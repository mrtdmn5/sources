package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Intrinsic.kt */
/* loaded from: classes.dex */
public final class MinIntrinsicWidthModifier implements IntrinsicSizeModifier {
    public static final MinIntrinsicWidthModifier INSTANCE = new MinIntrinsicWidthModifier();

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    /* renamed from: calculateContentConstraints-l58MMJ0 */
    public final long mo69calculateContentConstraintsl58MMJ0(MeasureScope calculateContentConstraints, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(calculateContentConstraints, "$this$calculateContentConstraints");
        return Constraints.Companion.m572fixedWidthOenEA2s(measurable.minIntrinsicWidth(Constraints.m564getMaxHeightimpl(j)));
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.layout.LayoutModifier
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return intrinsicMeasurable.minIntrinsicWidth(r4);
    }
}
