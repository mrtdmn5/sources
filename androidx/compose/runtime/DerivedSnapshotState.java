package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DerivedState.kt */
/* loaded from: classes.dex */
public final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    public final Function0<T> calculation;
    public ResultRecord<T> first;
    public final SnapshotMutationPolicy<T> policy;

    /* compiled from: DerivedState.kt */
    /* loaded from: classes.dex */
    public static final class ResultRecord<T> extends StateRecord {
        public static final Object Unset = new Object();
        public IdentityArrayMap<StateObject, Integer> _dependencies;
        public Object result = Unset;
        public int resultHash;
        public int validSnapshotId;
        public int validSnapshotWriteCount;

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord resultRecord = (ResultRecord) value;
            this._dependencies = resultRecord._dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create() {
            return new ResultRecord();
        }

        public final Object[] getDependencies() {
            Object[] objArr;
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this._dependencies;
            if (identityArrayMap == null || (objArr = identityArrayMap.keys) == null) {
                return new Object[0];
            }
            return objArr;
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Object obj = SnapshotKt.lock;
            synchronized (obj) {
                z = false;
                if (this.validSnapshotId == snapshot.getId()) {
                    if (this.validSnapshotWriteCount == snapshot.getWriteCount$runtime_release()) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (this.result != Unset && (!z2 || this.resultHash == readableHash(derivedState, snapshot))) {
                z = true;
            }
            if (z && z2) {
                synchronized (obj) {
                    this.validSnapshotId = snapshot.getId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return z;
        }

        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            IdentityArrayMap<StateObject, Integer> identityArrayMap;
            StateRecord current;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            synchronized (SnapshotKt.lock) {
                identityArrayMap = this._dependencies;
            }
            int r0 = 7;
            if (identityArrayMap != null) {
                MutableVector derivedStateObservers = Platform.derivedStateObservers();
                int r3 = derivedStateObservers.size;
                int r5 = 0;
                if (r3 > 0) {
                    T[] tArr = derivedStateObservers.content;
                    int r7 = 0;
                    do {
                        ((DerivedStateObserver) tArr[r7]).start(derivedState);
                        r7++;
                    } while (r7 < r3);
                }
                try {
                    int r32 = identityArrayMap.size;
                    for (int r6 = 0; r6 < r32; r6++) {
                        Object obj = identityArrayMap.keys[r6];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        StateObject stateObject = (StateObject) obj;
                        if (((Number) identityArrayMap.values[r6]).intValue() == 1) {
                            if (stateObject instanceof DerivedSnapshotState) {
                                DerivedSnapshotState derivedSnapshotState = (DerivedSnapshotState) stateObject;
                                current = derivedSnapshotState.currentRecord((ResultRecord) SnapshotKt.current(derivedSnapshotState.first, snapshot), snapshot, false, derivedSnapshotState.calculation);
                            } else {
                                current = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                            }
                            r0 = (((r0 * 31) + System.identityHashCode(current)) * 31) + current.snapshotId;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    int r12 = derivedStateObservers.size;
                    if (r12 > 0) {
                        T[] tArr2 = derivedStateObservers.content;
                        do {
                            ((DerivedStateObserver) tArr2[r5]).done(derivedState);
                            r5++;
                        } while (r5 < r12);
                    }
                } catch (Throwable th) {
                    int r02 = derivedStateObservers.size;
                    if (r02 > 0) {
                        T[] tArr3 = derivedStateObservers.content;
                        do {
                            ((DerivedStateObserver) tArr3[r5]).done(derivedState);
                            r5++;
                        } while (r5 < r02);
                    }
                    throw th;
                }
            }
            return r0;
        }
    }

    public DerivedSnapshotState(SnapshotMutationPolicy snapshotMutationPolicy, Function0 calculation) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        this.calculation = calculation;
        this.policy = snapshotMutationPolicy;
        this.first = new ResultRecord<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ResultRecord<T> currentRecord(ResultRecord<T> resultRecord, Snapshot snapshot, boolean z, Function0<? extends T> function0) {
        final int r11;
        int r0;
        int r1 = 1;
        int r2 = 0;
        if (resultRecord.isValid(this, snapshot)) {
            if (z) {
                MutableVector derivedStateObservers = Platform.derivedStateObservers();
                int r12 = derivedStateObservers.size;
                if (r12 > 0) {
                    T[] tArr = derivedStateObservers.content;
                    int r3 = 0;
                    do {
                        ((DerivedStateObserver) tArr[r3]).start(this);
                        r3++;
                    } while (r3 < r12);
                }
                try {
                    IdentityArrayMap<StateObject, Integer> identityArrayMap = resultRecord._dependencies;
                    Integer num = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                    if (num != null) {
                        r0 = num.intValue();
                    } else {
                        r0 = 0;
                    }
                    if (identityArrayMap != null) {
                        int r32 = identityArrayMap.size;
                        for (int r4 = 0; r4 < r32; r4++) {
                            Object obj = identityArrayMap.keys[r4];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                            StateObject stateObject = (StateObject) obj;
                            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(((Number) identityArrayMap.values[r4]).intValue() + r0));
                            Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                            if (readObserver$runtime_release != null) {
                                readObserver$runtime_release.invoke(stateObject);
                            }
                        }
                    }
                    SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(r0));
                    Unit unit = Unit.INSTANCE;
                    int r10 = derivedStateObservers.size;
                    if (r10 > 0) {
                        T[] tArr2 = derivedStateObservers.content;
                        do {
                            ((DerivedStateObserver) tArr2[r2]).done(this);
                            r2++;
                        } while (r2 < r10);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return resultRecord;
        }
        Integer num2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
        if (num2 != null) {
            r11 = num2.intValue();
        } else {
            r11 = 0;
        }
        final IdentityArrayMap<StateObject, Integer> identityArrayMap2 = new IdentityArrayMap<>();
        MutableVector derivedStateObservers2 = Platform.derivedStateObservers();
        int r42 = derivedStateObservers2.size;
        if (r42 > 0) {
            T[] tArr3 = derivedStateObservers2.content;
            int r6 = 0;
            do {
                ((DerivedStateObserver) tArr3[r6]).start(this);
                r6++;
            } while (r6 < r42);
        }
        try {
            SnapshotThreadLocal<Integer> snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
            snapshotThreadLocal.set(Integer.valueOf(r11 + 1));
            Object observe = Snapshot.Companion.observe(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1
                public final /* synthetic */ DerivedSnapshotState<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object it) {
                    int r22;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it != this.this$0) {
                        if (it instanceof StateObject) {
                            Integer num3 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                            Intrinsics.checkNotNull(num3);
                            int intValue = num3.intValue() - r11;
                            IdentityArrayMap<StateObject, Integer> identityArrayMap3 = identityArrayMap2;
                            Integer num4 = identityArrayMap3.get(it);
                            if (num4 != null) {
                                r22 = num4.intValue();
                            } else {
                                r22 = Integer.MAX_VALUE;
                            }
                            identityArrayMap3.set(it, Integer.valueOf(Math.min(intValue, r22)));
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("A derived state calculation cannot read itself".toString());
                }
            }, function0);
            snapshotThreadLocal.set(Integer.valueOf(r11));
            int r43 = derivedStateObservers2.size;
            if (r43 > 0) {
                T[] tArr4 = derivedStateObservers2.content;
                int r5 = 0;
                do {
                    ((DerivedStateObserver) tArr4[r5]).done(this);
                    r5++;
                } while (r5 < r43);
            }
            synchronized (SnapshotKt.lock) {
                Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
                Object obj2 = resultRecord.result;
                if (obj2 != ResultRecord.Unset) {
                    SnapshotMutationPolicy<T> snapshotMutationPolicy = this.policy;
                    if (snapshotMutationPolicy == 0 || !snapshotMutationPolicy.equivalent(observe, obj2)) {
                        r1 = 0;
                    }
                    if (r1 != 0) {
                        resultRecord._dependencies = identityArrayMap2;
                        resultRecord.resultHash = resultRecord.readableHash(this, currentSnapshot);
                        resultRecord.validSnapshotId = snapshot.getId();
                        resultRecord.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                    }
                }
                resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, currentSnapshot);
                resultRecord._dependencies = identityArrayMap2;
                resultRecord.resultHash = resultRecord.readableHash(this, currentSnapshot);
                resultRecord.validSnapshotId = snapshot.getId();
                resultRecord.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                resultRecord.result = observe;
            }
            if (r11 == 0) {
                SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
            }
            return resultRecord;
        } finally {
            int r102 = derivedStateObservers2.size;
            if (r102 > 0) {
                T[] tArr5 = derivedStateObservers2.content;
                do {
                    ((DerivedStateObserver) tArr5[r2]).done(this);
                    r2++;
                } while (r2 < r102);
            }
        }
    }

    @Override // androidx.compose.runtime.DerivedState
    public final ResultRecord getCurrentRecord() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), SnapshotKt.currentSnapshot(), false, this.calculation);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.DerivedState
    public final SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.State
    public final T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = SnapshotKt.currentSnapshot().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), SnapshotKt.currentSnapshot(), true, this.calculation).result;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.first = (ResultRecord) stateRecord;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("DerivedState(value=");
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, SnapshotKt.currentSnapshot())) {
            str = String.valueOf(resultRecord.result);
        } else {
            str = "<Not calculated>";
        }
        sb.append(str);
        sb.append(")@");
        sb.append(hashCode());
        return sb.toString();
    }
}
