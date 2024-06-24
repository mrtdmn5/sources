package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.math.BigDecimal;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class BigDecimalStringType extends BaseDataType {
    public static final BigDecimalStringType singleTon = new BigDecimalStringType();

    public BigDecimalStringType() {
        super(SqlType.STRING, new Class[]{BigDecimal.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final int getDefaultWidth() {
        return 255;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((BigDecimal) obj).toString();
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigDecimal(str).toString();
        } catch (IllegalArgumentException e) {
            throw SupervisorKt.create("Problems with field " + fieldType + " parsing default BigDecimal string '" + str + "'", e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return androidDatabaseResults.getString(r2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r5) throws SQLException {
        try {
            return new BigDecimal((String) obj);
        } catch (IllegalArgumentException e) {
            throw SupervisorKt.create("Problems with column " + r5 + " parsing BigDecimal string '" + obj + "'", e);
        }
    }
}
