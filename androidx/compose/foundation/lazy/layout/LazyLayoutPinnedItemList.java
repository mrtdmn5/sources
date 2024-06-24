package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: LazyLayoutPinnableItem.kt */
/* loaded from: classes.dex */
public final class LazyLayoutPinnedItemList implements List<PinnedItem>, KMappedMarker {
    public final List<PinnedItem> items = new SnapshotStateList();

    /* compiled from: LazyLayoutPinnableItem.kt */
    /* loaded from: classes.dex */
    public interface PinnedItem {
        int getIndex();

        Object getKey();
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int r1, PinnedItem pinnedItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r1, Collection<? extends PinnedItem> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof PinnedItem)) {
            return false;
        }
        PinnedItem element = (PinnedItem) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.items.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.items.containsAll(elements);
    }

    @Override // java.util.List
    public final PinnedItem get(int r2) {
        return this.items.get(r2);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof PinnedItem)) {
            return -1;
        }
        PinnedItem element = (PinnedItem) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.items.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<PinnedItem> iterator() {
        return this.items.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof PinnedItem)) {
            return -1;
        }
        PinnedItem element = (PinnedItem) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.items.lastIndexOf(element);
    }

    @Override // java.util.List
    public final ListIterator<PinnedItem> listIterator() {
        return this.items.listIterator();
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ PinnedItem remove(int r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<PinnedItem> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ PinnedItem set(int r1, PinnedItem pinnedItem) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.items.size();
    }

    @Override // java.util.List
    public final void sort(Comparator<? super PinnedItem> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<PinnedItem> subList(int r2, int r3) {
        return this.items.subList(r2, r3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends PinnedItem> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator<PinnedItem> listIterator(int r2) {
        return this.items.listIterator(r2);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
