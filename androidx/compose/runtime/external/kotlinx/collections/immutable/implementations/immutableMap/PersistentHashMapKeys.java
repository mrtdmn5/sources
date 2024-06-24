package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMapContentViews.kt */
/* loaded from: classes.dex */
public final class PersistentHashMapKeys<K, V> extends AbstractSet<K> implements ImmutableSet<K> {
    public final PersistentHashMap<K, V> map;

    public PersistentHashMapKeys(PersistentHashMap<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        PersistentHashMap<K, V> persistentHashMap = this.map;
        persistentHashMap.getClass();
        return persistentHashMap.size;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        return new PersistentHashMapKeysIterator(this.map.node);
    }
}
