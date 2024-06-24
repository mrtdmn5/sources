package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public abstract class TrieNodeBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {
    public Object[] buffer;
    public int dataSize;
    public int index;

    public TrieNodeBaseIterator() {
        TrieNode trieNode = TrieNode.EMPTY;
        this.buffer = TrieNode.EMPTY.buffer;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.index < this.dataSize) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
