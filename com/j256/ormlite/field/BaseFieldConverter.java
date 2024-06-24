package com.j256.ormlite.field;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.types.SerializableType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public abstract class BaseFieldConverter implements FieldConverter {
    @Override // com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return this instanceof SerializableType;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        return null;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToJava(FieldType fieldType, AndroidDatabaseResults androidDatabaseResults, int r3) throws SQLException {
        Object resultToSqlArg = resultToSqlArg(androidDatabaseResults, r3);
        if (resultToSqlArg == null) {
            return null;
        }
        return sqlArgToJava(fieldType, resultToSqlArg, r3);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        return obj;
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int r3) throws SQLException {
        return obj;
    }
}
