package com.animaconnected.watch.storage.models;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0;
import com.animaconnected.watch.storage.models.DBWatch;
import com.animaconnected.watch.storage.models.DBWatchQueries;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBWatchQueries.kt */
/* loaded from: classes3.dex */
public final class DBWatchQueries extends TransacterImpl {
    private final DBWatch.Adapter DBWatchAdapter;

    /* compiled from: DBWatchQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetWatchByAddressQuery<T> extends Query<T> {
        private final String address;
        final /* synthetic */ DBWatchQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetWatchByAddressQuery(DBWatchQueries dBWatchQueries, String address, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = dBWatchQueries;
            this.address = address;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBWatch"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1682200699, "SELECT * FROM DBWatch WHERE device_address IN (?)", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$GetWatchByAddressQuery$execute$1
                final /* synthetic */ DBWatchQueries.GetWatchByAddressQuery<T> this$0;

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
                    executeQuery.bindString(0, this.this$0.getAddress());
                }
            });
        }

        public final String getAddress() {
            return this.address;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBWatch"}, listener);
        }

        public String toString() {
            return "DBWatch.sq:getWatchByAddress";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBWatchQueries(SqlDriver driver, DBWatch.Adapter DBWatchAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(DBWatchAdapter, "DBWatchAdapter");
        this.DBWatchAdapter = DBWatchAdapter;
    }

    public final void delete(final String device_address) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        getDriver().execute(-1921807852, "DELETE FROM DBWatch WHERE device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$delete$1
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
                execute.bindString(0, device_address);
            }
        });
        notifyQueries(-1921807852, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$delete$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final <T> Query<T> getAll(final Function9<? super String, ? super Integer, ? super String, ? super String, ? super Boolean, ? super Long, ? super Long, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(-1835716908, new String[]{"DBWatch"}, getDriver(), "DBWatch.sq", "getAll", "SELECT * FROM DBWatch", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$getAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBWatch.Adapter adapter;
                Integer num;
                DBWatch.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function9<String, Integer, String, String, Boolean, Long, Long, Integer, String, T> function9 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                adapter = this.DBWatchAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getDevice_typeAdapter());
                String string2 = cursor.getString(2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                Boolean bool = cursor.getBoolean(4);
                Intrinsics.checkNotNull(bool);
                Long l = cursor.getLong(5);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(6);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(7);
                if (l3 != null) {
                    DBWatchQueries dBWatchQueries = this;
                    long longValue = l3.longValue();
                    adapter2 = dBWatchQueries.DBWatchAdapter;
                    num = Integer.valueOf(adapter2.getVariantAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return (T) function9.invoke(string, m, string2, string3, bool, l, l2, num, cursor.getString(8));
            }
        });
    }

    public final Query<Long> getCount() {
        return UrlKt.Query(1109558658, new String[]{"DBWatch"}, getDriver(), "DBWatch.sq", "getCount", "SELECT COUNT(*) FROM DBWatch", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$getCount$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final <T> Query<T> getWatchByAddress(String address, final Function9<? super String, ? super Integer, ? super String, ? super String, ? super Boolean, ? super Long, ? super Long, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetWatchByAddressQuery(this, address, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$getWatchByAddress$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBWatch.Adapter adapter;
                Integer num;
                DBWatch.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function9<String, Integer, String, String, Boolean, Long, Long, Integer, String, T> function9 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                adapter = this.DBWatchAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getDevice_typeAdapter());
                String string2 = cursor.getString(2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                Boolean bool = cursor.getBoolean(4);
                Intrinsics.checkNotNull(bool);
                Long l = cursor.getLong(5);
                Intrinsics.checkNotNull(l);
                Long l2 = cursor.getLong(6);
                Intrinsics.checkNotNull(l2);
                Long l3 = cursor.getLong(7);
                if (l3 != null) {
                    DBWatchQueries dBWatchQueries = this;
                    long longValue = l3.longValue();
                    adapter2 = dBWatchQueries.DBWatchAdapter;
                    num = Integer.valueOf(adapter2.getVariantAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return (T) function9.invoke(string, m, string2, string3, bool, l, l2, num, cursor.getString(8));
            }
        });
    }

    public final void insertAll(final DBWatch DBWatch) {
        Intrinsics.checkNotNullParameter(DBWatch, "DBWatch");
        getDriver().execute(-689352929, "INSERT INTO DBWatch (device_address, device_type, sku, last_dfu_result, stronger_vibration, time_diagnostics_sent, time_since_daily, variant, category)\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$insertAll$1
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
                DBWatch.Adapter adapter;
                Long l;
                DBWatch.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(0, DBWatch.this.getDevice_address());
                adapter = this.DBWatchAdapter;
                execute.bindLong(1, adapter.getDevice_typeAdapter().encode(Integer.valueOf(DBWatch.this.getDevice_type())));
                execute.bindString(2, DBWatch.this.getSku());
                execute.bindString(3, DBWatch.this.getLast_dfu_result());
                execute.bindBoolean(4, Boolean.valueOf(DBWatch.this.getStronger_vibration()));
                execute.bindLong(5, Long.valueOf(DBWatch.this.getTime_diagnostics_sent()));
                execute.bindLong(6, Long.valueOf(DBWatch.this.getTime_since_daily()));
                Integer variant = DBWatch.this.getVariant();
                if (variant != null) {
                    DBWatchQueries dBWatchQueries = this;
                    int intValue = variant.intValue();
                    adapter2 = dBWatchQueries.DBWatchAdapter;
                    l = Long.valueOf(adapter2.getVariantAdapter().encode(Integer.valueOf(intValue)).longValue());
                } else {
                    l = null;
                }
                execute.bindLong(7, l);
                execute.bindString(8, DBWatch.this.getCategory());
            }
        });
        notifyQueries(-689352929, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$insertAll$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final void updateCategory(final String str, final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        getDriver().execute(-1732572080, "UPDATE DBWatch SET category = ? WHERE device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateCategory$1
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
                execute.bindString(0, str);
                execute.bindString(1, address);
            }
        });
        notifyQueries(-1732572080, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateCategory$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final void updateLastDfuResult(final String lastDfuResult, final String address) {
        Intrinsics.checkNotNullParameter(lastDfuResult, "lastDfuResult");
        Intrinsics.checkNotNullParameter(address, "address");
        getDriver().execute(981045288, "UPDATE DBWatch SET last_dfu_result = ? WHERE device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateLastDfuResult$1
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
                execute.bindString(0, lastDfuResult);
                execute.bindString(1, address);
            }
        });
        notifyQueries(981045288, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateLastDfuResult$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final void updateSku(final String str, final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        getDriver().execute(2040898187, "UPDATE DBWatch SET sku = ? WHERE device_address IN (?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateSku$1
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
                execute.bindString(0, str);
                execute.bindString(1, address);
            }
        });
        notifyQueries(2040898187, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateSku$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final void updateStrongerVibration(final boolean z, final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        getDriver().execute(910432860, "UPDATE DBWatch SET stronger_vibration = ? WHERE device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateStrongerVibration$1
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
                execute.bindBoolean(0, Boolean.valueOf(z));
                execute.bindString(1, address);
            }
        });
        notifyQueries(910432860, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateStrongerVibration$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final void updateTimeDiagnosticsSent(final long j, final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        getDriver().execute(-2026028475, "UPDATE DBWatch SET time_diagnostics_sent = ? WHERE device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateTimeDiagnosticsSent$1
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
                execute.bindString(1, address);
            }
        });
        notifyQueries(-2026028475, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateTimeDiagnosticsSent$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final void updateTimeSinceDaily(final long j, final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        getDriver().execute(1724631934, "UPDATE DBWatch SET time_since_daily = ? WHERE device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateTimeSinceDaily$1
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
                execute.bindString(1, address);
            }
        });
        notifyQueries(1724631934, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$updateTimeSinceDaily$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatch");
            }
        });
    }

    public final Query<DBWatch> getAll() {
        return getAll(new Function9<String, Integer, String, String, Boolean, Long, Long, Integer, String, DBWatch>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$getAll$2
            @Override // kotlin.jvm.functions.Function9
            public /* bridge */ /* synthetic */ DBWatch invoke(String str, Integer num, String str2, String str3, Boolean bool, Long l, Long l2, Integer num2, String str4) {
                return invoke(str, num.intValue(), str2, str3, bool.booleanValue(), l.longValue(), l2.longValue(), num2, str4);
            }

            public final DBWatch invoke(String device_address, int r15, String str, String last_dfu_result, boolean z, long j, long j2, Integer num, String str2) {
                Intrinsics.checkNotNullParameter(device_address, "device_address");
                Intrinsics.checkNotNullParameter(last_dfu_result, "last_dfu_result");
                return new DBWatch(device_address, r15, str, last_dfu_result, z, j, j2, num, str2);
            }
        });
    }

    public final Query<DBWatch> getWatchByAddress(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return getWatchByAddress(address, new Function9<String, Integer, String, String, Boolean, Long, Long, Integer, String, DBWatch>() { // from class: com.animaconnected.watch.storage.models.DBWatchQueries$getWatchByAddress$2
            @Override // kotlin.jvm.functions.Function9
            public /* bridge */ /* synthetic */ DBWatch invoke(String str, Integer num, String str2, String str3, Boolean bool, Long l, Long l2, Integer num2, String str4) {
                return invoke(str, num.intValue(), str2, str3, bool.booleanValue(), l.longValue(), l2.longValue(), num2, str4);
            }

            public final DBWatch invoke(String device_address, int r15, String str, String last_dfu_result, boolean z, long j, long j2, Integer num, String str2) {
                Intrinsics.checkNotNullParameter(device_address, "device_address");
                Intrinsics.checkNotNullParameter(last_dfu_result, "last_dfu_result");
                return new DBWatch(device_address, r15, str, last_dfu_result, z, j, j2, num, str2);
            }
        });
    }
}
