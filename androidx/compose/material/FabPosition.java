package androidx.compose.material;

/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public final class FabPosition {
    public final int value;

    public final boolean equals(Object obj) {
        if (!(obj instanceof FabPosition)) {
            return false;
        }
        if (this.value != ((FabPosition) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        boolean z;
        if (this.value == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "FabPosition.Center";
        }
        return "FabPosition.End";
    }
}
