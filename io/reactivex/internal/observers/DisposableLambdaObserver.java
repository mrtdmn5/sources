package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    public final Observer<? super T> downstream;
    public final Action onDispose;
    public final Consumer<? super Disposable> onSubscribe;
    public Disposable upstream;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.downstream = observer;
        this.onSubscribe = consumer;
        this.onDispose = action;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Disposable disposable = this.upstream;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.upstream = disposableHelper;
            try {
                this.onDispose.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        Disposable disposable = this.upstream;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.upstream = disposableHelper;
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        Disposable disposable = this.upstream;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.upstream = disposableHelper;
            this.downstream.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        Observer<? super T> observer = this.downstream;
        try {
            this.onSubscribe.accept(disposable);
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                observer.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, observer);
        }
    }
}
