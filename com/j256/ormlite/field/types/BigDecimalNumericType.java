package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.math.BigDecimal;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class BigDecimalNumericType extends BaseDataType {
    public static final BigDecimalNumericType singleTon = new BigDecimalNumericType();

    public BigDecimalNumericType() {
        super(SqlType.BIG_DECIMAL);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Class<?> getPrimaryClass() {
        return BigDecimal.class;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigDecimal(str);
        } catch (IllegalArgumentException e) {
            throw SupervisorKt.create("Problems with field " + fieldType + " parsing default BigDecimal string '" + str + "'", e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        androidDatabaseResults.getClass();
        throw new SQLException("Android does not support BigDecimal type.  Use BIG_DECIMAL or BIG_DECIMAL_STRING types");
    }
}
