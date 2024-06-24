package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* compiled from: SafeCollector.kt */
/* loaded from: classes4.dex */
public final class DownstreamExceptionContext implements CoroutineContext {
    public final /* synthetic */ CoroutineContext $$delegate_0;
    public final Throwable e;

    public DownstreamExceptionContext(CoroutineContext coroutineContext, Throwable th) {
        this.e = th;
        this.$$delegate_0 = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) this.$$delegate_0.fold(r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) this.$$delegate_0.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return this.$$delegate_0.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.$$delegate_0.plus(coroutineContext);
    }
}
