package io.reactivex;

import io.reactivex.android.schedulers.HandlerScheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class Observable<T> implements ObservableSource<T> {
    public static <T> Observable<T> error(Throwable th) {
        if (th != null) {
            return new ObservableError(new Functions.JustValue(th));
        }
        throw new NullPointerException("exception is null");
    }

    public static <T> Observable<T> fromArray(T... tArr) {
        if (tArr.length == 0) {
            return ObservableEmpty.INSTANCE;
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return new ObservableFromArray(tArr);
    }

    public static <T> Observable<T> just(T t) {
        if (t != null) {
            return new ObservableJust(t);
        }
        throw new NullPointerException("item is null");
    }

    public static Observable merge(ObservableSource observableSource, Observable observable) {
        if (observableSource != null) {
            if (observable != null) {
                return fromArray(observableSource, observable).flatMap(Functions.IDENTITY, 2);
            }
            throw new NullPointerException("source2 is null");
        }
        throw new NullPointerException("source1 is null");
    }

    public static ObservableTimer timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (timeUnit != null) {
            if (scheduler != null) {
                return new ObservableTimer(Math.max(j, 0L), timeUnit, scheduler);
            }
            throw new NullPointerException("scheduler is null");
        }
        throw new NullPointerException("unit is null");
    }

    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        if (observableTransformer != null) {
            Observable<R> apply = observableTransformer.apply(this);
            if (apply != null) {
                return apply;
            }
            throw new NullPointerException("source is null");
        }
        throw new NullPointerException("composer is null");
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (timeUnit != null) {
            if (scheduler != null) {
                return new ObservableDelay(this, j, timeUnit, scheduler);
            }
            throw new NullPointerException("scheduler is null");
        }
        throw new NullPointerException("unit is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Observable flatMap(Function function, int r4) {
        int r0 = Flowable.BUFFER_SIZE;
        if (function != null) {
            ObjectHelper.verifyPositive(r4, "maxConcurrency");
            ObjectHelper.verifyPositive(r0, "bufferSize");
            if (this instanceof ScalarCallable) {
                T call = ((ScalarCallable) this).call();
                if (call == null) {
                    return ObservableEmpty.INSTANCE;
                }
                return new ObservableScalarXMap.ScalarXMapObservable(function, call);
            }
            return new ObservableFlatMap(this, function, r4, r0);
        }
        throw new NullPointerException("mapper is null");
    }

    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        if (function != null) {
            return new ObservableMap(this, function);
        }
        throw new NullPointerException("mapper is null");
    }

    public final ObservableObserveOn observeOn(HandlerScheduler handlerScheduler) {
        int r0 = Flowable.BUFFER_SIZE;
        ObjectHelper.verifyPositive(r0, "bufferSize");
        return new ObservableObserveOn(this, handlerScheduler, r0);
    }

    public final Observable<T> startWith(T t) {
        if (t != null) {
            return new ObservableConcatMap(fromArray(just(t), this), Flowable.BUFFER_SIZE, ErrorMode.BOUNDARY);
        }
        throw new NullPointerException("item is null");
    }

    public final LambdaObserver subscribe(Consumer consumer, Consumer consumer2) {
        if (consumer != null) {
            LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2);
            subscribe(lambdaObserver);
            return lambdaObserver;
        }
        throw new NullPointerException("onNext is null");
    }

    public abstract void subscribeActual(Observer<? super T> observer);

    public final ObservableSubscribeOn subscribeOn(Scheduler scheduler) {
        if (scheduler != null) {
            return new ObservableSubscribeOn(this, scheduler);
        }
        throw new NullPointerException("scheduler is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        Observable<R> observableSwitchMap;
        int r0 = Flowable.BUFFER_SIZE;
        if (function != null) {
            ObjectHelper.verifyPositive(r0, "bufferSize");
            if (this instanceof ScalarCallable) {
                T call = ((ScalarCallable) this).call();
                if (call == null) {
                    return ObservableEmpty.INSTANCE;
                }
                observableSwitchMap = new ObservableScalarXMap.ScalarXMapObservable<>(function, call);
            } else {
                observableSwitchMap = new ObservableSwitchMap<>(this, function, r0);
            }
            return observableSwitchMap;
        }
        throw new NullPointerException("mapper is null");
    }

    public final ObservableUnsubscribeOn unsubscribeOn(Scheduler scheduler) {
        if (scheduler != null) {
            return new ObservableUnsubscribeOn(this, scheduler);
        }
        throw new NullPointerException("scheduler is null");
    }

    @Override // io.reactivex.ObservableSource
    public final void subscribe(Observer<? super T> observer) {
        if (observer != null) {
            try {
                subscribeActual(observer);
                return;
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        throw new NullPointerException("observer is null");
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap(function, Integer.MAX_VALUE);
    }
}
