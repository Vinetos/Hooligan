package com.safexty.hooligan;

import com.safexty.hooligan.firebase.NotificationManager;
import com.safexty.hooligan.network.NetworkManager;
import com.safexty.hooligan.network.messages.out.LoginMessage;
import com.safexty.hooligan.network.messages.out.ReseachSynopticMessage;
import com.safexty.hooligan.network.objects.out.LoginObject;
import com.safexty.hooligan.network.objects.out.ResearchSynopticObject;
import com.safexty.hooligan.parser.LoginParser;
import com.safexty.hooligan.parser.SynopticParser;
import com.safexty.hooligan.utils.ConfigLoader;
import com.safexty.hooligan.utils.LoggerUtils;
import com.safexty.hooligan.utils.ObjectTranslator;
import com.safexty.hooligan.utils.config.Config;
import flex.messaging.io.amf.ASObject;

public class Hooligan {

    private static boolean logged = false;
    private static int centerNumber = -1;

    public static void main(String[] args) {
        LoggerUtils.info("Welcome to Hooligan !");
        ConfigLoader.initialize();
        NotificationManager.initialize();
        while (true) {
            long start = System.currentTimeMillis();
            if (!logged) {
                LoggerUtils.info("Logging in...");
                // Login Request
                var loginmsg = new LoginMessage(new LoginObject(ConfigLoader.getConfig().user, ConfigLoader.getConfig().password)).getRawMessage();
                // Send the request and parse the answer from the server.
                var parser = new LoginParser(ObjectTranslator.toJson((ASObject) NetworkManager.request(loginmsg).getBody()));
                if (!parser.isConnected()) {
                    LoggerUtils.error("Failed to connect ! Exiting.");
                    System.exit(1);
                }
                centerNumber = parser.getCenterNumber();
                LoggerUtils.info("Connected as " + parser.getRank() + " " + parser.getFullName() + " (" + parser.getRegistrationNumber() + ")");
                logged = true;
            }

            LoggerUtils.info("Requesting synoptic...");
            var msg = new ReseachSynopticMessage(new ResearchSynopticObject(centerNumber)).getRawMessage();
            var answer = NetworkManager.request(msg);

            if (answer == null) {
                LoggerUtils.error("Failed ! Resetting.");
                logged = false;
                continue;
            }
            var body = (ASObject) answer.getBody();
            SynopticParser.parseJson(ObjectTranslator.toJson(body));
            LoggerUtils.info("Sleeping...");
            // Avoid spamming
            long cooldown = 10000 - (System.currentTimeMillis() - start);
            if (cooldown > 0) {
                try {
                    Thread.sleep(cooldown);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
