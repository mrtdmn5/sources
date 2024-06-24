package androidx.compose.ui.text;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
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
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: SpanStyle.kt */
/* loaded from: classes.dex */
public final class SpanStyle {
    public final long background;
    public final BaselineShift baselineShift;
    public final DrawStyle drawStyle;
    public final FontFamily fontFamily;
    public final String fontFeatureSettings;
    public final long fontSize;
    public final FontStyle fontStyle;
    public final FontSynthesis fontSynthesis;
    public final FontWeight fontWeight;
    public final long letterSpacing;
    public final LocaleList localeList;
    public final PlatformSpanStyle platformStyle;
    public final Shadow shadow;
    public final TextDecoration textDecoration;
    public final TextForegroundStyle textForegroundStyle;
    public final TextGeometricTransform textGeometricTransform;

    public SpanStyle(TextForegroundStyle textForegroundStyle, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(textForegroundStyle, "textForegroundStyle");
        this.textForegroundStyle = textForegroundStyle;
        this.fontSize = j;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = str;
        this.letterSpacing = j2;
        this.baselineShift = baselineShift;
        this.textGeometricTransform = textGeometricTransform;
        this.localeList = localeList;
        this.background = j3;
        this.textDecoration = textDecoration;
        this.shadow = shadow;
        this.platformStyle = platformSpanStyle;
        this.drawStyle = drawStyle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        if (hasSameLayoutAffectingAttributes$ui_text_release(spanStyle) && hasSameNonLayoutAttributes$ui_text_release(spanStyle)) {
            return true;
        }
        return false;
    }

    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU */
    public final long m516getColor0d7_KjU() {
        return this.textForegroundStyle.mo553getColor0d7_KjU();
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(SpanStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this == other) {
            return true;
        }
        if (TextUnit.m596equalsimpl0(this.fontSize, other.fontSize) && Intrinsics.areEqual(this.fontWeight, other.fontWeight) && Intrinsics.areEqual(this.fontStyle, other.fontStyle) && Intrinsics.areEqual(this.fontSynthesis, other.fontSynthesis) && Intrinsics.areEqual(this.fontFamily, other.fontFamily) && Intrinsics.areEqual(this.fontFeatureSettings, other.fontFeatureSettings) && TextUnit.m596equalsimpl0(this.letterSpacing, other.letterSpacing) && Intrinsics.areEqual(this.baselineShift, other.baselineShift) && Intrinsics.areEqual(this.textGeometricTransform, other.textGeometricTransform) && Intrinsics.areEqual(this.localeList, other.localeList) && Color.m317equalsimpl0(this.background, other.background) && Intrinsics.areEqual(this.platformStyle, other.platformStyle)) {
            return true;
        }
        return false;
    }

