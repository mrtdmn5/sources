package com.animaconnected.watch;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import com.animaconnected.watch.database.AlarmDatabaseImplKt;
import com.animaconnected.watch.model.alarms.Alarms;
import com.animaconnected.watch.model.alarms.AlarmsQueries;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: AlarmDatabase.kt */
/* loaded from: classes3.dex */
public interface AlarmDatabase extends Transacter {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: AlarmDatabase.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SqlSchema<QueryResult.Value<Unit>> getSchema() {
            return AlarmDatabaseImplKt.getSchema(Reflection.getOrCreateKotlinClass(AlarmDatabase.class));
        }

        public final AlarmDatabase invoke(SqlDriver driver, Alarms.Adapter alarmsAdapter) {
            Intrinsics.checkNotNullParameter(driver, "driver");
            Intrinsics.checkNotNullParameter(alarmsAdapter, "alarmsAdapter");
            return AlarmDatabaseImplKt.newInstance(Reflection.getOrCreateKotlinClass(AlarmDatabase.class), driver, alarmsAdapter);
        }
    }

    AlarmsQueries getAlarmsQueries();

    @Override // app.cash.sqldelight.Transacter
    /* synthetic */ void transaction(boolean z, Function1 function1);

    /* synthetic */ Object transactionWithResult(boolean z, Function1 function1);
}
