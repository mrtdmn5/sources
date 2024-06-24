package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public final class BatteryNotLowController extends ConstraintController<Boolean> {
    public BatteryNotLowController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).mBatteryNotLowTracker);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.mRequiresBatteryNotLow;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(Boolean isBatteryNotLow) {
        return !isBatteryNotLow.booleanValue();
    }
}
