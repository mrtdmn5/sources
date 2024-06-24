package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

/* compiled from: SavedCall.kt */
/* loaded from: classes3.dex */
public final class SavedHttpResponse extends HttpResponse {
    public final SavedHttpCall call;
    public final ByteBufferChannel content;
    public final CoroutineContext coroutineContext;
    public final Headers headers;
    public final GMTDate requestTime;
    public final GMTDate responseTime;
    public final HttpStatusCode status;
    public final HttpProtocolVersion version;

    public SavedHttpResponse(SavedHttpCall call, byte[] bArr, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.call = call;
        JobImpl Job$default = JobKt.Job$default();
        this.status = httpResponse.getStatus();
        this.version = httpResponse.getVersion();
        this.requestTime = httpResponse.getRequestTime();
        this.responseTime = httpResponse.getResponseTime();
        this.headers = httpResponse.getHeaders();
        this.coroutineContext = httpResponse.getCoroutineContext().plus(Job$default);
        this.content = ByteChannelCtorKt.ByteReadChannel(bArr);
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
