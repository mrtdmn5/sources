package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class DeserializeHandler<Input, Output> implements Handler<OperationRequest<HttpRequestBuilder>, Output> {
    public final Handler<OperationRequest<HttpRequestBuilder>, HttpCall> inner;
    public final InterceptorExecutor<Input, Output> interceptors;
    public final Function3<ExecutionContext, HttpResponse, Continuation<? super Output>, Object> mapResponse;

    public DeserializeHandler(Handler handler, SdkOperationExecutionKt$decorate$3 sdkOperationExecutionKt$decorate$3, InterceptorExecutor interceptorExecutor) {
        this.inner = handler;
        this.mapResponse = sdkOperationExecutionKt$decorate$3;
        this.interceptors = interceptorExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // aws.smithy.kotlin.runtime.io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object call(aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder> r13, kotlin.coroutines.Continuation<? super Output> r14) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.DeserializeHandler.call(aws.smithy.kotlin.runtime.http.operation.OperationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
