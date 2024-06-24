package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.dynamite.zzm;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Scroll.kt */
/* loaded from: classes.dex */
public final class ScrollingLayoutNode extends Modifier.Node implements LayoutModifierNode {
    public boolean isReversed;
    public boolean isVertical;
    public ScrollState scrollerState;

    public ScrollingLayoutNode(ScrollState scrollerState, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(scrollerState, "scrollerState");
        this.scrollerState = scrollerState;
        this.isReversed = z;
        this.isVertical = z2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (this.isVertical) {
            return intrinsicMeasurable.maxIntrinsicHeight(r4);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (this.isVertical) {
            return intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(r4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Orientation orientation;
        int m564getMaxHeightimpl;
        int r2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        if (this.isVertical) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        zzm.m1640checkScrollableContainerConstraintsK40F9xA(j, orientation);
        int r1 = Integer.MAX_VALUE;
        if (this.isVertical) {
            m564getMaxHeightimpl = Integer.MAX_VALUE;
        } else {
            m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
        }
        if (this.isVertical) {
            r1 = Constraints.m565getMaxWidthimpl(j);
        }
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(Constraints.m558copyZbe2FdA$default(j, 0, r1, 0, m564getMaxHeightimpl, 5));
        int r0 = mo421measureBRTryo0.width;
        int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        if (r0 > m565getMaxWidthimpl) {
            r0 = m565getMaxWidthimpl;
        }
        int r12 = mo421measureBRTryo0.height;
        int m564getMaxHeightimpl2 = Constraints.m564getMaxHeightimpl(j);
        if (r12 > m564getMaxHeightimpl2) {
            r12 = m564getMaxHeightimpl2;
        }
        final int r122 = mo421measureBRTryo0.height - r12;
        int r13 = mo421measureBRTryo0.width - r0;
        if (!this.isVertical) {
            r122 = r13;
        }
        ScrollState scrollState = this.scrollerState;
        scrollState._maxValueState.setIntValue(r122);
        if (scrollState.getValue() > r122) {
            scrollState.value$delegate.setIntValue(r122);
        }
        ScrollState scrollState2 = this.scrollerState;
        if (this.isVertical) {
            r2 = r12;
        } else {
            r2 = r0;
        }
        scrollState2.viewportSize$delegate.setIntValue(r2);
        return measure.layout(r0, r12, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ScrollingLayoutNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                int r14;
                int r3;
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                ScrollingLayoutNode scrollingLayoutNode = ScrollingLayoutNode.this;
                int value = scrollingLayoutNode.scrollerState.getValue();
                int r22 = 0;
                int r32 = r122;
                int coerceIn = RangesKt___RangesKt.coerceIn(value, 0, r32);
                if (scrollingLayoutNode.isReversed) {
                    r14 = coerceIn - r32;
                } else {
                    r14 = -coerceIn;
                }
                boolean z = scrollingLayoutNode.isVertical;
                if (z) {
                    r3 = 0;
                } else {
                    r3 = r14;
                }
                if (z) {
                    r22 = r14;
                }
                Placeable.PlacementScope.placeRelativeWithLayer$default(layout, mo421measureBRTryo0, r3, r22);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (this.isVertical) {
            return intrinsicMeasurable.minIntrinsicHeight(r4);
        }
        return intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (this.isVertical) {
            return intrinsicMeasurable.minIntrinsicWidth(Integer.MAX_VALUE);
        }
        return intrinsicMeasurable.minIntrinsicWidth(r4);
    }
}
