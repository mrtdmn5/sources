package com.animaconnected.watch.workout;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class WorkoutMetricType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkoutMetricType[] $VALUES;
    public static final WorkoutMetricType Steps = new WorkoutMetricType("Steps", 0);
    public static final WorkoutMetricType HeartRate = new WorkoutMetricType("HeartRate", 1);
    public static final WorkoutMetricType Calories = new WorkoutMetricType("Calories", 2);
    public static final WorkoutMetricType VO2Max = new WorkoutMetricType("VO2Max", 3);
    public static final WorkoutMetricType Sleep = new WorkoutMetricType("Sleep", 4);

    private static final /* synthetic */ WorkoutMetricType[] $values() {
        return new WorkoutMetricType[]{Steps, HeartRate, Calories, VO2Max, Sleep};
    }

    static {
        WorkoutMetricType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WorkoutMetricType(String str, int r2) {
    }

    public static EnumEntries<WorkoutMetricType> getEntries() {
        return $ENTRIES;
    }

    public static WorkoutMetricType valueOf(String str) {
        return (WorkoutMetricType) Enum.valueOf(WorkoutMetricType.class, str);
    }

    public static WorkoutMetricType[] values() {
        return (WorkoutMetricType[]) $VALUES.clone();
    }
}
