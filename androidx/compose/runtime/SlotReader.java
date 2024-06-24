package androidx.compose.runtime;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotReader {
    public boolean closed;
    public int currentEnd;
    public int currentGroup;
    public int currentSlot;
    public int currentSlotEnd;
    public int emptyCount;
    public final int[] groups;
    public final int groupsSize;
    public int parent;
    public final Object[] slots;
    public final int slotsSize;
    public final SlotTable table;

    public SlotReader(SlotTable table) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.groups = table.groups;
        int r0 = table.groupsSize;
        this.groupsSize = r0;
        this.slots = table.slots;
        this.slotsSize = table.slotsSize;
        this.currentEnd = r0;
        this.parent = -1;
    }

    public final Anchor anchor(int r4) {
        ArrayList<Anchor> arrayList = this.table.anchors;
        int search = SlotTableKt.search(arrayList, r4, this.groupsSize);
        if (search < 0) {
            Anchor anchor = new Anchor(r4);
            arrayList.add(-(search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final Object aux(int[] r2, int r3) {
        int countOneBits;
        if (SlotTableKt.access$hasAux(r2, r3)) {
            int r32 = r3 * 5;
            if (r32 >= r2.length) {
                countOneBits = r2.length;
            } else {
                countOneBits = SlotTableKt.countOneBits(r2[r32 + 1] >> 29) + r2[r32 + 4];
            }
            return this.slots[countOneBits];
        }
        return Composer.Companion.Empty;
    }

    public final void close() {
        boolean z = true;
        this.closed = true;
        SlotTable slotTable = this.table;
        slotTable.getClass();
        int r2 = slotTable.readers;
        if (r2 <= 0) {
            z = false;
        }
        if (z) {
            slotTable.readers = r2 - 1;
        } else {
            ComposerKt.composeRuntimeError("Unexpected reader close()".toString());
            throw null;
        }
    }

    public final void endGroup() {
        boolean z;
        int r0;
        if (this.emptyCount == 0) {
            if (this.currentGroup == this.currentEnd) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int r02 = (this.parent * 5) + 2;
                int[] r1 = this.groups;
                int r03 = r1[r02];
                this.parent = r03;
                if (r03 < 0) {
                    r0 = this.groupsSize;
                } else {
                    r0 = r03 + r1[(r03 * 5) + 3];
                }
                this.currentEnd = r0;
                return;
            }
            ComposerKt.composeRuntimeError("endGroup() not called at the end of a group".toString());
            throw null;
        }
    }

    public final Object getGroupAux() {
        int r0 = this.currentGroup;
        if (r0 < this.currentEnd) {
            return aux(this.groups, r0);
        }
        return 0;
    }

    public final int getGroupKey() {
        int r0 = this.currentGroup;
        if (r0 < this.currentEnd) {
            return this.groups[r0 * 5];
        }
        return 0;
    }

    public final Object groupGet(int r4, int r5) {
        int r42;
        int[] r0 = this.groups;
        int access$slotAnchor = SlotTableKt.access$slotAnchor(r0, r4);
        int r43 = r4 + 1;
        if (r43 < this.groupsSize) {
            r42 = r0[(r43 * 5) + 4];
        } else {
            r42 = this.slotsSize;
        }
        int r1 = access$slotAnchor + r5;
        if (r1 < r42) {
            return this.slots[r1];
        }
        return Composer.Companion.Empty;
    }

    public final int groupSize(int r2) {
        return SlotTableKt.access$groupSize(this.groups, r2);
    }

    public final boolean isNode(int r2) {
        return SlotTableKt.access$isNode(this.groups, r2);
    }

    public final Object node(int r3) {
        int[] r0 = this.groups;
        if (SlotTableKt.access$isNode(r0, r3)) {
            if (SlotTableKt.access$isNode(r0, r3)) {
                return this.slots[r0[(r3 * 5) + 4]];
            }
            return Composer.Companion.Empty;
        }
        return null;
    }

    public final int nodeCount(int r2) {
        return SlotTableKt.access$nodeCount(this.groups, r2);
    }

    public final Object objectKey(int[] r3, int r4) {
        boolean z;
        int r42 = r4 * 5;
        int r0 = r3[r42 + 1];
        if ((536870912 & r0) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.slots[SlotTableKt.countOneBits(r0 >> 30) + r3[r42 + 4]];
        }
        return null;
    }

    public final int parent(int r2) {
        return this.groups[(r2 * 5) + 2];
    }

    public final void reposition(int r4) {
        boolean z;
        int r42;
        if (this.emptyCount == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.currentGroup = r4;
            int[] r0 = this.groups;
            int r2 = this.groupsSize;
            if (r4 < r2) {
                r42 = r0[(r4 * 5) + 2];
            } else {
                r42 = -1;
            }
            this.parent = r42;
            if (r42 < 0) {
                this.currentEnd = r2;
            } else {
                this.currentEnd = SlotTableKt.access$groupSize(r0, r42) + r42;
            }
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        ComposerKt.composeRuntimeError("Cannot reposition while in an empty region".toString());
        throw null;
    }

    public final int skipGroup() {
        boolean z;
        int r1 = 1;
        if (this.emptyCount == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r0 = this.currentGroup;
            int[] r2 = this.groups;
            if (!SlotTableKt.access$isNode(r2, r0)) {
                r1 = SlotTableKt.access$nodeCount(r2, this.currentGroup);
            }
            int r02 = this.currentGroup;
            this.currentGroup = r2[(r02 * 5) + 3] + r02;
            return r1;
        }
        ComposerKt.composeRuntimeError("Cannot skip while in an empty region".toString());
        throw null;
    }

    public final void skipToGroupEnd() {
        boolean z;
        if (this.emptyCount == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.currentGroup = this.currentEnd;
        } else {
            ComposerKt.composeRuntimeError("Cannot skip the enclosing group while in an empty region".toString());
            throw null;
        }
    }

    public final void startGroup() {
        boolean z;
        int r0;
        if (this.emptyCount <= 0) {
            int r02 = this.currentGroup;
            int[] r2 = this.groups;
            if (r2[(r02 * 5) + 2] == this.parent) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.parent = r02;
                this.currentEnd = r2[(r02 * 5) + 3] + r02;
                int r1 = r02 + 1;
                this.currentGroup = r1;
                this.currentSlot = SlotTableKt.access$slotAnchor(r2, r02);
                if (r02 >= this.groupsSize - 1) {
                    r0 = this.slotsSize;
                } else {
                    r0 = r2[(r1 * 5) + 4];
                }
                this.currentSlotEnd = r0;
                return;
            }
            throw new IllegalArgumentException("Invalid slot table detected".toString());
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SlotReader(current=");
        sb.append(this.currentGroup);
        sb.append(", key=");
        sb.append(getGroupKey());
        sb.append(", parent=");
        sb.append(this.parent);
        sb.append(", end=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.currentEnd, ')');
    }
}
