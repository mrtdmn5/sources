package com.animaconnected.dfu.fota.utils;

import com.animaconnected.bluetooth.gatt.GattId;
import java.util.UUID;

/* loaded from: classes.dex */
public class FotaConstants {
    public static final byte PAGE_COMPLETED = 1;
    public static final byte PAGE_IN_PROGRESS = 2;
    public static final byte PAGE_NOT_STARTED = 0;
    public static final byte RESPONSE_BANK_BUSY = 7;
    public static final byte RESPONSE_BATTERY_TOO_LOW = 8;
    public static final byte RESPONSE_FLASH_ERROR = 5;
    public static final byte RESPONSE_HASH_MISMATCH = 4;
    public static final byte RESPONSE_INVAL_ARG = 1;
    public static final byte RESPONSE_INVAL_STATE = 2;
    public static final byte RESPONSE_OK = 0;
    public static final byte RESPONSE_SIZE_MISMATCH = 3;
    public static final byte RESPONSE_TEMP_OUT_OF_RANGE = 9;
    public static final int STATE_ERASING_INFO = 5;
    public static final int STATE_ERASING_PAGE = 3;
    public static final int STATE_INITED = 1;
    public static final int STATE_PREINIT = 0;
    public static final int STATE_RECEIVING_DATA = 2;
    public static final int STATE_RESTARTING = 7;
    public static final int STATE_WRITING_INFO = 6;
    public static final int STATE_WRITING_PAGE = 4;
    public static final int TYPE_FOTA_INIT = 2;
    public static final int TYPE_FOTA_STATUS = 1;
    public static final int TYPE_PAGE_DATA = 4;
    public static final int TYPE_PAGE_END = 5;
    public static final int TYPE_PAGE_START = 3;
    public static final int TYPE_PERFORM_FOTA = 6;
    public static final int TYPE_RESPONSE = 170;
    public static final int TYPE_VERIFY_FOTA = 7;
    public static final UUID FOTA_SERVICE = GattId.Service.FOTA;
    public static final UUID FOTA_TX_CHARACTERISTIC = UUID.fromString("6e400002-b5a3-f393-e043-565341544f46");
    public static final UUID FOTA_RX_CHARACTERISTIC = UUID.fromString("6e400003-b5a3-f393-e043-565341544f46");

    public static String getResponseAsName(byte b) {
        switch (b) {
            case 0:
                return "RESPONSE_OK";
            case 1:
                return "RESPONSE_INVAL_ARG";
            case 2:
                return "RESPONSE_INVAL_STATE";
            case 3:
                return "RESPONSE_SIZE_MISMATCH";
            case 4:
                return "RESPONSE_HASH_MISMATCH";
            case 5:
                return "RESPONSE_FLASH_ERROR";
            case 6:
            default:
                return "UNDEFINED";
            case 7:
                return "RESPONSE_BANK_BUSY";
            case 8:
                return "RESPONSE_BATTERY_TOO_LOW";
            case 9:
                return "RESPONSE_TEMP_OUT_OF_RANGE";
        }
    }

    public static String getStateAsName(int r0) {
        switch (r0) {
            case 0:
                return "STATE_PREINIT";
            case 1:
                return "STATE_INITED";
            case 2:
                return "STATE_RECEIVING_DATA";
            case 3:
                return "STATE_ERASING_PAGE";
            case 4:
                return "STATE_WRITING_PAGE";
            case 5:
                return "STATE_ERASING_INFO";
            case 6:
                return "STATE_WRITING_INFO";
            case 7:
                return "STATE_RESTARTING";
            default:
                return "UNDEFINED";
        }
    }

    public static String getTypeAsName(int r1) {
        if (r1 != 170) {
            switch (r1) {
                case 1:
                    return "TYPE_FOTA_STATUS";
                case 2:
                    return "TYPE_FOTA_INIT";
                case 3:
                    return "TYPE_PAGE_START";
                case 4:
                    return "TYPE_PAGE_DATA";
                case 5:
                    return "TYPE_PAGE_END";
                case 6:
                    return "TYPE_PERFORM_FOTA";
                case 7:
                    return "TYPE_VERIFY_FOTA";
                default:
                    return "UNDEFINED";
            }
        }
        return "TYPE_RESPONSE";
    }
}
