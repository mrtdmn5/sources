package com.j256.ormlite.stmt.query;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.j256.ormlite.db.BaseDatabaseType;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.FieldType$$ExternalSyntheticOutline0;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.ColumnArg;
import com.j256.ormlite.stmt.SelectArg;
import java.sql.SQLException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class BaseComparison implements Clause {
    public final String columnName;
    public final FieldType fieldType;
    public final Object value;

    public BaseComparison(String str, FieldType fieldType, Object obj, boolean z) throws SQLException {
        boolean isComparable;
        if (z) {
            if (fieldType.fieldConfig.foreignCollection) {
                isComparable = false;
            } else {
                DataPersister dataPersister = fieldType.dataPersister;
                if (dataPersister != null) {
                    isComparable = dataPersister.isComparable();
                } else {
                    throw new SQLException("Internal error.  Data-persister is not configured for field.  Please post _full_ exception with associated data objects to mailing list: " + fieldType);
                }
            }
            if (!isComparable) {
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Field '", str, "' is of data type ");
                m.append(fieldType.dataPersister);
                m.append(" which can not be compared");
                throw new SQLException(m.toString());
            }
        }
        this.columnName = str;
        this.fieldType = fieldType;
        this.value = obj;
    }

    public final void appendArgOrValue(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, ArrayList arrayList, Object obj) throws SQLException {
        if (obj != null) {
            boolean z = obj instanceof ArgumentHolder;
            boolean z2 = true;
            String str = this.columnName;
            if (z) {
                sb.append('?');
                ArgumentHolder argumentHolder = (ArgumentHolder) obj;
                argumentHolder.setMetaInfo(fieldType, str);
                arrayList.add(argumentHolder);
            } else if (obj instanceof ColumnArg) {
                ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(null, sb);
            } else if (fieldType.dataPersister.isArgumentHolderRequired()) {
                sb.append('?');
                SelectArg selectArg = new SelectArg();
                selectArg.setMetaInfo(fieldType, str);
                selectArg.hasBeenSet = true;
                selectArg.value = obj;
                arrayList.add(selectArg);
            } else {
                DatabaseFieldConfig databaseFieldConfig = fieldType.fieldConfig;
                if (databaseFieldConfig.foreign && fieldType.field.getType().isAssignableFrom(obj.getClass())) {
                    FieldType fieldType2 = fieldType.foreignIdField;
                    appendArgOrValue(databaseType, fieldType2, sb, arrayList, fieldType2.extractJavaFieldValue(obj));
                    z2 = false;
                } else if (fieldType.dataPersister.isEscapedValue()) {
                    String obj2 = fieldType.convertJavaFieldToSqlArgValue(obj).toString();
                    ((BaseDatabaseType) databaseType).getClass();
                    sb.append('\'');
                    sb.append(obj2);
                    sb.append('\'');
                } else if (databaseFieldConfig.foreign) {
                    String obj3 = fieldType.convertJavaFieldToSqlArgValue(obj).toString();
                    if (obj3.length() > 0 && "0123456789.-+".indexOf(obj3.charAt(0)) < 0) {
                        throw new SQLException("Foreign field " + fieldType + " does not seem to be producing a numerical value '" + obj3 + "'. Maybe you are passing the wrong object to comparison: " + this);
                    }
                    sb.append(obj3);
                } else {
                    sb.append(fieldType.convertJavaFieldToSqlArgValue(obj));
                }
            }
            if (z2) {
                sb.append(' ');
                return;
            }
            return;
        }
        throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(fieldType.field, new StringBuilder("argument for '"), "' is null"));
    }

    public abstract void appendOperation(StringBuilder sb);

    @Override // com.j256.ormlite.stmt.query.Clause
    public final void appendSql(DatabaseType databaseType, String str, StringBuilder sb, ArrayList arrayList) throws SQLException {
        if (str != null) {
            ((SqliteAndroidDatabaseType) databaseType).appendEscapedEntityName(str, sb);
            sb.append('.');
        }
        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = (SqliteAndroidDatabaseType) databaseType;
        sqliteAndroidDatabaseType.appendEscapedEntityName(this.columnName, sb);
        sb.append(' ');
        appendOperation(sb);
        appendValue(sqliteAndroidDatabaseType, sb, arrayList);
    }

    public void appendValue(DatabaseType databaseType, StringBuilder sb, ArrayList arrayList) throws SQLException {
        appendArgOrValue(databaseType, this.fieldType, sb, arrayList, this.value);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.columnName);
        sb.append(' ');
        appendOperation(sb);
        sb.append(' ');
        sb.append(this.value);
        return sb.toString();
    }
}
