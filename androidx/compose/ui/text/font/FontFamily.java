package androidx.compose.ui.text.font;

/* compiled from: FontFamily.kt */
/* loaded from: classes.dex */
public abstract class FontFamily {
    public static final DefaultFontFamily Default = new DefaultFontFamily();

    /* compiled from: FontFamily.kt */
    /* loaded from: classes.dex */
    public interface Resolver {
        /* renamed from: resolve-DPcqOEQ, reason: not valid java name */
        TypefaceResult mo534resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int r3, int r4);
    }

    static {
        new GenericFontFamily("sans-serif", "FontFamily.SansSerif");
        new GenericFontFamily("serif", "FontFamily.Serif");
        new GenericFontFamily("monospace", "FontFamily.Monospace");
        new GenericFontFamily("cursive", "FontFamily.Cursive");
    }
}
