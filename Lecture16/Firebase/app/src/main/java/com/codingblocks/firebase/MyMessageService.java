package com.codingblocks.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by arnav on 10/15/2017.
 */

public class MyMessageService extends FirebaseMessagingService {
    public static final String TAG = "FM";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived: msg id" + remoteMessage.getMessageId());
        Log.d(TAG, "onMessageReceived: msg time" + remoteMessage.getSentTime());
        Log.d(TAG, "onMessageReceived: msg data" + remoteMessage.getData().toString());
        Log.d(TAG, "onMessageReceived: msg body" + remoteMessage.getNotification().getBody());
        Log.d(TAG, "onMessageReceived: msg title" + remoteMessage.getNotification().getTitle());

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notif = new Notification.Builder(this)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setContentIntent(PendingIntent.getActivity(
                        this,
                        232,
                        new Intent(this, MainActivity.class),
                        PendingIntent.FLAG_ONE_SHOT
                ))
                .setColor(Color.CYAN)
                .build();
        nm.notify(111, notif);

        super.onMessageReceived(remoteMessage);
    }
}
