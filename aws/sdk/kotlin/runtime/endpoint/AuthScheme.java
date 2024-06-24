package aws.sdk.kotlin.runtime.endpoint;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthScheme.kt */
/* loaded from: classes.dex */
public abstract class AuthScheme {

    /* compiled from: AuthScheme.kt */
    /* loaded from: classes.dex */
    public static final class SigV4 extends AuthScheme {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SigV4)) {
                return false;
            }
            ((SigV4) obj).getClass();
            if (Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "SigV4(signingName=null, disableDoubleEncoding=false, signingRegion=null)";
        }
    }
}
