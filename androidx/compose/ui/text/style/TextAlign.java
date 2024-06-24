package androidx.compose.ui.text.style;

/* compiled from: TextAlign.kt */
/* loaded from: classes.dex */
public final class TextAlign {
    public final int value;

    public final boolean equals(Object obj) {
        if (!(obj instanceof TextAlign)) {
            return false;
        }
        if (this.value != ((TextAlign) obj).value) {
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
        boolean z5;
        int r0 = this.value;
        boolean z6 = false;
        if (r0 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Left";
        }
        if (r0 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Right";
        }
        if (r0 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Center";
        }
        if (r0 == 4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "Justify";
        }
        if (r0 == 5) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            return "Start";
        }
        if (r0 == 6) {
            z6 = true;
        }
        if (z6) {
            return "End";
        }
        return "Invalid";
    }
}
