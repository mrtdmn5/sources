package kotlinx.coroutines.flow;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: SharingStarted.kt */
/* loaded from: classes4.dex */
public final class StartedWhileSubscribed implements SharingStarted {
    public final long replayExpiration;
    public final long stopTimeout;

    public StartedWhileSubscribed(long j, long j2) {
        boolean z;
        this.stopTimeout = j;
        this.replayExpiration = j2;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (j2 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public final Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this, null);
        int r0 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        final ChannelFlowTransformLatest channelFlowTransformLatest = new ChannelFlowTransformLatest(startedWhileSubscribed$command$1, stateFlow, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
        final StartedWhileSubscribed$command$2 startedWhileSubscribed$command$2 = new StartedWhileSubscribed$command$2(null);
        return FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
                Object collect = channelFlowTransformLatest.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), flowCollector, startedWhileSubscribed$command$2), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public final int hashCode() {
        return Long.hashCode(this.replayExpiration) + (Long.hashCode(this.stopTimeout) * 31);
    }

    public final String toString() {
        ListBuilder listBuilder = new ListBuilder(2);
        long j = this.stopTimeout;
        if (j > 0) {
            listBuilder.add("stopTimeout=" + j + "ms");
        }
        long j2 = this.replayExpiration;
        if (j2 < Long.MAX_VALUE) {
            listBuilder.add("replayExpiration=" + j2 + "ms");
        }
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SharingStarted.WhileSubscribed("), CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.build(listBuilder), null, null, null, null, 63), ')');
    }
}
