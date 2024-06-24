package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleFlatMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class MaybeSwitchIfEmptySingle<T> extends Single<T> {
    public final SingleSource<? extends T> other;
    public final MaybeSource<T> source;

    /* loaded from: classes.dex */
    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        public final SingleObserver<? super T> downstream;
        public final SingleSource<? extends T> other;

        /* loaded from: classes.dex */
        public static final class OtherSingleObserver<T> implements SingleObserver<T> {
            public final SingleObserver<? super T> downstream;
            public final AtomicReference<Disposable> parent;

            public OtherSingleObserver(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
                this.downstream = singleObserver;
                this.parent = atomicReference;
            }

            @Override // io.reactivex.SingleObserver
            public final void onError(Throwable th) {
                this.downstream.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.parent, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSuccess(T t) {
                this.downstream.onSuccess(t);
            }
        }

        public SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.downstream = singleObserver;
            this.other = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            Disposable disposable = get();
            if (disposable != DisposableHelper.DISPOSED && compareAndSet(disposable, null)) {
                this.other.subscribe(new OtherSingleObserver(this.downstream, this));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmptySingle(MaybeMap maybeMap, SingleFlatMap singleFlatMap) {
        this.source = maybeMap;
        this.other = singleFlatMap;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new SwitchIfEmptyMaybeObserver(singleObserver, this.other));
    }
}
