package kotlin.collections;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilderEntries;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilderKeys;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilderValues;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: AbstractMutableMap.kt */
/* loaded from: classes.dex */
public abstract class AbstractMutableMap<K, V> extends java.util.AbstractMap<K, V> implements Map<K, V>, KMutableMap {
    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new PersistentHashMapBuilderEntries((PersistentHashMapBuilder) this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        return new PersistentHashMapBuilderKeys((PersistentHashMapBuilder) this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return ((PersistentHashMapBuilder) this).size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        return new PersistentHashMapBuilderValues((PersistentHashMapBuilder) this);
    }
}
