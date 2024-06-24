package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes4.dex */
public class AsyncTimeout extends Timeout {
    public static final long IDLE_TIMEOUT_MILLIS;
    public static final long IDLE_TIMEOUT_NANOS;
    public static final Condition condition;
    public static AsyncTimeout head;
    public static final ReentrantLock lock;
    public boolean inQueue;
    public AsyncTimeout next;
    public long timeoutAt;

    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long nanoTime = System.nanoTime();
                AsyncTimeout.condition.await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                Intrinsics.checkNotNull(asyncTimeout3);
                if (asyncTimeout3.next != null || System.nanoTime() - nanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long nanoTime2 = asyncTimeout2.timeoutAt - System.nanoTime();
            if (nanoTime2 > 0) {
                AsyncTimeout.condition.await(nanoTime2, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout4);
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }
    }

    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes4.dex */
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            ReentrantLock reentrantLock;
            AsyncTimeout awaitTimeout$okio;
            while (true) {
                try {
                    reentrantLock = AsyncTimeout.lock;
                    reentrantLock.lock();
                    try {
                        awaitTimeout$okio = Companion.awaitTimeout$okio();
                    } finally {
                        reentrantLock.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (awaitTimeout$okio == AsyncTimeout.head) {
                    AsyncTimeout.head = null;
                    return;
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                if (awaitTimeout$okio != null) {
                    awaitTimeout$okio.timedOut();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(newCondition, "lock.newCondition()");
        condition = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void enter() {
        AsyncTimeout asyncTimeout;
        long j = this.timeoutNanos;
        boolean z = this.hasDeadline;
        if (j == 0 && !z) {
            return;
        }
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (!this.inQueue) {
                this.inQueue = true;
                if (head == null) {
                    head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long nanoTime = System.nanoTime();
                if (j != 0 && z) {
                    this.timeoutAt = Math.min(j, deadlineNanoTime() - nanoTime) + nanoTime;
                } else if (j != 0) {
                    this.timeoutAt = j + nanoTime;
                } else if (z) {
                    this.timeoutAt = deadlineNanoTime();
                } else {
                    throw new AssertionError();
                }
                long j2 = this.timeoutAt - nanoTime;
                AsyncTimeout asyncTimeout2 = head;
                Intrinsics.checkNotNull(asyncTimeout2);
                while (true) {
                    asyncTimeout = asyncTimeout2.next;
                    if (asyncTimeout == null || j2 < asyncTimeout.timeoutAt - nanoTime) {
                        break;
                    } else {
                        asyncTimeout2 = asyncTimeout;
                    }
                }
                this.next = asyncTimeout;
                asyncTimeout2.next = this;
                if (asyncTimeout2 == head) {
                    condition.signal();
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (!this.inQueue) {
                return false;
            }
            this.inQueue = false;
            AsyncTimeout asyncTimeout = head;
            while (asyncTimeout != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout.next;
                if (asyncTimeout2 == this) {
                    asyncTimeout.next = this.next;
                    this.next = null;
                    return false;
                }
                asyncTimeout = asyncTimeout2;
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void timedOut() {
    }
}
