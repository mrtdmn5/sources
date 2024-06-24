package androidx.compose.runtime.snapshots;

import java.util.ListIterator;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public final class SubList$listIterator$1<T> implements ListIterator<T>, KMappedMarker {
    public final /* synthetic */ Ref$IntRef $current;
    public final /* synthetic */ SubList<T> this$0;

    public SubList$listIterator$1(Ref$IntRef ref$IntRef, SubList<T> subList) {
        this.$current = ref$IntRef;
        this.this$0 = subList;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        Object obj2 = SnapshotStateListKt.sync;
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        if (this.$current.element < this.this$0.size - 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.$current.element >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        Ref$IntRef ref$IntRef = this.$current;
        int r1 = ref$IntRef.element + 1;
        SubList<T> subList = this.this$0;
        SnapshotStateListKt.access$validateRange(r1, subList.size);
        ref$IntRef.element = r1;
        return subList.get(r1);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.$current.element + 1;
    }

    @Override // java.util.ListIterator
    public final T previous() {
        Ref$IntRef ref$IntRef = this.$current;
        int r1 = ref$IntRef.element;
        SubList<T> subList = this.this$0;
        SnapshotStateListKt.access$validateRange(r1, subList.size);
        ref$IntRef.element = r1 - 1;
        return subList.get(r1);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.$current.element;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        Object obj = SnapshotStateListKt.sync;
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        Object obj2 = SnapshotStateListKt.sync;
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }
}
