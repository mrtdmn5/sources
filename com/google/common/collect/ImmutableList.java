package com.google.common.collect;

import com.animaconnected.firebase.AnalyticsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import okhttp3.internal._HostnamesJvmKt;

/* loaded from: classes3.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    public static final Itr EMPTY_ITR = new Itr(RegularImmutableList.EMPTY, 0);

    /* loaded from: classes3.dex */
    public static class Itr<E> extends AbstractIndexedListIterator<E> {
        public final ImmutableList<E> list;

        public Itr(ImmutableList<E> immutableList, int r3) {
            super(immutableList.size(), r3);
            this.list = immutableList;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public final E get(int r2) {
            return this.list.get(r2);
        }
    }

    /* loaded from: classes3.dex */
    public class SubList extends ImmutableList<E> {
        public final transient int length;
        public final transient int offset;

        public SubList(int r2, int r3) {
            this.offset = r2;
            this.length = r3;
        }

        @Override // java.util.List
        public final E get(int r2) {
            _HostnamesJvmKt.checkElementIndex(r2, this.length);
            return ImmutableList.this.get(r2 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
            return listIterator(r1);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ImmutableList<E> subList(int r2, int r3) {
            _HostnamesJvmKt.checkPositionIndexes(r2, r3, this.length);
            int r0 = this.offset;
            return ImmutableList.this.subList(r2 + r0, r3 + r0);
        }
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int r1, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int r1, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public void copyIntoArray(Object[] objArr) {
        int size = size();
        for (int r2 = 0; r2 < size; r2++) {
            objArr[0 + r2] = get(r2);
        }
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int r3 = 0; r3 < size; r3++) {
                        E e = get(r3);
                        Object obj2 = list.get(r3);
                        if (e != obj2 && (e == null || !e.equals(obj2))) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = list.iterator();
                for (E e2 : this) {
                    if (it.hasNext()) {
                        E next = it.next();
                        if (e2 != next && (e2 == null || !e2.equals(next))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                        }
                    }
                }
                return true ^ it.hasNext();
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int r1 = 1;
        for (int r2 = 0; r2 < size; r2++) {
            r1 = ~(~(get(r2).hashCode() + (r1 * 31)));
        }
        return r1;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int r2 = 0; r2 < size; r2++) {
            if (obj.equals(get(r2))) {
                return r2;
            }
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int r1, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int r2, int r3) {
        _HostnamesJvmKt.checkPositionIndexes(r2, r3, size());
        int r32 = r3 - r2;
        if (r32 == size()) {
            return this;
        }
        if (r32 == 0) {
            return RegularImmutableList.EMPTY;
        }
        return new SubList(r2, r32);
    }

    @Override // java.util.List
    public final Itr listIterator(int r4) {
        int size = size();
        if (r4 >= 0 && r4 <= size) {
            if (isEmpty()) {
                return EMPTY_ITR;
            }
            return new Itr(this, r4);
        }
        throw new IndexOutOfBoundsException(_HostnamesJvmKt.badPositionIndex(r4, size, AnalyticsConstants.KEY_INDEX));
    }
}
