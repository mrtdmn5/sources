package androidx.compose.ui.unit;

/* compiled from: TextUnit.kt */
/* loaded from: classes.dex */
public final class TextUnitType {
    public final long type;

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m601equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m602toStringimpl(long j) {
        if (m601equalsimpl0(j, 0L)) {
            return "Unspecified";
        }
        if (m601equalsimpl0(j, 4294967296L)) {
            return "Sp";
        }
        if (m601equalsimpl0(j, 8589934592L)) {
            return "Em";
        }
        return "Invalid";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TextUnitType)) {
            return false;
        }
        if (this.type != ((TextUnitType) obj).type) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.type);
    }

    public final String toString() {
        return m602toStringimpl(this.type);
    }
}
