package com.animaconnected.secondo.provider.status.internal.devicestatus.battery;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.DeviceBatteryStatus;
import com.animaconnected.secondo.provider.status.StatusChangeListener;
import com.animaconnected.secondo.provider.status.StatusController;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.BatteryState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceBatteryStatusController.kt */
/* loaded from: classes3.dex */
public final class DeviceBatteryStatusController extends StatusController {
    public static final int $stable = 0;
    private final DeviceBatteryStatusController$watchProviderListener$1 watchProviderListener;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.animaconnected.secondo.provider.status.internal.devicestatus.battery.DeviceBatteryStatusController$watchProviderListener$1, com.animaconnected.watch.WatchProvider$WatchProviderListener] */
    public DeviceBatteryStatusController(WatchProvider watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        ?? r0 = new BaseWatchProviderListener() { // from class: com.animaconnected.secondo.provider.status.internal.devicestatus.battery.DeviceBatteryStatusController$watchProviderListener$1
            @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
            public void onBatteryStateChanged(BatteryState batteryState) {
                DeviceBatteryStatus deviceBatteryStatus;
                if (ProviderFactory.getWatch().getCapabilities().getHasChargeableBattery() && batteryState == BatteryState.CRITICAL) {
                    return;
                }
                DeviceBatteryStatusController deviceBatteryStatusController = DeviceBatteryStatusController.this;
                if (batteryState != BatteryState.NORMAL && batteryState != null) {
                    deviceBatteryStatus = new DeviceBatteryStatus(batteryState);
                } else {
                    deviceBatteryStatus = null;
                }
                deviceBatteryStatusController.setCurrentStatusModel(deviceBatteryStatus);
                StatusChangeListener statusChangeListener = DeviceBatteryStatusController.this.getStatusChangeListener();
                if (statusChangeListener != null) {
                    statusChangeListener.onStatusChanged();
                }
            }
        };
        this.watchProviderListener = r0;
        watch.registerListener(r0);
    }
}
