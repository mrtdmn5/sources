package androidx.collection;

/* loaded from: classes.dex */
public final class SparseArrayCompat<E> implements Cloneable {
    public static final Object DELETED = new Object();
    public boolean mGarbage = false;
    public int[] mKeys;
    public int mSize;
    public Object[] mValues;

    public SparseArrayCompat() {
        int r3;
        int r1 = 4;
        while (true) {
            r3 = 40;
            if (r1 >= 32) {
                break;
            }
            int r2 = (1 << r1) - 12;
            if (40 <= r2) {
                r3 = r2;
                break;
            }
            r1++;
        }
        int r32 = r3 / 4;
        this.mKeys = new int[r32];
        this.mValues = new Object[r32];
    }

    public final void append(int r8, E e) {
        int r0 = this.mSize;
        if (r0 != 0 && r8 <= this.mKeys[r0 - 1]) {
            put(r8, e);
            return;
        }
        if (this.mGarbage && r0 >= this.mKeys.length) {
            gc();
        }
        int r02 = this.mSize;
        if (r02 >= this.mKeys.length) {
            int r1 = (r02 + 1) * 4;
            int r4 = 4;
            while (true) {
                if (r4 >= 32) {
                    break;
                }
                int r5 = (1 << r4) - 12;
                if (r1 <= r5) {
                    r1 = r5;
                    break;
                }
                r4++;
            }
            int r12 = r1 / 4;
            int[] r3 = new int[r12];
            Object[] objArr = new Object[r12];
            int[] r42 = this.mKeys;
            System.arraycopy(r42, 0, r3, 0, r42.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = r3;
            this.mValues = objArr;
        }
        this.mKeys[r02] = r8;
        this.mValues[r02] = e;
        this.mSize = r02 + 1;
    }

    public final void gc() {
        int r0 = this.mSize;
        int[] r1 = this.mKeys;
        Object[] objArr = this.mValues;
        int r5 = 0;
        for (int r4 = 0; r4 < r0; r4++) {
            Object obj = objArr[r4];
            if (obj != DELETED) {
                if (r4 != r5) {
                    r1[r5] = r1[r4];
                    objArr[r5] = obj;
                    objArr[r4] = null;
                }
                r5++;
            }
        }
        this.mGarbage = false;
        this.mSize = r5;
    }

    public final Object get(int r3, Integer num) {
        Object obj;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r3);
        if (binarySearch >= 0 && (obj = this.mValues[binarySearch]) != DELETED) {
            return obj;
        }
        return num;
    }

    public final void put(int r8, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r8);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        int r0 = ~binarySearch;
        int r1 = this.mSize;
        if (r0 < r1) {
            Object[] objArr = this.mValues;
            if (objArr[r0] == DELETED) {
                this.mKeys[r0] = r8;
                objArr[r0] = e;
                return;
            }
        }
        if (this.mGarbage && r1 >= this.mKeys.length) {
            gc();
            r0 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, r8);
        }
        int r12 = this.mSize;
        if (r12 >= this.mKeys.length) {
            int r13 = (r12 + 1) * 4;
            int r4 = 4;
            while (true) {
                if (r4 >= 32) {
                    break;
                }
                int r5 = (1 << r4) - 12;
                if (r13 <= r5) {
                    r13 = r5;
                    break;
                }
                r4++;
            }
            int r14 = r13 / 4;
            int[] r2 = new int[r14];
            Object[] objArr2 = new Object[r14];
            int[] r42 = this.mKeys;
            System.arraycopy(r42, 0, r2, 0, r42.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = r2;
            this.mValues = objArr2;
        }
        int r15 = this.mSize - r0;
        if (r15 != 0) {
            int[] r22 = this.mKeys;
            int r43 = r0 + 1;
            System.arraycopy(r22, r0, r22, r43, r15);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, r0, objArr4, r43, this.mSize - r0);
        }
        this.mKeys[r0] = r8;
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

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final SparseArrayCompat<E> m3clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
