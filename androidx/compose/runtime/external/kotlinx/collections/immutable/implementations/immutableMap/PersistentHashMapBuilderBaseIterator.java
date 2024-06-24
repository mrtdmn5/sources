package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: PersistentHashMapBuilderContentIterators.kt */
/* loaded from: classes.dex */
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> {
    public final PersistentHashMapBuilder<K, V> builder;
    public int expectedModCount;
    public K lastIteratedKey;
    public boolean nextWasInvoked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentHashMapBuilderBaseIterator(PersistentHashMapBuilder<K, V> builder, TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr) {
        super(builder.node, trieNodeBaseIteratorArr);
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.expectedModCount = builder.modCount;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public final T next() {
        if (this.builder.modCount == this.expectedModCount) {
            if (this.hasNext) {
                TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator = this.path[this.pathLastIndex];
                this.lastIteratedKey = (K) trieNodeBaseIterator.buffer[trieNodeBaseIterator.index];
                this.nextWasInvoked = true;
                return (T) super.next();
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public final void remove() {
        int r3;
        if (this.nextWasInvoked) {
            boolean z = this.hasNext;
            PersistentHashMapBuilder<K, V> persistentHashMapBuilder = this.builder;
            if (z) {
                if (z) {
                    TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator = this.path[this.pathLastIndex];
                    Object obj = trieNodeBaseIterator.buffer[trieNodeBaseIterator.index];
                    TypeIntrinsics.asMutableMap(persistentHashMapBuilder).remove(this.lastIteratedKey);
                    if (obj != null) {
                        r3 = obj.hashCode();
                    } else {
                        r3 = 0;
                    }
                    resetPath(r3, persistentHashMapBuilder.node, obj, 0);
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                TypeIntrinsics.asMutableMap(persistentHashMapBuilder).remove(this.lastIteratedKey);
            }
            this.lastIteratedKey = null;
            this.nextWasInvoked = false;
            this.expectedModCount = persistentHashMapBuilder.modCount;
            return;
        }
        throw new IllegalStateException();
    }

    public final void resetPath(int r7, TrieNode<?, ?> trieNode, K k, int r10) {
        int r0 = r10 * 5;
        TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr = this.path;
        if (r0 > 30) {
            TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator = trieNodeBaseIteratorArr[r10];
            Object[] objArr = trieNode.buffer;
            int length = objArr.length;
            trieNodeBaseIterator.getClass();
            trieNodeBaseIterator.buffer = objArr;
            trieNodeBaseIterator.dataSize = length;
            trieNodeBaseIterator.index = 0;
            while (true) {
                TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator2 = trieNodeBaseIteratorArr[r10];
                if (!Intrinsics.areEqual(trieNodeBaseIterator2.buffer[trieNodeBaseIterator2.index], k)) {
                    trieNodeBaseIteratorArr[r10].index += 2;
                } else {
                    this.pathLastIndex = r10;
                    return;
                }
            }
        } else {
            int r02 = 1 << ((r7 >> r0) & 31);
            if (trieNode.hasEntryAt$runtime_release(r02)) {
                int entryKeyIndex$runtime_release = trieNode.entryKeyIndex$runtime_release(r02);
                TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator3 = trieNodeBaseIteratorArr[r10];
                Object[] buffer = trieNode.buffer;
                int bitCount = Integer.bitCount(trieNode.dataMap) * 2;
                trieNodeBaseIterator3.getClass();
                Intrinsics.checkNotNullParameter(buffer, "buffer");
                trieNodeBaseIterator3.buffer = buffer;
                trieNodeBaseIterator3.dataSize = bitCount;
                trieNodeBaseIterator3.index = entryKeyIndex$runtime_release;
                this.pathLastIndex = r10;
                return;
            }
            int nodeIndex$runtime_release = trieNode.nodeIndex$runtime_release(r02);
            TrieNode<?, ?> nodeAtIndex$runtime_release = trieNode.nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            TrieNodeBaseIterator<K, V, T> trieNodeBaseIterator4 = trieNodeBaseIteratorArr[r10];
            Object[] buffer2 = trieNode.buffer;
            int bitCount2 = Integer.bitCount(trieNode.dataMap) * 2;
            trieNodeBaseIterator4.getClass();
            Intrinsics.checkNotNullParameter(buffer2, "buffer");
            trieNodeBaseIterator4.buffer = buffer2;
            trieNodeBaseIterator4.dataSize = bitCount2;
            trieNodeBaseIterator4.index = nodeIndex$runtime_release;
            resetPath(r7, nodeAtIndex$runtime_release, k, r10 + 1);
        }
    }
}
