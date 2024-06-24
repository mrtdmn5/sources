package com.animaconnected.watch.workout;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class WorkoutPeriod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkoutPeriod[] $VALUES;
    public static final WorkoutPeriod WEEK = new WorkoutPeriod("WEEK", 0);
    public static final WorkoutPeriod MONTH = new WorkoutPeriod("MONTH", 1);
    public static final WorkoutPeriod YEAR = new WorkoutPeriod("YEAR", 2);

    private static final /* synthetic */ WorkoutPeriod[] $values() {
        return new WorkoutPeriod[]{WEEK, MONTH, YEAR};
    }

    static {
        WorkoutPeriod[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WorkoutPeriod(String str, int r2) {
    }

    public static EnumEntries<WorkoutPeriod> getEntries() {
        return $ENTRIES;
    }

    public static WorkoutPeriod valueOf(String str) {
        return (WorkoutPeriod) Enum.valueOf(WorkoutPeriod.class, str);
    }

    public static WorkoutPeriod[] values() {
        return (WorkoutPeriod[]) $VALUES.clone();
    }
}
