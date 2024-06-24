package androidx.compose.ui.text.input;

/* compiled from: ImeAction.kt */
/* loaded from: classes.dex */
public final class ImeAction {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m542toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "None";
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Default";
        }
        if (r3 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Go";
        }
        if (r3 == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "Search";
        }
        if (r3 == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            return "Send";
        }
        if (r3 == 5) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            return "Previous";
        }
        if (r3 == 6) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "Next";
        }
        if (r3 == 7) {
            z8 = true;
        }
        if (z8) {
            return "Done";
        }
        return "Invalid";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ImeAction)) {
            return false;
        }
        if (this.value != ((ImeAction) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m542toStringimpl(this.value);
    }
}
