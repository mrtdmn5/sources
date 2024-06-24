package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
/* loaded from: classes3.dex */
public final class DelegatedRequest implements HttpRequest {
    public final /* synthetic */ HttpRequest $$delegate_0;

    public DelegatedRequest(HttpClientCall call, HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.$$delegate_0 = httpRequest;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes getAttributes() {
        return this.$$delegate_0.getAttributes();
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.$$delegate_0.getHeaders();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpMethod getMethod() {
        return this.$$delegate_0.getMethod();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Url getUrl() {
        return this.$$delegate_0.getUrl();
    }
}
