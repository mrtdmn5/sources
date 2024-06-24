package androidx.compose.ui.unit;

/* compiled from: IntSize.kt */
/* loaded from: classes.dex */
public final class IntSize {
    public final long packedValue;

    /* compiled from: IntSize.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
    }

    static {
        new Companion();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m592equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final int m593getHeightimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m594toStringimpl(long j) {
        return ((int) (j >> 32)) + " x " + m593getHeightimpl(j);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IntSize)) {
            return false;
        }
        if (this.packedValue != ((IntSize) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m594toStringimpl(this.packedValue);
    }
}
