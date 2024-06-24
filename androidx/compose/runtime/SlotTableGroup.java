package androidx.compose.runtime;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotTableGroup implements Iterable<Object>, KMappedMarker {
    public final int group;
    public final SlotTable table;
    public final int version;

    public SlotTableGroup(int r2, int r3, SlotTable table) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.group = r2;
        this.version = r3;
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        SlotTable slotTable = this.table;
        if (slotTable.version == this.version) {
            int r2 = this.group;
            return new GroupIterator(r2 + 1, SlotTableKt.access$groupSize(slotTable.groups, r2) + r2, slotTable);
        }
        throw new ConcurrentModificationException();
    }
}
