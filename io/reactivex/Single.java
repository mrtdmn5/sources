package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class Single<T> implements SingleSource<T> {
    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        if (blockingMultiObserver.getCount() != 0) {
            try {
                blockingMultiObserver.await();
            } catch (InterruptedException e) {
                blockingMultiObserver.cancelled = true;
                Disposable disposable = blockingMultiObserver.upstream;
                if (disposable != null) {
                    disposable.dispose();
                }
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = blockingMultiObserver.error;
        if (th == null) {
            return blockingMultiObserver.value;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.SingleSource
    public final void subscribe(SingleObserver<? super T> singleObserver) {
        if (singleObserver != null) {
            try {
                subscribeActual(singleObserver);
                return;
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        throw new NullPointerException("observer is null");
    }

    public abstract void subscribeActual(SingleObserver<? super T> singleObserver);

    public final SingleTimeout timeout(long j, TimeUnit timeUnit, Scheduler scheduler, Single single) {
        if (single != null) {
            if (timeUnit != null) {
                if (scheduler != null) {
                    return new SingleTimeout(this, j, timeUnit, scheduler, single);
                }
                throw new NullPointerException("scheduler is null");
            }
            throw new NullPointerException("unit is null");
        }
        throw new NullPointerException("other is null");
    }
}
