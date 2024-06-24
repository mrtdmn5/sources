package aws.sdk.kotlin.runtime.config.imds;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImdsClient.kt */
/* loaded from: classes.dex */
public abstract class EndpointConfiguration {

    /* compiled from: ImdsClient.kt */
    /* loaded from: classes.dex */
    public static final class Custom extends EndpointConfiguration {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Custom)) {
                return false;
            }
            ((Custom) obj).getClass();
            if (Intrinsics.areEqual((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Custom(endpoint=null)";
        }
    }

    /* compiled from: ImdsClient.kt */
    /* loaded from: classes.dex */
    public static final class Default extends EndpointConfiguration {
        public static final Default INSTANCE = new Default();
    }

    /* compiled from: ImdsClient.kt */
    /* loaded from: classes.dex */
    public static final class ModeOverride extends EndpointConfiguration {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ModeOverride)) {
                return false;
            }
            ((ModeOverride) obj).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ModeOverride(mode=null)";
        }
    }
}
