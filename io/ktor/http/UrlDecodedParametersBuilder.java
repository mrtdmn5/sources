package io.ktor.http;

import io.ktor.util.StringValuesImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlDecodedParametersBuilder.kt */
/* loaded from: classes3.dex */
public final class UrlDecodedParametersBuilder implements ParametersBuilder {
    public final ParametersBuilder encodedParametersBuilder;

    public UrlDecodedParametersBuilder(ParametersBuilderImpl parametersBuilderImpl) {
        this.encodedParametersBuilder = parametersBuilderImpl;
        boolean z = parametersBuilderImpl.caseInsensitiveName;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void append(String str, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedParametersBuilder.append(CodecsKt.encodeURLParameter(str, false), CodecsKt.encodeURLParameter(value, true));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void appendAll(String name, Iterable<String> values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        String encodeURLParameter = CodecsKt.encodeURLParameter(name, false);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(values, 10));
        for (String str : values) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            arrayList.add(CodecsKt.encodeURLParameter(str, true));
        }
        this.encodedParametersBuilder.appendAll(encodeURLParameter, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void clear() {
        this.encodedParametersBuilder.clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set<Map.Entry<String, List<String>>> entries() {
        return ((StringValuesImpl) UrlDecodedParametersBuilderKt.decodeParameters(this.encodedParametersBuilder)).entries();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> all = this.encodedParametersBuilder.getAll(CodecsKt.encodeURLParameter(name, false));
        if (all != null) {
            List<String> list = all;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(CodecsKt.decodeURLQueryComponent$default((String) it.next(), 0, 0, true, 11));
            }
            return arrayList;
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final boolean isEmpty() {
        return this.encodedParametersBuilder.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set<String> names() {
        Set<String> names = this.encodedParametersBuilder.names();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(names, 10));
        Iterator<T> it = names.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.decodeURLQueryComponent$default((String) it.next(), 0, 0, false, 15));
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }
}
