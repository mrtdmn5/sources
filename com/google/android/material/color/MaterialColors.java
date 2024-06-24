package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes3.dex */
public final class MaterialColors {
    public static int getColor(int r1, View view) {
        return MaterialAttributes.resolveOrThrow(r1, view.getContext(), view.getClass().getCanonicalName());
    }

    public static boolean isColorLight(int r20) {
        boolean z;
        double pow;
        double pow2;
        double pow3;
        if (r20 != 0) {
            ThreadLocal<double[]> threadLocal = ColorUtils.TEMP_ARRAY;
            double[] dArr = threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int red = Color.red(r20);
            int green = Color.green(r20);
            int blue = Color.blue(r20);
            if (dArr.length == 3) {
                double d = red / 255.0d;
                if (d < 0.04045d) {
                    pow = d / 12.92d;
                } else {
                    pow = Math.pow((d + 0.055d) / 1.055d, 2.4d);
                }
                double d2 = green / 255.0d;
                if (d2 < 0.04045d) {
                    pow2 = d2 / 12.92d;
                } else {
                    pow2 = Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
                }
                double d3 = blue / 255.0d;
                if (d3 < 0.04045d) {
                    pow3 = d3 / 12.92d;
                } else {
                    pow3 = Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
                }
                z = false;
                dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
                double d4 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
                dArr[1] = d4;
                dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
                if (d4 / 100.0d > 0.5d) {
                    return true;
                }
            } else {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
        } else {
            z = false;
        }
        return z;
    }

    public static int layer(int r1, float f, int r3) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(r3, Math.round(Color.alpha(r3) * f)), r1);
    }

    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str2.length() + str.length());
            for (int r1 = 0; r1 < str.length(); r1++) {
                sb.append(str.charAt(r1));
                if (str2.length() > r1) {
                    sb.append(str2.charAt(r1));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    public static int getColor(Context context, int r1, int r2) {
        TypedValue resolve = MaterialAttributes.resolve(context, r1);
        return resolve != null ? resolve.data : r2;
    }
}
