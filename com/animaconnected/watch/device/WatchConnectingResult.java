package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceConnectionListener.kt */
/* loaded from: classes3.dex */
public final class WatchConnectingResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WatchConnectingResult[] $VALUES;
    public static final WatchConnectingResult Success = new WatchConnectingResult("Success", 0);
    public static final WatchConnectingResult UpdateRequired = new WatchConnectingResult("UpdateRequired", 1);

    private static final /* synthetic */ WatchConnectingResult[] $values() {
        return new WatchConnectingResult[]{Success, UpdateRequired};
    }

    static {
        WatchConnectingResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WatchConnectingResult(String str, int r2) {
    }

    public static EnumEntries<WatchConnectingResult> getEntries() {
        return $ENTRIES;
    }

    public static WatchConnectingResult valueOf(String str) {
        return (WatchConnectingResult) Enum.valueOf(WatchConnectingResult.class, str);
    }

    public static WatchConnectingResult[] values() {
        return (WatchConnectingResult[]) $VALUES.clone();
    }
}
