package com.animaconnected.secondo.behaviour.distress.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.screens.MainActivity;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;

/* loaded from: classes3.dex */
public class StateNotificationHandler {
    private static final int NOTIFICATION_ID = 99882233;
    public static final int REQUEST_CODE = 3216547;

    public static void cancel(Context context) {
        getNotificationManager(context).cancel(NOTIFICATION_ID);
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    public static void pushNotification(Context context, String str, String str2) {
        pushNotification(context, str, str2, true);
    }

    public static void pushNotification(Context context, String str, String str2, boolean z) {
        NotificationManager notificationManager = getNotificationManager(context);
        PendingIntent activity = PendingIntent.getActivity(context, REQUEST_CODE, new Intent(context.getApplicationContext(), (Class<?>) MainActivity.class), 1073741824 | AppUtils.getPendingIntentFlag());
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setFlag(16, false);
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setContentTitle(str);
        createNotificationBuilder.setFlag(2, z);
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setSound(defaultUri);
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.bigText(str2);
        createNotificationBuilder.setStyle(notificationCompat$BigTextStyle);
        notificationManager.notify(NOTIFICATION_ID, createNotificationBuilder.build());
    }
}
