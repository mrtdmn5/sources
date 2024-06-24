package no.nordicsemi.android.error;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes4.dex */
public final class GattError {
    public static String parse(int r2) {
        if (r2 != 26) {
            if (r2 != 30) {
                if (r2 != 34) {
                    if (r2 != 42) {
                        if (r2 != 257) {
                            if (r2 != 58) {
                                if (r2 != 59) {
                                    switch (r2) {
                                        case 1:
                                            return "GATT INVALID HANDLE";
                                        case 2:
                                            return "GATT READ NOT PERMIT";
                                        case 3:
                                            return "GATT WRITE NOT PERMIT";
                                        case 4:
                                            return "GATT INVALID PDU";
                                        case 5:
                                            return "GATT INSUF AUTHENTICATION";
                                        case 6:
                                            return "GATT REQ NOT SUPPORTED";
                                        case 7:
                                            return "GATT INVALID OFFSET";
                                        case 8:
                                            return "GATT INSUF AUTHORIZATION";
                                        case 9:
                                            return "GATT PREPARE Q FULL";
                                        case 10:
                                            return "GATT NOT FOUND";
                                        case 11:
                                            return "GATT NOT LONG";
                                        case 12:
                                            return "GATT INSUF KEY SIZE";
                                        case 13:
                                            return "GATT INVALID ATTR LEN";
                                        case 14:
                                            return "GATT ERR UNLIKELY";
                                        case 15:
                                            return "GATT INSUF ENCRYPTION";
                                        case 16:
                                            return "GATT UNSUPPORT GRP TYPE";
                                        case 17:
                                            return "GATT INSUF RESOURCE";
                                        default:
                                            switch (r2) {
                                                case 128:
                                                    return "GATT NO RESOURCES";
                                                case R.styleable.AppTheme_statusTopStripeImportant /* 129 */:
                                                    return "GATT INTERNAL ERROR";
                                                case R.styleable.AppTheme_statusTopStripeSetup /* 130 */:
                                                    return "GATT WRONG STATE";
                                                case R.styleable.AppTheme_stepsHistoryBackgroundActivity /* 131 */:
                                                    return "GATT DB FULL";
                                                case R.styleable.AppTheme_stepsHistoryBackgroundDetail /* 132 */:
                                                    return "GATT BUSY";
                                                case 133:
                                                    return "GATT ERROR";
                                                case R.styleable.AppTheme_stepsHistoryBaseLineColorDetail /* 134 */:
                                                    return "GATT CMD STARTED";
                                                case R.styleable.AppTheme_stepsHistoryColumnColorActivity /* 135 */:
                                                    return "GATT ILLEGAL PARAMETER";
                                                case R.styleable.AppTheme_stepsHistoryColumnColorDetail /* 136 */:
                                                    return "GATT PENDING";
                                                case R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity /* 137 */:
                                                    return "GATT AUTH FAIL";
                                                case R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail /* 138 */:
                                                    return "GATT MORE";
                                                case R.styleable.AppTheme_stepsHistoryFontActivity /* 139 */:
                                                    return "GATT INVALID CFG";
                                                case R.styleable.AppTheme_stepsHistoryFontDetail /* 140 */:
                                                    return "GATT SERVICE STARTED";
                                                case R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity /* 141 */:
                                                    return "GATT ENCRYPTED NO MITM";
                                                case R.styleable.AppTheme_stepsHistoryGoalLegendColorDetail /* 142 */:
                                                    return "GATT NOT ENCRYPTED";
                                                case R.styleable.AppTheme_stepsHistoryGoalLineColorActivity /* 143 */:
                                                    return "GATT CONGESTED";
                                                default:
                                                    switch (r2) {
                                                        case 253:
                                                            return "GATT CCCD CFG ERROR";
                                                        case 254:
                                                            return "GATT PROCEDURE IN PROGRESS";
                                                        case 255:
                                                            return "GATT VALUE OUT OF RANGE";
                                                        default:
                                                            switch (r2) {
                                                                case 4096:
                                                                    return "DFU DEVICE DISCONNECTED";
                                                                case DfuBaseService.ERROR_FILE_NOT_FOUND /* 4097 */:
                                                                    return "DFU FILE NOT FOUND";
                                                                case DfuBaseService.ERROR_FILE_ERROR /* 4098 */:
                                                                    return "DFU FILE ERROR";
                                                                case DfuBaseService.ERROR_FILE_INVALID /* 4099 */:
                                                                    return "DFU NOT A VALID HEX FILE";
                                                                case DfuBaseService.ERROR_FILE_IO_EXCEPTION /* 4100 */:
                                                                    return "DFU IO EXCEPTION";
                                                                case DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED /* 4101 */:
                                                                    return "DFU SERVICE DISCOVERY NOT STARTED";
                                                                case DfuBaseService.ERROR_SERVICE_NOT_FOUND /* 4102 */:
                                                                    return "DFU CHARACTERISTICS NOT FOUND";
                                                                default:
                                                                    switch (r2) {
                                                                        case DfuBaseService.ERROR_INVALID_RESPONSE /* 4104 */:
                                                                            return "DFU INVALID RESPONSE";
                                                                        case DfuBaseService.ERROR_FILE_TYPE_UNSUPPORTED /* 4105 */:
                                                                            return "DFU FILE TYPE NOT SUPPORTED";
                                                                        case DfuBaseService.ERROR_BLUETOOTH_DISABLED /* 4106 */:
                                                                            return "BLUETOOTH ADAPTER DISABLED";
                                                                        case DfuBaseService.ERROR_INIT_PACKET_REQUIRED /* 4107 */:
                                                                        case DfuBaseService.ERROR_FILE_SIZE_INVALID /* 4108 */:
                                                                            return "DFU INIT PACKET REQUIRED";
                                                                        case DfuBaseService.ERROR_CRC_ERROR /* 4109 */:
                                                                            return "DFU CRC ERROR";
                                                                        case DfuBaseService.ERROR_DEVICE_NOT_BONDED /* 4110 */:
                                                                            return "DFU DEVICE NOT BONDED";
                                                                        default:
                                                                            return ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("UNKNOWN (", r2, ")");
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return "GATT UNACCEPT CONN INTERVAL";
                            }
                            return "GATT CONTROLLER BUSY";
                        }
                        return "TOO MANY OPEN CONNECTIONS";
                    }
                    return "HCI ERROR DIFF TRANSACTION COLLISION";
                }
                return "GATT CONN LMP TIMEOUT";
            }
            return "HCI ERROR INVALID LMP PARAM";
        }
        return "HCI ERROR UNSUPPORTED REMOTE FEATURE";
    }

    public static String parseConnectionError(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 != 8) {
                    if (r2 != 19) {
                        if (r2 != 22) {
                            if (r2 != 34) {
                                if (r2 != 62) {
                                    if (r2 != 133) {
                                        if (r2 != 256) {
                                            return ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("UNKNOWN (", r2, ")");
                                        }
                                        return "GATT CONN CANCEL ";
                                    }
                                    return "GATT ERROR";
                                }
                                return "GATT CONN FAIL ESTABLISH";
                            }
                            return "GATT CONN LMP TIMEOUT";
                        }
                        return "GATT CONN TERMINATE LOCAL HOST";
                    }
                    return "GATT CONN TERMINATE PEER USER";
                }
                return "GATT CONN TIMEOUT";
            }
            return "GATT CONN L2C FAILURE";
        }
        return "SUCCESS";
    }

    public static String parseDfuRemoteError(int r2) {
        int r0 = r2 & 3840;
        if (r0 != 256) {
            if (r0 != 512) {
                if (r0 != 1024) {
                    if (r0 != 2048) {
                        return ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("UNKNOWN (", r2, ")");
                    }
                    return SecureDfuError.parseButtonlessError(r2);
                }
                return SecureDfuError.parseExtendedError(r2);
            }
            return SecureDfuError.parse(r2);
        }
        return LegacyDfuError.parse(r2);
    }
}
