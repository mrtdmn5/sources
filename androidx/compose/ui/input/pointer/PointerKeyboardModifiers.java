package androidx.compose.ui.input.pointer;

/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public final class PointerKeyboardModifiers {
    public final int packedValue;

    public final boolean equals(Object obj) {
        if (!(obj instanceof PointerKeyboardModifiers)) {
            return false;
        }
        if (this.packedValue != ((PointerKeyboardModifiers) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.packedValue);
    }

    public final String toString() {
        return "PointerKeyboardModifiers(packedValue=" + this.packedValue + ')';
    }
}
