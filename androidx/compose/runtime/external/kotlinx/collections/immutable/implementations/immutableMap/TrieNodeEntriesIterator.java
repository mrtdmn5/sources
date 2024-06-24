package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;

/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public final class TrieNodeEntriesIterator<K, V> extends TrieNodeBaseIterator<K, V, Map.Entry<? extends K, ? extends V>> {
    @Override // java.util.Iterator
    public final Object next() {
        int r0 = this.index + 2;
        this.index = r0;
        Object[] objArr = this.buffer;
        return new MapEntry(objArr[r0 - 2], objArr[r0 - 1]);
    }
}
