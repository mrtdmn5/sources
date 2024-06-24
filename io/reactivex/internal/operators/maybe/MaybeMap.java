package io.reactivex.internal.operators.maybe;

import com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes.dex */
public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {
    public final Function<? super T, ? extends R> mapper;

    /* loaded from: classes.dex */
    public static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
        public final MaybeObserver<? super R> downstream;
        public final Function<? super T, ? extends R> mapper;
        public Disposable upstream;

        public MapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends R> function) {
            this.downstream = maybeObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable disposable = this.upstream;
            this.upstream = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
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
            MaybeObserver<? super R> maybeObserver = this.downstream;
            try {
                R apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The mapper returned a null item");
                maybeObserver.onSuccess(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                maybeObserver.onError(th);
            }
        }
    }

    public MaybeMap(MaybeFilterSingle maybeFilterSingle, ServiceDiscoveryManager.AnonymousClass4 anonymousClass4) {
        super(maybeFilterSingle);
        this.mapper = anonymousClass4;
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new MapMaybeObserver(maybeObserver, this.mapper));
    }
}
