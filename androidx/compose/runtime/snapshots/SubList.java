package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public final class SubList<T> implements List<T>, KMutableList {
    public int modification;
    public final int offset;
    public final SnapshotStateList<T> parentList;
    public int size;

    public SubList(SnapshotStateList<T> parentList, int r3, int r4) {
        Intrinsics.checkNotNullParameter(parentList, "parentList");
        this.parentList = parentList;
        this.offset = r3;
        this.modification = parentList.getModification$runtime_release();
        this.size = r4 - r3;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t) {
        validateModification();
        int r1 = this.offset + this.size;
        SnapshotStateList<T> snapshotStateList = this.parentList;
        snapshotStateList.add(r1, t);
        this.size++;
        this.modification = snapshotStateList.getModification$runtime_release();
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return addAll(this.size, elements);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        int r5;
        PersistentList<? extends T> persistentList;
        Snapshot currentSnapshot;
        boolean z;
        if (this.size > 0) {
            validateModification();
            SnapshotStateList<T> snapshotStateList = this.parentList;
            int r1 = this.offset;
            int r2 = this.size + r1;
            snapshotStateList.getClass();
            do {
                Object obj = SnapshotStateListKt.sync;
                synchronized (obj) {
                    SnapshotStateList.StateListStateRecord stateListStateRecord = snapshotStateList.firstStateRecord;
                    Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    SnapshotStateList.StateListStateRecord stateListStateRecord2 = (SnapshotStateList.StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                    r5 = stateListStateRecord2.modification;
                    persistentList = stateListStateRecord2.list;
                    Unit unit = Unit.INSTANCE;
                }
                Intrinsics.checkNotNull(persistentList);
                PersistentVectorBuilder builder = persistentList.builder();
                builder.subList(r1, r2).clear();
                PersistentList<? extends T> build = builder.build();
                if (Intrinsics.areEqual(build, persistentList)) {
                    break;
                }
                SnapshotStateList.StateListStateRecord stateListStateRecord3 = snapshotStateList.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                synchronized (SnapshotKt.lock) {
                    currentSnapshot = SnapshotKt.currentSnapshot();
                    SnapshotStateList.StateListStateRecord stateListStateRecord4 = (SnapshotStateList.StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, snapshotStateList, currentSnapshot);
                    synchronized (obj) {
                        if (stateListStateRecord4.modification == r5) {
                            stateListStateRecord4.setList$runtime_release(build);
                            z = true;
                            stateListStateRecord4.modification++;
                        } else {
                            z = false;
                        }
                    }
                }
                SnapshotKt.notifyWrite(currentSnapshot, snapshotStateList);
            } while (!z);
            this.size = 0;
            this.modification = this.parentList.getModification$runtime_release();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final T get(int r2) {
        validateModification();
        SnapshotStateListKt.access$validateRange(r2, this.size);
        return this.parentList.get(this.offset + r2);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        validateModification();
        int r0 = this.size;
        int r1 = this.offset;
        Iterator<Integer> it = RangesKt___RangesKt.until(r1, r0 + r1).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (Intrinsics.areEqual(obj, this.parentList.get(nextInt))) {
                return nextInt - r1;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        validateModification();
        int r0 = this.size;
        int r1 = this.offset;
        for (int r02 = (r0 + r1) - 1; r02 >= r1; r02--) {
            if (Intrinsics.areEqual(obj, this.parentList.get(r02))) {
                return r02 - r1;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> elements) {
        int r6;
        PersistentList<? extends T> persistentList;
        Snapshot currentSnapshot;
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int r1 = this.offset;
        int r2 = this.size + r1;
        snapshotStateList.getClass();
        int size = snapshotStateList.size();
        do {
            Object obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                SnapshotStateList.StateListStateRecord stateListStateRecord = snapshotStateList.firstStateRecord;
                Intrinsics.checkNotNull(stateListStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                SnapshotStateList.StateListStateRecord stateListStateRecord2 = (SnapshotStateList.StateListStateRecord) SnapshotKt.current(stateListStateRecord);
                r6 = stateListStateRecord2.modification;
                persistentList = stateListStateRecord2.list;
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(persistentList);
            PersistentVectorBuilder builder = persistentList.builder();
            builder.subList(r1, r2).retainAll(elements);
            PersistentList<? extends T> build = builder.build();
            if (Intrinsics.areEqual(build, persistentList)) {
                break;
            }
            SnapshotStateList.StateListStateRecord stateListStateRecord3 = snapshotStateList.firstStateRecord;
            Intrinsics.checkNotNull(stateListStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                SnapshotStateList.StateListStateRecord stateListStateRecord4 = (SnapshotStateList.StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, snapshotStateList, currentSnapshot);
                synchronized (obj) {
                    if (stateListStateRecord4.modification == r6) {
                        stateListStateRecord4.setList$runtime_release(build);
                        stateListStateRecord4.modification++;
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(currentSnapshot, snapshotStateList);
        } while (!z);
        int size2 = size - snapshotStateList.size();
        if (size2 > 0) {
            this.modification = this.parentList.getModification$runtime_release();
            this.size -= size2;
        }
        if (size2 > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List
    public final T set(int r2, T t) {
        SnapshotStateListKt.access$validateRange(r2, this.size);
        validateModification();
        int r22 = r2 + this.offset;
        SnapshotStateList<T> snapshotStateList = this.parentList;
        T t2 = snapshotStateList.set(r22, t);
        this.modification = snapshotStateList.getModification$runtime_release();
        return t2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.size;
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
        if (!z || r5 > this.size) {
            z2 = false;
        }
        if (z2) {
            validateModification();
            int r1 = this.offset;
            return new SubList(this.parentList, r4 + r1, r5 + r1);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final void validateModification() {
        if (this.parentList.getModification$runtime_release() == this.modification) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int r2) {
        validateModification();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = r2 - 1;
        return new SubList$listIterator$1(ref$IntRef, this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List
    public final boolean addAll(int r3, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        validateModification();
        int r32 = r3 + this.offset;
        SnapshotStateList<T> snapshotStateList = this.parentList;
        boolean addAll = snapshotStateList.addAll(r32, elements);
        if (addAll) {
            this.size = elements.size() + this.size;
            this.modification = snapshotStateList.getModification$runtime_release();
        }
        return addAll;
    }

    @Override // java.util.List
    public final T remove(int r3) {
        validateModification();
        int r0 = this.offset + r3;
        SnapshotStateList<T> snapshotStateList = this.parentList;
        T remove = snapshotStateList.remove(r0);
        this.size--;
        this.modification = snapshotStateList.getModification$runtime_release();
        return remove;
    }

    @Override // java.util.List
    public final void add(int r2, T t) {
        validateModification();
        int r0 = this.offset + r2;
        SnapshotStateList<T> snapshotStateList = this.parentList;
        snapshotStateList.add(r0, t);
        this.size++;
        this.modification = snapshotStateList.getModification$runtime_release();
    }
}
