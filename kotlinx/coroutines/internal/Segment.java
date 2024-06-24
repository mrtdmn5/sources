package kotlinx.coroutines.internal;

import com.animaconnected.watch.image.Kolors;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.Segment;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes4.dex */
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> implements NotCompleted {
    public static final AtomicIntegerFieldUpdater cleanedAndPointers$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;
    public final long id;

    public Segment(long j, S s, int r4) {
        super(s);
        this.id = j;
        this.cleanedAndPointers = r4 << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        boolean z;
        if (cleanedAndPointers$FU.addAndGet(this, Kolors.red) != getNumberOfSlots()) {
            return false;
        }
        if (getNext() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }

    public abstract int getNumberOfSlots();

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public final boolean isRemoved() {
        boolean z;
        if (cleanedAndPointers$FU.get(this) != getNumberOfSlots()) {
            return false;
        }
        if (getNext() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }

    public abstract void onCancellation(int r1, CoroutineContext coroutineContext);

    public final void onSlotCleaned() {
        if (cleanedAndPointers$FU.incrementAndGet(this) == getNumberOfSlots()) {
            remove();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.internal.Segment.cleanedAndPointers$FU
            int r1 = r0.get(r5)
            int r2 = r5.getNumberOfSlots()
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L1c
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r2 = r5.getNext()
            if (r2 != 0) goto L16
            r2 = r3
            goto L17
        L16:
            r2 = r4
        L17:
            if (r2 == 0) goto L1a
            goto L1c
        L1a:
            r2 = r4
            goto L1d
        L1c:
            r2 = r3
        L1d:
            if (r2 != 0) goto L21
            r3 = r4
            goto L2a
        L21:
            r2 = 65536(0x10000, float:9.1835E-41)
            int r2 = r2 + r1
            boolean r0 = r0.compareAndSet(r5, r1, r2)
            if (r0 == 0) goto L0
        L2a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.Segment.tryIncPointers$kotlinx_coroutines_core():boolean");
    }
}
