package aws.smithy.kotlin.runtime.http.request;

import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.DeferredHeadersBuilder;
import aws.smithy.kotlin.runtime.http.DeferredHeadersImpl;
import aws.smithy.kotlin.runtime.http.EmptyDeferredHeaders;
import aws.smithy.kotlin.runtime.http.EmptyHeaders;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HeadersImpl;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.net.Url;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import aws.smithy.kotlin.runtime.util.ValuesMapKt;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestBuilder.kt */
/* loaded from: classes.dex */
public final class HttpRequestBuilder implements CanDeepCopy<HttpRequestBuilder> {
    public HttpBody body;
    public final HeadersBuilder headers;
    public HttpMethod method;
    public final DeferredHeadersBuilder trailingHeaders;
    public final UrlBuilder url;

    public HttpRequestBuilder(HttpMethod httpMethod, UrlBuilder urlBuilder, HeadersBuilder headersBuilder, HttpBody httpBody, DeferredHeadersBuilder deferredHeadersBuilder) {
        this.method = httpMethod;
        this.url = urlBuilder;
        this.headers = headersBuilder;
        this.body = httpBody;
        this.trailingHeaders = deferredHeadersBuilder;
    }

    public final RealHttpRequest build() {
        Headers headersImpl;
        DeferredHeaders deferredHeadersImpl;
        HttpMethod method = this.method;
        Url build = this.url.build();
        HeadersBuilder headersBuilder = this.headers;
        if (headersBuilder.values.isEmpty()) {
            Headers.Companion.getClass();
            headersImpl = EmptyHeaders.INSTANCE;
        } else {
            headersImpl = new HeadersImpl(headersBuilder.values);
        }
        HttpBody body = this.body;
        DeferredHeadersBuilder deferredHeadersBuilder = this.trailingHeaders;
        if (deferredHeadersBuilder.values.isEmpty()) {
            DeferredHeaders.Companion.getClass();
            deferredHeadersImpl = EmptyDeferredHeaders.INSTANCE;
        } else {
            deferredHeadersImpl = new DeferredHeadersImpl(deferredHeadersBuilder.values);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(body, "body");
        return new RealHttpRequest(method, build, headersImpl, body, deferredHeadersImpl);
    }

    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public final HttpRequestBuilder deepCopy() {
        HttpMethod httpMethod = this.method;
        UrlBuilder deepCopy = this.url.deepCopy();
        LinkedHashMap deepCopy2 = ValuesMapKt.deepCopy(this.headers.values);
        HeadersBuilder headersBuilder = new HeadersBuilder();
        headersBuilder.values.putAll(deepCopy2);
        HttpBody httpBody = this.body;
        LinkedHashMap deepCopy3 = ValuesMapKt.deepCopy(this.trailingHeaders.values);
        DeferredHeadersBuilder deferredHeadersBuilder = new DeferredHeadersBuilder();
        deferredHeadersBuilder.values.putAll(deepCopy3);
        return new HttpRequestBuilder(httpMethod, deepCopy, headersBuilder, httpBody, deferredHeadersBuilder);
    }

    public final void setMethod(HttpMethod httpMethod) {
        Intrinsics.checkNotNullParameter(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpRequestBuilder(method=" + this.method + ", url=" + this.url + ", headers=" + this.headers + ", body=" + this.body + ", trailingHeaders=" + this.trailingHeaders + ')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public HttpRequestBuilder() {
        this(HttpMethod.GET, new UrlBuilder(), new HeadersBuilder(), HttpBody.Empty.INSTANCE, new DeferredHeadersBuilder());
    }
}
