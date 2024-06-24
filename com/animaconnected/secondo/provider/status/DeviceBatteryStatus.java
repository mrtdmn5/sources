package com.animaconnected.secondo.provider.status;

import com.animaconnected.secondo.screens.status.devicestatus.DeviceBatteryStatusFragment;
import com.animaconnected.watch.device.BatteryState;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public final class DeviceBatteryStatus extends StatusModel {
    public static final int $stable = 0;
    private final BatteryState batteryState;

    public DeviceBatteryStatus(BatteryState batteryState) {
        super(70, DeviceBatteryStatusFragment.class, null);
        this.batteryState = batteryState;
    }

    public static /* synthetic */ DeviceBatteryStatus copy$default(DeviceBatteryStatus deviceBatteryStatus, BatteryState batteryState, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            batteryState = deviceBatteryStatus.batteryState;
        }
        return deviceBatteryStatus.copy(batteryState);
    }

    public final BatteryState component1() {
        return this.batteryState;
    }

    public final DeviceBatteryStatus copy(BatteryState batteryState) {
        return new DeviceBatteryStatus(batteryState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DeviceBatteryStatus) && this.batteryState == ((DeviceBatteryStatus) obj).batteryState) {
            return true;
        }
        return false;
    }

    public final BatteryState getBatteryState() {
        return this.batteryState;
    }

    public int hashCode() {
        BatteryState batteryState = this.batteryState;
        if (batteryState == null) {
            return 0;
        }
        return batteryState.hashCode();
    }

    @Override // com.animaconnected.secondo.provider.status.StatusModel
    public String toString() {
        return "DeviceBatteryStatus(batteryState=" + this.batteryState + ')';
    }
}
