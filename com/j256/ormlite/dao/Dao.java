package com.j256.ormlite.dao;

import com.animaconnected.secondo.notification.model.Contact;
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
public interface Dao<T, ID> extends CloseableIterable<T> {

    /* loaded from: classes3.dex */
    public static class CreateOrUpdateStatus {
    }

    int create(T t) throws SQLException;

    T createObjectInstance() throws SQLException;

    CreateOrUpdateStatus createOrUpdate(Contact contact) throws SQLException;

    int delete(MappedPreparedStmt mappedPreparedStmt) throws SQLException;

    int delete(T t) throws SQLException;

    DeleteBuilder<T, ID> deleteBuilder();

    int deleteById(Integer num) throws SQLException;

    ConnectionSource getConnectionSource();

    Class<T> getDataClass();

    void getObjectCache();

    TableInfo<T, ID> getTableInfo();

    @Override // java.lang.Iterable
    CloseableIterator<T> iterator();

    CloseableIterator iterator(PreparedQuery preparedQuery) throws SQLException;

    void notifyChanges();

    List<T> query(PreparedQuery<T> preparedQuery) throws SQLException;

    QueryBuilder<T, ID> queryBuilder();

    List<T> queryForAll() throws SQLException;

    List queryForEq(Integer num) throws SQLException;

    T queryForId(ID r1) throws SQLException;

    int refresh(Contact contact) throws SQLException;

    int update(MappedPreparedStmt mappedPreparedStmt) throws SQLException;

    int update(T t) throws SQLException;

    UpdateBuilder<T, ID> updateBuilder();
}
