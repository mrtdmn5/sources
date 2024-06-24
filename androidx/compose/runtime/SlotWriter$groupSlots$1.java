package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotWriter$groupSlots$1 implements Iterator<Object>, KMappedMarker {
    public final /* synthetic */ int $end;
    public int current;
    public final /* synthetic */ SlotWriter this$0;

    public SlotWriter$groupSlots$1(int r1, int r2, SlotWriter slotWriter) {
        this.$end = r2;
        this.this$0 = slotWriter;
        this.current = r1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.current < this.$end) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            SlotWriter slotWriter = this.this$0;
            Object[] objArr = slotWriter.slots;
            int r2 = this.current;
            this.current = r2 + 1;
            return objArr[slotWriter.dataIndexToDataAddress(r2)];
        }
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
