package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public final class Logging {
    public static void d(Object obj, String str, String str2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj));
        }
    }

    public static void e(String str, String str2, Exception exc) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            Log.e(tag, str2, exc);
        }
    }

    public static String getTag(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            String concat = "TRuntime.".concat(str);
            if (concat.length() > 23) {
                return concat.substring(0, 23);
            }
            return concat;
        }
        return "TRuntime.".concat(str);
    }
}
