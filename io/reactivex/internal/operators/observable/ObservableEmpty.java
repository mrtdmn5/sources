package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

/* loaded from: classes.dex */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {
    public static final ObservableEmpty INSTANCE = new ObservableEmpty();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return null;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.complete(observer);
    }
}
