package com.animaconnected.bluetooth.device.scanner;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScannedDevice.kt */
/* loaded from: classes.dex */
public final class SmarTimeDevice extends ScannedDevice {
    private final String address;
    private final SmarTimeBrand brand;
    private final int rssi;

    public SmarTimeDevice(String address, int r3, SmarTimeBrand brand) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(brand, "brand");
        this.address = address;
        this.rssi = r3;
        this.brand = brand;
    }

    public static /* synthetic */ SmarTimeDevice copy$default(SmarTimeDevice smarTimeDevice, String str, int r2, SmarTimeBrand smarTimeBrand, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = smarTimeDevice.address;
        }
        if ((r4 & 2) != 0) {
            r2 = smarTimeDevice.rssi;
        }
        if ((r4 & 4) != 0) {
            smarTimeBrand = smarTimeDevice.brand;
        }
        return smarTimeDevice.copy(str, r2, smarTimeBrand);
    }

    public final String component1() {
        return this.address;
    }

    public final int component2() {
        return this.rssi;
    }

    public final SmarTimeBrand component3() {
        return this.brand;
    }

    public final SmarTimeDevice copy(String address, int r3, SmarTimeBrand brand) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(brand, "brand");
        return new SmarTimeDevice(address, r3, brand);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmarTimeDevice)) {
            return false;
        }
        SmarTimeDevice smarTimeDevice = (SmarTimeDevice) obj;
        if (Intrinsics.areEqual(this.address, smarTimeDevice.address) && this.rssi == smarTimeDevice.rssi && this.brand == smarTimeDevice.brand) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.bluetooth.device.scanner.ScannedDevice
    public String getAddress() {
        return this.address;
    }

    public final SmarTimeBrand getBrand() {
        return this.brand;
    }

    @Override // com.animaconnected.bluetooth.device.scanner.ScannedDevice
    public int getRssi() {
        return this.rssi;
    }

    public int hashCode() {
        return this.brand.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.rssi, this.address.hashCode() * 31, 31);
    }

    public String toString() {
        return "SmarTimeDevice(address=" + this.address + ", rssi=" + this.rssi + ", brand=" + this.brand + ')';
    }
}
