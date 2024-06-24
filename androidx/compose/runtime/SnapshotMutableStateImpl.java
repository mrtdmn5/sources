package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotState.kt */
/* loaded from: classes.dex */
public class SnapshotMutableStateImpl<T> implements StateObject, SnapshotMutableState<T> {
    public StateStateRecord<T> next;
    public final SnapshotMutationPolicy<T> policy;

    /* compiled from: SnapshotState.kt */
    /* loaded from: classes.dex */
    public static final class StateStateRecord<T> extends StateRecord {
        public T value;

        public StateStateRecord(T t) {
            this.value = t;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = ((StateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create() {
            return new StateStateRecord(this.value);
        }
    }

    public SnapshotMutableStateImpl(T t, SnapshotMutationPolicy<T> policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.policy = policy;
        this.next = new StateStateRecord<>(t);
    }

    @Override // androidx.compose.runtime.MutableState
    public final T component1() {
        return getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1<T, Unit> component2() {
        return new Function1<T, Unit>(this) { // from class: androidx.compose.runtime.SnapshotMutableStateImpl$component2$1
            public final /* synthetic */ SnapshotMutableStateImpl<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                this.this$0.setValue(obj);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.State
    public final T getValue() {
        return ((StateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (!this.policy.equivalent(((StateStateRecord) stateRecord2).value, ((StateStateRecord) stateRecord3).value)) {
            return null;
        }
        return stateRecord2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (StateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(T t) {
        Snapshot currentSnapshot;
        StateStateRecord stateStateRecord = (StateStateRecord) SnapshotKt.current(this.next);
        if (!this.policy.equivalent(stateStateRecord.value, t)) {
            StateStateRecord<T> stateStateRecord2 = this.next;
            synchronized (SnapshotKt.lock) {
                currentSnapshot = SnapshotKt.currentSnapshot();
                ((StateStateRecord) SnapshotKt.overwritableRecord(stateStateRecord2, this, currentSnapshot, stateStateRecord)).value = t;
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.notifyWrite(currentSnapshot, this);
        }
    }

    public final String toString() {
        return "MutableState(value=" + ((StateStateRecord) SnapshotKt.current(this.next)).value + ")@" + hashCode();
    }
}
