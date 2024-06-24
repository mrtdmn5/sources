package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.KronabyApplication;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugStorage.kt */
/* loaded from: classes3.dex */
public final class DebugStorage {
    public static final int $stable = 0;
    private static final String CUSTOMER_SUPPORD_DEV = "customer-support-dev";
    private static final String ENABLE_SPEED_CALIBRATION = "enable-speed-calibration";
    private static final String FEATURE_READY_STUFF = "show-feature-ready-stuff";
    private static final String FORCE_MOCK_FITNESS_PROVIDER = "force-mock-fitness-provider";
    public static final DebugStorage INSTANCE = new DebugStorage();
    private static final String KTOR_HTTP_LOGGING = "ktor-http-logging";
    private static final String SHARED_PREFS_NAME = "debug_storage";
    private static final String SHOW_WORKOUT_SESSIONS = "show-workout-sessions";
    private static final String UPDATE_FOTA_FROM_CLOUD = "update-fota-from-cloud";

    private DebugStorage() {
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public static final boolean getShowWorkoutSessions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getSharedPreferences(context).getBoolean(SHOW_WORKOUT_SESSIONS, false);
    }

    public static final boolean getUpdateFotaFromCloud(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getSharedPreferences(context).getBoolean(UPDATE_FOTA_FROM_CLOUD, true);
    }

    public static final void setUpdateFotaFromCloud(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor edit = INSTANCE.getSharedPreferences(context).edit();
        edit.putBoolean(UPDATE_FOTA_FROM_CLOUD, z);
        edit.apply();
    }

    public final boolean getCustomerSupportDevEnvironment(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getBoolean(CUSTOMER_SUPPORD_DEV, false);
    }

    public final boolean getForceMockFitnessProvider() {
        return getSharedPreferences(KronabyApplication.Companion.getContext()).getBoolean(FORCE_MOCK_FITNESS_PROVIDER, false);
    }

    public final boolean getShowWipStuff() {
        return getSharedPreferences(KronabyApplication.Companion.getContext()).getBoolean(FEATURE_READY_STUFF, false);
    }

    public final boolean isKtorHttpLoggingEnabled() {
        return getSharedPreferences(KronabyApplication.Companion.getContext()).getBoolean(KTOR_HTTP_LOGGING, false);
    }

    public final boolean isSpeedCalibrationEnabled() {
        return getSharedPreferences(KronabyApplication.Companion.getContext()).getBoolean(ENABLE_SPEED_CALIBRATION, false);
    }

    public final void setCustomerSupportDevEnvironment(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putBoolean(CUSTOMER_SUPPORD_DEV, z);
        edit.apply();
    }

    public final void setForceMockFitnessProvider(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences(KronabyApplication.Companion.getContext()).edit();
        edit.putBoolean(FORCE_MOCK_FITNESS_PROVIDER, z);
        edit.apply();
    }

    public final void setKtorHttpLoggingEnabled(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences(KronabyApplication.Companion.getContext()).edit();
        edit.putBoolean(KTOR_HTTP_LOGGING, z);
        edit.apply();
    }

    public final void setShowWipStuff(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences(KronabyApplication.Companion.getContext()).edit();
        edit.putBoolean(FEATURE_READY_STUFF, z);
        edit.apply();
    }

    public final void setShowWorkoutSessions(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putBoolean(SHOW_WORKOUT_SESSIONS, z);
        edit.apply();
    }

    public final void setSpeedCalibrationEnabled(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences(KronabyApplication.Companion.getContext()).edit();
        edit.putBoolean(ENABLE_SPEED_CALIBRATION, z);
        edit.apply();
    }
}
