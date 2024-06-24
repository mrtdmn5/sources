package androidx.compose.runtime;

import android.os.Trace;
import android.util.SparseArray;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, RecomposeScopeOwner {
    public final CoroutineContext _recomposeContext;
    public final HashSet<RememberObserver> abandonSet;
    public final Applier<?> applier;
    public final ArrayList changes;
    public Function2<? super Composer, ? super Integer, Unit> composable;
    public final ComposerImpl composer;
    public final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    public final IdentityScopeMap<DerivedState<?>> derivedStates;
    public boolean disposed;
    public CompositionImpl invalidationDelegate;
    public int invalidationDelegateGroup;
    public IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    public final ArrayList lateChanges;
    public final Object lock;
    public final IdentityScopeMap<RecomposeScopeImpl> observations;
    public final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    public final CompositionContext parent;
    public boolean pendingInvalidScopes;
    public final AtomicReference<Object> pendingModifications;
    public final SlotTable slotTable;

    /* compiled from: Composition.kt */
    /* loaded from: classes.dex */
    public static final class RememberEventDispatcher implements RememberManager {
        public final Set<RememberObserver> abandoning;
        public ArrayList deactivating;
        public final ArrayList forgetting;
        public ArrayList releasing;
        public final ArrayList remembering;
        public final ArrayList sideEffects;

        public RememberEventDispatcher(HashSet abandoning) {
            Intrinsics.checkNotNullParameter(abandoning, "abandoning");
            this.abandoning = abandoning;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void deactivating(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            ArrayList arrayList = this.deactivating;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.deactivating = arrayList;
            }
            arrayList.add(instance);
        }

        public final void dispatchAbandons() {
            Set<RememberObserver> set = this.abandoning;
            if (!set.isEmpty()) {
                Trace.beginSection("Compose:abandons");
                try {
                    Iterator<RememberObserver> it = set.iterator();
                    while (it.hasNext()) {
                        RememberObserver next = it.next();
                        it.remove();
                        next.onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        }

        public final void dispatchRememberObservers() {
            boolean z;
            ArrayList arrayList = this.deactivating;
            boolean z2 = false;
            if (arrayList != null && !arrayList.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Trace.beginSection("Compose:deactivations");
                try {
                    for (int size = arrayList.size() - 1; -1 < size; size--) {
                        ((ComposeNodeLifecycleCallback) arrayList.get(size)).onDeactivate();
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                    arrayList.clear();
                } finally {
                }
            }
            ArrayList arrayList2 = this.forgetting;
            boolean z3 = !arrayList2.isEmpty();
            Set<RememberObserver> set = this.abandoning;
            if (z3) {
                Trace.beginSection("Compose:onForgotten");
                try {
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        RememberObserver rememberObserver = (RememberObserver) arrayList2.get(size2);
                        if (!set.contains(rememberObserver)) {
                            rememberObserver.onForgotten();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            }
            ArrayList arrayList3 = this.remembering;
            if (!arrayList3.isEmpty()) {
                Trace.beginSection("Compose:onRemembered");
                try {
                    int size3 = arrayList3.size();
                    for (int r6 = 0; r6 < size3; r6++) {
                        RememberObserver rememberObserver2 = (RememberObserver) arrayList3.get(r6);
                        set.remove(rememberObserver2);
                        rememberObserver2.onRemembered();
                    }
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                }
            }
            ArrayList arrayList4 = this.releasing;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                z2 = true;
            }
            if (!z2) {
                Trace.beginSection("Compose:releases");
                try {
                    for (int size4 = arrayList4.size() - 1; -1 < size4; size4--) {
                        ((ComposeNodeLifecycleCallback) arrayList4.get(size4)).onRelease();
                    }
                    Unit unit4 = Unit.INSTANCE;
                    Trace.endSection();
                    arrayList4.clear();
                } finally {
                }
            }
        }

        public final void dispatchSideEffects() {
            ArrayList arrayList = this.sideEffects;
            if (!arrayList.isEmpty()) {
                Trace.beginSection("Compose:sideeffects");
                try {
                    int size = arrayList.size();
                    for (int r2 = 0; r2 < size; r2++) {
                        ((Function0) arrayList.get(r2)).invoke();
                    }
                    arrayList.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void forgetting(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            ArrayList arrayList = this.remembering;
            int lastIndexOf = arrayList.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                arrayList.remove(lastIndexOf);
                this.abandoning.remove(instance);
            } else {
                this.forgetting.add(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void releasing(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            ArrayList arrayList = this.releasing;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.releasing = arrayList;
            }
            arrayList.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void remembering(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            ArrayList arrayList = this.forgetting;
            int lastIndexOf = arrayList.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                arrayList.remove(lastIndexOf);
                this.abandoning.remove(instance);
            } else {
                this.remembering.add(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void sideEffect(Function0<Unit> effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.sideEffects.add(effect);
        }
    }

    public CompositionImpl() {
        throw null;
    }

    public CompositionImpl(CompositionContext parent, AbstractApplier abstractApplier) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
        this.applier = abstractApplier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable = new SlotTable();
        this.slotTable = slotTable;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        ArrayList arrayList = new ArrayList();
        this.changes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>();
        ComposerImpl composerImpl = new ComposerImpl(abstractApplier, parent, slotTable, hashSet, arrayList, arrayList2, this);
        parent.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = null;
        boolean z = parent instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.f8lambda1;
    }

    public final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    public final HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked(HashSet<RecomposeScopeImpl> hashSet, Object obj, boolean z) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int find = identityScopeMap.find(obj);
        if (find >= 0) {
            IdentityArraySet<RecomposeScopeImpl> scopeSetAt = identityScopeMap.scopeSetAt(find);
            Object[] objArr = scopeSetAt.values;
            int r0 = scopeSetAt.size;
            for (int r3 = 0; r3 < r0; r3++) {
                Object obj2 = objArr[r3];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (!this.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if ((recomposeScopeImpl.trackedDependencies != null) && !z) {
                        this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet<>();
                        }
                        hashSet.add(recomposeScopeImpl);
                    }
                }
            }
        }
        return hashSet;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        HashSet<RememberObserver> abandoning = this.abandonSet;
                        Intrinsics.checkNotNullParameter(abandoning, "abandoning");
                        new ArrayList();
                        new ArrayList();
                        new ArrayList();
                        if (!abandoning.isEmpty()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                Iterator<RememberObserver> it = abandoning.iterator();
                                while (it.hasNext()) {
                                    RememberObserver next = it.next();
                                    it.remove();
                                    next.onAbandoned();
                                }
                                Unit unit2 = Unit.INSTANCE;
                                Trace.endSection();
                            } catch (Throwable th2) {
                                Trace.endSection();
                                throw th2;
                            }
                        }
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyChangesInLocked(java.util.ArrayList r20) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.applyChangesInLocked(java.util.ArrayList):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (!this.lateChanges.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        HashSet<RememberObserver> abandoning = this.abandonSet;
                        Intrinsics.checkNotNullParameter(abandoning, "abandoning");
                        new ArrayList();
                        new ArrayList();
                        new ArrayList();
                        if (!abandoning.isEmpty()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                Iterator<RememberObserver> it = abandoning.iterator();
                                while (it.hasNext()) {
                                    RememberObserver next = it.next();
                                    it.remove();
                                    next.onAbandoned();
                                }
                                Unit unit2 = Unit.INSTANCE;
                                Trace.endSection();
                            } catch (Throwable th2) {
                                Trace.endSection();
                                throw th2;
                            }
                        }
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void changesApplied() {
        synchronized (this.lock) {
            try {
                ComposerImpl composerImpl = this.composer;
                composerImpl.createFreshInsertTable();
                ((SparseArray) composerImpl.providerUpdates.sparseArray).clear();
                if (!this.abandonSet.isEmpty()) {
                    HashSet<RememberObserver> abandoning = this.abandonSet;
                    Intrinsics.checkNotNullParameter(abandoning, "abandoning");
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    if (!abandoning.isEmpty()) {
                        Trace.beginSection("Compose:abandons");
                        try {
                            Iterator<RememberObserver> it = abandoning.iterator();
                            while (it.hasNext()) {
                                RememberObserver next = it.next();
                                it.remove();
                                next.onAbandoned();
                            }
                            Unit unit = Unit.INSTANCE;
                            Trace.endSection();
                        } finally {
                        }
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        HashSet<RememberObserver> abandoning2 = this.abandonSet;
                        Intrinsics.checkNotNullParameter(abandoning2, "abandoning");
                        new ArrayList();
                        new ArrayList();
                        new ArrayList();
                        if (!abandoning2.isEmpty()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                Iterator<RememberObserver> it2 = abandoning2.iterator();
                                while (it2.hasNext()) {
                                    RememberObserver next2 = it2.next();
                                    it2.remove();
                                    next2.onAbandoned();
                                }
                                Unit unit3 = Unit.INSTANCE;
                                Trace.endSection();
                            } finally {
                            }
                        }
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    public final void cleanUpDerivedStateObservations() {
        boolean z;
        IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
        int[] r2 = identityScopeMap.valueOrder;
        IdentityArraySet<DerivedState<?>>[] identityArraySetArr = identityScopeMap.scopeSets;
        Object[] objArr = identityScopeMap.values;
        int r5 = identityScopeMap.size;
        int r7 = 0;
        int r8 = 0;
        while (r7 < r5) {
            int r11 = r2[r7];
            IdentityArraySet<DerivedState<?>> identityArraySet = identityArraySetArr[r11];
            Intrinsics.checkNotNull(identityArraySet);
            Object[] objArr2 = identityArraySet.values;
            int r14 = identityArraySet.size;
            int r6 = 0;
            int r15 = 0;
            while (r15 < r14) {
                Object obj = objArr2[r15];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                IdentityArraySet<DerivedState<?>>[] identityArraySetArr2 = identityArraySetArr;
                if (!(!this.observations.contains((DerivedState) obj))) {
                    if (r6 != r15) {
                        objArr2[r6] = obj;
                    }
                    r6++;
                }
                r15++;
                identityArraySetArr = identityArraySetArr2;
            }
            IdentityArraySet<DerivedState<?>>[] identityArraySetArr3 = identityArraySetArr;
            for (int r3 = r6; r3 < r14; r3++) {
                objArr2[r3] = null;
            }
            identityArraySet.size = r6;
            if (r6 > 0) {
                if (r8 != r7) {
                    int r32 = r2[r8];
                    r2[r8] = r11;
                    r2[r7] = r32;
                }
                r8++;
            }
            r7++;
            identityArraySetArr = identityArraySetArr3;
        }
        int r33 = identityScopeMap.size;
        for (int r52 = r8; r52 < r33; r52++) {
            objArr[r2[r52]] = null;
        }
        identityScopeMap.size = r8;
        HashSet<RecomposeScopeImpl> hashSet = this.conditionallyInvalidatedScopes;
        if (!hashSet.isEmpty()) {
            Iterator<RecomposeScopeImpl> it = hashSet.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator()");
            while (it.hasNext()) {
                if (it.next().trackedDependencies != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    it.remove();
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void composeContent(ComposableLambdaImpl composableLambdaImpl) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
                this.invalidations = new IdentityArrayMap<>();
                try {
                    this.composer.composeContent$runtime_release(identityArrayMap, composableLambdaImpl);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    this.invalidations = identityArrayMap;
                    throw e;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    HashSet<RememberObserver> abandoning = this.abandonSet;
                    Intrinsics.checkNotNullParameter(abandoning, "abandoning");
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    if (!abandoning.isEmpty()) {
                        Trace.beginSection("Compose:abandons");
                        try {
                            Iterator<RememberObserver> it = abandoning.iterator();
                            while (it.hasNext()) {
                                RememberObserver next = it.next();
                                it.remove();
                                next.onAbandoned();
                            }
                            Unit unit2 = Unit.INSTANCE;
                            Trace.endSection();
                        } catch (Throwable th2) {
                            Trace.endSection();
                            throw th2;
                        }
                    }
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final <R> R delegateInvalidations(ControlledComposition controlledComposition, int r3, Function0<? extends R> function0) {
        if (controlledComposition != null && !Intrinsics.areEqual(controlledComposition, this) && r3 >= 0) {
            this.invalidationDelegate = (CompositionImpl) controlledComposition;
            this.invalidationDelegateGroup = r3;
            try {
                return function0.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return function0.invoke();
    }

    @Override // androidx.compose.runtime.Composition
    public final void dispose() {
        boolean z;
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.f9lambda2;
                ArrayList arrayList = this.composer.deferredChanges;
                if (arrayList != null) {
                    applyChangesInLocked(arrayList);
                }
                if (this.slotTable.groupsSize > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.getClass();
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close();
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            openWriter.close();
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void disposeUnusedMovableContent(MovableContentState movableContentState) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = movableContentState.slotTable.openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            openWriter.close();
            throw th;
        }
    }

    public final void drainPendingModificationsForCompositionLocked() {
        AtomicReference<Object> atomicReference = this.pendingModifications;
        Object obj = CompositionKt.PendingApplyNoModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            if (!Intrinsics.areEqual(andSet, obj)) {
                if (andSet instanceof Set) {
                    addPendingInvalidationsLocked(true, (Set) andSet);
                    return;
                }
                if (andSet instanceof Object[]) {
                    for (Set set : (Set[]) andSet) {
                        addPendingInvalidationsLocked(true, set);
                    }
                    return;
                }
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
                throw null;
            }
            ComposerKt.composeRuntimeError("pending composition has not been applied");
            throw null;
        }
    }

    public final void drainPendingModificationsLocked() {
        AtomicReference<Object> atomicReference = this.pendingModifications;
        Object andSet = atomicReference.getAndSet(null);
        if (!Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked(false, (Set) andSet);
                return;
            }
            if (andSet instanceof Object[]) {
                for (Set set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(false, set);
                }
                return;
            }
            if (andSet == null) {
                ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                throw null;
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
            throw null;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public final boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            if (this.invalidations.size > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public final void insertMovableContent(ArrayList arrayList) {
        int size = arrayList.size();
        boolean z = false;
        int r2 = 0;
        while (true) {
            if (r2 < size) {
                if (!Intrinsics.areEqual(((MovableContentStateReference) ((Pair) arrayList.get(r2)).first).composition, this)) {
                    break;
                } else {
                    r2++;
                }
            } else {
                z = true;
                break;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            ComposerImpl composerImpl = this.composer;
            composerImpl.getClass();
            try {
                composerImpl.insertMovableContentGuarded(arrayList);
                composerImpl.cleanUpCompose();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                composerImpl.abortRoot();
                throw th;
            }
        } catch (Throwable th2) {
            HashSet<RememberObserver> hashSet = this.abandonSet;
            try {
                if (!hashSet.isEmpty()) {
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    if (!hashSet.isEmpty()) {
                        Trace.beginSection("Compose:abandons");
                        try {
                            Iterator<RememberObserver> it = hashSet.iterator();
                            while (it.hasNext()) {
                                RememberObserver next = it.next();
                                it.remove();
                                next.onAbandoned();
                            }
                            Unit unit2 = Unit.INSTANCE;
                            Trace.endSection();
                        } catch (Throwable th3) {
                            Trace.endSection();
                            throw th3;
                        }
                    }
                }
                throw th2;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            }
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public final InvalidationResult invalidate(RecomposeScopeImpl scope, Object obj) {
        boolean z;
        boolean z2;
        CompositionImpl compositionImpl;
        boolean z3;
        Intrinsics.checkNotNullParameter(scope, "scope");
        int r0 = scope.flags;
        boolean z4 = false;
        if ((r0 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            scope.flags = r0 | 4;
        }
        Anchor anchor = scope.anchor;
        if (anchor != null) {
            if (anchor.location != Integer.MIN_VALUE) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (!this.slotTable.ownsAnchor(anchor)) {
                    synchronized (this.lock) {
                        compositionImpl = this.invalidationDelegate;
                    }
                    if (compositionImpl != null) {
                        ComposerImpl composerImpl = compositionImpl.composer;
                        if (composerImpl.isComposing && composerImpl.tryImminentInvalidation$runtime_release(scope, obj)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        return InvalidationResult.IMMINENT;
                    }
                    return InvalidationResult.IGNORED;
                }
                if (scope.block != null) {
                    z4 = true;
                }
                if (!z4) {
                    return InvalidationResult.IGNORED;
                }
                return invalidateChecked(scope, anchor, obj);
            }
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void invalidateAll() {
        RecomposeScopeImpl recomposeScopeImpl;
        synchronized (this.lock) {
            for (Object obj : this.slotTable.slots) {
                if (obj instanceof RecomposeScopeImpl) {
                    recomposeScopeImpl = (RecomposeScopeImpl) obj;
                } else {
                    recomposeScopeImpl = null;
                }
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final InvalidationResult invalidateChecked(RecomposeScopeImpl key, Anchor anchor, Object obj) {
        boolean z;
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            if (compositionImpl == null || !this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                compositionImpl = null;
            }
            if (compositionImpl == null) {
                ComposerImpl composerImpl = this.composer;
                boolean z2 = true;
                if (composerImpl.isComposing && composerImpl.tryImminentInvalidation$runtime_release(key, obj)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return InvalidationResult.IMMINENT;
                }
                if (obj == null) {
                    this.invalidations.set(key, null);
                } else {
                    IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
                    Object obj2 = CompositionKt.PendingApplyNoModifications;
                    identityArrayMap.getClass();
                    Intrinsics.checkNotNullParameter(key, "key");
                    if (identityArrayMap.find(key) < 0) {
                        z2 = false;
                    }
                    if (z2) {
                        IdentityArraySet<Object> identityArraySet = identityArrayMap.get(key);
                        if (identityArraySet != null) {
                            identityArraySet.add(obj);
                        }
                    } else {
                        IdentityArraySet<Object> identityArraySet2 = new IdentityArraySet<>();
                        identityArraySet2.add(obj);
                        Unit unit = Unit.INSTANCE;
                        identityArrayMap.set(key, identityArraySet2);
                    }
                }
            }
            if (compositionImpl != null) {
                return compositionImpl.invalidateChecked(key, anchor, obj);
            }
            this.parent.invalidate$runtime_release(this);
            if (this.composer.isComposing) {
                return InvalidationResult.DEFERRED;
            }
            return InvalidationResult.SCHEDULED;
        }
    }

    public final void invalidateScopeOfLocked(Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int find = identityScopeMap.find(obj);
        if (find >= 0) {
            IdentityArraySet<RecomposeScopeImpl> scopeSetAt = identityScopeMap.scopeSetAt(find);
            Object[] objArr = scopeSetAt.values;
            int r0 = scopeSetAt.size;
            for (int r2 = 0; r2 < r0; r2++) {
                Object obj2 = objArr[r2];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final boolean isComposing() {
        return this.composer.isComposing;
    }

    @Override // androidx.compose.runtime.Composition
    public final boolean isDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final boolean observesAnyOf(IdentityArraySet identityArraySet) {
        boolean z;
        int r1 = 0;
        while (true) {
            if (r1 < identityArraySet.size) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            int r4 = r1 + 1;
            Object obj = identityArraySet.values[r1];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                break;
            }
            r1 = r4;
        }
        return true;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void prepareCompose(Recomposer$performRecompose$1$1 recomposer$performRecompose$1$1) {
        ComposerImpl composerImpl = this.composer;
        composerImpl.getClass();
        if (!composerImpl.isComposing) {
            composerImpl.isComposing = true;
            try {
                recomposer$performRecompose$1$1.invoke();
                return;
            } finally {
                composerImpl.isComposing = false;
            }
        }
        ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
        throw null;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final boolean recompose() {
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
                this.invalidations = new IdentityArrayMap<>();
                try {
                    recompose$runtime_release = this.composer.recompose$runtime_release(identityArrayMap);
                    if (!recompose$runtime_release) {
                        drainPendingModificationsLocked();
                    }
                } catch (Exception e) {
                    this.invalidations = identityArrayMap;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        HashSet<RememberObserver> abandoning = this.abandonSet;
                        Intrinsics.checkNotNullParameter(abandoning, "abandoning");
                        new ArrayList();
                        new ArrayList();
                        new ArrayList();
                        if (!abandoning.isEmpty()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                Iterator<RememberObserver> it = abandoning.iterator();
                                while (it.hasNext()) {
                                    RememberObserver next = it.next();
                                    it.remove();
                                    next.onAbandoned();
                                }
                                Unit unit = Unit.INSTANCE;
                                Trace.endSection();
                            } catch (Throwable th2) {
                                Trace.endSection();
                                throw th2;
                            }
                        }
                    }
                    throw th;
                } catch (Exception e2) {
                    abandonChanges();
                    throw e2;
                }
            }
        }
        return recompose$runtime_release;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public final void recomposeScopeReleased(RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.pendingInvalidScopes = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.Set[]] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public final void recordModificationsOf(IdentityArraySet values) {
        Object obj;
        boolean z;
        boolean areEqual;
        IdentityArraySet identityArraySet;
        Intrinsics.checkNotNullParameter(values, "values");
        do {
            obj = this.pendingModifications.get();
            z = true;
            if (obj == null) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications);
            }
            if (areEqual) {
                identityArraySet = values;
            } else if (obj instanceof Set) {
                identityArraySet = new Set[]{obj, values};
            } else if (obj instanceof Object[]) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                identityArraySet = ArraysKt___ArraysJvmKt.plus((IdentityArraySet[]) obj, values);
            } else {
                throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
            }
            AtomicReference<Object> atomicReference = this.pendingModifications;
            while (true) {
                if (atomicReference.compareAndSet(obj, identityArraySet)) {
                    break;
                } else if (atomicReference.get() != obj) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void recordReadOf(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.runtime.ComposerImpl r0 = r5.composer
            int r1 = r0.childrenComposing
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L10
            r1 = r3
            goto L11
        L10:
            r1 = r2
        L11:
            if (r1 != 0) goto L82
            androidx.compose.runtime.RecomposeScopeImpl r0 = r0.getCurrentRecomposeScope$runtime_release()
            if (r0 == 0) goto L82
            int r1 = r0.flags
            r1 = r1 | r3
            r0.flags = r1
            r1 = r1 & 32
            if (r1 == 0) goto L24
            r1 = r3
            goto L25
        L24:
            r1 = r2
        L25:
            if (r1 == 0) goto L28
            goto L59
        L28:
            androidx.compose.runtime.collection.IdentityArrayIntMap r1 = r0.trackedInstances
            if (r1 != 0) goto L33
            androidx.compose.runtime.collection.IdentityArrayIntMap r1 = new androidx.compose.runtime.collection.IdentityArrayIntMap
            r1.<init>()
            r0.trackedInstances = r1
        L33:
            int r4 = r0.currentToken
            int r1 = r1.add(r4, r6)
            int r4 = r0.currentToken
            if (r1 != r4) goto L3e
            goto L5a
        L3e:
            boolean r1 = r6 instanceof androidx.compose.runtime.DerivedState
            if (r1 == 0) goto L59
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r1 = r0.trackedDependencies
            if (r1 != 0) goto L4d
            androidx.compose.runtime.collection.IdentityArrayMap r1 = new androidx.compose.runtime.collection.IdentityArrayMap
            r1.<init>()
            r0.trackedDependencies = r1
        L4d:
            r3 = r6
            androidx.compose.runtime.DerivedState r3 = (androidx.compose.runtime.DerivedState) r3
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord r3 = r3.getCurrentRecord()
            java.lang.Object r3 = r3.result
            r1.set(r6, r3)
        L59:
            r3 = r2
        L5a:
            if (r3 != 0) goto L82
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r1 = r5.observations
            r1.add(r6, r0)
            boolean r0 = r6 instanceof androidx.compose.runtime.DerivedState
            if (r0 == 0) goto L82
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r0 = r5.derivedStates
            r0.removeScope(r6)
            r1 = r6
            androidx.compose.runtime.DerivedState r1 = (androidx.compose.runtime.DerivedState) r1
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord r1 = r1.getCurrentRecord()
            java.lang.Object[] r1 = r1.getDependencies()
            int r3 = r1.length
        L76:
            if (r2 >= r3) goto L82
            r4 = r1[r2]
            if (r4 == 0) goto L82
            r0.add(r4, r6)
            int r2 = r2 + 1
            goto L76
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordReadOf(java.lang.Object):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void recordWriteOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
            int find = identityScopeMap.find(value);
            if (find >= 0) {
                IdentityArraySet<DerivedState<?>> scopeSetAt = identityScopeMap.scopeSetAt(find);
                Object[] objArr = scopeSetAt.values;
                int r6 = scopeSetAt.size;
                for (int r2 = 0; r2 < r6; r2++) {
                    Object obj = objArr[r2];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    invalidateScopeOfLocked((DerivedState) obj);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.disposed) {
            this.composable = function2;
            this.parent.composeInitial$runtime_release(this, (ComposableLambdaImpl) function2);
            return;
        }
        throw new IllegalStateException("The composition is disposed".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void addPendingInvalidationsLocked(boolean r19, java.util.Set r20) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(boolean, java.util.Set):void");
    }
}
