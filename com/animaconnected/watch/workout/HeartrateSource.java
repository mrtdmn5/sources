package com.animaconnected.watch.workout;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class HeartrateSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HeartrateSource[] $VALUES;
    public static final HeartrateSource LIVE = new HeartrateSource("LIVE", 0);
    public static final HeartrateSource HISTORY = new HeartrateSource("HISTORY", 1);

    private static final /* synthetic */ HeartrateSource[] $values() {
        return new HeartrateSource[]{LIVE, HISTORY};
    }

    static {
        HeartrateSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private HeartrateSource(String str, int r2) {
    }

    public static EnumEntries<HeartrateSource> getEntries() {
        return $ENTRIES;
    }

    public static HeartrateSource valueOf(String str) {
        return (HeartrateSource) Enum.valueOf(HeartrateSource.class, str);
    }

    public static HeartrateSource[] values() {
        return (HeartrateSource[]) $VALUES.clone();
    }
}
