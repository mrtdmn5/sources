package androidx.compose.ui.input.pointer;

/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public final class PointerId {
    public final long value;

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m413equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m414toStringimpl(long j) {
        return "PointerId(value=" + j + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PointerId)) {
            return false;
        }
        if (this.value != ((PointerId) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return m414toStringimpl(this.value);
    }
}
