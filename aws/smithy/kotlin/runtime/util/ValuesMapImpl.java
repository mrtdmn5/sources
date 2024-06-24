package aws.smithy.kotlin.runtime.util;

import aws.smithy.kotlin.runtime.util.ValuesMap;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValuesMap.kt */
/* loaded from: classes.dex */
public class ValuesMapImpl<T> implements ValuesMap<T> {
    public final boolean caseInsensitiveName;
    public final Map<String, List<T>> values;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [aws.smithy.kotlin.runtime.util.CaseInsensitiveMap] */
    public ValuesMapImpl(Map initialValues, boolean z) {
        Intrinsics.checkNotNullParameter(initialValues, "initialValues");
        this.caseInsensitiveName = z;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(initialValues.size()));
        for (Map.Entry entry : initialValues.entrySet()) {
            linkedHashMap.put(entry.getKey(), CollectionsKt___CollectionsKt.toList((List) entry.getValue()));
        }
        if (this.caseInsensitiveName) {
            ?? caseInsensitiveMap = new CaseInsensitiveMap();
            caseInsensitiveMap.putAll(linkedHashMap);
            linkedHashMap = caseInsensitiveMap;
        }
        this.values = linkedHashMap;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final Set<Map.Entry<String, List<T>>> entries() {
        return this.values.entrySet();
    }

    public boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof ValuesMap)) {
            return false;
        }
        ValuesMap valuesMap = (ValuesMap) obj;
        if (this.caseInsensitiveName != valuesMap.getCaseInsensitiveName()) {
            return false;
        }
        Set<String> names = names();
        if (names.size() != valuesMap.names().size()) {
            return false;
        }
        Set<String> set = names;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (String str : set) {
                if (!Intrinsics.areEqual(getAll(str), valuesMap.getAll(str))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!z) {
            return false;
        }
        return true;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final void forEach(Function2<? super String, ? super List<? extends T>, Unit> function2) {
        ValuesMap.DefaultImpls.forEach(this, function2);
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final T get(String str) {
        List<T> all = getAll(str);
        if (all != null) {
            return (T) CollectionsKt___CollectionsKt.firstOrNull((List) all);
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final List<T> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.get(name);
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final Set<String> names() {
        return this.values.keySet();
    }
}
