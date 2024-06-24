package com.animaconnected.secondo.utils;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes3.dex */
public final class DebugLogUtils {
    private DebugLogUtils() {
    }

    public static String intentToString(Intent intent) {
        StringBuilder sb = new StringBuilder(intent.toString());
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.getSize(null);
            sb.append(" extras: ");
            sb.append(extras);
        }
        return sb.toString();
    }
}
