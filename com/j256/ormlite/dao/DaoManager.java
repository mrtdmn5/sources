package com.j256.ormlite.dao;

import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class DaoManager {
    public static HashMap classMap;
    public static HashMap configMap;
    public static final Logger logger = LoggerFactory.getLogger(DaoManager.class);
    public static HashMap tableConfigMap;

    /* loaded from: classes3.dex */
    public static class ClassConnectionSource {
        public final Class<?> clazz;
        public final ConnectionSource connectionSource;

        public ClassConnectionSource(ConnectionSource connectionSource, Class<?> cls) {
            this.connectionSource = connectionSource;
            this.clazz = cls;
        }

        public final boolean equals(Object obj) {
            if (obj == null || ClassConnectionSource.class != obj.getClass()) {
                return false;
            }
            ClassConnectionSource classConnectionSource = (ClassConnectionSource) obj;
            if (!this.clazz.equals(classConnectionSource.clazz) || !this.connectionSource.equals(classConnectionSource.connectionSource)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.connectionSource.hashCode() + ((this.clazz.hashCode() + 31) * 31);
        }
    }

    /* loaded from: classes3.dex */
    public static class TableConfigConnectionSource {
        public final ConnectionSource connectionSource;
        public final DatabaseTableConfig<?> tableConfig;

        public TableConfigConnectionSource(ConnectionSource connectionSource, DatabaseTableConfig<?> databaseTableConfig) {
            this.connectionSource = connectionSource;
            this.tableConfig = databaseTableConfig;
        }

        public final boolean equals(Object obj) {
            if (obj == null || TableConfigConnectionSource.class != obj.getClass()) {
                return false;
            }
            TableConfigConnectionSource tableConfigConnectionSource = (TableConfigConnectionSource) obj;
            if (!this.tableConfig.equals(tableConfigConnectionSource.tableConfig) || !this.connectionSource.equals(tableConfigConnectionSource.connectionSource)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.connectionSource.hashCode() + ((this.tableConfig.hashCode() + 31) * 31);
        }
    }

    public static synchronized void addCachedDatabaseConfigs(ArrayList arrayList) {
        HashMap hashMap;
        synchronized (DaoManager.class) {
            if (configMap == null) {
                hashMap = new HashMap();
            } else {
                hashMap = new HashMap(configMap);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                DatabaseTableConfig databaseTableConfig = (DatabaseTableConfig) it.next();
                hashMap.put(databaseTableConfig.dataClass, databaseTableConfig);
                Logger logger2 = logger;
                Object obj = databaseTableConfig.dataClass;
                logger2.getClass();
                Level level = Level.INFO;
                Object obj2 = Logger.UNKNOWN_ARG;
                logger2.logIfEnabled(level, null, "Loaded configuration for {}", obj, obj2, obj2, null);
            }
            configMap = hashMap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[Catch: all -> 0x00c7, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0009, B:10:0x0016, B:17:0x002d, B:19:0x0037, B:21:0x003f, B:24:0x0048, B:26:0x0056, B:29:0x0061, B:30:0x0077, B:32:0x0078, B:38:0x0087, B:39:0x0097, B:33:0x00ba, B:40:0x0098, B:42:0x00a3, B:43:0x00b3, B:44:0x00ab, B:45:0x001b, B:47:0x0025, B:48:0x00bf, B:49:0x00c6), top: B:3:0x0007, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized <D extends com.j256.ormlite.dao.Dao<T, ?>, T> D createDao(final com.j256.ormlite.support.ConnectionSource r6, final java.lang.Class<T> r7) throws java.sql.SQLException {
        /*
            java.lang.String r0 = "Could not find public constructor with ConnectionSource and optional Class parameters "
            java.lang.String r1 = "Could not call the constructor in class "
            java.lang.Class<com.j256.ormlite.dao.DaoManager> r2 = com.j256.ormlite.dao.DaoManager.class
            monitor-enter(r2)
            if (r6 == 0) goto Lbf
            com.j256.ormlite.dao.DaoManager$ClassConnectionSource r3 = new com.j256.ormlite.dao.DaoManager$ClassConnectionSource     // Catch: java.lang.Throwable -> Lc7
            r3.<init>(r6, r7)     // Catch: java.lang.Throwable -> Lc7
            com.j256.ormlite.dao.Dao r3 = lookupDao(r3)     // Catch: java.lang.Throwable -> Lc7
            if (r3 == 0) goto L16
            monitor-exit(r2)
            return r3
        L16:
            java.util.HashMap r3 = com.j256.ormlite.dao.DaoManager.configMap     // Catch: java.lang.Throwable -> Lc7
            if (r3 != 0) goto L1b
            goto L23
        L1b:
            java.lang.Object r3 = r3.get(r7)     // Catch: java.lang.Throwable -> Lc7
            com.j256.ormlite.table.DatabaseTableConfig r3 = (com.j256.ormlite.table.DatabaseTableConfig) r3     // Catch: java.lang.Throwable -> Lc7
            if (r3 != 0) goto L25
        L23:
            r3 = 0
            goto L29
        L25:
            com.j256.ormlite.dao.Dao r3 = doCreateDao(r6, r3)     // Catch: java.lang.Throwable -> Lc7
        L29:
            if (r3 == 0) goto L2d
            monitor-exit(r2)
            return r3
        L2d:
            java.lang.Class<com.j256.ormlite.table.DatabaseTable> r3 = com.j256.ormlite.table.DatabaseTable.class
            java.lang.annotation.Annotation r3 = r7.getAnnotation(r3)     // Catch: java.lang.Throwable -> Lc7
            com.j256.ormlite.table.DatabaseTable r3 = (com.j256.ormlite.table.DatabaseTable) r3     // Catch: java.lang.Throwable -> Lc7
            if (r3 == 0) goto L98
            java.lang.Class r4 = r3.daoClass()     // Catch: java.lang.Throwable -> Lc7
            java.lang.Class<java.lang.Void> r5 = java.lang.Void.class
            if (r4 == r5) goto L98
            java.lang.Class r4 = r3.daoClass()     // Catch: java.lang.Throwable -> Lc7
            java.lang.Class<com.j256.ormlite.dao.BaseDaoImpl> r5 = com.j256.ormlite.dao.BaseDaoImpl.class
            if (r4 != r5) goto L48
            goto L98
        L48:
            java.lang.Class r3 = r3.daoClass()     // Catch: java.lang.Throwable -> Lc7
            java.lang.Object[] r4 = new java.lang.Object[]{r6, r7}     // Catch: java.lang.Throwable -> Lc7
            java.lang.reflect.Constructor r5 = findConstructor(r3, r4)     // Catch: java.lang.Throwable -> Lc7
            if (r5 != 0) goto L78
            java.lang.Object[] r4 = new java.lang.Object[]{r6}     // Catch: java.lang.Throwable -> Lc7
            java.lang.reflect.Constructor r5 = findConstructor(r3, r4)     // Catch: java.lang.Throwable -> Lc7
            if (r5 == 0) goto L61
            goto L78
        L61:
            java.sql.SQLException r6 = new java.sql.SQLException     // Catch: java.lang.Throwable -> Lc7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc7
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lc7
            r7.append(r3)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r0 = ".  Missing static on class?"
            r7.append(r0)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lc7
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lc7
            throw r6     // Catch: java.lang.Throwable -> Lc7
        L78:
            java.lang.Object r0 = r5.newInstance(r4)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> Lc7
            com.j256.ormlite.dao.Dao r0 = (com.j256.ormlite.dao.Dao) r0     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> Lc7
            com.j256.ormlite.logger.Logger r4 = com.j256.ormlite.dao.DaoManager.logger     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> Lc7
            java.lang.String r5 = "created dao for class {} from constructor"
            r4.debug(r7, r5)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> Lc7
            goto Lba
        L86:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc7
            r7.<init>(r1)     // Catch: java.lang.Throwable -> Lc7
            r7.append(r3)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lc7
            java.sql.SQLException r6 = kotlinx.coroutines.SupervisorKt.create(r7, r6)     // Catch: java.lang.Throwable -> Lc7
            throw r6     // Catch: java.lang.Throwable -> Lc7
        L98:
            r0 = r6
            com.j256.ormlite.android.AndroidConnectionSource r0 = (com.j256.ormlite.android.AndroidConnectionSource) r0     // Catch: java.lang.Throwable -> Lc7
            com.j256.ormlite.db.SqliteAndroidDatabaseType r0 = r0.databaseType     // Catch: java.lang.Throwable -> Lc7
            com.j256.ormlite.table.DatabaseTableConfig r0 = r0.extractDatabaseTableConfig(r6, r7)     // Catch: java.lang.Throwable -> Lc7
            if (r0 != 0) goto Lab
            com.j256.ormlite.dao.BaseDaoImpl$1 r0 = com.j256.ormlite.dao.BaseDaoImpl.daoConfigLevelLocal     // Catch: java.lang.Throwable -> Lc7
            com.j256.ormlite.dao.BaseDaoImpl$5 r0 = new com.j256.ormlite.dao.BaseDaoImpl$5     // Catch: java.lang.Throwable -> Lc7
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> Lc7
            goto Lb3
        Lab:
            com.j256.ormlite.dao.BaseDaoImpl$1 r1 = com.j256.ormlite.dao.BaseDaoImpl.daoConfigLevelLocal     // Catch: java.lang.Throwable -> Lc7
            com.j256.ormlite.dao.BaseDaoImpl$6 r1 = new com.j256.ormlite.dao.BaseDaoImpl$6     // Catch: java.lang.Throwable -> Lc7
            r1.<init>(r6, r0)     // Catch: java.lang.Throwable -> Lc7
            r0 = r1
        Lb3:
            com.j256.ormlite.logger.Logger r1 = com.j256.ormlite.dao.DaoManager.logger     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r3 = "created dao for class {} with reflection"
            r1.debug(r7, r3)     // Catch: java.lang.Throwable -> Lc7
        Lba:
            registerDao(r6, r0)     // Catch: java.lang.Throwable -> Lc7
            monitor-exit(r2)
            return r0
        Lbf:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r7 = "connectionSource argument cannot be null"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lc7
            throw r6     // Catch: java.lang.Throwable -> Lc7
        Lc7:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.dao.DaoManager.createDao(com.j256.ormlite.support.ConnectionSource, java.lang.Class):com.j256.ormlite.dao.Dao");
    }

    public static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        D anonymousClass6;
        TableConfigConnectionSource tableConfigConnectionSource = new TableConfigConnectionSource(connectionSource, databaseTableConfig);
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        D d = (D) tableConfigMap.get(tableConfigConnectionSource);
        if (d == null) {
            d = null;
        }
        if (d != null) {
            return d;
        }
        Class<T> cls = databaseTableConfig.dataClass;
        ClassConnectionSource classConnectionSource = new ClassConnectionSource(connectionSource, cls);
        D d2 = (D) lookupDao(classConnectionSource);
        if (d2 != null) {
            if (tableConfigMap == null) {
                tableConfigMap = new HashMap();
            }
            tableConfigMap.put(tableConfigConnectionSource, d2);
            return d2;
        }
        DatabaseTable databaseTable = (DatabaseTable) databaseTableConfig.dataClass.getAnnotation(DatabaseTable.class);
        if (databaseTable != null && databaseTable.daoClass() != Void.class && databaseTable.daoClass() != BaseDaoImpl.class) {
            Class<?> daoClass = databaseTable.daoClass();
            Object[] objArr = {connectionSource, databaseTableConfig};
            Constructor<?> findConstructor = findConstructor(daoClass, objArr);
            if (findConstructor != null) {
                try {
                    anonymousClass6 = (D) findConstructor.newInstance(objArr);
                } catch (Exception e) {
                    throw SupervisorKt.create("Could not call the constructor in class " + daoClass, e);
                }
            } else {
                throw new SQLException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class ", daoClass));
            }
        } else {
            BaseDaoImpl.AnonymousClass1 anonymousClass1 = BaseDaoImpl.daoConfigLevelLocal;
            anonymousClass6 = new BaseDaoImpl.AnonymousClass6(connectionSource, databaseTableConfig);
        }
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        tableConfigMap.put(tableConfigConnectionSource, anonymousClass6);
        logger.debug(cls, "created dao for class {} from table config");
        if (lookupDao(classConnectionSource) == null) {
            if (classMap == null) {
                classMap = new HashMap();
            }
            classMap.put(classConnectionSource, anonymousClass6);
        }
        return anonymousClass6;
    }

    public static Constructor<?> findConstructor(Class<?> cls, Object[] objArr) {
        boolean z;
        for (Constructor<?> constructor : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                int r5 = 0;
                while (true) {
                    if (r5 < parameterTypes.length) {
                        if (!parameterTypes[r5].isAssignableFrom(objArr[r5].getClass())) {
                            z = false;
                            break;
                        }
                        r5++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public static <T> Dao<?, ?> lookupDao(ClassConnectionSource classConnectionSource) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        Dao<?, ?> dao = (Dao) classMap.get(classConnectionSource);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    public static synchronized void registerDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            try {
                if (connectionSource != null) {
                    ClassConnectionSource classConnectionSource = new ClassConnectionSource(connectionSource, dao.getDataClass());
                    if (classMap == null) {
                        classMap = new HashMap();
                    }
                    classMap.put(classConnectionSource, dao);
                } else {
                    throw new IllegalArgumentException("connectionSource argument cannot be null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void unregisterDao(ConnectionSource connectionSource, BaseDaoImpl baseDaoImpl) {
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                ClassConnectionSource classConnectionSource = new ClassConnectionSource(connectionSource, baseDaoImpl.dataClass);
                HashMap hashMap = classMap;
                if (hashMap != null) {
                    hashMap.remove(classConnectionSource);
                }
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
    }
}
