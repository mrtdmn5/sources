package androidx.compose.ui.geometry;

/* compiled from: GeometryUtils.kt */
/* loaded from: classes.dex */
public class GeometryUtilsKt {
    public static final String toStringAsFixed(float f) {
        int max = Math.max(1, 0);
        float pow = (float) Math.pow(10.0f, max);
        float f2 = f * pow;
        int r2 = (int) f2;
        if (f2 - r2 >= 0.5f) {
            r2++;
        }
        float f3 = r2 / pow;
        if (max > 0) {
            return String.valueOf(f3);
        }
        return String.valueOf((int) f3);
    }
}
