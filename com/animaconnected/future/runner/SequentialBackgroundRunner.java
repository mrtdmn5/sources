package com.animaconnected.future.runner;

import android.os.Handler;
import android.os.Looper;
import com.animaconnected.future.Future;
import com.animaconnected.future.Promise;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class SequentialBackgroundRunner implements BackgroundRunner {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Queue<Runnable> mQueue = new LinkedList();
    private final Object mLock = new Object();
    private final Object mRunLock = new Object();
    private boolean mRunningTask = false;
    private final Executor mExecutor = Executors.newCachedThreadPool();

    private void addToQueue(Runnable runnable) {
        synchronized (this.mLock) {
            this.mQueue.add(runnable);
        }
    }

    private void executeNextIfReadyLocked() {
        if (!this.mRunningTask && !this.mQueue.isEmpty()) {
            this.mRunningTask = true;
            this.mExecutor.execute(this.mQueue.remove());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submit$2(Callable callable, final Promise promise) {
        try {
            try {
                synchronized (this.mRunLock) {
                    final Object call = callable.call();
                    this.mHandler.post(new Runnable() { // from class: com.animaconnected.future.runner.SequentialBackgroundRunner$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Promise.this.resolve(call);
                        }
                    });
                }
                synchronized (this.mLock) {
                    this.mRunningTask = false;
                    executeNextIfReadyLocked();
                }
            } catch (Exception e) {
                this.mHandler.post(new Runnable() { // from class: com.animaconnected.future.runner.SequentialBackgroundRunner$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Promise.this.reject(e);
                    }
                });
                synchronized (this.mLock) {
                    this.mRunningTask = false;
                    executeNextIfReadyLocked();
                }
            }
        } catch (Throwable th) {
            synchronized (this.mLock) {
                this.mRunningTask = false;
                executeNextIfReadyLocked();
                throw th;
            }
        }
    }

    @Override // com.animaconnected.future.runner.BackgroundRunner
    public <T> Future<T> submit(final Callable<T> callable) {
        final Promise promise = new Promise();
        addToQueue(new Runnable() { // from class: com.animaconnected.future.runner.SequentialBackgroundRunner$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SequentialBackgroundRunner.this.lambda$submit$2(callable, promise);
            }
        });
        synchronized (this.mLock) {
            executeNextIfReadyLocked();
        }
        return promise.getFuture();
    }
}
