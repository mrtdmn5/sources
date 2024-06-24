package com.animaconnected.dfu.dfu.utils;

import com.animaconnected.bluetooth.gatt.GattId;
import java.util.UUID;

/* loaded from: classes.dex */
public class DfuConstants {
    public static final int GATT_ERROR = 133;
    public static final byte ImageApplication = 4;
    public static final byte ImageBootloader = 2;
    public static final byte ImageSoftDevice = 1;
    public static final byte ImageSoftDeviceBootloader = 3;
    public static final byte OpActivateAndReset = 5;
    public static final byte OpInitParams = 2;
    public static final byte OpPacketNotifyReq = 8;
    public static final byte OpPacketResponse = 17;
    public static final byte OpRecvImage = 3;
    public static final byte OpReportRecvdSize = 7;
    public static final byte OpReset = 6;
    public static final byte OpResponse = 16;
    public static final byte OpStartDfu = 1;
    public static final byte OpValidate = 4;
    public static final byte RespCrcError = 5;
    public static final byte RespDataExceedsLimit = 4;
    public static final byte RespInvalidState = 2;
    public static final byte RespNotSupported = 3;
    public static final byte RespOperationFailed = 6;
    public static final byte RespSuccess = 1;
    public static final int UNKNOWN_DFU_15_ERROR = 520;
    public static final UUID SERVICE_UUID = GattId.Service.NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8;
    public static final UUID CONTROL_CHARA_UUID = UUID.fromString("00001531-1212-efde-1523-785feabcd123");
    public static final UUID DATA_CHARA_UUID = UUID.fromString("00001532-1212-efde-1523-785feabcd123");
}
