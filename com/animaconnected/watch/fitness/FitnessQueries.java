package com.animaconnected.watch.fitness;

import app.cash.sqldelight.ColumnAdapter;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.TransactionWithoutReturn;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
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
import com.animaconnected.watch.model.HistoryDeviceId;
import com.google.firebase.messaging.MessagingAnalytics$$ExternalSyntheticLambda0;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessQueries.kt */
/* loaded from: classes3.dex */
public final class FitnessQueries extends TransacterImpl {
    private final DBActivityData.Adapter DBActivityDataAdapter;
    private final DBDebug.Adapter DBDebugAdapter;
    private final DBDeletedSessions.Adapter DBDeletedSessionsAdapter;
    private final DBDiagnostics.Adapter DBDiagnosticsAdapter;
    private final DBElevation.Adapter DBElevationAdapter;
    private final DBExercise.Adapter DBExerciseAdapter;
    private final DBFitnessIndex.Adapter DBFitnessIndexAdapter;
    private final DBFitnessIndexProcessed.Adapter DBFitnessIndexProcessedAdapter;
    private final DBGoal.Adapter DBGoalAdapter;
    private final DBHeartrateData.Adapter DBHeartrateDataAdapter;
    private final DBInterval.Adapter DBIntervalAdapter;
    private final DBLocationData.Adapter DBLocationDataAdapter;
    private final DBPower.Adapter DBPowerAdapter;
    private final DBProfile.Adapter DBProfileAdapter;
    private final DBRestingHeartrateData.Adapter DBRestingHeartrateDataAdapter;
    private final DBSession.Adapter DBSessionAdapter;
    private final DBSessionData.Adapter DBSessionDataAdapter;
    private final DBSleepData.Adapter DBSleepDataAdapter;
    private final DBSleepHistoryData.Adapter DBSleepHistoryDataAdapter;
    private final DBSpeedCalibration.Adapter DBSpeedCalibrationAdapter;
    private final DBStand.Adapter DBStandAdapter;
    private final DBStress.Adapter DBStressAdapter;
    private final DBWrist.Adapter DBWristAdapter;
    private final StravaPendingUploads.Adapter StravaPendingUploadsAdapter;

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetActivityDataByIdentifierForWorkoutQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetActivityDataByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-43426330, "SELECT *\nFROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ? ORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetActivityDataByIdentifierForWorkoutQuery$execute$1
                final /* synthetic */ FitnessQueries.GetActivityDataByIdentifierForWorkoutQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBActivityData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBActivityDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1356getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1356getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getActivityDataByIdentifierForWorkout";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetActivityDataByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetActivityDataForSessionQuery<T> extends Query<T> {
        private final String hdid;
        private final long sesson_end;
        private final long sesson_start;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetActivityDataForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData", "DBInterval"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-1415638945, "SELECT *\nFROM DBActivityData AS loc\nWHERE timestamp >= ?\n    AND timestamp <= ?\n        AND hdid == ?\n    AND EXISTS\n        (SELECT *\n        FROM DBInterval interval\n        WHERE interval.start_timestamp >= ?\n            AND interval.end_timestamp <= ?\n            AND loc.timestamp > interval.start_timestamp\n            AND loc.timestamp < interval.end_timestamp)", mapper, 5, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetActivityDataForSessionQuery$execute$1
                final /* synthetic */ FitnessQueries.GetActivityDataForSessionQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBActivityData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSesson_start()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getSesson_end()));
                    adapter = fitnessQueries.DBActivityDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1357getHdidV9ZILtA())));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getSesson_start()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getSesson_end()));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1357getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getSesson_end() {
            return this.sesson_end;
        }

        public final long getSesson_start() {
            return this.sesson_start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData", "DBInterval"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getActivityDataForSession";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetActivityDataForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.sesson_start = j;
            this.sesson_end = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetActivityDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetActivityDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(826360114, "SELECT *\nFROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetActivityDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetActivityDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getActivityData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetAvgCaloriesPerMonthQuery<T> extends Query<T> {
        private final long end;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAvgCaloriesPerMonthQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.end = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1988374402, "WITH DailyCalories AS (\n  SELECT timestamp, date(timestamp / 1000, 'unixepoch', 'localtime') AS day, SUM(calories) AS sum_calories\n  FROM DBActivityData\n  WHERE timestamp >= ? AND timestamp < ?\n  GROUP BY 2\n)\nSELECT timestamp, AVG(sum_calories) AS avg_calories\nFROM DailyCalories\nWHERE sum_calories > 0\nGROUP BY strftime('%Y-%m', day)", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetAvgCaloriesPerMonthQuery$execute$1
                final /* synthetic */ FitnessQueries.GetAvgCaloriesPerMonthQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getEnd()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getAvgCaloriesPerMonth";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetAvgStepsPerMonthQuery<T> extends Query<T> {
        private final long end;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAvgStepsPerMonthQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.end = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-211969199, "WITH DailySteps AS (\n  SELECT timestamp, date(timestamp / 1000, 'unixepoch', 'localtime') AS day, COALESCE(SUM(walk_steps), 0) + COALESCE(SUM(run_steps), 0) AS steps\n  FROM DBActivityData\n  WHERE timestamp >= ? AND timestamp < ?\n  GROUP BY 2\n)\nSELECT timestamp, AVG(steps) AS avg_steps\nFROM DailySteps\nWHERE steps > 0\nGROUP BY strftime('%Y-%m', day)", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetAvgStepsPerMonthQuery$execute$1
                final /* synthetic */ FitnessQueries.GetAvgStepsPerMonthQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getEnd()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getAvgStepsPerMonth";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetCurrentSessionDataQuery<T> extends Query<T> {
        private final String identifier;
        private final long sessionId;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetCurrentSessionDataQuery(FitnessQueries fitnessQueries, long j, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSessionData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(1564418880, "SELECT *\nFROM DBSessionData\nWHERE session_id == ? AND hdid == ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetCurrentSessionDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetCurrentSessionDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBSessionData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSessionId()));
                    adapter = fitnessQueries.DBSessionDataAdapter;
                    executeQuery.bindString(1, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1358getIdentifierV9ZILtA())));
                }
            });
        }

        /* renamed from: getIdentifier-V9ZILtA */
        public final String m1358getIdentifierV9ZILtA() {
            return this.identifier;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSessionData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getCurrentSessionData";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetCurrentSessionDataQuery(FitnessQueries fitnessQueries, long j, String identifier, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.sessionId = j;
            this.identifier = identifier;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetDebugDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetDebugDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBDebug"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1094157668, "SELECT *\nFROM DBDebug\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetDebugDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetDebugDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBDebug"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getDebugData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetDiagnosticsDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetDiagnosticsDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBDiagnostics"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1914092803, "SELECT *\nFROM DBDiagnostics\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetDiagnosticsDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetDiagnosticsDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBDiagnostics"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getDiagnosticsData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetDistanceByIdentifierForWorkoutQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetDistanceByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-1078097406, "SELECT SUM(distance)\nFROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ? AND distance IS NOT NULL", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetDistanceByIdentifierForWorkoutQuery$execute$1
                final /* synthetic */ FitnessQueries.GetDistanceByIdentifierForWorkoutQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBActivityData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBActivityDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1359getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1359getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getDistanceByIdentifierForWorkout";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetDistanceByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetDistanceQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetDistanceQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-778212786, "SELECT SUM(distance)\nFROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ? AND distance IS NOT NULL", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetDistanceQuery$execute$1
                final /* synthetic */ FitnessQueries.GetDistanceQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getDistance";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetElevationForSessionQuery<T> extends Query<T> {
        private final long session_timestamp;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetElevationForSessionQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.session_timestamp = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBElevation"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1323260975, "SELECT * FROM DBElevation WHERE session_timestamp = ? ORDER BY number ASC", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetElevationForSessionQuery$execute$1
                final /* synthetic */ FitnessQueries.GetElevationForSessionQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSession_timestamp()));
                }
            });
        }

        public final long getSession_timestamp() {
            return this.session_timestamp;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBElevation"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getElevationForSession";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetExerciseDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetExerciseDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBExercise"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1268792453, "SELECT *\nFROM DBExercise\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetExerciseDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetExerciseDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBExercise"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getExerciseData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetGoalForTimestampQuery<T> extends Query<T> {
        final /* synthetic */ FitnessQueries this$0;
        private final long timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetGoalForTimestampQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.timestamp = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBGoal"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-490188199, "SELECT * FROM DBGoal WHERE timestamp <= ? ORDER BY timestamp DESC LIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetGoalForTimestampQuery$execute$1
                final /* synthetic */ FitnessQueries.GetGoalForTimestampQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getTimestamp()));
                }
            });
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBGoal"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getGoalForTimestamp";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetHeartRateHistorySinceQuery<T> extends Query<T> {
        private final long since;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetHeartRateHistorySinceQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.since = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(941297331, "SELECT *\nFROM DBHeartrateData\nWHERE timestamp > ? AND heartrate > 0 ORDER BY timestamp ASC", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetHeartRateHistorySinceQuery$execute$1
                final /* synthetic */ FitnessQueries.GetHeartRateHistorySinceQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSince()));
                }
            });
        }

        public final long getSince() {
            return this.since;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getHeartRateHistorySince";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetHeartrateDataByIdentifierForWorkoutQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetHeartrateDataByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(600020779, "SELECT *\nFROM DBHeartrateData\nWHERE timestamp > ? AND timestamp <= ? AND hdid == ? AND heartrate > 0 ORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetHeartrateDataByIdentifierForWorkoutQuery$execute$1
                final /* synthetic */ FitnessQueries.GetHeartrateDataByIdentifierForWorkoutQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBHeartrateData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBHeartrateDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1360getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1360getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getHeartrateDataByIdentifierForWorkout";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetHeartrateDataByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetHeartrateDataByIdentifierQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetHeartrateDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-1884435913, "SELECT *\nFROM DBHeartrateData\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ? AND heartrate > 0 ORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetHeartrateDataByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetHeartrateDataByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBHeartrateData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBHeartrateDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1361getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1361getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getHeartrateDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetHeartrateDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetHeartrateDataForSessionQuery<T> extends Query<T> {
        private final String hdid;
        private final long sesson_end;
        private final long sesson_start;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetHeartrateDataForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData", "DBInterval"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(1958299940, "SELECT *\nFROM DBHeartrateData AS hrdb\nWHERE timestamp >= ?\n    AND timestamp <= ?\n    AND heartrate > 0\n    AND hdid == ?\n    AND EXISTS\n        (SELECT *\n        FROM DBInterval interval\n        WHERE interval.start_timestamp >= ?\n            AND interval.end_timestamp <= ?\n            AND hrdb.timestamp > interval.start_timestamp\n            AND hrdb.timestamp < interval.end_timestamp)", mapper, 5, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetHeartrateDataForSessionQuery$execute$1
                final /* synthetic */ FitnessQueries.GetHeartrateDataForSessionQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBHeartrateData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSesson_start()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getSesson_end()));
                    adapter = fitnessQueries.DBHeartrateDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1362getHdidV9ZILtA())));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getSesson_start()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getSesson_end()));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1362getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getSesson_end() {
            return this.sesson_end;
        }

        public final long getSesson_start() {
            return this.sesson_start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData", "DBInterval"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getHeartrateDataForSession";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetHeartrateDataForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.sesson_start = j;
            this.sesson_end = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetHeartrateDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetHeartrateDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1610499017, "SELECT *\nFROM DBHeartrateData\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetHeartrateDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetHeartrateDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getHeartrateData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetHeartrateIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetHeartrateIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(905069297, "SELECT (timestamp - ?) / ? AS interval_index, max(heartrate) AS max, min(heartrate) AS min, avg(heartrate) AS avg FROM DBHeartrateData\nWHERE timestamp >= ? AND timestamp < ? AND heartrate > 0\nGROUP BY round((timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetHeartrateIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetHeartrateIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getHeartrateIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetHeartrateMinMaxByIdentifierQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetHeartrateMinMaxByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(1862339839, "SELECT min(heartrate_low) AS lowMin, max(heartrate_high) AS highMax\nFROM DBHeartrateData\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ? ORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetHeartrateMinMaxByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetHeartrateMinMaxByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBHeartrateData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBHeartrateDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1363getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1363getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getHeartrateMinMaxByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetHeartrateMinMaxByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetIntervalsForSessionQuery<T> extends Query<T> {
        private final long session_timestamp;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetIntervalsForSessionQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.session_timestamp = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBInterval"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1221210242, "SELECT * FROM DBInterval WHERE session_timestamp = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetIntervalsForSessionQuery$execute$1
                final /* synthetic */ FitnessQueries.GetIntervalsForSessionQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSession_timestamp()));
                }
            });
        }

        public final long getSession_timestamp() {
            return this.session_timestamp;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBInterval"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getIntervalsForSession";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetLastLocationDataByIdentifierQuery<T> extends Query<T> {
        private final long amount;
        private final String hdid;
        final /* synthetic */ FitnessQueries this$0;
        private final long timestamp;

        public /* synthetic */ GetLastLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, String str, long j2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, str, j2, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBLocationData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-1966583922, "SELECT *\nFROM DBLocationData\nWHERE timestamp >= ? AND hdid == ? AND accepted == 1\nORDER BY timestamp DESC\nLIMIT ?", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetLastLocationDataByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetLastLocationDataByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBLocationData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getTimestamp()));
                    adapter = fitnessQueries.DBLocationDataAdapter;
                    executeQuery.bindString(1, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1364getHdidV9ZILtA())));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getAmount()));
                }
            });
        }

        public final long getAmount() {
            return this.amount;
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1364getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBLocationData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getLastLocationDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetLastLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, String hdid, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.timestamp = j;
            this.hdid = hdid;
            this.amount = j2;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetLastRawLocationDataByIdentifierQuery<T> extends Query<T> {
        private final long amount;
        private final String hdid;
        final /* synthetic */ FitnessQueries this$0;
        private final long timestamp;

        public /* synthetic */ GetLastRawLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, String str, long j2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, str, j2, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBLocationData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(1308990552, "SELECT *\nFROM DBLocationData\nWHERE timestamp >= ? AND hdid == ?\nORDER BY timestamp DESC\nLIMIT ?", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetLastRawLocationDataByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetLastRawLocationDataByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBLocationData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getTimestamp()));
                    adapter = fitnessQueries.DBLocationDataAdapter;
                    executeQuery.bindString(1, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1365getHdidV9ZILtA())));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getAmount()));
                }
            });
        }

        public final long getAmount() {
            return this.amount;
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1365getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBLocationData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getLastRawLocationDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetLastRawLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, String hdid, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.timestamp = j;
            this.hdid = hdid;
            this.amount = j2;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetLatestHeartrateDataByIdentifierQuery<T> extends Query<T> {
        private final String hdid;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetLatestHeartrateDataByIdentifierQuery(FitnessQueries fitnessQueries, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-1078534352, "SELECT *\nFROM DBHeartrateData\nWHERE hdid == ? AND heartrate > 0 ORDER BY timestamp DESC LIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetLatestHeartrateDataByIdentifierQuery$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBHeartrateData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    adapter = FitnessQueries.this.DBHeartrateDataAdapter;
                    executeQuery.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.m1366getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1366getHdidV9ZILtA() {
            return this.hdid;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getLatestHeartrateDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetLatestHeartrateDataByIdentifierQuery(FitnessQueries fitnessQueries, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetLatestTimestampQuery<T> extends Query<T> {
        private final String identifier;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetLatestTimestampQuery(FitnessQueries fitnessQueries, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData", "DBHeartrateData", "DBSleepData", "DBStand", "DBSessionData", "DBStress", "DBExercise", "DBFitnessIndex", "DBWrist", "DBSpeedCalibration"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(204815574, "SELECT timestamp FROM DBActivityData WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBHeartrateData WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBSleepData WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBStand WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBSessionData WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBStress WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBExercise WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBFitnessIndex WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBWrist WHERE hdid = ?\nUNION ALL\nSELECT timestamp FROM DBSpeedCalibration WHERE hdid = ?\nORDER BY timestamp DESC LIMIT 1", mapper, 10, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetLatestTimestampQuery$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBActivityData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    adapter = FitnessQueries.this.DBActivityDataAdapter;
                    String encode = adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.m1367getIdentifierV9ZILtA()));
                    executeQuery.bindString(0, encode);
                    executeQuery.bindString(1, encode);
                    executeQuery.bindString(2, encode);
                    executeQuery.bindString(3, encode);
                    executeQuery.bindString(4, encode);
                    executeQuery.bindString(5, encode);
                    executeQuery.bindString(6, encode);
                    executeQuery.bindString(7, encode);
                    executeQuery.bindString(8, encode);
                    executeQuery.bindString(9, encode);
                }
            });
        }

        /* renamed from: getIdentifier-V9ZILtA */
        public final String m1367getIdentifierV9ZILtA() {
            return this.identifier;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData", "DBHeartrateData", "DBSleepData", "DBStand", "DBSessionData", "DBStress", "DBExercise", "DBFitnessIndex", "DBWrist", "DBSpeedCalibration"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getLatestTimestamp";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetLatestTimestampQuery(FitnessQueries fitnessQueries, String identifier, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.identifier = identifier;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetLocationDataByIdentifierQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBLocationData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-2121248936, "SELECT *\nFROM DBLocationData\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ? AND accepted == 1\nORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetLocationDataByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetLocationDataByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBLocationData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBLocationDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1368getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1368getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBLocationData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getLocationDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetLocationDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetLocationDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBLocationData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-860738856, "SELECT *\nFROM DBLocationData\nWHERE timestamp >= ? AND timestamp < ? AND accepted == 1\nORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetLocationDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetLocationDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBLocationData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getLocationData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetLocationsDataForSessionQuery<T> extends Query<T> {
        private final String hdid;
        private final long sesson_end;
        private final long sesson_start;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetLocationsDataForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBLocationData", "DBInterval"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-1226214308, "SELECT *\nFROM DBLocationData AS loc\nWHERE timestamp >= ?\n    AND timestamp <= ?\n    AND hdid == ?\n    AND accepted == 1\n    AND EXISTS\n        (SELECT *\n        FROM DBInterval interval\n        WHERE interval.start_timestamp >= ?\n            AND interval.end_timestamp <= ?\n            AND loc.timestamp > interval.start_timestamp\n            AND loc.timestamp < interval.end_timestamp)", mapper, 5, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetLocationsDataForSessionQuery$execute$1
                final /* synthetic */ FitnessQueries.GetLocationsDataForSessionQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBLocationData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSesson_start()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getSesson_end()));
                    adapter = fitnessQueries.DBLocationDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1369getHdidV9ZILtA())));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getSesson_start()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getSesson_end()));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1369getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getSesson_end() {
            return this.sesson_end;
        }

        public final long getSesson_start() {
            return this.sesson_start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBLocationData", "DBInterval"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getLocationsDataForSession";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetLocationsDataForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.sesson_start = j;
            this.sesson_end = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetPowerDataByIdentifierQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetPowerDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBPower"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-2027125098, "SELECT *\nFROM DBPower\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ? ORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetPowerDataByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetPowerDataByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBPower.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBPowerAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1370getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1370getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBPower"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getPowerDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetPowerDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetPowerDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetPowerDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBPower"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(2137575190, "SELECT *\nFROM DBPower\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetPowerDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetPowerDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBPower"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getPowerData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetProcessedFitnessIndexIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetProcessedFitnessIndexIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFitnessIndexProcessed"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-786074109, "SELECT (session_timestamp - ?) / ? AS interval_index, avg(processed_fitness_index) AS avg_fitness_index FROM DBFitnessIndexProcessed\nWHERE session_timestamp >= ? AND session_timestamp < ?\nGROUP BY round((session_timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetProcessedFitnessIndexIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetProcessedFitnessIndexIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFitnessIndexProcessed"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getProcessedFitnessIndexIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetProfileForTimestampQuery<T> extends Query<T> {
        final /* synthetic */ FitnessQueries this$0;
        private final long timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetProfileForTimestampQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.timestamp = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBProfile"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1584097635, "SELECT * FROM DBProfile\nWHERE timestamp <= ?\nORDER BY timestamp DESC LIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetProfileForTimestampQuery$execute$1
                final /* synthetic */ FitnessQueries.GetProfileForTimestampQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getTimestamp()));
                }
            });
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBProfile"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getProfileForTimestamp";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetProfilesInIntervalQuery<T> extends Query<T> {
        private final long end;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetProfilesInIntervalQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.end = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBProfile"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-946335827, "SELECT * FROM DBProfile\nWHERE timestamp >= ? AND timestamp < ?\nORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetProfilesInIntervalQuery$execute$1
                final /* synthetic */ FitnessQueries.GetProfilesInIntervalQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getEnd()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBProfile"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getProfilesInInterval";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRawFitnessIndexDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetRawFitnessIndexDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFitnessIndex"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-154992925, "SELECT *\nFROM DBFitnessIndex\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRawFitnessIndexDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRawFitnessIndexDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFitnessIndex"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRawFitnessIndexData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRawFitnessIndexForSessionQuery<T> extends Query<T> {
        private final String hdid;
        private final long sesson_end;
        private final long sesson_start;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetRawFitnessIndexForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFitnessIndex"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-1223800314, "SELECT *\nFROM DBFitnessIndex\nWHERE timestamp >= ?\n    AND timestamp <= ?\n    AND hdid == ?\n    AND fitness_index > 0.0\n    ORDER BY timestamp ASC\n    LIMIT 3", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRawFitnessIndexForSessionQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRawFitnessIndexForSessionQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBFitnessIndex.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSesson_start()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getSesson_end()));
                    adapter = fitnessQueries.DBFitnessIndexAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1371getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1371getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getSesson_end() {
            return this.sesson_end;
        }

        public final long getSesson_start() {
            return this.sesson_start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFitnessIndex"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRawFitnessIndexForSession";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetRawFitnessIndexForSessionQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.sesson_start = j;
            this.sesson_end = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRawHRAndActivtyQuery<T> extends Query<T> {
        private final long end;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetRawHRAndActivtyQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.end = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData", "DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(608266886, "SELECT hdid, timestamp, heartrate, NULL AS activity_class FROM DBHeartrateData\nWHERE timestamp >= ? AND timestamp < ? AND heartrate > 0\nUNION\nSELECT hdid, timestamp, NULL, activity_class FROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ?\nORDER BY timestamp ASC", mapper, 4, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRawHRAndActivtyQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRawHRAndActivtyQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData", "DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRawHRAndActivty";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRawLocationDataByIdentifierQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetRawLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBLocationData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-2111500210, "SELECT *\nFROM DBLocationData\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ?\nORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRawLocationDataByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRawLocationDataByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBLocationData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBLocationDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1372getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1372getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBLocationData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRawLocationDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetRawLocationDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRawLocationDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetRawLocationDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBLocationData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-514315058, "SELECT *\nFROM DBLocationData\nWHERE timestamp >= ? AND timestamp < ?\nORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRawLocationDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRawLocationDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBLocationData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRawLocationData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRelevantSessionFitnessIndexDataQuery<T> extends Query<T> {
        final /* synthetic */ FitnessQueries this$0;
        private final long timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetRelevantSessionFitnessIndexDataQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.timestamp = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSession"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1911451508, "SELECT DBSession.fitness_index\nFROM DBSession\nWHERE DBSession.fitness_index IS NOT NULL AND DBSession.start_timestamp <= ?\nORDER BY start_timestamp DESC\nLIMIT 5", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRelevantSessionFitnessIndexDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRelevantSessionFitnessIndexDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getTimestamp()));
                }
            });
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSession"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRelevantSessionFitnessIndexData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRestingHeartrateDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetRestingHeartrateDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBRestingHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1028532517, "SELECT *\nFROM DBRestingHeartrateData\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRestingHeartrateDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRestingHeartrateDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBRestingHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRestingHeartrateData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetRestingHeartrateIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetRestingHeartrateIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBRestingHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-635121003, "SELECT (timestamp - ?) / ? AS interval_index, avg(restingHeartrate) AS avgRestingHeartRateValue FROM DBRestingHeartrateData\nWHERE timestamp >= ? AND timestamp < ? AND restingHeartrate > 0\nGROUP BY round((timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetRestingHeartrateIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetRestingHeartrateIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBRestingHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getRestingHeartrateIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSessionDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSessionDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSessionData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1198096999, "SELECT *\nFROM DBSessionData\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSessionDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSessionDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSessionData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSessionData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSessionQuery<T> extends Query<T> {
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSessionQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSession"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(842200349, "SELECT *\nFROM DBSession\nWHERE start_timestamp == ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSessionQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSessionQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSession"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSession";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSessionsQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSessionsQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSession"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(338407158, "SELECT *\nFROM DBSession\nWHERE start_timestamp >= ? AND start_timestamp < ? ORDER BY start_timestamp DESC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSessionsQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSessionsQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSession"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSessions";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSessionsSinceQuery<T> extends Query<T> {
        private final long since;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSessionsSinceQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.since = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSession"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1652309476, "SELECT *\nFROM DBSession\nWHERE start_timestamp > ? ORDER BY start_timestamp ASC", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSessionsSinceQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSessionsSinceQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSince()));
                }
            });
        }

        public final long getSince() {
            return this.since;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSession"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSessionsSince";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSessionsWithPendingUploadQuery<T> extends Query<T> {
        private final String hdid;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetSessionsWithPendingUploadQuery(FitnessQueries fitnessQueries, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSession", "StravaPendingUploads"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(654623484, "SELECT * FROM DBSession\nJOIN StravaPendingUploads\nON DBSession.start_timestamp = StravaPendingUploads.timestamp AND DBSession.hdid = StravaPendingUploads.hdid\nWHERE DBSession.hdid = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSessionsWithPendingUploadQuery$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBSession.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    adapter = FitnessQueries.this.DBSessionAdapter;
                    executeQuery.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.m1373getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1373getHdidV9ZILtA() {
            return this.hdid;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSession", "StravaPendingUploads"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSessionsWithPendingUpload";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetSessionsWithPendingUploadQuery(FitnessQueries fitnessQueries, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSleepDataByIdentifierQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetSleepDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSleepData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(-557627288, "SELECT *\nFROM DBSleepData\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ? ORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSleepDataByIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSleepDataByIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBSleepData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBSleepDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1374getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1374getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSleepData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSleepDataByIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetSleepDataByIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSleepDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSleepDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSleepData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1279671272, "SELECT *\nFROM DBSleepData\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSleepDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSleepDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSleepData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSleepData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSleepHistoryDataEndInclusiveQuery<T> extends Query<T> {
        private final long end;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSleepHistoryDataEndInclusiveQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.end = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1482109999, "SELECT *\nFROM DBSleepHistoryData\nWHERE end >= ? AND end < ? ORDER BY start ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSleepHistoryDataEndInclusiveQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSleepHistoryDataEndInclusiveQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getEnd()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSleepHistoryDataEndInclusive";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSleepHistoryDataQuery<T> extends Query<T> {
        private final long end;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSleepHistoryDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.end = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1389883488, "SELECT *\nFROM DBSleepHistoryData\nWHERE end >= ? AND end < ? ORDER BY start ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSleepHistoryDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSleepHistoryDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getEnd()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSleepHistoryData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSleepHistorySinceQuery<T> extends Query<T> {
        private final long since;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSleepHistorySinceQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.since = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(150800708, "SELECT *\nFROM DBSleepHistoryData\nWHERE end > ? ORDER BY end ASC", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSleepHistorySinceQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSleepHistorySinceQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSince()));
                }
            });
        }

        public final long getSince() {
            return this.since;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSleepHistorySince";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSpeedCalibrationDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSpeedCalibrationDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSpeedCalibration"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-406889914, "SELECT *\nFROM DBSpeedCalibration\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSpeedCalibrationDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSpeedCalibrationDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSpeedCalibration"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSpeedCalibrationData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetStandDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetStandDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBStand"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-966182553, "SELECT *\nFROM DBStand\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetStandDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetStandDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBStand"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getStandData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetStressDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetStressDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBStress"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(750479255, "SELECT *\nFROM DBStress\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetStressDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetStressDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBStress"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getStressData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetStressIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetStressIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBStress"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(869656145, "SELECT (timestamp - ?) / ? AS interval_index, avg(stress) AS avg_stress FROM DBStress\nWHERE timestamp >= ? AND timestamp < ?\nGROUP BY round((timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetStressIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetStressIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBStress"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getStressIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumCaloriesByIdentifierForWorkoutQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetSumCaloriesByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(1698844076, "SELECT SUM(calories)\nFROM DBActivityData\nWHERE timestamp > ? AND timestamp <= ? AND hdid == ? AND calories IS NOT NULL", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumCaloriesByIdentifierForWorkoutQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumCaloriesByIdentifierForWorkoutQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBActivityData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBActivityDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1375getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1375getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumCaloriesByIdentifierForWorkout";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetSumCaloriesByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumCaloriesIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSumCaloriesIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(110658492, "SELECT (timestamp - ?) / ? AS interval_index, SUM(calories) AS calories FROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ?\nGROUP BY round((timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumCaloriesIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumCaloriesIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumCaloriesIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumCaloriesQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSumCaloriesQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-335525512, "SELECT SUM(calories)\nFROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ? AND calories IS NOT NULL", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumCaloriesQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumCaloriesQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumCalories";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumExerciseQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSumExerciseQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBExercise"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1889763402, "SELECT SUM(active_minutes)\nFROM DBExercise\nWHERE timestamp >= ? AND timestamp < ?", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumExerciseQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumExerciseQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBExercise"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumExercise";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumStepsByIdentifierForWorkoutQuery<T> extends Query<T> {
        private final String hdid;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetSumStepsByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(158995049, "SELECT COALESCE(SUM(walk_steps), 0) + COALESCE(SUM(run_steps), 0)\nFROM DBActivityData\nWHERE timestamp > ? AND timestamp <= ? AND hdid == ?", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumStepsByIdentifierForWorkoutQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumStepsByIdentifierForWorkoutQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBActivityData.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBActivityDataAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1376getHdidV9ZILtA())));
                }
            });
        }

        /* renamed from: getHdid-V9ZILtA */
        public final String m1376getHdidV9ZILtA() {
            return this.hdid;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumStepsByIdentifierForWorkout";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetSumStepsByIdentifierForWorkoutQuery(FitnessQueries fitnessQueries, long j, long j2, String hdid, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hdid, "hdid");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.hdid = hdid;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumStepsCategorisedQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSumStepsCategorisedQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(785171311, "SELECT SUM(walk_steps) AS walk, SUM(run_steps) AS run, SUM(other_steps) AS other\nFROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ?", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumStepsCategorisedQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumStepsCategorisedQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumStepsCategorised";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumStepsIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSumStepsIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1330922503, "SELECT (timestamp - ?) / ? AS interval_index, COALESCE(SUM(walk_steps), 0) + COALESCE(SUM(run_steps), 0) AS steps FROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ?\nGROUP BY round((timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumStepsIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumStepsIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumStepsIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSumStepsQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSumStepsQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1452554741, "SELECT COALESCE(SUM(walk_steps), 0) + COALESCE(SUM(run_steps), 0)\nFROM DBActivityData\nWHERE timestamp >= ? AND timestamp < ?", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetSumStepsQuery$execute$1
                final /* synthetic */ FitnessQueries.GetSumStepsQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getSumSteps";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetTotalExerciseIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetTotalExerciseIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBExercise"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1534367495, "SELECT (timestamp - ?) / ? AS interval_index, SUM(active_minutes) AS total_active_minutes FROM DBExercise\nWHERE timestamp >= ? AND timestamp < ?\nGROUP BY round((timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetTotalExerciseIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetTotalExerciseIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBExercise"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getTotalExerciseIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetTotalStandsIntervaledQuery<T> extends Query<T> {
        private final long end;
        private final long interval;
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetTotalStandsIntervaledQuery(FitnessQueries fitnessQueries, long j, long j2, long j3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.interval = j2;
            this.end = j3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBStand"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(547465484, "SELECT (timestamp - ?) / ? AS interval_index, MAX(successful_stands) AS total_stands FROM DBStand\nWHERE timestamp >= ? AND timestamp < ?\nGROUP BY round((timestamp - ?) / ?)", mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetTotalStandsIntervaledQuery$execute$1
                final /* synthetic */ FitnessQueries.GetTotalStandsIntervaledQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getInterval()));
                    executeQuery.bindLong(2, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(3, Long.valueOf(this.this$0.getEnd()));
                    executeQuery.bindLong(4, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(5, Long.valueOf(this.this$0.getInterval()));
                }
            });
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBStand"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getTotalStandsIntervaled";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetWristDataForIdentifierQuery<T> extends Query<T> {
        private final String identifier;
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        public /* synthetic */ GetWristDataForIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(fitnessQueries, j, j2, str, function1);
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBWrist"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final FitnessQueries fitnessQueries = this.this$0;
            return driver.executeQuery(1808392530, "SELECT * FROM DBWrist\nWHERE timestamp >= ? AND timestamp < ? AND hdid == ?\nORDER BY timestamp ASC", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetWristDataForIdentifierQuery$execute$1
                final /* synthetic */ FitnessQueries.GetWristDataForIdentifierQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    DBWrist.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                    adapter = fitnessQueries.DBWristAdapter;
                    executeQuery.bindString(2, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(this.this$0.m1377getIdentifierV9ZILtA())));
                }
            });
        }

        /* renamed from: getIdentifier-V9ZILtA */
        public final String m1377getIdentifierV9ZILtA() {
            return this.identifier;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBWrist"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getWristDataForIdentifier";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GetWristDataForIdentifierQuery(FitnessQueries fitnessQueries, long j, long j2, String identifier, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
            this.identifier = identifier;
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetWristDataQuery<T> extends Query<T> {
        private final long start;
        private final long stop;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetWristDataQuery(FitnessQueries fitnessQueries, long j, long j2, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
            this.stop = j2;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBWrist"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-128702240, "SELECT *\nFROM DBWrist\nWHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$GetWristDataQuery$execute$1
                final /* synthetic */ FitnessQueries.GetWristDataQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                    executeQuery.bindLong(1, Long.valueOf(this.this$0.getStop()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        public final long getStop() {
            return this.stop;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBWrist"}, listener);
        }

        public String toString() {
            return "Fitness.sq:getWristData";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class HasCaloriesEntriesBeforeQuery<T> extends Query<T> {
        private final long instant;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasCaloriesEntriesBeforeQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.instant = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-2011993012, "SELECT COUNT(calories) > 0 FROM DBActivityData\nWHERE timestamp < ? AND calories IS NOT NULL\nLIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$HasCaloriesEntriesBeforeQuery$execute$1
                final /* synthetic */ FitnessQueries.HasCaloriesEntriesBeforeQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getInstant()));
                }
            });
        }

        public final long getInstant() {
            return this.instant;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:hasCaloriesEntriesBefore";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class HasHeartrateEntriesBeforeQuery<T> extends Query<T> {
        private final long instant;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasHeartrateEntriesBeforeQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.instant = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(386825862, "SELECT COUNT(*) > 0 FROM DBHeartrateData\nWHERE timestamp < ? AND heartrate > 0\nLIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$HasHeartrateEntriesBeforeQuery$execute$1
                final /* synthetic */ FitnessQueries.HasHeartrateEntriesBeforeQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getInstant()));
                }
            });
        }

        public final long getInstant() {
            return this.instant;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:hasHeartrateEntriesBefore";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class HasProcessedFitnessIndexBeforeQuery<T> extends Query<T> {
        private final long instant;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasProcessedFitnessIndexBeforeQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.instant = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFitnessIndexProcessed"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-658261222, "SELECT COUNT(*) > 0 FROM DBFitnessIndexProcessed\nWHERE session_timestamp < ?\nLIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$HasProcessedFitnessIndexBeforeQuery$execute$1
                final /* synthetic */ FitnessQueries.HasProcessedFitnessIndexBeforeQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getInstant()));
                }
            });
        }

        public final long getInstant() {
            return this.instant;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFitnessIndexProcessed"}, listener);
        }

        public String toString() {
            return "Fitness.sq:hasProcessedFitnessIndexBefore";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class HasRestingHeartrateEntriesBeforeQuery<T> extends Query<T> {
        private final long instant;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasRestingHeartrateEntriesBeforeQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.instant = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBRestingHeartrateData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-657451174, "SELECT COUNT(*) > 0 FROM DBRestingHeartrateData\nWHERE timestamp < ? AND restingHeartrate > 0\nLIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$HasRestingHeartrateEntriesBeforeQuery$execute$1
                final /* synthetic */ FitnessQueries.HasRestingHeartrateEntriesBeforeQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getInstant()));
                }
            });
        }

        public final long getInstant() {
            return this.instant;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBRestingHeartrateData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:hasRestingHeartrateEntriesBefore";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class HasSleepHistoryBeforeQuery<T> extends Query<T> {
        private final long start;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasSleepHistoryBeforeQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.start = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1714608903, "SELECT COUNT(*) > 0 FROM DBSleepHistoryData\nWHERE start <= ?\nLIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$HasSleepHistoryBeforeQuery$execute$1
                final /* synthetic */ FitnessQueries.HasSleepHistoryBeforeQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getStart()));
                }
            });
        }

        public final long getStart() {
            return this.start;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBSleepHistoryData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:hasSleepHistoryBefore";
        }
    }

    /* compiled from: FitnessQueries.kt */
    /* loaded from: classes3.dex */
    public final class HasStepEntriesBeforeQuery<T> extends Query<T> {
        private final long instant;
        final /* synthetic */ FitnessQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasStepEntriesBeforeQuery(FitnessQueries fitnessQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = fitnessQueries;
            this.instant = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBActivityData"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1498661946, "SELECT COUNT(walk_steps) > 0 AS walk, COUNT(run_steps) > 0 AS run\nFROM DBActivityData\nWHERE timestamp < ?\nLIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.fitness.FitnessQueries$HasStepEntriesBeforeQuery$execute$1
                final /* synthetic */ FitnessQueries.HasStepEntriesBeforeQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getInstant()));
                }
            });
        }

        public final long getInstant() {
            return this.instant;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBActivityData"}, listener);
        }

        public String toString() {
            return "Fitness.sq:hasStepEntriesBefore";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessQueries(SqlDriver driver, DBActivityData.Adapter DBActivityDataAdapter, DBHeartrateData.Adapter DBHeartrateDataAdapter, DBDebug.Adapter DBDebugAdapter, DBDiagnostics.Adapter DBDiagnosticsAdapter, DBPower.Adapter DBPowerAdapter, DBRestingHeartrateData.Adapter DBRestingHeartrateDataAdapter, DBSleepData.Adapter DBSleepDataAdapter, DBSleepHistoryData.Adapter DBSleepHistoryDataAdapter, DBStand.Adapter DBStandAdapter, DBExercise.Adapter DBExerciseAdapter, DBFitnessIndex.Adapter DBFitnessIndexAdapter, DBFitnessIndexProcessed.Adapter DBFitnessIndexProcessedAdapter, DBWrist.Adapter DBWristAdapter, DBSpeedCalibration.Adapter DBSpeedCalibrationAdapter, DBStress.Adapter DBStressAdapter, DBSessionData.Adapter DBSessionDataAdapter, DBDeletedSessions.Adapter DBDeletedSessionsAdapter, DBLocationData.Adapter DBLocationDataAdapter, DBSession.Adapter DBSessionAdapter, DBInterval.Adapter DBIntervalAdapter, DBElevation.Adapter DBElevationAdapter, DBGoal.Adapter DBGoalAdapter, DBProfile.Adapter DBProfileAdapter, StravaPendingUploads.Adapter StravaPendingUploadsAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(DBActivityDataAdapter, "DBActivityDataAdapter");
        Intrinsics.checkNotNullParameter(DBHeartrateDataAdapter, "DBHeartrateDataAdapter");
        Intrinsics.checkNotNullParameter(DBDebugAdapter, "DBDebugAdapter");
        Intrinsics.checkNotNullParameter(DBDiagnosticsAdapter, "DBDiagnosticsAdapter");
        Intrinsics.checkNotNullParameter(DBPowerAdapter, "DBPowerAdapter");
        Intrinsics.checkNotNullParameter(DBRestingHeartrateDataAdapter, "DBRestingHeartrateDataAdapter");
        Intrinsics.checkNotNullParameter(DBSleepDataAdapter, "DBSleepDataAdapter");
        Intrinsics.checkNotNullParameter(DBSleepHistoryDataAdapter, "DBSleepHistoryDataAdapter");
        Intrinsics.checkNotNullParameter(DBStandAdapter, "DBStandAdapter");
        Intrinsics.checkNotNullParameter(DBExerciseAdapter, "DBExerciseAdapter");
        Intrinsics.checkNotNullParameter(DBFitnessIndexAdapter, "DBFitnessIndexAdapter");
        Intrinsics.checkNotNullParameter(DBFitnessIndexProcessedAdapter, "DBFitnessIndexProcessedAdapter");
        Intrinsics.checkNotNullParameter(DBWristAdapter, "DBWristAdapter");
        Intrinsics.checkNotNullParameter(DBSpeedCalibrationAdapter, "DBSpeedCalibrationAdapter");
        Intrinsics.checkNotNullParameter(DBStressAdapter, "DBStressAdapter");
        Intrinsics.checkNotNullParameter(DBSessionDataAdapter, "DBSessionDataAdapter");
        Intrinsics.checkNotNullParameter(DBDeletedSessionsAdapter, "DBDeletedSessionsAdapter");
        Intrinsics.checkNotNullParameter(DBLocationDataAdapter, "DBLocationDataAdapter");
        Intrinsics.checkNotNullParameter(DBSessionAdapter, "DBSessionAdapter");
        Intrinsics.checkNotNullParameter(DBIntervalAdapter, "DBIntervalAdapter");
        Intrinsics.checkNotNullParameter(DBElevationAdapter, "DBElevationAdapter");
        Intrinsics.checkNotNullParameter(DBGoalAdapter, "DBGoalAdapter");
        Intrinsics.checkNotNullParameter(DBProfileAdapter, "DBProfileAdapter");
        Intrinsics.checkNotNullParameter(StravaPendingUploadsAdapter, "StravaPendingUploadsAdapter");
        this.DBActivityDataAdapter = DBActivityDataAdapter;
        this.DBHeartrateDataAdapter = DBHeartrateDataAdapter;
        this.DBDebugAdapter = DBDebugAdapter;
        this.DBDiagnosticsAdapter = DBDiagnosticsAdapter;
        this.DBPowerAdapter = DBPowerAdapter;
        this.DBRestingHeartrateDataAdapter = DBRestingHeartrateDataAdapter;
        this.DBSleepDataAdapter = DBSleepDataAdapter;
        this.DBSleepHistoryDataAdapter = DBSleepHistoryDataAdapter;
        this.DBStandAdapter = DBStandAdapter;
        this.DBExerciseAdapter = DBExerciseAdapter;
        this.DBFitnessIndexAdapter = DBFitnessIndexAdapter;
        this.DBFitnessIndexProcessedAdapter = DBFitnessIndexProcessedAdapter;
        this.DBWristAdapter = DBWristAdapter;
        this.DBSpeedCalibrationAdapter = DBSpeedCalibrationAdapter;
        this.DBStressAdapter = DBStressAdapter;
        this.DBSessionDataAdapter = DBSessionDataAdapter;
        this.DBDeletedSessionsAdapter = DBDeletedSessionsAdapter;
        this.DBLocationDataAdapter = DBLocationDataAdapter;
        this.DBSessionAdapter = DBSessionAdapter;
        this.DBIntervalAdapter = DBIntervalAdapter;
        this.DBElevationAdapter = DBElevationAdapter;
        this.DBGoalAdapter = DBGoalAdapter;
        this.DBProfileAdapter = DBProfileAdapter;
        this.StravaPendingUploadsAdapter = StravaPendingUploadsAdapter;
    }

    /* renamed from: cleanRejectedLocations-Y1s2hH8 */
    public final void m1284cleanRejectedLocationsY1s2hH8(final String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(411195508, "DELETE FROM DBLocationData WHERE hdid == ? AND accepted == 0", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$cleanRejectedLocations$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBLocationData.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBLocationDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
            }
        });
        notifyQueries(411195508, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$cleanRejectedLocations$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBLocationData");
            }
        });
    }

    public final void clearActivityData() {
        getDriver().execute(-1509465879, "DELETE FROM DBActivityData", null);
        notifyQueries(-1509465879, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearActivityData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBActivityData");
            }
        });
    }

    public final void clearDeletedSessions() {
        getDriver().execute(2026825798, "DELETE FROM DBDeletedSessions", null);
        notifyQueries(2026825798, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearDeletedSessions$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBDeletedSessions");
            }
        });
    }

    public final void clearElevation() {
        getDriver().execute(446623437, "DELETE FROM DBElevation", null);
        notifyQueries(446623437, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearElevation$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBElevation");
            }
        });
    }

    public final void clearExerciseData() {
        getDriver().execute(690348850, "DELETE FROM DBExercise", null);
        notifyQueries(690348850, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearExerciseData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBExercise");
            }
        });
    }

    public final void clearGoals() {
        getDriver().execute(1360190512, "DELETE FROM DBGoal", null);
        notifyQueries(1360190512, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearGoals$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBGoal");
            }
        });
    }

    public final void clearHeartrateData() {
        getDriver().execute(-1006660768, "DELETE FROM DBHeartrateData", null);
        notifyQueries(-1006660768, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearHeartrateData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBHeartrateData");
            }
        });
    }

    public final void clearInterval() {
        getDriver().execute(1554798165, "DELETE FROM DBInterval", null);
        notifyQueries(1554798165, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearInterval$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBInterval");
            }
        });
    }

    public final void clearLocationData() {
        getDriver().execute(1098402447, "DELETE FROM DBLocationData", null);
        notifyQueries(1098402447, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearLocationData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBLocationData");
            }
        });
    }

    public final void clearProfile() {
        getDriver().execute(969254425, "DELETE FROM DBProfile", null);
        notifyQueries(969254425, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearProfile$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBProfile");
            }
        });
    }

    public final void clearRestingHeartrateData() {
        getDriver().execute(1473531794, "DELETE FROM DBRestingHeartrateData", null);
        notifyQueries(1473531794, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearRestingHeartrateData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBRestingHeartrateData");
            }
        });
    }

    public final void clearSession() {
        getDriver().execute(-1031299322, "DELETE FROM DBSession", null);
        notifyQueries(-1031299322, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearSession$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSession");
            }
        });
    }

    public final void clearSessionData() {
        getDriver().execute(-401272880, "DELETE FROM DBSessionData", null);
        notifyQueries(-401272880, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearSessionData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSessionData");
            }
        });
    }

    public final void clearSleepData() {
        getDriver().execute(437784465, "DELETE FROM DBSleepData", null);
        notifyQueries(437784465, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearSleepData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSleepData");
            }
        });
    }

    public final void clearSleepHistoryData() {
        getDriver().execute(-1282843497, "DELETE FROM DBSleepHistoryData", null);
        notifyQueries(-1282843497, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearSleepHistoryData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSleepHistoryData");
            }
        });
    }

    public final void clearStandData() {
        getDriver().execute(-1808069360, "DELETE FROM DBStand", null);
        notifyQueries(-1808069360, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearStandData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBStand");
            }
        });
    }

    public final void clearStressData() {
        getDriver().execute(421792014, "DELETE FROM DBStress", null);
        notifyQueries(421792014, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearStressData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBStress");
            }
        });
    }

    public final void clearWristData() {
        getDriver().execute(-970589047, "DELETE FROM DBWrist", null);
        notifyQueries(-970589047, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$clearWristData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWrist");
            }
        });
    }

    /* renamed from: deleteElevation-cu7-zPM */
    public final void m1285deleteElevationcu7zPM(final String identifier, final long j) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(-1650626475, "DELETE FROM DBElevation\nWHERE hdid = ? AND session_timestamp = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteElevation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBElevation.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBElevationAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(identifier)));
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(-1650626475, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteElevation$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBElevation");
            }
        });
    }

    /* renamed from: deleteInterval-cu7-zPM */
    public final void m1286deleteIntervalcu7zPM(final String hdid, final long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(378766285, "DELETE FROM DBInterval\nWHERE hdid = ? AND session_timestamp = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteInterval$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBInterval.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBIntervalAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(378766285, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteInterval$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBInterval");
            }
        });
    }

    public final void deleteLocation(final long j) {
        getDriver().execute(1709391549, "DELETE FROM DBLocationData WHERE timestamp == ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteLocation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindLong(0, Long.valueOf(j));
            }
        });
        notifyQueries(1709391549, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteLocation$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBLocationData");
            }
        });
    }

    /* renamed from: deleteLocations-OZHprlw */
    public final void m1287deleteLocationsOZHprlw(final String identifier, final long j, final long j2) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(1451530582, "DELETE FROM DBLocationData\nWHERE hdid = ? AND timestamp >= ? AND timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteLocations$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBLocationData.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBLocationDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(identifier)));
                execute.bindLong(1, Long.valueOf(j));
                execute.bindLong(2, Long.valueOf(j2));
            }
        });
        notifyQueries(1451530582, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteLocations$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBLocationData");
            }
        });
    }

    public final void deleteProcessedDataAfter(final long j) {
        transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                SqlDriver driver = FitnessQueries.this.getDriver();
                final long j2 = j;
                driver.execute(-1750674851, "DELETE FROM DBSession WHERE start_timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j2));
                    }
                });
                SqlDriver driver2 = FitnessQueries.this.getDriver();
                final long j3 = j;
                driver2.execute(-1750674850, "DELETE FROM DBInterval WHERE session_timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j3));
                    }
                });
                SqlDriver driver3 = FitnessQueries.this.getDriver();
                final long j4 = j;
                driver3.execute(-1750674849, "DELETE FROM DBElevation WHERE session_timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j4));
                    }
                });
                SqlDriver driver4 = FitnessQueries.this.getDriver();
                final long j5 = j;
                driver4.execute(-1750674848, "DELETE FROM DBSleepHistoryData WHERE start >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j5));
                    }
                });
                SqlDriver driver5 = FitnessQueries.this.getDriver();
                final long j6 = j;
                driver5.execute(-1750674847, "DELETE FROM DBRestingHeartrateData WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j6));
                    }
                });
                SqlDriver driver6 = FitnessQueries.this.getDriver();
                final long j7 = j;
                driver6.execute(-1750674846, "DELETE FROM DBFitnessIndexProcessed WHERE session_timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j7));
                    }
                });
            }
        });
        notifyQueries(96502188, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataAfter$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBElevation");
                emit.invoke("DBFitnessIndexProcessed");
                emit.invoke("DBInterval");
                emit.invoke("DBRestingHeartrateData");
                emit.invoke("DBSession");
                emit.invoke("DBSleepHistoryData");
            }
        });
    }

    public final void deleteProcessedDataBefore(final long j) {
        transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                SqlDriver driver = FitnessQueries.this.getDriver();
                final long j2 = j;
                driver.execute(2027395488, "DELETE FROM DBSession WHERE start_timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j2));
                    }
                });
                SqlDriver driver2 = FitnessQueries.this.getDriver();
                final long j3 = j;
                driver2.execute(2027395489, "DELETE FROM DBInterval WHERE session_timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j3));
                    }
                });
                SqlDriver driver3 = FitnessQueries.this.getDriver();
                final long j4 = j;
                driver3.execute(2027395490, "DELETE FROM DBElevation WHERE session_timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j4));
                    }
                });
                SqlDriver driver4 = FitnessQueries.this.getDriver();
                final long j5 = j;
                driver4.execute(2027395491, "DELETE FROM DBSleepHistoryData WHERE start < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j5));
                    }
                });
                SqlDriver driver5 = FitnessQueries.this.getDriver();
                final long j6 = j;
                driver5.execute(2027395492, "DELETE FROM DBRestingHeartrateData WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j6));
                    }
                });
                SqlDriver driver6 = FitnessQueries.this.getDriver();
                final long j7 = j;
                driver6.execute(2027395493, "DELETE FROM DBFitnessIndexProcessed WHERE session_timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j7));
                    }
                });
            }
        });
        notifyQueries(-1276101201, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteProcessedDataBefore$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBElevation");
                emit.invoke("DBFitnessIndexProcessed");
                emit.invoke("DBInterval");
                emit.invoke("DBRestingHeartrateData");
                emit.invoke("DBSession");
                emit.invoke("DBSleepHistoryData");
            }
        });
    }

    public final void deleteRawDataAfter(final long j) {
        transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                SqlDriver driver = FitnessQueries.this.getDriver();
                final long j2 = j;
                driver.execute(-213082301, "DELETE FROM DBActivityData WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j2));
                    }
                });
                SqlDriver driver2 = FitnessQueries.this.getDriver();
                final long j3 = j;
                driver2.execute(-213082300, "DELETE FROM DBExercise WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j3));
                    }
                });
                SqlDriver driver3 = FitnessQueries.this.getDriver();
                final long j4 = j;
                driver3.execute(-213082299, "DELETE FROM DBFitnessIndex WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j4));
                    }
                });
                SqlDriver driver4 = FitnessQueries.this.getDriver();
                final long j5 = j;
                driver4.execute(-213082298, "DELETE FROM DBStress WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j5));
                    }
                });
                SqlDriver driver5 = FitnessQueries.this.getDriver();
                final long j6 = j;
                driver5.execute(-213082297, "DELETE FROM DBHeartrateData WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j6));
                    }
                });
                SqlDriver driver6 = FitnessQueries.this.getDriver();
                final long j7 = j;
                driver6.execute(-213082296, "DELETE FROM DBLocationData WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j7));
                    }
                });
                SqlDriver driver7 = FitnessQueries.this.getDriver();
                final long j8 = j;
                driver7.execute(-213082295, "DELETE FROM DBSessionData WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j8));
                    }
                });
                SqlDriver driver8 = FitnessQueries.this.getDriver();
                final long j9 = j;
                driver8.execute(-213082294, "DELETE FROM DBGoal WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j9));
                    }
                });
                SqlDriver driver9 = FitnessQueries.this.getDriver();
                final long j10 = j;
                driver9.execute(-213082293, "DELETE FROM DBSleepData WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j10));
                    }
                });
                SqlDriver driver10 = FitnessQueries.this.getDriver();
                final long j11 = j;
                driver10.execute(-213082292, "DELETE FROM DBStand WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j11));
                    }
                });
                SqlDriver driver11 = FitnessQueries.this.getDriver();
                final long j12 = j;
                driver11.execute(1984383340, "DELETE FROM DBWrist WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j12));
                    }
                });
                SqlDriver driver12 = FitnessQueries.this.getDriver();
                final long j13 = j;
                driver12.execute(1984383341, "DELETE FROM DBDebug WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j13));
                    }
                });
                SqlDriver driver13 = FitnessQueries.this.getDriver();
                final long j14 = j;
                driver13.execute(1984383342, "DELETE FROM DBDiagnostics WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j14));
                    }
                });
                SqlDriver driver14 = FitnessQueries.this.getDriver();
                final long j15 = j;
                driver14.execute(1984383343, "DELETE FROM DBPower WHERE timestamp >= ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$1.14
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j15));
                    }
                });
            }
        });
        notifyQueries(-98545646, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataAfter$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBActivityData");
                emit.invoke("DBDebug");
                emit.invoke("DBDiagnostics");
                emit.invoke("DBExercise");
                emit.invoke("DBFitnessIndex");
                emit.invoke("DBGoal");
                emit.invoke("DBHeartrateData");
                emit.invoke("DBLocationData");
                emit.invoke("DBPower");
                emit.invoke("DBSessionData");
                emit.invoke("DBSleepData");
                emit.invoke("DBStand");
                emit.invoke("DBStress");
                emit.invoke("DBWrist");
            }
        });
    }

    public final void deleteRawDataBefore(final long j) {
        transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                SqlDriver driver = FitnessQueries.this.getDriver();
                final long j2 = j;
                driver.execute(-1846843014, "DELETE FROM DBActivityData WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j2));
                    }
                });
                SqlDriver driver2 = FitnessQueries.this.getDriver();
                final long j3 = j;
                driver2.execute(-1846843013, "DELETE FROM DBExercise WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j3));
                    }
                });
                SqlDriver driver3 = FitnessQueries.this.getDriver();
                final long j4 = j;
                driver3.execute(-1846843012, "DELETE FROM DBFitnessIndex WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j4));
                    }
                });
                SqlDriver driver4 = FitnessQueries.this.getDriver();
                final long j5 = j;
                driver4.execute(-1846843011, "DELETE FROM DBStress WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j5));
                    }
                });
                SqlDriver driver5 = FitnessQueries.this.getDriver();
                final long j6 = j;
                driver5.execute(-1846843010, "DELETE FROM DBHeartrateData WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j6));
                    }
                });
                SqlDriver driver6 = FitnessQueries.this.getDriver();
                final long j7 = j;
                driver6.execute(-1846843009, "DELETE FROM DBLocationData WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j7));
                    }
                });
                SqlDriver driver7 = FitnessQueries.this.getDriver();
                final long j8 = j;
                driver7.execute(-1846843008, "DELETE FROM DBSessionData WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j8));
                    }
                });
                SqlDriver driver8 = FitnessQueries.this.getDriver();
                final long j9 = j;
                driver8.execute(-1846843007, "DELETE FROM DBGoal WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j9));
                    }
                });
                SqlDriver driver9 = FitnessQueries.this.getDriver();
                final long j10 = j;
                driver9.execute(-1846843006, "DELETE FROM DBSleepData WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j10));
                    }
                });
                SqlDriver driver10 = FitnessQueries.this.getDriver();
                final long j11 = j;
                driver10.execute(-1846843005, "DELETE FROM DBStand WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j11));
                    }
                });
                SqlDriver driver11 = FitnessQueries.this.getDriver();
                final long j12 = j;
                driver11.execute(-1417558507, "DELETE FROM DBWrist WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j12));
                    }
                });
                SqlDriver driver12 = FitnessQueries.this.getDriver();
                final long j13 = j;
                driver12.execute(-1417558506, "DELETE FROM DBDebug WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j13));
                    }
                });
                SqlDriver driver13 = FitnessQueries.this.getDriver();
                final long j14 = j;
                driver13.execute(-1417558505, "DELETE FROM DBDiagnostics WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j14));
                    }
                });
                SqlDriver driver14 = FitnessQueries.this.getDriver();
                final long j15 = j;
                driver14.execute(-1417558504, "DELETE FROM DBPower WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.14
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j15));
                    }
                });
                SqlDriver driver15 = FitnessQueries.this.getDriver();
                final long j16 = j;
                driver15.execute(-1417558503, "DELETE FROM DBSpeedCalibration WHERE timestamp < ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$1.15
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                        invoke2(sqlPreparedStatement);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SqlPreparedStatement execute) {
                        Intrinsics.checkNotNullParameter(execute, "$this$execute");
                        execute.bindLong(0, Long.valueOf(j16));
                    }
                });
            }
        });
        notifyQueries(1267350537, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteRawDataBefore$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBActivityData");
                emit.invoke("DBDebug");
                emit.invoke("DBDiagnostics");
                emit.invoke("DBExercise");
                emit.invoke("DBFitnessIndex");
                emit.invoke("DBGoal");
                emit.invoke("DBHeartrateData");
                emit.invoke("DBLocationData");
                emit.invoke("DBPower");
                emit.invoke("DBSessionData");
                emit.invoke("DBSleepData");
                emit.invoke("DBSpeedCalibration");
                emit.invoke("DBStand");
                emit.invoke("DBStress");
                emit.invoke("DBWrist");
            }
        });
    }

    /* renamed from: deleteSession-cu7-zPM */
    public final void m1288deleteSessioncu7zPM(final String hdid, final long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-792141170, "DELETE FROM DBSession\nWHERE hdid = ? AND start_timestamp == ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBSession.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBSessionAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(-792141170, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteSession$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSession");
            }
        });
    }

    /* renamed from: deleteSessionData-4i7cvns */
    public final void m1289deleteSessionData4i7cvns(final String identifier, final long j, final long j2, final long j3) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(-1518776488, "DELETE FROM DBSessionData\nWHERE hdid = ? AND ((timestamp >= ? AND timestamp <= ?) OR (session_id != -1 AND session_id == ?))", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteSessionData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBSessionData.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBSessionDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(identifier)));
                execute.bindLong(1, Long.valueOf(j));
                execute.bindLong(2, Long.valueOf(j2));
                execute.bindLong(3, Long.valueOf(j3));
            }
        });
        notifyQueries(-1518776488, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteSessionData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSessionData");
            }
        });
    }

    /* renamed from: deleteStravaPendingUpload-cu7-zPM */
    public final void m1290deleteStravaPendingUploadcu7zPM(final String hdid, final long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(979746613, "DELETE FROM StravaPendingUploads\nWHERE hdid = ? AND timestamp = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteStravaPendingUpload$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                StravaPendingUploads.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.StravaPendingUploadsAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(979746613, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$deleteStravaPendingUpload$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("StravaPendingUploads");
            }
        });
    }

    public final Query<Long> firstTimestamp() {
        return UrlKt.Query(-1125643133, new String[]{"DBActivityData", "DBHeartrateData", "DBSleepData", "DBStand", "DBSessionData", "DBLocationData", "DBStress", "DBExercise", "DBFitnessIndex", "DBWrist"}, getDriver(), "Fitness.sq", "firstTimestamp", "SELECT timestamp FROM DBActivityData\nUNION\nSELECT timestamp FROM DBHeartrateData\nUNION\nSELECT timestamp FROM DBSleepData\nUNION\nSELECT timestamp FROM DBStand\nUNION\nSELECT timestamp FROM DBSessionData\nUNION\nSELECT timestamp FROM DBLocationData\nUNION\nSELECT timestamp FROM DBStress\nUNION\nSELECT timestamp FROM DBExercise\nUNION\nSELECT timestamp FROM DBFitnessIndex\nUNION\nSELECT timestamp FROM DBWrist\nORDER BY timestamp ASC\nLIMIT 1", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$firstTimestamp$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final <T> Query<T> getActivityData(long j, long j2, final Function10<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetActivityDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getActivityData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBActivityData.Adapter adapter;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Float f;
                Integer num6;
                Integer num7;
                DBActivityData.Adapter adapter2;
                DBActivityData.Adapter adapter3;
                DBActivityData.Adapter adapter4;
                DBActivityData.Adapter adapter5;
                DBActivityData.Adapter adapter6;
                DBActivityData.Adapter adapter7;
                DBActivityData.Adapter adapter8;
                DBActivityData.Adapter adapter9;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, T> function10 = mapper;
                adapter = this.DBActivityDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter9 = fitnessQueries.DBActivityDataAdapter;
                    num = Integer.valueOf(adapter9.getActivity_classAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(3);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter8 = fitnessQueries2.DBActivityDataAdapter;
                    num2 = Integer.valueOf(adapter8.getWalk_stepsAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                Long l4 = cursor.getLong(4);
                if (l4 != null) {
                    FitnessQueries fitnessQueries3 = this;
                    long longValue3 = l4.longValue();
                    adapter7 = fitnessQueries3.DBActivityDataAdapter;
                    num3 = Integer.valueOf(adapter7.getRun_stepsAdapter().decode(Long.valueOf(longValue3)).intValue());
                } else {
                    num3 = null;
                }
                Long l5 = cursor.getLong(5);
                if (l5 != null) {
                    FitnessQueries fitnessQueries4 = this;
                    long longValue4 = l5.longValue();
                    adapter6 = fitnessQueries4.DBActivityDataAdapter;
                    num4 = Integer.valueOf(adapter6.getOther_stepsAdapter().decode(Long.valueOf(longValue4)).intValue());
                } else {
                    num4 = null;
                }
                Long l6 = cursor.getLong(6);
                if (l6 != null) {
                    FitnessQueries fitnessQueries5 = this;
                    long longValue5 = l6.longValue();
                    adapter5 = fitnessQueries5.DBActivityDataAdapter;
                    num5 = Integer.valueOf(adapter5.getRhythmic_steps_cadenceAdapter().decode(Long.valueOf(longValue5)).intValue());
                } else {
                    num5 = null;
                }
                Double d = cursor.getDouble(7);
                if (d != null) {
                    FitnessQueries fitnessQueries6 = this;
                    double doubleValue = d.doubleValue();
                    adapter4 = fitnessQueries6.DBActivityDataAdapter;
                    f = Float.valueOf(adapter4.getSpeedAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l7 = cursor.getLong(8);
                if (l7 != null) {
                    FitnessQueries fitnessQueries7 = this;
                    long longValue6 = l7.longValue();
                    adapter3 = fitnessQueries7.DBActivityDataAdapter;
                    num6 = Integer.valueOf(adapter3.getDistanceAdapter().decode(Long.valueOf(longValue6)).intValue());
                } else {
                    num6 = null;
                }
                Long l8 = cursor.getLong(9);
                if (l8 != null) {
                    FitnessQueries fitnessQueries8 = this;
                    long longValue7 = l8.longValue();
                    adapter2 = fitnessQueries8.DBActivityDataAdapter;
                    num7 = Integer.valueOf(adapter2.getCaloriesAdapter().decode(Long.valueOf(longValue7)).intValue());
                } else {
                    num7 = null;
                }
                return (T) function10.invoke(m, l, num, num2, num3, num4, num5, f, num6, num7);
            }
        });
    }

    /* renamed from: getActivityDataByIdentifierForWorkout-VAJrmyI */
    public final Query<DBActivityData> m1291getActivityDataByIdentifierForWorkoutVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1292getActivityDataByIdentifierForWorkoutW5HvN8Q(j, j2, hdid, new Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, DBActivityData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getActivityDataByIdentifierForWorkout$2
            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ DBActivityData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                return m1379invokehSv7xU0(historyDeviceId.m1562unboximpl(), l.longValue(), num, num2, num3, num4, num5, f, num6, num7);
            }

            /* renamed from: invoke-hSv7xU0, reason: not valid java name */
            public final DBActivityData m1379invokehSv7xU0(String hdid_, long j3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBActivityData(hdid_, j3, num, num2, num3, num4, num5, f, num6, num7, null);
            }
        });
    }

    /* renamed from: getActivityDataByIdentifierForWorkout-W5HvN8Q */
    public final <T> Query<T> m1292getActivityDataByIdentifierForWorkoutW5HvN8Q(long j, long j2, String hdid, final Function10<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetActivityDataByIdentifierForWorkoutQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getActivityDataByIdentifierForWorkout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBActivityData.Adapter adapter;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Float f;
                Integer num6;
                Integer num7;
                DBActivityData.Adapter adapter2;
                DBActivityData.Adapter adapter3;
                DBActivityData.Adapter adapter4;
                DBActivityData.Adapter adapter5;
                DBActivityData.Adapter adapter6;
                DBActivityData.Adapter adapter7;
                DBActivityData.Adapter adapter8;
                DBActivityData.Adapter adapter9;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, T> function10 = mapper;
                adapter = this.DBActivityDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter9 = fitnessQueries.DBActivityDataAdapter;
                    num = Integer.valueOf(adapter9.getActivity_classAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(3);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter8 = fitnessQueries2.DBActivityDataAdapter;
                    num2 = Integer.valueOf(adapter8.getWalk_stepsAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                Long l4 = cursor.getLong(4);
                if (l4 != null) {
                    FitnessQueries fitnessQueries3 = this;
                    long longValue3 = l4.longValue();
                    adapter7 = fitnessQueries3.DBActivityDataAdapter;
                    num3 = Integer.valueOf(adapter7.getRun_stepsAdapter().decode(Long.valueOf(longValue3)).intValue());
                } else {
                    num3 = null;
                }
                Long l5 = cursor.getLong(5);
                if (l5 != null) {
                    FitnessQueries fitnessQueries4 = this;
                    long longValue4 = l5.longValue();
                    adapter6 = fitnessQueries4.DBActivityDataAdapter;
                    num4 = Integer.valueOf(adapter6.getOther_stepsAdapter().decode(Long.valueOf(longValue4)).intValue());
                } else {
                    num4 = null;
                }
                Long l6 = cursor.getLong(6);
                if (l6 != null) {
                    FitnessQueries fitnessQueries5 = this;
                    long longValue5 = l6.longValue();
                    adapter5 = fitnessQueries5.DBActivityDataAdapter;
                    num5 = Integer.valueOf(adapter5.getRhythmic_steps_cadenceAdapter().decode(Long.valueOf(longValue5)).intValue());
                } else {
                    num5 = null;
                }
                Double d = cursor.getDouble(7);
                if (d != null) {
                    FitnessQueries fitnessQueries6 = this;
                    double doubleValue = d.doubleValue();
                    adapter4 = fitnessQueries6.DBActivityDataAdapter;
                    f = Float.valueOf(adapter4.getSpeedAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l7 = cursor.getLong(8);
                if (l7 != null) {
                    FitnessQueries fitnessQueries7 = this;
                    long longValue6 = l7.longValue();
                    adapter3 = fitnessQueries7.DBActivityDataAdapter;
                    num6 = Integer.valueOf(adapter3.getDistanceAdapter().decode(Long.valueOf(longValue6)).intValue());
                } else {
                    num6 = null;
                }
                Long l8 = cursor.getLong(9);
                if (l8 != null) {
                    FitnessQueries fitnessQueries8 = this;
                    long longValue7 = l8.longValue();
                    adapter2 = fitnessQueries8.DBActivityDataAdapter;
                    num7 = Integer.valueOf(adapter2.getCaloriesAdapter().decode(Long.valueOf(longValue7)).intValue());
                } else {
                    num7 = null;
                }
                return (T) function10.invoke(m, l, num, num2, num3, num4, num5, f, num6, num7);
            }
        }, null);
    }

    /* renamed from: getActivityDataForSession-VAJrmyI */
    public final Query<DBActivityData> m1293getActivityDataForSessionVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1294getActivityDataForSessionW5HvN8Q(j, j2, hdid, new Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, DBActivityData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getActivityDataForSession$2
            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ DBActivityData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                return m1380invokehSv7xU0(historyDeviceId.m1562unboximpl(), l.longValue(), num, num2, num3, num4, num5, f, num6, num7);
            }

            /* renamed from: invoke-hSv7xU0, reason: not valid java name */
            public final DBActivityData m1380invokehSv7xU0(String hdid_, long j3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBActivityData(hdid_, j3, num, num2, num3, num4, num5, f, num6, num7, null);
            }
        });
    }

    /* renamed from: getActivityDataForSession-W5HvN8Q */
    public final <T> Query<T> m1294getActivityDataForSessionW5HvN8Q(long j, long j2, String hdid, final Function10<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetActivityDataForSessionQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getActivityDataForSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBActivityData.Adapter adapter;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Float f;
                Integer num6;
                Integer num7;
                DBActivityData.Adapter adapter2;
                DBActivityData.Adapter adapter3;
                DBActivityData.Adapter adapter4;
                DBActivityData.Adapter adapter5;
                DBActivityData.Adapter adapter6;
                DBActivityData.Adapter adapter7;
                DBActivityData.Adapter adapter8;
                DBActivityData.Adapter adapter9;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, T> function10 = mapper;
                adapter = this.DBActivityDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter9 = fitnessQueries.DBActivityDataAdapter;
                    num = Integer.valueOf(adapter9.getActivity_classAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(3);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter8 = fitnessQueries2.DBActivityDataAdapter;
                    num2 = Integer.valueOf(adapter8.getWalk_stepsAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                Long l4 = cursor.getLong(4);
                if (l4 != null) {
                    FitnessQueries fitnessQueries3 = this;
                    long longValue3 = l4.longValue();
                    adapter7 = fitnessQueries3.DBActivityDataAdapter;
                    num3 = Integer.valueOf(adapter7.getRun_stepsAdapter().decode(Long.valueOf(longValue3)).intValue());
                } else {
                    num3 = null;
                }
                Long l5 = cursor.getLong(5);
                if (l5 != null) {
                    FitnessQueries fitnessQueries4 = this;
                    long longValue4 = l5.longValue();
                    adapter6 = fitnessQueries4.DBActivityDataAdapter;
                    num4 = Integer.valueOf(adapter6.getOther_stepsAdapter().decode(Long.valueOf(longValue4)).intValue());
                } else {
                    num4 = null;
                }
                Long l6 = cursor.getLong(6);
                if (l6 != null) {
                    FitnessQueries fitnessQueries5 = this;
                    long longValue5 = l6.longValue();
                    adapter5 = fitnessQueries5.DBActivityDataAdapter;
                    num5 = Integer.valueOf(adapter5.getRhythmic_steps_cadenceAdapter().decode(Long.valueOf(longValue5)).intValue());
                } else {
                    num5 = null;
                }
                Double d = cursor.getDouble(7);
                if (d != null) {
                    FitnessQueries fitnessQueries6 = this;
                    double doubleValue = d.doubleValue();
                    adapter4 = fitnessQueries6.DBActivityDataAdapter;
                    f = Float.valueOf(adapter4.getSpeedAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l7 = cursor.getLong(8);
                if (l7 != null) {
                    FitnessQueries fitnessQueries7 = this;
                    long longValue6 = l7.longValue();
                    adapter3 = fitnessQueries7.DBActivityDataAdapter;
                    num6 = Integer.valueOf(adapter3.getDistanceAdapter().decode(Long.valueOf(longValue6)).intValue());
                } else {
                    num6 = null;
                }
                Long l8 = cursor.getLong(9);
                if (l8 != null) {
                    FitnessQueries fitnessQueries8 = this;
                    long longValue7 = l8.longValue();
                    adapter2 = fitnessQueries8.DBActivityDataAdapter;
                    num7 = Integer.valueOf(adapter2.getCaloriesAdapter().decode(Long.valueOf(longValue7)).intValue());
                } else {
                    num7 = null;
                }
                return (T) function10.invoke(m, l, num, num2, num3, num4, num5, f, num6, num7);
            }
        }, null);
    }

    public final <T> Query<T> getAvgCaloriesPerMonth(long j, long j2, final Function2<? super Long, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetAvgCaloriesPerMonthQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getAvgCaloriesPerMonth$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Double, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return function2.invoke(l, cursor.getDouble(1));
            }
        });
    }

    public final <T> Query<T> getAvgStepsPerMonth(long j, long j2, final Function2<? super Long, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetAvgStepsPerMonthQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getAvgStepsPerMonth$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Double, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return function2.invoke(l, cursor.getDouble(1));
            }
        });
    }

    /* renamed from: getCurrentSessionData-2OocG74 */
    public final <T> Query<T> m1295getCurrentSessionData2OocG74(long j, String identifier, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Boolean, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetCurrentSessionDataQuery(this, j, identifier, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSessionData.Adapter adapter;
                DBSessionData.Adapter adapter2;
                Integer num;
                DBSessionData.Adapter adapter3;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Boolean, Long, T> function6 = mapper;
                adapter = this.DBSessionDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBSessionDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStateAdapter());
                Long l2 = cursor.getLong(3);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter3 = fitnessQueries.DBSessionDataAdapter;
                    num = Integer.valueOf(adapter3.getTypeAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Boolean bool = cursor.getBoolean(4);
                Long l3 = cursor.getLong(5);
                Intrinsics.checkNotNull(l3);
                return (T) function6.invoke(m, l, m2, num, bool, l3);
            }
        }, null);
    }

    /* renamed from: getCurrentSessionData-nDauRJo */
    public final Query<DBSessionData> m1296getCurrentSessionDatanDauRJo(long j, String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return m1295getCurrentSessionData2OocG74(j, identifier, new Function6<HistoryDeviceId, Long, Integer, Integer, Boolean, Long, DBSessionData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBSessionData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Boolean bool, Long l2) {
                return m1381invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2, bool, l2.longValue());
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBSessionData m1381invokeFGKXf14(String hdid, long j2, int r15, Integer num, Boolean bool, long j3) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSessionData(hdid, j2, r15, num, bool, j3, null);
            }
        });
    }

    public final <T> Query<T> getDebugData(long j, long j2, final Function4<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetDebugDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDebugData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBDebug.Adapter adapter;
                DBDebug.Adapter adapter2;
                DBDebug.Adapter adapter3;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function4<HistoryDeviceId, Long, Integer, Integer, T> function4 = mapper;
                adapter = this.DBDebugAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBDebugAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getTypeAdapter());
                adapter3 = this.DBDebugAdapter;
                return (T) function4.invoke(m, l, m2, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getValue_Adapter()));
            }
        });
    }

    public final Query<Long> getDeletedSessions() {
        return UrlKt.Query(1558853469, new String[]{"DBDeletedSessions"}, getDriver(), "Fitness.sq", "getDeletedSessions", "SELECT timestamp\nFROM DBDeletedSessions", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDeletedSessions$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final <T> Query<T> getDiagnosticsData(long j, long j2, final Function4<? super HistoryDeviceId, ? super Long, ? super String, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetDiagnosticsDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDiagnosticsData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBDiagnostics.Adapter adapter;
                DBDiagnostics.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function4<HistoryDeviceId, Long, String, Integer, T> function4 = mapper;
                adapter = this.DBDiagnosticsAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(2);
                Intrinsics.checkNotNull(string);
                adapter2 = this.DBDiagnosticsAdapter;
                return (T) function4.invoke(m, l, string, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter2.getValue_Adapter()));
            }
        });
    }

    public final <T> Query<T> getDistance(long j, long j2, final Function1<? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetDistanceQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDistance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                return mapper.invoke(cursor.getDouble(0));
            }
        });
    }

    /* renamed from: getDistanceByIdentifierForWorkout-VAJrmyI */
    public final Query<GetDistanceByIdentifierForWorkout> m1297getDistanceByIdentifierForWorkoutVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1298getDistanceByIdentifierForWorkoutW5HvN8Q(j, j2, hdid, new Function1<Double, GetDistanceByIdentifierForWorkout>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDistanceByIdentifierForWorkout$2
            @Override // kotlin.jvm.functions.Function1
            public final GetDistanceByIdentifierForWorkout invoke(Double d) {
                return new GetDistanceByIdentifierForWorkout(d);
            }
        });
    }

    /* renamed from: getDistanceByIdentifierForWorkout-W5HvN8Q */
    public final <T> Query<T> m1298getDistanceByIdentifierForWorkoutW5HvN8Q(long j, long j2, String hdid, final Function1<? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetDistanceByIdentifierForWorkoutQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDistanceByIdentifierForWorkout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                return mapper.invoke(cursor.getDouble(0));
            }
        }, null);
    }

    public final <T> Query<T> getElevationForSession(long j, final Function7<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Double, ? super Double, ? super Double, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetElevationForSessionQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getElevationForSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBElevation.Adapter adapter;
                DBElevation.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Integer, Double, Double, Double, Double, T> function7 = mapper;
                adapter = this.DBElevationAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBElevationAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getNumberAdapter());
                Double d = cursor.getDouble(3);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d2);
                Double d3 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d3);
                Double d4 = cursor.getDouble(6);
                Intrinsics.checkNotNull(d4);
                return (T) function7.invoke(m, l, m2, d, d2, d3, d4);
            }
        });
    }

    public final <T> Query<T> getExerciseData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetExerciseDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getExerciseData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBExercise.Adapter adapter;
                DBExercise.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBExerciseAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBExerciseAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getActive_minutesAdapter()));
            }
        });
    }

    public final <T> Query<T> getFirstHeartrateData(final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(-1217115847, new String[]{"DBHeartrateData"}, getDriver(), "Fitness.sq", "getFirstHeartrateData", "SELECT * FROM DBHeartrateData\nWHERE heartrate > 0\nORDER BY timestamp ASC\nLIMIT 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getFirstHeartrateData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Integer num;
                Integer num2;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, T> function6 = mapper;
                adapter = this.DBHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBHeartrateDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getHeartrateAdapter());
                adapter3 = this.DBHeartrateDataAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getConfidenceAdapter());
                Long l2 = cursor.getLong(4);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter5.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(5);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter4.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                return (T) function6.invoke(m, l, m2, m3, num, num2);
            }
        });
    }

    public final Query<Long> getFirstTimestampCalories() {
        return UrlKt.Query(1322275845, new String[]{"DBActivityData"}, getDriver(), "Fitness.sq", "getFirstTimestampCalories", "SELECT timestamp FROM DBActivityData\nWHERE calories IS NOT NULL AND calories > 0\nORDER BY timestamp ASC\nLIMIT 1", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getFirstTimestampCalories$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final <T> Query<T> getGoalForTimestamp(long j, final Function5<? super Long, ? super HistoryDeviceId, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetGoalForTimestampQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getGoalForTimestamp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBGoal.Adapter adapter;
                DBGoal.Adapter adapter2;
                DBGoal.Adapter adapter3;
                DBGoal.Adapter adapter4;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function5<Long, HistoryDeviceId, Integer, Integer, Integer, T> function5 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                adapter = this.DBGoalAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 1, adapter.getHdidAdapter());
                adapter2 = this.DBGoalAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStepsAdapter());
                adapter3 = this.DBGoalAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getStandAdapter());
                adapter4 = this.DBGoalAdapter;
                return (T) function5.invoke(l, m, m2, m3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter4.getExerciseAdapter()));
            }
        });
    }

    public final <T> Query<T> getHeartRateHistorySince(long j, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetHeartRateHistorySinceQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartRateHistorySince$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Integer num;
                Integer num2;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, T> function6 = mapper;
                adapter = this.DBHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBHeartrateDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getHeartrateAdapter());
                adapter3 = this.DBHeartrateDataAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getConfidenceAdapter());
                Long l2 = cursor.getLong(4);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter5.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(5);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter4.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                return (T) function6.invoke(m, l, m2, m3, num, num2);
            }
        });
    }

    public final <T> Query<T> getHeartrateData(long j, long j2, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetHeartrateDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Integer num;
                Integer num2;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, T> function6 = mapper;
                adapter = this.DBHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBHeartrateDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getHeartrateAdapter());
                adapter3 = this.DBHeartrateDataAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getConfidenceAdapter());
                Long l2 = cursor.getLong(4);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter5.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(5);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter4.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                return (T) function6.invoke(m, l, m2, m3, num, num2);
            }
        });
    }

    /* renamed from: getHeartrateDataByIdentifier-VAJrmyI */
    public final Query<DBHeartrateData> m1299getHeartrateDataByIdentifierVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1300getHeartrateDataByIdentifierW5HvN8Q(j, j2, hdid, new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, DBHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1390invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBHeartrateData m1390invokeFGKXf14(String hdid_, long j3, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBHeartrateData(hdid_, j3, r14, r15, num, num2, null);
            }
        });
    }

    /* renamed from: getHeartrateDataByIdentifier-W5HvN8Q */
    public final <T> Query<T> m1300getHeartrateDataByIdentifierW5HvN8Q(long j, long j2, String hdid, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetHeartrateDataByIdentifierQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Integer num;
                Integer num2;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, T> function6 = mapper;
                adapter = this.DBHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBHeartrateDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getHeartrateAdapter());
                adapter3 = this.DBHeartrateDataAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getConfidenceAdapter());
                Long l2 = cursor.getLong(4);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter5.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(5);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter4.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                return (T) function6.invoke(m, l, m2, m3, num, num2);
            }
        }, null);
    }

    /* renamed from: getHeartrateDataByIdentifierForWorkout-VAJrmyI */
    public final Query<DBHeartrateData> m1301getHeartrateDataByIdentifierForWorkoutVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1302getHeartrateDataByIdentifierForWorkoutW5HvN8Q(j, j2, hdid, new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, DBHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateDataByIdentifierForWorkout$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1391invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBHeartrateData m1391invokeFGKXf14(String hdid_, long j3, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBHeartrateData(hdid_, j3, r14, r15, num, num2, null);
            }
        });
    }

    /* renamed from: getHeartrateDataByIdentifierForWorkout-W5HvN8Q */
    public final <T> Query<T> m1302getHeartrateDataByIdentifierForWorkoutW5HvN8Q(long j, long j2, String hdid, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetHeartrateDataByIdentifierForWorkoutQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateDataByIdentifierForWorkout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Integer num;
                Integer num2;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, T> function6 = mapper;
                adapter = this.DBHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBHeartrateDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getHeartrateAdapter());
                adapter3 = this.DBHeartrateDataAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getConfidenceAdapter());
                Long l2 = cursor.getLong(4);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter5.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(5);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter4.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                return (T) function6.invoke(m, l, m2, m3, num, num2);
            }
        }, null);
    }

    /* renamed from: getHeartrateDataForSession-VAJrmyI */
    public final Query<DBHeartrateData> m1303getHeartrateDataForSessionVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1304getHeartrateDataForSessionW5HvN8Q(j, j2, hdid, new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, DBHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateDataForSession$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1392invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBHeartrateData m1392invokeFGKXf14(String hdid_, long j3, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBHeartrateData(hdid_, j3, r14, r15, num, num2, null);
            }
        });
    }

    /* renamed from: getHeartrateDataForSession-W5HvN8Q */
    public final <T> Query<T> m1304getHeartrateDataForSessionW5HvN8Q(long j, long j2, String hdid, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetHeartrateDataForSessionQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateDataForSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Integer num;
                Integer num2;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, T> function6 = mapper;
                adapter = this.DBHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBHeartrateDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getHeartrateAdapter());
                adapter3 = this.DBHeartrateDataAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getConfidenceAdapter());
                Long l2 = cursor.getLong(4);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter5.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(5);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter4.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                return (T) function6.invoke(m, l, m2, m3, num, num2);
            }
        }, null);
    }

    public final <T> Query<T> getHeartrateIntervaled(long j, long j2, long j3, final Function4<? super Long, ? super Integer, ? super Integer, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetHeartrateIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function4<Long, Integer, Integer, Double, T> function4 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(1);
                Integer num2 = null;
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter2 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter2.getHeartrateAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(2);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter.getHeartrateAdapter().decode(Long.valueOf(longValue2)).intValue());
                }
                return function4.invoke(l, num, num2, cursor.getDouble(3));
            }
        });
    }

    /* renamed from: getHeartrateMinMaxByIdentifier-VAJrmyI */
    public final Query<GetHeartrateMinMaxByIdentifier> m1305getHeartrateMinMaxByIdentifierVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1306getHeartrateMinMaxByIdentifierW5HvN8Q(j, j2, hdid, new Function2<Integer, Integer, GetHeartrateMinMaxByIdentifier>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateMinMaxByIdentifier$2
            @Override // kotlin.jvm.functions.Function2
            public final GetHeartrateMinMaxByIdentifier invoke(Integer num, Integer num2) {
                return new GetHeartrateMinMaxByIdentifier(num, num2);
            }
        });
    }

    /* renamed from: getHeartrateMinMaxByIdentifier-W5HvN8Q */
    public final <T> Query<T> m1306getHeartrateMinMaxByIdentifierW5HvN8Q(long j, long j2, String hdid, final Function2<? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetHeartrateMinMaxByIdentifierQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateMinMaxByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Integer, Integer, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Integer num2 = null;
                if (l != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l.longValue();
                    adapter2 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter2.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l2 = cursor.getLong(1);
                if (l2 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l2.longValue();
                    adapter = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                }
                return function2.invoke(num, num2);
            }
        }, null);
    }

    public final <T> Query<T> getIntervalsForSession(long j, final Function4<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetIntervalsForSessionQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getIntervalsForSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBInterval.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function4<HistoryDeviceId, Long, Long, Long, T> function4 = mapper;
                adapter = this.DBIntervalAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                return (T) function4.invoke(m, l, l2, l3);
            }
        });
    }

    public final <T> Query<T> getLastActivityData(final Function10<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(872374888, new String[]{"DBActivityData"}, getDriver(), "Fitness.sq", "getLastActivityData", "SELECT *\nFROM DBActivityData\nORDER BY timestamp DESC\nLIMIT 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastActivityData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBActivityData.Adapter adapter;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Float f;
                Integer num6;
                Integer num7;
                DBActivityData.Adapter adapter2;
                DBActivityData.Adapter adapter3;
                DBActivityData.Adapter adapter4;
                DBActivityData.Adapter adapter5;
                DBActivityData.Adapter adapter6;
                DBActivityData.Adapter adapter7;
                DBActivityData.Adapter adapter8;
                DBActivityData.Adapter adapter9;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, T> function10 = mapper;
                adapter = this.DBActivityDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter9 = fitnessQueries.DBActivityDataAdapter;
                    num = Integer.valueOf(adapter9.getActivity_classAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(3);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter8 = fitnessQueries2.DBActivityDataAdapter;
                    num2 = Integer.valueOf(adapter8.getWalk_stepsAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                Long l4 = cursor.getLong(4);
                if (l4 != null) {
                    FitnessQueries fitnessQueries3 = this;
                    long longValue3 = l4.longValue();
                    adapter7 = fitnessQueries3.DBActivityDataAdapter;
                    num3 = Integer.valueOf(adapter7.getRun_stepsAdapter().decode(Long.valueOf(longValue3)).intValue());
                } else {
                    num3 = null;
                }
                Long l5 = cursor.getLong(5);
                if (l5 != null) {
                    FitnessQueries fitnessQueries4 = this;
                    long longValue4 = l5.longValue();
                    adapter6 = fitnessQueries4.DBActivityDataAdapter;
                    num4 = Integer.valueOf(adapter6.getOther_stepsAdapter().decode(Long.valueOf(longValue4)).intValue());
                } else {
                    num4 = null;
                }
                Long l6 = cursor.getLong(6);
                if (l6 != null) {
                    FitnessQueries fitnessQueries5 = this;
                    long longValue5 = l6.longValue();
                    adapter5 = fitnessQueries5.DBActivityDataAdapter;
                    num5 = Integer.valueOf(adapter5.getRhythmic_steps_cadenceAdapter().decode(Long.valueOf(longValue5)).intValue());
                } else {
                    num5 = null;
                }
                Double d = cursor.getDouble(7);
                if (d != null) {
                    FitnessQueries fitnessQueries6 = this;
                    double doubleValue = d.doubleValue();
                    adapter4 = fitnessQueries6.DBActivityDataAdapter;
                    f = Float.valueOf(adapter4.getSpeedAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l7 = cursor.getLong(8);
                if (l7 != null) {
                    FitnessQueries fitnessQueries7 = this;
                    long longValue6 = l7.longValue();
                    adapter3 = fitnessQueries7.DBActivityDataAdapter;
                    num6 = Integer.valueOf(adapter3.getDistanceAdapter().decode(Long.valueOf(longValue6)).intValue());
                } else {
                    num6 = null;
                }
                Long l8 = cursor.getLong(9);
                if (l8 != null) {
                    FitnessQueries fitnessQueries8 = this;
                    long longValue7 = l8.longValue();
                    adapter2 = fitnessQueries8.DBActivityDataAdapter;
                    num7 = Integer.valueOf(adapter2.getCaloriesAdapter().decode(Long.valueOf(longValue7)).intValue());
                } else {
                    num7 = null;
                }
                return (T) function10.invoke(m, l, num, num2, num3, num4, num5, f, num6, num7);
            }
        });
    }

    /* renamed from: getLastLocationDataByIdentifier-2OocG74 */
    public final Query<DBLocationData> m1307getLastLocationDataByIdentifier2OocG74(long j, String hdid, long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1308getLastLocationDataByIdentifierkRTOawE(j, hdid, j2, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, DBLocationData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastLocationDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBLocationData invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1395invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBLocationData m1395invokeEBUUAns(String hdid_, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBLocationData(hdid_, j3, d, d2, f, d3, z, null);
            }
        });
    }

    /* renamed from: getLastLocationDataByIdentifier-kRTOawE */
    public final <T> Query<T> m1308getLastLocationDataByIdentifierkRTOawE(long j, String hdid, long j2, final Function7<? super HistoryDeviceId, ? super Long, ? super Double, ? super Double, ? super Float, ? super Double, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetLastLocationDataByIdentifierQuery(this, j, hdid, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastLocationDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, T> function7 = mapper;
                adapter = this.DBLocationDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(3);
                Intrinsics.checkNotNull(d2);
                adapter2 = this.DBLocationDataAdapter;
                ColumnAdapter<Float, Double> accuracyAdapter = adapter2.getAccuracyAdapter();
                Double d3 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d3);
                Float decode = accuracyAdapter.decode(d3);
                Double d4 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d4);
                Boolean bool = cursor.getBoolean(6);
                Intrinsics.checkNotNull(bool);
                return (T) function7.invoke(m, l, d, d2, decode, d4, bool);
            }
        }, null);
    }

    public final <T> Query<T> getLastProcessedFitnessIndex(final Function3<? super HistoryDeviceId, ? super Long, ? super Float, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(1415050249, new String[]{"DBFitnessIndexProcessed"}, getDriver(), "Fitness.sq", "getLastProcessedFitnessIndex", "SELECT *\nFROM DBFitnessIndexProcessed\nORDER BY session_timestamp DESC\nLIMIT 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastProcessedFitnessIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFitnessIndexProcessed.Adapter adapter;
                Float f;
                DBFitnessIndexProcessed.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Float, T> function3 = mapper;
                adapter = this.DBFitnessIndexProcessedAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                if (d != null) {
                    FitnessQueries fitnessQueries = this;
                    double doubleValue = d.doubleValue();
                    adapter2 = fitnessQueries.DBFitnessIndexProcessedAdapter;
                    f = Float.valueOf(adapter2.getProcessed_fitness_indexAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                return (T) function3.invoke(m, l, f);
            }
        });
    }

    /* renamed from: getLastRawLocationDataByIdentifier-2OocG74 */
    public final Query<DBLocationData> m1309getLastRawLocationDataByIdentifier2OocG74(long j, String hdid, long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1310getLastRawLocationDataByIdentifierkRTOawE(j, hdid, j2, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, DBLocationData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastRawLocationDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBLocationData invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1397invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBLocationData m1397invokeEBUUAns(String hdid_, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBLocationData(hdid_, j3, d, d2, f, d3, z, null);
            }
        });
    }

    /* renamed from: getLastRawLocationDataByIdentifier-kRTOawE */
    public final <T> Query<T> m1310getLastRawLocationDataByIdentifierkRTOawE(long j, String hdid, long j2, final Function7<? super HistoryDeviceId, ? super Long, ? super Double, ? super Double, ? super Float, ? super Double, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetLastRawLocationDataByIdentifierQuery(this, j, hdid, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastRawLocationDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, T> function7 = mapper;
                adapter = this.DBLocationDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(3);
                Intrinsics.checkNotNull(d2);
                adapter2 = this.DBLocationDataAdapter;
                ColumnAdapter<Float, Double> accuracyAdapter = adapter2.getAccuracyAdapter();
                Double d3 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d3);
                Float decode = accuracyAdapter.decode(d3);
                Double d4 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d4);
                Boolean bool = cursor.getBoolean(6);
                Intrinsics.checkNotNull(bool);
                return (T) function7.invoke(m, l, d, d2, decode, d4, bool);
            }
        }, null);
    }

    public final <T> Query<T> getLastRestingHeartrateHistoryEntry(final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(2073168805, new String[]{"DBRestingHeartrateData"}, getDriver(), "Fitness.sq", "getLastRestingHeartrateHistoryEntry", "SELECT * FROM DBRestingHeartrateData\nORDER BY timestamp DESC\nLIMIT 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastRestingHeartrateHistoryEntry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBRestingHeartrateData.Adapter adapter;
                DBRestingHeartrateData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBRestingHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBRestingHeartrateDataAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getRestingHeartrateAdapter()));
            }
        });
    }

    public final Query<Long> getLastSessionFitnessIndexTimestamp() {
        return UrlKt.Query(-1417315195, new String[]{"DBSession"}, getDriver(), "Fitness.sq", "getLastSessionFitnessIndexTimestamp", "SELECT start_timestamp\nFROM DBSession WHERE fitness_index IS NOT NULL\nORDER BY start_timestamp DESC LIMIT 1", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastSessionFitnessIndexTimestamp$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final Query<Long> getLastSessionTimestamp() {
        return UrlKt.Query(-568567121, new String[]{"DBSession"}, getDriver(), "Fitness.sq", "getLastSessionTimestamp", "SELECT end_timestamp\nFROM DBSession\nORDER BY start_timestamp DESC LIMIT 1", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastSessionTimestamp$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    /* renamed from: getLatestHeartrateDataByIdentifier-Y1s2hH8 */
    public final Query<DBHeartrateData> m1311getLatestHeartrateDataByIdentifierY1s2hH8(String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1312getLatestHeartrateDataByIdentifiercu7zPM(hdid, new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, DBHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLatestHeartrateDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1399invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBHeartrateData m1399invokeFGKXf14(String hdid_, long j, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBHeartrateData(hdid_, j, r14, r15, num, num2, null);
            }
        });
    }

    /* renamed from: getLatestHeartrateDataByIdentifier-cu7-zPM */
    public final <T> Query<T> m1312getLatestHeartrateDataByIdentifiercu7zPM(String hdid, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetLatestHeartrateDataByIdentifierQuery(this, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLatestHeartrateDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Integer num;
                Integer num2;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, T> function6 = mapper;
                adapter = this.DBHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBHeartrateDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getHeartrateAdapter());
                adapter3 = this.DBHeartrateDataAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getConfidenceAdapter());
                Long l2 = cursor.getLong(4);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    num = Integer.valueOf(adapter5.getHeartrate_lowAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(5);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    num2 = Integer.valueOf(adapter4.getHeartrate_highAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                return (T) function6.invoke(m, l, m2, m3, num, num2);
            }
        }, null);
    }

    public final <T> Query<T> getLatestSpeedCalibrationData(final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(1152994733, new String[]{"DBSpeedCalibration"}, getDriver(), "Fitness.sq", "getLatestSpeedCalibrationData", "SELECT * FROM DBSpeedCalibration\nORDER BY timestamp DESC LIMIT 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLatestSpeedCalibrationData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSpeedCalibration.Adapter adapter;
                DBSpeedCalibration.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBSpeedCalibrationAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBSpeedCalibrationAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getCoefficientAdapter()));
            }
        });
    }

    /* renamed from: getLatestTimestamp-Y1s2hH8 */
    public final Query<Long> m1313getLatestTimestampY1s2hH8(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new GetLatestTimestampQuery(this, identifier, new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLatestTimestamp$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        }, null);
    }

    public final <T> Query<T> getLocationData(long j, long j2, final Function7<? super HistoryDeviceId, ? super Long, ? super Double, ? super Double, ? super Float, ? super Double, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetLocationDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLocationData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, T> function7 = mapper;
                adapter = this.DBLocationDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(3);
                Intrinsics.checkNotNull(d2);
                adapter2 = this.DBLocationDataAdapter;
                ColumnAdapter<Float, Double> accuracyAdapter = adapter2.getAccuracyAdapter();
                Double d3 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d3);
                Float decode = accuracyAdapter.decode(d3);
                Double d4 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d4);
                Boolean bool = cursor.getBoolean(6);
                Intrinsics.checkNotNull(bool);
                return (T) function7.invoke(m, l, d, d2, decode, d4, bool);
            }
        });
    }

    /* renamed from: getLocationDataByIdentifier-VAJrmyI */
    public final Query<DBLocationData> m1314getLocationDataByIdentifierVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1315getLocationDataByIdentifierW5HvN8Q(j, j2, hdid, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, DBLocationData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLocationDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBLocationData invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1402invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBLocationData m1402invokeEBUUAns(String hdid_, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBLocationData(hdid_, j3, d, d2, f, d3, z, null);
            }
        });
    }

    /* renamed from: getLocationDataByIdentifier-W5HvN8Q */
    public final <T> Query<T> m1315getLocationDataByIdentifierW5HvN8Q(long j, long j2, String hdid, final Function7<? super HistoryDeviceId, ? super Long, ? super Double, ? super Double, ? super Float, ? super Double, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetLocationDataByIdentifierQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLocationDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, T> function7 = mapper;
                adapter = this.DBLocationDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(3);
                Intrinsics.checkNotNull(d2);
                adapter2 = this.DBLocationDataAdapter;
                ColumnAdapter<Float, Double> accuracyAdapter = adapter2.getAccuracyAdapter();
                Double d3 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d3);
                Float decode = accuracyAdapter.decode(d3);
                Double d4 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d4);
                Boolean bool = cursor.getBoolean(6);
                Intrinsics.checkNotNull(bool);
                return (T) function7.invoke(m, l, d, d2, decode, d4, bool);
            }
        }, null);
    }

    /* renamed from: getLocationsDataForSession-VAJrmyI */
    public final Query<DBLocationData> m1316getLocationsDataForSessionVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1317getLocationsDataForSessionW5HvN8Q(j, j2, hdid, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, DBLocationData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLocationsDataForSession$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBLocationData invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1403invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBLocationData m1403invokeEBUUAns(String hdid_, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBLocationData(hdid_, j3, d, d2, f, d3, z, null);
            }
        });
    }

    /* renamed from: getLocationsDataForSession-W5HvN8Q */
    public final <T> Query<T> m1317getLocationsDataForSessionW5HvN8Q(long j, long j2, String hdid, final Function7<? super HistoryDeviceId, ? super Long, ? super Double, ? super Double, ? super Float, ? super Double, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetLocationsDataForSessionQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLocationsDataForSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, T> function7 = mapper;
                adapter = this.DBLocationDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(3);
                Intrinsics.checkNotNull(d2);
                adapter2 = this.DBLocationDataAdapter;
                ColumnAdapter<Float, Double> accuracyAdapter = adapter2.getAccuracyAdapter();
                Double d3 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d3);
                Float decode = accuracyAdapter.decode(d3);
                Double d4 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d4);
                Boolean bool = cursor.getBoolean(6);
                Intrinsics.checkNotNull(bool);
                return (T) function7.invoke(m, l, d, d2, decode, d4, bool);
            }
        }, null);
    }

    public final <T> Query<T> getMissingProcessedFitnessIndexes(final Function2<? super HistoryDeviceId, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(700991033, new String[]{"DBSession", "DBFitnessIndexProcessed"}, getDriver(), "Fitness.sq", "getMissingProcessedFitnessIndexes", "SELECT DBSession.hdid, start_timestamp\nFROM DBSession\nLEFT JOIN DBFitnessIndexProcessed ON DBSession.start_timestamp == DBFitnessIndexProcessed.session_timestamp\nWHERE DBSession.fitness_index IS NOT NULL AND DBFitnessIndexProcessed.session_timestamp IS NULL", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getMissingProcessedFitnessIndexes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSession.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<HistoryDeviceId, Long, T> function2 = mapper;
                adapter = this.DBSessionAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                return (T) function2.invoke(m, l);
            }
        });
    }

    public final <T> Query<T> getPowerData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetPowerDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getPowerData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBPower.Adapter adapter;
                DBPower.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBPowerAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBPowerAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStateAdapter()));
            }
        });
    }

    /* renamed from: getPowerDataByIdentifier-VAJrmyI */
    public final Query<DBPower> m1318getPowerDataByIdentifierVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1319getPowerDataByIdentifierW5HvN8Q(j, j2, hdid, new Function3<HistoryDeviceId, Long, Integer, DBPower>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getPowerDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBPower invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1406invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBPower m1406invokeOZHprlw(String hdid_, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBPower(hdid_, j3, r11, null);
            }
        });
    }

    /* renamed from: getPowerDataByIdentifier-W5HvN8Q */
    public final <T> Query<T> m1319getPowerDataByIdentifierW5HvN8Q(long j, long j2, String hdid, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetPowerDataByIdentifierQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getPowerDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBPower.Adapter adapter;
                DBPower.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBPowerAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBPowerAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStateAdapter()));
            }
        }, null);
    }

    public final <T> Query<T> getProcessedFitnessIndexIntervaled(long j, long j2, long j3, final Function2<? super Long, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetProcessedFitnessIndexIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getProcessedFitnessIndexIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Double, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return function2.invoke(l, cursor.getDouble(1));
            }
        });
    }

    public final <T> Query<T> getProfileForTimestamp(long j, final Function9<? super Long, ? super Integer, ? super Integer, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetProfileForTimestampQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getProfileForTimestamp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Integer num6;
                Integer num7;
                DBProfile.Adapter adapter;
                DBProfile.Adapter adapter2;
                DBProfile.Adapter adapter3;
                DBProfile.Adapter adapter4;
                DBProfile.Adapter adapter5;
                DBProfile.Adapter adapter6;
                DBProfile.Adapter adapter7;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function9<Long, Integer, Integer, Long, Integer, Integer, Integer, Integer, Integer, T> function9 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(1);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter7 = fitnessQueries.DBProfileAdapter;
                    num = Integer.valueOf(adapter7.getHeightAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(2);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter6 = fitnessQueries2.DBProfileAdapter;
                    num2 = Integer.valueOf(adapter6.getWeightAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                Long l4 = cursor.getLong(3);
                Long l5 = cursor.getLong(4);
                if (l5 != null) {
                    FitnessQueries fitnessQueries3 = this;
                    long longValue3 = l5.longValue();
                    adapter5 = fitnessQueries3.DBProfileAdapter;
                    num3 = Integer.valueOf(adapter5.getGenderAdapter().decode(Long.valueOf(longValue3)).intValue());
                } else {
                    num3 = null;
                }
                Long l6 = cursor.getLong(5);
                if (l6 != null) {
                    FitnessQueries fitnessQueries4 = this;
                    long longValue4 = l6.longValue();
                    adapter4 = fitnessQueries4.DBProfileAdapter;
                    num4 = Integer.valueOf(adapter4.getMeasurementAdapter().decode(Long.valueOf(longValue4)).intValue());
                } else {
                    num4 = null;
                }
                Long l7 = cursor.getLong(6);
                if (l7 != null) {
                    FitnessQueries fitnessQueries5 = this;
                    long longValue5 = l7.longValue();
                    adapter3 = fitnessQueries5.DBProfileAdapter;
                    num5 = Integer.valueOf(adapter3.getTemperatureAdapter().decode(Long.valueOf(longValue5)).intValue());
                } else {
                    num5 = null;
                }
                Long l8 = cursor.getLong(7);
                if (l8 != null) {
                    FitnessQueries fitnessQueries6 = this;
                    long longValue6 = l8.longValue();
                    adapter2 = fitnessQueries6.DBProfileAdapter;
                    num6 = Integer.valueOf(adapter2.getBedtime_hourAdapter().decode(Long.valueOf(longValue6)).intValue());
                } else {
                    num6 = null;
                }
                Long l9 = cursor.getLong(8);
                if (l9 != null) {
                    FitnessQueries fitnessQueries7 = this;
                    long longValue7 = l9.longValue();
                    adapter = fitnessQueries7.DBProfileAdapter;
                    num7 = Integer.valueOf(adapter.getBedtime_minAdapter().decode(Long.valueOf(longValue7)).intValue());
                } else {
                    num7 = null;
                }
                return function9.invoke(l, num, num2, l4, num3, num4, num5, num6, num7);
            }
        });
    }

    public final <T> Query<T> getProfilesInInterval(long j, long j2, final Function9<? super Long, ? super Integer, ? super Integer, ? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetProfilesInIntervalQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getProfilesInInterval$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Integer num6;
                Integer num7;
                DBProfile.Adapter adapter;
                DBProfile.Adapter adapter2;
                DBProfile.Adapter adapter3;
                DBProfile.Adapter adapter4;
                DBProfile.Adapter adapter5;
                DBProfile.Adapter adapter6;
                DBProfile.Adapter adapter7;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function9<Long, Integer, Integer, Long, Integer, Integer, Integer, Integer, Integer, T> function9 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(1);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter7 = fitnessQueries.DBProfileAdapter;
                    num = Integer.valueOf(adapter7.getHeightAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l3 = cursor.getLong(2);
                if (l3 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue2 = l3.longValue();
                    adapter6 = fitnessQueries2.DBProfileAdapter;
                    num2 = Integer.valueOf(adapter6.getWeightAdapter().decode(Long.valueOf(longValue2)).intValue());
                } else {
                    num2 = null;
                }
                Long l4 = cursor.getLong(3);
                Long l5 = cursor.getLong(4);
                if (l5 != null) {
                    FitnessQueries fitnessQueries3 = this;
                    long longValue3 = l5.longValue();
                    adapter5 = fitnessQueries3.DBProfileAdapter;
                    num3 = Integer.valueOf(adapter5.getGenderAdapter().decode(Long.valueOf(longValue3)).intValue());
                } else {
                    num3 = null;
                }
                Long l6 = cursor.getLong(5);
                if (l6 != null) {
                    FitnessQueries fitnessQueries4 = this;
                    long longValue4 = l6.longValue();
                    adapter4 = fitnessQueries4.DBProfileAdapter;
                    num4 = Integer.valueOf(adapter4.getMeasurementAdapter().decode(Long.valueOf(longValue4)).intValue());
                } else {
                    num4 = null;
                }
                Long l7 = cursor.getLong(6);
                if (l7 != null) {
                    FitnessQueries fitnessQueries5 = this;
                    long longValue5 = l7.longValue();
                    adapter3 = fitnessQueries5.DBProfileAdapter;
                    num5 = Integer.valueOf(adapter3.getTemperatureAdapter().decode(Long.valueOf(longValue5)).intValue());
                } else {
                    num5 = null;
                }
                Long l8 = cursor.getLong(7);
                if (l8 != null) {
                    FitnessQueries fitnessQueries6 = this;
                    long longValue6 = l8.longValue();
                    adapter2 = fitnessQueries6.DBProfileAdapter;
                    num6 = Integer.valueOf(adapter2.getBedtime_hourAdapter().decode(Long.valueOf(longValue6)).intValue());
                } else {
                    num6 = null;
                }
                Long l9 = cursor.getLong(8);
                if (l9 != null) {
                    FitnessQueries fitnessQueries7 = this;
                    long longValue7 = l9.longValue();
                    adapter = fitnessQueries7.DBProfileAdapter;
                    num7 = Integer.valueOf(adapter.getBedtime_minAdapter().decode(Long.valueOf(longValue7)).intValue());
                } else {
                    num7 = null;
                }
                return function9.invoke(l, num, num2, l4, num3, num4, num5, num6, num7);
            }
        });
    }

    public final <T> Query<T> getRawFitnessIndexData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Float, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetRawFitnessIndexDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawFitnessIndexData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFitnessIndex.Adapter adapter;
                DBFitnessIndex.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Float, T> function3 = mapper;
                adapter = this.DBFitnessIndexAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBFitnessIndexAdapter;
                ColumnAdapter<Float, Double> fitness_indexAdapter = adapter2.getFitness_indexAdapter();
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                return (T) function3.invoke(m, l, fitness_indexAdapter.decode(d));
            }
        });
    }

    /* renamed from: getRawFitnessIndexForSession-VAJrmyI */
    public final Query<DBFitnessIndex> m1320getRawFitnessIndexForSessionVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1321getRawFitnessIndexForSessionW5HvN8Q(j, j2, hdid, new Function3<HistoryDeviceId, Long, Float, DBFitnessIndex>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawFitnessIndexForSession$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBFitnessIndex invoke(HistoryDeviceId historyDeviceId, Long l, Float f) {
                return m1408invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), f.floatValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBFitnessIndex m1408invokeOZHprlw(String hdid_, long j3, float f) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBFitnessIndex(hdid_, j3, f, null);
            }
        });
    }

    /* renamed from: getRawFitnessIndexForSession-W5HvN8Q */
    public final <T> Query<T> m1321getRawFitnessIndexForSessionW5HvN8Q(long j, long j2, String hdid, final Function3<? super HistoryDeviceId, ? super Long, ? super Float, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetRawFitnessIndexForSessionQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawFitnessIndexForSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFitnessIndex.Adapter adapter;
                DBFitnessIndex.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Float, T> function3 = mapper;
                adapter = this.DBFitnessIndexAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBFitnessIndexAdapter;
                ColumnAdapter<Float, Double> fitness_indexAdapter = adapter2.getFitness_indexAdapter();
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                return (T) function3.invoke(m, l, fitness_indexAdapter.decode(d));
            }
        }, null);
    }

    public final <T> Query<T> getRawHRAndActivty(long j, long j2, final Function4<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        if (SetsKt__SetsKt.setOf((Object[]) new ColumnAdapter[]{this.DBHeartrateDataAdapter.getHdidAdapter(), this.DBActivityDataAdapter.getHdidAdapter()}).size() == 1) {
            return new GetRawHRAndActivtyQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawHRAndActivty$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final T invoke(SqlCursor cursor) {
                    DBHeartrateData.Adapter adapter;
                    Integer num;
                    DBActivityData.Adapter adapter2;
                    DBHeartrateData.Adapter adapter3;
                    Intrinsics.checkNotNullParameter(cursor, "cursor");
                    Function4<HistoryDeviceId, Long, Integer, Integer, T> function4 = mapper;
                    adapter = this.DBHeartrateDataAdapter;
                    Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                    Long l = cursor.getLong(1);
                    Intrinsics.checkNotNull(l);
                    Long l2 = cursor.getLong(2);
                    Integer num2 = null;
                    if (l2 != null) {
                        FitnessQueries fitnessQueries = this;
                        long longValue = l2.longValue();
                        adapter3 = fitnessQueries.DBHeartrateDataAdapter;
                        num = Integer.valueOf(adapter3.getHeartrateAdapter().decode(Long.valueOf(longValue)).intValue());
                    } else {
                        num = null;
                    }
                    Long l3 = cursor.getLong(3);
                    if (l3 != null) {
                        FitnessQueries fitnessQueries2 = this;
                        long longValue2 = l3.longValue();
                        adapter2 = fitnessQueries2.DBActivityDataAdapter;
                        num2 = Integer.valueOf(adapter2.getActivity_classAdapter().decode(Long.valueOf(longValue2)).intValue());
                    }
                    return (T) function4.invoke(m, l, num, num2);
                }
            });
        }
        throw new IllegalStateException("Adapter types are expected to be identical.".toString());
    }

    public final <T> Query<T> getRawLocationData(long j, long j2, final Function7<? super HistoryDeviceId, ? super Long, ? super Double, ? super Double, ? super Float, ? super Double, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetRawLocationDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawLocationData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, T> function7 = mapper;
                adapter = this.DBLocationDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(3);
                Intrinsics.checkNotNull(d2);
                adapter2 = this.DBLocationDataAdapter;
                ColumnAdapter<Float, Double> accuracyAdapter = adapter2.getAccuracyAdapter();
                Double d3 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d3);
                Float decode = accuracyAdapter.decode(d3);
                Double d4 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d4);
                Boolean bool = cursor.getBoolean(6);
                Intrinsics.checkNotNull(bool);
                return (T) function7.invoke(m, l, d, d2, decode, d4, bool);
            }
        });
    }

    /* renamed from: getRawLocationDataByIdentifier-VAJrmyI */
    public final Query<DBLocationData> m1322getRawLocationDataByIdentifierVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1323getRawLocationDataByIdentifierW5HvN8Q(j, j2, hdid, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, DBLocationData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawLocationDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBLocationData invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1411invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBLocationData m1411invokeEBUUAns(String hdid_, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBLocationData(hdid_, j3, d, d2, f, d3, z, null);
            }
        });
    }

    /* renamed from: getRawLocationDataByIdentifier-W5HvN8Q */
    public final <T> Query<T> m1323getRawLocationDataByIdentifierW5HvN8Q(long j, long j2, String hdid, final Function7<? super HistoryDeviceId, ? super Long, ? super Double, ? super Double, ? super Float, ? super Double, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetRawLocationDataByIdentifierQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawLocationDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, T> function7 = mapper;
                adapter = this.DBLocationDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(2);
                Intrinsics.checkNotNull(d);
                Double d2 = cursor.getDouble(3);
                Intrinsics.checkNotNull(d2);
                adapter2 = this.DBLocationDataAdapter;
                ColumnAdapter<Float, Double> accuracyAdapter = adapter2.getAccuracyAdapter();
                Double d3 = cursor.getDouble(4);
                Intrinsics.checkNotNull(d3);
                Float decode = accuracyAdapter.decode(d3);
                Double d4 = cursor.getDouble(5);
                Intrinsics.checkNotNull(d4);
                Boolean bool = cursor.getBoolean(6);
                Intrinsics.checkNotNull(bool);
                return (T) function7.invoke(m, l, d, d2, decode, d4, bool);
            }
        }, null);
    }

    public final Query<Float> getRelevantSessionFitnessIndexData(long j) {
        return new GetRelevantSessionFitnessIndexDataQuery(this, j, new Function1<SqlCursor, Float>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRelevantSessionFitnessIndexData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(SqlCursor cursor) {
                DBSession.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                adapter = FitnessQueries.this.DBSessionAdapter;
                ColumnAdapter<Float, Double> fitness_indexAdapter = adapter.getFitness_indexAdapter();
                Double d = cursor.getDouble(0);
                Intrinsics.checkNotNull(d);
                return fitness_indexAdapter.decode(d);
            }
        });
    }

    public final <T> Query<T> getRestingHeartrateData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetRestingHeartrateDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRestingHeartrateData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBRestingHeartrateData.Adapter adapter;
                DBRestingHeartrateData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBRestingHeartrateDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBRestingHeartrateDataAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getRestingHeartrateAdapter()));
            }
        });
    }

    public final <T> Query<T> getRestingHeartrateIntervaled(long j, long j2, long j3, final Function2<? super Long, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetRestingHeartrateIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRestingHeartrateIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Double, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return function2.invoke(l, cursor.getDouble(1));
            }
        });
    }

    public final <T> Query<T> getSession(long j, final Function14<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? super Double, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Boolean, ? super Long, ? super Float, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSessionQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSession.Adapter adapter;
                DBSession.Adapter adapter2;
                DBSession.Adapter adapter3;
                DBSession.Adapter adapter4;
                DBSession.Adapter adapter5;
                Float f;
                Integer num;
                DBSession.Adapter adapter6;
                DBSession.Adapter adapter7;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function14<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, T> function14 = mapper;
                adapter = this.DBSessionAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                Double d = cursor.getDouble(5);
                Intrinsics.checkNotNull(d);
                adapter2 = this.DBSessionAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 6, adapter2.getStepsAdapter());
                adapter3 = this.DBSessionAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 7, adapter3.getCaloriesAdapter());
                adapter4 = this.DBSessionAdapter;
                Object m4 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 8, adapter4.getElevationGainAdapter());
                adapter5 = this.DBSessionAdapter;
                Object m5 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 9, adapter5.getTypeAdapter());
                Boolean bool = cursor.getBoolean(10);
                Intrinsics.checkNotNull(bool);
                Long l5 = cursor.getLong(11);
                Intrinsics.checkNotNull(l5);
                Double d2 = cursor.getDouble(12);
                if (d2 != null) {
                    FitnessQueries fitnessQueries = this;
                    double doubleValue = d2.doubleValue();
                    adapter7 = fitnessQueries.DBSessionAdapter;
                    f = Float.valueOf(adapter7.getFitness_indexAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l6 = cursor.getLong(13);
                if (l6 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue = l6.longValue();
                    adapter6 = fitnessQueries2.DBSessionAdapter;
                    num = Integer.valueOf(adapter6.getStatusAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return (T) function14.invoke(m, l, l2, l3, l4, d, m2, m3, m4, m5, bool, l5, f, num);
            }
        });
    }

    public final <T> Query<T> getSessionData(long j, long j2, final Function6<? super HistoryDeviceId, ? super Long, ? super Integer, ? super Integer, ? super Boolean, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSessionDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessionData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSessionData.Adapter adapter;
                DBSessionData.Adapter adapter2;
                Integer num;
                DBSessionData.Adapter adapter3;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<HistoryDeviceId, Long, Integer, Integer, Boolean, Long, T> function6 = mapper;
                adapter = this.DBSessionDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBSessionDataAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStateAdapter());
                Long l2 = cursor.getLong(3);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter3 = fitnessQueries.DBSessionDataAdapter;
                    num = Integer.valueOf(adapter3.getTypeAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Boolean bool = cursor.getBoolean(4);
                Long l3 = cursor.getLong(5);
                Intrinsics.checkNotNull(l3);
                return (T) function6.invoke(m, l, m2, num, bool, l3);
            }
        });
    }

    public final <T> Query<T> getSessions(long j, long j2, final Function14<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? super Double, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Boolean, ? super Long, ? super Float, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSessionsQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSession.Adapter adapter;
                DBSession.Adapter adapter2;
                DBSession.Adapter adapter3;
                DBSession.Adapter adapter4;
                DBSession.Adapter adapter5;
                Float f;
                Integer num;
                DBSession.Adapter adapter6;
                DBSession.Adapter adapter7;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function14<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, T> function14 = mapper;
                adapter = this.DBSessionAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                Double d = cursor.getDouble(5);
                Intrinsics.checkNotNull(d);
                adapter2 = this.DBSessionAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 6, adapter2.getStepsAdapter());
                adapter3 = this.DBSessionAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 7, adapter3.getCaloriesAdapter());
                adapter4 = this.DBSessionAdapter;
                Object m4 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 8, adapter4.getElevationGainAdapter());
                adapter5 = this.DBSessionAdapter;
                Object m5 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 9, adapter5.getTypeAdapter());
                Boolean bool = cursor.getBoolean(10);
                Intrinsics.checkNotNull(bool);
                Long l5 = cursor.getLong(11);
                Intrinsics.checkNotNull(l5);
                Double d2 = cursor.getDouble(12);
                if (d2 != null) {
                    FitnessQueries fitnessQueries = this;
                    double doubleValue = d2.doubleValue();
                    adapter7 = fitnessQueries.DBSessionAdapter;
                    f = Float.valueOf(adapter7.getFitness_indexAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l6 = cursor.getLong(13);
                if (l6 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue = l6.longValue();
                    adapter6 = fitnessQueries2.DBSessionAdapter;
                    num = Integer.valueOf(adapter6.getStatusAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return (T) function14.invoke(m, l, l2, l3, l4, d, m2, m3, m4, m5, bool, l5, f, num);
            }
        });
    }

    public final <T> Query<T> getSessionsSince(long j, final Function14<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? super Double, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Boolean, ? super Long, ? super Float, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSessionsSinceQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessionsSince$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSession.Adapter adapter;
                DBSession.Adapter adapter2;
                DBSession.Adapter adapter3;
                DBSession.Adapter adapter4;
                DBSession.Adapter adapter5;
                Float f;
                Integer num;
                DBSession.Adapter adapter6;
                DBSession.Adapter adapter7;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function14<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, T> function14 = mapper;
                adapter = this.DBSessionAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                Double d = cursor.getDouble(5);
                Intrinsics.checkNotNull(d);
                adapter2 = this.DBSessionAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 6, adapter2.getStepsAdapter());
                adapter3 = this.DBSessionAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 7, adapter3.getCaloriesAdapter());
                adapter4 = this.DBSessionAdapter;
                Object m4 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 8, adapter4.getElevationGainAdapter());
                adapter5 = this.DBSessionAdapter;
                Object m5 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 9, adapter5.getTypeAdapter());
                Boolean bool = cursor.getBoolean(10);
                Intrinsics.checkNotNull(bool);
                Long l5 = cursor.getLong(11);
                Intrinsics.checkNotNull(l5);
                Double d2 = cursor.getDouble(12);
                if (d2 != null) {
                    FitnessQueries fitnessQueries = this;
                    double doubleValue = d2.doubleValue();
                    adapter7 = fitnessQueries.DBSessionAdapter;
                    f = Float.valueOf(adapter7.getFitness_indexAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l6 = cursor.getLong(13);
                if (l6 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue = l6.longValue();
                    adapter6 = fitnessQueries2.DBSessionAdapter;
                    num = Integer.valueOf(adapter6.getStatusAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return (T) function14.invoke(m, l, l2, l3, l4, d, m2, m3, m4, m5, bool, l5, f, num);
            }
        });
    }

    /* renamed from: getSessionsWithPendingUpload-Y1s2hH8 */
    public final Query<GetSessionsWithPendingUpload> m1324getSessionsWithPendingUploadY1s2hH8(String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1325getSessionsWithPendingUploadcu7zPM(hdid, new Function18<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, Long, HistoryDeviceId, String, Long, GetSessionsWithPendingUpload>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessionsWithPendingUpload$2
            @Override // kotlin.jvm.functions.Function18
            public /* bridge */ /* synthetic */ GetSessionsWithPendingUpload invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4, Double d, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Long l5, Float f, Integer num5, Long l6, HistoryDeviceId historyDeviceId2, String str, Long l7) {
                return m1417invokeMV0Ov2Y(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue(), d.doubleValue(), num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), bool.booleanValue(), l5.longValue(), f, num5, l6.longValue(), historyDeviceId2.m1562unboximpl(), str, l7.longValue());
            }

            /* renamed from: invoke-MV0Ov2Y, reason: not valid java name */
            public final GetSessionsWithPendingUpload m1417invokeMV0Ov2Y(String hdid_, long j, long j2, long j3, long j4, double d, int r42, int r43, int r44, int r45, boolean z, long j5, Float f, Integer num, long j6, String hdid__, String failure_reason, long j7) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                Intrinsics.checkNotNullParameter(hdid__, "hdid__");
                Intrinsics.checkNotNullParameter(failure_reason, "failure_reason");
                return new GetSessionsWithPendingUpload(hdid_, j, j2, j3, j4, d, r42, r43, r44, r45, z, j5, f, num, j6, hdid__, failure_reason, j7, null);
            }
        });
    }

    /* renamed from: getSessionsWithPendingUpload-cu7-zPM */
    public final <T> Query<T> m1325getSessionsWithPendingUploadcu7zPM(String hdid, final Function18<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? super Double, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Boolean, ? super Long, ? super Float, ? super Integer, ? super Long, ? super HistoryDeviceId, ? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSessionsWithPendingUploadQuery(this, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessionsWithPendingUpload$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSession.Adapter adapter;
                DBSession.Adapter adapter2;
                DBSession.Adapter adapter3;
                DBSession.Adapter adapter4;
                DBSession.Adapter adapter5;
                Float f;
                Integer num;
                StravaPendingUploads.Adapter adapter6;
                DBSession.Adapter adapter7;
                DBSession.Adapter adapter8;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function18<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, Long, HistoryDeviceId, String, Long, T> function18 = mapper;
                adapter = this.DBSessionAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                Double d = cursor.getDouble(5);
                Intrinsics.checkNotNull(d);
                adapter2 = this.DBSessionAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 6, adapter2.getStepsAdapter());
                adapter3 = this.DBSessionAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 7, adapter3.getCaloriesAdapter());
                adapter4 = this.DBSessionAdapter;
                Object m4 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 8, adapter4.getElevationGainAdapter());
                adapter5 = this.DBSessionAdapter;
                Object m5 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 9, adapter5.getTypeAdapter());
                Boolean bool = cursor.getBoolean(10);
                Intrinsics.checkNotNull(bool);
                Long l5 = cursor.getLong(11);
                Intrinsics.checkNotNull(l5);
                Double d2 = cursor.getDouble(12);
                if (d2 != null) {
                    FitnessQueries fitnessQueries = this;
                    double doubleValue = d2.doubleValue();
                    adapter8 = fitnessQueries.DBSessionAdapter;
                    f = Float.valueOf(adapter8.getFitness_indexAdapter().decode(Double.valueOf(doubleValue)).floatValue());
                } else {
                    f = null;
                }
                Long l6 = cursor.getLong(13);
                Float f2 = f;
                if (l6 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    long longValue = l6.longValue();
                    adapter7 = fitnessQueries2.DBSessionAdapter;
                    num = Integer.valueOf(adapter7.getStatusAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                Long l7 = cursor.getLong(14);
                Intrinsics.checkNotNull(l7);
                adapter6 = this.StravaPendingUploadsAdapter;
                Object m6 = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 15, adapter6.getHdidAdapter());
                String string = cursor.getString(16);
                Intrinsics.checkNotNull(string);
                Long l8 = cursor.getLong(17);
                Intrinsics.checkNotNull(l8);
                return (T) function18.invoke(m, l, l2, l3, l4, d, m2, m3, m4, m5, bool, l5, f2, num, l7, m6, string, l8);
            }
        }, null);
    }

    public final <T> Query<T> getSleepData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSleepDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSleepData.Adapter adapter;
                DBSleepData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBSleepDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBSleepDataAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getSleep_stateAdapter()));
            }
        });
    }

    /* renamed from: getSleepDataByIdentifier-VAJrmyI */
    public final Query<DBSleepData> m1326getSleepDataByIdentifierVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1327getSleepDataByIdentifierW5HvN8Q(j, j2, hdid, new Function3<HistoryDeviceId, Long, Integer, DBSleepData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepDataByIdentifier$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBSleepData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1419invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBSleepData m1419invokeOZHprlw(String hdid_, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid_, "hdid_");
                return new DBSleepData(hdid_, j3, r11, null);
            }
        });
    }

    /* renamed from: getSleepDataByIdentifier-W5HvN8Q */
    public final <T> Query<T> m1327getSleepDataByIdentifierW5HvN8Q(long j, long j2, String hdid, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSleepDataByIdentifierQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepDataByIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSleepData.Adapter adapter;
                DBSleepData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBSleepDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBSleepDataAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getSleep_stateAdapter()));
            }
        }, null);
    }

    public final <T> Query<T> getSleepHistoryData(long j, long j2, final Function5<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSleepHistoryDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistoryData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSleepHistoryData.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function5<HistoryDeviceId, Long, Long, Long, Long, T> function5 = mapper;
                adapter = this.DBSleepHistoryDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                return (T) function5.invoke(m, l, l2, l3, l4);
            }
        });
    }

    public final <T> Query<T> getSleepHistoryDataEndInclusive(long j, long j2, final Function5<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSleepHistoryDataEndInclusiveQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistoryDataEndInclusive$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSleepHistoryData.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function5<HistoryDeviceId, Long, Long, Long, Long, T> function5 = mapper;
                adapter = this.DBSleepHistoryDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                return (T) function5.invoke(m, l, l2, l3, l4);
            }
        });
    }

    public final <T> Query<T> getSleepHistoryDataLatest(final Function5<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(-893934585, new String[]{"DBSleepHistoryData"}, getDriver(), "Fitness.sq", "getSleepHistoryDataLatest", "SELECT *\nFROM DBSleepHistoryData\nORDER BY start DESC\nLIMIT 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistoryDataLatest$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSleepHistoryData.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function5<HistoryDeviceId, Long, Long, Long, Long, T> function5 = mapper;
                adapter = this.DBSleepHistoryDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                return (T) function5.invoke(m, l, l2, l3, l4);
            }
        });
    }

    public final <T> Query<T> getSleepHistorySince(long j, final Function5<? super HistoryDeviceId, ? super Long, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSleepHistorySinceQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistorySince$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSleepHistoryData.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function5<HistoryDeviceId, Long, Long, Long, Long, T> function5 = mapper;
                adapter = this.DBSleepHistoryDataAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(2);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(3);
                Intrinsics.checkNotNull(l3);
                Long l4 = cursor.getLong(4);
                Intrinsics.checkNotNull(l4);
                return (T) function5.invoke(m, l, l2, l3, l4);
            }
        });
    }

    public final <T> Query<T> getSpeedCalibrationData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSpeedCalibrationDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSpeedCalibrationData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBSpeedCalibration.Adapter adapter;
                DBSpeedCalibration.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBSpeedCalibrationAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBSpeedCalibrationAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getCoefficientAdapter()));
            }
        });
    }

    public final <T> Query<T> getStandData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetStandDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getStandData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBStand.Adapter adapter;
                DBStand.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBStandAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBStandAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getSuccessful_standsAdapter()));
            }
        });
    }

    public final <T> Query<T> getStressData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetStressDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getStressData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBStress.Adapter adapter;
                DBStress.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBStressAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBStressAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStressAdapter()));
            }
        });
    }

    public final <T> Query<T> getStressIntervaled(long j, long j2, long j3, final Function2<? super Long, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetStressIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getStressIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Double, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return function2.invoke(l, cursor.getDouble(1));
            }
        });
    }

    public final <T> Query<T> getSumCalories(long j, long j2, final Function1<? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSumCaloriesQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumCalories$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                return mapper.invoke(cursor.getDouble(0));
            }
        });
    }

    /* renamed from: getSumCaloriesByIdentifierForWorkout-VAJrmyI */
    public final Query<GetSumCaloriesByIdentifierForWorkout> m1328getSumCaloriesByIdentifierForWorkoutVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return m1329getSumCaloriesByIdentifierForWorkoutW5HvN8Q(j, j2, hdid, new Function1<Double, GetSumCaloriesByIdentifierForWorkout>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumCaloriesByIdentifierForWorkout$2
            @Override // kotlin.jvm.functions.Function1
            public final GetSumCaloriesByIdentifierForWorkout invoke(Double d) {
                return new GetSumCaloriesByIdentifierForWorkout(d);
            }
        });
    }

    /* renamed from: getSumCaloriesByIdentifierForWorkout-W5HvN8Q */
    public final <T> Query<T> m1329getSumCaloriesByIdentifierForWorkoutW5HvN8Q(long j, long j2, String hdid, final Function1<? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSumCaloriesByIdentifierForWorkoutQuery(this, j, j2, hdid, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumCaloriesByIdentifierForWorkout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                return mapper.invoke(cursor.getDouble(0));
            }
        }, null);
    }

    public final <T> Query<T> getSumCaloriesIntervaled(long j, long j2, long j3, final Function2<? super Long, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSumCaloriesIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumCaloriesIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Double, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return function2.invoke(l, cursor.getDouble(1));
            }
        });
    }

    public final <T> Query<T> getSumExercise(long j, long j2, final Function1<? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSumExerciseQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumExercise$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBExercise.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function1<Integer, T> function1 = mapper;
                Long l = cursor.getLong(0);
                if (l != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l.longValue();
                    adapter = fitnessQueries.DBExerciseAdapter;
                    num = Integer.valueOf(adapter.getActive_minutesAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return function1.invoke(num);
            }
        });
    }

    public final Query<Double> getSumSteps(long j, long j2) {
        return new GetSumStepsQuery(this, j, j2, new Function1<SqlCursor, Double>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumSteps$1
            @Override // kotlin.jvm.functions.Function1
            public final Double invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Double d = cursor.getDouble(0);
                Intrinsics.checkNotNull(d);
                return d;
            }
        });
    }

    /* renamed from: getSumStepsByIdentifierForWorkout-VAJrmyI */
    public final Query<Double> m1330getSumStepsByIdentifierForWorkoutVAJrmyI(long j, long j2, String hdid) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new GetSumStepsByIdentifierForWorkoutQuery(this, j, j2, hdid, new Function1<SqlCursor, Double>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumStepsByIdentifierForWorkout$1
            @Override // kotlin.jvm.functions.Function1
            public final Double invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Double d = cursor.getDouble(0);
                Intrinsics.checkNotNull(d);
                return d;
            }
        }, null);
    }

    public final <T> Query<T> getSumStepsCategorised(long j, long j2, final Function3<? super Double, ? super Double, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSumStepsCategorisedQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumStepsCategorised$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                return mapper.invoke(cursor.getDouble(0), cursor.getDouble(1), cursor.getDouble(2));
            }
        });
    }

    public final <T> Query<T> getSumStepsIntervaled(long j, long j2, long j3, final Function2<? super Long, ? super Double, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSumStepsIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumStepsIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Double, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                Double d = cursor.getDouble(1);
                Intrinsics.checkNotNull(d);
                return function2.invoke(l, d);
            }
        });
    }

    public final <T> Query<T> getTotalExerciseIntervaled(long j, long j2, long j3, final Function2<? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetTotalExerciseIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getTotalExerciseIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBExercise.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Integer, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(1);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter = fitnessQueries.DBExerciseAdapter;
                    num = Integer.valueOf(adapter.getActive_minutesAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return function2.invoke(l, num);
            }
        });
    }

    public final <T> Query<T> getTotalStandsIntervaled(long j, long j2, long j3, final Function2<? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetTotalStandsIntervaledQuery(this, j, j2, j3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getTotalStandsIntervaled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBStand.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Long, Integer, T> function2 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(1);
                if (l2 != null) {
                    FitnessQueries fitnessQueries = this;
                    long longValue = l2.longValue();
                    adapter = fitnessQueries.DBStandAdapter;
                    num = Integer.valueOf(adapter.getSuccessful_standsAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return function2.invoke(l, num);
            }
        });
    }

    public final <T> Query<T> getWristData(long j, long j2, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetWristDataQuery(this, j, j2, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getWristData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBWrist.Adapter adapter;
                DBWrist.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBWristAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBWristAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStateAdapter()));
            }
        });
    }

    /* renamed from: getWristDataForIdentifier-VAJrmyI */
    public final Query<DBWrist> m1331getWristDataForIdentifierVAJrmyI(long j, long j2, String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return m1332getWristDataForIdentifierW5HvN8Q(j, j2, identifier, new Function3<HistoryDeviceId, Long, Integer, DBWrist>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getWristDataForIdentifier$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBWrist invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1428invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBWrist m1428invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBWrist(hdid, j3, r11, null);
            }
        });
    }

    /* renamed from: getWristDataForIdentifier-W5HvN8Q */
    public final <T> Query<T> m1332getWristDataForIdentifierW5HvN8Q(long j, long j2, String identifier, final Function3<? super HistoryDeviceId, ? super Long, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetWristDataForIdentifierQuery(this, j, j2, identifier, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getWristDataForIdentifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBWrist.Adapter adapter;
                DBWrist.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<HistoryDeviceId, Long, Integer, T> function3 = mapper;
                adapter = this.DBWristAdapter;
                Object m = MessagingAnalytics$$ExternalSyntheticLambda0.m(cursor, 0, adapter.getHdidAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                adapter2 = this.DBWristAdapter;
                return (T) function3.invoke(m, l, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getStateAdapter()));
            }
        }, null);
    }

    public final Query<Boolean> hasCaloriesEntriesBefore(long j) {
        return new HasCaloriesEntriesBeforeQuery(this, j, new Function1<SqlCursor, Boolean>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasCaloriesEntriesBefore$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                return bool;
            }
        });
    }

    public final Query<Boolean> hasHeartrateEntriesBefore(long j) {
        return new HasHeartrateEntriesBeforeQuery(this, j, new Function1<SqlCursor, Boolean>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasHeartrateEntriesBefore$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                return bool;
            }
        });
    }

    public final Query<Boolean> hasProcessedFitnessIndexBefore(long j) {
        return new HasProcessedFitnessIndexBeforeQuery(this, j, new Function1<SqlCursor, Boolean>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasProcessedFitnessIndexBefore$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                return bool;
            }
        });
    }

    public final Query<Boolean> hasRestingHeartrateEntriesBefore(long j) {
        return new HasRestingHeartrateEntriesBeforeQuery(this, j, new Function1<SqlCursor, Boolean>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasRestingHeartrateEntriesBefore$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                return bool;
            }
        });
    }

    public final Query<Boolean> hasSessions() {
        return UrlKt.Query(1134964282, new String[]{"DBSession"}, getDriver(), "Fitness.sq", "hasSessions", "SELECT COUNT(*) > 0 FROM DBSession\nLIMIT 1", new Function1<SqlCursor, Boolean>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasSessions$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                return bool;
            }
        });
    }

    public final Query<Boolean> hasSleepHistoryBefore(long j) {
        return new HasSleepHistoryBeforeQuery(this, j, new Function1<SqlCursor, Boolean>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasSleepHistoryBefore$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                return bool;
            }
        });
    }

    public final <T> Query<T> hasStepEntriesBefore(long j, final Function2<? super Boolean, ? super Boolean, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new HasStepEntriesBeforeQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasStepEntriesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Boolean, Boolean, T> function2 = mapper;
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                Boolean bool2 = cursor.getBoolean(1);
                Intrinsics.checkNotNull(bool2);
                return function2.invoke(bool, bool2);
            }
        });
    }

    public final Query<Boolean> hasValidSessions() {
        return UrlKt.Query(-300309188, new String[]{"DBSession"}, getDriver(), "Fitness.sq", "hasValidSessions", "SELECT COUNT(*) > 0 FROM DBSession WHERE status = 0\nLIMIT 1", new Function1<SqlCursor, Boolean>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasValidSessions$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Boolean bool = cursor.getBoolean(0);
                Intrinsics.checkNotNull(bool);
                return bool;
            }
        });
    }

    /* renamed from: insertActivityData-hSv7xU0 */
    public final void m1333insertActivityDatahSv7xU0(final String hdid, final long j, final Integer num, final Integer num2, final Integer num3, final Integer num4, final Integer num5, final Float f, final Integer num6, final Integer num7) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-1561580945, "INSERT OR REPLACE INTO DBActivityData(hdid, timestamp, activity_class, walk_steps, run_steps, other_steps, rhythmic_steps_cadence, speed, distance, calories)\nVALUES (?, ?, ?, ?, ? ,?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertActivityData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBActivityData.Adapter adapter;
                Long l;
                Long l2;
                Long l3;
                Long l4;
                Long l5;
                Double d;
                Long l6;
                DBActivityData.Adapter adapter2;
                DBActivityData.Adapter adapter3;
                DBActivityData.Adapter adapter4;
                DBActivityData.Adapter adapter5;
                DBActivityData.Adapter adapter6;
                DBActivityData.Adapter adapter7;
                DBActivityData.Adapter adapter8;
                DBActivityData.Adapter adapter9;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBActivityDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                Integer num8 = num;
                Long l7 = null;
                if (num8 != null) {
                    FitnessQueries fitnessQueries = FitnessQueries.this;
                    int intValue = num8.intValue();
                    adapter9 = fitnessQueries.DBActivityDataAdapter;
                    l = Long.valueOf(adapter9.getActivity_classAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l = null;
                }
                execute.bindLong(2, l);
                Integer num9 = num2;
                if (num9 != null) {
                    FitnessQueries fitnessQueries2 = FitnessQueries.this;
                    int intValue2 = num9.intValue();
                    adapter8 = fitnessQueries2.DBActivityDataAdapter;
                    l2 = Long.valueOf(adapter8.getWalk_stepsAdapter().encode(Integer.valueOf(intValue2)).longValue());
                } else {
                    l2 = null;
                }
                execute.bindLong(3, l2);
                Integer num10 = num3;
                if (num10 != null) {
                    FitnessQueries fitnessQueries3 = FitnessQueries.this;
                    int intValue3 = num10.intValue();
                    adapter7 = fitnessQueries3.DBActivityDataAdapter;
                    l3 = Long.valueOf(adapter7.getRun_stepsAdapter().encode(Integer.valueOf(intValue3)).longValue());
                } else {
                    l3 = null;
                }
                execute.bindLong(4, l3);
                Integer num11 = num4;
                if (num11 != null) {
                    FitnessQueries fitnessQueries4 = FitnessQueries.this;
                    int intValue4 = num11.intValue();
                    adapter6 = fitnessQueries4.DBActivityDataAdapter;
                    l4 = Long.valueOf(adapter6.getOther_stepsAdapter().encode(Integer.valueOf(intValue4)).longValue());
                } else {
                    l4 = null;
                }
                execute.bindLong(5, l4);
                Integer num12 = num5;
                if (num12 != null) {
                    FitnessQueries fitnessQueries5 = FitnessQueries.this;
                    int intValue5 = num12.intValue();
                    adapter5 = fitnessQueries5.DBActivityDataAdapter;
                    l5 = Long.valueOf(adapter5.getRhythmic_steps_cadenceAdapter().encode(Integer.valueOf(intValue5)).longValue());
                } else {
                    l5 = null;
                }
                execute.bindLong(6, l5);
                Float f2 = f;
                if (f2 != null) {
                    FitnessQueries fitnessQueries6 = FitnessQueries.this;
                    float floatValue = f2.floatValue();
                    adapter4 = fitnessQueries6.DBActivityDataAdapter;
                    d = Double.valueOf(adapter4.getSpeedAdapter().encode(Float.valueOf(floatValue)).doubleValue());
                } else {
                    d = null;
                }
                execute.bindDouble(7, d);
                Integer num13 = num6;
                if (num13 != null) {
                    FitnessQueries fitnessQueries7 = FitnessQueries.this;
                    int intValue6 = num13.intValue();
                    adapter3 = fitnessQueries7.DBActivityDataAdapter;
                    l6 = Long.valueOf(adapter3.getDistanceAdapter().encode(Integer.valueOf(intValue6)).longValue());
                } else {
                    l6 = null;
                }
                execute.bindLong(8, l6);
                Integer num14 = num7;
                if (num14 != null) {
                    FitnessQueries fitnessQueries8 = FitnessQueries.this;
                    int intValue7 = num14.intValue();
                    adapter2 = fitnessQueries8.DBActivityDataAdapter;
                    l7 = Long.valueOf(adapter2.getCaloriesAdapter().encode(Integer.valueOf(intValue7)).longValue());
                }
                execute.bindLong(9, l7);
            }
        });
        notifyQueries(-1561580945, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertActivityData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBActivityData");
            }
        });
    }

    /* renamed from: insertDebugData-4i7cvns */
    public final void m1334insertDebugData4i7cvns(final String hdid, final long j, final int r15, final int r16) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-264868537, "INSERT OR REPLACE INTO DBDebug(hdid, timestamp, type, value)\nVALUES (?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertDebugData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBDebug.Adapter adapter;
                DBDebug.Adapter adapter2;
                DBDebug.Adapter adapter3;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBDebugAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBDebugAdapter;
                execute.bindLong(2, adapter2.getTypeAdapter().encode(Integer.valueOf(r15)));
                adapter3 = FitnessQueries.this.DBDebugAdapter;
                execute.bindLong(3, adapter3.getValue_Adapter().encode(Integer.valueOf(r16)));
            }
        });
        notifyQueries(-264868537, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertDebugData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBDebug");
            }
        });
    }

    /* renamed from: insertDeletedSession-cu7-zPM */
    public final void m1335insertDeletedSessioncu7zPM(final String hdid, final long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(829673939, "INSERT OR REPLACE INTO DBDeletedSessions(hdid, timestamp)\nVALUES (?,?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertDeletedSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBDeletedSessions.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBDeletedSessionsAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(829673939, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertDeletedSession$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBDeletedSessions");
            }
        });
    }

    /* renamed from: insertDiagnosticsData-4i7cvns */
    public final void m1336insertDiagnosticsData4i7cvns(final String hdid, final long j, final String key, final int r16) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(key, "key");
        getDriver().execute(772109472, "INSERT OR REPLACE INTO DBDiagnostics(hdid, timestamp, key, value)\nVALUES (?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertDiagnosticsData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBDiagnostics.Adapter adapter;
                DBDiagnostics.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBDiagnosticsAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                execute.bindString(2, key);
                adapter2 = FitnessQueries.this.DBDiagnosticsAdapter;
                execute.bindLong(3, adapter2.getValue_Adapter().encode(Integer.valueOf(r16)));
            }
        });
        notifyQueries(772109472, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertDiagnosticsData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBDiagnostics");
            }
        });
    }

    /* renamed from: insertElevation-EBUUAns */
    public final void m1337insertElevationEBUUAns(final String hdid, final long j, final int r21, final double d, final double d2, final double d3, final double d4) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-70515961, "INSERT OR REPLACE INTO DBElevation(hdid, session_timestamp, number, long, lat, elevation, resolution)\nVALUES (?, ?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertElevation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBElevation.Adapter adapter;
                DBElevation.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBElevationAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBElevationAdapter;
                execute.bindLong(2, adapter2.getNumberAdapter().encode(Integer.valueOf(r21)));
                execute.bindDouble(3, Double.valueOf(d));
                execute.bindDouble(4, Double.valueOf(d2));
                execute.bindDouble(5, Double.valueOf(d3));
                execute.bindDouble(6, Double.valueOf(d4));
            }
        });
        notifyQueries(-70515961, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertElevation$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBElevation");
            }
        });
    }

    /* renamed from: insertExerciseData-OZHprlw */
    public final void m1338insertExerciseDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(638233784, "INSERT OR REPLACE INTO DBExercise(hdid, timestamp, active_minutes)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertExerciseData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBExercise.Adapter adapter;
                DBExercise.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBExerciseAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBExerciseAdapter;
                execute.bindLong(2, adapter2.getActive_minutesAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(638233784, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertExerciseData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBExercise");
            }
        });
    }

    /* renamed from: insertGoal-AjOicPU */
    public final void m1339insertGoalAjOicPU(final Long l, final String hdid, final int r14, final int r15, final int r16) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-1213863895, "INSERT OR REPLACE INTO DBGoal(timestamp, hdid, steps, stand, exercise)\nVALUES (?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertGoal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBGoal.Adapter adapter;
                DBGoal.Adapter adapter2;
                DBGoal.Adapter adapter3;
                DBGoal.Adapter adapter4;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindLong(0, l);
                adapter = this.DBGoalAdapter;
                execute.bindString(1, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                adapter2 = this.DBGoalAdapter;
                execute.bindLong(2, adapter2.getStepsAdapter().encode(Integer.valueOf(r14)));
                adapter3 = this.DBGoalAdapter;
                execute.bindLong(3, adapter3.getStandAdapter().encode(Integer.valueOf(r15)));
                adapter4 = this.DBGoalAdapter;
                execute.bindLong(4, adapter4.getExerciseAdapter().encode(Integer.valueOf(r16)));
            }
        });
        notifyQueries(-1213863895, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertGoal$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBGoal");
            }
        });
    }

    /* renamed from: insertHeartrateData-FGKXf14 */
    public final void m1340insertHeartrateDataFGKXf14(final String hdid, final long j, final int r17, final int r18, final Integer num, final Integer num2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(1672739482, "INSERT OR REPLACE INTO DBHeartrateData(hdid, timestamp, heartrate, confidence, heartrate_low, heartrate_high)\nVALUES (?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertHeartrateData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBHeartrateData.Adapter adapter;
                DBHeartrateData.Adapter adapter2;
                DBHeartrateData.Adapter adapter3;
                Long l;
                DBHeartrateData.Adapter adapter4;
                DBHeartrateData.Adapter adapter5;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBHeartrateDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBHeartrateDataAdapter;
                execute.bindLong(2, adapter2.getHeartrateAdapter().encode(Integer.valueOf(r17)));
                adapter3 = FitnessQueries.this.DBHeartrateDataAdapter;
                execute.bindLong(3, adapter3.getConfidenceAdapter().encode(Integer.valueOf(r18)));
                Integer num3 = num;
                Long l2 = null;
                if (num3 != null) {
                    FitnessQueries fitnessQueries = FitnessQueries.this;
                    int intValue = num3.intValue();
                    adapter5 = fitnessQueries.DBHeartrateDataAdapter;
                    l = Long.valueOf(adapter5.getHeartrate_lowAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l = null;
                }
                execute.bindLong(4, l);
                Integer num4 = num2;
                if (num4 != null) {
                    FitnessQueries fitnessQueries2 = FitnessQueries.this;
                    int intValue2 = num4.intValue();
                    adapter4 = fitnessQueries2.DBHeartrateDataAdapter;
                    l2 = Long.valueOf(adapter4.getHeartrate_highAdapter().encode(Integer.valueOf(intValue2)).longValue());
                }
                execute.bindLong(5, l2);
            }
        });
        notifyQueries(1672739482, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertHeartrateData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBHeartrateData");
            }
        });
    }

    /* renamed from: insertInterval-4i7cvns */
    public final void m1341insertInterval4i7cvns(final String hdid, final long j, final long j2, final long j3) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-540093733, "INSERT OR REPLACE INTO DBInterval(hdid, session_timestamp, start_timestamp, end_timestamp)\nVALUES (?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertInterval$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBInterval.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBIntervalAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                execute.bindLong(2, Long.valueOf(j2));
                execute.bindLong(3, Long.valueOf(j3));
            }
        });
        notifyQueries(-540093733, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertInterval$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBInterval");
            }
        });
    }

    /* renamed from: insertLocationData-EBUUAns */
    public final void m1342insertLocationDataEBUUAns(final String hdid, final long j, final double d, final double d2, final float f, final double d3, final boolean z) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(1046287381, "INSERT OR REPLACE INTO DBLocationData(hdid, timestamp, long, lat, accuracy, altitude, accepted)\nVALUES (?, ?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertLocationData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBLocationData.Adapter adapter;
                DBLocationData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBLocationDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                execute.bindDouble(2, Double.valueOf(d));
                execute.bindDouble(3, Double.valueOf(d2));
                adapter2 = FitnessQueries.this.DBLocationDataAdapter;
                execute.bindDouble(4, adapter2.getAccuracyAdapter().encode(Float.valueOf(f)));
                execute.bindDouble(5, Double.valueOf(d3));
                execute.bindBoolean(6, Boolean.valueOf(z));
            }
        });
        notifyQueries(1046287381, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertLocationData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBLocationData");
            }
        });
    }

    /* renamed from: insertPowerData-OZHprlw */
    public final void m1343insertPowerDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(778548985, "INSERT OR REPLACE INTO DBPower(hdid, timestamp, state)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertPowerData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBPower.Adapter adapter;
                DBPower.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBPowerAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBPowerAdapter;
                execute.bindLong(2, adapter2.getStateAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(778548985, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertPowerData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBPower");
            }
        });
    }

    /* renamed from: insertProcessedFitnessIndexData-OZHprlw */
    public final void m1344insertProcessedFitnessIndexDataOZHprlw(final String hdid, final long j, final Float f) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(1661331116, "INSERT OR REPLACE INTO DBFitnessIndexProcessed(hdid, session_timestamp, processed_fitness_index)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertProcessedFitnessIndexData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBFitnessIndexProcessed.Adapter adapter;
                Double d;
                DBFitnessIndexProcessed.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBFitnessIndexProcessedAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                Float f2 = f;
                if (f2 != null) {
                    FitnessQueries fitnessQueries = FitnessQueries.this;
                    float floatValue = f2.floatValue();
                    adapter2 = fitnessQueries.DBFitnessIndexProcessedAdapter;
                    d = Double.valueOf(adapter2.getProcessed_fitness_indexAdapter().encode(Float.valueOf(floatValue)).doubleValue());
                } else {
                    d = null;
                }
                execute.bindDouble(2, d);
            }
        });
        notifyQueries(1661331116, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertProcessedFitnessIndexData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBFitnessIndexProcessed");
            }
        });
    }

    public final void insertProfile(final Long l, final Integer num, final Integer num2, final Long l2, final Integer num3, final Integer num4, final Integer num5, final Integer num6, final Integer num7) {
        getDriver().execute(901677267, "INSERT OR REPLACE INTO DBProfile(timestamp, height, weight, ts_of_birth, gender, measurement, temperature, bedtime_hour, bedtime_min)\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertProfile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                Long l3;
                Long l4;
                Long l5;
                Long l6;
                Long l7;
                Long l8;
                DBProfile.Adapter adapter;
                DBProfile.Adapter adapter2;
                DBProfile.Adapter adapter3;
                DBProfile.Adapter adapter4;
                DBProfile.Adapter adapter5;
                DBProfile.Adapter adapter6;
                DBProfile.Adapter adapter7;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindLong(0, l);
                Integer num8 = num;
                Long l9 = null;
                if (num8 != null) {
                    FitnessQueries fitnessQueries = this;
                    int intValue = num8.intValue();
                    adapter7 = fitnessQueries.DBProfileAdapter;
                    l3 = Long.valueOf(adapter7.getHeightAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l3 = null;
                }
                execute.bindLong(1, l3);
                Integer num9 = num2;
                if (num9 != null) {
                    FitnessQueries fitnessQueries2 = this;
                    int intValue2 = num9.intValue();
                    adapter6 = fitnessQueries2.DBProfileAdapter;
                    l4 = Long.valueOf(adapter6.getWeightAdapter().encode(Integer.valueOf(intValue2)).longValue());
                } else {
                    l4 = null;
                }
                execute.bindLong(2, l4);
                execute.bindLong(3, l2);
                Integer num10 = num3;
                if (num10 != null) {
                    FitnessQueries fitnessQueries3 = this;
                    int intValue3 = num10.intValue();
                    adapter5 = fitnessQueries3.DBProfileAdapter;
                    l5 = Long.valueOf(adapter5.getGenderAdapter().encode(Integer.valueOf(intValue3)).longValue());
                } else {
                    l5 = null;
                }
                execute.bindLong(4, l5);
                Integer num11 = num4;
                if (num11 != null) {
                    FitnessQueries fitnessQueries4 = this;
                    int intValue4 = num11.intValue();
                    adapter4 = fitnessQueries4.DBProfileAdapter;
                    l6 = Long.valueOf(adapter4.getMeasurementAdapter().encode(Integer.valueOf(intValue4)).longValue());
                } else {
                    l6 = null;
                }
                execute.bindLong(5, l6);
                Integer num12 = num5;
                if (num12 != null) {
                    FitnessQueries fitnessQueries5 = this;
                    int intValue5 = num12.intValue();
                    adapter3 = fitnessQueries5.DBProfileAdapter;
                    l7 = Long.valueOf(adapter3.getTemperatureAdapter().encode(Integer.valueOf(intValue5)).longValue());
                } else {
                    l7 = null;
                }
                execute.bindLong(6, l7);
                Integer num13 = num6;
                if (num13 != null) {
                    FitnessQueries fitnessQueries6 = this;
                    int intValue6 = num13.intValue();
                    adapter2 = fitnessQueries6.DBProfileAdapter;
                    l8 = Long.valueOf(adapter2.getBedtime_hourAdapter().encode(Integer.valueOf(intValue6)).longValue());
                } else {
                    l8 = null;
                }
                execute.bindLong(7, l8);
                Integer num14 = num7;
                if (num14 != null) {
                    FitnessQueries fitnessQueries7 = this;
                    int intValue7 = num14.intValue();
                    adapter = fitnessQueries7.DBProfileAdapter;
                    l9 = Long.valueOf(adapter.getBedtime_minAdapter().encode(Integer.valueOf(intValue7)).longValue());
                }
                execute.bindLong(8, l9);
            }
        });
        notifyQueries(901677267, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertProfile$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBProfile");
            }
        });
    }

    /* renamed from: insertRawFitnessIndexData-OZHprlw */
    public final void m1345insertRawFitnessIndexDataOZHprlw(final String hdid, final long j, final float f) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-464017658, "INSERT OR REPLACE INTO DBFitnessIndex(hdid, timestamp, fitness_index)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertRawFitnessIndexData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBFitnessIndex.Adapter adapter;
                DBFitnessIndex.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBFitnessIndexAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBFitnessIndexAdapter;
                execute.bindDouble(2, adapter2.getFitness_indexAdapter().encode(Float.valueOf(f)));
            }
        });
        notifyQueries(-464017658, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertRawFitnessIndexData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBFitnessIndex");
            }
        });
    }

    /* renamed from: insertRestingHeartrateData-OZHprlw */
    public final void m1346insertRestingHeartrateDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-2018364648, "INSERT OR REPLACE INTO DBRestingHeartrateData(hdid, timestamp, restingHeartrate)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertRestingHeartrateData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBRestingHeartrateData.Adapter adapter;
                DBRestingHeartrateData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBRestingHeartrateDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBRestingHeartrateDataAdapter;
                execute.bindLong(2, adapter2.getRestingHeartrateAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(-2018364648, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertRestingHeartrateData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBRestingHeartrateData");
            }
        });
    }

    /* renamed from: insertSession-us9H8TY */
    public final void m1347insertSessionus9H8TY(final String hdid, final long j, final long j2, final long j3, final long j4, final double d, final int r38, final int r39, final int r40, final int r41, final boolean z, final long j5, final Float f, final Integer num) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-1098876480, "INSERT OR REPLACE INTO DBSession(hdid, start_timestamp, end_timestamp, total_time_ms, active_time_ms, total_distance_meter, steps, calories, elevationGain, type, gps, session_id, fitness_index, status)\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBSession.Adapter adapter;
                DBSession.Adapter adapter2;
                DBSession.Adapter adapter3;
                DBSession.Adapter adapter4;
                DBSession.Adapter adapter5;
                Double d2;
                DBSession.Adapter adapter6;
                DBSession.Adapter adapter7;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBSessionAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                execute.bindLong(2, Long.valueOf(j2));
                execute.bindLong(3, Long.valueOf(j3));
                execute.bindLong(4, Long.valueOf(j4));
                execute.bindDouble(5, Double.valueOf(d));
                adapter2 = FitnessQueries.this.DBSessionAdapter;
                execute.bindLong(6, adapter2.getStepsAdapter().encode(Integer.valueOf(r38)));
                adapter3 = FitnessQueries.this.DBSessionAdapter;
                execute.bindLong(7, adapter3.getCaloriesAdapter().encode(Integer.valueOf(r39)));
                adapter4 = FitnessQueries.this.DBSessionAdapter;
                execute.bindLong(8, adapter4.getElevationGainAdapter().encode(Integer.valueOf(r40)));
                adapter5 = FitnessQueries.this.DBSessionAdapter;
                execute.bindLong(9, adapter5.getTypeAdapter().encode(Integer.valueOf(r41)));
                execute.bindBoolean(10, Boolean.valueOf(z));
                execute.bindLong(11, Long.valueOf(j5));
                Float f2 = f;
                Long l = null;
                if (f2 != null) {
                    FitnessQueries fitnessQueries = FitnessQueries.this;
                    float floatValue = f2.floatValue();
                    adapter7 = fitnessQueries.DBSessionAdapter;
                    d2 = Double.valueOf(adapter7.getFitness_indexAdapter().encode(Float.valueOf(floatValue)).doubleValue());
                } else {
                    d2 = null;
                }
                execute.bindDouble(12, d2);
                Integer num2 = num;
                if (num2 != null) {
                    FitnessQueries fitnessQueries2 = FitnessQueries.this;
                    int intValue = num2.intValue();
                    adapter6 = fitnessQueries2.DBSessionAdapter;
                    l = Long.valueOf(adapter6.getStatusAdapter().encode(Integer.valueOf(intValue)).longValue());
                }
                execute.bindLong(13, l);
            }
        });
        notifyQueries(-1098876480, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSession$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSession");
            }
        });
    }

    /* renamed from: insertSessionData-FGKXf14 */
    public final void m1348insertSessionDataFGKXf14(final String hdid, final long j, final int r18, final Integer num, final Boolean bool, final long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(843971978, "INSERT OR REPLACE INTO DBSessionData(hdid, timestamp, state, type, gps, session_id)\nVALUES (?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSessionData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBSessionData.Adapter adapter;
                DBSessionData.Adapter adapter2;
                Long l;
                DBSessionData.Adapter adapter3;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBSessionDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBSessionDataAdapter;
                execute.bindLong(2, adapter2.getStateAdapter().encode(Integer.valueOf(r18)));
                Integer num2 = num;
                if (num2 != null) {
                    FitnessQueries fitnessQueries = FitnessQueries.this;
                    int intValue = num2.intValue();
                    adapter3 = fitnessQueries.DBSessionDataAdapter;
                    l = Long.valueOf(adapter3.getTypeAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l = null;
                }
                execute.bindLong(3, l);
                execute.bindBoolean(4, bool);
                execute.bindLong(5, Long.valueOf(j2));
            }
        });
        notifyQueries(843971978, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSessionData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSessionData");
            }
        });
    }

    /* renamed from: insertSleepData-OZHprlw */
    public final void m1349insertSleepDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-79354933, "INSERT OR REPLACE INTO DBSleepData(hdid, timestamp, sleep_state)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSleepData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBSleepData.Adapter adapter;
                DBSleepData.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBSleepDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBSleepDataAdapter;
                execute.bindLong(2, adapter2.getSleep_stateAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(-79354933, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSleepData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSleepData");
            }
        });
    }

    /* renamed from: insertSleepHistoryData-_w5UW7A */
    public final void m1350insertSleepHistoryData_w5UW7A(final String hdid, final long j, final long j2, final long j3, final long j4) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-1237191907, "INSERT OR REPLACE INTO DBSleepHistoryData(hdid, start, end, lightSleepMs, deepSleepMs)\nVALUES (?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSleepHistoryData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBSleepHistoryData.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBSleepHistoryDataAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                execute.bindLong(2, Long.valueOf(j2));
                execute.bindLong(3, Long.valueOf(j3));
                execute.bindLong(4, Long.valueOf(j4));
            }
        });
        notifyQueries(-1237191907, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSleepHistoryData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSleepHistoryData");
            }
        });
    }

    /* renamed from: insertSpeedCalibrationData-OZHprlw */
    public final void m1351insertSpeedCalibrationDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-1396722045, "INSERT OR REPLACE INTO DBSpeedCalibration(hdid, timestamp, coefficient)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSpeedCalibrationData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBSpeedCalibration.Adapter adapter;
                DBSpeedCalibration.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBSpeedCalibrationAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBSpeedCalibrationAdapter;
                execute.bindLong(2, adapter2.getCoefficientAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(-1396722045, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertSpeedCalibrationData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBSpeedCalibration");
            }
        });
    }

    /* renamed from: insertStandData-OZHprlw */
    public final void m1352insertStandDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(1969758538, "INSERT OR REPLACE INTO DBStand(hdid, timestamp, successful_stands)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertStandData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBStand.Adapter adapter;
                DBStand.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBStandAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBStandAdapter;
                execute.bindLong(2, adapter2.getSuccessful_standsAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(1969758538, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertStandData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBStand");
            }
        });
    }

    /* renamed from: insertStravaPendingUpload-kRTOawE */
    public final void m1353insertStravaPendingUploadkRTOawE(final long j, final String hdid, final String failure_reason, final long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(failure_reason, "failure_reason");
        getDriver().execute(738859879, "INSERT OR REPLACE INTO StravaPendingUploads (timestamp, hdid, failure_reason, last_attempted_upload)\nVALUES (?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertStravaPendingUpload$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                StravaPendingUploads.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindLong(0, Long.valueOf(j));
                adapter = this.StravaPendingUploadsAdapter;
                execute.bindString(1, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindString(2, failure_reason);
                execute.bindLong(3, Long.valueOf(j2));
            }
        });
        notifyQueries(738859879, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertStravaPendingUpload$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("StravaPendingUploads");
            }
        });
    }

    /* renamed from: insertStressData-OZHprlw */
    public final void m1354insertStressDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(1570339860, "INSERT OR REPLACE INTO DBStress(hdid, timestamp, stress)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertStressData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBStress.Adapter adapter;
                DBStress.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBStressAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBStressAdapter;
                execute.bindLong(2, adapter2.getStressAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(1570339860, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertStressData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBStress");
            }
        });
    }

    /* renamed from: insertWristData-OZHprlw */
    public final void m1355insertWristDataOZHprlw(final String hdid, final long j, final int r14) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        getDriver().execute(-1487728445, "INSERT OR REPLACE INTO DBWrist(hdid, timestamp, state)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertWristData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                DBWrist.Adapter adapter;
                DBWrist.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = FitnessQueries.this.DBWristAdapter;
                execute.bindString(0, adapter.getHdidAdapter().encode(HistoryDeviceId.m1556boximpl(hdid)));
                execute.bindLong(1, Long.valueOf(j));
                adapter2 = FitnessQueries.this.DBWristAdapter;
                execute.bindLong(2, adapter2.getStateAdapter().encode(Integer.valueOf(r14)));
            }
        });
        notifyQueries(-1487728445, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$insertWristData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWrist");
            }
        });
    }

    public final Query<DBActivityData> getActivityData(long j, long j2) {
        return getActivityData(j, j2, new Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, DBActivityData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getActivityData$2
            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ DBActivityData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                return m1378invokehSv7xU0(historyDeviceId.m1562unboximpl(), l.longValue(), num, num2, num3, num4, num5, f, num6, num7);
            }

            /* renamed from: invoke-hSv7xU0, reason: not valid java name */
            public final DBActivityData m1378invokehSv7xU0(String hdid, long j3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBActivityData(hdid, j3, num, num2, num3, num4, num5, f, num6, num7, null);
            }
        });
    }

    public final Query<GetAvgCaloriesPerMonth> getAvgCaloriesPerMonth(long j, long j2) {
        return getAvgCaloriesPerMonth(j, j2, new Function2<Long, Double, GetAvgCaloriesPerMonth>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getAvgCaloriesPerMonth$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetAvgCaloriesPerMonth invoke(Long l, Double d) {
                return invoke(l.longValue(), d);
            }

            public final GetAvgCaloriesPerMonth invoke(long j3, Double d) {
                return new GetAvgCaloriesPerMonth(j3, d);
            }
        });
    }

    public final Query<GetAvgStepsPerMonth> getAvgStepsPerMonth(long j, long j2) {
        return getAvgStepsPerMonth(j, j2, new Function2<Long, Double, GetAvgStepsPerMonth>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getAvgStepsPerMonth$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetAvgStepsPerMonth invoke(Long l, Double d) {
                return invoke(l.longValue(), d);
            }

            public final GetAvgStepsPerMonth invoke(long j3, Double d) {
                return new GetAvgStepsPerMonth(j3, d);
            }
        });
    }

    public final Query<DBDebug> getDebugData(long j, long j2) {
        return getDebugData(j, j2, new Function4<HistoryDeviceId, Long, Integer, Integer, DBDebug>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDebugData$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ DBDebug invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2) {
                return m1382invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue());
            }

            /* renamed from: invoke-4i7cvns, reason: not valid java name */
            public final DBDebug m1382invoke4i7cvns(String hdid, long j3, int r12, int r13) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBDebug(hdid, j3, r12, r13, null);
            }
        });
    }

    public final Query<DBDiagnostics> getDiagnosticsData(long j, long j2) {
        return getDiagnosticsData(j, j2, new Function4<HistoryDeviceId, Long, String, Integer, DBDiagnostics>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDiagnosticsData$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ DBDiagnostics invoke(HistoryDeviceId historyDeviceId, Long l, String str, Integer num) {
                return m1383invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), str, num.intValue());
            }

            /* renamed from: invoke-4i7cvns, reason: not valid java name */
            public final DBDiagnostics m1383invoke4i7cvns(String hdid, long j3, String key, int r13) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                Intrinsics.checkNotNullParameter(key, "key");
                return new DBDiagnostics(hdid, j3, key, r13, null);
            }
        });
    }

    public final Query<GetDistance> getDistance(long j, long j2) {
        return getDistance(j, j2, new Function1<Double, GetDistance>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getDistance$2
            @Override // kotlin.jvm.functions.Function1
            public final GetDistance invoke(Double d) {
                return new GetDistance(d);
            }
        });
    }

    public final Query<DBElevation> getElevationForSession(long j) {
        return getElevationForSession(j, new Function7<HistoryDeviceId, Long, Integer, Double, Double, Double, Double, DBElevation>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getElevationForSession$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBElevation invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Double d, Double d2, Double d3, Double d4) {
                return m1384invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), d.doubleValue(), d2.doubleValue(), d3.doubleValue(), d4.doubleValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBElevation m1384invokeEBUUAns(String hdid, long j2, int r19, double d, double d2, double d3, double d4) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBElevation(hdid, j2, r19, d, d2, d3, d4, null);
            }
        });
    }

    public final Query<DBExercise> getExerciseData(long j, long j2) {
        return getExerciseData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBExercise>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getExerciseData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBExercise invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1385invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBExercise m1385invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBExercise(hdid, j3, r11, null);
            }
        });
    }

    public final Query<DBHeartrateData> getFirstHeartrateData() {
        return getFirstHeartrateData(new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, DBHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getFirstHeartrateData$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1386invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBHeartrateData m1386invokeFGKXf14(String hdid, long j, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBHeartrateData(hdid, j, r14, r15, num, num2, null);
            }
        });
    }

    public final Query<DBGoal> getGoalForTimestamp(long j) {
        return getGoalForTimestamp(j, new Function5<Long, HistoryDeviceId, Integer, Integer, Integer, DBGoal>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getGoalForTimestamp$2
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ DBGoal invoke(Long l, HistoryDeviceId historyDeviceId, Integer num, Integer num2, Integer num3) {
                return m1387invokeAjOicPU(l.longValue(), historyDeviceId.m1562unboximpl(), num.intValue(), num2.intValue(), num3.intValue());
            }

            /* renamed from: invoke-AjOicPU, reason: not valid java name */
            public final DBGoal m1387invokeAjOicPU(long j2, String hdid, int r13, int r14, int r15) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBGoal(j2, hdid, r13, r14, r15, null);
            }
        });
    }

    public final Query<DBHeartrateData> getHeartRateHistorySince(long j) {
        return getHeartRateHistorySince(j, new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, DBHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartRateHistorySince$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1388invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBHeartrateData m1388invokeFGKXf14(String hdid, long j2, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBHeartrateData(hdid, j2, r14, r15, num, num2, null);
            }
        });
    }

    public final Query<DBHeartrateData> getHeartrateData(long j, long j2) {
        return getHeartrateData(j, j2, new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, DBHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateData$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1389invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBHeartrateData m1389invokeFGKXf14(String hdid, long j3, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBHeartrateData(hdid, j3, r14, r15, num, num2, null);
            }
        });
    }

    public final Query<GetHeartrateIntervaled> getHeartrateIntervaled(long j, long j2, long j3) {
        return getHeartrateIntervaled(j, j2, j3, new Function4<Long, Integer, Integer, Double, GetHeartrateIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getHeartrateIntervaled$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ GetHeartrateIntervaled invoke(Long l, Integer num, Integer num2, Double d) {
                return invoke(l.longValue(), num, num2, d);
            }

            public final GetHeartrateIntervaled invoke(long j4, Integer num, Integer num2, Double d) {
                return new GetHeartrateIntervaled(j4, num, num2, d);
            }
        });
    }

    public final Query<DBInterval> getIntervalsForSession(long j) {
        return getIntervalsForSession(j, new Function4<HistoryDeviceId, Long, Long, Long, DBInterval>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getIntervalsForSession$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ DBInterval invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3) {
                return m1393invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue());
            }

            /* renamed from: invoke-4i7cvns, reason: not valid java name */
            public final DBInterval m1393invoke4i7cvns(String hdid, long j2, long j3, long j4) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBInterval(hdid, j2, j3, j4, null);
            }
        });
    }

    public final Query<DBActivityData> getLastActivityData() {
        return getLastActivityData(new Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, DBActivityData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastActivityData$2
            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ DBActivityData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                return m1394invokehSv7xU0(historyDeviceId.m1562unboximpl(), l.longValue(), num, num2, num3, num4, num5, f, num6, num7);
            }

            /* renamed from: invoke-hSv7xU0, reason: not valid java name */
            public final DBActivityData m1394invokehSv7xU0(String hdid, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBActivityData(hdid, j, num, num2, num3, num4, num5, f, num6, num7, null);
            }
        });
    }

    public final Query<DBFitnessIndexProcessed> getLastProcessedFitnessIndex() {
        return getLastProcessedFitnessIndex(new Function3<HistoryDeviceId, Long, Float, DBFitnessIndexProcessed>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastProcessedFitnessIndex$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBFitnessIndexProcessed invoke(HistoryDeviceId historyDeviceId, Long l, Float f) {
                return m1396invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), f);
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBFitnessIndexProcessed m1396invokeOZHprlw(String hdid, long j, Float f) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBFitnessIndexProcessed(hdid, j, f, null);
            }
        });
    }

    public final Query<DBRestingHeartrateData> getLastRestingHeartrateHistoryEntry() {
        return getLastRestingHeartrateHistoryEntry(new Function3<HistoryDeviceId, Long, Integer, DBRestingHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLastRestingHeartrateHistoryEntry$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBRestingHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1398invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBRestingHeartrateData m1398invokeOZHprlw(String hdid, long j, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBRestingHeartrateData(hdid, j, r11, null);
            }
        });
    }

    public final Query<DBSpeedCalibration> getLatestSpeedCalibrationData() {
        return getLatestSpeedCalibrationData(new Function3<HistoryDeviceId, Long, Integer, DBSpeedCalibration>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLatestSpeedCalibrationData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBSpeedCalibration invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1400invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBSpeedCalibration m1400invokeOZHprlw(String hdid, long j, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSpeedCalibration(hdid, j, r11, null);
            }
        });
    }

    public final Query<DBLocationData> getLocationData(long j, long j2) {
        return getLocationData(j, j2, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, DBLocationData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getLocationData$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBLocationData invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1401invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBLocationData m1401invokeEBUUAns(String hdid, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBLocationData(hdid, j3, d, d2, f, d3, z, null);
            }
        });
    }

    public final Query<DBPower> getPowerData(long j, long j2) {
        return getPowerData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBPower>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getPowerData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBPower invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1405invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBPower m1405invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBPower(hdid, j3, r11, null);
            }
        });
    }

    public final Query<GetProcessedFitnessIndexIntervaled> getProcessedFitnessIndexIntervaled(long j, long j2, long j3) {
        return getProcessedFitnessIndexIntervaled(j, j2, j3, new Function2<Long, Double, GetProcessedFitnessIndexIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getProcessedFitnessIndexIntervaled$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetProcessedFitnessIndexIntervaled invoke(Long l, Double d) {
                return invoke(l.longValue(), d);
            }

            public final GetProcessedFitnessIndexIntervaled invoke(long j4, Double d) {
                return new GetProcessedFitnessIndexIntervaled(j4, d);
            }
        });
    }

    public final Query<DBProfile> getProfileForTimestamp(long j) {
        return getProfileForTimestamp(j, new Function9<Long, Integer, Integer, Long, Integer, Integer, Integer, Integer, Integer, DBProfile>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getProfileForTimestamp$2
            @Override // kotlin.jvm.functions.Function9
            public /* bridge */ /* synthetic */ DBProfile invoke(Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
                return invoke(l.longValue(), num, num2, l2, num3, num4, num5, num6, num7);
            }

            public final DBProfile invoke(long j2, Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
                return new DBProfile(j2, num, num2, l, num3, num4, num5, num6, num7);
            }
        });
    }

    public final Query<DBProfile> getProfilesInInterval(long j, long j2) {
        return getProfilesInInterval(j, j2, new Function9<Long, Integer, Integer, Long, Integer, Integer, Integer, Integer, Integer, DBProfile>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getProfilesInInterval$2
            @Override // kotlin.jvm.functions.Function9
            public /* bridge */ /* synthetic */ DBProfile invoke(Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
                return invoke(l.longValue(), num, num2, l2, num3, num4, num5, num6, num7);
            }

            public final DBProfile invoke(long j3, Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
                return new DBProfile(j3, num, num2, l, num3, num4, num5, num6, num7);
            }
        });
    }

    public final Query<DBFitnessIndex> getRawFitnessIndexData(long j, long j2) {
        return getRawFitnessIndexData(j, j2, new Function3<HistoryDeviceId, Long, Float, DBFitnessIndex>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawFitnessIndexData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBFitnessIndex invoke(HistoryDeviceId historyDeviceId, Long l, Float f) {
                return m1407invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), f.floatValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBFitnessIndex m1407invokeOZHprlw(String hdid, long j3, float f) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBFitnessIndex(hdid, j3, f, null);
            }
        });
    }

    public final Query<DBLocationData> getRawLocationData(long j, long j2) {
        return getRawLocationData(j, j2, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, DBLocationData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawLocationData$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ DBLocationData invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1410invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final DBLocationData m1410invokeEBUUAns(String hdid, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBLocationData(hdid, j3, d, d2, f, d3, z, null);
            }
        });
    }

    public final Query<DBRestingHeartrateData> getRestingHeartrateData(long j, long j2) {
        return getRestingHeartrateData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBRestingHeartrateData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRestingHeartrateData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBRestingHeartrateData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1412invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBRestingHeartrateData m1412invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBRestingHeartrateData(hdid, j3, r11, null);
            }
        });
    }

    public final Query<GetRestingHeartrateIntervaled> getRestingHeartrateIntervaled(long j, long j2, long j3) {
        return getRestingHeartrateIntervaled(j, j2, j3, new Function2<Long, Double, GetRestingHeartrateIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRestingHeartrateIntervaled$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetRestingHeartrateIntervaled invoke(Long l, Double d) {
                return invoke(l.longValue(), d);
            }

            public final GetRestingHeartrateIntervaled invoke(long j4, Double d) {
                return new GetRestingHeartrateIntervaled(j4, d);
            }
        });
    }

    public final Query<DBSession> getSession(long j) {
        return getSession(j, new Function14<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, DBSession>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSession$2
            @Override // kotlin.jvm.functions.Function14
            public /* bridge */ /* synthetic */ DBSession invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4, Double d, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Long l5, Float f, Integer num5) {
                return m1413invokeus9H8TY(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue(), d.doubleValue(), num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), bool.booleanValue(), l5.longValue(), f, num5);
            }

            /* renamed from: invoke-us9H8TY, reason: not valid java name */
            public final DBSession m1413invokeus9H8TY(String hdid, long j2, long j3, long j4, long j5, double d, int r36, int r37, int r38, int r39, boolean z, long j6, Float f, Integer num) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSession(hdid, j2, j3, j4, j5, d, r36, r37, r38, r39, z, j6, f, num, null);
            }
        });
    }

    public final Query<DBSessionData> getSessionData(long j, long j2) {
        return getSessionData(j, j2, new Function6<HistoryDeviceId, Long, Integer, Integer, Boolean, Long, DBSessionData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessionData$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBSessionData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Boolean bool, Long l2) {
                return m1414invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2, bool, l2.longValue());
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final DBSessionData m1414invokeFGKXf14(String hdid, long j3, int r15, Integer num, Boolean bool, long j4) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSessionData(hdid, j3, r15, num, bool, j4, null);
            }
        });
    }

    public final Query<DBSession> getSessions(long j, long j2) {
        return getSessions(j, j2, new Function14<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, DBSession>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessions$2
            @Override // kotlin.jvm.functions.Function14
            public /* bridge */ /* synthetic */ DBSession invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4, Double d, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Long l5, Float f, Integer num5) {
                return m1415invokeus9H8TY(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue(), d.doubleValue(), num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), bool.booleanValue(), l5.longValue(), f, num5);
            }

            /* renamed from: invoke-us9H8TY, reason: not valid java name */
            public final DBSession m1415invokeus9H8TY(String hdid, long j3, long j4, long j5, long j6, double d, int r36, int r37, int r38, int r39, boolean z, long j7, Float f, Integer num) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSession(hdid, j3, j4, j5, j6, d, r36, r37, r38, r39, z, j7, f, num, null);
            }
        });
    }

    public final Query<DBSession> getSessionsSince(long j) {
        return getSessionsSince(j, new Function14<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, DBSession>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSessionsSince$2
            @Override // kotlin.jvm.functions.Function14
            public /* bridge */ /* synthetic */ DBSession invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4, Double d, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Long l5, Float f, Integer num5) {
                return m1416invokeus9H8TY(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue(), d.doubleValue(), num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), bool.booleanValue(), l5.longValue(), f, num5);
            }

            /* renamed from: invoke-us9H8TY, reason: not valid java name */
            public final DBSession m1416invokeus9H8TY(String hdid, long j2, long j3, long j4, long j5, double d, int r36, int r37, int r38, int r39, boolean z, long j6, Float f, Integer num) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSession(hdid, j2, j3, j4, j5, d, r36, r37, r38, r39, z, j6, f, num, null);
            }
        });
    }

    public final Query<DBSleepData> getSleepData(long j, long j2) {
        return getSleepData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBSleepData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBSleepData invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1418invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBSleepData m1418invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSleepData(hdid, j3, r11, null);
            }
        });
    }

    public final Query<DBSleepHistoryData> getSleepHistoryData(long j, long j2) {
        return getSleepHistoryData(j, j2, new Function5<HistoryDeviceId, Long, Long, Long, Long, DBSleepHistoryData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistoryData$2
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ DBSleepHistoryData invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4) {
                return m1420invoke_w5UW7A(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue());
            }

            /* renamed from: invoke-_w5UW7A, reason: not valid java name */
            public final DBSleepHistoryData m1420invoke_w5UW7A(String hdid, long j3, long j4, long j5, long j6) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSleepHistoryData(hdid, j3, j4, j5, j6, null);
            }
        });
    }

    public final Query<DBSleepHistoryData> getSleepHistoryDataEndInclusive(long j, long j2) {
        return getSleepHistoryDataEndInclusive(j, j2, new Function5<HistoryDeviceId, Long, Long, Long, Long, DBSleepHistoryData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistoryDataEndInclusive$2
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ DBSleepHistoryData invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4) {
                return m1421invoke_w5UW7A(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue());
            }

            /* renamed from: invoke-_w5UW7A, reason: not valid java name */
            public final DBSleepHistoryData m1421invoke_w5UW7A(String hdid, long j3, long j4, long j5, long j6) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSleepHistoryData(hdid, j3, j4, j5, j6, null);
            }
        });
    }

    public final Query<DBSleepHistoryData> getSleepHistoryDataLatest() {
        return getSleepHistoryDataLatest(new Function5<HistoryDeviceId, Long, Long, Long, Long, DBSleepHistoryData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistoryDataLatest$2
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ DBSleepHistoryData invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4) {
                return m1422invoke_w5UW7A(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue());
            }

            /* renamed from: invoke-_w5UW7A, reason: not valid java name */
            public final DBSleepHistoryData m1422invoke_w5UW7A(String hdid, long j, long j2, long j3, long j4) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSleepHistoryData(hdid, j, j2, j3, j4, null);
            }
        });
    }

    public final Query<DBSleepHistoryData> getSleepHistorySince(long j) {
        return getSleepHistorySince(j, new Function5<HistoryDeviceId, Long, Long, Long, Long, DBSleepHistoryData>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSleepHistorySince$2
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ DBSleepHistoryData invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4) {
                return m1423invoke_w5UW7A(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue());
            }

            /* renamed from: invoke-_w5UW7A, reason: not valid java name */
            public final DBSleepHistoryData m1423invoke_w5UW7A(String hdid, long j2, long j3, long j4, long j5) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSleepHistoryData(hdid, j2, j3, j4, j5, null);
            }
        });
    }

    public final Query<DBSpeedCalibration> getSpeedCalibrationData(long j, long j2) {
        return getSpeedCalibrationData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBSpeedCalibration>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSpeedCalibrationData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBSpeedCalibration invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1424invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBSpeedCalibration m1424invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBSpeedCalibration(hdid, j3, r11, null);
            }
        });
    }

    public final Query<DBStand> getStandData(long j, long j2) {
        return getStandData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBStand>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getStandData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBStand invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1425invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBStand m1425invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBStand(hdid, j3, r11, null);
            }
        });
    }

    public final Query<DBStress> getStressData(long j, long j2) {
        return getStressData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBStress>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getStressData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBStress invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1426invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBStress m1426invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBStress(hdid, j3, r11, null);
            }
        });
    }

    public final Query<GetStressIntervaled> getStressIntervaled(long j, long j2, long j3) {
        return getStressIntervaled(j, j2, j3, new Function2<Long, Double, GetStressIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getStressIntervaled$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetStressIntervaled invoke(Long l, Double d) {
                return invoke(l.longValue(), d);
            }

            public final GetStressIntervaled invoke(long j4, Double d) {
                return new GetStressIntervaled(j4, d);
            }
        });
    }

    public final Query<GetSumCalories> getSumCalories(long j, long j2) {
        return getSumCalories(j, j2, new Function1<Double, GetSumCalories>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumCalories$2
            @Override // kotlin.jvm.functions.Function1
            public final GetSumCalories invoke(Double d) {
                return new GetSumCalories(d);
            }
        });
    }

    public final Query<GetSumCaloriesIntervaled> getSumCaloriesIntervaled(long j, long j2, long j3) {
        return getSumCaloriesIntervaled(j, j2, j3, new Function2<Long, Double, GetSumCaloriesIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumCaloriesIntervaled$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetSumCaloriesIntervaled invoke(Long l, Double d) {
                return invoke(l.longValue(), d);
            }

            public final GetSumCaloriesIntervaled invoke(long j4, Double d) {
                return new GetSumCaloriesIntervaled(j4, d);
            }
        });
    }

    public final Query<GetSumExercise> getSumExercise(long j, long j2) {
        return getSumExercise(j, j2, new Function1<Integer, GetSumExercise>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumExercise$2
            @Override // kotlin.jvm.functions.Function1
            public final GetSumExercise invoke(Integer num) {
                return new GetSumExercise(num);
            }
        });
    }

    public final Query<GetSumStepsCategorised> getSumStepsCategorised(long j, long j2) {
        return getSumStepsCategorised(j, j2, new Function3<Double, Double, Double, GetSumStepsCategorised>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumStepsCategorised$2
            @Override // kotlin.jvm.functions.Function3
            public final GetSumStepsCategorised invoke(Double d, Double d2, Double d3) {
                return new GetSumStepsCategorised(d, d2, d3);
            }
        });
    }

    public final Query<GetSumStepsIntervaled> getSumStepsIntervaled(long j, long j2, long j3) {
        return getSumStepsIntervaled(j, j2, j3, new Function2<Long, Double, GetSumStepsIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getSumStepsIntervaled$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetSumStepsIntervaled invoke(Long l, Double d) {
                return invoke(l.longValue(), d.doubleValue());
            }

            public final GetSumStepsIntervaled invoke(long j4, double d) {
                return new GetSumStepsIntervaled(j4, d);
            }
        });
    }

    public final Query<GetTotalExerciseIntervaled> getTotalExerciseIntervaled(long j, long j2, long j3) {
        return getTotalExerciseIntervaled(j, j2, j3, new Function2<Long, Integer, GetTotalExerciseIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getTotalExerciseIntervaled$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetTotalExerciseIntervaled invoke(Long l, Integer num) {
                return invoke(l.longValue(), num);
            }

            public final GetTotalExerciseIntervaled invoke(long j4, Integer num) {
                return new GetTotalExerciseIntervaled(j4, num);
            }
        });
    }

    public final Query<GetTotalStandsIntervaled> getTotalStandsIntervaled(long j, long j2, long j3) {
        return getTotalStandsIntervaled(j, j2, j3, new Function2<Long, Integer, GetTotalStandsIntervaled>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getTotalStandsIntervaled$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetTotalStandsIntervaled invoke(Long l, Integer num) {
                return invoke(l.longValue(), num);
            }

            public final GetTotalStandsIntervaled invoke(long j4, Integer num) {
                return new GetTotalStandsIntervaled(j4, num);
            }
        });
    }

    public final Query<DBWrist> getWristData(long j, long j2) {
        return getWristData(j, j2, new Function3<HistoryDeviceId, Long, Integer, DBWrist>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getWristData$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBWrist invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1427invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final DBWrist m1427invokeOZHprlw(String hdid, long j3, int r11) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new DBWrist(hdid, j3, r11, null);
            }
        });
    }

    public final Query<HasStepEntriesBefore> hasStepEntriesBefore(long j) {
        return hasStepEntriesBefore(j, new Function2<Boolean, Boolean, HasStepEntriesBefore>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$hasStepEntriesBefore$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ HasStepEntriesBefore invoke(Boolean bool, Boolean bool2) {
                return invoke(bool.booleanValue(), bool2.booleanValue());
            }

            public final HasStepEntriesBefore invoke(boolean z, boolean z2) {
                return new HasStepEntriesBefore(z, z2);
            }
        });
    }

    public final Query<GetMissingProcessedFitnessIndexes> getMissingProcessedFitnessIndexes() {
        return getMissingProcessedFitnessIndexes(new Function2<HistoryDeviceId, Long, GetMissingProcessedFitnessIndexes>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getMissingProcessedFitnessIndexes$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GetMissingProcessedFitnessIndexes invoke(HistoryDeviceId historyDeviceId, Long l) {
                return m1404invokecu7zPM(historyDeviceId.m1562unboximpl(), l.longValue());
            }

            /* renamed from: invoke-cu7-zPM, reason: not valid java name */
            public final GetMissingProcessedFitnessIndexes m1404invokecu7zPM(String hdid, long j) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new GetMissingProcessedFitnessIndexes(hdid, j, null);
            }
        });
    }

    public final Query<GetRawHRAndActivty> getRawHRAndActivty(long j, long j2) {
        return getRawHRAndActivty(j, j2, new Function4<HistoryDeviceId, Long, Integer, Integer, GetRawHRAndActivty>() { // from class: com.animaconnected.watch.fitness.FitnessQueries$getRawHRAndActivty$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ GetRawHRAndActivty invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2) {
                return m1409invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), num, num2);
            }

            /* renamed from: invoke-4i7cvns, reason: not valid java name */
            public final GetRawHRAndActivty m1409invoke4i7cvns(String hdid, long j3, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(hdid, "hdid");
                return new GetRawHRAndActivty(hdid, j3, num, num2, null);
            }
        });
    }
}
