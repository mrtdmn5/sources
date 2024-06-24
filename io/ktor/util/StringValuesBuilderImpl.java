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
public class StringValuesBuilderImpl implements StringValuesBuilder {
    public final boolean caseInsensitiveName = true;
    public final Map<String, List<String>> values = new CaseInsensitiveMap();

    public StringValuesBuilderImpl(int r1) {
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void append(String str, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        validateValue(value);
        ensureListForKey(str).add(value);
    }

    public final void appendAll(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.forEach(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesBuilderImpl$appendAll$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(String str, List<? extends String> list) {
                String name = str;
                List<? extends String> values = list;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                StringValuesBuilderImpl.this.appendAll(name, values);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void clear() {
        this.values.clear();
    }

    public final List<String> ensureListForKey(String str) {
        Map<String, List<String>> map = this.values;
        List<String> list = map.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            validateName(str);
            map.put(str, arrayList);
            return arrayList;
        }
        return list;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set<Map.Entry<String, List<String>>> entries() {
        Set<Map.Entry<String, List<String>>> entrySet = this.values.entrySet();
        Intrinsics.checkNotNullParameter(entrySet, "<this>");
        Set<Map.Entry<String, List<String>>> unmodifiableSet = Collections.unmodifiableSet(entrySet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(this)");
        return unmodifiableSet;
    }

    public final String get(String str) {
        List<String> all = getAll(str);
        if (all != null) {
            return (String) CollectionsKt___CollectionsKt.firstOrNull((List) all);
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.get(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set<String> names() {
        return this.values.keySet();
    }

    public final void remove(String str) {
        this.values.remove(str);
    }

    public void validateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public void validateValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void appendAll(String name, Iterable<String> values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        List<String> ensureListForKey = ensureListForKey(name);
        for (String str : values) {
            validateValue(str);
            ensureListForKey.add(str);
        }
    }
}
