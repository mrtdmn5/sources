package com.animaconnected.watch;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.info.DeviceType;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.FitnessDataKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.storage.WatchDb;
import com.animaconnected.watch.storage.models.DBWatch;
import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: StorageToDbMigration.kt */
/* loaded from: classes3.dex */
public final class StorageToDbMigration implements CoroutineScope {
    private static final String BEHAVIOUR_SETTINGS_PREFIX = "settings";
    private static final String BEHAVIOUR_TYPE_PREFIX = "type_v2";
    private static final String DEVICE_ADDRESS = "device-address";
    private static final String DEVICE_TYPE_ADVERTISED_NUMBER = "device-itemid";
    private static final String MIGRATED_FLAG = "migrated";
    private static final String SHARED_PREFS_NAME = "watch_store";
    private static final String SHARED_PREFS_NAME_DEVICE_DATA = "deviceDataStorage";
    private static final String STEPS_GOAL = "stepGoal";
    private static final String STRONGER_VIBRATION = "strongVibration";
    public static final StorageToDbMigration INSTANCE = new StorageToDbMigration();
    private static final CompletableJob job = SupervisorKt.SupervisorJob$default();
    public static final int $stable = 8;

    private StorageToDbMigration() {
    }

    private final void migrateLostWatch(Context context, WatchDb watchDb) {
        String str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("initialLostwatchStorage", 0);
        if (sharedPreferences.getBoolean(MIGRATED_FLAG, false)) {
            return;
        }
        DBWatch currentWatch = watchDb.getCurrentWatch();
        if (currentWatch != null) {
            str = currentWatch.getDevice_address();
        } else {
            str = null;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("lostWatch_" + str, 0);
        Intrinsics.checkNotNull(sharedPreferences2);
        StorageToDbMigrationKt.copyTo(sharedPreferences, sharedPreferences2);
        sharedPreferences.edit().putBoolean(MIGRATED_FLAG, true).apply();
        LogKt.debug$default((Object) this, "Lost watch migrated!", (String) null, (Throwable) null, false, 14, (Object) null);
    }

    private final void migrateStepsGoal(Context context, WatchDb watchDb, FitnessProvider fitnessProvider) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME_DEVICE_DATA, 0);
        if (sharedPreferences.contains(STEPS_GOAL)) {
            BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new StorageToDbMigration$migrateStepsGoal$1(fitnessProvider, migrateStepsGoal$pickNewValue(fitnessProvider, sharedPreferences, watchDb), null));
            sharedPreferences.edit().remove(STEPS_GOAL).apply();
            LogKt.debug$default((Object) this, "Steps goal migrated!", (String) null, (Throwable) null, false, 14, (Object) null);
        }
    }

    private static final int migrateStepsGoal$pickNewValue(FitnessProvider fitnessProvider, SharedPreferences sharedPreferences, WatchDb watchDb) {
        Object next;
        boolean z;
        DeviceType fromAdvertisedNumberOrNull;
        int steps = fitnessProvider.getGoalOnce(DateTimeUtilsKt.currentTimeMillis()).getSteps();
        int r9 = sharedPreferences.getInt(STEPS_GOAL, Constants.MAXIMUM_UPLOAD_PARTS);
        if (steps == r9) {
            return steps;
        }
        Iterator<T> it = watchDb.getAllWatches().iterator();
        Boolean bool = null;
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                long time_since_daily = ((DBWatch) next).getTime_since_daily();
                do {
                    Object next2 = it.next();
                    long time_since_daily2 = ((DBWatch) next2).getTime_since_daily();
                    if (time_since_daily < time_since_daily2) {
                        next = next2;
                        time_since_daily = time_since_daily2;
                    }
                } while (it.hasNext());
            }
        }
        DBWatch dBWatch = (DBWatch) next;
        if (dBWatch != null && (fromAdvertisedNumberOrNull = DeviceType.Companion.fromAdvertisedNumberOrNull(dBWatch.getDevice_type())) != null) {
            bool = Boolean.valueOf(fromAdvertisedNumberOrNull.getHasDisplay());
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return steps;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return r9;
        }
        if (steps != FitnessDataKt.m1223default(HealthGoals.Companion).getSteps()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return steps;
        }
        return r9;
    }

    private final void migrateStrongerVibration(Context context, WatchDb watchDb) {
        String device_address;
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME_DEVICE_DATA, 0);
        if (!sharedPreferences.contains(STRONGER_VIBRATION)) {
            return;
        }
        boolean z = sharedPreferences.getBoolean(STRONGER_VIBRATION, false);
        DBWatch currentWatch = watchDb.getCurrentWatch();
        if (currentWatch != null && (device_address = currentWatch.getDevice_address()) != null) {
            watchDb.updateStrongerVibration(z, device_address);
        }
        sharedPreferences.edit().remove(STRONGER_VIBRATION).apply();
        LogKt.debug$default((Object) this, "Stronger vibration migrated! enabled: " + z, (String) null, (Throwable) null, false, 14, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0086, code lost:            if (r0 == null) goto L18;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void migrateToDatabase(android.content.Context r23, com.animaconnected.watch.storage.WatchDb r24) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "watch_store"
            r2 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
            java.lang.String r3 = "migrated"
            boolean r4 = r1.getBoolean(r3, r2)
            if (r4 == 0) goto L1f
            java.lang.String r6 = "Settings already migrated"
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            r5 = r22
            com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
            return
        L1f:
            java.lang.String r4 = "device-address"
            r5 = 0
            java.lang.String r4 = r1.getString(r4, r5)
            com.animaconnected.info.DeviceType$Companion r6 = com.animaconnected.info.DeviceType.Companion     // Catch: java.lang.IllegalArgumentException -> L35
            java.lang.String r7 = "device-itemid"
            r8 = -1
            int r7 = r1.getInt(r7, r8)     // Catch: java.lang.IllegalArgumentException -> L35
            com.animaconnected.info.DeviceType r6 = r6.fromAdvertisedNumber(r7)     // Catch: java.lang.IllegalArgumentException -> L35
            r13 = r6
            goto L36
        L35:
            r13 = r5
        L36:
            r14 = 1
            if (r4 == 0) goto Lb1
            if (r13 != 0) goto L3d
            goto Lb1
        L3d:
            java.lang.String r7 = "Migration started"
            r8 = 0
            r15 = 0
            r10 = 0
            r11 = 14
            r12 = 0
            r9 = 0
            r6 = r22
            com.animaconnected.logger.LogKt.debug$default(r6, r7, r8, r9, r10, r11, r12)
            r10 = 4
            r11 = 0
            r6 = r24
            r7 = r4
            r8 = r13
            r9 = r15
            com.animaconnected.watch.storage.WatchDb.saveWatch$default(r6, r7, r8, r9, r10, r11)
            java.lang.String r6 = "device_cache"
            android.content.SharedPreferences r6 = r0.getSharedPreferences(r6, r2)
            java.lang.String r7 = "device_cache_"
            java.lang.String r7 = r7.concat(r4)
            android.content.SharedPreferences r7 = r0.getSharedPreferences(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            com.animaconnected.watch.StorageToDbMigrationKt.access$copyTo(r6, r7)
            com.animaconnected.watch.SharedPreferencesCache r6 = new com.animaconnected.watch.SharedPreferencesCache
            r6.<init>(r0, r4)
            java.lang.String r0 = "cap"
            byte[] r9 = r6.getBytes(r0)
            if (r9 == 0) goto L88
            com.animaconnected.watch.device.Capabilities$Companion r7 = com.animaconnected.watch.device.Capabilities.Companion
            r10 = 1
            r11 = 1
            com.animaconnected.msgpack.MsgPackKotlin$Companion r12 = com.animaconnected.msgpack.MsgPackKotlin.Companion
            r8 = r13
            com.animaconnected.watch.device.Capabilities r0 = r7.createFromBytes(r8, r9, r10, r11, r12)
            if (r0 != 0) goto L8e
        L88:
            com.animaconnected.watch.device.Capabilities$Companion r0 = com.animaconnected.watch.device.Capabilities.Companion
            com.animaconnected.watch.device.Capabilities r0 = r0.createForLegacyDevices(r13, r2, r2)
        L8e:
            com.animaconnected.watch.StorageToDbMigration$migrateToDatabase$1 r2 = new com.animaconnected.watch.StorageToDbMigration$migrateToDatabase$1
            r4 = r24
            r2.<init>(r1, r4, r0, r5)
            kotlinx.coroutines.BuildersKt.runBlocking$default(r2)
            android.content.SharedPreferences$Editor r0 = r1.edit()
            android.content.SharedPreferences$Editor r0 = r0.putBoolean(r3, r14)
            r0.apply()
            java.lang.String r2 = "Watch to DB migrated!"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 14
            r7 = 0
            r1 = r22
            com.animaconnected.logger.LogKt.debug$default(r1, r2, r3, r4, r5, r6, r7)
            return
        Lb1:
            java.lang.String r16 = "Settings not migrated, No device to migrate, Done"
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 14
            r21 = 0
            r15 = r22
            com.animaconnected.logger.LogKt.debug$default(r15, r16, r17, r18, r19, r20, r21)
            com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(r1, r3, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.StorageToDbMigration.migrateToDatabase(android.content.Context, com.animaconnected.watch.storage.WatchDb):void");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return MainDispatcherLoader.dispatcher.plus(job);
    }

    public final void migrate(Context context, WatchDb db, FitnessProvider fitness) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(fitness, "fitness");
        migrateToDatabase(context, db);
        migrateStrongerVibration(context, db);
        migrateLostWatch(context, db);
        migrateStepsGoal(context, db, fitness);
    }
}
