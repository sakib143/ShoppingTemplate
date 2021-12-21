package com.innomalist.taxi.shoppingapp.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import com.apptube.ecommerce.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.activity.OrdersTrackingActivity;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "PUSH";
    private static final String TEXT_CUSTOMER = "Customer";
    private static int count;

    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (BaseApplication.getAppRepository().isLoggedIn()) {
            Log.d(TAG, "From: " + remoteMessage.getFrom());
            Log.d(TAG, "Message Notification Data: " + remoteMessage.getData().toString());
            try {
                sendNotification(remoteMessage.getData().get("title"), remoteMessage.getData().get("body"), remoteMessage.getData().get("orderId"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onNewToken(String str) {
        Log.d(TAG, "Refreshed token: " + str);
    }

    private void sendNotification(String str, String str2, String str3) {
        Intent intent = new Intent(getApplicationContext(), OrdersTrackingActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("OrderId", str3);
        intent.putExtra("class", TAG);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, BasicMeasure.EXACTLY);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        notificationManager.cancelAll();
        String string = ResourceUtils.getString(R.string.default_notification_channel_id);
        String string2 = ResourceUtils.getString(R.string.default_notification_channel_name);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, TEXT_CUSTOMER);
        builder.setContentTitle(str).setContentText(str2).setSmallIcon(R.drawable.ic_notification).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_notification)).setAutoCancel(true).setSound(defaultUri).setContentIntent(activity).setVibrate(new long[]{250, 500, 250, 500, 250}).addAction(R.drawable.ic_map_marker, ResourceUtils.getString(R.string.track), activity).setChannelId(string).setPriority(2);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioAttributes build = new AudioAttributes.Builder().setUsage(5).build();
            NotificationChannel notificationChannel = new NotificationChannel(string, string2, 4);
            notificationChannel.setDescription(str2);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setVibrationPattern(new long[]{250, 500, 250, 500, 250});
            notificationChannel.setSound(defaultUri, build);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        builder.getNotification().flags |= 16;
        notificationManager.notify(count, builder.build());
        count++;
    }
}
