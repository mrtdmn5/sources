package androidx.compose.ui.text.font;

/* compiled from: FontStyle.kt */
/* loaded from: classes.dex */
public final class FontStyle {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m536toStringimpl(int r3) {
        boolean z;
        boolean z2 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Normal";
        }
        if (r3 == 1) {
            z2 = true;
        }
        if (z2) {
            return "Italic";
        }
        return "Invalid";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FontStyle)) {
            return false;
        }
        if (this.value != ((FontStyle) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m536toStringimpl(this.value);
    }
}
