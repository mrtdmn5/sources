package androidx.core.math;

/* loaded from: classes.dex */
public final class MathUtils {
    public static int clamp(int r0, int r1, int r2) {
        if (r0 < r1) {
            return r1;
        }
        if (r0 > r2) {
            return r2;
        }
        return r0;
    }
}
