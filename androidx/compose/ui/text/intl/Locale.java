package androidx.compose.ui.text.intl;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Locale.kt */
/* loaded from: classes.dex */
public final class Locale {
    public final PlatformLocale platformLocale;

    public Locale(AndroidLocale androidLocale) {
        this.platformLocale = androidLocale;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Locale)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Intrinsics.areEqual(this.platformLocale.toLanguageTag(), ((Locale) obj).platformLocale.toLanguageTag());
    }

    public final int hashCode() {
        return this.platformLocale.toLanguageTag().hashCode();
    }

    public final String toString() {
        return this.platformLocale.toLanguageTag();
    }
}
