package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMapContentViews.kt */
/* loaded from: classes.dex */
public final class PersistentHashMapEntries<K, V> extends AbstractSet<Map.Entry<? extends K, ? extends V>> implements ImmutableSet<Map.Entry<? extends K, ? extends V>> {
    public final PersistentHashMap<K, V> map;

    public PersistentHashMapEntries(PersistentHashMap<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        Object key = element.getKey();
        PersistentHashMap<K, V> persistentHashMap = this.map;
        Object obj2 = persistentHashMap.get(key);
        if (obj2 != null) {
            return Intrinsics.areEqual(obj2, element.getValue());
        }
        if (element.getValue() != null || !persistentHashMap.containsKey(element.getKey())) {
            return false;
        }
        return true;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        PersistentHashMap<K, V> persistentHashMap = this.map;
        persistentHashMap.getClass();
        return persistentHashMap.size;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new PersistentHashMapEntriesIterator(this.map.node);
    }
}
