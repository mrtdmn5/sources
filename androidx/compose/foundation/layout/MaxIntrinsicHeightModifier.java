package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Intrinsic.kt */
/* loaded from: classes.dex */
public final class MaxIntrinsicHeightModifier implements IntrinsicSizeModifier {
    public static final MaxIntrinsicHeightModifier INSTANCE = new MaxIntrinsicHeightModifier();

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    /* renamed from: calculateContentConstraints-l58MMJ0 */
    public final long mo69calculateContentConstraintsl58MMJ0(MeasureScope calculateContentConstraints, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(calculateContentConstraints, "$this$calculateContentConstraints");
        return Constraints.Companion.m571fixedHeightOenEA2s(measurable.maxIntrinsicHeight(Constraints.m565getMaxWidthimpl(j)));
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.layout.LayoutModifier
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return intrinsicMeasurable.maxIntrinsicHeight(r4);
    }
}
