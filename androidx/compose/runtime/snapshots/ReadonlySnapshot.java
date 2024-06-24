package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class ReadonlySnapshot extends Snapshot {
    public final Function1<Object, Unit> readObserver;
    public int snapshots;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadonlySnapshot(int r2, SnapshotIdSet invalid, Function1<Object, Unit> function1) {
        super(r2, invalid);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        this.readObserver = function1;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        if (!this.disposed) {
            nestedDeactivated$runtime_release(this);
            super.dispose();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final boolean getReadOnly() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Function1<Object, Unit> getWriteObserver$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int r2 = this.snapshots - 1;
        this.snapshots = r2;
        if (r2 == 0) {
            closeAndReleasePinning$runtime_release();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SnapshotKt$emptyLambda$1 snapshotKt$emptyLambda$1 = SnapshotKt.emptyLambda;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        SnapshotKt.access$validateOpen(this);
        return new NestedReadonlySnapshot(this.id, this.invalid, function1, this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void notifyObjectsInitialized$runtime_release() {
    }
}
