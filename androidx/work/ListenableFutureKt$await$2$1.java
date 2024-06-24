package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: ListenableFuture.kt */
/* loaded from: classes.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    public final /* synthetic */ CancellableContinuation<Object> $cancellableContinuation;
    public final /* synthetic */ ListenableFuture<Object> $this_await;

    public ListenableFutureKt$await$2$1(CancellableContinuationImpl cancellableContinuationImpl, ListenableFuture listenableFuture) {
        this.$cancellableContinuation = cancellableContinuationImpl;
        this.$this_await = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CancellableContinuation<Object> cancellableContinuation = this.$cancellableContinuation;
        try {
            cancellableContinuation.resumeWith(this.$this_await.get());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                cancellableContinuation.cancel(cause);
            } else {
                cancellableContinuation.resumeWith(ResultKt.createFailure(cause));
            }
        }
    }
}
