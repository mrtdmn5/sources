package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes4.dex */
public final class InvokeOnCancel extends CancelHandler {
    public final Function1<Throwable, Unit> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancel(Function1<? super Throwable, Unit> function1) {
        this.handler = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.handler.getClass().getSimpleName() + '@' + DebugStringsKt.getHexAddress(this) + ']';
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.handler.invoke(th);
    }
}
