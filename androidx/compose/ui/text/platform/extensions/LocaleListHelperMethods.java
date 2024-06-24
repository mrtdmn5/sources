package androidx.compose.ui.text.platform.extensions;

import android.text.style.LocaleSpan;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocale;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocaleExtensions.android.kt */
/* loaded from: classes.dex */
public final class LocaleListHelperMethods {
    public static final LocaleListHelperMethods INSTANCE = new LocaleListHelperMethods();

    public final Object localeSpan(LocaleList localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(localeList, 10));
        Iterator<Locale> it = localeList.iterator();
        while (it.hasNext()) {
            Locale next = it.next();
            Intrinsics.checkNotNullParameter(next, "<this>");
            PlatformLocale platformLocale = next.platformLocale;
            Intrinsics.checkNotNull(platformLocale, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
            arrayList.add(((AndroidLocale) platformLocale).javaLocale);
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        return new LocaleSpan(new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }

    public final void setTextLocales(AndroidTextPaint textPaint, LocaleList localeList) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(localeList, 10));
        Iterator<Locale> it = localeList.iterator();
        while (it.hasNext()) {
            Locale next = it.next();
            Intrinsics.checkNotNullParameter(next, "<this>");
            PlatformLocale platformLocale = next.platformLocale;
            Intrinsics.checkNotNull(platformLocale, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
            arrayList.add(((AndroidLocale) platformLocale).javaLocale);
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        textPaint.setTextLocales(new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }
}
