package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    public final boolean mergeParentObservers;
    public final boolean ownsParentSnapshot;
    public final MutableSnapshot parentSnapshot;

    public TransparentObserverMutableSnapshot(MutableSnapshot mutableSnapshot, Function1<Object, Unit> function1, Function1<Object, Unit> function12, boolean z, boolean z2) {
        super(0, SnapshotIdSet.EMPTY, SnapshotKt.mergedReadObserver(z, function1, (mutableSnapshot == null || (r1 = mutableSnapshot.readObserver) == null) ? SnapshotKt.currentGlobalSnapshot.get().readObserver : r1), SnapshotKt.access$mergedWriteObserver(function12, (mutableSnapshot == null || (r1 = mutableSnapshot.writeObserver) == null) ? SnapshotKt.currentGlobalSnapshot.get().writeObserver : r1));
        Function1<Object, Unit> function13;
        Function1<Object, Unit> function14;
        this.parentSnapshot = mutableSnapshot;
        this.mergeParentObservers = z;
        this.ownsParentSnapshot = z2;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        MutableSnapshot mutableSnapshot;
        this.disposed = true;
        if (this.ownsParentSnapshot && (mutableSnapshot = this.parentSnapshot) != null) {
            mutableSnapshot.dispose();
        }
    }

    public final MutableSnapshot getCurrentSnapshot() {
        MutableSnapshot mutableSnapshot = this.parentSnapshot;
        if (mutableSnapshot == null) {
            GlobalSnapshot globalSnapshot = SnapshotKt.currentGlobalSnapshot.get();
            Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
            return globalSnapshot;
        }
        return mutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final IdentityArraySet<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final int getWriteCount$runtime_release() {
        return getCurrentSnapshot().getWriteCount$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        getCurrentSnapshot().recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void setId$runtime_release(int r1) {
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void setInvalid$runtime_release(SnapshotIdSet value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final void setModified(IdentityArraySet<StateObject> identityArraySet) {
        SnapshotStateMapKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void setWriteCount$runtime_release(int r2) {
        getCurrentSnapshot().setWriteCount$runtime_release(r2);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        Function1<Object, Unit> mergedReadObserver = SnapshotKt.mergedReadObserver(true, function1, this.readObserver);
        Function1<Object, Unit> access$mergedWriteObserver = SnapshotKt.access$mergedWriteObserver(function12, this.writeObserver);
        if (!this.mergeParentObservers) {
            return new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot(null, access$mergedWriteObserver), mergedReadObserver, access$mergedWriteObserver, false, true);
        }
        return getCurrentSnapshot().takeNestedMutableSnapshot(mergedReadObserver, access$mergedWriteObserver);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        Function1<Object, Unit> mergedReadObserver = SnapshotKt.mergedReadObserver(true, function1, this.readObserver);
        if (!this.mergeParentObservers) {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), mergedReadObserver, true);
        }
        return getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver);
    }
}
