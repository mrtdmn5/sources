package androidx.compose.ui.unit;

/* compiled from: Velocity.kt */
/* loaded from: classes.dex */
public final class VelocityKt {
    public static final long Velocity(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = Velocity.$r8$clinit;
        return floatToIntBits;
    }
}
