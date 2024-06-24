package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SendingCollector.kt */
/* loaded from: classes4.dex */
public final class SendingCollector<T> implements FlowCollector<T> {
    public final SendChannel<T> channel;

    /* JADX WARN: Multi-variable type inference failed */
    public SendingCollector(SendChannel<? super T> sendChannel) {
        this.channel = sendChannel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        Object send = this.channel.send(t, continuation);
        if (send == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return send;
        }
        return Unit.INSTANCE;
    }
}
