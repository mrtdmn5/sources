package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Builders.kt */
/* loaded from: classes4.dex */
public final class EmptyFlow implements Flow {
    public static final EmptyFlow INSTANCE = new EmptyFlow();

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<?> flowCollector, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
