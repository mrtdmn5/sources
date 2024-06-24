package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: Arrangement.kt */
/* loaded from: classes.dex */
public final class Arrangement$spacedBy$1 extends Lambda implements Function2<Integer, LayoutDirection, Integer> {
    public static final Arrangement$spacedBy$1 INSTANCE = new Arrangement$spacedBy$1();

    public Arrangement$spacedBy$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Integer invoke(Integer num, LayoutDirection layoutDirection) {
        int intValue = num.intValue();
        LayoutDirection layoutDirection2 = layoutDirection;
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        int r0 = Alignment.$r8$clinit;
        float f = (intValue + 0) / 2.0f;
        float f2 = -1.0f;
        if (layoutDirection2 != LayoutDirection.Ltr) {
            f2 = (-1.0f) * (-1);
        }
        return Integer.valueOf(MathKt__MathJVMKt.roundToInt((1 + f2) * f));
    }
}
