package androidx.compose.ui.unit;

/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public final class DpKt {
    /* renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m581DpOffsetYgX7TsA(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = DpOffset.$r8$clinit;
        return floatToIntBits;
    }

    /* renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m582DpSizeYgX7TsA(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = DpSize.$r8$clinit;
        return floatToIntBits;
    }
}
