package com.animaconnected.watch.model;

import app.cash.sqldelight.ColumnAdapter;
import app.cash.sqldelight.adapter.primitive.FloatColumnAdapter;
import app.cash.sqldelight.db.SqlDriver;
import com.animaconnected.watch.AlarmDatabase;
import com.animaconnected.watch.WatchDatabase;
import com.animaconnected.watch.fitness.DBActivityData;
import com.animaconnected.watch.fitness.DBDebug;
import com.animaconnected.watch.fitness.DBDeletedSessions;
import com.animaconnected.watch.fitness.DBDiagnostics;
import com.animaconnected.watch.fitness.DBElevation;
import com.animaconnected.watch.fitness.DBExercise;
import com.animaconnected.watch.fitness.DBFitnessIndex;
import com.animaconnected.watch.fitness.DBFitnessIndexProcessed;
import com.animaconnected.watch.fitness.DBGoal;
import com.animaconnected.watch.fitness.DBHeartrateData;
import com.animaconnected.watch.fitness.DBInterval;
import com.animaconnected.watch.fitness.DBLocationData;
import com.animaconnected.watch.fitness.DBPower;
import com.animaconnected.watch.fitness.DBProfile;
import com.animaconnected.watch.fitness.DBRestingHeartrateData;
import com.animaconnected.watch.fitness.DBSession;
import com.animaconnected.watch.fitness.DBSessionData;
import com.animaconnected.watch.fitness.DBSleepData;
import com.animaconnected.watch.fitness.DBSleepHistoryData;
import com.animaconnected.watch.fitness.DBSpeedCalibration;
import com.animaconnected.watch.fitness.DBStand;
import com.animaconnected.watch.fitness.DBStress;
import com.animaconnected.watch.fitness.DBWrist;
import com.animaconnected.watch.fitness.StravaPendingUploads;
import com.animaconnected.watch.model.alarms.Alarms;
import com.animaconnected.watch.model.alarms.DaysOfWeek;
import com.animaconnected.watch.storage.models.BehaviourSlot;
import com.animaconnected.watch.storage.models.DBWatch;
import com.animaconnected.watch.sync.DBApp;
import com.animaconnected.watch.sync.DBAppPositions;
import com.animaconnected.watch.sync.DBConfig;
import com.animaconnected.watch.sync.DBFile;
import com.animaconnected.watch.sync.DBPreferences;
import io.ktor.http.content.NullBody;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverFactory.kt */
/* loaded from: classes3.dex */
public final class DriverFactoryKt {
    private static final ColumnAdapter<DaysOfWeek, Long> dayOfWeekAdapter = new ColumnAdapter<DaysOfWeek, Long>() { // from class: com.animaconnected.watch.model.DriverFactoryKt$dayOfWeekAdapter$1
        @Override // app.cash.sqldelight.ColumnAdapter
        public /* bridge */ /* synthetic */ DaysOfWeek decode(Long l) {
            return decode(l.longValue());
        }

        public DaysOfWeek decode(long j) {
            return DaysOfWeek.Companion.fromBitSet(((int) j) << 1);
        }

        @Override // app.cash.sqldelight.ColumnAdapter
        public Long encode(DaysOfWeek value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Long.valueOf(value.toBitSet() >> 1);
        }
    };

    public static final AlarmDatabase createAlarmsDatabase(DriverFactory driverFactory) {
        Intrinsics.checkNotNullParameter(driverFactory, "driverFactory");
        SqlDriver createAlarmsDriver = driverFactory.createAlarmsDriver();
        AlarmDatabase.Companion companion = AlarmDatabase.Companion;
        NullBody nullBody = NullBody.INSTANCE$1;
        return companion.invoke(createAlarmsDriver, new Alarms.Adapter(nullBody, nullBody, dayOfWeekAdapter));
    }

