package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public final class Trackers {
    public static Trackers sInstance;
    public final BatteryChargingTracker mBatteryChargingTracker;
    public final BatteryNotLowTracker mBatteryNotLowTracker;
    public final NetworkStateTracker mNetworkStateTracker;
    public final StorageNotLowTracker mStorageNotLowTracker;

    public Trackers(Context context, TaskExecutor taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.mBatteryChargingTracker = new BatteryChargingTracker(applicationContext, taskExecutor);
        this.mBatteryNotLowTracker = new BatteryNotLowTracker(applicationContext, taskExecutor);
        this.mNetworkStateTracker = new NetworkStateTracker(applicationContext, taskExecutor);
        this.mStorageNotLowTracker = new StorageNotLowTracker(applicationContext, taskExecutor);
    }

    public static synchronized Trackers getInstance(Context context, TaskExecutor taskExecutor) {
        Trackers trackers;
        synchronized (Trackers.class) {
            if (sInstance == null) {
                sInstance = new Trackers(context, taskExecutor);
            }
            trackers = sInstance;
        }
        return trackers;
    }
}
