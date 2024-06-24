package androidx.compose.ui.unit;

/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public final class DpSize {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Unspecified = DpKt.m582DpSizeYgX7TsA(Float.NaN, Float.NaN);
    public static final long Zero;
    public final long packedValue;

    static {
        float f = 0;
        Zero = DpKt.m582DpSizeYgX7TsA(f, f);
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m586getHeightD9Ej5fM(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
        throw new IllegalStateException("DpSize is unspecified".toString());
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m587getWidthD9Ej5fM(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("DpSize is unspecified".toString());
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m588toStringimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return ((Object) Dp.m580toStringimpl(m587getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m580toStringimpl(m586getHeightD9Ej5fM(j)));
        }
        return "DpSize.Unspecified";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DpSize)) {
            return false;
        }
        if (this.packedValue != ((DpSize) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m588toStringimpl(this.packedValue);
    }
}
