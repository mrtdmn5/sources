package com.animaconnected.watch.model.alarms;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.alarms.Alarms;
import com.animaconnected.watch.model.alarms.AlarmsQueries;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlarmsQueries.kt */
/* loaded from: classes3.dex */
public final class AlarmsQueries extends TransacterImpl {
    private final Alarms.Adapter alarmsAdapter;

    /* compiled from: AlarmsQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetQuery<T> extends Query<T> {
        private final long _id;
        final /* synthetic */ AlarmsQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetQuery(AlarmsQueries alarmsQueries, long j, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = alarmsQueries;
            this._id = j;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"alarms"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-635453286, "SELECT *\nFROM alarms\nWHERE _id = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$GetQuery$execute$1
                final /* synthetic */ AlarmsQueries.GetQuery<T> this$0;

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
                    executeQuery.bindLong(0, Long.valueOf(this.this$0.get_id()));
                }
            });
        }

        public final long get_id() {
            return this._id;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"alarms"}, listener);
        }

        public String toString() {
            return "alarms.sq:get";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmsQueries(SqlDriver driver, Alarms.Adapter alarmsAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(alarmsAdapter, "alarmsAdapter");
        this.alarmsAdapter = alarmsAdapter;
    }

    public final void deleteAlarm(final long j) {
        getDriver().execute(318932138, "DELETE FROM alarms\nWHERE _id = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$deleteAlarm$1
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
        notifyQueries(318932138, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$deleteAlarm$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("alarms");
            }
        });
    }

    public final <T> Query<T> get(long j, final Function7<? super Long, ? super Integer, ? super Integer, ? super DaysOfWeek, ? super Boolean, ? super Boolean, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetQuery(this, j, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$get$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Alarms.Adapter adapter;
                Alarms.Adapter adapter2;
                Alarms.Adapter adapter3;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<Long, Integer, Integer, DaysOfWeek, Boolean, Boolean, Long, T> function7 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                adapter = this.alarmsAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getHourAdapter());
                adapter2 = this.alarmsAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getMinutesAdapter());
                adapter3 = this.alarmsAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getDaysofweekAdapter());
                Boolean bool = cursor.getBoolean(4);
                Intrinsics.checkNotNull(bool);
                Boolean bool2 = cursor.getBoolean(5);
                Intrinsics.checkNotNull(bool2);
                Long l2 = cursor.getLong(6);
                Intrinsics.checkNotNull(l2);
                return (T) function7.invoke(l, m, m2, m3, bool, bool2, l2);
            }
        });
    }

    public final <T> Query<T> getAll(final Function7<? super Long, ? super Integer, ? super Integer, ? super DaysOfWeek, ? super Boolean, ? super Boolean, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(1427063463, new String[]{"alarms"}, getDriver(), "alarms.sq", "getAll", "SELECT *\nFROM alarms", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$getAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Alarms.Adapter adapter;
                Alarms.Adapter adapter2;
                Alarms.Adapter adapter3;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function7<Long, Integer, Integer, DaysOfWeek, Boolean, Boolean, Long, T> function7 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                adapter = this.alarmsAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getHourAdapter());
                adapter2 = this.alarmsAdapter;
                Object m2 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getMinutesAdapter());
                adapter3 = this.alarmsAdapter;
                Object m3 = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 3, adapter3.getDaysofweekAdapter());
                Boolean bool = cursor.getBoolean(4);
                Intrinsics.checkNotNull(bool);
                Boolean bool2 = cursor.getBoolean(5);
                Intrinsics.checkNotNull(bool2);
                Long l2 = cursor.getLong(6);
                Intrinsics.checkNotNull(l2);
                return (T) function7.invoke(l, m, m2, m3, bool, bool2, l2);
            }
        });
    }

    public final void insertAlarm(final Alarms alarms) {
        Intrinsics.checkNotNullParameter(alarms, "alarms");
        getDriver().execute(1337606236, "INSERT OR REPLACE INTO alarms(_id, hour, minutes, daysofweek, enabled, last_modified)\nVALUES (?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$insertAlarm$1
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
                Alarms.Adapter adapter;
                Alarms.Adapter adapter2;
                Alarms.Adapter adapter3;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindLong(0, Long.valueOf(Alarms.this.get_id()));
                adapter = this.alarmsAdapter;
                execute.bindLong(1, adapter.getHourAdapter().encode(Integer.valueOf(Alarms.this.getHour())));
                adapter2 = this.alarmsAdapter;
                execute.bindLong(2, adapter2.getMinutesAdapter().encode(Integer.valueOf(Alarms.this.getMinutes())));
                adapter3 = this.alarmsAdapter;
                execute.bindLong(3, adapter3.getDaysofweekAdapter().encode(Alarms.this.getDaysofweek()));
                execute.bindBoolean(4, Boolean.valueOf(Alarms.this.getEnabled()));
                execute.bindLong(5, Long.valueOf(Alarms.this.getLast_modified()));
            }
        });
        notifyQueries(1337606236, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$insertAlarm$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("alarms");
            }
        });
    }

    public final Query<Alarms> get(long j) {
        return get(j, new Function7<Long, Integer, Integer, DaysOfWeek, Boolean, Boolean, Long, Alarms>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$get$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ Alarms invoke(Long l, Integer num, Integer num2, DaysOfWeek daysOfWeek, Boolean bool, Boolean bool2, Long l2) {
                return invoke(l.longValue(), num.intValue(), num2.intValue(), daysOfWeek, bool.booleanValue(), bool2.booleanValue(), l2.longValue());
            }

            public final Alarms invoke(long j2, int r14, int r15, DaysOfWeek daysofweek, boolean z, boolean z2, long j3) {
                Intrinsics.checkNotNullParameter(daysofweek, "daysofweek");
                return new Alarms(j2, r14, r15, daysofweek, z, z2, j3);
            }
        });
    }

    public final Query<Alarms> getAll() {
        return getAll(new Function7<Long, Integer, Integer, DaysOfWeek, Boolean, Boolean, Long, Alarms>() { // from class: com.animaconnected.watch.model.alarms.AlarmsQueries$getAll$2
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ Alarms invoke(Long l, Integer num, Integer num2, DaysOfWeek daysOfWeek, Boolean bool, Boolean bool2, Long l2) {
                return invoke(l.longValue(), num.intValue(), num2.intValue(), daysOfWeek, bool.booleanValue(), bool2.booleanValue(), l2.longValue());
            }

            public final Alarms invoke(long j, int r14, int r15, DaysOfWeek daysofweek, boolean z, boolean z2, long j2) {
                Intrinsics.checkNotNullParameter(daysofweek, "daysofweek");
                return new Alarms(j, r14, r15, daysofweek, z, z2, j2);
            }
        });
    }
}
