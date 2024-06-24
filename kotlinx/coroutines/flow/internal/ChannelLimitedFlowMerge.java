package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Merge.kt */
/* loaded from: classes4.dex */
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {
    public final Iterable<Flow<T>> flows;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge(Iterable<? extends Flow<? extends T>> iterable, CoroutineContext coroutineContext, int r3, BufferOverflow bufferOverflow) {
        super(coroutineContext, r3, bufferOverflow);
        this.flows = iterable;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        SendingCollector sendingCollector = new SendingCollector(producerScope);
        Iterator<Flow<T>> it = this.flows.iterator();
        while (it.hasNext()) {
            BuildersKt.launch$default(producerScope, null, null, new ChannelLimitedFlowMerge$collectTo$2$1(it.next(), sendingCollector, null), 3);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow<T> create(CoroutineContext coroutineContext, int r4, BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.flows, coroutineContext, r4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ProducerCoroutine produceImpl(CoroutineScope coroutineScope) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this, null);
        BufferOverflow bufferOverflow = BufferOverflow.SUSPEND;
        CoroutineStart coroutineStart = CoroutineStart.DEFAULT;
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, this.context), ChannelKt.Channel$default(this.capacity, bufferOverflow, 4));
        coroutineStart.invoke(channelFlow$collectToFun$1, producerCoroutine, producerCoroutine);
        return producerCoroutine;
    }
}
