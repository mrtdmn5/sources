package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes.dex */
public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    public final Predicate<? super T> predicate;

    /* loaded from: classes.dex */
    public static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        public final Predicate<? super T> filter;

        public FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.filter = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            int r0 = this.sourceMode;
            Observer<? super R> observer = this.downstream;
            if (r0 == 0) {
                try {
                    if (this.filter.test(t)) {
                        observer.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.dispose();
                    onError(th);
                    return;
                }
            }
            observer.onNext(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            T poll;
            do {
                poll = this.qd.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.filter.test(poll));
            return poll;
        }
    }

    public ObservableFilter(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.predicate = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new FilterObserver(observer, this.predicate));
    }
}
