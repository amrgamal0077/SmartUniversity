package com.example.momen.smart_university.firebase.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.momen.smart_university.Activites.Student_Profile;
import com.example.momen.smart_university.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by Momen on 6/9/2019.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String,String> data = remoteMessage.getData();
        sendNotification(data);
    }

    private void sendNotification(Map<String, String> data) {
        Intent intent = new Intent(this, Student_Profile.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Create the pending intent to launch the activity
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String doctor = data.get("title");
        String message = data.get("message");

        // If the message is longer than the max number of characters we want in our
        // notification, truncate it and add the unicode character for ellipsis
        if (message.length() > 30) {
            message = message.substring(0, 30) + "\u2026";
        }

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.book)
                .setContentTitle(doctor)
                .setContentText(message)
                .setAutoCancel(true)

                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
