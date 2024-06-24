package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: PersistentHashMapBuilderContentIterators.kt */
/* loaded from: classes.dex */
public final class MutableMapEntry<K, V> extends MapEntry<K, V> implements KMutableMap.Entry {
    public final PersistentHashMapBuilderEntriesIterator<K, V> parentIterator;
    public V value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(PersistentHashMapBuilderEntriesIterator<K, V> parentIterator, K k, V v) {
        super(k, v);
        Intrinsics.checkNotNullParameter(parentIterator, "parentIterator");
        this.parentIterator = parentIterator;
        this.value = v;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public final V setValue(V v) {
        int r3;
        V v2 = this.value;
        this.value = v;
        PersistentHashMapBuilderBaseIterator<K, V, Map.Entry<K, V>> persistentHashMapBuilderBaseIterator = this.parentIterator.base;
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder = persistentHashMapBuilderBaseIterator.builder;
        K k = this.key;
        if (persistentHashMapBuilder.containsKey(k)) {
            boolean z = persistentHashMapBuilderBaseIterator.hasNext;
            if (z) {
                if (z) {
                    TrieNodeBaseIterator trieNodeBaseIterator = persistentHashMapBuilderBaseIterator.path[persistentHashMapBuilderBaseIterator.pathLastIndex];
                    Object obj = trieNodeBaseIterator.buffer[trieNodeBaseIterator.index];
                    persistentHashMapBuilder.put(k, v);
                    if (obj != null) {
                        r3 = obj.hashCode();
                    } else {
                        r3 = 0;
                    }
                    persistentHashMapBuilderBaseIterator.resetPath(r3, persistentHashMapBuilder.node, obj, 0);
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                persistentHashMapBuilder.put(k, v);
            }
            persistentHashMapBuilderBaseIterator.expectedModCount = persistentHashMapBuilder.modCount;
        }
        return v2;
    }
}
