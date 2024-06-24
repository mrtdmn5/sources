package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public class DateType extends BaseDateType {
    public static final DateType singleTon = new DateType();

    public DateType() {
        super(SqlType.DATE, new Class[]{Date.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Timestamp(((Date) obj).getTime());
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        DateFormat dateFormat;
        DateStringFormatConfig dateStringFormatConfig;
        DateStringFormatConfig defaultDateFormatConfig = getDefaultDateFormatConfig();
        if (fieldType != null && (dateStringFormatConfig = (DateStringFormatConfig) fieldType.dataTypeConfigObj) != null) {
            defaultDateFormatConfig = dateStringFormatConfig;
        }
        try {
            if (defaultDateFormatConfig == BaseDateType.DEFAULT_DATE_FORMAT_CONFIG && str.indexOf(46) < 0) {
                dateFormat = (DateFormat) BaseDateType.NO_MILLIS_DATE_FORMAT_CONFIG.dateFormat.clone();
            } else {
                dateFormat = (DateFormat) defaultDateFormatConfig.dateFormat.clone();
            }
            return new Timestamp(dateFormat.parse(str).getTime());
        } catch (ParseException e) {
            throw SupervisorKt.create("Problems parsing default date string '" + str + "' using '" + defaultDateFormatConfig + '\'', e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        androidDatabaseResults.getClass();
        throw new SQLException("Android does not support timestamp.  Use JAVA_DATE_LONG or JAVA_DATE_STRING types");
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int r3) {
        return new Date(((Timestamp) obj).getTime());
    }
}
