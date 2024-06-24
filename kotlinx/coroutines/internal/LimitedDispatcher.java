package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes4.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    public static final AtomicIntegerFieldUpdater runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    public final /* synthetic */ Delay $$delegate_0;
    public final CoroutineDispatcher dispatcher;
    public final int parallelism;
    public final LockFreeTaskQueue<Runnable> queue;
    private volatile int runningWorkers;
    public final Object workerAllocationLock;

    /* compiled from: LimitedDispatcher.kt */
    /* loaded from: classes4.dex */
    public final class Worker implements Runnable {
        public Runnable currentTask;

        public Worker(Runnable runnable) {
            this.currentTask = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = 0;
            while (true) {
                try {
                    this.currentTask.run();
                } catch (Throwable th) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th);
                }
                LimitedDispatcher limitedDispatcher = LimitedDispatcher.this;
                Runnable obtainTaskOrDeallocateWorker = limitedDispatcher.obtainTaskOrDeallocateWorker();
                if (obtainTaskOrDeallocateWorker == null) {
                    return;
                }
                this.currentTask = obtainTaskOrDeallocateWorker;
                r0++;
                if (r0 >= 16 && limitedDispatcher.dispatcher.isDispatchNeeded(limitedDispatcher)) {
                    limitedDispatcher.dispatcher.dispatch(limitedDispatcher, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int r2) {
        Delay delay;
        this.dispatcher = coroutineDispatcher;
        this.parallelism = r2;
        if (coroutineDispatcher instanceof Delay) {
            delay = (Delay) coroutineDispatcher;
        } else {
            delay = null;
        }
        this.$$delegate_0 = delay == null ? DefaultExecutorKt.DefaultDelay : delay;
        this.queue = new LockFreeTaskQueue<>();
        this.workerAllocationLock = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        boolean z;
        Runnable obtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
        if (atomicIntegerFieldUpdater.get(this) < this.parallelism) {
            synchronized (this.workerAllocationLock) {
                if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                    z = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z = true;
                }
            }
            if (z && (obtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) != null) {
                this.dispatcher.dispatch(this, new Worker(obtainTaskOrDeallocateWorker));
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        boolean z;
        Runnable obtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
        if (atomicIntegerFieldUpdater.get(this) < this.parallelism) {
            synchronized (this.workerAllocationLock) {
                if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                    z = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z = true;
                }
            }
            if (z && (obtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) != null) {
                this.dispatcher.dispatchYield(this, new Worker(obtainTaskOrDeallocateWorker));
            }
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return this.$$delegate_0.invokeOnTimeout(j, runnable, coroutineContext);
    }

    public final Runnable obtainTaskOrDeallocateWorker() {
        while (true) {
            Runnable removeFirstOrNull = this.queue.removeFirstOrNull();
            if (removeFirstOrNull == null) {
                synchronized (this.workerAllocationLock) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.queue.getSize() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return removeFirstOrNull;
            }
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        this.$$delegate_0.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
    }
}
