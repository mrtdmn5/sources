package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class FloatObjectType extends BaseDataType {
    public static final FloatObjectType singleTon = new FloatObjectType();

    public FloatObjectType() {
        super(SqlType.FLOAT, new Class[]{Float.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) {
        return Float.valueOf(Float.parseFloat(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return Float.valueOf(androidDatabaseResults.cursor.getFloat(r2));
    }
}
