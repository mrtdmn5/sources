package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;

/* compiled from: AbstractCoroutine.kt */
/* loaded from: classes4.dex */
public abstract class AbstractCoroutine<T> extends JobSupport implements Continuation<T>, CoroutineScope {
    public final CoroutineContext context;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        initParentJob((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.context = coroutineContext.plus(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String cancellationExceptionMessage() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(CompletionHandlerException completionHandlerException) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, completionHandlerException);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(Object obj) {
        boolean z;
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            Throwable th = completedExceptionally.cause;
            completedExceptionally.getClass();
            if (CompletedExceptionally._handled$FU.get(completedExceptionally) != 0) {
                z = true;
            } else {
                z = false;
            }
            onCancelled(th, z);
            return;
        }
        onCompleted(obj);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
        if (m1661exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(m1661exceptionOrNullimpl, false);
        }
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(obj);
        if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(makeCompletingOnce$kotlinx_coroutines_core);
    }

    public void onCompleted(T t) {
    }

    public void onCancelled(Throwable th, boolean z) {
    }
}
