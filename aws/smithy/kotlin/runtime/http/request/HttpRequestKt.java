package aws.smithy.kotlin.runtime.http.request;

import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.Url;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
/* loaded from: classes.dex */
public final class HttpRequestKt {
    public static final HttpRequestBuilder toBuilder(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        if (httpRequest instanceof HttpRequestBuilderView) {
            HttpRequestBuilderView httpRequestBuilderView = (HttpRequestBuilderView) httpRequest;
            if (httpRequestBuilderView.allowToBuilder) {
                return httpRequestBuilderView.builder;
            }
            throw new IllegalStateException("This is an immutable HttpRequest that should not be converted to a builder".toString());
        }
        if (httpRequest instanceof RealHttpRequest) {
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.setMethod(httpRequest.getMethod());
            httpRequestBuilder.headers.appendAll(httpRequest.getHeaders());
            Url value = httpRequest.getUrl();
            Intrinsics.checkNotNullParameter(value, "value");
            UrlBuilder urlBuilder = httpRequestBuilder.url;
            urlBuilder.getClass();
            Scheme scheme = value.scheme;
            Intrinsics.checkNotNullParameter(scheme, "<set-?>");
            urlBuilder.scheme = scheme;
            Host host = value.host;
            Intrinsics.checkNotNullParameter(host, "<set-?>");
            urlBuilder.host = host;
            urlBuilder.port = Integer.valueOf(value.port);
            String str = value.path;
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            urlBuilder.path = str;
            urlBuilder.parameters.appendAll(value.parameters);
            urlBuilder.fragment = value.fragment;
            urlBuilder.userInfo = value.userInfo;
            urlBuilder.forceQuery = value.forceQuery;
            HttpBody body = httpRequest.getBody();
            Intrinsics.checkNotNullParameter(body, "<set-?>");
            httpRequestBuilder.body = body;
            httpRequestBuilder.trailingHeaders.appendAll(httpRequest.getTrailingHeaders());
            return httpRequestBuilder;
        }
        throw new NoWhenBranchMatchedException();
    }
}
