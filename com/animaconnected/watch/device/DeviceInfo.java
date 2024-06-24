package com.animaconnected.watch.device;

import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class DeviceInfo {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceInfo[] $VALUES;
    private final String key;
    public static final DeviceInfo Address = new DeviceInfo("Address", 0, WatchSettingsFragment.addressBundleKey);
    public static final DeviceInfo ModelNumber = new DeviceInfo("ModelNumber", 1, AnalyticsConstants.KEY_MODELNUMBER);
    public static final DeviceInfo SerialNumber = new DeviceInfo("SerialNumber", 2, AnalyticsConstants.KEY_SERIALNUMBER);
    public static final DeviceInfo ManufacturerName = new DeviceInfo("ManufacturerName", 3, AnalyticsConstants.KEY_MANUFACTURERNAME);
    public static final DeviceInfo HardwareRevision = new DeviceInfo("HardwareRevision", 4, AnalyticsConstants.KEY_HARDWAREREVISION);
    public static final DeviceInfo FirmwareRevision = new DeviceInfo("FirmwareRevision", 5, AnalyticsConstants.KEY_FIRMWAREREVISION);

    private static final /* synthetic */ DeviceInfo[] $values() {
        return new DeviceInfo[]{Address, ModelNumber, SerialNumber, ManufacturerName, HardwareRevision, FirmwareRevision};
    }

    static {
        DeviceInfo[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DeviceInfo(String str, int r2, String str2) {
        this.key = str2;
    }

    public static EnumEntries<DeviceInfo> getEntries() {
        return $ENTRIES;
    }

    public static DeviceInfo valueOf(String str) {
        return (DeviceInfo) Enum.valueOf(DeviceInfo.class, str);
    }

    public static DeviceInfo[] values() {
        return (DeviceInfo[]) $VALUES.clone();
    }

    public final String getKey() {
        return this.key;
    }
}
