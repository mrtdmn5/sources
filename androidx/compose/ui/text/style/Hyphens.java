package androidx.compose.ui.text.style;

/* compiled from: Hyphens.kt */
/* loaded from: classes.dex */
public final class Hyphens {
    public final int value;

    public final boolean equals(Object obj) {
        if (!(obj instanceof Hyphens)) {
            return false;
        }
        if (this.value != ((Hyphens) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        boolean z;
        int r0 = this.value;
        boolean z2 = false;
        if (r0 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Hyphens.None";
        }
        if (r0 == 2) {
            z2 = true;
        }
        if (z2) {
            return "Hyphens.Auto";
        }
        return "Invalid";
    }
}
