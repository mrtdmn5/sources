package com.animaconnected.secondo.provider;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.JobSchedulerService;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class JobSchedulerService extends JobService {
    public static final int JOB_ID_UPDATE_PERIODIC = 1632863;
    private static final String TAG = "JobSchedulerService";
    private final Map<Integer, JobTask> mTasks = new HashMap();

    /* loaded from: classes3.dex */
    public class JobTask {
        private boolean mCanceled = false;

        public JobTask(final JobParameters jobParameters, Future<Void> future) {
            future.success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.JobSchedulerService$JobTask$$ExternalSyntheticLambda0
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    JobSchedulerService.JobTask.this.lambda$new$0(jobParameters, (Void) obj);
                }
            }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.JobSchedulerService$JobTask$$ExternalSyntheticLambda1
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    JobSchedulerService.JobTask.this.lambda$new$1(jobParameters, th);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(JobParameters jobParameters, Void r2) {
            onJobFinished(jobParameters, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(JobParameters jobParameters, Throwable th) {
            Log.d(JobSchedulerService.TAG, "Failed to check for updates: " + th);
            onJobFinished(jobParameters, true);
        }

        private void onJobFinished(JobParameters jobParameters, boolean z) {
            if (!this.mCanceled) {
                JobSchedulerService.this.jobFinished(jobParameters, z);
                JobSchedulerService.this.mTasks.remove(Integer.valueOf(jobParameters.getJobId()));
            }
        }

        public void cancel() {
            this.mCanceled = true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        int jobId = jobParameters.getJobId();
        Log.d(TAG, "onStartJob() getJobId(): " + jobId);
        if (jobId == 1632863) {
            try {
                this.mTasks.put(Integer.valueOf(jobParameters.getJobId()), new JobTask(jobParameters, ProviderFactory.getBackgroundUpdateChecker().refreshNow()));
                return true;
            } catch (Exception e) {
                LogKt.err((Object) this, SubMenuBuilder$$ExternalSyntheticOutline0.m("onStartJob() exception jobId:", jobId), TAG, (Throwable) e, true);
                return false;
            }
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        JobTask jobTask = this.mTasks.get(Integer.valueOf(jobParameters.getJobId()));
        Log.d(TAG, "onStopJob() getJobId(): " + jobParameters.getJobId() + " task: " + jobTask);
        if (jobTask != null) {
            jobTask.cancel();
            this.mTasks.remove(Integer.valueOf(jobParameters.getJobId()));
            return true;
        }
        return true;
    }
}
