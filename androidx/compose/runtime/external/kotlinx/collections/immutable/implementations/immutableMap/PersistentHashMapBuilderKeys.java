package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMapBuilderContentViews.kt */
/* loaded from: classes.dex */
public final class PersistentHashMapBuilderKeys<K, V> extends AbstractMutableSet<K> {
    public final PersistentHashMapBuilder<K, V> builder;

    public PersistentHashMapBuilderKeys(PersistentHashMapBuilder<K, V> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.builder.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.builder.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder = this.builder;
        persistentHashMapBuilder.getClass();
        return persistentHashMapBuilder.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        return new PersistentHashMapBuilderKeysIterator(this.builder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder = this.builder;
        if (persistentHashMapBuilder.containsKey(obj)) {
            persistentHashMapBuilder.remove(obj);
            return true;
        }
        return false;
    }
}
