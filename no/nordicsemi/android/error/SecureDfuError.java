package no.nordicsemi.android.error;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.google.android.gms.measurement.internal.zzab;

/* loaded from: classes4.dex */
public final class SecureDfuError {
    public static zzab zza;

    public static String parse(int r2) {
        switch (r2) {
            case 514:
                return "OP CODE NOT SUPPORTED";
            case 515:
                return "INVALID PARAM";
            case 516:
                return "INSUFFICIENT RESOURCES";
            case 517:
                return "INVALID OBJECT";
            case 518:
            case 521:
            default:
                return ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("UNKNOWN (", r2, ")");
            case 519:
                return "UNSUPPORTED TYPE";
            case DfuConstants.UNKNOWN_DFU_15_ERROR /* 520 */:
                return "OPERATION NOT PERMITTED";
            case 522:
                return "OPERATION FAILED";
            case 523:
                return "EXTENDED ERROR";
        }
    }

    public static String parseButtonlessError(int r2) {
        if (r2 != 2050) {
            if (r2 != 2052) {
                return ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("UNKNOWN (", r2, ")");
            }
            return "OPERATION FAILED";
        }
        return "OP CODE NOT SUPPORTED";
    }

    public static String parseExtendedError(int r0) {
        switch (r0) {
            case 1026:
                return "Wrong command format";
            case 1027:
                return "Unknown command";
            case 1028:
                return "Init command invalid";
            case 1029:
                return "FW version failure";
            case 1030:
                return "HW version failure";
            case 1031:
                return "SD version failure";
            case 1032:
                return "Signature mismatch";
            case 1033:
                return "Wrong hash type";
            case 1034:
                return "Hash failed";
            case 1035:
                return "Wrong signature type";
            case 1036:
                return "Verification failed";
            case 1037:
                return "Insufficient space";
            default:
                return "Reserved for future use";
        }
    }
}
