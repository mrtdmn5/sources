package aws.sdk.kotlin.runtime.http;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.util.OsFamily;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class OsMetadata {
    public final OsFamily family;
    public final String version;

    /* compiled from: AwsUserAgentMetadata.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[OsFamily.values().length];
            try {
                r0[OsFamily.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public OsMetadata(OsFamily family, String str) {
        Intrinsics.checkNotNullParameter(family, "family");
        this.family = family;
        this.version = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OsMetadata)) {
            return false;
        }
        OsMetadata osMetadata = (OsMetadata) obj;
        if (this.family == osMetadata.family && Intrinsics.areEqual(this.version, osMetadata.version)) {
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
        String osFamily;
        int[] r0 = WhenMappings.$EnumSwitchMapping$0;
        OsFamily osFamily2 = this.family;
        if (r0[osFamily2.ordinal()] == 1) {
            osFamily = "other";
        } else {
            osFamily = osFamily2.toString();
        }
        String str = this.version;
        if (str != null) {
            return "os/" + osFamily + '/' + AwsUserAgentMetadataKt.access$encodeUaToken(str);
        }
        return ConstraintSet$$ExternalSyntheticOutline0.m("os/", osFamily);
    }
}
