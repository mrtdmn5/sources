package com.animaconnected.watch.model;

import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver;
import com.animaconnected.watch.AlarmDatabase;
import com.animaconnected.watch.WatchDatabase;

/* compiled from: DriverFactory.kt */
/* loaded from: classes3.dex */
public final class TestDriverFactory implements DriverFactory {
    @Override // com.animaconnected.watch.model.DriverFactory
    public SqlDriver createAlarmsDriver() {
        JdbcSqliteDriver jdbcSqliteDriver = new JdbcSqliteDriver();
        AlarmDatabase.Companion.getSchema().create(jdbcSqliteDriver);
        return jdbcSqliteDriver;
    }

    @Override // com.animaconnected.watch.model.DriverFactory
    public SqlDriver createDriver() {
        JdbcSqliteDriver jdbcSqliteDriver = new JdbcSqliteDriver();
        WatchDatabase.Companion.getSchema().create(jdbcSqliteDriver);
        return jdbcSqliteDriver;
    }
}
