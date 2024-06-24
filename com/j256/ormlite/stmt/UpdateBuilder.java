package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.SetValue;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class UpdateBuilder<T, ID> extends StatementBuilder<T, ID> {
    public ArrayList updateClauseList;

    public UpdateBuilder(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, TableInfo tableInfo, Dao dao) {
        super(sqliteAndroidDatabaseType, tableInfo, dao, StatementBuilder.StatementType.UPDATE);
        this.updateClauseList = null;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final void appendStatementEnd(StringBuilder sb, ArrayList arrayList) {
        this.databaseType.getClass();
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final void appendStatementStart(StringBuilder sb, ArrayList arrayList) throws SQLException {
        ArrayList arrayList2 = this.updateClauseList;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            sb.append("UPDATE ");
            TableInfo<T, ID> tableInfo = this.tableInfo;
            String str = tableInfo.schemaName;
            DatabaseType databaseType = this.databaseType;
            if (str != null && str.length() > 0) {
                ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(tableInfo.schemaName, sb);
                sb.append('.');
            }
            databaseType.getClass();
            ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(tableInfo.tableName, sb);
            sb.append(" SET ");
            Iterator it = this.updateClauseList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                Clause clause = (Clause) it.next();
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                clause.appendSql(databaseType, null, sb, arrayList);
            }
            return;
        }
        throw new IllegalArgumentException("UPDATE statements must have at least one SET column");
    }

    public final void updateColumnValue(Integer num, String str) throws SQLException {
        FieldType fieldTypeByColumnName = this.tableInfo.getFieldTypeByColumnName(str);
        if (!fieldTypeByColumnName.fieldConfig.foreignCollection) {
            SetValue setValue = new SetValue(str, fieldTypeByColumnName, num);
            if (this.updateClauseList == null) {
                this.updateClauseList = new ArrayList();
            }
            this.updateClauseList.add(setValue);
            return;
        }
        throw new SQLException("Can't update foreign colletion field: ".concat(str));
    }
}
