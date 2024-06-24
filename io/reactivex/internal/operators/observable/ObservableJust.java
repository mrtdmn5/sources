package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* loaded from: classes.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {
    public final T value;

    public ObservableJust(T t) {
        this.value = t;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        return this.value;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(this.value, observer);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
