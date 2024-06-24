package androidx.compose.ui.layout;

/* compiled from: ScaleFactor.kt */
/* loaded from: classes.dex */
public final class ScaleFactorKt {
    public static final long ScaleFactor(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = ScaleFactor.$r8$clinit;
        return floatToIntBits;
    }
}
