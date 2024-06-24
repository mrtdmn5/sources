package io.ktor.http;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMessageProperties.kt */
/* loaded from: classes3.dex */
public final class HttpMessagePropertiesKt {
    public static final Long contentLength(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Headers headers = httpResponse.getHeaders();
        List<String> list = HttpHeaders.UnsafeHeadersList;
        String str = headers.get("Content-Length");
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final void contentType(HttpRequestBuilder httpRequestBuilder, ContentType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<String> list = HttpHeaders.UnsafeHeadersList;
        String value = type.toString();
        HeadersBuilder headersBuilder = httpRequestBuilder.headers;
        headersBuilder.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        headersBuilder.validateValue(value);
        List<String> ensureListForKey = headersBuilder.ensureListForKey("Content-Type");
        ensureListForKey.clear();
        ensureListForKey.add(value);
    }

    public static final ContentType contentType(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        HeadersBuilder headers = httpMessageBuilder.getHeaders();
        List<String> list = HttpHeaders.UnsafeHeadersList;
        String str = headers.get("Content-Type");
        if (str == null) {
            return null;
        }
        ContentType contentType = ContentType.Any;
        return ContentType.Companion.parse(str);
    }

    public static final ContentType contentType(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        Headers headers = httpMessage.getHeaders();
        List<String> list = HttpHeaders.UnsafeHeadersList;
        String str = headers.get("Content-Type");
        if (str == null) {
            return null;
        }
        ContentType contentType = ContentType.Any;
        return ContentType.Companion.parse(str);
    }
}
