package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;

/* compiled from: DefaultHttpRequest.kt */
/* loaded from: classes3.dex */
public final class DefaultHttpRequest implements HttpRequest {
    public final Attributes attributes;
    public final HttpClientCall call;
    public final Headers headers;
    public final HttpMethod method;
    public final Url url;

    public DefaultHttpRequest(HttpClientCall httpClientCall, HttpRequestData httpRequestData) {
        this.call = httpClientCall;
        this.method = httpRequestData.method;
        this.url = httpRequestData.url;
        this.headers = httpRequestData.headers;
        this.attributes = httpRequestData.attributes;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.call.getCoroutineContext();
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.headers;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpMethod getMethod() {
        return this.method;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Url getUrl() {
        return this.url;
    }
}
