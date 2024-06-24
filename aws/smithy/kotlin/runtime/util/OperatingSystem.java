package aws.smithy.kotlin.runtime.util;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform.kt */
/* loaded from: classes.dex */
public final class OperatingSystem {
    public final OsFamily family;
    public final String version;

    public OperatingSystem(OsFamily family, String str) {
        Intrinsics.checkNotNullParameter(family, "family");
        this.family = family;
        this.version = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OperatingSystem)) {
            return false;
        }
        OperatingSystem operatingSystem = (OperatingSystem) obj;
        if (this.family == operatingSystem.family && Intrinsics.areEqual(this.version, operatingSystem.version)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.family.hashCode() * 31;
        String str = this.version;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OperatingSystem(family=");
        sb.append(this.family);
        sb.append(", version=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.version, ')');
    }
}
