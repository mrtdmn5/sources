package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public boolean deactivated;
    public final MutableSnapshot parent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedMutableSnapshot(int r2, SnapshotIdSet invalid, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot parent) {
        super(r2, invalid, function1, function12);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
        parent.nestedActivated$runtime_release(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[Catch: all -> 0x00ff, TryCatch #1 {, blocks: (B:11:0x0020, B:13:0x0025, B:16:0x002a, B:21:0x0044, B:23:0x004c, B:24:0x005b, B:26:0x0063, B:27:0x0068, B:29:0x0089, B:30:0x009f, B:31:0x00ac, B:34:0x00b7, B:35:0x00b8, B:46:0x00cf, B:51:0x00e9, B:52:0x00da, B:57:0x00fd, B:58:0x00fe, B:59:0x009c, B:60:0x0050, B:61:0x0058, B:33:0x00ad), top: B:10:0x0020, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[Catch: all -> 0x00ff, TryCatch #1 {, blocks: (B:11:0x0020, B:13:0x0025, B:16:0x002a, B:21:0x0044, B:23:0x004c, B:24:0x005b, B:26:0x0063, B:27:0x0068, B:29:0x0089, B:30:0x009f, B:31:0x00ac, B:34:0x00b7, B:35:0x00b8, B:46:0x00cf, B:51:0x00e9, B:52:0x00da, B:57:0x00fd, B:58:0x00fe, B:59:0x009c, B:60:0x0050, B:61:0x0058, B:33:0x00ad), top: B:10:0x0020, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c A[Catch: all -> 0x00ff, TryCatch #1 {, blocks: (B:11:0x0020, B:13:0x0025, B:16:0x002a, B:21:0x0044, B:23:0x004c, B:24:0x005b, B:26:0x0063, B:27:0x0068, B:29:0x0089, B:30:0x009f, B:31:0x00ac, B:34:0x00b7, B:35:0x00b8, B:46:0x00cf, B:51:0x00e9, B:52:0x00da, B:57:0x00fd, B:58:0x00fe, B:59:0x009c, B:60:0x0050, B:61:0x0058, B:33:0x00ad), top: B:10:0x0020, inners: #0 }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        if (!this.disposed) {
            super.dispose();
            if (!this.deactivated) {
                this.deactivated = true;
                this.parent.nestedDeactivated$runtime_release(this);
            }
        }
    }
}
