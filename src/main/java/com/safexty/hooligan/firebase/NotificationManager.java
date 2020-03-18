package com.safexty.hooligan.firebase;

import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import com.google.firebase.messaging.AndroidConfig.Priority;
import com.safexty.hooligan.utils.ConfigLoader;
import com.safexty.hooligan.utils.LoggerUtils;
import com.safexty.hooligan.utils.config.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.google.firebase.messaging.AndroidConfig.Priority.*;
import static com.safexty.hooligan.utils.ConfigLoader.getConfig;

public class NotificationManager {

    private static boolean initialized = false;
    private static List<String> registrationTokens;
    private static List<Message> messages = new ArrayList<>();

    public static void initialize() {
        if (initialized)
            return;
        LoggerUtils.info("Firebase : Initialisation...");
        try {
            var options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new FileInputStream(getConfig().firebase.credentials)))
                    .setDatabaseUrl(getConfig().firebase.databaseUrl)
                    .build();
            registrationTokens = getConfig().firebase.notificationTokens;
            FirebaseApp.initializeApp(options);
            initialized = true;
            LoggerUtils.info("Firebase : Initialized...");
        } catch (IOException e) {
            LoggerUtils.error("Firebase: Failed !");
            e.printStackTrace();
        }
    }

    public static void buildNotification(String title, String content) {
        if (!initialized) return;
        var notif = AndroidNotification.builder().setTitle(title).setBody(content).setVibrateTimingsInMillis(new long[]{1000, 1000, 1000, 1000, 1000}).build();
        registrationTokens.forEach(token -> messages.add(
                Message.builder()
                        .setAndroidConfig(
                                AndroidConfig.builder()
                                        .setPriority(HIGH)
                                        .setNotification(notif)
                                        .build())
                        .setToken(token)
                        .build()
        ));
    }

    public static void sendNotifications() {
        if (!initialized)
            return;
        LoggerUtils.info("Sending notifications...");
        if (messages.isEmpty()) {
            LoggerUtils.info("Nothing to send.");
            return;
        }
        var future = FirebaseMessaging.getInstance().sendAllAsync(messages);
        ApiFutures.addCallback(future, new ApiFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                LoggerUtils.warn("Failing to send notifications " + throwable.getMessage());
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(BatchResponse result) {
                LoggerUtils.info("Sent with " + result.getFailureCount() + "/" + result.getSuccessCount() + " failures.");
                messages.clear();
            }

        }, Executors.newSingleThreadExecutor());
    }
}
