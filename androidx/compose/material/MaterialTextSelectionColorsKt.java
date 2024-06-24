package androidx.compose.material;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: MaterialTextSelectionColors.kt */
/* loaded from: classes.dex */
public final class MaterialTextSelectionColorsKt {
    /* renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    public static final float m190calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long Color;
        Color = ColorKt.Color(Color.m322getRedimpl(j), Color.m321getGreenimpl(j), Color.m319getBlueimpl(j), f, Color.m320getColorSpaceimpl(j));
        long m324compositeOverOWjLjI = ColorKt.m324compositeOverOWjLjI(Color, j3);
        float m326luminance8_81llA = ColorKt.m326luminance8_81llA(ColorKt.m324compositeOverOWjLjI(j2, m324compositeOverOWjLjI)) + 0.05f;
        float m326luminance8_81llA2 = ColorKt.m326luminance8_81llA(m324compositeOverOWjLjI) + 0.05f;
        return Math.max(m326luminance8_81llA, m326luminance8_81llA2) / Math.min(m326luminance8_81llA, m326luminance8_81llA2);
    }
}
