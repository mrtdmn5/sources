package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    public final Subscriber<? super T> subscriber;
    public final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public ScalarSubscription(Object obj, Subscriber subscriber) {
        this.subscriber = subscriber;
        this.value = obj;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(1);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            T t = this.value;
            Subscriber<? super T> subscriber = this.subscriber;
            subscriber.onNext(t);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int r1) {
        return r1 & 1;
    }
}
