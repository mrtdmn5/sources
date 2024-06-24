package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SnapshotThreadLocal;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public abstract class Snapshot {
    public boolean disposed;
    public int id;
    public SnapshotIdSet invalid;
    public int pinningTrackingHandle;

    /* compiled from: Snapshot.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static Object observe(Function1 function1, Function0 block) {
            MutableSnapshot mutableSnapshot;
            Snapshot transparentObserverMutableSnapshot;
            Intrinsics.checkNotNullParameter(block, "block");
            if (function1 == null) {
                return block.invoke();
            }
            Snapshot snapshot = SnapshotKt.threadSnapshot.get();
            if (snapshot != null && !(snapshot instanceof MutableSnapshot)) {
                if (function1 == null) {
                    return block.invoke();
                }
                transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(function1);
            } else {
                if (snapshot instanceof MutableSnapshot) {
                    mutableSnapshot = (MutableSnapshot) snapshot;
                } else {
                    mutableSnapshot = null;
                }
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(mutableSnapshot, function1, null, true, false);
            }
            try {
                Snapshot makeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                try {
                    return block.invoke();
                } finally {
                    Snapshot.restoreCurrent(makeCurrent);
                }
            } finally {
                transparentObserverMutableSnapshot.dispose();
            }
        }
    }

    public Snapshot(int r7, SnapshotIdSet snapshotIdSet) {
        int r72;
        int access$lowestBitOf;
        this.invalid = snapshotIdSet;
        this.id = r7;
        if (r7 != 0) {
            SnapshotIdSet invalid = getInvalid$runtime_release();
            SnapshotKt$emptyLambda$1 snapshotKt$emptyLambda$1 = SnapshotKt.emptyLambda;
            Intrinsics.checkNotNullParameter(invalid, "invalid");
            int[] r0 = invalid.belowBound;
            if (r0 != null) {
                r7 = r0[0];
            } else {
                long j = invalid.lowerSet;
                int r5 = invalid.lowerBound;
                if (j != 0) {
                    access$lowestBitOf = SnapshotIdSetKt.access$lowestBitOf(j);
                } else {
                    long j2 = invalid.upperSet;
                    if (j2 != 0) {
                        r5 += 64;
                        access$lowestBitOf = SnapshotIdSetKt.access$lowestBitOf(j2);
                    }
                }
                r7 = access$lowestBitOf + r5;
            }
            synchronized (SnapshotKt.lock) {
                r72 = SnapshotKt.pinningTable.add(r7);
            }
        } else {
            r72 = -1;
        }
        this.pinningTrackingHandle = r72;
    }

    public static void restoreCurrent(Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final void closeAndReleasePinning$runtime_release() {
        synchronized (SnapshotKt.lock) {
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId());
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.lock) {
            int r1 = this.pinningTrackingHandle;
            if (r1 >= 0) {
                SnapshotKt.releasePinningLocked(r1);
                this.pinningTrackingHandle = -1;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public int getId() {
        return this.id;
    }

    public SnapshotIdSet getInvalid$runtime_release() {
        return this.invalid;
    }

    public abstract Function1<Object, Unit> getReadObserver$runtime_release();

    public abstract boolean getReadOnly();

    public int getWriteCount$runtime_release() {
        return 0;
    }

    public abstract Function1<Object, Unit> getWriteObserver$runtime_release();

    public final Snapshot makeCurrent() {
        SnapshotThreadLocal<Snapshot> snapshotThreadLocal = SnapshotKt.threadSnapshot;
        Snapshot snapshot = snapshotThreadLocal.get();
        snapshotThreadLocal.set(this);
        return snapshot;
    }

    public abstract void nestedActivated$runtime_release(Snapshot snapshot);

    public abstract void nestedDeactivated$runtime_release(Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    public abstract void recordModified$runtime_release(StateObject stateObject);

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        int r0 = this.pinningTrackingHandle;
        if (r0 >= 0) {
            SnapshotKt.releasePinningLocked(r0);
            this.pinningTrackingHandle = -1;
        }
    }

    public void setId$runtime_release(int r1) {
        this.id = r1;
    }

    public void setInvalid$runtime_release(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.invalid = snapshotIdSet;
    }

    public void setWriteCount$runtime_release(int r2) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }

    public abstract Snapshot takeNestedSnapshot(Function1<Object, Unit> function1);
}
