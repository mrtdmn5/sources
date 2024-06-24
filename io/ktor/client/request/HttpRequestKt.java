package io.ktor.client.request;

import io.ktor.http.URLParserKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
/* loaded from: classes3.dex */
public final class HttpRequestKt {
    public static final void headers(HttpRequestBuilder httpRequestBuilder, Function1 function1) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        function1.invoke(httpRequestBuilder.headers);
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        URLParserKt.takeFrom(httpRequestBuilder.url, urlString);
    }
}
