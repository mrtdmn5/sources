package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;

/* loaded from: classes3.dex */
public final class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final FieldType versionFieldType;
    public final int versionFieldTypeIndex;

    public MappedUpdate(Dao<T, ID> dao, TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType fieldType, int r6) {
        super(dao, tableInfo, str, fieldTypeArr);
        this.versionFieldType = fieldType;
        this.versionFieldTypeIndex = r6;
    }
}
