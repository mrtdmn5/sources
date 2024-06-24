package androidx.compose.ui.window;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecureFlagPolicy.android.kt */
/* loaded from: classes.dex */
public final class SecureFlagPolicy_androidKt {

    /* compiled from: SecureFlagPolicy.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SecureFlagPolicy.values().length];
            try {
                r0[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        Intrinsics.checkNotNullParameter(secureFlagPolicy, "<this>");
        int r2 = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (r2 != 1) {
            if (r2 == 2) {
                return true;
            }
            if (r2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return z;
        }
        return false;
    }
}
