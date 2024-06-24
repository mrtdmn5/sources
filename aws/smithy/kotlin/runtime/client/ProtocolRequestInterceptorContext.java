package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.http.request.HttpRequest;

/* compiled from: Interceptor.kt */
/* loaded from: classes.dex */
public interface ProtocolRequestInterceptorContext<I, ProtocolRequest> extends RequestInterceptorContext<I> {
    HttpRequest getProtocolRequest();
}
