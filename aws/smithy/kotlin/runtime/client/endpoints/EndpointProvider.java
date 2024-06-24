package aws.smithy.kotlin.runtime.client.endpoints;

import kotlin.coroutines.Continuation;

/* compiled from: EndpointProvider.kt */
/* loaded from: classes.dex */
public interface EndpointProvider<T> {
    Object resolveEndpoint(T t, Continuation<? super Endpoint> continuation);
}
