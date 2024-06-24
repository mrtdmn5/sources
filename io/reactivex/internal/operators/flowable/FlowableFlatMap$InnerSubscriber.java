package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public final class FlowableFlatMap$InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;
    public final long id;
    public final int limit;
    public final FlowableFlatMap$MergeSubscriber<T, U> parent;
    public long produced;
    public volatile SimpleQueue<U> queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber<T, U> flowableFlatMap$MergeSubscriber, long j) {
        this.id = j;
        this.parent = flowableFlatMap$MergeSubscriber;
        int r1 = flowableFlatMap$MergeSubscriber.bufferSize;
        this.bufferSize = r1;
        this.limit = r1 >> 2;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        lazySet(SubscriptionHelper.CANCELLED);
        FlowableFlatMap$MergeSubscriber<T, U> flowableFlatMap$MergeSubscriber = this.parent;
        if (flowableFlatMap$MergeSubscriber.errs.addThrowable(th)) {
            this.done = true;
            if (!flowableFlatMap$MergeSubscriber.delayErrors) {
                flowableFlatMap$MergeSubscriber.upstream.cancel();
                for (FlowableFlatMap$InnerSubscriber<?, ?> flowableFlatMap$InnerSubscriber : flowableFlatMap$MergeSubscriber.subscribers.getAndSet(FlowableFlatMap$MergeSubscriber.CANCELLED)) {
                    flowableFlatMap$InnerSubscriber.getClass();
                    SubscriptionHelper.cancel(flowableFlatMap$InnerSubscriber);
                }
            }
            flowableFlatMap$MergeSubscriber.drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(U u) {
        if (this.fusionMode != 2) {
            FlowableFlatMap$MergeSubscriber<T, U> flowableFlatMap$MergeSubscriber = this.parent;
            if (flowableFlatMap$MergeSubscriber.get() == 0 && flowableFlatMap$MergeSubscriber.compareAndSet(0, 1)) {
                long j = flowableFlatMap$MergeSubscriber.requested.get();
                SimpleQueue simpleQueue = this.queue;
                if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    flowableFlatMap$MergeSubscriber.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        flowableFlatMap$MergeSubscriber.requested.decrementAndGet();
                    }
                    requestMore(1L);
                } else {
                    if (simpleQueue == null && (simpleQueue = this.queue) == null) {
                        simpleQueue = new SpscArrayQueue(flowableFlatMap$MergeSubscriber.bufferSize);
                        this.queue = simpleQueue;
                    }
                    if (!simpleQueue.offer(u)) {
                        flowableFlatMap$MergeSubscriber.onError(new MissingBackpressureException(0));
                        return;
                    }
                }
                if (flowableFlatMap$MergeSubscriber.decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue2 = this.queue;
                if (simpleQueue2 == null) {
                    simpleQueue2 = new SpscArrayQueue(flowableFlatMap$MergeSubscriber.bufferSize);
                    this.queue = simpleQueue2;
                }
                if (!simpleQueue2.offer(u)) {
                    flowableFlatMap$MergeSubscriber.onError(new MissingBackpressureException(0));
                    return;
                } else if (flowableFlatMap$MergeSubscriber.getAndIncrement() != 0) {
                    return;
                }
            }
            flowableFlatMap$MergeSubscriber.drainLoop();
            return;
        }
        this.parent.drain();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                }
            }
            subscription.request(this.bufferSize);
        }
    }

    public final void requestMore(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 >= this.limit) {
                this.produced = 0L;
                get().request(j2);
            } else {
                this.produced = j2;
            }
        }
    }
}
