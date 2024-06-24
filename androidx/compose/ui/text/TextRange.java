package androidx.compose.ui.text;

/* compiled from: TextRange.kt */
/* loaded from: classes.dex */
public final class TextRange {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Zero = TextRangeKt.TextRange(0, 0);
    public final long packedValue;

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m521equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m522getCollapsedimpl(long j) {
        if (((int) (j >> 32)) == m523getEndimpl(j)) {
            return true;
        }
        return false;
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m523getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: getMax-impl, reason: not valid java name */
    public static final int m524getMaximpl(long j) {
        int r0 = (int) (j >> 32);
        if (r0 <= m523getEndimpl(j)) {
            return m523getEndimpl(j);
        }
        return r0;
    }

    /* renamed from: getMin-impl, reason: not valid java name */
    public static final int m525getMinimpl(long j) {
        int r0 = (int) (j >> 32);
        if (r0 > m523getEndimpl(j)) {
            return m523getEndimpl(j);
        }
        return r0;
    }

    /* renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m526getReversedimpl(long j) {
        if (((int) (j >> 32)) > m523getEndimpl(j)) {
            return true;
        }
        return false;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m527toStringimpl(long j) {
        return "TextRange(" + ((int) (j >> 32)) + ", " + m523getEndimpl(j) + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TextRange)) {
            return false;
        }
        if (this.packedValue != ((TextRange) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m527toStringimpl(this.packedValue);
    }
}
