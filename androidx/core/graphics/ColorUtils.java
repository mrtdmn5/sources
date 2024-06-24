package androidx.core.graphics;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class ColorUtils {
    public static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();

    public static int XYZToColor(double d, double d2, double d3) {
        double d4;
        double d5;
        double d6;
        int min;
        int min2;
        double d7 = (((-0.4986d) * d3) + (((-1.5372d) * d2) + (3.2406d * d))) / 100.0d;
        double d8 = ((0.0415d * d3) + ((1.8758d * d2) + ((-0.9689d) * d))) / 100.0d;
        double d9 = ((1.057d * d3) + (((-0.204d) * d2) + (0.0557d * d))) / 100.0d;
        if (d7 > 0.0031308d) {
            d4 = (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d4 = d7 * 12.92d;
        }
        if (d8 > 0.0031308d) {
            d5 = (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d5 = d8 * 12.92d;
        }
        if (d9 > 0.0031308d) {
            d6 = (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d6 = d9 * 12.92d;
        }
        int round = (int) Math.round(d4 * 255.0d);
        int r1 = 0;
        if (round < 0) {
            min = 0;
        } else {
            min = Math.min(round, 255);
        }
        int round2 = (int) Math.round(d5 * 255.0d);
        if (round2 < 0) {
            min2 = 0;
        } else {
            min2 = Math.min(round2, 255);
        }
        int round3 = (int) Math.round(d6 * 255.0d);
        if (round3 >= 0) {
            r1 = Math.min(round3, 255);
        }
        return Color.rgb(min, min2, r1);
    }

    public static int compositeColors(int r8, int r9) {
        int r5;
        int r7;
        int alpha = Color.alpha(r9);
        int alpha2 = Color.alpha(r8);
        int r3 = 255 - alpha2;
        int r2 = 255 - (((255 - alpha) * r3) / 255);
        int red = Color.red(r8);
        int red2 = Color.red(r9);
        int r6 = 0;
        if (r2 == 0) {
            r5 = 0;
        } else {
            r5 = (((red2 * alpha) * r3) + ((red * 255) * alpha2)) / (r2 * 255);
        }
        int green = Color.green(r8);
        int green2 = Color.green(r9);
        if (r2 == 0) {
            r7 = 0;
        } else {
            r7 = (((green2 * alpha) * r3) + ((green * 255) * alpha2)) / (r2 * 255);
        }
        int blue = Color.blue(r8);
        int blue2 = Color.blue(r9);
        if (r2 != 0) {
            r6 = (((blue2 * alpha) * r3) + ((blue * 255) * alpha2)) / (r2 * 255);
        }
        return Color.argb(r2, r5, r7, r6);
    }

    public static int setAlphaComponent(int r1, int r2) {
        if (r2 >= 0 && r2 <= 255) {
            return (r1 & 16777215) | (r2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