    public static final WatchDatabase createTestWatchDatabase() {
        return createWatchDatabase(new TestDriverFactory(), new Function1<String, HistoryDeviceId>() { // from class: com.animaconnected.watch.model.DriverFactoryKt$createTestWatchDatabase$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ HistoryDeviceId invoke(String str) {
                return HistoryDeviceId.m1556boximpl(m1555invoke1z8L_Yw(str));
            }

            /* renamed from: invoke-1z8L_Yw, reason: not valid java name */
            public final String m1555invoke1z8L_Yw(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return HistoryDeviceId.m1557constructorimpl("A-".concat(it));
            }
        });
    }

    public static final WatchDatabase createWatchDatabase(DriverFactory driverFactory, Function1<? super String, HistoryDeviceId> getHistoryDeviceId) {
        Intrinsics.checkNotNullParameter(driverFactory, "driverFactory");
        Intrinsics.checkNotNullParameter(getHistoryDeviceId, "getHistoryDeviceId");
        return createWatchDatabase(driverFactory.createDriver(), getHistoryDeviceId);
    }

    public static final WatchDatabase createWatchDatabase(SqlDriver driver, Function1<? super String, HistoryDeviceId> getHistoryDeviceId) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(getHistoryDeviceId, "getHistoryDeviceId");
        HistoryDeviceIdColumnAdapter historyDeviceIdColumnAdapter = new HistoryDeviceIdColumnAdapter(getHistoryDeviceId);
        WatchDatabase.Companion companion = WatchDatabase.Companion;
        NullBody nullBody = NullBody.INSTANCE$1;
        BehaviourSlot.Adapter adapter = new BehaviourSlot.Adapter(nullBody, nullBody);
        FloatColumnAdapter floatColumnAdapter = FloatColumnAdapter.INSTANCE;
        DBActivityData.Adapter adapter2 = new DBActivityData.Adapter(historyDeviceIdColumnAdapter, nullBody, nullBody, nullBody, nullBody, nullBody, floatColumnAdapter, nullBody, nullBody);
        DBApp.Adapter adapter3 = new DBApp.Adapter(nullBody);
        DBAppPositions.Adapter adapter4 = new DBAppPositions.Adapter(nullBody);
        DBConfig.Adapter adapter5 = new DBConfig.Adapter(nullBody);
        DBDebug.Adapter adapter6 = new DBDebug.Adapter(historyDeviceIdColumnAdapter, nullBody, nullBody);
        DBDiagnostics.Adapter adapter7 = new DBDiagnostics.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBElevation.Adapter adapter8 = new DBElevation.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBExercise.Adapter adapter9 = new DBExercise.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBFile.Adapter adapter10 = new DBFile.Adapter(nullBody);
        DBFitnessIndex.Adapter adapter11 = new DBFitnessIndex.Adapter(historyDeviceIdColumnAdapter, floatColumnAdapter);
        DBFitnessIndexProcessed.Adapter adapter12 = new DBFitnessIndexProcessed.Adapter(historyDeviceIdColumnAdapter, floatColumnAdapter);
        DBGoal.Adapter adapter13 = new DBGoal.Adapter(historyDeviceIdColumnAdapter, nullBody, nullBody, nullBody);
        DBHeartrateData.Adapter adapter14 = new DBHeartrateData.Adapter(historyDeviceIdColumnAdapter, nullBody, nullBody, nullBody, nullBody);
        DBLocationData.Adapter adapter15 = new DBLocationData.Adapter(historyDeviceIdColumnAdapter, floatColumnAdapter);
        DBPower.Adapter adapter16 = new DBPower.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBPreferences.Adapter adapter17 = new DBPreferences.Adapter(nullBody);
        DBProfile.Adapter adapter18 = new DBProfile.Adapter(nullBody, nullBody, nullBody, nullBody, nullBody, nullBody, nullBody);
        DBRestingHeartrateData.Adapter adapter19 = new DBRestingHeartrateData.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBSession.Adapter adapter20 = new DBSession.Adapter(historyDeviceIdColumnAdapter, nullBody, nullBody, nullBody, nullBody, floatColumnAdapter, nullBody);
        DBSessionData.Adapter adapter21 = new DBSessionData.Adapter(historyDeviceIdColumnAdapter, nullBody, nullBody);
        DBSleepData.Adapter adapter22 = new DBSleepData.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBStand.Adapter adapter23 = new DBStand.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBStress.Adapter adapter24 = new DBStress.Adapter(historyDeviceIdColumnAdapter, nullBody);
        DBWatch.Adapter adapter25 = new DBWatch.Adapter(nullBody, nullBody);
        DBWrist.Adapter adapter26 = new DBWrist.Adapter(historyDeviceIdColumnAdapter, nullBody);
        return companion.invoke(driver, adapter, adapter2, adapter3, adapter4, adapter5, adapter6, new DBDeletedSessions.Adapter(historyDeviceIdColumnAdapter), adapter7, adapter8, adapter9, adapter10, adapter11, adapter12, adapter13, adapter14, new DBInterval.Adapter(historyDeviceIdColumnAdapter), adapter15, adapter16, adapter17, adapter18, adapter19, adapter20, adapter21, adapter22, new DBSleepHistoryData.Adapter(historyDeviceIdColumnAdapter), new DBSpeedCalibration.Adapter(historyDeviceIdColumnAdapter, nullBody), adapter23, adapter24, adapter25, adapter26, new StravaPendingUploads.Adapter(historyDeviceIdColumnAdapter));
    }
}
