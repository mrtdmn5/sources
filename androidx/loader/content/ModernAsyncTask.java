package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;
    public static InternalHandler sHandler;
    public final AnonymousClass3 mFuture;
    public final AnonymousClass2 mWorker;
    public volatile Status mStatus = Status.PENDING;
    public final AtomicBoolean mCancelled = new AtomicBoolean();
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    /* renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;

        static {
            int[] r0 = new int[Status.values().length];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = r0;
            try {
                r0[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AsyncTaskResult<Data> {
        public final Data[] mData;
        public final ModernAsyncTask mTask;

        public AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.mTask = modernAsyncTask;
            this.mData = dataArr;
        }
    }

    /* loaded from: classes.dex */
    public static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int r3 = message.what;
            if (r3 != 1) {
                if (r3 == 2) {
                    asyncTaskResult.mTask.getClass();
                }
            } else {
                ModernAsyncTask modernAsyncTask = asyncTaskResult.mTask;
                Object obj = asyncTaskResult.mData[0];
                if (modernAsyncTask.mCancelled.get()) {
                    modernAsyncTask.onCancelled(obj);
                } else {
                    modernAsyncTask.onPostExecute(obj);
                }
                modernAsyncTask.mStatus = Status.FINISHED;
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes.dex */
    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        public Params[] mParams;
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.loader.content.ModernAsyncTask.1
            public final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
            }
        };
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), threadFactory);
    }

    public ModernAsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: androidx.loader.content.ModernAsyncTask.2
            @Override // java.util.concurrent.Callable
            public final Result call() throws Exception {
                ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
                modernAsyncTask.mTaskInvoked.set(true);
                try {
                    Process.setThreadPriority(10);
                    modernAsyncTask.doInBackground(this.mParams);
                    Binder.flushPendingCommands();
                    return null;
                } finally {
                }
            }
        };
        this.mWorker = workerRunnable;
        this.mFuture = new FutureTask<Result>(workerRunnable) { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.util.concurrent.FutureTask
            public final void done() {
                ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
                try {
                    Result result = get();
                    if (!modernAsyncTask.mTaskInvoked.get()) {
                        modernAsyncTask.postResult(result);
                    }
                } catch (InterruptedException e) {
                    Log.w("AsyncTask", e);
                } catch (CancellationException unused) {
                    if (!modernAsyncTask.mTaskInvoked.get()) {
                        modernAsyncTask.postResult(null);
                    }
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    public abstract void doInBackground(Object... objArr);

    public final void postResult(Object obj) {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            internalHandler = sHandler;
        }
        internalHandler.obtainMessage(1, new AsyncTaskResult(this, obj)).sendToTarget();
    }

    public void onCancelled(Result result) {
    }

    public void onPostExecute(Result result) {
    }
}
