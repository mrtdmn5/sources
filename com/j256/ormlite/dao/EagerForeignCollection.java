package com.j256.ormlite.dao;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.j256.ormlite.field.FieldType;
import java.io.Closeable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public final class EagerForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements CloseableIterable, Closeable, List<T> {
    public final List<T> results;

    public EagerForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) throws SQLException {
        super(dao, obj, obj2, fieldType, str, z);
        if (obj2 == null) {
            this.results = new ArrayList();
        } else {
            this.results = dao.query(getPreparedQuery());
        }
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public final boolean add(T t) {
        if (this.results.add(t)) {
            return super.add(t);
        }
        return false;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        if (this.results.addAll(collection)) {
            return super.addAll(collection);
        }
        return false;
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public final CloseableIterator<T> closeableIterator() {
        return new AnonymousClass1();
    }

    @Override // java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.results.contains(obj);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean containsAll(Collection<?> collection) {
        return this.results.containsAll(collection);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (!(obj instanceof EagerForeignCollection)) {
            return false;
        }
        return this.results.equals(((EagerForeignCollection) obj).results);
    }

    @Override // java.util.List
    public final T get(int r2) {
        return this.results.get(r2);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        return this.results.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.results.indexOf(obj);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.results.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new AnonymousClass1();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.results.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return this.results.listIterator();
    }

    @Override // java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        Dao<T, ID> dao;
        if (!this.results.remove(obj) || (dao = this.dao) == null) {
            return false;
        }
        try {
            return dao.delete((Dao<T, ID>) obj) == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Could not delete data element from dao", e);
        }
    }

    @Override // java.util.Collection, java.util.List
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.List
    public final T set(int r1, T t) {
        throw new UnsupportedOperationException("setting an element at an index is not supported by foreign-collections, use update");
    }

    @Override // java.util.Collection, java.util.List
    public final int size() {
        return this.results.size();
    }

    @Override // java.util.List
    public final List<T> subList(int r2, int r3) {
        return this.results.subList(r2, r3);
    }

    @Override // java.util.Collection, java.util.List
    public final Object[] toArray() {
        return this.results.toArray();
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int r2) {
        return this.results.listIterator(r2);
    }

    @Override // java.util.Collection, java.util.List
    public final <E> E[] toArray(E[] eArr) {
        return (E[]) this.results.toArray(eArr);
    }

    @Override // java.util.List
    public final void add(int r1, T t) {
        throw new UnsupportedOperationException("adding an element at an index is not supported by foreign-collections");
    }

    @Override // java.util.List
    public final boolean addAll(int r1, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("addAll() at an index is not supported by foreign-collections, use addAll()");
    }

    @Override // java.util.List
    public final T remove(int r2) {
        T t = this.results.get(0);
        remove(t);
        return t;
    }

    /* renamed from: com.j256.ormlite.dao.EagerForeignCollection$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements CloseableIterator<Object> {
        public int offset = -1;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.offset + 1 < EagerForeignCollection.this.results.size()) {
                return true;
            }
            return false;
        }

        @Override // com.j256.ormlite.dao.CloseableIterator
        public final void moveToNext() {
            this.offset++;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.offset + 1;
            this.offset = r0;
            return EagerForeignCollection.this.results.get(r0);
        }

        @Override // java.util.Iterator
        public final void remove() {
            int r0 = this.offset;
            if (r0 >= 0) {
                EagerForeignCollection eagerForeignCollection = EagerForeignCollection.this;
                if (r0 < eagerForeignCollection.results.size()) {
                    T remove = eagerForeignCollection.results.remove(this.offset);
                    this.offset--;
                    Dao<T, ID> dao = eagerForeignCollection.dao;
                    if (dao != null) {
                        try {
                            dao.delete((Dao<T, ID>) remove);
                            return;
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return;
                }
                throw new IllegalStateException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("current results position ("), this.offset, ") is out of bounds"));
            }
            throw new IllegalStateException("next() must be called before remove()");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
