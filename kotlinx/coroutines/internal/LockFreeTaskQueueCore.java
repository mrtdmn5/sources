package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes4.dex */
public final class LockFreeTaskQueueCore<E> {
    private volatile Object _next;
    private volatile long _state;
    public final AtomicReferenceArray array;
    public final int capacity;
    public final int mask;
    public final boolean singleConsumer;
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    public static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes4.dex */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int r1) {
            this.index = r1;
        }
    }

    public LockFreeTaskQueueCore(int r5, boolean z) {
        boolean z2;
        this.capacity = r5;
        this.singleConsumer = z;
        int r6 = r5 - 1;
        this.mask = r6;
        this.array = new AtomicReferenceArray(r5);
        if (r6 <= 1073741823) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if ((r5 & r6) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0056, code lost:            return 1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int addLast(E r17) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
        L4:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU
            long r2 = r8.get(r6)
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r9 = 0
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L1d
            r4 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            long r2 = r2 & r4
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 == 0) goto L1c
            r1 = 2
        L1c:
            return r1
        L1d:
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r11 = 0
            long r4 = r4 >> r11
            int r0 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r12 = 30
            long r4 = r4 >> r12
            int r13 = (int) r4
            int r4 = r13 + 2
            int r14 = r6.mask
            r4 = r4 & r14
            r5 = r0 & r14
            if (r4 != r5) goto L38
            return r1
        L38:
            boolean r4 = r6.singleConsumer
            java.util.concurrent.atomic.AtomicReferenceArray r15 = r6.array
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L57
            r4 = r13 & r14
            java.lang.Object r4 = r15.get(r4)
            if (r4 == 0) goto L57
            r2 = 1024(0x400, float:1.435E-42)
            int r3 = r6.capacity
            if (r3 < r2) goto L56
            int r13 = r13 - r0
            r0 = r13 & r5
            int r2 = r3 >> 1
            if (r0 <= r2) goto L4
        L56:
            return r1
        L57:
            int r0 = r13 + 1
            r0 = r0 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU
            r4 = -1152921503533105153(0xf00000003fffffff, double:-3.1050369248997324E231)
            long r4 = r4 & r2
            long r9 = (long) r0
            long r9 = r9 << r12
            long r4 = r4 | r9
            r0 = r1
            r1 = r16
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L4
            r0 = r13 & r14
            r15.set(r0, r7)
            r0 = r6
        L74:
            long r1 = r8.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L9f
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.next()
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r0.array
            int r2 = r0.mask
            r2 = r2 & r13
            java.lang.Object r5 = r1.get(r2)
            boolean r9 = r5 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore.Placeholder
            if (r9 == 0) goto L9c
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Placeholder r5 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore.Placeholder) r5
            int r5 = r5.index
            if (r5 != r13) goto L9c
            r1.set(r2, r7)
            goto L9d
        L9c:
            r0 = 0
        L9d:
            if (r0 != 0) goto L74
        L9f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.addLast(java.lang.Object):int");
    }

    public final boolean close() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = _state$FU;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LockFreeTaskQueueCore<E> next() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        while (true) {
            atomicLongFieldUpdater = _state$FU;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                break;
            }
            long j2 = j | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
            int r4 = (int) ((1073741823 & j) >> 0);
            int r5 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int r7 = this.mask;
                int r8 = r4 & r7;
                if (r8 == (r7 & r5)) {
                    break;
                }
                Object obj = this.array.get(r8);
                if (obj == null) {
                    obj = new Placeholder(r4);
                }
                lockFreeTaskQueueCore2.array.set(lockFreeTaskQueueCore2.mask & r4, obj);
                r4++;
            }
            atomicLongFieldUpdater.set(lockFreeTaskQueueCore2, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueueCore2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object removeFirstOrNull() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return REMOVE_FROZEN;
            }
            int r5 = this.mask;
            int r14 = ((int) ((j & 1073741823) >> 0)) & r5;
            if ((((int) ((1152921503533105152L & j) >> 30)) & r5) == r14) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.array;
            Object obj = atomicReferenceArray.get(r14);
            boolean z = this.singleConsumer;
            if (obj == null) {
                if (z) {
                    return null;
                }
            } else {
                if (obj instanceof Placeholder) {
                    return null;
                }
                long j2 = ((r1 + 1) & 1073741823) << 0;
                if (atomicLongFieldUpdater.compareAndSet(this, j, (j & (-1073741824)) | j2)) {
                    atomicReferenceArray.set(r14, null);
                    return obj;
                }
                if (z) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = _state$FU;
                        long j3 = atomicLongFieldUpdater2.get(lockFreeTaskQueueCore);
                        int r2 = (int) ((j3 & 1073741823) >> 0);
                        if ((j3 & 1152921504606846976L) != 0) {
                            lockFreeTaskQueueCore = lockFreeTaskQueueCore.next();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(lockFreeTaskQueueCore, j3, (j3 & (-1073741824)) | j2)) {
                                lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & r2, null);
                                lockFreeTaskQueueCore = null;
                            } else {
                                continue;
                            }
                        }
                        if (lockFreeTaskQueueCore == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
