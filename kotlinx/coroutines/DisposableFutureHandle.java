package kotlinx.coroutines;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

/* compiled from: Executors.kt */
/* loaded from: classes4.dex */
public final class DisposableFutureHandle implements DisposableHandle {
    public final Future<?> future;

    public DisposableFutureHandle(ScheduledFuture scheduledFuture) {
        this.future = scheduledFuture;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        this.future.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.future + ']';
    }
}
