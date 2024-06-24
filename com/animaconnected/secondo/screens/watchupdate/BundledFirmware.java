package com.animaconnected.secondo.screens.watchupdate;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import com.animaconnected.watch.device.FirmwareVersion;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BundledFirmware.kt */
/* loaded from: classes3.dex */
public final class BundledFirmware {
    public static final int $stable = 8;
    private final FirmwareVersion firmwareVersion;
    private final int id;

    public BundledFirmware(FirmwareVersion firmwareVersion, int r3) {
        Intrinsics.checkNotNullParameter(firmwareVersion, "firmwareVersion");
        this.firmwareVersion = firmwareVersion;
        this.id = r3;
    }

    public static /* synthetic */ BundledFirmware copy$default(BundledFirmware bundledFirmware, FirmwareVersion firmwareVersion, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            firmwareVersion = bundledFirmware.firmwareVersion;
        }
        if ((r3 & 2) != 0) {
            r2 = bundledFirmware.id;
        }
        return bundledFirmware.copy(firmwareVersion, r2);
    }

    public final FirmwareVersion component1() {
        return this.firmwareVersion;
    }

    public final int component2() {
        return this.id;
    }

    public final BundledFirmware copy(FirmwareVersion firmwareVersion, int r3) {
        Intrinsics.checkNotNullParameter(firmwareVersion, "firmwareVersion");
        return new BundledFirmware(firmwareVersion, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BundledFirmware)) {
            return false;
        }
        BundledFirmware bundledFirmware = (BundledFirmware) obj;
        if (Intrinsics.areEqual(this.firmwareVersion, bundledFirmware.firmwareVersion) && this.id == bundledFirmware.id) {
            return true;
        }
        return false;
    }

    public final FirmwareVersion getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return Integer.hashCode(this.id) + (this.firmwareVersion.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BundledFirmware(firmwareVersion=");
        sb.append(this.firmwareVersion);
        sb.append(", id=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.id, ')');
    }
}
