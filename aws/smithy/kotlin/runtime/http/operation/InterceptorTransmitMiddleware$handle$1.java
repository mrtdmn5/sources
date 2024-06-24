package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX WARN: Unknown type variable: I in type: aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware<I, O> */
/* JADX WARN: Unknown type variable: O in type: aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware<I, O> */
/* compiled from: SdkOperationExecution.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware", f = "SdkOperationExecution.kt", l = {337, 340}, m = "handle")
/* loaded from: classes.dex */
public final class InterceptorTransmitMiddleware$handle$1<H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> extends ContinuationImpl {
    public InterceptorTransmitMiddleware L$0;
    public OperationRequest L$1;
    public Handler L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InterceptorTransmitMiddleware<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unknown type variable: I in type: aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware<I, O> */
    /* JADX WARN: Unknown type variable: O in type: aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware<I, O> */
    public InterceptorTransmitMiddleware$handle$1(InterceptorTransmitMiddleware<I, O> interceptorTransmitMiddleware, Continuation<? super InterceptorTransmitMiddleware$handle$1> continuation) {
        super(continuation);
        this.this$0 = interceptorTransmitMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle2((OperationRequest<HttpRequestBuilder>) null, (OperationRequest<HttpRequestBuilder>) null, this);
    }
}
