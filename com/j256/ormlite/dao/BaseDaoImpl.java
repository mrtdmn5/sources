package com.j256.ormlite.dao;

import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.notification.model.Contact;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public abstract class BaseDaoImpl<T, ID> implements Dao<T, ID> {
    public static final AnonymousClass1 daoConfigLevelLocal = new AnonymousClass1();
    public final ConnectionSource connectionSource;
    public final Constructor<T> constructor;
    public final Class<T> dataClass;
    public SqliteAndroidDatabaseType databaseType;
    public boolean initialized;
    public StatementExecutor<T, ID> statementExecutor;
    public final DatabaseTableConfig<T> tableConfig;
    public TableInfo<T, ID> tableInfo;

    /* renamed from: com.j256.ormlite.dao.BaseDaoImpl$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 extends ThreadLocal<List<BaseDaoImpl<?, ?>>> {
        @Override // java.lang.ThreadLocal
        public final List<BaseDaoImpl<?, ?>> initialValue() {
            return new ArrayList(10);
        }
    }

    /* renamed from: com.j256.ormlite.dao.BaseDaoImpl$6, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass6 extends BaseDaoImpl<Object, Object> {
        public AnonymousClass6(ConnectionSource connectionSource, DatabaseTableConfig databaseTableConfig) {
            super(connectionSource, databaseTableConfig.dataClass, databaseTableConfig);
        }

        @Override // com.j256.ormlite.dao.BaseDaoImpl, java.lang.Iterable
        public final /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }
    }

    public BaseDaoImpl() throws SQLException {
        throw null;
    }

    public BaseDaoImpl(ConnectionSource connectionSource, Class<T> cls, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        FieldType fieldType;
        Field declaredField;
        this.dataClass = cls;
        this.tableConfig = databaseTableConfig;
        try {
            for (Object obj : cls.getDeclaredConstructors()) {
                Constructor<T> constructor = (Constructor<T>) obj;
                if (constructor.getParameterTypes().length == 0) {
                    if (!constructor.isAccessible()) {
                        try {
                            constructor.setAccessible(true);
                        } catch (SecurityException unused) {
                            throw new IllegalArgumentException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Could not open access to constructor for ", cls));
                        }
                    }
                    this.constructor = constructor;
                    if (connectionSource != null) {
                        this.connectionSource = connectionSource;
                        if (this.initialized) {
                            return;
                        }
                        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) connectionSource).databaseType;
                        this.databaseType = sqliteAndroidDatabaseType;
                        if (sqliteAndroidDatabaseType != null) {
                            DatabaseTableConfig<T> databaseTableConfig2 = this.tableConfig;
                            if (databaseTableConfig2 == null) {
                                this.tableInfo = new TableInfo<>(sqliteAndroidDatabaseType, this.dataClass);
                            } else {
                                if (databaseTableConfig2.fieldTypes == null) {
                                    List<DatabaseFieldConfig> list = databaseTableConfig2.fieldConfigs;
                                    if (list == null) {
                                        databaseTableConfig2.fieldTypes = DatabaseTableConfig.extractFieldTypes(sqliteAndroidDatabaseType, databaseTableConfig2.dataClass, databaseTableConfig2.tableName);
                                    } else {
                                        String str = databaseTableConfig2.tableName;
                                        ArrayList arrayList = new ArrayList();
                                        for (DatabaseFieldConfig databaseFieldConfig : list) {
                                            Class<T> cls2 = databaseTableConfig2.dataClass;
                                            while (true) {
                                                if (cls2 == null) {
                                                    fieldType = null;
                                                    break;
                                                }
                                                try {
                                                    declaredField = cls2.getDeclaredField(databaseFieldConfig.fieldName);
                                                } catch (NoSuchFieldException unused2) {
                                                }
                                                if (declaredField != null) {
                                                    fieldType = new FieldType(sqliteAndroidDatabaseType, str, declaredField, databaseFieldConfig, databaseTableConfig2.dataClass);
                                                    break;
                                                }
                                                cls2 = cls2.getSuperclass();
                                            }
                                            if (fieldType != null) {
                                                arrayList.add(fieldType);
                                            } else {
                                                throw new SQLException("Could not find declared field with name '" + databaseFieldConfig.fieldName + "' for " + databaseTableConfig2.dataClass);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            databaseTableConfig2.fieldTypes = (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
                                        } else {
                                            throw new SQLException("No fields were configured for class " + databaseTableConfig2.dataClass);
                                        }
                                    }
                                }
                                this.tableInfo = new TableInfo<>(this.databaseType, databaseTableConfig2);
                            }
                            this.statementExecutor = new StatementExecutor<>(this.databaseType, this.tableInfo, this);
                            AnonymousClass1 anonymousClass1 = daoConfigLevelLocal;
                            List<BaseDaoImpl<?, ?>> list2 = anonymousClass1.get();
                            list2.add(this);
                            if (list2.size() > 1) {
                                return;
                            }
                            for (int r0 = 0; r0 < list2.size(); r0++) {
                                try {
                                    BaseDaoImpl<?, ?> baseDaoImpl = list2.get(r0);
                                    DaoManager.registerDao(connectionSource, baseDaoImpl);
                                    try {
                                        for (FieldType fieldType2 : baseDaoImpl.tableInfo.fieldTypes) {
                                            fieldType2.configDaoInformation(connectionSource, baseDaoImpl.dataClass);
                                        }
                                        baseDaoImpl.initialized = true;
                                    } catch (SQLException e) {
                                        DaoManager.unregisterDao(connectionSource, baseDaoImpl);
                                        throw e;
                                    }
                                } finally {
                                    list2.clear();
                                    anonymousClass1.remove();
                                }
                            }
                            return;
                        }
                        throw new IllegalStateException("connectionSource is getting a null DatabaseType in ".concat(getClass().getSimpleName()));
                    }
                    return;
                }
            }
            if (cls.getEnclosingClass() == null) {
                throw new IllegalArgumentException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Can't find a no-arg constructor for ", cls));
            }
            throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls + ".  Missing static on inner class?");
        } catch (Exception e2) {
            throw new IllegalArgumentException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Can't lookup declared constructors for ", cls), e2);
        }
    }

    public final void checkForInitialized() {
        if (this.initialized) {
        } else {
            throw new IllegalStateException("you must call initialize() before you can use the dao");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.j256.ormlite.dao.Dao
    public final int create(T t) throws SQLException {
        checkForInitialized();
        if (t == 0) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
        }
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        try {
            this.statementExecutor.create(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), t);
            connectionSource.getClass();
            return 1;
        } catch (Throwable th) {
            connectionSource.getClass();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.j256.ormlite.dao.Dao
    public final T createObjectInstance() throws SQLException {
        Constructor<T> constructor = this.constructor;
        try {
            T newInstance = constructor.newInstance(new Object[0]);
            if (newInstance instanceof BaseDaoEnabled) {
                ((BaseDaoEnabled) newInstance).getClass();
            }
            return newInstance;
        } catch (Exception e) {
            throw SupervisorKt.create("Could not create object for " + constructor.getDeclaringClass(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.j256.ormlite.dao.Dao
    public final synchronized Dao.CreateOrUpdateStatus createOrUpdate(Contact contact) throws SQLException {
        Object extractId = extractId(contact);
        if (extractId != null) {
            String str = this.tableInfo.tableName;
            ConnectionSource connectionSource = this.connectionSource;
            try {
                if (this.statementExecutor.ifExists(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), extractId)) {
                    update((BaseDaoImpl<T, ID>) contact);
                    return new Dao.CreateOrUpdateStatus();
                }
            } finally {
                connectionSource.getClass();
            }
        }
        create(contact);
        return new Dao.CreateOrUpdateStatus();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int delete(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        try {
            return this.statementExecutor.delete(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), t);
        } finally {
            connectionSource.getClass();
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final DeleteBuilder<T, ID> deleteBuilder() {
        checkForInitialized();
        return new DeleteBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int deleteById(Integer num) throws SQLException {
        checkForInitialized();
        if (num == null) {
            return 0;
        }
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        try {
            return this.statementExecutor.deleteById(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), num);
        } finally {
            connectionSource.getClass();
        }
    }

    public final Object extractId(Contact contact) throws SQLException {
        checkForInitialized();
        FieldType fieldType = this.tableInfo.idField;
        if (fieldType != null) {
            return fieldType.extractJavaFieldValue(contact);
        }
        throw new SQLException("Class " + this.dataClass + " does not have an id field");
    }

    @Override // com.j256.ormlite.dao.Dao
    public final ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    @Override // com.j256.ormlite.dao.Dao
    public final Class<T> getDataClass() {
        return this.dataClass;
    }

    @Override // com.j256.ormlite.dao.Dao
    public final TableInfo<T, ID> getTableInfo() {
        return this.tableInfo;
    }

    @Override // com.j256.ormlite.dao.Dao
    public final List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        return this.statementExecutor.query(this.connectionSource, preparedQuery);
    }

    @Override // com.j256.ormlite.dao.Dao
    public final QueryBuilder<T, ID> queryBuilder() {
        checkForInitialized();
        return new QueryBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public final List<T> queryForAll() throws SQLException {
        boolean z;
        checkForInitialized();
        StatementExecutor<T, ID> statementExecutor = this.statementExecutor;
        if (statementExecutor.preparedQueryForAll == null) {
            QueryBuilder queryBuilder = new QueryBuilder(statementExecutor.databaseType, statementExecutor.tableInfo, statementExecutor.dao);
            if (queryBuilder.selectList == null) {
                z = true;
            } else {
                z = false;
            }
            statementExecutor.preparedQueryForAll = queryBuilder.prepareStatement(z);
        }
        return statementExecutor.query(this.connectionSource, statementExecutor.preparedQueryForAll);
    }

    @Override // com.j256.ormlite.dao.Dao
    public final List queryForEq(Integer num) throws SQLException {
        Where<T, ID> where = queryBuilder().where();
        where.eq(num, "type");
        return where.query();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final T queryForId(ID r7) throws SQLException {
        checkForInitialized();
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        DatabaseConnection readWriteConnection = ((AndroidConnectionSource) connectionSource).getReadWriteConnection();
        try {
            StatementExecutor<T, ID> statementExecutor = this.statementExecutor;
            if (statementExecutor.mappedQueryForId == null) {
                statementExecutor.mappedQueryForId = MappedQueryForFieldEq.build(statementExecutor.dao, statementExecutor.tableInfo, null);
            }
            return (T) statementExecutor.mappedQueryForId.execute(readWriteConnection, r7);
        } finally {
            connectionSource.getClass();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.j256.ormlite.dao.Dao
    public final int refresh(Contact contact) throws SQLException {
        checkForInitialized();
        if (contact instanceof BaseDaoEnabled) {
        }
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        try {
            return this.statementExecutor.refresh(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), contact);
        } finally {
            connectionSource.getClass();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.j256.ormlite.dao.Dao
    public final int update(T t) throws SQLException {
        checkForInitialized();
        if (t == 0) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
        }
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        try {
            return this.statementExecutor.update(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), t);
        } finally {
            connectionSource.getClass();
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final UpdateBuilder<T, ID> updateBuilder() {
        checkForInitialized();
        return new UpdateBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // java.lang.Iterable
    public final CloseableIterator<T> iterator() {
        checkForInitialized();
        try {
            StatementExecutor<T, ID> statementExecutor = this.statementExecutor;
            ConnectionSource connectionSource = this.connectionSource;
            if (statementExecutor.preparedQueryForAll == null) {
                QueryBuilder queryBuilder = new QueryBuilder(statementExecutor.databaseType, statementExecutor.tableInfo, statementExecutor.dao);
                statementExecutor.preparedQueryForAll = queryBuilder.prepareStatement(queryBuilder.selectList == null);
            }
            return statementExecutor.buildIterator(this, connectionSource, statementExecutor.preparedQueryForAll);
        } catch (Exception e) {
            throw new IllegalStateException("Could not build iterator for " + this.dataClass, e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int delete(MappedPreparedStmt mappedPreparedStmt) throws SQLException {
        checkForInitialized();
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        try {
            return this.statementExecutor.delete(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), mappedPreparedStmt);
        } finally {
            connectionSource.getClass();
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int update(MappedPreparedStmt mappedPreparedStmt) throws SQLException {
        checkForInitialized();
        String str = this.tableInfo.tableName;
        ConnectionSource connectionSource = this.connectionSource;
        try {
            return this.statementExecutor.update(((AndroidConnectionSource) connectionSource).getReadWriteConnection(), mappedPreparedStmt);
        } finally {
            connectionSource.getClass();
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final CloseableIterator iterator(PreparedQuery preparedQuery) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, preparedQuery);
        } catch (SQLException e) {
            throw SupervisorKt.create("Could not build prepared-query iterator for " + this.dataClass, e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final void getObjectCache() {
    }

    @Override // com.j256.ormlite.dao.Dao
    public final void notifyChanges() {
    }
}
