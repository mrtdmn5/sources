package com.animaconnected.watch.filter;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.filter.AncsQueries;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AncsQueries.kt */
/* loaded from: classes3.dex */
public final class AncsQueries extends TransacterImpl {

    /* compiled from: AncsQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetAncsFiltersForWatchQuery<T> extends Query<T> {
        private final String identifier;
        final /* synthetic */ AncsQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAncsFiltersForWatchQuery(AncsQueries ancsQueries, String identifier, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = ancsQueries;
            this.identifier = identifier;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBAncsFilter"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-1838892844, "SELECT * FROM DBAncsFilter WHERE identifier = ? ORDER BY  identifier, idx", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.filter.AncsQueries$GetAncsFiltersForWatchQuery$execute$1
                final /* synthetic */ AncsQueries.GetAncsFiltersForWatchQuery<T> this$0;

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
            this.this$0.getDriver().removeListener(new String[]{"DBAncsFilter"}, listener);
        }

        public String toString() {
            return "Ancs.sq:getAncsFiltersForWatch";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AncsQueries(SqlDriver driver) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
    }

    public final void addAncsFilter(final String identifier, final long j, final Long l, final Long l2, final String str, final Long l3) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(-413630608, "INSERT OR REPLACE INTO DBAncsFilter(identifier, idx, ancs_category, ancs_attribute, search_string, vibration_pattern, linked_filter_index, match_method)\nVALUES (?, ?, ?, ?, ?, ?, NULL, NULL)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.AncsQueries$addAncsFilter$1
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
                execute.bindLong(1, Long.valueOf(j));
                execute.bindLong(2, l);
                execute.bindLong(3, l2);
                execute.bindString(4, str);
                execute.bindLong(5, l3);
            }
        });
        notifyQueries(-413630608, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.AncsQueries$addAncsFilter$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBAncsFilter");
            }
        });
    }

    public final void addEmptyAncsFilter(final String identifier, final long j) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(1884147975, "INSERT OR REPLACE INTO DBAncsFilter(identifier, idx)\nVALUES (?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.AncsQueries$addEmptyAncsFilter$1
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
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(1884147975, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.AncsQueries$addEmptyAncsFilter$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBAncsFilter");
            }
        });
    }

    public final void clearAncs() {
        getDriver().execute(1488251652, "DELETE FROM DBAncsFilter", null);
        notifyQueries(1488251652, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.AncsQueries$clearAncs$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBAncsFilter");
            }
        });
    }

    public final <T> Query<T> getAncsFiltersForWatch(String identifier, final Function8<? super String, ? super Long, ? super Long, ? super Long, ? super String, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetAncsFiltersForWatchQuery(this, identifier, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.filter.AncsQueries$getAncsFiltersForWatch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function8<String, Long, Long, Long, String, Long, Long, Long, T> function8 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                return function8.invoke(string, l, cursor.getLong(2), cursor.getLong(3), cursor.getString(4), cursor.getLong(5), cursor.getLong(6), cursor.getLong(7));
            }
        });
    }

    public final void removeAncsFilterWithIdForWatch(final String identifier, final long j) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getDriver().execute(-2139146522, "DELETE FROM DBAncsFilter WHERE identifier = ? AND idx = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.AncsQueries$removeAncsFilterWithIdForWatch$1
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
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(-2139146522, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.AncsQueries$removeAncsFilterWithIdForWatch$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBAncsFilter");
            }
        });
    }

    public final Query<DBAncsFilter> getAncsFiltersForWatch(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return getAncsFiltersForWatch(identifier, new Function8<String, Long, Long, Long, String, Long, Long, Long, DBAncsFilter>() { // from class: com.animaconnected.watch.filter.AncsQueries$getAncsFiltersForWatch$2
            @Override // kotlin.jvm.functions.Function8
            public /* bridge */ /* synthetic */ DBAncsFilter invoke(String str, Long l, Long l2, Long l3, String str2, Long l4, Long l5, Long l6) {
                return invoke(str, l.longValue(), l2, l3, str2, l4, l5, l6);
            }

            public final DBAncsFilter invoke(String identifier_, long j, Long l, Long l2, String str, Long l3, Long l4, Long l5) {
                Intrinsics.checkNotNullParameter(identifier_, "identifier_");
                return new DBAncsFilter(identifier_, j, l, l2, str, l3, l4, l5);
            }
        });
    }
}
