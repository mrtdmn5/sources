package io.reactivex.internal.operators.single;

import com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {
    public final Consumer<? super Disposable> onSubscribe;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
        public boolean done;
        public final SingleObserver<? super T> downstream;
        public final Consumer<? super Disposable> onSubscribe;

        public DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.downstream = singleObserver;
            this.onSubscribe = consumer;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            SingleObserver<? super T> singleObserver = this.downstream;
            try {
                this.onSubscribe.accept(disposable);
                singleObserver.onSubscribe(disposable);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.done = true;
                disposable.dispose();
                EmptyDisposable.error(th, singleObserver);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            if (this.done) {
                return;
            }
            this.downstream.onSuccess(t);
        }
    }

    public SingleDoOnSubscribe(SingleCache singleCache, ServiceDiscoveryManager.AnonymousClass1 anonymousClass1) {
        this.source = singleCache;
        this.onSubscribe = anonymousClass1;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnSubscribeSingleObserver(singleObserver, this.onSubscribe));
    }
}
