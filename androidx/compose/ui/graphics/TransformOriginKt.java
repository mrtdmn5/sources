package androidx.compose.ui.graphics;

/* compiled from: TransformOrigin.kt */
/* loaded from: classes.dex */
public final class TransformOriginKt {
    public static final long TransformOrigin(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = TransformOrigin.$r8$clinit;
        return floatToIntBits;
    }
}
