package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    public transient int cachedHashCode;
    public final transient E element;

    public SingletonImmutableSet(E e) {
        e.getClass();
        this.element = e;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final void copyIntoArray(Object[] objArr) {
        objArr[0] = this.element;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int r0 = this.cachedHashCode;
        if (r0 == 0) {
            int hashCode = this.element.hashCode();
            this.cachedHashCode = hashCode;
            return hashCode;
        }
        return r0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public final boolean isHashCodeFast() {
        if (this.cachedHashCode != 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.element.toString() + ']';
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator<E> iterator() {
        final E e = this.element;
        return (UnmodifiableIterator<E>) new UnmodifiableIterator<Object>() { // from class: com.google.common.collect.Iterators$9
            public boolean done;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return !this.done;
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (!this.done) {
                    this.done = true;
                    return e;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingletonImmutableSet(int r1, Object obj) {
        this.element = obj;
        this.cachedHashCode = r1;
    }
}
