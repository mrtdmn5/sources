package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("SystemJobService");
    public final HashMap mJobParameters = new HashMap();
    public WorkManagerImpl mWorkManagerImpl;

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl = workManagerImpl;
            workManagerImpl.mProcessor.addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            Processor processor = workManagerImpl.mProcessor;
            synchronized (processor.mLock) {
                processor.mOuterListeners.remove(this);
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String workSpecId, boolean needsReschedule) {
        JobParameters jobParameters;
        Logger.get().debug(TAG, String.format("%s executed on JobScheduler", workSpecId), new Throwable[0]);
        synchronized (this.mJobParameters) {
            jobParameters = (JobParameters) this.mJobParameters.remove(workSpecId);
        }
        if (jobParameters != null) {
            jobFinished(jobParameters, needsReschedule);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // android.app.job.JobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            androidx.work.impl.WorkManagerImpl r0 = r8.mWorkManagerImpl
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L17
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r3 = androidx.work.impl.background.systemjob.SystemJobService.TAG
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.debug(r3, r4, r5)
            r8.jobFinished(r9, r1)
            return r2
        L17:
            java.lang.String r0 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r3 = r9.getExtras()     // Catch: java.lang.NullPointerException -> L2a
            if (r3 == 0) goto L2a
            boolean r4 = r3.containsKey(r0)     // Catch: java.lang.NullPointerException -> L2a
            if (r4 == 0) goto L2a
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.NullPointerException -> L2a
            goto L2b
        L2a:
            r0 = 0
        L2b:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L3f
            androidx.work.Logger r9 = androidx.work.Logger.get()
            java.lang.String r0 = androidx.work.impl.background.systemjob.SystemJobService.TAG
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.error(r0, r1, r3)
            return r2
        L3f:
            java.util.HashMap r3 = r8.mJobParameters
            monitor-enter(r3)
            java.util.HashMap r4 = r8.mJobParameters     // Catch: java.lang.Throwable -> Lb3
            boolean r4 = r4.containsKey(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r4 == 0) goto L61
            androidx.work.Logger r9 = androidx.work.Logger.get()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r1 = androidx.work.impl.background.systemjob.SystemJobService.TAG     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r4 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = java.lang.String.format(r4, r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.Throwable[] r4 = new java.lang.Throwable[r2]     // Catch: java.lang.Throwable -> Lb3
            r9.debug(r1, r0, r4)     // Catch: java.lang.Throwable -> Lb3
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb3
            return r2
        L61:
            androidx.work.Logger r4 = androidx.work.Logger.get()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = androidx.work.impl.background.systemjob.SystemJobService.TAG     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch: java.lang.Throwable -> Lb3
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch: java.lang.Throwable -> Lb3
            r4.debug(r5, r6, r2)     // Catch: java.lang.Throwable -> Lb3
            java.util.HashMap r2 = r8.mJobParameters     // Catch: java.lang.Throwable -> Lb3
            r2.put(r0, r9)     // Catch: java.lang.Throwable -> Lb3
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb3
            int r2 = android.os.Build.VERSION.SDK_INT
            androidx.work.WorkerParameters$RuntimeExtras r3 = new androidx.work.WorkerParameters$RuntimeExtras
            r3.<init>()
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            if (r4 == 0) goto L93
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.triggeredContentUris = r4
        L93:
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            if (r4 == 0) goto La3
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.triggeredContentAuthorities = r4
        La3:
            r4 = 28
            if (r2 < r4) goto Lad
            android.net.Network r9 = androidx.work.impl.background.systemjob.SystemJobService$$ExternalSyntheticApiModelOutline0.m(r9)
            r3.network = r9
        Lad:
            androidx.work.impl.WorkManagerImpl r9 = r8.mWorkManagerImpl
            r9.startWork(r0, r3)
            return r1
        Lb3:
            r9 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb3
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    @Override // android.app.job.JobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onStopJob(android.app.job.JobParameters r7) {
        /*
            r6 = this;
            androidx.work.impl.WorkManagerImpl r0 = r6.mWorkManagerImpl
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L14
            androidx.work.Logger r7 = androidx.work.Logger.get()
            java.lang.String r0 = androidx.work.impl.background.systemjob.SystemJobService.TAG
            java.lang.String r3 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]
            r7.debug(r0, r3, r2)
            return r1
        L14:
            java.lang.String r0 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r7 = r7.getExtras()     // Catch: java.lang.NullPointerException -> L27
            if (r7 == 0) goto L27
            boolean r3 = r7.containsKey(r0)     // Catch: java.lang.NullPointerException -> L27
            if (r3 == 0) goto L27
            java.lang.String r7 = r7.getString(r0)     // Catch: java.lang.NullPointerException -> L27
            goto L28
        L27:
            r7 = 0
        L28:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L3c
            androidx.work.Logger r7 = androidx.work.Logger.get()
            java.lang.String r0 = androidx.work.impl.background.systemjob.SystemJobService.TAG
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r7.error(r0, r1, r3)
            return r2
        L3c:
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r3 = androidx.work.impl.background.systemjob.SystemJobService.TAG
            java.lang.String r4 = "onStopJob for %s"
            java.lang.Object[] r5 = new java.lang.Object[]{r7}
            java.lang.String r4 = java.lang.String.format(r4, r5)
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]
            r0.debug(r3, r4, r2)
            java.util.HashMap r0 = r6.mJobParameters
            monitor-enter(r0)
            java.util.HashMap r2 = r6.mJobParameters     // Catch: java.lang.Throwable -> L72
            r2.remove(r7)     // Catch: java.lang.Throwable -> L72
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L72
            androidx.work.impl.WorkManagerImpl r0 = r6.mWorkManagerImpl
            r0.stopWork(r7)
            androidx.work.impl.WorkManagerImpl r0 = r6.mWorkManagerImpl
            androidx.work.impl.Processor r0 = r0.mProcessor
            java.lang.Object r2 = r0.mLock
            monitor-enter(r2)
            java.util.HashSet r0 = r0.mCancelledIds     // Catch: java.lang.Throwable -> L6f
            boolean r7 = r0.contains(r7)     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6f
            r7 = r7 ^ r1
            return r7
        L6f:
            r7 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6f
            throw r7
        L72:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L72
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStopJob(android.app.job.JobParameters):boolean");
    }
}
