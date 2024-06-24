package com.animaconnected.watch.workout;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDatePickerViewModel.kt */
/* loaded from: classes3.dex */
public final class HistoryPeriodTab {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HistoryPeriodTab[] $VALUES;
    public static final HistoryPeriodTab Week = new HistoryPeriodTab("Week", 0);
    public static final HistoryPeriodTab Month = new HistoryPeriodTab("Month", 1);
    public static final HistoryPeriodTab Year = new HistoryPeriodTab("Year", 2);

    private static final /* synthetic */ HistoryPeriodTab[] $values() {
        return new HistoryPeriodTab[]{Week, Month, Year};
    }

    static {
        HistoryPeriodTab[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private HistoryPeriodTab(String str, int r2) {
    }

    public static EnumEntries<HistoryPeriodTab> getEntries() {
        return $ENTRIES;
    }

    public static HistoryPeriodTab valueOf(String str) {
        return (HistoryPeriodTab) Enum.valueOf(HistoryPeriodTab.class, str);
    }

    public static HistoryPeriodTab[] values() {
        return (HistoryPeriodTab[]) $VALUES.clone();
    }
}
