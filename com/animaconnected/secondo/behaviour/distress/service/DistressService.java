package com.animaconnected.secondo.behaviour.distress.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.DeviceService$$ExternalSyntheticApiModelOutline4;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.model.Observer;
import com.animaconnected.secondo.behaviour.distress.notifications.StateNotificationHandler;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.secondo.screens.MainActivity;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.ForegroundServiceUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.kronaby.watch.app.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DistressService.kt */
/* loaded from: classes3.dex */
public final class DistressService extends Service {
    private static final String DISTRESS_SERVICE_NOTIFICATION_CHANNEL_ID = "distress_notification_channel_id";
    private static final int DISTRESS_SERVICE_NOTIFICATION_ID = 804;
    private static boolean isRunning;

    @SuppressLint({"StaticFieldLeak"})
    private static NotificationCompat$Builder notificationBuilder;
    private static NotificationManager notificationManager;
    private Job locationJob;
    private final CoroutineScope scope;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DistressService";

    /* compiled from: DistressService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isRunning() {
            return DistressService.isRunning;
        }

        public final void setRunning(boolean z) {
            DistressService.isRunning = z;
        }

        public final void start(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AndroidLocationBackend.hasForegroundLocationPermission()) {
                String str = DistressService.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressService$Companion$start$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "start() called with context = [" + context + ']';
                    }
                }, 6, (Object) null);
                try {
                    Intent intent = new Intent(context, (Class<?>) DistressService.class);
                    Object obj = ContextCompat.sLock;
                    if (Build.VERSION.SDK_INT >= 26) {
                        ContextCompat.Api26Impl.startForegroundService(context, intent);
                    } else {
                        context.startService(intent);
                    }
                    setRunning(true);
                    ForegroundServiceUtils foregroundServiceUtils = ForegroundServiceUtils.INSTANCE;
                    String str2 = DistressService.TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                    ForegroundServiceUtils.sendForegroundStartAnalytics$default(foregroundServiceUtils, context, str2, true, null, 8, null);
                    return;
                } catch (Exception e) {
                    ForegroundServiceUtils foregroundServiceUtils2 = ForegroundServiceUtils.INSTANCE;
                    String str3 = DistressService.TAG;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                    ForegroundServiceUtils.sendForegroundStartAnalytics$default(foregroundServiceUtils2, context, str3, false, null, 8, null);
                    String str4 = DistressService.TAG;
                    Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                    foregroundServiceUtils2.handleStartForegroundServiceException(str4, e, context);
                    String str5 = DistressService.TAG;
                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                    LogKt.warn((Object) this, str5, (Throwable) e, true, (Function0<String>) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressService$Companion$start$3
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to launch DistressService";
                        }
                    });
                    return;
                }
            }
            ForegroundServiceUtils foregroundServiceUtils3 = ForegroundServiceUtils.INSTANCE;
            String str6 = DistressService.TAG;
            Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$cp(...)");
            foregroundServiceUtils3.sendForegroundStartAnalytics(context, str6, false, "missing_permission");
            String str7 = DistressService.TAG;
            Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
            LogKt.debug$default((Object) this, str7, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressService$Companion$start$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "start() service missing permission";
                }
            }, 6, (Object) null);
        }

        public final void stop(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = DistressService.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            LogKt.debug$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressService$Companion$stop$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "stop() called with context = [" + context + ']';
                }
            }, 6, (Object) null);
            context.stopService(new Intent(context, (Class<?>) DistressService.class));
        }

        public final void updateNotification(String str, String str2) {
            NotificationCompat$Builder notificationCompat$Builder = DistressService.notificationBuilder;
            if (notificationCompat$Builder != null) {
                notificationCompat$Builder.setContentTitle(str);
                notificationCompat$Builder.setContentText(str2);
                NotificationManager notificationManager = DistressService.notificationManager;
                if (notificationManager != null) {
                    notificationManager.notify(DistressService.DISTRESS_SERVICE_NOTIFICATION_ID, notificationCompat$Builder.build());
                }
            }
        }

        private Companion() {
        }
    }

    public DistressService() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.scope = CoroutineScopeKt.CoroutineScope(MainDispatcherLoader.dispatcher.plus(SupervisorKt.SupervisorJob$default()));
    }

    private final void createNotificationBuilder() {
        String str;
        PendingIntent activity = PendingIntent.getActivity(this, StateNotificationHandler.REQUEST_CODE, new Intent(this, (Class<?>) MainActivity.class), 134217728 | AppUtils.getPendingIntentFlag());
        Observer observer = DistressModel.Companion.getInstance(this).getObserver();
        if (observer == null || (str = observer.getFirstName()) == null) {
            str = "";
        }
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(this, DISTRESS_SERVICE_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setContentTitle(getString(R.string.behaviour_name_distress));
        createNotificationBuilder.setContentText(getString(R.string.distress_ntf_fmh_active_message, str));
        notificationBuilder = createNotificationBuilder;
    }

    private final void createNotificationChannel(NotificationManager notificationManager2) {
        if (Build.VERSION.SDK_INT >= 26) {
            DeviceService$$ExternalSyntheticApiModelOutline4.m();
            notificationManager2.createNotificationChannel(DistressService$$ExternalSyntheticApiModelOutline0.m(getString(R.string.behaviour_name_distress)));
        }
    }

    private final void startForegroundServiceIfNeeded() {
        Notification notification;
        if (Build.VERSION.SDK_INT >= 26) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressService$startForegroundServiceIfNeeded$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Creating distress service notification";
                }
            }, 6, (Object) null);
            Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager2 = (NotificationManager) systemService;
            notificationManager = notificationManager2;
            createNotificationChannel(notificationManager2);
            createNotificationBuilder();
            NotificationCompat$Builder notificationCompat$Builder = notificationBuilder;
            if (notificationCompat$Builder != null) {
                notification = notificationCompat$Builder.build();
            } else {
                notification = null;
            }
            startForeground(DISTRESS_SERVICE_NOTIFICATION_ID, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLocationUpdates() {
        Job job = this.locationJob;
        if (job != null) {
            job.cancel(null);
        }
        this.locationJob = BuildersKt.launch$default(this.scope, null, null, new DistressService$startLocationUpdates$1(this, null), 3);
    }

    public static final void stop(Context context) {
        Companion.stop(context);
    }

    private final void stopForegroundIfNeeded() {
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
    }

    public static final void updateNotification(String str, String str2) {
        Companion.updateNotification(str, str2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        if (!AndroidLocationBackend.hasForegroundLocationPermission()) {
            ForegroundServiceUtils foregroundServiceUtils = ForegroundServiceUtils.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            foregroundServiceUtils.sendForegroundStartAnalytics(applicationContext, TAG2, false, "missing_permission");
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressService$onCreate$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "onCreate() service missing permission";
                }
            }, 6, (Object) null);
            return;
        }
        super.onCreate();
        startForegroundServiceIfNeeded();
    }

    @Override // android.app.Service
    public void onDestroy() {
        CoroutineScopeKt.cancel(this.scope, null);
        super.onDestroy();
        stopForegroundIfNeeded();
        isRunning = false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int r2, int r3) {
        startLocationUpdates();
        return 1;
    }
}
