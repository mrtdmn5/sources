package com.animaconnected.secondo.behaviour.time;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public class TimeStorage {
    private static final String KEY_HOME_TIMEZONE_ENABLED = "homeTimezoneEnabled";
    private static final String TIME_STORAGE = "timeStorage";

    public static boolean getHomeTimezoneEnabled(Context context) {
        return getSharedPreferences(context).getBoolean(KEY_HOME_TIMEZONE_ENABLED, false);
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(TIME_STORAGE, 0);
    }

    public static void setHomeTimezoneEnabled(Context context, boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(context), KEY_HOME_TIMEZONE_ENABLED, z);
    }
}
