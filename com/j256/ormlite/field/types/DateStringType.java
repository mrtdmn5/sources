package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public class DateStringType extends BaseDateType {
    public static final DateStringType singleTon = new DateStringType();

    public DateStringType() {
        super(SqlType.STRING);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final int getDefaultWidth() {
        return 50;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Class<?> getPrimaryClass() {
        return byte[].class;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        DateStringFormatConfig dateStringFormatConfig;
        DateStringFormatConfig dateStringFormatConfig2 = BaseDateType.DEFAULT_DATE_FORMAT_CONFIG;
        if (fieldType != null && (dateStringFormatConfig = (DateStringFormatConfig) fieldType.dataTypeConfigObj) != null) {
            dateStringFormatConfig2 = dateStringFormatConfig;
        }
        return ((DateFormat) dateStringFormatConfig2.dateFormat.clone()).format((Date) obj);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object makeConfigObject(FieldType fieldType) {
        String str = fieldType.fieldConfig.format;
        if (str == null) {
            return BaseDateType.DEFAULT_DATE_FORMAT_CONFIG;
        }
        return new DateStringFormatConfig(str);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        DateStringFormatConfig dateStringFormatConfig;
        DateFormat dateFormat;
        DateStringFormatConfig dateStringFormatConfig2 = BaseDateType.DEFAULT_DATE_FORMAT_CONFIG;
        if (fieldType == null || (dateStringFormatConfig = (DateStringFormatConfig) fieldType.dataTypeConfigObj) == null) {
            dateStringFormatConfig = dateStringFormatConfig2;
        }
        if (dateStringFormatConfig == dateStringFormatConfig2) {
            try {
                if (str.indexOf(46) < 0) {
                    dateFormat = (DateFormat) BaseDateType.NO_MILLIS_DATE_FORMAT_CONFIG.dateFormat.clone();
                    return dateFormat.format(dateFormat.parse(str));
                }
            } catch (ParseException e) {
                throw SupervisorKt.create("Problems with field " + fieldType + " parsing default date-string '" + str + "' using '" + dateStringFormatConfig + "'", e);
            }
        }
        dateFormat = (DateFormat) dateStringFormatConfig.dateFormat.clone();
        return dateFormat.format(dateFormat.parse(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return androidDatabaseResults.getString(r2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int r6) throws SQLException {
        DateStringFormatConfig dateStringFormatConfig;
        DateFormat dateFormat;
        String str = (String) obj;
        DateStringFormatConfig dateStringFormatConfig2 = BaseDateType.DEFAULT_DATE_FORMAT_CONFIG;
        if (fieldType == null || (dateStringFormatConfig = (DateStringFormatConfig) fieldType.dataTypeConfigObj) == null) {
            dateStringFormatConfig = dateStringFormatConfig2;
        }
        if (dateStringFormatConfig == dateStringFormatConfig2) {
            try {
                if (str.indexOf(46) < 0) {
                    dateFormat = (DateFormat) BaseDateType.NO_MILLIS_DATE_FORMAT_CONFIG.dateFormat.clone();
                    return dateFormat.parse(str);
                }
            } catch (ParseException e) {
                throw SupervisorKt.create("Problems with column " + r6 + " parsing date-string '" + str + "' using '" + dateStringFormatConfig + "'", e);
            }
        }
        dateFormat = (DateFormat) dateStringFormatConfig.dateFormat.clone();
        return dateFormat.parse(str);
    }
}
