package kotlin.coroutines;

import com.animaconnected.firebase.AnalyticsConstants;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* compiled from: SafeContinuationJvm.kt */
/* loaded from: classes.dex */
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    public static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, AnalyticsConstants.KEY_RESULT);
    public final Continuation<T> delegate;
    private volatile Object result;

    public SafeContinuation(CoroutineSingletons coroutineSingletons, Continuation continuation) {
        this.delegate = continuation;
        this.result = coroutineSingletons;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    public final Object getOrThrow() {
        boolean z;
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> atomicReferenceFieldUpdater = RESULT;
            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, coroutineSingletons, coroutineSingletons2)) {
                    z = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != coroutineSingletons) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
        if (!(obj instanceof Result.Failure)) {
            return obj;
        }
        throw ((Result.Failure) obj).exception;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            boolean z = false;
            if (obj2 == coroutineSingletons) {
                AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> atomicReferenceFieldUpdater = RESULT;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, coroutineSingletons, obj)) {
                        z = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != coroutineSingletons) {
                        break;
                    }
                }
                if (z) {
                    return;
                }
            } else {
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj2 == coroutineSingletons2) {
                    AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> atomicReferenceFieldUpdater2 = RESULT;
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.RESUMED;
                    while (true) {
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, coroutineSingletons2, coroutineSingletons3)) {
                            z = true;
                            break;
                        } else if (atomicReferenceFieldUpdater2.get(this) != coroutineSingletons2) {
                            break;
                        }
                    }
                    if (z) {
                        this.delegate.resumeWith(obj);
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> continuation) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        this.delegate = continuation;
        this.result = coroutineSingletons;
    }
}
