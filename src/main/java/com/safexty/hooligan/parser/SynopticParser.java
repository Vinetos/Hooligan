package com.safexty.hooligan.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safexty.hooligan.User;
import com.safexty.hooligan.firebase.NotificationManager;
import com.safexty.hooligan.utils.LoggerUtils;

import java.util.Optional;

public class SynopticParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void parseJson(String theJson) {
        try {
            LoggerUtils.info("Ok ! Parsing answer...");
            var rootNode = mapper.readTree(theJson).get("lesPersonnels");
            if (rootNode == null)
                return;
            if (rootNode.isArray()) {
                if (rootNode.isEmpty())
                    return;

                for (final JsonNode objNode : rootNode) {
                    var name = objNode.get("nom").asText("");
                    var firstName = objNode.get("prenom").asText("");
                    var etat = objNode.get("currentEtatPlanning").get("libelleEtat").asText("Vide");
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
            LoggerUtils.info("Done ! Updating users...");
            User.users.forEach(User::update);
            NotificationManager.sendNotifications();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
