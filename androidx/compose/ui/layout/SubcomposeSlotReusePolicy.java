package androidx.compose.ui.layout;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public interface SubcomposeSlotReusePolicy {

    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public static final class SlotIdsSet implements Collection<Object>, KMappedMarker {
        public final Set<Object> set = new LinkedHashSet();

        public SlotIdsSet(int r1) {
        }

        @Override // java.util.Collection
        public final boolean add(Object obj) {
            return this.set.add(obj);
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final void clear() {
            this.set.clear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return this.set.contains(obj);
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.set.containsAll(elements);
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<Object> iterator() {
            return this.set.iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            return this.set.remove(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<? extends Object> slotIds) {
            Intrinsics.checkNotNullParameter(slotIds, "slotIds");
            return this.set.remove(slotIds);
        }

        @Override // java.util.Collection
        public final boolean removeIf(Predicate<? super Object> predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<? extends Object> slotIds) {
            Intrinsics.checkNotNullParameter(slotIds, "slotIds");
            return this.set.retainAll(slotIds);
        }

        @Override // java.util.Collection
        public final int size() {
            return this.set.size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return (T[]) CollectionToArray.toArray(this, array);
        }
    }

    boolean areCompatible(Object obj, Object obj2);

    void getSlotsToRetain(SlotIdsSet slotIdsSet);
}
