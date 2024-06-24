package kotlinx.coroutines;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import kotlin.Unit;

/* compiled from: Future.kt */
/* loaded from: classes4.dex */
public final class CancelFutureOnCancel extends CancelHandler {
    public final Future<?> future;

    public CancelFutureOnCancel(ScheduledFuture scheduledFuture) {
        this.future = scheduledFuture;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    public final String toString() {
        return "CancelFutureOnCancel[" + this.future + ']';
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (th != null) {
            this.future.cancel(false);
        }
    }
}
