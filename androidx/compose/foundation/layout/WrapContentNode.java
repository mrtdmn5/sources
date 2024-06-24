package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    public Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    public Direction direction;
    public boolean unbounded;

    public WrapContentNode(Direction direction, boolean z, Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(alignmentCallback, "alignmentCallback");
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = alignmentCallback;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        int m567getMinWidthimpl;
        int m565getMaxWidthimpl;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Direction direction = this.direction;
        Direction direction2 = Direction.Vertical;
        int r2 = 0;
        if (direction != direction2) {
            m567getMinWidthimpl = 0;
        } else {
            m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
        }
        Direction direction3 = this.direction;
        Direction direction4 = Direction.Horizontal;
        if (direction3 == direction4) {
            r2 = Constraints.m566getMinHeightimpl(j);
        }
        int r5 = Integer.MAX_VALUE;
        if (this.direction != direction2 && this.unbounded) {
            m565getMaxWidthimpl = Integer.MAX_VALUE;
        } else {
            m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        }
        if (this.direction == direction4 || !this.unbounded) {
            r5 = Constraints.m564getMaxHeightimpl(j);
        }
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(ConstraintsKt.Constraints(m567getMinWidthimpl, m565getMaxWidthimpl, r2, r5));
        final int coerceIn = RangesKt___RangesKt.coerceIn(mo421measureBRTryo0.width, Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j));
        final int coerceIn2 = RangesKt___RangesKt.coerceIn(mo421measureBRTryo0.height, Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j));
        return measure.layout(coerceIn, coerceIn2, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2 = WrapContentNode.this.alignmentCallback;
                Placeable placeable = mo421measureBRTryo0;
                Placeable.PlacementScope.m432place70tqf50(placeable, function2.invoke(new IntSize(IntSizeKt.IntSize(coerceIn - placeable.width, coerceIn2 - placeable.height)), measure.getLayoutDirection()).packedValue, 0.0f);
                return Unit.INSTANCE;
            }
        });
    }
}
