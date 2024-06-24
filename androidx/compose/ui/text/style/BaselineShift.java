package androidx.compose.ui.text.style;

/* compiled from: BaselineShift.kt */
/* loaded from: classes.dex */
public final class BaselineShift {
    public final float multiplier;

    public final boolean equals(Object obj) {
        if (!(obj instanceof BaselineShift)) {
            return false;
        }
        if (Float.compare(this.multiplier, ((BaselineShift) obj).multiplier) != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.multiplier);
    }

    public final String toString() {
        return "BaselineShift(multiplier=" + this.multiplier + ')';
    }
}
