package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class SingleFromCallable<T> extends Single<T> {
    public final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        RunnableDisposable runnableDisposable = new RunnableDisposable(Functions.EMPTY_RUNNABLE);
        singleObserver.onSubscribe(runnableDisposable);
        if (runnableDisposable.isDisposed()) {
            return;
        }
        try {
            T call = this.callable.call();
            ObjectHelper.requireNonNull(call, "The callable returned a null value");
            if (!runnableDisposable.isDisposed()) {
                singleObserver.onSuccess(call);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!runnableDisposable.isDisposed()) {
                singleObserver.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
