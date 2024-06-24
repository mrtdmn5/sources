package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import java.util.Map;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: PersistentHashMapBuilder.kt */
/* loaded from: classes.dex */
public class PersistentHashMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {
    public PersistentHashMap<K, V> map;
    public int modCount;
    public TrieNode<K, V> node;
    public V operationResult;
    public JobKt ownership;
    public int size;

    public PersistentHashMapBuilder(PersistentHashMap<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
        this.ownership = new JobKt();
        this.node = map.node;
        this.size = map.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        TrieNode trieNode = TrieNode.EMPTY;
        TrieNode<K, V> trieNode2 = TrieNode.EMPTY;
        Intrinsics.checkNotNull(trieNode2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = trieNode2;
        setSize(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(K k) {
        int r2;
        TrieNode<K, V> trieNode = this.node;
        if (k != null) {
            r2 = k.hashCode();
        } else {
            r2 = 0;
        }
        return trieNode.containsKey(r2, 0, k);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(K k) {
        int r2;
        TrieNode<K, V> trieNode = this.node;
        if (k != null) {
            r2 = k.hashCode();
        } else {
            r2 = 0;
        }
        return (V) trieNode.get(r2, 0, k);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int r0;
        this.operationResult = null;
        TrieNode<K, V> trieNode = this.node;
        if (k != null) {
            r0 = k.hashCode();
        } else {
            r0 = 0;
        }
        this.node = trieNode.mutablePut(r0, k, v, 0, this);
        return this.operationResult;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> from) {
        PersistentHashMap<K, V> persistentHashMap;
        PersistentHashMapBuilder persistentHashMapBuilder;
        Intrinsics.checkNotNullParameter(from, "from");
        PersistentHashMap<K, V> persistentHashMap2 = null;
        if (from instanceof PersistentHashMap) {
            persistentHashMap = (PersistentHashMap) from;
        } else {
            persistentHashMap = null;
        }
        if (persistentHashMap == null) {
            if (from instanceof PersistentHashMapBuilder) {
                persistentHashMapBuilder = (PersistentHashMapBuilder) from;
            } else {
                persistentHashMapBuilder = null;
            }
            if (persistentHashMapBuilder != null) {
                persistentHashMap2 = persistentHashMapBuilder.build();
            }
        } else {
            persistentHashMap2 = persistentHashMap;
        }
        if (persistentHashMap2 != null) {
            DeltaCounter deltaCounter = new DeltaCounter(0);
            int r2 = this.size;
            TrieNode<K, V> trieNode = this.node;
            TrieNode<K, V> trieNode2 = persistentHashMap2.node;
            Intrinsics.checkNotNull(trieNode2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
            this.node = trieNode.mutablePutAll(trieNode2, 0, deltaCounter, this);
            int r0 = (persistentHashMap2.size + r2) - deltaCounter.count;
            if (r2 != r0) {
                setSize(r0);
                return;
            }
            return;
        }
        super.putAll(from);
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int r0 = this.size;
        TrieNode<K, V> mutableRemove = this.node.mutableRemove(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (mutableRemove == null) {
            TrieNode trieNode = TrieNode.EMPTY;
            mutableRemove = TrieNode.EMPTY;
            Intrinsics.checkNotNull(mutableRemove, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = mutableRemove;
        return r0 != this.size;
    }

    public final void setSize(int r1) {
        this.size = r1;
        this.modCount++;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    public PersistentHashMap<K, V> build() {
        TrieNode<K, V> trieNode = this.node;
        PersistentHashMap<K, V> persistentHashMap = this.map;
        if (trieNode != persistentHashMap.node) {
            this.ownership = new JobKt();
            persistentHashMap = new PersistentHashMap<>(this.node, this.size);
        }
        this.map = persistentHashMap;
        return persistentHashMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(K k) {
        this.operationResult = null;
        TrieNode<K, V> mutableRemove = this.node.mutableRemove(k != null ? k.hashCode() : 0, k, 0, this);
        if (mutableRemove == null) {
            TrieNode trieNode = TrieNode.EMPTY;
            mutableRemove = TrieNode.EMPTY;
            Intrinsics.checkNotNull(mutableRemove, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = mutableRemove;
        return this.operationResult;
    }
}
