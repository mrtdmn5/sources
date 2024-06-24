package kotlinx.coroutines.selects;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: Select.kt */
/* loaded from: classes4.dex */
public interface SelectInstance<R> {
    void disposeOnCompletion(DisposableHandle disposableHandle);

    CoroutineContext getContext();

    void selectInRegistrationPhase(Object obj);

    boolean trySelect(Object obj, Object obj2);
}
