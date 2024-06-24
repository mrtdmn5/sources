package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: SafeCollector.kt */
/* loaded from: classes4.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T> {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final FlowCollector<T> collector;
    public Continuation<? super Unit> completion;
    public CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.INSTANCE, EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, new Function2<Integer, CoroutineContext.Element, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(Integer num, CoroutineContext.Element element) {
                return Integer.valueOf(num.intValue() + 1);
            }
        })).intValue();
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        try {
            Object emit = emit(continuation, (Continuation<? super Unit>) t);
            return emit == CoroutineSingletons.COROUTINE_SUSPENDED ? emit : Unit.INSTANCE;
        } catch (Throwable th) {
            this.lastEmissionContext = new DownstreamExceptionContext(continuation.getContext(), th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext == null) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
        if (m1661exceptionOrNullimpl != null) {
            this.lastEmissionContext = new DownstreamExceptionContext(getContext(), m1661exceptionOrNullimpl);
        }
        Continuation<? super Unit> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final void releaseIntercepted() {
        super.releaseIntercepted();
    }

    public final Object emit(Continuation<? super Unit> continuation, T t) {
        CoroutineContext context = continuation.getContext();
        JobKt.ensureActive(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            if (!(coroutineContext instanceof DownstreamExceptionContext)) {
                if (((Number) context.fold(0, new Function2<Integer, CoroutineContext.Element, Integer>(this) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
                    public final /* synthetic */ SafeCollector<?> $this_checkContext;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$this_checkContext = this;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Integer invoke(Integer num, CoroutineContext.Element element) {
                        int r4;
                        int intValue = num.intValue();
                        CoroutineContext.Element element2 = element;
                        CoroutineContext.Key<?> key = element2.getKey();
                        CoroutineContext.Element element3 = this.$this_checkContext.collectContext.get(key);
                        int r2 = Job.$r8$clinit;
                        if (key != Job.Key.$$INSTANCE) {
                            if (element2 != element3) {
                                r4 = Integer.MIN_VALUE;
                            } else {
                                r4 = intValue + 1;
                            }
                            return Integer.valueOf(r4);
                        }
                        Job job = (Job) element3;
                        Job job2 = (Job) element2;
                        while (true) {
                            if (job2 == null) {
                                job2 = null;
                                break;
                            }
                            if (job2 == job || !(job2 instanceof ScopeCoroutine)) {
                                break;
                            }
                            job2 = job2.getParent();
                        }
                        if (job2 == job) {
                            if (job != null) {
                                intValue++;
                            }
                            return Integer.valueOf(intValue);
                        }
                        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + job2 + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                    }
                })).intValue() == this.collectContextSize) {
                    this.lastEmissionContext = context;
                } else {
                    throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.collectContext + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
                }
            } else {
                throw new IllegalStateException(StringsKt__IndentKt.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((DownstreamExceptionContext) coroutineContext).e + ", but then emission attempt of value '" + t + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
        }
        this.completion = continuation;
        Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> function3 = SafeCollectorKt.emitFun;
        FlowCollector<T> flowCollector = this.collector;
        Intrinsics.checkNotNull(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object invoke = function3.invoke(flowCollector, t, this);
        if (!Intrinsics.areEqual(invoke, CoroutineSingletons.COROUTINE_SUSPENDED)) {
            this.completion = null;
        }
        return invoke;
    }
}
