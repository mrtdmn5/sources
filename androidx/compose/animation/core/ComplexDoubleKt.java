package androidx.compose.animation.core;

/* compiled from: ComplexDouble.kt */
/* loaded from: classes.dex */
public final class ComplexDoubleKt {
    public static final ComplexDouble complexSqrt(double d) {
        if (d < 0.0d) {
            return new ComplexDouble(0.0d, Math.sqrt(Math.abs(d)));
        }
        return new ComplexDouble(Math.sqrt(d), 0.0d);
    }
}
