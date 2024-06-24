package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    public AtomicReferenceArray<Object> consumerBuffer;
    public final AtomicLong consumerIndex;
    public final int consumerMask;
    public AtomicReferenceArray<Object> producerBuffer;
    public final AtomicLong producerIndex;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public final int producerMask;
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object HAS_NEXT = new Object();

    public SpscLinkedArrayQueue(int r5) {
        AtomicLong atomicLong = new AtomicLong();
        this.producerIndex = atomicLong;
        this.consumerIndex = new AtomicLong();
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, r5) - 1));
        int r1 = numberOfLeadingZeros - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(numberOfLeadingZeros + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = r1;
        this.producerLookAheadStep = Math.min(numberOfLeadingZeros / 4, MAX_LOOK_AHEAD_STEP);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = r1;
        this.producerLookAhead = r1 - 1;
        atomicLong.lazySet(0L);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (this.producerIndex.get() == this.consumerIndex.get()) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
            AtomicLong atomicLong = this.producerIndex;
            long j = atomicLong.get();
            int r5 = this.producerMask;
            int r4 = ((int) j) & r5;
            if (j < this.producerLookAhead) {
                atomicReferenceArray.lazySet(r4, t);
                atomicLong.lazySet(j + 1);
                return true;
            }
            long j2 = this.producerLookAheadStep + j;
            if (atomicReferenceArray.get(((int) j2) & r5) == null) {
                this.producerLookAhead = j2 - 1;
                atomicReferenceArray.lazySet(r4, t);
                atomicLong.lazySet(j + 1);
                return true;
            }
            long j3 = j + 1;
            if (atomicReferenceArray.get(((int) j3) & r5) == null) {
                atomicReferenceArray.lazySet(r4, t);
                atomicLong.lazySet(j3);
                return true;
            }
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.producerBuffer = atomicReferenceArray2;
            this.producerLookAhead = (r5 + j) - 1;
            atomicReferenceArray2.lazySet(r4, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(r4, HAS_NEXT);
            atomicLong.lazySet(j3);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        boolean z;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        AtomicLong atomicLong = this.consumerIndex;
        long j = atomicLong.get();
        int r5 = this.consumerMask;
        int r4 = ((int) j) & r5;
        T t = (T) atomicReferenceArray.get(r4);
        if (t == HAS_NEXT) {
            z = true;
        } else {
            z = false;
        }
        if (t != null && !z) {
            atomicReferenceArray.lazySet(r4, null);
            atomicLong.lazySet(j + 1);
            return t;
        }
        if (!z) {
            return null;
        }
        int r52 = r5 + 1;
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(r52);
        atomicReferenceArray.lazySet(r52, null);
        this.consumerBuffer = atomicReferenceArray2;
        T t2 = (T) atomicReferenceArray2.get(r4);
        if (t2 != null) {
            atomicReferenceArray2.lazySet(r4, null);
            atomicLong.lazySet(j + 1);
        }
        return t2;
    }
}
