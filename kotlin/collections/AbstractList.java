package kotlin.collections;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: AbstractList.kt */
/* loaded from: classes.dex */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    /* compiled from: AbstractList.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static void checkBoundsIndexes$kotlin_stdlib(int r4, int r5, int r6) {
            if (r4 >= 0 && r5 <= r6) {
                if (r4 <= r5) {
                } else {
                    throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("startIndex: ", r4, " > endIndex: ", r5));
                }
            } else {
                StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("startIndex: ", r4, ", endIndex: ", r5, ", size: ");
                m.append(r6);
                throw new IndexOutOfBoundsException(m.toString());
            }
        }

        public static void checkRangeIndexes$kotlin_stdlib(int r4, int r5, int r6) {
            if (r4 >= 0 && r5 <= r6) {
                if (r4 <= r5) {
                } else {
                    throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("fromIndex: ", r4, " > toIndex: ", r5));
                }
            } else {
                StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("fromIndex: ", r4, ", toIndex: ", r5, ", size: ");
                m.append(r6);
                throw new IndexOutOfBoundsException(m.toString());
            }
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes.dex */
    public class IteratorImpl implements Iterator<E>, KMappedMarker {
        public int index;

        public IteratorImpl() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.index < AbstractList.this.getSize()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final E next() {
            if (hasNext()) {
                int r0 = this.index;
                this.index = r0 + 1;
                return AbstractList.this.get(r0);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes.dex */
    public class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E> {
        public ListIteratorImpl(int r5) {
            super();
            int size = AbstractList.this.getSize();
            if (r5 >= 0 && r5 <= size) {
                this.index = r5;
                return;
            }
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", size));
        }

        @Override // java.util.ListIterator
        public final void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.index > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            if (hasPrevious()) {
                int r0 = this.index - 1;
                this.index = r0;
                return AbstractList.this.get(r0);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public final void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes.dex */
    public static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        public final int _size;
        public final int fromIndex;
        public final AbstractList<E> list;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(AbstractList<? extends E> list, int r3, int r4) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.fromIndex = r3;
            Companion.checkRangeIndexes$kotlin_stdlib(r3, r4, list.getSize());
            this._size = r4 - r3;
        }

        @Override // java.util.List
        public final E get(int r5) {
            int r0 = this._size;
            if (r5 >= 0 && r5 < r0) {
                return this.list.get(this.fromIndex + r5);
            }
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", r0));
        }

        @Override // kotlin.collections.AbstractCollection
        public final int getSize() {
            return this._size;
        }
    }

    @Override // java.util.List
    public final void add(int r1, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r1, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection other = (Collection) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        if (size() == other.size()) {
            Iterator<E> it = other.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int r2;
        int r1 = 1;
        for (E e : this) {
            int r12 = r1 * 31;
            if (e != null) {
                r2 = e.hashCode();
            } else {
                r2 = 0;
            }
            r1 = r12 + r2;
        }
        return r1;
    }

    public int indexOf(E e) {
        Iterator<E> it = iterator();
        int r1 = 0;
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(it.next(), e)) {
                r1++;
            } else {
                return r1;
            }
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    public int lastIndexOf(E e) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), e)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override // java.util.List
    public final E remove(int r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final E set(int r1, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int r2, int r3) {
        return new SubList(this, r2, r3);
    }

    public ListIterator<E> listIterator(int r2) {
        return new ListIteratorImpl(r2);
    }
}
