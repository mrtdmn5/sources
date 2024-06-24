package com.animaconnected.watch;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.firebase.config.AppFeatureGetMovingParams;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.device.WatchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: DeviceDataSync.kt */
/* loaded from: classes3.dex */
public final class DeviceDataSync {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_ALARMS_DIRTY = "alarms-dirty";
    private static final String KEY_ALL_DIRTY = "all-dirty";
    private static final String KEY_COMPLICATION_DIRTY = "complication-dirty";
    private static final String KEY_CROWN_BUTTON_COMPLICATION_DIRTY = "crown-button-complication-dirty";
    private static final String KEY_CROWN_DOUBLE_BUTTON_COMPLICATION_DIRTY = "crown-double-button-complication-dirty";
    private static final String KEY_DEFAULT_COMPLICATION_DIRTY = "default-complication-dirty";
    private static final String KEY_DEVICE_CONFIG_SETTINGS = "deviceConfig";
    private static final String KEY_DEVICE_DISCONNECT_LED = "deviceDisconnectLedAndVibrateEnable";
    private static final String KEY_LAST_SYNC = "last-sync-time";
    private static final String KEY_ONBOARDING_DIRTY = "onboarding-dirty";
    private static final String KEY_ONBOARDING_DONE = "onboarding";
    private static final String KEY_QUIET_HOURS_DIRTY = "quiet-hours-dirty";
    private static final String KEY_REMOTE_CONFIG_VERSION = "remoteConfigVersion";
    private static final String KEY_RESET_STEPS = "resetSteps";
    private static final String KEY_RESYNC_ALARMS_MIGRATION = "resync-alarms-migration";
    private static final String KEY_RSSI_NOTIFICATION = "rssiNotification";
    private static final String KEY_SLEEP_START_TIME_DIRTY = "sleep-start-time-dirty";
    private static final String KEY_STEPS_GOAL = "stepGoal";
    private static final String KEY_STEPS_GOAL_DIRTY = "stepsgoalactive-dirty";
    private static final String KEY_STILLNESS = "stillness";
    private static final String KEY_STILLNESS_ACTIVE = "stillnessActive";
    private static final String KEY_STILLNESS_DIRTY = "stillness-dirty";
    private static final String KEY_TIMEZONE = "timeZone";
    private static final String KEY_TIMEZONE_DIRTY = "timeZone-dirty";
    private static final String KEY_TRIGGERS_DIRTY = "triggers-dirty";
    private static final String KEY_USE_HID_FOR_MUSIC = "useHid";
    private static final String KEY_WROTE_ONBOARDING_DEVICE_SETTINGS = "wroteOnboardingDeviceSettings";
    private boolean alarmsDirty;
    private boolean allDirty;
    private boolean baseConfigDirty;
    private boolean complicationDirty;
    private boolean crownButtonComplicationDirty;
    private boolean crownDoubleButtonComplicationDirty;
    private boolean debugConfigDirty;
    private boolean defaultComplicationDirty;
    private boolean dirty;
    private boolean forceTimeWrite;
    private boolean isOnboardingDirty;
    private boolean isTriggersDirty;
    private boolean quietHoursDirty;
    private boolean remoteComplicationConfigDirty;
    private boolean remoteComplicationDirty;
    private long remoteConfigVersion;
    private boolean sleepStartTimeDirty;
    private boolean stepsGoalDirty;
    private boolean stillnessDirty;
    private final DeviceDataStorage storage;
    private boolean timezoneDirty;

