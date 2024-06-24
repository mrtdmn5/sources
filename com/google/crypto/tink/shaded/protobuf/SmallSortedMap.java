package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean isImmutable;
    public volatile SmallSortedMap<K, V>.DescendingEntrySet lazyDescendingEntrySet;
    public volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    public final int maxArraySize;
    public List<SmallSortedMap<K, V>.Entry> entryList = Collections.emptyList();
    public Map<K, V> overflowEntries = Collections.emptyMap();
    public Map<K, V> overflowEntriesDescending = Collections.emptyMap();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.SmallSortedMap$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 extends SmallSortedMap<Object, Object> {
        @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap
        public final void makeImmutable() {
            if (!this.isImmutable) {
                for (int r0 = 0; r0 < getNumArrayEntries(); r0++) {
                    ((FieldSet.FieldDescriptorLite) getArrayEntryAt(r0).getKey()).isRepeated();
                }
                Iterator<Map.Entry<Object, Object>> it = getOverflowEntries().iterator();
                while (it.hasNext()) {
                    ((FieldSet.FieldDescriptorLite) it.next().getKey()).isRepeated();
                }
            }
            super.makeImmutable();
        }
    }

    /* loaded from: classes3.dex */
    public class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        public Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        public int pos;

        public DescendingEntryIterator() {
            this.pos = SmallSortedMap.this.entryList.size();
        }

        public final Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntriesDescending.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int r0 = this.pos;
            if ((r0 > 0 && r0 <= SmallSortedMap.this.entryList.size()) || getOverflowIterator().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (getOverflowIterator().hasNext()) {
                return getOverflowIterator().next();
            }
            List<SmallSortedMap<K, V>.Entry> list = SmallSortedMap.this.entryList;
            int r1 = this.pos - 1;
            this.pos = r1;
            return list.get(r1);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        public DescendingEntrySet() {
            super();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }
    }

    /* loaded from: classes3.dex */
    public static class EmptySet {
        public static final AnonymousClass1 ITERATOR = new AnonymousClass1();
        public static final AnonymousClass2 ITERABLE = new AnonymousClass2();

        /* renamed from: com.google.crypto.tink.shaded.protobuf.SmallSortedMap$EmptySet$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements Iterator<Object> {
            @Override // java.util.Iterator
            public final boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: com.google.crypto.tink.shaded.protobuf.SmallSortedMap$EmptySet$2, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass2 implements Iterable<Object> {
            @Override // java.lang.Iterable
            public final Iterator<Object> iterator() {
                return EmptySet.ITERATOR;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        public final K key;
        public V value;

        public Entry() {
            throw null;
        }

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.key.compareTo(((Entry) obj).key);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            boolean equals;
            boolean equals2;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            K k = this.key;
            if (k == null) {
                if (key == null) {
                    equals = true;
                } else {
                    equals = false;
                }
            } else {
                equals = k.equals(key);
            }
            if (equals) {
                V v = this.value;
                Object value = entry.getValue();
                if (v == null) {
                    if (value == null) {
                        equals2 = true;
                    } else {
                        equals2 = false;
                    }
                } else {
                    equals2 = v.equals(value);
                }
                if (equals2) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int hashCode;
            int r0 = 0;
            K k = this.key;
            if (k == null) {
                hashCode = 0;
            } else {
                hashCode = k.hashCode();
            }
            V v = this.value;
            if (v != null) {
                r0 = v.hashCode();
            }
            return r0 ^ hashCode;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            int r0 = SmallSortedMap.$r8$clinit;
            SmallSortedMap.this.checkMutable();
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* loaded from: classes3.dex */
    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        public Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        public boolean nextCalledBeforeRemove;
        public int pos = -1;

        public EntryIterator() {
        }

        public final Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int r0 = this.pos + 1;
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            if (r0 < smallSortedMap.entryList.size()) {
                return true;
            }
            if (!smallSortedMap.overflowEntries.isEmpty() && getOverflowIterator().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.nextCalledBeforeRemove = true;
            int r1 = this.pos + 1;
            this.pos = r1;
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            if (r1 < smallSortedMap.entryList.size()) {
                return smallSortedMap.entryList.get(this.pos);
            }
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.nextCalledBeforeRemove) {
                this.nextCalledBeforeRemove = false;
                int r0 = SmallSortedMap.$r8$clinit;
                SmallSortedMap smallSortedMap = SmallSortedMap.this;
                smallSortedMap.checkMutable();
                if (this.pos < smallSortedMap.entryList.size()) {
                    int r1 = this.pos;
                    this.pos = r1 - 1;
                    smallSortedMap.removeArrayEntryAt(r1);
                    return;
                }
                getOverflowIterator().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* loaded from: classes3.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                SmallSortedMap.this.put((SmallSortedMap) entry.getKey(), (Comparable) entry.getValue());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                SmallSortedMap.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return SmallSortedMap.this.size();
        }
    }

    public SmallSortedMap(int r1) {
        this.maxArraySize = r1;
    }

    public final int binarySearchInArray(K k) {
        int size = this.entryList.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.entryList.get(size).key);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int r1 = 0;
        while (r1 <= size) {
            int r2 = (r1 + size) / 2;
            int compareTo2 = k.compareTo(this.entryList.get(r2).key);
            if (compareTo2 < 0) {
                size = r2 - 1;
            } else if (compareTo2 > 0) {
                r1 = r2 + 1;
            } else {
                return r2;
            }
        }
        return -(r1 + 1);
    }

    public final void checkMutable() {
        if (!this.isImmutable) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (!this.overflowEntries.isEmpty()) {
            this.overflowEntries.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (binarySearchInArray(comparable) < 0 && !this.overflowEntries.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new EntrySet();
        }
        return this.lazyEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int numArrayEntries = getNumArrayEntries();
        if (numArrayEntries != smallSortedMap.getNumArrayEntries()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int r4 = 0; r4 < numArrayEntries; r4++) {
            if (!getArrayEntryAt(r4).equals(smallSortedMap.getArrayEntryAt(r4))) {
                return false;
            }
        }
        if (numArrayEntries == size) {
            return true;
        }
        return this.overflowEntries.equals(smallSortedMap.overflowEntries);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).value;
        }
        return this.overflowEntries.get(comparable);
    }

    public final Map.Entry<K, V> getArrayEntryAt(int r2) {
        return this.entryList.get(r2);
    }

    public final int getNumArrayEntries() {
        return this.entryList.size();
    }

    public final Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty()) {
            return EmptySet.ITERABLE;
        }
        return this.overflowEntries.entrySet();
    }

    public final SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.overflowEntries = treeMap;
            this.overflowEntriesDescending = treeMap.descendingMap();
        }
        return (SortedMap) this.overflowEntries;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int numArrayEntries = getNumArrayEntries();
        int r2 = 0;
        for (int r1 = 0; r1 < numArrayEntries; r1++) {
            r2 += this.entryList.get(r1).hashCode();
        }
        if (this.overflowEntries.size() > 0) {
            return r2 + this.overflowEntries.hashCode();
        }
        return r2;
    }

    public void makeImmutable() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (!this.isImmutable) {
            if (this.overflowEntries.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.overflowEntries);
            }
            this.overflowEntries = unmodifiableMap;
            if (this.overflowEntriesDescending.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.overflowEntriesDescending);
            }
            this.overflowEntriesDescending = unmodifiableMap2;
            this.isImmutable = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((SmallSortedMap<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        checkMutable();
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return (V) removeArrayEntryAt(binarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    public final V removeArrayEntryAt(int r6) {
        checkMutable();
        V v = this.entryList.remove(r6).value;
        if (!this.overflowEntries.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = getOverflowEntriesMutable().entrySet().iterator();
            List<SmallSortedMap<K, V>.Entry> list = this.entryList;
            Map.Entry<K, V> next = it.next();
            list.add(new Entry(next.getKey(), next.getValue()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.overflowEntries.size() + this.entryList.size();
    }

    public final V put(K k, V v) {
        checkMutable();
        int binarySearchInArray = binarySearchInArray(k);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).setValue(v);
        }
        checkMutable();
        boolean isEmpty = this.entryList.isEmpty();
        int r2 = this.maxArraySize;
        if (isEmpty && !(this.entryList instanceof ArrayList)) {
            this.entryList = new ArrayList(r2);
        }
        int r0 = -(binarySearchInArray + 1);
        if (r0 >= r2) {
            return getOverflowEntriesMutable().put(k, v);
        }
        if (this.entryList.size() == r2) {
            SmallSortedMap<K, V>.Entry remove = this.entryList.remove(r2 - 1);
            getOverflowEntriesMutable().put(remove.key, remove.value);
        }
        this.entryList.add(r0, new Entry(k, v));
        return null;
    }
}
