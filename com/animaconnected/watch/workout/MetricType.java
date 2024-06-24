package com.animaconnected.watch.workout;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class MetricType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MetricType[] $VALUES;
    public static final MetricType ACTIVE_TIME = new MetricType("ACTIVE_TIME", 0);
    public static final MetricType TOTAL_TIME = new MetricType("TOTAL_TIME", 1);
    public static final MetricType DISTANCE = new MetricType("DISTANCE", 2);
    public static final MetricType STEPS = new MetricType("STEPS", 3);
    public static final MetricType PACE_AVG = new MetricType("PACE_AVG", 4);
    public static final MetricType SPEED_AVG = new MetricType("SPEED_AVG", 5);
    public static final MetricType ACTIVE_CALORIES = new MetricType("ACTIVE_CALORIES", 6);
    public static final MetricType TOTAL_CALORIES = new MetricType("TOTAL_CALORIES", 7);

    private static final /* synthetic */ MetricType[] $values() {
        return new MetricType[]{ACTIVE_TIME, TOTAL_TIME, DISTANCE, STEPS, PACE_AVG, SPEED_AVG, ACTIVE_CALORIES, TOTAL_CALORIES};
    }

    static {
        MetricType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private MetricType(String str, int r2) {
    }

    public static EnumEntries<MetricType> getEntries() {
        return $ENTRIES;
    }

    public static MetricType valueOf(String str) {
        return (MetricType) Enum.valueOf(MetricType.class, str);
    }

    public static MetricType[] values() {
        return (MetricType[]) $VALUES.clone();
    }
}
