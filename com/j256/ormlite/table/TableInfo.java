package com.j256.ormlite.table;

import com.j256.ormlite.db.BaseDatabaseType;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.FieldType$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class TableInfo<T, ID> {
    public static final FieldType[] NO_FOREIGN_COLLECTIONS = new FieldType[0];
    public final Class<T> dataClass;
    public final DatabaseType databaseType;
    public HashMap fieldNameMap;
    public final FieldType[] fieldTypes;
    public final boolean foreignAutoCreate;
    public final FieldType[] foreignCollections;
    public final FieldType idField;
    public final String schemaName;
    public final String tableName;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:            if ((r5.generatedIdSequence != null) != false) goto L15;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TableInfo(com.j256.ormlite.db.DatabaseType r9, com.j256.ormlite.table.DatabaseTableConfig<T> r10) throws java.sql.SQLException {
        /*
            r8 = this;
            r8.<init>()
            r8.databaseType = r9
            java.lang.Class<T> r9 = r10.dataClass
            r8.dataClass = r9
            java.lang.String r9 = r10.schemaName
            r8.schemaName = r9
            java.lang.String r9 = r10.tableName
            r8.tableName = r9
            com.j256.ormlite.field.FieldType[] r9 = r10.fieldTypes
            if (r9 == 0) goto L98
            r8.fieldTypes = r9
            int r10 = r9.length
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r2
            r4 = r3
        L1d:
            if (r2 >= r10) goto L71
            r5 = r9[r2]
            boolean r6 = r5.isId
            r7 = 1
            if (r6 != 0) goto L33
            boolean r6 = r5.isGeneratedId
            if (r6 != 0) goto L33
            java.lang.String r6 = r5.generatedIdSequence
            if (r6 == 0) goto L30
            r6 = r7
            goto L31
        L30:
            r6 = r0
        L31:
            if (r6 == 0) goto L36
        L33:
            if (r1 != 0) goto L46
            r1 = r5
        L36:
            com.j256.ormlite.field.DatabaseFieldConfig r5 = r5.fieldConfig
            boolean r6 = r5.foreignAutoCreate
            if (r6 == 0) goto L3d
            r3 = r7
        L3d:
            boolean r5 = r5.foreignCollection
            if (r5 == 0) goto L43
            int r4 = r4 + 1
        L43:
            int r2 = r2 + 1
            goto L1d
        L46:
            java.sql.SQLException r9 = new java.sql.SQLException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "More than 1 idField configured for class "
            r10.<init>(r0)
            java.lang.Class<T> r0 = r8.dataClass
            r10.append(r0)
            java.lang.String r0 = " ("
            r10.append(r0)
            r10.append(r1)
            java.lang.String r0 = ","
            r10.append(r0)
            r10.append(r5)
            java.lang.String r0 = ")"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L71:
            r8.idField = r1
            r8.foreignAutoCreate = r3
            if (r4 != 0) goto L7c
            com.j256.ormlite.field.FieldType[] r9 = com.j256.ormlite.table.TableInfo.NO_FOREIGN_COLLECTIONS
            r8.foreignCollections = r9
            goto L97
        L7c:
            com.j256.ormlite.field.FieldType[] r9 = new com.j256.ormlite.field.FieldType[r4]
            r8.foreignCollections = r9
            com.j256.ormlite.field.FieldType[] r9 = r8.fieldTypes
            int r10 = r9.length
            r1 = r0
        L84:
            if (r0 >= r10) goto L97
            r2 = r9[r0]
            com.j256.ormlite.field.DatabaseFieldConfig r3 = r2.fieldConfig
            boolean r3 = r3.foreignCollection
            if (r3 == 0) goto L94
            com.j256.ormlite.field.FieldType[] r3 = r8.foreignCollections
            r3[r1] = r2
            int r1 = r1 + 1
        L94:
            int r0 = r0 + 1
            goto L84
        L97:
            return
        L98:
            java.sql.SQLException r9 = new java.sql.SQLException
            java.lang.String r10 = "Field types have not been extracted in table config"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableInfo.<init>(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.table.DatabaseTableConfig):void");
    }

    public final FieldType getFieldTypeByColumnName(String str) {
        HashMap hashMap = this.fieldNameMap;
        int r1 = 0;
        FieldType[] fieldTypeArr = this.fieldTypes;
        DatabaseType databaseType = this.databaseType;
        if (hashMap == null) {
            HashMap hashMap2 = new HashMap();
            for (FieldType fieldType : fieldTypeArr) {
                String str2 = fieldType.columnName;
                ((BaseDatabaseType) databaseType).getClass();
                hashMap2.put(str2.toLowerCase(Locale.ENGLISH), fieldType);
            }
            this.fieldNameMap = hashMap2;
        }
        HashMap hashMap3 = this.fieldNameMap;
        ((BaseDatabaseType) databaseType).getClass();
        FieldType fieldType2 = (FieldType) hashMap3.get(str.toLowerCase(Locale.ENGLISH));
        if (fieldType2 != null) {
            return fieldType2;
        }
        int length = fieldTypeArr.length;
        while (true) {
            String str3 = this.tableName;
            if (r1 < length) {
                FieldType fieldType3 = fieldTypeArr[r1];
                if (!fieldType3.field.getName().equals(str)) {
                    r1++;
                } else {
                    StringBuilder sb = new StringBuilder("You should use columnName '");
                    sb.append(fieldType3.columnName);
                    sb.append("' for table ");
                    sb.append(str3);
                    sb.append(" instead of fieldName '");
                    throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(fieldType3.field, sb, "'"));
                }
            } else {
                throw new IllegalArgumentException("Unknown column name '" + str + "' in table " + str3);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TableInfo(com.j256.ormlite.db.SqliteAndroidDatabaseType r5, java.lang.Class r6) throws java.sql.SQLException {
        /*
            r4 = this;
            java.lang.String r0 = com.j256.ormlite.table.DatabaseTableConfig.extractTableName(r5, r6)
            java.lang.Class<com.j256.ormlite.table.DatabaseTable> r1 = com.j256.ormlite.table.DatabaseTable.class
            java.lang.annotation.Annotation r1 = r6.getAnnotation(r1)
            com.j256.ormlite.table.DatabaseTable r1 = (com.j256.ormlite.table.DatabaseTable) r1
            if (r1 == 0) goto L1d
            java.lang.String r2 = r1.schemaName()
            int r2 = r2.length()
            if (r2 <= 0) goto L1d
            java.lang.String r1 = r1.schemaName()
            goto L1e
        L1d:
            r1 = 0
        L1e:
            r5.getClass()
            com.j256.ormlite.table.DatabaseTableConfig r2 = new com.j256.ormlite.table.DatabaseTableConfig
            com.j256.ormlite.field.FieldType[] r3 = com.j256.ormlite.table.DatabaseTableConfig.extractFieldTypes(r5, r6, r0)
            r2.<init>(r6, r1, r0, r3)
            r4.<init>(r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableInfo.<init>(com.j256.ormlite.db.SqliteAndroidDatabaseType, java.lang.Class):void");
    }
}
