package androidx.compose.animation.core;

/* compiled from: Easing.kt */
/* loaded from: classes.dex */
public final class EasingKt {
    public static final EasingKt$LinearEasing$1 LinearEasing;
    public static final CubicBezierEasing FastOutSlowInEasing = new CubicBezierEasing(0.4f, 0.2f);
    public static final CubicBezierEasing LinearOutSlowInEasing = new CubicBezierEasing(0.0f, 0.2f);

    static {
        boolean z;
        if (!Float.isNaN(0.4f) && !Float.isNaN(0.0f) && !Float.isNaN(1.0f) && !Float.isNaN(1.0f)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LinearEasing = EasingKt$LinearEasing$1.INSTANCE;
            return;
        }
        throw new IllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: 0.4, 0.0, 1.0, 1.0.".toString());
    }
}
