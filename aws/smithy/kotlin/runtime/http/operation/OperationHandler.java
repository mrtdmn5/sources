package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.io.Handler;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class OperationHandler<Input, Output> implements Handler<OperationRequest<Input>, Output> {
    public final Handler<OperationRequest<Input>, Output> inner;
    public final InterceptorExecutor<Input, Output> interceptors;

    /* JADX WARN: Multi-variable type inference failed */
    public OperationHandler(Handler<? super OperationRequest<Input>, ? extends Output> handler, InterceptorExecutor<Input, Output> interceptorExecutor) {
        this.inner = handler;
        this.interceptors = interceptorExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.smithy.kotlin.runtime.io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object call(aws.smithy.kotlin.runtime.http.operation.OperationRequest<Input> r11, kotlin.coroutines.Continuation<? super Output> r12) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.OperationHandler.call(aws.smithy.kotlin.runtime.http.operation.OperationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
