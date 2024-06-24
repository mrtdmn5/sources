package com.animaconnected.secondo.app;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.bluetooth.util.Bonding;
import com.animaconnected.info.DeviceType;
import com.animaconnected.logger.LibLogger;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.DeviceNotificationModel;
import com.animaconnected.secondo.app.DeviceService$batteryNotificationRunnable$2;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.battery.BatteryProvider;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.provider.status.internal.devicestatus.battery.DeviceBatteryNotificationHandler;
import com.animaconnected.secondo.provider.update.WatchDfuProvider;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.secondo.screens.MainActivity;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.ForegroundServiceUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.secondo.utils.debugging.DogfoodLogger;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.account.strava.StravaClient;
import com.animaconnected.watch.device.BatteryState;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SessionListener;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DeviceService.kt */
/* loaded from: classes.dex */
public final class DeviceService extends Service implements DeviceNotificationModel.ChangeListener {
    private static final String DEVICE_SERVICE_NOTIFICATION_CHANNEL_ID = "service_notification_channel_id";
    private static final int DEVICE_SERVICE_NOTIFICATION_ID = 803;
    private static final int GROUP_DEACTIVATED = -1;
    private static final int REQUEST_CODE = 180817;
    private static Boolean active;
    private DeviceAnalytics deviceAnalytics;
    private DeviceNotificationModel deviceNotificationModel;
    private NotificationCompat$Builder notificationBuilder;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DeviceService";
    private final Lazy batteryNotificationHandler$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.animaconnected.secondo.app.DeviceService$batteryNotificationHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private final Lazy batteryNotificationRunnable$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DeviceService$batteryNotificationRunnable$2.AnonymousClass1>() { // from class: com.animaconnected.secondo.app.DeviceService$batteryNotificationRunnable$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.animaconnected.secondo.app.DeviceService$batteryNotificationRunnable$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final DeviceService deviceService = DeviceService.this;
            return new Runnable() { // from class: com.animaconnected.secondo.app.DeviceService$batteryNotificationRunnable$2.1
                @Override // java.lang.Runnable
                public void run() {
                    WatchProvider watchProvider;
                    Handler batteryNotificationHandler;
                    WatchProvider watchProvider2;
                    Context applicationContext = DeviceService.this.getApplicationContext();
                    BatteryProvider batteryProvider = ProviderFactory.getBatteryProvider();
                    BatteryState state = batteryProvider.getState();
                    if (state != BatteryState.NORMAL) {
                        watchProvider = DeviceService.this.getWatchProvider();
                        if (watchProvider.getCapabilities().getHasChargeableBattery() && state == BatteryState.CRITICAL) {
                            return;
                        }
                        if (state == BatteryState.LOW) {
                            DeviceBatteryNotificationHandler.showBatteryLowNotification(applicationContext);
                        } else {
                            DeviceBatteryNotificationHandler.showBatteryCriticalNotification(applicationContext);
                        }
                        batteryNotificationHandler = DeviceService.this.getBatteryNotificationHandler();
                        batteryNotificationHandler.postDelayed(this, 3600000L);
                    } else {
                        DeviceBatteryNotificationHandler.dismissNotifications(applicationContext);
                    }
                    Float percentage = batteryProvider.getPercentage();
                    Float previousPercentage = batteryProvider.getPreviousPercentage();
                    if (percentage != null && previousPercentage != null) {
                        watchProvider2 = DeviceService.this.getWatchProvider();
                        if (watchProvider2.getCapabilities().getHasChargeableBattery() && Intrinsics.areEqual(percentage, 1.0f) && !Intrinsics.areEqual(previousPercentage, 1.0f)) {
                            DeviceBatteryNotificationHandler.showBatteryFullyChargedNotification(applicationContext);
                        }
                    }
                }
            };
        }
    });
    private final Lazy notificationManager$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NotificationManager>() { // from class: com.animaconnected.secondo.app.DeviceService$notificationManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationManager invoke() {
            Object systemService = DeviceService.this.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService;
        }
    });
    private final Lazy notificationProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NotificationProvider>() { // from class: com.animaconnected.secondo.app.DeviceService$notificationProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationProvider invoke() {
            return ProviderFactory.getNotificationProvider();
        }
    });
    private final Lazy watchProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchProvider>() { // from class: com.animaconnected.secondo.app.DeviceService$watchProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchProvider invoke() {
            return ProviderFactory.getWatch();
        }
    });
    private final Lazy stravaClient$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StravaClient>() { // from class: com.animaconnected.secondo.app.DeviceService$stravaClient$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StravaClient invoke() {
            WatchProvider watchProvider;
            watchProvider = DeviceService.this.getWatchProvider();
            return watchProvider.getWatchManager().getStravaClient();
        }
    });
    private final BaseWatchProviderListener listener = new DeviceService$listener$1(this);
    private final SessionListener sessionListener = new SessionListener() { // from class: com.animaconnected.secondo.app.DeviceService$sessionListener$1
        @Override // com.animaconnected.watch.fitness.SessionListener
        public Object onCompletedPreProcess(Session session, List<? extends List<LocationEntry>> list, Continuation<? super Unit> continuation) {
            NotificationUtils.showWorkoutCompletedNotification();
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            Object withContext = BuildersKt.withContext(MainDispatcherLoader.dispatcher, new DeviceService$sessionListener$1$onCompletedPreProcess$2(DeviceService.this, session, null), continuation);
            if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return withContext;
            }
            return Unit.INSTANCE;
        }
    };

    /* compiled from: DeviceService.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isMissingPermissionToStart(Context context) {
            if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") != 0) {
                return true;
            }
            return false;
        }

        public final void start(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (isMissingPermissionToStart(context)) {
                ForegroundServiceUtils foregroundServiceUtils = ForegroundServiceUtils.INSTANCE;
                String str = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                foregroundServiceUtils.sendForegroundStartAnalytics(context, str, false, "missing_permission");
                String str2 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) this, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$Companion$start$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "start() service missing permission";
                    }
                }, 6, (Object) null);
                return;
            }
            if (Intrinsics.areEqual(DeviceService.active, Boolean.TRUE)) {
                String str3 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) this, str3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$Companion$start$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "start requested. already running, nothing done";
                    }
                }, 6, (Object) null);
                return;
            }
            try {
                String str4 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                LogKt.info$default((Object) this, str4, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$Companion$start$3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "start service";
                    }
                }, 2, (Object) null);
                Intent intent = new Intent(context, (Class<?>) DeviceService.class);
                Object obj = ContextCompat.sLock;
                if (Build.VERSION.SDK_INT >= 26) {
                    ContextCompat.Api26Impl.startForegroundService(context, intent);
                } else {
                    context.startService(intent);
                }
                ForegroundServiceUtils foregroundServiceUtils2 = ForegroundServiceUtils.INSTANCE;
                String str5 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                ForegroundServiceUtils.sendForegroundStartAnalytics$default(foregroundServiceUtils2, context, str5, true, null, 8, null);
            } catch (Exception e) {
                ForegroundServiceUtils foregroundServiceUtils3 = ForegroundServiceUtils.INSTANCE;
                String str6 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$cp(...)");
                ForegroundServiceUtils.sendForegroundStartAnalytics$default(foregroundServiceUtils3, context, str6, false, null, 8, null);
                String str7 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
                foregroundServiceUtils3.handleStartForegroundServiceException(str7, e, context);
                String str8 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str8, "access$getTAG$cp(...)");
                LogKt.warn((Object) this, str8, (Throwable) e, true, (Function0<String>) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$Companion$start$4
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to launch DeviceService";
                    }
                });
            }
        }

        public final void stop(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = DeviceService.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            LogKt.debug$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$Companion$stop$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "stop";
                }
            }, 6, (Object) null);
            context.stopService(new Intent(context, (Class<?>) DeviceService.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getBatteryNotificationHandler() {
        return (Handler) this.batteryNotificationHandler$delegate.getValue();
    }

    private final Runnable getBatteryNotificationRunnable() {
        return (Runnable) this.batteryNotificationRunnable$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationManager getNotificationManager() {
        return (NotificationManager) this.notificationManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationProvider getNotificationProvider() {
        return (NotificationProvider) this.notificationProvider$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StravaClient getStravaClient() {
        return (StravaClient) this.stravaClient$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WatchProvider getWatchProvider() {
        return (WatchProvider) this.watchProvider$delegate.getValue();
    }

    private final void initializeService() {
        ActivityManager activityManager;
        Object systemService = getSystemService("activity");
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager != null) {
            String str = TAG;
            Log.d(str, "Memory class: " + activityManager.getMemoryClass() + " MB");
            Log.d(str, "Large memory class: " + activityManager.getLargeMemoryClass() + " MB");
        }
        startOrRestartBatteryNotificationHandlerChecks();
    }

    private final void startForegroundServiceIfNeeded() {
        if (Build.VERSION.SDK_INT >= 26) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$startForegroundServiceIfNeeded$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Creating device service notification";
                }
            }, 6, (Object) null);
            DeviceService$$ExternalSyntheticApiModelOutline4.m();
            NotificationChannel m = DeviceService$$ExternalSyntheticApiModelOutline3.m(getString(R.string.service_notification_name));
            m.enableVibration(false);
            m.setSound(null, null);
            getNotificationManager().createNotificationChannel(m);
            PendingIntent activity = PendingIntent.getActivity(this, REQUEST_CODE, new Intent(this, (Class<?>) MainActivity.class), 134217728 | AppUtils.getPendingIntentFlag());
            Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.CHANNEL_ID", DEVICE_SERVICE_NOTIFICATION_CHANNEL_ID);
            intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
            PendingIntent activity2 = PendingIntent.getActivity(getApplicationContext(), 0, intent, AppUtils.getPendingIntentFlag());
            NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(this, DEVICE_SERVICE_NOTIFICATION_CHANNEL_ID);
            createNotificationBuilder.mContentIntent = activity;
            NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
            notificationCompat$BigTextStyle.bigText("");
            createNotificationBuilder.setStyle(notificationCompat$BigTextStyle);
            createNotificationBuilder.mShowWhen = false;
            createNotificationBuilder.addAction(0, getApplicationContext().getString(R.string.service_notification_hide), activity2);
            this.notificationBuilder = createNotificationBuilder;
            startForeground(DEVICE_SERVICE_NOTIFICATION_ID, createNotificationBuilder.build());
            LogKt.info$default((Object) this, TAG2, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$startForegroundServiceIfNeeded$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Foreground service started";
                }
            }, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startOrRestartBatteryNotificationHandlerChecks() {
        getBatteryNotificationHandler().removeCallbacks(getBatteryNotificationRunnable());
        getBatteryNotificationHandler().post(getBatteryNotificationRunnable());
    }

    private final void updateForegroundService() {
        if (Build.VERSION.SDK_INT >= 26) {
            DeviceNotificationModel deviceNotificationModel = new DeviceNotificationModel(getWatchProvider());
            deviceNotificationModel.setListener(this);
            this.deviceNotificationModel = deviceNotificationModel;
            onChange();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        throw new UnsupportedOperationException("Not supported");
    }

    @Override // com.animaconnected.secondo.app.DeviceNotificationModel.ChangeListener
    public void onChange() {
        NotificationCompat$Builder notificationCompat$Builder = this.notificationBuilder;
        if (notificationCompat$Builder == null) {
            return;
        }
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new DeviceService$onChange$1(this, notificationCompat$Builder, null), 3);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        onChange();
    }

    @Override // android.app.Service
    public void onCreate() {
        Companion companion = Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        boolean z = false;
        if (companion.isMissingPermissionToStart(applicationContext)) {
            ForegroundServiceUtils foregroundServiceUtils = ForegroundServiceUtils.INSTANCE;
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            foregroundServiceUtils.sendForegroundStartAnalytics(applicationContext2, TAG2, false, "missing_permission");
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$onCreate$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "onCreate() service missing permission";
                }
            }, 6, (Object) null);
            return;
        }
        super.onCreate();
        String TAG3 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        LogKt.info$default((Object) this, TAG3, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$onCreate$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Starting service";
            }
        }, 2, (Object) null);
        active = Boolean.TRUE;
        startForegroundServiceIfNeeded();
        KronabyApplication.Companion.initialize();
        updateForegroundService();
        getWatchProvider().registerListener(this.listener);
        DeviceType deviceType = getWatchProvider().getDeviceType();
        if (deviceType != null && deviceType.getHasDisplay()) {
            z = true;
        }
        if (z) {
            getWatchProvider().fitness().registerSessionListener(this.sessionListener);
        }
        Context applicationContext3 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        WatchProvider watchProvider = getWatchProvider();
        WatchDfuProvider watchDfuProvider = ProviderFactory.getWatchDfuProvider();
        WatchFotaProvider watchFotaProvider = ProviderFactory.getWatchFotaProvider();
        Bonding bonding = Bonding.getInstance();
        Intrinsics.checkNotNullExpressionValue(bonding, "getInstance(...)");
        DeviceAnalytics deviceAnalytics = new DeviceAnalytics(applicationContext3, watchProvider, watchDfuProvider, watchFotaProvider, bonding, ProviderFactory.getWatchAppUpdateProvider());
        deviceAnalytics.init();
        this.deviceAnalytics = deviceAnalytics;
        initializeService();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.info$default((Object) this, TAG2, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$onDestroy$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onDestroy";
            }
        }, 2, (Object) null);
        active = Boolean.FALSE;
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(1);
            DeviceNotificationModel deviceNotificationModel = this.deviceNotificationModel;
            if (deviceNotificationModel != null) {
                deviceNotificationModel.setListener(null);
            }
        }
        DeviceAnalytics deviceAnalytics = this.deviceAnalytics;
        if (deviceAnalytics != null) {
            deviceAnalytics.shutdown();
        }
        getWatchProvider().unregisterListener(this.listener);
        getWatchProvider().fitness().unregisterSessionListener(this.sessionListener);
        getBatteryNotificationHandler().removeCallbacks(getBatteryNotificationRunnable());
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        DogfoodLogger dogfoodLogger;
        super.onLowMemory();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.warn$default((Object) this, TAG2, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$onLowMemory$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onLowMemory";
            }
        }, 2, (Object) null);
        LibLogger currentLogger = LogKt.getCurrentLogger();
        if (currentLogger instanceof DogfoodLogger) {
            dogfoodLogger = (DogfoodLogger) currentLogger;
        } else {
            dogfoodLogger = null;
        }
        if (dogfoodLogger == null) {
            return;
        }
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new DeviceService$onLowMemory$2(dogfoodLogger, null), 3);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int r9, int r10) {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$onStartCommand$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onStartCommand";
            }
        }, 6, (Object) null);
        return 1;
    }
}
