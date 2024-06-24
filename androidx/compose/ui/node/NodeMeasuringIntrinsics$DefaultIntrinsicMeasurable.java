package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNode.kt */
/* loaded from: classes.dex */
public final class NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable implements Measurable {
    public final IntrinsicMeasurable measurable;
    public final NodeMeasuringIntrinsics$IntrinsicMinMax minMax;
    public final NodeMeasuringIntrinsics$IntrinsicWidthHeight widthHeight;

    public NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable(IntrinsicMeasurable measurable, NodeMeasuringIntrinsics$IntrinsicMinMax minMax, NodeMeasuringIntrinsics$IntrinsicWidthHeight widthHeight) {
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        this.measurable = measurable;
        this.minMax = minMax;
        this.widthHeight = widthHeight;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final Object getParentData() {
        return this.measurable.getParentData();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicHeight(int r2) {
        return this.measurable.maxIntrinsicHeight(r2);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicWidth(int r2) {
        return this.measurable.maxIntrinsicWidth(r2);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    public final Placeable mo421measureBRTryo0(long j) {
        final int minIntrinsicHeight;
        final int minIntrinsicWidth;
        NodeMeasuringIntrinsics$IntrinsicWidthHeight nodeMeasuringIntrinsics$IntrinsicWidthHeight = this.widthHeight;
        NodeMeasuringIntrinsics$IntrinsicWidthHeight nodeMeasuringIntrinsics$IntrinsicWidthHeight2 = NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width;
        NodeMeasuringIntrinsics$IntrinsicMinMax nodeMeasuringIntrinsics$IntrinsicMinMax = this.minMax;
        IntrinsicMeasurable intrinsicMeasurable = this.measurable;
        if (nodeMeasuringIntrinsics$IntrinsicWidthHeight == nodeMeasuringIntrinsics$IntrinsicWidthHeight2) {
            if (nodeMeasuringIntrinsics$IntrinsicMinMax == NodeMeasuringIntrinsics$IntrinsicMinMax.Max) {
                minIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m564getMaxHeightimpl(j));
            } else {
                minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m564getMaxHeightimpl(j));
            }
            final int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
            return new Placeable(minIntrinsicWidth, m564getMaxHeightimpl) { // from class: androidx.compose.ui.node.NodeMeasuringIntrinsics$EmptyPlaceable
                {
                    m430setMeasuredSizeozmzZPI(IntSizeKt.IntSize(minIntrinsicWidth, m564getMaxHeightimpl));
                }

                @Override // androidx.compose.ui.layout.Measured
                public final int get(AlignmentLine alignmentLine) {
                    Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
                    return Integer.MIN_VALUE;
                }

                @Override // androidx.compose.ui.layout.Placeable
                /* renamed from: placeAt-f8xVGno */
                public final void mo422placeAtf8xVGno(long j2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
                }
            };
        }
        if (nodeMeasuringIntrinsics$IntrinsicMinMax == NodeMeasuringIntrinsics$IntrinsicMinMax.Max) {
            minIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m565getMaxWidthimpl(j));
        } else {
            minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m565getMaxWidthimpl(j));
        }
        final int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        return new Placeable(m565getMaxWidthimpl, minIntrinsicHeight) { // from class: androidx.compose.ui.node.NodeMeasuringIntrinsics$EmptyPlaceable
            {
                m430setMeasuredSizeozmzZPI(IntSizeKt.IntSize(m565getMaxWidthimpl, minIntrinsicHeight));
            }

            @Override // androidx.compose.ui.layout.Measured
            public final int get(AlignmentLine alignmentLine) {
                Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
                return Integer.MIN_VALUE;
            }

            @Override // androidx.compose.ui.layout.Placeable
            /* renamed from: placeAt-f8xVGno */
            public final void mo422placeAtf8xVGno(long j2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            }
        };
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicHeight(int r2) {
        return this.measurable.minIntrinsicHeight(r2);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicWidth(int r2) {
        return this.measurable.minIntrinsicWidth(r2);
    }
}
