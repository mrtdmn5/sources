package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public final class TrieNodeValuesIterator<K, V> extends TrieNodeBaseIterator<K, V, V> {
    @Override // java.util.Iterator
    public final V next() {
        int r0 = this.index + 2;
        this.index = r0;
        return (V) this.buffer[r0 - 1];
    }
}
