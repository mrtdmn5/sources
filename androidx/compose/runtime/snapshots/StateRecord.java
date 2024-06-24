package androidx.compose.runtime.snapshots;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public abstract class StateRecord {
    public StateRecord next;
    public int snapshotId = SnapshotKt.currentSnapshot().getId();

    public abstract void assign(StateRecord stateRecord);

    public abstract StateRecord create();
}
