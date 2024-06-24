package com.animaconnected.watch;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidStringsBackend.kt */
/* loaded from: classes3.dex */
public final class AndroidStringsBackendKt {
    public static final String toBCP47LanguageTag(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        return locale.getLanguage() + '-' + locale.getCountry();
    }
}
