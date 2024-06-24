package androidx.compose.ui.text.font;

/* compiled from: FontSynthesis.kt */
/* loaded from: classes.dex */
public final class FontSynthesis {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m537toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
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
            return "All";
        }
        if (r3 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Weight";
        }
        if (r3 == 3) {
            z4 = true;
        }
        if (z4) {
            return "Style";
        }
        return "Invalid";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FontSynthesis)) {
            return false;
        }
        if (this.value != ((FontSynthesis) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m537toStringimpl(this.value);
    }
}
