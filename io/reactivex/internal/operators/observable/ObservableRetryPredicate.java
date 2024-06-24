package io.reactivex.internal.operators.observable;

import com.polidea.rxandroidble2.internal.connection.MtuWatcher;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    public final long count;
    public final Predicate<? super Throwable> predicate;

    /* loaded from: classes.dex */
    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        public final Observer<? super T> downstream;
        public final Predicate<? super Throwable> predicate;
        public long remaining;
        public final ObservableSource<? extends T> source;
        public final SequentialDisposable upstream;

        public RepeatObserver(Observer<? super T> observer, long j, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.upstream = sequentialDisposable;
            this.source = observableSource;
            this.predicate = predicate;
            this.remaining = j;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            Observer<? super T> observer = this.downstream;
            if (j == 0) {
                observer.onError(th);
                return;
            }
            try {
                if (!this.predicate.test(th)) {
                    observer.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                observer.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            SequentialDisposable sequentialDisposable = this.upstream;
            sequentialDisposable.getClass();
            DisposableHelper.replace(sequentialDisposable, disposable);
        }

        public final void subscribeNext() {
            if (getAndIncrement() == 0) {
                int r0 = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    r0 = addAndGet(-r0);
                    if (r0 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryPredicate(Observable observable, MtuWatcher.AnonymousClass1 anonymousClass1) {
        super(observable);
        this.predicate = anonymousClass1;
        this.count = Long.MAX_VALUE;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.count, this.predicate, sequentialDisposable, this.source).subscribeNext();
    }
}
