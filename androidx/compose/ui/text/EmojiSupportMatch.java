package androidx.compose.ui.text;

/* compiled from: EmojiSupportMatch.kt */
/* loaded from: classes.dex */
public final class EmojiSupportMatch {
    public final int value;

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m511toStringimpl(int r2) {
        if (r2 == 0) {
            return "EmojiSupportMatch.Default";
        }
        if (r2 == 1) {
            return "EmojiSupportMatch.None";
        }
        return "Invalid(value=" + r2 + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof EmojiSupportMatch)) {
            return false;
        }
        if (this.value != ((EmojiSupportMatch) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m511toStringimpl(this.value);
    }
}
