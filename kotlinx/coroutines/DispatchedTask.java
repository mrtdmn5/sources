package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.Task;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes4.dex */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public DispatchedTask(int r1) {
        this.resumeMode = r1;
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.cause;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.checkNotNull(th);
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:            r6 = (kotlinx.coroutines.Job) r6.get(kotlinx.coroutines.Job.Key.$$INSTANCE);     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r12 = this;
            kotlinx.coroutines.scheduling.TaskContext r0 = r12.taskContext
            kotlin.coroutines.Continuation r1 = r12.getDelegate$kotlinx_coroutines_core()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L9e
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch: java.lang.Throwable -> L9e
            kotlin.coroutines.Continuation<T> r2 = r1.continuation     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r1 = r1.countOrElement     // Catch: java.lang.Throwable -> L9e
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r3, r1)     // Catch: java.lang.Throwable -> L9e
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch: java.lang.Throwable -> L9e
            r5 = 0
            if (r1 == r4) goto L23
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r2, r3, r1)     // Catch: java.lang.Throwable -> L9e
            goto L24
        L23:
            r4 = r5
        L24:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r7 = r12.takeState$kotlinx_coroutines_core()     // Catch: java.lang.Throwable -> L5f
            java.lang.Throwable r8 = r12.getExceptionalResult$kotlinx_coroutines_core(r7)     // Catch: java.lang.Throwable -> L5f
            if (r8 != 0) goto L47
            int r9 = r12.resumeMode     // Catch: java.lang.Throwable -> L5f
            r10 = 1
            if (r9 == r10) goto L3c
            r11 = 2
            if (r9 != r11) goto L3b
            goto L3c
        L3b:
            r10 = 0
        L3c:
            if (r10 == 0) goto L47
            kotlinx.coroutines.Job$Key r9 = kotlinx.coroutines.Job.Key.$$INSTANCE     // Catch: java.lang.Throwable -> L5f
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch: java.lang.Throwable -> L5f
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch: java.lang.Throwable -> L5f
            goto L48
        L47:
            r6 = r5
        L48:
            if (r6 == 0) goto L61
            boolean r9 = r6.isActive()     // Catch: java.lang.Throwable -> L5f
            if (r9 != 0) goto L61
            java.util.concurrent.CancellationException r6 = r6.getCancellationException()     // Catch: java.lang.Throwable -> L5f
            r12.cancelCompletedResult$kotlinx_coroutines_core(r7, r6)     // Catch: java.lang.Throwable -> L5f
            kotlin.Result$Failure r6 = kotlin.ResultKt.createFailure(r6)     // Catch: java.lang.Throwable -> L5f
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> L5f
            goto L72
        L5f:
            r2 = move-exception
            goto L92
        L61:
            if (r8 == 0) goto L6b
            kotlin.Result$Failure r6 = kotlin.ResultKt.createFailure(r8)     // Catch: java.lang.Throwable -> L5f
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> L5f
            goto L72
        L6b:
            java.lang.Object r6 = r12.getSuccessfulResult$kotlinx_coroutines_core(r7)     // Catch: java.lang.Throwable -> L5f
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> L5f
        L72:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5f
            if (r4 == 0) goto L7c
            boolean r2 = r4.clearThreadContext()     // Catch: java.lang.Throwable -> L9e
            if (r2 == 0) goto L7f
        L7c:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch: java.lang.Throwable -> L9e
        L7f:
            r0.afterTask()     // Catch: java.lang.Throwable -> L85
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L85
            goto L8a
        L85:
            r0 = move-exception
            kotlin.Result$Failure r0 = kotlin.ResultKt.createFailure(r0)
        L8a:
            java.lang.Throwable r0 = kotlin.Result.m1661exceptionOrNullimpl(r0)
            r12.handleFatalException$kotlinx_coroutines_core(r5, r0)
            goto Lb1
        L92:
            if (r4 == 0) goto L9a
            boolean r4 = r4.clearThreadContext()     // Catch: java.lang.Throwable -> L9e
            if (r4 == 0) goto L9d
        L9a:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch: java.lang.Throwable -> L9e
        L9d:
            throw r2     // Catch: java.lang.Throwable -> L9e
        L9e:
            r1 = move-exception
            r0.afterTask()     // Catch: java.lang.Throwable -> La5
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La5
            goto Laa
        La5:
            r0 = move-exception
            kotlin.Result$Failure r0 = kotlin.ResultKt.createFailure(r0)
        Laa:
            java.lang.Throwable r0 = kotlin.Result.m1661exceptionOrNullimpl(r0)
            r12.handleFatalException$kotlinx_coroutines_core(r1, r0)
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException) {
    }
}
