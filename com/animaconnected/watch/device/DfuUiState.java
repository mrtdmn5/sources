package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchIO.kt */
/* loaded from: classes3.dex */
public final class DfuUiState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DfuUiState[] $VALUES;
    private final int id;
    public static final DfuUiState None = new DfuUiState("None", 0, 0);
    public static final DfuUiState Init = new DfuUiState("Init", 1, 1);
    public static final DfuUiState Loading = new DfuUiState("Loading", 2, 2);

    private static final /* synthetic */ DfuUiState[] $values() {
        return new DfuUiState[]{None, Init, Loading};
    }

    static {
        DfuUiState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DfuUiState(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<DfuUiState> getEntries() {
        return $ENTRIES;
    }

    public static DfuUiState valueOf(String str) {
        return (DfuUiState) Enum.valueOf(DfuUiState.class, str);
    }

    public static DfuUiState[] values() {
        return (DfuUiState[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
