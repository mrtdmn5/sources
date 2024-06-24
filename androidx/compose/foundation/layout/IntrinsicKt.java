package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Intrinsic.kt */
/* loaded from: classes.dex */
public final class IntrinsicKt {

    /* compiled from: Intrinsic.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[IntrinsicSize.values().length];
            try {
                r0[IntrinsicSize.Min.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[IntrinsicSize.Max.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final Modifier height(Modifier modifier, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        int r2 = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (r2 != 1) {
            if (r2 == 2) {
                return modifier.then(MaxIntrinsicHeightModifier.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        }
        return modifier.then(MinIntrinsicHeightModifier.INSTANCE);
    }

    public static final Modifier width(Modifier modifier, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        int r2 = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (r2 != 1) {
            if (r2 == 2) {
                return modifier.then(MaxIntrinsicWidthModifier.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        }
        return modifier.then(MinIntrinsicWidthModifier.INSTANCE);
    }
}
