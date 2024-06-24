package kotlin.collections;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes.dex */
public final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    public final Object[] buffer;
    public final int capacity;
    public int size;
    public int startIndex;

    public RingBuffer(int r4, Object[] objArr) {
        boolean z;
        this.buffer = objArr;
        if (r4 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r4 <= objArr.length) {
                this.capacity = objArr.length;
                this.size = r4;
                return;
            } else {
                StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("ring buffer filled size: ", r4, " cannot be larger than the buffer size: ");
                m.append(objArr.length);
                throw new IllegalArgumentException(m.toString().toString());
            }
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("ring buffer filled size should not be negative but it is ", r4).toString());
    }

    @Override // java.util.List
    public final T get(int r5) {
        int size = getSize();
        if (r5 >= 0 && r5 < size) {
            return (T) this.buffer[(this.startIndex + r5) % this.capacity];
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", size));
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<T> iterator() {
        return new RingBuffer$iterator$1(this);
    }

    public final void removeFirst(int r6) {
        boolean z;
        boolean z2 = true;
        if (r6 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r6 > this.size) {
                z2 = false;
            }
            if (z2) {
                if (r6 > 0) {
                    int r0 = this.startIndex;
                    int r3 = this.capacity;
                    int r2 = (r0 + r6) % r3;
                    Object[] objArr = this.buffer;
                    if (r0 > r2) {
                        ArraysKt___ArraysJvmKt.fill(r0, r3, objArr);
                        ArraysKt___ArraysJvmKt.fill(0, r2, objArr);
                    } else {
                        ArraysKt___ArraysJvmKt.fill(r0, r2, objArr);
                    }
                    this.startIndex = r2;
                    this.size -= r6;
                    return;
                }
                return;
            }
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("n shouldn't be greater than the buffer size: n = ", r6, ", size = ");
            m.append(this.size);
            throw new IllegalArgumentException(m.toString().toString());
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("n shouldn't be negative but it is ", r6).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[getSize()]);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int r1 = this.size;
        if (length < r1) {
            array = (T[]) Arrays.copyOf(array, r1);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        }
        int r0 = this.size;
        int r12 = this.startIndex;
        int r2 = 0;
        int r3 = 0;
        while (true) {
            objArr = this.buffer;
            if (r3 >= r0 || r12 >= this.capacity) {
                break;
            }
            array[r3] = objArr[r12];
            r3++;
            r12++;
        }
        while (r3 < r0) {
            array[r3] = objArr[r2];
            r3++;
            r2++;
        }
        if (r0 < array.length) {
            array[r0] = null;
        }
        return array;
    }
}
