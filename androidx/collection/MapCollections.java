package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class MapCollections<K, V> {
    public MapCollections<K, V>.EntrySet mEntrySet;
    public MapCollections<K, V>.KeySet mKeySet;
    public MapCollections<K, V>.ValuesCollection mValues;

    /* loaded from: classes.dex */
    public final class ArrayIterator<T> implements Iterator<T> {
        public boolean mCanRemove = false;
        public int mIndex;
        public final int mOffset;
        public int mSize;

        public ArrayIterator(int r3) {
            this.mOffset = r3;
            this.mSize = MapCollections.this.colGetSize();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mIndex < this.mSize) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (hasNext()) {
                T t = (T) MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
                this.mIndex++;
                this.mCanRemove = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.mCanRemove) {
                int r0 = this.mIndex - 1;
                this.mIndex = r0;
                this.mSize--;
                this.mCanRemove = false;
                MapCollections.this.colRemoveAt(r0);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public final class EntrySet implements Set<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            MapCollections mapCollections = MapCollections.this;
            int colGetSize = mapCollections.colGetSize();
            for (Map.Entry<K, V> entry : collection) {
                mapCollections.colPut(entry.getKey(), entry.getValue());
            }
            if (colGetSize != mapCollections.colGetSize()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            MapCollections mapCollections = MapCollections.this;
            int colIndexOfKey = mapCollections.colIndexOfKey(key);
            if (colIndexOfKey < 0) {
                return false;
            }
            Object colGetEntry = mapCollections.colGetEntry(colIndexOfKey, 1);
            Object value = entry.getValue();
            if (colGetEntry != value && (colGetEntry == null || !colGetEntry.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int hashCode;
            int hashCode2;
            MapCollections mapCollections = MapCollections.this;
            int r4 = 0;
            for (int colGetSize = mapCollections.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = mapCollections.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = mapCollections.colGetEntry(colGetSize, 1);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                if (colGetEntry2 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = colGetEntry2.hashCode();
                }
                r4 += hashCode ^ hashCode2;
            }
            return r4;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public final class KeySet implements Set<K> {
        public KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            if (MapCollections.this.colIndexOfKey(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Map<K, V> colGetMap = MapCollections.this.colGetMap();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!colGetMap.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int hashCode;
            MapCollections mapCollections = MapCollections.this;
            int r3 = 0;
            for (int colGetSize = mapCollections.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = mapCollections.colGetEntry(colGetSize, 0);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                r3 += hashCode;
            }
            return r3;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            MapCollections mapCollections = MapCollections.this;
            int colIndexOfKey = mapCollections.colIndexOfKey(obj);
            if (colIndexOfKey >= 0) {
                mapCollections.colRemoveAt(colIndexOfKey);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            Map<K, V> colGetMap = MapCollections.this.colGetMap();
            int size = colGetMap.size();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                colGetMap.remove(it.next());
            }
            if (size != colGetMap.size()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(0, tArr);
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            MapCollections mapCollections = MapCollections.this;
            int colGetSize = mapCollections.colGetSize();
            Object[] objArr = new Object[colGetSize];
            for (int r4 = 0; r4 < colGetSize; r4++) {
                objArr[r4] = mapCollections.colGetEntry(r4, 0);
            }
            return objArr;
        }
    }

    /* loaded from: classes.dex */
    public final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        public int mEnd;
        public boolean mEntryValid = false;
        public int mIndex = -1;

        public MapIterator() {
            this.mEnd = MapCollections.this.colGetSize() - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            boolean z;
            boolean z2;
            if (this.mEntryValid) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int r2 = this.mIndex;
                MapCollections mapCollections = MapCollections.this;
                Object colGetEntry = mapCollections.colGetEntry(r2, 0);
                if (key != colGetEntry && (key == null || !key.equals(colGetEntry))) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return false;
                }
                Object value = entry.getValue();
                Object colGetEntry2 = mapCollections.colGetEntry(this.mIndex, 1);
                if (value != colGetEntry2 && (value == null || !value.equals(colGetEntry2))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (this.mEntryValid) {
                return (K) MapCollections.this.colGetEntry(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (this.mEntryValid) {
                return (V) MapCollections.this.colGetEntry(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mIndex < this.mEnd) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int hashCode;
            if (this.mEntryValid) {
                int r0 = this.mIndex;
                MapCollections mapCollections = MapCollections.this;
                int r2 = 0;
                Object colGetEntry = mapCollections.colGetEntry(r0, 0);
                Object colGetEntry2 = mapCollections.colGetEntry(this.mIndex, 1);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                if (colGetEntry2 != null) {
                    r2 = colGetEntry2.hashCode();
                }
                return hashCode ^ r2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (hasNext()) {
                this.mIndex++;
                this.mEntryValid = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.mEntryValid) {
                MapCollections.this.colRemoveAt(this.mIndex);
                this.mIndex--;
                this.mEnd--;
                this.mEntryValid = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            if (this.mEntryValid) {
                return (V) MapCollections.this.colSetValue(this.mIndex, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    public final class ValuesCollection implements Collection<V> {
        public ValuesCollection() {
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            if (MapCollections.this.colIndexOfValue(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            MapCollections mapCollections = MapCollections.this;
            int colIndexOfValue = mapCollections.colIndexOfValue(obj);
            if (colIndexOfValue >= 0) {
                mapCollections.colRemoveAt(colIndexOfValue);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            MapCollections mapCollections = MapCollections.this;
            int colGetSize = mapCollections.colGetSize();
            int r2 = 0;
            boolean z = false;
            while (r2 < colGetSize) {
                if (collection.contains(mapCollections.colGetEntry(r2, 1))) {
                    mapCollections.colRemoveAt(r2);
                    r2--;
                    colGetSize--;
                    z = true;
                }
                r2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            MapCollections mapCollections = MapCollections.this;
            int colGetSize = mapCollections.colGetSize();
            int r2 = 0;
            boolean z = false;
            while (r2 < colGetSize) {
                if (!collection.contains(mapCollections.colGetEntry(r2, 1))) {
                    mapCollections.colRemoveAt(r2);
                    r2--;
                    colGetSize--;
                    z = true;
                }
                r2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(1, tArr);
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            MapCollections mapCollections = MapCollections.this;
            int colGetSize = mapCollections.colGetSize();
            Object[] objArr = new Object[colGetSize];
            for (int r3 = 0; r3 < colGetSize; r3++) {
                objArr[r3] = mapCollections.colGetEntry(r3, 1);
            }
            return objArr;
        }
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public abstract void colClear();

    public abstract Object colGetEntry(int r1, int r2);

    public abstract Map<K, V> colGetMap();

    public abstract int colGetSize();

    public abstract int colIndexOfKey(Object obj);

    public abstract int colIndexOfValue(Object obj);

    public abstract void colPut(K k, V v);

    public abstract void colRemoveAt(int r1);

    public abstract V colSetValue(int r1, V v);

    public final Object[] toArrayHelper(int r4, Object[] objArr) {
        int colGetSize = colGetSize();
        if (objArr.length < colGetSize) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), colGetSize);
        }
        for (int r1 = 0; r1 < colGetSize; r1++) {
            objArr[r1] = colGetEntry(r1, r4);
        }
        if (objArr.length > colGetSize) {
            objArr[colGetSize] = null;
        }
        return objArr;
    }
}
