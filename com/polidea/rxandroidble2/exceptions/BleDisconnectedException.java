package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.utils.GattStatusParser;

/* loaded from: classes3.dex */
public class BleDisconnectedException extends BleException {
    @Deprecated
    public BleDisconnectedException() {
        this("", -1);
    }

    public static String createMessage(int r3, String str) {
        String str2 = GattStatusParser.GATT_STATUS.get(Integer.valueOf(r3));
        if (str2 == null) {
            str2 = "UNKNOWN";
        }
        return "Disconnected from " + LoggerUtil.commonMacMessage(str) + " with status " + r3 + " (" + str2 + ")";
    }

    public BleDisconnectedException(String str, Throwable th) {
        super(createMessage(-1, str), th);
    }

    public BleDisconnectedException(String str, int r2) {
        super(createMessage(r2, str));
    }
}
