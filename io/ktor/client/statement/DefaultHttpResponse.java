package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;

/* compiled from: DefaultHttpResponse.kt */
/* loaded from: classes3.dex */
public final class DefaultHttpResponse extends HttpResponse {
    public final HttpClientCall call;
    public final ByteReadChannel content;
    public final CoroutineContext coroutineContext;
    public final Headers headers;
    public final GMTDate requestTime;
    public final GMTDate responseTime;
    public final HttpStatusCode status;
    public final HttpProtocolVersion version;

    public DefaultHttpResponse(HttpClientCall httpClientCall, HttpResponseData httpResponseData) {
        ByteReadChannel byteReadChannel;
        this.call = httpClientCall;
        this.coroutineContext = httpResponseData.callContext;
        this.status = httpResponseData.statusCode;
        this.version = httpResponseData.version;
        this.requestTime = httpResponseData.requestTime;
        this.responseTime = httpResponseData.responseTime;
        Object obj = httpResponseData.body;
        if (obj instanceof ByteReadChannel) {
            byteReadChannel = (ByteReadChannel) obj;
        } else {
            byteReadChannel = null;
        }
        if (byteReadChannel == null) {
            ByteReadChannel.Companion.getClass();
            byteReadChannel = (ByteReadChannel) ByteReadChannel.Companion.Empty$delegate.getValue();
        }
        this.content = byteReadChannel;
        this.headers = httpResponseData.headers;
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
        return this.headers;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate getRequestTime() {
        return this.requestTime;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate getResponseTime() {
        return this.responseTime;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpStatusCode getStatus() {
        return this.status;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpProtocolVersion getVersion() {
        return this.version;
    }
}
