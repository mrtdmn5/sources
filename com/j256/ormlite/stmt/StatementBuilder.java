package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class StatementBuilder<T, ID> {
    public static final ArgumentHolder[] EMPTY_ARGUMENT_HOLDERS = new ArgumentHolder[0];
    public static final FieldType[] EMPTY_FIELD_TYPES = new FieldType[0];
    public static final Logger logger = LoggerFactory.getLogger(StatementBuilder.class);
    public boolean addTableName;
    public final Dao<T, ID> dao;
    public final DatabaseType databaseType;
    public final TableInfo<T, ID> tableInfo;
    public final String tableName;
    public StatementType type;
    public Where<T, ID> where = null;

    /* loaded from: classes3.dex */
    public enum StatementType {
        SELECT(true, true, false, false),
        SELECT_LONG(true, true, false, false),
        SELECT_RAW(true, true, false, false),
        UPDATE(true, false, true, false),
        DELETE(true, false, true, false),
        EXECUTE(false, false, false, true);

        private final boolean okForExecute;
        private final boolean okForQuery;
        private final boolean okForStatementBuilder;
        private final boolean okForUpdate;

        StatementType(boolean z, boolean z2, boolean z3, boolean z4) {
            this.okForStatementBuilder = z;
            this.okForQuery = z2;
            this.okForUpdate = z3;
            this.okForExecute = z4;
        }

        public boolean isOkForExecute() {
            return this.okForExecute;
        }

        public boolean isOkForQuery() {
            return this.okForQuery;
        }

        public boolean isOkForStatementBuilder() {
            return this.okForStatementBuilder;
        }

        public boolean isOkForUpdate() {
            return this.okForUpdate;
        }
    }

    /* loaded from: classes3.dex */
    public enum WhereOperation {
        FIRST("WHERE ", null),
        AND("AND (", ") "),
        OR("OR (", ") ");

        private final String after;
        private final String before;

        WhereOperation(String str, String str2) {
            this.before = str;
            this.after = str2;
        }

        public void appendAfter(StringBuilder sb) {
            String str = this.after;
            if (str != null) {
                sb.append(str);
            }
        }

        public void appendBefore(StringBuilder sb) {
            String str = this.before;
            if (str != null) {
                sb.append(str);
            }
        }
    }

    public StatementBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao, StatementType statementType) {
        this.databaseType = databaseType;
        this.tableInfo = tableInfo;
        this.tableName = tableInfo.tableName;
        this.dao = dao;
        this.type = statementType;
        if (statementType.isOkForStatementBuilder()) {
            return;
        }
        throw new IllegalStateException("Building a statement from a " + statementType + " statement is not allowed");
    }

    public abstract void appendStatementEnd(StringBuilder sb, ArrayList arrayList) throws SQLException;

    public abstract void appendStatementStart(StringBuilder sb, ArrayList arrayList) throws SQLException;

    public boolean appendWhereStatement(StringBuilder sb, ArrayList arrayList, WhereOperation whereOperation) throws SQLException {
        String str;
        if (this.where == null) {
            if (whereOperation == WhereOperation.FIRST) {
                return true;
            }
            return false;
        }
        whereOperation.appendBefore(sb);
        Where<T, ID> where = this.where;
        if (this.addTableName) {
            str = getTableName();
        } else {
            str = null;
        }
        int r4 = where.clauseStackLevel;
        if (r4 != 0) {
            if (r4 == 1) {
                where.clauseStack[r4 - 1].appendSql(where.databaseType, str, sb, arrayList);
                whereOperation.appendAfter(sb);
                return false;
            }
            throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
        }
        throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
    }

    public final String buildStatementString(ArrayList arrayList) throws SQLException {
        StringBuilder sb = new StringBuilder(128);
        appendStatementStart(sb, arrayList);
        appendWhereStatement(sb, arrayList, WhereOperation.FIRST);
        appendStatementEnd(sb, arrayList);
        int length = sb.length();
        if (length > 0) {
            int r4 = length - 1;
            if (sb.charAt(r4) == ' ') {
                sb.setLength(r4);
            }
        }
        String sb2 = sb.toString();
        logger.debug(sb2, "built statement {}");
        return sb2;
    }

    public FieldType[] getResultFieldTypes() {
        return null;
    }

    public String getTableName() {
        return this.tableName;
    }

    public final MappedPreparedStmt prepareStatement(boolean z) throws SQLException {
        FieldType[] fieldTypeArr;
        ArgumentHolder[] argumentHolderArr;
        ArrayList arrayList = new ArrayList();
        String buildStatementString = buildStatementString(arrayList);
        if (arrayList.isEmpty()) {
            argumentHolderArr = EMPTY_ARGUMENT_HOLDERS;
            fieldTypeArr = EMPTY_FIELD_TYPES;
        } else {
            ArgumentHolder[] argumentHolderArr2 = (ArgumentHolder[]) arrayList.toArray(new ArgumentHolder[arrayList.size()]);
            FieldType[] fieldTypeArr2 = new FieldType[arrayList.size()];
            for (int r2 = 0; r2 < argumentHolderArr2.length; r2++) {
                fieldTypeArr2[r2] = argumentHolderArr2[r2].getFieldType();
            }
            fieldTypeArr = fieldTypeArr2;
            argumentHolderArr = argumentHolderArr2;
        }
        FieldType[] resultFieldTypes = getResultFieldTypes();
        Dao<T, ID> dao = this.dao;
        TableInfo<T, ID> tableInfo = this.tableInfo;
        this.databaseType.getClass();
        return new MappedPreparedStmt(dao, tableInfo, buildStatementString, fieldTypeArr, resultFieldTypes, argumentHolderArr, this.type, z);
    }

    public final Where<T, ID> where() {
        Where<T, ID> where = new Where<>(this.tableInfo, this, this.databaseType);
        this.where = where;
        return where;
    }
}
