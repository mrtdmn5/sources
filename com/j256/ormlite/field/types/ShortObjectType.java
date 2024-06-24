package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class ShortObjectType extends BaseDataType {
    public static final ShortObjectType singleTon = new ShortObjectType();

    public ShortObjectType() {
        super(SqlType.SHORT, new Class[]{Short.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Object convertIdNumber(Number number) {
        return Short.valueOf(number.shortValue());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForVersion() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Object moveToNextValue(Object obj) {
        if (obj == null) {
            return (short) 1;
        }
        return Short.valueOf((short) (((Short) obj).shortValue() + 1));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) {
        return Short.valueOf(Short.parseShort(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return Short.valueOf(androidDatabaseResults.cursor.getShort(r2));
    }
}
