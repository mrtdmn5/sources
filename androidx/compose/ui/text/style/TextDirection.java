package androidx.compose.ui.text.style;

/* compiled from: TextDirection.kt */
/* loaded from: classes.dex */
public final class TextDirection {
    public final int value;

    public final boolean equals(Object obj) {
        if (!(obj instanceof TextDirection)) {
            return false;
        }
        if (this.value != ((TextDirection) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int r0 = this.value;
        boolean z5 = false;
        if (r0 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Ltr";
        }
        if (r0 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Rtl";
        }
        if (r0 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Content";
        }
        if (r0 == 4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "ContentOrLtr";
        }
        if (r0 == 5) {
            z5 = true;
        }
        if (z5) {
            return "ContentOrRtl";
        }
        return "Invalid";
    }
}
