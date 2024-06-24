package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;

/* compiled from: MapBuilder.kt */
/* loaded from: classes.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public static final MapBuilder Empty;
    public MapBuilderEntries<K, V> entriesView;
    public int[] hashArray;
    public int hashShift;
    public boolean isReadOnly;
    public K[] keysArray;
    public MapBuilderKeys<K> keysView;
    public int length;
    public int maxProbeDistance;
    public int modCount;
    public int[] presenceArray;
    public int size;
    public V[] valuesArray;
    public MapBuilderValues<V> valuesView;

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes.dex */
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public final Object next() {
            checkForComodification$kotlin_stdlib();
            int r0 = this.index;
            MapBuilder<K, V> mapBuilder = this.map;
            if (r0 < mapBuilder.length) {
                this.index = r0 + 1;
                this.lastIndex = r0;
                EntryRef entryRef = new EntryRef(mapBuilder, r0);
                initNext$kotlin_stdlib();
                return entryRef;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes.dex */
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final int index;
        public final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> map, int r3) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.index = r3;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.map.keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            V[] vArr = this.map.valuesArray;
            Intrinsics.checkNotNull(vArr);
            return vArr[this.index];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int r0;
            K key = getKey();
            int r1 = 0;
            if (key != null) {
                r0 = key.hashCode();
            } else {
                r0 = 0;
            }
            V value = getValue();
            if (value != null) {
                r1 = value.hashCode();
            }
            return r0 ^ r1;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            MapBuilder<K, V> mapBuilder = this.map;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            V[] vArr = mapBuilder.valuesArray;
            if (vArr == null) {
                vArr = (V[]) ListBuilderKt.arrayOfUninitializedElements(mapBuilder.keysArray.length);
                mapBuilder.valuesArray = vArr;
            }
            int r0 = this.index;
            V v2 = vArr[r0];
            vArr[r0] = v;
            return v2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes.dex */
    public static class Itr<K, V> {
        public int expectedModCount;
        public int index;
        public int lastIndex;
        public final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.lastIndex = -1;
            this.expectedModCount = map.modCount;
            initNext$kotlin_stdlib();
        }

        public final void checkForComodification$kotlin_stdlib() {
            if (this.map.modCount == this.expectedModCount) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            if (this.index < this.map.length) {
                return true;
            }
            return false;
        }

        public final void initNext$kotlin_stdlib() {
            while (true) {
                int r0 = this.index;
                MapBuilder<K, V> mapBuilder = this.map;
                if (r0 < mapBuilder.length && mapBuilder.presenceArray[r0] < 0) {
                    this.index = r0 + 1;
                } else {
                    return;
                }
            }
        }

        public final void remove() {
            boolean z;
            checkForComodification$kotlin_stdlib();
            if (this.lastIndex != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                MapBuilder<K, V> mapBuilder = this.map;
                mapBuilder.checkIsMutable$kotlin_stdlib();
                mapBuilder.removeKeyAt(this.lastIndex);
                this.lastIndex = -1;
                this.expectedModCount = mapBuilder.modCount;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes.dex */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMappedMarker {
        @Override // java.util.Iterator
        public final K next() {
            checkForComodification$kotlin_stdlib();
            int r0 = this.index;
            MapBuilder<K, V> mapBuilder = this.map;
            if (r0 < mapBuilder.length) {
                this.index = r0 + 1;
                this.lastIndex = r0;
                K k = mapBuilder.keysArray[r0];
                initNext$kotlin_stdlib();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes.dex */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMappedMarker {
        @Override // java.util.Iterator
        public final V next() {
            checkForComodification$kotlin_stdlib();
            int r0 = this.index;
            MapBuilder<K, V> mapBuilder = this.map;
            if (r0 < mapBuilder.length) {
                this.index = r0 + 1;
                this.lastIndex = r0;
                V[] vArr = mapBuilder.valuesArray;
                Intrinsics.checkNotNull(vArr);
                V v = vArr[this.lastIndex];
                initNext$kotlin_stdlib();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        new Companion();
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k);
            int r1 = this.maxProbeDistance * 2;
            int length = this.hashArray.length / 2;
            if (r1 > length) {
                r1 = length;
            }
            int r2 = 0;
            while (true) {
                int[] r3 = this.hashArray;
                int r4 = r3[hash];
                if (r4 <= 0) {
                    int r12 = this.length;
                    K[] kArr = this.keysArray;
                    if (r12 >= kArr.length) {
                        ensureExtraCapacity(1);
                    } else {
                        int r6 = r12 + 1;
                        this.length = r6;
                        kArr[r12] = k;
                        this.presenceArray[r12] = hash;
                        r3[hash] = r6;
                        this.size++;
                        this.modCount++;
                        if (r2 > this.maxProbeDistance) {
                            this.maxProbeDistance = r2;
                        }
                        return r12;
                    }
                } else {
                    if (Intrinsics.areEqual(this.keysArray[r4 - 1], k)) {
                        return -r4;
                    }
                    r2++;
                    if (r2 > r1) {
                        rehash(this.hashArray.length * 2);
                        break;
                    }
                    int r32 = hash - 1;
                    if (hash == 0) {
                        hash = this.hashArray.length - 1;
                    } else {
                        hash = r32;
                    }
                }
            }
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (!this.isReadOnly) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.ranges.IntProgressionIterator] */
    @Override // java.util.Map
    public final void clear() {
        checkIsMutable$kotlin_stdlib();
        ?? it = new IntRange(0, this.length - 1).iterator();
        while (it.hasNext) {
            int nextInt = it.nextInt();
            int[] r4 = this.presenceArray;
            int r5 = r4[nextInt];
            if (r5 >= 0) {
                this.hashArray[r5] = 0;
                r4[nextInt] = -1;
            }
        }
        ListBuilderKt.resetRange(0, this.length, this.keysArray);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetRange(0, this.length, vArr);
        }
        this.size = 0;
        this.length = 0;
        this.modCount++;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m) {
        Intrinsics.checkNotNullParameter(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual(vArr[findKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (findKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        int r1;
        int r0 = this.length;
        while (true) {
            r1 = -1;
            r0--;
            if (r0 < 0) {
                break;
            }
            if (this.presenceArray[r0] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual(vArr[r0], obj)) {
                    r1 = r0;
                    break;
                }
            }
        }
        if (r1 >= 0) {
            return true;
        }
        return false;
    }

    public final void ensureExtraCapacity(int r6) {
        boolean z;
        V[] vArr;
        K[] kArr = this.keysArray;
        int length = kArr.length;
        int r2 = this.length;
        int r1 = length - r2;
        int r3 = r2 - this.size;
        int r4 = 1;
        if (r1 < r6 && r1 + r3 >= r6 && r3 >= kArr.length / 4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            rehash(this.hashArray.length);
            return;
        }
        int r22 = r2 + r6;
        if (r22 >= 0) {
            if (r22 > kArr.length) {
                int length2 = kArr.length;
                int r62 = length2 + (length2 >> 1);
                if (r62 - r22 < 0) {
                    r62 = r22;
                }
                if (r62 - 2147483639 > 0) {
                    if (r22 > 2147483639) {
                        r62 = Integer.MAX_VALUE;
                    } else {
                        r62 = 2147483639;
                    }
                }
                K[] kArr2 = (K[]) Arrays.copyOf(kArr, r62);
                Intrinsics.checkNotNullExpressionValue(kArr2, "copyOf(...)");
                this.keysArray = kArr2;
                V[] vArr2 = this.valuesArray;
                if (vArr2 != null) {
                    vArr = (V[]) Arrays.copyOf(vArr2, r62);
                    Intrinsics.checkNotNullExpressionValue(vArr, "copyOf(...)");
                } else {
                    vArr = null;
                }
                this.valuesArray = vArr;
                int[] copyOf = Arrays.copyOf(this.presenceArray, r62);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.presenceArray = copyOf;
                if (r62 >= 1) {
                    r4 = r62;
                }
                int highestOneBit = Integer.highestOneBit(r4 * 3);
                if (highestOneBit > this.hashArray.length) {
                    rehash(highestOneBit);
                    return;
                }
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries == null) {
            MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
            this.entriesView = mapBuilderEntries2;
            return mapBuilderEntries2;
        }
        return mapBuilderEntries;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.size == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final int findKey(K k) {
        int hash = hash(k);
        int r1 = this.maxProbeDistance;
        while (true) {
            int r2 = this.hashArray[hash];
            if (r2 == 0) {
                return -1;
            }
            if (r2 > 0) {
                int r22 = r2 - 1;
                if (Intrinsics.areEqual(this.keysArray[r22], k)) {
                    return r22;
                }
            }
            r1--;
            if (r1 < 0) {
                return -1;
            }
            int r23 = hash - 1;
            if (hash == 0) {
                hash = this.hashArray.length - 1;
            } else {
                hash = r23;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return vArr[findKey];
    }

    public final int hash(K k) {
        int r2;
        if (k != null) {
            r2 = k.hashCode();
        } else {
            r2 = 0;
        }
        return (r2 * (-1640531527)) >>> this.hashShift;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int r3;
        int r4;
        EntriesItr entriesItr = new EntriesItr(this);
        int r2 = 0;
        while (entriesItr.hasNext()) {
            int r32 = entriesItr.index;
            MapBuilder<K, V> mapBuilder = entriesItr.map;
            if (r32 < mapBuilder.length) {
                entriesItr.index = r32 + 1;
                entriesItr.lastIndex = r32;
                K k = mapBuilder.keysArray[r32];
                if (k != null) {
                    r3 = k.hashCode();
                } else {
                    r3 = 0;
                }
                V[] vArr = mapBuilder.valuesArray;
                Intrinsics.checkNotNull(vArr);
                V v = vArr[entriesItr.lastIndex];
                if (v != null) {
                    r4 = v.hashCode();
                } else {
                    r4 = 0;
                }
                entriesItr.initNext$kotlin_stdlib();
                r2 += r3 ^ r4;
            } else {
                throw new NoSuchElementException();
            }
        }
        return r2;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys == null) {
            MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
            this.keysView = mapBuilderKeys2;
            return mapBuilderKeys2;
        }
        return mapBuilderKeys;
    }

    @Override // java.util.Map
    public final V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] vArr = this.valuesArray;
        if (vArr == null) {
            vArr = (V[]) ListBuilderKt.arrayOfUninitializedElements(this.keysArray.length);
            this.valuesArray = vArr;
        }
        if (addKey$kotlin_stdlib < 0) {
            int r3 = (-addKey$kotlin_stdlib) - 1;
            V v2 = vArr[r3];
            vArr[r3] = v;
            return v2;
        }
        vArr[addKey$kotlin_stdlib] = v;
        return null;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> entrySet = from.entrySet();
        if (!entrySet.isEmpty()) {
            ensureExtraCapacity(entrySet.size());
            for (Map.Entry<? extends K, ? extends V> entry : entrySet) {
                int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
                V[] vArr = this.valuesArray;
                if (vArr == null) {
                    vArr = (V[]) ListBuilderKt.arrayOfUninitializedElements(this.keysArray.length);
                    this.valuesArray = vArr;
                }
                if (addKey$kotlin_stdlib >= 0) {
                    vArr[addKey$kotlin_stdlib] = entry.getValue();
                } else {
                    int r1 = (-addKey$kotlin_stdlib) - 1;
                    if (!Intrinsics.areEqual(entry.getValue(), vArr[r1])) {
                        vArr[r1] = entry.getValue();
                    }
                }
            }
        }
    }

    public final void rehash(int r8) {
        boolean z;
        int r5;
        this.modCount++;
        if (this.length > this.size) {
            V[] vArr = this.valuesArray;
            int r2 = 0;
            int r4 = 0;
            while (true) {
                r5 = this.length;
                if (r2 >= r5) {
                    break;
                }
                if (this.presenceArray[r2] >= 0) {
                    K[] kArr = this.keysArray;
                    kArr[r4] = kArr[r2];
                    if (vArr != null) {
                        vArr[r4] = vArr[r2];
                    }
                    r4++;
                }
                r2++;
            }
            ListBuilderKt.resetRange(r4, r5, this.keysArray);
            if (vArr != null) {
                ListBuilderKt.resetRange(r4, this.length, vArr);
            }
            this.length = r4;
        }
        int[] r0 = this.hashArray;
        if (r8 != r0.length) {
            this.hashArray = new int[r8];
            this.hashShift = Integer.numberOfLeadingZeros(r8) + 1;
        } else {
            Arrays.fill(r0, 0, r0.length, 0);
        }
        int r82 = 0;
        while (r82 < this.length) {
            int r02 = r82 + 1;
            int hash = hash(this.keysArray[r82]);
            int r42 = this.maxProbeDistance;
            while (true) {
                int[] r52 = this.hashArray;
                if (r52[hash] == 0) {
                    r52[hash] = r02;
                    this.presenceArray[r82] = hash;
                    z = true;
                    break;
                }
                r42--;
                if (r42 < 0) {
                    z = false;
                    break;
                }
                int r6 = hash - 1;
                if (hash == 0) {
                    hash = r52.length - 1;
                } else {
                    hash = r6;
                }
            }
            if (z) {
                r82 = r02;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(obj);
        if (findKey < 0) {
            findKey = -1;
        } else {
            removeKeyAt(findKey);
        }
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        V v = vArr[findKey];
        vArr[findKey] = null;
        return v;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:0: B:5:0x001e->B:22:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeKeyAt(int r12) {
        /*
            r11 = this;
            K[] r0 = r11.keysArray
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = 0
            r0[r12] = r1
            int[] r0 = r11.presenceArray
            r0 = r0[r12]
            int r1 = r11.maxProbeDistance
            int r1 = r1 * 2
            int[] r2 = r11.hashArray
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1a
            r1 = r2
        L1a:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L1e:
            int r5 = r0 + (-1)
            r6 = -1
            if (r0 != 0) goto L28
            int[] r0 = r11.hashArray
            int r0 = r0.length
            int r0 = r0 + r6
            goto L29
        L28:
            r0 = r5
        L29:
            int r4 = r4 + 1
            int r5 = r11.maxProbeDistance
            if (r4 <= r5) goto L34
            int[] r0 = r11.hashArray
            r0[r1] = r2
            goto L63
        L34:
            int[] r5 = r11.hashArray
            r7 = r5[r0]
            if (r7 != 0) goto L3d
            r5[r1] = r2
            goto L63
        L3d:
            if (r7 >= 0) goto L42
            r5[r1] = r6
            goto L5a
        L42:
            K[] r5 = r11.keysArray
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.hash(r5)
            int r5 = r5 - r0
            int[] r9 = r11.hashArray
            int r10 = r9.length
            int r10 = r10 + r6
            r5 = r5 & r10
            if (r5 < r4) goto L5c
            r9[r1] = r7
            int[] r4 = r11.presenceArray
            r4[r8] = r1
        L5a:
            r1 = r0
            r4 = r2
        L5c:
            int r3 = r3 + r6
            if (r3 >= 0) goto L1e
            int[] r0 = r11.hashArray
            r0[r1] = r6
        L63:
            int[] r0 = r11.presenceArray
            r0[r12] = r6
            int r12 = r11.size
            int r12 = r12 + r6
            r11.size = r12
            int r12 = r11.modCount
            int r12 = r12 + 1
            r11.modCount = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.removeKeyAt(int):void");
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.size * 3) + 2);
        sb.append("{");
        EntriesItr entriesItr = new EntriesItr(this);
        int r2 = 0;
        while (entriesItr.hasNext()) {
            if (r2 > 0) {
                sb.append(", ");
            }
            int r3 = entriesItr.index;
            MapBuilder<K, V> mapBuilder = entriesItr.map;
            if (r3 < mapBuilder.length) {
                entriesItr.index = r3 + 1;
                entriesItr.lastIndex = r3;
                K k = mapBuilder.keysArray[r3];
                if (k == mapBuilder) {
                    sb.append("(this Map)");
                } else {
                    sb.append(k);
                }
                sb.append('=');
                V[] vArr = mapBuilder.valuesArray;
                Intrinsics.checkNotNull(vArr);
                V v = vArr[entriesItr.lastIndex];
                if (v == mapBuilder) {
                    sb.append("(this Map)");
                } else {
                    sb.append(v);
                }
                entriesItr.initNext$kotlin_stdlib();
                r2++;
            } else {
                throw new NoSuchElementException();
            }
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues == null) {
            MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
            this.valuesView = mapBuilderValues2;
            return mapBuilderValues2;
        }
        return mapBuilderValues;
    }

    public MapBuilder(int r5) {
        K[] kArr = (K[]) ListBuilderKt.arrayOfUninitializedElements(r5);
        int[] r1 = new int[r5];
        int highestOneBit = Integer.highestOneBit((r5 < 1 ? 1 : r5) * 3);
        this.keysArray = kArr;
        this.valuesArray = null;
        this.presenceArray = r1;
        this.hashArray = new int[highestOneBit];
        this.maxProbeDistance = 2;
        this.length = 0;
        this.hashShift = Integer.numberOfLeadingZeros(highestOneBit) + 1;
    }
}
