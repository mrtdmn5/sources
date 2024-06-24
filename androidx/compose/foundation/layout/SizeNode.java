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
public final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    public boolean enforceIncoming;
    public float maxHeight;
    public float maxWidth;
    public float minHeight;
    public float minWidth;

    public SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:            if (r5 != Integer.MAX_VALUE) goto L24;     */
    /* renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m96getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density r8) {
        /*
            r7 = this;
            float r0 = r7.maxWidth
            r1 = 2143289344(0x7fc00000, float:NaN)
            boolean r0 = androidx.compose.ui.unit.Dp.m579equalsimpl0(r0, r1)
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            if (r0 != 0) goto L18
            float r0 = r7.maxWidth
            int r0 = r8.mo44roundToPx0680j_4(r0)
            if (r0 >= 0) goto L19
            r0 = r3
            goto L19
        L18:
            r0 = r2
        L19:
            float r4 = r7.maxHeight
            boolean r4 = androidx.compose.ui.unit.Dp.m579equalsimpl0(r4, r1)
            if (r4 != 0) goto L2b
            float r4 = r7.maxHeight
            int r4 = r8.mo44roundToPx0680j_4(r4)
            if (r4 >= 0) goto L2c
            r4 = r3
            goto L2c
        L2b:
            r4 = r2
        L2c:
            float r5 = r7.minWidth
            boolean r5 = androidx.compose.ui.unit.Dp.m579equalsimpl0(r5, r1)
            if (r5 != 0) goto L43
            float r5 = r7.minWidth
            int r5 = r8.mo44roundToPx0680j_4(r5)
            if (r5 <= r0) goto L3d
            r5 = r0
        L3d:
            if (r5 >= 0) goto L40
            r5 = r3
        L40:
            if (r5 == r2) goto L43
            goto L44
        L43:
            r5 = r3
        L44:
            float r6 = r7.minHeight
            boolean r1 = androidx.compose.ui.unit.Dp.m579equalsimpl0(r6, r1)
            if (r1 != 0) goto L5b
            float r1 = r7.minHeight
            int r8 = r8.mo44roundToPx0680j_4(r1)
            if (r8 <= r4) goto L55
            r8 = r4
        L55:
            if (r8 >= 0) goto L58
            r8 = r3
        L58:
            if (r8 == r2) goto L5b
            r3 = r8
        L5b:
            long r0 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r5, r0, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeNode.m96getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density):long");
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        long m96getTargetConstraintsOenEA2s = m96getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m562getHasFixedHeightimpl(m96getTargetConstraintsOenEA2s)) {
            return Constraints.m564getMaxHeightimpl(m96getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m575constrainHeightK40F9xA(intrinsicMeasurable.maxIntrinsicHeight(r5), m96getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        long m96getTargetConstraintsOenEA2s = m96getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m563getHasFixedWidthimpl(m96getTargetConstraintsOenEA2s)) {
            return Constraints.m565getMaxWidthimpl(m96getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m576constrainWidthK40F9xA(intrinsicMeasurable.maxIntrinsicWidth(r5), m96getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int m567getMinWidthimpl;
        int m565getMaxWidthimpl;
        int m566getMinHeightimpl;
        int m564getMaxHeightimpl;
        long Constraints;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        long m96getTargetConstraintsOenEA2s = m96getTargetConstraintsOenEA2s(measure);
        if (this.enforceIncoming) {
            Constraints = ConstraintsKt.m574constrainN9IONVI(j, m96getTargetConstraintsOenEA2s);
        } else {
            if (!Dp.m579equalsimpl0(this.minWidth, Float.NaN)) {
                m567getMinWidthimpl = Constraints.m567getMinWidthimpl(m96getTargetConstraintsOenEA2s);
            } else {
                m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
                int m565getMaxWidthimpl2 = Constraints.m565getMaxWidthimpl(m96getTargetConstraintsOenEA2s);
                if (m567getMinWidthimpl > m565getMaxWidthimpl2) {
                    m567getMinWidthimpl = m565getMaxWidthimpl2;
                }
            }
            if (!Dp.m579equalsimpl0(this.maxWidth, Float.NaN)) {
                m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(m96getTargetConstraintsOenEA2s);
            } else {
                m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
                int m567getMinWidthimpl2 = Constraints.m567getMinWidthimpl(m96getTargetConstraintsOenEA2s);
                if (m565getMaxWidthimpl < m567getMinWidthimpl2) {
                    m565getMaxWidthimpl = m567getMinWidthimpl2;
                }
            }
            if (!Dp.m579equalsimpl0(this.minHeight, Float.NaN)) {
                m566getMinHeightimpl = Constraints.m566getMinHeightimpl(m96getTargetConstraintsOenEA2s);
            } else {
                m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
                int m564getMaxHeightimpl2 = Constraints.m564getMaxHeightimpl(m96getTargetConstraintsOenEA2s);
                if (m566getMinHeightimpl > m564getMaxHeightimpl2) {
                    m566getMinHeightimpl = m564getMaxHeightimpl2;
                }
            }
            if (!Dp.m579equalsimpl0(this.maxHeight, Float.NaN)) {
                m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(m96getTargetConstraintsOenEA2s);
            } else {
                m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
                int m566getMinHeightimpl2 = Constraints.m566getMinHeightimpl(m96getTargetConstraintsOenEA2s);
                if (m564getMaxHeightimpl < m566getMinHeightimpl2) {
                    m564getMaxHeightimpl = m566getMinHeightimpl2;
                }
            }
            Constraints = ConstraintsKt.Constraints(m567getMinWidthimpl, m565getMaxWidthimpl, m566getMinHeightimpl, m564getMaxHeightimpl);
        }
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(Constraints);
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        long m96getTargetConstraintsOenEA2s = m96getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m562getHasFixedHeightimpl(m96getTargetConstraintsOenEA2s)) {
            return Constraints.m564getMaxHeightimpl(m96getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m575constrainHeightK40F9xA(intrinsicMeasurable.minIntrinsicHeight(r5), m96getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        long m96getTargetConstraintsOenEA2s = m96getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m563getHasFixedWidthimpl(m96getTargetConstraintsOenEA2s)) {
            return Constraints.m565getMaxWidthimpl(m96getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m576constrainWidthK40F9xA(intrinsicMeasurable.minIntrinsicWidth(r5), m96getTargetConstraintsOenEA2s);
    }
}
