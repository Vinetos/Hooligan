package com.safexty.hooligan.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safexty.hooligan.User;
import org.apache.bcel.generic.PUSH;

import java.util.ArrayList;
import java.util.List;

public class MembersParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final String theJson;

    public MembersParser(String theJson) {
        this.theJson = theJson;
        parseJson();
    }

    private void parseJson() {
        try {
            var rootNode = mapper.readTree(theJson).get("lesPersonnels");
            if (rootNode.isArray())
                for (final JsonNode objNode : rootNode) {
                    new User(
                            objNode.get("prenom").asText(""),
                            objNode.get("nom").asText(""),
                            objNode.get("etat").get("codeEtat").asText("")
                    );
                }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
