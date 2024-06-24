package androidx.compose.ui.text.intl;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLocaleDelegate.android.kt */
/* loaded from: classes.dex */
public final class AndroidLocale implements PlatformLocale {
    public final java.util.Locale javaLocale;

    public AndroidLocale(java.util.Locale locale) {
        this.javaLocale = locale;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    public final String toLanguageTag() {
        String languageTag = this.javaLocale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "javaLocale.toLanguageTag()");
        return languageTag;
    }
}
