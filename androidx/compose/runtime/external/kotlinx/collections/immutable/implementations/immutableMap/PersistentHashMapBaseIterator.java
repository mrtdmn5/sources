package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {
    public boolean hasNext;
    public final TrieNodeBaseIterator<K, V, T>[] path;
    public int pathLastIndex;

    public PersistentHashMapBaseIterator(TrieNode<K, V> node, TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.path = trieNodeBaseIteratorArr;
        this.hasNext = true;
        TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator = trieNodeBaseIteratorArr[0];
        Object[] buffer = node.buffer;
        int bitCount = Integer.bitCount(node.dataMap) * 2;
        trieNodeBaseIterator.getClass();
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        trieNodeBaseIterator.buffer = buffer;
        trieNodeBaseIterator.dataSize = bitCount;
        trieNodeBaseIterator.index = 0;
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }

    public final void ensureNextEntryIsReady() {
        boolean z;
        boolean z2;
        int r0 = this.pathLastIndex;
        TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr = this.path;
        TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator = trieNodeBaseIteratorArr[r0];
        if (trieNodeBaseIterator.index < trieNodeBaseIterator.dataSize) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        while (-1 < r0) {
            int moveToNextNodeWithData = moveToNextNodeWithData(r0);
            if (moveToNextNodeWithData == -1) {
                TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator2 = trieNodeBaseIteratorArr[r0];
                int r7 = trieNodeBaseIterator2.index;
                Object[] objArr = trieNodeBaseIterator2.buffer;
                if (r7 < objArr.length) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    int length = objArr.length;
                    trieNodeBaseIterator2.index = r7 + 1;
                    moveToNextNodeWithData = moveToNextNodeWithData(r0);
                }
            }
            if (moveToNextNodeWithData != -1) {
                this.pathLastIndex = moveToNextNodeWithData;
                return;
            }
            if (r0 > 0) {
                TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator3 = trieNodeBaseIteratorArr[r0 - 1];
                int r3 = trieNodeBaseIterator3.index;
                int length2 = trieNodeBaseIterator3.buffer.length;
                trieNodeBaseIterator3.index = r3 + 1;
            }
            TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator4 = trieNodeBaseIteratorArr[r0];
            Object[] buffer = TrieNode.EMPTY.buffer;
            trieNodeBaseIterator4.getClass();
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            trieNodeBaseIterator4.buffer = buffer;
            trieNodeBaseIterator4.dataSize = 0;
            trieNodeBaseIterator4.index = 0;
            r0--;
        }
        this.hasNext = false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    public final int moveToNextNodeWithData(int r7) {
        boolean z;
        boolean z2;
        TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr = this.path;
        TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator = trieNodeBaseIteratorArr[r7];
        int r2 = trieNodeBaseIterator.index;
        if (r2 < trieNodeBaseIterator.dataSize) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return r7;
        }
        Object[] objArr = trieNodeBaseIterator.buffer;
        if (r2 < objArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            int length = objArr.length;
            Object obj = objArr[r2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
            TrieNode trieNode = (TrieNode) obj;
            if (r7 == 6) {
                TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator2 = trieNodeBaseIteratorArr[r7 + 1];
                Object[] objArr2 = trieNode.buffer;
                int length2 = objArr2.length;
                trieNodeBaseIterator2.getClass();
                trieNodeBaseIterator2.buffer = objArr2;
                trieNodeBaseIterator2.dataSize = length2;
                trieNodeBaseIterator2.index = 0;
            } else {
                TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator3 = trieNodeBaseIteratorArr[r7 + 1];
                Object[] buffer = trieNode.buffer;
                int bitCount = Integer.bitCount(trieNode.dataMap) * 2;
                trieNodeBaseIterator3.getClass();
                Intrinsics.checkNotNullParameter(buffer, "buffer");
                trieNodeBaseIterator3.buffer = buffer;
                trieNodeBaseIterator3.dataSize = bitCount;
                trieNodeBaseIterator3.index = 0;
            }
            return moveToNextNodeWithData(r7 + 1);
        }
        return -1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.hasNext) {
            T next = this.path[this.pathLastIndex].next();
            ensureNextEntryIsReady();
            return next;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
