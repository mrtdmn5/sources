package io.reactivex.internal.operators.mixed;

import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleFlatMapObservable<T, R> extends Observable<R> {
    public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, SingleObserver<T>, Disposable {
        public final Observer<? super R> downstream;
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

        public FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                ObservableSource<? extends R> apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The mapper returned a null Publisher");
                apply.subscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }
    }

    public SingleFlatMapObservable(SingleMap singleMap, ClientStateObservable.AnonymousClass4 anonymousClass4) {
        this.source = singleMap;
        this.mapper = anonymousClass4;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.mapper);
        observer.onSubscribe(flatMapObserver);
        this.source.subscribe(flatMapObserver);
    }
}
