package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String TAG = Logger.tagWithPrefix("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String str = TAG;
        Logger.get().debug(str, "Requesting diagnostics", new Throwable[0]);
        try {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
            OneTimeWorkRequest build = new OneTimeWorkRequest.Builder().build();
            workManagerImpl.getClass();
            List singletonList = Collections.singletonList(build);
            if (!singletonList.isEmpty()) {
                new WorkContinuationImpl(workManagerImpl, null, ExistingWorkPolicy.KEEP, singletonList).enqueue();
                return;
            }
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        } catch (IllegalStateException e) {
            Logger.get().error(str, "WorkManager is not initialized", e);
        }
    }
}
