package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class FilteringSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    public final Iterator<T> iterator;
    public T nextItem;
    public int nextState = -1;
    public final /* synthetic */ FilteringSequence<T> this$0;

    public FilteringSequence$iterator$1(FilteringSequence<T> filteringSequence) {
        this.this$0 = filteringSequence;
        this.iterator = filteringSequence.sequence.iterator();
    }

    public final void calcNext() {
        T next;
        FilteringSequence<T> filteringSequence;
        do {
            Iterator<T> it = this.iterator;
            if (it.hasNext()) {
                next = it.next();
                filteringSequence = this.this$0;
            } else {
                this.nextState = 0;
                return;
            }
        } while (filteringSequence.predicate.invoke(next).booleanValue() != filteringSequence.sendWhen);
        this.nextItem = next;
        this.nextState = 1;
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
