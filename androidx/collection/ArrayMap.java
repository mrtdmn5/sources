package androidx.collection;

import androidx.collection.MapCollections;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    public AnonymousClass1 mCollections;

    /* renamed from: androidx.collection.ArrayMap$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends MapCollections<Object, Object> {
        public AnonymousClass1() {
        }

        @Override // androidx.collection.MapCollections
        public final void colClear() {
            ArrayMap.this.clear();
        }

        @Override // androidx.collection.MapCollections
        public final Object colGetEntry(int r2, int r3) {
            return ArrayMap.this.mArray[(r2 << 1) + r3];
        }

        @Override // androidx.collection.MapCollections
        public final Map<Object, Object> colGetMap() {
            return ArrayMap.this;
        }

        @Override // androidx.collection.MapCollections
        public final int colGetSize() {
            return ArrayMap.this.mSize;
        }

        @Override // androidx.collection.MapCollections
        public final int colIndexOfKey(Object obj) {
            return ArrayMap.this.indexOfKey(obj);
        }

        @Override // androidx.collection.MapCollections
        public final int colIndexOfValue(Object obj) {
            return ArrayMap.this.indexOfValue(obj);
        }

        @Override // androidx.collection.MapCollections
        public final void colPut(Object obj, Object obj2) {
            ArrayMap.this.put(obj, obj2);
        }

        @Override // androidx.collection.MapCollections
        public final void colRemoveAt(int r2) {
            ArrayMap.this.removeAt(r2);
        }

        @Override // androidx.collection.MapCollections
        public final Object colSetValue(int r3, Object obj) {
            int r32 = (r3 << 1) + 1;
            Object[] objArr = ArrayMap.this.mArray;
            Object obj2 = objArr[r32];
            objArr[r32] = obj;
            return obj2;
        }
    }

    public ArrayMap() {
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1();
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (anonymousClass1.mEntrySet == null) {
            anonymousClass1.mEntrySet = new MapCollections.EntrySet();
        }
        return anonymousClass1.mEntrySet;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1();
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (anonymousClass1.mKeySet == null) {
            anonymousClass1.mKeySet = new MapCollections.KeySet();
        }
        return anonymousClass1.mKeySet;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size() + this.mSize);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1();
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (anonymousClass1.mValues == null) {
            anonymousClass1.mValues = new MapCollections.ValuesCollection();
        }
        return anonymousClass1.mValues;
    }

    public ArrayMap(ArrayMap arrayMap) {
        if (arrayMap != null) {
            int r0 = arrayMap.mSize;
            ensureCapacity(this.mSize + r0);
            if (this.mSize != 0) {
                for (int r2 = 0; r2 < r0; r2++) {
                    put(arrayMap.keyAt(r2), arrayMap.valueAt(r2));
                }
            } else if (r0 > 0) {
                System.arraycopy(arrayMap.mHashes, 0, this.mHashes, 0, r0);
                System.arraycopy(arrayMap.mArray, 0, this.mArray, 0, r0 << 1);
                this.mSize = r0;
            }
        }
    }
}
