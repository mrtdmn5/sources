package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes4.dex */
public final class DispatchedContinuationKt {
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void resumeCancellableWith(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        Object completedExceptionally;
        UndispatchedCoroutine<?> undispatchedCoroutine;
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
            boolean z = false;
            if (m1661exceptionOrNullimpl == null) {
                if (function1 != null) {
                    completedExceptionally = new CompletedWithCancellation(obj, function1);
                } else {
                    completedExceptionally = obj;
                }
            } else {
                completedExceptionally = new CompletedExceptionally(m1661exceptionOrNullimpl, false);
            }
            Continuation<T> continuation2 = dispatchedContinuation.continuation;
            CoroutineContext context = dispatchedContinuation.getContext();
            CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation._state = completedExceptionally;
                dispatchedContinuation.resumeMode = 1;
                coroutineDispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = completedExceptionally;
                dispatchedContinuation.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key.$$INSTANCE);
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(completedExceptionally, cancellationException);
                    dispatchedContinuation.resumeWith(ResultKt.createFailure(cancellationException));
                    z = true;
                }
                if (!z) {
                    Object obj2 = dispatchedContinuation.countOrElement;
                    CoroutineContext context2 = continuation2.getContext();
                    Object updateThreadContext = ThreadContextKt.updateThreadContext(context2, obj2);
                    if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
                        undispatchedCoroutine = CoroutineContextKt.updateUndispatchedCompletion(continuation2, context2, updateThreadContext);
                    } else {
                        undispatchedCoroutine = null;
                    }
                    try {
                        continuation2.resumeWith(obj);
                        Unit unit = Unit.INSTANCE;
                        if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                            ThreadContextKt.restoreThreadContext(context2, updateThreadContext);
                        }
                    } catch (Throwable th) {
                        if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                            ThreadContextKt.restoreThreadContext(context2, updateThreadContext);
                        }
                        throw th;
                    }
                }
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }
}
