package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Iterator;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentOrderedSet.kt */
/* loaded from: classes.dex */
public final class PersistentOrderedSet<E> extends AbstractSet<E> implements PersistentSet<E> {
    public static final PersistentOrderedSet EMPTY;
    public final Object firstElement;
    public final PersistentHashMap<E, Links> hashMap;
    public final Object lastElement;

    static {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        PersistentHashMap persistentHashMap = PersistentHashMap.EMPTY;
        Intrinsics.checkNotNull(persistentHashMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
        EMPTY = new PersistentOrderedSet(endOfChain, endOfChain, persistentHashMap);
    }

    public PersistentOrderedSet(Object obj, Object obj2, PersistentHashMap<E, Links> persistentHashMap) {
        this.firstElement = obj;
        this.lastElement = obj2;
        this.hashMap = persistentHashMap;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public final PersistentOrderedSet add(Recomposer.RecomposerInfoImpl recomposerInfoImpl) {
        PersistentHashMap<E, Links> persistentHashMap = this.hashMap;
        if (persistentHashMap.containsKey(recomposerInfoImpl)) {
            return this;
        }
        if (isEmpty()) {
            return new PersistentOrderedSet(recomposerInfoImpl, recomposerInfoImpl, persistentHashMap.put(recomposerInfoImpl, new Links()));
        }
        Object obj = this.lastElement;
        Object obj2 = persistentHashMap.get(obj);
        Intrinsics.checkNotNull(obj2);
        return new PersistentOrderedSet(this.firstElement, recomposerInfoImpl, persistentHashMap.put(obj, new Links(((Links) obj2).previous, recomposerInfoImpl)).put((Object) recomposerInfoImpl, new Links(obj, EndOfChain.INSTANCE)));
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        PersistentHashMap<E, Links> persistentHashMap = this.hashMap;
        persistentHashMap.getClass();
        return persistentHashMap.size;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return new PersistentOrderedSetIterator(this.firstElement, this.hashMap);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public final PersistentOrderedSet remove(Object obj) {
        int r3;
        boolean z;
        boolean z2;
        boolean z3;
        Object obj2;
        PersistentHashMap<E, Links> persistentHashMap = this.hashMap;
        Links links = persistentHashMap.get(obj);
        if (links == null) {
            return this;
        }
        boolean z4 = false;
        if (obj != null) {
            r3 = obj.hashCode();
        } else {
            r3 = 0;
        }
        TrieNode<E, Links> trieNode = persistentHashMap.node;
        TrieNode<E, Links> remove = trieNode.remove(r3, 0, obj);
        if (trieNode != remove) {
            if (remove == null) {
                persistentHashMap = PersistentHashMap.EMPTY;
                Intrinsics.checkNotNull(persistentHashMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            } else {
                persistentHashMap = new PersistentHashMap<>(remove, persistentHashMap.size - 1);
            }
        }
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        Object obj3 = links.previous;
        if (obj3 != endOfChain) {
            z = true;
        } else {
            z = false;
        }
        Object obj4 = links.next;
        if (z) {
            Links links2 = persistentHashMap.get(obj3);
            Intrinsics.checkNotNull(links2);
            persistentHashMap = persistentHashMap.put(obj3, new Links(links2.previous, obj4));
        }
        if (obj4 != endOfChain) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Links links3 = persistentHashMap.get(obj4);
            Intrinsics.checkNotNull(links3);
            persistentHashMap = persistentHashMap.put(obj4, new Links(obj3, links3.next));
        }
        if (obj3 != endOfChain) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            obj2 = obj4;
        } else {
            obj2 = this.firstElement;
        }
        if (obj4 != endOfChain) {
            z4 = true;
        }
        if (z4) {
            obj3 = this.lastElement;
        }
        return new PersistentOrderedSet(obj2, obj3, persistentHashMap);
    }
}
