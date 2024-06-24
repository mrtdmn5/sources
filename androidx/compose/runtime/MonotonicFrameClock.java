package androidx.compose.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* compiled from: MonotonicFrameClock.kt */
/* loaded from: classes.dex */
public interface MonotonicFrameClock extends CoroutineContext.Element {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: MonotonicFrameClock.kt */
    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key<MonotonicFrameClock> {
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    default CoroutineContext.Key<?> getKey() {
        return Key.$$INSTANCE;
    }

    <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation);
}
