package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class DisposeOnCompletion extends JobNode {
    public final DisposableHandle handle;

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.handle = disposableHandle;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.handle.dispose();
    }
}
