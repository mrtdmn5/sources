package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public final class NetworkConnectedController extends ConstraintController<NetworkState> {
    public NetworkConnectedController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).mNetworkStateTracker);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        if (workSpec.constraints.mRequiredNetworkType == NetworkType.CONNECTED) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(NetworkState state) {
        NetworkState networkState = state;
        if (Build.VERSION.SDK_INT >= 26) {
            if (!networkState.mIsConnected || !networkState.mIsValidated) {
                return true;
            }
            return false;
        }
        return true ^ networkState.mIsConnected;
    }
}
