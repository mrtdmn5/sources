package aws.smithy.kotlin.runtime.http.response;

import aws.smithy.kotlin.runtime.ProtocolResponse;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpResponse.kt */
/* loaded from: classes.dex */
public final class HttpResponse implements ProtocolResponse {
    public final HttpBody body;
    public final Headers headers;
    public final HttpStatusCode status;

    public HttpResponse(HttpStatusCode status, Headers headers, HttpBody body) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        if (Intrinsics.areEqual(this.status, httpResponse.status) && Intrinsics.areEqual(this.headers, httpResponse.headers) && Intrinsics.areEqual(this.body, httpResponse.body)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.body.hashCode() + ((this.headers.hashCode() + (this.status.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "HttpResponse(status=" + this.status + ", headers=" + this.headers + ", body=" + this.body + ')';
    }
}
