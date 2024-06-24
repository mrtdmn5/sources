package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class ChildContinuation extends JobCancellingNode {
    public final CancellableContinuationImpl<?> child;

    public ChildContinuation(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        this.child = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        boolean z;
        JobSupport job = getJob();
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.child;
        Throwable continuationCancellationCause = cancellableContinuationImpl.getContinuationCancellationCause(job);
        boolean z2 = false;
        if (cancellableContinuationImpl.isReusable()) {
            Continuation<?> continuation = cancellableContinuationImpl.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = DispatchedContinuationKt.REUSABLE_CLAIMED;
                boolean z3 = true;
                if (Intrinsics.areEqual(obj, symbol)) {
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, continuationCancellationCause)) {
                            z = true;
                            break;
                        } else if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        break;
                    }
                } else {
                    if (obj instanceof Throwable) {
                        break;
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                            break;
                        } else if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                            z3 = false;
                            break;
                        }
                    }
                    if (z3) {
                        break;
                    }
                }
            }
            z2 = true;
        }
        if (z2) {
            return;
        }
        cancellableContinuationImpl.cancel(continuationCancellationCause);
        if (cancellableContinuationImpl.isReusable()) {
            return;
        }
        cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
    }
}
