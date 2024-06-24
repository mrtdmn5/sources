package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMap.kt */
/* loaded from: classes.dex */
public class PersistentHashMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {
    public static final PersistentHashMap EMPTY = new PersistentHashMap(TrieNode.EMPTY, 0);
    public final TrieNode<K, V> node;
    public final int size;

    public PersistentHashMap(TrieNode<K, V> node, int r3) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.node = node;
        this.size = r3;
    }

    @Override // java.util.Map
    public boolean containsKey(K k) {
        int r1;
        if (k != null) {
            r1 = k.hashCode();
        } else {
            r1 = 0;
        }
        return this.node.containsKey(r1, 0, k);
    }

    @Override // java.util.Map
    public V get(K k) {
        int r1;
        if (k != null) {
            r1 = k.hashCode();
        } else {
            r1 = 0;
        }
        return (V) this.node.get(r1, 0, k);
    }

    public final PersistentHashMap put(Object obj, Links links) {
        int r1;
        if (obj != null) {
            r1 = obj.hashCode();
        } else {
            r1 = 0;
        }
        TrieNode.ModificationResult put = this.node.put(r1, 0, obj, links);
        if (put == null) {
            return this;
        }
        return new PersistentHashMap(put.node, this.size + put.sizeDelta);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentHashMapBuilder<K, V> builder() {
        return new PersistentHashMapBuilder<>(this);
    }
}
