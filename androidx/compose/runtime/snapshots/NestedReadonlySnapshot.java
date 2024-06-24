package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class NestedReadonlySnapshot extends Snapshot {
    public final Snapshot parent;
    public final Function1<Object, Unit> readObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedReadonlySnapshot(int r2, SnapshotIdSet invalid, final Function1<Object, Unit> function1, Snapshot parent) {
        super(r2, invalid);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
        parent.nestedActivated$runtime_release(this);
        if (function1 != null) {
            final Function1<Object, Unit> readObserver$runtime_release = parent.getReadObserver$runtime_release();
            if (readObserver$runtime_release != null) {
                function1 = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.NestedReadonlySnapshot$readObserver$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object state) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        function1.invoke(state);
                        readObserver$runtime_release.invoke(state);
                        return Unit.INSTANCE;
                    }
                };
            }
        } else {
            function1 = parent.getReadObserver$runtime_release();
        }
        this.readObserver = function1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        if (!this.disposed) {
            int r0 = this.id;
            Snapshot snapshot = this.parent;
            if (r0 != snapshot.getId()) {
                closeAndReleasePinning$runtime_release();
            }
            snapshot.nestedDeactivated$runtime_release(this);
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
    public final void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SnapshotKt$emptyLambda$1 snapshotKt$emptyLambda$1 = SnapshotKt.emptyLambda;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(Function1 function1) {
        return new NestedReadonlySnapshot(this.id, this.invalid, function1, this.parent);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void notifyObjectsInitialized$runtime_release() {
    }
}
