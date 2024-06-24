package androidx.compose.ui.unit;

/* compiled from: IntOffset.kt */
/* loaded from: classes.dex */
public final class IntOffset {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Zero;
    public final long packedValue;

    /* compiled from: IntOffset.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
    }

    static {
        new Companion();
        Zero = IntOffsetKt.IntOffset(0, 0);
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m589equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final int m590getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m591toStringimpl(long j) {
        return "(" + ((int) (j >> 32)) + ", " + m590getYimpl(j) + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IntOffset)) {
            return false;
        }
        if (this.packedValue != ((IntOffset) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m591toStringimpl(this.packedValue);
    }
}
