package com.animaconnected.watch.filter;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.filter.ApplicationQueries;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplicationQueries.kt */
/* loaded from: classes3.dex */
public final class ApplicationQueries extends TransacterImpl {

    /* compiled from: ApplicationQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetAllApplicationsBySettingQuery<T> extends Query<T> {
        private final long setting;
        final /* synthetic */ ApplicationQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAllApplicationsBySettingQuery(ApplicationQueries applicationQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = applicationQueries;
            this.setting = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBApplication"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(820054120, "SELECT * FROM DBApplication WHERE setting = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.filter.ApplicationQueries$GetAllApplicationsBySettingQuery$execute$1
                final /* synthetic */ ApplicationQueries.GetAllApplicationsBySettingQuery<T> this$0;

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
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.getSetting()));
                }
            });
        }

        public final long getSetting() {
            return this.setting;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBApplication"}, listener);
        }

        public String toString() {
            return "Application.sq:getAllApplicationsBySetting";
        }
    }

    /* compiled from: ApplicationQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetApplicationQuery<T> extends Query<T> {
        private final String identifier;
        final /* synthetic */ ApplicationQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetApplicationQuery(ApplicationQueries applicationQueries, String identifier, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = applicationQueries;
            this.identifier = identifier;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBApplication"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1618386685, "SELECT * FROM DBApplication WHERE identifier = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.filter.ApplicationQueries$GetApplicationQuery$execute$1
                final /* synthetic */ ApplicationQueries.GetApplicationQuery<T> this$0;

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
                    executeQuery.bindString(0, this.this$0.getIdentifier());
                }
            });
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBApplication"}, listener);
        }

        public String toString() {
            return "Application.sq:getApplication";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationQueries(SqlDriver driver) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
    }

    public final void addOrUpdatesApplication(final String identifier, final String display_name, final long j) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(display_name, "display_name");
        getDriver().execute(2036518951, "INSERT OR REPLACE INTO DBApplication(identifier, display_name, setting)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$addOrUpdatesApplication$1
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
                execute.bindString(0, identifier);
                execute.bindString(1, display_name);
                execute.bindLong(2, Long.valueOf(j));
            }
        });
        notifyQueries(2036518951, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$addOrUpdatesApplication$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApplication");
            }
        });
    }

    public final void clearApplications() {
        getDriver().execute(-972602803, "DELETE FROM DBApplication", null);
        notifyQueries(-972602803, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$clearApplications$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApplication");
            }
        });
    }

    public final <T> Query<T> getAllApplications(final Function3<? super String, ? super Long, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(1996948625, new String[]{"DBApplication"}, getDriver(), "Application.sq", "getAllApplications", "SELECT * FROM DBApplication", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$getAllApplications$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Long, String, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                return function3.invoke(string, l, string2);
            }
        });
    }

    public final <T> Query<T> getAllApplicationsBySetting(long j, final Function3<? super String, ? super Long, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetAllApplicationsBySettingQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$getAllApplicationsBySetting$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Long, String, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                return function3.invoke(string, l, string2);
            }
        });
    }

    public final <T> Query<T> getApplication(String identifier, final Function3<? super String, ? super Long, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetApplicationQuery(this, identifier, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$getApplication$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Long, String, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                return function3.invoke(string, l, string2);
            }
        });
    }

    public final Query<Long> getNbrOfApplications() {
        return UrlKt.Query(-1154920091, new String[]{"DBApplication"}, getDriver(), "Application.sq", "getNbrOfApplications", "SELECT COUNT(*) FROM DBApplication", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$getNbrOfApplications$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final void removeApplication(final String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(-1081960343, "DELETE FROM DBApplication WHERE identifier = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$removeApplication$1
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
                execute.bindString(0, identifier);
            }
        });
        notifyQueries(-1081960343, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$removeApplication$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApplication");
            }
        });
    }

    public final void removeApplicationsWithSetting(final long j) {
        getDriver().execute(-1462378720, "DELETE FROM DBApplication WHERE setting = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$removeApplicationsWithSetting$1
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
        notifyQueries(-1462378720, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$removeApplicationsWithSetting$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBApplication");
            }
        });
    }

    public final Query<DBApplication> getAllApplications() {
        return getAllApplications(new Function3<String, Long, String, DBApplication>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$getAllApplications$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBApplication invoke(String str, Long l, String str2) {
                return invoke(str, l.longValue(), str2);
            }

            public final DBApplication invoke(String identifier, long j, String display_name) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(display_name, "display_name");
                return new DBApplication(identifier, j, display_name);
            }
        });
    }

    public final Query<DBApplication> getAllApplicationsBySetting(long j) {
        return getAllApplicationsBySetting(j, new Function3<String, Long, String, DBApplication>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$getAllApplicationsBySetting$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBApplication invoke(String str, Long l, String str2) {
                return invoke(str, l.longValue(), str2);
            }

            public final DBApplication invoke(String identifier, long j2, String display_name) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(display_name, "display_name");
                return new DBApplication(identifier, j2, display_name);
            }
        });
    }

    public final Query<DBApplication> getApplication(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return getApplication(identifier, new Function3<String, Long, String, DBApplication>() { // from class: com.animaconnected.watch.filter.ApplicationQueries$getApplication$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBApplication invoke(String str, Long l, String str2) {
                return invoke(str, l.longValue(), str2);
            }

            public final DBApplication invoke(String identifier_, long j, String display_name) {
                Intrinsics.checkNotNullParameter(identifier_, "identifier_");
                Intrinsics.checkNotNullParameter(display_name, "display_name");
                return new DBApplication(identifier_, j, display_name);
            }
        });
    }
}
