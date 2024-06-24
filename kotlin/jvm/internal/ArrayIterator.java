package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes.dex */
public final class ArrayIterator<T> implements Iterator<T>, KMappedMarker {
    public final T[] array;
    public int index;

    public ArrayIterator(T[] array) {
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
    public final T next() {
        try {
            T[] tArr = this.array;
            int r1 = this.index;
            this.index = r1 + 1;
            return tArr[r1];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
