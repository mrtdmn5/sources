package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: AspectRatio.kt */
/* loaded from: classes.dex */
public final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    public float aspectRatio;
    public boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (r4 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(r4 / this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(r4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (r4 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(r4 * this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(r4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:            if (androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, 0) == false) goto L53;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00c4, code lost:            r5 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:            if (androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, 0) == false) goto L53;     */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.layout.MeasureResult mo31measure3p2s80s(androidx.compose.ui.layout.MeasureScope r8, androidx.compose.ui.layout.Measurable r9, long r10) {
        /*
            r7 = this;
            java.lang.String r0 = "$this$measure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r7.matchHeightConstraintsFirst
            r1 = 0
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L6c
            long r5 = r7.m63tryMaxWidthJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L19
            goto Lc5
        L19:
            long r5 = r7.m62tryMaxHeightJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L25
            goto Lc5
        L25:
            long r5 = r7.m65tryMinWidthJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L31
            goto Lc5
        L31:
            long r5 = r7.m64tryMinHeightJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L3d
            goto Lc5
        L3d:
            long r5 = r7.m63tryMaxWidthJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L49
            goto Lc5
        L49:
            long r5 = r7.m62tryMaxHeightJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L55
            goto Lc5
        L55:
            long r5 = r7.m65tryMinWidthJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L61
            goto Lc5
        L61:
            long r5 = r7.m64tryMinHeightJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto Lc4
            goto Lc5
        L6c:
            long r5 = r7.m62tryMaxHeightJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L77
            goto Lc5
        L77:
            long r5 = r7.m63tryMaxWidthJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L82
            goto Lc5
        L82:
            long r5 = r7.m64tryMinHeightJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L8d
            goto Lc5
        L8d:
            long r5 = r7.m65tryMinWidthJN0ABg(r10, r4)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto L98
            goto Lc5
        L98:
            long r5 = r7.m62tryMaxHeightJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto La3
            goto Lc5
        La3:
            long r5 = r7.m63tryMaxWidthJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto Lae
            goto Lc5
        Lae:
            long r5 = r7.m64tryMinHeightJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto Lb9
            goto Lc5
        Lb9:
            long r5 = r7.m65tryMinWidthJN0ABg(r10, r3)
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto Lc4
            goto Lc5
        Lc4:
            r5 = r1
        Lc5:
            boolean r0 = androidx.compose.ui.unit.IntSize.m592equalsimpl0(r5, r1)
            if (r0 != 0) goto Ld8
            r10 = 32
            long r10 = r5 >> r10
            int r10 = (int) r10
            int r11 = androidx.compose.ui.unit.IntSize.m593getHeightimpl(r5)
            long r10 = androidx.compose.ui.unit.Constraints.Companion.m570fixedJhjzzOo(r10, r11)
        Ld8:
            androidx.compose.ui.layout.Placeable r9 = r9.mo421measureBRTryo0(r10)
            int r10 = r9.width
            int r11 = r9.height
            androidx.compose.foundation.layout.AspectRatioNode$measure$1 r0 = new androidx.compose.foundation.layout.AspectRatioNode$measure$1
            r0.<init>()
            kotlin.collections.EmptyMap r9 = kotlin.collections.EmptyMap.INSTANCE
            androidx.compose.ui.layout.MeasureResult r8 = r8.layout(r10, r11, r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.AspectRatioNode.mo31measure3p2s80s(androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, long):androidx.compose.ui.layout.MeasureResult");
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (r4 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(r4 / this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicHeight(r4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (r4 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(r4 * this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicWidth(r4);
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    public final long m62tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
        if (m564getMaxHeightimpl != Integer.MAX_VALUE && (roundToInt = MathKt__MathJVMKt.roundToInt(m564getMaxHeightimpl * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m564getMaxHeightimpl);
            if (!z || ConstraintsKt.m577isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
            return 0L;
        }
        return 0L;
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    public final long m63tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        if (m565getMaxWidthimpl != Integer.MAX_VALUE && (roundToInt = MathKt__MathJVMKt.roundToInt(m565getMaxWidthimpl / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(m565getMaxWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m577isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
            return 0L;
        }
        return 0L;
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    public final long m64tryMinHeightJN0ABg(long j, boolean z) {
        int m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
        int roundToInt = MathKt__MathJVMKt.roundToInt(m566getMinHeightimpl * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m566getMinHeightimpl);
            if (!z || ConstraintsKt.m577isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
            return 0L;
        }
        return 0L;
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    public final long m65tryMinWidthJN0ABg(long j, boolean z) {
        int m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
        int roundToInt = MathKt__MathJVMKt.roundToInt(m567getMinWidthimpl / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(m567getMinWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m577isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
            return 0L;
        }
        return 0L;
    }
}
