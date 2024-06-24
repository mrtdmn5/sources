package com.animaconnected.dfu.dfu.utils;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DfuUtilities {
    public static int percentageIndex;
    public static DfuDebugListener sDebugListener;
    public static final List<String> sLogs = new ArrayList();
    public static Long timestamp;

    /* loaded from: classes.dex */
    public interface DfuDebugListener {
        void onChange();
    }

    public static int crc16(byte[] bArr) {
        int r2 = 65535;
        for (byte b : bArr) {
            int r22 = (((r2 << 8) | (r2 >>> 8)) & 65535) ^ (b & 255);
            int r23 = r22 ^ ((r22 & 255) >> 4);
            int r24 = r23 ^ ((r23 << 12) & 65535);
            r2 = r24 ^ (((r24 & 255) << 5) & 65535);
        }
        return r2 & 65535;
    }

    public static void log(String str, String str2) {
        Log.d(str, str2);
        float currentTimeMillis = ((float) (System.currentTimeMillis() - timestamp.longValue())) / 1000.0f;
        sLogs.add("[" + currentTimeMillis + "] " + str + ":\n" + str2);
        DfuDebugListener dfuDebugListener = sDebugListener;
        if (dfuDebugListener != null) {
            dfuDebugListener.onChange();
        }
    }

    public static void resetLog() {
        sLogs.clear();
        timestamp = Long.valueOf(System.currentTimeMillis());
    }

    public static void setPercentage(int r3) {
        List<String> list = sLogs;
        int size = list.size() - 1;
        percentageIndex = size;
        list.set(size, r3 + "%");
        DfuDebugListener dfuDebugListener = sDebugListener;
        if (dfuDebugListener != null) {
            dfuDebugListener.onChange();
        }
    }
}
