package androidx.work.impl.utils;

import androidx.room.RoomDatabase;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkProgressUpdater implements ProgressUpdater {
    public static final String TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    public final TaskExecutor mTaskExecutor;
    public final WorkDatabase mWorkDatabase;

    /* renamed from: androidx.work.impl.utils.WorkProgressUpdater$1 */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Data val$data;
        public final /* synthetic */ SettableFuture val$future;
        public final /* synthetic */ UUID val$id;

        public AnonymousClass1(final UUID val$id, final Data val$data, final SettableFuture val$future) {
            id = val$id;
            data = val$data;
            settableFuture = val$future;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WorkSpec workSpec;
            SettableFuture settableFuture = settableFuture;
            UUID r1 = id;
            String str = r1.toString();
            Logger logger = Logger.get();
            String str2 = WorkProgressUpdater.TAG;
            Data data = data;
            logger.debug(str2, String.format("Updating progress for %s (%s)", r1, data), new Throwable[0]);
            WorkProgressUpdater workProgressUpdater = WorkProgressUpdater.this;
            WorkDatabase workDatabase = workProgressUpdater.mWorkDatabase;
            WorkDatabase workDatabase2 = workProgressUpdater.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                workSpec = ((WorkSpecDao_Impl) workDatabase2.workSpecDao()).getWorkSpec(str);
            } finally {
                try {
                    return;
                } finally {
                }
            }
            if (workSpec != null) {
                if (workSpec.state == WorkInfo.State.RUNNING) {
                    WorkProgress workProgress = new WorkProgress(str, data);
                    WorkProgressDao_Impl workProgressDao_Impl = (WorkProgressDao_Impl) workDatabase2.workProgressDao();
                    RoomDatabase roomDatabase = workProgressDao_Impl.__db;
                    roomDatabase.assertNotSuspendingTransaction();
                    roomDatabase.beginTransaction();
                    try {
                        workProgressDao_Impl.__insertionAdapterOfWorkProgress.insert(workProgress);
                        roomDatabase.setTransactionSuccessful();
                        roomDatabase.endTransaction();
                    } catch (Throwable th) {
                        roomDatabase.endTransaction();
                        throw th;
                    }
                } else {
                    Logger.get().warning(str2, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", str), new Throwable[0]);
                }
                settableFuture.set(null);
                workDatabase2.setTransactionSuccessful();
                return;
            }
            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        }
    }

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }
}
