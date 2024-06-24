package androidx.compose.ui.geometry;

/* compiled from: CornerRadius.kt */
/* loaded from: classes.dex */
public final class CornerRadiusKt {
    public static final long CornerRadius(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = CornerRadius.$r8$clinit;
        return floatToIntBits;
    }
}
