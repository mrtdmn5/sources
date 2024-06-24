package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* compiled from: Builders.kt */
/* loaded from: classes4.dex */
public class ChannelFlowBuilder<T> extends ChannelFlow<T> {
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> block;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowBuilder(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int r3, BufferOverflow bufferOverflow) {
        super(coroutineContext, r3, bufferOverflow);
        this.block = function2;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }
}
