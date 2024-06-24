package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import kotlin.collections.AbstractMutableCollection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMapBuilderContentViews.kt */
/* loaded from: classes.dex */
public final class PersistentHashMapBuilderValues<K, V> extends AbstractMutableCollection<V> {
    public final PersistentHashMapBuilder<K, V> builder;

    public PersistentHashMapBuilderValues(PersistentHashMapBuilder<K, V> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.builder.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.builder.containsValue(obj);
    }

    @Override // kotlin.collections.AbstractMutableCollection
    public final int getSize() {
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder = this.builder;
        persistentHashMapBuilder.getClass();
        return persistentHashMapBuilder.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return new PersistentHashMapBuilderValuesIterator(this.builder);
    }
}
