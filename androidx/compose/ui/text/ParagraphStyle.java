package androidx.compose.ui.text;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParagraphStyle.kt */
/* loaded from: classes.dex */
public final class ParagraphStyle {
    public final Hyphens hyphens;
    public final int hyphensOrDefault;
    public final LineBreak lineBreak;
    public final int lineBreakOrDefault;
    public final long lineHeight;
    public final LineHeightStyle lineHeightStyle;
    public final PlatformParagraphStyle platformStyle;
    public final TextAlign textAlign;
    public final int textAlignOrDefault;
    public final TextDirection textDirection;
    public final TextIndent textIndent;
    public final TextMotion textMotion;

    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        int r1;
        int r12;
        int r2;
        this.textAlign = textAlign;
        this.textDirection = textDirection;
        this.lineHeight = j;
        this.textIndent = textIndent;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle;
        this.lineBreak = lineBreak;
        this.hyphens = hyphens;
        this.textMotion = textMotion;
        if (textAlign != null) {
            r1 = textAlign.value;
        } else {
            r1 = 5;
        }
        this.textAlignOrDefault = r1;
        if (lineBreak != null) {
            r12 = lineBreak.mask;
        } else {
            r12 = LineBreak.Simple;
        }
        this.lineBreakOrDefault = r12;
        if (hyphens != null) {
            r2 = hyphens.value;
        } else {
            r2 = 1;
        }
        this.hyphensOrDefault = r2;
        if (!TextUnit.m596equalsimpl0(j, TextUnit.Unspecified)) {
            if (!(TextUnit.m598getValueimpl(j) >= 0.0f)) {
                throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m598getValueimpl(j) + ')').toString());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        if (Intrinsics.areEqual(this.textAlign, paragraphStyle.textAlign) && Intrinsics.areEqual(this.textDirection, paragraphStyle.textDirection) && TextUnit.m596equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual(this.textIndent, paragraphStyle.textIndent) && Intrinsics.areEqual(this.platformStyle, paragraphStyle.platformStyle) && Intrinsics.areEqual(this.lineHeightStyle, paragraphStyle.lineHeightStyle) && Intrinsics.areEqual(this.lineBreak, paragraphStyle.lineBreak) && Intrinsics.areEqual(this.hyphens, paragraphStyle.hyphens) && Intrinsics.areEqual(this.textMotion, paragraphStyle.textMotion)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r23;
        int r24;
        int r25;
        int r26;
        int r0 = 0;
        TextAlign textAlign = this.textAlign;
        if (textAlign != null) {
            r1 = Integer.hashCode(textAlign.value);
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        TextDirection textDirection = this.textDirection;
        if (textDirection != null) {
            r2 = Integer.hashCode(textDirection.value);
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        int m = Scale$$ExternalSyntheticOutline0.m(this.lineHeight, r13, 31);
        TextIndent textIndent = this.textIndent;
        if (textIndent != null) {
            r22 = textIndent.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (m + r22) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        if (platformParagraphStyle != null) {
            r23 = platformParagraphStyle.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        if (lineHeightStyle != null) {
            r24 = lineHeightStyle.hashCode();
        } else {
            r24 = 0;
        }
        int r16 = (r15 + r24) * 31;
        LineBreak lineBreak = this.lineBreak;
        if (lineBreak != null) {
            r25 = Integer.hashCode(lineBreak.mask);
        } else {
            r25 = 0;
        }
        int r17 = (r16 + r25) * 31;
        Hyphens hyphens = this.hyphens;
        if (hyphens != null) {
            r26 = Integer.hashCode(hyphens.value);
        } else {
            r26 = 0;
        }
        int r18 = (r17 + r26) * 31;
        TextMotion textMotion = this.textMotion;
        if (textMotion != null) {
            r0 = textMotion.hashCode();
        }
        return r18 + r0;
    }

    public final ParagraphStyle merge(ParagraphStyle paragraphStyle) {
        if (paragraphStyle == null) {
            return this;
        }
        return ParagraphStyleKt.m515fastMergeHtYhynw(this, paragraphStyle.textAlign, paragraphStyle.textDirection, paragraphStyle.lineHeight, paragraphStyle.textIndent, paragraphStyle.platformStyle, paragraphStyle.lineHeightStyle, paragraphStyle.lineBreak, paragraphStyle.hyphens, paragraphStyle.textMotion);
    }

    public final String toString() {
        return "ParagraphStyle(textAlign=" + this.textAlign + ", textDirection=" + this.textDirection + ", lineHeight=" + ((Object) TextUnit.m599toStringimpl(this.lineHeight)) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + this.lineBreak + ", hyphens=" + this.hyphens + ", textMotion=" + this.textMotion + ')';
    }
}
