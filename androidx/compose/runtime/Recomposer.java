package androidx.compose.runtime;

import android.util.Log;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.SnapshotKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Recomposer.kt */
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    public static final AtomicReference<Boolean> _hotReloadEnabled;
    public static final StateFlowImpl _runningRecomposers;
    public final StateFlowImpl _state;
    public final BroadcastFrameClock broadcastFrameClock;
    public Throwable closeCause;
    public final ArrayList compositionInvalidations;
    public final LinkedHashMap compositionValueStatesAvailable;
    public final ArrayList compositionValuesAwaitingInsert;
    public final LinkedHashMap compositionValuesRemoved;
    public final ArrayList compositionsAwaitingApply;
    public Set<ControlledComposition> compositionsRemoved;
    public final CoroutineContext effectCoroutineContext;
    public final JobImpl effectJob;
    public RecomposerErrorState errorState;
    public ArrayList failedCompositions;
    public boolean frameClockPaused;
    public final ArrayList knownCompositions;
    public final RecomposerInfoImpl recomposerInfo;
    public Job runnerJob;
    public IdentityArraySet<Object> snapshotInvalidations;
    public final Object stateLock;
    public CancellableContinuation<? super Unit> workContinuation;

    /* compiled from: Recomposer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
    }

    /* compiled from: Recomposer.kt */
    /* loaded from: classes.dex */
    public static final class RecomposerErrorState {
        public RecomposerErrorState(Exception exc) {
        }
    }

    /* compiled from: Recomposer.kt */
    /* loaded from: classes.dex */
    public final class RecomposerInfoImpl {
    }

    /* compiled from: Recomposer.kt */
    /* loaded from: classes.dex */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    static {
        new Companion();
        _runningRecomposers = StateFlowKt.MutableStateFlow(PersistentOrderedSet.EMPTY);
        _hotReloadEnabled = new AtomicReference<>(Boolean.FALSE);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.runtime.Recomposer$broadcastFrameClock$1] */
    public Recomposer(CoroutineContext effectCoroutineContext) {
        Intrinsics.checkNotNullParameter(effectCoroutineContext, "effectCoroutineContext");
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                CancellableContinuation<Unit> deriveStateLocked;
                Recomposer recomposer = Recomposer.this;
                synchronized (recomposer.stateLock) {
                    deriveStateLocked = recomposer.deriveStateLocked();
                    if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
                    }
                }
                if (deriveStateLocked != null) {
                    deriveStateLocked.resumeWith(Unit.INSTANCE);
                }
                return Unit.INSTANCE;
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this.knownCompositions = new ArrayList();
        this.snapshotInvalidations = new IdentityArraySet<>();
        this.compositionInvalidations = new ArrayList();
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        JobImpl jobImpl = new JobImpl((Job) effectCoroutineContext.get(Job.Key.$$INSTANCE));
        jobImpl.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                final Throwable th2 = th;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th2);
                final Recomposer recomposer = Recomposer.this;
                synchronized (recomposer.stateLock) {
                    Job job = recomposer.runnerJob;
                    if (job != null) {
                        recomposer._state.setValue(Recomposer.State.ShuttingDown);
                        job.cancel(CancellationException);
                        recomposer.workContinuation = null;
                        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Throwable th3) {
                                Throwable th4 = th3;
                                Recomposer recomposer2 = Recomposer.this;
                                Object obj = recomposer2.stateLock;
                                Throwable th5 = th2;
                                synchronized (obj) {
                                    if (th5 != null) {
                                        if (th4 != null) {
                                            if (!(!(th4 instanceof CancellationException))) {
                                                th4 = null;
                                            }
                                            if (th4 != null) {
                                                kotlin.ExceptionsKt.addSuppressed(th5, th4);
                                            }
                                        }
                                    } else {
                                        th5 = null;
                                    }
                                    recomposer2.closeCause = th5;
                                    recomposer2._state.setValue(Recomposer.State.ShutDown);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        recomposer.closeCause = CancellationException;
                        recomposer._state.setValue(Recomposer.State.ShutDown);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        });
        this.effectJob = jobImpl;
        this.effectCoroutineContext = effectCoroutineContext.plus(broadcastFrameClock).plus(jobImpl);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public static final ControlledComposition access$performRecompose(Recomposer recomposer, ControlledComposition controlledComposition, IdentityArraySet identityArraySet) {
        boolean z;
        MutableSnapshot mutableSnapshot;
        MutableSnapshot takeNestedMutableSnapshot;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed()) {
            return null;
        }
        Set<ControlledComposition> set = recomposer.compositionsRemoved;
        boolean z2 = true;
        if (set != null && set.contains(controlledComposition)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Recomposer$readObserverOf$1 recomposer$readObserverOf$1 = new Recomposer$readObserverOf$1(controlledComposition);
        Recomposer$writeObserverOf$1 recomposer$writeObserverOf$1 = new Recomposer$writeObserverOf$1(controlledComposition, identityArraySet);
        Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
        if (currentSnapshot instanceof MutableSnapshot) {
            mutableSnapshot = (MutableSnapshot) currentSnapshot;
        } else {
            mutableSnapshot = null;
        }
        if (mutableSnapshot != null && (takeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(recomposer$readObserverOf$1, recomposer$writeObserverOf$1)) != null) {
            try {
                Snapshot makeCurrent = takeNestedMutableSnapshot.makeCurrent();
                try {
                    if (!identityArraySet.isNotEmpty()) {
                        z2 = false;
                    }
                    if (z2) {
                        controlledComposition.prepareCompose(new Recomposer$performRecompose$1$1(controlledComposition, identityArraySet));
                    }
                    boolean recompose = controlledComposition.recompose();
                    Snapshot.restoreCurrent(makeCurrent);
                    if (!recompose) {
                        controlledComposition = null;
                    }
                    return controlledComposition;
                } catch (Throwable th) {
                    Snapshot.restoreCurrent(makeCurrent);
                    throw th;
                }
            } finally {
                applyAndCheck(takeNestedMutableSnapshot);
            }
        }
        throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
    }

    public static final boolean access$recordComposerModifications(Recomposer recomposer) {
        boolean z;
        ArrayList mutableList;
        synchronized (recomposer.stateLock) {
            z = false;
            if (recomposer.snapshotInvalidations.isEmpty()) {
                if ((!recomposer.compositionInvalidations.isEmpty()) || recomposer.getHasBroadcastFrameClockAwaitersLocked()) {
                    z = true;
                }
            } else {
                IdentityArraySet<Object> identityArraySet = recomposer.snapshotInvalidations;
                recomposer.snapshotInvalidations = new IdentityArraySet<>();
                synchronized (recomposer.stateLock) {
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) recomposer.knownCompositions);
                }
                try {
                    int size = mutableList.size();
                    for (int r5 = 0; r5 < size; r5++) {
                        ((ControlledComposition) mutableList.get(r5)).recordModificationsOf(identityArraySet);
                        if (((State) recomposer._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                            break;
                        }
                    }
                    recomposer.snapshotInvalidations = new IdentityArraySet<>();
                    synchronized (recomposer.stateLock) {
                        if (recomposer.deriveStateLocked() == null) {
                            if ((!recomposer.compositionInvalidations.isEmpty()) || recomposer.getHasBroadcastFrameClockAwaitersLocked()) {
                                z = true;
                            }
                        } else {
                            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                        }
                    }
                } catch (Throwable th) {
                    synchronized (recomposer.stateLock) {
                        recomposer.snapshotInvalidations.addAll((Collection<? extends Object>) identityArraySet);
                        Unit unit = Unit.INSTANCE;
                        throw th;
                    }
                }
            }
        }
        return z;
    }

    public static void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (!(mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure)) {
            } else {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            mutableSnapshot.dispose();
        }
    }

    public static final void performInitialMovableContentInserts$fillToInsert(ArrayList arrayList, Recomposer recomposer, ControlledComposition controlledComposition) {
        arrayList.clear();
        synchronized (recomposer.stateLock) {
            Iterator it = recomposer.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) it.next();
                if (Intrinsics.areEqual(movableContentStateReference.composition, controlledComposition)) {
                    arrayList.add(movableContentStateReference);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, boolean z, int r3) {
        if ((r3 & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, null, z);
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (((State) this._state.getValue()).compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        this.effectJob.cancel(null);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void composeInitial$runtime_release(ControlledComposition composition, ComposableLambdaImpl composableLambdaImpl) {
        MutableSnapshot takeNestedMutableSnapshot;
        Intrinsics.checkNotNullParameter(composition, "composition");
        boolean isComposing = composition.isComposing();
        try {
            Recomposer$readObserverOf$1 recomposer$readObserverOf$1 = new Recomposer$readObserverOf$1(composition);
            MutableSnapshot mutableSnapshot = null;
            Recomposer$writeObserverOf$1 recomposer$writeObserverOf$1 = new Recomposer$writeObserverOf$1(composition, null);
            Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
            if (currentSnapshot instanceof MutableSnapshot) {
                mutableSnapshot = (MutableSnapshot) currentSnapshot;
            }
            if (mutableSnapshot != null && (takeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(recomposer$readObserverOf$1, recomposer$writeObserverOf$1)) != null) {
                try {
                    Snapshot makeCurrent = takeNestedMutableSnapshot.makeCurrent();
                    try {
                        composition.composeContent(composableLambdaImpl);
                        Unit unit = Unit.INSTANCE;
                        if (!isComposing) {
                            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
                        }
                        synchronized (this.stateLock) {
                            if (((State) this._state.getValue()).compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(composition)) {
                                this.knownCompositions.add(composition);
                            }
                        }
                        try {
                            performInitialMovableContentInserts(composition);
                            try {
                                composition.applyChanges();
                                composition.applyLateChanges();
                                if (!isComposing) {
                                    SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                processCompositionError$default(this, e, false, 6);
                                return;
                            }
                        } catch (Exception e2) {
                            processCompositionError(e2, composition, true);
                            return;
                        }
                    } finally {
                        Snapshot.restoreCurrent(makeCurrent);
                    }
                } finally {
                    applyAndCheck(takeNestedMutableSnapshot);
                }
            }
            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
        } catch (Exception e3) {
            processCompositionError(e3, composition, true);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        synchronized (this.stateLock) {
            LinkedHashMap linkedHashMap = this.compositionValuesRemoved;
            MovableContent<Object> movableContent = movableContentStateReference.content;
            Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
            Object obj = linkedHashMap.get(movableContent);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(movableContent, obj);
            }
            ((List) obj).add(movableContentStateReference);
        }
    }

    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        StateFlowImpl stateFlowImpl = this._state;
        int compareTo = ((State) stateFlowImpl.getValue()).compareTo(State.ShuttingDown);
        ArrayList arrayList = this.compositionValuesAwaitingInsert;
        ArrayList arrayList2 = this.compositionsAwaitingApply;
        ArrayList arrayList3 = this.compositionInvalidations;
        if (compareTo <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations = new IdentityArraySet<>();
            arrayList3.clear();
            arrayList2.clear();
            arrayList.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new IdentityArraySet<>();
            arrayList3.clear();
            if (getHasBroadcastFrameClockAwaitersLocked()) {
                state = State.InactivePendingWork;
            } else {
                state = State.Inactive;
            }
        } else if (!(!arrayList3.isEmpty()) && !this.snapshotInvalidations.isNotEmpty() && !(!arrayList2.isEmpty()) && !(!arrayList.isEmpty()) && !getHasBroadcastFrameClockAwaitersLocked()) {
            state = State.Idle;
        } else {
            state = State.PendingWork;
        }
        stateFlowImpl.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasBroadcastFrameClockAwaitersLocked() {
        boolean z;
        if (!this.frameClockPaused) {
            BroadcastFrameClock broadcastFrameClock = this.broadcastFrameClock;
            synchronized (broadcastFrameClock.lock) {
                z = !broadcastFrameClock.awaiters.isEmpty();
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = true;
            if (!this.snapshotInvalidations.isNotEmpty() && !(!this.compositionInvalidations.isEmpty())) {
                if (!getHasBroadcastFrameClockAwaitersLocked()) {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuation;
        Intrinsics.checkNotNullParameter(composition, "composition");
        synchronized (this.stateLock) {
            if (!this.compositionInvalidations.contains(composition)) {
                this.compositionInvalidations.add(composition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            cancellableContinuation.resumeWith(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(movableContentStateReference, movableContentState);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState movableContentState;
        Intrinsics.checkNotNullParameter(reference, "reference");
        synchronized (this.stateLock) {
            movableContentState = (MovableContentState) this.compositionValueStatesAvailable.remove(reference);
        }
        return movableContentState;
    }

    public final void performInitialMovableContentInserts(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            ArrayList arrayList = this.compositionValuesAwaitingInsert;
            int size = arrayList.size();
            boolean z = false;
            int r4 = 0;
            while (true) {
                if (r4 >= size) {
                    break;
                }
                if (Intrinsics.areEqual(((MovableContentStateReference) arrayList.get(r4)).composition, controlledComposition)) {
                    z = true;
                    break;
                }
                r4++;
            }
            if (!z) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            ArrayList arrayList2 = new ArrayList();
            performInitialMovableContentInserts$fillToInsert(arrayList2, this, controlledComposition);
            while (!arrayList2.isEmpty()) {
                performInsertValues(arrayList2, null);
                performInitialMovableContentInserts$fillToInsert(arrayList2, this, controlledComposition);
            }
        }
    }

    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> list, IdentityArraySet<Object> identityArraySet) {
        MutableSnapshot mutableSnapshot;
        MutableSnapshot takeNestedMutableSnapshot;
        ArrayList arrayList;
        Object obj;
        Recomposer recomposer = this;
        HashMap hashMap = new HashMap(list.size());
        int size = list.size();
        for (int r4 = 0; r4 < size; r4++) {
            MovableContentStateReference movableContentStateReference = list.get(r4);
            ControlledComposition controlledComposition = movableContentStateReference.composition;
            Object obj2 = hashMap.get(controlledComposition);
            if (obj2 == null) {
                obj2 = new ArrayList();
                hashMap.put(controlledComposition, obj2);
            }
            ((ArrayList) obj2).add(movableContentStateReference);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            ControlledComposition controlledComposition2 = (ControlledComposition) entry.getKey();
            List list2 = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition2.isComposing());
            Recomposer$readObserverOf$1 recomposer$readObserverOf$1 = new Recomposer$readObserverOf$1(controlledComposition2);
            Recomposer$writeObserverOf$1 recomposer$writeObserverOf$1 = new Recomposer$writeObserverOf$1(controlledComposition2, identityArraySet);
            Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
            if (currentSnapshot instanceof MutableSnapshot) {
                mutableSnapshot = (MutableSnapshot) currentSnapshot;
            } else {
                mutableSnapshot = null;
            }
            if (mutableSnapshot != null && (takeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(recomposer$readObserverOf$1, recomposer$writeObserverOf$1)) != null) {
                try {
                    Snapshot makeCurrent = takeNestedMutableSnapshot.makeCurrent();
                    try {
                        synchronized (recomposer.stateLock) {
                            arrayList = new ArrayList(list2.size());
                            int size2 = list2.size();
                            int r13 = 0;
                            while (r13 < size2) {
                                MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list2.get(r13);
                                LinkedHashMap linkedHashMap = recomposer.compositionValuesRemoved;
                                MovableContent<Object> movableContent = movableContentStateReference2.content;
                                Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
                                List list3 = (List) linkedHashMap.get(movableContent);
                                if (list3 != null) {
                                    if (!list3.isEmpty()) {
                                        Object remove = list3.remove(0);
                                        if (list3.isEmpty()) {
                                            linkedHashMap.remove(movableContent);
                                        }
                                        obj = remove;
                                    } else {
                                        throw new NoSuchElementException("List is empty.");
                                    }
                                } else {
                                    obj = null;
                                }
                                arrayList.add(new Pair(movableContentStateReference2, obj));
                                r13++;
                                recomposer = this;
                            }
                        }
                        controlledComposition2.insertMovableContent(arrayList);
                        Unit unit = Unit.INSTANCE;
                        applyAndCheck(takeNestedMutableSnapshot);
                        recomposer = this;
                    } finally {
                        Snapshot.restoreCurrent(makeCurrent);
                    }
                } catch (Throwable th) {
                    applyAndCheck(takeNestedMutableSnapshot);
                    throw th;
                }
            } else {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
            }
        }
        return CollectionsKt___CollectionsKt.toList(hashMap.keySet());
    }

    public final void processCompositionError(Exception exc, ControlledComposition controlledComposition, boolean z) {
        Boolean bool = _hotReloadEnabled.get();
        Intrinsics.checkNotNullExpressionValue(bool, "_hotReloadEnabled.get()");
        if (bool.booleanValue()) {
            if (!(exc instanceof ComposeRuntimeError)) {
                synchronized (this.stateLock) {
                    int r1 = ActualAndroid_androidKt.$r8$clinit;
                    Log.e("ComposeInternal", "Error was captured in composition while live edit was enabled.", exc);
                    this.compositionsAwaitingApply.clear();
                    this.compositionInvalidations.clear();
                    this.snapshotInvalidations = new IdentityArraySet<>();
                    this.compositionValuesAwaitingInsert.clear();
                    this.compositionValuesRemoved.clear();
                    this.compositionValueStatesAvailable.clear();
                    this.errorState = new RecomposerErrorState(exc);
                    if (controlledComposition != null) {
                        ArrayList arrayList = this.failedCompositions;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.failedCompositions = arrayList;
                        }
                        if (!arrayList.contains(controlledComposition)) {
                            arrayList.add(controlledComposition);
                        }
                        this.knownCompositions.remove(controlledComposition);
                    }
                    deriveStateLocked();
                }
                return;
            }
            throw exc;
        }
        throw exc;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void reportRemovedComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        synchronized (this.stateLock) {
            Set set = this.compositionsRemoved;
            if (set == null) {
                set = new LinkedHashSet();
                this.compositionsRemoved = set;
            }
            set.add(composition);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void unregisterComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        synchronized (this.stateLock) {
            this.knownCompositions.remove(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void recordInspectionTable$runtime_release(Set<Object> set) {
    }
}
