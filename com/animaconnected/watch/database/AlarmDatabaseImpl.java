package com.animaconnected.watch.database;

import androidx.compose.foundation.BorderStrokeKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.AfterVersion;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import com.animaconnected.watch.AlarmDatabase;
import com.animaconnected.watch.model.alarms.Alarms;
import com.animaconnected.watch.model.alarms.AlarmsQueries;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlarmDatabaseImpl.kt */
/* loaded from: classes3.dex */
public final class AlarmDatabaseImpl extends TransacterImpl implements AlarmDatabase {
    private final AlarmsQueries alarmsQueries;

    /* compiled from: AlarmDatabaseImpl.kt */
    /* loaded from: classes3.dex */
    public static final class Schema implements SqlSchema<QueryResult.Value<Unit>> {
        public static final Schema INSTANCE = new Schema();

        private Schema() {
        }

        /* renamed from: migrateInternal-ElmaSbI, reason: not valid java name */
        private final Object m1058migrateInternalElmaSbI(SqlDriver sqlDriver, long j, long j2) {
            if (j <= 1 && j2 > 1) {
                sqlDriver.execute(null, "CREATE TABLE IF NOT EXISTS alarms (\n  _id INTEGER PRIMARY KEY NOT NULL,\n  hour INTEGER NOT NULL,\n  minutes INTEGER NOT NULL,\n  daysofweek INTEGER NOT NULL,\n  enabled INTEGER NOT NULL,\n  delete_after_use INTEGER NOT NULL DEFAULT 0\n)", null);
                sqlDriver.execute(null, "INSERT OR IGNORE INTO alarms(_id, hour, minutes, daysofweek, enabled, delete_after_use) VALUES (1, 7, 0, 31, 0, 0)", null);
                sqlDriver.execute(null, "INSERT OR IGNORE INTO alarms(_id, hour, minutes, daysofweek, enabled, delete_after_use) VALUES (2, 9, 0, 96, 0, 0)", null);
            }
            if (j <= 2 && j2 > 2) {
                sqlDriver.execute(null, "ALTER TABLE alarms ADD COLUMN last_modified INTEGER NOT NULL DEFAULT 0", null);
            }
            QueryResult.Companion.getClass();
            return QueryResult.Companion.Unit;
        }

        @Override // app.cash.sqldelight.db.SqlSchema
        public /* synthetic */ QueryResult.Value<Unit> create(SqlDriver sqlDriver) {
            return new QueryResult.Value<>(m1059create0iQ1z0(sqlDriver));
        }

        /* renamed from: create-0iQ1-z0, reason: not valid java name */
        public Object m1059create0iQ1z0(SqlDriver driver) {
            Intrinsics.checkNotNullParameter(driver, "driver");
            driver.execute(null, "CREATE TABLE alarms (\n  _id INTEGER PRIMARY KEY NOT NULL,\n  hour INTEGER NOT NULL,\n  minutes INTEGER NOT NULL,\n  daysofweek INTEGER NOT NULL,\n  enabled INTEGER NOT NULL,\n  delete_after_use INTEGER NOT NULL DEFAULT 0,\n  last_modified INTEGER NOT NULL DEFAULT 0\n)", null);
            driver.execute(null, "INSERT OR IGNORE INTO alarms(_id, hour, minutes, daysofweek, enabled, delete_after_use, last_modified) VALUES (1, 7, 0, 31, 0, 0, 0)", null);
            driver.execute(null, "INSERT OR IGNORE INTO alarms(_id, hour, minutes, daysofweek, enabled, delete_after_use, last_modified) VALUES (2, 9, 0, 96, 0, 0, 0)", null);
            QueryResult.Companion.getClass();
            return QueryResult.Companion.Unit;
        }

        @Override // app.cash.sqldelight.db.SqlSchema
        public long getVersion() {
            return 3L;
        }

        @Override // app.cash.sqldelight.db.SqlSchema
        public /* synthetic */ QueryResult.Value<Unit> migrate(SqlDriver sqlDriver, long j, long j2, AfterVersion[] afterVersionArr) {
            return new QueryResult.Value<>(m1060migratezeHU3Mk(sqlDriver, j, j2, afterVersionArr));
        }

        /* renamed from: migrate-zeHU3Mk, reason: not valid java name */
        public Object m1060migratezeHU3Mk(SqlDriver driver, long j, long j2, AfterVersion... callbacks) {
            boolean z;
            Intrinsics.checkNotNullParameter(driver, "driver");
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            ArrayList arrayList = new ArrayList();
            for (AfterVersion afterVersion : callbacks) {
                afterVersion.getClass();
                if (j <= 0 && 0 < j2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(afterVersion);
                }
            }
            Iterator it = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.animaconnected.watch.database.AlarmDatabaseImpl$Schema$migrate-zeHU3Mk$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    ((AfterVersion) t).getClass();
                    ((AfterVersion) t2).getClass();
                    return BorderStrokeKt.compareValues(0L, 0L);
                }
            }).iterator();
            if (!it.hasNext()) {
                if (j < j2) {
                    m1058migrateInternalElmaSbI(driver, j, j2);
                }
                QueryResult.Companion.getClass();
                return QueryResult.Companion.Unit;
            }
            AfterVersion afterVersion2 = (AfterVersion) it.next();
            Schema schema = INSTANCE;
            afterVersion2.getClass();
            schema.m1058migrateInternalElmaSbI(driver, j, 1L);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmDatabaseImpl(SqlDriver driver, Alarms.Adapter alarmsAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(alarmsAdapter, "alarmsAdapter");
        this.alarmsQueries = new AlarmsQueries(driver, alarmsAdapter);
    }

    @Override // com.animaconnected.watch.AlarmDatabase
    public AlarmsQueries getAlarmsQueries() {
        return this.alarmsQueries;
    }
}
