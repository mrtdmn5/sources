package com.animaconnected.watch;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import com.animaconnected.watch.database.WatchDatabaseImplKt;
import com.animaconnected.watch.filter.AncsQueries;
import com.animaconnected.watch.filter.ApplicationQueries;
import com.animaconnected.watch.filter.ImportantContactQueries;
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
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.StravaPendingUploads;
import com.animaconnected.watch.storage.models.BehaviourSlot;
import com.animaconnected.watch.storage.models.BehaviourSlotQueries;
import com.animaconnected.watch.storage.models.DBCurrentWatchQueries;
import com.animaconnected.watch.storage.models.DBWatch;
import com.animaconnected.watch.storage.models.DBWatchQueries;
import com.animaconnected.watch.sync.AppsQueries;
import com.animaconnected.watch.sync.ConfigQueries;
import com.animaconnected.watch.sync.DBApp;
import com.animaconnected.watch.sync.DBAppPositions;
import com.animaconnected.watch.sync.DBConfig;
import com.animaconnected.watch.sync.DBFile;
import com.animaconnected.watch.sync.DBPreferences;
import com.animaconnected.watch.sync.FilesQueries;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: WatchDatabase.kt */
/* loaded from: classes3.dex */
public interface WatchDatabase extends Transacter {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: WatchDatabase.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SqlSchema<QueryResult.Value<Unit>> getSchema() {
            return WatchDatabaseImplKt.getSchema(Reflection.getOrCreateKotlinClass(WatchDatabase.class));
        }

