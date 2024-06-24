package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ULongArray.kt */
/* loaded from: classes.dex */
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    public final long[] storage;

    /* compiled from: ULongArray.kt */
    /* loaded from: classes.dex */
    public static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {
        public final long[] array;
        public int index;

        public Iterator(long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.index < this.array.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final ULong next() {
            int r0 = this.index;
            long[] jArr = this.array;
            if (r0 < jArr.length) {
                this.index = r0 + 1;
                return new ULong(jArr[r0]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        long j = ((ULong) obj).data;
        long[] jArr = this.storage;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        int r4 = 0;
        while (true) {
            if (r4 < length) {
                if (j == jArr[r4]) {
                    break;
                }
                r4++;
            } else {
                r4 = -1;
                break;
            }
        }
        if (r4 < 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:4:0x0016->B:24:?, LOOP_END, SYNTHETIC] */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsAll(java.util.Collection<? extends java.lang.Object> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            r0 = r10
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 == 0) goto L12
            goto L4c
        L12:
            java.util.Iterator r10 = r10.iterator()
        L16:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r10.next()
            boolean r2 = r0 instanceof kotlin.ULong
            r3 = 0
            if (r2 == 0) goto L48
            kotlin.ULong r0 = (kotlin.ULong) r0
            long r4 = r0.data
            java.lang.String r0 = "<this>"
            long[] r2 = r9.storage
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            int r0 = r2.length
            r6 = r3
        L32:
            if (r6 >= r0) goto L3e
            r7 = r2[r6]
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 != 0) goto L3b
            goto L3f
        L3b:
            int r6 = r6 + 1
            goto L32
        L3e:
            r6 = -1
        L3f:
            if (r6 < 0) goto L43
            r0 = r1
            goto L44
        L43:
            r0 = r3
        L44:
            if (r0 == 0) goto L48
            r0 = r1
            goto L49
        L48:
            r0 = r3
        L49:
            if (r0 != 0) goto L16
            r1 = r3
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ULongArray.containsAll(java.util.Collection):boolean");
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (!(obj instanceof ULongArray)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.storage, ((ULongArray) obj).storage)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.storage);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        if (this.storage.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator<ULong> iterator() {
        return new Iterator(this.storage);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.storage.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final String toString() {
        return "ULongArray(storage=" + Arrays.toString(this.storage) + ')';
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
