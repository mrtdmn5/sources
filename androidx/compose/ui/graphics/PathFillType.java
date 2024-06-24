package androidx.compose.ui.graphics;

/* compiled from: PathFillType.kt */
/* loaded from: classes.dex */
public final class PathFillType {
    public final int value;

    public final boolean equals(Object obj) {
        if (!(obj instanceof PathFillType)) {
            return false;
        }
        if (this.value != ((PathFillType) obj).value) {
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
            return "NonZero";
        }
        if (r0 == 1) {
            z2 = true;
        }
        if (z2) {
            return "EvenOdd";
        }
        return "Unknown";
    }
}
