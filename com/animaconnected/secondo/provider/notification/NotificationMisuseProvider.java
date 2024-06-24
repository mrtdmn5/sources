package com.animaconnected.secondo.provider.notification;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.firebase.config.AppNotificationsMisusedParams;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class NotificationMisuseProvider {
    private static final String INITIAL_MISUSE_STORAGE = "initialNotificationMisuseStorage";
    private static final String KEY_MISUSE_DAY_TIMESTAMP = "dayMisuseNotification";
    private static final String KEY_MISUSE_LAST_SENT_TIMESTAMP = "lastMisuseNotificationSent";
    private static final String KEY_MISUSE_NOTIFICATION_AMOUNT = "amountOfNotifications";
    private static final String KEY_MISUSE_NOTIFICATION_STREAK_AMOUNT = "streakInDays";
    private static final int MISUSE_NOTIFICATION_ID = 170800299;
    private static final long ONE_DAY_IN_MILLISECONDS = 86400000;

    @SuppressLint({"StaticFieldLeak"})
    private static NotificationMisuseProvider sInstance;
    private final Context mContext;

    private NotificationMisuseProvider(Context context) {
        this.mContext = context;
    }

    private int getCurrentNotificationAmount() {
        return getSharedPreferences(this.mContext).getInt(KEY_MISUSE_NOTIFICATION_AMOUNT, 0);
    }

    private long getDayTimeStamp() {
        return getSharedPreferences(this.mContext).getLong(KEY_MISUSE_DAY_TIMESTAMP, 0L);
    }

    public static NotificationMisuseProvider getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NotificationMisuseProvider(context);
        }
        return sInstance;
    }

    private long getLastSentTimeStamp() {
        return getSharedPreferences(this.mContext).getLong(KEY_MISUSE_LAST_SENT_TIMESTAMP, 0L);
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(INITIAL_MISUSE_STORAGE, 0);
    }

    private int getStreakAmount() {
        return getSharedPreferences(this.mContext).getInt(KEY_MISUSE_NOTIFICATION_STREAK_AMOUNT, 0);
    }

    private void setCurrentNotificationAmount(int r3) {
        getSharedPreferences(this.mContext).edit().putInt(KEY_MISUSE_NOTIFICATION_AMOUNT, r3).apply();
    }

    private void setDayTimeStamp(long j) {
        getSharedPreferences(this.mContext).edit().putLong(KEY_MISUSE_DAY_TIMESTAMP, j).apply();
    }

    private void setLastSentTimeStamp(long j) {
        getSharedPreferences(this.mContext).edit().putLong(KEY_MISUSE_LAST_SENT_TIMESTAMP, j).apply();
    }

    private void setStreakAmount(int r3) {
        getSharedPreferences(this.mContext).edit().putInt(KEY_MISUSE_NOTIFICATION_STREAK_AMOUNT, r3).apply();
    }

    private void showSystemNotification() {
        Context context = KronabyApplication.getContext();
        NotificationManager notificationManager = getNotificationManager(context);
        Intent createStartApplicationIntent = KronabyApplication.createStartApplicationIntent();
        createStartApplicationIntent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, createStartApplicationIntent, AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.notification_misused_title));
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.bigText(context.getString(R.string.notification_misused_description));
        createNotificationBuilder.setStyle(notificationCompat$BigTextStyle);
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setFlag(16, true);
        notificationManager.notify(MISUSE_NOTIFICATION_ID, createNotificationBuilder.build());
    }

    public void calculateNotification() {
        long dayTimeStamp = getDayTimeStamp();
        long currentTimeMillis = System.currentTimeMillis();
        int currentNotificationAmount = getCurrentNotificationAmount() + 1;
        setCurrentNotificationAmount(currentNotificationAmount);
        if (currentTimeMillis - dayTimeStamp >= ONE_DAY_IN_MILLISECONDS) {
            AppNotificationsMisusedParams appNotificationsMisusedParams = RemoteConfigController.getInstance(this.mContext).getAppNotificationsMisusedParams();
            if (currentNotificationAmount >= appNotificationsMisusedParams.getNotificationsToReach()) {
                int streakAmount = getStreakAmount() + 1;
                setStreakAmount(streakAmount);
                if (streakAmount >= appNotificationsMisusedParams.getStreakInDays() && currentTimeMillis - getLastSentTimeStamp() >= appNotificationsMisusedParams.getAlertDelayInDays() * ONE_DAY_IN_MILLISECONDS) {
                    ProviderFactory.getAppAnalytics().sendAction("show_notifications_misuse");
                    showSystemNotification();
                    setLastSentTimeStamp(currentTimeMillis);
                }
            } else {
                setStreakAmount(0);
            }
            setCurrentNotificationAmount(0);
            setDayTimeStamp(currentTimeMillis);
        }
    }
}
