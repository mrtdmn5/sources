package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.Intrinsics;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ColorSpace.kt */
/* loaded from: classes.dex */
public final class ColorSpaceKt {
    public static ColorSpace adapt$default(ColorSpace colorSpace) {
        WhitePoint whitePoint = MessageFormatter.D50;
        Adaptation$Companion$Bradford$1 adaptation$Companion$Bradford$1 = Adaptation.Bradford;
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        if (ColorModel.m348equalsimpl0(colorSpace.model, ColorModel.Rgb)) {
            Rgb rgb = (Rgb) colorSpace;
            if (!compare(rgb.whitePoint, whitePoint)) {
                float[] xyz$ui_graphics_release = whitePoint.toXyz$ui_graphics_release();
                return new Rgb(rgb.name, rgb.primaries, whitePoint, mul3x3(chromaticAdaptation(adaptation$Companion$Bradford$1.transform, rgb.whitePoint.toXyz$ui_graphics_release(), xyz$ui_graphics_release), rgb.transform), rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
            }
            return colorSpace;
        }
        return colorSpace;
    }

    public static final float[] chromaticAdaptation(float[] matrix, float[] fArr, float[] fArr2) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        mul3x3Float3(matrix, fArr);
        mul3x3Float3(matrix, fArr2);
        return mul3x3(inverse3x3(matrix), mul3x3Diag(new float[]{fArr2[0] / fArr[0], fArr2[1] / fArr[1], fArr2[2] / fArr[2]}, matrix));
    }

    public static final boolean compare(WhitePoint a, WhitePoint b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a == b) {
            return true;
        }
        if (Math.abs(a.x - b.x) < 0.001f && Math.abs(a.y - b.y) < 0.001f) {
            return true;
        }
        return false;
    }

    public static final float[] inverse3x3(float[] m) {
        Intrinsics.checkNotNullParameter(m, "m");
        float f = m[0];
        float f2 = m[3];
        float f3 = m[6];
        float f4 = m[1];
        float f5 = m[4];
        float f6 = m[7];
        float f7 = m[2];
        float f8 = m[5];
        float f9 = m[8];
        float f10 = (f5 * f9) - (f6 * f8);
        float f11 = (f6 * f7) - (f4 * f9);
        float f12 = (f4 * f8) - (f5 * f7);
        float f13 = (f3 * f12) + (f2 * f11) + (f * f10);
        float[] fArr = new float[m.length];
        fArr[0] = f10 / f13;
        fArr[1] = f11 / f13;
        fArr[2] = f12 / f13;
        fArr[3] = ((f3 * f8) - (f2 * f9)) / f13;
        fArr[4] = ((f9 * f) - (f3 * f7)) / f13;
        fArr[5] = ((f7 * f2) - (f8 * f)) / f13;
        fArr[6] = ((f2 * f6) - (f3 * f5)) / f13;
        fArr[7] = ((f3 * f4) - (f6 * f)) / f13;
        fArr[8] = ((f * f5) - (f2 * f4)) / f13;
        return fArr;
    }

    public static final float[] mul3x3(float[] lhs, float[] rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        float f = lhs[0] * rhs[0];
        float f2 = lhs[3];
        float f3 = rhs[1];
        float f4 = lhs[6];
        float f5 = rhs[2];
        float f6 = f4 * f5;
        float f7 = lhs[1];
        float f8 = rhs[0];
        float f9 = lhs[4];
        float f10 = f3 * f9;
        float f11 = lhs[7];
        float f12 = f11 * f5;
        float f13 = lhs[2] * f8;
        float f14 = lhs[5];
        float f15 = (rhs[1] * f14) + f13;
        float f16 = lhs[8];
        float f17 = lhs[0];
        float f18 = rhs[3] * f17;
        float f19 = rhs[4];
        float f20 = (f2 * f19) + f18;
        float f21 = rhs[5];
        float f22 = lhs[1];
        float f23 = rhs[3];
        float f24 = f9 * f19;
        float f25 = lhs[2];
        float f26 = f14 * rhs[4];
        float f27 = f17 * rhs[6];
        float f28 = lhs[3];
        float f29 = rhs[7];
        float f30 = (f28 * f29) + f27;
        float f31 = rhs[8];
        float f32 = rhs[6];
        return new float[]{f6 + (f2 * f3) + f, f12 + f10 + (f7 * f8), (f5 * f16) + f15, (f4 * f21) + f20, (f11 * f21) + f24 + (f22 * f23), (f21 * f16) + f26 + (f23 * f25), (f4 * f31) + f30, (f11 * f31) + (lhs[4] * f29) + (f22 * f32), (f16 * f31) + (lhs[5] * rhs[7]) + (f25 * f32)};
    }

    public static final float[] mul3x3Diag(float[] fArr, float[] rhs) {
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        return new float[]{fArr[0] * rhs[0], fArr[1] * rhs[1], fArr[2] * rhs[2], rhs[3] * f, rhs[4] * f2, rhs[5] * f3, f * rhs[6], f2 * rhs[7], f3 * rhs[8]};
    }

    public static final void mul3x3Float3(float[] lhs, float[] fArr) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        fArr[0] = (lhs[6] * f3) + (lhs[3] * f2) + (lhs[0] * f);
        fArr[1] = (lhs[7] * f3) + (lhs[4] * f2) + (lhs[1] * f);
        fArr[2] = (lhs[8] * f3) + (lhs[5] * f2) + (lhs[2] * f);
    }

    public static final float mul3x3Float3_0(float[] lhs, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        return (lhs[6] * f3) + (lhs[3] * f2) + (lhs[0] * f);
    }

    public static final float mul3x3Float3_1(float[] lhs, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        return (lhs[7] * f3) + (lhs[4] * f2) + (lhs[1] * f);
    }

    public static final float mul3x3Float3_2(float[] lhs, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        return (lhs[8] * f3) + (lhs[5] * f2) + (lhs[2] * f);
    }
}
