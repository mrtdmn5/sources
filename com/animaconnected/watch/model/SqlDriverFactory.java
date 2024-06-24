package com.animaconnected.watch.model;

import android.content.Context;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.android.AndroidSqliteDriver;
import com.animaconnected.watch.AlarmDatabase;
import com.animaconnected.watch.WatchDatabase;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverFactory.kt */
/* loaded from: classes3.dex */
public class SqlDriverFactory implements DriverFactory {
    private final Context context;

    public SqlDriverFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.animaconnected.watch.model.DriverFactory
    public SqlDriver createAlarmsDriver() {
        return new AndroidSqliteDriver(AlarmDatabase.Companion.getSchema(), this.context, "alarms.db");
    }

    public final SqlDriver createDebugDriver(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        return new AndroidSqliteDriver(WatchDatabase.Companion.getSchema(), this.context, filename);
    }

    @Override // com.animaconnected.watch.model.DriverFactory
    public SqlDriver createDriver() {
        return new AndroidSqliteDriver(WatchDatabase.Companion.getSchema(), this.context, "watch_database");
    }
}
