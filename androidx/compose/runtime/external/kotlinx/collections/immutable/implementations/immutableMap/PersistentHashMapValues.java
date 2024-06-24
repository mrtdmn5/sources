package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMapContentViews.kt */
/* loaded from: classes.dex */
public final class PersistentHashMapValues<K, V> extends AbstractCollection<V> {
    public final PersistentHashMap<K, V> map;

    public PersistentHashMapValues(PersistentHashMap<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        PersistentHashMap<K, V> persistentHashMap = this.map;
        persistentHashMap.getClass();
        return persistentHashMap.size;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return new PersistentHashMapValuesIterator(this.map.node);
    }
}
