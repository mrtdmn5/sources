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
public final class DoubleArrayList extends AbstractProtobufList<Double> implements RandomAccess, PrimitiveNonBoxingCollection {
    public double[] array;
    public int size;

    static {
        new DoubleArrayList(0, new double[0]).isMutable = false;
    }

    public DoubleArrayList() {
        this(0, new double[10]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r7, Object obj) {
        int r8;
        double doubleValue = ((Double) obj).doubleValue();
        ensureIsMutable();
        if (r7 >= 0 && r7 <= (r8 = this.size)) {
            double[] dArr = this.array;
            if (r8 < dArr.length) {
                System.arraycopy(dArr, r7, dArr, r7 + 1, r8 - r7);
            } else {
                double[] dArr2 = new double[OpaqueKey$$ExternalSyntheticOutline0.m(r8, 3, 2, 1)];
                System.arraycopy(dArr, 0, dArr2, 0, r7);
                System.arraycopy(this.array, r7, dArr2, r7 + 1, this.size - r7);
                this.array = dArr2;
            }
            this.array[r7] = doubleValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r7, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Charset charset = Internal.UTF_8;
        collection.getClass();
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int r0 = doubleArrayList.size;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.size;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            double[] dArr = this.array;
            if (r22 > dArr.length) {
                this.array = Arrays.copyOf(dArr, r22);
            }
            System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
            this.size = r22;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addDouble(double d) {
        ensureIsMutable();
        int r0 = this.size;
        double[] dArr = this.array;
        if (r0 == dArr.length) {
            double[] dArr2 = new double[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, r0);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        dArr3[r1] = d;
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
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int r1 = 0; r1 < this.size; r1++) {
            if (Double.doubleToLongBits(this.array[r1]) != Double.doubleToLongBits(dArr[r1])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r4) {
        ensureIndexInRange(r4);
        return Double.valueOf(this.array[r4]);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.size; r1++) {
            r0 = (r0 * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[r1]));
        }
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public final Internal.ProtobufList mutableCopyWithCapacity(int r3) {
        if (r3 >= this.size) {
            return new DoubleArrayList(this.size, Arrays.copyOf(this.array, r3));
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        ensureIsMutable();
        for (int r1 = 0; r1 < this.size; r1++) {
            if (obj.equals(Double.valueOf(this.array[r1]))) {
                double[] dArr = this.array;
                System.arraycopy(dArr, r1 + 1, dArr, r1, (this.size - r1) - 1);
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
            double[] dArr = this.array;
            System.arraycopy(dArr, r4, dArr, r3, this.size - r4);
            this.size -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r5, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        ensureIsMutable();
        ensureIndexInRange(r5);
        double[] dArr = this.array;
        double d = dArr[r5];
        dArr[r5] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public DoubleArrayList(int r1, double[] dArr) {
        this.array = dArr;
        this.size = r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int r6) {
        ensureIsMutable();
        ensureIndexInRange(r6);
        double[] dArr = this.array;
        double d = dArr[r6];
        if (r6 < this.size - 1) {
            System.arraycopy(dArr, r6 + 1, dArr, r6, (r3 - r6) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addDouble(((Double) obj).doubleValue());
        return true;
    }
}
