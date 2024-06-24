package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class SerializeHandler<Input, Output> implements Handler<OperationRequest<Input>, Output> {
    public final Handler<OperationRequest<HttpRequestBuilder>, Output> inner;
    public final InterceptorExecutor<Input, Output> interceptors;
    public final Function3<ExecutionContext, Input, Continuation<? super HttpRequestBuilder>, Object> mapRequest;

    public SerializeHandler(Handler handler, SdkOperationExecutionKt$decorate$2 sdkOperationExecutionKt$decorate$2, InterceptorExecutor interceptorExecutor) {
        this.inner = handler;
        this.mapRequest = sdkOperationExecutionKt$decorate$2;
        this.interceptors = interceptorExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081 A[LOOP:1: B:35:0x007b->B:37:0x0081, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, I, java.lang.Object] */
    @Override // aws.smithy.kotlin.runtime.io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object call(aws.smithy.kotlin.runtime.http.operation.OperationRequest<Input> r11, kotlin.coroutines.Continuation<? super Output> r12) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.SerializeHandler.call(aws.smithy.kotlin.runtime.http.operation.OperationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
