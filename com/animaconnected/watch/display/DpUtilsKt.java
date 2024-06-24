package com.animaconnected.watch.display;

import android.content.res.Resources;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: DpUtils.kt */
/* loaded from: classes3.dex */
public final class DpUtilsKt {
    private static final float density = Resources.getSystem().getDisplayMetrics().density;
    private static final float scaledDensity = Resources.getSystem().getDisplayMetrics().scaledDensity;

    public static final float getDensity() {
        return density;
    }

    public static final float getScaledDensity() {
        return scaledDensity;
    }

    public static final float toDp(float f) {
        return f / density;
    }

    public static final int toDpInt(float f) {
        return MathKt__MathJVMKt.roundToInt(f / density);
    }

    public static final float toPx(float f) {
        return f * density;
    }

    public static final int toPxInt(float f) {
        return MathKt__MathJVMKt.roundToInt(f * density);
    }

    public static final int toSp(float f) {
        return MathKt__MathJVMKt.roundToInt(f / scaledDensity);
    }

    public static final float toDp(int r1) {
        return r1 / density;
    }

    public static final int toDpInt(int r1) {
        return MathKt__MathJVMKt.roundToInt(r1 / density);
    }

    public static final int toPxInt(int r1) {
        return MathKt__MathJVMKt.roundToInt(r1 * density);
    }

    public static final int toSp(int r1) {
        return MathKt__MathJVMKt.roundToInt(r1 / scaledDensity);
    }
}
