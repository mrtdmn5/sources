package com.animaconnected.watch.strings;

import com.animaconnected.watch.ServiceLocator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: StringsExtensions.kt */
/* loaded from: classes3.dex */
public final class StringsExtensionsKt {
    public static final String getAppString(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new Translated(key, null, 2, null).app();
    }

    public static final String getFirmwareString(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new Translated(key, null, 2, null).firmware();
    }

    public static final KeyString getKeyString(Key key, String... values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        return new Translated(key, ArraysKt___ArraysKt.toList(values));
    }

    public static final String getStringFromKey(Key key, Language language, List<String> list) {
        String str;
        Map<Key, String> map = StringsKt.getStrings().get(language);
        if (map == null || (str = map.get(key)) == null) {
            Map<Key, String> map2 = StringsKt.getStrings().get(Language.EN);
            Intrinsics.checkNotNull(map2);
            String str2 = map2.get(key);
            Intrinsics.checkNotNull(str2);
            str = str2;
        }
        String replace$default = StringsKt__StringsJVMKt.replace$default(str, "{brand}", ServiceLocator.INSTANCE.getStringsBackend().brand());
        if ((!list.isEmpty()) && StringsKt__StringsKt.contains(replace$default, "{?}", false)) {
            return StringsKt__StringsJVMKt.replace$default(replace$default, "{?}", (String) CollectionsKt___CollectionsKt.first((List) list));
        }
        return replace$default;
    }

    /* renamed from: static */
    public static final Static m1571static(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Static(str);
    }

    public static final String getAppString(Key key, String... values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        return new Translated(key, ArraysKt___ArraysJvmKt.asList(values)).app();
    }

    public static final KeyString getKeyString(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new Translated(key, null, 2, null);
    }
}
