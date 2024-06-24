package kotlinx.coroutines;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;
    public static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    public static final AtomicIntegerFieldUpdater _isCompleted$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted");

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public final class DelayedResumeTask extends DelayedTask {
        public final CancellableContinuation<Unit> cont;

        public DelayedResumeTask(long j, CancellableContinuationImpl cancellableContinuationImpl) {
            super(j);
            this.cont = cancellableContinuationImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.cont;
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public static final class DelayedRunnableTask extends DelayedTask {
        public final Runnable block;

        public DelayedRunnableTask(Runnable runnable, long j) {
            super(j);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.block;
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;
        public int index = -1;
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // java.lang.Comparable
        public final int compareTo(DelayedTask delayedTask) {
            long j = this.nanoTime - delayedTask.nanoTime;
            if (j > 0) {
                return 1;
            }
            if (j < 0) {
                return -1;
            }
            return 0;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            DelayedTaskQueue delayedTaskQueue;
            synchronized (this) {
                Object obj = this._heap;
                Symbol symbol = EventLoop_commonKt.DISPOSED_TASK;
                if (obj == symbol) {
                    return;
                }
                ThreadSafeHeap threadSafeHeap = null;
                if (obj instanceof DelayedTaskQueue) {
                    delayedTaskQueue = (DelayedTaskQueue) obj;
                } else {
                    delayedTaskQueue = null;
                }
                if (delayedTaskQueue != null) {
                    synchronized (delayedTaskQueue) {
                        Object obj2 = this._heap;
                        if (obj2 instanceof ThreadSafeHeap) {
                            threadSafeHeap = (ThreadSafeHeap) obj2;
                        }
                        if (threadSafeHeap != null) {
                            delayedTaskQueue.removeAtImpl(this.index);
                        }
                    }
                }
                this._heap = symbol;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final int scheduleTask(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            Object obj;
            synchronized (this) {
                if (this._heap == EventLoop_commonKt.DISPOSED_TASK) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    try {
                        Object[] objArr = delayedTaskQueue.a;
                        if (objArr != null) {
                            obj = objArr[0];
                        } else {
                            obj = null;
                        }
                        DelayedTask delayedTask = (DelayedTask) obj;
                        if (EventLoopImplBase.access$isCompleted(eventLoopImplBase)) {
                            return 1;
                        }
                        if (delayedTask == null) {
                            delayedTaskQueue.timeNow = j;
                        } else {
                            long j2 = delayedTask.nanoTime;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - delayedTaskQueue.timeNow > 0) {
                                delayedTaskQueue.timeNow = j;
                            }
                        }
                        long j3 = this.nanoTime;
                        long j4 = delayedTaskQueue.timeNow;
                        if (j3 - j4 < 0) {
                            this.nanoTime = j4;
                        }
                        delayedTaskQueue.addImpl(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public final void setHeap(DelayedTaskQueue delayedTaskQueue) {
            boolean z;
            if (this._heap != EventLoop_commonKt.DISPOSED_TASK) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this._heap = delayedTaskQueue;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public final void setIndex(int r1) {
            this.index = r1;
        }

        public String toString() {
            return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(new StringBuilder("Delayed[nanos="), this.nanoTime, ']');
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    public static final boolean access$isCompleted(EventLoopImplBase eventLoopImplBase) {
        eventLoopImplBase.getClass();
        if (_isCompleted$FU.get(eventLoopImplBase) != 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        if (enqueueImpl(runnable)) {
            Thread thread = getThread();
            if (Thread.currentThread() != thread) {
                LockSupport.unpark(thread);
                return;
            }
            return;
        }
        DefaultExecutor.INSTANCE.enqueue(runnable);
    }

    public final boolean enqueueImpl(Runnable runnable) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z2 = false;
            if (_isCompleted$FU.get(this) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            if (obj == null) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                        z2 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                if (z2) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore.addLast(runnable);
                if (addLast == 0) {
                    return true;
                }
                if (addLast != 1) {
                    if (addLast == 2) {
                        return false;
                    }
                } else {
                    LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                    }
                }
            } else {
                if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.addLast((Runnable) obj);
                lockFreeTaskQueueCore2.addLast(runnable);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore2)) {
                        z2 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(j, runnable, coroutineContext);
    }

    public final boolean isEmpty() {
        boolean z;
        boolean z2;
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque != null) {
            z = arrayDeque.isEmpty();
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) _delayed$FU.get(this);
        if (delayedTaskQueue != null) {
            if (delayedTaskQueue.getSize() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        }
        Object obj = _queue$FU.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof LockFreeTaskQueueCore) {
            long j = LockFreeTaskQueueCore._state$FU.get((LockFreeTaskQueueCore) obj);
            if (((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x008a, code lost:            r8 = null;     */
    @Override // kotlinx.coroutines.EventLoop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long processNextEvent() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    public final void schedule(long j, DelayedTask delayedTask) {
        boolean z;
        int scheduleTask;
        Thread thread;
        boolean z2 = true;
        if (_isCompleted$FU.get(this) != 0) {
            z = true;
        } else {
            z = false;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _delayed$FU;
        ThreadSafeHeapNode threadSafeHeapNode = null;
        if (z) {
            scheduleTask = 1;
        } else {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) atomicReferenceFieldUpdater.get(this);
            if (delayedTaskQueue == null) {
                DelayedTaskQueue delayedTaskQueue2 = new DelayedTaskQueue(j);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, delayedTaskQueue2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                Intrinsics.checkNotNull(obj);
                delayedTaskQueue = (DelayedTaskQueue) obj;
            }
            scheduleTask = delayedTask.scheduleTask(j, delayedTaskQueue, this);
        }
        if (scheduleTask != 0) {
            if (scheduleTask != 1) {
                if (scheduleTask != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            } else {
                reschedule(j, delayedTask);
                return;
            }
        }
        DelayedTaskQueue delayedTaskQueue3 = (DelayedTaskQueue) atomicReferenceFieldUpdater.get(this);
        if (delayedTaskQueue3 != null) {
            synchronized (delayedTaskQueue3) {
                ThreadSafeHeapNode[] threadSafeHeapNodeArr = delayedTaskQueue3.a;
                if (threadSafeHeapNodeArr != null) {
                    threadSafeHeapNode = threadSafeHeapNodeArr[0];
                }
            }
            threadSafeHeapNode = (DelayedTask) threadSafeHeapNode;
        }
        if (threadSafeHeapNode != delayedTask) {
            z2 = false;
        }
        if (z2 && Thread.currentThread() != (thread = getThread())) {
            LockSupport.unpark(thread);
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        long j2 = 0;
        if (j > 0) {
            if (j >= 9223372036854L) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = 1000000 * j;
            }
        }
        if (j2 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(j2 + nanoTime, cancellableContinuationImpl);
            schedule(nanoTime, delayedResumeTask);
            cancellableContinuationImpl.invokeOnCancellation(new DisposeOnCancel(delayedResumeTask));
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        boolean z;
        DelayedTask delayedTask;
        boolean z2;
        ThreadLocal<EventLoop> threadLocal = ThreadLocalEventLoop.ref;
        ThreadLocalEventLoop.ref.set(null);
        _isCompleted$FU.set(this, 1);
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = EventLoop_commonKt.CLOSED_EMPTY;
            if (obj == null) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
                        z = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != null) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    break;
                }
            } else {
                if (obj instanceof LockFreeTaskQueueCore) {
                    ((LockFreeTaskQueueCore) obj).close();
                    break;
                }
                if (obj == symbol) {
                    break;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                        z2 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                    break;
                }
            }
        }
        do {
        } while (processNextEvent() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) _delayed$FU.get(this);
            if (delayedTaskQueue != null) {
                synchronized (delayedTaskQueue) {
                    if (delayedTaskQueue.getSize() > 0) {
                        delayedTask = delayedTaskQueue.removeAtImpl(0);
                    } else {
                        delayedTask = null;
                    }
                }
                DelayedTask delayedTask2 = delayedTask;
                if (delayedTask2 != null) {
                    reschedule(nanoTime, delayedTask2);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
