package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.tracing.CoroutineContextUtilsKt;
import aws.smithy.kotlin.runtime.tracing.EventLevel;
import aws.smithy.kotlin.runtime.tracing.TraceSpan;
import aws.smithy.kotlin.runtime.tracing.TraceSpanExtKt;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [O] */
/* compiled from: CoroutineContextUtils.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1", f = "RetryMiddleware.kt", l = {238}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1<O> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super O>, Object> {
    public final /* synthetic */ Ref$IntRef $attempt$inlined;
    public final /* synthetic */ OperationRequest $modified$inlined;
    public final /* synthetic */ Handler $next$inlined;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RetryMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1(RetryMiddleware retryMiddleware, OperationRequest operationRequest, Handler handler, Continuation continuation, Ref$IntRef ref$IntRef) {
        super(2, continuation);
        this.$attempt$inlined = ref$IntRef;
        this.$modified$inlined = operationRequest;
        this.this$0 = retryMiddleware;
        this.$next$inlined = handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Ref$IntRef ref$IntRef = this.$attempt$inlined;
        RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1 retryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1 = new RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1(this.this$0, this.$modified$inlined, this.$next$inlined, continuation, ref$IntRef);
        retryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1.L$0 = obj;
        return retryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((RetryMiddleware$handle$result$outcome$1$invokeSuspend$$inlined$withChildTraceSpan$1) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m619access$tryAttemptBWLJW6A;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        final Ref$IntRef ref$IntRef = this.$attempt$inlined;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
                m619access$tryAttemptBWLJW6A = ((Result) obj).value;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (ref$IntRef.element > 1) {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                Function0<Object> function0 = new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return "retrying request, attempt " + Ref$IntRef.this.element;
                    }
                };
                TraceSpan traceSpan = CoroutineContextUtilsKt.getTraceSpan(coroutineContext);
                EventLevel eventLevel = EventLevel.Debug;
                String qualifiedName = Reflection.getOrCreateKotlinClass(RetryMiddleware.class).getQualifiedName();
                if (qualifiedName != null) {
                    TraceSpanExtKt.log(traceSpan, eventLevel, qualifiedName, function0);
                } else {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
            }
            OperationRequest operationRequest = this.$modified$inlined;
            Intrinsics.checkNotNullParameter(operationRequest, "<this>");
            OperationRequest operationRequest2 = new OperationRequest(operationRequest.context, ((CanDeepCopy) operationRequest.subject).deepCopy());
            int r7 = ref$IntRef.element;
            this.label = 1;
            m619access$tryAttemptBWLJW6A = RetryMiddleware.m619access$tryAttemptBWLJW6A(this.this$0, operationRequest2, this.$next$inlined, r7, this);
            if (m619access$tryAttemptBWLJW6A == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        ref$IntRef.element++;
        ResultKt.throwOnFailure(m619access$tryAttemptBWLJW6A);
        return m619access$tryAttemptBWLJW6A;
    }
}
