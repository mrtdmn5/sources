package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotFloatState.kt */
/* loaded from: classes.dex */
public class SnapshotMutableFloatStateImpl implements StateObject, MutableFloatState, SnapshotMutableState<Float> {
    public FloatStateStateRecord next;

    /* compiled from: SnapshotFloatState.kt */
    /* loaded from: classes.dex */
    public static final class FloatStateStateRecord extends StateRecord {
        public float value;

        public FloatStateStateRecord(float f) {
            this.value = f;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = ((FloatStateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create() {
            return new FloatStateStateRecord(this.value);
        }
    }

    public SnapshotMutableFloatStateImpl(float f) {
        this.next = new FloatStateStateRecord(f);
    }

    @Override // androidx.compose.runtime.MutableState
    public final Float component1() {
        return Float.valueOf(getFloatValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1<Float, Unit> component2() {
        return new Function1<Float, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableFloatStateImpl$component2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f) {
                SnapshotMutableFloatStateImpl.this.setFloatValue(f.floatValue());
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.MutableFloatState
    public final float getFloatValue() {
        return ((FloatStateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final SnapshotMutationPolicy<Float> getPolicy() {
        return StructuralEqualityPolicy.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        boolean z;
        if (((FloatStateStateRecord) stateRecord2).value == ((FloatStateStateRecord) stateRecord3).value) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return null;
        }
        return stateRecord2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (FloatStateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.MutableFloatState
    public final void setFloatValue(float f) {
        boolean z;
        Snapshot currentSnapshot;
        FloatStateStateRecord floatStateStateRecord = (FloatStateStateRecord) SnapshotKt.current(this.next);
        if (floatStateStateRecord.value == f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            FloatStateStateRecord floatStateStateRecord2 = this.next;
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                ((FloatStateStateRecord) SnapshotKt.overwritableRecord(floatStateStateRecord2, this, currentSnapshot, floatStateStateRecord)).value = f;
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        }
    }

    public final String toString() {
        return "MutableFloatState(value=" + ((FloatStateStateRecord) SnapshotKt.current(this.next)).value + ")@" + hashCode();
    }
}
