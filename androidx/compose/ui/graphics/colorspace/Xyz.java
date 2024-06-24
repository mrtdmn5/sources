package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Xyz.kt */
/* loaded from: classes.dex */
public final class Xyz extends ColorSpace {
    public Xyz() {
        super("Generic XYZ", ColorModel.Xyz, 14);
    }

    public static float clamp(float f) {
        return RangesKt___RangesKt.coerceIn(f, -2.0f, 2.0f);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] fromXyz(float[] fArr) {
        fArr[0] = clamp(fArr[0]);
        fArr[1] = clamp(fArr[1]);
        fArr[2] = clamp(fArr[2]);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMaxValue(int r1) {
        return 2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMinValue(int r1) {
        return -2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final long toXy$ui_graphics_release(float f, float f2, float f3) {
        float clamp = clamp(f);
        float clamp2 = clamp(f2);
        return (Float.floatToIntBits(clamp2) & 4294967295L) | (Float.floatToIntBits(clamp) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] toXyz(float[] fArr) {
        fArr[0] = clamp(fArr[0]);
        fArr[1] = clamp(fArr[1]);
        fArr[2] = clamp(fArr[2]);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float toZ$ui_graphics_release(float f, float f2, float f3) {
        return clamp(f3);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public final long mo350xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return ColorKt.Color(clamp(f), clamp(f2), clamp(f3), f4, colorSpace);
    }
}
