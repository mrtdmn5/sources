package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class ResumeOnCompletion extends JobNode {
    public final Continuation<Unit> continuation;

    public ResumeOnCompletion(CancellableContinuationImpl cancellableContinuationImpl) {
        this.continuation = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.continuation.resumeWith(Unit.INSTANCE);
    }
}
