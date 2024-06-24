package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: PersistentCompositionLocalMap.kt */
/* loaded from: classes.dex */
public final class PersistentCompositionLocalHashMap extends PersistentHashMap<CompositionLocal<Object>, State<? extends Object>> implements PersistentCompositionLocalMap {
    public static final PersistentCompositionLocalHashMap Empty;

    /* compiled from: PersistentCompositionLocalMap.kt */
    /* loaded from: classes.dex */
    public static final class Builder extends PersistentHashMapBuilder<CompositionLocal<Object>, State<? extends Object>> {
        public PersistentCompositionLocalHashMap map;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(PersistentCompositionLocalHashMap map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        /* renamed from: build$1, reason: merged with bridge method [inline-methods] */
        public final PersistentCompositionLocalHashMap build() {
            Object obj = this.node;
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = this.map;
            if (obj != persistentCompositionLocalHashMap.node) {
                this.ownership = new JobKt();
                persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(this.node, this.size);
            }
            this.map = persistentCompositionLocalHashMap;
            return persistentCompositionLocalHashMap;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (!(obj instanceof CompositionLocal)) {
                return false;
            }
            return super.containsKey((CompositionLocal) obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (!(obj instanceof State)) {
                return false;
            }
            return super.containsValue((State) obj);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (!(obj instanceof CompositionLocal)) {
                return null;
            }
            return (State) super.get((CompositionLocal) obj);
        }

        @Override // java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            if (!(obj instanceof CompositionLocal)) {
                return obj2;
            }
            return (State) super.getOrDefault((CompositionLocal) obj, (State) obj2);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (!(obj instanceof CompositionLocal)) {
                return null;
            }
            return (State) super.remove((CompositionLocal) obj);
        }
    }

    static {
        TrieNode trieNode = TrieNode.EMPTY;
        Intrinsics.checkNotNull(trieNode, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>");
        Empty = new PersistentCompositionLocalHashMap(trieNode, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentCompositionLocalHashMap(TrieNode<CompositionLocal<Object>, State<Object>> node, int r3) {
        super(node, r3);
        Intrinsics.checkNotNullParameter(node, "node");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public final PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder() {
        return new Builder(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof CompositionLocal)) {
            return false;
        }
        return super.containsKey((CompositionLocal) obj);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof State)) {
            return false;
        }
        return super.containsValue((State) obj);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof CompositionLocal) {
            return (State) super.get((PersistentCompositionLocalHashMap) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        if (!(obj instanceof CompositionLocal)) {
            return obj2;
        }
        return (State) super.getOrDefault((CompositionLocal) obj, (State) obj2);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    /* renamed from: builder, reason: avoid collision after fix types in other method */
    public final PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder2() {
        return new Builder(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public final PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder() {
        return new Builder(this);
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public final Object get(ProvidableCompositionLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CompositionLocalMapKt.read(this, key);
    }
}
