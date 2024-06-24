package com.animaconnected.secondo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.animaconnected.firebase.Analytics;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.notification.DeviceNotification;
import com.animaconnected.secondo.notification.NotificationListener;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.BrandUtils;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.provider.WatchAlarmProviderListener;
import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: AppAnalytics.kt */
/* loaded from: classes.dex */
public final class AppAnalytics extends BaseWatchProviderListener implements NotificationListener, WatchAlarmProviderListener, RemoteConfigController.RemoteConfigControllerListener, QuietHoursProvider.QuietHoursChangedListener {
    public static final int $stable = 8;
    private final Analytics analytics;
    private final AppEvents appEvents;
    private final Context context;
    private long onboardingTime;
    private final BroadcastReceiver receiver;
    private final RemoteConfigController remoteConfigController;

    public AppAnalytics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.analytics = ProviderFactory.INSTANCE.getAnalytics();
        this.appEvents = ProviderFactory.getAppAnalytics();
        this.remoteConfigController = RemoteConfigController.Companion.getInstance(context);
        this.receiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.app.AppAnalytics$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                AppEvents appEvents;
                AppEvents appEvents2;
                AppEvents appEvents3;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1530327060) {
                        if (hashCode == 1947666138 && action.equals("android.intent.action.ACTION_SHUTDOWN")) {
                            appEvents3 = AppAnalytics.this.appEvents;
                            appEvents3.phoneShutDown();
                            return;
                        }
                        return;
                    }
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
                        if (intExtra != intExtra2 && intExtra == 12) {
                            Log.d("TAG", "Bluetooth enabled");
                            appEvents2 = AppAnalytics.this.appEvents;
                            appEvents2.bluetoothOn();
                        } else if (intExtra != intExtra2 && intExtra == 10) {
                            Log.d("TAG", "Bluetooth disabled");
                            appEvents = AppAnalytics.this.appEvents;
                            appEvents.bluetoothOff();
                        }
                    }
                }
            }
        };
    }

    public final BroadcastReceiver getReceiver() {
        return this.receiver;
    }

    public final void init() {
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        this.analytics.setAppId(BrandUtils.getAppId());
        this.context.registerReceiver(this.receiver, intentFilter);
        ProviderFactory.getWatch().registerListener(this);
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        providerFactory.getNotificationCenter().addListener(this);
        providerFactory.getWatchAlarmProvider().registerListener(this);
        this.remoteConfigController.registerListener(this);
        providerFactory.getQuietHoursProvider().registerListener(this);
        onFetch();
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProviderListener
    public void onAlarmsChanged() {
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(scope, MainDispatcherLoader.dispatcher, null, new AppAnalytics$onAlarmsChanged$1(this, null), 2);
    }

    @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
    public void onFetch() {
        String[] disabledEvents = this.remoteConfigController.getDisabledEvents();
        boolean analyticsCollectionEnable = this.remoteConfigController.getAnalyticsCollectionEnable();
        this.analytics.setDisabledEvents(ArraysKt___ArraysKt.toList(disabledEvents));
        this.analytics.setAnalyticsCollectionEnabled(analyticsCollectionEnable);
        AppEvents.remoteConfigFetched$default(this.appEvents, true, this.remoteConfigController.getVersion(), this.remoteConfigController.getType(), null, 8, null);
    }

    @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
    public void onFetchFailed(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.appEvents.remoteConfigFetched(false, this.remoteConfigController.getVersion(), this.remoteConfigController.getType(), msg);
    }

    @Override // com.animaconnected.secondo.notification.NotificationListener
    public void onNotificationHandled(DeviceNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.appEvents.notificationHandled(notification.getCategory(), notification.getPackageName());
    }

    @Override // com.animaconnected.secondo.notification.NotificationListener
    public void onNotificationWithCategoryEvent(DeviceNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.appEvents.notificationEventHandled(notification.getPackageName());
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onOnboardingFinished(boolean z) {
        if (z) {
            this.appEvents.onboardingFinished(SystemClock.elapsedRealtime() - this.onboardingTime);
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onOnboardingStarted() {
        this.onboardingTime = SystemClock.elapsedRealtime();
        this.appEvents.onboardingStarted();
    }

    @Override // com.animaconnected.watch.provider.quiethours.QuietHoursProvider.QuietHoursChangedListener
    public void onQuietHoursChanged(boolean z, int r8, int r9, int r10, int r11) {
        this.appEvents.quietHoursSet(z, r8, r9, r10, r11);
    }

    public final void shutdown() {
        this.context.unregisterReceiver(this.receiver);
        ProviderFactory.getWatch().unregisterListener(this);
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        providerFactory.getNotificationCenter().removeListener(this);
        providerFactory.getWatchAlarmProvider().unregisterListener(this);
        this.remoteConfigController.unregisterListener(this);
    }
}
