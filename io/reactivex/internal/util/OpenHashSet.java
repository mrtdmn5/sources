package io.reactivex.internal.util;

/* loaded from: classes.dex */
public final class OpenHashSet<T> {
    public T[] keys;
    public int mask;
    public int maxSize;
    public int size;

    public OpenHashSet() {
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
        this.mask = numberOfLeadingZeros - 1;
        this.maxSize = (int) (numberOfLeadingZeros * 0.75f);
        this.keys = (T[]) new Object[numberOfLeadingZeros];
    }

    public final void add(Object obj) {
        T t;
        Object obj2;
        Object[] objArr = this.keys;
        int r1 = this.mask;
        int hashCode = obj.hashCode() * (-1640531527);
        int r2 = (hashCode ^ (hashCode >>> 16)) & r1;
        Object obj3 = objArr[r2];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return;
            }
            do {
                r2 = (r2 + 1) & r1;
                obj2 = objArr[r2];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return;
        }
        objArr[r2] = obj;
        int r9 = this.size + 1;
        this.size = r9;
        if (r9 >= this.maxSize) {
            T[] tArr = this.keys;
            int length = tArr.length;
            int r22 = length << 1;
            int r4 = r22 - 1;
            T[] tArr2 = (T[]) new Object[r22];
            while (true) {
                int r6 = r9 - 1;
                if (r9 == 0) {
                    this.mask = r4;
                    this.maxSize = (int) (r22 * 0.75f);
                    this.keys = tArr2;
                    return;
                }
                do {
                    length--;
                    t = tArr[length];
                } while (t == null);
                int hashCode2 = t.hashCode() * (-1640531527);
                int r92 = (hashCode2 ^ (hashCode2 >>> 16)) & r4;
                if (tArr2[r92] == null) {
                    tArr2[r92] = tArr[length];
                    r9 = r6;
                }
                do {
                    r92 = (r92 + 1) & r4;
                } while (tArr2[r92] != null);
                tArr2[r92] = tArr[length];
                r9 = r6;
            }
        }
    }

    public final void removeEntry(int r5, int r6, Object[] objArr) {
        int r0;
        Object obj;
        this.size--;
        while (true) {
            int r02 = r5 + 1;
            while (true) {
                r0 = r02 & r6;
                obj = objArr[r0];
                if (obj == null) {
                    objArr[r5] = null;
                    return;
                }
                int hashCode = obj.hashCode() * (-1640531527);
                int r2 = (hashCode ^ (hashCode >>> 16)) & r6;
                if (r5 <= r0) {
                    if (r5 < r2 && r2 <= r0) {
                        r02 = r0 + 1;
                    }
                } else {
                    if (r5 >= r2 && r2 > r0) {
                        break;
                    }
                    r02 = r0 + 1;
                }
            }
            objArr[r5] = obj;
            r5 = r0;
        }
    }
}
