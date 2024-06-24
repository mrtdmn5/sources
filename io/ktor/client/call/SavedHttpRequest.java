package io.ktor.client.call;

import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedCall.kt */
/* loaded from: classes3.dex */
public final class SavedHttpRequest implements HttpRequest {
    public final /* synthetic */ HttpRequest $$delegate_0;

    public SavedHttpRequest(SavedHttpCall call, HttpRequest httpRequest) {
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
