package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;

/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String TAG = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str)) {
            Logger.get().debug(TAG, String.format("Ignoring unknown action %s", str), new Throwable[0]);
        } else {
            final BroadcastReceiver.PendingResult goAsync = goAsync();
            ((WorkManagerTaskExecutor) WorkManagerImpl.getInstance(context).mWorkTaskExecutor).executeOnBackgroundThread(new Runnable() { // from class: androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver.1
                @Override // java.lang.Runnable
                public final void run() {
                    BroadcastReceiver.PendingResult pendingResult = goAsync;
                    Context context2 = context;
                    Intent intent2 = intent;
                    try {
                        boolean booleanExtra = intent2.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra2 = intent2.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                        boolean booleanExtra3 = intent2.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra4 = intent2.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                        Logger.get().debug(ConstraintProxyUpdateReceiver.TAG, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                        PackageManagerHelper.setComponentEnabled(context2, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                        PackageManagerHelper.setComponentEnabled(context2, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                        PackageManagerHelper.setComponentEnabled(context2, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                        PackageManagerHelper.setComponentEnabled(context2, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                    } finally {
                        pendingResult.finish();
                    }
                }
            });
        }
    }
}
