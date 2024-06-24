package androidx.compose.ui.text.intl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: AndroidLocaleDelegate.android.kt */
/* loaded from: classes.dex */
public final class AndroidLocaleDelegateAPI24 {
    public LocaleList lastLocaleList;
    public android.os.LocaleList lastPlatformLocaleList;
    public final ExecutorsKt lock = new ExecutorsKt();

    public final LocaleList getCurrent() {
        android.os.LocaleList localeList = android.os.LocaleList.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeList, "getDefault()");
        synchronized (this.lock) {
            LocaleList localeList2 = this.lastLocaleList;
            if (localeList2 != null && localeList == this.lastPlatformLocaleList) {
                return localeList2;
            }
            int size = localeList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int r4 = 0; r4 < size; r4++) {
                java.util.Locale locale = localeList.get(r4);
                Intrinsics.checkNotNullExpressionValue(locale, "platformLocaleList[position]");
                arrayList.add(new Locale(new AndroidLocale(locale)));
            }
            LocaleList localeList3 = new LocaleList(arrayList);
            this.lastPlatformLocaleList = localeList;
            this.lastLocaleList = localeList3;
            return localeList3;
        }
    }
}
