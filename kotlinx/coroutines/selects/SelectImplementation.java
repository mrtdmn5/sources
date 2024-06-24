package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Select.kt */
/* loaded from: classes4.dex */
public final class SelectImplementation<R> extends CancelHandler implements SelectInstance, Waiter {
    public static final AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    public final CoroutineContext context;
    public Object disposableHandleOrSegment;
    private volatile Object state = SelectKt.STATE_REG;
    public ArrayList clauses = new ArrayList(2);
    public int indexInSegment = -1;
    public Object internalResult = SelectKt.NO_RESULT;

    /* compiled from: Select.kt */
    /* loaded from: classes4.dex */
    public final class ClauseData {
        public final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        public final Object param;
        public final Function3<Object, Object, Object, Object> processResFunc;
        public final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;

        public ClauseData(Object obj, Function3 function3, Function3 function32, Symbol symbol, SuspendLambda suspendLambda, Function3 function33) {
            this.clauseObject = obj;
            this.regFunc = function3;
            this.processResFunc = function32;
            this.param = symbol;
            this.block = suspendLambda;
            this.onCancellationConstructor = function33;
        }

        public final void dispose() {
            DisposableHandle disposableHandle;
            Object obj = this.disposableHandleOrSegment;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, SelectImplementation.this.context);
                return;
            }
            if (obj instanceof DisposableHandle) {
                disposableHandle = (DisposableHandle) obj;
            } else {
                disposableHandle = null;
            }
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Object invokeBlock(Object obj, ContinuationImpl continuationImpl) {
            Symbol symbol = SelectKt.PARAM_CLAUSE_0;
            Object obj2 = this.param;
            Object obj3 = this.block;
            if (obj2 == symbol) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj3).invoke(continuationImpl);
            }
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj3).invoke(obj, continuationImpl);
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }

    public final Object complete(ContinuationImpl continuationImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        Object obj = atomicReferenceFieldUpdater.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.internalResult;
        ArrayList arrayList = this.clauses;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ClauseData clauseData2 = (ClauseData) it.next();
                if (clauseData2 != clauseData) {
                    clauseData2.dispose();
                }
            }
            atomicReferenceFieldUpdater.set(this, SelectKt.STATE_COMPLETED);
            this.internalResult = SelectKt.NO_RESULT;
            this.clauses = null;
        }
        return clauseData.invokeBlock(clauseData.processResFunc.invoke(clauseData.clauseObject, clauseData.param, obj2), continuationImpl);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00d9 A[PHI: r11
  0x00d9: PHI (r11v8 java.lang.Object) = (r11v7 java.lang.Object), (r11v1 java.lang.Object) binds: [B:17:0x00d6, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object doSelectSuspend(kotlin.coroutines.Continuation<? super R> r11) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.doSelectSuspend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final SelectImplementation<R>.ClauseData findClause(Object obj) {
        boolean z;
        ArrayList arrayList = this.clauses;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).clauseObject == obj) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj2 = next;
                break;
            }
        }
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment<?> segment, int r2) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = r2;
    }

    public final void register(SelectImplementation<R>.ClauseData clauseData, boolean z) {
        boolean z2;
        boolean z3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        if (atomicReferenceFieldUpdater.get(this) instanceof ClauseData) {
            return;
        }
        Object obj = clauseData.clauseObject;
        boolean z4 = true;
        if (!z) {
            ArrayList arrayList = this.clauses;
            Intrinsics.checkNotNull(arrayList);
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((ClauseData) it.next()).clauseObject == obj) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            if (!z2) {
                throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
            }
        }
        clauseData.regFunc.invoke(obj, this, clauseData.param);
        if (this.internalResult != SelectKt.NO_RESULT) {
            z4 = false;
        }
        if (z4) {
            if (!z) {
                ArrayList arrayList2 = this.clauses;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add(clauseData);
            }
            clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
            clauseData.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
            return;
        }
        atomicReferenceFieldUpdater.set(this, clauseData);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void selectInRegistrationPhase(Object obj) {
        this.internalResult = obj;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final boolean trySelect(Object obj, Object obj2) {
        if (trySelectInternal(obj, obj2) == 0) {
            return true;
        }
        return false;
    }

    public final int trySelectInternal(Object obj, Object obj2) {
        Function1<Throwable, Unit> function1;
        boolean z;
        boolean z2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            boolean z3 = false;
            boolean z4 = true;
            if (obj3 instanceof CancellableContinuation) {
                SelectImplementation<R>.ClauseData findClause = findClause(obj);
                if (findClause != null) {
                    Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> function3 = findClause.onCancellationConstructor;
                    if (function3 != null) {
                        function1 = function3.invoke(this, findClause.param, obj2);
                    } else {
                        function1 = null;
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, findClause)) {
                            z = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj3;
                        this.internalResult = obj2;
                        SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1 selectKt$DUMMY_PROCESS_RESULT_FUNCTION$1 = SelectKt.DUMMY_PROCESS_RESULT_FUNCTION;
                        Symbol tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, function1);
                        if (tryResume == null) {
                            z4 = false;
                        } else {
                            cancellableContinuation.completeResume(tryResume);
                        }
                        if (z4) {
                            return 0;
                        }
                        this.internalResult = null;
                        return 2;
                    }
                } else {
                    continue;
                }
            } else {
                if (Intrinsics.areEqual(obj3, SelectKt.STATE_COMPLETED)) {
                    z2 = true;
                } else {
                    z2 = obj3 instanceof ClauseData;
                }
                if (z2) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.STATE_CANCELLED)) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.STATE_REG)) {
                    List listOf = CollectionsKt__CollectionsKt.listOf(obj);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, listOf)) {
                            z3 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    if (z3) {
                        return 1;
                    }
                } else if (obj3 instanceof List) {
                    ArrayList plus = CollectionsKt___CollectionsKt.plus((Collection) obj3, obj);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, plus)) {
                            z3 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    if (z3) {
                        return 1;
                    }
                } else {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
            }
        }
    }

    public final void invoke(SelectClause1 selectClause1, FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2) {
        register(new ClauseData(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, flowKt__DelayKt$debounceInternal$1$3$2, selectClause1.getOnCancellationConstructor()), false);
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke */
    public final void invoke2(Throwable th) {
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_COMPLETED) {
                return;
            }
            Symbol symbol = SelectKt.STATE_CANCELLED;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                    z = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        ArrayList arrayList = this.clauses;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ClauseData) it.next()).dispose();
        }
        this.internalResult = SelectKt.NO_RESULT;
        this.clauses = null;
    }
}
