package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    public Entry<K, V> mEnd;
    public final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap<>();
    public int mSize = 0;
    public Entry<K, V> mStart;

    /* loaded from: classes.dex */
    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mNext;
        }
    }

    /* loaded from: classes.dex */
    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mPrevious;
        }
    }

    /* loaded from: classes.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        public final K mKey;
        public Entry<K, V> mNext;
        public Entry<K, V> mPrevious;
        public final V mValue;

        public Entry(K k, V v) {
            this.mKey = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.mKey.equals(entry.mKey) && this.mValue.equals(entry.mValue)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    /* loaded from: classes.dex */
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        public boolean mBeforeStart = true;
        public Entry<K, V> mCurrent;

        public IteratorWithAdditions() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mBeforeStart) {
                if (SafeIterableMap.this.mStart != null) {
                    return true;
                }
                return false;
            }
            Entry<K, V> entry = this.mCurrent;
            if (entry != null && entry.mNext != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Entry<K, V> entry;
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.mStart;
            } else {
                Entry<K, V> entry2 = this.mCurrent;
                if (entry2 != null) {
                    entry = entry2.mNext;
                } else {
                    entry = null;
                }
                this.mCurrent = entry;
            }
            return this.mCurrent;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void supportRemove(Entry<K, V> entry) {
            boolean z;
            Entry<K, V> entry2 = this.mCurrent;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                if (entry3 == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.mBeforeStart = z;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        public Entry<K, V> mExpectedEnd;
        public Entry<K, V> mNext;

        public ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        public abstract Entry<K, V> backward(Entry<K, V> entry);

        public abstract Entry<K, V> forward(Entry<K, V> entry);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mNext != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Entry<K, V> entry;
            Entry<K, V> entry2 = this.mNext;
            Entry<K, V> entry3 = this.mExpectedEnd;
            if (entry2 != entry3 && entry3 != null) {
                entry = forward(entry2);
            } else {
                entry = null;
            }
            this.mNext = entry;
            return entry2;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void supportRemove(Entry<K, V> entry) {
            Entry<K, V> entry2 = null;
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            Entry<K, V> entry3 = this.mExpectedEnd;
            if (entry3 == entry) {
                this.mExpectedEnd = backward(entry3);
            }
            Entry<K, V> entry4 = this.mNext;
            if (entry4 == entry) {
                Entry<K, V> entry5 = this.mExpectedEnd;
                if (entry4 != entry5 && entry5 != null) {
                    entry2 = forward(entry4);
                }
                this.mNext = entry2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SupportRemove<K, V> {
        public abstract void supportRemove(Entry<K, V> entry);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:            if (r3.hasNext() != false) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:            if (((androidx.arch.core.internal.SafeIterableMap.ListIterator) r7).hasNext() != false) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:            return true;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0054, code lost:            return false;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof androidx.arch.core.internal.SafeIterableMap
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            androidx.arch.core.internal.SafeIterableMap r7 = (androidx.arch.core.internal.SafeIterableMap) r7
            int r1 = r6.mSize
            int r3 = r7.mSize
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            androidx.arch.core.internal.SafeIterableMap$ListIterator r3 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            androidx.arch.core.internal.SafeIterableMap$ListIterator r4 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            androidx.arch.core.internal.SafeIterableMap$ListIterator r7 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = r2
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.arch.core.internal.SafeIterableMap.equals(java.lang.Object):boolean");
    }

    public Entry<K, V> get(K k) {
        Entry<K, V> entry = this.mStart;
        while (entry != null && !entry.mKey.equals(k)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public final int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int r1 = 0;
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (listIterator.hasNext()) {
                r1 += ((Map.Entry) listIterator.next()).hashCode();
            } else {
                return r1;
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public V putIfAbsent(K k, V v) {
        Entry<K, V> entry = get(k);
        if (entry != null) {
            return entry.mValue;
        }
        Entry<K, V> entry2 = new Entry<>(k, v);
        this.mSize++;
        Entry<K, V> entry3 = this.mEnd;
        if (entry3 == null) {
            this.mStart = entry2;
            this.mEnd = entry2;
            return null;
        }
        entry3.mNext = entry2;
        entry2.mPrevious = entry3;
        this.mEnd = entry2;
        return null;
    }

    public V remove(K k) {
        Entry<K, V> entry = get(k);
        if (entry == null) {
            return null;
        }
        this.mSize--;
        WeakHashMap<SupportRemove<K, V>, Boolean> weakHashMap = this.mIterators;
        if (!weakHashMap.isEmpty()) {
            Iterator<SupportRemove<K, V>> it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().supportRemove(entry);
            }
        }
        Entry<K, V> entry2 = entry.mPrevious;
        if (entry2 != null) {
            entry2.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        Entry<K, V> entry3 = entry.mNext;
        if (entry3 != null) {
            entry3.mPrevious = entry2;
        } else {
            this.mEnd = entry2;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (listIterator.hasNext()) {
                sb.append(((Map.Entry) listIterator.next()).toString());
                if (listIterator.hasNext()) {
                    sb.append(", ");
                }
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
