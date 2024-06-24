package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* compiled from: Produce.kt */
/* loaded from: classes4.dex */
public final class ProducerCoroutine<E> extends ChannelCoroutine<E> implements ProducerScope<E> {
    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        if (!this._channel.close(th) && !z) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.context, th);
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Unit unit) {
        this._channel.close(null);
    }
}
