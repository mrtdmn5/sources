package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class SerialExecutor implements Executor {
    public volatile Runnable mActive;
    public final Executor mExecutor;
    public final ArrayDeque<Task> mTasks = new ArrayDeque<>();
    public final Object mLock = new Object();

    /* loaded from: classes.dex */
    public static class Task implements Runnable {
        public final Runnable mRunnable;
        public final SerialExecutor mSerialExecutor;

        public Task(SerialExecutor serialExecutor, Runnable runnable) {
            this.mSerialExecutor = serialExecutor;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SerialExecutor serialExecutor = this.mSerialExecutor;
            try {
                this.mRunnable.run();
            } finally {
                serialExecutor.scheduleNext();
            }
        }
    }

    public SerialExecutor(ExecutorService executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        synchronized (this.mLock) {
            this.mTasks.add(new Task(this, command));
            if (this.mActive == null) {
                scheduleNext();
            }
        }
    }

    public final void scheduleNext() {
        synchronized (this.mLock) {
            Task poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                this.mExecutor.execute(this.mActive);
            }
        }
    }
}
