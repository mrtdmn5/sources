package io.ktor.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlDecodedParametersBuilder.kt */
/* loaded from: classes3.dex */
public final class UrlDecodedParametersBuilderKt {
    public static final void appendAllEncoded(ParametersBuilder parametersBuilder, Parameters parameters) {
        for (String str : parameters.names()) {
            List<String> all = parameters.getAll(str);
            if (all == null) {
                all = EmptyList.INSTANCE;
            }
            String encodeURLParameter = CodecsKt.encodeURLParameter(str, false);
            List<String> list = all;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            for (String str2 : list) {
                Intrinsics.checkNotNullParameter(str2, "<this>");
                arrayList.add(CodecsKt.encodeURLParameter(str2, true));
            }
            parametersBuilder.appendAll(encodeURLParameter, arrayList);
        }
    }

    public static final Parameters decodeParameters(ParametersBuilder parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ParametersBuilderImpl ParametersBuilder$default = ParametersKt.ParametersBuilder$default();
        for (String str : parameters.names()) {
            List<String> all = parameters.getAll(str);
            if (all == null) {
                all = EmptyList.INSTANCE;
            }
            String decodeURLQueryComponent$default = CodecsKt.decodeURLQueryComponent$default(str, 0, 0, false, 15);
            List<String> list = all;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(CodecsKt.decodeURLQueryComponent$default((String) it.next(), 0, 0, true, 11));
            }
            ParametersBuilder$default.appendAll(decodeURLQueryComponent$default, arrayList);
        }
        return new ParametersImpl(ParametersBuilder$default.values);
    }
}
