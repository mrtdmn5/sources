package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
public final class SnapshotMapKeySet<K, V> extends SnapshotMapSet<K, V, K> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapKeySet(SnapshotStateMap<K, V> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!this.map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        SnapshotStateMap<K, V> snapshotStateMap = this.map;
        return new StateMapMutableKeysIterator(snapshotStateMap, ((ImmutableSet) snapshotStateMap.getReadable$runtime_release().map.entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        if (this.map.remove(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (this.map.remove(it.next()) != null || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> elements) {
        PersistentMap<K, ? extends V> persistentMap;
        int r4;
        boolean z;
        Snapshot currentSnapshot;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Set set = CollectionsKt___CollectionsKt.toSet(elements);
        SnapshotStateMap<K, V> snapshotStateMap = this.map;
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = snapshotStateMap.firstStateRecord;
                Intrinsics.checkNotNull(stateMapStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(stateMapStateRecord);
                persistentMap = stateMapStateRecord2.map;
                r4 = stateMapStateRecord2.modification;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentMap);
            PersistentMap.Builder<K, ? extends V> builder = persistentMap.builder();
            Object it = snapshotStateMap.entries.iterator();
            while (true) {
                z = true;
                if (!((StateMapMutableIterator) it).hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) ((StateMapMutableEntriesIterator) it).next();
                if (!set.contains(entry.getKey())) {
                    builder.remove(entry.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap<K, ? extends V> build = builder.build();
            if (Intrinsics.areEqual(build, persistentMap)) {
                break;
            }
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord3 = snapshotStateMap.firstStateRecord;
            Intrinsics.checkNotNull(stateMapStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord4 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, snapshotStateMap, currentSnapshot);
                synchronized (SnapshotStateMapKt.sync) {
                    if (stateMapStateRecord4.modification == r4) {
                        stateMapStateRecord4.setMap$runtime_release(build);
                        stateMapStateRecord4.modification++;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, snapshotStateMap);
        } while (!z);
        return z2;
    }
}
