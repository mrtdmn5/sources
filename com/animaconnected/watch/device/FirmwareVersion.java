package com.animaconnected.watch.device;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirmwareVersion.kt */
/* loaded from: classes3.dex */
public final class FirmwareVersion extends BaseFirmwareVersion {
    private final int major;
    private final int minor;
    private final int patch;

    public FirmwareVersion(int r2, int r3, int r4) {
        super(null);
        this.major = r2;
        this.minor = r3;
        this.patch = r4;
    }

    public static /* synthetic */ FirmwareVersion copy$default(FirmwareVersion firmwareVersion, int r1, int r2, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            r1 = firmwareVersion.major;
        }
        if ((r4 & 2) != 0) {
            r2 = firmwareVersion.minor;
        }
        if ((r4 & 4) != 0) {
            r3 = firmwareVersion.patch;
        }
        return firmwareVersion.copy(r1, r2, r3);
    }

    public final int compareTo(FirmwareVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int r0 = this.major;
        int r1 = other.major;
        if (r0 != r1) {
            return Intrinsics.compare(r0, r1);
        }
        int r02 = this.minor;
        int r12 = other.minor;
        if (r02 != r12) {
            return Intrinsics.compare(r02, r12);
        }
        int r03 = this.patch;
        int r3 = other.patch;
        if (r03 != r3) {
            return Intrinsics.compare(r03, r3);
        }
        return 0;
    }

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    public final int component3() {
        return this.patch;
    }

    public final FirmwareVersion copy(int r2, int r3, int r4) {
        return new FirmwareVersion(r2, r3, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirmwareVersion)) {
            return false;
        }
        FirmwareVersion firmwareVersion = (FirmwareVersion) obj;
        if (this.major == firmwareVersion.major && this.minor == firmwareVersion.minor && this.patch == firmwareVersion.patch) {
            return true;
        }
        return false;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return Integer.hashCode(this.patch) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.minor, Integer.hashCode(this.major) * 31, 31);
    }

    public final Pair<FirmwareVersion, FirmwareVersion> rangeTo(FirmwareVersion other) {
        boolean z;
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.compareTo(this) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new Pair<>(this, other);
        }
        throw new IllegalArgumentException((" A range of versions must be positive " + this + ' ' + other).toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.major);
        sb.append('.');
        sb.append(this.minor);
        sb.append('.');
        sb.append(this.patch);
        return sb.toString();
    }
}
