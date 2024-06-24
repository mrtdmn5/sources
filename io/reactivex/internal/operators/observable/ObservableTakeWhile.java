package io.reactivex.internal.operators.observable;

import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {
    public final Predicate<? super T> predicate;

    /* loaded from: classes.dex */
    public static final class TakeWhileObserver<T> implements Observer<T>, Disposable {
        public boolean done;
        public final Observer<? super T> downstream;
        public final Predicate<? super T> predicate;
        public Disposable upstream;

        public TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.downstream = observer;
            this.predicate = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                boolean test = this.predicate.test(t);
                Observer<? super T> observer = this.downstream;
                if (!test) {
                    this.done = true;
                    this.upstream.dispose();
                    observer.onComplete();
                    return;
                }
                observer.onNext(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableTakeWhile(ObservableInterval observableInterval, ClientStateObservable.AnonymousClass2 anonymousClass2) {
        super(observableInterval);
        this.predicate = anonymousClass2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeWhileObserver(observer, this.predicate));
    }
}
