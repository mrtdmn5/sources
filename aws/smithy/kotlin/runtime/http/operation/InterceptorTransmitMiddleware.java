package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.io.middleware.Middleware;
import kotlin.coroutines.Continuation;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class InterceptorTransmitMiddleware<I, O> implements Middleware<OperationRequest<HttpRequestBuilder>, HttpCall> {
    public final InterceptorExecutor<I, O> interceptors;

    public InterceptorTransmitMiddleware(InterceptorExecutor<I, O> interceptorExecutor) {
        this.interceptors = interceptorExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: handle, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <H extends aws.smithy.kotlin.runtime.io.Handler<? super aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder>, ? extends aws.smithy.kotlin.runtime.http.response.HttpCall>> java.lang.Object handle2(aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder> r10, H r11, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.http.response.HttpCall> r12) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware.handle2(aws.smithy.kotlin.runtime.http.operation.OperationRequest, aws.smithy.kotlin.runtime.io.Handler, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // aws.smithy.kotlin.runtime.io.middleware.Middleware
    public final /* bridge */ /* synthetic */ Object handle(OperationRequest<HttpRequestBuilder> operationRequest, Handler handler, Continuation<? super HttpCall> continuation) {
        return handle2(operationRequest, (OperationRequest<HttpRequestBuilder>) handler, continuation);
    }
}
