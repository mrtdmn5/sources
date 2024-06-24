package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes4.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    public SubscriptionCountStateFlow _subscriptionCount;
    public int nCollectors;
    public int nextIndex;
    public S[] slots;

    public final S allocateSlot() {
        S s;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            S[] sArr = this.slots;
            if (sArr == null) {
                sArr = (S[]) createSlotArray();
                this.slots = sArr;
            } else if (this.nCollectors >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.slots = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                sArr = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
            }
            int r1 = this.nextIndex;
            do {
                s = sArr[r1];
                if (s == null) {
                    s = createSlot();
                    sArr[r1] = s;
                }
                r1++;
                if (r1 >= sArr.length) {
                    r1 = 0;
                }
                Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s.allocateLocked(this));
            this.nextIndex = r1;
            this.nCollectors++;
            subscriptionCountStateFlow = this._subscriptionCount;
        }
        if (subscriptionCountStateFlow != null) {
            synchronized (subscriptionCountStateFlow) {
                Object[] objArr = subscriptionCountStateFlow.buffer;
                Intrinsics.checkNotNull(objArr);
                subscriptionCountStateFlow.tryEmit(Integer.valueOf(((Number) objArr[((int) ((subscriptionCountStateFlow.replayIndex + ((int) ((subscriptionCountStateFlow.getHead() + subscriptionCountStateFlow.bufferSize) - subscriptionCountStateFlow.replayIndex))) - 1)) & (objArr.length - 1)]).intValue() + 1));
            }
        }
        return s;
    }

    public abstract S createSlot();

    public abstract AbstractSharedFlowSlot[] createSlotArray();

    public final void freeSlot(S s) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int r2;
        Continuation[] freeLocked;
        synchronized (this) {
            int r0 = this.nCollectors - 1;
            this.nCollectors = r0;
            subscriptionCountStateFlow = this._subscriptionCount;
            if (r0 == 0) {
                this.nextIndex = 0;
            }
            Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            freeLocked = s.freeLocked(this);
        }
        for (Continuation continuation : freeLocked) {
            if (continuation != null) {
                continuation.resumeWith(Unit.INSTANCE);
            }
        }
        if (subscriptionCountStateFlow != null) {
            synchronized (subscriptionCountStateFlow) {
                Intrinsics.checkNotNull(subscriptionCountStateFlow.buffer);
                subscriptionCountStateFlow.tryEmit(Integer.valueOf(((Number) r9[((int) ((subscriptionCountStateFlow.replayIndex + ((int) ((subscriptionCountStateFlow.getHead() + subscriptionCountStateFlow.bufferSize) - subscriptionCountStateFlow.replayIndex))) - 1)) & (r9.length - 1)]).intValue() - 1));
            }
        }
    }

    public final SubscriptionCountStateFlow getSubscriptionCount() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this._subscriptionCount;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.nCollectors);
                this._subscriptionCount = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }
}
