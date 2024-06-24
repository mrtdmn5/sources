package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public final class NetworkNotRoamingController extends ConstraintController<NetworkState> {
    static {
        Logger.tagWithPrefix("NetworkNotRoamingCtrlr");
    }

    public NetworkNotRoamingController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).mNetworkStateTracker);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        if (workSpec.constraints.mRequiredNetworkType == NetworkType.NOT_ROAMING) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(NetworkState state) {
        NetworkState networkState = state;
        if (networkState.mIsConnected && networkState.mIsNotRoaming) {
            return false;
        }
        return true;
    }
}
