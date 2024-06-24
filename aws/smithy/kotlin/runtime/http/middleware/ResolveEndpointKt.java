package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.Url;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.util.ValuesMap;
import com.amazonaws.http.HttpHeader;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ResolveEndpoint.kt */
/* loaded from: classes.dex */
public final class ResolveEndpointKt {
    public static final void setResolvedEndpoint(OperationRequest<HttpRequestBuilder> req, Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        String str = (String) req.context.getOrNull(HttpOperationContext.HostPrefix);
        if (str == null) {
            str = "";
        }
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
        Url url = endpoint.uri;
        m.append(url.host);
        String sb = m.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringsKt__StringsKt.removeSuffix("/", url.path));
        HttpRequestBuilder httpRequestBuilder = req.subject;
        if (!StringsKt__StringsJVMKt.isBlank(httpRequestBuilder.url.path)) {
            sb2.append("/");
            sb2.append(StringsKt__StringsKt.removePrefix("/", httpRequestBuilder.url.path));
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        UrlBuilder urlBuilder = httpRequestBuilder.url;
        urlBuilder.getClass();
        Scheme scheme = url.scheme;
        Intrinsics.checkNotNullParameter(scheme, "<set-?>");
        urlBuilder.scheme = scheme;
        UrlBuilder urlBuilder2 = httpRequestBuilder.url;
        urlBuilder2.userInfo = url.userInfo;
        Host parse = Host.Companion.parse(sb);
        urlBuilder2.getClass();
        urlBuilder2.host = parse;
        httpRequestBuilder.url.port = Integer.valueOf(url.port);
        UrlBuilder urlBuilder3 = httpRequestBuilder.url;
        urlBuilder3.getClass();
        urlBuilder3.path = sb3;
        httpRequestBuilder.url.parameters.appendAll(url.parameters);
        httpRequestBuilder.url.fragment = url.fragment;
        httpRequestBuilder.headers.set(sb, HttpHeader.HOST);
        ValuesMap<String> valuesMap = endpoint.headers;
        if (valuesMap != null) {
            httpRequestBuilder.headers.appendAll(valuesMap);
        }
    }
}
