package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceAlertConfig.kt */
/* loaded from: classes3.dex */
public final class DeviceAlertConfig {
    private static final int ALERT_BIT_ALARM = 1;
    private static final int ALERT_BIT_CALLS = 8;
    private static final int ALERT_BIT_DISCONNECT = 16;
    private static final int ALERT_BIT_STEPGOAL_REACHED = 4;
    private static final int ALERT_BIT_STILLNESS = 2;
    private static final int ALERT_TYPE_NONE = 0;
    public static final DeviceAlertConfig INSTANCE = new DeviceAlertConfig();
    private static final String KEY_ALERT_CONFIG_DIRTY = "alert-config-dirty";
    private static final String KEY_ALERT_TYPE_ALARM = "alert-type-alarm";
    private static final String KEY_ALERT_TYPE_CALLS = "alert-type-calls";
    private static final String KEY_ALERT_TYPE_DISCONNECT = "alert-type-disconnect";
    private static final String KEY_ALERT_TYPE_STEP_GOAL = "alert-type-step-goal";
    private static final String KEY_ALERT_TYPE_STILLNESS = "alert-type-stillness";
    private static final int NBR_OF_ALERT_CONFIGS = 6;

    private DeviceAlertConfig() {
    }

    private final void setAlertType(DeviceDataStorage deviceDataStorage, int r5, String str) {
        boolean z;
        if (1 <= r5 && r5 < 7) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            r5 = 0;
        }
        deviceDataStorage.put(str, r5, false);
        deviceDataStorage.put(KEY_ALERT_CONFIG_DIRTY, true, false);
    }

    public final int getBitmaskForAlertType(DeviceDataStorage storage, int r5, boolean z, boolean z2) {
        int r0;
        Intrinsics.checkNotNullParameter(storage, "storage");
        if (r5 == storage.getInt(KEY_ALERT_TYPE_ALARM, 0)) {
            r0 = 1;
        } else {
            r0 = 0;
        }
        if (r5 == storage.getInt(KEY_ALERT_TYPE_STEP_GOAL, 0)) {
            r0 |= 4;
        }
        if (r5 == storage.getInt(KEY_ALERT_TYPE_STILLNESS, 0)) {
            r0 |= 2;
        }
        if (z2 && r5 == storage.getInt(KEY_ALERT_TYPE_DISCONNECT, 0)) {
            r0 |= 16;
        }
        if (z && r5 == storage.getInt(KEY_ALERT_TYPE_CALLS, 0)) {
            return r0 | 8;
        }
        return r0;
    }

    public final boolean isAlarmSet(DeviceDataStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        if (storage.getInt(KEY_ALERT_TYPE_ALARM, 0) == 0) {
            return false;
        }
        return true;
    }

    public final boolean isAlertConfigDirty(DeviceDataStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage.getBoolean(KEY_ALERT_CONFIG_DIRTY, false);
    }

    public final void setAlertConfigNotDirty(DeviceDataStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        storage.put(KEY_ALERT_CONFIG_DIRTY, false, false);
    }

    public final boolean updateAlertTypes(DeviceDataStorage sharedPrefs, int r6, int r7, int r8, int r9, int r10, Function0<Unit> alarmIsUpdated) {
        boolean z;
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        Intrinsics.checkNotNullParameter(alarmIsUpdated, "alarmIsUpdated");
        if (sharedPrefs.getInt(KEY_ALERT_TYPE_ALARM, -1) != r6) {
            setAlertType(sharedPrefs, r6, KEY_ALERT_TYPE_ALARM);
            alarmIsUpdated.invoke();
            z = true;
        } else {
            z = false;
        }
        if (sharedPrefs.getInt(KEY_ALERT_TYPE_STILLNESS, -1) != r7) {
            setAlertType(sharedPrefs, r7, KEY_ALERT_TYPE_STILLNESS);
            z = true;
        }
        if (sharedPrefs.getInt(KEY_ALERT_TYPE_STEP_GOAL, -1) != r8) {
            setAlertType(sharedPrefs, r8, KEY_ALERT_TYPE_STEP_GOAL);
            z = true;
        }
        if (sharedPrefs.getInt(KEY_ALERT_TYPE_CALLS, -1) != r9) {
            setAlertType(sharedPrefs, r9, KEY_ALERT_TYPE_CALLS);
            z = true;
        }
        if (sharedPrefs.getInt(KEY_ALERT_TYPE_DISCONNECT, -1) != r10) {
            setAlertType(sharedPrefs, r10, KEY_ALERT_TYPE_DISCONNECT);
            return true;
        }
        return z;
    }
}
