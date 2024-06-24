package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes4.dex */
public final class CancellableContinuationKt {
    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(Continuation<? super T> continuation) {
        CancellableContinuationImpl<T> cancellableContinuationImpl;
        CancellableContinuationImpl<T> cancellableContinuationImpl2;
        boolean z;
        boolean z2 = true;
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(1, continuation);
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
            Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
            Symbol symbol = DispatchedContinuationKt.REUSABLE_CLAIMED;
            cancellableContinuationImpl = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(dispatchedContinuation, symbol);
                cancellableContinuationImpl2 = null;
                break;
            }
            if (obj instanceof CancellableContinuationImpl) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, symbol)) {
                        z = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    cancellableContinuationImpl2 = (CancellableContinuationImpl) obj;
                    break;
                }
            } else if (obj != symbol && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (cancellableContinuationImpl2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuationImpl._state$FU;
            Object obj2 = atomicReferenceFieldUpdater2.get(cancellableContinuationImpl2);
            if ((obj2 instanceof CompletedContinuation) && ((CompletedContinuation) obj2).idempotentResume != null) {
                cancellableContinuationImpl2.detachChild$kotlinx_coroutines_core();
                z2 = false;
            } else {
                CancellableContinuationImpl._decisionAndIndex$FU.set(cancellableContinuationImpl2, 536870911);
                atomicReferenceFieldUpdater2.set(cancellableContinuationImpl2, Active.INSTANCE);
            }
            if (z2) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            }
            if (cancellableContinuationImpl != null) {
                return cancellableContinuationImpl;
            }
        }
        return new CancellableContinuationImpl<>(2, continuation);
    }
}
