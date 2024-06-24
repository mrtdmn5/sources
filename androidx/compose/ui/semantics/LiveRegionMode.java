package androidx.compose.ui.semantics;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class LiveRegionMode {
    public final int value = 0;

    public final boolean equals(Object obj) {
        if (!(obj instanceof LiveRegionMode)) {
            return false;
        }
        if (this.value != ((LiveRegionMode) obj).value) {
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
        if (r0 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Polite";
        }
        if (r0 == 1) {
            z2 = true;
        }
        if (z2) {
            return "Assertive";
        }
        return "Unknown";
    }
}
