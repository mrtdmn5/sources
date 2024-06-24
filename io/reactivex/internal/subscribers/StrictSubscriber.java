package io.reactivex.internal.subscribers;

import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public final class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public volatile boolean done;
    public final Subscriber<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.done) {
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.done = true;
        Subscriber<? super T> subscriber = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        if (getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                subscriber.onError(terminate);
            } else {
                subscriber.onComplete();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.done = true;
        Subscriber<? super T> subscriber = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        if (atomicThrowable.addThrowable(th)) {
            if (getAndIncrement() == 0) {
                subscriber.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.downstream;
            subscriber.onNext(t);
            if (decrementAndGet() != 0) {
                Throwable terminate = this.error.terminate();
                if (terminate != null) {
                    subscriber.onError(terminate);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        } else {
            subscription.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("§3.9 violated: positive request amount required but it was ", j)));
        } else {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }
    }
}
