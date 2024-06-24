package com.j256.ormlite.dao;

import com.j256.ormlite.misc.IOUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> {
    @Override // com.j256.ormlite.dao.CloseableIterable
    public final CloseableIterator<T> closeableIterator() {
        return closeableIterator$1();
    }

    public final CloseableIterator closeableIterator$1() {
        Dao<T, ID> dao = this.dao;
        try {
            if (dao != null) {
                return dao.iterator(getPreparedQuery());
            }
            throw new IllegalStateException("Internal DAO object is null.  Maybe the collection was deserialized or otherwise constructed wrongly.  Use dao.assignEmptyForeignCollection(...) or dao.getEmptyForeignCollection(...) instead");
        } catch (SQLException e) {
            throw new IllegalStateException("Could not build lazy iterator for " + dao.getDataClass(), e);
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        do {
            try {
                if (!closeableIterator$1.hasNext()) {
                    IOUtils.closeQuietly(closeableIterator$1);
                    return false;
                }
            } catch (Throwable th) {
                IOUtils.closeQuietly(closeableIterator$1);
                throw th;
            }
        } while (!closeableIterator$1.next().equals(obj));
        IOUtils.closeQuietly(closeableIterator$1);
        return true;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet(collection);
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        while (closeableIterator$1.hasNext()) {
            try {
                hashSet.remove(closeableIterator$1.next());
            } finally {
                IOUtils.closeQuietly(closeableIterator$1);
            }
        }
        return hashSet.isEmpty();
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        try {
            return !closeableIterator$1.hasNext();
        } finally {
            IOUtils.closeQuietly(closeableIterator$1);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return closeableIterator$1();
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        do {
            try {
                if (!closeableIterator$1.hasNext()) {
                    IOUtils.closeQuietly(closeableIterator$1);
                    return false;
                }
            } catch (Throwable th) {
                IOUtils.closeQuietly(closeableIterator$1);
                throw th;
            }
        } while (!closeableIterator$1.next().equals(obj));
        closeableIterator$1.remove();
        IOUtils.closeQuietly(closeableIterator$1);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        boolean z = false;
        while (closeableIterator$1.hasNext()) {
            try {
                if (collection.contains(closeableIterator$1.next())) {
                    closeableIterator$1.remove();
                    z = true;
                }
            } finally {
                IOUtils.closeQuietly(closeableIterator$1);
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        int r1 = 0;
        while (closeableIterator$1.hasNext()) {
            try {
                closeableIterator$1.moveToNext();
                r1++;
            } finally {
                IOUtils.closeQuietly(closeableIterator$1);
            }
        }
        return r1;
    }

    @Override // java.util.Collection
    public final <E> E[] toArray(E[] eArr) {
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        ArrayList arrayList = null;
        int r4 = 0;
        while (closeableIterator$1.hasNext()) {
            try {
                T next = closeableIterator$1.next();
                if (r4 >= eArr.length) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        for (E e : eArr) {
                            arrayList.add(e);
                        }
                    }
                    arrayList.add(next);
                } else {
                    eArr[r4] = next;
                }
                r4++;
            } finally {
                IOUtils.closeQuietly(closeableIterator$1);
            }
        }
        if (arrayList == null) {
            if (r4 < eArr.length - 1) {
                eArr[r4] = 0;
            }
            return eArr;
        }
        return (E[]) arrayList.toArray(eArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator closeableIterator$1 = closeableIterator$1();
        while (closeableIterator$1.hasNext()) {
            try {
                arrayList.add(closeableIterator$1.next());
            } catch (Throwable th) {
                IOUtils.closeQuietly(closeableIterator$1);
                throw th;
            }
        }
        IOUtils.closeQuietly(closeableIterator$1);
        return arrayList.toArray();
    }
}
