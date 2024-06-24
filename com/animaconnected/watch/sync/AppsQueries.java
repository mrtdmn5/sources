package com.animaconnected.watch.sync;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0;
import com.animaconnected.watch.sync.DBApp;
import com.animaconnected.watch.sync.DBAppPositions;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppsQueries.kt */
/* loaded from: classes3.dex */
public final class AppsQueries extends TransacterImpl {
    private final DBApp.Adapter DBAppAdapter;
    private final DBAppPositions.Adapter DBAppPositionsAdapter;

    /* compiled from: AppsQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetAppQuery<T> extends Query<T> {
        private final int appId;
        final /* synthetic */ AppsQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAppQuery(AppsQueries appsQueries, int r3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = appsQueries;
            this.appId = r3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBApp"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final AppsQueries appsQueries = this.this$0;
            return driver.executeQuery(-1712577789, "SELECT *\nFROM DBApp\nWHERE appId = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$GetAppQuery$execute$1
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
                    DBApp.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    adapter = AppsQueries.this.DBAppAdapter;
                    executeQuery.bindLong(0, adapter.getAppIdAdapter().encode(Integer.valueOf(this.getAppId())));
                }
            });
        }

        public final int getAppId() {
            return this.appId;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBApp"}, listener);
        }

        public String toString() {
            return "Apps.sq:getApp";
        }
    }

    /* compiled from: AppsQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetPositionQuery<T> extends Query<T> {
        private final int appId;
        final /* synthetic */ AppsQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetPositionQuery(AppsQueries appsQueries, int r3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = appsQueries;
            this.appId = r3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBAppPositions"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final AppsQueries appsQueries = this.this$0;
            return driver.executeQuery(1689791879, "SELECT position\nFROM DBAppPositions\nWHERE appId = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$GetPositionQuery$execute$1
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
                    DBAppPositions.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    adapter = AppsQueries.this.DBAppPositionsAdapter;
                    executeQuery.bindLong(0, adapter.getAppIdAdapter().encode(Integer.valueOf(this.getAppId())));
                }
            });
        }

        public final int getAppId() {
            return this.appId;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBAppPositions"}, listener);
        }

        public String toString() {
            return "Apps.sq:getPosition";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsQueries(SqlDriver driver, DBApp.Adapter DBAppAdapter, DBAppPositions.Adapter DBAppPositionsAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(DBAppAdapter, "DBAppAdapter");
        Intrinsics.checkNotNullParameter(DBAppPositionsAdapter, "DBAppPositionsAdapter");
        this.DBAppAdapter = DBAppAdapter;
        this.DBAppPositionsAdapter = DBAppPositionsAdapter;
    }

    public final void addApp(final Integer num, final long j) {
        getDriver().execute(-1885752872, "INSERT INTO DBApp(appId, data_hash)\nVALUES (?,?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$addApp$1
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
                Long l;
                DBApp.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                Integer num2 = num;
                if (num2 != null) {
                    AppsQueries appsQueries = this;
                    int intValue = num2.intValue();
                    adapter = appsQueries.DBAppAdapter;
                    l = Long.valueOf(adapter.getAppIdAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l = null;
                }
                execute.bindLong(0, l);
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(-1885752872, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$addApp$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApp");
            }
        });
    }

    public final void clearApps() {
        getDriver().execute(-1044711609, "DELETE FROM DBApp", null);
        notifyQueries(-1044711609, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$clearApps$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApp");
            }
        });
    }

    public final void clearPositions() {
        getDriver().execute(352787637, "DELETE FROM DBAppPositions", null);
        notifyQueries(352787637, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$clearPositions$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBAppPositions");
            }
        });
    }

    public final Query<Integer> getAllAppIds() {
        return UrlKt.Query(-1813756614, new String[]{"DBApp"}, getDriver(), "Apps.sq", "getAllAppIds", "SELECT appId\nFROM DBApp", new Function1<SqlCursor, Integer>() { // from class: com.animaconnected.watch.sync.AppsQueries$getAllAppIds$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(SqlCursor cursor) {
                DBApp.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                adapter = AppsQueries.this.DBAppAdapter;
                return (Integer) FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 0, adapter.getAppIdAdapter());
            }
        });
    }

    public final <T> Query<T> getAllApps(final Function2<? super Integer, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(-1436522603, new String[]{"DBApp"}, getDriver(), "Apps.sq", "getAllApps", "SELECT *\nFROM DBApp", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.AppsQueries$getAllApps$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBApp.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Integer, Long, T> function2 = mapper;
                adapter = this.DBAppAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 0, adapter.getAppIdAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                return (T) function2.invoke(m, l);
            }
        });
    }

    public final <T> Query<T> getAllPositions(final Function2<? super Integer, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(1868672295, new String[]{"DBAppPositions"}, getDriver(), "Apps.sq", "getAllPositions", "SELECT *\nFROM DBAppPositions\nORDER BY position ASC", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.AppsQueries$getAllPositions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBAppPositions.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Integer, Long, T> function2 = mapper;
                adapter = this.DBAppPositionsAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 0, adapter.getAppIdAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                return (T) function2.invoke(m, l);
            }
        });
    }

    public final <T> Query<T> getApp(int r3, final Function2<? super Integer, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetAppQuery(this, r3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.AppsQueries$getApp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBApp.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<Integer, Long, T> function2 = mapper;
                adapter = this.DBAppAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 0, adapter.getAppIdAdapter());
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                return (T) function2.invoke(m, l);
            }
        });
    }

    public final Query<Long> getPosition(int r3) {
        return new GetPositionQuery(this, r3, new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.sync.AppsQueries$getPosition$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final void removeApp(final int r5) {
        getDriver().execute(1509096421, "DELETE FROM DBApp\nWHERE appId = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$removeApp$1
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
                DBApp.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = AppsQueries.this.DBAppAdapter;
                execute.bindLong(0, adapter.getAppIdAdapter().encode(Integer.valueOf(r5)));
            }
        });
        notifyQueries(1509096421, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$removeApp$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApp");
            }
        });
    }

    public final void removePosition(final int r5) {
        getDriver().execute(-790654491, "DELETE FROM DBAppPositions\nWHERE appId = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$removePosition$1
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
                DBAppPositions.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = AppsQueries.this.DBAppPositionsAdapter;
                execute.bindLong(0, adapter.getAppIdAdapter().encode(Integer.valueOf(r5)));
            }
        });
        notifyQueries(-790654491, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$removePosition$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBAppPositions");
            }
        });
    }

    public final void updateApp(final Integer num, final long j) {
        getDriver().execute(-1722476160, "INSERT OR REPLACE INTO DBApp(appId, data_hash)\nVALUES (?,?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$updateApp$1
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
                Long l;
                DBApp.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                Integer num2 = num;
                if (num2 != null) {
                    AppsQueries appsQueries = this;
                    int intValue = num2.intValue();
                    adapter = appsQueries.DBAppAdapter;
                    l = Long.valueOf(adapter.getAppIdAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l = null;
                }
                execute.bindLong(0, l);
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(-1722476160, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$updateApp$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApp");
            }
        });
    }

    public final void updatePosition(final Integer num, final long j) {
        getDriver().execute(1673968938, "INSERT OR REPLACE INTO DBAppPositions(appId, position)\nVALUES (?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$updatePosition$1
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
                Long l;
                DBAppPositions.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                Integer num2 = num;
                if (num2 != null) {
                    AppsQueries appsQueries = this;
                    int intValue = num2.intValue();
                    adapter = appsQueries.DBAppPositionsAdapter;
                    l = Long.valueOf(adapter.getAppIdAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l = null;
                }
                execute.bindLong(0, l);
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(1673968938, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.AppsQueries$updatePosition$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBAppPositions");
            }
        });
    }

    public final Query<DBApp> getAllApps() {
        return getAllApps(new Function2<Integer, Long, DBApp>() { // from class: com.animaconnected.watch.sync.AppsQueries$getAllApps$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ DBApp invoke(Integer num, Long l) {
                return invoke(num.intValue(), l.longValue());
            }

            public final DBApp invoke(int r2, long j) {
                return new DBApp(r2, j);
            }
        });
    }

    public final Query<DBAppPositions> getAllPositions() {
        return getAllPositions(new Function2<Integer, Long, DBAppPositions>() { // from class: com.animaconnected.watch.sync.AppsQueries$getAllPositions$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ DBAppPositions invoke(Integer num, Long l) {
                return invoke(num.intValue(), l.longValue());
            }

            public final DBAppPositions invoke(int r2, long j) {
                return new DBAppPositions(r2, j);
            }
        });
    }

    public final Query<DBApp> getApp(int r2) {
        return getApp(r2, new Function2<Integer, Long, DBApp>() { // from class: com.animaconnected.watch.sync.AppsQueries$getApp$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ DBApp invoke(Integer num, Long l) {
                return invoke(num.intValue(), l.longValue());
            }

            public final DBApp invoke(int r22, long j) {
                return new DBApp(r22, j);
            }
        });
    }
}
