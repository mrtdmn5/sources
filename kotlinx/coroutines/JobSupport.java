package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public class JobSupport implements Job, ChildJob, ParentJob {
    private volatile Object _parentHandle;
    private volatile Object _state;
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        public final JobSupport job;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(1, continuation);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final Throwable getContinuationCancellationCause(JobSupport jobSupport) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            if ((state$kotlinx_coroutines_core instanceof Finishing) && (rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause()) != null) {
                return rootCause;
            }
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
            return jobSupport.getCancellationException();
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final String nameString() {
            return "AwaitContinuation";
        }
    }

    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class ChildCompletion extends JobNode {
        public final ChildHandleNode child;
        public final JobSupport parent;
        public final Object proposedUpdate;
        public final Finishing state;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke */
        public final void invoke2(Throwable th) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._state$FU;
            JobSupport jobSupport = this.parent;
            jobSupport.getClass();
            ChildHandleNode nextChild = JobSupport.nextChild(this.child);
            Finishing finishing = this.state;
            Object obj = this.proposedUpdate;
            if (nextChild == null || !jobSupport.tryWaitForChild(finishing, nextChild, obj)) {
                jobSupport.afterCompletion(jobSupport.finalizeFinishingState(finishing, obj));
            }
        }
    }

    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting = 0;
        private volatile Object _rootCause;
        public final NodeList list;
        public static final AtomicIntegerFieldUpdater _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting");
        public static final AtomicReferenceFieldUpdater _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause");
        public static final AtomicReferenceFieldUpdater _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder");

        public Finishing(NodeList nodeList, Throwable th) {
            this.list = nodeList;
            this._rootCause = th;
        }

        public final void addExceptionLocked(Throwable th) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                _rootCause$FU.set(this, th);
                return;
            }
            if (th == rootCause) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(obj);
                arrayList.add(th);
                atomicReferenceFieldUpdater.set(this, arrayList);
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }

        @Override // kotlinx.coroutines.Incomplete
        public final NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return (Throwable) _rootCause$FU.get(this);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isActive() {
            if (getRootCause() == null) {
                return true;
            }
            return false;
        }

        public final boolean isCancelling() {
            if (getRootCause() != null) {
                return true;
            }
            return false;
        }

        public final boolean isCompleting() {
            if (_isCompleting$FU.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final ArrayList sealLocked(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else if (obj instanceof ArrayList) {
                arrayList = (ArrayList) obj;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th != null && !Intrinsics.areEqual(th, rootCause)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, JobSupportKt.SEALED);
            return arrayList;
        }

        public final String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + _exceptionsHolder$FU.get(this) + ", list=" + this.list + ']';
        }
    }

    public JobSupport(boolean z) {
        Empty empty;
        if (z) {
            empty = JobSupportKt.EMPTY_ACTIVE;
        } else {
            empty = JobSupportKt.EMPTY_NEW;
        }
        this._state = empty;
    }

    public static ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public static String stateString(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.isCancelling()) {
                return "Cancelling";
            }
            if (finishing.isCompleting()) {
                return "Completing";
            }
        } else if (obj instanceof Incomplete) {
            if (!((Incomplete) obj).isActive()) {
                return "New";
            }
        } else {
            if (obj instanceof CompletedExceptionally) {
                return "Cancelled";
            }
            return "Completed";
        }
        return "Active";
    }

    public final boolean addLastAtomic(final Object obj, NodeList nodeList, final JobNode jobNode) {
        boolean z;
        char c;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(jobNode) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            public final Symbol prepare(Object obj2) {
                boolean z2;
                if (this.getState$kotlinx_coroutines_core() == obj) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return null;
                }
                return LockFreeLinkedListKt.CONDITION_FALSE;
            }
        };
        do {
            LockFreeLinkedListNode prevNode = nodeList.getPrevNode();
            LockFreeLinkedListNode._prev$FU.lazySet(jobNode, prevNode);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode._next$FU;
            atomicReferenceFieldUpdater.lazySet(jobNode, nodeList);
            condAddOp.oldNext = nodeList;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(prevNode, nodeList, condAddOp)) {
                    z = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(prevNode) != nodeList) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                c = 0;
            } else if (condAddOp.perform(prevNode) == null) {
                c = 1;
            } else {
                c = 2;
            }
            if (c == 1) {
                return true;
            }
        } while (c != 2);
        return false;
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(JobSupport jobSupport) {
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(this, true, new ChildHandleNode(jobSupport), 2);
        Intrinsics.checkNotNull(invokeOnCompletion$default, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) invokeOnCompletion$default;
    }

    public final Object awaitInternal(Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
                }
                throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        awaitContinuation.invokeOnCancellation(new DisposeOnCancel(invokeOnCompletion(new ResumeAwaitOnCompletion(awaitContinuation))));
        Object result = awaitContinuation.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0111, code lost:            return true;     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:            r0 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:            if (r0 != kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L128;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:            return true;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            r0 = tryMakeCompleting(r0, new kotlinx.coroutines.CompletedExceptionally(createCauseException(r10), false));     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:            if (r0 == kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY) goto L205;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:            if (r0 != kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY) goto L189;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:            r0 = null;        r1 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:            r4 = getState$kotlinx_coroutines_core();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:            if ((r4 instanceof kotlinx.coroutines.JobSupport.Finishing) == false) goto L159;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:            if ((r4 instanceof kotlinx.coroutines.Incomplete) == false) goto L209;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:            if (r1 != null) goto L163;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:            r1 = createCauseException(r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:            r5 = (kotlinx.coroutines.Incomplete) r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:            if (getOnCancelComplete$kotlinx_coroutines_core() != false) goto L114;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:            if (r5.isActive() == false) goto L206;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d0, code lost:            r5 = tryMakeCompleting(r4, new kotlinx.coroutines.CompletedExceptionally(r1, false));     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:            if (r5 == kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY) goto L211;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00df, code lost:            if (r5 == kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY) goto L214;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e1, code lost:            r0 = r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:            r0 = getState$kotlinx_coroutines_core();     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fa, code lost:            throw new java.lang.IllegalStateException(("Cannot happen in " + r4).toString());     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a6, code lost:            r6 = getOrPromoteCancellingList(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00aa, code lost:            if (r6 != null) goto L168;     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ad, code lost:            r7 = new kotlinx.coroutines.JobSupport.Finishing(r6, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:            r4 = kotlinx.coroutines.JobSupport._state$FU;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b8, code lost:            if (r4.compareAndSet(r9, r5, r7) == false) goto L172;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:            if ((r0 instanceof kotlinx.coroutines.Incomplete) == false) goto L202;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c0, code lost:            if (r4.get(r9) == r5) goto L218;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c2, code lost:            r4 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c3, code lost:            if (r4 != false) goto L177;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c7, code lost:            notifyCancelling(r6, r1);        r4 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cb, code lost:            if (r4 == false) goto L215;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cd, code lost:            r10 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY;     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fd, code lost:            r0 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ba, code lost:            r4 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c5, code lost:            r4 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fb, code lost:            r10 = kotlinx.coroutines.JobSupportKt.TOO_LATE_TO_CANCEL;     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0047, code lost:            monitor-enter(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:            if ((r0 instanceof kotlinx.coroutines.JobSupport.Finishing) == false) goto L121;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0053, code lost:            if (kotlinx.coroutines.JobSupport.Finishing._exceptionsHolder$FU.get((kotlinx.coroutines.JobSupport.Finishing) r4) != kotlinx.coroutines.JobSupportKt.SEALED) goto L137;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0055, code lost:            r5 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0058, code lost:            if (r5 == false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x005a, code lost:            r10 = kotlinx.coroutines.JobSupportKt.TOO_LATE_TO_CANCEL;     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x005c, code lost:            monitor-exit(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x005f, code lost:            r5 = ((kotlinx.coroutines.JobSupport.Finishing) r4).isCancelling();     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0066, code lost:            if (r10 != null) goto L145;     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0068, code lost:            if (r5 != false) goto L148;     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0076, code lost:            r10 = ((kotlinx.coroutines.JobSupport.Finishing) r4).getRootCause();     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x007f, code lost:            if ((!r5) == false) goto L152;     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0081, code lost:            r0 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0082, code lost:            monitor-exit(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0083, code lost:            if (r0 == null) goto L155;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0085, code lost:            notifyCancelling(((kotlinx.coroutines.JobSupport.Finishing) r4).list, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x008c, code lost:            r10 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY;     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x006a, code lost:            if (r1 != null) goto L147;     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x006c, code lost:            r1 = createCauseException(r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0070, code lost:            ((kotlinx.coroutines.JobSupport.Finishing) r4).addExceptionLocked(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0057, code lost:            r5 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:            if (((kotlinx.coroutines.JobSupport.Finishing) r0).isCompleting() == false) goto L121;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0100, code lost:            if (r0 != kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY) goto L192;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0105, code lost:            if (r0 != kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L195;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x010a, code lost:            if (r0 != kotlinx.coroutines.JobSupportKt.TOO_LATE_TO_CANCEL) goto L198;     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x010d, code lost:            afterCompletion(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:            return false;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean cancelImpl$kotlinx_coroutines_core(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.cancelImpl$kotlinx_coroutines_core(java.lang.Object):boolean");
    }

    public void cancelInternal(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandle = (ChildHandle) _parentHandle$FU.get(this);
        if (childHandle != null && childHandle != NonDisposableHandle.INSTANCE) {
            if (childHandle.childCancelled(th) || z) {
                return true;
            }
            return false;
        }
        return z;
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (cancelImpl$kotlinx_coroutines_core(th) && getHandlesException$kotlinx_coroutines_core()) {
            return true;
        }
        return false;
    }

    public boolean complete(Object obj) {
        return makeCompleting$kotlinx_coroutines_core(obj);
    }

    public final void completeStateFinalization(Incomplete incomplete, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle != null) {
            childHandle.dispose();
            atomicReferenceFieldUpdater.set(this, NonDisposableHandle.INSTANCE);
        }
        CompletionHandlerException completionHandlerException = null;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.cause;
        } else {
            th = null;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            Object next = list.getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, list); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            kotlin.ExceptionsKt.addSuppressed(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
            }
        }
    }

    public final Throwable createCauseException(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof Throwable;
        }
        if (z) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return th;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).getChildJobCancellationCause();
    }

    public final Object finalizeFinishingState(Finishing finishing, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable finalRootCause;
        Object obj2;
        boolean z;
        Throwable th = null;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.cause;
        }
        synchronized (finishing) {
            finishing.isCancelling();
            ArrayList<Throwable> sealLocked = finishing.sealLocked(th);
            finalRootCause = getFinalRootCause(finishing, sealLocked);
            if (finalRootCause != null && sealLocked.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(sealLocked.size()));
                for (Throwable th2 : sealLocked) {
                    if (th2 != finalRootCause && th2 != finalRootCause && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                        kotlin.ExceptionsKt.addSuppressed(finalRootCause, th2);
                    }
                }
            }
        }
        if (finalRootCause != null && finalRootCause != th) {
            obj = new CompletedExceptionally(finalRootCause, false);
        }
        if (finalRootCause != null) {
            if (!cancelParent(finalRootCause) && !handleJobException(finalRootCause)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                CompletedExceptionally._handled$FU.compareAndSet((CompletedExceptionally) obj, 0, 1);
            }
        }
        onCompletionInternal(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        if (obj instanceof Incomplete) {
            obj2 = new IncompleteStateBox((Incomplete) obj);
        } else {
            obj2 = obj;
        }
        while (!atomicReferenceFieldUpdater.compareAndSet(this, finishing, obj2) && atomicReferenceFieldUpdater.get(this) == finishing) {
        }
        completeStateFinalization(finishing, obj);
        return obj;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(r, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException = null;
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                String concat = getClass().getSimpleName().concat(" is cancelling");
                if (rootCause instanceof CancellationException) {
                    cancellationException = (CancellationException) rootCause;
                }
                if (cancellationException == null) {
                    if (concat == null) {
                        concat = cancellationExceptionMessage();
                    }
                    return new JobCancellationException(concat, rootCause, this);
                }
                return cancellationException;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                if (th instanceof CancellationException) {
                    cancellationException = (CancellationException) th;
                }
                if (cancellationException == null) {
                    return new JobCancellationException(cancellationExceptionMessage(), th, this);
                }
                return cancellationException;
            }
            return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.ParentJob
    public final CancellationException getChildJobCancellationCause() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException2 = null;
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            cancellationException = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            cancellationException = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new JobCancellationException("Parent job is ".concat(stateString(state$kotlinx_coroutines_core)), cancellationException, this);
        }
        return cancellationException2;
    }

    public Object getCompleted() {
        return getCompletedInternal$kotlinx_coroutines_core();
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Throwable getCompletionExceptionOrNull() {
        CompletedExceptionally completedExceptionally;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
            } else {
                completedExceptionally = null;
            }
            if (completedExceptionally == null) {
                return null;
            }
            return completedExceptionally.cause;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Throwable getFinalRootCause(Finishing finishing, ArrayList arrayList) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (!finishing.isCancelling()) {
                return null;
            }
            return new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key.$$INSTANCE;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return this instanceof CompletableDeferredImpl;
    }

    public final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list == null) {
            if (incomplete instanceof Empty) {
                return new NodeList();
            }
            if (incomplete instanceof JobNode) {
                promoteSingleToNodeList((JobNode) incomplete);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + incomplete).toString());
        }
        return list;
    }

    @Override // kotlinx.coroutines.Job
    public final Job getParent() {
        ChildHandle childHandle = (ChildHandle) _parentHandle$FU.get(this);
        if (childHandle != null) {
            return childHandle.getParent();
        }
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = _state$FU.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public boolean handleJobException(Throwable th) {
        return false;
    }

    public final void initParentJob(Job job) {
        NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
            return;
        }
        job.start();
        ChildHandle attachChild = job.attachChild(this);
        atomicReferenceFieldUpdater.set(this, attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
        }
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletion(false, true, function1);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally) && (!(state$kotlinx_coroutines_core instanceof Finishing) || !((Finishing) state$kotlinx_coroutines_core).isCancelling())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public boolean isScopedCoroutine() {
        return this instanceof BlockingCoroutine;
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> continuation) {
        boolean z;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                z = false;
                break;
            }
            if (startInternal(state$kotlinx_coroutines_core) >= 0) {
                z = true;
                break;
            }
        }
        if (!z) {
            JobKt.ensureActive(continuation.getContext());
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new DisposeOnCancel(invokeOnCompletion(new ResumeOnCompletion(cancellableContinuationImpl))));
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (result != coroutineSingletons) {
            result = Unit.INSTANCE;
        }
        if (result == coroutineSingletons) {
            return result;
        }
        return Unit.INSTANCE;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        Object tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                return false;
            }
            if (tryMakeCompleting == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        afterCompletion(tryMakeCompleting);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object tryMakeCompleting;
        CompletedExceptionally completedExceptionally;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (obj instanceof CompletedExceptionally) {
                    completedExceptionally = (CompletedExceptionally) obj;
                } else {
                    completedExceptionally = null;
                }
                if (completedExceptionally != null) {
                    th = completedExceptionally.cause;
                }
                throw new IllegalStateException(str, th);
            }
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return tryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return getClass().getSimpleName();
    }

    public final void notifyCancelling(NodeList nodeList, Throwable th) {
        Object next = nodeList.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        cancelParent(th);
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(JobSupport jobSupport) {
        cancelImpl$kotlinx_coroutines_core(jobSupport);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CoroutineContext.DefaultImpls.plus(this, context);
    }

    public final void promoteSingleToNodeList(JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z;
        NodeList nodeList = new NodeList();
        jobNode.getClass();
        LockFreeLinkedListNode._prev$FU.lazySet(nodeList, jobNode);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode._next$FU;
        atomicReferenceFieldUpdater2.lazySet(nodeList, jobNode);
        while (true) {
            if (jobNode.getNext() != jobNode) {
                break;
            }
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(jobNode, jobNode, nodeList)) {
                    z = true;
                    break;
                } else if (atomicReferenceFieldUpdater2.get(jobNode) != jobNode) {
                    z = false;
                    break;
                }
            }
            if (z) {
                nodeList.finishAdd(jobNode);
                break;
            }
        }
        LockFreeLinkedListNode nextNode = jobNode.getNextNode();
        do {
            atomicReferenceFieldUpdater = _state$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, jobNode, nextNode)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == jobNode);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    public final int startInternal(Object obj) {
        boolean z = obj instanceof Empty;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        boolean z2 = false;
        if (z) {
            if (((Empty) obj).isActive) {
                return 0;
            }
            Empty empty = JobSupportKt.EMPTY_ACTIVE;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, empty)) {
                    z2 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            if (!z2) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        NodeList nodeList = ((InactiveNodeList) obj).list;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj, nodeList)) {
                z2 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                break;
            }
        }
        if (!z2) {
            return -1;
        }
        onStart();
        return 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}');
        sb.append('@');
        sb.append(DebugStringsKt.getHexAddress(this));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Throwable, T] */
    public final Object tryMakeCompleting(Object obj, Object obj2) {
        Object obj3;
        boolean z;
        Finishing finishing;
        CompletedExceptionally completedExceptionally;
        ChildHandleNode childHandleNode;
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.COMPLETING_ALREADY;
        }
        boolean z2 = true;
        boolean z3 = false;
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            Incomplete incomplete = (Incomplete) obj;
            if (obj2 instanceof Incomplete) {
                obj3 = new IncompleteStateBox((Incomplete) obj2);
            } else {
                obj3 = obj2;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, obj3)) {
                    z = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                z2 = false;
            } else {
                onCompletionInternal(obj2);
                completeStateFinalization(incomplete, obj2);
            }
            if (z2) {
                return obj2;
            }
            return JobSupportKt.COMPLETING_RETRY;
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete2);
        if (orPromoteCancellingList == null) {
            return JobSupportKt.COMPLETING_RETRY;
        }
        ChildHandleNode childHandleNode2 = null;
        if (incomplete2 instanceof Finishing) {
            finishing = (Finishing) incomplete2;
        } else {
            finishing = null;
        }
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            Finishing._isCompleting$FU.set(finishing, 1);
            if (finishing != incomplete2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, incomplete2, finishing)) {
                        z3 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater2.get(this) != incomplete2) {
                        break;
                    }
                }
                if (!z3) {
                    return JobSupportKt.COMPLETING_RETRY;
                }
            }
            boolean isCancelling = finishing.isCancelling();
            if (obj2 instanceof CompletedExceptionally) {
                completedExceptionally = (CompletedExceptionally) obj2;
            } else {
                completedExceptionally = null;
            }
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            ?? rootCause = Boolean.valueOf(true ^ isCancelling).booleanValue() ? finishing.getRootCause() : 0;
            ref$ObjectRef.element = rootCause;
            Unit unit = Unit.INSTANCE;
            if (rootCause != 0) {
                notifyCancelling(orPromoteCancellingList, rootCause);
            }
            if (incomplete2 instanceof ChildHandleNode) {
                childHandleNode = (ChildHandleNode) incomplete2;
            } else {
                childHandleNode = null;
            }
            if (childHandleNode == null) {
                NodeList list = incomplete2.getList();
                if (list != null) {
                    childHandleNode2 = nextChild(list);
                }
            } else {
                childHandleNode2 = childHandleNode;
            }
            if (childHandleNode2 != null && tryWaitForChild(finishing, childHandleNode2, obj2)) {
                return JobSupportKt.COMPLETING_WAITING_CHILDREN;
            }
            return finalizeFinishingState(finishing, obj2);
        }
    }

    public final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.invokeOnCompletion$default(childHandleNode.childJob, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1) == NonDisposableHandle.INSTANCE) {
            childHandleNode = nextChild(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [kotlinx.coroutines.InactiveNodeList] */
    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        JobNode jobNode;
        boolean z3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Throwable th;
        if (z) {
            jobNode = function1 instanceof JobCancellingNode ? (JobCancellingNode) function1 : null;
            if (jobNode == null) {
                jobNode = new InvokeOnCancelling(function1);
            }
        } else {
            jobNode = function1 instanceof JobNode ? (JobNode) function1 : null;
            if (jobNode == null) {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.job = this;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                    while (true) {
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, state$kotlinx_coroutines_core, jobNode)) {
                            z3 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater2.get(this) != state$kotlinx_coroutines_core) {
                            z3 = false;
                            break;
                        }
                    }
                    if (z3) {
                        return jobNode;
                    }
                } else {
                    NodeList nodeList = new NodeList();
                    if (!empty.isActive) {
                        nodeList = new InactiveNodeList(nodeList);
                    }
                    do {
                        atomicReferenceFieldUpdater = _state$FU;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, empty, nodeList)) {
                            break;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == empty);
                }
            } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list == null) {
                    Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else {
                    DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                    if (z && (state$kotlinx_coroutines_core instanceof Finishing)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            th = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                            if (th == null || ((function1 instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                                if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                                    if (th == null) {
                                        return jobNode;
                                    }
                                    disposableHandle = jobNode;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z2) {
                            function1.invoke(th);
                        }
                        return disposableHandle;
                    }
                    if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                        return jobNode;
                    }
                }
            } else {
                if (z2) {
                    CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core : null;
                    function1.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                }
                return NonDisposableHandle.INSTANCE;
            }
        }
    }

    public void onStart() {
    }

    public void afterCompletion(Object obj) {
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(CompletionHandlerException completionHandlerException) {
        throw completionHandlerException;
    }

    public void onCompletionInternal(Object obj) {
    }
}
