package com.animaconnected.secondo.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.kronaby.watch.app.R;

/* loaded from: classes.dex */
public class NotificationHandler {
    private static final int ALARM_NOTIFICATION_ID = 17070399;
    private static final int POWER_NOTIFICATION_ID = 17070599;
    private static final int STEPS_GOAL_REACHED_NOTIFICATION_ID = 17070499;
    private static final int STILLNESS_MOVED_NOTIFICATION_ID = 17070299;
    private static final int STILLNESS_MOVE_NOTIFICATION_ID = 17070199;

    private NotificationHandler() {
    }

    public static void dismissAlarmNotification(Context context) {
        getNotificationManager(context).cancel(ALARM_NOTIFICATION_ID);
    }

    public static void dismissMoveNotification(Context context) {
        getNotificationManager(context).cancel(STILLNESS_MOVE_NOTIFICATION_ID);
    }

    private static void dismissMovedNotification(Context context) {
        getNotificationManager(context).cancel(STILLNESS_MOVED_NOTIFICATION_ID);
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    public static void showAlarmNotification(Context context, int r2) {
        showNotification(ALARM_NOTIFICATION_ID, context, context.getString(r2));
    }

    public static void showMoveNotification(Context context) {
        dismissMoveNotification(context);
        dismissMovedNotification(context);
        showNotification(STILLNESS_MOVE_NOTIFICATION_ID, context, context.getString(R.string.notification_start_moving));
    }

    public static void showMovedNotification(Context context) {
        dismissMoveNotification(context);
        dismissMovedNotification(context);
        showNotification(STILLNESS_MOVED_NOTIFICATION_ID, context, context.getString(R.string.notification_moving_done));
    }

    private static void showNotification(int r5, Context context, String str) {
        NotificationManager notificationManager = getNotificationManager(context);
        Intent createStartApplicationIntent = KronabyApplication.createStartApplicationIntent();
        createStartApplicationIntent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, createStartApplicationIntent, AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.notification_title));
        createNotificationBuilder.setContentText(str);
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setFlag(16, true);
        notificationManager.notify(r5, createNotificationBuilder.build());
    }

    public static void showPowerNotification(Context context) {
        NotificationManager notificationManager = getNotificationManager(context);
        Intent createStartApplicationIntent = KronabyApplication.createStartApplicationIntent();
        createStartApplicationIntent.putExtra(NotificationUtils.EXTRA_KEY_POWER_OPTIMIZATION, true);
        createStartApplicationIntent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, createStartApplicationIntent, AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.notification_title));
        createNotificationBuilder.setContentText(context.getString(R.string.battery_optimizations_notification));
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setFlag(16, true);
        ProviderFactory.getAppAnalytics().sendAction("PowerOptimizations");
        notificationManager.notify(POWER_NOTIFICATION_ID, createNotificationBuilder.build());
    }

    public static void showStepsGoalReachedNotification(Context context) {
        showNotification(STEPS_GOAL_REACHED_NOTIFICATION_ID, context, context.getString(R.string.notification_steps_goal_reached));
    }
}
