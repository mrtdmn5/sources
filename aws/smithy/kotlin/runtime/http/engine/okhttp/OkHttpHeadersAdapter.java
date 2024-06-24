package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.util.ValuesMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: OkHttpHeadersAdapter.kt */
/* loaded from: classes.dex */
public final class OkHttpHeadersAdapter implements Headers {
    public final boolean caseInsensitiveName;
    public final okhttp3.Headers headers;

    public OkHttpHeadersAdapter(okhttp3.Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
        this.caseInsensitiveName = true;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final Set<Map.Entry<String, List<String>>> entries() {
        okhttp3.Headers headers = this.headers;
        headers.getClass();
        TreeMap treeMap = new TreeMap(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER());
        int length = headers.namesAndValues.length / 2;
        for (int r4 = 0; r4 < length; r4++) {
            String name = headers.name(r4);
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = name.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(headers.value(r4));
        }
        return treeMap.entrySet();
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final void forEach(Function2<? super String, ? super List<? extends String>, Unit> function2) {
        ValuesMap.DefaultImpls.forEach(this, function2);
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final String get(String str) {
        Object obj;
        List<String> all = getAll(str);
        if (all != null) {
            obj = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) all);
        } else {
            obj = null;
        }
        return (String) obj;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final List<String> getAll(String str) {
        List<String> values = this.headers.values(str);
        if (values.isEmpty()) {
            values = null;
        }
        return values;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final Set<String> names() {
        okhttp3.Headers headers = this.headers;
        headers.getClass();
        TreeSet treeSet = new TreeSet(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER());
        int length = headers.namesAndValues.length / 2;
        for (int r3 = 0; r3 < length; r3++) {
            treeSet.add(headers.name(r3));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }
}
