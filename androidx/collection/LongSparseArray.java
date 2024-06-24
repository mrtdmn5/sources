package androidx.collection;

/* loaded from: classes.dex */
public final class LongSparseArray<E> implements Cloneable {
    public static final Object DELETED = new Object();
    public boolean mGarbage;
    public long[] mKeys;
    public int mSize;
    public Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    public final void clear() {
        int r0 = this.mSize;
        Object[] objArr = this.mValues;
        for (int r3 = 0; r3 < r0; r3++) {
            objArr[r3] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public final void gc() {
        int r0 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int r5 = 0;
        for (int r4 = 0; r4 < r0; r4++) {
            Object obj = objArr[r4];
            if (obj != DELETED) {
                if (r4 != r5) {
                    jArr[r5] = jArr[r4];
                    objArr[r5] = obj;
                    objArr[r4] = null;
                }
                r5++;
            }
        }
        this.mGarbage = false;
        this.mSize = r5;
    }

    public final Object get(long j, Long l) {
        Object obj;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0 && (obj = this.mValues[binarySearch]) != DELETED) {
            return obj;
        }
        return l;
    }

    public final void put(long j, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        int r0 = ~binarySearch;
        int r1 = this.mSize;
        if (r0 < r1) {
            Object[] objArr = this.mValues;
            if (objArr[r0] == DELETED) {
                this.mKeys[r0] = j;
                objArr[r0] = e;
                return;
            }
        }
        if (this.mGarbage && r1 >= this.mKeys.length) {
            gc();
            r0 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        }
        int r12 = this.mSize;
        if (r12 >= this.mKeys.length) {
            int r13 = (r12 + 1) * 8;
            int r2 = 4;
            while (true) {
                if (r2 >= 32) {
                    break;
                }
                int r4 = (1 << r2) - 12;
                if (r13 <= r4) {
                    r13 = r4;
                    break;
                }
                r2++;
            }
            int r14 = r13 / 8;
            long[] jArr = new long[r14];
            Object[] objArr2 = new Object[r14];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int r15 = this.mSize - r0;
        if (r15 != 0) {
            long[] jArr3 = this.mKeys;
            int r42 = r0 + 1;
            System.arraycopy(jArr3, r0, jArr3, r42, r15);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, r0, objArr4, r42, this.mSize - r0);
        }
        this.mKeys[r0] = j;
        this.mValues[r0] = e;
        this.mSize++;
    }

    public final int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int r1 = 0; r1 < this.mSize; r1++) {
            if (r1 > 0) {
                sb.append(", ");
            }
            if (this.mGarbage) {
                gc();
            }
            sb.append(this.mKeys[r1]);
            sb.append('=');
            E valueAt = valueAt(r1);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final E valueAt(int r2) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[r2];
    }

    public LongSparseArray(int r3) {
        this.mGarbage = false;
        if (r3 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int r32 = r3 * 8;
        int r0 = 4;
        while (true) {
            if (r0 >= 32) {
                break;
            }
            int r1 = (1 << r0) - 12;
            if (r32 <= r1) {
                r32 = r1;
                break;
            }
            r0++;
        }
        int r33 = r32 / 8;
        this.mKeys = new long[r33];
        this.mValues = new Object[r33];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final LongSparseArray<E> m2clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
