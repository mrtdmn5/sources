package kotlinx.coroutines.flow.internal;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    public final int capacity;
    public final CoroutineContext context;
    public final BufferOverflow onBufferOverflow;

    public ChannelFlow(CoroutineContext coroutineContext, int r2, BufferOverflow bufferOverflow) {
        this.context = coroutineContext;
        this.capacity = r2;
        this.onBufferOverflow = bufferOverflow;
    }

    public String additionalToStringProps() {
        return null;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ChannelFlow$collect$2(null, flowCollector, this), continuation);
        if (coroutineScope != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return Unit.INSTANCE;
        }
        return coroutineScope;
    }

    public abstract Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    public abstract ChannelFlow<T> create(CoroutineContext coroutineContext, int r2, BufferOverflow bufferOverflow);

    public Flow<T> dropChannelOperators() {
        return null;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow<T> fuse(CoroutineContext coroutineContext, int r6, BufferOverflow bufferOverflow) {
        CoroutineContext coroutineContext2 = this.context;
        CoroutineContext plus = coroutineContext.plus(coroutineContext2);
        BufferOverflow bufferOverflow2 = BufferOverflow.SUSPEND;
        BufferOverflow bufferOverflow3 = this.onBufferOverflow;
        int r3 = this.capacity;
        if (bufferOverflow == bufferOverflow2) {
            if (r3 != -3) {
                if (r6 != -3) {
                    if (r3 != -2) {
                        if (r6 != -2) {
                            r6 += r3;
                            if (r6 < 0) {
                                r6 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                r6 = r3;
            }
            bufferOverflow = bufferOverflow3;
        }
        if (Intrinsics.areEqual(plus, coroutineContext2) && r6 == r3 && bufferOverflow == bufferOverflow3) {
            return this;
        }
        return create(plus, r6, bufferOverflow);
    }

    public ProducerCoroutine produceImpl(CoroutineScope coroutineScope) {
        int r1 = this.capacity;
        if (r1 == -3) {
            r1 = -2;
        }
        CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this, null);
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, this.context), ChannelKt.Channel$default(r1, this.onBufferOverflow, 4));
        coroutineStart.invoke(channelFlow$collectToFun$1, producerCoroutine, producerCoroutine);
        return producerCoroutine;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String additionalToStringProps = additionalToStringProps();
        if (additionalToStringProps != null) {
            arrayList.add(additionalToStringProps);
        }
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext = this.context;
        if (coroutineContext != emptyCoroutineContext) {
            arrayList.add("context=" + coroutineContext);
        }
        int r2 = this.capacity;
        if (r2 != -3) {
            arrayList.add("capacity=" + r2);
        }
        BufferOverflow bufferOverflow = BufferOverflow.SUSPEND;
        BufferOverflow bufferOverflow2 = this.onBufferOverflow;
        if (bufferOverflow2 != bufferOverflow) {
            arrayList.add("onBufferOverflow=" + bufferOverflow2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, null, 62), ']');
    }
}
