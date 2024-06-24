package app.cash.sqldelight.driver.jdbc.sqlite;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.driver.jdbc.ConnectionManager;
import app.cash.sqldelight.driver.jdbc.JdbcDriver;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: JdbcSqliteDriver.kt */
/* loaded from: classes.dex */
public final class JdbcSqliteDriver extends JdbcDriver {
    public final /* synthetic */ JdbcSqliteDriverConnectionManager $$delegate_0;
    public final LinkedHashMap<String, Set<Query.Listener>> listeners;

    public JdbcSqliteDriver() {
        boolean z;
        JdbcSqliteDriverConnectionManager staticConnectionManager;
        Properties properties = new Properties();
        String substringAfter$default = StringsKt__StringsKt.substringAfter$default(StringsKt__StringsKt.substringBefore$default("jdbc:sqlite:", '?'), "jdbc:sqlite:");
        if (substringAfter$default.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && !Intrinsics.areEqual(substringAfter$default, ":memory:") && !Intrinsics.areEqual(substringAfter$default, "file::memory:") && !StringsKt__StringsJVMKt.startsWith(substringAfter$default, ":resource:", false) && !StringsKt__StringsKt.contains("jdbc:sqlite:", "mode=memory", false)) {
            staticConnectionManager = new ThreadedConnectionManager(properties);
        } else {
            staticConnectionManager = new StaticConnectionManager(properties);
        }
        this.$$delegate_0 = staticConnectionManager;
        this.listeners = new LinkedHashMap<>();
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void addListener(String[] queryKeys, Query.Listener listener) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            for (String str : queryKeys) {
                LinkedHashMap<String, Set<Query.Listener>> linkedHashMap = this.listeners;
                Set<Query.Listener> set = linkedHashMap.get(str);
                if (set == null) {
                    set = new LinkedHashSet<>();
                    linkedHashMap.put(str, set);
                }
                set.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void close() {
        this.$$delegate_0.close();
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void closeConnection(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.$$delegate_0.closeConnection(connection);
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void endTransaction(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "<this>");
        this.$$delegate_0.endTransaction(connection);
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final Connection getConnection() {
        return this.$$delegate_0.getConnection();
    }

    @Override // app.cash.sqldelight.driver.jdbc.JdbcDriver, app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final ConnectionManager.Transaction getTransaction() {
        return this.$$delegate_0.getTransaction();
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void notifyListeners(String... queryKeys) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.listeners) {
            for (String str : queryKeys) {
                Set<Query.Listener> set = this.listeners.get(str);
                if (set != null) {
                    linkedHashSet.addAll(set);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((Query.Listener) it.next()).queryResultsChanged();
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void removeListener(String[] queryKeys, Query.Listener listener) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            for (String str : queryKeys) {
                Set<Query.Listener> set = this.listeners.get(str);
                if (set != null) {
                    set.remove(listener);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void rollbackTransaction(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "<this>");
        this.$$delegate_0.rollbackTransaction(connection);
    }

    @Override // app.cash.sqldelight.driver.jdbc.JdbcDriver, app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void setTransaction(ConnectionManager.Transaction transaction) {
        this.$$delegate_0.setTransaction(transaction);
    }
}
