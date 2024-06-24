package com.animaconnected.watch.fitness;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class SyncState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SyncState[] $VALUES;
    public static final SyncState Done = new SyncState("Done", 0);
    public static final SyncState Calculating = new SyncState("Calculating", 1);
    public static final SyncState Fetching = new SyncState("Fetching", 2);
    public static final SyncState Error = new SyncState("Error", 3);

    private static final /* synthetic */ SyncState[] $values() {
        return new SyncState[]{Done, Calculating, Fetching, Error};
    }

    static {
        SyncState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SyncState(String str, int r2) {
    }

    public static EnumEntries<SyncState> getEntries() {
        return $ENTRIES;
    }

    public static SyncState valueOf(String str) {
        return (SyncState) Enum.valueOf(SyncState.class, str);
    }

    public static SyncState[] values() {
        return (SyncState[]) $VALUES.clone();
    }
}
