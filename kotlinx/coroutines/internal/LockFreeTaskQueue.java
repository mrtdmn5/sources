package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes4.dex */
public class LockFreeTaskQueue<E> {
    public static final AtomicReferenceFieldUpdater _cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    private volatile Object _cur = new LockFreeTaskQueueCore(8, false);

    public final boolean addLast(E e) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            int addLast = lockFreeTaskQueueCore.addLast(e);
            if (addLast == 0) {
                return true;
            }
            if (addLast != 1) {
                if (addLast == 2) {
                    return false;
                }
            } else {
                LockFreeTaskQueueCore<E> next = lockFreeTaskQueueCore.next();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeTaskQueueCore, next) && atomicReferenceFieldUpdater.get(this) == lockFreeTaskQueueCore) {
                }
            }
        }
    }

    public final void close() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore.close()) {
                return;
            }
            LockFreeTaskQueueCore<E> next = lockFreeTaskQueueCore.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeTaskQueueCore, next) && atomicReferenceFieldUpdater.get(this) == lockFreeTaskQueueCore) {
            }
        }
    }

    public final int getSize() {
        LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) _cur$FU.get(this);
        lockFreeTaskQueueCore.getClass();
        long j = LockFreeTaskQueueCore._state$FU.get(lockFreeTaskQueueCore);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0))) & 1073741823;
    }

    public final E removeFirstOrNull() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            E e = (E) lockFreeTaskQueueCore.removeFirstOrNull();
            if (e != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return e;
            }
            LockFreeTaskQueueCore<E> next = lockFreeTaskQueueCore.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeTaskQueueCore, next) && atomicReferenceFieldUpdater.get(this) == lockFreeTaskQueueCore) {
            }
        }
    }
}
