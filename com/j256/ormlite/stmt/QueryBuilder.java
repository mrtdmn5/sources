package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.query.ColumnNameOrRawSql;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class QueryBuilder<T, ID> extends StatementBuilder<T, ID> {
    public final FieldType idField;
    public ArrayList orderByList;
    public FieldType[] resultFieldTypes;
    public final boolean selectIdColumn;
    public ArrayList selectList;

    public QueryBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementBuilder.StatementType.SELECT);
        boolean z;
        FieldType fieldType = tableInfo.idField;
        this.idField = fieldType;
        if (fieldType != null) {
            z = true;
        } else {
            z = false;
        }
        this.selectIdColumn = z;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final void appendStatementEnd(StringBuilder sb, ArrayList arrayList) throws SQLException {
        ArrayList arrayList2 = this.orderByList;
        DatabaseType databaseType = this.databaseType;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            sb.append("ORDER BY ");
            Iterator it = this.orderByList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                OrderBy orderBy = (OrderBy) it.next();
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                String str = orderBy.rawSql;
                if (str == null) {
                    if (this.addTableName) {
                        appendTableQualifier(sb);
                        sb.append('.');
                    }
                    ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(orderBy.columnName, sb);
                    if (!orderBy.ascending) {
                        sb.append(" DESC");
                    }
                    if (orderBy.nullsFirst) {
                        sb.append(" NULLS FIRST");
                    } else if (orderBy.nullsLast) {
                        sb.append(" NULLS LAST");
                    }
                } else {
                    sb.append(str);
                    ArgumentHolder[] argumentHolderArr = orderBy.orderByArgs;
                    if (argumentHolderArr != null) {
                        for (ArgumentHolder argumentHolder : argumentHolderArr) {
                            arrayList.add(argumentHolder);
                        }
                    }
                }
            }
            sb.append(' ');
        }
        databaseType.getClass();
        this.addTableName = false;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final void appendStatementStart(StringBuilder sb, ArrayList arrayList) {
        FieldType fieldType;
        this.addTableName = false;
        sb.append("SELECT ");
        DatabaseType databaseType = this.databaseType;
        databaseType.getClass();
        this.type = StatementBuilder.StatementType.SELECT;
        ArrayList arrayList2 = this.selectList;
        TableInfo<T, ID> tableInfo = this.tableInfo;
        if (arrayList2 == null) {
            if (this.addTableName) {
                appendTableQualifier(sb);
                sb.append('.');
            }
            sb.append("* ");
            this.resultFieldTypes = tableInfo.fieldTypes;
        } else {
            ArrayList arrayList3 = new ArrayList(this.selectList.size() + 1);
            Iterator it = this.selectList.iterator();
            boolean z = false;
            boolean z2 = true;
            while (true) {
                boolean hasNext = it.hasNext();
                fieldType = this.idField;
                if (!hasNext) {
                    break;
                }
                ColumnNameOrRawSql columnNameOrRawSql = (ColumnNameOrRawSql) it.next();
                if (columnNameOrRawSql.rawSql != null) {
                    this.type = StatementBuilder.StatementType.SELECT_RAW;
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(columnNameOrRawSql.rawSql);
                } else {
                    FieldType fieldTypeByColumnName = tableInfo.getFieldTypeByColumnName(columnNameOrRawSql.columnName);
                    if (fieldTypeByColumnName.fieldConfig.foreignCollection) {
                        arrayList3.add(fieldTypeByColumnName);
                    } else {
                        if (z2) {
                            z2 = false;
                        } else {
                            sb.append(", ");
                        }
                        if (this.addTableName) {
                            appendTableQualifier(sb);
                            sb.append('.');
                        }
                        ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(fieldTypeByColumnName.columnName, sb);
                        arrayList3.add(fieldTypeByColumnName);
                        if (fieldTypeByColumnName == fieldType) {
                            z = true;
                        }
                    }
                }
            }
            if (this.type != StatementBuilder.StatementType.SELECT_RAW) {
                if (!z && this.selectIdColumn) {
                    if (!z2) {
                        sb.append(',');
                    }
                    String str = fieldType.columnName;
                    if (this.addTableName) {
                        appendTableQualifier(sb);
                        sb.append('.');
                    }
                    ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(str, sb);
                    arrayList3.add(fieldType);
                }
                this.resultFieldTypes = (FieldType[]) arrayList3.toArray(new FieldType[arrayList3.size()]);
            }
            sb.append(' ');
        }
        sb.append("FROM ");
        String str2 = tableInfo.schemaName;
        if (str2 != null && str2.length() > 0) {
            ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(tableInfo.schemaName, sb);
            sb.append('.');
        }
        ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(this.tableName, sb);
        sb.append(' ');
    }

    public final void appendTableQualifier(StringBuilder sb) {
        TableInfo<T, ID> tableInfo = this.tableInfo;
        String str = tableInfo.schemaName;
        DatabaseType databaseType = this.databaseType;
        if (str != null && str.length() > 0) {
            ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(tableInfo.schemaName, sb);
            sb.append('.');
        }
        ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(this.tableName, sb);
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final boolean appendWhereStatement(StringBuilder sb, ArrayList arrayList, StatementBuilder.WhereOperation whereOperation) throws SQLException {
        boolean z;
        if (whereOperation == StatementBuilder.WhereOperation.FIRST) {
            z = true;
        } else {
            z = false;
        }
        if (this.where != null) {
            return super.appendWhereStatement(sb, arrayList, whereOperation);
        }
        return z;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final FieldType[] getResultFieldTypes() {
        return this.resultFieldTypes;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public final String getTableName() {
        return this.tableName;
    }

    public final void orderBy(String str, boolean z) {
        if (!this.tableInfo.getFieldTypeByColumnName(str).fieldConfig.foreignCollection) {
            OrderBy orderBy = new OrderBy(str, z);
            if (this.orderByList == null) {
                this.orderByList = new ArrayList();
            }
            this.orderByList.add(orderBy);
            return;
        }
        throw new IllegalArgumentException("Can't orderBy foreign collection field: ".concat(str));
    }
}
