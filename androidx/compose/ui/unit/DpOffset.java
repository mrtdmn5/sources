package androidx.compose.ui.unit;

/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public final class DpOffset {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Unspecified;
    public final long packedValue;

    static {
        float f = 0;
        DpKt.m581DpOffsetYgX7TsA(f, f);
        Unspecified = DpKt.m581DpOffsetYgX7TsA(Float.NaN, Float.NaN);
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m583getXD9Ej5fM(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m584getYD9Ej5fM(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m585toStringimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "(" + ((Object) Dp.m580toStringimpl(m583getXD9Ej5fM(j))) + ", " + ((Object) Dp.m580toStringimpl(m584getYD9Ej5fM(j))) + ')';
        }
        return "DpOffset.Unspecified";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DpOffset)) {
            return false;
        }
        if (this.packedValue != ((DpOffset) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m585toStringimpl(this.packedValue);
    }
}
