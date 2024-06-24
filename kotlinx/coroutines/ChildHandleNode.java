package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class ChildHandleNode extends JobCancellingNode implements ChildHandle {
    public final ChildJob childJob;

    public ChildHandleNode(JobSupport jobSupport) {
        this.childJob = jobSupport;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        return getJob().childCancelled(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke */
    public final void invoke2(Throwable th) {
        this.childJob.parentCancelled(getJob());
    }
}
