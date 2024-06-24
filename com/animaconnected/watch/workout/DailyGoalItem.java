package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.workout.ListItem;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class DailyGoalItem extends ListItem {
    private final CommonFlow<BarEntry> exerciseFlow;
    private final ListItem.Type itemType;
    private final CommonFlow<BarEntry> standFlow;
    private final CommonFlow<BarEntry> stepsFlow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyGoalItem(CommonFlow<BarEntry> stepsFlow, CommonFlow<BarEntry> standFlow, CommonFlow<BarEntry> exerciseFlow) {
        super(null);
        Intrinsics.checkNotNullParameter(stepsFlow, "stepsFlow");
        Intrinsics.checkNotNullParameter(standFlow, "standFlow");
        Intrinsics.checkNotNullParameter(exerciseFlow, "exerciseFlow");
        this.stepsFlow = stepsFlow;
        this.standFlow = standFlow;
        this.exerciseFlow = exerciseFlow;
        this.itemType = ListItem.Type.DailyGoal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DailyGoalItem copy$default(DailyGoalItem dailyGoalItem, CommonFlow commonFlow, CommonFlow commonFlow2, CommonFlow commonFlow3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            commonFlow = dailyGoalItem.stepsFlow;
        }
        if ((r4 & 2) != 0) {
            commonFlow2 = dailyGoalItem.standFlow;
        }
        if ((r4 & 4) != 0) {
            commonFlow3 = dailyGoalItem.exerciseFlow;
        }
        return dailyGoalItem.copy(commonFlow, commonFlow2, commonFlow3);
    }

    public final CommonFlow<BarEntry> component1() {
        return this.stepsFlow;
    }

    public final CommonFlow<BarEntry> component2() {
        return this.standFlow;
    }

    public final CommonFlow<BarEntry> component3() {
        return this.exerciseFlow;
    }

    public final DailyGoalItem copy(CommonFlow<BarEntry> stepsFlow, CommonFlow<BarEntry> standFlow, CommonFlow<BarEntry> exerciseFlow) {
        Intrinsics.checkNotNullParameter(stepsFlow, "stepsFlow");
        Intrinsics.checkNotNullParameter(standFlow, "standFlow");
        Intrinsics.checkNotNullParameter(exerciseFlow, "exerciseFlow");
        return new DailyGoalItem(stepsFlow, standFlow, exerciseFlow);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyGoalItem)) {
            return false;
        }
        DailyGoalItem dailyGoalItem = (DailyGoalItem) obj;
        if (Intrinsics.areEqual(this.stepsFlow, dailyGoalItem.stepsFlow) && Intrinsics.areEqual(this.standFlow, dailyGoalItem.standFlow) && Intrinsics.areEqual(this.exerciseFlow, dailyGoalItem.exerciseFlow)) {
            return true;
        }
        return false;
    }

    public final CommonFlow<BarEntry> getExerciseFlow() {
        return this.exerciseFlow;
    }

    @Override // com.animaconnected.watch.workout.ListItem
    public ListItem.Type getItemType() {
        return this.itemType;
    }

    public final CommonFlow<BarEntry> getStandFlow() {
        return this.standFlow;
    }

    public final CommonFlow<BarEntry> getStepsFlow() {
        return this.stepsFlow;
    }

    public int hashCode() {
        return this.exerciseFlow.hashCode() + ((this.standFlow.hashCode() + (this.stepsFlow.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "DailyGoalItem(stepsFlow=" + this.stepsFlow + ", standFlow=" + this.standFlow + ", exerciseFlow=" + this.exerciseFlow + ')';
    }
}
