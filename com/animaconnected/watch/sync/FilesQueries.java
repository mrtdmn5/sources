package com.animaconnected.watch.sync;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;
import com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0;
import com.animaconnected.watch.sync.DBFile;
import com.animaconnected.watch.sync.FilesQueries;
import io.ktor.http.UrlKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: FilesQueries.kt */
/* loaded from: classes3.dex */
public final class FilesQueries extends TransacterImpl {
    private final DBFile.Adapter DBFileAdapter;

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetEditableFileQuery<T> extends Query<T> {
        private final String address;
        private final String pathHash;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetEditableFileQuery(FilesQueries filesQueries, String address, String str, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = address;
            this.pathHash = str;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            String str;
            String trimMargin;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            StringBuilder sb = new StringBuilder("\n    |SELECT *\n    |FROM DBFile AS a\n    |WHERE EXISTS\n    |  (SELECT *\n    |   FROM DBWatchFileSynced b\n    |   WHERE b.file_id = a.id\n    |     AND b.device_address = ?)\n    |AND a.pathHash ");
            if (this.pathHash == null) {
                str = "IS";
            } else {
                str = "=";
            }
            sb.append(str);
            sb.append(" ?\n    ");
            trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
            return driver.executeQuery(null, trimMargin, mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetEditableFileQuery$execute$1
                final /* synthetic */ FilesQueries.GetEditableFileQuery<T> this$0;

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
                    executeQuery.bindString(1, this.this$0.getPathHash());
                }
            });
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getPathHash() {
            return this.pathHash;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:getEditableFile";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetEditableFilesQuery<T> extends Query<T> {
        private final String address;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetEditableFilesQuery(FilesQueries filesQueries, String address, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = address;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(811501418, "SELECT *\nFROM DBFile AS a\nWHERE EXISTS\n    (SELECT *\n     FROM DBWatchFileSynced b\n     WHERE b.file_id = a.id\n       AND b.device_address = ?)\n  AND a.pathHash IS NOT NULL", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetEditableFilesQuery$execute$1
                final /* synthetic */ FilesQueries.GetEditableFilesQuery<T> this$0;

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
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:getEditableFiles";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetFileByHashQuery<T> extends Query<T> {
        private final String hash;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetFileByHashQuery(FilesQueries filesQueries, String hash, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.hash = hash;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(634437898, "SELECT *\nFROM DBFile\nWHERE hash = ?", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetFileByHashQuery$execute$1
                final /* synthetic */ FilesQueries.GetFileByHashQuery<T> this$0;

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
                    executeQuery.bindString(0, this.this$0.getHash());
                }
            });
        }

        public final String getHash() {
            return this.hash;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFile"}, listener);
        }

        public String toString() {
            return "Files.sq:getFileByHash";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetFileQuery<T> extends Query<T> {
        private final String directory;
        private final String hash;
        private final String name;
        private final String pathHash;
        private final int size;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetFileQuery(FilesQueries filesQueries, String directory, String name, String hash, int r6, String str, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(directory, "directory");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.directory = directory;
            this.name = name;
            this.hash = hash;
            this.size = r6;
            this.pathHash = str;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            String str;
            String trimMargin;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            StringBuilder sb = new StringBuilder("\n    |SELECT *\n    |FROM DBFile\n    |WHERE directory = ?\n    |AND name = ?\n    |AND hash = ?\n    |AND size = ?\n    |AND pathHash ");
            if (this.pathHash == null) {
                str = "IS";
            } else {
                str = "=";
            }
            sb.append(str);
            sb.append(" ?\n    ");
            trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
            final FilesQueries filesQueries = this.this$0;
            return driver.executeQuery(null, trimMargin, mapper, 5, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetFileQuery$execute$1
                final /* synthetic */ FilesQueries.GetFileQuery<T> this$0;

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
                    DBFile.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindString(0, this.this$0.getDirectory());
                    executeQuery.bindString(1, this.this$0.getName());
                    executeQuery.bindString(2, this.this$0.getHash());
                    adapter = filesQueries.DBFileAdapter;
                    executeQuery.bindLong(3, adapter.getSizeAdapter().encode(Integer.valueOf(this.this$0.getSize())));
                    executeQuery.bindString(4, this.this$0.getPathHash());
                }
            });
        }

        public final String getDirectory() {
            return this.directory;
        }

        public final String getHash() {
            return this.hash;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPathHash() {
            return this.pathHash;
        }

        public final int getSize() {
            return this.size;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFile"}, listener);
        }

        public String toString() {
            return "Files.sq:getFile";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetFilesOnWatchQuery<T> extends Query<T> {
        private final String address;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetFilesOnWatchQuery(FilesQueries filesQueries, String address, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = address;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1765526498, "SELECT *\nFROM DBFile AS a\nWHERE EXISTS\n  (SELECT *\n     FROM DBWatchFileSynced b\n     WHERE b.file_id = a.id\n       AND b.device_address = ?)", mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetFilesOnWatchQuery$execute$1
                final /* synthetic */ FilesQueries.GetFilesOnWatchQuery<T> this$0;

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
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:getFilesOnWatch";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetStorageUsedInRamQuery<T> extends Query<T> {
        private final String address;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetStorageUsedInRamQuery(FilesQueries filesQueries, String str, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = str;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            String str;
            String trimMargin;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            StringBuilder sb = new StringBuilder("\n    |SELECT SUM(DBFile.size)\n    |FROM DBFile\n    |LEFT JOIN DBWatchFileSynced ON DBWatchFileSynced.file_id = DBFile.id\n    |WHERE DBWatchFileSynced.device_address ");
            if (this.address == null) {
                str = "IS";
            } else {
                str = "==";
            }
            sb.append(str);
            sb.append(" ?\n    |AND DBFile.directory LIKE '/ram%'\n    ");
            trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
            return driver.executeQuery(null, trimMargin, mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetStorageUsedInRamQuery$execute$1
                final /* synthetic */ FilesQueries.GetStorageUsedInRamQuery<T> this$0;

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
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:getStorageUsedInRam";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetStorageUsedOnFlashQuery<T> extends Query<T> {
        private final String address;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetStorageUsedOnFlashQuery(FilesQueries filesQueries, String str, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = str;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            String str;
            String trimMargin;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            StringBuilder sb = new StringBuilder("\n    |SELECT SUM(DBFile.size)\n    |FROM DBFile\n    |LEFT JOIN DBWatchFileSynced ON DBWatchFileSynced.file_id = DBFile.id\n    |WHERE DBWatchFileSynced.device_address ");
            if (this.address == null) {
                str = "IS";
            } else {
                str = "==";
            }
            sb.append(str);
            sb.append(" ?\n    |AND DBFile.directory LIKE '/flash%'\n    ");
            trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
            return driver.executeQuery(null, trimMargin, mapper, 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetStorageUsedOnFlashQuery$execute$1
                final /* synthetic */ FilesQueries.GetStorageUsedOnFlashQuery<T> this$0;

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
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:getStorageUsedOnFlash";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSyncedFileQuery<T> extends Query<T> {
        private final String address;
        private final String directory;
        private final String name;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSyncedFileQuery(FilesQueries filesQueries, String address, String directory, String name, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(directory, "directory");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = address;
            this.directory = directory;
            this.name = name;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(1918449535, "SELECT *\nFROM DBFile AS a\nWHERE EXISTS\n(SELECT *\n   FROM DBWatchFileSynced b\n   WHERE b.file_id = a.id\n     AND b.device_address = ?)\n    AND a.directory = ?\n    AND a.name = ?", mapper, 3, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetSyncedFileQuery$execute$1
                final /* synthetic */ FilesQueries.GetSyncedFileQuery<T> this$0;

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
                    executeQuery.bindString(1, this.this$0.getDirectory());
                    executeQuery.bindString(2, this.this$0.getName());
                }
            });
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getDirectory() {
            return this.directory;
        }

        public final String getName() {
            return this.name;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:getSyncedFile";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetSyncedFilesQuery<T> extends Query<T> {
        private final String address;
        private final String directory;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSyncedFilesQuery(FilesQueries filesQueries, String address, String directory, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(directory, "directory");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = address;
            this.directory = directory;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return this.this$0.getDriver().executeQuery(-657606444, "SELECT *\nFROM DBFile AS a\nWHERE EXISTS\n  (SELECT *\n     FROM DBWatchFileSynced b\n     WHERE b.file_id = a.id\n       AND b.device_address = ?)\n  AND a.directory = ?", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$GetSyncedFilesQuery$execute$1
                final /* synthetic */ FilesQueries.GetSyncedFilesQuery<T> this$0;

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
                    executeQuery.bindString(1, this.this$0.getDirectory());
                }
            });
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getDirectory() {
            return this.directory;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:getSyncedFiles";
        }
    }

    /* compiled from: FilesQueries.kt */
    /* loaded from: classes3.dex */
    public final class IsFileSyncedQuery<T> extends Query<T> {
        private final String address;
        private final String directory;
        private final String hash;
        private final String name;
        private final String pathHash;
        private final int size;
        final /* synthetic */ FilesQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IsFileSyncedQuery(FilesQueries filesQueries, String address, String directory, String name, String hash, int r7, String str, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(directory, "directory");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = filesQueries;
            this.address = address;
            this.directory = directory;
            this.name = name;
            this.hash = hash;
            this.size = r7;
            this.pathHash = str;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            String str;
            String trimMargin;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            StringBuilder sb = new StringBuilder("\n    |SELECT *\n    |FROM DBFile AS a\n    |WHERE EXISTS\n    |    (SELECT *\n    |     FROM DBWatchFileSynced b\n    |     WHERE b.file_id = a.id\n    |       AND b.device_address = ?)\n    |  AND a.directory = ?\n    |  AND a.name = ?\n    |  AND a.hash = ?\n    |  AND a.size = ?\n    |  AND a.pathHash ");
            if (this.pathHash == null) {
                str = "IS";
            } else {
                str = "=";
            }
            sb.append(str);
            sb.append(" ?\n    ");
            trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
            final FilesQueries filesQueries = this.this$0;
            return driver.executeQuery(null, trimMargin, mapper, 6, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.sync.FilesQueries$IsFileSyncedQuery$execute$1
                final /* synthetic */ FilesQueries.IsFileSyncedQuery<T> this$0;

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
                    DBFile.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindString(0, this.this$0.getAddress());
                    executeQuery.bindString(1, this.this$0.getDirectory());
                    executeQuery.bindString(2, this.this$0.getName());
                    executeQuery.bindString(3, this.this$0.getHash());
                    adapter = filesQueries.DBFileAdapter;
                    executeQuery.bindLong(4, adapter.getSizeAdapter().encode(Integer.valueOf(this.this$0.getSize())));
                    executeQuery.bindString(5, this.this$0.getPathHash());
                }
            });
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getDirectory() {
            return this.directory;
        }

        public final String getHash() {
            return this.hash;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPathHash() {
            return this.pathHash;
        }

        public final int getSize() {
            return this.size;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"DBFile", "DBWatchFileSynced"}, listener);
        }

        public String toString() {
            return "Files.sq:isFileSynced";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesQueries(SqlDriver driver, DBFile.Adapter DBFileAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(DBFileAdapter, "DBFileAdapter");
        this.DBFileAdapter = DBFileAdapter;
    }

    public final void addFile(final String directory, final String name, final String hash, final int r15, final String str) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        getDriver().execute(-1266011536, "INSERT INTO DBFile(directory, name, hash, size, pathHash)\nVALUES (?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$addFile$1
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
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(0, directory);
                execute.bindString(1, name);
                execute.bindString(2, hash);
                adapter = this.DBFileAdapter;
                execute.bindLong(3, adapter.getSizeAdapter().encode(Integer.valueOf(r15)));
                execute.bindString(4, str);
            }
        });
        notifyQueries(-1266011536, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$addFile$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBFile");
            }
        });
    }

    public final void clearFileSync() {
        getDriver().execute(-1859921385, "DELETE FROM DBWatchFileSynced", null);
        notifyQueries(-1859921385, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$clearFileSync$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatchFileSynced");
            }
        });
    }

