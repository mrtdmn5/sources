package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableAmb<T> extends Observable<T> {
    public final ObservableSource<? extends T>[] sources = null;
    public final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    /* loaded from: classes.dex */
    public static final class AmbCoordinator<T> implements Disposable {
        public final Observer<? super T> downstream;
        public final AmbInnerObserver<T>[] observers;
        public final AtomicInteger winner = new AtomicInteger();

        public AmbCoordinator(Observer<? super T> observer, int r3) {
            this.downstream = observer;
            this.observers = new AmbInnerObserver[r3];
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            AtomicInteger atomicInteger = this.winner;
            if (atomicInteger.get() != -1) {
                atomicInteger.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.observers) {
                    ambInnerObserver.getClass();
                    DisposableHelper.dispose(ambInnerObserver);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.winner.get() == -1) {
                return true;
            }
            return false;
        }

        public final boolean win(int r6) {
            AtomicInteger atomicInteger = this.winner;
            int r1 = atomicInteger.get();
            int r3 = 0;
            if (r1 == 0) {
                if (!atomicInteger.compareAndSet(0, r6)) {
                    return false;
                }
                AmbInnerObserver<T>[] ambInnerObserverArr = this.observers;
                int length = ambInnerObserverArr.length;
                while (r3 < length) {
                    int r4 = r3 + 1;
                    if (r4 != r6) {
                        AmbInnerObserver<T> ambInnerObserver = ambInnerObserverArr[r3];
                        ambInnerObserver.getClass();
                        DisposableHelper.dispose(ambInnerObserver);
                    }
                    r3 = r4;
                }
                return true;
            }
            if (r1 == r6) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        public final Observer<? super T> downstream;
        public final int index;
        public final AmbCoordinator<T> parent;
        public boolean won;

        public AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int r2, Observer<? super T> observer) {
            this.parent = ambCoordinator;
            this.index = r2;
            this.downstream = observer;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            boolean z = this.won;
            Observer<? super T> observer = this.downstream;
            if (z) {
                observer.onComplete();
            } else if (this.parent.win(this.index)) {
                this.won = true;
                observer.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            boolean z = this.won;
            Observer<? super T> observer = this.downstream;
            if (z) {
                observer.onError(th);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                observer.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            boolean z = this.won;
            Observer<? super T> observer = this.downstream;
            if (z) {
                observer.onNext(t);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                observer.onNext(t);
            } else {
                get().dispose();
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableAmb(List list) {
        this.sourcesIterable = list;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        int length;
        Observer<? super T> observer2;
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                    if (observableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (length == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int r5 = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = r5;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(observer);
            return;
        }
        if (length == 1) {
            observableSourceArr[0].subscribe(observer);
            return;
        }
        AmbCoordinator ambCoordinator = new AmbCoordinator(observer, length);
        AmbInnerObserver<T>[] ambInnerObserverArr = ambCoordinator.observers;
        int length2 = ambInnerObserverArr.length;
        int r4 = 0;
        while (true) {
            observer2 = ambCoordinator.downstream;
            if (r4 >= length2) {
                break;
            }
            int r7 = r4 + 1;
            ambInnerObserverArr[r4] = new AmbInnerObserver<>(ambCoordinator, r7, observer2);
            r4 = r7;
        }
        AtomicInteger atomicInteger = ambCoordinator.winner;
        atomicInteger.lazySet(0);
        observer2.onSubscribe(ambCoordinator);
        for (int r1 = 0; r1 < length2 && atomicInteger.get() == 0; r1++) {
            observableSourceArr[r1].subscribe(ambInnerObserverArr[r1]);
        }
    }
}
