package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Lab.kt */
/* loaded from: classes.dex */
public final class Lab extends ColorSpace {
    public Lab() {
        super("Generic L*a*b*", ColorModel.Lab, 15);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] fromXyz(float[] fArr) {
        float f;
        float f2;
        float f3;
        float f4 = fArr[0];
        float[] fArr2 = MessageFormatter.D50Xyz;
        float f5 = f4 / fArr2[0];
        float f6 = fArr[1] / fArr2[1];
        float f7 = fArr[2] / fArr2[2];
        if (f5 > 0.008856452f) {
            f = (float) Math.pow(f5, 0.33333334f);
        } else {
            f = (f5 * 7.787037f) + 0.13793103f;
        }
        if (f6 > 0.008856452f) {
            f2 = (float) Math.pow(f6, 0.33333334f);
        } else {
            f2 = (f6 * 7.787037f) + 0.13793103f;
        }
        if (f7 > 0.008856452f) {
            f3 = (float) Math.pow(f7, 0.33333334f);
        } else {
            f3 = (f7 * 7.787037f) + 0.13793103f;
        }
        fArr[0] = RangesKt___RangesKt.coerceIn((116.0f * f2) - 16.0f, 0.0f, 100.0f);
        fArr[1] = RangesKt___RangesKt.coerceIn((f - f2) * 500.0f, -128.0f, 128.0f);
        fArr[2] = RangesKt___RangesKt.coerceIn((f2 - f3) * 200.0f, -128.0f, 128.0f);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMaxValue(int r1) {
        if (r1 == 0) {
            return 100.0f;
        }
        return 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMinValue(int r1) {
        if (r1 == 0) {
            return 0.0f;
        }
        return -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final long toXy$ui_graphics_release(float f, float f2, float f3) {
        float f4;
        float f5;
        float coerceIn = (RangesKt___RangesKt.coerceIn(f, 0.0f, 100.0f) + 16.0f) / 116.0f;
        float coerceIn2 = (RangesKt___RangesKt.coerceIn(f, -128.0f, 128.0f) * 0.002f) + coerceIn;
        if (coerceIn2 > 0.20689656f) {
            f4 = coerceIn2 * coerceIn2 * coerceIn2;
        } else {
            f4 = (coerceIn2 - 0.13793103f) * 0.12841855f;
        }
        if (coerceIn > 0.20689656f) {
            f5 = coerceIn * coerceIn * coerceIn;
        } else {
            f5 = (coerceIn - 0.13793103f) * 0.12841855f;
        }
        float[] fArr = MessageFormatter.D50Xyz;
        float f6 = f4 * fArr[0];
        float f7 = f5 * fArr[1];
        return (Float.floatToIntBits(f6) << 32) | (Float.floatToIntBits(f7) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] toXyz(float[] fArr) {
        float f;
        float f2;
        float f3;
        fArr[0] = RangesKt___RangesKt.coerceIn(fArr[0], 0.0f, 100.0f);
        fArr[1] = RangesKt___RangesKt.coerceIn(fArr[1], -128.0f, 128.0f);
        float coerceIn = RangesKt___RangesKt.coerceIn(fArr[2], -128.0f, 128.0f);
        fArr[2] = coerceIn;
        float f4 = (fArr[0] + 16.0f) / 116.0f;
        float f5 = (fArr[1] * 0.002f) + f4;
        float f6 = f4 - (coerceIn * 0.005f);
        if (f5 > 0.20689656f) {
            f = f5 * f5 * f5;
        } else {
            f = (f5 - 0.13793103f) * 0.12841855f;
        }
        if (f4 > 0.20689656f) {
            f2 = f4 * f4 * f4;
        } else {
            f2 = (f4 - 0.13793103f) * 0.12841855f;
        }
        if (f6 > 0.20689656f) {
            f3 = f6 * f6 * f6;
        } else {
            f3 = (f6 - 0.13793103f) * 0.12841855f;
        }
        float[] fArr2 = MessageFormatter.D50Xyz;
        fArr[0] = f * fArr2[0];
        fArr[1] = f2 * fArr2[1];
        fArr[2] = f3 * fArr2[2];
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float toZ$ui_graphics_release(float f, float f2, float f3) {
        float f4;
        float coerceIn = ((RangesKt___RangesKt.coerceIn(f, 0.0f, 100.0f) + 16.0f) / 116.0f) - (RangesKt___RangesKt.coerceIn(f3, -128.0f, 128.0f) * 0.005f);
        if (coerceIn > 0.20689656f) {
            f4 = coerceIn * coerceIn * coerceIn;
        } else {
            f4 = 0.12841855f * (coerceIn - 0.13793103f);
        }
        return f4 * MessageFormatter.D50Xyz[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public final long mo350xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float f5;
        float f6;
        float f7;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        float[] fArr = MessageFormatter.D50Xyz;
        float f8 = f / fArr[0];
        float f9 = f2 / fArr[1];
        float f10 = f3 / fArr[2];
        if (f8 > 0.008856452f) {
            f5 = (float) Math.pow(f8, 0.33333334f);
        } else {
            f5 = (f8 * 7.787037f) + 0.13793103f;
        }
        if (f9 > 0.008856452f) {
            f6 = (float) Math.pow(f9, 0.33333334f);
        } else {
            f6 = (f9 * 7.787037f) + 0.13793103f;
        }
        if (f10 > 0.008856452f) {
            f7 = (float) Math.pow(f10, 0.33333334f);
        } else {
            f7 = (f10 * 7.787037f) + 0.13793103f;
        }
        return ColorKt.Color(RangesKt___RangesKt.coerceIn((116.0f * f6) - 16.0f, 0.0f, 100.0f), RangesKt___RangesKt.coerceIn((f5 - f6) * 500.0f, -128.0f, 128.0f), RangesKt___RangesKt.coerceIn((f6 - f7) * 200.0f, -128.0f, 128.0f), f4, colorSpace);
    }
}
