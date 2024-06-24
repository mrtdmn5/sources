package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* loaded from: classes.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    public abstract void connect(Consumer<? super Disposable> consumer);
}
