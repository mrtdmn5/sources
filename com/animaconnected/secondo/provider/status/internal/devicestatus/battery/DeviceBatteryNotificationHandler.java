package com.animaconnected.secondo.provider.status.internal.devicestatus.battery;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DeviceBatteryNotificationHandler {
    private static final int BATTERY_NOTIFICATION_ID = 17070499;
    private static final long MIN_REPORT_TIME_INTERVAL_DAYS = 7;
    private static final long MIN_REPORT_TIME_INTERVAL_MS = 604800000;
    private static final String PREF_KEY_BATTERY_CRITICAL = "batteryCriticalNotification";
    private static final String PREF_KEY_BATTERY_LOW = "batteryLowNotification";
    private static final String PREF_NAME = "com.kronaby.watch.device.battery.notification";

    private DeviceBatteryNotificationHandler() {
    }

    public static void dismissNotifications(Context context) {
        getNotificationManager(context).cancel(BATTERY_NOTIFICATION_ID);
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    private static long getTimestamp(Context context, String str) {
        return context.getSharedPreferences(PREF_NAME, 0).getLong(str, 0L);
    }

    private static void setTimestamp(Context context, String str, long j) {
        context.getSharedPreferences(PREF_NAME, 0).edit().putLong(str, j).apply();
    }

    public static void showBatteryCriticalNotification(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - getTimestamp(context, PREF_KEY_BATTERY_CRITICAL) >= MIN_REPORT_TIME_INTERVAL_MS) {
            showNotification(context, context.getString(R.string.battery_critical_notification_title), context.getString(R.string.battery_critical_notification_description));
            setTimestamp(context, PREF_KEY_BATTERY_CRITICAL, currentTimeMillis);
        }
    }

    public static void showBatteryFullyChargedNotification(Context context) {
        showNotification(context, context.getString(R.string.watch_brand), context.getString(R.string.battery_fully_charged_notification_description));
    }

    public static void showBatteryLowNotification(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - getTimestamp(context, PREF_KEY_BATTERY_LOW) >= MIN_REPORT_TIME_INTERVAL_MS) {
            showNotification(context, context.getString(R.string.battery_low_notification_title), context.getString(R.string.battery_low_notification_description));
            setTimestamp(context, PREF_KEY_BATTERY_LOW, currentTimeMillis);
        }
    }

    private static void showNotification(Context context, String str, String str2) {
        NotificationManager notificationManager = getNotificationManager(context);
        Intent createStartApplicationIntent = KronabyApplication.createStartApplicationIntent();
        createStartApplicationIntent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, createStartApplicationIntent, AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(str);
        createNotificationBuilder.setContentText(str2);
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setFlag(16, true);
        createNotificationBuilder.mContentIntent = activity;
        notificationManager.notify(BATTERY_NOTIFICATION_ID, createNotificationBuilder.build());
    }
}
