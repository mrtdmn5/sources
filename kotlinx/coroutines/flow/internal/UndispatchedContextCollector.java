package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    public final Object countOrElement;
    public final CoroutineContext emitContext;
    public final UndispatchedContextCollector$emitRef$1 emitRef;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        this.emitContext = coroutineContext;
        this.countOrElement = ThreadContextKt.threadContextElements(coroutineContext);
        this.emitRef = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        Object withContextUndispatched = ChannelFlowKt.withContextUndispatched(this.emitContext, t, this.countOrElement, this.emitRef, continuation);
        if (withContextUndispatched == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContextUndispatched;
        }
        return Unit.INSTANCE;
    }
}
