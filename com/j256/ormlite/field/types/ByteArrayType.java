package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class ByteArrayType extends BaseDataType {
    public static final ByteArrayType singleTon = new ByteArrayType();

    public ByteArrayType() {
        super(SqlType.BYTE_ARRAY);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Class<?> getPrimaryClass() {
        return byte[].class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isAppropriateId() {
        return true;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        String str2;
        if (fieldType != null && (str2 = fieldType.fieldConfig.format) != null) {
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException e) {
                throw SupervisorKt.create("Could not convert default string: ".concat(str), e);
            }
        }
        return str.getBytes();
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return androidDatabaseResults.cursor.getBlob(r2);
    }
}
