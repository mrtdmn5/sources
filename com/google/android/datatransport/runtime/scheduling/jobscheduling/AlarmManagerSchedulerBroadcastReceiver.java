package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

/* loaded from: classes3.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int r6 = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(context);
        AutoValue_TransportContext.Builder builder = TransportContext.builder();
        builder.setBackendName(queryParameter);
        builder.setPriority(PriorityMapping.valueOf(intValue));
        if (queryParameter2 != null) {
            builder.extras = Base64.decode(queryParameter2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        AutoValue_TransportContext build = builder.build();
        AlarmManagerSchedulerBroadcastReceiver$$ExternalSyntheticLambda0 alarmManagerSchedulerBroadcastReceiver$$ExternalSyntheticLambda0 = new AlarmManagerSchedulerBroadcastReceiver$$ExternalSyntheticLambda0();
        uploader.getClass();
        uploader.executor.execute(new Uploader$$ExternalSyntheticLambda0(uploader, build, r6, alarmManagerSchedulerBroadcastReceiver$$ExternalSyntheticLambda0));
    }
}
