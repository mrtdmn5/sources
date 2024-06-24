package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    public final Flow<S> flow;

    public ChannelFlowOperator(int r1, CoroutineContext coroutineContext, BufferOverflow bufferOverflow, Flow flow) {
        super(coroutineContext, r1, bufferOverflow);
        this.flow = flow;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        CoroutineContext foldCopies;
        boolean z;
        if (this.capacity == -3) {
            CoroutineContext context = continuation.getContext();
            Boolean bool = Boolean.FALSE;
            CoroutineContextKt$hasCopyableElements$1 coroutineContextKt$hasCopyableElements$1 = CoroutineContextKt$hasCopyableElements$1.INSTANCE;
            CoroutineContext coroutineContext = this.context;
            if (!((Boolean) coroutineContext.fold(bool, coroutineContextKt$hasCopyableElements$1)).booleanValue()) {
                foldCopies = context.plus(coroutineContext);
            } else {
                foldCopies = CoroutineContextKt.foldCopies(context, coroutineContext, false);
            }
            if (Intrinsics.areEqual(foldCopies, context)) {
                Object flowCollect = flowCollect(flowCollector, continuation);
                if (flowCollect != CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return Unit.INSTANCE;
                }
                return flowCollect;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.Key.$$INSTANCE;
            if (Intrinsics.areEqual(foldCopies.get(key), context.get(key))) {
                CoroutineContext context2 = continuation.getContext();
                if (flowCollector instanceof SendingCollector) {
                    z = true;
                } else {
                    z = flowCollector instanceof NopCollector;
                }
                if (!z) {
                    flowCollector = new UndispatchedContextCollector(flowCollector, context2);
                }
                Object withContextUndispatched = ChannelFlowKt.withContextUndispatched(foldCopies, flowCollector, ThreadContextKt.threadContextElements(foldCopies), new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (withContextUndispatched != coroutineSingletons) {
                    withContextUndispatched = Unit.INSTANCE;
                }
                if (withContextUndispatched != coroutineSingletons) {
                    return Unit.INSTANCE;
                }
                return withContextUndispatched;
            }
        }
        Object collect = super.collect(flowCollector, continuation);
        if (collect != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return Unit.INSTANCE;
        }
        return collect;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object flowCollect = flowCollect(new SendingCollector(producerScope), continuation);
        if (flowCollect != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return Unit.INSTANCE;
        }
        return flowCollect;
    }

    public abstract Object flowCollect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return this.flow + " -> " + super.toString();
    }
}
