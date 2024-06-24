package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes4.dex */
public final class ConcurrentLinkedListKt {
    public static final Symbol CLOSED = new Symbol("CLOSED");

    public static final <S extends Segment<S>> Object findSegmentInternal(S s, long j, Function2<? super Long, ? super S, ? extends S> function2) {
        boolean z;
        while (true) {
            if (s.id >= j && !s.isRemoved()) {
                return s;
            }
            Object obj = ConcurrentLinkedListNode._next$FU.get(s);
            Symbol symbol = CLOSED;
            if (obj == symbol) {
                return symbol;
            }
            S s2 = (S) ((ConcurrentLinkedListNode) obj);
            if (s2 == null) {
                s2 = function2.invoke(Long.valueOf(s.id + 1), s);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ConcurrentLinkedListNode._next$FU;
                    if (atomicReferenceFieldUpdater.compareAndSet(s, null, s2)) {
                        z = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(s) != null) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    if (s.isRemoved()) {
                        s.remove();
                    }
                }
            }
            s = s2;
        }
    }
}
