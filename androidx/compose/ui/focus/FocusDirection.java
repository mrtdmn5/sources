package androidx.compose.ui.focus;

/* compiled from: FocusDirection.kt */
/* loaded from: classes.dex */
public final class FocusDirection {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m237toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (r3 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Next";
        }
        if (r3 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Previous";
        }
        if (r3 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Left";
        }
        if (r3 == 4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "Right";
        }
        if (r3 == 5) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            return "Up";
        }
        if (r3 == 6) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            return "Down";
        }
        if (r3 == 7) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "Enter";
        }
        if (r3 == 8) {
            z8 = true;
        }
        if (z8) {
            return "Exit";
        }
        return "Invalid FocusDirection";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FocusDirection)) {
            return false;
        }
        if (this.value != ((FocusDirection) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m237toStringimpl(this.value);
    }
}
