package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public final class AlignmentLineOffsetDpNode extends Modifier.Node implements LayoutModifierNode {
    public float after;
    public AlignmentLine alignmentLine;
    public float before;

    public AlignmentLineOffsetDpNode(AlignmentLine alignmentLine, float f, float f2) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        this.alignmentLine = alignmentLine;
        this.before = f;
        this.after = f2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        long m558copyZbe2FdA$default;
        int r7;
        int m565getMaxWidthimpl;
        int r12;
        int r2;
        int max;
        int r3;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final AlignmentLine alignmentLine = this.alignmentLine;
        final float f = this.before;
        float f2 = this.after;
        boolean z = alignmentLine instanceof HorizontalAlignmentLine;
        if (z) {
            m558copyZbe2FdA$default = Constraints.m558copyZbe2FdA$default(j, 0, 0, 0, 0, 11);
        } else {
            m558copyZbe2FdA$default = Constraints.m558copyZbe2FdA$default(j, 0, 0, 0, 0, 14);
        }
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(m558copyZbe2FdA$default);
        int r6 = mo421measureBRTryo0.get(alignmentLine);
        if (r6 == Integer.MIN_VALUE) {
            r6 = 0;
        }
        if (z) {
            r7 = mo421measureBRTryo0.height;
        } else {
            r7 = mo421measureBRTryo0.width;
        }
        if (z) {
            m565getMaxWidthimpl = Constraints.m564getMaxHeightimpl(j);
        } else {
            m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        }
        if (!Dp.m579equalsimpl0(f, Float.NaN)) {
            r12 = measure.mo44roundToPx0680j_4(f);
        } else {
            r12 = 0;
        }
        int r10 = m565getMaxWidthimpl - r7;
        final int coerceIn = RangesKt___RangesKt.coerceIn(r12 - r6, 0, r10);
        if (!Dp.m579equalsimpl0(f2, Float.NaN)) {
            r2 = measure.mo44roundToPx0680j_4(f2);
        } else {
            r2 = 0;
        }
        final int coerceIn2 = RangesKt___RangesKt.coerceIn((r2 - r7) + r6, 0, r10 - coerceIn);
        if (z) {
            max = mo421measureBRTryo0.width;
        } else {
            max = Math.max(mo421measureBRTryo0.width + coerceIn + coerceIn2, Constraints.m567getMinWidthimpl(j));
        }
        if (z) {
            r3 = Math.max(mo421measureBRTryo0.height + coerceIn + coerceIn2, Constraints.m566getMinHeightimpl(j));
        } else {
            r3 = mo421measureBRTryo0.height;
        }
        final int r11 = r3;
        final int r72 = max;
        return measure.layout(max, r11, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                int r73;
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                boolean z2 = AlignmentLine.this instanceof HorizontalAlignmentLine;
                int r1 = coerceIn;
                Placeable placeable = mo421measureBRTryo0;
                int r32 = coerceIn2;
                float f3 = f;
                if (z2) {
                    r73 = 0;
                } else if (!Dp.m579equalsimpl0(f3, Float.NaN)) {
                    r73 = r1;
                } else {
                    r73 = (r72 - r32) - placeable.width;
                }
                if (!z2) {
                    r1 = 0;
                } else if (Dp.m579equalsimpl0(f3, Float.NaN)) {
                    r1 = (r11 - r32) - placeable.height;
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable, r73, r1);
                return Unit.INSTANCE;
            }
        });
    }
}
