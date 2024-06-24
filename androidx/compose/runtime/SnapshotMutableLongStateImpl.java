package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotLongState.kt */
/* loaded from: classes.dex */
public class SnapshotMutableLongStateImpl implements StateObject, MutableLongState, SnapshotMutableState<Long> {
    public LongStateStateRecord next;

    /* compiled from: SnapshotLongState.kt */
    /* loaded from: classes.dex */
    public static final class LongStateStateRecord extends StateRecord {
        public long value;

        public LongStateStateRecord(long j) {
            this.value = j;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = ((LongStateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create() {
            return new LongStateStateRecord(this.value);
        }
    }

    public SnapshotMutableLongStateImpl(long j) {
        this.next = new LongStateStateRecord(j);
    }

    @Override // androidx.compose.runtime.MutableState
    public final Long component1() {
        return Long.valueOf(getLongValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1<Long, Unit> component2() {
        return new Function1<Long, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableLongStateImpl$component2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Long l) {
                SnapshotMutableLongStateImpl.this.setLongValue(l.longValue());
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.MutableLongState
    public final long getLongValue() {
        return ((LongStateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final SnapshotMutationPolicy<Long> getPolicy() {
        return StructuralEqualityPolicy.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (((LongStateStateRecord) stateRecord2).value != ((LongStateStateRecord) stateRecord3).value) {
            return null;
        }
        return stateRecord2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (LongStateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.MutableLongState
    public final void setLongValue(long j) {
        Snapshot currentSnapshot;
        LongStateStateRecord longStateStateRecord = (LongStateStateRecord) SnapshotKt.current(this.next);
        if (longStateStateRecord.value != j) {
            LongStateStateRecord longStateStateRecord2 = this.next;
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                ((LongStateStateRecord) SnapshotKt.overwritableRecord(longStateStateRecord2, this, currentSnapshot, longStateStateRecord)).value = j;
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        }
    }

    public final String toString() {
        return "MutableLongState(value=" + ((LongStateStateRecord) SnapshotKt.current(this.next)).value + ")@" + hashCode();
    }
}
