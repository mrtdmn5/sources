package com.google.crypto.tink.shaded.protobuf;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class IntArrayList extends AbstractProtobufList<Integer> implements RandomAccess, PrimitiveNonBoxingCollection {
    public int[] array;
    public int size;

    static {
        new IntArrayList(new int[0], 0).isMutable = false;
    }

    public IntArrayList() {
        this(new int[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, Object obj) {
        int r0;
        int intValue = ((Integer) obj).intValue();
        ensureIsMutable();
        if (r6 >= 0 && r6 <= (r0 = this.size)) {
            int[] r1 = this.array;
            if (r0 < r1.length) {
                System.arraycopy(r1, r6, r1, r6 + 1, r0 - r6);
            } else {
                int[] r02 = new int[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(r1, 0, r02, 0, r6);
                System.arraycopy(this.array, r6, r02, r6 + 1, this.size - r6);
                this.array = r02;
            }
            this.array[r6] = intValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r6, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Charset charset = Internal.UTF_8;
        collection.getClass();
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int r0 = intArrayList.size;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.size;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            int[] r02 = this.array;
            if (r22 > r02.length) {
                this.array = Arrays.copyOf(r02, r22);
            }
            System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
            this.size = r22;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addInt(int r6) {
        ensureIsMutable();
        int r0 = this.size;
        int[] r1 = this.array;
        if (r0 == r1.length) {
            int[] r2 = new int[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(r1, 0, r2, 0, r0);
            this.array = r2;
        }
        int[] r02 = this.array;
        int r12 = this.size;
        this.size = r12 + 1;
        r02[r12] = r6;
    }

    public final void ensureIndexInRange(int r4) {
        if (r4 >= 0 && r4 < this.size) {
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r4, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] r6 = intArrayList.array;
        for (int r1 = 0; r1 < this.size; r1++) {
            if (this.array[r1] != r6[r1]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r2) {
        ensureIndexInRange(r2);
        return Integer.valueOf(this.array[r2]);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.size; r1++) {
            r0 = (r0 * 31) + this.array[r1];
        }
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public final Internal.ProtobufList mutableCopyWithCapacity(int r3) {
        if (r3 >= this.size) {
            return new IntArrayList(Arrays.copyOf(this.array, r3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        ensureIsMutable();
        for (int r1 = 0; r1 < this.size; r1++) {
            if (obj.equals(Integer.valueOf(this.array[r1]))) {
                int[] r5 = this.array;
                System.arraycopy(r5, r1 + 1, r5, r1, (this.size - r1) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int r3, int r4) {
        ensureIsMutable();
        if (r4 >= r3) {
            int[] r0 = this.array;
            System.arraycopy(r0, r4, r0, r3, this.size - r4);
            this.size -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r3, Object obj) {
        int intValue = ((Integer) obj).intValue();
        ensureIsMutable();
        ensureIndexInRange(r3);
        int[] r0 = this.array;
        int r1 = r0[r3];
        r0[r3] = intValue;
        return Integer.valueOf(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public IntArrayList(int[] r1, int r2) {
        this.array = r1;
        this.size = r2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int r5) {
        ensureIsMutable();
        ensureIndexInRange(r5);
        int[] r0 = this.array;
        int r1 = r0[r5];
        if (r5 < this.size - 1) {
            System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addInt(((Integer) obj).intValue());
        return true;
    }
}
