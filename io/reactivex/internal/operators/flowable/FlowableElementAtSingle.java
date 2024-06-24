package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public final class FlowableElementAtSingle<T> extends Single<T> {
    public final Flowable<T> source;
    public final long index = 0;
    public final T defaultValue = null;

    /* loaded from: classes.dex */
    public static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        public long count;
        public final T defaultValue;
        public boolean done;
        public final SingleObserver<? super T> downstream;
        public final long index;
        public Subscription upstream;

        public ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j, T t) {
            this.downstream = singleObserver;
            this.index = j;
            this.defaultValue = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.upstream == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            if (!this.done) {
                this.done = true;
                SingleObserver<? super T> singleObserver = this.downstream;
                T t = this.defaultValue;
                if (t != null) {
                    singleObserver.onSuccess(t);
                } else {
                    singleObserver.onError(new NoSuchElementException());
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.count;
            if (j == this.index) {
                this.done = true;
                this.upstream.cancel();
                this.upstream = SubscriptionHelper.CANCELLED;
                this.downstream.onSuccess(t);
                return;
            }
            this.count = j + 1;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAtSingle(FlowableFlatMapPublisher flowableFlatMapPublisher) {
        this.source = flowableFlatMapPublisher;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((FlowableSubscriber) new ElementAtSubscriber(singleObserver, this.index, this.defaultValue));
    }
}
