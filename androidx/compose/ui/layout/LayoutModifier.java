package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifier.kt */
/* loaded from: classes.dex */
public interface LayoutModifier extends Modifier.Element {
    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo5measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new MeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics$IntrinsicMinMax.Max, MeasuringIntrinsics$IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(r6, 0, 13)).getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo5measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new MeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics$IntrinsicMinMax.Max, MeasuringIntrinsics$IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, r6, 7)).getWidth();
    }

    /* renamed from: measure-3p2s80s */
    MeasureResult mo5measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo5measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new MeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics$IntrinsicMinMax.Min, MeasuringIntrinsics$IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(r6, 0, 13)).getHeight();
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo5measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new MeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics$IntrinsicMinMax.Min, MeasuringIntrinsics$IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, r6, 7)).getWidth();
    }
}
