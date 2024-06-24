package com.j256.ormlite.field;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.Constants;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.db.BaseSqliteDatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.SerializableType;
import com.j256.ormlite.field.types.SqlDateStringType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.TimeStampStringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.SQLException;
import java.util.Collection;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class FieldType {
    public final String columnName;
    public DataPersister dataPersister;
    public Object dataTypeConfigObj;
    public Object defaultValue;
    public final Field field;
    public final DatabaseFieldConfig fieldConfig;
    public FieldConverter fieldConverter;
    public final Method fieldGetMethod;
    public final Method fieldSetMethod;
    public Dao<?, ?> foreignDao;
    public FieldType foreignFieldType;
    public FieldType foreignIdField;
    public FieldType foreignRefField;
    public final String generatedIdSequence;
    public final boolean isGeneratedId;
    public final boolean isId;
    public MappedQueryForFieldEq<?, ?> mappedQueryForForeignField;
    public final Class<?> parentClass;
    public final String tableName;
    public static final ThreadLocal<LevelCounters> threadLevelCounters = new ThreadLocal<>();
    public static final Logger logger = LoggerFactory.getLogger(FieldType.class);

    /* loaded from: classes3.dex */
    public static class LevelCounters {
        public int autoRefreshLevel;
        public int autoRefreshLevelMax;
        public int foreignCollectionLevel;
        public int foreignCollectionLevelMax;
    }

    public FieldType(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, String str, Field field, DatabaseFieldConfig databaseFieldConfig, Class cls) throws SQLException {
        DataPersister dataPersister;
        String m;
        this.tableName = str;
        this.field = field;
        this.parentClass = cls;
        if (databaseFieldConfig.foreignColumnName != null) {
            databaseFieldConfig.foreignAutoRefresh = true;
        }
        if (databaseFieldConfig.foreignAutoRefresh && databaseFieldConfig.maxForeignAutoRefreshLevel == -1) {
            databaseFieldConfig.maxForeignAutoRefreshLevel = 2;
        }
        Class<?> type = field.getType();
        if (databaseFieldConfig.getDataPersister() == null) {
            Class<? extends DataPersister> cls2 = databaseFieldConfig.persisterClass;
            if (cls2 != null && cls2 != VoidType.class) {
                try {
                    try {
                        Object invoke = cls2.getDeclaredMethod("getSingleton", new Class[0]).invoke(null, new Object[0]);
                        if (invoke != null) {
                            try {
                                dataPersister = (DataPersister) invoke;
                            } catch (Exception e) {
                                throw SupervisorKt.create("Could not cast result of static getSingleton method to DataPersister from class " + cls2, e);
                            }
                        } else {
                            throw new SQLException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Static getSingleton method should not return null on class ", cls2));
                        }
                    } catch (InvocationTargetException e2) {
                        throw SupervisorKt.create(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Could not run getSingleton method on class ", cls2), e2.getTargetException());
                    } catch (Exception e3) {
                        throw SupervisorKt.create("Could not run getSingleton method on class " + cls2, e3);
                    }
                } catch (Exception e4) {
                    throw SupervisorKt.create("Could not find getSingleton static method on class " + cls2, e4);
                }
            } else {
                dataPersister = DataPersisterManager.lookupForField(field);
            }
        } else {
            dataPersister = databaseFieldConfig.getDataPersister();
            if (!dataPersister.isValidForField(field)) {
                StringBuilder sb = new StringBuilder("Field class ");
                sb.append(type.getName());
                sb.append(" for field ");
                sb.append(this);
                sb.append(" is not valid for type ");
                sb.append(dataPersister);
                Class<?> primaryClass = dataPersister.getPrimaryClass();
                if (primaryClass != null) {
                    sb.append(", maybe should be ");
                    sb.append(primaryClass);
                }
                throw new IllegalArgumentException(sb.toString());
            }
        }
        String str2 = databaseFieldConfig.foreignColumnName;
        String name = field.getName();
        if (!databaseFieldConfig.foreign && !databaseFieldConfig.foreignAutoRefresh && str2 == null) {
            boolean z = databaseFieldConfig.foreignCollection;
            if (z) {
                if (type != Collection.class && !ForeignCollection.class.isAssignableFrom(type)) {
                    throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field class for '"), "' must be of class ForeignCollection or Collection."));
                }
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    if (((ParameterizedType) genericType).getActualTypeArguments().length == 0) {
                        throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field class for '"), "' must be a parameterized Collection with at least 1 type."));
                    }
                } else {
                    throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field class for '"), "' must be a parameterized Collection."));
                }
            } else if (dataPersister == null && !z) {
                if (!byte[].class.isAssignableFrom(type)) {
                    if (Serializable.class.isAssignableFrom(type)) {
                        if (databaseFieldConfig.javaxEntity) {
                            dataPersister = SerializableType.singleTon;
                        } else {
                            StringBuilder sb2 = new StringBuilder("ORMLite does not know how to store ");
                            sb2.append(type);
                            sb2.append(" for field '");
                            throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, sb2, "'.  Use another class, custom persister, or to serialize it use dataType=DataType.SERIALIZABLE"));
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder("ORMLite does not know how to store ");
                        sb3.append(type);
                        sb3.append(" for field ");
                        throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, sb3, ". Use another class or a custom persister."));
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder("ORMLite does not know how to store ");
                    sb4.append(type);
                    sb4.append(" for field '");
                    throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, sb4, "'. byte[] fields must specify dataType=DataType.BYTE_ARRAY or SERIALIZABLE"));
                }
            }
        } else {
            if (dataPersister != null && dataPersister.isPrimitive()) {
                throw new IllegalArgumentException("Field " + this + " is a primitive class " + type + " but marked as foreign");
            }
            if (str2 == null) {
                m = ComposableInvoker$$ExternalSyntheticOutline0.m(name, TransferTable.COLUMN_ID);
            } else {
                m = AbstractResolvableFuture$$ExternalSyntheticOutline0.m(name, "_", str2);
            }
            name = m;
            if (ForeignCollection.class.isAssignableFrom(type)) {
                throw new SQLException("Field '" + field.getName() + "' in class " + type + "' should use the @ForeignCollectionField annotation not foreign=true");
            }
        }
        String str3 = databaseFieldConfig.columnName;
        if (str3 == null) {
            this.columnName = name;
        } else {
            this.columnName = str3;
        }
        this.fieldConfig = databaseFieldConfig;
        if (databaseFieldConfig.id) {
            if (!databaseFieldConfig.generatedId && databaseFieldConfig.generatedIdSequence == null) {
                this.isId = true;
                this.isGeneratedId = false;
                this.generatedIdSequence = null;
            } else {
                throw new IllegalArgumentException("Must specify one of id, generatedId, and generatedIdSequence with " + field.getName());
            }
        } else if (databaseFieldConfig.generatedId) {
            if (databaseFieldConfig.generatedIdSequence == null) {
                this.isId = true;
                this.isGeneratedId = true;
                sqliteAndroidDatabaseType.getClass();
                this.generatedIdSequence = null;
            } else {
                throw new IllegalArgumentException("Must specify one of id, generatedId, and generatedIdSequence with " + field.getName());
            }
        } else {
            String str4 = databaseFieldConfig.generatedIdSequence;
            if (str4 != null) {
                this.isId = true;
                this.isGeneratedId = true;
                sqliteAndroidDatabaseType.getClass();
                this.generatedIdSequence = str4;
            } else {
                this.isId = false;
                this.isGeneratedId = false;
                this.generatedIdSequence = null;
            }
        }
        if (this.isId && databaseFieldConfig.foreign) {
            throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Id field "), " cannot also be a foreign object"));
        }
        if (databaseFieldConfig.useGetSet) {
            this.fieldGetMethod = DatabaseFieldConfig.findGetMethod(field, sqliteAndroidDatabaseType, true);
            this.fieldSetMethod = DatabaseFieldConfig.findSetMethod(field, sqliteAndroidDatabaseType, true);
        } else {
            if (!field.isAccessible()) {
                try {
                    field.setAccessible(true);
                } catch (SecurityException unused) {
                    throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Could not open access to field "), ".  You may have to set useGetSet=true to fix."));
                }
            }
            this.fieldGetMethod = null;
            this.fieldSetMethod = null;
        }
        if (databaseFieldConfig.allowGeneratedIdInsert && !databaseFieldConfig.generatedId) {
            throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field "), " must be a generated-id if allowGeneratedIdInsert = true"));
        }
        if (databaseFieldConfig.foreignColumnName != null && !databaseFieldConfig.foreign) {
            throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field "), " must have foreign = true if foreignColumnName is set"));
        }
        if (databaseFieldConfig.foreignAutoRefresh && !databaseFieldConfig.foreign) {
            throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field "), " must have foreign = true if foreignAutoRefresh = true"));
        }
        if (databaseFieldConfig.foreignAutoCreate && !databaseFieldConfig.foreign) {
            throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field "), " must have foreign = true if foreignAutoCreate = true"));
        }
        if (databaseFieldConfig.version && (dataPersister == null || !dataPersister.isValidForVersion())) {
            throw new IllegalArgumentException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field "), " is not a valid type to be a version field"));
        }
        assignDataType(sqliteAndroidDatabaseType, dataPersister);
    }

    public final void assignDataType(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, DataPersister dataPersister) throws SQLException {
        FieldConverter fieldConverter;
        sqliteAndroidDatabaseType.getClass();
        if (dataPersister != null && SqliteAndroidDatabaseType.AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()] == 1) {
            if (dataPersister instanceof TimeStampType) {
                dataPersister = TimeStampStringType.singleTon;
            } else if (dataPersister instanceof SqlDateType) {
                dataPersister = SqlDateStringType.singleTon;
            } else {
                dataPersister = DateStringType.singleTon;
            }
        }
        this.dataPersister = dataPersister;
        DatabaseFieldConfig databaseFieldConfig = this.fieldConfig;
        if (dataPersister == null) {
            if (!databaseFieldConfig.foreign && !databaseFieldConfig.foreignCollection) {
                throw new SQLException("Data persister for field " + this + " is null but the field is not a foreign or foreignCollection");
            }
            return;
        }
        int r1 = BaseSqliteDatabaseType.AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                fieldConverter = dataPersister;
            } else {
                fieldConverter = BigDecimalStringType.singleTon;
            }
        } else {
            fieldConverter = BaseSqliteDatabaseType.booleanConverter;
        }
        this.fieldConverter = fieldConverter;
        boolean z = this.isGeneratedId;
        Field field = this.field;
        if (z && !dataPersister.isValidGeneratedType()) {
            StringBuilder sb = new StringBuilder("Generated-id field '");
            sb.append(field.getName());
            sb.append("' in ");
            sb.append(field.getDeclaringClass().getSimpleName());
            sb.append(" can't be type ");
            sb.append(dataPersister.getSqlType());
            sb.append(".  Must be one of: ");
            for (DataType dataType : DataType.values()) {
                DataPersister dataPersister2 = dataType.getDataPersister();
                if (dataPersister2 != null && dataPersister2.isValidGeneratedType()) {
                    sb.append(dataType);
                    sb.append(' ');
                }
            }
            throw new IllegalArgumentException(sb.toString());
        }
        if (databaseFieldConfig.throwIfNull && !dataPersister.isPrimitive()) {
            throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field "), " must be a primitive if set with throwIfNull"));
        }
        if (this.isId && !dataPersister.isAppropriateId()) {
            throw new SQLException("Field '" + field.getName() + "' is of data type " + dataPersister + " which cannot be the ID field");
        }
        this.dataTypeConfigObj = this.fieldConverter.makeConfigObject(this);
        String str = databaseFieldConfig.defaultValue;
        if (str == null) {
            this.defaultValue = null;
            return;
        }
        if (!z) {
            this.defaultValue = this.fieldConverter.parseDefaultString(this, str);
            return;
        }
        throw new SQLException("Field '" + field.getName() + "' cannot be a generatedId and have a default value '" + str + "'");
    }

    public final void assignField(ConnectionSource connectionSource, Object obj, Object obj2, boolean z) throws SQLException {
        Object execute;
        int r4;
        Object obj3;
        Level level = Level.TRACE;
        Logger logger2 = logger;
        if (logger2.backend.isLevelEnabled(level)) {
            Object obj4 = Constants.NULL_VERSION_ID;
            if (obj == null) {
                obj3 = Constants.NULL_VERSION_ID;
            } else {
                obj3 = obj.getClass();
            }
            if (obj2 != null) {
                obj4 = obj2.getClass();
            }
            logger2.trace("assiging from data {}, val {}: {}", obj3, obj4, obj2);
        }
        if (this.foreignRefField != null && obj2 != null) {
            Object extractJavaFieldValue = extractJavaFieldValue(obj);
            if (extractJavaFieldValue != null && extractJavaFieldValue.equals(obj2)) {
                return;
            }
            this.foreignDao.getObjectCache();
            if (!z) {
                ThreadLocal<LevelCounters> threadLocal = threadLevelCounters;
                LevelCounters levelCounters = threadLocal.get();
                DatabaseFieldConfig databaseFieldConfig = this.fieldConfig;
                if (levelCounters == null) {
                    if (!databaseFieldConfig.foreignAutoRefresh) {
                        execute = createForeignShell(connectionSource, obj2);
                        obj2 = execute;
                    } else {
                        levelCounters = new LevelCounters();
                        threadLocal.set(levelCounters);
                    }
                }
                int r5 = levelCounters.autoRefreshLevel;
                if (r5 == 0) {
                    boolean z2 = databaseFieldConfig.foreignAutoRefresh;
                    if (!z2) {
                        execute = createForeignShell(connectionSource, obj2);
                        obj2 = execute;
                    } else {
                        if (z2) {
                            r4 = databaseFieldConfig.maxForeignAutoRefreshLevel;
                        } else {
                            r4 = -1;
                        }
                        levelCounters.autoRefreshLevelMax = r4;
                    }
                }
                if (r5 >= levelCounters.autoRefreshLevelMax) {
                    execute = createForeignShell(connectionSource, obj2);
                } else {
                    if (this.mappedQueryForForeignField == null) {
                        Dao<?, ?> dao = this.foreignDao;
                        this.mappedQueryForForeignField = MappedQueryForFieldEq.build(dao, dao.getTableInfo(), this.foreignIdField);
                    }
                    levelCounters.autoRefreshLevel++;
                    try {
                        execute = this.mappedQueryForForeignField.execute(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), obj2);
                        int r11 = levelCounters.autoRefreshLevel - 1;
                        levelCounters.autoRefreshLevel = r11;
                        if (r11 <= 0) {
                            threadLocal.remove();
                        }
                    } catch (Throwable th) {
                        int r10 = levelCounters.autoRefreshLevel - 1;
                        levelCounters.autoRefreshLevel = r10;
                        if (r10 <= 0) {
                            threadLocal.remove();
                        }
                        throw th;
                    }
                }
                obj2 = execute;
            }
        }
        Method method = this.fieldSetMethod;
        if (method == null) {
            try {
                this.field.set(obj, obj2);
                return;
            } catch (IllegalAccessException e) {
                throw SupervisorKt.create("Could not assign object '" + obj2 + "' of type " + obj2.getClass() + "' to field " + this, e);
            } catch (IllegalArgumentException e2) {
                if (obj2 == null) {
                    throw SupervisorKt.create("Could not assign object '" + obj2 + "' to field " + this, e2);
                }
                throw SupervisorKt.create("Could not assign object '" + obj2 + "' of type " + obj2.getClass() + " to field " + this, e2);
            }
        }
        try {
            method.invoke(obj, obj2);
        } catch (Exception e3) {
            throw SupervisorKt.create("Could not call " + method + " on object with '" + obj2 + "' for " + this, e3);
        }
    }

    public final <FT, FID> void configDaoInformation(ConnectionSource connectionSource, Class<?> cls) throws SQLException {
        Dao<?, ?> createDao;
        FieldType fieldTypeByColumnName;
        FieldType fieldType;
        FieldType fieldType2;
        Field field = this.field;
        Class<?> type = field.getType();
        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) connectionSource).databaseType;
        DatabaseFieldConfig databaseFieldConfig = this.fieldConfig;
        String str = databaseFieldConfig.foreignColumnName;
        MappedQueryForFieldEq<?, ?> mappedQueryForFieldEq = null;
        if (!databaseFieldConfig.foreignAutoRefresh && str == null) {
            if (databaseFieldConfig.foreign) {
                DataPersister dataPersister = this.dataPersister;
                if (dataPersister != null && dataPersister.isPrimitive()) {
                    throw new IllegalArgumentException("Field " + this + " is a primitive class " + type + " but marked as foreign");
                }
                createDao = DaoManager.createDao(connectionSource, type);
                fieldType2 = createDao.getTableInfo().idField;
                if (fieldType2 != null) {
                    if (databaseFieldConfig.foreignAutoCreate && !fieldType2.isGeneratedId) {
                        throw new IllegalArgumentException("Field " + field.getName() + ", if foreignAutoCreate = true then class " + type.getSimpleName() + " must have id field with generatedId = true");
                    }
                    fieldTypeByColumnName = fieldType2;
                    fieldType = null;
                } else {
                    throw new IllegalArgumentException("Foreign field " + type + " does not have id field");
                }
            } else {
                if (databaseFieldConfig.foreignCollection) {
                    if (type != Collection.class && !ForeignCollection.class.isAssignableFrom(type)) {
                        throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field class for '"), "' must be of class ForeignCollection or Collection."));
                    }
                    Type genericType = field.getGenericType();
                    if (genericType instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                        if (actualTypeArguments.length != 0) {
                            if (actualTypeArguments[0] instanceof TypeVariable) {
                                actualTypeArguments = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();
                            }
                            Type type2 = actualTypeArguments[0];
                            if (type2 instanceof Class) {
                                Class cls2 = (Class) type2;
                                createDao = DaoManager.createDao(connectionSource, cls2);
                                String str2 = databaseFieldConfig.foreignCollectionForeignFieldName;
                                FieldType[] fieldTypeArr = createDao.getTableInfo().fieldTypes;
                                int length = fieldTypeArr.length;
                                for (int r4 = 0; r4 < length; r4++) {
                                    fieldType = fieldTypeArr[r4];
                                    if (fieldType.field.getType() == cls && (str2 == null || fieldType.field.getName().equals(str2))) {
                                        fieldType2 = null;
                                        fieldTypeByColumnName = null;
                                    }
                                }
                                StringBuilder sb = new StringBuilder("Foreign collection class ");
                                sb.append(cls2.getName());
                                sb.append(" for field '");
                                sb.append(field.getName());
                                sb.append("' column-name does not contain a foreign field");
                                if (str2 != null) {
                                    sb.append(" named '");
                                    sb.append(str2);
                                    sb.append('\'');
                                }
                                sb.append(" of class ");
                                sb.append(cls.getName());
                                throw new SQLException(sb.toString());
                            }
                            throw new SQLException("Field class for '" + field.getName() + "' must be a parameterized Collection whose generic argument is an entity class not: " + actualTypeArguments[0]);
                        }
                        throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field class for '"), "' must be a parameterized Collection with at least 1 type."));
                    }
                    throw new SQLException(FieldType$$ExternalSyntheticOutline0.m(field, new StringBuilder("Field class for '"), "' must be a parameterized Collection."));
                }
                createDao = null;
                fieldType2 = null;
                fieldTypeByColumnName = null;
                fieldType = null;
            }
        } else {
            createDao = DaoManager.createDao(connectionSource, type);
            TableInfo<?, ?> tableInfo = createDao.getTableInfo();
            FieldType fieldType3 = tableInfo.idField;
            if (fieldType3 != null) {
                if (str == null) {
                    fieldTypeByColumnName = fieldType3;
                } else {
                    fieldTypeByColumnName = tableInfo.getFieldTypeByColumnName(str);
                }
                fieldType = null;
                mappedQueryForFieldEq = MappedQueryForFieldEq.build(createDao, tableInfo, fieldTypeByColumnName);
                fieldType2 = fieldType3;
            } else {
                throw new IllegalArgumentException("Foreign field " + type + " does not have id field");
            }
        }
        this.mappedQueryForForeignField = mappedQueryForFieldEq;
        this.foreignFieldType = fieldType;
        this.foreignDao = createDao;
        this.foreignIdField = fieldType2;
        this.foreignRefField = fieldTypeByColumnName;
        if (fieldTypeByColumnName != null) {
            assignDataType(sqliteAndroidDatabaseType, fieldTypeByColumnName.dataPersister);
        }
    }

    public final Object convertJavaFieldToSqlArgValue(Object obj) throws SQLException {
        if (obj == null) {
            return null;
        }
        return this.fieldConverter.javaToSqlArg(this, obj);
    }

    public final Object createForeignShell(ConnectionSource connectionSource, Object obj) throws SQLException {
        Object createObjectInstance = this.foreignDao.createObjectInstance();
        this.foreignIdField.assignField(connectionSource, createObjectInstance, obj, false);
        return createObjectInstance;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != FieldType.class) {
            return false;
        }
        FieldType fieldType = (FieldType) obj;
        if (!this.field.equals(fieldType.field)) {
            return false;
        }
        Class<?> cls = fieldType.parentClass;
        Class<?> cls2 = this.parentClass;
        if (cls2 == null) {
            if (cls != null) {
                return false;
            }
        } else if (!cls2.equals(cls)) {
            return false;
        }
        return true;
    }

    public final Object extractJavaFieldValue(Object obj) throws SQLException {
        Object extractRawJavaFieldValue = extractRawJavaFieldValue(obj);
        FieldType fieldType = this.foreignRefField;
        if (fieldType != null && extractRawJavaFieldValue != null) {
            return fieldType.extractRawJavaFieldValue(extractRawJavaFieldValue);
        }
        return extractRawJavaFieldValue;
    }

    public final <FV> FV extractRawJavaFieldValue(Object obj) throws SQLException {
        Method method = this.fieldGetMethod;
        if (method == null) {
            try {
                return (FV) this.field.get(obj);
            } catch (Exception e) {
                throw SupervisorKt.create("Could not get field value for " + this, e);
            }
        }
        try {
            return (FV) method.invoke(obj, new Object[0]);
        } catch (Exception e2) {
            throw SupervisorKt.create("Could not call " + method + " for " + this, e2);
        }
    }

    public final int hashCode() {
        return this.field.hashCode();
    }

    public final boolean isFieldValueDefault(Object obj) {
        Object obj2;
        if (obj == null) {
            return true;
        }
        Field field = this.field;
        if (field.getType() == Boolean.TYPE) {
            obj2 = Boolean.FALSE;
        } else if (field.getType() != Byte.TYPE && field.getType() != Byte.class) {
            if (field.getType() != Character.TYPE && field.getType() != Character.class) {
                if (field.getType() != Short.TYPE && field.getType() != Short.class) {
                    if (field.getType() != Integer.TYPE && field.getType() != Integer.class) {
                        if (field.getType() != Long.TYPE && field.getType() != Long.class) {
                            if (field.getType() != Float.TYPE && field.getType() != Float.class) {
                                if (field.getType() != Double.TYPE && field.getType() != Double.class) {
                                    obj2 = null;
                                } else {
                                    obj2 = Double.valueOf(0.0d);
                                }
                            } else {
                                obj2 = Float.valueOf(0.0f);
                            }
                        } else {
                            obj2 = 0L;
                        }
                    } else {
                        obj2 = 0;
                    }
                } else {
                    obj2 = (short) 0;
                }
            } else {
                obj2 = (char) 0;
            }
        } else {
            obj2 = (byte) 0;
        }
        return obj.equals(obj2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FieldType:name=");
        Field field = this.field;
        sb.append(field.getName());
        sb.append(",class=");
        sb.append(field.getDeclaringClass().getSimpleName());
        return sb.toString();
    }
}
