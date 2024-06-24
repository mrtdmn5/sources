package com.j256.ormlite.field;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDataType;
import com.j256.ormlite.field.types.BaseDateType;
import com.j256.ormlite.field.types.BaseEnumType;
import com.j256.ormlite.field.types.BigDecimalNumericType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import com.j256.ormlite.field.types.BigIntegerType;
import com.j256.ormlite.field.types.BooleanObjectType;
import com.j256.ormlite.field.types.BooleanType;
import com.j256.ormlite.field.types.ByteArrayType;
import com.j256.ormlite.field.types.ByteObjectType;
import com.j256.ormlite.field.types.ByteType;
import com.j256.ormlite.field.types.CharacterObjectType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.DateType;
import com.j256.ormlite.field.types.DoubleObjectType;
import com.j256.ormlite.field.types.EnumStringType;
import com.j256.ormlite.field.types.FloatObjectType;
import com.j256.ormlite.field.types.IntegerObjectType;
import com.j256.ormlite.field.types.LongObjectType;
import com.j256.ormlite.field.types.SerializableType;
import com.j256.ormlite.field.types.ShortObjectType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.StringType;
import com.j256.ormlite.field.types.TimeStampStringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.field.types.UuidType;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class DataType extends Enum<DataType> {
    private static final /* synthetic */ DataType[] $VALUES;
    public static final DataType BIG_DECIMAL;
    public static final DataType BIG_DECIMAL_NUMERIC;
    public static final DataType BIG_INTEGER;
    public static final DataType BOOLEAN;
    public static final DataType BOOLEAN_CHAR;
    public static final DataType BOOLEAN_INTEGER;
    public static final DataType BOOLEAN_OBJ;
    public static final DataType BYTE;
    public static final DataType BYTE_ARRAY;
    public static final DataType BYTE_OBJ;
    public static final DataType CHAR;
    public static final DataType CHAR_OBJ;
    public static final DataType CURRENCY;
    public static final DataType DATE;
    public static final DataType DATE_INTEGER;
    public static final DataType DATE_LONG;
    public static final DataType DATE_STRING;
    public static final DataType DATE_TIME;
    public static final DataType DOUBLE;
    public static final DataType DOUBLE_OBJ;
    public static final DataType ENUM_INTEGER;
    public static final DataType ENUM_NAME;
    public static final DataType ENUM_STRING;
    public static final DataType ENUM_TO_STRING;
    public static final DataType FLOAT;
    public static final DataType FLOAT_OBJ;
    public static final DataType INTEGER;
    public static final DataType INTEGER_OBJ;
    public static final DataType LONG;
    public static final DataType LONG_OBJ;
    public static final DataType SERIALIZABLE;
    public static final DataType SHORT;
    public static final DataType SHORT_OBJ;
    public static final DataType SQL_DATE;
    public static final DataType STRING_BYTES;
    public static final DataType TIME_STAMP;
    public static final DataType TIME_STAMP_STRING;
    public static final DataType UNKNOWN;
    public static final DataType UUID;
    public static final DataType UUID_NATIVE;
    private final DataPersister dataPersister;
    public static final DataType STRING = new DataType("STRING", 0, StringType.singleTon);
    public static final DataType LONG_STRING = new DataType("LONG_STRING", 1, new StringType() { // from class: com.j256.ormlite.field.types.LongStringType
        {
            SqlType sqlType = SqlType.LONG_STRING;
        }

        @Override // com.j256.ormlite.field.types.StringType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
        public final int getDefaultWidth() {
            return 0;
        }

        @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
        public final Class<?> getPrimaryClass() {
            return String.class;
        }

        @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
        public final boolean isAppropriateId() {
            return false;
        }
    });

    static {
        DataType dataType = new DataType("STRING_BYTES", 2, new BaseDataType() { // from class: com.j256.ormlite.field.types.StringBytesType
            {
                SqlType sqlType = SqlType.BYTE_ARRAY;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final Class<?> getPrimaryClass() {
                return String.class;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isArgumentHolderRequired() {
                return true;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
                String str;
                String str2 = (String) obj;
                if (fieldType == null || (str = fieldType.fieldConfig.format) == null) {
                    str = "Unicode";
                }
                try {
                    return str2.getBytes(str);
                } catch (UnsupportedEncodingException e) {
                    throw SupervisorKt.create("Could not convert string with charset name: ".concat(str), e);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0006, code lost:            if (r2 == null) goto L5;     */
            @Override // com.j256.ormlite.field.FieldConverter
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object parseDefaultString(com.j256.ormlite.field.FieldType r2, java.lang.String r3) throws java.sql.SQLException {
                /*
                    r1 = this;
                    if (r2 == 0) goto L8
                    com.j256.ormlite.field.DatabaseFieldConfig r2 = r2.fieldConfig     // Catch: java.io.UnsupportedEncodingException -> Lf
                    java.lang.String r2 = r2.format     // Catch: java.io.UnsupportedEncodingException -> Lf
                    if (r2 != 0) goto La
                L8:
                    java.lang.String r2 = "Unicode"
                La:
                    byte[] r2 = r3.getBytes(r2)     // Catch: java.io.UnsupportedEncodingException -> Lf
                    return r2
                Lf:
                    r2 = move-exception
                    java.lang.String r0 = "Could not convert default string: "
                    java.lang.String r3 = r0.concat(r3)
                    java.sql.SQLException r2 = kotlinx.coroutines.SupervisorKt.create(r3, r2)
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.types.StringBytesType.parseDefaultString(com.j256.ormlite.field.FieldType, java.lang.String):java.lang.Object");
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return androidDatabaseResults.cursor.getBlob(r2);
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) throws SQLException {
                String str;
                byte[] bArr = (byte[]) obj;
                if (fieldType == null || (str = fieldType.fieldConfig.format) == null) {
                    str = "Unicode";
                }
                try {
                    return new String(bArr, str);
                } catch (UnsupportedEncodingException e) {
                    throw SupervisorKt.create("Could not convert string with charset name: ".concat(str), e);
                }
            }
        });
        STRING_BYTES = dataType;
        DataType dataType2 = new DataType("BOOLEAN", 3, BooleanType.singleTon);
        BOOLEAN = dataType2;
        DataType dataType3 = new DataType("BOOLEAN_OBJ", 4, BooleanObjectType.singleTon);
        BOOLEAN_OBJ = dataType3;
        DataType dataType4 = new DataType("BOOLEAN_CHAR", 5, new BooleanType() { // from class: com.j256.ormlite.field.types.BooleanCharType
            {
                SqlType sqlType = SqlType.CHAR;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) {
                int r2;
                String str = (String) fieldType.dataTypeConfigObj;
                if (((Boolean) obj).booleanValue()) {
                    r2 = 0;
                } else {
                    r2 = 1;
                }
                return Character.valueOf(str.charAt(r2));
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object makeConfigObject(FieldType fieldType) throws SQLException {
                String str = fieldType.fieldConfig.format;
                if (str == null) {
                    return "10";
                }
                if (str.length() == 2 && str.charAt(0) != str.charAt(1)) {
                    return str;
                }
                throw new SQLException("Invalid boolean format must have 2 different characters that represent true/false like \"10\" or \"tf\": ".concat(str));
            }

            @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
            public final Object parseDefaultString(FieldType fieldType, String str) {
                return javaToSqlArg(fieldType, Boolean.valueOf(Boolean.parseBoolean(str)));
            }

            @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return Character.valueOf(androidDatabaseResults.getChar(r2));
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) {
                if (((Character) obj).charValue() == ((String) fieldType.dataTypeConfigObj).charAt(0)) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        });
        BOOLEAN_CHAR = dataType4;
        DataType dataType5 = new DataType("BOOLEAN_INTEGER", 6, new BooleanType() { // from class: com.j256.ormlite.field.types.BooleanIntegerType
            public static final Integer TRUE_VALUE = 1;
            public static final Integer FALSE_VALUE = 0;

            {
                SqlType sqlType = SqlType.INTEGER;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    return TRUE_VALUE;
                }
                return FALSE_VALUE;
            }

            @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
            public final Object parseDefaultString(FieldType fieldType, String str) {
                return javaToSqlArg(fieldType, Boolean.valueOf(Boolean.parseBoolean(str)));
            }

            @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return Integer.valueOf(androidDatabaseResults.cursor.getInt(r2));
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) {
                if (((Integer) obj).intValue() == 0) {
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
        });
        BOOLEAN_INTEGER = dataType5;
        DataType dataType6 = new DataType("DATE", 7, DateType.singleTon);
        DATE = dataType6;
        DataType dataType7 = new DataType("DATE_LONG", 8, new BaseDateType() { // from class: com.j256.ormlite.field.types.DateLongType
            {
                SqlType sqlType = SqlType.LONG;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final Class<?> getPrimaryClass() {
                return Date.class;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isEscapedValue() {
                return false;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) {
                return Long.valueOf(((Date) obj).getTime());
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
                try {
                    return Long.valueOf(Long.parseLong(str));
                } catch (NumberFormatException e) {
                    throw SupervisorKt.create("Problems with field " + fieldType + " parsing default date-long value: " + str, e);
                }
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return Long.valueOf(androidDatabaseResults.cursor.getLong(r2));
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) {
                return new Date(((Long) obj).longValue());
            }
        });
        DATE_LONG = dataType7;
        DataType dataType8 = new DataType("DATE_INTEGER", 9, new BaseDateType() { // from class: com.j256.ormlite.field.types.DateIntegerType
            {
                SqlType sqlType = SqlType.INTEGER;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final Class<?> getPrimaryClass() {
                return Date.class;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isEscapedValue() {
                return false;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) {
                return Integer.valueOf((int) (((Date) obj).getTime() / 1000));
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
                try {
                    return Integer.valueOf(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    throw SupervisorKt.create("Problems with field " + fieldType + " parsing default date-integer value: " + str, e);
                }
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return Integer.valueOf(androidDatabaseResults.cursor.getInt(r2));
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r5) {
                return new Date(((Integer) obj).intValue() * 1000);
            }
        });
        DATE_INTEGER = dataType8;
        DataType dataType9 = new DataType("DATE_STRING", 10, DateStringType.singleTon);
        DATE_STRING = dataType9;
        DataType dataType10 = new DataType("CHAR", 11, new CharacterObjectType() { // from class: com.j256.ormlite.field.types.CharType
            {
                SqlType sqlType = SqlType.CHAR;
                new Class[1][0] = Character.TYPE;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isPrimitive() {
                return true;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) {
                Character ch = (Character) obj;
                if (ch != null && ch.charValue() != 0) {
                    return ch;
                }
                return null;
            }
        });
        CHAR = dataType10;
        DataType dataType11 = new DataType("CHAR_OBJ", 12, CharacterObjectType.singleTon);
        CHAR_OBJ = dataType11;
        DataType dataType12 = new DataType("BYTE", 13, ByteType.singleTon);
        BYTE = dataType12;
        DataType dataType13 = new DataType("BYTE_ARRAY", 14, ByteArrayType.singleTon);
        BYTE_ARRAY = dataType13;
        DataType dataType14 = new DataType("BYTE_OBJ", 15, ByteObjectType.singleTon);
        BYTE_OBJ = dataType14;
        DataType dataType15 = new DataType("SHORT", 16, new ShortObjectType() { // from class: com.j256.ormlite.field.types.ShortType
            {
                SqlType sqlType = SqlType.SHORT;
                new Class[1][0] = Short.TYPE;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isPrimitive() {
                return true;
            }
        });
        SHORT = dataType15;
        DataType dataType16 = new DataType("SHORT_OBJ", 17, ShortObjectType.singleTon);
        SHORT_OBJ = dataType16;
        DataType dataType17 = new DataType("INTEGER", 18, new IntegerObjectType() { // from class: com.j256.ormlite.field.types.IntType
            {
                SqlType sqlType = SqlType.INTEGER;
                new Class[1][0] = Integer.TYPE;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isPrimitive() {
                return true;
            }
        });
        INTEGER = dataType17;
        DataType dataType18 = new DataType("INTEGER_OBJ", 19, IntegerObjectType.singleTon);
        INTEGER_OBJ = dataType18;
        DataType dataType19 = new DataType("LONG", 20, new LongObjectType() { // from class: com.j256.ormlite.field.types.LongType
            {
                SqlType sqlType = SqlType.LONG;
                new Class[1][0] = Long.TYPE;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isPrimitive() {
                return true;
            }
        });
        LONG = dataType19;
        DataType dataType20 = new DataType("LONG_OBJ", 21, LongObjectType.singleTon);
        LONG_OBJ = dataType20;
        DataType dataType21 = new DataType("FLOAT", 22, new FloatObjectType() { // from class: com.j256.ormlite.field.types.FloatType
            {
                SqlType sqlType = SqlType.FLOAT;
                new Class[1][0] = Float.TYPE;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isPrimitive() {
                return true;
            }
        });
        FLOAT = dataType21;
        DataType dataType22 = new DataType("FLOAT_OBJ", 23, FloatObjectType.singleTon);
        FLOAT_OBJ = dataType22;
        DataType dataType23 = new DataType("DOUBLE", 24, new DoubleObjectType() { // from class: com.j256.ormlite.field.types.DoubleType
            {
                SqlType sqlType = SqlType.DOUBLE;
                new Class[1][0] = Double.TYPE;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isPrimitive() {
                return true;
            }
        });
        DOUBLE = dataType23;
        DataType dataType24 = new DataType("DOUBLE_OBJ", 25, DoubleObjectType.singleTon);
        DOUBLE_OBJ = dataType24;
        DataType dataType25 = new DataType("SERIALIZABLE", 26, SerializableType.singleTon);
        SERIALIZABLE = dataType25;
        EnumStringType enumStringType = EnumStringType.singleTon;
        DataType dataType26 = new DataType("ENUM_STRING", 27, enumStringType);
        ENUM_STRING = dataType26;
        DataType dataType27 = new DataType("ENUM_NAME", 28, enumStringType);
        ENUM_NAME = dataType27;
        DataType dataType28 = new DataType("ENUM_TO_STRING", 29, new EnumStringType() { // from class: com.j256.ormlite.field.types.EnumToStringType
            {
                SqlType sqlType = SqlType.STRING;
                new Class[1][0] = Enum.class;
            }

            @Override // com.j256.ormlite.field.types.EnumStringType
            public final String getEnumName(Enum<?> r1) {
                return r1.toString();
            }
        });
        ENUM_TO_STRING = dataType28;
        DataType dataType29 = new DataType("ENUM_INTEGER", 30, new BaseEnumType() { // from class: com.j256.ormlite.field.types.EnumIntegerType
            {
                SqlType sqlType = SqlType.INTEGER;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final Class<?> getPrimaryClass() {
                return Integer.TYPE;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isEscapedValue() {
                return false;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) {
                return Integer.valueOf(((Enum) obj).ordinal());
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object makeConfigObject(FieldType fieldType) throws SQLException {
                HashMap hashMap = new HashMap();
                Enum[] enumArr = (Enum[]) fieldType.field.getType().getEnumConstants();
                if (enumArr != null) {
                    for (Enum r3 : enumArr) {
                        hashMap.put(Integer.valueOf(r3.ordinal()), r3);
                    }
                    return hashMap;
                }
                throw new SQLException("Could not get enum-constants for field " + fieldType);
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object parseDefaultString(FieldType fieldType, String str) {
                return Integer.valueOf(Integer.parseInt(str));
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return Integer.valueOf(androidDatabaseResults.cursor.getInt(r2));
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r4) throws SQLException {
                if (fieldType == null) {
                    return obj;
                }
                Integer num = (Integer) obj;
                Map map = (Map) fieldType.dataTypeConfigObj;
                DatabaseFieldConfig databaseFieldConfig = fieldType.fieldConfig;
                if (map == null) {
                    return BaseEnumType.enumVal(fieldType, num, null, databaseFieldConfig.unknownEnumValue);
                }
                return BaseEnumType.enumVal(fieldType, num, (Enum) map.get(num), databaseFieldConfig.unknownEnumValue);
            }
        });
        ENUM_INTEGER = dataType29;
        DataType dataType30 = new DataType("UUID", 31, UuidType.singleTon);
        UUID = dataType30;
        DataType dataType31 = new DataType("UUID_NATIVE", 32, new UuidType() { // from class: com.j256.ormlite.field.types.NativeUuidType
            {
                SqlType sqlType = SqlType.UUID;
            }
        });
        UUID_NATIVE = dataType31;
        DataType dataType32 = new DataType("BIG_INTEGER", 33, BigIntegerType.singleTon);
        BIG_INTEGER = dataType32;
        DataType dataType33 = new DataType("BIG_DECIMAL", 34, BigDecimalStringType.singleTon);
        BIG_DECIMAL = dataType33;
        DataType dataType34 = new DataType("BIG_DECIMAL_NUMERIC", 35, BigDecimalNumericType.singleTon);
        BIG_DECIMAL_NUMERIC = dataType34;
        DataType dataType35 = new DataType("DATE_TIME", 36, new BaseDataType() { // from class: com.j256.ormlite.field.types.DateTimeType
            public static Class<?> dateTimeClass = null;
            public static Method getMillisMethod = null;
            public static Constructor<?> millisConstructor = null;
            public static final String[] associatedClassNames = {"org.joda.time.DateTime"};

            {
                SqlType sqlType = SqlType.LONG;
            }

            public static Object createInstance(Long l) throws SQLException {
                try {
                    if (millisConstructor == null) {
                        if (dateTimeClass == null) {
                            dateTimeClass = Class.forName("org.joda.time.DateTime");
                        }
                        millisConstructor = dateTimeClass.getConstructor(Long.TYPE);
                    }
                    return millisConstructor.newInstance(l);
                } catch (Exception e) {
                    throw SupervisorKt.create("Could not use reflection to construct a Joda DateTime", e);
                }
            }

            public static Long extractMillis(Object obj) throws SQLException {
                try {
                    if (getMillisMethod == null) {
                        if (dateTimeClass == null) {
                            dateTimeClass = Class.forName("org.joda.time.DateTime");
                        }
                        getMillisMethod = dateTimeClass.getMethod("getMillis", new Class[0]);
                    }
                    if (obj == null) {
                        return null;
                    }
                    return (Long) getMillisMethod.invoke(obj, new Object[0]);
                } catch (Exception e) {
                    throw SupervisorKt.create("Could not use reflection to get millis from Joda DateTime: " + obj, e);
                }
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final String[] getAssociatedClassNames() {
                return associatedClassNames;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final Class<?> getPrimaryClass() {
                try {
                    if (dateTimeClass == null) {
                        dateTimeClass = Class.forName("org.joda.time.DateTime");
                    }
                    return dateTimeClass;
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isAppropriateId() {
                return false;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isEscapedValue() {
                return false;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isValidForVersion() {
                return true;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
                return extractMillis(obj);
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final Object moveToNextValue(Object obj) throws SQLException {
                long currentTimeMillis = System.currentTimeMillis();
                if (obj == null) {
                    return createInstance(Long.valueOf(currentTimeMillis));
                }
                if (currentTimeMillis == extractMillis(obj).longValue()) {
                    return createInstance(Long.valueOf(currentTimeMillis + 1));
                }
                return createInstance(Long.valueOf(currentTimeMillis));
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
                try {
                    return Long.valueOf(Long.parseLong(str));
                } catch (NumberFormatException e) {
                    throw SupervisorKt.create("Problems with field " + fieldType + " parsing default DateTime value: " + str, e);
                }
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return Long.valueOf(androidDatabaseResults.cursor.getLong(r2));
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) throws SQLException {
                return createInstance((Long) obj);
            }
        });
        DATE_TIME = dataType35;
        DataType dataType36 = new DataType("SQL_DATE", 37, SqlDateType.singleTon);
        SQL_DATE = dataType36;
        DataType dataType37 = new DataType("TIME_STAMP", 38, TimeStampType.singleTon);
        TIME_STAMP = dataType37;
        DataType dataType38 = new DataType("TIME_STAMP_STRING", 39, TimeStampStringType.singleTon);
        TIME_STAMP_STRING = dataType38;
        DataType dataType39 = new DataType("CURRENCY", 40, new BaseDataType() { // from class: com.j256.ormlite.field.types.CurrencyType
            {
                SqlType sqlType = SqlType.STRING;
                new Class[1][0] = Currency.class;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final int getDefaultWidth() {
                return 30;
            }

            @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
            public final boolean isAppropriateId() {
                return false;
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
            public final Object javaToSqlArg(FieldType fieldType, Object obj) {
                return ((Currency) obj).getCurrencyCode();
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
                try {
                    return Currency.getInstance(str).getCurrencyCode();
                } catch (IllegalArgumentException e) {
                    throw SupervisorKt.create("Problems with field " + fieldType + " parsing default Currency '", e);
                }
            }

            @Override // com.j256.ormlite.field.FieldConverter
            public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
                return androidDatabaseResults.getString(r2);
            }

            @Override // com.j256.ormlite.field.BaseFieldConverter
            public final Object sqlArgToJava(FieldType fieldType, Object obj, int r5) throws SQLException {
                String str = (String) obj;
                try {
                    return Currency.getInstance(str);
                } catch (IllegalArgumentException e) {
                    throw SupervisorKt.create("Problems with column " + r5 + " parsing Currency '" + str + "'", e);
                }
            }
        });
        CURRENCY = dataType39;
        DataType dataType40 = new DataType("UNKNOWN", 41, null);
        UNKNOWN = dataType40;
        $VALUES = new DataType[]{STRING, LONG_STRING, dataType, dataType2, dataType3, dataType4, dataType5, dataType6, dataType7, dataType8, dataType9, dataType10, dataType11, dataType12, dataType13, dataType14, dataType15, dataType16, dataType17, dataType18, dataType19, dataType20, dataType21, dataType22, dataType23, dataType24, dataType25, dataType26, dataType27, dataType28, dataType29, dataType30, dataType31, dataType32, dataType33, dataType34, dataType35, dataType36, dataType37, dataType38, dataType39, dataType40};
    }

    private DataType(String str, int r2, DataPersister dataPersister) {
        super(str, r2);
        this.dataPersister = dataPersister;
    }

    public static DataType valueOf(String str) {
        return (DataType) Enum.valueOf(DataType.class, str);
    }

    public static DataType[] values() {
        return (DataType[]) $VALUES.clone();
    }

    public DataPersister getDataPersister() {
        return this.dataPersister;
    }
}
