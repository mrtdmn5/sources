package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.node.OwnerSnapshotObserver$clearInvalidObservations$1;
import com.google.common.collect.Platform;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: SnapshotStateObserver.kt */
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    public Snapshot$Companion$registerApplyObserver$2 applyUnsubscribe;
    public ObservedScopeMap currentMap;
    public boolean isPaused;
    public final Function1<Function0<Unit>, Unit> onChangedExecutor;
    public boolean sendingNotifications;
    public final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    public final SnapshotStateObserver$applyObserver$1 applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            final SnapshotStateObserver snapshotStateObserver;
            boolean z;
            List plus;
            Set<? extends Object> applied = set;
            Intrinsics.checkNotNullParameter(applied, "applied");
            Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
            do {
                snapshotStateObserver = SnapshotStateObserver.this;
                AtomicReference<Object> atomicReference = snapshotStateObserver.pendingChanges;
                Object obj = atomicReference.get();
                z = true;
                if (obj == null) {
                    plus = applied;
                } else if (obj instanceof Set) {
                    plus = CollectionsKt__CollectionsKt.listOf((Object[]) new Set[]{obj, applied});
                } else if (obj instanceof List) {
                    plus = CollectionsKt___CollectionsKt.plus((Iterable) CollectionsKt__CollectionsKt.listOf(applied), (Collection) obj);
                } else {
                    ComposerKt.composeRuntimeError("Unexpected notification");
                    throw null;
                }
                while (true) {
                    if (atomicReference.compareAndSet(obj, plus)) {
                        break;
                    }
                    if (atomicReference.get() != obj) {
                        z = false;
                        break;
                    }
                }
            } while (!z);
            if (SnapshotStateObserver.access$drainChanges(snapshotStateObserver)) {
                snapshotStateObserver.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        do {
                            SnapshotStateObserver snapshotStateObserver2 = SnapshotStateObserver.this;
                            synchronized (snapshotStateObserver2.observedScopeMaps) {
                                if (!snapshotStateObserver2.sendingNotifications) {
                                    snapshotStateObserver2.sendingNotifications = true;
                                    try {
                                        MutableVector<SnapshotStateObserver.ObservedScopeMap> mutableVector = snapshotStateObserver2.observedScopeMaps;
                                        int r4 = mutableVector.size;
                                        if (r4 > 0) {
                                            SnapshotStateObserver.ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                                            int r5 = 0;
                                            do {
                                                SnapshotStateObserver.ObservedScopeMap observedScopeMap = observedScopeMapArr[r5];
                                                IdentityArraySet<Object> identityArraySet = observedScopeMap.invalidated;
                                                Object[] objArr = identityArraySet.values;
                                                int r9 = identityArraySet.size;
                                                for (int r10 = 0; r10 < r9; r10++) {
                                                    Object obj2 = objArr[r10];
                                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                                    observedScopeMap.onChanged.invoke(obj2);
                                                }
                                                identityArraySet.clear();
                                                r5++;
                                            } while (r5 < r4);
                                        }
                                        snapshotStateObserver2.sendingNotifications = false;
                                    } finally {
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        } while (SnapshotStateObserver.access$drainChanges(SnapshotStateObserver.this));
                        return Unit.INSTANCE;
                    }
                });
            }
            return Unit.INSTANCE;
        }
    };
    public final SnapshotStateObserver$readObserver$1 readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object state) {
            Intrinsics.checkNotNullParameter(state, "state");
            SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
            if (!snapshotStateObserver.isPaused) {
                synchronized (snapshotStateObserver.observedScopeMaps) {
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                    Intrinsics.checkNotNull(observedScopeMap);
                    Object obj = observedScopeMap.currentScope;
                    Intrinsics.checkNotNull(obj);
                    int r3 = observedScopeMap.currentToken;
                    IdentityArrayIntMap identityArrayIntMap = observedScopeMap.currentScopeReads;
                    if (identityArrayIntMap == null) {
                        identityArrayIntMap = new IdentityArrayIntMap();
                        observedScopeMap.currentScopeReads = identityArrayIntMap;
                        observedScopeMap.scopeToValues.set(obj, identityArrayIntMap);
                        Unit unit = Unit.INSTANCE;
                    }
                    observedScopeMap.recordRead(state, r3, obj, identityArrayIntMap);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
    };
    public final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16]);

    /* compiled from: SnapshotStateObserver.kt */
    /* loaded from: classes.dex */
    public static final class ObservedScopeMap {
        public Object currentScope;
        public IdentityArrayIntMap currentScopeReads;
        public int currentToken;
        public final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates;
        public int deriveStateScopeCount;
        public final SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1 derivedStateObserver;
        public final IdentityArraySet<Object> invalidated;
        public final Function1<Object, Unit> onChanged;
        public final HashMap<DerivedState<?>, Object> recordedDerivedStateValues;
        public final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues;
        public final MutableVector<DerivedState<?>> statesToReread;
        public final IdentityScopeMap<Object> valueToScopes;

        /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1] */
        public ObservedScopeMap(Function1<Object, Unit> onChanged) {
            Intrinsics.checkNotNullParameter(onChanged, "onChanged");
            this.onChanged = onChanged;
            this.currentToken = -1;
            this.valueToScopes = new IdentityScopeMap<>();
            this.scopeToValues = new IdentityArrayMap<>();
            this.invalidated = new IdentityArraySet<>();
            this.statesToReread = new MutableVector<>(new DerivedState[16]);
            this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
                @Override // androidx.compose.runtime.DerivedStateObserver
                public final void done(DerivedState<?> derivedState) {
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                    observedScopeMap.deriveStateScopeCount--;
                }

                @Override // androidx.compose.runtime.DerivedStateObserver
                public final void start(DerivedState<?> derivedState) {
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    SnapshotStateObserver.ObservedScopeMap.this.deriveStateScopeCount++;
                }
            };
            this.dependencyToDerivedStates = new IdentityScopeMap<>();
            this.recordedDerivedStateValues = new HashMap<>();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void observe(Object scope, SnapshotStateObserver$readObserver$1 readObserver, Function0 block) {
            boolean z;
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(readObserver, "readObserver");
            Intrinsics.checkNotNullParameter(block, "block");
            Object obj = this.currentScope;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            int r6 = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1 snapshotStateObserver$ObservedScopeMap$derivedStateObserver$1 = this.derivedStateObserver;
            MutableVector derivedStateObservers = Platform.derivedStateObservers();
            boolean z2 = true;
            try {
                derivedStateObservers.add(snapshotStateObserver$ObservedScopeMap$derivedStateObserver$1);
                Snapshot.Companion.observe(readObserver, block);
                derivedStateObservers.removeAt(derivedStateObservers.size - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                int r3 = this.currentToken;
                IdentityArrayIntMap identityArrayIntMap2 = this.currentScopeReads;
                if (identityArrayIntMap2 != null) {
                    Object[] objArr = identityArrayIntMap2.keys;
                    int[] r9 = identityArrayIntMap2.values;
                    int r10 = identityArrayIntMap2.size;
                    int r12 = 0;
                    int r13 = 0;
                    while (r12 < r10) {
                        Object obj3 = objArr[r12];
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Any");
                        int r15 = r9[r12];
                        if (r15 != r3) {
                            z = z2;
                        } else {
                            z = false;
                        }
                        if (z) {
                            IdentityScopeMap<Object> identityScopeMap = this.valueToScopes;
                            identityScopeMap.remove(obj3, obj2);
                            if ((obj3 instanceof DerivedState) && !identityScopeMap.contains(obj3)) {
                                this.dependencyToDerivedStates.removeScope(obj3);
                                this.recordedDerivedStateValues.remove(obj3);
                            }
                        }
                        if (!z) {
                            if (r13 != r12) {
                                objArr[r13] = obj3;
                                r9[r13] = r15;
                            }
                            r13++;
                        }
                        r12++;
                        z2 = true;
                    }
                    for (int r0 = r13; r0 < r10; r0++) {
                        objArr[r0] = null;
                    }
                    identityArrayIntMap2.size = r13;
                }
                this.currentScope = obj;
                this.currentScopeReads = identityArrayIntMap;
                this.currentToken = r6;
            } catch (Throwable th) {
                derivedStateObservers.removeAt(derivedStateObservers.size - 1);
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r17v0, types: [androidx.compose.runtime.SnapshotMutationPolicy] */
        public final boolean recordInvalidation(Set<? extends Object> set) {
            boolean z;
            int find;
            int find2;
            HashMap<DerivedState<?>, Object> hashMap = this.recordedDerivedStateValues;
            boolean z2 = set instanceof IdentityArraySet;
            StructuralEqualityPolicy structuralEqualityPolicy = StructuralEqualityPolicy.INSTANCE;
            MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.dependencyToDerivedStates;
            IdentityScopeMap<Object> identityScopeMap2 = this.valueToScopes;
            IdentityArraySet<Object> identityArraySet = this.invalidated;
            if (z2) {
                IdentityArraySet identityArraySet2 = (IdentityArraySet) set;
                Object[] objArr = identityArraySet2.values;
                int r1 = identityArraySet2.size;
                int r12 = 0;
                z = false;
                while (r12 < r1) {
                    Object obj = objArr[r12];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    if (identityScopeMap.contains(obj) && (find2 = identityScopeMap.find(obj)) >= 0) {
                        IdentityArraySet<DerivedState<?>> scopeSetAt = identityScopeMap.scopeSetAt(find2);
                        Object[] objArr2 = scopeSetAt.values;
                        int r15 = scopeSetAt.size;
                        int r6 = 0;
                        while (r6 < r15) {
                            int r20 = r1;
                            Object obj2 = objArr2[r6];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            DerivedState derivedState = (DerivedState) obj2;
                            Object[] objArr3 = objArr;
                            Object obj3 = hashMap.get(derivedState);
                            ?? policy = derivedState.getPolicy();
                            StructuralEqualityPolicy structuralEqualityPolicy2 = structuralEqualityPolicy;
                            if (policy != 0) {
                                structuralEqualityPolicy = policy;
                            }
                            Object[] objArr4 = objArr2;
                            if (!structuralEqualityPolicy.equivalent(derivedState.getCurrentRecord().result, obj3)) {
                                int find3 = identityScopeMap2.find(derivedState);
                                if (find3 >= 0) {
                                    IdentityArraySet<Object> scopeSetAt2 = identityScopeMap2.scopeSetAt(find3);
                                    Object[] objArr5 = scopeSetAt2.values;
                                    int r13 = scopeSetAt2.size;
                                    int r4 = 0;
                                    while (r4 < r13) {
                                        Object obj4 = objArr5[r4];
                                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                        identityArraySet.add(obj4);
                                        r4++;
                                        z = true;
                                    }
                                }
                            } else {
                                mutableVector.add(derivedState);
                            }
                            r6++;
                            r1 = r20;
                            objArr = objArr3;
                            objArr2 = objArr4;
                            structuralEqualityPolicy = structuralEqualityPolicy2;
                        }
                    }
                    int r202 = r1;
                    Object[] objArr6 = objArr;
                    StructuralEqualityPolicy structuralEqualityPolicy3 = structuralEqualityPolicy;
                    int find4 = identityScopeMap2.find(obj);
                    if (find4 >= 0) {
                        IdentityArraySet<Object> scopeSetAt3 = identityScopeMap2.scopeSetAt(find4);
                        Object[] objArr7 = scopeSetAt3.values;
                        int r14 = scopeSetAt3.size;
                        int r42 = 0;
                        while (r42 < r14) {
                            Object obj5 = objArr7[r42];
                            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            identityArraySet.add(obj5);
                            r42++;
                            z = true;
                        }
                    }
                    r12++;
                    r1 = r202;
                    objArr = objArr6;
                    structuralEqualityPolicy = structuralEqualityPolicy3;
                }
            } else {
                Iterator it = set.iterator();
                z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (identityScopeMap.contains(next) && (find = identityScopeMap.find(next)) >= 0) {
                        IdentityArraySet<DerivedState<?>> scopeSetAt4 = identityScopeMap.scopeSetAt(find);
                        Object[] objArr8 = scopeSetAt4.values;
                        int r43 = scopeSetAt4.size;
                        int r62 = 0;
                        while (r62 < r43) {
                            Object obj6 = objArr8[r62];
                            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            DerivedState derivedState2 = (DerivedState) obj6;
                            Object obj7 = hashMap.get(derivedState2);
                            SnapshotMutationPolicy policy2 = derivedState2.getPolicy();
                            Iterator it2 = it;
                            if (policy2 == null) {
                                policy2 = structuralEqualityPolicy;
                            }
                            if (!policy2.equivalent(derivedState2.getCurrentRecord().result, obj7)) {
                                int find5 = identityScopeMap2.find(derivedState2);
                                if (find5 >= 0) {
                                    IdentityArraySet<Object> scopeSetAt5 = identityScopeMap2.scopeSetAt(find5);
                                    Object[] objArr9 = scopeSetAt5.values;
                                    int r16 = scopeSetAt5.size;
                                    int r142 = 0;
                                    while (r142 < r16) {
                                        Object obj8 = objArr9[r142];
                                        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                        identityArraySet.add(obj8);
                                        r142++;
                                        z = true;
                                    }
                                }
                            } else {
                                mutableVector.add(derivedState2);
                            }
                            r62++;
                            it = it2;
                        }
                    }
                    Iterator it3 = it;
                    int find6 = identityScopeMap2.find(next);
                    if (find6 >= 0) {
                        IdentityArraySet<Object> scopeSetAt6 = identityScopeMap2.scopeSetAt(find6);
                        Object[] objArr10 = scopeSetAt6.values;
                        int r17 = scopeSetAt6.size;
                        int r44 = 0;
                        while (r44 < r17) {
                            Object obj9 = objArr10[r44];
                            Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            identityArraySet.add(obj9);
                            r44++;
                            z = true;
                        }
                    }
                    it = it3;
                }
            }
            if (mutableVector.isNotEmpty()) {
                int r18 = mutableVector.size;
                if (r18 > 0) {
                    DerivedState<?>[] derivedStateArr = mutableVector.content;
                    int r3 = 0;
                    do {
                        DerivedState<?> derivedState3 = derivedStateArr[r3];
                        Intrinsics.checkNotNullParameter(derivedState3, "derivedState");
                        int id = SnapshotKt.currentSnapshot().getId();
                        int find7 = identityScopeMap2.find(derivedState3);
                        if (find7 >= 0) {
                            IdentityArraySet<Object> scopeSetAt7 = identityScopeMap2.scopeSetAt(find7);
                            Object[] objArr11 = scopeSetAt7.values;
                            int r63 = scopeSetAt7.size;
                            for (int r11 = 0; r11 < r63; r11++) {
                                Object obj10 = objArr11[r11];
                                Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
                                IdentityArrayIntMap identityArrayIntMap = identityArrayMap.get(obj10);
                                if (identityArrayIntMap == null) {
                                    identityArrayIntMap = new IdentityArrayIntMap();
                                    identityArrayMap.set(obj10, identityArrayIntMap);
                                    Unit unit = Unit.INSTANCE;
                                }
                                recordRead(derivedState3, id, obj10, identityArrayIntMap);
                            }
                        }
                        r3++;
                    } while (r3 < r18);
                }
                mutableVector.clear();
            }
            return z;
        }

        public final void recordRead(Object obj, int r6, Object obj2, IdentityArrayIntMap identityArrayIntMap) {
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int add = identityArrayIntMap.add(r6, obj);
            if ((obj instanceof DerivedState) && add != r6) {
                DerivedSnapshotState.ResultRecord currentRecord = ((DerivedState) obj).getCurrentRecord();
                this.recordedDerivedStateValues.put(obj, currentRecord.result);
                Object[] dependencies = currentRecord.getDependencies();
                IdentityScopeMap<DerivedState<?>> identityScopeMap = this.dependencyToDerivedStates;
                identityScopeMap.removeScope(obj);
                for (Object obj3 : dependencies) {
                    if (obj3 == null) {
                        break;
                    }
                    identityScopeMap.add(obj3, obj);
                }
            }
            if (add == -1) {
                this.valueToScopes.add(obj, obj2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void removeScopeIf(OwnerSnapshotObserver$clearInvalidObservations$1 ownerSnapshotObserver$clearInvalidObservations$1) {
            IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
            int r1 = identityArrayMap.size;
            int r4 = 0;
            for (int r3 = 0; r3 < r1; r3++) {
                Object obj = identityArrayMap.keys[r3];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) identityArrayMap.values[r3];
                Boolean bool = (Boolean) ownerSnapshotObserver$clearInvalidObservations$1.invoke(obj);
                if (bool.booleanValue()) {
                    Object[] objArr = identityArrayIntMap.keys;
                    int[] r9 = identityArrayIntMap.values;
                    int r6 = identityArrayIntMap.size;
                    for (int r10 = 0; r10 < r6; r10++) {
                        Object obj2 = objArr[r10];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                        int r12 = r9[r10];
                        IdentityScopeMap<Object> identityScopeMap = this.valueToScopes;
                        identityScopeMap.remove(obj2, obj);
                        if ((obj2 instanceof DerivedState) && !identityScopeMap.contains(obj2)) {
                            this.dependencyToDerivedStates.removeScope(obj2);
                            this.recordedDerivedStateValues.remove(obj2);
                        }
                    }
                }
                if (!bool.booleanValue()) {
                    if (r4 != r3) {
                        identityArrayMap.keys[r4] = obj;
                        Object[] objArr2 = identityArrayMap.values;
                        objArr2[r4] = objArr2[r3];
                    }
                    r4++;
                }
            }
            int r15 = identityArrayMap.size;
            if (r15 > r4) {
                for (int r13 = r4; r13 < r15; r13++) {
                    identityArrayMap.keys[r13] = null;
                    identityArrayMap.values[r13] = null;
                }
                identityArrayMap.size = r4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1] */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$drainChanges(SnapshotStateObserver snapshotStateObserver) {
        boolean z;
        Set<? extends Object> set;
        byte b;
        synchronized (snapshotStateObserver.observedScopeMaps) {
            z = snapshotStateObserver.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            AtomicReference<Object> atomicReference = snapshotStateObserver.pendingChanges;
            Object obj = atomicReference.get();
            Set<? extends Object> set2 = null;
            r4 = null;
            Object subList = null;
            if (obj != null) {
                if (obj instanceof Set) {
                    set = (Set) obj;
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    set = (Set) list.get(0);
                    if (list.size() == 2) {
                        subList = list.get(1);
                    } else if (list.size() > 2) {
                        subList = list.subList(1, list.size());
                    }
                } else {
                    ComposerKt.composeRuntimeError("Unexpected notification");
                    throw null;
                }
                Object obj2 = subList;
                while (true) {
                    if (atomicReference.compareAndSet(obj, obj2)) {
                        b = true;
                        break;
                    }
                    if (atomicReference.get() != obj) {
                        b = false;
                        break;
                    }
                }
                if (b == true) {
                    set2 = set;
                } else {
                    continue;
                }
            }
            if (set2 == null) {
                return z2;
            }
            synchronized (snapshotStateObserver.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = snapshotStateObserver.observedScopeMaps;
                int r6 = mutableVector.size;
                if (r6 > 0) {
                    ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                    int r7 = 0;
                    do {
                        if (!observedScopeMapArr[r7].recordInvalidation(set2) && !z2) {
                            z2 = false;
                            r7++;
                        }
                        z2 = true;
                        r7++;
                    } while (r7 < r6);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int r2 = mutableVector.size;
            if (r2 > 0) {
                ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                int r4 = 0;
                do {
                    ObservedScopeMap observedScopeMap = observedScopeMapArr[r4];
                    observedScopeMap.valueToScopes.clear();
                    IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = observedScopeMap.scopeToValues;
                    identityArrayMap.size = 0;
                    ArraysKt___ArraysJvmKt.fill$default(identityArrayMap.keys, null);
                    ArraysKt___ArraysJvmKt.fill$default(identityArrayMap.values, null);
                    observedScopeMap.dependencyToDerivedStates.clear();
                    observedScopeMap.recordedDerivedStateValues.clear();
                    r4++;
                } while (r4 < r2);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap observedScopeMap;
        ObservedScopeMap observedScopeMap2;
        boolean z;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onValueChangedForScope, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int r2 = mutableVector.size;
            if (r2 > 0) {
                ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                int r6 = 0;
                do {
                    observedScopeMap = observedScopeMapArr[r6];
                    if (observedScopeMap.onChanged == onValueChangedForScope) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    } else {
                        r6++;
                    }
                } while (r6 < r2);
            }
            observedScopeMap = null;
            observedScopeMap2 = observedScopeMap;
            if (observedScopeMap2 == null) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, onValueChangedForScope);
                observedScopeMap2 = new ObservedScopeMap(onValueChangedForScope);
                mutableVector.add(observedScopeMap2);
            }
        }
        boolean z2 = this.isPaused;
        ObservedScopeMap observedScopeMap3 = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMap2;
            observedScopeMap2.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = observedScopeMap3;
            this.isPaused = z2;
        }
    }

    public final void start() {
        SnapshotStateObserver$applyObserver$1 observer = this.applyObserver;
        Intrinsics.checkNotNullParameter(observer, "observer");
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers.add(observer);
        }
        this.applyUnsubscribe = new Snapshot$Companion$registerApplyObserver$2(observer);
    }
}
