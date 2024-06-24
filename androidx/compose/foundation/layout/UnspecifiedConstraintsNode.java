package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    public float minHeight;
    public float minWidth;

    public UnspecifiedConstraintsNode(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        int r2;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(r4);
        if (!Dp.m579equalsimpl0(this.minHeight, Float.NaN)) {
            r2 = intrinsicMeasureScope.mo44roundToPx0680j_4(this.minHeight);
        } else {
            r2 = 0;
        }
        if (maxIntrinsicHeight < r2) {
            return r2;
        }
        return maxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        int r2;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(r4);
        if (!Dp.m579equalsimpl0(this.minWidth, Float.NaN)) {
            r2 = intrinsicMeasureScope.mo44roundToPx0680j_4(this.minWidth);
        } else {
            r2 = 0;
        }
        if (maxIntrinsicWidth < r2) {
            return r2;
        }
        return maxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int m567getMinWidthimpl;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        int r2 = 0;
        if (!Dp.m579equalsimpl0(this.minWidth, Float.NaN) && Constraints.m567getMinWidthimpl(j) == 0) {
            m567getMinWidthimpl = measure.mo44roundToPx0680j_4(this.minWidth);
            int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
            if (m567getMinWidthimpl > m565getMaxWidthimpl) {
                m567getMinWidthimpl = m565getMaxWidthimpl;
            }
            if (m567getMinWidthimpl < 0) {
                m567getMinWidthimpl = 0;
            }
        } else {
            m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
        }
        int m565getMaxWidthimpl2 = Constraints.m565getMaxWidthimpl(j);
        if (!Dp.m579equalsimpl0(this.minHeight, Float.NaN) && Constraints.m566getMinHeightimpl(j) == 0) {
            int mo44roundToPx0680j_4 = measure.mo44roundToPx0680j_4(this.minHeight);
            int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
            if (mo44roundToPx0680j_4 > m564getMaxHeightimpl) {
                mo44roundToPx0680j_4 = m564getMaxHeightimpl;
            }
            if (mo44roundToPx0680j_4 >= 0) {
                r2 = mo44roundToPx0680j_4;
            }
        } else {
            r2 = Constraints.m566getMinHeightimpl(j);
        }
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(ConstraintsKt.Constraints(m567getMinWidthimpl, m565getMaxWidthimpl2, r2, Constraints.m564getMaxHeightimpl(j)));
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        int r2;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(r4);
        if (!Dp.m579equalsimpl0(this.minHeight, Float.NaN)) {
            r2 = intrinsicMeasureScope.mo44roundToPx0680j_4(this.minHeight);
        } else {
            r2 = 0;
        }
        if (minIntrinsicHeight < r2) {
            return r2;
        }
        return minIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        int r2;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(r4);
        if (!Dp.m579equalsimpl0(this.minWidth, Float.NaN)) {
            r2 = intrinsicMeasureScope.mo44roundToPx0680j_4(this.minWidth);
        } else {
            r2 = 0;
        }
        if (minIntrinsicWidth < r2) {
            return r2;
        }
        return minIntrinsicWidth;
    }
}
