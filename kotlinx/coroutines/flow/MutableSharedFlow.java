package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;

/* compiled from: SharedFlow.kt */
/* loaded from: classes4.dex */
public interface MutableSharedFlow<T> extends SharedFlow<T>, FlowCollector<T> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    Object emit(T t, Continuation<? super Unit> continuation);

    SubscriptionCountStateFlow getSubscriptionCount();

    void resetReplayCache();

    boolean tryEmit(T t);
}
