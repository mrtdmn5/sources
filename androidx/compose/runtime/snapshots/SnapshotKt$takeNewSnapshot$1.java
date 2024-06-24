package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class SnapshotKt$takeNewSnapshot$1 extends Lambda implements Function1<SnapshotIdSet, Object> {
    public final /* synthetic */ Function1<SnapshotIdSet, Object> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotKt$takeNewSnapshot$1(Function1<? super SnapshotIdSet, Object> function1) {
        super(1);
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet invalid = snapshotIdSet;
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        Snapshot snapshot = (Snapshot) this.$block.invoke(invalid);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getId());
            Unit unit = Unit.INSTANCE;
        }
        return snapshot;
    }
}
