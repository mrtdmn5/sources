package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextStyle.kt */
/* loaded from: classes.dex */
public final class TextStyleKt {

    /* compiled from: TextStyle.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            try {
                r0[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final TextStyle resolveDefaults(TextStyle style, LayoutDirection direction) {
        int r6;
        int r7;
        float f;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(direction, "direction");
        int r4 = SpanStyleKt.$r8$clinit;
        SpanStyle style2 = style.spanStyle;
        Intrinsics.checkNotNullParameter(style2, "style");
        TextForegroundStyle takeOrElse = style2.textForegroundStyle.takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1
            @Override // kotlin.jvm.functions.Function0
            public final TextForegroundStyle invoke() {
                boolean z3;
                long j = SpanStyleKt.DefaultColor;
                if (j != Color.Unspecified) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return new ColorStyle(j);
                }
                return TextForegroundStyle.Unspecified.INSTANCE;
            }
        });
        long j = style2.fontSize;
        if (TextUnitKt.m600isUnspecifiedR2X_6o(j)) {
            j = SpanStyleKt.DefaultFontSize;
        }
        long j2 = j;
        FontWeight fontWeight = style2.fontWeight;
        if (fontWeight == null) {
            fontWeight = FontWeight.Normal;
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = style2.fontStyle;
        if (fontStyle != null) {
            r6 = fontStyle.value;
        } else {
            r6 = 0;
        }
        FontStyle fontStyle2 = new FontStyle(r6);
        FontSynthesis fontSynthesis = style2.fontSynthesis;
        if (fontSynthesis != null) {
            r7 = fontSynthesis.value;
        } else {
            r7 = 1;
        }
        FontSynthesis fontSynthesis2 = new FontSynthesis(r7);
        FontFamily fontFamily = style2.fontFamily;
        if (fontFamily == null) {
            fontFamily = FontFamily.Default;
        }
        FontFamily fontFamily2 = fontFamily;
        String str = style2.fontFeatureSettings;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        long j3 = style2.letterSpacing;
        if (TextUnitKt.m600isUnspecifiedR2X_6o(j3)) {
            j3 = SpanStyleKt.DefaultLetterSpacing;
        }
        long j4 = j3;
        BaselineShift baselineShift = style2.baselineShift;
        if (baselineShift != null) {
            f = baselineShift.multiplier;
        } else {
            f = 0.0f;
        }
        BaselineShift baselineShift2 = new BaselineShift(f);
        TextGeometricTransform textGeometricTransform = style2.textGeometricTransform;
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.None;
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = style2.localeList;
        if (localeList == null) {
            localeList = PlatformLocaleKt.platformLocaleDelegate.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long j5 = Color.Unspecified;
        long j6 = style2.background;
        if (j6 != j5) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            j6 = SpanStyleKt.DefaultBackgroundColor;
        }
        long j7 = j6;
        TextDecoration textDecoration = style2.textDecoration;
        if (textDecoration == null) {
            textDecoration = TextDecoration.None;
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = style2.shadow;
        if (shadow == null) {
            shadow = Shadow.None;
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformSpanStyle = style2.platformStyle;
        DrawStyle drawStyle = style2.drawStyle;
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        SpanStyle spanStyle = new SpanStyle(takeOrElse, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j4, baselineShift2, textGeometricTransform2, localeList2, j7, textDecoration2, shadow2, platformSpanStyle, drawStyle);
        int r2 = ParagraphStyleKt.$r8$clinit;
        ParagraphStyle style3 = style.paragraphStyle;
        Intrinsics.checkNotNullParameter(style3, "style");
        TextAlign textAlign = new TextAlign(style3.textAlignOrDefault);
        TextDirection textDirection = style3.textDirection;
        if (textDirection != null && textDirection.value == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        int r62 = 2;
        if (z2) {
            int r42 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
            if (r42 != 1) {
                if (r42 == 2) {
                    r62 = 5;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                r62 = 4;
            }
        } else if (textDirection == null) {
            int r43 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
            if (r43 != 1) {
                if (r43 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                r62 = 1;
            }
        } else {
            r62 = textDirection.value;
        }
        TextDirection textDirection2 = new TextDirection(r62);
        long j8 = style3.lineHeight;
        if (TextUnitKt.m600isUnspecifiedR2X_6o(j8)) {
            j8 = ParagraphStyleKt.DefaultLineHeight;
        }
        TextIndent textIndent = style3.textIndent;
        if (textIndent == null) {
            textIndent = TextIndent.None;
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformParagraphStyle = style3.platformStyle;
        LineHeightStyle lineHeightStyle = style3.lineHeightStyle;
        LineBreak lineBreak = new LineBreak(style3.lineBreakOrDefault);
        Hyphens hyphens = new Hyphens(style3.hyphensOrDefault);
        TextMotion textMotion = style3.textMotion;
        if (textMotion == null) {
            textMotion = TextMotion.Static;
        }
        return new TextStyle(spanStyle, new ParagraphStyle(textAlign, textDirection2, j8, textIndent2, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion), style.platformStyle);
    }
}
