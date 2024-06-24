package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;
import com.animaconnected.watch.image.Kolors;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* loaded from: classes.dex */
public final class CamUtils {
    public static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] WHITE_POINT_D65 = {95.047f, 100.0f, 108.883f};
    public static final float[][] SRGB_TO_XYZ = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int intFromLStar(float f) {
        boolean z;
        float f2;
        boolean z2;
        float f3;
        if (f < 1.0f) {
            return Kolors.black;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f4 = (f + 16.0f) / 116.0f;
        if (f > 8.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f2 = f4 * f4 * f4;
        } else {
            f2 = f / 903.2963f;
        }
        float f5 = f4 * f4 * f4;
        if (f5 > 0.008856452f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            f3 = f5;
        } else {
            f3 = ((f4 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z2) {
            f5 = ((f4 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(f3 * fArr[0], f2 * fArr[1], f5 * fArr[2]);
    }

    public static float linearized(int r6) {
        float pow;
        float f = r6 / 255.0f;
        if (f <= 0.04045f) {
            pow = f / 12.92f;
        } else {
            pow = (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
        }
        return pow * 100.0f;
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        String str2;
        boolean z;
        int r0 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 != null) {
            Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                if (j2 <= longValue && longValue <= j3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return longValue;
                }
                throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
            }
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + str2 + '\'').toString());
        }
        return j;
    }

    public static int systemProp$default(String str, int r8, int r9, int r10, int r11) {
        if ((r11 & 4) != 0) {
            r9 = 1;
        }
        if ((r11 & 8) != 0) {
            r10 = Integer.MAX_VALUE;
        }
        return (int) systemProp(str, r8, r9, r10);
    }

    public static float yFromLStar() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }
}