    public final boolean hasSameNonLayoutAttributes$ui_text_release(SpanStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(this.textForegroundStyle, other.textForegroundStyle) || !Intrinsics.areEqual(this.textDecoration, other.textDecoration) || !Intrinsics.areEqual(this.shadow, other.shadow) || !Intrinsics.areEqual(this.drawStyle, other.drawStyle)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int r1;
        int r12;
        int r13;
        int r14;
        int r15;
        int r16;
        int r17;
        int r18;
        int r19;
        int r110;
        int r111;
        int r112;
        long m516getColor0d7_KjU = m516getColor0d7_KjU();
        int r2 = Color.$r8$clinit;
        int hashCode = Long.hashCode(m516getColor0d7_KjU) * 31;
        Brush brush = getBrush();
        int r22 = 0;
        if (brush != null) {
            r1 = brush.hashCode();
        } else {
            r1 = 0;
        }
        int hashCode2 = (Float.hashCode(this.textForegroundStyle.getAlpha()) + ((hashCode + r1) * 31)) * 31;
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        int m = Scale$$ExternalSyntheticOutline0.m(this.fontSize, hashCode2, 31);
        FontWeight fontWeight = this.fontWeight;
        if (fontWeight != null) {
            r12 = fontWeight.weight;
        } else {
            r12 = 0;
        }
        int r0 = (m + r12) * 31;
        FontStyle fontStyle = this.fontStyle;
        if (fontStyle != null) {
            r13 = Integer.hashCode(fontStyle.value);
        } else {
            r13 = 0;
        }
        int r02 = (r0 + r13) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        if (fontSynthesis != null) {
            r14 = Integer.hashCode(fontSynthesis.value);
        } else {
            r14 = 0;
        }
        int r03 = (r02 + r14) * 31;
        FontFamily fontFamily = this.fontFamily;
        if (fontFamily != null) {
            r15 = fontFamily.hashCode();
        } else {
            r15 = 0;
        }
        int r04 = (r03 + r15) * 31;
        String str = this.fontFeatureSettings;
        if (str != null) {
            r16 = str.hashCode();
        } else {
            r16 = 0;
        }
        int m2 = Scale$$ExternalSyntheticOutline0.m(this.letterSpacing, (r04 + r16) * 31, 31);
        BaselineShift baselineShift = this.baselineShift;
        if (baselineShift != null) {
            r17 = Float.hashCode(baselineShift.multiplier);
        } else {
            r17 = 0;
        }
        int r05 = (m2 + r17) * 31;
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        if (textGeometricTransform != null) {
            r18 = textGeometricTransform.hashCode();
        } else {
            r18 = 0;
        }
        int r06 = (r05 + r18) * 31;
        LocaleList localeList = this.localeList;
        if (localeList != null) {
            r19 = localeList.hashCode();
        } else {
            r19 = 0;
        }
        int m3 = Scale$$ExternalSyntheticOutline0.m(this.background, (r06 + r19) * 31, 31);
        TextDecoration textDecoration = this.textDecoration;
        if (textDecoration != null) {
            r110 = textDecoration.mask;
        } else {
            r110 = 0;
        }
        int r07 = (m3 + r110) * 31;
        Shadow shadow = this.shadow;
        if (shadow != null) {
            r111 = shadow.hashCode();
        } else {
            r111 = 0;
        }
        int r08 = (r07 + r111) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        if (platformSpanStyle != null) {
            r112 = platformSpanStyle.hashCode();
        } else {
            r112 = 0;
        }
        int r09 = (r08 + r112) * 31;
        DrawStyle drawStyle = this.drawStyle;
        if (drawStyle != null) {
            r22 = drawStyle.hashCode();
        }
        return r09 + r22;
    }

    public final SpanStyle merge(SpanStyle spanStyle) {
        if (spanStyle == null) {
            return this;
        }
        TextForegroundStyle textForegroundStyle = spanStyle.textForegroundStyle;
        return SpanStyleKt.m517fastMergedSHsh3o(this, textForegroundStyle.mo553getColor0d7_KjU(), textForegroundStyle.getBrush(), textForegroundStyle.getAlpha(), spanStyle.fontSize, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, spanStyle.fontFamily, spanStyle.fontFeatureSettings, spanStyle.letterSpacing, spanStyle.baselineShift, spanStyle.textGeometricTransform, spanStyle.localeList, spanStyle.background, spanStyle.textDecoration, spanStyle.shadow, spanStyle.platformStyle, spanStyle.drawStyle);
    }

    public final String toString() {
        return "SpanStyle(color=" + ((Object) Color.m323toStringimpl(m516getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + this.textForegroundStyle.getAlpha() + ", fontSize=" + ((Object) TextUnit.m599toStringimpl(this.fontSize)) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + ((Object) TextUnit.m599toStringimpl(this.letterSpacing)) + ", baselineShift=" + this.baselineShift + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + ((Object) Color.m323toStringimpl(this.background)) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", platformStyle=" + this.platformStyle + ", drawStyle=" + this.drawStyle + ')';
    }

    public SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, int r43) {
        this((r43 & 1) != 0 ? Color.Unspecified : j, (r43 & 2) != 0 ? TextUnit.Unspecified : j2, (r43 & 4) != 0 ? null : fontWeight, (r43 & 8) != 0 ? null : fontStyle, (r43 & 16) != 0 ? null : fontSynthesis, (r43 & 32) != 0 ? null : fontFamily, (r43 & 64) != 0 ? null : str, (r43 & 128) != 0 ? TextUnit.Unspecified : j3, (r43 & 256) != 0 ? null : baselineShift, (r43 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? null : textGeometricTransform, (r43 & 1024) != 0 ? null : localeList, (r43 & 2048) != 0 ? Color.Unspecified : j4, (r43 & 4096) != 0 ? null : textDecoration, (r43 & DfuBaseService.ERROR_REMOTE_MASK) != 0 ? null : shadow, (PlatformSpanStyle) null, (DrawStyle) null);
    }

    public SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this((j > Color.Unspecified ? 1 : (j == Color.Unspecified ? 0 : -1)) != 0 ? new ColorStyle(j) : TextForegroundStyle.Unspecified.INSTANCE, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle);
    }
}
