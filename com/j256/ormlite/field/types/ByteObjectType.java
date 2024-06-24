package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class ByteObjectType extends BaseDataType {
    public static final ByteObjectType singleTon = new ByteObjectType();

    public ByteObjectType() {
        super(SqlType.BYTE, new Class[]{Byte.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Object convertIdNumber(Number number) {
        return Byte.valueOf(number.byteValue());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) {
        return Byte.valueOf(Byte.parseByte(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return Byte.valueOf((byte) androidDatabaseResults.cursor.getShort(r2));
    }
}
