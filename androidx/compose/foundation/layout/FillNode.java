package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class FillNode extends Modifier.Node implements LayoutModifierNode {
    public Direction direction;
    public float fraction;

    public FillNode(Direction direction, float f) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int m567getMinWidthimpl;
        int m565getMaxWidthimpl;
        int m564getMaxHeightimpl;
        int r7;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        if (Constraints.m561getHasBoundedWidthimpl(j) && this.direction != Direction.Vertical) {
            m567getMinWidthimpl = RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(Constraints.m565getMaxWidthimpl(j) * this.fraction), Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j));
            m565getMaxWidthimpl = m567getMinWidthimpl;
        } else {
            m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
            m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        }
        if (Constraints.m560getHasBoundedHeightimpl(j) && this.direction != Direction.Horizontal) {
            r7 = RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(Constraints.m564getMaxHeightimpl(j) * this.fraction), Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j));
            m564getMaxHeightimpl = r7;
        } else {
            int m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
            m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
            r7 = m566getMinHeightimpl;
        }
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(ConstraintsKt.Constraints(m567getMinWidthimpl, m565getMaxWidthimpl, r7, m564getMaxHeightimpl));
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
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
}
