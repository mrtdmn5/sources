package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX WARN: Unknown type variable: I in type: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware<I, O> */
/* JADX WARN: Unknown type variable: O in type: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware<I, O> */
/* compiled from: RetryMiddleware.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware", f = "RetryMiddleware.kt", l = {38, 47, 118}, m = "handle")
/* loaded from: classes.dex */
public final class RetryMiddleware$handle$1<H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends O>> extends ContinuationImpl {
    public Object L$0;
    public OperationRequest L$1;
    public Handler L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RetryMiddleware<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unknown type variable: I in type: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware<I, O> */
    /* JADX WARN: Unknown type variable: O in type: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware<I, O> */
    public RetryMiddleware$handle$1(RetryMiddleware<I, O> retryMiddleware, Continuation<? super RetryMiddleware$handle$1> continuation) {
        super(continuation);
        this.this$0 = retryMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle2((OperationRequest<HttpRequestBuilder>) null, (OperationRequest<HttpRequestBuilder>) null, this);
    }
}
