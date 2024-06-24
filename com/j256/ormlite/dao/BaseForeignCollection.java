package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    public final transient Dao<T, ID> dao;
    public final transient FieldType foreignFieldType;
    public final transient boolean orderAscending;
    public final transient String orderColumn;
    public final transient Object parent;
    public final transient Object parentId;
    public transient MappedPreparedStmt preparedQuery;

    public BaseForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        this.dao = dao;
        this.foreignFieldType = fieldType;
        this.parentId = obj2;
        this.orderColumn = str;
        this.orderAscending = z;
        this.parent = obj;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        try {
            return addElement(t);
        } catch (SQLException e) {
            throw new IllegalStateException("Could not create data element in dao", e);
        }
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            try {
                if (addElement(it.next())) {
                    z = true;
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Could not create data elements in dao", e);
            }
        }
        return z;
    }

    public final boolean addElement(T t) throws SQLException {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return false;
        }
        Object obj = this.parent;
        if (obj != null) {
            FieldType fieldType = this.foreignFieldType;
            Object extractJavaFieldValue = fieldType.extractJavaFieldValue(t);
            if (fieldType.isFieldValueDefault(extractJavaFieldValue)) {
                extractJavaFieldValue = null;
            }
            if (extractJavaFieldValue == null) {
                fieldType.assignField(dao.getConnectionSource(), t, obj, true);
            }
        }
        dao.create(t);
        return true;
    }

    @Override // java.util.Collection
    public final void clear() {
        if (this.dao == null) {
            return;
        }
        CloseableIterator<T> closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                closeableIterator.next();
                closeableIterator.remove();
            } finally {
                IOUtils.closeQuietly(closeableIterator);
            }
        }
    }

    public final PreparedQuery<T> getPreparedQuery() throws SQLException {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return null;
        }
        if (this.preparedQuery == null) {
            SelectArg selectArg = new SelectArg();
            selectArg.hasBeenSet = true;
            Object obj = this.parentId;
            selectArg.value = obj;
            QueryBuilder<T, ID> queryBuilder = dao.queryBuilder();
            String str = this.orderColumn;
            if (str != null) {
                queryBuilder.orderBy(str, this.orderAscending);
            }
            Where<T, ID> where = queryBuilder.where();
            where.eq(selectArg, this.foreignFieldType.columnName);
            MappedPreparedStmt prepareStatement = where.statementBuilder.prepareStatement(false);
            this.preparedQuery = prepareStatement;
            prepareStatement.parent = this.parent;
            prepareStatement.parentId = obj;
        }
        return this.preparedQuery;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        if (this.dao == null) {
            return false;
        }
        CloseableIterator<T> closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                if (!collection.contains(closeableIterator.next())) {
                    closeableIterator.remove();
                    z = true;
                }
            } finally {
                IOUtils.closeQuietly(closeableIterator);
            }
        }
        return z;
    }
}
