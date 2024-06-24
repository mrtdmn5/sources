package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    public SettableFuture<ListenableWorker.Result> mFuture;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    public abstract ListenableWorker.Result.Success doWork();

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = new SettableFuture<>();
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.Worker.1
            @Override // java.lang.Runnable
            public final void run() {
                Worker worker = Worker.this;
                try {
                    worker.mFuture.set(worker.doWork());
                } catch (Throwable th) {
                    worker.mFuture.setException(th);
                }
            }
        });
        return this.mFuture;
    }
}
