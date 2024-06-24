package com.polidea.rxandroidble2.exceptions;

import java.util.Date;

/* loaded from: classes3.dex */
public class BleScanException extends BleException {
    public final int reason;

    public BleScanException(int r2) {
        super(createMessage(r2, null));
        this.reason = r2;
    }

    public static String createMessage(int r2, Date date) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (r2 != 2147483646) {
            switch (r2) {
                case 0:
                    str = "Bluetooth cannot start";
                    break;
                case 1:
                    str = "Bluetooth disabled";
                    break;
                case 2:
                    str = "Bluetooth not available";
                    break;
                case 3:
                    str = "Location Permission missing";
                    break;
                case 4:
                    str = "Location Services disabled";
                    break;
                case 5:
                    str = "Scan failed because it has already started";
                    break;
                case 6:
                    str = "Scan failed because application registration failed";
                    break;
                case 7:
                    str = "Scan failed because of an internal error";
                    break;
                case 8:
                    str = "Scan failed because feature unsupported";
                    break;
                case 9:
                    str = "Scan failed because out of hardware resources";
                    break;
                default:
                    str = "Unknown error";
                    break;
            }
        } else {
            str = "Undocumented scan throttle";
        }
        sb.append(str);
        sb.append(" (code ");
        sb.append(r2);
        sb.append(")");
        if (date == null) {
            str2 = "";
        } else {
            str2 = ", suggested retry date is " + date;
        }
        sb.append(str2);
        return sb.toString();
    }

    public BleScanException(Date date) {
        super(createMessage(2147483646, date));
        this.reason = 2147483646;
    }

    public BleScanException(int r2, Throwable th) {
        super(createMessage(r2, null), th);
        this.reason = r2;
    }
}
