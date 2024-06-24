package com.animaconnected.secondo.behaviour.rememberthisspot.location;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.location.Spot;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class LocationFetcherView {
    private static final int LOCATION_FETCHER_NOTIFICATION_ID = 33033033;

    private LocationFetcherView() {
    }

    private static NotificationManager getNotificationManager() {
        return (NotificationManager) KronabyApplication.getContext().getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    public static void showLocationFetched(Spot spot) {
        Context context = KronabyApplication.getContext();
        NotificationManager notificationManager = getNotificationManager();
        PendingIntent activity = PendingIntent.getActivity(context, 0, LocationIntentCreator.createMapsIntent(spot), AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setDefaults(6);
        createNotificationBuilder.setContentTitle(context.getString(R.string.remember_this_spot_fetching_location_finished));
        createNotificationBuilder.setContentText(spot.addressLine);
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setProgress(0, 0, false);
        createNotificationBuilder.setFlag(16, true);
        createNotificationBuilder.addAction(R.drawable.ic_navigate, context.getString(R.string.navigate), activity);
        notificationManager.notify(LOCATION_FETCHER_NOTIFICATION_ID, createNotificationBuilder.build());
    }

    public static void showLocationFetchedFailed(boolean z, boolean z2) {
        String string;
        Context context = KronabyApplication.getContext();
        NotificationManager notificationManager = getNotificationManager();
        if (z) {
            string = context.getString(R.string.location_permissions_is_missing);
        } else if (z2) {
            string = context.getString(R.string.location_services_not_available);
        } else {
            string = context.getString(R.string.remember_this_spot_fetching_location_failed);
        }
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setDefaults(6);
        createNotificationBuilder.setContentTitle(context.getString(R.string.remember_this_spot_fetching_location_title));
        createNotificationBuilder.setContentText(string);
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setProgress(0, 0, false);
        createNotificationBuilder.setFlag(16, true);
        if (z2) {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.setFlags(268435456);
            createNotificationBuilder.mContentIntent = PendingIntent.getActivity(context, 0, intent, AppUtils.getPendingIntentFlag());
        }
        notificationManager.notify(LOCATION_FETCHER_NOTIFICATION_ID, createNotificationBuilder.build());
    }

    public static void showLocationFetching() {
        KronabyApplication.createStartApplicationIntent().setFlags(268435456);
        Context context = KronabyApplication.getContext();
        NotificationManager notificationManager = getNotificationManager();
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.remember_this_spot_fetching_location_title));
        createNotificationBuilder.setContentText(context.getString(R.string.remember_this_spot_fetching_location_progress_description));
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setProgress(0, 0, true);
        createNotificationBuilder.setFlag(16, false);
        notificationManager.notify(LOCATION_FETCHER_NOTIFICATION_ID, createNotificationBuilder.build());
    }
}
