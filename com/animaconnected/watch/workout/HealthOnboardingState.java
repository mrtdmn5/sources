package com.animaconnected.watch.workout;

import com.animaconnected.watch.behaviour.workout.Workout;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DashboardViewModel.kt */
/* loaded from: classes3.dex */
public final class HealthOnboardingState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HealthOnboardingState[] $VALUES;
    public static final HealthOnboardingState Inactive = new HealthOnboardingState("Inactive", 0);
    public static final HealthOnboardingState DailyGoal = new HealthOnboardingState("DailyGoal", 1);
    public static final HealthOnboardingState Workout = new HealthOnboardingState(Workout.TYPE, 2);
    public static final HealthOnboardingState Metric = new HealthOnboardingState("Metric", 3);
    public static final HealthOnboardingState LetsGo = new HealthOnboardingState("LetsGo", 4);
    public static final HealthOnboardingState InteractionComplete = new HealthOnboardingState("InteractionComplete", 5);

    private static final /* synthetic */ HealthOnboardingState[] $values() {
        return new HealthOnboardingState[]{Inactive, DailyGoal, Workout, Metric, LetsGo, InteractionComplete};
    }

    static {
        HealthOnboardingState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private HealthOnboardingState(String str, int r2) {
    }

    public static EnumEntries<HealthOnboardingState> getEntries() {
        return $ENTRIES;
    }

    public static HealthOnboardingState valueOf(String str) {
        return (HealthOnboardingState) Enum.valueOf(HealthOnboardingState.class, str);
    }

    public static HealthOnboardingState[] values() {
        return (HealthOnboardingState[]) $VALUES.clone();
    }
}
