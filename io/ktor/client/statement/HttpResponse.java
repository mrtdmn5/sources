package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpResponse.kt */
/* loaded from: classes3.dex */
public abstract class HttpResponse implements HttpMessage, CoroutineScope {
    public abstract HttpClientCall getCall();

    public abstract ByteReadChannel getContent();

    public abstract GMTDate getRequestTime();

    public abstract GMTDate getResponseTime();

    public abstract HttpStatusCode getStatus();

    public abstract HttpProtocolVersion getVersion();

    public final String toString() {
        return "HttpResponse[" + getCall().getRequest().getUrl() + ", " + getStatus() + ']';
    }
}
