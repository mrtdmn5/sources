package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;
import java.util.UUID;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public class UuidType extends BaseDataType {
    public static final UuidType singleTon = new UuidType();

    public UuidType() {
        super(SqlType.STRING, new Class[]{UUID.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Object generateId() {
        return UUID.randomUUID();
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final int getDefaultWidth() {
        return 48;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isSelfGeneratedId() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidGeneratedType() {
        return true;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((UUID) obj).toString();
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return androidDatabaseResults.getString(r2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r5) throws SQLException {
        String str = (String) obj;
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            throw SupervisorKt.create("Problems with column " + r5 + " parsing UUID-string '" + str + "'", e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) {
        return str;
    }
}
