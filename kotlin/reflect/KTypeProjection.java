package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KTypeProjection.kt */
/* loaded from: classes.dex */
public final class KTypeProjection {
    public final KVariance variance = null;
    public final KType type = null;

    /* compiled from: KTypeProjection.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[KVariance.values().length];
            try {
                r0[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        if (this.variance == kTypeProjection.variance && Intrinsics.areEqual(this.type, kTypeProjection.type)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        KVariance kVariance = this.variance;
        if (kVariance == null) {
            hashCode = 0;
        } else {
            hashCode = kVariance.hashCode();
        }
        int r1 = hashCode * 31;
        KType kType = this.type;
        if (kType != null) {
            r0 = kType.hashCode();
        }
        return r1 + r0;
    }

    public final String toString() {
        int r1;
        KVariance kVariance = this.variance;
        if (kVariance == null) {
            r1 = -1;
        } else {
            r1 = WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        }
        if (r1 != -1) {
            KType kType = this.type;
            if (r1 != 1) {
                if (r1 != 2) {
                    if (r1 == 3) {
                        return "out " + kType;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "in " + kType;
            }
            return String.valueOf(kType);
        }
        return "*";
    }
}
