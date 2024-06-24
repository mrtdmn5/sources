package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParagraphStyle.kt */
/* loaded from: classes.dex */
public final class ParagraphStyleKt {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long DefaultLineHeight;

    static {
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        DefaultLineHeight = TextUnit.Unspecified;
    }

    /* renamed from: fastMerge-HtYhynw, reason: not valid java name */
    public static final ParagraphStyle m515fastMergeHtYhynw(ParagraphStyle fastMerge, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        boolean z;
        Hyphens hyphens2;
        TextMotion textMotion2;
        TextMotion textMotion3;
        LineHeightStyle lineHeightStyle2 = lineHeightStyle;
        LineBreak lineBreak2 = lineBreak;
        Hyphens hyphens3 = hyphens;
        Intrinsics.checkNotNullParameter(fastMerge, "$this$fastMerge");
        TextMotion textMotion4 = fastMerge.textMotion;
        Hyphens hyphens4 = fastMerge.hyphens;
        LineBreak lineBreak3 = fastMerge.lineBreak;
        LineHeightStyle lineHeightStyle3 = fastMerge.lineHeightStyle;
        PlatformParagraphStyle platformParagraphStyle2 = fastMerge.platformStyle;
        TextDirection textDirection2 = fastMerge.textDirection;
        TextIndent textIndent2 = fastMerge.textIndent;
        Hyphens hyphens5 = hyphens4;
        long j2 = fastMerge.lineHeight;
        TextAlign textAlign2 = fastMerge.textAlign;
        if (textAlign != null && !Intrinsics.areEqual(textAlign, textAlign2)) {
            textMotion2 = textMotion;
            textMotion3 = textMotion4;
            z = true;
        } else {
            z = true;
            if (((!TextUnitKt.m600isUnspecifiedR2X_6o(j)) && !TextUnit.m596equalsimpl0(j, j2)) || ((textIndent != null && !Intrinsics.areEqual(textIndent, textIndent2)) || ((textDirection != null && !Intrinsics.areEqual(textDirection, textDirection2)) || ((platformParagraphStyle != null && !Intrinsics.areEqual(platformParagraphStyle, platformParagraphStyle2)) || ((lineHeightStyle2 != null && !Intrinsics.areEqual(lineHeightStyle2, lineHeightStyle3)) || (lineBreak2 != null && !Intrinsics.areEqual(lineBreak2, lineBreak3))))))) {
                hyphens2 = hyphens5;
            } else {
                hyphens2 = hyphens5;
                if (hyphens3 == null || Intrinsics.areEqual(hyphens3, hyphens2)) {
                    textMotion2 = textMotion;
                    hyphens5 = hyphens2;
                    textMotion3 = textMotion4;
                    if (textMotion2 == null || Intrinsics.areEqual(textMotion2, textMotion3)) {
                        z = false;
                    }
                }
            }
            textMotion2 = textMotion;
            hyphens5 = hyphens2;
            textMotion3 = textMotion4;
        }
        if (!z) {
            return fastMerge;
        }
        if (!TextUnitKt.m600isUnspecifiedR2X_6o(j)) {
            j2 = j;
        }
        if (textIndent != null) {
            textIndent2 = textIndent;
        }
        if (textAlign != null) {
            textAlign2 = textAlign;
        }
        if (textDirection != null) {
            textDirection2 = textDirection;
        }
        if (platformParagraphStyle2 == null || platformParagraphStyle != null) {
            platformParagraphStyle2 = platformParagraphStyle;
        }
        if (lineHeightStyle2 == null) {
            lineHeightStyle2 = lineHeightStyle3;
        }
        if (lineBreak2 == null) {
            lineBreak2 = lineBreak3;
        }
        if (hyphens3 == null) {
            hyphens3 = hyphens5;
        }
        if (textMotion2 != null) {
            textMotion3 = textMotion2;
        }
        return new ParagraphStyle(textAlign2, textDirection2, j2, textIndent2, platformParagraphStyle2, lineHeightStyle2, lineBreak2, hyphens3, textMotion3);
    }
}
