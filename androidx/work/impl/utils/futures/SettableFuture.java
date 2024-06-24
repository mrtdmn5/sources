package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    public final boolean set(V v) {
        if (v == null) {
            v = (V) AbstractFuture.NULL;
        }
        if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, v)) {
            AbstractFuture.complete(this);
            return true;
        }
        return false;
    }

    public final boolean setException(Throwable throwable) {
        throwable.getClass();
        if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, new AbstractFuture.Failure(throwable))) {
            AbstractFuture.complete(this);
            return true;
        }
        return false;
    }

    public final boolean setFuture(ListenableFuture<? extends V> future) {
        AbstractFuture.Failure failure;
        future.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (future.isDone()) {
                if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, AbstractFuture.getFutureValue(future))) {
                    return false;
                }
                AbstractFuture.complete(this);
            } else {
                AbstractFuture.SetFuture setFuture = new AbstractFuture.SetFuture(this, future);
                if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, setFuture)) {
                    try {
                        future.addListener(setFuture, DirectExecutor.INSTANCE);
                    } catch (Throwable th) {
                        try {
                            failure = new AbstractFuture.Failure(th);
                        } catch (Throwable unused) {
                            failure = AbstractFuture.Failure.FALLBACK_INSTANCE;
                        }
                        AbstractFuture.ATOMIC_HELPER.casValue(this, setFuture, failure);
                    }
                } else {
                    obj = this.value;
                }
            }
            return true;
        }
        if (!(obj instanceof AbstractFuture.Cancellation)) {
            return false;
        }
        future.cancel(((AbstractFuture.Cancellation) obj).wasInterrupted);
        return false;
    }
}
