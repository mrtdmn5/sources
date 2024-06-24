package androidx.compose.ui.graphics;

/* compiled from: StrokeCap.kt */
/* loaded from: classes.dex */
public final class StrokeCap {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m342toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Butt";
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Round";
        }
        if (r3 == 2) {
            z3 = true;
        }
        if (z3) {
            return "Square";
        }
        return "Unknown";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StrokeCap)) {
            return false;
        }
        if (this.value != ((StrokeCap) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m342toStringimpl(this.value);
    }
}