        public final WatchDatabase invoke(SqlDriver driver, BehaviourSlot.Adapter BehaviourSlotAdapter, DBActivityData.Adapter DBActivityDataAdapter, DBApp.Adapter DBAppAdapter, DBAppPositions.Adapter DBAppPositionsAdapter, DBConfig.Adapter DBConfigAdapter, DBDebug.Adapter DBDebugAdapter, DBDeletedSessions.Adapter DBDeletedSessionsAdapter, DBDiagnostics.Adapter DBDiagnosticsAdapter, DBElevation.Adapter DBElevationAdapter, DBExercise.Adapter DBExerciseAdapter, DBFile.Adapter DBFileAdapter, DBFitnessIndex.Adapter DBFitnessIndexAdapter, DBFitnessIndexProcessed.Adapter DBFitnessIndexProcessedAdapter, DBGoal.Adapter DBGoalAdapter, DBHeartrateData.Adapter DBHeartrateDataAdapter, DBInterval.Adapter DBIntervalAdapter, DBLocationData.Adapter DBLocationDataAdapter, DBPower.Adapter DBPowerAdapter, DBPreferences.Adapter DBPreferencesAdapter, DBProfile.Adapter DBProfileAdapter, DBRestingHeartrateData.Adapter DBRestingHeartrateDataAdapter, DBSession.Adapter DBSessionAdapter, DBSessionData.Adapter DBSessionDataAdapter, DBSleepData.Adapter DBSleepDataAdapter, DBSleepHistoryData.Adapter DBSleepHistoryDataAdapter, DBSpeedCalibration.Adapter DBSpeedCalibrationAdapter, DBStand.Adapter DBStandAdapter, DBStress.Adapter DBStressAdapter, DBWatch.Adapter DBWatchAdapter, DBWrist.Adapter DBWristAdapter, StravaPendingUploads.Adapter StravaPendingUploadsAdapter) {
            Intrinsics.checkNotNullParameter(driver, "driver");
            Intrinsics.checkNotNullParameter(BehaviourSlotAdapter, "BehaviourSlotAdapter");
            Intrinsics.checkNotNullParameter(DBActivityDataAdapter, "DBActivityDataAdapter");
            Intrinsics.checkNotNullParameter(DBAppAdapter, "DBAppAdapter");
            Intrinsics.checkNotNullParameter(DBAppPositionsAdapter, "DBAppPositionsAdapter");
            Intrinsics.checkNotNullParameter(DBConfigAdapter, "DBConfigAdapter");
            Intrinsics.checkNotNullParameter(DBDebugAdapter, "DBDebugAdapter");
            Intrinsics.checkNotNullParameter(DBDeletedSessionsAdapter, "DBDeletedSessionsAdapter");
            Intrinsics.checkNotNullParameter(DBDiagnosticsAdapter, "DBDiagnosticsAdapter");
            Intrinsics.checkNotNullParameter(DBElevationAdapter, "DBElevationAdapter");
            Intrinsics.checkNotNullParameter(DBExerciseAdapter, "DBExerciseAdapter");
            Intrinsics.checkNotNullParameter(DBFileAdapter, "DBFileAdapter");
            Intrinsics.checkNotNullParameter(DBFitnessIndexAdapter, "DBFitnessIndexAdapter");
            Intrinsics.checkNotNullParameter(DBFitnessIndexProcessedAdapter, "DBFitnessIndexProcessedAdapter");
            Intrinsics.checkNotNullParameter(DBGoalAdapter, "DBGoalAdapter");
            Intrinsics.checkNotNullParameter(DBHeartrateDataAdapter, "DBHeartrateDataAdapter");
            Intrinsics.checkNotNullParameter(DBIntervalAdapter, "DBIntervalAdapter");
            Intrinsics.checkNotNullParameter(DBLocationDataAdapter, "DBLocationDataAdapter");
            Intrinsics.checkNotNullParameter(DBPowerAdapter, "DBPowerAdapter");
            Intrinsics.checkNotNullParameter(DBPreferencesAdapter, "DBPreferencesAdapter");
            Intrinsics.checkNotNullParameter(DBProfileAdapter, "DBProfileAdapter");
            Intrinsics.checkNotNullParameter(DBRestingHeartrateDataAdapter, "DBRestingHeartrateDataAdapter");
            Intrinsics.checkNotNullParameter(DBSessionAdapter, "DBSessionAdapter");
            Intrinsics.checkNotNullParameter(DBSessionDataAdapter, "DBSessionDataAdapter");
            Intrinsics.checkNotNullParameter(DBSleepDataAdapter, "DBSleepDataAdapter");
            Intrinsics.checkNotNullParameter(DBSleepHistoryDataAdapter, "DBSleepHistoryDataAdapter");
            Intrinsics.checkNotNullParameter(DBSpeedCalibrationAdapter, "DBSpeedCalibrationAdapter");
            Intrinsics.checkNotNullParameter(DBStandAdapter, "DBStandAdapter");
            Intrinsics.checkNotNullParameter(DBStressAdapter, "DBStressAdapter");
            Intrinsics.checkNotNullParameter(DBWatchAdapter, "DBWatchAdapter");
            Intrinsics.checkNotNullParameter(DBWristAdapter, "DBWristAdapter");
            Intrinsics.checkNotNullParameter(StravaPendingUploadsAdapter, "StravaPendingUploadsAdapter");
            return WatchDatabaseImplKt.newInstance(Reflection.getOrCreateKotlinClass(WatchDatabase.class), driver, BehaviourSlotAdapter, DBActivityDataAdapter, DBAppAdapter, DBAppPositionsAdapter, DBConfigAdapter, DBDebugAdapter, DBDeletedSessionsAdapter, DBDiagnosticsAdapter, DBElevationAdapter, DBExerciseAdapter, DBFileAdapter, DBFitnessIndexAdapter, DBFitnessIndexProcessedAdapter, DBGoalAdapter, DBHeartrateDataAdapter, DBIntervalAdapter, DBLocationDataAdapter, DBPowerAdapter, DBPreferencesAdapter, DBProfileAdapter, DBRestingHeartrateDataAdapter, DBSessionAdapter, DBSessionDataAdapter, DBSleepDataAdapter, DBSleepHistoryDataAdapter, DBSpeedCalibrationAdapter, DBStandAdapter, DBStressAdapter, DBWatchAdapter, DBWristAdapter, StravaPendingUploadsAdapter);
        }
    }

    AncsQueries getAncsQueries();

    ApplicationQueries getApplicationQueries();

    AppsQueries getAppsQueries();

    BehaviourSlotQueries getBehaviourSlotQueries();

    ConfigQueries getConfigQueries();

    DBCurrentWatchQueries getDBCurrentWatchQueries();

    DBWatchQueries getDBWatchQueries();

    FilesQueries getFilesQueries();

    FitnessQueries getFitnessQueries();

    ImportantContactQueries getImportantContactQueries();

    @Override // app.cash.sqldelight.Transacter
    /* synthetic */ void transaction(boolean z, Function1 function1);

    /* synthetic */ Object transactionWithResult(boolean z, Function1 function1);
}
