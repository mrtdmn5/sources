package com.animaconnected.secondo.app;

import android.annotation.SuppressLint;
import android.content.Context;
import com.animaconnected.firebase.RemoteConfig;
import com.animaconnected.firebase.RemoteConfigConstants;
import com.animaconnected.firebase.RemoteConfigListener;
import com.animaconnected.firebase.config.AppConfigAWSParams;
import com.animaconnected.firebase.config.AppFeatureGetMovingParams;
import com.animaconnected.firebase.config.AppNotificationsMisusedParams;
import com.animaconnected.firebase.config.ImportantAppsConfig;
import com.animaconnected.firebase.config.LePingReqParams;
import com.animaconnected.firebase.config.StatusDiagEnabledParams;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.google.gson.reflect.TypeToken;
import com.kronaby.watch.app.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteConfigController.kt */
/* loaded from: classes.dex */
public final class RemoteConfigController extends BaseWatchProviderListener implements RemoteConfigListener {

    @SuppressLint({"StaticFieldLeak"})
    private static RemoteConfigController sInstance;
    private final Context context;
    private final Set<RemoteConfigControllerListener> listeners;
    private final RemoteConfig remoteConfig;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: RemoteConfigController.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RemoteConfigController getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            RemoteConfigController remoteConfigController = RemoteConfigController.sInstance;
            if (remoteConfigController == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                RemoteConfigController remoteConfigController2 = new RemoteConfigController(applicationContext, null);
                RemoteConfigController.sInstance = remoteConfigController2;
                return remoteConfigController2;
            }
            return remoteConfigController;
        }

        private Companion() {
        }
    }

    /* compiled from: RemoteConfigController.kt */
    /* loaded from: classes.dex */
    public interface RemoteConfigControllerListener {
        void onFetch();

        void onFetchFailed(String str);
    }

    public /* synthetic */ RemoteConfigController(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final RemoteConfigController getInstance(Context context) {
        return Companion.getInstance(context);
    }

    private final void updateCacheExpirationTime() {
        this.remoteConfig.setCacheExpirationTime(this.remoteConfig.getLong(RemoteConfigConstants.APP_CONFIG_REMOTE_CONFIG_CACHE_EXPIRATION));
    }

    public final void fetch() {
        this.remoteConfig.fetch();
    }

    public final Map<String, String> getAll() {
        List<String> allKeys = this.remoteConfig.getAllKeys(this.context);
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(allKeys, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Object obj : allKeys) {
            linkedHashMap.put(obj, this.remoteConfig.getString((String) obj));
        }
        return linkedHashMap;
    }

    public final boolean getAnalyticsCollectionEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_CONFIG_ANALYTICS_COLLECTION_ENABLE);
    }

    public final boolean getAppBrickEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_BRICK_ENABLE);
    }

    public final AppConfigAWSParams getAppConfigAwsParams() {
        AppConfigAWSParams appConfigAWSParams = (AppConfigAWSParams) this.remoteConfig.getObject(RemoteConfigConstants.APP_CONFIG_AWS_PARAMS, AppConfigAWSParams.class);
        if (appConfigAWSParams == null) {
            return new AppConfigAWSParams();
        }
        return appConfigAWSParams;
    }

    public final long getAppConfigUpdateCheckIntervalHours() {
        return this.remoteConfig.getLong(RemoteConfigConstants.APP_CONFIG_UPDATE_CHECK_INTERVAL_HOURS);
    }

    public final boolean getAppDebugMenuEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_DEBUG_MENU_ENABLE);
    }

    public final boolean getAppLostWatchEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_LOST_WATCH_ENABLE);
    }

    public final AppFeatureGetMovingParams getAppMovingParams() {
        return (AppFeatureGetMovingParams) this.remoteConfig.getObject(RemoteConfigConstants.APP_FEATURE_GET_MOVING_PARAMS, AppFeatureGetMovingParams.class);
    }

    public final AppNotificationsMisusedParams getAppNotificationsMisusedParams() {
        return (AppNotificationsMisusedParams) this.remoteConfig.getObject(RemoteConfigConstants.APP_FEATURE_NOTIFICATIONS_MISUSED_PARAMS, AppNotificationsMisusedParams.class);
    }

    public final boolean getAppStrongVibrationEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_STRONG_VIBRATION_ENABLE);
    }

    public final boolean getAppToolBarBackButtonEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_TOOLBAR_BACK_BUTTON_ENABLE);
    }

    public final boolean getCrashNotificationEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_ENABLE_CRASH_NOTIFICATION);
    }

    public final String getCustomSupportMail() {
        return this.remoteConfig.getString(RemoteConfigConstants.APP_SETTINGS_CUSTOM_SUPPORT_EMAIL);
    }

    public final String getCustomerSupportUrl() {
        return this.remoteConfig.getString(RemoteConfigConstants.CUSTOMER_SUPPORT_API_URL);
    }

    public final String getCustomerSupportWebCode() {
        return this.remoteConfig.getString(RemoteConfigConstants.CUSTOMER_SUPPORT_API_WEBCODE);
    }

    public final boolean getDebuggingEnabled() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_DEBUGGING_ENABLE);
    }

    public final Map<String, Integer> getDeviceConfigSettings() {
        Map<String, Integer> map = (Map) this.remoteConfig.getObject(RemoteConfigConstants.DEVICE_CONFIG_SETTINGS, new TypeToken<HashMap<String, Integer>>() { // from class: com.animaconnected.secondo.app.RemoteConfigController$deviceConfigSettings$1
        }.getType());
        if (map == null) {
            return EmptyMap.INSTANCE;
        }
        return map;
    }

    public final boolean getDeviceDebugDisconnectEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.DEVICE_DEBUG_DISCONNECT_ENABLE);
    }

    public final boolean getDeviceDisconnectLedAndVibrateEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.DEVICE_DISCONNECT_LED_AND_VIBRATION_ENABLE);
    }

    public final String[] getDisabledBehaviours() {
        return this.remoteConfig.getList(RemoteConfigConstants.APP_LIST_BEHAVIOURS_DISABLE);
    }

    public final String[] getDisabledEvents() {
        return this.remoteConfig.getList(RemoteConfigConstants.APP_LIST_ANALYTICS_EVENTS_DISABLE);
    }

    public final String getElevationApiKey() {
        return this.remoteConfig.getString(RemoteConfigConstants.ELEVATION_API_KEY);
    }

    public final boolean getFastModeEnable() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_FASTMODE_ENABLE);
    }

    public final ImportantAppsConfig getImportantAppConfig() {
        ImportantAppsConfig importantAppsConfig = (ImportantAppsConfig) this.remoteConfig.getObject(RemoteConfigConstants.APP_IMPORTANT_APPS_CONFIG, ImportantAppsConfig.class);
        if (importantAppsConfig == null) {
            return new ImportantAppsConfig();
        }
        return importantAppsConfig;
    }

    public final LePingReqParams getLePingReqParams() {
        LePingReqParams lePingReqParams = (LePingReqParams) this.remoteConfig.getObject(RemoteConfigConstants.APP_FEATURE_LE_PING_REQ_MODELS, LePingReqParams.class);
        if (lePingReqParams == null) {
            return new LePingReqParams();
        }
        return lePingReqParams;
    }

    public final boolean getSpeedCalibrationEnabled() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_SPEED_CALIBRATION_ENABLED);
    }

    public final StatusDiagEnabledParams getStatusDiagPagingRequired() {
        StatusDiagEnabledParams statusDiagEnabledParams = (StatusDiagEnabledParams) this.remoteConfig.getObject(RemoteConfigConstants.APP_FEATURE_STATUS_DIAG_PAGING_REQUIRED, StatusDiagEnabledParams.class);
        if (statusDiagEnabledParams == null) {
            return new StatusDiagEnabledParams(false, false, 3, null);
        }
        return statusDiagEnabledParams;
    }

    public final String getStravaClientId() {
        return this.remoteConfig.getString(RemoteConfigConstants.STRAVA_CLIENT_ID);
    }

    public final String getStravaClientSecret() {
        return this.remoteConfig.getString(RemoteConfigConstants.STRAVA_CLIENT_SECRET);
    }

    public final String getType() {
        return this.remoteConfig.getString(RemoteConfigConstants.CONFIG_TYPE);
    }

    public final long getVersion() {
        return this.remoteConfig.getLong(RemoteConfigConstants.CONFIG_VERSION);
    }

    public final String getWeatherApiKey() {
        return this.remoteConfig.getString(RemoteConfigConstants.WEATHER_API_KEY);
    }

    public final void init() {
        this.remoteConfig.registerListener(this);
        ProviderFactory.getWatch().registerListener(this);
        this.remoteConfig.setCacheExpirationTime(0L);
        fetch();
    }

    public final boolean isCampaignEnabled() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_GIFT_TIDAL_ENABLE);
    }

    public final boolean isEvaluationFeaturesEnabled() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_UNDER_EVALUATION);
    }

    public final boolean isIftttNotificationsEnabled(String iftttBehaviourName) {
        Intrinsics.checkNotNullParameter(iftttBehaviourName, "iftttBehaviourName");
        if (!ArraysKt___ArraysKt.contains(getDisabledBehaviours(), iftttBehaviourName) && this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_IFTTT_NOTIFICATIONS_ENABLE)) {
            return true;
        }
        return false;
    }

    public final boolean isMoreNumbersEvaluationEnabled() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_MORE_NUMBERS_EVALUATION);
    }

    public final boolean isRemoveBondFallbackEnabled() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_REMOVE_BOND_FALLBACK_ENABLE);
    }

    public final boolean isRemoveBondFallbackProntoEnabled() {
        return this.remoteConfig.getBoolean(RemoteConfigConstants.APP_FEATURE_REMOVE_BOND_FALLBACK_PRONTO);
    }

    @Override // com.animaconnected.firebase.RemoteConfigListener
    public void onConfigFetched() {
        updateCacheExpirationTime();
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((RemoteConfigControllerListener) it.next()).onFetch();
        }
    }

    @Override // com.animaconnected.firebase.RemoteConfigListener
    public void onConfigFetchedFailed(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((RemoteConfigControllerListener) it.next()).onFetchFailed(msg);
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onDaily() {
        fetch();
    }

    public final void registerListener(RemoteConfigControllerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void shutdown() {
        ProviderFactory.getWatch().unregisterListener(this);
        this.remoteConfig.unregisterListener(this);
    }

    public final void unregisterListener(RemoteConfigControllerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    private RemoteConfigController(Context context) {
        this.context = context;
        this.listeners = new CopyOnWriteArraySet();
        this.remoteConfig = RemoteConfig.Companion.getInstance(R.xml.remote_config_defaults);
    }
}
