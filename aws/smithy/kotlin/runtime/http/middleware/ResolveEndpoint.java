package aws.smithy.kotlin.runtime.http.middleware;

import aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequest;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResolveEndpoint.kt */
/* loaded from: classes.dex */
public final class ResolveEndpoint<T> implements ModifyRequest {
    public final T params;
    public final EndpointProvider<T> provider;

    /* JADX WARN: Multi-variable type inference failed */
    public ResolveEndpoint(ImdsEndpointProvider imdsEndpointProvider, Unit unit) {
        this.provider = imdsEndpointProvider;
        this.params = unit;
    }

    public final void install(SdkHttpOperation<?, ?> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase<OperationRequest<HttpRequestBuilder>, ?> phase = op.execution.mutate;
        Phase.Order order = Phase.Order.After;
        phase.getClass();
        Intrinsics.checkNotNullParameter(order, "order");
        phase.register(new ModifyRequestMiddleware(this), order);
    }

    @Override // aws.smithy.kotlin.runtime.io.middleware.ModifyRequest
    public final /* bridge */ /* synthetic */ Object modifyRequest(Object obj, ModifyRequestMiddleware$handle$1 modifyRequestMiddleware$handle$1) {
        return modifyRequest((OperationRequest<HttpRequestBuilder>) obj, (Continuation<? super OperationRequest<HttpRequestBuilder>>) modifyRequestMiddleware$handle$1);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyRequest(aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder> r5, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint$modifyRequest$1
            if (r0 == 0) goto L13
            r0 = r6
            aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint$modifyRequest$1 r0 = (aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint$modifyRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint$modifyRequest$1 r0 = new aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint$modifyRequest$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            aws.smithy.kotlin.runtime.http.operation.OperationRequest r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider<T> r6 = r4.provider
            T r2 = r4.params
            java.lang.Object r6 = r6.resolveEndpoint(r2, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            aws.smithy.kotlin.runtime.client.endpoints.Endpoint r6 = (aws.smithy.kotlin.runtime.client.endpoints.Endpoint) r6
            aws.smithy.kotlin.runtime.http.middleware.ResolveEndpointKt.setResolvedEndpoint(r5, r6)
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint$modifyRequest$2 r1 = new aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint$modifyRequest$2
            r1.<init>()
            aws.smithy.kotlin.runtime.tracing.TraceSpan r6 = aws.smithy.kotlin.runtime.tracing.CoroutineContextUtilsKt.getTraceSpan(r0)
            aws.smithy.kotlin.runtime.tracing.EventLevel r0 = aws.smithy.kotlin.runtime.tracing.EventLevel.Debug
            java.lang.Class<aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint> r2 = aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint.class
            kotlin.jvm.internal.ClassReference r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getQualifiedName()
            if (r2 == 0) goto L67
            aws.smithy.kotlin.runtime.tracing.TraceSpanExtKt.log(r6, r0, r2, r1)
            return r5
        L67:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "log<T> cannot be used on an anonymous object"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint.modifyRequest(aws.smithy.kotlin.runtime.http.operation.OperationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
