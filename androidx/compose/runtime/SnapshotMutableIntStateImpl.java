package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotIntState.kt */
/* loaded from: classes.dex */
public class SnapshotMutableIntStateImpl implements StateObject, MutableIntState, SnapshotMutableState<Integer> {
    public IntStateStateRecord next;

    /* compiled from: SnapshotIntState.kt */
    /* loaded from: classes.dex */
    public static final class IntStateStateRecord extends StateRecord {
        public int value;

        public IntStateStateRecord(int r1) {
            this.value = r1;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = ((IntStateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create() {
            return new IntStateStateRecord(this.value);
        }
    }

    public SnapshotMutableIntStateImpl(int r2) {
        this.next = new IntStateStateRecord(r2);
    }

    @Override // androidx.compose.runtime.MutableState
    public final Integer component1() {
        return Integer.valueOf(getIntValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1<Integer, Unit> component2() {
        return new Function1<Integer, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableIntStateImpl$component2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                SnapshotMutableIntStateImpl.this.setIntValue(num.intValue());
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.MutableIntState
    public final int getIntValue() {
        return ((IntStateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final SnapshotMutationPolicy<Integer> getPolicy() {
        return StructuralEqualityPolicy.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (((IntStateStateRecord) stateRecord2).value != ((IntStateStateRecord) stateRecord3).value) {
            return null;
        }
        return stateRecord2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (IntStateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.MutableIntState
    public final void setIntValue(int r5) {
        Snapshot currentSnapshot;
        IntStateStateRecord intStateStateRecord = (IntStateStateRecord) SnapshotKt.current(this.next);
        if (intStateStateRecord.value != r5) {
            IntStateStateRecord intStateStateRecord2 = this.next;
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                ((IntStateStateRecord) SnapshotKt.overwritableRecord(intStateStateRecord2, this, currentSnapshot, intStateStateRecord)).value = r5;
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        }
    }

    public final String toString() {
        return "MutableIntState(value=" + ((IntStateStateRecord) SnapshotKt.current(this.next)).value + ")@" + hashCode();
    }
}
