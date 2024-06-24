package io.ktor.client.request;

import io.ktor.http.Headers;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
/* loaded from: classes3.dex */
public final class HttpResponseData {
    public final Object body;
    public final CoroutineContext callContext;
    public final Headers headers;
    public final GMTDate requestTime;
    public final GMTDate responseTime;
    public final HttpStatusCode statusCode;
    public final HttpProtocolVersion version;

    public HttpResponseData(HttpStatusCode httpStatusCode, GMTDate requestTime, HeadersImpl headersImpl, HttpProtocolVersion version, ByteReadChannel body, CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        this.statusCode = httpStatusCode;
        this.requestTime = requestTime;
        this.headers = headersImpl;
        this.version = version;
        this.body = body;
        this.callContext = callContext;
        this.responseTime = DateJvmKt.GMTDate(null);
    }

    public final String toString() {
        return "HttpResponseData=(statusCode=" + this.statusCode + ')';
    }
}
