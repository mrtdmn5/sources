package io.reactivex.internal.operators.maybe;

import com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleFromCallable;

/* loaded from: classes.dex */
public final class MaybeFilterSingle<T> extends Maybe<T> {
    public final Predicate<? super T> predicate;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {
        public final MaybeObserver<? super T> downstream;
        public final Predicate<? super T> predicate;
        public Disposable upstream;

        public FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.downstream = maybeObserver;
            this.predicate = predicate;
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

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
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
            MaybeObserver<? super T> maybeObserver = this.downstream;
            try {
                if (this.predicate.test(t)) {
                    maybeObserver.onSuccess(t);
                } else {
                    maybeObserver.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                maybeObserver.onError(th);
            }
        }
    }

    public MaybeFilterSingle(SingleFromCallable singleFromCallable, ServiceDiscoveryManager.AnonymousClass5 anonymousClass5) {
        this.source = singleFromCallable;
        this.predicate = anonymousClass5;
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new FilterMaybeObserver(maybeObserver, this.predicate));
    }
}
