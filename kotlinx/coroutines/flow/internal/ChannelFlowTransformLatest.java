package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Merge.kt */
/* loaded from: classes4.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {
    public final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> transform;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Flow<? extends T> flow, CoroutineContext coroutineContext, int r4, BufferOverflow bufferOverflow) {
        super(r4, coroutineContext, bufferOverflow, flow);
        this.transform = function3;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow<R> create(CoroutineContext coroutineContext, int r9, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.transform, this.flow, coroutineContext, r9, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public final Object flowCollect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ChannelFlowTransformLatest$flowCollect$3(this, flowCollector, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
