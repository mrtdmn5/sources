package com.google.common.collect;

import com.animaconnected.firebase.AnalyticsConstants;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import okhttp3.internal._HostnamesJvmKt;

/* loaded from: classes3.dex */
public abstract class AbstractIndexedListIterator<E> extends UnmodifiableIterator<Object> implements ListIterator<Object> {
    public int position;
    public final int size;

    public AbstractIndexedListIterator(int r3, int r4) {
        if (r4 >= 0 && r4 <= r3) {
            this.size = r3;
            this.position = r4;
            return;
        }
        throw new IndexOutOfBoundsException(_HostnamesJvmKt.badPositionIndex(r4, r3, AnalyticsConstants.KEY_INDEX));
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        add$com$google$common$collect$UnmodifiableListIterator(obj);
        throw null;
    }

    @Deprecated
    public final void add$com$google$common$collect$UnmodifiableListIterator(Object obj) {
        throw new UnsupportedOperationException();
    }

    public abstract E get(int r1);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.position < this.size) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.position > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int r0 = this.position;
            this.position = r0 + 1;
            return get(r0);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.position;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int r0 = this.position - 1;
            this.position = r0;
            return get(r0);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.position - 1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        set$com$google$common$collect$UnmodifiableListIterator(obj);
        throw null;
    }

    @Deprecated
    public final void set$com$google$common$collect$UnmodifiableListIterator(Object obj) {
        throw new UnsupportedOperationException();
    }
}
