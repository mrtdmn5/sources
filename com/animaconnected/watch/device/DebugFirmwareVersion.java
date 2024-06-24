package com.animaconnected.watch.device;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirmwareVersion.kt */
/* loaded from: classes3.dex */
public final class DebugFirmwareVersion extends BaseFirmwareVersion {
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFirmwareVersion(String name) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public static /* synthetic */ DebugFirmwareVersion copy$default(DebugFirmwareVersion debugFirmwareVersion, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = debugFirmwareVersion.name;
        }
        return debugFirmwareVersion.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final DebugFirmwareVersion copy(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DebugFirmwareVersion(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DebugFirmwareVersion) && Intrinsics.areEqual(this.name, ((DebugFirmwareVersion) obj).name)) {
            return true;
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("DebugFirmwareVersion(name="), this.name, ')');
    }
}
