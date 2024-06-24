package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.Segment;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    public final AtomicReferenceArray acquirers;

    public SemaphoreSegment(long j, SemaphoreSegment semaphoreSegment, int r4) {
        super(j, semaphoreSegment, r4);
        this.acquirers = new AtomicReferenceArray(SemaphoreKt.SEGMENT_SIZE);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int getNumberOfSlots() {
        return SemaphoreKt.SEGMENT_SIZE;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final void onCancellation(int r2, CoroutineContext coroutineContext) {
        this.acquirers.set(r2, SemaphoreKt.CANCELLED);
        onSlotCleaned();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + hashCode() + ']';
    }
}
