package androidx.compose.ui.text.style;

/* compiled from: TextOverflow.kt */
/* loaded from: classes.dex */
public final class TextOverflow {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m557toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (r3 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Clip";
        }
        if (r3 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Ellipsis";
        }
        if (r3 == 3) {
            z3 = true;
        }
        if (z3) {
            return "Visible";
        }
        return "Invalid";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TextOverflow)) {
            return false;
        }
        if (this.value != ((TextOverflow) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m557toStringimpl(this.value);
    }
}
