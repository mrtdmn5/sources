package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DebugStringsKt;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public class LockFreeLinkedListNode {
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final void complete(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode;
            boolean z2 = true;
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            LockFreeLinkedListNode lockFreeLinkedListNode4 = this.newNode;
            if (z) {
                lockFreeLinkedListNode2 = lockFreeLinkedListNode4;
            } else {
                lockFreeLinkedListNode2 = this.oldNext;
            }
            if (lockFreeLinkedListNode2 != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode._next$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode3, this, lockFreeLinkedListNode2)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode3) != this) {
                        z2 = false;
                        break;
                    }
                }
                if (z2 && z) {
                    LockFreeLinkedListNode lockFreeLinkedListNode5 = this.oldNext;
                    Intrinsics.checkNotNull(lockFreeLinkedListNode5);
                    lockFreeLinkedListNode4.finishAdd(lockFreeLinkedListNode5);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:            r6 = ((kotlinx.coroutines.internal.Removed) r6).ref;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:            if (r5.compareAndSet(r4, r2, r6) == false) goto L31;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:            if (r5.get(r4) == r2) goto L56;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:            if (r7 != false) goto L35;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:            r7 = true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode correctPrev() {
        /*
            r11 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode._prev$FU
            java.lang.Object r1 = r0.get(r11)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = r1
        L9:
            r3 = 0
            r4 = r3
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.LockFreeLinkedListNode._next$FU
            java.lang.Object r6 = r5.get(r2)
            r7 = 0
            r8 = 1
            if (r6 != r11) goto L2a
            if (r1 != r2) goto L18
            return r2
        L18:
            boolean r3 = r0.compareAndSet(r11, r1, r2)
            if (r3 == 0) goto L20
            r7 = r8
            goto L26
        L20:
            java.lang.Object r3 = r0.get(r11)
            if (r3 == r1) goto L18
        L26:
            if (r7 != 0) goto L29
            goto L0
        L29:
            return r2
        L2a:
            boolean r9 = r11.isRemoved()
            if (r9 == 0) goto L31
            return r3
        L31:
            if (r6 != 0) goto L34
            return r2
        L34:
            boolean r9 = r6 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r9 == 0) goto L3e
            kotlinx.coroutines.internal.OpDescriptor r6 = (kotlinx.coroutines.internal.OpDescriptor) r6
            r6.perform(r2)
            goto L0
        L3e:
            boolean r9 = r6 instanceof kotlinx.coroutines.internal.Removed
            if (r9 == 0) goto L62
            if (r4 == 0) goto L5b
            kotlinx.coroutines.internal.Removed r6 = (kotlinx.coroutines.internal.Removed) r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = r6.ref
        L48:
            boolean r3 = r5.compareAndSet(r4, r2, r6)
            if (r3 == 0) goto L50
            r7 = r8
            goto L56
        L50:
            java.lang.Object r3 = r5.get(r4)
            if (r3 == r2) goto L48
        L56:
            if (r7 != 0) goto L59
            goto L0
        L59:
            r2 = r4
            goto L9
        L5b:
            java.lang.Object r2 = r0.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Lb
        L62:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r4)
            r4 = r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
            r10 = r4
            r4 = r2
            r2 = r10
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.correctPrev():kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public void dispose() {
        remove$1();
    }

    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (getNext() != lockFreeLinkedListNode) {
                return;
            }
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                    z = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) != lockFreeLinkedListNode2) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        if (isRemoved()) {
            lockFreeLinkedListNode.correctPrev();
        }
    }

    public final Object getNext() {
        while (true) {
            Object obj = _next$FU.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        Removed removed;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object next = getNext();
        if (next instanceof Removed) {
            removed = (Removed) next;
        } else {
            removed = null;
        }
        if (removed == null || (lockFreeLinkedListNode = removed.ref) == null) {
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            return (LockFreeLinkedListNode) next;
        }
        return lockFreeLinkedListNode;
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode correctPrev = correctPrev();
        if (correctPrev == null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            while (true) {
                correctPrev = (LockFreeLinkedListNode) obj;
                if (!correctPrev.isRemoved()) {
                    break;
                }
                obj = atomicReferenceFieldUpdater.get(correctPrev);
            }
        }
        return correctPrev;
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final void remove$1() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        boolean z;
        do {
            Object next = getNext();
            if (next instanceof Removed) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = ((Removed) next).ref;
                return;
            }
            if (next == this) {
                return;
            }
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _removedRef$FU;
            Removed removed = (Removed) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (removed == null) {
                removed = new Removed(lockFreeLinkedListNode);
                atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, removed);
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _next$FU;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, next, removed)) {
                    z = true;
                    break;
                } else if (atomicReferenceFieldUpdater2.get(this) != next) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        lockFreeLinkedListNode.correctPrev();
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1
            @Override // kotlin.reflect.KProperty0
            public final Object get() {
                return this.receiver.getClass().getSimpleName();
            }
        } + '@' + DebugStringsKt.getHexAddress(this);
    }
}
