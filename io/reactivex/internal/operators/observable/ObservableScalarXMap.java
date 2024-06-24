package io.reactivex.internal.operators.observable;

import android.Manifest;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class ObservableScalarXMap {

    /* loaded from: classes.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        public final Observer<? super T> observer;
        public final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public ScalarDisposable(Object obj, Observer observer) {
            this.observer = observer;
            this.value = obj;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (get() == 3) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            if (get() != 1) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.value;
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r2) {
            if ((r2 & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                T t = this.value;
                Observer<? super T> observer = this.observer;
                observer.onNext(t);
                if (get() == 2) {
                    lazySet(3);
                    observer.onComplete();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class ScalarXMapObservable<T, R> extends Observable<R> {
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public ScalarXMapObservable(Function function, Object obj) {
            this.value = obj;
            this.mapper = function;
        }

        @Override // io.reactivex.Observable
        public final void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource<? extends R> apply = this.mapper.apply(this.value);
                ObjectHelper.requireNonNull(apply, "The mapper returned a null ObservableSource");
                ObservableSource<? extends R> observableSource = apply;
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.complete(observer);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(call, observer);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptyDisposable.error(th, observer);
                        return;
                    }
                }
                observableSource.subscribe(observer);
            } catch (Throwable th2) {
                EmptyDisposable.error(th2, observer);
            }
        }
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (observableSource instanceof Callable) {
            try {
                Manifest manifest = (Object) ((Callable) observableSource).call();
                if (manifest == null) {
                    EmptyDisposable.complete(observer);
                    return true;
                }
                try {
                    ObservableSource<? extends R> apply = function.apply(manifest);
                    ObjectHelper.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    ObservableSource<? extends R> observableSource2 = apply;
                    if (observableSource2 instanceof Callable) {
                        try {
                            Object call = ((Callable) observableSource2).call();
                            if (call == null) {
                                EmptyDisposable.complete(observer);
                                return true;
                            }
                            ScalarDisposable scalarDisposable = new ScalarDisposable(call, observer);
                            observer.onSubscribe(scalarDisposable);
                            scalarDisposable.run();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptyDisposable.error(th, observer);
                            return true;
                        }
                    } else {
                        observableSource2.subscribe(observer);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptyDisposable.error(th2, observer);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptyDisposable.error(th3, observer);
                return true;
            }
        }
        return false;
    }
}
