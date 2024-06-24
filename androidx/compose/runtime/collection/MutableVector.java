package androidx.compose.runtime.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: MutableVector.kt */
/* loaded from: classes.dex */
public final class MutableVector<T> implements RandomAccess {
    public T[] content;
    public MutableVectorList list;
    public int size = 0;

    /* compiled from: MutableVector.kt */
    /* loaded from: classes.dex */
    public static final class MutableVectorList<T> implements List<T>, KMutableList {
        public final MutableVector<T> vector;

        public MutableVectorList(MutableVector<T> vector) {
            Intrinsics.checkNotNullParameter(vector, "vector");
            this.vector = vector;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(T t) {
            this.vector.add(t);
            return true;
        }

        @Override // java.util.List
        public final boolean addAll(int r2, Collection<? extends T> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.vector.addAll(r2, elements);
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            this.vector.clear();
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            return this.vector.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            MutableVector<T> mutableVector = this.vector;
            mutableVector.getClass();
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!mutableVector.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public final T get(int r2) {
            MutableVectorKt.access$checkIndex(r2, this);
            return this.vector.content[r2];
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            MutableVector<T> mutableVector = this.vector;
            int r1 = mutableVector.size;
            if (r1 > 0) {
                T[] tArr = mutableVector.content;
                int r2 = 0;
                while (!Intrinsics.areEqual(obj, tArr[r2])) {
                    r2++;
                    if (r2 >= r1) {
                    }
                }
                return r2;
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.vector.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            MutableVector<T> mutableVector = this.vector;
            int r1 = mutableVector.size;
            if (r1 <= 0) {
                return -1;
            }
            int r12 = r1 - 1;
            T[] tArr = mutableVector.content;
            while (!Intrinsics.areEqual(obj, tArr[r12])) {
                r12--;
                if (r12 < 0) {
                    return -1;
                }
            }
            return r12;
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            return this.vector.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            MutableVector<T> mutableVector = this.vector;
            mutableVector.getClass();
            if (elements.isEmpty()) {
                return false;
            }
            int r1 = mutableVector.size;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                mutableVector.remove(it.next());
            }
            if (r1 == mutableVector.size) {
                return false;
            }
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            MutableVector<T> mutableVector = this.vector;
            mutableVector.getClass();
            int r1 = mutableVector.size;
            for (int r2 = r1 - 1; -1 < r2; r2--) {
                if (!elements.contains(mutableVector.content[r2])) {
                    mutableVector.removeAt(r2);
                }
            }
            if (r1 != mutableVector.size) {
                return true;
            }
            return false;
        }

        @Override // java.util.List
        public final T set(int r3, T t) {
            MutableVectorKt.access$checkIndex(r3, this);
            T[] tArr = this.vector.content;
            T t2 = tArr[r3];
            tArr[r3] = t;
            return t2;
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.vector.size;
        }

        @Override // java.util.List
        public final List<T> subList(int r2, int r3) {
            MutableVectorKt.access$checkSubIndex(r2, this, r3);
            return new SubList(r2, this, r3);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List
        public final void add(int r2, T t) {
            this.vector.add(r2, t);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends T> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            MutableVector<T> mutableVector = this.vector;
            mutableVector.getClass();
            return mutableVector.addAll(mutableVector.size, elements);
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator(int r2) {
            return new VectorListIterator(this, r2);
        }

        @Override // java.util.List
        public final T remove(int r2) {
            MutableVectorKt.access$checkIndex(r2, this);
            return this.vector.removeAt(r2);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return (T[]) CollectionToArray.toArray(this, array);
        }
    }

    /* compiled from: MutableVector.kt */
    /* loaded from: classes.dex */
    public static final class SubList<T> implements List<T>, KMutableList {
        public int end;
        public final List<T> list;
        public final int start;

        public SubList(int r2, List list, int r4) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.start = r2;
            this.end = r4;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(T t) {
            int r0 = this.end;
            this.end = r0 + 1;
            this.list.add(r0, t);
            return true;
        }

        @Override // java.util.List
        public final boolean addAll(int r2, Collection<? extends T> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.list.addAll(r2 + this.start, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            int r0 = this.end - 1;
            int r1 = this.start;
            if (r1 <= r0) {
                while (true) {
                    this.list.remove(r0);
                    if (r0 == r1) {
                        break;
                    } else {
                        r0--;
                    }
                }
            }
            this.end = r1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            int r0 = this.end;
            for (int r1 = this.start; r1 < r0; r1++) {
                if (Intrinsics.areEqual(this.list.get(r1), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public final T get(int r2) {
            MutableVectorKt.access$checkIndex(r2, this);
            return this.list.get(r2 + this.start);
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            int r0 = this.end;
            int r1 = this.start;
            for (int r2 = r1; r2 < r0; r2++) {
                if (Intrinsics.areEqual(this.list.get(r2), obj)) {
                    return r2 - r1;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            if (this.end == this.start) {
                return true;
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            int r0 = this.end - 1;
            int r1 = this.start;
            if (r1 <= r0) {
                while (!Intrinsics.areEqual(this.list.get(r0), obj)) {
                    if (r0 != r1) {
                        r0--;
                    } else {
                        return -1;
                    }
                }
                return r0 - r1;
            }
            return -1;
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            int r0 = this.end;
            for (int r1 = this.start; r1 < r0; r1++) {
                List<T> list = this.list;
                if (Intrinsics.areEqual(list.get(r1), obj)) {
                    list.remove(r1);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int r0 = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            if (r0 != this.end) {
                return true;
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int r0 = this.end;
            int r1 = r0 - 1;
            int r2 = this.start;
            if (r2 <= r1) {
                while (true) {
                    List<T> list = this.list;
                    if (!elements.contains(list.get(r1))) {
                        list.remove(r1);
                        this.end--;
                    }
                    if (r1 == r2) {
                        break;
                    }
                    r1--;
                }
            }
            if (r0 != this.end) {
                return true;
            }
            return false;
        }

        @Override // java.util.List
        public final T set(int r2, T t) {
            MutableVectorKt.access$checkIndex(r2, this);
            return this.list.set(r2 + this.start, t);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public final List<T> subList(int r2, int r3) {
            MutableVectorKt.access$checkSubIndex(r2, this, r3);
            return new SubList(r2, this, r3);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List
        public final void add(int r2, T t) {
            this.list.add(r2 + this.start, t);
            this.end++;
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator(int r2) {
            return new VectorListIterator(this, r2);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return (T[]) CollectionToArray.toArray(this, array);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends T> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }

        @Override // java.util.List
        public final T remove(int r2) {
            MutableVectorKt.access$checkIndex(r2, this);
            this.end--;
            return this.list.remove(r2 + this.start);
        }
    }

    /* compiled from: MutableVector.kt */
    /* loaded from: classes.dex */
    public static final class VectorListIterator<T> implements ListIterator<T>, KMappedMarker {
        public int index;
        public final List<T> list;

        public VectorListIterator(List<T> list, int r3) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = r3;
        }

        @Override // java.util.ListIterator
        public final void add(T t) {
            this.list.add(this.index, t);
            this.index++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            if (this.index < this.list.size()) {
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
        public final T next() {
            int r0 = this.index;
            this.index = r0 + 1;
            return this.list.get(r0);
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final T previous() {
            int r0 = this.index - 1;
            this.index = r0;
            return this.list.get(r0);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            int r0 = this.index - 1;
            this.index = r0;
            this.list.remove(r0);
        }

        @Override // java.util.ListIterator
        public final void set(T t) {
            this.list.set(this.index, t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutableVector(Object[] objArr) {
        this.content = objArr;
    }

    public final void add(Object obj) {
        ensureCapacity(this.size + 1);
        Object[] objArr = (T[]) this.content;
        int r1 = this.size;
        objArr[r1] = obj;
        this.size = r1 + 1;
    }

    public final void addAll(int r5, MutableVector elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this.size + elements.size);
        T[] tArr = this.content;
        int r1 = this.size;
        if (r5 != r1) {
            ArraysKt___ArraysJvmKt.copyInto(elements.size + r5, r5, r1, tArr, tArr);
        }
        ArraysKt___ArraysJvmKt.copyInto(r5, 0, elements.size, elements.content, tArr);
        this.size += elements.size;
    }

    public final List<T> asMutableList() {
        MutableVectorList mutableVectorList = this.list;
        if (mutableVectorList == null) {
            MutableVectorList mutableVectorList2 = new MutableVectorList(this);
            this.list = mutableVectorList2;
            return mutableVectorList2;
        }
        return mutableVectorList;
    }

    public final void clear() {
        T[] tArr = this.content;
        int r1 = this.size;
        while (true) {
            r1--;
            if (-1 < r1) {
                tArr[r1] = null;
            } else {
                this.size = 0;
                return;
            }
        }
    }

    public final boolean contains(T t) {
        int r0 = this.size - 1;
        if (r0 >= 0) {
            for (int r3 = 0; !Intrinsics.areEqual(this.content[r3], t); r3++) {
                if (r3 != r0) {
                }
            }
            return true;
        }
        return false;
    }

    public final void ensureCapacity(int r3) {
        T[] tArr = this.content;
        if (tArr.length < r3) {
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, Math.max(r3, tArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(this, newSize)");
            this.content = tArr2;
        }
    }

    public final boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this.size != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(T r6) {
        /*
            r5 = this;
            int r0 = r5.size
            r1 = 0
            if (r0 <= 0) goto L15
            T[] r2 = r5.content
            r3 = r1
        L8:
            r4 = r2[r3]
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r4)
            if (r4 == 0) goto L11
            goto L16
        L11:
            int r3 = r3 + 1
            if (r3 < r0) goto L8
        L15:
            r3 = -1
        L16:
            if (r3 < 0) goto L1d
            r5.removeAt(r3)
            r6 = 1
            return r6
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.remove(java.lang.Object):boolean");
    }

    public final T removeAt(int r5) {
        T[] tArr = this.content;
        T t = tArr[r5];
        int r2 = this.size;
        if (r5 != r2 - 1) {
            ArraysKt___ArraysJvmKt.copyInto(r5, r5 + 1, r2, tArr, tArr);
        }
        int r52 = this.size - 1;
        this.size = r52;
        tArr[r52] = null;
        return t;
    }

    public final void removeRange(int r4, int r5) {
        if (r5 > r4) {
            int r0 = this.size;
            if (r5 < r0) {
                T[] tArr = this.content;
                ArraysKt___ArraysJvmKt.copyInto(r4, r5, r0, tArr, tArr);
            }
            int r02 = this.size;
            int r42 = r02 - (r5 - r4);
            int r03 = r02 - 1;
            if (r42 <= r03) {
                int r52 = r42;
                while (true) {
                    this.content[r52] = null;
                    if (r52 == r03) {
                        break;
                    } else {
                        r52++;
                    }
                }
            }
            this.size = r42;
        }
    }

    public final void add(int r4, T t) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int r1 = this.size;
        if (r4 != r1) {
            ArraysKt___ArraysJvmKt.copyInto(r4 + 1, r4, r1, tArr, tArr);
        }
        tArr[r4] = t;
        this.size++;
    }

    public final boolean addAll(int r6, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int r1 = 0;
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(elements.size() + this.size);
        T[] tArr = this.content;
        if (r6 != this.size) {
            ArraysKt___ArraysJvmKt.copyInto(elements.size() + r6, r6, this.size, tArr, tArr);
        }
        for (T t : elements) {
            int r4 = r1 + 1;
            if (r1 >= 0) {
                tArr[r1 + r6] = t;
                r1 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        this.size = elements.size() + this.size;
        return true;
    }
}
