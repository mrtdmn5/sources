package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.EventLoopImplBase;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes4.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    public static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    private volatile int _size;
    public T[] a;

    public final void addImpl(EventLoopImplBase.DelayedTask delayedTask) {
        delayedTask.setHeap((EventLoopImplBase.DelayedTaskQueue) this);
        T[] tArr = this.a;
        if (tArr == null) {
            tArr = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr;
        } else if (getSize() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            tArr = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.a = tArr;
        }
        int size = getSize();
        _size$FU.set(this, size + 1);
        tArr[size] = delayedTask;
        delayedTask.index = size;
        siftUpFrom(size);
    }

    public final int getSize() {
        return _size$FU.get(this);
    }

    public final T removeAtImpl(int r8) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        _size$FU.set(this, getSize() - 1);
        if (r8 < getSize()) {
            swap(r8, getSize());
            int r1 = (r8 - 1) / 2;
            if (r8 > 0) {
                T t = tArr[r8];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[r1];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    swap(r8, r1);
                    siftUpFrom(r1);
                }
            }
            while (true) {
                int r12 = (r8 * 2) + 1;
                if (r12 >= getSize()) {
                    break;
                }
                T[] tArr2 = this.a;
                Intrinsics.checkNotNull(tArr2);
                int r4 = r12 + 1;
                if (r4 < getSize()) {
                    T t3 = tArr2[r4];
                    Intrinsics.checkNotNull(t3);
                    T t4 = tArr2[r12];
                    Intrinsics.checkNotNull(t4);
                    if (((Comparable) t3).compareTo(t4) < 0) {
                        r12 = r4;
                    }
                }
                T t5 = tArr2[r8];
                Intrinsics.checkNotNull(t5);
                T t6 = tArr2[r12];
                Intrinsics.checkNotNull(t6);
                if (((Comparable) t5).compareTo(t6) <= 0) {
                    break;
                }
                swap(r8, r12);
                r8 = r12;
            }
        }
        T t7 = tArr[getSize()];
        Intrinsics.checkNotNull(t7);
        t7.setHeap(null);
        t7.setIndex(-1);
        tArr[getSize()] = null;
        return t7;
    }

    public final void siftUpFrom(int r4) {
        while (r4 > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int r1 = (r4 - 1) / 2;
            T t = tArr[r1];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[r4];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            swap(r4, r1);
            r4 = r1;
        }
    }

    public final void swap(int r4, int r5) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[r5];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[r4];
        Intrinsics.checkNotNull(t2);
        tArr[r4] = t;
        tArr[r5] = t2;
        t.setIndex(r4);
        t2.setIndex(r5);
    }
}
