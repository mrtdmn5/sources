package kotlinx.coroutines.channels;

import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public final class ReceiveCatching<E> implements Waiter {
    public final CancellableContinuationImpl<ChannelResult<? extends E>> cont;

    /* JADX WARN: Multi-variable type inference failed */
    public ReceiveCatching(CancellableContinuationImpl<? super ChannelResult<? extends E>> cancellableContinuationImpl) {
        this.cont = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment<?> segment, int r3) {
        this.cont.invokeOnCancellation(segment, r3);
    }
}
