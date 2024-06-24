package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNode.kt */
/* loaded from: classes.dex */
public interface LayoutModifierNode extends DelegatableNode {
    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo31measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Max, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(r6, 0, 13)).getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo31measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Max, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, r6, 7)).getWidth();
    }

    /* renamed from: measure-3p2s80s */
    MeasureResult mo31measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo31measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Min, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(r6, 0, 13)).getHeight();
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r6) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return mo31measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable(intrinsicMeasurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Min, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, r6, 7)).getWidth();
    }
}
