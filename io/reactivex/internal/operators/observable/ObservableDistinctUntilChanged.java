package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    public final BiPredicate<? super K, ? super K> comparer;
    public final Function<? super T, K> keySelector;

    /* loaded from: classes.dex */
    public static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        public final BiPredicate<? super K, ? super K> comparer;
        public boolean hasValue;
        public final Function<? super T, K> keySelector;
        public K last;

        public DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            int r0 = this.sourceMode;
            Observer<? super R> observer = this.downstream;
            if (r0 != 0) {
                observer.onNext(t);
                return;
            }
            try {
                K apply = this.keySelector.apply(t);
                if (this.hasValue) {
                    BiPredicate<? super K, ? super K> biPredicate = this.comparer;
                    K k = this.last;
                    ((ObjectHelper.BiObjectPredicate) biPredicate).getClass();
                    boolean equals = ObjectHelper.equals(k, apply);
                    this.last = apply;
                    if (equals) {
                        return;
                    }
                } else {
                    this.hasValue = true;
                    this.last = apply;
                }
                observer.onNext(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            while (true) {
                T poll = this.qd.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.keySelector.apply(poll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = apply;
                    return poll;
                }
                K k = this.last;
                ((ObjectHelper.BiObjectPredicate) this.comparer).getClass();
                if (!ObjectHelper.equals(k, apply)) {
                    this.last = apply;
                    return poll;
                }
                this.last = apply;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableDistinctUntilChanged(ObservableSource observableSource) {
        super(observableSource);
        Functions.Identity identity = Functions.IDENTITY;
        ObjectHelper.BiObjectPredicate biObjectPredicate = ObjectHelper.EQUALS;
        this.keySelector = identity;
        this.comparer = biObjectPredicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DistinctUntilChangedObserver(observer, this.keySelector, this.comparer));
    }
}
