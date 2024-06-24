package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes4.dex */
public final class SubscriptionCountStateFlow extends SharedFlowImpl<Integer> implements StateFlow<Integer> {
    public SubscriptionCountStateFlow(int r4) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        tryEmit(Integer.valueOf(r4));
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public final Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            valueOf = Integer.valueOf(((Number) objArr[((int) ((this.replayIndex + ((int) ((getHead() + this.bufferSize) - this.replayIndex))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return valueOf;
    }
}
