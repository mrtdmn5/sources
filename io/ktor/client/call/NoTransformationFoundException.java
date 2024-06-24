package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: HttpClientCall.kt */
/* loaded from: classes3.dex */
public final class NoTransformationFoundException extends UnsupportedOperationException {
    public final String message;

    public NoTransformationFoundException(HttpResponse httpResponse, ClassReference classReference, KClass to) {
        String trimMargin;
        Intrinsics.checkNotNullParameter(to, "to");
        StringBuilder sb = new StringBuilder("No transformation found: ");
        sb.append(classReference);
        sb.append(" -> ");
        sb.append(to);
        sb.append("\n        |with response from ");
        sb.append(httpResponse.getCall().getRequest().getUrl());
        sb.append(":\n        |status: ");
        sb.append(httpResponse.getStatus());
        sb.append("\n        |response headers: \n        |");
        Headers headers = httpResponse.getHeaders();
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Set<Map.Entry<String, List<String>>> entries = headers.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new Pair(entry.getKey(), (String) it2.next()));
            }
            CollectionsKt__ReversedViewsKt.addAll(arrayList2, arrayList);
        }
        sb.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: io.ktor.client.call.NoTransformationFoundException$message$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Pair<? extends String, ? extends String> pair) {
                Pair<? extends String, ? extends String> pair2 = pair;
                Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
                return ((String) pair2.first) + ": " + ((String) pair2.second) + '\n';
            }
        }, 31));
        sb.append("\n    ");
        trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
        this.message = trimMargin;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
