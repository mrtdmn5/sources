package no.nordicsemi.android.error;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;

/* loaded from: classes4.dex */
public final class LegacyDfuError {
    public static String parse(int r2) {
        switch (r2) {
            case 258:
                return "INVALID STATE";
            case 259:
                return "NOT SUPPORTED";
            case 260:
                return "DATA SIZE EXCEEDS LIMIT";
            case 261:
                return "INVALID CRC ERROR";
            case 262:
                return "OPERATION FAILED";
            default:
                return ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("UNKNOWN (", r2, ")");
        }
    }
}