    public final void clearFiles() {
        getDriver().execute(843764375, "DELETE FROM DBFile", null);
        notifyQueries(843764375, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$clearFiles$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBFile");
            }
        });
    }

    public final <T> Query<T> getAllFiles(final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(1912693247, new String[]{"DBFile"}, getDriver(), "Files.sq", "getAllFiles", "SELECT *\nFROM DBFile", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getAllFiles$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }

    public final <T> Query<T> getAllWatchFile(final Function2<? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(725799539, new String[]{"DBWatchFileSynced"}, getDriver(), "Files.sq", "getAllWatchFile", "SELECT *\nFROM DBWatchFileSynced", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getAllWatchFile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<String, Long, T> function2 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                Long l = cursor.getLong(1);
                Intrinsics.checkNotNull(l);
                return function2.invoke(string, l);
            }
        });
    }

    public final <T> Query<T> getEditableFile(String address, String str, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetEditableFileQuery(this, address, str, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getEditableFile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }

    public final <T> Query<T> getEditableFiles(String address, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetEditableFilesQuery(this, address, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getEditableFiles$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter());
                String string4 = cursor.getString(5);
                Intrinsics.checkNotNull(string4);
                return (T) function6.invoke(l, string, string2, string3, m, string4);
            }
        });
    }

    public final Query<DBFile> getFile(String str, String str2, String str3, int r17, String str4) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "directory", str2, "name", str3, "hash");
        return getFile(str, str2, str3, r17, str4, new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFile$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str5, String str6, String str7, Integer num, String str8) {
                return invoke(l.longValue(), str5, str6, str7, num.intValue(), str8);
            }

            public final DBFile invoke(long j, String directory_, String name_, String hash_, int r15, String str5) {
                Intrinsics.checkNotNullParameter(directory_, "directory_");
                Intrinsics.checkNotNullParameter(name_, "name_");
                Intrinsics.checkNotNullParameter(hash_, "hash_");
                return new DBFile(j, directory_, name_, hash_, r15, str5);
            }
        });
    }

    public final <T> Query<T> getFileByHash(String hash, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetFileByHashQuery(this, hash, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFileByHash$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }

    public final <T> Query<T> getFilesOnWatch(String address, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetFilesOnWatchQuery(this, address, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFilesOnWatch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }

    public final <T> Query<T> getFilesOnWatches(final Function5<? super String, ? super String, ? super String, ? super String, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(158885904, new String[]{"DBWatchFileSynced", "DBFile"}, getDriver(), "Files.sq", "getFilesOnWatches", "SELECT DBWatchFileSynced.device_address,\n       DBFile.directory,\n       DBFile.name,\n       DBFile.hash,\n       DBFile.size\nFROM DBFile\nLEFT JOIN DBWatchFileSynced ON DBWatchFileSynced.file_id = DBFile.id", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFilesOnWatches$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function5<String, String, String, String, Integer, T> function5 = mapper;
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(2);
                Intrinsics.checkNotNull(string3);
                String string4 = cursor.getString(3);
                Intrinsics.checkNotNull(string4);
                adapter = this.DBFileAdapter;
                return (T) function5.invoke(string, string2, string3, string4, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()));
            }
        });
    }

    public final <T> Query<T> getStorageUsedInRam(String str, final Function1<? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetStorageUsedInRamQuery(this, str, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getStorageUsedInRam$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function1<Integer, T> function1 = mapper;
                Long l = cursor.getLong(0);
                if (l != null) {
                    FilesQueries filesQueries = this;
                    long longValue = l.longValue();
                    adapter = filesQueries.DBFileAdapter;
                    num = Integer.valueOf(adapter.getSizeAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return function1.invoke(num);
            }
        });
    }

    public final <T> Query<T> getStorageUsedOnFlash(String str, final Function1<? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetStorageUsedOnFlashQuery(this, str, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getStorageUsedOnFlash$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Integer num;
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function1<Integer, T> function1 = mapper;
                Long l = cursor.getLong(0);
                if (l != null) {
                    FilesQueries filesQueries = this;
                    long longValue = l.longValue();
                    adapter = filesQueries.DBFileAdapter;
                    num = Integer.valueOf(adapter.getSizeAdapter().decode(Long.valueOf(longValue)).intValue());
                } else {
                    num = null;
                }
                return function1.invoke(num);
            }
        });
    }

    public final Query<DBFile> getSyncedFile(String str, String str2, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, WatchSettingsFragment.addressBundleKey, str2, "directory", str3, "name");
        return getSyncedFile(str, str2, str3, new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$getSyncedFile$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str4, String str5, String str6, Integer num, String str7) {
                return invoke(l.longValue(), str4, str5, str6, num.intValue(), str7);
            }

            public final DBFile invoke(long j, String directory_, String name_, String hash, int r15, String str4) {
                Intrinsics.checkNotNullParameter(directory_, "directory_");
                Intrinsics.checkNotNullParameter(name_, "name_");
                Intrinsics.checkNotNullParameter(hash, "hash");
                return new DBFile(j, directory_, name_, hash, r15, str4);
            }
        });
    }

    public final <T> Query<T> getSyncedFiles(String address, String directory, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSyncedFilesQuery(this, address, directory, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getSyncedFiles$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }

    public final <T> Query<T> isFileSynced(String address, String directory, String name, String hash, int r17, String str, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new IsFileSyncedQuery(this, address, directory, name, hash, r17, str, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$isFileSynced$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }

    public final void setAllFilesNotSynched(final String device_address) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        getDriver().execute(-119085660, "DELETE FROM DBWatchFileSynced\nWHERE device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setAllFilesNotSynched$1
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
        notifyQueries(-119085660, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setAllFilesNotSynched$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatchFileSynced");
            }
        });
    }

    public final void setFileNotSynchedForWatch(final long j, final String device_address) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        getDriver().execute(-405073808, "DELETE FROM DBWatchFileSynced\nWHERE file_id = ?\nAND device_address = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setFileNotSynchedForWatch$1
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
                execute.bindString(1, device_address);
            }
        });
        notifyQueries(-405073808, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setFileNotSynchedForWatch$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatchFileSynced");
            }
        });
    }

    public final void setNotSynched(final long j) {
        getDriver().execute(1409307822, "DELETE FROM DBWatchFileSynced\nWHERE file_id = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setNotSynched$1
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
        notifyQueries(1409307822, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setNotSynched$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatchFileSynced");
            }
        });
    }

    public final void setSynced(final String device_address, final long j) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        getDriver().execute(-185767057, "INSERT INTO DBWatchFileSynced(device_address, file_id)\nVALUES (?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setSynced$1
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
                execute.bindLong(1, Long.valueOf(j));
            }
        });
        notifyQueries(-185767057, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$setSynced$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatchFileSynced");
            }
        });
    }

    public final void unsyncDirectory(final String address, final String directory) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        getDriver().execute(821901772, "DELETE\nFROM DBWatchFileSynced\nWHERE EXISTS\n    (SELECT *\n     FROM DBFile b\n     WHERE b.id = DBWatchFileSynced.file_id\n       AND DBWatchFileSynced.device_address = ?\n       AND b.directory = ?\n    )", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$unsyncDirectory$1
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
                execute.bindString(0, address);
                execute.bindString(1, directory);
            }
        });
        notifyQueries(821901772, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.sync.FilesQueries$unsyncDirectory$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("DBWatchFileSynced");
            }
        });
    }

    public final Query<DBFile> getAllFiles() {
        return getAllFiles(new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$getAllFiles$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str, String str2, String str3, Integer num, String str4) {
                return invoke(l.longValue(), str, str2, str3, num.intValue(), str4);
            }

            public final DBFile invoke(long j, String directory, String name, String hash, int r15, String str) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(hash, "hash");
                return new DBFile(j, directory, name, hash, r15, str);
            }
        });
    }

    public final Query<DBWatchFileSynced> getAllWatchFile() {
        return getAllWatchFile(new Function2<String, Long, DBWatchFileSynced>() { // from class: com.animaconnected.watch.sync.FilesQueries$getAllWatchFile$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ DBWatchFileSynced invoke(String str, Long l) {
                return invoke(str, l.longValue());
            }

            public final DBWatchFileSynced invoke(String device_address, long j) {
                Intrinsics.checkNotNullParameter(device_address, "device_address");
                return new DBWatchFileSynced(device_address, j);
            }
        });
    }

    public final Query<DBFile> getEditableFile(String address, String str) {
        Intrinsics.checkNotNullParameter(address, "address");
        return getEditableFile(address, str, new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$getEditableFile$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str2, String str3, String str4, Integer num, String str5) {
                return invoke(l.longValue(), str2, str3, str4, num.intValue(), str5);
            }

            public final DBFile invoke(long j, String directory, String name, String hash, int r15, String str2) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(hash, "hash");
                return new DBFile(j, directory, name, hash, r15, str2);
            }
        });
    }

    public final Query<GetEditableFiles> getEditableFiles(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return getEditableFiles(address, new Function6<Long, String, String, String, Integer, String, GetEditableFiles>() { // from class: com.animaconnected.watch.sync.FilesQueries$getEditableFiles$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ GetEditableFiles invoke(Long l, String str, String str2, String str3, Integer num, String str4) {
                return invoke(l.longValue(), str, str2, str3, num.intValue(), str4);
            }

            public final GetEditableFiles invoke(long j, String directory, String name, String hash, int r15, String pathHash) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(hash, "hash");
                Intrinsics.checkNotNullParameter(pathHash, "pathHash");
                return new GetEditableFiles(j, directory, name, hash, r15, pathHash);
            }
        });
    }

    public final Query<DBFile> getFileByHash(String hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        return getFileByHash(hash, new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFileByHash$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str, String str2, String str3, Integer num, String str4) {
                return invoke(l.longValue(), str, str2, str3, num.intValue(), str4);
            }

            public final DBFile invoke(long j, String directory, String name, String hash_, int r15, String str) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(hash_, "hash_");
                return new DBFile(j, directory, name, hash_, r15, str);
            }
        });
    }

    public final Query<DBFile> getFilesOnWatch(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return getFilesOnWatch(address, new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFilesOnWatch$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str, String str2, String str3, Integer num, String str4) {
                return invoke(l.longValue(), str, str2, str3, num.intValue(), str4);
            }

            public final DBFile invoke(long j, String directory, String name, String hash, int r15, String str) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(hash, "hash");
                return new DBFile(j, directory, name, hash, r15, str);
            }
        });
    }

    public final Query<GetFilesOnWatches> getFilesOnWatches() {
        return getFilesOnWatches(new Function5<String, String, String, String, Integer, GetFilesOnWatches>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFilesOnWatches$2
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ GetFilesOnWatches invoke(String str, String str2, String str3, String str4, Integer num) {
                return invoke(str, str2, str3, str4, num.intValue());
            }

            public final GetFilesOnWatches invoke(String str, String directory, String name, String hash, int r12) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(hash, "hash");
                return new GetFilesOnWatches(str, directory, name, hash, r12);
            }
        });
    }

    public final Query<GetStorageUsedInRam> getStorageUsedInRam(String str) {
        return getStorageUsedInRam(str, new Function1<Integer, GetStorageUsedInRam>() { // from class: com.animaconnected.watch.sync.FilesQueries$getStorageUsedInRam$2
            @Override // kotlin.jvm.functions.Function1
            public final GetStorageUsedInRam invoke(Integer num) {
                return new GetStorageUsedInRam(num);
            }
        });
    }

    public final Query<GetStorageUsedOnFlash> getStorageUsedOnFlash(String str) {
        return getStorageUsedOnFlash(str, new Function1<Integer, GetStorageUsedOnFlash>() { // from class: com.animaconnected.watch.sync.FilesQueries$getStorageUsedOnFlash$2
            @Override // kotlin.jvm.functions.Function1
            public final GetStorageUsedOnFlash invoke(Integer num) {
                return new GetStorageUsedOnFlash(num);
            }
        });
    }

    public final Query<DBFile> getSyncedFiles(String address, String directory) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        return getSyncedFiles(address, directory, new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$getSyncedFiles$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str, String str2, String str3, Integer num, String str4) {
                return invoke(l.longValue(), str, str2, str3, num.intValue(), str4);
            }

            public final DBFile invoke(long j, String directory_, String name, String hash, int r15, String str) {
                Intrinsics.checkNotNullParameter(directory_, "directory_");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(hash, "hash");
                return new DBFile(j, directory_, name, hash, r15, str);
            }
        });
    }

    public final Query<DBFile> isFileSynced(String address, String directory, String name, String hash, int r14, String str) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        return isFileSynced(address, directory, name, hash, r14, str, new Function6<Long, String, String, String, Integer, String, DBFile>() { // from class: com.animaconnected.watch.sync.FilesQueries$isFileSynced$2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ DBFile invoke(Long l, String str2, String str3, String str4, Integer num, String str5) {
                return invoke(l.longValue(), str2, str3, str4, num.intValue(), str5);
            }

            public final DBFile invoke(long j, String directory_, String name_, String hash_, int r15, String str2) {
                Intrinsics.checkNotNullParameter(directory_, "directory_");
                Intrinsics.checkNotNullParameter(name_, "name_");
                Intrinsics.checkNotNullParameter(hash_, "hash_");
                return new DBFile(j, directory_, name_, hash_, r15, str2);
            }
        });
    }

    public final <T> Query<T> getFile(String directory, String name, String hash, int r13, String str, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetFileQuery(this, directory, name, hash, r13, str, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getFile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }

    public final <T> Query<T> getSyncedFile(String address, String directory, String name, final Function6<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetSyncedFileQuery(this, address, directory, name, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.sync.FilesQueries$getSyncedFile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                DBFile.Adapter adapter;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function6<Long, String, String, String, Integer, String, T> function6 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                String string3 = cursor.getString(3);
                Intrinsics.checkNotNull(string3);
                adapter = this.DBFileAdapter;
                return (T) function6.invoke(l, string, string2, string3, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 4, adapter.getSizeAdapter()), cursor.getString(5));
            }
        });
    }
}
