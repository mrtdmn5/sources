package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.table.TableInfo;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class DeleteBuilder<T, ID> extends StatementBuilder<T, ID> {
    public DeleteBuilder(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, TableInfo tableInfo, Dao dao) {
        super(sqliteAndroidDatabaseType, tableInfo, dao, StatementBuilder.StatementType.DELETE);
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final void appendStatementEnd(StringBuilder sb, ArrayList arrayList) {
        this.databaseType.getClass();
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final void appendStatementStart(StringBuilder sb, ArrayList arrayList) {
        sb.append("DELETE FROM ");
        TableInfo<T, ID> tableInfo = this.tableInfo;
        String str = tableInfo.schemaName;
        DatabaseType databaseType = this.databaseType;
        if (str != null && str.length() > 0) {
            ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(tableInfo.schemaName, sb);
            sb.append('.');
        }
        databaseType.getClass();
        ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(tableInfo.tableName, sb);
        sb.append(' ');
    }
}
