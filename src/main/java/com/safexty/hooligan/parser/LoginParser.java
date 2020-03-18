package com.safexty.hooligan.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class LoginParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final String theJson;
    private boolean connected = false;
    private String fullName;
    private int registrationNumber = 0;
    private String rank;
    private int centerNumber = 0;
    private String centerName;
    private boolean failed = false;

    public LoginParser(String theJson) {
        this.theJson = theJson;
        parseJson();
    }

    private void parseJson() {
        try {
            var rootNode = mapper.readTree(theJson).get("connexion");
            // Error in answer
            if (rootNode == null) {
                failed = true;
                return;
            }
            connected = rootNode.get("connexionAutorisee").asBoolean(false);
            if (isConnected()) {
                fullName = rootNode.get("nomPersonnelConnecte").asText(null);
                registrationNumber = rootNode.get("matriculePersonnelConnecte").asInt(0);

                var profilsRoot = rootNode.get("lesProfilsAutorises");
                if (profilsRoot.isArray())
                    for (final JsonNode objNode : profilsRoot) {
                        rank = objNode.get("grade").asText(null);
                        var centerRoot = objNode.get("centre");
                        centerNumber = centerRoot.get("numeroCentre").asInt(0);
                        centerName = centerRoot.get("nomCentre").asText(null);
                    }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public boolean hasFailed() {
        return failed;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getCenterNumber() {
        return centerNumber;
    }

    public void setCenterNumber(int centerNumber) {
        this.centerNumber = centerNumber;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
}
