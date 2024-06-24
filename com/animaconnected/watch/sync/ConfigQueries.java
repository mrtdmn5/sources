package com.animaconnected.watch.sync;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0;
import com.animaconnected.watch.sync.ConfigQueries;
import com.animaconnected.watch.sync.DBConfig;
import com.animaconnected.watch.sync.DBPreferences;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigQueries.kt */
/* loaded from: classes3.dex */
public final class ConfigQueries extends TransacterImpl {
    private final DBConfig.Adapter DBConfigAdapter;
    private final DBPreferences.Adapter DBPreferencesAdapter;

    /* compiled from: ConfigQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetConfigQuery<T> extends Query<T> {
        private final String command;
        private final int hash;
        private final String id;
        final /* synthetic */ ConfigQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetConfigQuery(ConfigQueries configQueries, String id, String command, int r5, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = configQueries;
            this.id = id;
            this.command = command;
            this.hash = r5;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBConfig"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final ConfigQueries configQueries = this.this$0;
            return driver.executeQuery(212766288, "SELECT *\nFROM DBConfig\nWHERE identifier = ? AND command = ? AND data_hash = ?", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.ConfigQueries$GetConfigQuery$execute$1
                final /* synthetic */ ConfigQueries.GetConfigQuery<T> this$0;

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
                    DBConfig.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindString(0, this.this$0.getId());
                    executeQuery.bindString(1, this.this$0.getCommand());
                    adapter = configQueries.DBConfigAdapter;
                    executeQuery.bindLong(2, adapter.getData_hashAdapter().encode(Integer.valueOf(this.this$0.getHash())));
                }
            });
        }

        public final String getCommand() {
            return this.command;
        }

        public final int getHash() {
            return this.hash;
        }

        public final String getId() {
            return this.id;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBConfig"}, listener);
        }

        public String toString() {
            return "Config.sq:getConfig";
        }
    }

    /* compiled from: ConfigQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetPreferenceGlobalQuery<T> extends Query<T> {
        private final int preferenceId;
        final /* synthetic */ ConfigQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetPreferenceGlobalQuery(ConfigQueries configQueries, int r3, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = configQueries;
            this.preferenceId = r3;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBPreferences"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final ConfigQueries configQueries = this.this$0;
            return driver.executeQuery(1721855468, "SELECT *\nFROM DBPreferences\nWHERE preferenceId = ? LIMIT 1", mapper, 1, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$GetPreferenceGlobalQuery$execute$1
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
                    DBPreferences.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    adapter = ConfigQueries.this.DBPreferencesAdapter;
                    executeQuery.bindLong(0, adapter.getPreferenceIdAdapter().encode(Integer.valueOf(this.getPreferenceId())));
                }
            });
        }

        public final int getPreferenceId() {
            return this.preferenceId;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBPreferences"}, listener);
        }

        public String toString() {
            return "Config.sq:getPreferenceGlobal";
        }
    }

    /* compiled from: ConfigQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetPreferenceQuery<T> extends Query<T> {
        private final String id;
        private final int preferenceId;
        final /* synthetic */ ConfigQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetPreferenceQuery(ConfigQueries configQueries, String id, int r4, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = configQueries;
            this.id = id;
            this.preferenceId = r4;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBPreferences"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final ConfigQueries configQueries = this.this$0;
            return driver.executeQuery(1387499753, "SELECT *\nFROM DBPreferences\nWHERE identifier = ? AND preferenceId = ?", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.ConfigQueries$GetPreferenceQuery$execute$1
                final /* synthetic */ ConfigQueries.GetPreferenceQuery<T> this$0;

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
                    DBPreferences.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindString(0, this.this$0.getId());
                    adapter = configQueries.DBPreferencesAdapter;
                    executeQuery.bindLong(1, adapter.getPreferenceIdAdapter().encode(Integer.valueOf(this.this$0.getPreferenceId())));
                }
            });
        }

        public final String getId() {
            return this.id;
        }

        public final int getPreferenceId() {
            return this.preferenceId;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBPreferences"}, listener);
        }

        public String toString() {
            return "Config.sq:getPreference";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigQueries(SqlDriver driver, DBConfig.Adapter DBConfigAdapter, DBPreferences.Adapter DBPreferencesAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(DBConfigAdapter, "DBConfigAdapter");
        Intrinsics.checkNotNullParameter(DBPreferencesAdapter, "DBPreferencesAdapter");
        this.DBConfigAdapter = DBConfigAdapter;
        this.DBPreferencesAdapter = DBPreferencesAdapter;
    }

    public final void addConfig(final String identifier, final String command, final int r7) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(command, "command");
        getDriver().execute(-590408869, "INSERT INTO DBConfig(identifier, command, data_hash)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$addConfig$1
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
                DBConfig.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(0, identifier);
                execute.bindString(1, command);
                adapter = this.DBConfigAdapter;
                execute.bindLong(2, adapter.getData_hashAdapter().encode(Integer.valueOf(r7)));
            }
        });
        notifyQueries(-590408869, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$addConfig$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBConfig");
            }
        });
    }

    public final void clearConfigs() {
        getDriver().execute(890210124, "DELETE FROM DBConfig", null);
        notifyQueries(890210124, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$clearConfigs$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBConfig");
            }
        });
    }

    public final void clearPreferences() {
        getDriver().execute(-53535917, "DELETE FROM DBPreferences", null);
        notifyQueries(-53535917, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$clearPreferences$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBPreferences");
            }
        });
    }

    public final void clearPreferencesForDevice(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getDriver().execute(-1937887636, "DELETE FROM DBPreferences\nWHERE identifier = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$clearPreferencesForDevice$1
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
                execute.bindString(0, id);
            }
        });
        notifyQueries(-1937887636, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$clearPreferencesForDevice$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBPreferences");
            }
        });
    }

    public final <T> Query<T> getConfig(String id, String command, int r10, final Function3<? super String, ? super String, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetConfigQuery(this, id, command, r10, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.ConfigQueries$getConfig$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBConfig.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, String, Integer, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(1);
                Intrinsics.checkNotNull(string2);
                adapter = this.DBConfigAdapter;
                return (T) function3.invoke(string, string2, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter.getData_hashAdapter()));
            }
        });
    }

    public final <T> Query<T> getPreference(String id, int r4, final Function3<? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetPreferenceQuery(this, id, r4, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.ConfigQueries$getPreference$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBPreferences.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Integer, String, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                adapter = this.DBPreferencesAdapter;
                return (T) function3.invoke(string, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getPreferenceIdAdapter()), cursor.getString(2));
            }
        });
    }

    public final <T> Query<T> getPreferenceGlobal(int r3, final Function3<? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetPreferenceGlobalQuery(this, r3, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.ConfigQueries$getPreferenceGlobal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBPreferences.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Integer, String, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                adapter = this.DBPreferencesAdapter;
                return (T) function3.invoke(string, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getPreferenceIdAdapter()), cursor.getString(2));
            }
        });
    }

    public final Query<String> getPreferencesIdentifiers() {
        return UrlKt.Query(-790604320, new String[]{"DBPreferences"}, getDriver(), "Config.sq", "getPreferencesIdentifiers", "SELECT DISTINCT identifier FROM DBPreferences", new Function1<SqlCursor, String>() { // from class: com.animaconnected.watch.sync.ConfigQueries$getPreferencesIdentifiers$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                return string;
            }
        });
    }

    public final void removeConfig(final String id, final String command) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(command, "command");
        getDriver().execute(-1353321010, "DELETE FROM DBConfig\nWHERE identifier = ? AND command = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$removeConfig$1
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
                execute.bindString(0, id);
                execute.bindString(1, command);
            }
        });
        notifyQueries(-1353321010, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$removeConfig$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBConfig");
            }
        });
    }

    public final void setPreference(final String identifier, final int r6, final String str) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(-2133336331, "INSERT OR REPLACE INTO DBPreferences(identifier, preferenceId, value)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$setPreference$1
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
                DBPreferences.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(0, identifier);
                adapter = this.DBPreferencesAdapter;
                execute.bindLong(1, adapter.getPreferenceIdAdapter().encode(Integer.valueOf(r6)));
                execute.bindString(2, str);
            }
        });
        notifyQueries(-2133336331, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.ConfigQueries$setPreference$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBPreferences");
            }
        });
    }

    public final Query<DBConfig> getConfig(String id, String command, int r4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(command, "command");
        return getConfig(id, command, r4, new Function3<String, String, Integer, DBConfig>() { // from class: com.animaconnected.watch.sync.ConfigQueries$getConfig$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBConfig invoke(String str, String str2, Integer num) {
                return invoke(str, str2, num.intValue());
            }

            public final DBConfig invoke(String identifier, String command_, int r42) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(command_, "command_");
                return new DBConfig(identifier, command_, r42);
            }
        });
    }

    public final Query<DBPreferences> getPreference(String id, int r3) {
        Intrinsics.checkNotNullParameter(id, "id");
        return getPreference(id, r3, new Function3<String, Integer, String, DBPreferences>() { // from class: com.animaconnected.watch.sync.ConfigQueries$getPreference$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBPreferences invoke(String str, Integer num, String str2) {
                return invoke(str, num.intValue(), str2);
            }

            public final DBPreferences invoke(String identifier, int r32, String str) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new DBPreferences(identifier, r32, str);
            }
        });
    }

    public final Query<DBPreferences> getPreferenceGlobal(int r2) {
        return getPreferenceGlobal(r2, new Function3<String, Integer, String, DBPreferences>() { // from class: com.animaconnected.watch.sync.ConfigQueries$getPreferenceGlobal$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ DBPreferences invoke(String str, Integer num, String str2) {
                return invoke(str, num.intValue(), str2);
            }

            public final DBPreferences invoke(String identifier, int r3, String str) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new DBPreferences(identifier, r3, str);
            }
        });
    }
}
