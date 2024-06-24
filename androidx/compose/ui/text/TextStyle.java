package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
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
import androidx.compose.ui.unit.TextUnit;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: TextStyle.kt */
/* loaded from: classes.dex */
public final class TextStyle {
    public static final TextStyle Default = new TextStyle(0, 0, null, null, 0, 0, 16777215);
    public final ParagraphStyle paragraphStyle;
    public final PlatformTextStyle platformStyle;
    public final SpanStyle spanStyle;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextStyle(androidx.compose.ui.text.SpanStyle r4, androidx.compose.ui.text.ParagraphStyle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "spanStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.ui.text.PlatformSpanStyle r0 = r4.platformStyle
            androidx.compose.ui.text.PlatformParagraphStyle r1 = r5.platformStyle
            if (r0 != 0) goto L10
            if (r1 != 0) goto L10
            r0 = 0
            goto L16
        L10:
            androidx.compose.ui.text.PlatformTextStyle r2 = new androidx.compose.ui.text.PlatformTextStyle
            r2.<init>(r0, r1)
            r0 = r2
        L16:
            r3.<init>(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.text.SpanStyle, androidx.compose.ui.text.ParagraphStyle):void");
    }

    /* renamed from: copy-v2rsoow$default */
    public static TextStyle m529copyv2rsoow$default(int r37, long j, long j2, long j3, PlatformTextStyle platformTextStyle, TextStyle textStyle, FontFamily fontFamily, FontWeight fontWeight) {
        long j4;
        long j5;
        FontWeight fontWeight2;
        FontStyle fontStyle;
        FontSynthesis fontSynthesis;
        FontFamily fontFamily2;
        String str;
        long j6;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long j7;
        TextDecoration textDecoration;
        Shadow shadow;
        DrawStyle drawStyle;
        TextAlign textAlign;
        TextDirection textDirection;
        long j8;
        TextIndent textIndent;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle;
        LineBreak lineBreak;
        Hyphens hyphens;
        TextMotion textMotion;
        boolean z;
        TextForegroundStyle textForegroundStyle;
        PlatformSpanStyle platformSpanStyle;
        PlatformParagraphStyle platformParagraphStyle;
        if ((r37 & 1) != 0) {
            j4 = textStyle.spanStyle.m516getColor0d7_KjU();
        } else {
            j4 = j;
        }
        if ((r37 & 2) != 0) {
            j5 = textStyle.spanStyle.fontSize;
        } else {
            j5 = j2;
        }
        if ((r37 & 4) != 0) {
            fontWeight2 = textStyle.spanStyle.fontWeight;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((r37 & 8) != 0) {
            fontStyle = textStyle.spanStyle.fontStyle;
        } else {
            fontStyle = null;
        }
        if ((r37 & 16) != 0) {
            fontSynthesis = textStyle.spanStyle.fontSynthesis;
        } else {
            fontSynthesis = null;
        }
        if ((r37 & 32) != 0) {
            fontFamily2 = textStyle.spanStyle.fontFamily;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((r37 & 64) != 0) {
            str = textStyle.spanStyle.fontFeatureSettings;
        } else {
            str = null;
        }
        if ((r37 & 128) != 0) {
            j6 = textStyle.spanStyle.letterSpacing;
        } else {
            j6 = j3;
        }
        if ((r37 & 256) != 0) {
            baselineShift = textStyle.spanStyle.baselineShift;
        } else {
            baselineShift = null;
        }
        if ((r37 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            textGeometricTransform = textStyle.spanStyle.textGeometricTransform;
        } else {
            textGeometricTransform = null;
        }
        if ((r37 & 1024) != 0) {
            localeList = textStyle.spanStyle.localeList;
        } else {
            localeList = null;
        }
        if ((r37 & 2048) != 0) {
            j7 = textStyle.spanStyle.background;
        } else {
            j7 = 0;
        }
        if ((r37 & 4096) != 0) {
            textDecoration = textStyle.spanStyle.textDecoration;
        } else {
            textDecoration = null;
        }
        if ((r37 & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
            shadow = textStyle.spanStyle.shadow;
        } else {
            shadow = null;
        }
        if ((r37 & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
            drawStyle = textStyle.spanStyle.drawStyle;
        } else {
            drawStyle = null;
        }
        if ((32768 & r37) != 0) {
            textAlign = textStyle.paragraphStyle.textAlign;
        } else {
            textAlign = null;
        }
        if ((65536 & r37) != 0) {
            textDirection = textStyle.paragraphStyle.textDirection;
        } else {
            textDirection = null;
        }
        if ((131072 & r37) != 0) {
            j8 = textStyle.paragraphStyle.lineHeight;
        } else {
            j8 = 0;
        }
        if ((262144 & r37) != 0) {
            textIndent = textStyle.paragraphStyle.textIndent;
        } else {
            textIndent = null;
        }
        if ((524288 & r37) != 0) {
            platformTextStyle2 = textStyle.platformStyle;
        } else {
            platformTextStyle2 = platformTextStyle;
        }
        if ((1048576 & r37) != 0) {
            lineHeightStyle = textStyle.paragraphStyle.lineHeightStyle;
        } else {
            lineHeightStyle = null;
        }
        if ((2097152 & r37) != 0) {
            lineBreak = textStyle.paragraphStyle.lineBreak;
        } else {
            lineBreak = null;
        }
        if ((4194304 & r37) != 0) {
            hyphens = textStyle.paragraphStyle.hyphens;
        } else {
            hyphens = null;
        }
        if ((r37 & 8388608) != 0) {
            textMotion = textStyle.paragraphStyle.textMotion;
        } else {
            textMotion = null;
        }
        SpanStyle spanStyle = textStyle.spanStyle;
        if (Color.m317equalsimpl0(j4, spanStyle.m516getColor0d7_KjU())) {
            textForegroundStyle = spanStyle.textForegroundStyle;
        } else {
            if (j4 != Color.Unspecified) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                textForegroundStyle = new ColorStyle(j4);
            } else {
                textForegroundStyle = TextForegroundStyle.Unspecified.INSTANCE;
            }
        }
        TextForegroundStyle textForegroundStyle2 = textForegroundStyle;
        if (platformTextStyle2 != null) {
            platformSpanStyle = platformTextStyle2.spanStyle;
        } else {
            platformSpanStyle = null;
        }
        SpanStyle spanStyle2 = new SpanStyle(textForegroundStyle2, j5, fontWeight2, fontStyle, fontSynthesis, fontFamily2, str, j6, baselineShift, textGeometricTransform, localeList, j7, textDecoration, shadow, platformSpanStyle, drawStyle);
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle2.paragraphStyle;
        } else {
            platformParagraphStyle = null;
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, j8, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion), platformTextStyle2);
    }

    /* renamed from: merge-Z1GrekI$default */
    public static TextStyle m530mergeZ1GrekI$default(long j, long j2, long j3, TextStyle textStyle, FontFamily fontFamily, FontStyle fontStyle, FontWeight fontWeight, TextAlign textAlign, TextDecoration textDecoration) {
        long j4 = Color.Unspecified;
        SpanStyle m517fastMergedSHsh3o = SpanStyleKt.m517fastMergedSHsh3o(textStyle.spanStyle, j4, null, Float.NaN, j, fontWeight, fontStyle, null, fontFamily, null, j2, null, null, null, j4, textDecoration, null, null, null);
        ParagraphStyle m515fastMergeHtYhynw = ParagraphStyleKt.m515fastMergeHtYhynw(textStyle.paragraphStyle, textAlign, null, j3, null, null, null, null, null, null);
        if (textStyle.spanStyle == m517fastMergedSHsh3o && textStyle.paragraphStyle == m515fastMergeHtYhynw) {
            return textStyle;
        }
        return new TextStyle(m517fastMergedSHsh3o, m515fastMergeHtYhynw);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        if (Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle)) {
            return true;
        }
        return false;
    }

    /* renamed from: getColor-0d7_KjU */
    public final long m531getColor0d7_KjU() {
        return this.spanStyle.m516getColor0d7_KjU();
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this != other && (!Intrinsics.areEqual(this.paragraphStyle, other.paragraphStyle) || !this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(other.spanStyle))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int r0;
        int hashCode = (this.paragraphStyle.hashCode() + (this.spanStyle.hashCode() * 31)) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        if (platformTextStyle != null) {
            r0 = platformTextStyle.hashCode();
        } else {
            r0 = 0;
        }
        return hashCode + r0;
    }

    public final TextStyle merge(TextStyle textStyle) {
        if (textStyle != null && !Intrinsics.areEqual(textStyle, Default)) {
            return new TextStyle(this.spanStyle.merge(textStyle.spanStyle), this.paragraphStyle.merge(textStyle.paragraphStyle));
        }
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextStyle(color=");
        sb.append((Object) Color.m323toStringimpl(m531getColor0d7_KjU()));
        sb.append(", brush=");
        SpanStyle spanStyle = this.spanStyle;
        sb.append(spanStyle.getBrush());
        sb.append(", alpha=");
        sb.append(spanStyle.textForegroundStyle.getAlpha());
        sb.append(", fontSize=");
        sb.append((Object) TextUnit.m599toStringimpl(spanStyle.fontSize));
        sb.append(", fontWeight=");
        sb.append(spanStyle.fontWeight);
        sb.append(", fontStyle=");
        sb.append(spanStyle.fontStyle);
        sb.append(", fontSynthesis=");
        sb.append(spanStyle.fontSynthesis);
        sb.append(", fontFamily=");
        sb.append(spanStyle.fontFamily);
        sb.append(", fontFeatureSettings=");
        sb.append(spanStyle.fontFeatureSettings);
        sb.append(", letterSpacing=");
        sb.append((Object) TextUnit.m599toStringimpl(spanStyle.letterSpacing));
        sb.append(", baselineShift=");
        sb.append(spanStyle.baselineShift);
        sb.append(", textGeometricTransform=");
        sb.append(spanStyle.textGeometricTransform);
        sb.append(", localeList=");
        sb.append(spanStyle.localeList);
        sb.append(", background=");
        sb.append((Object) Color.m323toStringimpl(spanStyle.background));
        sb.append(", textDecoration=");
        sb.append(spanStyle.textDecoration);
        sb.append(", shadow=");
        sb.append(spanStyle.shadow);
        sb.append(", drawStyle=");
        sb.append(spanStyle.drawStyle);
        sb.append(", textAlign=");
        ParagraphStyle paragraphStyle = this.paragraphStyle;
        sb.append(paragraphStyle.textAlign);
        sb.append(", textDirection=");
        sb.append(paragraphStyle.textDirection);
        sb.append(", lineHeight=");
        sb.append((Object) TextUnit.m599toStringimpl(paragraphStyle.lineHeight));
        sb.append(", textIndent=");
        sb.append(paragraphStyle.textIndent);
        sb.append(", platformStyle=");
        sb.append(this.platformStyle);
        sb.append(", lineHeightStyle=");
        sb.append(paragraphStyle.lineHeightStyle);
        sb.append(", lineBreak=");
        sb.append(paragraphStyle.lineBreak);
        sb.append(", hyphens=");
        sb.append(paragraphStyle.hyphens);
        sb.append(", textMotion=");
        sb.append(paragraphStyle.textMotion);
        sb.append(')');
        return sb.toString();
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    public TextStyle(long j, long j2, FontWeight fontWeight, String str, long j3, long j4, int r43) {
        this(new SpanStyle((r43 & 1) != 0 ? Color.Unspecified : j, (r43 & 2) != 0 ? TextUnit.Unspecified : j2, (r43 & 4) != 0 ? null : fontWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (r43 & 64) != 0 ? null : str, (r43 & 128) != 0 ? TextUnit.Unspecified : j3, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, (r43 & 2048) != 0 ? Color.Unspecified : 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null), new ParagraphStyle(null, null, (r43 & 131072) != 0 ? TextUnit.Unspecified : j4, null, null, null, null, null, null), null);
    }
}
