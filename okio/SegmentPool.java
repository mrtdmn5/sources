package okio;

import java.util.concurrent.atomic.AtomicReference;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: SegmentPool.kt */
/* loaded from: classes4.dex */
public final class SegmentPool {
    public static final int HASH_BUCKET_COUNT;
    public static final Segment LOCK = new Segment(new byte[0], 0, 0, false);
    public static final AtomicReference<Segment>[] hashBuckets;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int r1 = 0; r1 < highestOneBit; r1++) {
            atomicReferenceArr[r1] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    public static final void recycle(Segment segment) {
        boolean z;
        int r2;
        if (segment.next == null && segment.prev == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (segment.shared) {
                return;
            }
            AtomicReference<Segment> atomicReference = hashBuckets[(int) (Thread.currentThread().getId() & (HASH_BUCKET_COUNT - 1))];
            Segment segment2 = LOCK;
            Segment andSet = atomicReference.getAndSet(segment2);
            if (andSet == segment2) {
                return;
            }
            if (andSet != null) {
                r2 = andSet.limit;
            } else {
                r2 = 0;
            }
            if (r2 >= 65536) {
                atomicReference.set(andSet);
                return;
            }
            segment.next = andSet;
            segment.pos = 0;
            segment.limit = r2 + DfuBaseService.ERROR_REMOTE_MASK;
            atomicReference.set(segment);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final Segment take() {
        AtomicReference<Segment> atomicReference = hashBuckets[(int) (Thread.currentThread().getId() & (HASH_BUCKET_COUNT - 1))];
        Segment segment = LOCK;
        Segment andSet = atomicReference.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new Segment();
        }
        atomicReference.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }
}
