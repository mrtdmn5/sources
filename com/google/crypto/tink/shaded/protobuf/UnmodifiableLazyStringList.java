package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    public final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r2) {
        return (String) this.list.get(r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final Object getRaw(int r2) {
        return this.list.getRaw(r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new Iterator<String>(this) { // from class: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList.2
            public final Iterator<String> iter;

            {
                this.iter = this.list.iterator();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public final String next() {
                return this.iter.next();
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int r2) {
        return new ListIterator<String>(this, r2) { // from class: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList.1
            public final ListIterator<String> iter;

            {
                this.iter = this.list.listIterator(r2);
            }

            @Override // java.util.ListIterator
            public final void add(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.ListIterator
            public final boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final Object next() {
                return this.iter.next();
            }

            @Override // java.util.ListIterator
            public final int nextIndex() {
                return this.iter.nextIndex();
            }

            @Override // java.util.ListIterator
            public final String previous() {
                return this.iter.previous();
            }

            @Override // java.util.ListIterator
            public final int previousIndex() {
                return this.iter.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public final void set(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.list.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final LazyStringList getUnmodifiableView() {
        return this;
    }
}
