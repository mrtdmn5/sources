package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String TAG = Logger.tagWithPrefix("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("Received intent %s", intent), new Throwable[0]);
        try {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
            BroadcastReceiver.PendingResult goAsync = goAsync();
            workManagerImpl.getClass();
            synchronized (WorkManagerImpl.sLock) {
                workManagerImpl.mRescheduleReceiverResult = goAsync;
                if (workManagerImpl.mForceStopRunnableCompleted) {
                    goAsync.finish();
                    workManagerImpl.mRescheduleReceiverResult = null;
                }
            }
        } catch (IllegalStateException e) {
            Logger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
