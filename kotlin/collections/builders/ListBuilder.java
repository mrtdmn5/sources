package kotlin.collections.builders;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt__ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ListBuilder.kt */
/* loaded from: classes.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
    public static final ListBuilder Empty;
    public E[] array;
    public final ListBuilder<E> backing;
    public boolean isReadOnly;
    public int length;
    public final int offset;
    public final ListBuilder<E> root;

    /* compiled from: ListBuilder.kt */
    /* loaded from: classes.dex */
    public static final class Itr<E> implements ListIterator<E>, KMappedMarker {
        public int expectedModCount;
        public int index;
        public int lastIndex;
        public final ListBuilder<E> list;

        public Itr(ListBuilder<E> list, int r3) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = r3;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) list).modCount;
        }

        @Override // java.util.ListIterator
        public final void add(E e) {
            checkForComodification();
            int r0 = this.index;
            this.index = r0 + 1;
            ListBuilder<E> listBuilder = this.list;
            listBuilder.add(r0, e);
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) listBuilder).modCount;
        }

        public final void checkForComodification() {
            if (((AbstractList) this.list).modCount == this.expectedModCount) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            if (this.index < this.list.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.index > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final E next() {
            checkForComodification();
            int r0 = this.index;
            ListBuilder<E> listBuilder = this.list;
            if (r0 < listBuilder.length) {
                this.index = r0 + 1;
                this.lastIndex = r0;
                return listBuilder.array[listBuilder.offset + r0];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            checkForComodification();
            int r0 = this.index;
            if (r0 > 0) {
                int r02 = r0 - 1;
                this.index = r02;
                this.lastIndex = r02;
                ListBuilder<E> listBuilder = this.list;
                return listBuilder.array[listBuilder.offset + r02];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            boolean z;
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ListBuilder<E> listBuilder = this.list;
                listBuilder.removeAt(r0);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) listBuilder).modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public final void set(E e) {
            boolean z;
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.list.set(r0, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public ListBuilder(E[] eArr, int r2, int r3, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = r2;
        this.length = r3;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
        if (listBuilder != null) {
            ((AbstractList) this).modCount = ((AbstractList) listBuilder).modCount;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        int size = elements.size();
        addAllInternal(this.offset + this.length, size, elements);
        return size > 0;
    }

    public final void addAllInternal(int r5, int r6, Collection collection) {
        ((AbstractList) this).modCount++;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(r5, r6, collection);
            this.array = listBuilder.array;
            this.length += r6;
        } else {
            insertAtInternal(r5, r6);
            Iterator<E> it = collection.iterator();
            for (int r0 = 0; r0 < r6; r0++) {
                this.array[r5 + r0] = it.next();
            }
        }
    }

    public final void addAtInternal(int r3, E e) {
        ((AbstractList) this).modCount++;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(r3, e);
            this.array = listBuilder.array;
            this.length++;
        } else {
            insertAtInternal(r3, 1);
            this.array[r3] = e;
        }
    }

    public final void checkForComodification() {
        ListBuilder<E> listBuilder = this.root;
        if (listBuilder != null && ((AbstractList) listBuilder).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void checkIsMutable() {
        boolean z;
        ListBuilder<E> listBuilder;
        if (!this.isReadOnly && ((listBuilder = this.root) == null || !listBuilder.isReadOnly)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r7.checkForComodification()
            r0 = 1
            if (r8 == r7) goto L34
            boolean r1 = r8 instanceof java.util.List
            r2 = 0
            if (r1 == 0) goto L33
            java.util.List r8 = (java.util.List) r8
            E[] r1 = r7.array
            int r3 = r7.length
            int r4 = r8.size()
            if (r3 == r4) goto L18
            goto L2a
        L18:
            r4 = r2
        L19:
            if (r4 >= r3) goto L2f
            int r5 = r7.offset
            int r5 = r5 + r4
            r5 = r1[r5]
            java.lang.Object r6 = r8.get(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 != 0) goto L2c
        L2a:
            r8 = r2
            goto L30
        L2c:
            int r4 = r4 + 1
            goto L19
        L2f:
            r8 = r0
        L30:
            if (r8 == 0) goto L33
            goto L34
        L33:
            r0 = r2
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.ListBuilder.equals(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int r5) {
        checkForComodification();
        int r0 = this.length;
        if (r5 >= 0 && r5 < r0) {
            return this.array[this.offset + r5];
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", r0));
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        checkForComodification();
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r5;
        checkForComodification();
        E[] eArr = this.array;
        int r1 = this.length;
        int r2 = 1;
        for (int r4 = 0; r4 < r1; r4++) {
            E e = eArr[this.offset + r4];
            int r22 = r2 * 31;
            if (e != null) {
                r5 = e.hashCode();
            } else {
                r5 = 0;
            }
            r2 = r22 + r5;
        }
        return r2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        checkForComodification();
        for (int r0 = 0; r0 < this.length; r0++) {
            if (Intrinsics.areEqual(this.array[this.offset + r0], obj)) {
                return r0;
            }
        }
        return -1;
    }

    public final void insertAtInternal(int r6, int r7) {
        int r0 = this.length + r7;
        if (r0 >= 0) {
            E[] eArr = this.array;
            if (r0 > eArr.length) {
                int length = eArr.length;
                int r2 = length + (length >> 1);
                if (r2 - r0 < 0) {
                    r2 = r0;
                }
                if (r2 - 2147483639 > 0) {
                    if (r0 > 2147483639) {
                        r2 = Integer.MAX_VALUE;
                    } else {
                        r2 = 2147483639;
                    }
                }
                E[] eArr2 = (E[]) Arrays.copyOf(eArr, r2);
                Intrinsics.checkNotNullExpressionValue(eArr2, "copyOf(...)");
                this.array = eArr2;
            }
            E[] eArr3 = this.array;
            ArraysKt___ArraysJvmKt.copyInto(r6 + r7, r6, this.offset + this.length, eArr3, eArr3);
            this.length += r7;
            return;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        checkForComodification();
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        checkForComodification();
        for (int r0 = this.length - 1; r0 >= 0; r0--) {
            if (Intrinsics.areEqual(this.array[this.offset + r0], obj)) {
                return r0;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        checkIsMutable();
        checkForComodification();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final E removeAt(int r5) {
        checkIsMutable();
        checkForComodification();
        int r0 = this.length;
        if (r5 >= 0 && r5 < r0) {
            return removeAtInternal(this.offset + r5);
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", r0));
    }

    public final E removeAtInternal(int r6) {
        ((AbstractList) this).modCount++;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(r6);
        }
        E[] eArr = this.array;
        E e = eArr[r6];
        int r3 = this.length;
        int r4 = this.offset;
        ArraysKt___ArraysJvmKt.copyInto(r6, r6 + 1, r3 + r4, eArr, eArr);
        E[] eArr2 = this.array;
        int r42 = (r4 + this.length) - 1;
        Intrinsics.checkNotNullParameter(eArr2, "<this>");
        eArr2[r42] = null;
        this.length--;
        return e;
    }

    public final void removeRangeInternal(int r4, int r5) {
        if (r5 > 0) {
            ((AbstractList) this).modCount++;
        }
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(r4, r5);
        } else {
            E[] eArr = this.array;
            ArraysKt___ArraysJvmKt.copyInto(r4, r4 + r5, this.length, eArr, eArr);
            E[] eArr2 = this.array;
            int r0 = this.length;
            ListBuilderKt.resetRange(r0 - r5, r0, eArr2);
        }
        this.length -= r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0) {
            return true;
        }
        return false;
    }

    public final int retainOrRemoveAllInternal(int r6, int r7, Collection<? extends E> collection, boolean z) {
        int r62;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            r62 = listBuilder.retainOrRemoveAllInternal(r6, r7, collection, z);
        } else {
            int r0 = 0;
            int r1 = 0;
            while (r0 < r7) {
                int r3 = r6 + r0;
                if (collection.contains(this.array[r3]) == z) {
                    E[] eArr = this.array;
                    r0++;
                    eArr[r1 + r6] = eArr[r3];
                    r1++;
                } else {
                    r0++;
                }
            }
            int r8 = r7 - r1;
            E[] eArr2 = this.array;
            ArraysKt___ArraysJvmKt.copyInto(r6 + r1, r7 + r6, this.length, eArr2, eArr2);
            E[] eArr3 = this.array;
            int r72 = this.length;
            ListBuilderKt.resetRange(r72 - r8, r72, eArr3);
            r62 = r8;
        }
        if (r62 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.length -= r62;
        return r62;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int r4, E e) {
        checkIsMutable();
        checkForComodification();
        int r0 = this.length;
        if (r4 >= 0 && r4 < r0) {
            E[] eArr = this.array;
            int r1 = this.offset;
            E e2 = eArr[r1 + r4];
            eArr[r1 + r4] = e;
            return e2;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r4, ", size: ", r0));
    }

    @Override // java.util.AbstractList, java.util.List
    public final List<E> subList(int r9, int r10) {
        ListBuilder<E> listBuilder;
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r9, r10, this.length);
        E[] eArr = this.array;
        int r3 = this.offset + r9;
        int r4 = r10 - r9;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder2 = this.root;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(eArr, r3, r4, z, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkForComodification();
        int length = destination.length;
        int r1 = this.length;
        int r2 = this.offset;
        if (length < r1) {
            T[] tArr = (T[]) Arrays.copyOfRange(this.array, r2, r1 + r2, destination.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(...)");
            return tArr;
        }
        ArraysKt___ArraysJvmKt.copyInto(0, r2, r1 + r2, this.array, destination);
        int r0 = this.length;
        if (r0 < destination.length) {
            destination[r0] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        checkForComodification();
        E[] eArr = this.array;
        int r1 = this.length;
        StringBuilder sb = new StringBuilder((r1 * 3) + 2);
        sb.append("[");
        for (int r3 = 0; r3 < r1; r3++) {
            if (r3 > 0) {
                sb.append(", ");
            }
            E e = eArr[this.offset + r3];
            if (e == this) {
                sb.append("(this Collection)");
            } else {
                sb.append(e);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int r5) {
        checkForComodification();
        int r0 = this.length;
        if (r5 >= 0 && r5 <= r0) {
            return new Itr(this, r5);
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", r0));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r4, E e) {
        checkIsMutable();
        checkForComodification();
        int r0 = this.length;
        if (r4 >= 0 && r4 <= r0) {
            addAtInternal(this.offset + r4, e);
            return;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r4, ", size: ", r0));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r4, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        int r0 = this.length;
        if (r4 >= 0 && r4 <= r0) {
            int size = elements.size();
            addAllInternal(this.offset + r4, size, elements);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r4, ", size: ", r0));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        checkForComodification();
        E[] eArr = this.array;
        int r1 = this.length;
        int r2 = this.offset;
        int r12 = r1 + r2;
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        ArraysKt__ArraysKt.copyOfRangeToIndexCheck(r12, eArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(eArr, r2, r12);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int r8) {
        this(ListBuilderKt.arrayOfUninitializedElements(r8), 0, 0, false, null, null);
    }
}
