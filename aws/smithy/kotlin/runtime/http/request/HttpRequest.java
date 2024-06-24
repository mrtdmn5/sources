package aws.smithy.kotlin.runtime.http.request;

import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.net.Url;

/* compiled from: HttpRequest.kt */
/* loaded from: classes.dex */
public interface HttpRequest {
    HttpBody getBody();

    Headers getHeaders();

    HttpMethod getMethod();

    DeferredHeaders getTrailingHeaders();

    Url getUrl();
}
