package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* loaded from: classes4.dex */
public final class BuildersKt {
    public static DeferredCoroutine async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int r4) {
        CoroutineStart coroutineStart;
        DeferredCoroutine deferredCoroutine;
        if ((r4 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((r4 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        } else {
            coroutineStart = null;
        }
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            deferredCoroutine = new LazyDeferredCoroutine(newCoroutineContext, function2);
        } else {
            deferredCoroutine = new DeferredCoroutine(newCoroutineContext, true);
        }
        coroutineStart.invoke(function2, deferredCoroutine, deferredCoroutine);
        return deferredCoroutine;
    }

    public static StandaloneCoroutine launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int r5) {
        StandaloneCoroutine standaloneCoroutine;
        if ((r5 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((r5 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            standaloneCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, function2);
        } else {
            standaloneCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        coroutineStart.invoke(function2, standaloneCoroutine, standaloneCoroutine);
        return standaloneCoroutine;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T runBlocking(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        EventLoop eventLoop;
        CoroutineContext foldCopies;
        long j;
        CompletedExceptionally completedExceptionally;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor.Key key = ContinuationInterceptor.Key.$$INSTANCE;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(key);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (continuationInterceptor == null) {
            eventLoop = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
            foldCopies = CoroutineContextKt.foldCopies(emptyCoroutineContext, coroutineContext.plus(eventLoop), true);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            if (foldCopies != defaultScheduler && foldCopies.get(key) == null) {
                foldCopies = foldCopies.plus(defaultScheduler);
            }
        } else {
            if (continuationInterceptor instanceof EventLoop) {
            }
            eventLoop = ThreadLocalEventLoop.ref.get();
            foldCopies = CoroutineContextKt.foldCopies(emptyCoroutineContext, coroutineContext, true);
            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
            if (foldCopies != defaultScheduler2 && foldCopies.get(key) == null) {
                foldCopies = foldCopies.plus(defaultScheduler2);
            }
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(foldCopies, currentThread, eventLoop);
        CoroutineStart.DEFAULT.invoke(function2, blockingCoroutine, blockingCoroutine);
        EventLoop eventLoop2 = blockingCoroutine.eventLoop;
        if (eventLoop2 != null) {
            int r0 = EventLoop.$r8$clinit;
            eventLoop2.incrementUseCount(false);
        }
        while (!Thread.interrupted()) {
            try {
                if (eventLoop2 != null) {
                    j = eventLoop2.processNextEvent();
                } else {
                    j = Long.MAX_VALUE;
                }
                if (!blockingCoroutine.isCompleted()) {
                    LockSupport.parkNanos(blockingCoroutine, j);
                } else {
                    T t = (T) JobSupportKt.unboxState(blockingCoroutine.getState$kotlinx_coroutines_core());
                    if (t instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) t;
                    } else {
                        completedExceptionally = null;
                    }
                    if (completedExceptionally == null) {
                        return t;
                    }
                    throw completedExceptionally.cause;
                }
            } finally {
                if (eventLoop2 != null) {
                    int r1 = EventLoop.$r8$clinit;
                    eventLoop2.decrementUseCount(false);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        blockingCoroutine.cancelImpl$kotlinx_coroutines_core(interruptedException);
        throw interruptedException;
    }

    public static final <T> Object withContext(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        CoroutineContext foldCopies;
        Object unboxState;
        CoroutineContext context = continuation.getContext();
        boolean z = false;
        if (!((Boolean) coroutineContext.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue()) {
            foldCopies = context.plus(coroutineContext);
        } else {
            foldCopies = CoroutineContextKt.foldCopies(context, coroutineContext, false);
        }
        JobKt.ensureActive(foldCopies);
        if (foldCopies == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation, foldCopies);
            unboxState = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.Key.$$INSTANCE;
            if (Intrinsics.areEqual(foldCopies.get(key), context.get(key))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(continuation, foldCopies);
                CoroutineContext coroutineContext2 = undispatchedCoroutine.context;
                Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext2, null);
                try {
                    Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                    unboxState = startUndispatchedOrReturn;
                } catch (Throwable th) {
                    ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(continuation, foldCopies);
                try {
                    DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, dispatchedCoroutine, dispatchedCoroutine)), Unit.INSTANCE, null);
                    while (true) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = DispatchedCoroutine._decision$FU;
                        int r5 = atomicIntegerFieldUpdater.get(dispatchedCoroutine);
                        if (r5 != 0) {
                            if (r5 != 2) {
                                throw new IllegalStateException("Already suspended".toString());
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(dispatchedCoroutine, 0, 1)) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        unboxState = CoroutineSingletons.COROUTINE_SUSPENDED;
                    } else {
                        unboxState = JobSupportKt.unboxState(dispatchedCoroutine.getState$kotlinx_coroutines_core());
                        if (unboxState instanceof CompletedExceptionally) {
                            throw ((CompletedExceptionally) unboxState).cause;
                        }
                    }
                } catch (Throwable th2) {
                    dispatchedCoroutine.resumeWith(ResultKt.createFailure(th2));
                    throw th2;
                }
            }
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return unboxState;
    }
}
