package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {
    public final K key;
    public final V value;

    public MapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        if (obj instanceof Map.Entry) {
            entry = (Map.Entry) obj;
        } else {
            entry = null;
        }
        if (entry == null || !Intrinsics.areEqual(entry.getKey(), this.key) || !Intrinsics.areEqual(entry.getValue(), getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int r1;
        int r0 = 0;
        K k = this.key;
        if (k != null) {
            r1 = k.hashCode();
        } else {
            r1 = 0;
        }
        V value = getValue();
        if (value != null) {
            r0 = value.hashCode();
        }
        return r0 ^ r1;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
