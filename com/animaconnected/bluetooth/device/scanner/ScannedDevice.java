package com.animaconnected.bluetooth.device.scanner;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScannedDevice.kt */
/* loaded from: classes.dex */
public abstract class ScannedDevice implements Comparable<ScannedDevice> {
    public abstract String getAddress();

    public abstract int getRssi();

    @Override // java.lang.Comparable
    public int compareTo(ScannedDevice other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((this instanceof SmarTimeDevice) && (other instanceof HybridDevice)) {
            return 1;
        }
        if ((this instanceof HybridDevice) && (other instanceof SmarTimeDevice)) {
            return -1;
        }
        return Intrinsics.compare(Math.abs(getRssi()), Math.abs(other.getRssi()));
    }
}
