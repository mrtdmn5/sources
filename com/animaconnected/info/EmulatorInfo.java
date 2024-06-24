package com.animaconnected.info;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Devices.kt */
/* loaded from: classes.dex */
public final class EmulatorInfo {
    public static final Companion Companion = new Companion(null);
    private static final EmulatorInfo EmulatorBt001Info = new EmulatorInfo("1750DD292B", "A1000-2606", "EMULATOR-E2:3F:F4:DD:29:2C", DeviceType.BT001, null, null, null, "3gAZA8MAwxnDBsMIwxvDFMMXwwTDCcMKwwvDEsMOww/DE8MYwxrDIcMVkpSSeMy0BQCSAQGUkcy0CgORAQIDBcMHwxbDGMM", 112, null);
    private static final EmulatorInfo EmulatorPascalInfo = new EmulatorInfo("1750DD292D", "A1007-8585", "EMULATOR-E2:AA:F4:DD:29:3C", DeviceType.PASCAL, null, null, null, null, 240, null);
    private final String address;
    private final String capsString;
    private final String coreUnit;
    private final DeviceType deviceType;
    private final String firmwareRevision;
    private final String hardwareRevision;
    private final String manufacturerName;
    private final String serialnumber;
    private final String sku;

    /* compiled from: Devices.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* compiled from: Devices.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[DeviceType.values().length];
                try {
                    r0[DeviceType.BT001.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[DeviceType.PASCAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[DeviceType.PASCAL_FULL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r0[DeviceType.BT002.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    r0[DeviceType.BT003.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    r0[DeviceType.FKS933.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    r0[DeviceType.FKS927.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EmulatorInfo getForType(DeviceType deviceType) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            switch (WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()]) {
                case 1:
                    return EmulatorInfo.EmulatorBt001Info;
                case 2:
                case 3:
                    return EmulatorInfo.EmulatorPascalInfo;
                case 4:
                case 5:
                case 6:
                case 7:
                    throw new NotImplementedError();
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        private Companion() {
        }
    }

    public EmulatorInfo(String serialnumber, String coreUnit, String address, DeviceType deviceType, String firmwareRevision, String hardwareRevision, String manufacturerName, String str) {
        Intrinsics.checkNotNullParameter(serialnumber, "serialnumber");
        Intrinsics.checkNotNullParameter(coreUnit, "coreUnit");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(firmwareRevision, "firmwareRevision");
        Intrinsics.checkNotNullParameter(hardwareRevision, "hardwareRevision");
        Intrinsics.checkNotNullParameter(manufacturerName, "manufacturerName");
        this.serialnumber = serialnumber;
        this.coreUnit = coreUnit;
        this.address = address;
        this.deviceType = deviceType;
        this.firmwareRevision = firmwareRevision;
        this.hardwareRevision = hardwareRevision;
        this.manufacturerName = manufacturerName;
        this.capsString = str;
        this.sku = coreUnit;
    }

    public static /* synthetic */ EmulatorInfo copy$default(EmulatorInfo emulatorInfo, String str, String str2, String str3, DeviceType deviceType, String str4, String str5, String str6, String str7, int r18, Object obj) {
        String str8;
        String str9;
        String str10;
        DeviceType deviceType2;
        String str11;
        String str12;
        String str13;
        String str14;
        if ((r18 & 1) != 0) {
            str8 = emulatorInfo.serialnumber;
        } else {
            str8 = str;
        }
        if ((r18 & 2) != 0) {
            str9 = emulatorInfo.coreUnit;
        } else {
            str9 = str2;
        }
        if ((r18 & 4) != 0) {
            str10 = emulatorInfo.address;
        } else {
            str10 = str3;
        }
        if ((r18 & 8) != 0) {
            deviceType2 = emulatorInfo.deviceType;
        } else {
            deviceType2 = deviceType;
        }
        if ((r18 & 16) != 0) {
            str11 = emulatorInfo.firmwareRevision;
        } else {
            str11 = str4;
        }
        if ((r18 & 32) != 0) {
            str12 = emulatorInfo.hardwareRevision;
        } else {
            str12 = str5;
        }
        if ((r18 & 64) != 0) {
            str13 = emulatorInfo.manufacturerName;
        } else {
            str13 = str6;
        }
        if ((r18 & 128) != 0) {
            str14 = emulatorInfo.capsString;
        } else {
            str14 = str7;
        }
        return emulatorInfo.copy(str8, str9, str10, deviceType2, str11, str12, str13, str14);
    }

