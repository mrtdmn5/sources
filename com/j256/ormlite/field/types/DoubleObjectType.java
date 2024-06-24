package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class DoubleObjectType extends BaseDataType {
    public static final DoubleObjectType singleTon = new DoubleObjectType();

    public DoubleObjectType() {
        super(SqlType.DOUBLE, new Class[]{Double.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) {
        return Double.valueOf(Double.parseDouble(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return Double.valueOf(androidDatabaseResults.cursor.getDouble(r2));
    }
}
