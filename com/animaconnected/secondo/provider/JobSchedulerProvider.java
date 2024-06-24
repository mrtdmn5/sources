package com.animaconnected.secondo.provider;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import com.animaconnected.secondo.provider.update.UpdateJobScheduler;
import java.util.Locale;

/* loaded from: classes3.dex */
class JobSchedulerProvider implements UpdateJobScheduler {
    private static final long BACKOFF_MS = 1800000;
    private static final String TAG = "JobSchedulerProvider";
    private final Context mContext;

    public JobSchedulerProvider(Context context) {
        this.mContext = context;
    }

    private void scheduleJob(JobInfo jobInfo) {
        ((JobScheduler) this.mContext.getSystemService("jobscheduler")).schedule(jobInfo);
    }

    @Override // com.animaconnected.secondo.provider.update.UpdateJobScheduler
    public void schedulePeriodicUpdateJob(long j) {
        Log.d(TAG, String.format(Locale.ROOT, "schedulePeriodicUpdateJob (h): %.2f", Float.valueOf(((float) j) / 3600000.0f)));
        scheduleJob(new JobInfo.Builder(JobSchedulerService.JOB_ID_UPDATE_PERIODIC, new ComponentName(this.mContext, (Class<?>) JobSchedulerService.class)).setBackoffCriteria(BACKOFF_MS, 1).setRequiredNetworkType(1).setPeriodic(j).setPersisted(true).build());
    }
}
