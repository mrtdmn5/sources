package com.google.common.collect;

import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final class RegularImmutableSet<E> extends ImmutableSet<E> {
    public static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet<>(0, 0, 0, new Object[0], null);
    public final transient Object[] elements;
    public final transient int hashCode;
    public final transient int mask;
    public final transient int size;
    public final transient Object[] table;

    public RegularImmutableSet(int r1, int r2, int r3, Object[] objArr, Object[] objArr2) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = r2;
        this.hashCode = r1;
        this.size = r3;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        Object[] objArr;
        if (obj == null || (objArr = this.table) == null) {
            return false;
        }
        int smear = Hashing.smear(obj.hashCode());
        while (true) {
            int r2 = smear & this.mask;
            Object obj2 = objArr[r2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            smear = r2 + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final void copyIntoArray(Object[] objArr) {
        System.arraycopy(this.elements, 0, objArr, 0, this.size);
    }

    public final RegularImmutableList createAsList() {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        int r0 = this.size;
        if (r0 == 0) {
            return RegularImmutableList.EMPTY;
        }
        return new RegularImmutableList(r0, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] internalArray() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayStart() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator<E> iterator() {
        RegularImmutableList regularImmutableList = this.asList;
        if (regularImmutableList == null) {
            regularImmutableList = createAsList();
            this.asList = regularImmutableList;
        }
        return regularImmutableList.listIterator(0);
    }
}
