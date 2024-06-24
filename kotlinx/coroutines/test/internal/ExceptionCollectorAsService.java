package kotlinx.coroutines.test.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: ExceptionCollector.kt */
/* loaded from: classes4.dex */
public final class ExceptionCollectorAsService implements CoroutineExceptionHandler {
    public final /* synthetic */ ExceptionCollector $$delegate_0 = ExceptionCollector.INSTANCE;

    public final boolean equals(Object obj) {
        if (!(obj instanceof ExceptionCollectorAsService) && !(obj instanceof ExceptionCollector)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) this.$$delegate_0.fold(r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) this.$$delegate_0.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this.$$delegate_0.getKey();
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        this.$$delegate_0.getClass();
        synchronized (ExceptionCollector.lock) {
        }
    }

    public final int hashCode() {
        return ExceptionCollector.INSTANCE.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return this.$$delegate_0.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.$$delegate_0.plus(coroutineContext);
    }
}
