package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    public StateListStateRecord firstStateRecord = new StateListStateRecord(SmallPersistentVector.EMPTY);

    /* compiled from: SnapshotStateList.kt */
    /* loaded from: classes.dex */
    public static final class StateListStateRecord<T> extends StateRecord {
        public PersistentList<? extends T> list;
        public int modification;

        public StateListStateRecord(PersistentList<? extends T> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (SnapshotStateListKt.sync) {
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t) {
        int r2;
        PersistentList<? extends T> persistentList;
        boolean z;
        Snapshot currentSnapshot;
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r2 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentList<? extends T> add = persistentList.add((PersistentList<? extends T>) t);
            z = false;
            if (Intrinsics.areEqual(add, persistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r2) {
                        stateListStateRecord4.setList$runtime_release(add);
                        stateListStateRecord4.modification++;
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return true;
    }

    @Override // java.util.List
    public final boolean addAll(final int r2, final Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                List it = (List) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.addAll(r2, elements));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        Snapshot currentSnapshot;
        StateListStateRecord stateListStateRecord = this.firstStateRecord;
        Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        synchronized (SnapshotKt.lock) {
            currentSnapshot = SnapshotKt.currentSnapshot();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, currentSnapshot);
            synchronized (SnapshotStateListKt.sync) {
                stateListStateRecord2.setList$runtime_release(SmallPersistentVector.EMPTY);
                stateListStateRecord2.modification++;
            }
        }
        SnapshotKt.notifyWrite(currentSnapshot, this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return getReadable$runtime_release().list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return getReadable$runtime_release().list.containsAll(elements);
    }

    @Override // java.util.List
    public final T get(int r2) {
        return getReadable$runtime_release().list.get(r2);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final int getModification$runtime_release() {
        StateListStateRecord stateListStateRecord = this.firstStateRecord;
        Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current(stateListStateRecord)).modification;
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateListStateRecord stateListStateRecord = this.firstStateRecord;
        Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable(stateListStateRecord, this);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return getReadable$runtime_release().list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return getReadable$runtime_release().list.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return getReadable$runtime_release().list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    public final boolean mutateBoolean(Function1<? super List<T>, Boolean> function1) {
        int r2;
        PersistentList<? extends T> persistentList;
        Boolean invoke;
        Snapshot currentSnapshot;
        boolean z;
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r2 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentVectorBuilder builder = persistentList.builder();
            invoke = function1.invoke(builder);
            PersistentList<? extends T> build = builder.build();
            if (Intrinsics.areEqual(build, persistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r2) {
                        stateListStateRecord4.setList$runtime_release(build);
                        z = true;
                        stateListStateRecord4.modification++;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return invoke.booleanValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        stateRecord.next = this.firstStateRecord;
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    @Override // java.util.List
    public final T remove(int r9) {
        int r3;
        PersistentList<? extends T> persistentList;
        Snapshot currentSnapshot;
        boolean z;
        T t = get(r9);
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r3 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentList<? extends T> removeAt = persistentList.removeAt(r9);
            if (Intrinsics.areEqual(removeAt, persistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r3) {
                        stateListStateRecord4.setList$runtime_release(removeAt);
                        z = true;
                        stateListStateRecord4.modification++;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return t;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> elements) {
        int r2;
        PersistentList<? extends T> persistentList;
        boolean z;
        Snapshot currentSnapshot;
        Intrinsics.checkNotNullParameter(elements, "elements");
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r2 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentList<? extends T> removeAll = persistentList.removeAll((Collection<? extends Object>) elements);
            z = false;
            if (Intrinsics.areEqual(removeAll, persistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r2) {
                        stateListStateRecord4.setList$runtime_release(removeAll);
                        stateListStateRecord4.modification++;
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(final Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                List it = (List) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.retainAll(elements));
            }
        });
    }

    @Override // java.util.List
    public final T set(int r9, T t) {
        int r3;
        PersistentList<? extends T> persistentList;
        Snapshot currentSnapshot;
        boolean z;
        T t2 = get(r9);
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r3 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentList<? extends T> persistentList2 = persistentList.set(r9, (int) t);
            if (Intrinsics.areEqual(persistentList2, persistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r3) {
                        stateListStateRecord4.setList$runtime_release(persistentList2);
                        z = true;
                        stateListStateRecord4.modification++;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return t2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return getReadable$runtime_release().list.size();
    }

    @Override // java.util.List
    public final List<T> subList(int r4, int r5) {
        boolean z;
        boolean z2 = true;
        if (r4 >= 0 && r4 <= r5) {
            z = true;
        } else {
            z = false;
        }
        if (!z || r5 > size()) {
            z2 = false;
        }
        if (z2) {
            return new SubList(this, r4, r5);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> elements) {
        int r2;
        PersistentList<? extends T> persistentList;
        boolean z;
        Snapshot currentSnapshot;
        Intrinsics.checkNotNullParameter(elements, "elements");
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r2 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentList<? extends T> addAll = persistentList.addAll((Collection<? extends Object>) elements);
            z = false;
            if (Intrinsics.areEqual(addAll, persistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r2) {
                        stateListStateRecord4.setList$runtime_release(addAll);
                        stateListStateRecord4.modification++;
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return true;
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int r2) {
        return new StateListIterator(this, r2);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List
    public final void add(int r8, T t) {
        int r2;
        PersistentList<? extends T> persistentList;
        Snapshot currentSnapshot;
        boolean z;
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r2 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentList<? extends T> add = persistentList.add(r8, (int) t);
            if (Intrinsics.areEqual(add, persistentList)) {
                return;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r2) {
                        stateListStateRecord4.setList$runtime_release(add);
                        z = true;
                        stateListStateRecord4.modification++;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int r2;
        PersistentList<? extends T> persistentList;
        boolean z;
        Snapshot currentSnapshot;
        do {
            Object obj2 = SnapshotStateListKt.sync;
            synchronized (obj2) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r2 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentList<? extends T> remove = persistentList.remove((PersistentList<? extends T>) obj);
            z = false;
            if (Intrinsics.areEqual(remove, persistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, currentSnapshot);
                synchronized (obj2) {
                    if (stateListStateRecord4.modification == r2) {
                        stateListStateRecord4.setList$runtime_release(remove);
                        stateListStateRecord4.modification++;
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        } while (!z);
        return true;
    }
}
