package com.animaconnected.secondo.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class RunOnUIThread {
    private static Handler sHandler;

    private static Handler getHandler() {
        Handler handler;
        synchronized (RunOnUIThread.class) {
            if (sHandler == null) {
                sHandler = new Handler(Looper.getMainLooper());
            }
            handler = sHandler;
        }
        return handler;
    }

    public static void post(Runnable runnable) {
        getHandler().post(runnable);
    }

    public static void postDelayed(Runnable runnable, long j) {
        getHandler().postDelayed(runnable, j);
    }
}