    public final String component1() {
        return this.serialnumber;
    }

    public final String component2() {
        return this.coreUnit;
    }

    public final String component3() {
        return this.address;
    }

    public final DeviceType component4() {
        return this.deviceType;
    }

    public final String component5() {
        return this.firmwareRevision;
    }

    public final String component6() {
        return this.hardwareRevision;
    }

    public final String component7() {
        return this.manufacturerName;
    }

    public final String component8() {
        return this.capsString;
    }

    public final EmulatorInfo copy(String serialnumber, String coreUnit, String address, DeviceType deviceType, String firmwareRevision, String hardwareRevision, String manufacturerName, String str) {
        Intrinsics.checkNotNullParameter(serialnumber, "serialnumber");
        Intrinsics.checkNotNullParameter(coreUnit, "coreUnit");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(firmwareRevision, "firmwareRevision");
        Intrinsics.checkNotNullParameter(hardwareRevision, "hardwareRevision");
        Intrinsics.checkNotNullParameter(manufacturerName, "manufacturerName");
        return new EmulatorInfo(serialnumber, coreUnit, address, deviceType, firmwareRevision, hardwareRevision, manufacturerName, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmulatorInfo)) {
            return false;
        }
        EmulatorInfo emulatorInfo = (EmulatorInfo) obj;
        if (Intrinsics.areEqual(this.serialnumber, emulatorInfo.serialnumber) && Intrinsics.areEqual(this.coreUnit, emulatorInfo.coreUnit) && Intrinsics.areEqual(this.address, emulatorInfo.address) && this.deviceType == emulatorInfo.deviceType && Intrinsics.areEqual(this.firmwareRevision, emulatorInfo.firmwareRevision) && Intrinsics.areEqual(this.hardwareRevision, emulatorInfo.hardwareRevision) && Intrinsics.areEqual(this.manufacturerName, emulatorInfo.manufacturerName) && Intrinsics.areEqual(this.capsString, emulatorInfo.capsString)) {
            return true;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCapsString() {
        return this.capsString;
    }

    public final String getCoreUnit() {
        return this.coreUnit;
    }

    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final String getFirmwareRevision() {
        return this.firmwareRevision;
    }

    public final String getHardwareRevision() {
        return this.hardwareRevision;
    }

    public final String getManufacturerName() {
        return this.manufacturerName;
    }

    public final String getSerialnumber() {
        return this.serialnumber;
    }

    public final String getSku() {
        return this.sku;
    }

    public int hashCode() {
        int hashCode;
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.manufacturerName, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.hardwareRevision, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.firmwareRevision, (this.deviceType.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.address, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.coreUnit, this.serialnumber.hashCode() * 31, 31), 31)) * 31, 31), 31), 31);
        String str = this.capsString;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return m + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EmulatorInfo(serialnumber=");
        sb.append(this.serialnumber);
        sb.append(", coreUnit=");
        sb.append(this.coreUnit);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", deviceType=");
        sb.append(this.deviceType);
        sb.append(", firmwareRevision=");
        sb.append(this.firmwareRevision);
        sb.append(", hardwareRevision=");
        sb.append(this.hardwareRevision);
        sb.append(", manufacturerName=");
        sb.append(this.manufacturerName);
        sb.append(", capsString=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.capsString, ')');
    }

    public /* synthetic */ EmulatorInfo(String str, String str2, String str3, DeviceType deviceType, String str4, String str5, String str6, String str7, int r20, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, deviceType, (r20 & 16) != 0 ? "2022.5.17-dev" : str4, (r20 & 32) != 0 ? "A1000-2950.A_00" : str5, (r20 & 64) != 0 ? "Anima Emulator" : str6, (r20 & 128) != 0 ? null : str7);
    }
}
