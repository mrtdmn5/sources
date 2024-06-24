package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes.dex */
public class DeferredScalarSubscription<T> extends AtomicInteger implements QueueSubscription<Object> {
    public final Subscriber<? super T> downstream;
    public T value;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.value;
        this.value = null;
        return t;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        T t;
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        do {
            int r2 = get();
            if ((r2 & (-2)) != 0) {
                return;
            }
            if (r2 == 1) {
                if (compareAndSet(1, 3) && (t = this.value) != null) {
                    this.value = null;
                    Subscriber<? super T> subscriber = this.downstream;
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int r2) {
        if ((r2 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }
}
