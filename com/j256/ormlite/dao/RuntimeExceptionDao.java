package com.j256.ormlite.dao;

import com.animaconnected.secondo.notification.model.Contact;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes3.dex */
public final class RuntimeExceptionDao<T, ID> implements Dao<T, ID> {
    public static final Level LOG_LEVEL = Level.DEBUG;
    public static final Logger logger = LoggerFactory.getLogger(RuntimeExceptionDao.class);
    public final Dao<T, ID> dao;

    public RuntimeExceptionDao(Dao<T, ID> dao) {
        this.dao = dao;
    }

    public static void logMessage(SQLException sQLException, String str) {
        Logger logger2 = logger;
        Level level = LOG_LEVEL;
        Object obj = Logger.UNKNOWN_ARG;
        logger2.logIfEnabled(level, sQLException, str, obj, obj, obj, null);
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int create(T t) {
        try {
            return this.dao.create(t);
        } catch (SQLException e) {
            logMessage(e, "create threw exception on: " + t);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final T createObjectInstance() {
        try {
            return this.dao.createObjectInstance();
        } catch (SQLException e) {
            logMessage(e, "createObjectInstance() threw exception");
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final Dao.CreateOrUpdateStatus createOrUpdate(Contact contact) {
        try {
            return this.dao.createOrUpdate(contact);
        } catch (SQLException e) {
            logMessage(e, "createOrUpdate threw exception on: " + contact);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int delete(T t) {
        try {
            return this.dao.delete((Dao<T, ID>) t);
        } catch (SQLException e) {
            logMessage(e, "delete threw exception on: " + t);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final DeleteBuilder<T, ID> deleteBuilder() {
        return this.dao.deleteBuilder();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int deleteById(Integer num) {
        try {
            return this.dao.deleteById(num);
        } catch (SQLException e) {
            logMessage(e, "deleteById threw exception on: " + num);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final ConnectionSource getConnectionSource() {
        return this.dao.getConnectionSource();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final Class<T> getDataClass() {
        return this.dao.getDataClass();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final void getObjectCache() {
        this.dao.getObjectCache();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final TableInfo<T, ID> getTableInfo() {
        return this.dao.getTableInfo();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final void notifyChanges() {
        this.dao.notifyChanges();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final List<T> query(PreparedQuery<T> preparedQuery) {
        try {
            return this.dao.query(preparedQuery);
        } catch (SQLException e) {
            logMessage(e, "query threw exception on: " + preparedQuery);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final QueryBuilder<T, ID> queryBuilder() {
        return this.dao.queryBuilder();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final List<T> queryForAll() {
        try {
            return this.dao.queryForAll();
        } catch (SQLException e) {
            logMessage(e, "queryForAll threw exception");
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final List queryForEq(Integer num) {
        try {
            return this.dao.queryForEq(num);
        } catch (SQLException e) {
            logMessage(e, "queryForEq threw exception on: type");
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final T queryForId(ID r4) {
        try {
            return this.dao.queryForId(r4);
        } catch (SQLException e) {
            logMessage(e, "queryForId threw exception on: " + r4);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int refresh(Contact contact) {
        try {
            return this.dao.refresh(contact);
        } catch (SQLException e) {
            logMessage(e, "refresh threw exception on: " + contact);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int update(T t) {
        try {
            return this.dao.update((Dao<T, ID>) t);
        } catch (SQLException e) {
            logMessage(e, "update threw exception on: " + t);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final UpdateBuilder<T, ID> updateBuilder() {
        return this.dao.updateBuilder();
    }

    @Override // java.lang.Iterable
    public final CloseableIterator<T> iterator() {
        return this.dao.iterator();
    }

    @Override // com.j256.ormlite.dao.Dao
    public final CloseableIterator iterator(PreparedQuery preparedQuery) {
        try {
            return this.dao.iterator(preparedQuery);
        } catch (SQLException e) {
            logMessage(e, "iterator threw exception on: " + preparedQuery);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int delete(MappedPreparedStmt mappedPreparedStmt) {
        try {
            return this.dao.delete(mappedPreparedStmt);
        } catch (SQLException e) {
            logMessage(e, "delete threw exception on: " + mappedPreparedStmt);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public final int update(MappedPreparedStmt mappedPreparedStmt) {
        try {
            return this.dao.update(mappedPreparedStmt);
        } catch (SQLException e) {
            logMessage(e, "update threw exception on: " + mappedPreparedStmt);
            throw new RuntimeException(e);
        }
    }
}
