package io.reactivex.internal.operators.flowable;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    public final T[] array;

    /* loaded from: classes.dex */
    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        public final ConditionalSubscriber<? super T> downstream;

        public ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.downstream = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public final void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            for (int r3 = this.index; r3 != length; r3++) {
                if (this.cancelled) {
                    return;
                }
                if (tArr[r3] == null) {
                    conditionalSubscriber.onError(new NullPointerException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("The element at index ", r3, " is null")));
                    return;
                }
                conditionalSubscriber.tryOnNext();
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:            r10.index = r2;        r11 = addAndGet(-r6);     */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r3 = r10.downstream
            L7:
                r4 = 0
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L36
                if (r2 == r1) goto L36
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L2a
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "The element at index "
                java.lang.String r0 = " is null"
                java.lang.String r12 = androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m(r12, r2, r0)
                r11.<init>(r12)
                r3.onError(r11)
                return
            L2a:
                boolean r8 = r3.tryOnNext()
                if (r8 == 0) goto L33
                r8 = 1
                long r6 = r6 + r8
            L33:
                int r2 = r2 + 1
                goto La
            L36:
                if (r2 != r1) goto L40
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L3f
                r3.onComplete()
            L3f:
                return
            L40:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r4 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArrayConditionalSubscription.slowPath(long):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        public final Subscriber<? super T> downstream;

        public ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.downstream = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public final void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.downstream;
            for (int r3 = this.index; r3 != length; r3++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[r3];
                if (t == null) {
                    subscriber.onError(new NullPointerException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("The element at index ", r3, " is null")));
                    return;
                }
                subscriber.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:            r10.index = r2;        r11 = addAndGet(-r6);     */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                org.reactivestreams.Subscriber<? super T> r3 = r10.downstream
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L33
                if (r2 == r1) goto L33
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L2a
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "The element at index "
                java.lang.String r0 = " is null"
                java.lang.String r12 = androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m(r12, r2, r0)
                r11.<init>(r12)
                r3.onError(r11)
                return
            L2a:
                r3.onNext(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L33:
                if (r2 != r1) goto L3d
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L3c
                r3.onComplete()
            L3c:
                return
            L3d:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArraySubscription.slowPath(long):void");
        }
    }

    /* loaded from: classes.dex */
    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        public final T[] array;
        public volatile boolean cancelled;
        public int index;

        public BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            if (this.index == this.array.length) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            int r0 = this.index;
            T[] tArr = this.array;
            if (r0 == tArr.length) {
                return null;
            }
            this.index = r0 + 1;
            T t = tArr[r0];
            ObjectHelper.requireNonNull(t, "array element is null");
            return t;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r1) {
            return r1 & 1;
        }

        public abstract void slowPath(long j);
    }

    public FlowableFromArray(T[] tArr) {
        this.array = tArr;
    }

    @Override // io.reactivex.Flowable
    public final void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        T[] tArr = this.array;
        if (z) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, tArr));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, tArr));
        }
    }
}
