package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;

/* compiled from: AbstractListIterator.kt */
/* loaded from: classes.dex */
public final class SingleElementListIterator<E> extends AbstractListIterator<E> {
    public final E element;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleElementListIterator(int r2, Object obj) {
        super(r2, 1);
        this.element = obj;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final E next() {
        if (hasNext()) {
            this.index++;
            return this.element;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            this.index--;
            return this.element;
        }
        throw new NoSuchElementException();
    }
}
