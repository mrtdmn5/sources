package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
public final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapEntrySet(SnapshotStateMap<K, V> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
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
        boolean z;
        if ((obj instanceof Map.Entry) && (!(obj instanceof KMappedMarker) || (obj instanceof KMutableMap.Entry))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(this.map.get(element.getKey()), element.getValue());
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
            if (!contains((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        SnapshotStateMap<K, V> snapshotStateMap = this.map;
        return new StateMapMutableEntriesIterator(snapshotStateMap, ((ImmutableSet) snapshotStateMap.getReadable$runtime_release().map.entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        boolean z;
        if ((obj instanceof Map.Entry) && (!(obj instanceof KMappedMarker) || (obj instanceof KMutableMap.Entry))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        if (this.map.remove(element.getKey()) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (this.map.remove(((Map.Entry) it.next()).getKey()) != null || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> elements) {
        PersistentMap<K, ? extends V> persistentMap;
        int r4;
        boolean z;
        Snapshot currentSnapshot;
        boolean z2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> collection = elements;
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(collection, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        SnapshotStateMap<K, V> snapshotStateMap = this.map;
        boolean z3 = false;
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
            Object it2 = snapshotStateMap.entries.iterator();
            while (true) {
                z = true;
                if (!((StateMapMutableIterator) it2).hasNext()) {
                    break;
                }
                Map.Entry entry2 = (Map.Entry) ((StateMapMutableEntriesIterator) it2).next();
                if (linkedHashMap.containsKey(entry2.getKey()) && Intrinsics.areEqual(linkedHashMap.get(entry2.getKey()), entry2.getValue())) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    builder.remove(entry2.getKey());
                    z3 = true;
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
        return z3;
    }
}
