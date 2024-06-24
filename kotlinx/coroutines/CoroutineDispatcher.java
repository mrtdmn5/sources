package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes4.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public static final Key Key = new Key();

    /* compiled from: CoroutineDispatcher.kt */
    /* loaded from: classes4.dex */
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {
        public Key() {
            super(ContinuationInterceptor.Key.$$INSTANCE, new Function1<CoroutineContext.Element, CoroutineDispatcher>() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // kotlin.jvm.functions.Function1
                public final CoroutineDispatcher invoke(CoroutineContext.Element element) {
                    CoroutineContext.Element element2 = element;
                    if (element2 instanceof CoroutineDispatcher) {
                        return (CoroutineDispatcher) element2;
                    }
                    return null;
                }
            });
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key.$$INSTANCE);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            CoroutineContext.Key<?> key2 = getKey();
            Intrinsics.checkNotNullParameter(key2, "key");
            if (key2 != abstractCoroutineContextKey && abstractCoroutineContextKey.topmostKey != key2) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                E e = (E) abstractCoroutineContextKey.safeCast.invoke(this);
                if (e instanceof CoroutineContext.Element) {
                    return e;
                }
            }
        } else if (ContinuationInterceptor.Key.$$INSTANCE == key) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final DispatchedContinuation interceptContinuation(Continuation continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !(this instanceof Unconfined);
    }

    public CoroutineDispatcher limitedParallelism(int r2) {
        LimitedDispatcherKt.checkParallelism(r2);
        return new LimitedDispatcher(this, r2);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        boolean z2 = key instanceof AbstractCoroutineContextKey;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (z2) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            CoroutineContext.Key<?> key2 = getKey();
            Intrinsics.checkNotNullParameter(key2, "key");
            if (key2 != abstractCoroutineContextKey && abstractCoroutineContextKey.topmostKey != key2) {
                z = false;
            } else {
                z = true;
            }
            if (z && ((CoroutineContext.Element) abstractCoroutineContextKey.safeCast.invoke(this)) != null) {
                return emptyCoroutineContext;
            }
        } else if (ContinuationInterceptor.Key.$$INSTANCE == key) {
            return emptyCoroutineContext;
        }
        return this;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void releaseInterceptedContinuation(Continuation<?> continuation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        CancellableContinuationImpl cancellableContinuationImpl;
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        do {
            atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
        } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == DispatchedContinuationKt.REUSABLE_CLAIMED);
        Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
        if (obj instanceof CancellableContinuationImpl) {
            cancellableContinuationImpl = (CancellableContinuationImpl) obj;
        } else {
            cancellableContinuationImpl = null;
        }
        if (cancellableContinuationImpl != null) {
            cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.getHexAddress(this);
    }
}
