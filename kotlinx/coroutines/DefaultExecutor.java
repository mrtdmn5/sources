package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.EventLoopImplBase;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes4.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    public static final DefaultExecutor INSTANCE;
    public static final long KEEP_ALIVE_NANOS;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        defaultExecutor.incrementUseCount(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void acknowledgeShutdownIfNeeded() {
        boolean z;
        int r0 = debugStatus;
        if (r0 != 2 && r0 != 3) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return;
        }
        debugStatus = 3;
        EventLoopImplBase._queue$FU.set(this, null);
        EventLoopImplBase._delayed$FU.set(this, null);
        notifyAll();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final void enqueue(Runnable runnable) {
        boolean z;
        if (debugStatus == 4) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            super.enqueue(runnable);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final Thread getThread() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
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
            EventLoopImplBase.DelayedRunnableTask delayedRunnableTask = new EventLoopImplBase.DelayedRunnableTask(runnable, j2 + nanoTime);
            schedule(nanoTime, delayedRunnableTask);
            return delayedRunnableTask;
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        boolean z3;
        ThreadLocalEventLoop.ref.set(this);
        try {
            synchronized (this) {
                int r0 = debugStatus;
                if (r0 != 2 && r0 != 3) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    z2 = false;
                } else {
                    debugStatus = 1;
                    notifyAll();
                    z2 = true;
                }
            }
            if (!z2) {
                _thread = null;
                acknowledgeShutdownIfNeeded();
                if (!isEmpty()) {
                    getThread();
                    return;
                }
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long processNextEvent = processNextEvent();
                if (processNextEvent == Long.MAX_VALUE) {
                    long nanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = KEEP_ALIVE_NANOS + nanoTime;
                    }
                    long j2 = j - nanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        if (!isEmpty()) {
                            getThread();
                            return;
                        }
                        return;
                    }
                    if (processNextEvent > j2) {
                        processNextEvent = j2;
                    }
                } else {
                    j = Long.MAX_VALUE;
                }
                if (processNextEvent > 0) {
                    int r02 = debugStatus;
                    if (r02 != 2 && r02 != 3) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        if (!isEmpty()) {
                            getThread();
                            return;
                        }
                        return;
                    }
                    LockSupport.parkNanos(this, processNextEvent);
                }
            }
        } catch (Throwable th) {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            if (!isEmpty()) {
                getThread();
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
