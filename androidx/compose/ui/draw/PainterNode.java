package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: PainterModifier.kt */
/* loaded from: classes.dex */
public final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    public Alignment alignment;
    public float alpha;
    public ColorFilter colorFilter;
    public ContentScale contentScale;
    public Painter painter;
    public boolean sizeToIntrinsics;

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk */
    public static boolean m232hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        boolean z;
        if (Size.m273equalsimpl0(j, Size.Unspecified)) {
            return false;
        }
        float m274getHeightimpl = Size.m274getHeightimpl(j);
        if (!Float.isInfinite(m274getHeightimpl) && !Float.isNaN(m274getHeightimpl)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk */
    public static boolean m233hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        boolean z;
        if (Size.m273equalsimpl0(j, Size.Unspecified)) {
            return false;
        }
        float m276getWidthimpl = Size.m276getWidthimpl(j);
        if (!Float.isInfinite(m276getWidthimpl) && !Float.isNaN(m276getWidthimpl)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dc  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope r13) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draw.PainterNode.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }

    public final boolean getUseIntrinsicSize() {
        boolean z;
        if (!this.sizeToIntrinsics) {
            return false;
        }
        long mo392getIntrinsicSizeNHjbRc = this.painter.mo392getIntrinsicSizeNHjbRc();
        int r0 = Size.$r8$clinit;
        if (mo392getIntrinsicSizeNHjbRc != Size.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (getUseIntrinsicSize()) {
            long m234modifyConstraintsZezNO4M = m234modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(r5, 0, 13));
            return Math.max(Constraints.m566getMinHeightimpl(m234modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(r5));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(r5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (getUseIntrinsicSize()) {
            long m234modifyConstraintsZezNO4M = m234modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, r5, 7));
            return Math.max(Constraints.m567getMinWidthimpl(m234modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(r5));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(r5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(m234modifyConstraintsZezNO4M(j));
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
        if (getUseIntrinsicSize()) {
            long m234modifyConstraintsZezNO4M = m234modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(r5, 0, 13));
            return Math.max(Constraints.m566getMinHeightimpl(m234modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(r5));
        }
        return intrinsicMeasurable.minIntrinsicHeight(r5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        if (getUseIntrinsicSize()) {
            long m234modifyConstraintsZezNO4M = m234modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, r5, 7));
            return Math.max(Constraints.m567getMinWidthimpl(m234modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(r5));
        }
        return intrinsicMeasurable.minIntrinsicWidth(r5);
    }

    /* renamed from: modifyConstraints-ZezNO4M */
    public final long m234modifyConstraintsZezNO4M(long j) {
        boolean z;
        boolean z2;
        int m567getMinWidthimpl;
        int m566getMinHeightimpl;
        float m276getWidthimpl;
        float m274getHeightimpl;
        boolean z3;
        boolean z4 = true;
        if (Constraints.m561getHasBoundedWidthimpl(j) && Constraints.m560getHasBoundedHeightimpl(j)) {
            z = true;
        } else {
            z = false;
        }
        if (Constraints.m563getHasFixedWidthimpl(j) && Constraints.m562getHasFixedHeightimpl(j)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m558copyZbe2FdA$default(j, Constraints.m565getMaxWidthimpl(j), 0, Constraints.m564getMaxHeightimpl(j), 0, 10);
        }
        long mo392getIntrinsicSizeNHjbRc = this.painter.mo392getIntrinsicSizeNHjbRc();
        if (m233hasSpecifiedAndFiniteWidthuvyYCjk(mo392getIntrinsicSizeNHjbRc)) {
            m567getMinWidthimpl = MathKt__MathJVMKt.roundToInt(Size.m276getWidthimpl(mo392getIntrinsicSizeNHjbRc));
        } else {
            m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
        }
        if (m232hasSpecifiedAndFiniteHeightuvyYCjk(mo392getIntrinsicSizeNHjbRc)) {
            m566getMinHeightimpl = MathKt__MathJVMKt.roundToInt(Size.m274getHeightimpl(mo392getIntrinsicSizeNHjbRc));
        } else {
            m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
        }
        long Size = SizeKt.Size(ConstraintsKt.m576constrainWidthK40F9xA(m567getMinWidthimpl, j), ConstraintsKt.m575constrainHeightK40F9xA(m566getMinHeightimpl, j));
        if (getUseIntrinsicSize()) {
            if (!m233hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo392getIntrinsicSizeNHjbRc())) {
                m276getWidthimpl = Size.m276getWidthimpl(Size);
            } else {
                m276getWidthimpl = Size.m276getWidthimpl(this.painter.mo392getIntrinsicSizeNHjbRc());
            }
            if (!m232hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo392getIntrinsicSizeNHjbRc())) {
                m274getHeightimpl = Size.m274getHeightimpl(Size);
            } else {
                m274getHeightimpl = Size.m274getHeightimpl(this.painter.mo392getIntrinsicSizeNHjbRc());
            }
            long Size2 = SizeKt.Size(m276getWidthimpl, m274getHeightimpl);
            if (Size.m276getWidthimpl(Size) == 0.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                if (Size.m274getHeightimpl(Size) != 0.0f) {
                    z4 = false;
                }
                if (!z4) {
                    long mo420computeScaleFactorH7hwNQA = this.contentScale.mo420computeScaleFactorH7hwNQA(Size2, Size);
                    Size = SizeKt.Size(ScaleFactor.m437getScaleXimpl(mo420computeScaleFactorH7hwNQA) * Size.m276getWidthimpl(Size2), ScaleFactor.m438getScaleYimpl(mo420computeScaleFactorH7hwNQA) * Size.m274getHeightimpl(Size2));
                }
            }
            Size = Size.Zero;
        }
        return Constraints.m558copyZbe2FdA$default(j, ConstraintsKt.m576constrainWidthK40F9xA(MathKt__MathJVMKt.roundToInt(Size.m276getWidthimpl(Size)), j), 0, ConstraintsKt.m575constrainHeightK40F9xA(MathKt__MathJVMKt.roundToInt(Size.m274getHeightimpl(Size)), j), 0, 10);
    }

    public final String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
