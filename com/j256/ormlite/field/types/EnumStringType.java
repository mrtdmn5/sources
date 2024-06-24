package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class EnumStringType extends BaseEnumType {
    public static final EnumStringType singleTon = new EnumStringType();

    public EnumStringType() {
        super(SqlType.STRING, new Class[]{Enum.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final int getDefaultWidth() {
        return 100;
    }

    public String getEnumName(Enum<?> r1) {
        return r1.name();
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return getEnumName((Enum) obj);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap hashMap = new HashMap();
        Enum<?>[] enumArr = (Enum[]) fieldType.field.getType().getEnumConstants();
        if (enumArr != null) {
            for (Enum<?> r3 : enumArr) {
                hashMap.put(getEnumName(r3), r3);
            }
            return hashMap;
        }
        throw new SQLException("Could not get enum-constants for field " + fieldType + ", not an enum or maybe generic?");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return androidDatabaseResults.getString(r2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r4) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        String str = (String) obj;
        Map map = (Map) fieldType.dataTypeConfigObj;
        DatabaseFieldConfig databaseFieldConfig = fieldType.fieldConfig;
        if (map == null) {
            return BaseEnumType.enumVal(fieldType, str, null, databaseFieldConfig.unknownEnumValue);
        }
        return BaseEnumType.enumVal(fieldType, str, (Enum) map.get(str), databaseFieldConfig.unknownEnumValue);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) {
        return str;
    }
}
