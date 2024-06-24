package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleObserveOn<T> extends Single<T> {
    public final Scheduler scheduler;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        public final SingleObserver<? super T> downstream;
        public Throwable error;
        public final Scheduler scheduler;
        public T value;

        public ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.downstream = singleObserver;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.value = t;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        @Override // java.lang.Runnable
        public final void run() {
            Throwable th = this.error;
            SingleObserver<? super T> singleObserver = this.downstream;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.value);
            }
        }
    }

    public SingleObserveOn(Single single, Scheduler scheduler) {
        this.source = single;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ObserveOnSingleObserver(singleObserver, this.scheduler));
    }
}
