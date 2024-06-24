package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

/* loaded from: classes3.dex */
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int r2 = jobParameters.getExtras().getInt("priority");
        int r3 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        AutoValue_TransportContext.Builder builder = TransportContext.builder();
        builder.setBackendName(string);
        builder.setPriority(PriorityMapping.valueOf(r2));
        if (string2 != null) {
            builder.extras = Base64.decode(string2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        AutoValue_TransportContext build = builder.build();
        Runnable runnable = new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                int r0 = JobInfoSchedulerService.$r8$clinit;
                JobInfoSchedulerService.this.jobFinished(jobParameters, false);
            }
        };
        uploader.getClass();
        uploader.executor.execute(new Uploader$$ExternalSyntheticLambda0(uploader, build, r3, runnable));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
