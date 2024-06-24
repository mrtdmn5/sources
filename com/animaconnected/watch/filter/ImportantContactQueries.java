package com.animaconnected.watch.filter;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.filter.ImportantContactQueries;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImportantContactQueries.kt */
/* loaded from: classes3.dex */
public final class ImportantContactQueries extends TransacterImpl {

    /* compiled from: ImportantContactQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetImportantContactQuery<T> extends Query<T> {
        private final String platform_specific_identifier;
        final /* synthetic */ ImportantContactQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetImportantContactQuery(ImportantContactQueries importantContactQueries, String platform_specific_identifier, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = importantContactQueries;
            this.platform_specific_identifier = platform_specific_identifier;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBImportantContact"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(294464877, "SELECT * FROM DBImportantContact WHERE platform_specific_identifier = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.filter.ImportantContactQueries$GetImportantContactQuery$execute$1
                final /* synthetic */ ImportantContactQueries.GetImportantContactQuery<T> this$0;

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
                    executeQuery.bindString(0, this.this$0.getPlatform_specific_identifier());
                }
            });
        }

        public final String getPlatform_specific_identifier() {
            return this.platform_specific_identifier;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBImportantContact"}, listener);
        }

        public String toString() {
            return "ImportantContact.sq:getImportantContact";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportantContactQueries(SqlDriver driver) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
    }

    public final void addImportantContact(final String platform_specific_identifier, final String display_name, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
        Intrinsics.checkNotNullParameter(display_name, "display_name");
        getDriver().execute(1885282488, "INSERT OR REPLACE INTO DBImportantContact(platform_specific_identifier, display_name, phone_number, email)\nVALUES (?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$addImportantContact$1
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
                execute.bindString(0, platform_specific_identifier);
                execute.bindString(1, display_name);
                execute.bindString(2, str);
                execute.bindString(3, str2);
            }
        });
        notifyQueries(1885282488, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$addImportantContact$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBImportantContact");
            }
        });
    }

    public final void clearImportantContact() {
        getDriver().execute(1609356324, "DELETE FROM DBImportantContact", null);
        notifyQueries(1609356324, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$clearImportantContact$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBImportantContact");
            }
        });
    }

    public final <T> Query<T> getAllImportantContacts(final Function4<? super String, ? super String, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(1064037187, new String[]{"DBImportantContact"}, getDriver(), "ImportantContact.sq", "getAllImportantContacts", "SELECT * FROM DBImportantContact", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$getAllImportantContacts$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function4<String, String, String, String, T> function4 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(1);
                Intrinsics.checkNotNull(string2);
                return function4.invoke(string, string2, cursor.getString(2), cursor.getString(3));
            }
        });
    }

    public final <T> Query<T> getImportantContact(String platform_specific_identifier, final Function4<? super String, ? super String, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetImportantContactQuery(this, platform_specific_identifier, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$getImportantContact$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function4<String, String, String, String, T> function4 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(1);
                Intrinsics.checkNotNull(string2);
                return function4.invoke(string, string2, cursor.getString(2), cursor.getString(3));
            }
        });
    }

    public final Query<Long> getNbrOfImportantContacts() {
        return UrlKt.Query(-1577116689, new String[]{"DBImportantContact"}, getDriver(), "ImportantContact.sq", "getNbrOfImportantContacts", "SELECT COUNT(*) FROM DBImportantContact", new Function1<SqlCursor, Long>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$getNbrOfImportantContacts$1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    public final void removeImportantContact(final String platform_specific_identifier) {
        Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
        getDriver().execute(-1056901303, "DELETE FROM DBImportantContact WHERE platform_specific_identifier = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$removeImportantContact$1
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
                execute.bindString(0, platform_specific_identifier);
            }
        });
        notifyQueries(-1056901303, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$removeImportantContact$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBImportantContact");
            }
        });
    }

    public final Query<DBImportantContact> getAllImportantContacts() {
        return getAllImportantContacts(new Function4<String, String, String, String, DBImportantContact>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$getAllImportantContacts$2
            @Override // kotlin.jvm.functions.Function4
            public final DBImportantContact invoke(String platform_specific_identifier, String display_name, String str, String str2) {
                Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
                Intrinsics.checkNotNullParameter(display_name, "display_name");
                return new DBImportantContact(platform_specific_identifier, display_name, str, str2);
            }
        });
    }

    public final Query<DBImportantContact> getImportantContact(String platform_specific_identifier) {
        Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
        return getImportantContact(platform_specific_identifier, new Function4<String, String, String, String, DBImportantContact>() { // from class: com.animaconnected.watch.filter.ImportantContactQueries$getImportantContact$2
            @Override // kotlin.jvm.functions.Function4
            public final DBImportantContact invoke(String platform_specific_identifier_, String display_name, String str, String str2) {
                Intrinsics.checkNotNullParameter(platform_specific_identifier_, "platform_specific_identifier_");
                Intrinsics.checkNotNullParameter(display_name, "display_name");
                return new DBImportantContact(platform_specific_identifier_, display_name, str, str2);
            }
        });
    }
}
