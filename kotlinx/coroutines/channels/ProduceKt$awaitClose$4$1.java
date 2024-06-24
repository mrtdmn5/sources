package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: Produce.kt */
/* loaded from: classes4.dex */
public final class ProduceKt$awaitClose$4$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ CancellableContinuation<Unit> $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProduceKt$awaitClose$4$1(CancellableContinuationImpl cancellableContinuationImpl) {
        super(1);
        this.$cont = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        Unit unit = Unit.INSTANCE;
        this.$cont.resumeWith(unit);
        return unit;
    }
}
