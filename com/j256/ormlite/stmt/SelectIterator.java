package com.j256.ormlite.stmt;

import com.j256.ormlite.android.AndroidCompiledStatement;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.io.IOException;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class SelectIterator<T, ID> implements CloseableIterator<T> {
    public static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
    public boolean alreadyMoved;
    public final Dao<T, ID> classDao;
    public boolean closed;
    public final CompiledStatement compiledStmt;
    public final ConnectionSource connectionSource;
    public final Class<?> dataClass;
    public boolean first = true;
    public T last;
    public final AndroidDatabaseResults results;
    public int rowC;
    public final GenericRowMapper<T> rowMapper;

    public SelectIterator(Class cls, Dao dao, GenericRowMapper genericRowMapper, ConnectionSource connectionSource, DatabaseConnection databaseConnection, AndroidCompiledStatement androidCompiledStatement) throws SQLException {
        this.dataClass = cls;
        this.classDao = dao;
        this.rowMapper = genericRowMapper;
        this.connectionSource = connectionSource;
        this.compiledStmt = androidCompiledStatement;
        this.results = androidCompiledStatement.runQuery();
        logger.debug(Integer.valueOf(hashCode()), androidCompiledStatement, "starting iterator @{} for '{}'");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (!this.closed) {
            ((AndroidCompiledStatement) this.compiledStmt).close();
            this.closed = true;
            this.last = null;
            logger.debug(Integer.valueOf(hashCode()), Integer.valueOf(this.rowC), "closed iterator @{} after {} rows");
            try {
                this.connectionSource.getClass();
            } catch (SQLException e) {
                throw new IOException("could not release connection", e);
            }
        }
    }

    public final T getCurrent() throws SQLException {
        T t = (T) this.rowMapper.mapRow(this.results);
        this.last = t;
        this.alreadyMoved = false;
        this.rowC++;
        return t;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        try {
            return hasNextThrow();
        } catch (SQLException e) {
            this.last = null;
            IOUtils.closeQuietly(this);
            throw new IllegalStateException("Errors getting more results of " + this.dataClass, e);
        }
    }

    public final boolean hasNextThrow() throws SQLException {
        boolean moveToNext;
        if (this.closed) {
            return false;
        }
        if (this.alreadyMoved) {
            return true;
        }
        boolean z = this.first;
        AndroidDatabaseResults androidDatabaseResults = this.results;
        if (z) {
            this.first = false;
            moveToNext = androidDatabaseResults.cursor.moveToFirst();
        } else {
            moveToNext = androidDatabaseResults.cursor.moveToNext();
        }
        if (!moveToNext) {
            IOUtils.closeThrowSqlException(this, "iterator");
        }
        this.alreadyMoved = true;
        return moveToNext;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public final void moveToNext() {
        this.last = null;
        this.first = false;
        this.alreadyMoved = false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T nextThrow;
        try {
            nextThrow = nextThrow();
        } catch (SQLException e) {
            e = e;
        }
        if (nextThrow != null) {
            return nextThrow;
        }
        e = null;
        this.last = null;
        IOUtils.closeQuietly(this);
        throw new IllegalStateException("Could not get next result for " + this.dataClass, e);
    }

    public final T nextThrow() throws SQLException {
        boolean moveToNext;
        if (this.closed) {
            return null;
        }
        if (!this.alreadyMoved) {
            boolean z = this.first;
            AndroidDatabaseResults androidDatabaseResults = this.results;
            if (z) {
                this.first = false;
                moveToNext = androidDatabaseResults.cursor.moveToFirst();
            } else {
                moveToNext = androidDatabaseResults.cursor.moveToNext();
            }
            if (!moveToNext) {
                this.first = false;
                return null;
            }
        }
        this.first = false;
        return getCurrent();
    }

    @Override // java.util.Iterator
    public final void remove() {
        try {
            removeThrow();
        } catch (SQLException e) {
            IOUtils.closeQuietly(this);
            throw new IllegalStateException("Could not delete " + this.dataClass + " object " + this.last, e);
        }
    }

    public final void removeThrow() throws SQLException {
        T t = this.last;
        Class<?> cls = this.dataClass;
        if (t != null) {
            Dao<T, ID> dao = this.classDao;
            if (dao != null) {
                try {
                    dao.delete((Dao<T, ID>) t);
                    return;
                } finally {
                    this.last = null;
                }
            } else {
                throw new IllegalStateException("Cannot remove " + cls + " object because classDao not initialized");
            }
        }
        throw new IllegalStateException("No last " + cls + " object to remove. Must be called after a call to next.");
    }
}
