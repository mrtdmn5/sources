package aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal;

import aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.EndpointParameters;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider;
import aws.smithy.kotlin.runtime.http.interceptors.HttpAttemptInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpFinalInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpInputInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpInputOutputInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResolveEndpoint.kt */
/* loaded from: classes.dex */
public final class ResolveEndpoint<I> implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    public final Function2<EndpointParameters.Builder, I, Unit> buildParams;
    public final EndpointProvider<EndpointParameters> endpointProvider;
    public EndpointParameters params;

    /* JADX WARN: Multi-variable type inference failed */
    public ResolveEndpoint(EndpointProvider<EndpointParameters> endpointProvider, Function2<? super EndpointParameters.Builder, ? super I, Unit> function2) {
        Intrinsics.checkNotNullParameter(endpointProvider, "endpointProvider");
        this.endpointProvider = endpointProvider;
        this.buildParams = function2;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    public final Object mo615modifyBeforeAttemptCompletiongIAlus(HttpAttemptInterceptorContext httpAttemptInterceptorContext) {
        return httpAttemptInterceptorContext.response;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* renamed from: modifyBeforeCompletion-gIAlu-s */
    public final Object mo616modifyBeforeCompletiongIAlus(HttpFinalInterceptorContext httpFinalInterceptorContext) {
        return httpFinalInterceptorContext.response;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final Object modifyBeforeDeserialization(HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext) {
        return httpProtocolResponseInterceptorContext.protocolResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r5v10, types: [aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext] */
    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyBeforeRetryLoop(aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint$modifyBeforeRetryLoop$1
            if (r0 == 0) goto L13
            r0 = r6
            aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint$modifyBeforeRetryLoop$1 r0 = (aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint$modifyBeforeRetryLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint$modifyBeforeRetryLoop$1 r0 = new aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint$modifyBeforeRetryLoop$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.EndpointParameters r6 = r4.params
            if (r6 == 0) goto L91
            r0.L$0 = r5
            r0.label = r3
            aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider<aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.EndpointParameters> r2 = r4.endpointProvider
            java.lang.Object r6 = r2.resolveEndpoint(r6, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            aws.smithy.kotlin.runtime.client.endpoints.Endpoint r6 = (aws.smithy.kotlin.runtime.client.endpoints.Endpoint) r6
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint$modifyBeforeRetryLoop$2 r1 = new aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint$modifyBeforeRetryLoop$2
            r1.<init>()
            aws.smithy.kotlin.runtime.tracing.TraceSpan r0 = aws.smithy.kotlin.runtime.tracing.CoroutineContextUtilsKt.getTraceSpan(r0)
            aws.smithy.kotlin.runtime.tracing.EventLevel r2 = aws.smithy.kotlin.runtime.tracing.EventLevel.Debug
            java.lang.Class<aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint> r3 = aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint.class
            kotlin.jvm.internal.ClassReference r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.String r3 = r3.getQualifiedName()
            if (r3 == 0) goto L85
            aws.smithy.kotlin.runtime.tracing.TraceSpanExtKt.log(r0, r2, r3, r1)
            aws.smithy.kotlin.runtime.http.request.HttpRequest r0 = r5.getProtocolRequest()
            aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder r0 = aws.smithy.kotlin.runtime.http.request.HttpRequestKt.toBuilder(r0)
            aws.smithy.kotlin.runtime.http.operation.OperationRequest r1 = new aws.smithy.kotlin.runtime.http.operation.OperationRequest
            aws.smithy.kotlin.runtime.operation.ExecutionContext r5 = r5.getExecutionContext()
            r1.<init>(r5, r0)
            aws.smithy.kotlin.runtime.http.middleware.ResolveEndpointKt.setResolvedEndpoint(r1, r6)
            aws.sdk.kotlin.runtime.endpoint.AuthSchemeKt.getAuthScheme(r6)
            T r5 = r1.subject
            aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder r5 = (aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder) r5
            aws.smithy.kotlin.runtime.http.request.RealHttpRequest r5 = r5.build()
            return r5
        L85:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "log<T> cannot be used on an anonymous object"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L91:
            java.lang.String r5 = "params"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint.modifyBeforeRetryLoop(aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final Object modifyBeforeSerialization(HttpInputInterceptorContext httpInputInterceptorContext) {
        return httpInputInterceptorContext.request;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final Object modifyBeforeSigning(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext) {
        return httpProtocolRequestInterceptorContext.protocolRequest;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final Object modifyBeforeTransmit(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext) {
        return httpProtocolRequestInterceptorContext.protocolRequest;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readBeforeSerialization(HttpInputInterceptorContext httpInputInterceptorContext) {
        I r3 = httpInputInterceptorContext.request;
        EndpointParameters.Builder builder = new EndpointParameters.Builder();
        this.buildParams.invoke(builder, r3);
        this.params = new EndpointParameters(builder);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readAfterAttempt(HttpAttemptInterceptorContext httpAttemptInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readAfterDeserialization(HttpInputOutputInterceptorContext httpInputOutputInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readAfterExecution(HttpFinalInterceptorContext httpFinalInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readAfterSerialization(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readAfterSigning(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readAfterTransmit(HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readBeforeAttempt(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readBeforeDeserialization(HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readBeforeExecution(HttpInputInterceptorContext httpInputInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readBeforeSigning(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext) {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public final void readBeforeTransmit(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext) {
    }
}
