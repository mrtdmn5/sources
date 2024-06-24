package io.reactivex.internal.operators.maybe;

import com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda3;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

    /* loaded from: classes.dex */
    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        public final MaybeObserver<? super R> downstream;
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public Disposable upstream;

        /* loaded from: classes.dex */
        public final class InnerObserver implements MaybeObserver<R> {
            public InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
            public final void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public final void onError(Throwable th) {
                FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSuccess(R r) {
                FlatMapMaybeObserver.this.downstream.onSuccess(r);
            }
        }

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.downstream = maybeObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            try {
                MaybeSource<? extends R> apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource<? extends R> maybeSource = apply;
                if (!isDisposed()) {
                    maybeSource.subscribe(new InnerObserver());
                }
            } catch (Exception e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }
    }

    public MaybeFlatten(ObservableElementAtMaybe observableElementAtMaybe, RxBleClientImpl$$ExternalSyntheticLambda3 rxBleClientImpl$$ExternalSyntheticLambda3) {
        super(observableElementAtMaybe);
        this.mapper = rxBleClientImpl$$ExternalSyntheticLambda3;
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new FlatMapMaybeObserver(maybeObserver, this.mapper));
    }
}
