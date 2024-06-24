package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
public enum Throwables {
    ;

    private static final int MAX_RETRY = 1000;

    public static Throwable getRootCause(Throwable th) {
        if (th == null) {
            return th;
        }
        int r0 = 0;
        Throwable th2 = th;
        while (r0 < MAX_RETRY) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            r0++;
            th2 = cause;
        }
        LogFactory.getLog((Class<?>) Throwables.class).debug("Possible circular reference detected on " + th.getClass() + ": [" + th + "]");
        return th;
    }
}
