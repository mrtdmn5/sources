package com.animaconnected.secondo.behaviour.steps;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.WatchFaceBehavior;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Steps.kt */
/* loaded from: classes3.dex */
public final class Steps extends WatchFaceBehavior {
    private static final float MAX_ANGLE = 300.0f;
    private boolean active;
    private final String analyticsName;
    private final int deviceComplicationMode;
    private final FitnessProvider fitnessProvider;
    private TimePeriod periodCollecting;
    private Job refreshJob;
    private boolean refreshing;
    private final MutableStateFlow<Integer> stepsToday;
    private final String type$1;
    private Job updateStepsJob;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    public static final String type = "Steps";

    /* compiled from: Steps.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Steps(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
        this.type$1 = type;
        this.analyticsName = "daily_hundred";
        this.stepsToday = StateFlowKt.MutableStateFlow(0);
        this.periodCollecting = TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null);
        this.deviceComplicationMode = 4;
    }

    private final float getStepsInDegrees() {
        float stepsToday = (getStepsToday() / getStepGoal()) * MAX_ANGLE;
        if (MAX_ANGLE <= stepsToday) {
            return MAX_ANGLE;
        }
        return stepsToday;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshCollectionIfNeeded() {
        if (!Intrinsics.areEqual(this.periodCollecting, TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null))) {
            Job job = this.updateStepsJob;
            if (job != null) {
                job.cancel(null);
            }
            this.updateStepsJob = null;
            startCollecting();
        }
    }

    private final void startCollecting() {
        if (this.updateStepsJob != null) {
            return;
        }
        this.periodCollecting = TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null);
        this.updateStepsJob = BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new Steps$startCollecting$1(this, null), 3);
    }

    private final void stopCollecting() {
        if (!this.active && !this.refreshing) {
            Job job = this.updateStepsJob;
            if (job != null) {
                job.cancel(null);
            }
            this.updateStepsJob = null;
        }
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        super.activate(slot);
        this.active = true;
        startCollecting();
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return CollectionsKt__CollectionsKt.listOf(Scale.ZeroToHundred);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.SubComplication1, Slot.SubComplication2, Slot.MainComplication, Slot.MainComplicationDouble};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        super.deactivated(slot);
        this.active = false;
        stopCollecting();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return this.deviceComplicationMode;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees() {
        return getStepsInDegrees();
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getMinutesInDegrees() {
        return getStepsInDegrees();
    }

    public final int getStepGoal() {
        return this.fitnessProvider.getGoalOnce(DateTimeUtilsKt.currentTimeMillis()).getSteps();
    }

    public final int getStepsToday() {
        return this.stepsToday.getValue().intValue();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type$1;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void startRefreshing() {
        this.refreshing = true;
        if (this.updateStepsJob != null) {
            refreshCollectionIfNeeded();
        } else {
            startCollecting();
        }
        this.refreshJob = BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new Steps$startRefreshing$1(this, null), 3);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void stopRefreshing() {
        this.refreshing = false;
        stopCollecting();
        Job job = this.refreshJob;
        if (job != null) {
            job.cancel(null);
        }
        this.refreshJob = null;
    }
}
