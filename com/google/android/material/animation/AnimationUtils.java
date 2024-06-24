package com.google.android.material.animation;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* loaded from: classes3.dex */
public final class AnimationUtils {
    public static final LinearInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final FastOutSlowInInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final FastOutLinearInInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    public static final LinearOutSlowInInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    public static final DecelerateInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static float lerp(float f, float f2, float f3, float f4, float f5) {
        return f5 < f3 ? f : f5 > f4 ? f2 : DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f2, f, (f5 - f3) / (f4 - f3), f);
    }

    public static int lerp(int r0, float f, int r2) {
        return Math.round(f * (r2 - r0)) + r0;
    }
}
