package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class DropSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    public final Iterator<T> iterator;
    public int left;

    public DropSequence$iterator$1(DropSequence<T> dropSequence) {
        this.iterator = dropSequence.sequence.iterator();
        this.left = dropSequence.count;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator<T> it;
        while (true) {
            int r0 = this.left;
            it = this.iterator;
            if (r0 <= 0 || !it.hasNext()) {
                break;
            }
            it.next();
            this.left--;
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        Iterator<T> it;
        while (true) {
            int r0 = this.left;
            it = this.iterator;
            if (r0 <= 0 || !it.hasNext()) {
                break;
            }
            it.next();
            this.left--;
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
