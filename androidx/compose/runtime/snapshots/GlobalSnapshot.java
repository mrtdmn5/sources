package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class GlobalSnapshot extends MutableSnapshot {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GlobalSnapshot(int r5, androidx.compose.runtime.snapshots.SnapshotIdSet r6) {
        /*
            r4 = this;
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.lock
            monitor-enter(r0)
            java.util.ArrayList r1 = androidx.compose.runtime.snapshots.SnapshotKt.globalWriteObservers     // Catch: java.lang.Throwable -> L2a
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L2a
            r2 = r2 ^ 1
            r3 = 0
            if (r2 == 0) goto L13
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r1)     // Catch: java.lang.Throwable -> L2a
            goto L14
        L13:
            r1 = r3
        L14:
            if (r1 == 0) goto L24
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.singleOrNull(r1)     // Catch: java.lang.Throwable -> L2a
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Throwable -> L2a
            if (r2 != 0) goto L25
            androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1 r2 = new androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L25
        L24:
            r2 = r3
        L25:
            monitor-exit(r0)
            r4.<init>(r5, r6, r3, r2)
            return
        L2a:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.GlobalSnapshot.<init>(int, androidx.compose.runtime.snapshots.SnapshotIdSet):void");
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final SnapshotApplyResult apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        synchronized (SnapshotKt.lock) {
            int r1 = this.pinningTrackingHandle;
            if (r1 >= 0) {
                SnapshotKt.releasePinningLocked(r1);
                this.pinningTrackingHandle = -1;
            }
            Unit unit = Unit.INSTANCE;
        }
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
        SnapshotKt.advanceGlobalSnapshot(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SnapshotIdSet snapshotIdSet) {
                SnapshotIdSet it = snapshotIdSet;
                Intrinsics.checkNotNullParameter(it, "it");
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final MutableSnapshot takeNestedMutableSnapshot(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12) {
        Function1<SnapshotIdSet, MutableSnapshot> function13 = new Function1<SnapshotIdSet, MutableSnapshot>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MutableSnapshot invoke(SnapshotIdSet snapshotIdSet) {
                int r1;
                SnapshotIdSet invalid = snapshotIdSet;
                Intrinsics.checkNotNullParameter(invalid, "invalid");
                synchronized (SnapshotKt.lock) {
                    r1 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = r1 + 1;
                }
                return new MutableSnapshot(r1, invalid, function1, function12);
            }
        };
        SnapshotKt$emptyLambda$1 snapshotKt$emptyLambda$1 = SnapshotKt.emptyLambda;
        return (MutableSnapshot) ((Snapshot) SnapshotKt.advanceGlobalSnapshot(new SnapshotKt$takeNewSnapshot$1(function13)));
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(final Function1<Object, Unit> function1) {
        Function1<SnapshotIdSet, ReadonlySnapshot> function12 = new Function1<SnapshotIdSet, ReadonlySnapshot>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ReadonlySnapshot invoke(SnapshotIdSet snapshotIdSet) {
                int r1;
                SnapshotIdSet invalid = snapshotIdSet;
                Intrinsics.checkNotNullParameter(invalid, "invalid");
                synchronized (SnapshotKt.lock) {
                    r1 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = r1 + 1;
                }
                return new ReadonlySnapshot(r1, invalid, function1);
            }
        };
        SnapshotKt$emptyLambda$1 snapshotKt$emptyLambda$1 = SnapshotKt.emptyLambda;
        return (Snapshot) SnapshotKt.advanceGlobalSnapshot(new SnapshotKt$takeNewSnapshot$1(function12));
    }
}
