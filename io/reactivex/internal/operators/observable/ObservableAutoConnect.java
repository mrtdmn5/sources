package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class ObservableAutoConnect<T> extends Observable<T> {
    public final AtomicInteger clients;
    public final Consumer<? super Disposable> connection;
    public final int numberOfObservers;
    public final ConnectableObservable<? extends T> source;

    public ObservableAutoConnect(ConnectableObservable connectableObservable, int r3) {
        Functions.EmptyConsumer emptyConsumer = Functions.EMPTY_CONSUMER;
        this.source = connectableObservable;
        this.numberOfObservers = r3;
        this.connection = emptyConsumer;
        this.clients = new AtomicInteger();
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        ConnectableObservable<? extends T> connectableObservable = this.source;
        connectableObservable.subscribe(observer);
        if (this.clients.incrementAndGet() == this.numberOfObservers) {
            connectableObservable.connect(this.connection);
        }
    }
}
