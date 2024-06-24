package com.animaconnected.secondo.screens.workout.dashboard;

import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.workout.DailyGoalItem;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthDashboardScreen.kt */
/* loaded from: classes3.dex */
public final class GoalData {
    public static final int $stable = 8;
    private final HealthGoals goals;
    private final DailyGoalItem progress;

    public GoalData(DailyGoalItem progress, HealthGoals goals) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(goals, "goals");
        this.progress = progress;
        this.goals = goals;
    }

    public static /* synthetic */ GoalData copy$default(GoalData goalData, DailyGoalItem dailyGoalItem, HealthGoals healthGoals, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            dailyGoalItem = goalData.progress;
        }
        if ((r3 & 2) != 0) {
            healthGoals = goalData.goals;
        }
        return goalData.copy(dailyGoalItem, healthGoals);
    }

    public final DailyGoalItem component1() {
        return this.progress;
    }

    public final HealthGoals component2() {
        return this.goals;
    }

    public final GoalData copy(DailyGoalItem progress, HealthGoals goals) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(goals, "goals");
        return new GoalData(progress, goals);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoalData)) {
            return false;
        }
        GoalData goalData = (GoalData) obj;
        if (Intrinsics.areEqual(this.progress, goalData.progress) && Intrinsics.areEqual(this.goals, goalData.goals)) {
            return true;
        }
        return false;
    }

    public final HealthGoals getGoals() {
        return this.goals;
    }

    public final DailyGoalItem getProgress() {
        return this.progress;
    }

    public int hashCode() {
        return this.goals.hashCode() + (this.progress.hashCode() * 31);
    }

    public String toString() {
        return "GoalData(progress=" + this.progress + ", goals=" + this.goals + ')';
    }
}
