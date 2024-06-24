package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public final class ChannelFlowOperatorImpl<T> extends ChannelFlowOperator<T, T> {
    public ChannelFlowOperatorImpl(Flow flow, CoroutineDispatcher coroutineDispatcher, int r4, BufferOverflow bufferOverflow, int r6) {
        super((r6 & 4) != 0 ? -3 : r4, (r6 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineDispatcher, (r6 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow, flow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow<T> create(CoroutineContext coroutineContext, int r4, BufferOverflow bufferOverflow) {
        return new ChannelFlowOperatorImpl(r4, coroutineContext, bufferOverflow, this.flow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Flow<T> dropChannelOperators() {
        return (Flow<T>) this.flow;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public final Object flowCollect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(flowCollector, continuation);
        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
