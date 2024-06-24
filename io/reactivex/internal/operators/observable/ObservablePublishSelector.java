package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

    /* loaded from: classes.dex */
    public static final class SourceObserver<T, R> implements Observer<T> {
        public final PublishSubject<T> subject;
        public final AtomicReference<Disposable> target;

        public SourceObserver(PublishSubject publishSubject, TargetObserver targetObserver) {
            this.subject = publishSubject;
            this.target = targetObserver;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.subject.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.subject.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.subject.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.target, disposable);
        }
    }

    /* loaded from: classes.dex */
    public static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        public final Observer<? super R> downstream;
        public Disposable upstream;

        public TargetObserver(Observer<? super R> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.selector = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        PublishSubject publishSubject = new PublishSubject();
        try {
            ObservableSource<R> apply = this.selector.apply(publishSubject);
            ObjectHelper.requireNonNull(apply, "The selector returned a null ObservableSource");
            ObservableSource<R> observableSource = apply;
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.source.subscribe(new SourceObserver(publishSubject, targetObserver));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
