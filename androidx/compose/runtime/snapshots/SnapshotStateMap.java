package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, KMutableMap {
    public final SnapshotMapEntrySet entries;
    public StateMapStateRecord firstStateRecord;
    public final SnapshotMapKeySet keys;
    public final SnapshotMapValueSet values;

    /* compiled from: SnapshotStateMap.kt */
    /* loaded from: classes.dex */
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        public PersistentMap<K, ? extends V> map;
        public int modification;

        public StateMapStateRecord(PersistentMap<K, ? extends V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) value;
            synchronized (SnapshotStateMapKt.sync) {
                this.map = stateMapStateRecord.map;
                this.modification = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create() {
            return new StateMapStateRecord(this.map);
        }

        public final void setMap$runtime_release(PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "<set-?>");
            this.map = persistentMap;
        }
    }

    public SnapshotStateMap() {
        PersistentHashMap persistentHashMap = PersistentHashMap.EMPTY;
        Intrinsics.checkNotNull(persistentHashMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
        this.firstStateRecord = new StateMapStateRecord(persistentHashMap);
        this.entries = new SnapshotMapEntrySet(this);
        this.keys = new SnapshotMapKeySet(this);
        this.values = new SnapshotMapValueSet(this);
    }

    @Override // java.util.Map
    public final void clear() {
        Snapshot currentSnapshot;
        StateMapStateRecord stateMapStateRecord = this.firstStateRecord;
        Intrinsics.checkNotNull(stateMapStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord);
        PersistentHashMap persistentHashMap = PersistentHashMap.EMPTY;
        Intrinsics.checkNotNull(persistentHashMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
        if (persistentHashMap != stateMapStateRecord2.map) {
            StateMapStateRecord stateMapStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateMapStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, currentSnapshot);
                synchronized (SnapshotStateMapKt.sync) {
                    stateMapStateRecord4.map = persistentHashMap;
                    stateMapStateRecord4.modification++;
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        }
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return getReadable$runtime_release().map.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return getReadable$runtime_release().map.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.entries;
    }

    @Override // java.util.Map
    public final V get(Object obj) {
        return getReadable$runtime_release().map.get(obj);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        StateMapStateRecord stateMapStateRecord = this.firstStateRecord;
        Intrinsics.checkNotNull(stateMapStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.readable(stateMapStateRecord, this);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return getReadable$runtime_release().map.isEmpty();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.keys;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.firstStateRecord = (StateMapStateRecord) stateRecord;
    }

    @Override // java.util.Map
    public final V put(K k, V v) {
        PersistentMap<K, ? extends V> persistentMap;
        int r1;
        V put;
        Snapshot currentSnapshot;
        boolean z;
        do {
            Object obj = SnapshotStateMapKt.sync;
            synchronized (obj) {
                StateMapStateRecord stateMapStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateMapStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord);
                persistentMap = stateMapStateRecord2.map;
                r1 = stateMapStateRecord2.modification;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentMap);
            PersistentMap.Builder<K, ? extends V> builder = persistentMap.builder();
            put = builder.put(k, v);
            PersistentMap<K, ? extends V> build = builder.build();
            if (Intrinsics.areEqual(build, persistentMap)) {
                break;
            }
            StateMapStateRecord stateMapStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateMapStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateMapStateRecord4.modification == r1) {
                        stateMapStateRecord4.setMap$runtime_release(build);
                        z = true;
                        stateMapStateRecord4.modification++;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return put;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> from) {
        PersistentMap<K, ? extends V> persistentMap;
        int r1;
        Snapshot currentSnapshot;
        boolean z;
        Intrinsics.checkNotNullParameter(from, "from");
        do {
            Object obj = SnapshotStateMapKt.sync;
            synchronized (obj) {
                StateMapStateRecord stateMapStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateMapStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord);
                persistentMap = stateMapStateRecord2.map;
                r1 = stateMapStateRecord2.modification;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentMap);
            PersistentMap.Builder<K, ? extends V> builder = persistentMap.builder();
            builder.putAll(from);
            PersistentMap<K, ? extends V> build = builder.build();
            if (!Intrinsics.areEqual(build, persistentMap)) {
                StateMapStateRecord stateMapStateRecord3 = this.firstStateRecord;
                Intrinsics.checkNotNull(stateMapStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                synchronized (SnapshotKt.lock) {
                    currentSnapshot = SnapshotKt.currentSnapshot();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, currentSnapshot);
                    synchronized (obj) {
                        if (stateMapStateRecord4.modification == r1) {
                            stateMapStateRecord4.setMap$runtime_release(build);
                            z = true;
                            stateMapStateRecord4.modification++;
                        } else {
                            z = false;
                        }
                    }
                }
                SnapshotKt.notifyWrite(currentSnapshot, this);
            } else {
                return;
            }
        } while (!z);
    }

    @Override // java.util.Map
    public final V remove(Object obj) {
        PersistentMap<K, ? extends V> persistentMap;
        int r1;
        V remove;
        Snapshot currentSnapshot;
        boolean z;
        do {
            Object obj2 = SnapshotStateMapKt.sync;
            synchronized (obj2) {
                StateMapStateRecord stateMapStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateMapStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord);
                persistentMap = stateMapStateRecord2.map;
                r1 = stateMapStateRecord2.modification;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentMap);
            PersistentMap.Builder<K, ? extends V> builder = persistentMap.builder();
            remove = builder.remove(obj);
            PersistentMap<K, ? extends V> build = builder.build();
            if (Intrinsics.areEqual(build, persistentMap)) {
                break;
            }
            StateMapStateRecord stateMapStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateMapStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, currentSnapshot);
                synchronized (obj2) {
                    if (stateMapStateRecord4.modification == r1) {
                        stateMapStateRecord4.setMap$runtime_release(build);
                        z = true;
                        stateMapStateRecord4.modification++;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return remove;
    }

    @Override // java.util.Map
    public final int size() {
        return getReadable$runtime_release().map.size();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.values;
    }
}