    /* compiled from: DeviceDataSync.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceDataSync(DeviceDataStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.storage = storage;
        this.dirty = storage.getDirty();
        this.allDirty = DeviceDataStorage.getBoolean$default(storage, KEY_ALL_DIRTY, false, 2, null);
        this.complicationDirty = DeviceDataStorage.getBoolean$default(storage, KEY_COMPLICATION_DIRTY, false, 2, null);
        this.defaultComplicationDirty = DeviceDataStorage.getBoolean$default(storage, KEY_DEFAULT_COMPLICATION_DIRTY, false, 2, null);
        this.crownButtonComplicationDirty = DeviceDataStorage.getBoolean$default(storage, KEY_CROWN_BUTTON_COMPLICATION_DIRTY, false, 2, null);
        this.crownDoubleButtonComplicationDirty = DeviceDataStorage.getBoolean$default(storage, KEY_CROWN_DOUBLE_BUTTON_COMPLICATION_DIRTY, false, 2, null);
        this.timezoneDirty = DeviceDataStorage.getBoolean$default(storage, KEY_TIMEZONE_DIRTY, false, 2, null);
        this.remoteComplicationConfigDirty = true;
        this.alarmsDirty = DeviceDataStorage.getBoolean$default(storage, KEY_ALARMS_DIRTY, false, 2, null);
        this.quietHoursDirty = DeviceDataStorage.getBoolean$default(storage, KEY_QUIET_HOURS_DIRTY, false, 2, null);
        this.sleepStartTimeDirty = DeviceDataStorage.getBoolean$default(storage, KEY_SLEEP_START_TIME_DIRTY, false, 2, null);
        this.stillnessDirty = DeviceDataStorage.getBoolean$default(storage, KEY_STILLNESS_DIRTY, false, 2, null);
        this.stepsGoalDirty = DeviceDataStorage.getBoolean$default(storage, KEY_STEPS_GOAL_DIRTY, false, 2, null);
        this.isOnboardingDirty = DeviceDataStorage.getBoolean$default(storage, KEY_ONBOARDING_DIRTY, false, 2, null);
        this.forceTimeWrite = true;
        this.baseConfigDirty = true;
        this.debugConfigDirty = true;
        this.remoteConfigVersion = storage.getLong(KEY_REMOTE_CONFIG_VERSION, -1L);
        if (!storage.getBoolean(KEY_RESYNC_ALARMS_MIGRATION, false)) {
            setAlarmsDirty();
            DeviceDataStorage.put$default(storage, KEY_RESYNC_ALARMS_MIGRATION, true, false, 4, (Object) null);
        }
    }

    private final void onSyncSuccessful() {
        this.forceTimeWrite = false;
        this.storage.put(KEY_RESET_STEPS, false, false);
        this.storage.put(KEY_LAST_SYNC, DateTimeUtilsKt.currentTimeMillis(), false);
    }

    public final int[] getAlertConfigBitmasks(boolean z, boolean z2, boolean z3) {
        int r7;
        if (z3) {
            r7 = 6;
        } else {
            r7 = 3;
        }
        IntRange until = RangesKt___RangesKt.until(0, r7);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(DeviceAlertConfig.INSTANCE.getBitmaskForAlertType(this.storage, ((IntIterator) it).nextInt() + 1, z, z2)));
        }
        return CollectionsKt___CollectionsKt.toIntArray(arrayList);
    }

    public final Map<String, Integer> getDeviceConfigSettings() {
        Object obj;
        String string = this.storage.getString(KEY_DEVICE_CONFIG_SETTINGS);
        if (string != null) {
            try {
                Json.Default r1 = Json.Default;
                r1.getClass();
                obj = r1.decodeFromString(BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(StringSerializer.INSTANCE, IntSerializer.INSTANCE)), string);
            } catch (Exception unused) {
                obj = null;
            }
            return (Map) obj;
        }
        obj = null;
        return (Map) obj;
    }

    public final boolean getDeviceDisconnectLedAndVibrateEnable() {
        return this.storage.getBoolean(KEY_DEVICE_DISCONNECT_LED, false);
    }

    public final boolean getForceTimeWrite() {
        return this.forceTimeWrite;
    }

    public final long getLastSyncTime() {
        return this.storage.getLong(KEY_LAST_SYNC, -1L);
    }

    public final boolean getRssiNotification() {
        return this.storage.getBoolean(KEY_RSSI_NOTIFICATION, false);
    }

    public final int getStepGoal() {
        return this.storage.getInt(KEY_STEPS_GOAL, Constants.MAXIMUM_UPLOAD_PARTS);
    }

    public final boolean getStillnessActive() {
        return this.storage.getBoolean(KEY_STILLNESS_ACTIVE, false);
    }

    public final AppFeatureGetMovingParams getStillnessParameters() {
        Object obj;
        String string = this.storage.getString("stillness");
        if (string != null) {
            try {
                Json.Default r1 = Json.Default;
                r1.getClass();
                obj = r1.decodeFromString(BuiltinSerializersKt.getNullable(AppFeatureGetMovingParams.Companion.serializer()), string);
            } catch (Exception unused) {
                obj = null;
            }
            return (AppFeatureGetMovingParams) obj;
        }
        obj = null;
        return (AppFeatureGetMovingParams) obj;
    }

    public final DeviceDataStorage getStorage() {
        return this.storage;
    }

    public final String getTimeZoneId() {
        return this.storage.getString(KEY_TIMEZONE, WatchConstants.DEFAULT_SECONDTIMEZONE);
    }

    public final boolean getUseHidForMusic() {
        return this.storage.getBoolean(KEY_USE_HID_FOR_MUSIC, false);
    }

    public final boolean getWroteOnboardingDeviceSettings() {
        return this.storage.getBoolean(KEY_WROTE_ONBOARDING_DEVICE_SETTINGS, false);
    }

    public final boolean isAlarmSet() {
        return DeviceAlertConfig.INSTANCE.isAlarmSet(this.storage);
    }

    public final boolean isAlarmsDirty() {
        if (!this.alarmsDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isAlertConfigDirty() {
        if (!DeviceAlertConfig.INSTANCE.isAlertConfigDirty(this.storage) && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isBaseConfigDirty() {
        if (!this.baseConfigDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isComplicationDirty() {
        if (!this.complicationDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isCrownButtonComplicationDirty() {
        if (!this.crownButtonComplicationDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isCrownDoubleButtonComplicationDirty() {
        if (!this.crownDoubleButtonComplicationDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isDebugConfigDirty() {
        if (!this.debugConfigDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isDefaultComplicationDirty() {
        if (!this.defaultComplicationDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isDirty() {
        if (!this.dirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isOnboardingDirty() {
        return this.isOnboardingDirty;
    }

    public final boolean isOnboardingFinished() {
        return this.storage.getBoolean(KEY_ONBOARDING_DONE, false);
    }

    public final boolean isQuietHoursDirty() {
        if (!this.quietHoursDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isRemoteComplicationDataConfigDirty() {
        if (!this.remoteComplicationConfigDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isRemoteComplicationDirty() {
        if (!this.remoteComplicationDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isRemoteConfigDirty() {
        if (this.storage.getLong(KEY_REMOTE_CONFIG_VERSION, -1L) == this.remoteConfigVersion && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isSleepStartTimeDirty() {
        if (!this.sleepStartTimeDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isStillnessDirty() {
        if (!this.stillnessDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isTimeZoneDirty() {
        if (!this.timezoneDirty && !this.allDirty) {
            return false;
        }
        return true;
    }

    public final boolean isTriggersDirty() {
        return this.isTriggersDirty;
    }

    public final void setAlarmsDirty() {
        this.dirty = true;
        this.alarmsDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_ALARMS_DIRTY, true, false, 4, (Object) null);
    }

    public final void setAllDirty() {
        this.allDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_ALL_DIRTY, true, false, 4, (Object) null);
    }

    public final void setComplicationDirty() {
        this.dirty = true;
        this.complicationDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_COMPLICATION_DIRTY, true, false, 4, (Object) null);
    }

    public final void setCrownButtonComplicationDirty() {
        this.dirty = true;
        this.crownButtonComplicationDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_CROWN_BUTTON_COMPLICATION_DIRTY, true, false, 4, (Object) null);
    }

    public final void setCrownDoubleButtonComplicationDirty() {
        this.dirty = true;
        this.crownDoubleButtonComplicationDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_CROWN_DOUBLE_BUTTON_COMPLICATION_DIRTY, true, false, 4, (Object) null);
    }

    public final void setDefaultComplicationDirty() {
        this.dirty = true;
        this.defaultComplicationDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_DEFAULT_COMPLICATION_DIRTY, true, false, 4, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setDeviceConfigSettings(java.util.Map<java.lang.String, java.lang.Integer> r8) {
        /*
            r7 = this;
            com.animaconnected.watch.DeviceDataStorage r0 = r7.storage
            java.lang.String r1 = "deviceConfig"
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto Lb
            goto L1e
        Lb:
            kotlinx.serialization.json.Json$Default r1 = kotlinx.serialization.json.Json.Default     // Catch: java.lang.Exception -> L1e
            r1.getClass()     // Catch: java.lang.Exception -> L1e
            kotlinx.serialization.internal.LinkedHashMapSerializer r2 = new kotlinx.serialization.internal.LinkedHashMapSerializer     // Catch: java.lang.Exception -> L1e
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE     // Catch: java.lang.Exception -> L1e
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.INSTANCE     // Catch: java.lang.Exception -> L1e
            r2.<init>(r3, r4)     // Catch: java.lang.Exception -> L1e
            java.lang.Object r0 = r1.decodeFromString(r2, r0)     // Catch: java.lang.Exception -> L1e
            goto L1f
        L1e:
            r0 = 0
        L1f:
            java.util.Map r0 = (java.util.Map) r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r0 == 0) goto L28
            return
        L28:
            com.animaconnected.watch.DeviceDataStorage r1 = r7.storage
            java.lang.String r2 = "deviceConfig"
            kotlinx.serialization.json.Json$Default r0 = kotlinx.serialization.json.Json.Default     // Catch: java.lang.Exception -> L48
            r0.getClass()     // Catch: java.lang.Exception -> L48
            kotlinx.serialization.internal.LinkedHashMapSerializer r3 = new kotlinx.serialization.internal.LinkedHashMapSerializer     // Catch: java.lang.Exception -> L48
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE     // Catch: java.lang.Exception -> L48
            kotlinx.serialization.internal.IntSerializer r5 = kotlinx.serialization.internal.IntSerializer.INSTANCE     // Catch: java.lang.Exception -> L48
            r3.<init>(r4, r5)     // Catch: java.lang.Exception -> L48
            kotlinx.serialization.KSerializer r3 = kotlinx.serialization.builtins.BuiltinSerializersKt.getNullable(r3)     // Catch: java.lang.Exception -> L48
            java.lang.String r3 = r0.encodeToString(r3, r8)     // Catch: java.lang.Exception -> L48
            r4 = 0
            r5 = 4
            r6 = 0
            com.animaconnected.watch.DeviceDataStorage.put$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L48
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DeviceDataSync.setDeviceConfigSettings(java.util.Map):void");
    }

    public final void setDeviceDisconnectLedAndVibrateEnable(boolean z) {
        DeviceDataStorage.put$default(this.storage, KEY_DEVICE_DISCONNECT_LED, z, false, 4, (Object) null);
    }

    public final void setDirty() {
        this.storage.setDirty(true);
        this.dirty = true;
    }

    public final void setForceTimeWrite() {
        this.dirty = true;
        this.forceTimeWrite = true;
    }

    public final void setOnboardingFinished(boolean z) {
        this.dirty = true;
        this.isOnboardingDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_ONBOARDING_DIRTY, true, false, 4, (Object) null);
        DeviceDataStorage.put$default(this.storage, KEY_ONBOARDING_DONE, z, false, 4, (Object) null);
    }

    public final void setQuietHoursDirty() {
        this.dirty = true;
        this.quietHoursDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_QUIET_HOURS_DIRTY, true, false, 4, (Object) null);
    }

    public final void setRemoteComplicationDataConfigDirty() {
        this.remoteComplicationConfigDirty = true;
        setDirty();
    }

    public final void setRemoteComplicationDirty() {
        this.remoteComplicationDirty = true;
        setDirty();
    }

    public final void setRemoteConfigVersion(long j) {
        this.remoteConfigVersion = j;
        if (isRemoteConfigDirty()) {
            setDirty();
        }
    }

    public final void setRssiNotification(boolean z) {
        this.dirty = true;
        this.debugConfigDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_RSSI_NOTIFICATION, z, false, 4, (Object) null);
    }

    public final void setSleepStartTimeDirty() {
        this.dirty = true;
        this.sleepStartTimeDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_SLEEP_START_TIME_DIRTY, true, false, 4, (Object) null);
    }

    public final void setStepGoal(int r14) {
        this.dirty = true;
        this.stepsGoalDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_STEPS_GOAL_DIRTY, true, false, 4, (Object) null);
        DeviceDataStorage.put$default(this.storage, KEY_STEPS_GOAL, r14, false, 4, (Object) null);
    }

    public final void setStillnessActive(boolean z) {
        this.dirty = true;
        this.stillnessDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_STILLNESS_DIRTY, true, false, 4, (Object) null);
        DeviceDataStorage.put$default(this.storage, KEY_STILLNESS_ACTIVE, z, false, 4, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setStillnessParameters(com.animaconnected.firebase.config.AppFeatureGetMovingParams r8) {
        /*
            r7 = this;
            com.animaconnected.watch.DeviceDataStorage r0 = r7.storage
            java.lang.String r1 = "stillness"
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto Lb
            goto L1b
        Lb:
            kotlinx.serialization.json.Json$Default r1 = kotlinx.serialization.json.Json.Default     // Catch: java.lang.Exception -> L1b
            r1.getClass()     // Catch: java.lang.Exception -> L1b
            com.animaconnected.firebase.config.AppFeatureGetMovingParams$Companion r2 = com.animaconnected.firebase.config.AppFeatureGetMovingParams.Companion     // Catch: java.lang.Exception -> L1b
            kotlinx.serialization.KSerializer r2 = r2.serializer()     // Catch: java.lang.Exception -> L1b
            java.lang.Object r0 = r1.decodeFromString(r2, r0)     // Catch: java.lang.Exception -> L1b
            goto L1c
        L1b:
            r0 = 0
        L1c:
            com.animaconnected.firebase.config.AppFeatureGetMovingParams r0 = (com.animaconnected.firebase.config.AppFeatureGetMovingParams) r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r0 == 0) goto L25
            return
        L25:
            com.animaconnected.watch.DeviceDataStorage r1 = r7.storage
            java.lang.String r2 = "stillness"
            kotlinx.serialization.json.Json$Default r0 = kotlinx.serialization.json.Json.Default     // Catch: java.lang.Exception -> L44
            r0.getClass()     // Catch: java.lang.Exception -> L44
            com.animaconnected.firebase.config.AppFeatureGetMovingParams$Companion r3 = com.animaconnected.firebase.config.AppFeatureGetMovingParams.Companion     // Catch: java.lang.Exception -> L44
            kotlinx.serialization.KSerializer r3 = r3.serializer()     // Catch: java.lang.Exception -> L44
            kotlinx.serialization.KSerializer r3 = kotlinx.serialization.builtins.BuiltinSerializersKt.getNullable(r3)     // Catch: java.lang.Exception -> L44
            java.lang.String r3 = r0.encodeToString(r3, r8)     // Catch: java.lang.Exception -> L44
            r4 = 0
            r5 = 4
            r6 = 0
            com.animaconnected.watch.DeviceDataStorage.put$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L44
            r8 = 1
            goto L45
        L44:
            r8 = 0
        L45:
            r7.stillnessDirty = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DeviceDataSync.setStillnessParameters(com.animaconnected.firebase.config.AppFeatureGetMovingParams):void");
    }

    public final void setSyncDone() {
        if (!this.dirty) {
            this.complicationDirty = false;
            this.defaultComplicationDirty = false;
            this.crownButtonComplicationDirty = false;
            this.crownDoubleButtonComplicationDirty = false;
            this.timezoneDirty = false;
            this.isOnboardingDirty = false;
            this.stillnessDirty = false;
            this.stepsGoalDirty = false;
            this.alarmsDirty = false;
            this.quietHoursDirty = false;
            this.sleepStartTimeDirty = false;
            this.baseConfigDirty = false;
            this.debugConfigDirty = false;
            this.isTriggersDirty = false;
            this.allDirty = false;
            this.remoteComplicationDirty = false;
            this.remoteComplicationConfigDirty = false;
            DeviceAlertConfig.INSTANCE.setAlertConfigNotDirty(this.storage);
            DeviceDataStorage deviceDataStorage = this.storage;
            DeviceDataStorage.put$default(deviceDataStorage, KEY_ALL_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_ALARMS_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_QUIET_HOURS_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_SLEEP_START_TIME_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_COMPLICATION_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_DEFAULT_COMPLICATION_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_CROWN_BUTTON_COMPLICATION_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_CROWN_DOUBLE_BUTTON_COMPLICATION_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_TIMEZONE_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_ONBOARDING_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_STILLNESS_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_TRIGGERS_DIRTY, false, false, 4, (Object) null);
            DeviceDataStorage.put$default(deviceDataStorage, KEY_REMOTE_CONFIG_VERSION, this.remoteConfigVersion, false, 4, (Object) null);
            deviceDataStorage.setDirty(false);
            onSyncSuccessful();
        }
    }

    public final void setSyncPending() {
        this.dirty = false;
    }

    public final void setTimeZoneId(String timeZoneId) {
        Intrinsics.checkNotNullParameter(timeZoneId, "timeZoneId");
        this.dirty = true;
        this.timezoneDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_TIMEZONE_DIRTY, true, false, 4, (Object) null);
        DeviceDataStorage.put$default(this.storage, KEY_TIMEZONE, timeZoneId, false, 4, (Object) null);
    }

    public final void setTriggersDirty$watch_release() {
        this.dirty = true;
        this.isTriggersDirty = true;
        DeviceDataStorage.put$default(this.storage, KEY_TRIGGERS_DIRTY, true, false, 4, (Object) null);
    }

    public final void setUseHidForMusic(boolean z) {
        if (getUseHidForMusic() != z) {
            setTriggersDirty$watch_release();
            DeviceDataStorage.put$default(this.storage, KEY_USE_HID_FOR_MUSIC, z, false, 4, (Object) null);
        }
    }

    public final void setWroteOnboardingDeviceSettings(boolean z) {
        this.storage.put(KEY_WROTE_ONBOARDING_DEVICE_SETTINGS, z, false);
    }

    public final boolean updateAlertTypes(int r9, int r10, int r11, int r12, int r13) {
        boolean updateAlertTypes = DeviceAlertConfig.INSTANCE.updateAlertTypes(this.storage, r9, r10, r11, r12, r13, new Function0<Unit>() { // from class: com.animaconnected.watch.DeviceDataSync$updateAlertTypes$didUpdate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DeviceDataSync.this.setAlarmsDirty();
            }
        });
        if (updateAlertTypes) {
            setDirty();
        }
        return updateAlertTypes;
    }

    public static /* synthetic */ void getStepGoal$annotations() {
    }
}
