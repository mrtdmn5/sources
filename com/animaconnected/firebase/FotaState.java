package com.animaconnected.firebase;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchEvents.kt */
/* loaded from: classes.dex */
public final class FotaState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FotaState[] $VALUES;
    private final String key;
    public static final FotaState ErrorFailed = new FotaState("ErrorFailed", 0, "failed");
    public static final FotaState ErrorPerformFailed = new FotaState("ErrorPerformFailed", 1, "perform_failed");
    public static final FotaState ReadyToPerform = new FotaState("ReadyToPerform", 2, "ready_to_perform");
    public static final FotaState PerformCompleted = new FotaState("PerformCompleted", 3, "waiting_for_reconnect");
    public static final FotaState Success = new FotaState("Success", 4, AnalyticsConstants.KEY_SUCCESSFUL);

    private static final /* synthetic */ FotaState[] $values() {
        return new FotaState[]{ErrorFailed, ErrorPerformFailed, ReadyToPerform, PerformCompleted, Success};
    }

    static {
        FotaState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FotaState(String str, int r2, String str2) {
        this.key = str2;
    }

    public static EnumEntries<FotaState> getEntries() {
        return $ENTRIES;
    }

    public static FotaState valueOf(String str) {
        return (FotaState) Enum.valueOf(FotaState.class, str);
    }

    public static FotaState[] values() {
        return (FotaState[]) $VALUES.clone();
    }

    public final String getKey() {
        return this.key;
    }
}
