package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: NopCollector.kt */
/* loaded from: classes4.dex */
public final class NopCollector implements FlowCollector<Object> {
    public static final NopCollector INSTANCE = new NopCollector();

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
