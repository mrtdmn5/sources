package androidx.compose.runtime.snapshots;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public abstract class SnapshotApplyResult {

    /* compiled from: Snapshot.kt */
    /* loaded from: classes.dex */
    public static final class Failure extends SnapshotApplyResult {
        public Failure(Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        }
    }

    /* compiled from: Snapshot.kt */
    /* loaded from: classes.dex */
    public static final class Success extends SnapshotApplyResult {
        public static final Success INSTANCE = new Success();
    }
}
