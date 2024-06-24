package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public final class FlowableFlatMap$MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final Subscriber<? super U> downstream;
    public final AtomicThrowable errs = new AtomicThrowable();
    public long lastId;
    public int lastIndex;
    public final Function<? super T, ? extends Publisher<? extends U>> mapper;
    public final int maxConcurrency;
    public volatile SimplePlainQueue<U> queue;
    public final AtomicLong requested;
    public int scalarEmitted;
    public final int scalarLimit;
    public final AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> subscribers;
    public long uniqueId;
    public Subscription upstream;
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] EMPTY = new FlowableFlatMap$InnerSubscriber[0];
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] CANCELLED = new FlowableFlatMap$InnerSubscriber[0];

    public FlowableFlatMap$MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int r6, int r7) {
        AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
        this.subscribers = atomicReference;
        this.requested = new AtomicLong();
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = r6;
        this.bufferSize = r7;
        this.scalarLimit = Math.max(1, r6 >> 1);
        atomicReference.lazySet(EMPTY);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SimplePlainQueue<U> simplePlainQueue;
        FlowableFlatMap$InnerSubscriber<?, ?>[] andSet;
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> atomicReference = this.subscribers;
            FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr = atomicReference.get();
            FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = CANCELLED;
            if (flowableFlatMap$InnerSubscriberArr != flowableFlatMap$InnerSubscriberArr2 && (andSet = atomicReference.getAndSet(flowableFlatMap$InnerSubscriberArr2)) != flowableFlatMap$InnerSubscriberArr2) {
                for (FlowableFlatMap$InnerSubscriber<?, ?> flowableFlatMap$InnerSubscriber : andSet) {
                    flowableFlatMap$InnerSubscriber.getClass();
                    SubscriptionHelper.cancel(flowableFlatMap$InnerSubscriber);
                }
                Throwable terminate = this.errs.terminate();
                if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                    RxJavaPlugins.onError(terminate);
                }
            }
            if (getAndIncrement() == 0 && (simplePlainQueue = this.queue) != null) {
                simplePlainQueue.clear();
            }
        }
    }

    public final boolean checkTerminate() {
        if (this.cancelled) {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
            return true;
        }
        if (!this.delayErrors && this.errs.get() != null) {
            SimplePlainQueue<U> simplePlainQueue2 = this.queue;
            if (simplePlainQueue2 != null) {
                simplePlainQueue2.clear();
            }
            Throwable terminate = this.errs.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.downstream.onError(terminate);
            }
            return true;
        }
        return false;
    }

    public final void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void drainLoop() {
        boolean z;
        int r18;
        long j;
        long j2;
        boolean z2;
        int r7;
        long j3;
        Object obj;
        Subscriber<? super U> subscriber = this.downstream;
        int r4 = 1;
        while (!checkTerminate()) {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            long j4 = this.requested.get();
            if (j4 == Long.MAX_VALUE) {
                z = true;
            } else {
                z = false;
            }
            long j5 = 0;
            long j6 = 0;
            if (simplePlainQueue != null) {
                do {
                    long j7 = 0;
                    obj = null;
                    while (true) {
                        if (j4 == 0) {
                            break;
                        }
                        U poll = simplePlainQueue.poll();
                        if (checkTerminate()) {
                            return;
                        }
                        if (poll == null) {
                            obj = poll;
                            break;
                        }
                        subscriber.onNext(poll);
                        j6++;
                        j7++;
                        j4--;
                        obj = poll;
                    }
                    if (j7 != 0) {
                        if (z) {
                            j4 = Long.MAX_VALUE;
                        } else {
                            j4 = this.requested.addAndGet(-j7);
                        }
                    }
                    if (j4 == 0) {
                        break;
                    }
                } while (obj != null);
            }
            boolean z3 = this.done;
            SimplePlainQueue<U> simplePlainQueue2 = this.queue;
            FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr = this.subscribers.get();
            int length = flowableFlatMap$InnerSubscriberArr.length;
            if (z3 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                Throwable terminate = this.errs.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    if (terminate == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(terminate);
                        return;
                    }
                }
                return;
            }
            if (length != 0) {
                r18 = r4;
                long j8 = this.lastId;
                int r0 = this.lastIndex;
                if (length <= r0 || flowableFlatMap$InnerSubscriberArr[r0].id != j8) {
                    if (length <= r0) {
                        r0 = 0;
                    }
                    for (int r72 = 0; r72 < length && flowableFlatMap$InnerSubscriberArr[r0].id != j8; r72++) {
                        r0++;
                        if (r0 == length) {
                            r0 = 0;
                        }
                    }
                    this.lastIndex = r0;
                    this.lastId = flowableFlatMap$InnerSubscriberArr[r0].id;
                }
                int r3 = r0;
                boolean z4 = false;
                int r42 = 0;
                while (true) {
                    if (r42 < length) {
                        if (checkTerminate()) {
                            return;
                        }
                        FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber = flowableFlatMap$InnerSubscriberArr[r3];
                        Object obj2 = null;
                        while (!checkTerminate()) {
                            SimpleQueue<U> simpleQueue = flowableFlatMap$InnerSubscriber.queue;
                            int r13 = length;
                            if (simpleQueue != null) {
                                Object obj3 = obj2;
                                long j9 = j5;
                                while (true) {
                                    if (j4 == j5) {
                                        break;
                                    }
                                    try {
                                        U poll2 = simpleQueue.poll();
                                        if (poll2 == null) {
                                            obj3 = poll2;
                                            j5 = 0;
                                            break;
                                        }
                                        subscriber.onNext(poll2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        j4--;
                                        j9++;
                                        obj3 = poll2;
                                        j5 = 0;
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        SubscriptionHelper.cancel(flowableFlatMap$InnerSubscriber);
                                        this.errs.addThrowable(th);
                                        if (!this.delayErrors) {
                                            this.upstream.cancel();
                                        }
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(flowableFlatMap$InnerSubscriber);
                                        r42++;
                                        z4 = true;
                                        r7 = 1;
                                    }
                                }
                                if (j9 != j5) {
                                    if (!z) {
                                        j4 = this.requested.addAndGet(-j9);
                                    } else {
                                        j4 = Long.MAX_VALUE;
                                    }
                                    flowableFlatMap$InnerSubscriber.requestMore(j9);
                                    j3 = 0;
                                } else {
                                    j3 = j5;
                                }
                                if (j4 != j3 && obj3 != null) {
                                    length = r13;
                                    obj2 = obj3;
                                    j5 = 0;
                                }
                            }
                            boolean z5 = flowableFlatMap$InnerSubscriber.done;
                            SimpleQueue<U> simpleQueue2 = flowableFlatMap$InnerSubscriber.queue;
                            if (z5 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                removeInner(flowableFlatMap$InnerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                j6++;
                                z4 = true;
                            }
                            if (j4 == 0) {
                                z2 = z4;
                                break;
                            }
                            r3++;
                            if (r3 == r13) {
                                r3 = 0;
                            }
                            r7 = 1;
                            r42 += r7;
                            length = r13;
                            j5 = 0;
                        }
                        return;
                    }
                    z2 = z4;
                    break;
                }
                this.lastIndex = r3;
                this.lastId = flowableFlatMap$InnerSubscriberArr[r3].id;
                j2 = j6;
                j = 0;
            } else {
                r18 = r4;
                j = 0;
                j2 = j6;
                z2 = false;
            }
            if (j2 != j && !this.cancelled) {
                this.upstream.request(j2);
            }
            if (z2) {
                r4 = r18;
            } else {
                r4 = addAndGet(-r18);
                if (r4 == 0) {
                    return;
                }
            }
        }
    }

    public final SimplePlainQueue getMainQueue() {
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (simplePlainQueue == null) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                simplePlainQueue = new SpscLinkedArrayQueue<>(this.bufferSize);
            } else {
                simplePlainQueue = new SpscArrayQueue<>(this.maxConcurrency);
            }
            this.queue = simplePlainQueue;
        }
        return simplePlainQueue;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        if (this.errs.addThrowable(th)) {
            this.done = true;
            if (!this.delayErrors) {
                for (FlowableFlatMap$InnerSubscriber<?, ?> flowableFlatMap$InnerSubscriber : this.subscribers.getAndSet(CANCELLED)) {
                    flowableFlatMap$InnerSubscriber.getClass();
                    SubscriptionHelper.cancel(flowableFlatMap$InnerSubscriber);
                }
            }
            drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        boolean z;
        if (this.done) {
            return;
        }
        try {
            Publisher<? extends U> apply = this.mapper.apply(t);
            ObjectHelper.requireNonNull(apply, "The mapper returned a null Publisher");
            Publisher<? extends U> publisher = apply;
            boolean z2 = true;
            if (publisher instanceof Callable) {
                try {
                    Object call = ((Callable) publisher).call();
                    if (call != null) {
                        if (get() == 0 && compareAndSet(0, 1)) {
                            long j = this.requested.get();
                            SimplePlainQueue<U> simplePlainQueue = this.queue;
                            if (j != 0 && (simplePlainQueue == 0 || simplePlainQueue.isEmpty())) {
                                this.downstream.onNext(call);
                                if (j != Long.MAX_VALUE) {
                                    this.requested.decrementAndGet();
                                }
                                if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                                    int r10 = this.scalarEmitted + 1;
                                    this.scalarEmitted = r10;
                                    int r0 = this.scalarLimit;
                                    if (r10 == r0) {
                                        this.scalarEmitted = 0;
                                        this.upstream.request(r0);
                                    }
                                }
                            } else {
                                if (simplePlainQueue == 0) {
                                    simplePlainQueue = (SimplePlainQueue<U>) getMainQueue();
                                }
                                if (!simplePlainQueue.offer(call)) {
                                    onError(new IllegalStateException("Scalar queue full?!"));
                                    return;
                                }
                            }
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } else if (!getMainQueue().offer(call)) {
                            onError(new IllegalStateException("Scalar queue full?!"));
                            return;
                        } else if (getAndIncrement() != 0) {
                            return;
                        }
                        drainLoop();
                        return;
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int r102 = this.scalarEmitted + 1;
                        this.scalarEmitted = r102;
                        int r02 = this.scalarLimit;
                        if (r102 == r02) {
                            this.scalarEmitted = 0;
                            this.upstream.request(r02);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.errs.addThrowable(th);
                    drain();
                    return;
                }
            }
            long j2 = this.uniqueId;
            this.uniqueId = 1 + j2;
            FlowableFlatMap$InnerSubscriber<?, ?> flowableFlatMap$InnerSubscriber = new FlowableFlatMap$InnerSubscriber<>(this, j2);
            while (true) {
                AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> atomicReference = this.subscribers;
                FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr = atomicReference.get();
                if (flowableFlatMap$InnerSubscriberArr == CANCELLED) {
                    SubscriptionHelper.cancel(flowableFlatMap$InnerSubscriber);
                    z2 = false;
                    break;
                }
                int length = flowableFlatMap$InnerSubscriberArr.length;
                FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = new FlowableFlatMap$InnerSubscriber[length + 1];
                System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr2, 0, length);
                flowableFlatMap$InnerSubscriberArr2[length] = flowableFlatMap$InnerSubscriber;
                while (true) {
                    if (atomicReference.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2)) {
                        z = true;
                        break;
                    } else if (atomicReference.get() != flowableFlatMap$InnerSubscriberArr) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    break;
                }
            }
            if (z2) {
                publisher.subscribe(flowableFlatMap$InnerSubscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.upstream.cancel();
            onError(th2);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            if (!this.cancelled) {
                int r0 = this.maxConcurrency;
                if (r0 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(r0);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        boolean z;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        do {
            AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> atomicReference = this.subscribers;
            FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = atomicReference.get();
            int length = flowableFlatMap$InnerSubscriberArr2.length;
            if (length == 0) {
                return;
            }
            z = false;
            int r4 = 0;
            while (true) {
                if (r4 < length) {
                    if (flowableFlatMap$InnerSubscriberArr2[r4] == flowableFlatMap$InnerSubscriber) {
                        break;
                    } else {
                        r4++;
                    }
                } else {
                    r4 = -1;
                    break;
                }
            }
            if (r4 < 0) {
                return;
            }
            if (length == 1) {
                flowableFlatMap$InnerSubscriberArr = EMPTY;
            } else {
                FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr3 = new FlowableFlatMap$InnerSubscriber[length - 1];
                System.arraycopy(flowableFlatMap$InnerSubscriberArr2, 0, flowableFlatMap$InnerSubscriberArr3, 0, r4);
                System.arraycopy(flowableFlatMap$InnerSubscriberArr2, r4 + 1, flowableFlatMap$InnerSubscriberArr3, r4, (length - r4) - 1);
                flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr3;
            }
            while (true) {
                if (atomicReference.compareAndSet(flowableFlatMap$InnerSubscriberArr2, flowableFlatMap$InnerSubscriberArr)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != flowableFlatMap$InnerSubscriberArr2) {
                    break;
                }
            }
        } while (!z);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.requested, j);
            drain();
        }
    }
}
