package androidx.compose.ui.geometry;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class SizeKt {
    public static final long Size(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = Size.$r8$clinit;
        return floatToIntBits;
    }

    /* renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m279getCenteruvyYCjk(long j) {
        return OffsetKt.Offset(Size.m276getWidthimpl(j) / 2.0f, Size.m274getHeightimpl(j) / 2.0f);
    }
}
