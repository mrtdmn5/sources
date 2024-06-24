package io.ktor.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
/* loaded from: classes3.dex */
public class StringValuesImpl implements StringValues {
    public final boolean caseInsensitiveName;
    public final Map<String, List<String>> values;

    public StringValuesImpl(Map values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.caseInsensitiveName = true;
        CaseInsensitiveMap caseInsensitiveMap = new CaseInsensitiveMap();
        for (Map.Entry entry : values.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int r5 = 0; r5 < size; r5++) {
                arrayList.add((String) list.get(r5));
            }
            caseInsensitiveMap.put(str, arrayList);
        }
        this.values = caseInsensitiveMap;
    }

    @Override // io.ktor.util.StringValues
    public final Set<Map.Entry<String, List<String>>> entries() {
        Set<Map.Entry<String, List<String>>> entrySet = this.values.entrySet();
        Intrinsics.checkNotNullParameter(entrySet, "<this>");
        Set<Map.Entry<String, List<String>>> unmodifiableSet = Collections.unmodifiableSet(entrySet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(this)");
        return unmodifiableSet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (this.caseInsensitiveName != stringValues.getCaseInsensitiveName()) {
            return false;
        }
        return Intrinsics.areEqual(entries(), stringValues.entries());
    }

    @Override // io.ktor.util.StringValues
    public final void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        for (Map.Entry<String, List<String>> entry : this.values.entrySet()) {
            function2.invoke(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.ktor.util.StringValues
    public final String get(String str) {
        List<String> list = this.values.get(str);
        if (list != null) {
            return (String) CollectionsKt___CollectionsKt.firstOrNull((List) list);
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.get(name);
    }

    @Override // io.ktor.util.StringValues
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public final int hashCode() {
        Set<Map.Entry<String, List<String>>> entries = entries();
        return entries.hashCode() + (Boolean.hashCode(this.caseInsensitiveName) * 31 * 31);
    }

    @Override // io.ktor.util.StringValues
    public final boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public final Set<String> names() {
        Set<String> keySet = this.values.keySet();
        Intrinsics.checkNotNullParameter(keySet, "<this>");
        Set<String> unmodifiableSet = Collections.unmodifiableSet(keySet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(this)");
        return unmodifiableSet;
    }
}
