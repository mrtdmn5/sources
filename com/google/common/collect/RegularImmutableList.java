package com.google.common.collect;

import okhttp3.internal._HostnamesJvmKt;

/* loaded from: classes3.dex */
public final class RegularImmutableList<E> extends ImmutableList<E> {
    public static final RegularImmutableList EMPTY = new RegularImmutableList(0, new Object[0]);
    public final transient Object[] array;
    public final transient int size;

    public RegularImmutableList(int r1, Object[] objArr) {
        this.array = objArr;
        this.size = r1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final void copyIntoArray(Object[] objArr) {
        System.arraycopy(this.array, 0, objArr, 0, this.size);
    }

    @Override // java.util.List
    public final E get(int r2) {
        _HostnamesJvmKt.checkElementIndex(r2, this.size);
        return (E) this.array[r2];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayStart() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }
}
