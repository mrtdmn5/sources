package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.config.imds.EndpointConfiguration;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ImdsEndpointProvider.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class ImdsEndpointProvider$resolvedEndpoint$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Endpoint>, Object> {
    public ImdsEndpointProvider$resolvedEndpoint$1(Object obj) {
        super(1, obj, ImdsEndpointProvider.class, "doResolveEndpoint", "doResolveEndpoint(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Endpoint> continuation) {
        Continuation<? super Endpoint> continuation2 = continuation;
        ImdsEndpointProvider imdsEndpointProvider = (ImdsEndpointProvider) this.receiver;
        EndpointConfiguration endpointConfiguration = imdsEndpointProvider.endpointConfiguration;
        if (endpointConfiguration instanceof EndpointConfiguration.Custom) {
            ((EndpointConfiguration.Custom) endpointConfiguration).getClass();
            return null;
        }
        return imdsEndpointProvider.resolveEndpointFromConfig(continuation2);
    }
}
