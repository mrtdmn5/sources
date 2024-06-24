package com.j256.ormlite.field.types;

import android.database.Cursor;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class BooleanObjectType extends BaseDataType {
    public static final BooleanObjectType singleTon = new BooleanObjectType();

    public BooleanObjectType() {
        super(SqlType.BOOLEAN, new Class[]{Boolean.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r3) throws SQLException {
        boolean z;
        Cursor cursor = androidDatabaseResults.cursor;
        if (!cursor.isNull(r3) && cursor.getShort(r3) != 0) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
