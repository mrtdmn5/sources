package com.j256.ormlite.field;

import com.j256.ormlite.android.AndroidDatabaseResults;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface FieldConverter {
    SqlType getSqlType();

    boolean isStreamType();

    Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException;

    Object makeConfigObject(FieldType fieldType) throws SQLException;

    Object parseDefaultString(FieldType fieldType, String str) throws SQLException;

    Object resultToJava(FieldType fieldType, AndroidDatabaseResults androidDatabaseResults, int r3) throws SQLException;

    Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException;
}
