package androidx.compose.ui.geometry;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class Size {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final long packedValue;
    public static final long Zero = SizeKt.Size(0.0f, 0.0f);
    public static final long Unspecified = SizeKt.Size(Float.NaN, Float.NaN);

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m273equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final float m274getHeightimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    /* renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m275getMinDimensionimpl(long j) {
        return Math.min(Math.abs(m276getWidthimpl(j)), Math.abs(m274getHeightimpl(j)));
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final float m276getWidthimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m277isEmptyimpl(long j) {
        if (m276getWidthimpl(j) > 0.0f && m274getHeightimpl(j) > 0.0f) {
            return false;
        }
        return true;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m278toStringimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Size(" + GeometryUtilsKt.toStringAsFixed(m276getWidthimpl(j)) + ", " + GeometryUtilsKt.toStringAsFixed(m274getHeightimpl(j)) + ')';
        }
        return "Size.Unspecified";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Size)) {
            return false;
        }
        if (this.packedValue != ((Size) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m278toStringimpl(this.packedValue);
    }
}
