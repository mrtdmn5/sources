package io.reactivex.internal.operators.single;

import com.polidea.rxandroidble2.internal.operations.ConnectOperation;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class SingleDoFinally<T> extends Single<T> {
    public final Action onFinally;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        public final SingleObserver<? super T> downstream;
        public final Action onFinally;
        public Disposable upstream;

        public DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.downstream = singleObserver;
            this.onFinally = action;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
            runFinally();
        }

        public final void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public SingleDoFinally(Single single, ConnectOperation.AnonymousClass1 anonymousClass1) {
        this.source = single;
        this.onFinally = anonymousClass1;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoFinallyObserver(singleObserver, this.onFinally));
    }
}
