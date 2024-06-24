package com.animaconnected.cloud.util;

import com.animaconnected.firebase.AnalyticsConstants;

/* loaded from: classes.dex */
public class CloudIfttt {

    /* loaded from: classes.dex */
    public enum ACTION_E {
        CREATE_CONNECTION_CODE,
        TRIGGER_PRESSED,
        STATUS,
        SETUP
    }

    /* loaded from: classes.dex */
    public enum TRIGGER_E {
        SINGLE,
        DOUBLE,
        TRIPLE
    }

    public static String action2String(ACTION_E r1) {
        if (r1 == ACTION_E.CREATE_CONNECTION_CODE) {
            return "createConnectionCode";
        }
        if (r1 == ACTION_E.TRIGGER_PRESSED) {
            return "triggerPressed";
        }
        if (r1 == ACTION_E.STATUS) {
            return AnalyticsConstants.KEY_STATUS;
        }
        if (r1 == ACTION_E.SETUP) {
            return "setup";
        }
        return "unknown";
    }

    public static String trigger2String(TRIGGER_E r1) {
        if (r1 == TRIGGER_E.SINGLE) {
            return "single";
        }
        if (r1 == TRIGGER_E.DOUBLE) {
            return AnalyticsConstants.KEY_DOUBLE;
        }
        if (r1 == TRIGGER_E.TRIPLE) {
            return "triple";
        }
        return "unknown";
    }
}
