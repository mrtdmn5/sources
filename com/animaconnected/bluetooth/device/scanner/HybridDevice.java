package com.animaconnected.bluetooth.device.scanner;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScannedDevice.kt */
/* loaded from: classes.dex */
public final class HybridDevice extends ScannedDevice {
    private String address;
    private final DeviceType deviceType;
    private final FirmwareVariant firmwareVariant;
    private final int rssi;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ HybridDevice(java.lang.String r1, int r2, com.animaconnected.info.DeviceType r3, com.animaconnected.info.FirmwareVariant r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r5 = r5 & 8
            if (r5 == 0) goto Lb
            com.animaconnected.info.FirmwareVariant r4 = new com.animaconnected.info.FirmwareVariant
            r5 = 1
            r6 = 0
            r4.<init>(r6, r5, r6)
        Lb:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.device.scanner.HybridDevice.<init>(java.lang.String, int, com.animaconnected.info.DeviceType, com.animaconnected.info.FirmwareVariant, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ HybridDevice copy$default(HybridDevice hybridDevice, String str, int r2, DeviceType deviceType, FirmwareVariant firmwareVariant, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = hybridDevice.address;
        }
        if ((r5 & 2) != 0) {
            r2 = hybridDevice.rssi;
        }
        if ((r5 & 4) != 0) {
            deviceType = hybridDevice.deviceType;
        }
        if ((r5 & 8) != 0) {
            firmwareVariant = hybridDevice.firmwareVariant;
        }
        return hybridDevice.copy(str, r2, deviceType, firmwareVariant);
    }

    public final String component1() {
        return this.address;
    }

    public final int component2() {
        return this.rssi;
    }

    public final DeviceType component3() {
        return this.deviceType;
    }

    public final FirmwareVariant component4() {
        return this.firmwareVariant;
    }

    public final HybridDevice copy(String address, int r3, DeviceType deviceType, FirmwareVariant firmwareVariant) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(firmwareVariant, "firmwareVariant");
        return new HybridDevice(address, r3, deviceType, firmwareVariant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HybridDevice)) {
            return false;
        }
        HybridDevice hybridDevice = (HybridDevice) obj;
        if (Intrinsics.areEqual(this.address, hybridDevice.address) && this.rssi == hybridDevice.rssi && this.deviceType == hybridDevice.deviceType && Intrinsics.areEqual(this.firmwareVariant, hybridDevice.firmwareVariant)) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.bluetooth.device.scanner.ScannedDevice
    public String getAddress() {
        return this.address;
    }

    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final FirmwareVariant getFirmwareVariant() {
        return this.firmwareVariant;
    }

    @Override // com.animaconnected.bluetooth.device.scanner.ScannedDevice
    public int getRssi() {
        return this.rssi;
    }

    public int hashCode() {
        return this.firmwareVariant.hashCode() + ((this.deviceType.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.rssi, this.address.hashCode() * 31, 31)) * 31);
    }

    public void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public String toString() {
        return "HybridDevice(address=" + this.address + ", rssi=" + this.rssi + ", deviceType=" + this.deviceType + ", firmwareVariant=" + this.firmwareVariant + ')';
    }

    public HybridDevice(String address, int r3, DeviceType deviceType, FirmwareVariant firmwareVariant) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(firmwareVariant, "firmwareVariant");
        this.address = address;
        this.rssi = r3;
        this.deviceType = deviceType;
        this.firmwareVariant = firmwareVariant;
    }
}
