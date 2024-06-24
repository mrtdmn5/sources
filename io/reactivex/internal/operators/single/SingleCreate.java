package io.reactivex.internal.operators.single;

import com.polidea.rxandroidble2.internal.operations.ConnectOperation;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleCreate<T> extends Single<T> {
    public final SingleOnSubscribe<T> source;

    /* loaded from: classes.dex */
    public static final class Emitter<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {
        public final SingleObserver<? super T> downstream;

        public Emitter(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final String toString() {
            return String.format("%s{%s}", Emitter.class.getSimpleName(), super.toString());
        }

        public final boolean tryOnError(Throwable th) {
            Disposable andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && (andSet = getAndSet(disposableHelper)) != disposableHelper) {
                try {
                    this.downstream.onError(th);
                } finally {
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            }
            return false;
        }
    }

    public SingleCreate(ConnectOperation.AnonymousClass4 anonymousClass4) {
        this.source = anonymousClass4;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Emitter emitter = new Emitter(singleObserver);
        singleObserver.onSubscribe(emitter);
        try {
            ((ConnectOperation.AnonymousClass4) this.source).subscribe(emitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!emitter.tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
