package kotlin.collections;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ReversedViews.kt */
/* loaded from: classes.dex */
public final class ReversedListReadOnly$listIterator$1<T> implements ListIterator<T>, KMappedMarker {
    public final ListIterator<T> delegateIterator;
    public final /* synthetic */ ReversedListReadOnly<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ReversedListReadOnly$listIterator$1(ReversedListReadOnly<? extends T> reversedListReadOnly, int r6) {
        this.this$0 = reversedListReadOnly;
        List<T> list = reversedListReadOnly.delegate;
        if (new IntRange(0, reversedListReadOnly.size()).contains(r6)) {
            this.delegateIterator = list.listIterator(reversedListReadOnly.size() - r6);
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Position index ", r6, " must be in range [");
        m.append(new IntRange(0, reversedListReadOnly.size()));
        m.append("].");
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // java.util.ListIterator
    public final void add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.delegateIterator.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.delegateIterator.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        return this.delegateIterator.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return CollectionsKt__CollectionsKt.getLastIndex(this.this$0) - this.delegateIterator.previousIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return this.delegateIterator.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return CollectionsKt__CollectionsKt.getLastIndex(this.this$0) - this.delegateIterator.nextIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final void set(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
