package androidx.work.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class WorkerWrapper implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("WorkerWrapper");
    public final Context mAppContext;
    public final Configuration mConfiguration;
    public final DependencyDao mDependencyDao;
    public final ForegroundProcessor mForegroundProcessor;
    public volatile boolean mInterrupted;
    public final WorkerParameters.RuntimeExtras mRuntimeExtras;
    public final List<Scheduler> mSchedulers;
    public ArrayList mTags;
    public final WorkDatabase mWorkDatabase;
    public String mWorkDescription;
    public WorkSpec mWorkSpec;
    public final WorkSpecDao mWorkSpecDao;
    public final String mWorkSpecId;
    public final WorkTagDao mWorkTagDao;
    public final TaskExecutor mWorkTaskExecutor;
    public ListenableWorker.Result mResult = new ListenableWorker.Result.Failure();
    public final SettableFuture<Boolean> mFuture = new SettableFuture<>();
    public ListenableFuture<ListenableWorker.Result> mInnerFuture = null;
    public ListenableWorker mWorker = null;

    /* loaded from: classes.dex */
    public static class Builder {
        public final Context mAppContext;
        public final Configuration mConfiguration;
        public final ForegroundProcessor mForegroundProcessor;
        public WorkerParameters.RuntimeExtras mRuntimeExtras = new WorkerParameters.RuntimeExtras();
        public List<Scheduler> mSchedulers;
        public final WorkDatabase mWorkDatabase;
        public final String mWorkSpecId;
        public final TaskExecutor mWorkTaskExecutor;

        public Builder(Context context, Configuration configuration, TaskExecutor workTaskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase database, String workSpecId) {
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = workTaskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration;
            this.mWorkDatabase = database;
            this.mWorkSpecId = workSpecId;
        }
    }

    public WorkerWrapper(Builder builder) {
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        this.mWorkSpecId = builder.mWorkSpecId;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mConfiguration = builder.mConfiguration;
        WorkDatabase workDatabase = builder.mWorkDatabase;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = workDatabase.dependencyDao();
        this.mWorkTagDao = workDatabase.workTagDao();
    }

    public final void handleResult(ListenableWorker.Result result) {
        boolean z = result instanceof ListenableWorker.Result.Success;
        String str = TAG;
        if (z) {
            Logger.get().info(str, String.format("Worker result SUCCESS for %s", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
                return;
            }
            DependencyDao dependencyDao = this.mDependencyDao;
            String str2 = this.mWorkSpecId;
            WorkSpecDao workSpecDao = this.mWorkSpecDao;
            WorkDatabase workDatabase = this.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo.State.SUCCEEDED, str2);
                ((WorkSpecDao_Impl) workSpecDao).setOutput(str2, ((ListenableWorker.Result.Success) this.mResult).mOutputData);
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = ((DependencyDao_Impl) dependencyDao).getDependentWorkIds(str2).iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    if (((WorkSpecDao_Impl) workSpecDao).getState(str3) == WorkInfo.State.BLOCKED && ((DependencyDao_Impl) dependencyDao).hasCompletedAllPrerequisites(str3)) {
                        Logger.get().info(str, String.format("Setting status to enqueued for %s", str3), new Throwable[0]);
                        ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo.State.ENQUEUED, str3);
                        ((WorkSpecDao_Impl) workSpecDao).setPeriodStartTime(currentTimeMillis, str3);
                    }
                }
                workDatabase.setTransactionSuccessful();
                return;
            } finally {
                workDatabase.endTransaction();
                resolve(false);
            }
        }
        if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(str, String.format("Worker result RETRY for %s", this.mWorkDescription), new Throwable[0]);
            rescheduleAndResolve();
            return;
        }
        Logger.get().info(str, String.format("Worker result FAILURE for %s", this.mWorkDescription), new Throwable[0]);
        if (this.mWorkSpec.isPeriodic()) {
            resetPeriodicAndResolve();
        } else {
            setFailedAndResolve();
        }
    }

    public final void iterativelyFailWorkAndDependents(String workSpecId) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(workSpecId);
        while (!linkedList.isEmpty()) {
            String str = (String) linkedList.remove();
            WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) this.mWorkSpecDao;
            if (workSpecDao_Impl.getState(str) != WorkInfo.State.CANCELLED) {
                workSpecDao_Impl.setState(WorkInfo.State.FAILED, str);
            }
            linkedList.addAll(((DependencyDao_Impl) this.mDependencyDao).getDependentWorkIds(str));
        }
    }

    public final void onWorkFinished() {
        boolean tryCheckForInterruptionAndResolve = tryCheckForInterruptionAndResolve();
        String str = this.mWorkSpecId;
        WorkDatabase workDatabase = this.mWorkDatabase;
        if (!tryCheckForInterruptionAndResolve) {
            workDatabase.beginTransaction();
            try {
                WorkInfo.State state = ((WorkSpecDao_Impl) this.mWorkSpecDao).getState(str);
                WorkProgressDao_Impl workProgressDao_Impl = (WorkProgressDao_Impl) workDatabase.workProgressDao();
                RoomDatabase roomDatabase = workProgressDao_Impl.__db;
                roomDatabase.assertNotSuspendingTransaction();
                WorkProgressDao_Impl.AnonymousClass2 anonymousClass2 = workProgressDao_Impl.__preparedStmtOfDelete;
                SupportSQLiteStatement acquire = anonymousClass2.acquire();
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                roomDatabase.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    roomDatabase.setTransactionSuccessful();
                    if (state == null) {
                        resolve(false);
                    } else if (state == WorkInfo.State.RUNNING) {
                        handleResult(this.mResult);
                    } else if (!state.isFinished()) {
                        rescheduleAndResolve();
                    }
                    workDatabase.setTransactionSuccessful();
                } finally {
                    roomDatabase.endTransaction();
                    anonymousClass2.release(acquire);
                }
            } finally {
                workDatabase.endTransaction();
            }
        }
        List<Scheduler> list = this.mSchedulers;
        if (list != null) {
            Iterator<Scheduler> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(str);
            }
            Schedulers.schedule(this.mConfiguration, workDatabase, list);
        }
    }

    public final void rescheduleAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao workSpecDao = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo.State.ENQUEUED, str);
            ((WorkSpecDao_Impl) workSpecDao).setPeriodStartTime(System.currentTimeMillis(), str);
            ((WorkSpecDao_Impl) workSpecDao).markWorkSpecScheduled(-1L, str);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            resolve(true);
        }
    }

    public final void resetPeriodicAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao workSpecDao = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            ((WorkSpecDao_Impl) workSpecDao).setPeriodStartTime(System.currentTimeMillis(), str);
            ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo.State.ENQUEUED, str);
            WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
            RoomDatabase roomDatabase = workSpecDao_Impl.__db;
            roomDatabase.assertNotSuspendingTransaction();
            WorkSpecDao_Impl.AnonymousClass6 anonymousClass6 = workSpecDao_Impl.__preparedStmtOfResetWorkSpecRunAttemptCount;
            SupportSQLiteStatement acquire = anonymousClass6.acquire();
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            roomDatabase.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                roomDatabase.setTransactionSuccessful();
                roomDatabase.endTransaction();
                anonymousClass6.release(acquire);
                ((WorkSpecDao_Impl) workSpecDao).markWorkSpecScheduled(-1L, str);
                workDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                roomDatabase.endTransaction();
                anonymousClass6.release(acquire);
                throw th;
            }
        } finally {
            workDatabase.endTransaction();
            resolve(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x009b, TryCatch #1 {all -> 0x009b, blocks: (B:3:0x0005, B:10:0x0030, B:12:0x0038, B:14:0x0041, B:15:0x005b, B:17:0x005f, B:19:0x0063, B:21:0x0069, B:22:0x0071, B:30:0x007e, B:32:0x007f, B:38:0x0094, B:39:0x009a, B:5:0x0020, B:7:0x0027, B:24:0x0072, B:25:0x007a), top: B:2:0x0005, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041 A[Catch: all -> 0x009b, TryCatch #1 {all -> 0x009b, blocks: (B:3:0x0005, B:10:0x0030, B:12:0x0038, B:14:0x0041, B:15:0x005b, B:17:0x005f, B:19:0x0063, B:21:0x0069, B:22:0x0071, B:30:0x007e, B:32:0x007f, B:38:0x0094, B:39:0x009a, B:5:0x0020, B:7:0x0027, B:24:0x0072, B:25:0x007a), top: B:2:0x0005, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void resolve(final boolean r6) {
        /*
            r5 = this;
            androidx.work.impl.WorkDatabase r0 = r5.mWorkDatabase
            r0.beginTransaction()
            androidx.work.impl.WorkDatabase r0 = r5.mWorkDatabase     // Catch: java.lang.Throwable -> L9b
            androidx.work.impl.model.WorkSpecDao r0 = r0.workSpecDao()     // Catch: java.lang.Throwable -> L9b
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0     // Catch: java.lang.Throwable -> L9b
            r0.getClass()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"
            r2 = 0
            androidx.room.RoomSQLiteQuery r1 = androidx.room.RoomSQLiteQuery.acquire(r2, r1)     // Catch: java.lang.Throwable -> L9b
            androidx.room.RoomDatabase r0 = r0.__db     // Catch: java.lang.Throwable -> L9b
            r0.assertNotSuspendingTransaction()     // Catch: java.lang.Throwable -> L9b
            android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2)     // Catch: java.lang.Throwable -> L9b
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L93
            r4 = 1
            if (r3 == 0) goto L2f
            int r3 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto L2f
            r3 = r4
            goto L30
        L2f:
            r3 = r2
        L30:
            r0.close()     // Catch: java.lang.Throwable -> L9b
            r1.release()     // Catch: java.lang.Throwable -> L9b
            if (r3 != 0) goto L3f
            android.content.Context r0 = r5.mAppContext     // Catch: java.lang.Throwable -> L9b
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r1 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            androidx.work.impl.utils.PackageManagerHelper.setComponentEnabled(r0, r1, r2)     // Catch: java.lang.Throwable -> L9b
        L3f:
            if (r6 == 0) goto L5b
            androidx.work.impl.model.WorkSpecDao r0 = r5.mWorkSpecDao     // Catch: java.lang.Throwable -> L9b
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.ENQUEUED     // Catch: java.lang.Throwable -> L9b
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = r5.mWorkSpecId     // Catch: java.lang.Throwable -> L9b
            r3[r2] = r4     // Catch: java.lang.Throwable -> L9b
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0     // Catch: java.lang.Throwable -> L9b
            r0.setState(r1, r3)     // Catch: java.lang.Throwable -> L9b
            androidx.work.impl.model.WorkSpecDao r0 = r5.mWorkSpecDao     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = r5.mWorkSpecId     // Catch: java.lang.Throwable -> L9b
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0     // Catch: java.lang.Throwable -> L9b
            r2 = -1
            r0.markWorkSpecScheduled(r2, r1)     // Catch: java.lang.Throwable -> L9b
        L5b:
            androidx.work.impl.model.WorkSpec r0 = r5.mWorkSpec     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L7f
            androidx.work.ListenableWorker r0 = r5.mWorker     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L7f
            boolean r0 = r0.isRunInForeground()     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L7f
            androidx.work.impl.foreground.ForegroundProcessor r0 = r5.mForegroundProcessor     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = r5.mWorkSpecId     // Catch: java.lang.Throwable -> L9b
            androidx.work.impl.Processor r0 = (androidx.work.impl.Processor) r0     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r2 = r0.mLock     // Catch: java.lang.Throwable -> L9b
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L9b
            java.util.HashMap r3 = r0.mForegroundWorkMap     // Catch: java.lang.Throwable -> L7c
            r3.remove(r1)     // Catch: java.lang.Throwable -> L7c
            r0.stopForegroundService()     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7c
            goto L7f
        L7c:
            r6 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7c
            throw r6     // Catch: java.lang.Throwable -> L9b
        L7f:
            androidx.work.impl.WorkDatabase r0 = r5.mWorkDatabase     // Catch: java.lang.Throwable -> L9b
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L9b
            androidx.work.impl.WorkDatabase r0 = r5.mWorkDatabase
            r0.endTransaction()
            androidx.work.impl.utils.futures.SettableFuture<java.lang.Boolean> r0 = r5.mFuture
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r0.set(r6)
            return
        L93:
            r6 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L9b
            r1.release()     // Catch: java.lang.Throwable -> L9b
            throw r6     // Catch: java.lang.Throwable -> L9b
        L9b:
            r6 = move-exception
            androidx.work.impl.WorkDatabase r0 = r5.mWorkDatabase
            r0.endTransaction()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.resolve(boolean):void");
    }

    public final void resolveIncorrectStatus() {
        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) this.mWorkSpecDao;
        String str = this.mWorkSpecId;
        WorkInfo.State state = workSpecDao_Impl.getState(str);
        WorkInfo.State state2 = WorkInfo.State.RUNNING;
        String str2 = TAG;
        if (state == state2) {
            Logger.get().debug(str2, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", str), new Throwable[0]);
            resolve(true);
        } else {
            Logger.get().debug(str2, String.format("Status for %s is %s; not doing any work", str, state), new Throwable[0]);
            resolve(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:            if (r0 != false) goto L30;     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.run():void");
    }

    public final void setFailedAndResolve() {
        String str = this.mWorkSpecId;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            iterativelyFailWorkAndDependents(str);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).setOutput(str, ((ListenableWorker.Result.Failure) this.mResult).mOutputData);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            resolve(false);
        }
    }

    public final boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        Logger.get().debug(TAG, String.format("Work interrupted for %s", this.mWorkDescription), new Throwable[0]);
        if (((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId) == null) {
            resolve(false);
        } else {
            resolve(!r0.isFinished());
        }
        return true;
    }
}
