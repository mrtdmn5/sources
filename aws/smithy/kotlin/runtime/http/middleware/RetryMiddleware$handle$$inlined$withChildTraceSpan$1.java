package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [O] */
/* compiled from: CoroutineContextUtils.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$$inlined$withChildTraceSpan$1", f = "RetryMiddleware.kt", l = {228}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RetryMiddleware$handle$$inlined$withChildTraceSpan$1<O> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends O>>, Object> {
    public final /* synthetic */ Ref$IntRef $attempt$inlined;
    public final /* synthetic */ OperationRequest $modified$inlined;
    public final /* synthetic */ Handler $next$inlined;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RetryMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryMiddleware$handle$$inlined$withChildTraceSpan$1(RetryMiddleware retryMiddleware, OperationRequest operationRequest, Handler handler, Continuation continuation, Ref$IntRef ref$IntRef) {
        super(2, continuation);
        this.this$0 = retryMiddleware;
        this.$modified$inlined = operationRequest;
        this.$next$inlined = handler;
        this.$attempt$inlined = ref$IntRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RetryMiddleware$handle$$inlined$withChildTraceSpan$1 retryMiddleware$handle$$inlined$withChildTraceSpan$1 = new RetryMiddleware$handle$$inlined$withChildTraceSpan$1(this.this$0, this.$modified$inlined, this.$next$inlined, continuation, this.$attempt$inlined);
        retryMiddleware$handle$$inlined$withChildTraceSpan$1.L$0 = obj;
        return retryMiddleware$handle$$inlined$withChildTraceSpan$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((RetryMiddleware$handle$$inlined$withChildTraceSpan$1) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m619access$tryAttemptBWLJW6A;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
                m619access$tryAttemptBWLJW6A = ((Result) obj).value;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            int r5 = this.$attempt$inlined.element;
            this.label = 1;
            m619access$tryAttemptBWLJW6A = RetryMiddleware.m619access$tryAttemptBWLJW6A(this.this$0, this.$modified$inlined, this.$next$inlined, r5, this);
            if (m619access$tryAttemptBWLJW6A == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return new Result(m619access$tryAttemptBWLJW6A);
    }
}
