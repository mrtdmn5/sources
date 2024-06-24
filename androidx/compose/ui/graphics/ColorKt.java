package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Oklab;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda1;
import kotlinx.coroutines.YieldKt;

/* compiled from: Color.kt */
/* loaded from: classes.dex */
public final class ColorKt {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long Color(float r10, float r11, float r12, float r13, androidx.compose.ui.graphics.colorspace.ColorSpace r14) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m324compositeOverOWjLjI(long j, long j2) {
        boolean z;
        float f;
        boolean z2;
        float f2;
        long m315convertvNxB06k = Color.m315convertvNxB06k(j, Color.m320getColorSpaceimpl(j2));
        float m318getAlphaimpl = Color.m318getAlphaimpl(j2);
        float m318getAlphaimpl2 = Color.m318getAlphaimpl(m315convertvNxB06k);
        float f3 = 1.0f - m318getAlphaimpl2;
        float f4 = (m318getAlphaimpl * f3) + m318getAlphaimpl2;
        float m322getRedimpl = Color.m322getRedimpl(m315convertvNxB06k);
        float m322getRedimpl2 = Color.m322getRedimpl(j2);
        float f5 = 0.0f;
        boolean z3 = true;
        if (f4 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f = 0.0f;
        } else {
            f = (((m322getRedimpl2 * m318getAlphaimpl) * f3) + (m322getRedimpl * m318getAlphaimpl2)) / f4;
        }
        float m321getGreenimpl = Color.m321getGreenimpl(m315convertvNxB06k);
        float m321getGreenimpl2 = Color.m321getGreenimpl(j2);
        if (f4 == 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            f2 = 0.0f;
        } else {
            f2 = (((m321getGreenimpl2 * m318getAlphaimpl) * f3) + (m321getGreenimpl * m318getAlphaimpl2)) / f4;
        }
        float m319getBlueimpl = Color.m319getBlueimpl(m315convertvNxB06k);
        float m319getBlueimpl2 = Color.m319getBlueimpl(j2);
        if (f4 != 0.0f) {
            z3 = false;
        }
        if (!z3) {
            f5 = (((m319getBlueimpl2 * m318getAlphaimpl) * f3) + (m319getBlueimpl * m318getAlphaimpl2)) / f4;
        }
        return Color(f, f2, f5, f4, Color.m320getColorSpaceimpl(j2));
    }

    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m325lerpjxsXWHM(long j, long j2, float f) {
        Oklab oklab = ColorSpaces.Oklab;
        long m315convertvNxB06k = Color.m315convertvNxB06k(j, oklab);
        long m315convertvNxB06k2 = Color.m315convertvNxB06k(j2, oklab);
        float m318getAlphaimpl = Color.m318getAlphaimpl(m315convertvNxB06k);
        float m322getRedimpl = Color.m322getRedimpl(m315convertvNxB06k);
        float m321getGreenimpl = Color.m321getGreenimpl(m315convertvNxB06k);
        float m319getBlueimpl = Color.m319getBlueimpl(m315convertvNxB06k);
        float m318getAlphaimpl2 = Color.m318getAlphaimpl(m315convertvNxB06k2);
        float m322getRedimpl2 = Color.m322getRedimpl(m315convertvNxB06k2);
        float m321getGreenimpl2 = Color.m321getGreenimpl(m315convertvNxB06k2);
        float m319getBlueimpl2 = Color.m319getBlueimpl(m315convertvNxB06k2);
        return Color.m315convertvNxB06k(Color(YieldKt.lerp(m322getRedimpl, m322getRedimpl2, f), YieldKt.lerp(m321getGreenimpl, m321getGreenimpl2, f), YieldKt.lerp(m319getBlueimpl, m319getBlueimpl2, f), YieldKt.lerp(m318getAlphaimpl, m318getAlphaimpl2, f), oklab), Color.m320getColorSpaceimpl(j2));
    }

    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m326luminance8_81llA(long j) {
        ColorSpace m320getColorSpaceimpl = Color.m320getColorSpaceimpl(j);
        if (ColorModel.m348equalsimpl0(m320getColorSpaceimpl.model, ColorModel.Rgb)) {
            double m322getRedimpl = Color.m322getRedimpl(j);
            Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = ((Rgb) m320getColorSpaceimpl).eotfFunc;
            double invoke = rgb$$ExternalSyntheticLambda1.invoke(m322getRedimpl);
            float invoke2 = (float) ((rgb$$ExternalSyntheticLambda1.invoke(Color.m319getBlueimpl(j)) * 0.0722d) + (rgb$$ExternalSyntheticLambda1.invoke(Color.m321getGreenimpl(j)) * 0.7152d) + (invoke * 0.2126d));
            float f = 0.0f;
            if (invoke2 > 0.0f) {
                f = 1.0f;
                if (invoke2 < 1.0f) {
                    return invoke2;
                }
            }
            return f;
        }
        throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m349toStringimpl(m320getColorSpaceimpl.model))).toString());
    }

    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m327toArgb8_81llA(long j) {
        float[] fArr = ColorSpaces.SrgbPrimaries;
        return (int) (Color.m315convertvNxB06k(j, ColorSpaces.Srgb) >>> 32);
    }

    public static final long Color(int r2) {
        long j = r2 << 32;
        int r22 = Color.$r8$clinit;
        return j;
    }

    public static final long Color(long j) {
        long j2 = (j & 4294967295L) << 32;
        int r0 = Color.$r8$clinit;
        return j2;
    }

    public static final long Color(int r0, int r1, int r2, int r3) {
        return Color(((r0 & 255) << 16) | ((r3 & 255) << 24) | ((r1 & 255) << 8) | (r2 & 255));
    }
}
