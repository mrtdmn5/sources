package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes4.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public ConcurrentLinkedListNode(N n) {
        this._prev = n;
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final N getNext() {
        Object obj = _next$FU.get(this);
        if (obj == ConcurrentLinkedListKt.CLOSED) {
            return null;
        }
        return (N) obj;
    }

    public abstract boolean isRemoved();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    public final void remove() {
        boolean z;
        ConcurrentLinkedListNode concurrentLinkedListNode;
        boolean z2;
        boolean z3;
        ?? next;
        if (getNext() == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(this);
            while (concurrentLinkedListNode2 != null && concurrentLinkedListNode2.isRemoved()) {
                concurrentLinkedListNode2 = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(concurrentLinkedListNode2);
            }
            N next2 = getNext();
            Intrinsics.checkNotNull(next2);
            while (next2.isRemoved() && (next = next2.getNext()) != 0) {
                next2 = next;
            }
            do {
                Object obj = atomicReferenceFieldUpdater.get(next2);
                if (((ConcurrentLinkedListNode) obj) == null) {
                    concurrentLinkedListNode = null;
                } else {
                    concurrentLinkedListNode = concurrentLinkedListNode2;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(next2, obj, concurrentLinkedListNode)) {
                        z2 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(next2) != obj) {
                        z2 = false;
                        break;
                    }
                }
            } while (!z2);
            if (concurrentLinkedListNode2 != null) {
                _next$FU.set(concurrentLinkedListNode2, next2);
            }
            if (next2.isRemoved()) {
                if (next2.getNext() == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    continue;
                }
            }
            if (concurrentLinkedListNode2 == null || !concurrentLinkedListNode2.isRemoved()) {
                return;
            }
        }
    }
}
