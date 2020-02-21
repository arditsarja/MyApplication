package com.mydomain.myapplication;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public MyFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        try {
            showNotification(remoteMessage.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showNotification(Map<String, String> data) throws Exception {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String message = data.get("message") != null ? data.get("message") : "Message";
        String title = data.get("title") != null ? data.get("title") : "Title";
        String bigTxt = data.get("bigtex") != null ? data.get("bigtex") : "Big Text";

        Bundle bundle = new Bundle();
        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, MainActivity.class);
        bundle.putString("tekst", message);
        bundle.putString("titull", title);
        bundle.putString("bigtex", bigTxt);
        resultIntent.putExtras(bundle);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        String notification_channel_id = "test";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(notification_channel_id, "Leksion", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("TestNotification");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.GREEN);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);

        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, notification_channel_id);
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        notificationBuilder.setContentTitle(title);
        notificationBuilder.setContentText(message);
        notificationBuilder.setContentInfo("Info");
        notificationBuilder.setWhen(System.currentTimeMillis());
        notificationBuilder.setSmallIcon(R.drawable.image);
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.image));
        notificationBuilder.setBadgeIconType(R.drawable.image);
        notificationBuilder.setContentIntent(resultPendingIntent);
        notificationManager.notify(new Random().nextInt(), notificationBuilder.build());


    }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d(TAG, "New token: " + s);
    }
}
