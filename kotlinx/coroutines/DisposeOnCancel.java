package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes4.dex */
public final class DisposeOnCancel extends CancelHandler {
    public final DisposableHandle handle;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.handle = disposableHandle;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    public final String toString() {
        return "DisposeOnCancel[" + this.handle + ']';
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.handle.dispose();
    }
}
