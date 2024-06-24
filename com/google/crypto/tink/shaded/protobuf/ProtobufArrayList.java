package com.google.crypto.tink.shaded.protobuf;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    public static final ProtobufArrayList<Object> EMPTY_LIST;
    public E[] array;
    public int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(0, new Object[0]);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.isMutable = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtobufArrayList(int r1, Object[] objArr) {
        this.array = objArr;
        this.size = r1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        ensureIsMutable();
        int r0 = this.size;
        E[] eArr = this.array;
        if (r0 == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((r0 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        eArr2[r1] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void ensureIndexInRange(int r4) {
        if (r4 >= 0 && r4 < this.size) {
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r4, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int r2) {
        ensureIndexInRange(r2);
        return this.array[r2];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public final Internal.ProtobufList mutableCopyWithCapacity(int r3) {
        if (r3 >= this.size) {
            return new ProtobufArrayList(this.size, Arrays.copyOf(this.array, r3));
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int r5) {
        ensureIsMutable();
        ensureIndexInRange(r5);
        E[] eArr = this.array;
        E e = eArr[r5];
        if (r5 < this.size - 1) {
            System.arraycopy(eArr, r5 + 1, eArr, r5, (r2 - r5) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int r3, E e) {
        ensureIsMutable();
        ensureIndexInRange(r3);
        E[] eArr = this.array;
        E e2 = eArr[r3];
        eArr[r3] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, E e) {
        int r0;
        ensureIsMutable();
        if (r6 >= 0 && r6 <= (r0 = this.size)) {
            E[] eArr = this.array;
            if (r0 < eArr.length) {
                System.arraycopy(eArr, r6, eArr, r6 + 1, r0 - r6);
            } else {
                E[] eArr2 = (E[]) new Object[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(eArr, 0, eArr2, 0, r6);
                System.arraycopy(this.array, r6, eArr2, r6 + 1, this.size - r6);
                this.array = eArr2;
            }
            this.array[r6] = e;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r6, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }
}
