package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RetryMiddleware.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware", f = "RetryMiddleware.kt", l = {79, 87}, m = "tryAttempt-BWLJW6A")
/* loaded from: classes.dex */
public final class RetryMiddleware$tryAttempt$1 extends ContinuationImpl {
    public int I$0;
    public RetryMiddleware L$0;
    public Object L$1;
    public HttpRequestBuilderView L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RetryMiddleware<Object, Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryMiddleware$tryAttempt$1(RetryMiddleware<Object, Object> retryMiddleware, Continuation<? super RetryMiddleware$tryAttempt$1> continuation) {
        super(continuation);
        this.this$0 = retryMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m619access$tryAttemptBWLJW6A = RetryMiddleware.m619access$tryAttemptBWLJW6A(this.this$0, null, null, 0, this);
        if (m619access$tryAttemptBWLJW6A == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m619access$tryAttemptBWLJW6A;
        }
        return new Result(m619access$tryAttemptBWLJW6A);
    }
}
