package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LazyField extends LazyFieldLite {

    /* loaded from: classes3.dex */
    public static class LazyEntry<K> implements Map.Entry<K, Object> {
        public final Map.Entry<K, LazyField> entry;

        public LazyEntry() {
            throw null;
        }

        public LazyEntry(Map.Entry entry) {
            this.entry = entry;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            LazyField value = this.entry.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue(null);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                LazyField value = this.entry.getValue();
                MessageLite messageLite = value.value;
                value.memoizedBytes = null;
                value.value = (MessageLite) obj;
                return messageLite;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* loaded from: classes3.dex */
    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        public final Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Map.Entry<K, Object> next = this.iterator.next();
            if (next.getValue() instanceof LazyField) {
                return new LazyEntry(next);
            }
            return next;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.iterator.remove();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyFieldLite
    public final boolean equals(Object obj) {
        return getValue(null).equals(obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyFieldLite
    public final int hashCode() {
        return getValue(null).hashCode();
    }

    public final String toString() {
        return getValue(null).toString();
    }
}
