package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkForegroundUpdater implements ForegroundUpdater {
    public final ForegroundProcessor mForegroundProcessor;
    public final TaskExecutor mTaskExecutor;
    public final WorkSpecDao mWorkSpecDao;

    /* renamed from: androidx.work.impl.utils.WorkForegroundUpdater$1 */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ ForegroundInfo val$foregroundInfo;
        public final /* synthetic */ SettableFuture val$future;
        public final /* synthetic */ UUID val$id;

        public AnonymousClass1(final SettableFuture val$future, final UUID val$id, final ForegroundInfo val$foregroundInfo, final Context val$context) {
            this.val$future = val$future;
            this.val$id = val$id;
            this.val$foregroundInfo = val$foregroundInfo;
            this.val$context = val$context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!(this.val$future.value instanceof AbstractFuture.Cancellation)) {
                    String str = this.val$id.toString();
                    WorkInfo.State state = ((WorkSpecDao_Impl) WorkForegroundUpdater.this.mWorkSpecDao).getState(str);
                    if (state != null && !state.isFinished()) {
                        ((Processor) WorkForegroundUpdater.this.mForegroundProcessor).startForeground(str, this.val$foregroundInfo);
                        this.val$context.startService(SystemForegroundDispatcher.createNotifyIntent(this.val$context, str, this.val$foregroundInfo));
                    } else {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                }
                this.val$future.set(null);
            } catch (Throwable th) {
                this.val$future.setException(th);
            }
        }
    }

    static {
        Logger.tagWithPrefix("WMFgUpdater");
    }

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }
}
