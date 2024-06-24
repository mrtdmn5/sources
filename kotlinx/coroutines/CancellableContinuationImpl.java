package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes4.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;
    public final CoroutineContext context;
    public final Continuation<T> delegate;
    public static final AtomicIntegerFieldUpdater _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex");
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle");

    public CancellableContinuationImpl(int r1, Continuation continuation) {
        super(r1);
        this.delegate = continuation;
        this.context = continuation.getContext();
        this._decisionAndIndex = 536870911;
        this._state = Active.INSTANCE;
    }

    public static void multipleHandlersError(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object resumedState(NotCompleted notCompleted, Object obj, int r8, Function1 function1) {
        CancelHandler cancelHandler;
        if (!(obj instanceof CompletedExceptionally)) {
            boolean z = true;
            if (r8 != 1 && r8 != 2) {
                z = false;
            }
            if (z) {
                if (function1 != null || (notCompleted instanceof CancelHandler)) {
                    if (notCompleted instanceof CancelHandler) {
                        cancelHandler = (CancelHandler) notCompleted;
                    } else {
                        cancelHandler = null;
                    }
                    return new CompletedContinuation(obj, cancelHandler, function1, (CancellationException) null, 16);
                }
                return obj;
            }
            return obj;
        }
        return obj;
    }

    public final void callCancelHandler(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void callSegmentOnCancellation(Segment<?> segment, Throwable th) {
        boolean z;
        CoroutineContext coroutineContext = this.context;
        int r0 = _decisionAndIndex$FU.get(this) & 536870911;
        if (r0 != 536870911) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            try {
                segment.onCancellation(r0, coroutineContext);
                return;
            } catch (Throwable th2) {
                CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean cancel(Throwable th) {
        Object obj;
        boolean z;
        boolean z2;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            obj = atomicReferenceFieldUpdater.get(this);
            z = false;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            if (!(obj instanceof CancelHandler) && !(obj instanceof Segment)) {
                z2 = false;
            } else {
                z2 = true;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, th, z2);
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, cancelledContinuation)) {
                    z = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        } while (!z);
        NotCompleted notCompleted = (NotCompleted) obj;
        if (notCompleted instanceof CancelHandler) {
            callCancelHandler((CancelHandler) obj, th);
        } else if (notCompleted instanceof Segment) {
            callSegmentOnCancellation((Segment) obj, th);
        }
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
        dispatchResume(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CompletedExceptionally) {
                    return;
                }
                boolean z2 = true;
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (completedContinuation.cancelCause != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        CompletedContinuation copy$default = CompletedContinuation.copy$default(completedContinuation, null, cancellationException, 15);
                        while (true) {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, copy$default)) {
                                break;
                            } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                z2 = false;
                                break;
                            }
                        }
                        if (z2) {
                            CancelHandler cancelHandler = completedContinuation.cancelHandler;
                            if (cancelHandler != null) {
                                callCancelHandler(cancelHandler, cancellationException);
                            }
                            Function1<Throwable, Unit> function1 = completedContinuation.onCancellation;
                            if (function1 != null) {
                                callOnCancellation(function1, cancellationException);
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    CompletedContinuation completedContinuation2 = new CompletedContinuation(obj2, (CancelHandler) null, (Function1) null, cancellationException, 14);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, completedContinuation2)) {
                            break;
                        } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        return;
                    }
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void completeResume(Object obj) {
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater.get(this);
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        atomicReferenceFieldUpdater.set(this, NonDisposableHandle.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:            if (r7 != 4) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:            r0 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:            r1 = r6.delegate;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:            if (r0 != false) goto L114;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:            if ((r1 instanceof kotlinx.coroutines.internal.DispatchedContinuation) == false) goto L114;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:            if (r7 == 1) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:            if (r7 != 2) goto L89;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:            r7 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:            r5 = r6.resumeMode;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:            if (r5 == 1) goto L94;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:            if (r5 != 2) goto L95;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:            if (r7 != r4) goto L114;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:            r7 = ((kotlinx.coroutines.internal.DispatchedContinuation) r1).dispatcher;        r0 = r1.getContext();     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:            if (r7.isDispatchNeeded(r0) == false) goto L99;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:            r7.dispatch(r0, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:            r7 = kotlinx.coroutines.ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:            if (r7.isUnconfinedLoopActive() == false) goto L102;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:            r7.dispatchUnconfined(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:            r7.incrementUseCount(true);     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:            kotlinx.coroutines.DispatchedTaskKt.resume(r6, r1, true);     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:            if (r7.processUnconfinedEvent() != false) goto L124;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0088, code lost:            throw r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x004a, code lost:            r4 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0043, code lost:            r7 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:            kotlinx.coroutines.DispatchedTaskKt.resume(r6, r1, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008c, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0032, code lost:            r0 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:            if (r0 == false) goto L77;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void dispatchResume(int r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.CancellableContinuationImpl._decisionAndIndex$FU
            int r1 = r0.get(r6)
            int r2 = r1 >> 29
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1c
            if (r2 != r3) goto L10
            r0 = r4
            goto L2a
        L10:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already resumed"
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L1c:
            r2 = 536870911(0x1fffffff, float:1.0842021E-19)
            r2 = r2 & r1
            r5 = 1073741824(0x40000000, float:2.0)
            int r2 = r2 + r5
            boolean r0 = r0.compareAndSet(r6, r1, r2)
            if (r0 == 0) goto L0
            r0 = r3
        L2a:
            if (r0 == 0) goto L2d
            return
        L2d:
            r0 = 4
            if (r7 != r0) goto L32
            r0 = r3
            goto L33
        L32:
            r0 = r4
        L33:
            kotlin.coroutines.Continuation<T> r1 = r6.delegate
            if (r0 != 0) goto L89
            boolean r2 = r1 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r2 == 0) goto L89
            r2 = 2
            if (r7 == r3) goto L43
            if (r7 != r2) goto L41
            goto L43
        L41:
            r7 = r4
            goto L44
        L43:
            r7 = r3
        L44:
            int r5 = r6.resumeMode
            if (r5 == r3) goto L4a
            if (r5 != r2) goto L4b
        L4a:
            r4 = r3
        L4b:
            if (r7 != r4) goto L89
            r7 = r1
            kotlinx.coroutines.internal.DispatchedContinuation r7 = (kotlinx.coroutines.internal.DispatchedContinuation) r7
            kotlinx.coroutines.CoroutineDispatcher r7 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r0 = r1.getContext()
            boolean r2 = r7.isDispatchNeeded(r0)
            if (r2 == 0) goto L60
            r7.dispatch(r0, r6)
            goto L8c
        L60:
            kotlinx.coroutines.EventLoop r7 = kotlinx.coroutines.ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core()
            boolean r0 = r7.isUnconfinedLoopActive()
            if (r0 == 0) goto L6e
            r7.dispatchUnconfined(r6)
            goto L8c
        L6e:
            r7.incrementUseCount(r3)
            kotlinx.coroutines.DispatchedTaskKt.resume(r6, r1, r3)     // Catch: java.lang.Throwable -> L7b
        L74:
            boolean r0 = r7.processUnconfinedEvent()     // Catch: java.lang.Throwable -> L7b
            if (r0 != 0) goto L74
            goto L80
        L7b:
            r0 = move-exception
            r1 = 0
            r6.handleFatalException$kotlinx_coroutines_core(r0, r1)     // Catch: java.lang.Throwable -> L84
        L80:
            r7.decrementUseCount(r3)
            goto L8c
        L84:
            r0 = move-exception
            r7.decrementUseCount(r3)
            throw r0
        L89:
            kotlinx.coroutines.DispatchedTaskKt.resume(r6, r1, r0)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CancellableContinuationImpl.dispatchResume(int):void");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(JobSupport jobSupport) {
        return jobSupport.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core == null) {
            return null;
        }
        return exceptionalResult$kotlinx_coroutines_core;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:            if (((kotlinx.coroutines.DisposableHandle) kotlinx.coroutines.CancellableContinuationImpl._parentHandle$FU.get(r8)) != null) goto L59;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:            installParentHandle();     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:            if (r0 == false) goto L61;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:            releaseClaimedReusableContinuation$kotlinx_coroutines_core();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:            return kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:            if (r0 == false) goto L65;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:            releaseClaimedReusableContinuation$kotlinx_coroutines_core();     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:            r0 = kotlinx.coroutines.CancellableContinuationImpl._state$FU.get(r8);     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:            if ((r0 instanceof kotlinx.coroutines.CompletedExceptionally) != false) goto L81;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:            r1 = r8.resumeMode;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:            if (r1 == 1) goto L70;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:            if (r1 != 2) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:            if (r4 == false) goto L79;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:            r1 = (kotlinx.coroutines.Job) r8.context.get(kotlinx.coroutines.Job.Key.$$INSTANCE);     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:            if (r1 == null) goto L79;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:            if (r1.isActive() == false) goto L77;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:            r1 = r1.getCancellationException();        cancelCompletedResult$kotlinx_coroutines_core(r0, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:            throw r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:            return getSuccessfulResult$kotlinx_coroutines_core(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:            r4 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:            throw ((kotlinx.coroutines.CompletedExceptionally) r0).cause;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:            if (r1 == false) goto L63;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getResult() {
        /*
            r8 = this;
            boolean r0 = r8.isReusable()
        L4:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = kotlinx.coroutines.CancellableContinuationImpl._decisionAndIndex$FU
            int r2 = r1.get(r8)
            int r3 = r2 >> 29
            r4 = 0
            r5 = 1
            r6 = 2
            if (r3 == 0) goto L21
            if (r3 != r6) goto L15
            r1 = r4
            goto L2f
        L15:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Already suspended"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L21:
            r3 = 536870911(0x1fffffff, float:1.0842021E-19)
            r3 = r3 & r2
            r7 = 536870912(0x20000000, float:1.0842022E-19)
            int r3 = r3 + r7
            boolean r1 = r1.compareAndSet(r8, r2, r3)
            if (r1 == 0) goto L4
            r1 = r5
        L2f:
            if (r1 == 0) goto L46
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.CancellableContinuationImpl._parentHandle$FU
            java.lang.Object r1 = r1.get(r8)
            kotlinx.coroutines.DisposableHandle r1 = (kotlinx.coroutines.DisposableHandle) r1
            if (r1 != 0) goto L3e
            r8.installParentHandle()
        L3e:
            if (r0 == 0) goto L43
            r8.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
        L43:
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            return r0
        L46:
            if (r0 == 0) goto L4b
            r8.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
        L4b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.CancellableContinuationImpl._state$FU
            java.lang.Object r0 = r0.get(r8)
            boolean r1 = r0 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r1 != 0) goto L7e
            int r1 = r8.resumeMode
            if (r1 == r5) goto L5b
            if (r1 != r6) goto L5c
        L5b:
            r4 = r5
        L5c:
            if (r4 == 0) goto L79
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.Key.$$INSTANCE
            kotlin.coroutines.CoroutineContext r2 = r8.context
            kotlin.coroutines.CoroutineContext$Element r1 = r2.get(r1)
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            if (r1 == 0) goto L79
            boolean r2 = r1.isActive()
            if (r2 == 0) goto L71
            goto L79
        L71:
            java.util.concurrent.CancellationException r1 = r1.getCancellationException()
            r8.cancelCompletedResult$kotlinx_coroutines_core(r0, r1)
            throw r1
        L79:
            java.lang.Object r0 = r8.getSuccessfulResult$kotlinx_coroutines_core(r0)
            return r0
        L7e:
            kotlinx.coroutines.CompletedExceptionally r0 = (kotlinx.coroutines.CompletedExceptionally) r0
            java.lang.Throwable r0 = r0.cause
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CancellableContinuationImpl.getResult():java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public final <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        if (obj instanceof CompletedContinuation) {
            return (T) ((CompletedContinuation) obj).result;
        }
        return obj;
    }

    public final void initCancellability() {
        DisposableHandle installParentHandle = installParentHandle();
        if (installParentHandle != null && isCompleted()) {
            installParentHandle.dispose();
            _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    public final DisposableHandle installParentHandle() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) this.context.get(Job.Key.$$INSTANCE);
        if (job == null) {
            return null;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, new ChildContinuation(this), 2);
        do {
            atomicReferenceFieldUpdater = _parentHandle$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, invokeOnCompletion$default)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return invokeOnCompletion$default;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment<?> segment, int r6) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int r1;
        do {
            atomicIntegerFieldUpdater = _decisionAndIndex$FU;
            r1 = atomicIntegerFieldUpdater.get(this);
            if (!((r1 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, r1, ((r1 >> 29) << 29) + r6));
        invokeOnCancellationImpl(segment);
    }

    public final void invokeOnCancellationImpl(Object obj) {
        boolean z;
        boolean z2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z3 = true;
            if (obj2 instanceof Active) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    return;
                }
            } else {
                if (obj2 instanceof CancelHandler) {
                    z = true;
                } else {
                    z = obj2 instanceof Segment;
                }
                Throwable th = null;
                if (!z) {
                    boolean z4 = obj2 instanceof CompletedExceptionally;
                    if (z4) {
                        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj2;
                        completedExceptionally.getClass();
                        if (CompletedExceptionally._handled$FU.compareAndSet(completedExceptionally, 0, 1)) {
                            if (obj2 instanceof CancelledContinuation) {
                                if (!z4) {
                                    completedExceptionally = null;
                                }
                                if (completedExceptionally != null) {
                                    th = completedExceptionally.cause;
                                }
                                if (obj instanceof CancelHandler) {
                                    callCancelHandler((CancelHandler) obj, th);
                                    return;
                                } else {
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                    callSegmentOnCancellation((Segment) obj, th);
                                    return;
                                }
                            }
                            return;
                        }
                        multipleHandlersError(obj, obj2);
                        throw null;
                    }
                    if (obj2 instanceof CompletedContinuation) {
                        CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                        if (completedContinuation.cancelHandler == null) {
                            if (obj instanceof Segment) {
                                return;
                            }
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                            CancelHandler cancelHandler = (CancelHandler) obj;
                            Throwable th2 = completedContinuation.cancelCause;
                            if (th2 != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                callCancelHandler(cancelHandler, th2);
                                return;
                            }
                            CompletedContinuation copy$default = CompletedContinuation.copy$default(completedContinuation, cancelHandler, null, 29);
                            while (true) {
                                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, copy$default)) {
                                    break;
                                } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                    z3 = false;
                                    break;
                                }
                            }
                            if (z3) {
                                return;
                            }
                        } else {
                            multipleHandlersError(obj, obj2);
                            throw null;
                        }
                    } else {
                        if (obj instanceof Segment) {
                            return;
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        CompletedContinuation completedContinuation2 = new CompletedContinuation(obj2, (CancelHandler) obj, (Function1) null, (CancellationException) null, 28);
                        while (true) {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, completedContinuation2)) {
                                break;
                            } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            return;
                        }
                    }
                } else {
                    multipleHandlersError(obj, obj2);
                    throw null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isActive() {
        return _state$FU.get(this) instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isCompleted() {
        return !(_state$FU.get(this) instanceof NotCompleted);
    }

    public final boolean isReusable() {
        boolean z;
        boolean z2;
        if (this.resumeMode == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Continuation<T> continuation = this.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (DispatchedContinuation._reusableCancellableContinuation$FU.get((DispatchedContinuation) continuation) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public String nameString() {
        return "CancellableContinuation";
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:            if (r2 != null) goto L72;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:            detachChild$kotlinx_coroutines_core();        cancel(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        /*
            r7 = this;
            kotlin.coroutines.Continuation<T> r0 = r7.delegate
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            r2 = 0
            if (r1 == 0) goto La
            kotlinx.coroutines.internal.DispatchedContinuation r0 = (kotlinx.coroutines.internal.DispatchedContinuation) r0
            goto Lb
        La:
            r0 = r2
        Lb:
            if (r0 == 0) goto L6f
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.DispatchedContinuation._reusableCancellableContinuation$FU
            java.lang.Object r3 = r1.get(r0)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.DispatchedContinuationKt.REUSABLE_CLAIMED
            r5 = 0
            r6 = 1
            if (r3 != r4) goto L2a
        L19:
            boolean r3 = r1.compareAndSet(r0, r4, r7)
            if (r3 == 0) goto L21
            r5 = r6
            goto L27
        L21:
            java.lang.Object r3 = r1.get(r0)
            if (r3 == r4) goto L19
        L27:
            if (r5 == 0) goto Ld
            goto L41
        L2a:
            boolean r4 = r3 instanceof java.lang.Throwable
            if (r4 == 0) goto L57
        L2e:
            boolean r4 = r1.compareAndSet(r0, r3, r2)
            if (r4 == 0) goto L36
            r5 = r6
            goto L3c
        L36:
            java.lang.Object r4 = r1.get(r0)
            if (r4 == r3) goto L2e
        L3c:
            if (r5 == 0) goto L4b
            r2 = r3
            java.lang.Throwable r2 = (java.lang.Throwable) r2
        L41:
            if (r2 != 0) goto L44
            goto L6f
        L44:
            r7.detachChild$kotlinx_coroutines_core()
            r7.cancel(r2)
            return
        L4b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed requirement."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L57:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Inconsistent state "
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CancellableContinuationImpl.releaseClaimedReusableContinuation$kotlinx_coroutines_core():void");
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resume(T t, Function1<? super Throwable, Unit> function1) {
        resumeImpl(this.resumeMode, t, function1);
    }

    public final void resumeImpl(int r7, Object obj, Function1 function1) {
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            z = false;
            if (obj2 instanceof NotCompleted) {
                Object resumedState = resumedState((NotCompleted) obj2, obj, r7, function1);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, resumedState)) {
                        z = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    cancelledContinuation.getClass();
                    if (CancelledContinuation._resumed$FU.compareAndSet(cancelledContinuation, 0, 1)) {
                        if (function1 != null) {
                            callOnCancellation(function1, cancelledContinuation.cause);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
        } while (!z);
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
        dispatchResume(r7);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit) {
        DispatchedContinuation dispatchedContinuation;
        CoroutineDispatcher coroutineDispatcher2;
        int r4;
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        } else {
            coroutineDispatcher2 = null;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            r4 = 4;
        } else {
            r4 = this.resumeMode;
        }
        resumeImpl(r4, unit, null);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
        if (m1661exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(m1661exceptionOrNullimpl, false);
        }
        resumeImpl(this.resumeMode, obj, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object takeState$kotlinx_coroutines_core() {
        return _state$FU.get(this);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(nameString());
        sb.append('(');
        sb.append(DebugStringsKt.toDebugString(this.delegate));
        sb.append("){");
        Object obj = _state$FU.get(this);
        if (obj instanceof NotCompleted) {
            str = "Active";
        } else if (obj instanceof CancelledContinuation) {
            str = "Cancelled";
        } else {
            str = "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(DebugStringsKt.getHexAddress(this));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Symbol tryResume(Object obj, Function1 function1) {
        return tryResumeImpl(obj, function1);
    }

    public final Symbol tryResumeImpl(Object obj, Function1 function1) {
        Symbol symbol;
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z2 = obj2 instanceof NotCompleted;
            symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            if (z2) {
                Object resumedState = resumedState((NotCompleted) obj2, obj, this.resumeMode, function1);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, resumedState)) {
                        z = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        z = false;
                        break;
                    }
                }
            } else {
                boolean z3 = obj2 instanceof CompletedContinuation;
                return null;
            }
        } while (!z);
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
        return symbol;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Symbol tryResumeWithException(Throwable th) {
        return tryResumeImpl(new CompletedExceptionally(th, false), null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        invokeOnCancellationImpl(function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1));
    }
}
