package com.animaconnected.future.runner;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.animaconnected.future.Future;
import com.animaconnected.future.Promise;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ParallelBackgroundRunner implements BackgroundRunner {
    private final Executor mExecutor;
    private final Handler mHandler;

    public ParallelBackgroundRunner() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submit$2(Callable callable, final Promise promise) {
        try {
            final Object call = callable.call();
            this.mHandler.post(new Runnable() { // from class: com.animaconnected.future.runner.ParallelBackgroundRunner$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Promise.this.resolve(call);
                }
            });
        } catch (Exception e) {
            this.mHandler.post(new Runnable() { // from class: com.animaconnected.future.runner.ParallelBackgroundRunner$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    Promise.this.reject(e);
                }
            });
        }
    }

    @Override // com.animaconnected.future.runner.BackgroundRunner
    public <T> Future<T> submit(final Callable<T> callable) {
        final Promise promise = new Promise();
        this.mExecutor.execute(new Runnable() { // from class: com.animaconnected.future.runner.ParallelBackgroundRunner$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ParallelBackgroundRunner.this.lambda$submit$2(callable, promise);
            }
        });
        return promise.getFuture();
    }

    public ParallelBackgroundRunner(Executor executor) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mExecutor = executor;
    }
}
