package com.safexty.hooligan.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NotificationManager {

    private static boolean initialized = false;

    public static void initialize() {
        if (initialized)
            return;
        System.out.println("Firebase : Initialisation...");
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl("https://safexty-fire.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
            System.out.println("Firebase : Initialized...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendNotification(String title, String content) {
        // This registration token comes from the client FCM SDKs.
        String registrationToken = System.getenv("FIREBASE_TOKEN");
        // See documentation on defining a message payload.
        Message message = Message.builder()
                .setNotification(Notification.builder().setTitle(title).setBody(content).build())
                .setToken(registrationToken)
                .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        try {
            var response = FirebaseMessaging.getInstance().send(message);
            // Response is a message ID string.
            System.out.println("Successfully sent message: " + response);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }
}
