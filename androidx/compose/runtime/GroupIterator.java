package androidx.compose.runtime;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class GroupIterator implements Iterator<Object>, KMappedMarker {
    public final int end;
    public int index;
    public final SlotTable table;
    public final int version;

    public GroupIterator(int r2, int r3, SlotTable table) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.end = r3;
        this.index = r2;
        this.version = table.version;
        if (!table.writer) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.index < this.end) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        SlotTable slotTable = this.table;
        int r1 = slotTable.version;
        int r2 = this.version;
        if (r1 == r2) {
            int r12 = this.index;
            this.index = SlotTableKt.access$groupSize(slotTable.groups, r12) + r12;
            return new SlotTableGroup(r12, r2, slotTable);
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
