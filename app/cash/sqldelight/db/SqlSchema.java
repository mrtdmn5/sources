package app.cash.sqldelight.db;

import app.cash.sqldelight.db.QueryResult;
import kotlin.Unit;

/* compiled from: SqlSchema.kt */
/* loaded from: classes.dex */
public interface SqlSchema<T extends QueryResult<Unit>> {
    T create(SqlDriver sqlDriver);

    long getVersion();

    T migrate(SqlDriver sqlDriver, long j, long j2, AfterVersion... afterVersionArr);
}
