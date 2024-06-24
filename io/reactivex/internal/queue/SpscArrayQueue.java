package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    public static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final AtomicLong consumerIndex;
    public final int lookAheadStep;
    public final int mask;
    public final AtomicLong producerIndex;
    public long producerLookAhead;

    public SpscArrayQueue(int r3) {
        super(1 << (32 - Integer.numberOfLeadingZeros(r3 - 1)));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(r3 / 4, MAX_LOOK_AHEAD_STEP.intValue());
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
    public final boolean offer(E e) {
        if (e != null) {
            AtomicLong atomicLong = this.producerIndex;
            long j = atomicLong.get();
            int r4 = this.mask;
            int r3 = ((int) j) & r4;
            if (j >= this.producerLookAhead) {
                long j2 = this.lookAheadStep + j;
                if (get(r4 & ((int) j2)) == null) {
                    this.producerLookAhead = j2;
                } else if (get(r3) != null) {
                    return false;
                }
            }
            lazySet(r3, e);
            atomicLong.lazySet(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final E poll() {
        AtomicLong atomicLong = this.consumerIndex;
        long j = atomicLong.get();
        int r3 = ((int) j) & this.mask;
        E e = get(r3);
        if (e == null) {
            return null;
        }
        atomicLong.lazySet(j + 1);
        lazySet(r3, null);
        return e;
    }
}
