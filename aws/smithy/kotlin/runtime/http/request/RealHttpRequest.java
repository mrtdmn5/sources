package aws.smithy.kotlin.runtime.http.request;

import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.net.Url;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
/* loaded from: classes.dex */
public final class RealHttpRequest implements HttpRequest {
    public final HttpBody body;
    public final Headers headers;
    public final HttpMethod method;
    public final DeferredHeaders trailingHeaders;
    public final Url url;

    public RealHttpRequest(HttpMethod httpMethod, Url url, Headers headers, HttpBody httpBody, DeferredHeaders deferredHeaders) {
        this.method = httpMethod;
        this.url = url;
        this.headers = headers;
        this.body = httpBody;
        this.trailingHeaders = deferredHeaders;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealHttpRequest)) {
            return false;
        }
        RealHttpRequest realHttpRequest = (RealHttpRequest) obj;
        if (this.method == realHttpRequest.method && Intrinsics.areEqual(this.url, realHttpRequest.url) && Intrinsics.areEqual(this.headers, realHttpRequest.headers) && Intrinsics.areEqual(this.body, realHttpRequest.body) && Intrinsics.areEqual(this.trailingHeaders, realHttpRequest.trailingHeaders)) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final HttpBody getBody() {
        return this.body;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final Headers getHeaders() {
        return this.headers;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final HttpMethod getMethod() {
        return this.method;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final DeferredHeaders getTrailingHeaders() {
        return this.trailingHeaders;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final Url getUrl() {
        return this.url;
    }

    public final int hashCode() {
        return this.trailingHeaders.hashCode() + ((this.body.hashCode() + ((this.headers.hashCode() + ((this.url.hashCode() + (this.method.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "RealHttpRequest(method=" + this.method + ", url=" + this.url + ", headers=" + this.headers + ", body=" + this.body + ", trailingHeaders=" + this.trailingHeaders + ')';
    }
}
