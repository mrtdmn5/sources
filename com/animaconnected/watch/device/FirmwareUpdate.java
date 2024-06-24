package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FirmwareUpdate.kt */
/* loaded from: classes3.dex */
public final class FirmwareUpdate {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FirmwareUpdate[] $VALUES;
    private final String appStatusUpdateType;
    public static final FirmwareUpdate NONE = new FirmwareUpdate("NONE", 0, "none");
    public static final FirmwareUpdate DFU = new FirmwareUpdate("DFU", 1, DfuBaseService.NOTIFICATION_CHANNEL_DFU);
    public static final FirmwareUpdate DFU15 = new FirmwareUpdate("DFU15", 2, DfuBaseService.NOTIFICATION_CHANNEL_DFU);
    public static final FirmwareUpdate FOTA = new FirmwareUpdate("FOTA", 3, "fota");

    private static final /* synthetic */ FirmwareUpdate[] $values() {
        return new FirmwareUpdate[]{NONE, DFU, DFU15, FOTA};
    }

    static {
        FirmwareUpdate[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FirmwareUpdate(String str, int r2, String str2) {
        this.appStatusUpdateType = str2;
    }

    public static EnumEntries<FirmwareUpdate> getEntries() {
        return $ENTRIES;
    }

    public static FirmwareUpdate valueOf(String str) {
        return (FirmwareUpdate) Enum.valueOf(FirmwareUpdate.class, str);
    }

    public static FirmwareUpdate[] values() {
        return (FirmwareUpdate[]) $VALUES.clone();
    }

    public final String getAppStatusUpdateType() {
        return this.appStatusUpdateType;
    }

    public final boolean isDfu() {
        if (this != DFU && this != DFU15) {
            return false;
        }
        return true;
    }
}
