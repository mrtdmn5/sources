package com.animaconnected.watch.workout;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.workout.ListItem;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class DailyGoalsProgressItem extends ListItem {
    private boolean allGoalsCompleted;
    private final BarEntry exerciseEntry;
    private final boolean exerciseGoalsCompleted;
    private final ListItem.Type itemType;
    private final BarEntry standEntry;
    private final boolean standGoalsCompleted;
    private final boolean stepGoalsCompleted;
    private final BarEntry stepsEntry;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyGoalsProgressItem(String title, BarEntry stepsEntry, BarEntry standEntry, BarEntry exerciseEntry, boolean z, boolean z2, boolean z3) {
        super(null);
        boolean z4;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(stepsEntry, "stepsEntry");
        Intrinsics.checkNotNullParameter(standEntry, "standEntry");
        Intrinsics.checkNotNullParameter(exerciseEntry, "exerciseEntry");
        this.title = title;
        this.stepsEntry = stepsEntry;
        this.standEntry = standEntry;
        this.exerciseEntry = exerciseEntry;
        this.stepGoalsCompleted = z;
        this.standGoalsCompleted = z2;
        this.exerciseGoalsCompleted = z3;
        this.itemType = ListItem.Type.DailyGoalsProgressItem;
        if (z && z2 && z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.allGoalsCompleted = z4;
    }

    public static /* synthetic */ DailyGoalsProgressItem copy$default(DailyGoalsProgressItem dailyGoalsProgressItem, String str, BarEntry barEntry, BarEntry barEntry2, BarEntry barEntry3, boolean z, boolean z2, boolean z3, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            str = dailyGoalsProgressItem.title;
        }
        if ((r13 & 2) != 0) {
            barEntry = dailyGoalsProgressItem.stepsEntry;
        }
        BarEntry barEntry4 = barEntry;
        if ((r13 & 4) != 0) {
            barEntry2 = dailyGoalsProgressItem.standEntry;
        }
        BarEntry barEntry5 = barEntry2;
        if ((r13 & 8) != 0) {
            barEntry3 = dailyGoalsProgressItem.exerciseEntry;
        }
        BarEntry barEntry6 = barEntry3;
        if ((r13 & 16) != 0) {
            z = dailyGoalsProgressItem.stepGoalsCompleted;
        }
        boolean z4 = z;
        if ((r13 & 32) != 0) {
            z2 = dailyGoalsProgressItem.standGoalsCompleted;
        }
        boolean z5 = z2;
        if ((r13 & 64) != 0) {
            z3 = dailyGoalsProgressItem.exerciseGoalsCompleted;
        }
        return dailyGoalsProgressItem.copy(str, barEntry4, barEntry5, barEntry6, z4, z5, z3);
    }

    public final String component1() {
        return this.title;
    }

    public final BarEntry component2() {
        return this.stepsEntry;
    }

    public final BarEntry component3() {
        return this.standEntry;
    }

    public final BarEntry component4() {
        return this.exerciseEntry;
    }

    public final boolean component5() {
        return this.stepGoalsCompleted;
    }

    public final boolean component6() {
        return this.standGoalsCompleted;
    }

    public final boolean component7() {
        return this.exerciseGoalsCompleted;
    }

    public final DailyGoalsProgressItem copy(String title, BarEntry stepsEntry, BarEntry standEntry, BarEntry exerciseEntry, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(stepsEntry, "stepsEntry");
        Intrinsics.checkNotNullParameter(standEntry, "standEntry");
        Intrinsics.checkNotNullParameter(exerciseEntry, "exerciseEntry");
        return new DailyGoalsProgressItem(title, stepsEntry, standEntry, exerciseEntry, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyGoalsProgressItem)) {
            return false;
        }
        DailyGoalsProgressItem dailyGoalsProgressItem = (DailyGoalsProgressItem) obj;
        if (Intrinsics.areEqual(this.title, dailyGoalsProgressItem.title) && Intrinsics.areEqual(this.stepsEntry, dailyGoalsProgressItem.stepsEntry) && Intrinsics.areEqual(this.standEntry, dailyGoalsProgressItem.standEntry) && Intrinsics.areEqual(this.exerciseEntry, dailyGoalsProgressItem.exerciseEntry) && this.stepGoalsCompleted == dailyGoalsProgressItem.stepGoalsCompleted && this.standGoalsCompleted == dailyGoalsProgressItem.standGoalsCompleted && this.exerciseGoalsCompleted == dailyGoalsProgressItem.exerciseGoalsCompleted) {
            return true;
        }
        return false;
    }

    public final boolean getAllGoalsCompleted() {
        return this.allGoalsCompleted;
    }

    public final BarEntry getExerciseEntry() {
        return this.exerciseEntry;
    }

    public final boolean getExerciseGoalsCompleted() {
        return this.exerciseGoalsCompleted;
    }

    @Override // com.animaconnected.watch.workout.ListItem
    public ListItem.Type getItemType() {
        return this.itemType;
    }

    public final BarEntry getStandEntry() {
        return this.standEntry;
    }

    public final boolean getStandGoalsCompleted() {
        return this.standGoalsCompleted;
    }

    public final boolean getStepGoalsCompleted() {
        return this.stepGoalsCompleted;
    }

    public final BarEntry getStepsEntry() {
        return this.stepsEntry;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Boolean.hashCode(this.exerciseGoalsCompleted) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.standGoalsCompleted, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.stepGoalsCompleted, (this.exerciseEntry.hashCode() + ((this.standEntry.hashCode() + ((this.stepsEntry.hashCode() + (this.title.hashCode() * 31)) * 31)) * 31)) * 31, 31), 31);
    }

    public final void setAllGoalsCompleted(boolean z) {
        this.allGoalsCompleted = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DailyGoalsProgressItem(title=");
        sb.append(this.title);
        sb.append(", stepsEntry=");
        sb.append(this.stepsEntry);
        sb.append(", standEntry=");
        sb.append(this.standEntry);
        sb.append(", exerciseEntry=");
        sb.append(this.exerciseEntry);
        sb.append(", stepGoalsCompleted=");
        sb.append(this.stepGoalsCompleted);
        sb.append(", standGoalsCompleted=");
        sb.append(this.standGoalsCompleted);
        sb.append(", exerciseGoalsCompleted=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.exerciseGoalsCompleted, ')');
    }
}
