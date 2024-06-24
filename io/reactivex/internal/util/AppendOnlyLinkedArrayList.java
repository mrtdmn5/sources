package io.reactivex.internal.util;

import io.reactivex.functions.Predicate;

/* loaded from: classes.dex */
public final class AppendOnlyLinkedArrayList<T> {
    public final Object[] head;
    public int offset;
    public Object[] tail;

    /* loaded from: classes.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
    }

    public AppendOnlyLinkedArrayList() {
        Object[] objArr = new Object[5];
        this.head = objArr;
        this.tail = objArr;
    }

    public final void add(T t) {
        int r0 = this.offset;
        if (r0 == 4) {
            Object[] objArr = new Object[5];
            this.tail[4] = objArr;
            this.tail = objArr;
            r0 = 0;
        }
        this.tail[r0] = t;
        this.offset = r0 + 1;
    }

    public final void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        Object obj;
        for (Object[] objArr = this.head; objArr != null; objArr = (Object[]) objArr[4]) {
            for (int r1 = 0; r1 < 4 && (obj = objArr[r1]) != null; r1++) {
                if (nonThrowingPredicate.test(obj)) {
                    return;
                }
            }
        }
    }
}
