package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
/* loaded from: classes3.dex */
public final class DelegatedResponse extends HttpResponse {
    public final HttpClientCall call;
    public final ByteReadChannel content;
    public final CoroutineContext coroutineContext;
    public final HttpResponse origin;

    public DelegatedResponse(HttpClientCall call, ByteReadChannel content, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(content, "content");
        this.call = call;
        this.content = content;
        this.origin = httpResponse;
        this.coroutineContext = httpResponse.getCoroutineContext();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpClientCall getCall() {
        return this.call;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final ByteReadChannel getContent() {
        return this.content;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.origin.getHeaders();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate getRequestTime() {
        return this.origin.getRequestTime();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate getResponseTime() {
        return this.origin.getResponseTime();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpStatusCode getStatus() {
        return this.origin.getStatus();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpProtocolVersion getVersion() {
        return this.origin.getVersion();
    }
}
