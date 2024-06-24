package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleTimeout<T> extends Single<T> {
    public final SingleSource<? extends T> other;
    public final Scheduler scheduler;
    public final SingleSource<T> source;
    public final long timeout;
    public final TimeUnit unit;

    /* loaded from: classes.dex */
    public static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        public final SingleObserver<? super T> downstream;
        public final TimeoutFallbackObserver<T> fallback;
        public SingleSource<? extends T> other;
        public final AtomicReference<Disposable> task = new AtomicReference<>();
        public final long timeout;
        public final TimeUnit unit;

        /* loaded from: classes.dex */
        public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            public final SingleObserver<? super T> downstream;

            public TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.downstream = singleObserver;
            }

            @Override // io.reactivex.SingleObserver
            public final void onError(Throwable th) {
                this.downstream.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSuccess(T t) {
                this.downstream.onSuccess(t);
            }
        }

        public TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit) {
            this.downstream = singleObserver;
            this.other = singleSource;
            this.timeout = j;
            this.unit = timeUnit;
            if (singleSource != null) {
                this.fallback = new TimeoutFallbackObserver<>(singleObserver);
            } else {
                this.fallback = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.dispose(timeoutFallbackObserver);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.dispose(this.task);
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.dispose(this.task);
                this.downstream.onSuccess(t);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                if (disposable != null) {
                    disposable.dispose();
                }
                SingleSource<? extends T> singleSource = this.other;
                if (singleSource == null) {
                    ExceptionHelper.Termination termination = ExceptionHelper.TERMINATED;
                    this.downstream.onError(new TimeoutException("The source did not signal an event for " + this.timeout + " " + this.unit.toString().toLowerCase() + " and has been terminated."));
                    return;
                }
                this.other = null;
                singleSource.subscribe(this.fallback);
            }
        }
    }

    public SingleTimeout(SingleSource singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, Single single) {
        this.source = singleSource;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = single;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.other, this.timeout, this.unit);
        singleObserver.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.task, this.scheduler.scheduleDirect(timeoutMainObserver, this.timeout, this.unit));
        this.source.subscribe(timeoutMainObserver);
    }
}
