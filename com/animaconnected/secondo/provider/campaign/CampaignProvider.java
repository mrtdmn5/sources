package com.animaconnected.secondo.provider.campaign;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignProvider.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class CampaignProvider implements RemoteConfigController.RemoteConfigControllerListener {
    public static final int $stable;
    private static final String CAMPAIGN_STORAGE = "campaignStorage";
    public static final CampaignProvider INSTANCE = new CampaignProvider();
    private static final String KEY_INTERESTED = "notInterested";
    private static final String KEY_NOTIFICATION_SHOWED = "notificationShowed";
    public static final String PROMOTION_ID = "tidal";
    private static final Context context;
    private static final RemoteConfigController remoteController;
    private static final CampaignStorage storage;

    /* compiled from: CampaignProvider.kt */
    /* loaded from: classes3.dex */
    public static final class CampaignStorage {
        public final SharedPreferences getSharedPreferences() {
            SharedPreferences sharedPreferences = CampaignProvider.context.getSharedPreferences(CampaignProvider.CAMPAIGN_STORAGE, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return sharedPreferences;
        }

        public final boolean hasNotificationBeenShown() {
            return getSharedPreferences().getBoolean(CampaignProvider.KEY_NOTIFICATION_SHOWED, false);
        }

        public final boolean isInterested(String promotionId) {
            Intrinsics.checkNotNullParameter(promotionId, "promotionId");
            return getSharedPreferences().getBoolean("notInterested:".concat(promotionId), true);
        }

        public final void setNotInterested(String promotionId) {
            Intrinsics.checkNotNullParameter(promotionId, "promotionId");
            getSharedPreferences().edit().putBoolean("notInterested:".concat(promotionId), false).apply();
        }

        public final void setNotificationShown(boolean z) {
            PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(), CampaignProvider.KEY_NOTIFICATION_SHOWED, z);
        }
    }

    static {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        context = companion.getContext();
        storage = new CampaignStorage();
        remoteController = RemoteConfigController.Companion.getInstance(companion.getContext());
        $stable = 8;
    }

    private CampaignProvider() {
    }

    private final boolean showNotification() {
        NotificationManager notificationManager;
        Context context2 = context;
        Object systemService = context2.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        if (systemService instanceof NotificationManager) {
            notificationManager = (NotificationManager) systemService;
        } else {
            notificationManager = null;
        }
        if (notificationManager == null) {
            return false;
        }
        PendingIntent activity = PendingIntent.getActivity(context2, 0, KronabyApplication.Companion.createStartApplicationIntent(), AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context2, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context2.getString(R.string.tidal_header));
        createNotificationBuilder.setContentText(context2.getString(R.string.tidal_notification));
        createNotificationBuilder.mNotification.icon = R.drawable.ic_notification;
        Object obj = ContextCompat.sLock;
        createNotificationBuilder.mColor = ContextCompat.Api23Impl.getColor(context2, R.color.notificationColor);
        createNotificationBuilder.setFlag(16, true);
        createNotificationBuilder.mContentIntent = activity;
        notificationManager.notify(0, createNotificationBuilder.build());
        ProviderFactory.getAppAnalytics().giftNotificationShown();
        return true;
    }

    public final boolean isCampaignEnabled(String promotionId) {
        Intrinsics.checkNotNullParameter(promotionId, "promotionId");
        if (remoteController.isCampaignEnabled() && storage.isInterested(promotionId)) {
            return true;
        }
        return false;
    }

    public final boolean isInterested() {
        return storage.isInterested(PROMOTION_ID);
    }

    @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
    public void onFetch() {
        showNotificationIfNotShown();
    }

    @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
    public void onFetchFailed(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    public final void setNotInterested(String promotionId) {
        Intrinsics.checkNotNullParameter(promotionId, "promotionId");
        storage.setNotInterested(promotionId);
    }

    public final void showNotificationIfNotShown() {
        if (isCampaignEnabled(PROMOTION_ID)) {
            CampaignStorage campaignStorage = storage;
            if (!campaignStorage.hasNotificationBeenShown()) {
                campaignStorage.setNotificationShown(showNotification());
            }
        }
    }
}
