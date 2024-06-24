package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;

/* compiled from: Merge.kt */
/* loaded from: classes4.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    public final int concurrency;
    public final Flow<Flow<T>> flow;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(Flow<? extends Flow<? extends T>> flow, int r2, CoroutineContext coroutineContext, int r4, BufferOverflow bufferOverflow) {
        super(coroutineContext, r4, bufferOverflow);
        this.flow = flow;
        this.concurrency = r2;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String additionalToStringProps() {
        return "concurrency=" + this.concurrency;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        int r0 = SemaphoreKt.MAX_SPIN_CYCLES;
        Object collect = this.flow.collect(new ChannelFlowMerge$collectTo$2((Job) continuation.getContext().get(Job.Key.$$INSTANCE), new SemaphoreImpl(this.concurrency, 0), producerScope, new SendingCollector(producerScope)), continuation);
        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow<T> create(CoroutineContext coroutineContext, int r9, BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.flow, this.concurrency, coroutineContext, r9, bufferOverflow);
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
