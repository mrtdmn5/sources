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
public final class FloatArrayList extends AbstractProtobufList<Float> implements RandomAccess, PrimitiveNonBoxingCollection {
    public float[] array;
    public int size;

    static {
        new FloatArrayList(0, new float[0]).isMutable = false;
    }

    public FloatArrayList() {
        this(0, new float[10]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, Object obj) {
        int r0;
        float floatValue = ((Float) obj).floatValue();
        ensureIsMutable();
        if (r6 >= 0 && r6 <= (r0 = this.size)) {
            float[] fArr = this.array;
            if (r0 < fArr.length) {
                System.arraycopy(fArr, r6, fArr, r6 + 1, r0 - r6);
            } else {
                float[] fArr2 = new float[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(fArr, 0, fArr2, 0, r6);
                System.arraycopy(this.array, r6, fArr2, r6 + 1, this.size - r6);
                this.array = fArr2;
            }
            this.array[r6] = floatValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index:", r6, ", Size:");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Charset charset = Internal.UTF_8;
        collection.getClass();
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int r0 = floatArrayList.size;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.size;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            float[] fArr = this.array;
            if (r22 > fArr.length) {
                this.array = Arrays.copyOf(fArr, r22);
            }
            System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
            this.size = r22;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addFloat(float f) {
        ensureIsMutable();
        int r0 = this.size;
        float[] fArr = this.array;
        if (r0 == fArr.length) {
            float[] fArr2 = new float[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, r0);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        fArr3[r1] = f;
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
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int r1 = 0; r1 < this.size; r1++) {
            if (Float.floatToIntBits(this.array[r1]) != Float.floatToIntBits(fArr[r1])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r2) {
        ensureIndexInRange(r2);
        return Float.valueOf(this.array[r2]);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.size; r1++) {
            r0 = (r0 * 31) + Float.floatToIntBits(this.array[r1]);
        }
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public final Internal.ProtobufList mutableCopyWithCapacity(int r3) {
        if (r3 >= this.size) {
            return new FloatArrayList(this.size, Arrays.copyOf(this.array, r3));
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        ensureIsMutable();
        for (int r1 = 0; r1 < this.size; r1++) {
            if (obj.equals(Float.valueOf(this.array[r1]))) {
                float[] fArr = this.array;
                System.arraycopy(fArr, r1 + 1, fArr, r1, (this.size - r1) - 1);
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
            float[] fArr = this.array;
            System.arraycopy(fArr, r4, fArr, r3, this.size - r4);
            this.size -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r3, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        ensureIsMutable();
        ensureIndexInRange(r3);
        float[] fArr = this.array;
        float f = fArr[r3];
        fArr[r3] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public FloatArrayList(int r1, float[] fArr) {
        this.array = fArr;
        this.size = r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int r5) {
        ensureIsMutable();
        ensureIndexInRange(r5);
        float[] fArr = this.array;
        float f = fArr[r5];
        if (r5 < this.size - 1) {
            System.arraycopy(fArr, r5 + 1, fArr, r5, (r2 - r5) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addFloat(((Float) obj).floatValue());
        return true;
    }
}
