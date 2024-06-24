package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes.dex */
public final class SingleToFlowable<T> extends Flowable<T> {
    public final SingleSource<? extends T> source;

    /* loaded from: classes.dex */
    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        public Disposable upstream;

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            set(4);
            this.value = null;
            this.upstream.dispose();
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
            int r0 = get();
            do {
                Subscriber<? super T> subscriber = this.downstream;
                if (r0 == 8) {
                    this.value = t;
                    lazySet(16);
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                if ((r0 & (-3)) == 0) {
                    if (r0 == 2) {
                        lazySet(3);
                        subscriber.onNext(t);
                        if (get() != 4) {
                            subscriber.onComplete();
                            return;
                        }
                        return;
                    }
                    this.value = t;
                    if (!compareAndSet(0, 1)) {
                        r0 = get();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (r0 != 4);
            this.value = null;
        }
    }

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    @Override // io.reactivex.Flowable
    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SingleToFlowableObserver(subscriber));
    }
}
