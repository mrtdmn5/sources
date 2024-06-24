package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* compiled from: Share.kt */
/* loaded from: classes4.dex */
public final class ReadonlyStateFlow<T> implements StateFlow<T>, Flow, FusibleFlow<T> {
    public final /* synthetic */ StateFlow<T> $$delegate_0;
    public final Job job;

    public ReadonlyStateFlow(StateFlowImpl stateFlowImpl, StandaloneCoroutine standaloneCoroutine) {
        this.job = standaloneCoroutine;
        this.$$delegate_0 = stateFlowImpl;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return this.$$delegate_0.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow<T> fuse(CoroutineContext coroutineContext, int r3, BufferOverflow bufferOverflow) {
        boolean z;
        if (r3 >= 0 && r3 < 2) {
            z = true;
        } else {
            z = false;
        }
        if (((z || r3 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) || ((r3 == 0 || r3 == -3) && bufferOverflow == BufferOverflow.SUSPEND)) {
            return this;
        }
        return new ChannelFlowOperatorImpl(r3, coroutineContext, bufferOverflow, this);
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public final T getValue() {
        return this.$$delegate_0.getValue();
    }
}
