package com.safexty.hooligan;

import com.safexty.hooligan.network.messages.out.LoginMessage;
import com.safexty.hooligan.network.objects.out.LoginObject;
import com.safexty.hooligan.utils.ObjectTranslator;
import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.client.AMFConnection;
import flex.messaging.io.amf.client.exceptions.ClientStatusException;
import flex.messaging.io.amf.client.exceptions.ServerStatusException;
import flex.messaging.messages.AcknowledgeMessage;

import java.util.Arrays;

import static com.safexty.hooligan.Command.LOGIN;

public class Hooligan {

    public static final String GATEWAY_URL = "http://web-alerte.sdis38.fr:18080/systel-alerte-web/gateway";

    public static void main(String[] args) {
        if (args.length < 1)
            error("No enough args given");

        Command command = Command.getCommandFromString(args[0]);
        args = Arrays.copyOfRange(args, 1, args.length); //Extract command from array
        AMFConnection amfConnection = new AMFConnection();
        boolean error = false;
        try {
            amfConnection.connect(GATEWAY_URL);
            amfConnection.addHttpRequestHeader("Content-type", "application/x-amf");
            if (command == LOGIN) {
                if (args.length < 2)
                    error("Username or password missing");

                var loginObject = new LoginObject(args[0], args[1]);
                var msg = new LoginMessage(loginObject).getRawMessage();

                // Send the request and parse the answer from the server.
                var answer = (AcknowledgeMessage) amfConnection.call("null", msg);
                var body = (ASObject) answer.getBody();
                System.out.println(ObjectTranslator.toJson(body));
            }

        } catch (ClientStatusException | ServerStatusException e) {
            e.printStackTrace();
            error = true;
        } finally {
            amfConnection.close();
            if (error)
                error("Client or server got an error.");
        }
    }

    private static void error(String str) {
        System.err.print("{\"error\":\"" + str + "\"}");
        System.exit(1);
    }

}
