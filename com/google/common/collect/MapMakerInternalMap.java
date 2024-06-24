package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static final AnonymousClass1 UNSET_WEAK_VALUE_REFERENCE = new AnonymousClass1();
    public final int concurrencyLevel = Math.min(4, 65536);
    public final transient InternalEntryHelper<K, V, E, S> entryHelper;
    public transient EntrySet entrySet;
    public final Equivalence<Object> keyEquivalence;
    public transient KeySet keySet;
    public final transient int segmentMask;
    public final transient int segmentShift;
    public final transient Segment<K, V, E, S>[] segments;
    public transient Values values;

    /* loaded from: classes3.dex */
    public static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        public final int hash;
        public final K key;
        public final E next;

        public AbstractStrongKeyEntry(K k, int r2, E e) {
            this.key = k;
            this.hash = r2;
            this.next = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final E getNext() {
            return this.next;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        public final int hash;
        public final E next;

        public AbstractWeakKeyEntry(ReferenceQueue<K> referenceQueue, K k, int r3, E e) {
            super(k, referenceQueue);
            this.hash = r3;
            this.next = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final E getNext() {
            return this.next;
        }
    }

    /* loaded from: classes3.dex */
    public static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        public DummyInternalEntry() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final DummyInternalEntry getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            throw new AssertionError();
        }
    }

    /* loaded from: classes3.dex */
    public final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        @Override // java.util.Iterator
        public final Object next() {
            return nextEntry();
        }
    }

    /* loaded from: classes3.dex */
    public final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            MapMakerInternalMap mapMakerInternalMap;
            Object obj2;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = (mapMakerInternalMap = MapMakerInternalMap.this).get(key)) == null || !mapMakerInternalMap.entryHelper.valueStrength().defaultEquivalence().equivalent(entry.getValue(), obj2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !MapMakerInternalMap.this.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class HashIterator<T> implements Iterator<T> {
        public Segment<K, V, E, S> currentSegment;
        public AtomicReferenceArray<E> currentTable;
        public MapMakerInternalMap<K, V, E, S>.WriteThroughEntry lastReturned;
        public E nextEntry;
        public MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextExternal;
        public int nextSegmentIndex;
        public int nextTableIndex = -1;

        public HashIterator() {
            this.nextSegmentIndex = MapMakerInternalMap.this.segments.length - 1;
            advance();
        }

        public final void advance() {
            boolean z;
            this.nextExternal = null;
            E e = this.nextEntry;
            if (e != null) {
                while (true) {
                    E e2 = (E) e.getNext();
                    this.nextEntry = e2;
                    if (e2 == null) {
                        break;
                    }
                    if (advanceTo(e2)) {
                        z = true;
                        break;
                    }
                    e = this.nextEntry;
                }
            }
            z = false;
            if (z || nextInTable()) {
                return;
            }
            while (true) {
                int r0 = this.nextSegmentIndex;
                if (r0 >= 0) {
                    Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                    this.nextSegmentIndex = r0 - 1;
                    Segment<K, V, E, S> segment = segmentArr[r0];
                    this.currentSegment = segment;
                    if (segment.count != 0) {
                        this.currentTable = this.currentSegment.table;
                        this.nextTableIndex = r0.length() - 1;
                        if (nextInTable()) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        public final boolean advanceTo(E e) {
            Object value;
            MapMakerInternalMap mapMakerInternalMap = MapMakerInternalMap.this;
            try {
                Object key = e.getKey();
                mapMakerInternalMap.getClass();
                if (e.getKey() == null) {
                    value = null;
                } else {
                    value = e.getValue();
                }
                if (value != null) {
                    this.nextExternal = new WriteThroughEntry(key, value);
                    this.currentSegment.postReadCleanup();
                    return true;
                }
                this.currentSegment.postReadCleanup();
                return false;
            } catch (Throwable th) {
                this.currentSegment.postReadCleanup();
                throw th;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.nextExternal != null) {
                return true;
            }
            return false;
        }

        public final MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextEntry() {
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.nextExternal;
            if (writeThroughEntry != null) {
                this.lastReturned = writeThroughEntry;
                advance();
                return this.lastReturned;
            }
            throw new NoSuchElementException();
        }

        public final boolean nextInTable() {
            while (true) {
                int r0 = this.nextTableIndex;
                boolean z = false;
                if (r0 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.currentTable;
                this.nextTableIndex = r0 - 1;
                E e = atomicReferenceArray.get(r0);
                this.nextEntry = e;
                if (e != null) {
                    if (advanceTo(e)) {
                        break;
                    }
                    E e2 = this.nextEntry;
                    if (e2 != null) {
                        while (true) {
                            E e3 = (E) e2.getNext();
                            this.nextEntry = e3;
                            if (e3 == null) {
                                break;
                            }
                            if (advanceTo(e3)) {
                                z = true;
                                break;
                            }
                            e2 = this.nextEntry;
                        }
                    }
                    if (z) {
                        break;
                    }
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public final void remove() {
            boolean z;
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.lastReturned;
            if (writeThroughEntry != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                MapMakerInternalMap.this.remove(writeThroughEntry.key);
                this.lastReturned = null;
                return;
            }
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    /* loaded from: classes3.dex */
    public interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* loaded from: classes3.dex */
    public interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        E copy(S s, E e, E e2);

        E newEntry(S s, K k, int r3, E e);

        Segment newSegment(MapMakerInternalMap mapMakerInternalMap, int r2);

        void setValue(S s, E e, V v);

        Strength valueStrength();
    }

    /* loaded from: classes3.dex */
    public final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        @Override // java.util.Iterator
        public final K next() {
            return nextEntry().key;
        }
    }

    /* loaded from: classes3.dex */
    public final class KeySet extends SafeToArraySet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (MapMakerInternalMap.this.remove(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return MapMakerInternalMap.access$900(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.access$900(this).toArray(tArr);
        }
    }

    /* loaded from: classes3.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.Equals.INSTANCE;
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.Identity.INSTANCE;
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
        public volatile V value;

        /* loaded from: classes3.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
            public static final Helper<?, ?> INSTANCE = new Helper<>();

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry copy(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                StrongKeyStrongValueEntry strongKeyStrongValueEntry = (StrongKeyStrongValueEntry) internalEntry;
                StrongKeyStrongValueEntry strongKeyStrongValueEntry2 = new StrongKeyStrongValueEntry(strongKeyStrongValueEntry.key, strongKeyStrongValueEntry.hash, (StrongKeyStrongValueEntry) internalEntry2);
                strongKeyStrongValueEntry2.value = strongKeyStrongValueEntry.value;
                return strongKeyStrongValueEntry2;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry newEntry(Segment segment, Object obj, int r3, InternalEntry internalEntry) {
                return new StrongKeyStrongValueEntry(obj, r3, (StrongKeyStrongValueEntry) internalEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment newSegment(MapMakerInternalMap mapMakerInternalMap, int r3) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                ((StrongKeyStrongValueEntry) internalEntry).value = obj;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        public StrongKeyStrongValueEntry(K k, int r2, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
            super(k, r2, strongKeyStrongValueEntry);
            this.value = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final V getValue() {
            return this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
        public volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> valueReference;

        /* loaded from: classes3.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
            public static final Helper<?, ?> INSTANCE = new Helper<>();

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry copy(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                boolean z;
                StrongKeyWeakValueSegment strongKeyWeakValueSegment = (StrongKeyWeakValueSegment) segment;
                StrongKeyWeakValueEntry strongKeyWeakValueEntry = (StrongKeyWeakValueEntry) internalEntry;
                StrongKeyWeakValueEntry strongKeyWeakValueEntry2 = (StrongKeyWeakValueEntry) internalEntry2;
                int r0 = Segment.$r8$clinit;
                if (strongKeyWeakValueEntry.getValue() == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return null;
                }
                ReferenceQueue<V> referenceQueue = strongKeyWeakValueSegment.queueForValues;
                StrongKeyWeakValueEntry strongKeyWeakValueEntry3 = new StrongKeyWeakValueEntry(strongKeyWeakValueEntry.key, strongKeyWeakValueEntry.hash, strongKeyWeakValueEntry2);
                strongKeyWeakValueEntry3.valueReference = strongKeyWeakValueEntry.valueReference.copyFor(referenceQueue, strongKeyWeakValueEntry3);
                return strongKeyWeakValueEntry3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry newEntry(Segment segment, Object obj, int r3, InternalEntry internalEntry) {
                return new StrongKeyWeakValueEntry(obj, r3, (StrongKeyWeakValueEntry) internalEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment newSegment(MapMakerInternalMap mapMakerInternalMap, int r3) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, r3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                StrongKeyWeakValueEntry strongKeyWeakValueEntry = (StrongKeyWeakValueEntry) internalEntry;
                ReferenceQueue<V> referenceQueue = ((StrongKeyWeakValueSegment) segment).queueForValues;
                WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> weakValueReference = strongKeyWeakValueEntry.valueReference;
                strongKeyWeakValueEntry.valueReference = new WeakValueReferenceImpl(referenceQueue, obj, strongKeyWeakValueEntry);
                weakValueReference.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength valueStrength() {
                return Strength.WEAK;
            }
        }

        public StrongKeyWeakValueEntry(K k, int r2, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
            super(k, r2, strongKeyWeakValueEntry);
            this.valueReference = MapMakerInternalMap.UNSET_WEAK_VALUE_REFERENCE;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final V getValue() {
            return this.valueReference.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }
    }

    /* loaded from: classes3.dex */
    public final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        @Override // java.util.Iterator
        public final V next() {
            return nextEntry().value;
        }
    }

    /* loaded from: classes3.dex */
    public final class Values extends AbstractCollection<V> {
        public Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return MapMakerInternalMap.access$900(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.access$900(this).toArray(tArr);
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
        public volatile V value;

        /* loaded from: classes3.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
            public static final Helper<?, ?> INSTANCE = new Helper<>();

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry copy(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                WeakKeyStrongValueSegment weakKeyStrongValueSegment = (WeakKeyStrongValueSegment) segment;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry = (WeakKeyStrongValueEntry) internalEntry;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry2 = (WeakKeyStrongValueEntry) internalEntry2;
                if (weakKeyStrongValueEntry.get() == null) {
                    return null;
                }
                WeakKeyStrongValueEntry weakKeyStrongValueEntry3 = new WeakKeyStrongValueEntry(weakKeyStrongValueSegment.queueForKeys, weakKeyStrongValueEntry.get(), weakKeyStrongValueEntry.hash, weakKeyStrongValueEntry2);
                weakKeyStrongValueEntry3.value = weakKeyStrongValueEntry.value;
                return weakKeyStrongValueEntry3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry newEntry(Segment segment, Object obj, int r4, InternalEntry internalEntry) {
                return new WeakKeyStrongValueEntry(((WeakKeyStrongValueSegment) segment).queueForKeys, obj, r4, (WeakKeyStrongValueEntry) internalEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment newSegment(MapMakerInternalMap mapMakerInternalMap, int r3) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, r3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                ((WeakKeyStrongValueEntry) internalEntry).value = obj;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        public WeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k, int r3, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
            super(referenceQueue, k, r3, weakKeyStrongValueEntry);
            this.value = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final V getValue() {
            return this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
        public volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> valueReference;

        /* loaded from: classes3.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
            public static final Helper<?, ?> INSTANCE = new Helper<>();

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry copy(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                boolean z;
                WeakKeyWeakValueSegment weakKeyWeakValueSegment = (WeakKeyWeakValueSegment) segment;
                WeakKeyWeakValueEntry weakKeyWeakValueEntry = (WeakKeyWeakValueEntry) internalEntry;
                WeakKeyWeakValueEntry weakKeyWeakValueEntry2 = (WeakKeyWeakValueEntry) internalEntry2;
                if (weakKeyWeakValueEntry.get() != null) {
                    int r0 = Segment.$r8$clinit;
                    if (weakKeyWeakValueEntry.getValue() == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        ReferenceQueue<K> referenceQueue = weakKeyWeakValueSegment.queueForKeys;
                        ReferenceQueue<V> referenceQueue2 = weakKeyWeakValueSegment.queueForValues;
                        WeakKeyWeakValueEntry weakKeyWeakValueEntry3 = new WeakKeyWeakValueEntry(referenceQueue, weakKeyWeakValueEntry.get(), weakKeyWeakValueEntry.hash, weakKeyWeakValueEntry2);
                        weakKeyWeakValueEntry3.valueReference = weakKeyWeakValueEntry.valueReference.copyFor(referenceQueue2, weakKeyWeakValueEntry3);
                        return weakKeyWeakValueEntry3;
                    }
                }
                return null;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry newEntry(Segment segment, Object obj, int r4, InternalEntry internalEntry) {
                return new WeakKeyWeakValueEntry(((WeakKeyWeakValueSegment) segment).queueForKeys, obj, r4, (WeakKeyWeakValueEntry) internalEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment newSegment(MapMakerInternalMap mapMakerInternalMap, int r3) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, r3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                WeakKeyWeakValueEntry weakKeyWeakValueEntry = (WeakKeyWeakValueEntry) internalEntry;
                ReferenceQueue<V> referenceQueue = ((WeakKeyWeakValueSegment) segment).queueForValues;
                WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> weakValueReference = weakKeyWeakValueEntry.valueReference;
                weakKeyWeakValueEntry.valueReference = new WeakValueReferenceImpl(referenceQueue, obj, weakKeyWeakValueEntry);
                weakValueReference.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength valueStrength() {
                return Strength.WEAK;
            }
        }

        public WeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k, int r3, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
            super(referenceQueue, k, r3, weakKeyWeakValueEntry);
            this.valueReference = MapMakerInternalMap.UNSET_WEAK_VALUE_REFERENCE;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final V getValue() {
            return this.valueReference.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }
    }

    /* loaded from: classes3.dex */
    public interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        WeakValueReference<K, V, E> getValueReference();
    }

    /* loaded from: classes3.dex */
    public interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        void clear();

        WeakValueReference copyFor(ReferenceQueue referenceQueue, WeakValueEntry weakValueEntry);

        V get();

        E getEntry();
    }

    /* loaded from: classes3.dex */
    public static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        public final E entry;

        public WeakValueReferenceImpl(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.entry = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final WeakValueReference copyFor(ReferenceQueue referenceQueue, WeakValueEntry weakValueEntry) {
            return new WeakValueReferenceImpl(referenceQueue, get(), weakValueEntry);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final E getEntry() {
            return this.entry;
        }
    }

    /* loaded from: classes3.dex */
    public final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        public final K key;
        public V value;

        public WriteThroughEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.key.equals(entry.getKey()) || !this.value.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.key, v);
            this.value = v;
            return v2;
        }
    }

    public MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        Equivalence<Object> defaultEquivalence = mapMaker.getKeyStrength().defaultEquivalence();
        if (defaultEquivalence != null) {
            this.keyEquivalence = defaultEquivalence;
            this.entryHelper = internalEntryHelper;
            int min = Math.min(16, 1073741824);
            int r6 = 1;
            int r0 = 0;
            int r1 = 1;
            int r2 = 0;
            while (r1 < this.concurrencyLevel) {
                r2++;
                r1 <<= 1;
            }
            this.segmentShift = 32 - r2;
            this.segmentMask = r1 - 1;
            this.segments = new Segment[r1];
            int r22 = min / r1;
            while (r6 < (r1 * r22 < min ? r22 + 1 : r22)) {
                r6 <<= 1;
            }
            while (true) {
                Segment<K, V, E, S>[] segmentArr = this.segments;
                if (r0 < segmentArr.length) {
                    segmentArr[r0] = this.entryHelper.newSegment(this, r6);
                    r0++;
                } else {
                    return;
                }
            }
        } else {
            throw new NullPointerException("Both parameters are null");
        }
    }

    public static ArrayList access$900(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        it.getClass();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        int length = segmentArr.length;
        for (int r3 = 0; r3 < length; r3++) {
            Segment<K, V, E, S> segment = segmentArr[r3];
            if (segment.count != 0) {
                segment.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = segment.table;
                    for (int r6 = 0; r6 < atomicReferenceArray.length(); r6++) {
                        atomicReferenceArray.set(r6, null);
                    }
                    segment.maybeClearReferenceQueues();
                    segment.readCount.set(0);
                    segment.modCount++;
                    segment.count = 0;
                } finally {
                    segment.unlock();
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        InternalEntry liveEntry;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        Segment<K, V, E, S> segmentFor = segmentFor(hash);
        segmentFor.getClass();
        try {
            if (segmentFor.count != 0 && (liveEntry = segmentFor.getLiveEntry(hash, obj)) != null) {
                if (liveEntry.getValue() != null) {
                    z = true;
                }
            }
            return z;
        } finally {
            segmentFor.postReadCleanup();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Object value;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j = -1;
        int r6 = 0;
        while (r6 < 3) {
            int length = segmentArr.length;
            long j2 = 0;
            for (?? r10 = z; r10 < length; r10++) {
                Segment<K, V, E, S> segment = segmentArr[r10];
                int r12 = segment.count;
                AtomicReferenceArray<E> atomicReferenceArray = segment.table;
                for (?? r13 = z; r13 < atomicReferenceArray.length(); r13++) {
                    for (E e = atomicReferenceArray.get(r13); e != null; e = e.getNext()) {
                        if (e.getKey() == null) {
                            segment.tryDrainReferenceQueues();
                        } else {
                            value = e.getValue();
                            if (value == null) {
                                segment.tryDrainReferenceQueues();
                            }
                            if (value == null && this.entryHelper.valueStrength().defaultEquivalence().equivalent(obj, value)) {
                                return true;
                            }
                        }
                        value = null;
                        if (value == null) {
                        }
                    }
                }
                j2 += segment.modCount;
                z = false;
            }
            if (j2 == j) {
                return false;
            }
            r6++;
            j = j2;
            z = false;
        }
        return z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        V v = null;
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        Segment<K, V, E, S> segmentFor = segmentFor(hash);
        segmentFor.getClass();
        try {
            InternalEntry liveEntry = segmentFor.getLiveEntry(hash, obj);
            if (liveEntry != null && (v = (V) liveEntry.getValue()) == null) {
                segmentFor.tryDrainReferenceQueues();
            }
            return v;
        } finally {
            segmentFor.postReadCleanup();
        }
    }

    public final int hash(Object obj) {
        int doHash;
        Equivalence<Object> equivalence = this.keyEquivalence;
        if (obj == null) {
            equivalence.getClass();
            doHash = 0;
        } else {
            doHash = equivalence.doHash(obj);
        }
        int r3 = doHash + ((doHash << 15) ^ (-12931));
        int r32 = r3 ^ (r3 >>> 10);
        int r33 = r32 + (r32 << 3);
        int r34 = r33 ^ (r33 >>> 6);
        int r0 = (r34 << 2) + (r34 << 14) + r34;
        return (r0 >>> 16) ^ r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j = 0;
        for (int r4 = 0; r4 < segmentArr.length; r4++) {
            if (segmentArr[r4].count != 0) {
                return false;
            }
            j += segmentArr[r4].modCount;
        }
        if (j == 0) {
            return true;
        }
        for (int r42 = 0; r42 < segmentArr.length; r42++) {
            if (segmentArr[r42].count != 0) {
                return false;
            }
            j -= segmentArr[r42].modCount;
        }
        if (j != 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        KeySet keySet = this.keySet;
        if (keySet == null) {
            KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        k.getClass();
        v.getClass();
        int hash = hash(k);
        return (V) segmentFor(hash).put(hash, k, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final V putIfAbsent(K k, V v) {
        k.getClass();
        v.getClass();
        int hash = hash(k);
        return (V) segmentFor(hash).put(hash, k, v, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:            r11 = (V) r7.getValue();     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:            if (r11 == null) goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:            r2.modCount++;        r0 = r2.removeFromChain(r6, r7);        r1 = r2.count - 1;        r3.set(r4, r0);        r2.count = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:            return r11;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:            if (r7.getValue() != null) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:            r1 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:            if (r1 == false) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:            r1 = false;     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V remove(java.lang.Object r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            int r1 = r10.hash(r11)
            com.google.common.collect.MapMakerInternalMap$Segment r2 = r10.segmentFor(r1)
            r2.lock()
            r2.runLockedCleanup()     // Catch: java.lang.Throwable -> L6b
            java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>> r3 = r2.table     // Catch: java.lang.Throwable -> L6b
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L6b
            r5 = 1
            int r4 = r4 - r5
            r4 = r4 & r1
            java.lang.Object r6 = r3.get(r4)     // Catch: java.lang.Throwable -> L6b
            com.google.common.collect.MapMakerInternalMap$InternalEntry r6 = (com.google.common.collect.MapMakerInternalMap.InternalEntry) r6     // Catch: java.lang.Throwable -> L6b
            r7 = r6
        L22:
            if (r7 == 0) goto L67
            java.lang.Object r8 = r7.getKey()     // Catch: java.lang.Throwable -> L6b
            int r9 = r7.getHash()     // Catch: java.lang.Throwable -> L6b
            if (r9 != r1) goto L62
            if (r8 == 0) goto L62
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r9 = r2.map     // Catch: java.lang.Throwable -> L6b
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.keyEquivalence     // Catch: java.lang.Throwable -> L6b
            boolean r8 = r9.equivalent(r11, r8)     // Catch: java.lang.Throwable -> L6b
            if (r8 == 0) goto L62
            java.lang.Object r11 = r7.getValue()     // Catch: java.lang.Throwable -> L6b
            if (r11 == 0) goto L41
            goto L4c
        L41:
            java.lang.Object r1 = r7.getValue()     // Catch: java.lang.Throwable -> L6b
            if (r1 != 0) goto L49
            r1 = r5
            goto L4a
        L49:
            r1 = 0
        L4a:
            if (r1 == 0) goto L67
        L4c:
            int r0 = r2.modCount     // Catch: java.lang.Throwable -> L6b
            int r0 = r0 + r5
            r2.modCount = r0     // Catch: java.lang.Throwable -> L6b
            com.google.common.collect.MapMakerInternalMap$InternalEntry r0 = r2.removeFromChain(r6, r7)     // Catch: java.lang.Throwable -> L6b
            int r1 = r2.count     // Catch: java.lang.Throwable -> L6b
            int r1 = r1 - r5
            r3.set(r4, r0)     // Catch: java.lang.Throwable -> L6b
            r2.count = r1     // Catch: java.lang.Throwable -> L6b
            r2.unlock()
            r0 = r11
            goto L6a
        L62:
            com.google.common.collect.MapMakerInternalMap$InternalEntry r7 = r7.getNext()     // Catch: java.lang.Throwable -> L6b
            goto L22
        L67:
            r2.unlock()
        L6a:
            return r0
        L6b:
            r11 = move-exception
            r2.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.remove(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:            return null;     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V replace(K r11, V r12) {
        /*
            r10 = this;
            r11.getClass()
            r12.getClass()
            int r0 = r10.hash(r11)
            com.google.common.collect.MapMakerInternalMap$Segment r1 = r10.segmentFor(r0)
            r1.lock()
            r1.runLockedCleanup()     // Catch: java.lang.Throwable -> L76
            java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>> r2 = r1.table     // Catch: java.lang.Throwable -> L76
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L76
            r4 = 1
            int r3 = r3 - r4
            r3 = r3 & r0
            java.lang.Object r5 = r2.get(r3)     // Catch: java.lang.Throwable -> L76
            com.google.common.collect.MapMakerInternalMap$InternalEntry r5 = (com.google.common.collect.MapMakerInternalMap.InternalEntry) r5     // Catch: java.lang.Throwable -> L76
            r6 = r5
        L24:
            r7 = 0
            if (r6 == 0) goto L72
            java.lang.Object r8 = r6.getKey()     // Catch: java.lang.Throwable -> L76
            int r9 = r6.getHash()     // Catch: java.lang.Throwable -> L76
            if (r9 != r0) goto L6d
            if (r8 == 0) goto L6d
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r9 = r1.map     // Catch: java.lang.Throwable -> L76
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.keyEquivalence     // Catch: java.lang.Throwable -> L76
            boolean r8 = r9.equivalent(r11, r8)     // Catch: java.lang.Throwable -> L76
            if (r8 == 0) goto L6d
            java.lang.Object r11 = r6.getValue()     // Catch: java.lang.Throwable -> L76
            if (r11 != 0) goto L60
            java.lang.Object r11 = r6.getValue()     // Catch: java.lang.Throwable -> L76
            if (r11 != 0) goto L4b
            r11 = r4
            goto L4c
        L4b:
            r11 = 0
        L4c:
            if (r11 == 0) goto L72
            int r11 = r1.modCount     // Catch: java.lang.Throwable -> L76
            int r11 = r11 + r4
            r1.modCount = r11     // Catch: java.lang.Throwable -> L76
            com.google.common.collect.MapMakerInternalMap$InternalEntry r11 = r1.removeFromChain(r5, r6)     // Catch: java.lang.Throwable -> L76
            int r12 = r1.count     // Catch: java.lang.Throwable -> L76
            int r12 = r12 - r4
            r2.set(r3, r11)     // Catch: java.lang.Throwable -> L76
            r1.count = r12     // Catch: java.lang.Throwable -> L76
            goto L72
        L60:
            int r0 = r1.modCount     // Catch: java.lang.Throwable -> L76
            int r0 = r0 + r4
            r1.modCount = r0     // Catch: java.lang.Throwable -> L76
            r1.setValue(r6, r12)     // Catch: java.lang.Throwable -> L76
            r1.unlock()
            r7 = r11
            goto L75
        L6d:
            com.google.common.collect.MapMakerInternalMap$InternalEntry r6 = r6.getNext()     // Catch: java.lang.Throwable -> L76
            goto L24
        L72:
            r1.unlock()
        L75:
            return r7
        L76:
            r11 = move-exception
            r1.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.replace(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final Segment<K, V, E, S> segmentFor(int r2) {
        return this.segments[(r2 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long j = 0;
        for (int r3 = 0; r3 < this.segments.length; r3++) {
            j += r0[r3].count;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Values values = this.values;
        if (values == null) {
            Values values2 = new Values();
            this.values = values2;
            return values2;
        }
        return values;
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 implements WeakValueReference<Object, Object, DummyInternalEntry> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final WeakValueReference copyFor(ReferenceQueue referenceQueue, WeakValueEntry weakValueEntry) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final /* bridge */ /* synthetic */ DummyInternalEntry getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final void clear() {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        public static final /* synthetic */ int $r8$clinit = 0;
        public volatile int count;
        public final MapMakerInternalMap<K, V, E, S> map;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public volatile AtomicReferenceArray<E> table;
        public int threshold;

        public Segment(MapMakerInternalMap mapMakerInternalMap, int r3) {
            this.map = mapMakerInternalMap;
            AtomicReferenceArray<E> atomicReferenceArray = new AtomicReferenceArray<>(r3);
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == -1) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int r0 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    InternalEntry internalEntry = (InternalEntry) poll;
                    MapMakerInternalMap<K, V, E, S> mapMakerInternalMap = this.map;
                    mapMakerInternalMap.getClass();
                    int hash = internalEntry.getHash();
                    Segment<K, V, E, S> segmentFor = mapMakerInternalMap.segmentFor(hash);
                    segmentFor.lock();
                    try {
                        AtomicReferenceArray<E> atomicReferenceArray = segmentFor.table;
                        int length = hash & (atomicReferenceArray.length() - 1);
                        InternalEntry internalEntry2 = (InternalEntry) atomicReferenceArray.get(length);
                        InternalEntry internalEntry3 = internalEntry2;
                        while (true) {
                            if (internalEntry3 == null) {
                                break;
                            }
                            if (internalEntry3 == internalEntry) {
                                segmentFor.modCount++;
                                InternalEntry removeFromChain = segmentFor.removeFromChain(internalEntry2, internalEntry3);
                                int r5 = segmentFor.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                segmentFor.count = r5;
                                break;
                            }
                            internalEntry3 = internalEntry3.getNext();
                        }
                        segmentFor.unlock();
                        r0++;
                    } catch (Throwable th) {
                        segmentFor.unlock();
                        throw th;
                    }
                } else {
                    return;
                }
            } while (r0 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int r0 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    WeakValueReference<K, V, E> weakValueReference = (WeakValueReference) poll;
                    MapMakerInternalMap<K, V, E, S> mapMakerInternalMap = this.map;
                    mapMakerInternalMap.getClass();
                    E entry = weakValueReference.getEntry();
                    int hash = entry.getHash();
                    Segment<K, V, E, S> segmentFor = mapMakerInternalMap.segmentFor(hash);
                    Object key = entry.getKey();
                    segmentFor.lock();
                    try {
                        AtomicReferenceArray<E> atomicReferenceArray = segmentFor.table;
                        int length = (atomicReferenceArray.length() - 1) & hash;
                        InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                        InternalEntry internalEntry2 = internalEntry;
                        while (true) {
                            if (internalEntry2 == null) {
                                break;
                            }
                            Object key2 = internalEntry2.getKey();
                            if (internalEntry2.getHash() == hash && key2 != null && segmentFor.map.keyEquivalence.equivalent(key, key2)) {
                                if (((WeakValueEntry) internalEntry2).getValueReference() == weakValueReference) {
                                    segmentFor.modCount++;
                                    InternalEntry removeFromChain = segmentFor.removeFromChain(internalEntry, internalEntry2);
                                    int r3 = segmentFor.count - 1;
                                    atomicReferenceArray.set(length, removeFromChain);
                                    segmentFor.count = r3;
                                }
                            } else {
                                internalEntry2 = internalEntry2.getNext();
                            }
                        }
                        segmentFor.unlock();
                        r0++;
                    } catch (Throwable th) {
                        segmentFor.unlock();
                        throw th;
                    }
                } else {
                    return;
                }
            } while (r0 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int r2 = this.count;
            SpscArrayQueue spscArrayQueue = (AtomicReferenceArray<E>) new AtomicReferenceArray(length << 1);
            this.threshold = (spscArrayQueue.length() * 3) / 4;
            int length2 = spscArrayQueue.length() - 1;
            for (int r5 = 0; r5 < length; r5++) {
                E e = atomicReferenceArray.get(r5);
                if (e != null) {
                    InternalEntry next = e.getNext();
                    int hash = e.getHash() & length2;
                    if (next == null) {
                        spscArrayQueue.set(hash, e);
                    } else {
                        InternalEntry internalEntry = e;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                internalEntry = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        spscArrayQueue.set(hash, internalEntry);
                        while (e != internalEntry) {
                            int hash3 = e.getHash() & length2;
                            InternalEntry copy = this.map.entryHelper.copy(self(), e, (InternalEntry) spscArrayQueue.get(hash3));
                            if (copy != null) {
                                spscArrayQueue.set(hash3, copy);
                            } else {
                                r2--;
                            }
                            e = e.getNext();
                        }
                    }
                }
            }
            this.table = spscArrayQueue;
            this.count = r2;
        }

        public final InternalEntry getLiveEntry(int r4, Object obj) {
            if (this.count != 0) {
                for (E e = this.table.get((r0.length() - 1) & r4); e != null; e = e.getNext()) {
                    if (e.getHash() == r4) {
                        Object key = e.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return e;
                        }
                    }
                }
            }
            return null;
        }

        public final void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runLockedCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object put(int r9, Object obj, Object obj2, boolean z) {
            lock();
            try {
                runLockedCleanup();
                int r0 = this.count + 1;
                if (r0 > this.threshold) {
                    expand();
                    r0 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & r9;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == r9 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        Object value = internalEntry2.getValue();
                        if (value == null) {
                            this.modCount++;
                            setValue(internalEntry2, obj2);
                            this.count = this.count;
                            return null;
                        }
                        if (z) {
                            return value;
                        }
                        this.modCount++;
                        setValue(internalEntry2, obj2);
                        return value;
                    }
                }
                this.modCount++;
                InternalEntry newEntry = this.map.entryHelper.newEntry(self(), obj, r9, internalEntry);
                setValue(newEntry, obj2);
                atomicReferenceArray.set(length, newEntry);
                this.count = r0;
                return null;
            } finally {
                unlock();
            }
        }

        public final E removeFromChain(E e, E e2) {
            int r0 = this.count;
            E e3 = (E) e2.getNext();
            while (e != e2) {
                Object copy = this.map.entryHelper.copy(self(), e, e3);
                if (copy != null) {
                    e3 = (E) copy;
                } else {
                    r0--;
                }
                e = (E) e.getNext();
            }
            this.count = r0;
            return e3;
        }

        public final void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public final void setValue(E e, V v) {
            this.map.entryHelper.setValue(self(), e, v);
        }

        public final void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void maybeClearReferenceQueues() {
        }

        public void maybeDrainReferenceQueues() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment self() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        public final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap mapMakerInternalMap, int r2) {
            super(mapMakerInternalMap, r2);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void maybeClearReferenceQueues() {
            do {
            } while (this.queueForValues.poll() != null);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment self() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        public final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap mapMakerInternalMap, int r2) {
            super(mapMakerInternalMap, r2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void maybeClearReferenceQueues() {
            do {
            } while (this.queueForKeys.poll() != null);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment self() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        public final ReferenceQueue<K> queueForKeys;
        public final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap mapMakerInternalMap, int r2) {
            super(mapMakerInternalMap, r2);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void maybeClearReferenceQueues() {
            do {
            } while (this.queueForKeys.poll() != null);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment self() {
            return this;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:            if (r2.map.entryHelper.valueStrength().defaultEquivalence().equivalent(r12, r7.getValue()) == false) goto L17;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:            r0 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:            r2.modCount++;        r11 = r2.removeFromChain(r6, r7);        r12 = r2.count - 1;        r3.set(r4, r11);        r2.count = r12;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:            if (r7.getValue() != null) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:            r11 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:            if (r11 == false) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:            r11 = false;     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(java.lang.Object r11, java.lang.Object r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L80
            if (r12 != 0) goto L7
            goto L80
        L7:
            int r1 = r10.hash(r11)
            com.google.common.collect.MapMakerInternalMap$Segment r2 = r10.segmentFor(r1)
            r2.lock()
            r2.runLockedCleanup()     // Catch: java.lang.Throwable -> L7b
            java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>> r3 = r2.table     // Catch: java.lang.Throwable -> L7b
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L7b
            r5 = 1
            int r4 = r4 - r5
            r4 = r4 & r1
            java.lang.Object r6 = r3.get(r4)     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$InternalEntry r6 = (com.google.common.collect.MapMakerInternalMap.InternalEntry) r6     // Catch: java.lang.Throwable -> L7b
            r7 = r6
        L25:
            if (r7 == 0) goto L77
            java.lang.Object r8 = r7.getKey()     // Catch: java.lang.Throwable -> L7b
            int r9 = r7.getHash()     // Catch: java.lang.Throwable -> L7b
            if (r9 != r1) goto L72
            if (r8 == 0) goto L72
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r9 = r2.map     // Catch: java.lang.Throwable -> L7b
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.keyEquivalence     // Catch: java.lang.Throwable -> L7b
            boolean r8 = r9.equivalent(r11, r8)     // Catch: java.lang.Throwable -> L7b
            if (r8 == 0) goto L72
            java.lang.Object r11 = r7.getValue()     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r1 = r2.map     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$InternalEntryHelper<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r1 = r1.entryHelper     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$Strength r1 = r1.valueStrength()     // Catch: java.lang.Throwable -> L7b
            com.google.common.base.Equivalence r1 = r1.defaultEquivalence()     // Catch: java.lang.Throwable -> L7b
            boolean r11 = r1.equivalent(r12, r11)     // Catch: java.lang.Throwable -> L7b
            if (r11 == 0) goto L55
            r0 = r5
            goto L60
        L55:
            java.lang.Object r11 = r7.getValue()     // Catch: java.lang.Throwable -> L7b
            if (r11 != 0) goto L5d
            r11 = r5
            goto L5e
        L5d:
            r11 = r0
        L5e:
            if (r11 == 0) goto L77
        L60:
            int r11 = r2.modCount     // Catch: java.lang.Throwable -> L7b
            int r11 = r11 + r5
            r2.modCount = r11     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$InternalEntry r11 = r2.removeFromChain(r6, r7)     // Catch: java.lang.Throwable -> L7b
            int r12 = r2.count     // Catch: java.lang.Throwable -> L7b
            int r12 = r12 - r5
            r3.set(r4, r11)     // Catch: java.lang.Throwable -> L7b
            r2.count = r12     // Catch: java.lang.Throwable -> L7b
            goto L77
        L72:
            com.google.common.collect.MapMakerInternalMap$InternalEntry r7 = r7.getNext()     // Catch: java.lang.Throwable -> L7b
            goto L25
        L77:
            r2.unlock()
            return r0
        L7b:
            r11 = move-exception
            r2.unlock()
            throw r11
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.remove(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(K k, V v, V v2) {
        k.getClass();
        v2.getClass();
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        Segment<K, V, E, S> segmentFor = segmentFor(hash);
        segmentFor.lock();
        try {
            segmentFor.runLockedCleanup();
            AtomicReferenceArray<E> atomicReferenceArray = segmentFor.table;
            int length = (atomicReferenceArray.length() - 1) & hash;
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            InternalEntry internalEntry2 = internalEntry;
            while (true) {
                if (internalEntry2 == null) {
                    break;
                }
                Object key = internalEntry2.getKey();
                if (internalEntry2.getHash() == hash && key != null && segmentFor.map.keyEquivalence.equivalent(k, key)) {
                    Object value = internalEntry2.getValue();
                    if (value == null) {
                        if (internalEntry2.getValue() == null) {
                            segmentFor.modCount++;
                            InternalEntry removeFromChain = segmentFor.removeFromChain(internalEntry, internalEntry2);
                            int r12 = segmentFor.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            segmentFor.count = r12;
                        }
                    } else if (segmentFor.map.entryHelper.valueStrength().defaultEquivalence().equivalent(v, value)) {
                        segmentFor.modCount++;
                        segmentFor.setValue(internalEntry2, v2);
                        return true;
                    }
                } else {
                    internalEntry2 = internalEntry2.getNext();
                }
            }
            return false;
        } finally {
            segmentFor.unlock();
        }
    }
}
