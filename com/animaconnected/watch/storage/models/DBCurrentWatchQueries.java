package com.animaconnected.watch.storage.models;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.storage.models.DBWatch;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBCurrentWatchQueries.kt */
/* loaded from: classes3.dex */
public final class DBCurrentWatchQueries extends TransacterImpl {
    private final DBWatch.Adapter DBWatchAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBCurrentWatchQueries(SqlDriver driver, DBWatch.Adapter DBWatchAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(DBWatchAdapter, "DBWatchAdapter");
        this.DBWatchAdapter = DBWatchAdapter;
    }

    public final void deleteCurrent() {
        getDriver().execute(1132201590, "DELETE FROM DBCurrentWatch WHERE id = 1", null);
        notifyQueries(1132201590, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$deleteCurrent$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBCurrentWatch");
            }
        });
    }

    public final <T> Query<T> getCurrent(final Function9<? super String, ? super Integer, ? super String, ? super String, ? super Boolean, ? super Long, ? super Long, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(379415835, new String[]{"DBWatch", "DBCurrentWatch"}, getDriver(), "DBCurrentWatch.sq", "getCurrent", "SELECT DBWatch.* FROM DBCurrentWatch LEFT JOIN DBWatch ON DBCurrentWatch.current_address = DBWatch.device_address WHERE DBCurrentWatch.id = 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$getCurrent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBWatch.Adapter adapter;
                DBWatch.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function9<String, Integer, String, String, Boolean, Long, Long, Integer, String, T> function9 = mapper;
                String string = cursor.getString(0);
                Long l = cursor.getLong(1);
                Integer num2 = null;
                if (l != null) {
                    DBCurrentWatchQueries dBCurrentWatchQueries = this;
                    long longValue = l.longValue();
                    adapter2 = dBCurrentWatchQueries.DBWatchAdapter;
                    num = Integer.valueOf(adapter2.getDevice_typeAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                String string2 = cursor.getString(2);
                String string3 = cursor.getString(3);
                Boolean bool = cursor.getBoolean(4);
                Long l2 = cursor.getLong(5);
                Long l3 = cursor.getLong(6);
                Long l4 = cursor.getLong(7);
                if (l4 != null) {
                    DBCurrentWatchQueries dBCurrentWatchQueries2 = this;
                    long longValue2 = l4.longValue();
                    adapter = dBCurrentWatchQueries2.DBWatchAdapter;
                    num2 = Integer.valueOf(adapter.getVariantAdapter().decode(Long.valueOf(longValue2)).intValue());
                }
                return function9.invoke(string, num, string2, string3, bool, l2, l3, num2, cursor.getString(8));
            }
        });
    }

    public final <T> Query<T> getCurrentAddress(final Function1<? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(-1569856935, new String[]{"DBCurrentWatch"}, getDriver(), "DBCurrentWatch.sq", "getCurrentAddress", "SELECT DBCurrentWatch.current_address FROM DBCurrentWatch WHERE id = 1", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$getCurrentAddress$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                return mapper.invoke(cursor.getString(0));
            }
        });
    }

    public final void insertCurrent(final DBCurrentWatch DBCurrentWatch) {
        Intrinsics.checkNotNullParameter(DBCurrentWatch, "DBCurrentWatch");
        getDriver().execute(825466280, "INSERT INTO DBCurrentWatch (id, current_address)\nVALUES (?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$insertCurrent$1
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
                execute.bindLong(0, Long.valueOf(DBCurrentWatch.this.getId()));
                execute.bindString(1, DBCurrentWatch.this.getCurrent_address());
            }
        });
        notifyQueries(825466280, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$insertCurrent$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBCurrentWatch");
            }
        });
    }

    public final void updateCurrent(final String str) {
        getDriver().execute(-158976616, "UPDATE DBCurrentWatch SET current_address = ? WHERE id = 1", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$updateCurrent$1
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
            }
        });
        notifyQueries(-158976616, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$updateCurrent$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBCurrentWatch");
            }
        });
    }

    public final Query<GetCurrent> getCurrent() {
        return getCurrent(new Function9<String, Integer, String, String, Boolean, Long, Long, Integer, String, GetCurrent>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$getCurrent$2
            @Override // kotlin.jvm.functions.Function9
            public final GetCurrent invoke(String str, Integer num, String str2, String str3, Boolean bool, Long l, Long l2, Integer num2, String str4) {
                return new GetCurrent(str, num, str2, str3, bool, l, l2, num2, str4);
            }
        });
    }

    public final Query<GetCurrentAddress> getCurrentAddress() {
        return getCurrentAddress(new Function1<String, GetCurrentAddress>() { // from class: com.animaconnected.watch.storage.models.DBCurrentWatchQueries$getCurrentAddress$2
            @Override // kotlin.jvm.functions.Function1
            public final GetCurrentAddress invoke(String str) {
                return new GetCurrentAddress(str);
            }
        });
    }
}
