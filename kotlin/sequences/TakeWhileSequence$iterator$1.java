package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class TakeWhileSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    public final Iterator<T> iterator;
    public T nextItem;
    public int nextState = -1;
    public final /* synthetic */ TakeWhileSequence<T> this$0;

    public TakeWhileSequence$iterator$1(TakeWhileSequence<T> takeWhileSequence) {
        this.this$0 = takeWhileSequence;
        this.iterator = takeWhileSequence.sequence.iterator();
    }

    public final void calcNext() {
        Iterator<T> it = this.iterator;
        if (it.hasNext()) {
            T next = it.next();
            if (this.this$0.predicate.invoke(next).booleanValue()) {
                this.nextState = 1;
                this.nextItem = next;
                return;
            }
        }
        this.nextState = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState != 0) {
            T t = this.nextItem;
            this.nextItem = null;
            this.nextState = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
