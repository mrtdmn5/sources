package com.animaconnected.cloud.util;

import com.animaconnected.cloud.util.CloudStatusResponse;

/* loaded from: classes.dex */
public class CloudStatus {
    public static CloudStatusResponse.STATUS_E String2Status(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -2093369835:
                if (str.equals("UNSUPPORTED")) {
                    c = 0;
                    break;
                }
                break;
            case -2056551545:
                if (str.equals("LATEST")) {
                    c = 1;
                    break;
                }
                break;
            case -1987808683:
                if (str.equals("UPDATE_REQUIRED")) {
                    c = 2;
                    break;
                }
                break;
            case 68834:
                if (str.equals("EOL")) {
                    c = 3;
                    break;
                }
                break;
            case 1370954419:
                if (str.equals("UPDATE_AVAILABLE")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return CloudStatusResponse.STATUS_E.UNSUPPORTED;
            case 1:
                return CloudStatusResponse.STATUS_E.LATEST;
            case 2:
                return CloudStatusResponse.STATUS_E.UPDATE_REQUIRED;
            case 3:
                return CloudStatusResponse.STATUS_E.EOL;
            case 4:
                return CloudStatusResponse.STATUS_E.UPDATE_AVAILABLE;
            default:
                return CloudStatusResponse.STATUS_E.UNKNOWN;
        }
    }
}
