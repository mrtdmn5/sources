package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMapBuilderContentIterators.kt */
/* loaded from: classes.dex */
public final class TrieNodeMutableEntriesIterator<K, V> extends TrieNodeBaseIterator<K, V, Map.Entry<K, V>> {
    public final PersistentHashMapBuilderEntriesIterator<K, V> parentIterator;

    public TrieNodeMutableEntriesIterator(PersistentHashMapBuilderEntriesIterator<K, V> parentIterator) {
        Intrinsics.checkNotNullParameter(parentIterator, "parentIterator");
        this.parentIterator = parentIterator;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int r0 = this.index + 2;
        this.index = r0;
        Object[] objArr = this.buffer;
        return new MutableMapEntry(this.parentIterator, objArr[r0 - 2], objArr[r0 - 1]);
    }
}
