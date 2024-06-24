package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.MutexImpl;

/* compiled from: Mutex.kt */
/* loaded from: classes4.dex */
public final class MutexImpl extends SemaphoreImpl implements Mutex {
    public static final AtomicReferenceFieldUpdater owner$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    private volatile Object owner;

    /* compiled from: Mutex.kt */
    /* loaded from: classes4.dex */
    public final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {
        public final CancellableContinuationImpl<Unit> cont;
        public final Object owner;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(CancellableContinuationImpl<? super Unit> cancellableContinuationImpl, Object obj) {
            this.cont = cancellableContinuationImpl;
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final boolean cancel(Throwable th) {
            return this.cont.cancel(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void completeResume(Object obj) {
            this.cont.completeResume(obj);
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            return this.cont.context;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
            this.cont.invokeOnCancellation(function1);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final boolean isActive() {
            return this.cont.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final boolean isCompleted() {
            return this.cont.isCompleted();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void resume(Unit unit, Function1 function1) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.owner$FU;
            Object obj = this.owner;
            final MutexImpl mutexImpl = MutexImpl.this;
            atomicReferenceFieldUpdater.set(mutexImpl, obj);
            Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    MutexImpl.this.unlock(this.owner);
                    return Unit.INSTANCE;
                }
            };
            this.cont.resume(unit, function12);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.cont.resumeUndispatched(coroutineDispatcher, unit);
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            this.cont.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final Symbol tryResume(Object obj, Function1 function1) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.owner$FU;
                    MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner = this;
                    Object obj2 = cancellableContinuationWithOwner.owner;
                    MutexImpl mutexImpl2 = MutexImpl.this;
                    atomicReferenceFieldUpdater.set(mutexImpl2, obj2);
                    mutexImpl2.unlock(cancellableContinuationWithOwner.owner);
                    return Unit.INSTANCE;
                }
            };
            Symbol tryResumeImpl = this.cont.tryResumeImpl((Unit) obj, function12);
            if (tryResumeImpl != null) {
                MutexImpl.owner$FU.set(mutexImpl, this.owner);
            }
            return tryResumeImpl;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final Symbol tryResumeWithException(Throwable th) {
            return this.cont.tryResumeWithException(th);
        }

        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment<?> segment, int r3) {
            this.cont.invokeOnCancellation(segment, r3);
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        Symbol symbol;
        if (z) {
            symbol = null;
        } else {
            symbol = MutexKt.NO_OWNER;
        }
        this.owner = symbol;
        new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Function1<? super Throwable, ? extends Unit> invoke(SelectInstance<?> selectInstance, final Object obj, Object obj2) {
                final MutexImpl mutexImpl = MutexImpl.this;
                return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Throwable th) {
                        MutexImpl.this.unlock(obj);
                        return Unit.INSTANCE;
                    }
                };
            }
        };
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final Object lock(Object obj, Continuation<? super Unit> continuation) {
        if (tryLock(obj)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        try {
            acquire(new CancellableContinuationWithOwner(orCreateCancellableContinuation, obj));
            Object result = orCreateCancellableContinuation.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (result != coroutineSingletons) {
                result = Unit.INSTANCE;
            }
            if (result != coroutineSingletons) {
                return Unit.INSTANCE;
            }
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Mutex@");
        sb.append(DebugStringsKt.getHexAddress(this));
        sb.append("[isLocked=");
        boolean z = false;
        if (Math.max(SemaphoreImpl._availablePermits$FU.get(this), 0) == 0) {
            z = true;
        }
        sb.append(z);
        sb.append(",owner=");
        sb.append(owner$FU.get(this));
        sb.append(']');
        return sb.toString();
    }

    public final boolean tryLock(Object obj) {
        int r1;
        boolean z;
        char c;
        boolean z2;
        char c2;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = SemaphoreImpl._availablePermits$FU;
            int r12 = atomicIntegerFieldUpdater.get(this);
            int r2 = this.permits;
            if (r12 > r2) {
                do {
                    r1 = atomicIntegerFieldUpdater.get(this);
                    if (r1 > r2) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, r1, r2));
            } else {
                if (r12 <= 0) {
                    z = false;
                } else if (atomicIntegerFieldUpdater.compareAndSet(this, r12, r12 - 1)) {
                    z = true;
                } else {
                    continue;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = owner$FU;
                if (z) {
                    atomicReferenceFieldUpdater.set(this, obj);
                    c = 0;
                    break;
                }
                if (obj == null) {
                    break;
                }
                while (true) {
                    if (Math.max(atomicIntegerFieldUpdater.get(this), 0) == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        c2 = 0;
                        break;
                    }
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    if (obj2 != MutexKt.NO_OWNER) {
                        if (obj2 == obj) {
                            c2 = 1;
                        } else {
                            c2 = 2;
                        }
                    }
                }
                if (c2 != 1) {
                    if (c2 == 2) {
                        break;
                    }
                } else {
                    c = 2;
                    break;
                }
            }
        }
        c = 1;
        if (c == 0) {
            return true;
        }
        if (c == 1) {
            return false;
        }
        if (c != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final void unlock(Object obj) {
        boolean z;
        boolean z2;
        while (true) {
            boolean z3 = false;
            if (Math.max(SemaphoreImpl._availablePermits$FU.get(this), 0) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = owner$FU;
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                Symbol symbol = MutexKt.NO_OWNER;
                if (obj2 != symbol) {
                    if (obj2 != obj && obj != null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, symbol)) {
                            z3 = true;
                            break;
                        } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    if (z3) {
                        release();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException("This mutex is not locked".toString());
            }
        }
    }
}
