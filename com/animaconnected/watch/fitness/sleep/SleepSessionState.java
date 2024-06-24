package com.animaconnected.watch.fitness.sleep;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SleepSession.kt */
/* loaded from: classes3.dex */
public final class SleepSessionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SleepSessionState[] $VALUES;
    public static final SleepSessionState Invalid = new SleepSessionState("Invalid", 0);
    public static final SleepSessionState Ongoing = new SleepSessionState("Ongoing", 1);
    public static final SleepSessionState Completed = new SleepSessionState("Completed", 2);

    private static final /* synthetic */ SleepSessionState[] $values() {
        return new SleepSessionState[]{Invalid, Ongoing, Completed};
    }

    static {
        SleepSessionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SleepSessionState(String str, int r2) {
    }

    public static EnumEntries<SleepSessionState> getEntries() {
        return $ENTRIES;
    }

    public static SleepSessionState valueOf(String str) {
        return (SleepSessionState) Enum.valueOf(SleepSessionState.class, str);
    }

    public static SleepSessionState[] values() {
        return (SleepSessionState[]) $VALUES.clone();
    }
}
