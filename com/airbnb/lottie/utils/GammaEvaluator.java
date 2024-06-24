package com.airbnb.lottie.utils;

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnit;

/* loaded from: classes.dex */
public class GammaEvaluator {
    public static float EOCF_sRGB(float f) {
        if (f <= 0.04045f) {
            return f / 12.92f;
        }
        return (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float OECF_sRGB(float f) {
        if (f <= 0.0031308f) {
            return f * 12.92f;
        }
        return (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static final double convertDurationUnit(double d, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        long convert = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        return convert > 0 ? d * convert : d / sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long j, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    public static int evaluate(int r7, float f, int r9) {
        if (r7 == r9) {
            return r7;
        }
        float f2 = ((r7 >> 24) & 255) / 255.0f;
        float f3 = ((r9 >> 24) & 255) / 255.0f;
        float EOCF_sRGB = EOCF_sRGB(((r7 >> 16) & 255) / 255.0f);
        float EOCF_sRGB2 = EOCF_sRGB(((r7 >> 8) & 255) / 255.0f);
        float EOCF_sRGB3 = EOCF_sRGB((r7 & 255) / 255.0f);
        float EOCF_sRGB4 = EOCF_sRGB(((r9 >> 16) & 255) / 255.0f);
        float EOCF_sRGB5 = EOCF_sRGB(((r9 >> 8) & 255) / 255.0f);
        float EOCF_sRGB6 = EOCF_sRGB((r9 & 255) / 255.0f);
        float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f2, f, f2);
        float m2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(EOCF_sRGB4, EOCF_sRGB, f, EOCF_sRGB);
        float m3 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(EOCF_sRGB5, EOCF_sRGB2, f, EOCF_sRGB2);
        float m4 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(EOCF_sRGB6, EOCF_sRGB3, f, EOCF_sRGB3);
        float OECF_sRGB = OECF_sRGB(m2) * 255.0f;
        float OECF_sRGB2 = OECF_sRGB(m3) * 255.0f;
        return Math.round(OECF_sRGB(m4) * 255.0f) | (Math.round(OECF_sRGB) << 16) | (Math.round(m * 255.0f) << 24) | (Math.round(OECF_sRGB2) << 8);
    }

    public static final long convertDurationUnit(long j, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
}
