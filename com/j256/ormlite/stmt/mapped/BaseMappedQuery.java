package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.table.TableInfo;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseMappedQuery<T, ID> extends BaseMappedStatement<T, ID> implements GenericRowMapper<T> {
    public Map<String, Integer> columnPositions;
    public Object parent;
    public Object parentId;
    public final FieldType[] resultsFieldTypes;

    public BaseMappedQuery(Dao<T, ID> dao, TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2) {
        super(dao, tableInfo, str, fieldTypeArr);
        this.columnPositions = null;
        this.parent = null;
        this.parentId = null;
        this.resultsFieldTypes = fieldTypeArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:            if (r10.isNull(r9.intValue()) != false) goto L39;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d7, code lost:            r8 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d5, code lost:            if (r10.isNull(r9.intValue()) != false) goto L39;     */
    @Override // com.j256.ormlite.stmt.GenericRowMapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mapRow(com.j256.ormlite.android.AndroidDatabaseResults r20) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.mapped.BaseMappedQuery.mapRow(com.j256.ormlite.android.AndroidDatabaseResults):java.lang.Object");
    }
}
