package com.animaconnected.secondo.screens.minionboarding;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public class MiniOnboardingStorage {
    private static final String MINI_ONBOARDING_STORAGE = "miniOnboardingStorage";

    public static boolean getConfigured(Context context, String str) {
        return getSharedPreferences(context).getBoolean(str, false);
    }

    public static boolean getOnboardingDone(Context context, String str) {
        return getSharedPreferences(context).getBoolean(str, false);
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(MINI_ONBOARDING_STORAGE, 0);
    }

    public static void setConfigured(Context context, boolean z, String str) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(context), str, z);
    }

    public static void setOnboardingDone(Context context, boolean z, String str) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(context), str, z);
    }
}
