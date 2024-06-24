package com.j256.ormlite.stmt;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.BaseComparison;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes3.dex */
public final class Where<T, ID> {
    public Clause[] clauseStack = new Clause[4];
    public int clauseStackLevel;
    public final DatabaseType databaseType;
    public final StatementBuilder<T, ID> statementBuilder;
    public final TableInfo<T, ID> tableInfo;

    public Where(TableInfo<T, ID> tableInfo, StatementBuilder<T, ID> statementBuilder, DatabaseType databaseType) {
        this.tableInfo = tableInfo;
        this.statementBuilder = statementBuilder;
        FieldType fieldType = tableInfo.idField;
        this.databaseType = databaseType;
    }

    public final void addClause(BaseComparison baseComparison) {
        int r0 = this.clauseStackLevel;
        if (r0 == this.clauseStack.length) {
            Clause[] clauseArr = new Clause[r0 * 2];
            for (int r1 = 0; r1 < this.clauseStackLevel; r1++) {
                Clause[] clauseArr2 = this.clauseStack;
                clauseArr[r1] = clauseArr2[r1];
                clauseArr2[r1] = null;
            }
            this.clauseStack = clauseArr;
        }
        Clause[] clauseArr3 = this.clauseStack;
        int r12 = this.clauseStackLevel;
        this.clauseStackLevel = r12 + 1;
        clauseArr3[r12] = baseComparison;
    }

    public final void eq(Object obj, String str) throws SQLException {
        addClause(new SimpleComparison(str, this.tableInfo.getFieldTypeByColumnName(str), obj, "="));
    }

    public final List<T> query() throws SQLException {
        boolean z;
        StatementBuilder<T, ID> statementBuilder = this.statementBuilder;
        if (statementBuilder instanceof QueryBuilder) {
            QueryBuilder queryBuilder = (QueryBuilder) statementBuilder;
            if (queryBuilder.selectList == null) {
                z = true;
            } else {
                z = false;
            }
            return queryBuilder.dao.query(queryBuilder.prepareStatement(z));
        }
        throw new SQLException("Cannot call query() on a statement of type " + statementBuilder.type);
    }

    public final String toString() {
        int r0 = this.clauseStackLevel;
        if (r0 == 0) {
            return "empty where clause";
        }
        return "where clause: " + this.clauseStack[r0 - 1];
    }
}
