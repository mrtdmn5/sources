package androidx.compose.ui.graphics;

/* compiled from: StrokeJoin.kt */
/* loaded from: classes.dex */
public final class StrokeJoin {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m343toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Miter";
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
            return "Bevel";
        }
        return "Unknown";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StrokeJoin)) {
            return false;
        }
        if (this.value != ((StrokeJoin) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m343toStringimpl(this.value);
    }
}
