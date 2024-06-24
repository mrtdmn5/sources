package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public final class StateListIterator<T> implements ListIterator<T>, KMappedMarker {
    public int index;
    public final SnapshotStateList<T> list;
    public int modification;

    public StateListIterator(SnapshotStateList<T> list, int r3) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.index = r3 - 1;
        this.modification = list.getModification$runtime_release();
    }

    @Override // java.util.ListIterator
    public final void add(T t) {
        validateModification();
        int r0 = this.index + 1;
        SnapshotStateList<T> snapshotStateList = this.list;
        snapshotStateList.add(r0, t);
        this.index++;
        this.modification = snapshotStateList.getModification$runtime_release();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        if (this.index < this.list.size() - 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.index >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        validateModification();
        int r0 = this.index + 1;
        SnapshotStateList<T> snapshotStateList = this.list;
        SnapshotStateListKt.access$validateRange(r0, snapshotStateList.size());
        T t = snapshotStateList.get(r0);
        this.index = r0;
        return t;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.index + 1;
    }

    @Override // java.util.ListIterator
    public final T previous() {
        validateModification();
        int r0 = this.index;
        SnapshotStateList<T> snapshotStateList = this.list;
        SnapshotStateListKt.access$validateRange(r0, snapshotStateList.size());
        this.index--;
        return snapshotStateList.get(this.index);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        validateModification();
        int r0 = this.index;
        SnapshotStateList<T> snapshotStateList = this.list;
        snapshotStateList.remove(r0);
        this.index--;
        this.modification = snapshotStateList.getModification$runtime_release();
    }

    @Override // java.util.ListIterator
    public final void set(T t) {
        validateModification();
        int r0 = this.index;
        SnapshotStateList<T> snapshotStateList = this.list;
        snapshotStateList.set(r0, t);
        this.modification = snapshotStateList.getModification$runtime_release();
    }

    public final void validateModification() {
        if (this.list.getModification$runtime_release() == this.modification) {
        } else {
            throw new ConcurrentModificationException();
        }
    }
}
