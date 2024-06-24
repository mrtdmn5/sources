package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;

/* loaded from: classes3.dex */
public final class MappedRefresh<T, ID> extends MappedQueryForFieldEq<T, ID> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public MappedRefresh(Dao<T, ID> dao, TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2) {
        super(dao, tableInfo, str, fieldTypeArr, fieldTypeArr2, "refresh");
    }
}
