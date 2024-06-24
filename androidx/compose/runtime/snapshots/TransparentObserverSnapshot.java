package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class TransparentObserverSnapshot extends Snapshot {
    public final boolean mergeParentObservers;
    public final boolean ownsPreviousSnapshot;
    public final Snapshot previousSnapshot;
    public final Function1<Object, Unit> readObserver;

    public TransparentObserverSnapshot(Snapshot snapshot, Function1 function1, boolean z) {
        super(0, SnapshotIdSet.EMPTY);
        Function1<Object, Unit> readObserver$runtime_release;
        this.previousSnapshot = snapshot;
        this.mergeParentObservers = false;
        this.ownsPreviousSnapshot = z;
        this.readObserver = SnapshotKt.mergedReadObserver(false, function1, (snapshot == null || (readObserver$runtime_release = snapshot.getReadObserver$runtime_release()) == null) ? SnapshotKt.currentGlobalSnapshot.get().readObserver : readObserver$runtime_release);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        Snapshot snapshot;
        this.disposed = true;
        if (this.ownsPreviousSnapshot && (snapshot = this.previousSnapshot) != null) {
            snapshot.dispose();
        }
    }

    public final Snapshot getCurrentSnapshot() {
        Snapshot snapshot = this.previousSnapshot;
        if (snapshot == null) {
            GlobalSnapshot globalSnapshot = SnapshotKt.currentGlobalSnapshot.get();
            Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
            return globalSnapshot;
        }
        return snapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Function1<Object, Unit> getWriteObserver$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        getCurrentSnapshot().recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        Function1<Object, Unit> mergedReadObserver = SnapshotKt.mergedReadObserver(true, function1, this.readObserver);
        if (!this.mergeParentObservers) {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), mergedReadObserver, true);
        }
        return getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver);
    }
}
