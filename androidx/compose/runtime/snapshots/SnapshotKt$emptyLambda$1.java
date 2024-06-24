package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class SnapshotKt$emptyLambda$1 extends Lambda implements Function1<SnapshotIdSet, Unit> {
    public static final SnapshotKt$emptyLambda$1 INSTANCE = new SnapshotKt$emptyLambda$1();

    public SnapshotKt$emptyLambda$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet it = snapshotIdSet;
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
