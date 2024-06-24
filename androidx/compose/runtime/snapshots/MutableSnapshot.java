package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    public static final int[] EmptyIntArray = new int[0];
    public boolean applied;
    public ArrayList merged;
    public IdentityArraySet<StateObject> modified;
    public SnapshotIdSet previousIds;
    public int[] previousPinnedSnapshots;
    public final Function1<Object, Unit> readObserver;
    public int snapshots;
    public int writeCount;
    public final Function1<Object, Unit> writeObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int r2, SnapshotIdSet invalid, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(r2, invalid);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.EMPTY;
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (!this.applied && !this.disposed) {
            int id = getId();
            synchronized (SnapshotKt.lock) {
                int r2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = r2 + 1;
                setId$runtime_release(r2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
            }
            setInvalid$runtime_release(SnapshotKt.addRange(id + 1, getId(), getInvalid$runtime_release()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0094 A[Catch: all -> 0x013e, TryCatch #1 {, blocks: (B:7:0x002d, B:9:0x0034, B:12:0x0039, B:17:0x0059, B:18:0x009c, B:68:0x006f, B:70:0x0088, B:75:0x0094), top: B:6:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (!this.disposed) {
            super.dispose();
            nestedDeactivated$runtime_release(this);
        }
    }

    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int r18, HashMap hashMap, SnapshotIdSet snapshotIdSet) {
        StateRecord readable;
        StateRecord mergeRecords;
        Pair pair;
        SnapshotIdSet invalidSnapshots = snapshotIdSet;
        Intrinsics.checkNotNullParameter(invalidSnapshots, "invalidSnapshots");
        SnapshotIdSet or = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        Object[] objArr = modified$runtime_release.values;
        int r6 = modified$runtime_release.size;
        int r9 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        while (r9 < r6) {
            Object obj = objArr[r9];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord readable2 = SnapshotKt.readable(firstStateRecord, r18, invalidSnapshots);
            if (readable2 != null && (readable = SnapshotKt.readable(firstStateRecord, getId(), or)) != null && !Intrinsics.areEqual(readable2, readable)) {
                StateRecord readable3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid$runtime_release());
                if (readable3 != null) {
                    if (hashMap == null || (mergeRecords = (StateRecord) hashMap.get(readable2)) == null) {
                        mergeRecords = stateObject.mergeRecords(readable, readable2, readable3);
                    }
                    if (mergeRecords == null) {
                        return new SnapshotApplyResult.Failure(this);
                    }
                    if (!Intrinsics.areEqual(mergeRecords, readable3)) {
                        if (Intrinsics.areEqual(mergeRecords, readable2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(new Pair(stateObject, readable2.create()));
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(stateObject);
                        } else {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            if (!Intrinsics.areEqual(mergeRecords, readable)) {
                                pair = new Pair(stateObject, mergeRecords);
                            } else {
                                pair = new Pair(stateObject, readable.create());
                            }
                            arrayList.add(pair);
                        }
                    }
                } else {
                    SnapshotKt.readError();
                    throw null;
                }
            }
            r9++;
            invalidSnapshots = snapshotIdSet;
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int r2 = 0; r2 < size; r2++) {
                Pair pair2 = (Pair) arrayList.get(r2);
                StateObject stateObject2 = (StateObject) pair2.first;
                StateRecord stateRecord = (StateRecord) pair2.second;
                stateRecord.snapshotId = getId();
                synchronized (SnapshotKt.lock) {
                    stateRecord.next = stateObject2.getFirstStateRecord();
                    stateObject2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int r7 = 0; r7 < size2; r7++) {
                modified$runtime_release.remove((StateObject) arrayList2.get(r7));
            }
            ArrayList arrayList3 = this.merged;
            if (arrayList3 != null) {
                arrayList2 = CollectionsKt___CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayList3);
            }
            this.merged = arrayList2;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedDeactivated$runtime_release(Snapshot snapshot) {
        boolean z;
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int r8 = this.snapshots;
        if (r8 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r82 = r8 - 1;
            this.snapshots = r82;
            if (r82 == 0 && !this.applied) {
                IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
                if (modified$runtime_release != null) {
                    if (true ^ this.applied) {
                        setModified(null);
                        int id = getId();
                        Object[] objArr = modified$runtime_release.values;
                        int r83 = modified$runtime_release.size;
                        for (int r3 = 0; r3 < r83; r3++) {
                            Object obj = objArr[r3];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            for (StateRecord firstStateRecord = ((StateObject) obj).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.next) {
                                int r5 = firstStateRecord.snapshotId;
                                if (r5 == id || CollectionsKt___CollectionsKt.contains(this.previousIds, Integer.valueOf(r5))) {
                                    firstStateRecord.snapshotId = 0;
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
                    }
                }
                closeAndReleasePinning$runtime_release();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (!this.applied && !this.disposed) {
            advance$runtime_release();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = new IdentityArraySet<>();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    public final void recordPrevious$runtime_release(int r3) {
        synchronized (SnapshotKt.lock) {
            this.previousIds = this.previousIds.set(r3);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        int length = this.previousPinnedSnapshots.length;
        for (int r1 = 0; r1 < length; r1++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[r1]);
        }
        int r0 = this.pinningTrackingHandle;
        if (r0 >= 0) {
            SnapshotKt.releasePinningLocked(r0);
            this.pinningTrackingHandle = -1;
        }
    }

    public void setModified(IdentityArraySet<StateObject> identityArraySet) {
        this.modified = identityArraySet;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int r1) {
        this.writeCount = r1;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        NestedMutableSnapshot nestedMutableSnapshot;
        if (!this.disposed) {
            validateNotAppliedOrPinned();
            recordPrevious$runtime_release(getId());
            Object obj = SnapshotKt.lock;
            synchronized (obj) {
                int r3 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = r3 + 1;
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(r3);
                SnapshotIdSet invalid$runtime_release = getInvalid$runtime_release();
                setInvalid$runtime_release(invalid$runtime_release.set(r3));
                nestedMutableSnapshot = new NestedMutableSnapshot(r3, SnapshotKt.addRange(getId() + 1, r3, invalid$runtime_release), SnapshotKt.mergedReadObserver(true, function1, this.readObserver), SnapshotKt.access$mergedWriteObserver(function12, this.writeObserver), this);
            }
            if (!this.applied && !this.disposed) {
                int id = getId();
                synchronized (obj) {
                    int r11 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = r11 + 1;
                    setId$runtime_release(r11);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    Unit unit = Unit.INSTANCE;
                }
                setInvalid$runtime_release(SnapshotKt.addRange(id + 1, getId(), getInvalid$runtime_release()));
            }
            return nestedMutableSnapshot;
        }
        throw new IllegalArgumentException("Cannot use a disposed snapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        if (!this.disposed) {
            validateNotAppliedOrPinned();
            int id = getId();
            recordPrevious$runtime_release(getId());
            Object obj = SnapshotKt.lock;
            synchronized (obj) {
                int r2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = r2 + 1;
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(r2);
                nestedReadonlySnapshot = new NestedReadonlySnapshot(r2, SnapshotKt.addRange(id + 1, r2, getInvalid$runtime_release()), function1, this);
            }
            if (!this.applied && !this.disposed) {
                int id2 = getId();
                synchronized (obj) {
                    int r0 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = r0 + 1;
                    setId$runtime_release(r0);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    Unit unit = Unit.INSTANCE;
                }
                setInvalid$runtime_release(SnapshotKt.addRange(id2 + 1, getId(), getInvalid$runtime_release()));
            }
            return nestedReadonlySnapshot;
        }
        throw new IllegalArgumentException("Cannot use a disposed snapshot".toString());
    }

    public final void validateNotAppliedOrPinned() {
        boolean z;
        boolean z2 = true;
        if (this.applied) {
            if (this.pinningTrackingHandle >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                z2 = false;
            }
        }
        if (z2) {
        } else {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }
}
