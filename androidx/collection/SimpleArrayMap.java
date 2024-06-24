package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    public static Object[] mBaseCache;
    public static int mBaseCacheSize;
    public static Object[] mTwiceBaseCache;
    public static int mTwiceBaseCacheSize;
    public Object[] mArray;
    public int[] mHashes;
    public int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int r6) {
        if (r6 == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = mTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (r6 == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = mBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[r6];
        this.mArray = new Object[r6 << 1];
    }

    public static void freeArrays(int[] r7, Object[] objArr, int r9) {
        if (r7.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = r7;
                    for (int r72 = (r9 << 1) - 1; r72 >= 2; r72--) {
                        objArr[r72] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (r7.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = r7;
                    for (int r73 = (r9 << 1) - 1; r73 >= 2; r73--) {
                        objArr[r73] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public final void clear() {
        int r0 = this.mSize;
        if (r0 > 0) {
            int[] r1 = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(r1, objArr, r0);
        }
        if (this.mSize <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        if (indexOfKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsValue(Object obj) {
        if (indexOfValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final void ensureCapacity(int r6) {
        int r0 = this.mSize;
        int[] r1 = this.mHashes;
        if (r1.length < r6) {
            Object[] objArr = this.mArray;
            allocArrays(r6);
            if (this.mSize > 0) {
                System.arraycopy(r1, 0, this.mHashes, 0, r0);
                System.arraycopy(objArr, 0, this.mArray, 0, r0 << 1);
            }
            freeArrays(r1, objArr, r0);
        }
        if (this.mSize == r0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (this.mSize != simpleArrayMap.mSize) {
                return false;
            }
            for (int r1 = 0; r1 < this.mSize; r1++) {
                try {
                    K keyAt = keyAt(r1);
                    V valueAt = valueAt(r1);
                    Object orDefault = simpleArrayMap.getOrDefault(keyAt, null);
                    if (valueAt == null) {
                        if (orDefault != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.mSize != map.size()) {
                return false;
            }
            for (int r12 = 0; r12 < this.mSize; r12++) {
                try {
                    K keyAt2 = keyAt(r12);
                    V valueAt2 = valueAt(r12);
                    Object obj2 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj2 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final V getOrDefault(Object obj, V v) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (V) this.mArray[(indexOfKey << 1) + 1];
        }
        return v;
    }

    public final int hashCode() {
        int hashCode;
        int[] r0 = this.mHashes;
        Object[] objArr = this.mArray;
        int r2 = this.mSize;
        int r4 = 1;
        int r5 = 0;
        int r6 = 0;
        while (r5 < r2) {
            Object obj = objArr[r4];
            int r8 = r0[r5];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            r6 += hashCode ^ r8;
            r5++;
            r4 += 2;
        }
        return r6;
    }

    public final int indexOf(int r7, Object obj) {
        int r0 = this.mSize;
        if (r0 == 0) {
            return -1;
        }
        try {
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, r0, r7);
            if (binarySearch < 0) {
                return binarySearch;
            }
            if (obj.equals(this.mArray[binarySearch << 1])) {
                return binarySearch;
            }
            int r3 = binarySearch + 1;
            while (r3 < r0 && this.mHashes[r3] == r7) {
                if (obj.equals(this.mArray[r3 << 1])) {
                    return r3;
                }
                r3++;
            }
            for (int r2 = binarySearch - 1; r2 >= 0 && this.mHashes[r2] == r7; r2--) {
                if (obj.equals(this.mArray[r2 << 1])) {
                    return r2;
                }
            }
            return ~r3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int indexOfKey(Object obj) {
        if (obj == null) {
            return indexOfNull();
        }
        return indexOf(obj.hashCode(), obj);
    }

    public final int indexOfNull() {
        int r0 = this.mSize;
        if (r0 == 0) {
            return -1;
        }
        try {
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, r0, 0);
            if (binarySearch < 0) {
                return binarySearch;
            }
            if (this.mArray[binarySearch << 1] == null) {
                return binarySearch;
            }
            int r3 = binarySearch + 1;
            while (r3 < r0 && this.mHashes[r3] == 0) {
                if (this.mArray[r3 << 1] == null) {
                    return r3;
                }
                r3++;
            }
            for (int r2 = binarySearch - 1; r2 >= 0 && this.mHashes[r2] == 0; r2--) {
                if (this.mArray[r2 << 1] == null) {
                    return r2;
                }
            }
            return ~r3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int indexOfValue(Object obj) {
        int r0 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int r6 = 1; r6 < r0; r6 += 2) {
                if (objArr[r6] == null) {
                    return r6 >> 1;
                }
            }
            return -1;
        }
        for (int r3 = 1; r3 < r0; r3 += 2) {
            if (obj.equals(objArr[r3])) {
                return r3 >> 1;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    public final K keyAt(int r2) {
        return (K) this.mArray[r2 << 1];
    }

    public final V put(K k, V v) {
        int r3;
        int indexOf;
        int r0 = this.mSize;
        if (k == null) {
            indexOf = indexOfNull();
            r3 = 0;
        } else {
            int hashCode = k.hashCode();
            r3 = hashCode;
            indexOf = indexOf(hashCode, k);
        }
        if (indexOf >= 0) {
            int r10 = (indexOf << 1) + 1;
            Object[] objArr = this.mArray;
            V v2 = (V) objArr[r10];
            objArr[r10] = v;
            return v2;
        }
        int r2 = ~indexOf;
        int[] r4 = this.mHashes;
        if (r0 >= r4.length) {
            int r5 = 8;
            if (r0 >= 8) {
                r5 = (r0 >> 1) + r0;
            } else if (r0 < 4) {
                r5 = 4;
            }
            Object[] objArr2 = this.mArray;
            allocArrays(r5);
            if (r0 == this.mSize) {
                int[] r52 = this.mHashes;
                if (r52.length > 0) {
                    System.arraycopy(r4, 0, r52, 0, r4.length);
                    System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
                }
                freeArrays(r4, objArr2, r0);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (r2 < r0) {
            int[] r1 = this.mHashes;
            int r42 = r2 + 1;
            System.arraycopy(r1, r2, r1, r42, r0 - r2);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, r2 << 1, objArr3, r42 << 1, (this.mSize - r2) << 1);
        }
        int r12 = this.mSize;
        if (r0 == r12) {
            int[] r02 = this.mHashes;
            if (r2 < r02.length) {
                r02[r2] = r3;
                Object[] objArr4 = this.mArray;
                int r22 = r2 << 1;
                objArr4[r22] = k;
                objArr4[r22 + 1] = v;
                this.mSize = r12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final V putIfAbsent(K k, V v) {
        V orDefault = getOrDefault(k, null);
        if (orDefault == null) {
            return put(k, v);
        }
        return orDefault;
    }

    public final V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public final V removeAt(int r11) {
        Object[] objArr = this.mArray;
        int r1 = r11 << 1;
        V v = (V) objArr[r1 + 1];
        int r3 = this.mSize;
        int r4 = 0;
        if (r3 <= 1) {
            freeArrays(this.mHashes, objArr, r3);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int r6 = r3 - 1;
            int[] r7 = this.mHashes;
            int r9 = 8;
            if (r7.length > 8 && r3 < r7.length / 3) {
                if (r3 > 8) {
                    r9 = r3 + (r3 >> 1);
                }
                allocArrays(r9);
                if (r3 == this.mSize) {
                    if (r11 > 0) {
                        System.arraycopy(r7, 0, this.mHashes, 0, r11);
                        System.arraycopy(objArr, 0, this.mArray, 0, r1);
                    }
                    if (r11 < r6) {
                        int r42 = r11 + 1;
                        int r92 = r6 - r11;
                        System.arraycopy(r7, r42, this.mHashes, r11, r92);
                        System.arraycopy(objArr, r42 << 1, this.mArray, r1, r92 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (r11 < r6) {
                    int r0 = r11 + 1;
                    int r43 = r6 - r11;
                    System.arraycopy(r7, r0, r7, r11, r43);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, r0 << 1, objArr2, r1, r43 << 1);
                }
                Object[] objArr3 = this.mArray;
                int r02 = r6 << 1;
                objArr3[r02] = null;
                objArr3[r02 + 1] = null;
            }
            r4 = r6;
        }
        if (r3 == this.mSize) {
            this.mSize = r4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public final V replace(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0) {
            return null;
        }
        int r3 = (indexOfKey << 1) + 1;
        Object[] objArr = this.mArray;
        V v2 = (V) objArr[r3];
        objArr[r3] = v;
        return v2;
    }

    public final int size() {
        return this.mSize;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int r1 = 0; r1 < this.mSize; r1++) {
            if (r1 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(r1);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(r1);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final V valueAt(int r2) {
        return (V) this.mArray[(r2 << 1) + 1];
    }

    public final boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public final boolean replace(K k, V v, V v2) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (valueAt != v && (v == null || !v.equals(valueAt))) {
            return false;
        }
        int r3 = (indexOfKey << 1) + 1;
        Object[] objArr = this.mArray;
        Object obj = objArr[r3];
        objArr[r3] = v2;
        return true;
    }

    public SimpleArrayMap(int r1) {
        if (r1 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(r1);
        }
        this.mSize = 0;
    }
}
