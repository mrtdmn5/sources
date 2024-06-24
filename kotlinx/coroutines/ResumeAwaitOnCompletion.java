package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.JobSupport;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class ResumeAwaitOnCompletion<T> extends JobNode {
    public final CancellableContinuationImpl<T> continuation;

    public ResumeAwaitOnCompletion(JobSupport.AwaitContinuation awaitContinuation) {
        this.continuation = awaitContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        boolean z = state$kotlinx_coroutines_core instanceof CompletedExceptionally;
        CancellableContinuationImpl<T> cancellableContinuationImpl = this.continuation;
        if (z) {
            cancellableContinuationImpl.resumeWith(ResultKt.createFailure(((CompletedExceptionally) state$kotlinx_coroutines_core).cause));
        } else {
            cancellableContinuationImpl.resumeWith(JobSupportKt.unboxState(state$kotlinx_coroutines_core));
        }
    }
}
