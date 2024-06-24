package androidx.collection;

import androidx.collection.MapCollections;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    public static final int[] INT = new int[0];
    public static final Object[] OBJECT = new Object[0];
    public static Object[] sBaseCache;
    public static int sBaseCacheSize;
    public static Object[] sTwiceBaseCache;
    public static int sTwiceBaseCacheSize;
    public Object[] mArray;
    public AnonymousClass1 mCollections;
    public int[] mHashes;
    public int mSize;

    public ArraySet() {
        this(0);
    }

    public static void freeArrays(int[] r7, Object[] objArr, int r9) {
        if (r7.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = r7;
                    for (int r92 = r9 - 1; r92 >= 2; r92--) {
                        objArr[r92] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (r7.length == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = r7;
                    for (int r93 = r9 - 1; r93 >= 2; r93--) {
                        objArr[r93] = null;
                    }
                    sBaseCache = objArr;
                    sBaseCacheSize++;
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e) {
        int r2;
        int indexOf;
        if (e == null) {
            indexOf = indexOfNull();
            r2 = 0;
        } else {
            int hashCode = e.hashCode();
            r2 = hashCode;
            indexOf = indexOf(hashCode, e);
        }
        if (indexOf >= 0) {
            return false;
        }
        int r1 = ~indexOf;
        int r3 = this.mSize;
        int[] r4 = this.mHashes;
        if (r3 >= r4.length) {
            int r5 = 8;
            if (r3 >= 8) {
                r5 = (r3 >> 1) + r3;
            } else if (r3 < 4) {
                r5 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(r5);
            int[] r52 = this.mHashes;
            if (r52.length > 0) {
                System.arraycopy(r4, 0, r52, 0, r4.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(r4, objArr, this.mSize);
        }
        int r0 = this.mSize;
        if (r1 < r0) {
            int[] r32 = this.mHashes;
            int r42 = r1 + 1;
            System.arraycopy(r32, r1, r32, r42, r0 - r1);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, r1, objArr2, r42, this.mSize - r1);
        }
        this.mHashes[r1] = r2;
        this.mArray[r1] = e;
        this.mSize++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.mSize;
        int[] r0 = this.mHashes;
        boolean z = false;
        if (r0.length < size) {
            Object[] objArr = this.mArray;
            allocArrays(size);
            int r1 = this.mSize;
            if (r1 > 0) {
                System.arraycopy(r0, 0, this.mHashes, 0, r1);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(r0, objArr, this.mSize);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public final void allocArrays(int r6) {
        if (r6 == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = sTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    sTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (r6 == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = sBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    sBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[r6];
        this.mArray = new Object[r6];
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int r0 = this.mSize;
        if (r0 != 0) {
            freeArrays(this.mHashes, this.mArray, r0);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.mSize != set.size()) {
                return false;
            }
            for (int r1 = 0; r1 < this.mSize; r1++) {
                try {
                    if (!set.contains(this.mArray[r1])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] r0 = this.mHashes;
        int r1 = this.mSize;
        int r3 = 0;
        for (int r2 = 0; r2 < r1; r2++) {
            r3 += r0[r2];
        }
        return r3;
    }

    public final int indexOf(int r5, Object obj) {
        int r0 = this.mSize;
        if (r0 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, r0, r5);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int r2 = binarySearch + 1;
        while (r2 < r0 && this.mHashes[r2] == r5) {
            if (obj.equals(this.mArray[r2])) {
                return r2;
            }
            r2++;
        }
        for (int r1 = binarySearch - 1; r1 >= 0 && this.mHashes[r1] == r5; r1--) {
            if (obj.equals(this.mArray[r1])) {
                return r1;
            }
        }
        return ~r2;
    }

    public final int indexOfNull() {
        int r0 = this.mSize;
        if (r0 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, r0, 0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int r2 = binarySearch + 1;
        while (r2 < r0 && this.mHashes[r2] == 0) {
            if (this.mArray[r2] == null) {
                return r2;
            }
            r2++;
        }
        for (int r1 = binarySearch - 1; r1 >= 0 && this.mHashes[r1] == 0; r1--) {
            if (this.mArray[r1] == null) {
                return r1;
            }
        }
        return ~r2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.collection.ArraySet$1] */
    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<Object, Object>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                public final void colClear() {
                    ArraySet.this.clear();
                }

                @Override // androidx.collection.MapCollections
                public final Object colGetEntry(int r1, int r2) {
                    return ArraySet.this.mArray[r1];
                }

                @Override // androidx.collection.MapCollections
                public final Map<Object, Object> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                public final int colGetSize() {
                    return ArraySet.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                public final int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                public final int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                public final void colPut(Object obj, Object obj2) {
                    ArraySet.this.add(obj);
                }

                @Override // androidx.collection.MapCollections
                public final void colRemoveAt(int r2) {
                    ArraySet.this.removeAt(r2);
                }

                @Override // androidx.collection.MapCollections
                public final Object colSetValue(int r1, Object obj) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (anonymousClass1.mKeySet == null) {
            anonymousClass1.mKeySet = new MapCollections.KeySet();
        }
        return (Iterator<E>) anonymousClass1.mKeySet.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    public final void removeAt(int r8) {
        Object[] objArr = this.mArray;
        Object obj = objArr[r8];
        int r1 = this.mSize;
        if (r1 <= 1) {
            freeArrays(this.mHashes, objArr, r1);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
            return;
        }
        int[] r4 = this.mHashes;
        int r6 = 8;
        if (r4.length > 8 && r1 < r4.length / 3) {
            if (r1 > 8) {
                r6 = r1 + (r1 >> 1);
            }
            allocArrays(r6);
            this.mSize--;
            if (r8 > 0) {
                System.arraycopy(r4, 0, this.mHashes, 0, r8);
                System.arraycopy(objArr, 0, this.mArray, 0, r8);
            }
            int r12 = this.mSize;
            if (r8 < r12) {
                int r2 = r8 + 1;
                System.arraycopy(r4, r2, this.mHashes, r8, r12 - r8);
                System.arraycopy(objArr, r2, this.mArray, r8, this.mSize - r8);
                return;
            }
            return;
        }
        int r13 = r1 - 1;
        this.mSize = r13;
        if (r8 < r13) {
            int r0 = r8 + 1;
            System.arraycopy(r4, r0, r4, r8, r13 - r8);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, r0, objArr2, r8, this.mSize - r8);
        }
        this.mArray[this.mSize] = null;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int r0 = this.mSize - 1; r0 >= 0; r0--) {
            if (!collection.contains(this.mArray[r0])) {
                removeAt(r0);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int r0 = this.mSize;
        Object[] objArr = new Object[r0];
        System.arraycopy(this.mArray, 0, objArr, 0, r0);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int r1 = 0; r1 < this.mSize; r1++) {
            if (r1 > 0) {
                sb.append(", ");
            }
            Object obj = this.mArray[r1];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public ArraySet(int r1) {
        if (r1 == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(r1);
        }
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int r1 = this.mSize;
        if (length > r1) {
            tArr[r1] = null;
        }
        return tArr;
    }

    public final int indexOf(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj.hashCode(), obj);
    }
}
