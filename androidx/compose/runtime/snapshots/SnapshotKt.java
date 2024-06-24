package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class SnapshotKt {
    public static final ArrayList applyObservers;
    public static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    public static final SnapshotWeakSet<StateObject> extraStateObjects;
    public static final ArrayList globalWriteObservers;
    public static int nextSnapshotId;
    public static SnapshotIdSet openSnapshots;
    public static final AtomicInt pendingApplyObserverCount;
    public static final SnapshotDoubleIndexHeap pinningTable;
    public static final Snapshot snapshotInitializer;
    public static final SnapshotKt$emptyLambda$1 emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;
    public static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();
    public static final Object lock = new Object();

    static {
        SnapshotIdSet snapshotIdSet = SnapshotIdSet.EMPTY;
        openSnapshots = snapshotIdSet;
        nextSnapshotId = 1;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet<>();
        applyObservers = new ArrayList();
        globalWriteObservers = new ArrayList();
        int r2 = nextSnapshotId;
        nextSnapshotId = r2 + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(r2, snapshotIdSet);
        openSnapshots = openSnapshots.set(globalSnapshot.id);
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        GlobalSnapshot globalSnapshot2 = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot2, "currentGlobalSnapshot.get()");
        snapshotInitializer = globalSnapshot2;
        pendingApplyObserverCount = new AtomicInt();
    }

    public static final Function1 access$mergedWriteObserver(final Function1 function1, final Function1 function12) {
        if (function1 != null && function12 != null && !Intrinsics.areEqual(function1, function12)) {
            return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object state) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    function1.invoke(state);
                    function12.invoke(state);
                    return Unit.INSTANCE;
                }
            };
        }
        if (function1 == null) {
            return function12;
        }
        return function1;
    }

    public static final HashMap access$optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord readable;
        IdentityArraySet<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet or = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.previousIds);
        Object[] objArr = modified$runtime_release.values;
        int r0 = modified$runtime_release.size;
        HashMap hashMap = null;
        for (int r4 = 0; r4 < r0; r4++) {
            Object obj = objArr[r4];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord readable2 = readable(firstStateRecord, id, snapshotIdSet);
            if (readable2 != null && (readable = readable(firstStateRecord, id, or)) != null && !Intrinsics.areEqual(readable2, readable)) {
                StateRecord readable3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                if (readable3 != null) {
                    StateRecord mergeRecords = stateObject.mergeRecords(readable, readable2, readable3);
                    if (mergeRecords == null) {
                        return null;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(readable2, mergeRecords);
                } else {
                    readError();
                    throw null;
                }
            }
        }
        return hashMap;
    }

    public static final void access$validateOpen(Snapshot snapshot) {
        if (openSnapshots.get(snapshot.getId())) {
        } else {
            throw new IllegalStateException("Snapshot is not open".toString());
        }
    }

    public static final SnapshotIdSet addRange(int r1, int r2, SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<this>");
        while (r1 < r2) {
            snapshotIdSet = snapshotIdSet.set(r1);
            r1++;
        }
        return snapshotIdSet;
    }

    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        GlobalSnapshot globalSnapshot;
        IdentityArraySet<StateObject> identityArraySet;
        T t;
        ArrayList mutableList;
        Snapshot snapshot = snapshotInitializer;
        Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        Object obj = lock;
        synchronized (obj) {
            globalSnapshot = currentGlobalSnapshot.get();
            Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
            identityArraySet = globalSnapshot.modified;
            if (identityArraySet != null) {
                pendingApplyObserverCount.delegate.addAndGet(1);
            }
            t = (T) takeNewGlobalSnapshot(globalSnapshot, function1);
        }
        if (identityArraySet != null) {
            try {
                synchronized (obj) {
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) applyObservers);
                }
                int size = mutableList.size();
                for (int r6 = 0; r6 < size; r6++) {
                    ((Function2) mutableList.get(r6)).invoke(identityArraySet, globalSnapshot);
                }
            } finally {
                pendingApplyObserverCount.delegate.addAndGet(-1);
            }
        }
        synchronized (lock) {
            checkAndOverwriteUnusedRecordsLocked();
            if (identityArraySet != null) {
                Object[] objArr = identityArraySet.values;
                int r2 = identityArraySet.size;
                for (int r3 = 0; r3 < r2; r3++) {
                    Object obj2 = objArr[r3];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    processForUnusedRecordsLocked((StateObject) obj2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return t;
    }

    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
        int r1 = snapshotWeakSet.size;
        int r3 = 0;
        int r4 = 0;
        while (true) {
            StateObject stateObject = null;
            if (r3 >= r1) {
                break;
            }
            WeakReference<StateObject> weakReference = snapshotWeakSet.values[r3];
            if (weakReference != null) {
                stateObject = weakReference.get();
            }
            if (stateObject != null && !(!overwriteUnusedRecordsLocked(stateObject))) {
                if (r4 != r3) {
                    snapshotWeakSet.values[r4] = weakReference;
                    int[] r5 = snapshotWeakSet.hashes;
                    r5[r4] = r5[r3];
                }
                r4++;
            }
            r3++;
        }
        for (int r32 = r4; r32 < r1; r32++) {
            snapshotWeakSet.values[r32] = null;
            snapshotWeakSet.hashes[r32] = 0;
        }
        if (r4 != r1) {
            snapshotWeakSet.size = r4;
        }
    }

    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1<Object, Unit> function1, boolean z) {
        MutableSnapshot mutableSnapshot;
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (!z2 && snapshot != null) {
            return new TransparentObserverSnapshot(snapshot, function1, z);
        }
        if (z2) {
            mutableSnapshot = (MutableSnapshot) snapshot;
        } else {
            mutableSnapshot = null;
        }
        return new TransparentObserverMutableSnapshot(mutableSnapshot, function1, null, false, z);
    }

    public static final <T extends StateRecord> T current(T r) {
        T t;
        Intrinsics.checkNotNullParameter(r, "r");
        Snapshot currentSnapshot = currentSnapshot();
        T t2 = (T) readable(r, currentSnapshot.getId(), currentSnapshot.getInvalid$runtime_release());
        if (t2 != null) {
            return t2;
        }
        synchronized (lock) {
            Snapshot currentSnapshot2 = currentSnapshot();
            t = (T) readable(r, currentSnapshot2.getId(), currentSnapshot2.getInvalid$runtime_release());
        }
        if (t != null) {
            return t;
        }
        readError();
        throw null;
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        if (snapshot == null) {
            GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
            Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
            return globalSnapshot;
        }
        return snapshot;
    }

    public static final Function1 mergedReadObserver(boolean z, final Function1 function1, final Function1 function12) {
        if (!z) {
            function12 = null;
        }
        if (function1 != null && function12 != null && !Intrinsics.areEqual(function1, function12)) {
            return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object state) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    function1.invoke(state);
                    function12.invoke(state);
                    return Unit.INSTANCE;
                }
            };
        }
        if (function1 == null) {
            return function12;
        }
        return function1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:            if (r5 == false) goto L75;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T newOverwritableRecordLocked(T r12, androidx.compose.runtime.snapshots.StateObject r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()
            int r1 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId
            androidx.compose.runtime.snapshots.SnapshotDoubleIndexHeap r2 = androidx.compose.runtime.snapshots.SnapshotKt.pinningTable
            int r3 = r2.size
            r4 = 0
            if (r3 <= 0) goto L1c
            int[] r1 = r2.values
            r1 = r1[r4]
        L1c:
            int r1 = r1 + (-1)
            r2 = 0
            r3 = r2
        L20:
            if (r0 == 0) goto L68
            int r5 = r0.snapshotId
            if (r5 != 0) goto L27
            goto L61
        L27:
            if (r5 == 0) goto L54
            if (r5 > r1) goto L54
            int r5 = r5 + 0
            r6 = 1
            r7 = 0
            r9 = 1
            r11 = 64
            if (r5 < 0) goto L42
            if (r5 >= r11) goto L42
            long r9 = r9 << r5
            long r9 = r9 & r7
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L40
        L3e:
            r5 = r6
            goto L51
        L40:
            r5 = r4
            goto L51
        L42:
            if (r5 < r11) goto L40
            r11 = 128(0x80, float:1.8E-43)
            if (r5 >= r11) goto L40
            int r5 = r5 + (-64)
            long r9 = r9 << r5
            long r9 = r9 & r7
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L40
            goto L3e
        L51:
            if (r5 != 0) goto L54
            goto L55
        L54:
            r6 = r4
        L55:
            if (r6 == 0) goto L65
            if (r3 != 0) goto L5b
            r3 = r0
            goto L65
        L5b:
            int r1 = r0.snapshotId
            int r2 = r3.snapshotId
            if (r1 >= r2) goto L63
        L61:
            r2 = r0
            goto L68
        L63:
            r2 = r3
            goto L68
        L65:
            androidx.compose.runtime.snapshots.StateRecord r0 = r0.next
            goto L20
        L68:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == 0) goto L70
            r2.snapshotId = r0
            goto L7f
        L70:
            androidx.compose.runtime.snapshots.StateRecord r2 = r12.create()
            r2.snapshotId = r0
            androidx.compose.runtime.snapshots.StateRecord r12 = r13.getFirstStateRecord()
            r2.next = r12
            r13.prependStateRecord(r2)
        L7f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked(androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateObject):androidx.compose.runtime.snapshots.StateRecord");
    }

    public static final <T extends StateRecord> T newWritableRecord(T t, StateObject state, Snapshot snapshot) {
        T t2;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        synchronized (lock) {
            t2 = (T) newOverwritableRecordLocked(t, state);
            t2.assign(t);
            t2.snapshotId = snapshot.getId();
        }
        return t2;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount$runtime_release() + 1);
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(state);
        }
    }

    public static final <T extends StateRecord> T overwritableRecord(T t, StateObject state, Snapshot snapshot, T t2) {
        T t3;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(state);
        }
        int id = snapshot.getId();
        if (t2.snapshotId == id) {
            return t2;
        }
        synchronized (lock) {
            t3 = (T) newOverwritableRecordLocked(t, state);
        }
        t3.snapshotId = id;
        snapshot.recordModified$runtime_release(state);
        return t3;
    }

    public static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        boolean z;
        int r1 = nextSnapshotId;
        SnapshotDoubleIndexHeap snapshotDoubleIndexHeap = pinningTable;
        if (snapshotDoubleIndexHeap.size > 0) {
            r1 = snapshotDoubleIndexHeap.values[0];
        }
        StateRecord stateRecord2 = null;
        StateRecord stateRecord3 = null;
        int r5 = 0;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.next) {
            int r7 = firstStateRecord.snapshotId;
            if (r7 != 0) {
                if (r7 < r1) {
                    if (stateRecord2 == null) {
                        r5++;
                        stateRecord2 = firstStateRecord;
                    } else {
                        if (r7 < stateRecord2.snapshotId) {
                            stateRecord = stateRecord2;
                            stateRecord2 = firstStateRecord;
                        } else {
                            stateRecord = firstStateRecord;
                        }
                        if (stateRecord3 == null) {
                            stateRecord3 = stateObject.getFirstStateRecord();
                            StateRecord stateRecord4 = stateRecord3;
                            while (true) {
                                if (stateRecord3 != null) {
                                    int r9 = stateRecord3.snapshotId;
                                    if (r9 >= r1) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        break;
                                    }
                                    if (stateRecord4.snapshotId < r9) {
                                        stateRecord4 = stateRecord3;
                                    }
                                    stateRecord3 = stateRecord3.next;
                                } else {
                                    stateRecord3 = stateRecord4;
                                    break;
                                }
                            }
                        }
                        stateRecord2.snapshotId = 0;
                        stateRecord2.assign(stateRecord3);
                        stateRecord2 = stateRecord;
                    }
                } else {
                    r5++;
                }
            }
        }
        if (r5 <= 1) {
            return false;
        }
        return true;
    }

    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        StateObject stateObject2;
        StateObject stateObject3;
        StateObject stateObject4;
        if (overwriteUnusedRecordsLocked(stateObject)) {
            SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
            snapshotWeakSet.getClass();
            int r1 = snapshotWeakSet.size;
            int identityHashCode = System.identityHashCode(stateObject);
            int r4 = -1;
            if (r1 > 0) {
                int r5 = snapshotWeakSet.size - 1;
                int r6 = 0;
                while (true) {
                    if (r6 <= r5) {
                        int r7 = (r6 + r5) >>> 1;
                        int r8 = snapshotWeakSet.hashes[r7];
                        if (r8 < identityHashCode) {
                            r6 = r7 + 1;
                        } else if (r8 > identityHashCode) {
                            r5 = r7 - 1;
                        } else {
                            WeakReference<StateObject> weakReference = snapshotWeakSet.values[r7];
                            if (weakReference != null) {
                                stateObject2 = weakReference.get();
                            } else {
                                stateObject2 = null;
                            }
                            if (stateObject == stateObject2) {
                                r4 = r7;
                            } else {
                                int r52 = r7 - 1;
                                while (-1 < r52 && snapshotWeakSet.hashes[r52] == identityHashCode) {
                                    WeakReference<StateObject> weakReference2 = snapshotWeakSet.values[r52];
                                    if (weakReference2 != null) {
                                        stateObject4 = weakReference2.get();
                                    } else {
                                        stateObject4 = null;
                                    }
                                    if (stateObject4 == stateObject) {
                                        break;
                                    } else {
                                        r52--;
                                    }
                                }
                                int r42 = snapshotWeakSet.size;
                                r52 = r7 + 1;
                                while (true) {
                                    if (r52 < r42) {
                                        if (snapshotWeakSet.hashes[r52] != identityHashCode) {
                                            break;
                                        }
                                        WeakReference<StateObject> weakReference3 = snapshotWeakSet.values[r52];
                                        if (weakReference3 != null) {
                                            stateObject3 = weakReference3.get();
                                        } else {
                                            stateObject3 = null;
                                        }
                                        if (stateObject3 == stateObject) {
                                            break;
                                        } else {
                                            r52++;
                                        }
                                    } else {
                                        r52 = snapshotWeakSet.size;
                                        break;
                                    }
                                }
                                r52 = -(r52 + 1);
                                r4 = r52;
                            }
                        }
                    } else {
                        r4 = -(r6 + 1);
                        break;
                    }
                }
                if (r4 >= 0) {
                    return;
                }
            }
            int r43 = -(r4 + 1);
            WeakReference<StateObject>[] weakReferenceArr = snapshotWeakSet.values;
            int length = weakReferenceArr.length;
            if (r1 == length) {
                int r62 = length * 2;
                WeakReference<T>[] weakReferenceArr2 = new WeakReference[r62];
                int[] r63 = new int[r62];
                int r82 = r43 + 1;
                ArraysKt___ArraysJvmKt.copyInto(r82, r43, r1, weakReferenceArr, weakReferenceArr2);
                ArraysKt___ArraysJvmKt.copyInto$default(snapshotWeakSet.values, weakReferenceArr2, 0, r43, 6);
                ArraysKt___ArraysJvmKt.copyInto(r82, r43, snapshotWeakSet.hashes, r63, r1);
                ArraysKt___ArraysJvmKt.copyInto$default(snapshotWeakSet.hashes, r63, 0, r43, 6);
                snapshotWeakSet.values = weakReferenceArr2;
                snapshotWeakSet.hashes = r63;
            } else {
                int r3 = r43 + 1;
                ArraysKt___ArraysJvmKt.copyInto(r3, r43, r1, weakReferenceArr, weakReferenceArr);
                int[] r53 = snapshotWeakSet.hashes;
                ArraysKt___ArraysJvmKt.copyInto(r3, r43, r53, r53, r1);
            }
            snapshotWeakSet.values[r43] = new WeakReference<>(stateObject);
            snapshotWeakSet.hashes[r43] = identityHashCode;
            snapshotWeakSet.size++;
        }
    }

    public static final void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    public static final <T extends StateRecord> T readable(T t, StateObject state) {
        T t2;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Snapshot currentSnapshot = currentSnapshot();
        Function1<Object, Unit> readObserver$runtime_release = currentSnapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(state);
        }
        T t3 = (T) readable(t, currentSnapshot.getId(), currentSnapshot.getInvalid$runtime_release());
        if (t3 != null) {
            return t3;
        }
        synchronized (lock) {
            Snapshot currentSnapshot2 = currentSnapshot();
            StateRecord firstStateRecord = state.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            t2 = (T) readable(firstStateRecord, currentSnapshot2.getId(), currentSnapshot2.getInvalid$runtime_release());
            if (t2 == null) {
                readError();
                throw null;
            }
        }
        return t2;
    }

    public static final void releasePinningLocked(int r8) {
        int r6;
        SnapshotDoubleIndexHeap snapshotDoubleIndexHeap = pinningTable;
        int r1 = snapshotDoubleIndexHeap.handles[r8];
        snapshotDoubleIndexHeap.swap(r1, snapshotDoubleIndexHeap.size - 1);
        snapshotDoubleIndexHeap.size--;
        int[] r2 = snapshotDoubleIndexHeap.values;
        int r3 = r2[r1];
        int r4 = r1;
        while (r4 > 0) {
            int r5 = ((r4 + 1) >> 1) - 1;
            if (r2[r5] <= r3) {
                break;
            }
            snapshotDoubleIndexHeap.swap(r5, r4);
            r4 = r5;
        }
        int[] r22 = snapshotDoubleIndexHeap.values;
        int r32 = snapshotDoubleIndexHeap.size >> 1;
        while (r1 < r32) {
            int r42 = (r1 + 1) << 1;
            int r52 = r42 - 1;
            if (r42 < snapshotDoubleIndexHeap.size && (r6 = r22[r42]) < r22[r52]) {
                if (r6 >= r22[r1]) {
                    break;
                }
                snapshotDoubleIndexHeap.swap(r42, r1);
                r1 = r42;
            } else {
                if (r22[r52] >= r22[r1]) {
                    break;
                }
                snapshotDoubleIndexHeap.swap(r52, r1);
                r1 = r52;
            }
        }
        snapshotDoubleIndexHeap.handles[r8] = snapshotDoubleIndexHeap.firstFreeHandle;
        snapshotDoubleIndexHeap.firstFreeHandle = r8;
    }

    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T invoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (lock) {
            int r1 = nextSnapshotId;
            nextSnapshotId = r1 + 1;
            SnapshotIdSet clear = openSnapshots.clear(snapshot.getId());
            openSnapshots = clear;
            currentGlobalSnapshot.set(new GlobalSnapshot(r1, clear));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(r1);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    public static final <T extends StateRecord> T writableRecord(T t, StateObject state, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(state);
        }
        T t2 = (T) readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t2 != null) {
            if (t2.snapshotId == snapshot.getId()) {
                return t2;
            }
            T t3 = (T) newWritableRecord(t2, state, snapshot);
            snapshot.recordModified$runtime_release(state);
            return t3;
        }
        readError();
        throw null;
    }

    public static final <T extends StateRecord> T current(T r, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(r, "r");
        T t = (T) readable(r, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t != null) {
            return t;
        }
        readError();
        throw null;
    }

    public static final <T extends StateRecord> T readable(T t, int r5, SnapshotIdSet snapshotIdSet) {
        T t2 = null;
        while (t != null) {
            int r2 = t.snapshotId;
            if (((r2 == 0 || r2 > r5 || snapshotIdSet.get(r2)) ? false : true) && (t2 == null || t2.snapshotId < t.snapshotId)) {
                t2 = t;
            }
            t = (T) t.next;
        }
        if (t2 != null) {
            return t2;
        }
        return null;
    }
}
