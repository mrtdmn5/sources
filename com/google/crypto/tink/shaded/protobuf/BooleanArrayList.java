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
public final class BooleanArrayList extends AbstractProtobufList<Boolean> implements RandomAccess, PrimitiveNonBoxingCollection {
    public boolean[] array;
    public int size;

    static {
        new BooleanArrayList(new boolean[0], 0).isMutable = false;
    }

    public BooleanArrayList() {
        this(new boolean[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, Object obj) {
        int r0;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        ensureIsMutable();
        if (r6 >= 0 && r6 <= (r0 = this.size)) {
            boolean[] zArr = this.array;
            if (r0 < zArr.length) {
                System.arraycopy(zArr, r6, zArr, r6 + 1, r0 - r6);
            } else {
                boolean[] zArr2 = new boolean[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(zArr, 0, zArr2, 0, r6);
                System.arraycopy(this.array, r6, zArr2, r6 + 1, this.size - r6);
                this.array = zArr2;
            }
            this.array[r6] = booleanValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r6, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Charset charset = Internal.UTF_8;
        collection.getClass();
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int r0 = booleanArrayList.size;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.size;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            boolean[] zArr = this.array;
            if (r22 > zArr.length) {
                this.array = Arrays.copyOf(zArr, r22);
            }
            System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
            this.size = r22;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        ensureIsMutable();
        int r0 = this.size;
        boolean[] zArr = this.array;
        if (r0 == zArr.length) {
            boolean[] zArr2 = new boolean[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, r0);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        zArr3[r1] = z;
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
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int r1 = 0; r1 < this.size; r1++) {
            if (this.array[r1] != zArr[r1]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r2) {
        ensureIndexInRange(r2);
        return Boolean.valueOf(this.array[r2]);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r2;
        int r0 = 1;
        for (int r1 = 0; r1 < this.size; r1++) {
            int r02 = r0 * 31;
            boolean z = this.array[r1];
            Charset charset = Internal.UTF_8;
            if (z) {
                r2 = 1231;
            } else {
                r2 = 1237;
            }
            r0 = r02 + r2;
        }
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public final Internal.ProtobufList mutableCopyWithCapacity(int r3) {
        if (r3 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, r3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        ensureIsMutable();
        for (int r1 = 0; r1 < this.size; r1++) {
            if (obj.equals(Boolean.valueOf(this.array[r1]))) {
                boolean[] zArr = this.array;
                System.arraycopy(zArr, r1 + 1, zArr, r1, (this.size - r1) - 1);
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
            boolean[] zArr = this.array;
            System.arraycopy(zArr, r4, zArr, r3, this.size - r4);
            this.size -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r3, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        ensureIsMutable();
        ensureIndexInRange(r3);
        boolean[] zArr = this.array;
        boolean z = zArr[r3];
        zArr[r3] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public BooleanArrayList(boolean[] zArr, int r2) {
        this.array = zArr;
        this.size = r2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int r5) {
        ensureIsMutable();
        ensureIndexInRange(r5);
        boolean[] zArr = this.array;
        boolean z = zArr[r5];
        if (r5 < this.size - 1) {
            System.arraycopy(zArr, r5 + 1, zArr, r5, (r2 - r5) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
