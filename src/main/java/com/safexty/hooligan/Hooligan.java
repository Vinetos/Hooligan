package com.safexty.hooligan;

import com.safexty.hooligan.firebase.NotificationManager;
import com.safexty.hooligan.network.messages.out.LoginMessage;
import com.safexty.hooligan.network.messages.out.ResearchMembers;
import com.safexty.hooligan.network.messages.out.ReseachSynopticMessage;
import com.safexty.hooligan.network.objects.out.LoginObject;
import com.safexty.hooligan.network.objects.out.ResearchMembersObject;
import com.safexty.hooligan.network.objects.out.ResearchSynopticObject;
import com.safexty.hooligan.parser.LoginParser;
import com.safexty.hooligan.parser.MembersParser;
import com.safexty.hooligan.utils.ObjectTranslator;
import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.client.AMFConnection;
import flex.messaging.io.amf.client.exceptions.ClientStatusException;
import flex.messaging.io.amf.client.exceptions.ServerStatusException;
import flex.messaging.messages.AcknowledgeMessage;

import java.util.Arrays;

import static com.safexty.hooligan.Command.*;

public class Hooligan {

    public static final String GATEWAY_URL = "http://web-alerte.sdis38.fr:18080/systel-alerte-web/gateway";

    public static void main(String[] args) {
        System.out.println("Starting...");
        if (args.length < 1)
            error("No enough args given");

        //NotificationManager.initialize();
        //NotificationManager.sendNotification("titre", "pas titre");

        Command command = Command.getCommandFromString(args[0]);
        args = Arrays.copyOfRange(args, 1, args.length); //Extract command from array
        AMFConnection amfConnection = new AMFConnection();
        boolean error = false;
        try {
            amfConnection.connect(GATEWAY_URL);

            if (args.length < command.getArgumentsCount())
                error("Missing argument (one or more): " + String.join(",", command.getArguments()));

            if (command == LOGIN) {
                var loginObject = new LoginObject(args[0], args[1]);
                var msg = new LoginMessage(loginObject).getRawMessage();

                // Send the request and parse the answer from the server.
                var answer = (AcknowledgeMessage) amfConnection.call("null", msg);
                var body = (ASObject) answer.getBody();
                LoginParser loginParser = new LoginParser(ObjectTranslator.toJson(body));
                System.out.println(loginParser.isConnected());
                System.out.println(loginParser.getRegistrationNumber());
                System.out.println(loginParser.getFullName());
                System.out.println(loginParser.getRank());
                System.out.println(loginParser.getCenterName());
                System.out.println(loginParser.getCenterNumber());
            } else if (command == MEMBERS_RESEARCH) {

                //var loginmsg = new LoginMessage(new LoginObject("vchassignol", "4o062")).getRawMessage();
                var msg = new ResearchMembers(new ResearchMembersObject(Integer.parseInt(args[0]))).getRawMessage();

                // Send the request and parse the answer from the server.
                //amfConnection.call("null", loginmsg);
                var answer = (AcknowledgeMessage) amfConnection.call("null", msg);
                var body = (ASObject) answer.getBody();
                MembersParser membersParser = new MembersParser(ObjectTranslator.toJson(body));
                System.out.println(ObjectTranslator.toJson(body));
            } else if (command == SYNOPTIC_RESEARCH) {
                //var loginmsg = new LoginMessage(new LoginObject("vchassignol", "4o062")).getRawMessage();
                var msg = new ReseachSynopticMessage(new ResearchSynopticObject(Integer.parseInt(args[0]))).getRawMessage();

                // Send the request and parse the answer from the server.
                //amfConnection.call("null", loginmsg);
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
