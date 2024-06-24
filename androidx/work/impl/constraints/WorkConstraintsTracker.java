package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {
    public static final String TAG = Logger.tagWithPrefix("WorkConstraintsTracker");
    public final WorkConstraintsCallback mCallback;
    public final ConstraintController<?>[] mConstraintControllers;
    public final Object mLock;

    public WorkConstraintsTracker(Context context, TaskExecutor taskExecutor, WorkConstraintsCallback callback) {
        Context applicationContext = context.getApplicationContext();
        this.mCallback = callback;
        this.mConstraintControllers = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
        this.mLock = new Object();
    }

    public final boolean areAllConstraintsMet(String workSpecId) {
        boolean z;
        synchronized (this.mLock) {
            for (ConstraintController<?> constraintController : this.mConstraintControllers) {
                Object obj = constraintController.mCurrentValue;
                if (obj != null && constraintController.isConstrained(obj) && constraintController.mMatchingWorkSpecIds.contains(workSpecId)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Logger.get().debug(TAG, String.format("Work %s constrained by %s", workSpecId, constraintController.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public final void replace(Collection workSpecs) {
        synchronized (this.mLock) {
            for (ConstraintController<?> constraintController : this.mConstraintControllers) {
                if (constraintController.mCallback != null) {
                    constraintController.mCallback = null;
                    constraintController.updateCallback(null, constraintController.mCurrentValue);
                }
            }
            for (ConstraintController<?> constraintController2 : this.mConstraintControllers) {
                constraintController2.replace(workSpecs);
            }
            for (ConstraintController<?> constraintController3 : this.mConstraintControllers) {
                if (constraintController3.mCallback != this) {
                    constraintController3.mCallback = this;
                    constraintController3.updateCallback(this, constraintController3.mCurrentValue);
                }
            }
        }
    }

    public final void reset() {
        synchronized (this.mLock) {
            for (ConstraintController<?> constraintController : this.mConstraintControllers) {
                ArrayList arrayList = constraintController.mMatchingWorkSpecIds;
                if (!arrayList.isEmpty()) {
                    arrayList.clear();
                    ConstraintTracker<?> constraintTracker = constraintController.mTracker;
                    synchronized (constraintTracker.mLock) {
                        if (constraintTracker.mListeners.remove(constraintController) && constraintTracker.mListeners.isEmpty()) {
                            constraintTracker.stopTracking();
                        }
                    }
                }
            }
        }
    }
}
