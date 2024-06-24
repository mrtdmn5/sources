package androidx.compose.ui.text;

/* compiled from: AndroidTextStyle.android.kt */
/* loaded from: classes.dex */
public final class PlatformParagraphStyle {
    public static final PlatformParagraphStyle Default = new PlatformParagraphStyle();
    public final int emojiSupportMatch;
    public final boolean includeFontPadding;

    public PlatformParagraphStyle(int r1) {
        this.includeFontPadding = true;
        this.emojiSupportMatch = 0;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformParagraphStyle)) {
            return false;
        }
        PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) obj;
        if (this.includeFontPadding != platformParagraphStyle.includeFontPadding) {
            return false;
        }
        if (this.emojiSupportMatch == platformParagraphStyle.emojiSupportMatch) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.emojiSupportMatch) + (Boolean.hashCode(this.includeFontPadding) * 31);
    }

    public final String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ", emojiSupportMatch=" + ((Object) EmojiSupportMatch.m511toStringimpl(this.emojiSupportMatch)) + ')';
    }

    public PlatformParagraphStyle(int r1, boolean z) {
        this.includeFontPadding = z;
        this.emojiSupportMatch = r1;
    }

    public PlatformParagraphStyle() {
        this(0, true);
    }
}
