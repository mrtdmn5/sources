package kotlin.collections;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.ranges.IntRange;

/* compiled from: ReversedViews.kt */
/* loaded from: classes.dex */
public final class ReversedListReadOnly<T> extends AbstractList<T> {
    public final List<T> delegate;

    public ReversedListReadOnly(ArrayList arrayList) {
        this.delegate = arrayList;
    }

    @Override // java.util.List
    public final T get(int r5) {
        if (new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(this)).contains(r5)) {
            return this.delegate.get(CollectionsKt__CollectionsKt.getLastIndex(this) - r5);
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Element index ", r5, " must be in range [");
        m.append(new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(this)));
        m.append("].");
        throw new IndexOutOfBoundsException(m.toString());
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.delegate.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<T> iterator() {
        return new ReversedListReadOnly$listIterator$1(this, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator<T> listIterator() {
        return new ReversedListReadOnly$listIterator$1(this, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator<T> listIterator(int r2) {
        return new ReversedListReadOnly$listIterator$1(this, r2);
    }
}
