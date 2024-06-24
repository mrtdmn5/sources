package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* loaded from: classes3.dex */
public final class JobInfoScheduler implements WorkScheduler {
    public final SchedulerConfig config;
    public final Context context;
    public final EventStore eventStore;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.context = context;
        this.eventStore = eventStore;
        this.config = schedulerConfig;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public final void schedule(TransportContext transportContext, int r3) {
        schedule(transportContext, r3, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public final void schedule(TransportContext transportContext, int r14, boolean z) {
        boolean z2;
        Context context = this.context;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName(Constants.DEFAULT_ENCODING)));
        adler32.update(transportContext.getBackendName().getBytes(Charset.forName(Constants.DEFAULT_ENCODING)));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.toInt(transportContext.getPriority())).array());
        if (transportContext.getExtras() != null) {
            adler32.update(transportContext.getExtras());
        }
        int value = (int) adler32.getValue();
        if (!z) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int r8 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (r8 >= r14) {
                        z2 = true;
                    }
                }
            }
            z2 = false;
            if (z2) {
                Logging.d(transportContext, "JobInfoScheduler", "Upload for context %s is already scheduled. Returning...");
                return;
            }
        }
        long nextCallTime = this.eventStore.getNextCallTime(transportContext);
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        Priority priority = transportContext.getPriority();
        SchedulerConfig schedulerConfig = this.config;
        builder.setMinimumLatency(schedulerConfig.getScheduleDelay(priority, nextCallTime, r14));
        Set<SchedulerConfig.Flag> flags = schedulerConfig.getValues().get(priority).getFlags();
        if (flags.contains(SchedulerConfig.Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (flags.contains(SchedulerConfig.Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (flags.contains(SchedulerConfig.Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", r14);
        persistableBundle.putString("backendName", transportContext.getBackendName());
        persistableBundle.putInt("priority", PriorityMapping.toInt(transportContext.getPriority()));
        if (transportContext.getExtras() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = {transportContext, Integer.valueOf(value), Long.valueOf(schedulerConfig.getScheduleDelay(transportContext.getPriority(), nextCallTime, r14)), Long.valueOf(nextCallTime), Integer.valueOf(r14)};
        String tag = Logging.getTag("JobInfoScheduler");
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
        }
        jobScheduler.schedule(builder.build());
    }
}
