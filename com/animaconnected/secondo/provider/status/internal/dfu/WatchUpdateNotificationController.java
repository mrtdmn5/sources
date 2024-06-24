package com.animaconnected.secondo.provider.status.internal.dfu;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.kronaby.watch.app.R;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class WatchUpdateNotificationController {
    private static final int DELAY_BETWEEN_NOTIFICATIONS = 259200000;
    private static final int WATCH_UPDATE_NOTIFICATION_ID = 12070415;
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    private final WatchUpdateNotificationStorage mStorage;

    /* loaded from: classes3.dex */
    public static class WatchUpdateNotificationStorage {
        private static final String NOTIFICATION_LAST_SHOWN_VOLUME = "lastShown";
        private static final String WATCH_UPDATE_NOTIFICATION_STORAGE = "watchUpdateNotificationStorage";
        private final Context mContext;

        public WatchUpdateNotificationStorage(Context context) {
            this.mContext = context;
        }

        private SharedPreferences getSharedPreferences() {
            return this.mContext.getSharedPreferences(WATCH_UPDATE_NOTIFICATION_STORAGE, 0);
        }

        public long getLastShown() {
            return getSharedPreferences().getLong(NOTIFICATION_LAST_SHOWN_VOLUME, 0L);
        }

        public void setLastShown(long j) {
            getSharedPreferences().edit().putLong(NOTIFICATION_LAST_SHOWN_VOLUME, j).apply();
        }
    }

    public WatchUpdateNotificationController(Context context) {
        this.mNotificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        this.mStorage = new WatchUpdateNotificationStorage(context);
        this.mContext = context;
    }

    public void clear() {
        this.mStorage.setLastShown(0L);
    }

    public void createUpdateAvailableNotification(boolean z) {
        int r1;
        int r2;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.mStorage.getLastShown() < 259200000) {
            return;
        }
        this.mStorage.setLastShown(timeInMillis);
        Intent createStartApplicationIntent = KronabyApplication.createStartApplicationIntent();
        createStartApplicationIntent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, createStartApplicationIntent, AppUtils.getPendingIntentFlag());
        if (z) {
            r1 = R.string.notification_watch_update_required_title;
        } else {
            r1 = R.string.notification_watch_update_available_title;
        }
        if (z) {
            r2 = R.string.notification_watch_update_required_description;
        } else {
            r2 = R.string.notification_watch_update_available_description;
        }
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(this.mContext, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(this.mContext.getString(r1));
        createNotificationBuilder.setContentText(this.mContext.getString(r2));
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setFlag(16, !z);
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.notify(WATCH_UPDATE_NOTIFICATION_ID, createNotificationBuilder.build());
        }
    }

    public void dismissUpdateAvailableNotification() {
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(WATCH_UPDATE_NOTIFICATION_ID);
        }
    }
}
