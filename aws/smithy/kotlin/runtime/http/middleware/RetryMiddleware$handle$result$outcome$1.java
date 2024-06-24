package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.tracing.CoroutineContextUtilsKt;
import aws.smithy.kotlin.runtime.tracing.TraceSpan;
import aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: Add missing generic type declarations: [O] */
/* JADX WARN: Incorrect field signature: TH; */
/* compiled from: RetryMiddleware.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1", f = "RetryMiddleware.kt", l = {117}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RetryMiddleware$handle$result$outcome$1<O> extends SuspendLambda implements Function1<Continuation<? super O>, Object> {
    public final /* synthetic */ Ref$IntRef $attempt;
    public final /* synthetic */ OperationRequest<HttpRequestBuilder> $modified;
    public final /* synthetic */ Handler $next;
    public TraceSpan L$0;
    public int label;
    public final /* synthetic */ RetryMiddleware<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryMiddleware$handle$result$outcome$1(RetryMiddleware retryMiddleware, OperationRequest operationRequest, Handler handler, Continuation continuation, Ref$IntRef ref$IntRef) {
        super(1, continuation);
        this.$attempt = ref$IntRef;
        this.$modified = operationRequest;
        this.this$0 = retryMiddleware;
        this.$next = handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        Ref$IntRef ref$IntRef = this.$attempt;
        return new RetryMiddleware$handle$result$outcome$1(this.this$0, this.$modified, this.$next, continuation, ref$IntRef);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((RetryMiddleware$handle$result$outcome$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TraceSpan traceSpan;
        Throwable th;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                traceSpan = this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    th = th2;
                    traceSpan.close();
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineContext context = getContext();
            String str = "Attempt-" + this.$attempt.element;
            Ref$IntRef ref$IntRef = this.$attempt;
            OperationRequest<HttpRequestBuilder> operationRequest = this.$modified;
            RetryMiddleware<I, O> retryMiddleware = this.this$0;
            Handler handler = this.$next;
            TraceSpan child = CoroutineContextUtilsKt.getTraceSpan(context).child(str);
            try {
                TraceSpanContextElement traceSpanContextElement = new TraceSpanContextElement(child);
                RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1 retryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1 = new RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1(retryMiddleware, operationRequest, handler, null, ref$IntRef);
                this.L$0 = child;
                this.label = 1;
                Object withContext = BuildersKt.withContext(traceSpanContextElement, retryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1, this);
                if (withContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
                traceSpan = child;
                obj = withContext;
            } catch (Throwable th3) {
                traceSpan = child;
                th = th3;
                traceSpan.close();
                throw th;
            }
        }
        traceSpan.close();
        return obj;
    }
}
