package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchIO.kt */
/* loaded from: classes3.dex */
public final class CallState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CallState[] $VALUES;
    private final int value;
    public static final CallState Idle = new CallState("Idle", 0, 0);
    public static final CallState Ringing = new CallState("Ringing", 1, 1);
    public static final CallState OffHook = new CallState("OffHook", 2, 2);

    private static final /* synthetic */ CallState[] $values() {
        return new CallState[]{Idle, Ringing, OffHook};
    }

    static {
        CallState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private CallState(String str, int r2, int r3) {
        this.value = r3;
    }

    public static EnumEntries<CallState> getEntries() {
        return $ENTRIES;
    }

    public static CallState valueOf(String str) {
        return (CallState) Enum.valueOf(CallState.class, str);
    }

    public static CallState[] values() {
        return (CallState[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
