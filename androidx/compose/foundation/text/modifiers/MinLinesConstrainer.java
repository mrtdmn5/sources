package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: MinLinesConstrainer.kt */
/* loaded from: classes.dex */
public final class MinLinesConstrainer {
    public static MinLinesConstrainer last;
    public final Density density;
    public final FontFamily.Resolver fontFamilyResolver;
    public final TextStyle inputTextStyle;
    public final LayoutDirection layoutDirection;
    public float lineHeightCache = Float.NaN;
    public float oneLineHeightCache = Float.NaN;
    public final TextStyle resolvedStyle;

    /* compiled from: MinLinesConstrainer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static MinLinesConstrainer from(MinLinesConstrainer minLinesConstrainer, LayoutDirection layoutDirection, TextStyle paramStyle, Density density, FontFamily.Resolver fontFamilyResolver) {
            boolean z;
            Intrinsics.checkNotNullParameter(paramStyle, "paramStyle");
            Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
            boolean z2 = true;
            if (minLinesConstrainer != null && layoutDirection == minLinesConstrainer.layoutDirection && Intrinsics.areEqual(paramStyle, minLinesConstrainer.inputTextStyle)) {
                if (density.getDensity() == minLinesConstrainer.density.getDensity()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && fontFamilyResolver == minLinesConstrainer.fontFamilyResolver) {
                    return minLinesConstrainer;
                }
            }
            MinLinesConstrainer minLinesConstrainer2 = MinLinesConstrainer.last;
            if (minLinesConstrainer2 != null && layoutDirection == minLinesConstrainer2.layoutDirection && Intrinsics.areEqual(paramStyle, minLinesConstrainer2.inputTextStyle)) {
                if (density.getDensity() != minLinesConstrainer2.density.getDensity()) {
                    z2 = false;
                }
                if (z2 && fontFamilyResolver == minLinesConstrainer2.fontFamilyResolver) {
                    return minLinesConstrainer2;
                }
            }
            MinLinesConstrainer minLinesConstrainer3 = new MinLinesConstrainer(layoutDirection, TextStyleKt.resolveDefaults(paramStyle, layoutDirection), density, fontFamilyResolver);
            MinLinesConstrainer.last = minLinesConstrainer3;
            return minLinesConstrainer3;
        }
    }

    public MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle, Density density, FontFamily.Resolver resolver) {
        this.layoutDirection = layoutDirection;
        this.inputTextStyle = textStyle;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.resolvedStyle = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
    }

    /* renamed from: coerceMinLines-Oh53vG4$foundation_release, reason: not valid java name */
    public final long m125coerceMinLinesOh53vG4$foundation_release(int r17, long j) {
        float f = this.oneLineHeightCache;
        float f2 = this.lineHeightCache;
        int r5 = 0;
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            float height = ParagraphKt.m514ParagraphUdtVg6A$default(MinLinesConstrainerKt.EmptyTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 15), this.density, this.fontFamilyResolver, null, 1, 96).getHeight();
            float height2 = ParagraphKt.m514ParagraphUdtVg6A$default(MinLinesConstrainerKt.TwoLineTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 15), this.density, this.fontFamilyResolver, null, 2, 96).getHeight() - height;
            this.oneLineHeightCache = height;
            this.lineHeightCache = height2;
            f2 = height2;
            f = height;
        }
        if (r17 != 1) {
            int roundToInt = MathKt__MathJVMKt.roundToInt((f2 * (r17 - 1)) + f);
            if (roundToInt >= 0) {
                r5 = roundToInt;
            }
            int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
            if (r5 > m564getMaxHeightimpl) {
                r5 = m564getMaxHeightimpl;
            }
        } else {
            r5 = Constraints.m566getMinHeightimpl(j);
        }
        return ConstraintsKt.Constraints(Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j), r5, Constraints.m564getMaxHeightimpl(j));
    }
}
