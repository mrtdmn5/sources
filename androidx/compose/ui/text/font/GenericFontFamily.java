package androidx.compose.ui.text.font;

/* compiled from: FontFamily.kt */
/* loaded from: classes.dex */
public final class GenericFontFamily extends SystemFontFamily {
    public final String fontFamilyName;
    public final String name;

    public GenericFontFamily(String str, String str2) {
        this.name = str;
        this.fontFamilyName = str2;
    }

    public final String toString() {
        return this.fontFamilyName;
    }
}
