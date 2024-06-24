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
public final class LongArrayList extends AbstractProtobufList<Long> implements RandomAccess, PrimitiveNonBoxingCollection {
    public long[] array;
    public int size;

    static {
        new LongArrayList(new long[0], 0).isMutable = false;
    }

    public LongArrayList() {
        this(new long[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r7, Object obj) {
        int r8;
        long longValue = ((Long) obj).longValue();
        ensureIsMutable();
        if (r7 >= 0 && r7 <= (r8 = this.size)) {
            long[] jArr = this.array;
            if (r8 < jArr.length) {
                System.arraycopy(jArr, r7, jArr, r7 + 1, r8 - r7);
            } else {
                long[] jArr2 = new long[OpaqueKey$$ExternalSyntheticOutline0.m(r8, 3, 2, 1)];
                System.arraycopy(jArr, 0, jArr2, 0, r7);
                System.arraycopy(this.array, r7, jArr2, r7 + 1, this.size - r7);
                this.array = jArr2;
            }
            this.array[r7] = longValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r7, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Charset charset = Internal.UTF_8;
        collection.getClass();
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int r0 = longArrayList.size;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.size;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            long[] jArr = this.array;
            if (r22 > jArr.length) {
                this.array = Arrays.copyOf(jArr, r22);
            }
            System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
            this.size = r22;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addLong(long j) {
        ensureIsMutable();
        int r0 = this.size;
        long[] jArr = this.array;
        if (r0 == jArr.length) {
            long[] jArr2 = new long[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, r0);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        jArr3[r1] = j;
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
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int r1 = 0; r1 < this.size; r1++) {
            if (this.array[r1] != jArr[r1]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r4) {
        ensureIndexInRange(r4);
        return Long.valueOf(this.array[r4]);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.size; r1++) {
            r0 = (r0 * 31) + Internal.hashLong(this.array[r1]);
        }
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public final Internal.ProtobufList mutableCopyWithCapacity(int r3) {
        if (r3 >= this.size) {
            return new LongArrayList(Arrays.copyOf(this.array, r3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        ensureIsMutable();
        for (int r1 = 0; r1 < this.size; r1++) {
            if (obj.equals(Long.valueOf(this.array[r1]))) {
                long[] jArr = this.array;
                System.arraycopy(jArr, r1 + 1, jArr, r1, (this.size - r1) - 1);
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
            long[] jArr = this.array;
            System.arraycopy(jArr, r4, jArr, r3, this.size - r4);
            this.size -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r5, Object obj) {
        long longValue = ((Long) obj).longValue();
        ensureIsMutable();
        ensureIndexInRange(r5);
        long[] jArr = this.array;
        long j = jArr[r5];
        jArr[r5] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public LongArrayList(long[] jArr, int r2) {
        this.array = jArr;
        this.size = r2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int r6) {
        ensureIsMutable();
        ensureIndexInRange(r6);
        long[] jArr = this.array;
        long j = jArr[r6];
        if (r6 < this.size - 1) {
            System.arraycopy(jArr, r6 + 1, jArr, r6, (r3 - r6) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLong(((Long) obj).longValue());
        return true;
    }
}
