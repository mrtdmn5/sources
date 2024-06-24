package androidx.compose.runtime.snapshots;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public interface StateObject {
    StateRecord getFirstStateRecord();

    default StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return null;
    }

    void prependStateRecord(StateRecord stateRecord);
}
