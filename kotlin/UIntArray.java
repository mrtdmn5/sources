package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: UIntArray.kt */
/* loaded from: classes.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    public final int[] storage;

    /* compiled from: UIntArray.kt */
    /* loaded from: classes.dex */
    public static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {
        public final int[] array;
        public int index;

        public Iterator(int[] array) {
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
        public final UInt next() {
            int r0 = this.index;
            int[] r1 = this.array;
            if (r0 < r1.length) {
                this.index = r0 + 1;
                return new UInt(r1[r0]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        int r6 = ((UInt) obj).data;
        int[] r2 = this.storage;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int length = r2.length;
        int r3 = 0;
        while (true) {
            if (r3 < length) {
                if (r6 == r2[r3]) {
                    break;
                }
                r3++;
            } else {
                r3 = -1;
                break;
            }
        }
        if (r3 < 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:4:0x0016->B:24:?, LOOP_END, SYNTHETIC] */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsAll(java.util.Collection<? extends java.lang.Object> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r0 = r8
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 == 0) goto L12
            goto L4a
        L12:
            java.util.Iterator r8 = r8.iterator()
        L16:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L4a
            java.lang.Object r0 = r8.next()
            boolean r2 = r0 instanceof kotlin.UInt
            r3 = 0
            if (r2 == 0) goto L46
            kotlin.UInt r0 = (kotlin.UInt) r0
            int r0 = r0.data
            java.lang.String r2 = "<this>"
            int[] r4 = r7.storage
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            int r2 = r4.length
            r5 = r3
        L32:
            if (r5 >= r2) goto L3c
            r6 = r4[r5]
            if (r0 != r6) goto L39
            goto L3d
        L39:
            int r5 = r5 + 1
            goto L32
        L3c:
            r5 = -1
        L3d:
            if (r5 < 0) goto L41
            r0 = r1
            goto L42
        L41:
            r0 = r3
        L42:
            if (r0 == 0) goto L46
            r0 = r1
            goto L47
        L46:
            r0 = r3
        L47:
            if (r0 != 0) goto L16
            r1 = r3
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UIntArray.containsAll(java.util.Collection):boolean");
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (!(obj instanceof UIntArray)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.storage, ((UIntArray) obj).storage)) {
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
    public final java.util.Iterator<UInt> iterator() {
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
        return "UIntArray(storage=" + Arrays.toString(this.storage) + ')';
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
