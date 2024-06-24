package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public final class TrieNodeKeysIterator<K, V> extends TrieNodeBaseIterator<K, V, K> {
    @Override // java.util.Iterator
    public final K next() {
        int r0 = this.index + 2;
        this.index = r0;
        return (K) this.buffer[r0 - 2];
    }
}
