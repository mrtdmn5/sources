package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes.dex */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    public final Function<? super T, ? extends U> function;

    /* loaded from: classes.dex */
    public static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        public final Function<? super T, ? extends U> mapper;

        public MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.mapper = function;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            int r0 = this.sourceMode;
            Observer<? super R> observer = this.downstream;
            if (r0 != 0) {
                observer.onNext(null);
                return;
            }
            try {
                U apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The mapper function returned a null value.");
                observer.onNext(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final U poll() throws Exception {
            T poll = this.qd.poll();
            if (poll != null) {
                U apply = this.mapper.apply(poll);
                ObjectHelper.requireNonNull(apply, "The mapper function returned a null value.");
                return apply;
            }
            return null;
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.function = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new MapObserver(observer, this.function));
    }
}
