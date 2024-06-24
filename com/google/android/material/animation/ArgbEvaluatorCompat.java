package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    public static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    @Override // android.animation.TypeEvaluator
    public final Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f2 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float f3 = ((intValue2 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = (float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d);
        float pow6 = (float) Math.pow((intValue2 & 255) / 255.0f, 2.2d);
        float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f2, f, f2);
        float m2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pow4, pow, f, pow);
        float m3 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pow5, pow2, f, pow2);
        float m4 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pow6, pow3, f, pow3);
        float pow7 = ((float) Math.pow(m2, 0.45454545454545453d)) * 255.0f;
        float pow8 = ((float) Math.pow(m3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(m4, 0.45454545454545453d)) * 255.0f) | (Math.round(pow7) << 16) | (Math.round(m * 255.0f) << 24) | (Math.round(pow8) << 8));
    }
}
