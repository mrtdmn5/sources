package kotlinx.coroutines.scheduling;

import com.animaconnected.secondo.R;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: WorkQueue.kt */
/* loaded from: classes4.dex */
public final class WorkQueue {
    private volatile int blockingTasksInBuffer;
    public final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;
    public static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    public static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    public static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    public final Task addLast(Task task) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = producerIndex$FU;
        if (atomicIntegerFieldUpdater.get(this) - consumerIndex$FU.get(this) == 127) {
            return task;
        }
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        int r1 = atomicIntegerFieldUpdater.get(this) & R.styleable.AppTheme_statusTextH5;
        while (true) {
            AtomicReferenceArray<Task> atomicReferenceArray = this.buffer;
            if (atomicReferenceArray.get(r1) != null) {
                Thread.yield();
            } else {
                atomicReferenceArray.lazySet(r1, task);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
        }
    }

    public final Task pollBuffer() {
        Task andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = consumerIndex$FU;
            int r1 = atomicIntegerFieldUpdater.get(this);
            if (r1 - producerIndex$FU.get(this) == 0) {
                return null;
            }
            int r2 = r1 & R.styleable.AppTheme_statusTextH5;
            if (atomicIntegerFieldUpdater.compareAndSet(this, r1, r1 + 1) && (andSet = this.buffer.getAndSet(r2, null)) != null) {
                boolean z = true;
                if (andSet.taskContext.getTaskMode() != 1) {
                    z = false;
                }
                if (z) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:            if (r0.get(r7) == r1) goto L21;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:            if (r4 == false) goto L18;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:            if (r8 == false) goto L17;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:            kotlinx.coroutines.scheduling.WorkQueue.blockingTasksInBuffer$FU.decrementAndGet(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0022, code lost:            r4 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:            if (r3 == r8) goto L9;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:            if (r0.compareAndSet(r7, r1, null) == false) goto L12;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.scheduling.Task tryExtractFromTheMiddle(int r7, boolean r8) {
        /*
            r6 = this;
            r7 = r7 & 127(0x7f, float:1.78E-43)
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.Task> r0 = r6.buffer
            java.lang.Object r1 = r0.get(r7)
            kotlinx.coroutines.scheduling.Task r1 = (kotlinx.coroutines.scheduling.Task) r1
            r2 = 0
            if (r1 == 0) goto L34
            kotlinx.coroutines.scheduling.TaskContext r3 = r1.taskContext
            int r3 = r3.getTaskMode()
            r4 = 0
            r5 = 1
            if (r3 != r5) goto L19
            r3 = r5
            goto L1a
        L19:
            r3 = r4
        L1a:
            if (r3 != r8) goto L34
        L1c:
            boolean r3 = r0.compareAndSet(r7, r1, r2)
            if (r3 == 0) goto L24
            r4 = r5
            goto L2a
        L24:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r1) goto L1c
        L2a:
            if (r4 == 0) goto L34
            if (r8 == 0) goto L33
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = kotlinx.coroutines.scheduling.WorkQueue.blockingTasksInBuffer$FU
            r7.decrementAndGet(r6)
        L33:
            return r1
        L34:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.WorkQueue.tryExtractFromTheMiddle(int, boolean):kotlinx.coroutines.scheduling.Task");
    }
}
