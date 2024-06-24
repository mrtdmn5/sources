package aws.smithy.kotlin.runtime.net;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: UrlParser.kt */
/* loaded from: classes.dex */
public final class UrlParserKt {
    public static final String access$capture(String str, IntRange intRange, Function1 function1) {
        boolean z;
        String substring = StringsKt__StringsKt.substring(str, intRange);
        if (substring.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            function1.invoke(substring);
        }
        String substring2 = str.substring(intRange.last + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return substring2;
    }

    public static final String access$captureUntilAndSkip(String str, String str2, Function1 function1) {
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6);
        if (indexOf$default != -1) {
            function1.invoke(StringsKt__StringsKt.substring(str, RangesKt___RangesKt.until(0, indexOf$default)));
            String substring = str.substring(str2.length() + indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    public static final int access$firstIndexOrEnd(String str, String... strArr) {
        boolean z;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(Integer.valueOf(StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6)));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((Number) next).intValue() != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.isEmpty()) {
            return str.length();
        }
        return Math.min(((Number) CollectionsKt___CollectionsKt.minOrThrow(arrayList2)).intValue(), str.length());
    }
}
