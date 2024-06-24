package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.DisposableLambdaObserver;

/* loaded from: classes.dex */
public final class ObservableDoOnLifecycle<T> extends AbstractObservableWithUpstream<T, T> {
    public final Action onDispose;
    public final Consumer<? super Disposable> onSubscribe;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableDoOnLifecycle(Observable observable, Consumer consumer) {
        super(observable);
        Functions.EmptyAction emptyAction = Functions.EMPTY_ACTION;
        this.onSubscribe = consumer;
        this.onDispose = emptyAction;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DisposableLambdaObserver(observer, this.onSubscribe, this.onDispose));
    }
}
