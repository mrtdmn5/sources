package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {
    public final Callable<? extends T> callable;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        T call = this.callable.call();
        ObjectHelper.requireNonNull(call, "The callable returned a null value");
        return call;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            T call = this.callable.call();
            ObjectHelper.requireNonNull(call, "Callable returned null");
            deferredScalarDisposable.complete(call);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!deferredScalarDisposable.isDisposed()) {
                observer.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
