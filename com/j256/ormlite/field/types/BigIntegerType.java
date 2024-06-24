package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.math.BigInteger;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class BigIntegerType extends BaseDataType {
    public static final BigIntegerType singleTon = new BigIntegerType();

    public BigIntegerType() {
        super(SqlType.STRING, new Class[]{BigInteger.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Object convertIdNumber(Number number) {
        return BigInteger.valueOf(number.longValue());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final int getDefaultWidth() {
        return 255;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((BigInteger) obj).toString();
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Object moveToNextValue(Object obj) {
        if (obj == null) {
            return BigInteger.ONE;
        }
        return ((BigInteger) obj).add(BigInteger.ONE);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigInteger(str).toString();
        } catch (IllegalArgumentException e) {
            throw SupervisorKt.create("Problems with field " + fieldType + " parsing default BigInteger string '" + str + "'", e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return androidDatabaseResults.getString(r2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r5) throws SQLException {
        try {
            return new BigInteger((String) obj);
        } catch (IllegalArgumentException e) {
            throw SupervisorKt.create("Problems with column " + r5 + " parsing BigInteger string '" + obj + "'", e);
        }
    }
}
