package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Emitters.kt */
/* loaded from: classes4.dex */
public final class ThrowingCollector implements FlowCollector<Object> {
    public final Throwable e;

    public ThrowingCollector(Throwable th) {
        this.e = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation<? super Unit> continuation) {
        throw this.e;
    }
}
