package com.safexty.hooligan.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safexty.hooligan.AlertedTruck;
import com.safexty.hooligan.User;
import com.safexty.hooligan.firebase.NotificationManager;
import com.safexty.hooligan.utils.LoggerUtils;

import java.io.Console;
import java.util.Optional;

public class SynopticParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void parseJson(String theJson) {
        try {
            LoggerUtils.info("Ok ! Parsing answer...");
            var tree = mapper.readTree(theJson);
            System.out.println(theJson);
            var rootNode = tree.get("lesPersonnels");
            if (rootNode == null)
                return;
            if (rootNode.isArray()) {
                if (rootNode.isEmpty())
                    return;

                for (final JsonNode objNode : rootNode) {
                    var name = objNode.get("nom").asText("");
                    var firstName = objNode.get("prenom").asText("");
                    var etat = objNode.get("etat").get("codeEtat").asText("Vide");
                    if (etat.equals("DISPO"))
                        etat = objNode.get("currentEtatPlanning").get("libelleEtat").asText("Vide");
                    Optional<User> user = User.findByName(name, firstName);
                    if (user.isEmpty())
                        new User(
                                firstName,
                                name,
                                etat
                        );
                    else
                        user.get().setDispoCode(etat);
                }
            }

            rootNode = tree.get("lesMaterielEngages");
            if (rootNode == null || rootNode.isArray() && rootNode.isEmpty())
                AlertedTruck.alertedTrucks.clear();
            else
                for (final JsonNode objNode : rootNode) {
                    var fonctionEngin = objNode.get("fonctionEnginEngagee").asText("");
                    var engin = objNode.get("engin");
                    var enginName = engin.get("libelleEngin").asText("");
                    var etatEngin = engin.get("etatEngin").get("nomEtat").asText("Vide");
                    var truck = AlertedTruck.findByName(enginName);
                    if (truck.isEmpty())
                        new AlertedTruck(enginName, fonctionEngin, etatEngin);
                    else
                        truck.get().setEtat(etatEngin);
                }

            LoggerUtils.info("Done ! Updating users and trucks...");
            User.users.forEach(User::update);
            AlertedTruck.alertedTrucks.forEach(AlertedTruck::update);
            NotificationManager.sendNotifications();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
