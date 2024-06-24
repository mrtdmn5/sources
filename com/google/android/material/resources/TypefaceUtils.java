package com.google.android.material.resources;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.core.math.MathUtils;

/* loaded from: classes3.dex */
public final class TypefaceUtils {
    public static Typeface maybeCopyWithFontWeightAdjustment(Configuration configuration, Typeface typeface) {
        int r0;
        int r02;
        int weight;
        int r2;
        Typeface create;
        if (Build.VERSION.SDK_INT >= 31) {
            r0 = configuration.fontWeightAdjustment;
            if (r0 != Integer.MAX_VALUE) {
                r02 = configuration.fontWeightAdjustment;
                if (r02 != 0) {
                    weight = typeface.getWeight();
                    r2 = configuration.fontWeightAdjustment;
                    create = Typeface.create(typeface, MathUtils.clamp(r2 + weight, 1, 1000), typeface.isItalic());
                    return create;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
