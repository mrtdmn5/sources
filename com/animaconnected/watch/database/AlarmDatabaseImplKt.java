package com.animaconnected.watch.database;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import com.animaconnected.watch.AlarmDatabase;
import com.animaconnected.watch.database.AlarmDatabaseImpl;
import com.animaconnected.watch.model.alarms.Alarms;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: AlarmDatabaseImpl.kt */
/* loaded from: classes3.dex */
public final class AlarmDatabaseImplKt {
    public static final SqlSchema<QueryResult.Value<Unit>> getSchema(KClass<AlarmDatabase> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return AlarmDatabaseImpl.Schema.INSTANCE;
    }

    public static final AlarmDatabase newInstance(KClass<AlarmDatabase> kClass, SqlDriver driver, Alarms.Adapter alarmsAdapter) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(alarmsAdapter, "alarmsAdapter");
        return new AlarmDatabaseImpl(driver, alarmsAdapter);
    }
}
