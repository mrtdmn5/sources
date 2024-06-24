package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* compiled from: SharedFlow.kt */
/* loaded from: classes4.dex */
public final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {
    public CancellableContinuationImpl cont;
    public long index = -1;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean allocateLocked(AbstractSharedFlow abstractSharedFlow) {
        SharedFlowImpl sharedFlowImpl = (SharedFlowImpl) abstractSharedFlow;
        if (this.index >= 0) {
            return false;
        }
        long j = sharedFlowImpl.replayIndex;
        if (j < sharedFlowImpl.minCollectorIndex) {
            sharedFlowImpl.minCollectorIndex = j;
        }
        this.index = j;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final Continuation[] freeLocked(AbstractSharedFlow abstractSharedFlow) {
        long j = this.index;
        this.index = -1L;
        this.cont = null;
        return ((SharedFlowImpl) abstractSharedFlow).updateCollectorIndexLocked$kotlinx_coroutines_core(j);
    }
}
