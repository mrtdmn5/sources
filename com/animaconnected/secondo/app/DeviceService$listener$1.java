package com.animaconnected.secondo.app;

import android.content.Context;
import com.animaconnected.future.Future;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.provider.stopwatch.StopwatchProvider;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.device.BatteryState;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DeviceService.kt */
/* loaded from: classes.dex */
public final class DeviceService$listener$1 extends BaseWatchProviderListener {
    final /* synthetic */ DeviceService this$0;

    public DeviceService$listener$1(DeviceService deviceService) {
        this.this$0 = deviceService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAlarmEvent$lambda$0(DeviceService this$0, ConfigurationItem configurationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (configurationItem != null && configurationItem.getGroup() != -1) {
            NotificationHandler.showAlarmNotification(this$0.getApplicationContext(), R.string.alarm_dismissed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAlertEvent$lambda$1(DeviceService this$0, ConfigurationItem configurationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (configurationItem != null && configurationItem.getGroup() != -1) {
            NotificationHandler.showStepsGoalReachedNotification(this$0.getApplicationContext());
        }
    }

    private final void showNotificationPressCrownOrDismiss() {
        NotificationProvider notificationProvider;
        notificationProvider = this.this$0.getNotificationProvider();
        Future<ConfigurationItem> notificationItemASync = notificationProvider.getNotificationItemASync(5);
        final DeviceService deviceService = this.this$0;
        notificationItemASync.success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceService$listener$1$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceService$listener$1.showNotificationPressCrownOrDismiss$lambda$2(DeviceService.this, (ConfigurationItem) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotificationPressCrownOrDismiss$lambda$2(DeviceService this$0, ConfigurationItem configurationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (configurationItem != null && configurationItem.getGroup() != -1) {
            NotificationHandler.showAlarmNotification(this$0.getApplicationContext(), R.string.notification_alarm_start);
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onAlarmEvent(int r3) {
        NotificationProvider notificationProvider;
        if (r3 != 0 && r3 != 1) {
            if (r3 != 2) {
                if (r3 != 3) {
                    if (r3 == 4) {
                        notificationProvider = this.this$0.getNotificationProvider();
                        Future<ConfigurationItem> notificationItemASync = notificationProvider.getNotificationItemASync(5);
                        final DeviceService deviceService = this.this$0;
                        notificationItemASync.success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceService$listener$1$$ExternalSyntheticLambda2
                            @Override // com.animaconnected.future.SuccessCallback
                            public final void onSuccess(Object obj) {
                                DeviceService$listener$1.onAlarmEvent$lambda$0(DeviceService.this, (ConfigurationItem) obj);
                            }
                        });
                        return;
                    }
                    if (r3 != 5) {
                        return;
                    }
                } else {
                    NotificationHandler.showAlarmNotification(this.this$0.getApplicationContext(), R.string.notification_alarm_snoozed);
                    return;
                }
            }
            NotificationHandler.dismissAlarmNotification(this.this$0.getApplicationContext());
            return;
        }
        showNotificationPressCrownOrDismiss();
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onAlertEvent(int r1, int r2, int r3, int r4, int r5) {
        NotificationProvider notificationProvider;
        if (r1 != 0) {
            if (r1 == 2) {
                notificationProvider = this.this$0.getNotificationProvider();
                Future<ConfigurationItem> notificationItemASync = notificationProvider.getNotificationItemASync(7);
                final DeviceService deviceService = this.this$0;
                notificationItemASync.success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceService$listener$1$$ExternalSyntheticLambda1
                    @Override // com.animaconnected.future.SuccessCallback
                    public final void onSuccess(Object obj) {
                        DeviceService$listener$1.onAlertEvent$lambda$1(DeviceService.this, (ConfigurationItem) obj);
                    }
                });
                return;
            }
            return;
        }
        showNotificationPressCrownOrDismiss();
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBatteryPercentChanged(float f) {
        this.this$0.startOrRestartBatteryNotificationHandlerChecks();
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBatteryStateChanged(BatteryState batteryState) {
        this.this$0.startOrRestartBatteryNotificationHandlerChecks();
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onConnectionChanged(boolean z) {
        Context applicationContext = this.this$0.getApplicationContext();
        if (!z) {
            NotificationHandler.dismissMoveNotification(applicationContext);
            return;
        }
        RemoteConfigController.Companion companion = RemoteConfigController.Companion;
        Intrinsics.checkNotNull(applicationContext);
        if (companion.getInstance(applicationContext).getAppBrickEnable()) {
            BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new DeviceService$listener$1$onConnectionChanged$1(this.this$0, null), 3);
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onStillnessEvent(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 == 2) {
                    NotificationHandler.showMoveNotification(this.this$0.getApplicationContext());
                    return;
                }
                return;
            }
            NotificationHandler.showMovedNotification(this.this$0.getApplicationContext());
            return;
        }
        NotificationHandler.dismissMoveNotification(this.this$0.getApplicationContext());
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onStopwatchDataChanged() {
        StopwatchProvider.getInstance().update();
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onStepsNow(int r1, int r2) {
    }
}
