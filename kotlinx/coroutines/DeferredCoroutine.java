package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T> {
    @Override // kotlinx.coroutines.Deferred
    public final Object await(Continuation<? super T> continuation) {
        Object awaitInternal = awaitInternal(continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return awaitInternal;
    }
}
