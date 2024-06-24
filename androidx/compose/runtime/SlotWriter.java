package androidx.compose.runtime;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotWriter {
    public ArrayList<Anchor> anchors;
    public boolean closed;
    public int currentGroup;
    public int currentGroupEnd;
    public int currentSlot;
    public int currentSlotEnd;
    public final IntStack endStack;
    public int groupGapLen;
    public int groupGapStart;
    public int[] groups;
    public int insertCount;
    public int nodeCount;
    public final IntStack nodeCountStack;
    public int parent;
    public PrioritySet pendingRecalculateMarks;
    public Object[] slots;
    public int slotsGapLen;
    public int slotsGapOwner;
    public int slotsGapStart;
    public final IntStack startStack;
    public final SlotTable table;

    /* compiled from: SlotTable.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.util.List moveGroup(androidx.compose.runtime.SlotWriter r21, int r22, androidx.compose.runtime.SlotWriter r23, boolean r24, boolean r25, boolean r26) {
            /*
                Method dump skipped, instructions count: 400
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.Companion.moveGroup(androidx.compose.runtime.SlotWriter, int, androidx.compose.runtime.SlotWriter, boolean, boolean, boolean):java.util.List");
        }
    }

    static {
        new Companion();
    }

    public SlotWriter(SlotTable table) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        int[] r0 = table.groups;
        this.groups = r0;
        Object[] objArr = table.slots;
        this.slots = objArr;
        this.anchors = table.anchors;
        int r2 = table.groupsSize;
        this.groupGapStart = r2;
        this.groupGapLen = (r0.length / 5) - r2;
        this.currentGroupEnd = r2;
        int r4 = table.slotsSize;
        this.slotsGapStart = r4;
        this.slotsGapLen = objArr.length - r4;
        this.slotsGapOwner = r2;
        this.startStack = new IntStack();
        this.endStack = new IntStack();
        this.nodeCountStack = new IntStack();
        this.parent = -1;
    }

    public static void markGroup$default(SlotWriter slotWriter) {
        int r0 = slotWriter.parent;
        int groupIndexToAddress = slotWriter.groupIndexToAddress(r0);
        int[] r2 = slotWriter.groups;
        boolean z = true;
        int r3 = (groupIndexToAddress * 5) + 1;
        int r5 = r2[r3];
        if ((r5 & 134217728) == 0) {
            z = false;
        }
        if (!z) {
            r2[r3] = r5 | 134217728;
            if (!SlotTableKt.access$containsMark(r2, groupIndexToAddress)) {
                slotWriter.updateContainsMark(slotWriter.parent(r0));
            }
        }
    }

    public final void advanceBy(int r5) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (r5 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.insertCount <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (r5 == 0) {
                    return;
                }
                int r2 = this.currentGroup + r5;
                if (r2 < this.parent || r2 > this.currentGroupEnd) {
                    z3 = false;
                }
                if (z3) {
                    this.currentGroup = r2;
                    int dataIndex = dataIndex(this.groups, groupIndexToAddress(r2));
                    this.currentSlot = dataIndex;
                    this.currentSlotEnd = dataIndex;
                    return;
                }
                ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')').toString());
                throw null;
            }
            throw new IllegalStateException("Cannot call seek() while inserting".toString());
        }
        ComposerKt.composeRuntimeError("Cannot seek backwards".toString());
        throw null;
    }

    public final Anchor anchor(int r5) {
        ArrayList<Anchor> arrayList = this.anchors;
        int search = SlotTableKt.search(arrayList, r5, getSize$runtime_release());
        if (search < 0) {
            if (r5 > this.groupGapStart) {
                r5 = -(getSize$runtime_release() - r5);
            }
            Anchor anchor = new Anchor(r5);
            arrayList.add(-(search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        int r2 = anchor.location;
        if (r2 < 0) {
            return r2 + getSize$runtime_release();
        }
        return r2;
    }

    public final int auxIndex(int[] r2, int r3) {
        return SlotTableKt.countOneBits(r2[(r3 * 5) + 1] >> 29) + dataIndex(r2, r3);
    }

    public final void beginInsert() {
        int r0 = this.insertCount;
        this.insertCount = r0 + 1;
        if (r0 == 0) {
            this.endStack.push(((this.groups.length / 5) - this.groupGapLen) - this.currentGroupEnd);
        }
    }

    public final void close() {
        boolean z = true;
        this.closed = true;
        if (this.startStack.tos != 0) {
            z = false;
        }
        if (z) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            int r0 = this.slotsGapStart;
            ArraysKt___ArraysJvmKt.fill(r0, this.slotsGapLen + r0, this.slots);
            recalculateMarks();
        }
        int[] groups = this.groups;
        int r1 = this.groupGapStart;
        Object[] slots = this.slots;
        int r4 = this.slotsGapStart;
        ArrayList<Anchor> anchors = this.anchors;
        SlotTable slotTable = this.table;
        slotTable.getClass();
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(anchors, "anchors");
        if (slotTable.writer) {
            slotTable.writer = false;
            slotTable.groups = groups;
            slotTable.groupsSize = r1;
            slotTable.slots = slots;
            slotTable.slotsSize = r4;
            slotTable.anchors = anchors;
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()".toString());
    }

    public final int dataIndex(int[] r2, int r3) {
        if (r3 >= this.groups.length / 5) {
            return this.slots.length - this.slotsGapLen;
        }
        int r22 = r2[(r3 * 5) + 4];
        int r32 = this.slotsGapLen;
        int length = this.slots.length;
        if (r22 < 0) {
            return (length - r32) + r22 + 1;
        }
        return r22;
    }

    public final int dataIndexToDataAddress(int r2) {
        if (r2 >= this.slotsGapStart) {
            return r2 + this.slotsGapLen;
        }
        return r2;
    }

    public final void endGroup() {
        boolean z;
        int r7;
        int r1 = 1;
        int r2 = 0;
        if (this.insertCount > 0) {
            z = true;
        } else {
            z = false;
        }
        int r3 = this.currentGroup;
        int r4 = this.currentGroupEnd;
        int r5 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(r5);
        int r72 = this.nodeCount;
        int r8 = r3 - r5;
        boolean access$isNode = SlotTableKt.access$isNode(this.groups, groupIndexToAddress);
        IntStack intStack = this.nodeCountStack;
        if (z) {
            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress, r8);
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, r72);
            int pop = intStack.pop();
            if (!access$isNode) {
                r1 = r72;
            }
            this.nodeCount = pop + r1;
            this.parent = parent(this.groups, r5);
            return;
        }
        if (r3 != r4) {
            r1 = 0;
        }
        if (r1 != 0) {
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress);
            int access$nodeCount = SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress);
            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress, r8);
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, r72);
            int pop2 = this.startStack.pop();
            this.currentGroupEnd = ((this.groups.length / 5) - this.groupGapLen) - this.endStack.pop();
            this.parent = pop2;
            int parent = parent(this.groups, r5);
            int pop3 = intStack.pop();
            this.nodeCount = pop3;
            if (parent == pop2) {
                if (!access$isNode) {
                    r2 = r72 - access$nodeCount;
                }
                this.nodeCount = pop3 + r2;
                return;
            }
            int r82 = r8 - access$groupSize;
            if (access$isNode) {
                r7 = 0;
            } else {
                r7 = r72 - access$nodeCount;
            }
            if (r82 != 0 || r7 != 0) {
                while (parent != 0 && parent != pop2 && (r7 != 0 || r82 != 0)) {
                    int groupIndexToAddress2 = groupIndexToAddress(parent);
                    if (r82 != 0) {
                        SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.access$groupSize(this.groups, groupIndexToAddress2) + r82);
                    }
                    if (r7 != 0) {
                        int[] r12 = this.groups;
                        SlotTableKt.access$updateNodeCount(r12, groupIndexToAddress2, SlotTableKt.access$nodeCount(r12, groupIndexToAddress2) + r7);
                    }
                    if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress2)) {
                        r7 = 0;
                    }
                    parent = parent(this.groups, parent);
                }
            }
            this.nodeCount += r7;
            return;
        }
        ComposerKt.composeRuntimeError("Expected to be at the end of a group".toString());
        throw null;
    }

    public final void endInsert() {
        boolean z;
        int r0 = this.insertCount;
        boolean z2 = true;
        if (r0 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r02 = r0 - 1;
            this.insertCount = r02;
            if (r02 == 0) {
                if (this.nodeCountStack.tos != this.startStack.tos) {
                    z2 = false;
                }
                if (z2) {
                    this.currentGroupEnd = ((this.groups.length / 5) - this.groupGapLen) - this.endStack.pop();
                    return;
                } else {
                    ComposerKt.composeRuntimeError("startGroup/endGroup mismatch while inserting".toString());
                    throw null;
                }
            }
            return;
        }
        throw new IllegalStateException("Unbalanced begin/end insert".toString());
    }

    public final void ensureStarted(int r6) {
        boolean z;
        boolean z2 = true;
        if (this.insertCount <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r0 = this.parent;
            if (r0 != r6) {
                if (r6 < r0 || r6 >= this.currentGroupEnd) {
                    z2 = false;
                }
                if (z2) {
                    int r02 = this.currentGroup;
                    int r1 = this.currentSlot;
                    int r2 = this.currentSlotEnd;
                    this.currentGroup = r6;
                    startGroup();
                    this.currentGroup = r02;
                    this.currentSlot = r1;
                    this.currentSlotEnd = r2;
                    return;
                }
                ComposerKt.composeRuntimeError(("Started group at " + r6 + " must be a subgroup of the group at " + r0).toString());
                throw null;
            }
            return;
        }
        ComposerKt.composeRuntimeError("Cannot call ensureStarted() while inserting".toString());
        throw null;
    }

    public final void fixParentAnchorsFor(int r3, int r4, int r5) {
        if (r3 >= this.groupGapStart) {
            r3 = -((getSize$runtime_release() - r3) + 2);
        }
        while (r5 < r4) {
            this.groups[(groupIndexToAddress(r5) * 5) + 2] = r3;
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r5)) + r5;
            fixParentAnchorsFor(r5, access$groupSize, r5 + 1);
            r5 = access$groupSize;
        }
    }

    public final int getSize$runtime_release() {
        return (this.groups.length / 5) - this.groupGapLen;
    }

    public final int groupIndexToAddress(int r2) {
        if (r2 >= this.groupGapStart) {
            return r2 + this.groupGapLen;
        }
        return r2;
    }

    public final int groupSize(int r2) {
        return SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r2));
    }

    public final boolean indexInGroup(int r6, int r7) {
        int r3;
        int length;
        int groupSize;
        if (r7 == this.parent) {
            length = this.currentGroupEnd;
        } else {
            IntStack intStack = this.startStack;
            int r2 = intStack.tos;
            if (r2 > 0) {
                r3 = intStack.slots[r2 - 1];
            } else {
                r3 = 0;
            }
            if (r7 > r3) {
                groupSize = groupSize(r7);
            } else {
                int r32 = 0;
                while (true) {
                    if (r32 < r2) {
                        if (intStack.slots[r32] == r7) {
                            break;
                        }
                        r32++;
                    } else {
                        r32 = -1;
                        break;
                    }
                }
                if (r32 < 0) {
                    groupSize = groupSize(r7);
                } else {
                    length = ((this.groups.length / 5) - this.groupGapLen) - this.endStack.slots[r32];
                }
            }
            length = groupSize + r7;
        }
        if (r6 <= r7 || r6 >= length) {
            return false;
        }
        return true;
    }

    public final void insertGroups(int r12) {
        int r0;
        if (r12 > 0) {
            int r02 = this.currentGroup;
            moveGroupGapTo(r02);
            int r1 = this.groupGapStart;
            int r2 = this.groupGapLen;
            int[] r3 = this.groups;
            int length = r3.length / 5;
            int r5 = length - r2;
            int r6 = 0;
            if (r2 < r12) {
                int max = Math.max(Math.max(length * 2, r5 + r12), 32);
                int[] r8 = new int[max * 5];
                int r7 = max - r5;
                ArraysKt___ArraysJvmKt.copyInto(0, 0, r3, r8, r1 * 5);
                ArraysKt___ArraysJvmKt.copyInto((r1 + r7) * 5, (r2 + r1) * 5, r3, r8, length * 5);
                this.groups = r8;
                r2 = r7;
            }
            int r32 = this.currentGroupEnd;
            if (r32 >= r1) {
                this.currentGroupEnd = r32 + r12;
            }
            int r33 = r1 + r12;
            this.groupGapStart = r33;
            this.groupGapLen = r2 - r12;
            if (r5 > 0) {
                r0 = dataIndex(this.groups, groupIndexToAddress(r02 + r12));
            } else {
                r0 = 0;
            }
            if (this.slotsGapOwner >= r1) {
                r6 = this.slotsGapStart;
            }
            int r22 = this.slotsGapLen;
            int length2 = this.slots.length;
            if (r0 > r6) {
                r0 = -(((length2 - r22) - r0) + 1);
            }
            for (int r23 = r1; r23 < r33; r23++) {
                this.groups[(r23 * 5) + 4] = r0;
            }
            int r03 = this.slotsGapOwner;
            if (r03 >= r1) {
                this.slotsGapOwner = r03 + r12;
            }
        }
    }

    public final void insertSlots(int r10, int r11) {
        if (r10 > 0) {
            moveSlotGapTo(this.currentSlot, r11);
            int r112 = this.slotsGapStart;
            int r0 = this.slotsGapLen;
            if (r0 < r10) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int r3 = length - r0;
                int max = Math.max(Math.max(length * 2, r3 + r10), 32);
                Object[] objArr2 = new Object[max];
                for (int r7 = 0; r7 < max; r7++) {
                    objArr2[r7] = null;
                }
                int r4 = max - r3;
                ArraysKt___ArraysJvmKt.copyInto(0, 0, r112, objArr, objArr2);
                ArraysKt___ArraysJvmKt.copyInto(r112 + r4, r0 + r112, length, objArr, objArr2);
                this.slots = objArr2;
                r0 = r4;
            }
            int r1 = this.currentSlotEnd;
            if (r1 >= r112) {
                this.currentSlotEnd = r1 + r10;
            }
            this.slotsGapStart = r112 + r10;
            this.slotsGapLen = r0 - r10;
        }
    }

    public final boolean isNode(int r2) {
        return SlotTableKt.access$isNode(this.groups, groupIndexToAddress(r2));
    }

    public final void moveFrom(SlotTable table, int r10) {
        boolean z;
        Intrinsics.checkNotNullParameter(table, "table");
        if (this.insertCount > 0) {
            z = true;
        } else {
            z = false;
        }
        ComposerKt.runtimeCheck(z);
        if (r10 == 0 && this.currentGroup == 0 && this.table.groupsSize == 0) {
            int access$groupSize = SlotTableKt.access$groupSize(table.groups, r10);
            int r2 = table.groupsSize;
            if (access$groupSize == r2) {
                int[] groups = this.groups;
                Object[] slots = this.slots;
                ArrayList<Anchor> anchors = this.anchors;
                int[] r4 = table.groups;
                Object[] objArr = table.slots;
                int r6 = table.slotsSize;
                this.groups = r4;
                this.slots = objArr;
                this.anchors = table.anchors;
                this.groupGapStart = r2;
                this.groupGapLen = (r4.length / 5) - r2;
                this.slotsGapStart = r6;
                this.slotsGapLen = objArr.length - r6;
                this.slotsGapOwner = r2;
                Intrinsics.checkNotNullParameter(groups, "groups");
                Intrinsics.checkNotNullParameter(slots, "slots");
                Intrinsics.checkNotNullParameter(anchors, "anchors");
                table.groups = groups;
                table.groupsSize = 0;
                table.slots = slots;
                table.slotsSize = 0;
                table.anchors = anchors;
                return;
            }
        }
        SlotWriter openWriter = table.openWriter();
        try {
            Companion.moveGroup(openWriter, r10, this, true, true, false);
        } finally {
            openWriter.close();
        }
    }

    public final void moveGroupGapTo(int r9) {
        int size$runtime_release;
        int r7;
        int r0 = this.groupGapLen;
        int r1 = this.groupGapStart;
        if (r1 != r9) {
            boolean z = true;
            if (!this.anchors.isEmpty()) {
                int length = (this.groups.length / 5) - this.groupGapLen;
                if (r1 < r9) {
                    for (int access$locationOf = SlotTableKt.access$locationOf(this.anchors, r1, length); access$locationOf < this.anchors.size(); access$locationOf++) {
                        Anchor anchor = this.anchors.get(access$locationOf);
                        Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                        Anchor anchor2 = anchor;
                        int r72 = anchor2.location;
                        if (r72 >= 0 || (r7 = r72 + length) >= r9) {
                            break;
                        }
                        anchor2.location = r7;
                    }
                } else {
                    for (int access$locationOf2 = SlotTableKt.access$locationOf(this.anchors, r9, length); access$locationOf2 < this.anchors.size(); access$locationOf2++) {
                        Anchor anchor3 = this.anchors.get(access$locationOf2);
                        Intrinsics.checkNotNullExpressionValue(anchor3, "anchors[index]");
                        Anchor anchor4 = anchor3;
                        int r73 = anchor4.location;
                        if (r73 < 0) {
                            break;
                        }
                        anchor4.location = -(length - r73);
                    }
                }
            }
            if (r0 > 0) {
                int[] r2 = this.groups;
                int r4 = r9 * 5;
                int r5 = r0 * 5;
                int r6 = r1 * 5;
                if (r9 < r1) {
                    ArraysKt___ArraysJvmKt.copyInto(r5 + r4, r4, r2, r2, r6);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(r6, r6 + r5, r2, r2, r4 + r5);
                }
            }
            if (r9 < r1) {
                r1 = r9 + r0;
            }
            int length2 = this.groups.length / 5;
            if (r1 >= length2) {
                z = false;
            }
            ComposerKt.runtimeCheck(z);
            while (r1 < length2) {
                int r42 = (r1 * 5) + 2;
                int r3 = this.groups[r42];
                if (r3 > -2) {
                    size$runtime_release = r3;
                } else {
                    size$runtime_release = getSize$runtime_release() + r3 + 2;
                }
                if (size$runtime_release >= r9) {
                    size$runtime_release = -((getSize$runtime_release() - size$runtime_release) + 2);
                }
                if (size$runtime_release != r3) {
                    this.groups[r42] = size$runtime_release;
                }
                r1++;
                if (r1 == r9) {
                    r1 += r0;
                }
            }
        }
        this.groupGapStart = r9;
    }

    public final void moveSlotGapTo(int r11, int r12) {
        boolean z;
        boolean z2;
        int r0 = this.slotsGapLen;
        int r1 = this.slotsGapStart;
        int r2 = this.slotsGapOwner;
        if (r1 != r11) {
            Object[] objArr = this.slots;
            if (r11 < r1) {
                ArraysKt___ArraysJvmKt.copyInto(r11 + r0, r11, r1, objArr, objArr);
            } else {
                ArraysKt___ArraysJvmKt.copyInto(r1, r1 + r0, r11 + r0, objArr, objArr);
            }
        }
        int min = Math.min(r12 + 1, getSize$runtime_release());
        if (r2 != min) {
            int length = this.slots.length - r0;
            if (min < r2) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(r2);
                int r6 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int access$dataAnchor = SlotTableKt.access$dataAnchor(this.groups, groupIndexToAddress);
                    if (access$dataAnchor >= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        this.groups[(groupIndexToAddress * 5) + 4] = -((length - access$dataAnchor) + 1);
                        groupIndexToAddress++;
                        if (groupIndexToAddress == r6) {
                            groupIndexToAddress += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a positive anchor".toString());
                        throw null;
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(r2);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int access$dataAnchor2 = SlotTableKt.access$dataAnchor(this.groups, groupIndexToAddress3);
                    if (access$dataAnchor2 < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.groups[(groupIndexToAddress3 * 5) + 4] = access$dataAnchor2 + length + 1;
                        groupIndexToAddress3++;
                        if (groupIndexToAddress3 == this.groupGapStart) {
                            groupIndexToAddress3 += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a negative anchor".toString());
                        throw null;
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = r11;
    }

    public final List moveTo(Anchor anchor, SlotWriter slotWriter) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int access$nodeCount;
        boolean z5;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        boolean z6 = true;
        if (slotWriter.insertCount > 0) {
            z = true;
        } else {
            z = false;
        }
        ComposerKt.runtimeCheck(z);
        if (this.insertCount == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ComposerKt.runtimeCheck(z2);
        if (anchor.location != Integer.MIN_VALUE) {
            z3 = true;
        } else {
            z3 = false;
        }
        ComposerKt.runtimeCheck(z3);
        int anchorIndex = anchorIndex(anchor) + 1;
        int r12 = this.currentGroup;
        if (r12 <= anchorIndex && anchorIndex < this.currentGroupEnd) {
            z4 = true;
        } else {
            z4 = false;
        }
        ComposerKt.runtimeCheck(z4);
        int parent = parent(anchorIndex);
        int groupSize = groupSize(anchorIndex);
        if (isNode(anchorIndex)) {
            access$nodeCount = 1;
        } else {
            access$nodeCount = SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress(anchorIndex));
        }
        List moveGroup = Companion.moveGroup(this, anchorIndex, slotWriter, false, false, true);
        updateContainsMark(parent);
        if (access$nodeCount > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        while (parent >= r12) {
            int groupIndexToAddress = groupIndexToAddress(parent);
            int[] r5 = this.groups;
            SlotTableKt.access$updateGroupSize(r5, groupIndexToAddress, SlotTableKt.access$groupSize(r5, groupIndexToAddress) - groupSize);
            if (z5) {
                if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
                    z5 = false;
                } else {
                    int[] r52 = this.groups;
                    SlotTableKt.access$updateNodeCount(r52, groupIndexToAddress, SlotTableKt.access$nodeCount(r52, groupIndexToAddress) - access$nodeCount);
                }
            }
            parent = parent(parent);
        }
        if (z5) {
            if (this.nodeCount < access$nodeCount) {
                z6 = false;
            }
            ComposerKt.runtimeCheck(z6);
            this.nodeCount -= access$nodeCount;
        }
        return moveGroup;
    }

    public final Object node(int r3) {
        int groupIndexToAddress = groupIndexToAddress(r3);
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(dataIndex(this.groups, groupIndexToAddress))];
        }
        return null;
    }

    public final int parent(int r2) {
        return parent(this.groups, r2);
    }

    public final void recalculateMarks() {
        boolean z;
        boolean z2;
        boolean z3;
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (!prioritySet.list.isEmpty()) {
                int takeMax = prioritySet.takeMax();
                int groupIndexToAddress = groupIndexToAddress(takeMax);
                int r4 = takeMax + 1;
                int groupSize = groupSize(takeMax) + takeMax;
                while (true) {
                    z = false;
                    if (r4 < groupSize) {
                        if ((this.groups[(groupIndexToAddress(r4) * 5) + 1] & 201326592) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z2 = true;
                            break;
                        }
                        r4 += groupSize(r4);
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (SlotTableKt.access$containsMark(this.groups, groupIndexToAddress) != z2) {
                    z = true;
                }
                if (z) {
                    int[] r5 = this.groups;
                    int r3 = (groupIndexToAddress * 5) + 1;
                    if (z2) {
                        r5[r3] = r5[r3] | 67108864;
                    } else {
                        r5[r3] = r5[r3] & (-67108865);
                    }
                    int parent = parent(takeMax);
                    if (parent >= 0) {
                        prioritySet.add(parent);
                    }
                }
            }
        }
    }

    public final boolean removeGroup() {
        boolean z;
        if (this.insertCount == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r0 = this.currentGroup;
            int r2 = this.currentSlot;
            int skipGroup = skipGroup();
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet != null) {
                while (true) {
                    List<Integer> list = prioritySet.list;
                    if (!(!list.isEmpty()) || ((Number) CollectionsKt___CollectionsKt.first((List) list)).intValue() < r0) {
                        break;
                    }
                    prioritySet.takeMax();
                }
            }
            boolean removeGroups = removeGroups(r0, this.currentGroup - r0);
            removeSlots(r2, this.currentSlot - r2, r0 - 1);
            this.currentGroup = r0;
            this.currentSlot = r2;
            this.nodeCount -= skipGroup;
            return removeGroups;
        }
        ComposerKt.composeRuntimeError("Cannot remove group while inserting".toString());
        throw null;
    }

    public final boolean removeGroups(int r9, int r10) {
        boolean z;
        boolean z2 = false;
        if (r10 <= 0) {
            return false;
        }
        ArrayList<Anchor> arrayList = this.anchors;
        moveGroupGapTo(r9);
        if (!arrayList.isEmpty()) {
            int r3 = r10 + r9;
            int access$locationOf = SlotTableKt.access$locationOf(this.anchors, r3, (this.groups.length / 5) - this.groupGapLen);
            if (access$locationOf >= this.anchors.size()) {
                access$locationOf--;
            }
            int r4 = access$locationOf + 1;
            int r5 = 0;
            while (access$locationOf >= 0) {
                Anchor anchor = this.anchors.get(access$locationOf);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int anchorIndex = anchorIndex(anchor2);
                if (anchorIndex < r9) {
                    break;
                }
                if (anchorIndex < r3) {
                    anchor2.location = Integer.MIN_VALUE;
                    if (r5 == 0) {
                        r5 = access$locationOf + 1;
                    }
                    r4 = access$locationOf;
                }
                access$locationOf--;
            }
            if (r4 < r5) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.anchors.subList(r4, r5).clear();
            }
        } else {
            z = false;
        }
        this.groupGapStart = r9;
        this.groupGapLen += r10;
        int r32 = this.slotsGapOwner;
        if (r32 > r9) {
            this.slotsGapOwner = Math.max(r9, r32 - r10);
        }
        int r92 = this.currentGroupEnd;
        if (r92 >= this.groupGapStart) {
            this.currentGroupEnd = r92 - r10;
        }
        int r93 = this.parent;
        if (r93 >= 0 && SlotTableKt.access$containsMark(this.groups, groupIndexToAddress(r93))) {
            z2 = true;
        }
        if (z2) {
            updateContainsMark(this.parent);
        }
        return z;
    }

    public final void removeSlots(int r3, int r4, int r5) {
        if (r4 > 0) {
            int r0 = this.slotsGapLen;
            int r1 = r3 + r4;
            moveSlotGapTo(r1, r5);
            this.slotsGapStart = r3;
            this.slotsGapLen = r0 + r4;
            ArraysKt___ArraysJvmKt.fill(r3, r1, this.slots);
            int r52 = this.currentSlotEnd;
            if (r52 >= r3) {
                this.currentSlotEnd = r52 - r4;
            }
        }
    }

    public final Object set(int r5, Object obj) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(this.currentGroup));
        boolean z = true;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
        int r2 = slotIndex + r5;
        if (r2 < slotIndex || r2 >= dataIndex) {
            z = false;
        }
        if (z) {
            int dataIndexToDataAddress = dataIndexToDataAddress(r2);
            Object[] objArr = this.slots;
            Object obj2 = objArr[dataIndexToDataAddress];
            objArr[dataIndexToDataAddress] = obj;
            return obj2;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Write to an invalid slot index ", r5, " for group ");
        m.append(this.currentGroup);
        ComposerKt.composeRuntimeError(m.toString().toString());
        throw null;
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress) + this.currentGroup;
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress);
    }

    public final void skipToGroupEnd() {
        int r0 = this.currentGroupEnd;
        this.currentGroup = r0;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(r0));
    }

    public final Object slot(int r4, int r5) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(r4));
        boolean z = true;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(r4 + 1));
        int r52 = r5 + slotIndex;
        if (slotIndex > r52 || r52 >= dataIndex) {
            z = false;
        }
        if (!z) {
            return Composer.Companion.Empty;
        }
        return this.slots[dataIndexToDataAddress(r52)];
    }

    public final int slotIndex(int[] r2, int r3) {
        if (r3 >= this.groups.length / 5) {
            return this.slots.length - this.slotsGapLen;
        }
        int access$slotAnchor = SlotTableKt.access$slotAnchor(r2, r3);
        int r32 = this.slotsGapLen;
        int length = this.slots.length;
        if (access$slotAnchor < 0) {
            return (length - r32) + access$slotAnchor + 1;
        }
        return access$slotAnchor;
    }

    public final void startGroup() {
        if (this.insertCount == 0) {
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            startGroup(0, composer$Companion$Empty$1, composer$Companion$Empty$1, false);
        } else {
            ComposerKt.composeRuntimeError("Key must be supplied when inserting".toString());
            throw null;
        }
    }

    public final String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    public final void update(Object obj) {
        boolean z;
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int r2 = this.currentSlot;
        this.currentSlot = r2 + 1;
        Object obj2 = objArr[dataIndexToDataAddress(r2)];
        int r0 = this.currentSlot;
        if (r0 <= this.currentSlotEnd) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.slots[dataIndexToDataAddress(r0 - 1)] = obj;
        } else {
            ComposerKt.composeRuntimeError("Writing to an invalid slot".toString());
            throw null;
        }
    }

    public final void updateAux(Object obj) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (SlotTableKt.access$hasAux(this.groups, groupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = obj;
        } else {
            ComposerKt.composeRuntimeError("Updating the data of a group that was not created with a data slot".toString());
            throw null;
        }
    }

    public final void updateContainsMark(int r3) {
        if (r3 >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet(0);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(r3);
        }
    }

    public final void updateNodeOfGroup(int r4, Object obj) {
        boolean z;
        int groupIndexToAddress = groupIndexToAddress(r4);
        int[] r1 = this.groups;
        if (groupIndexToAddress < r1.length && SlotTableKt.access$isNode(r1, groupIndexToAddress)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.slots[dataIndexToDataAddress(dataIndex(this.groups, groupIndexToAddress))] = obj;
            return;
        }
        ComposerKt.composeRuntimeError(("Updating the node of a group at " + r4 + " that was not created with as a node group").toString());
        throw null;
    }

    public final int parent(int[] r1, int r2) {
        int r12 = r1[(groupIndexToAddress(r2) * 5) + 2];
        return r12 > -2 ? r12 : getSize$runtime_release() + r12 + 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startGroup(int r16, Object obj, Object obj2, boolean z) {
        int access$groupSize;
        byte b = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (b != false) {
            insertGroups(1);
            int r3 = this.currentGroup;
            int groupIndexToAddress = groupIndexToAddress(r3);
            int r8 = obj != composer$Companion$Empty$1 ? 1 : 0;
            int r5 = (z || obj2 == composer$Companion$Empty$1) ? 0 : 1;
            int[] r6 = this.groups;
            int r9 = this.parent;
            int r10 = this.currentSlot;
            int r11 = z ? 1073741824 : 0;
            int r12 = r8 != 0 ? 536870912 : 0;
            int r13 = r5 != 0 ? 268435456 : 0;
            int r7 = groupIndexToAddress * 5;
            r6[r7 + 0] = r16;
            r6[r7 + 1] = r11 | r12 | r13;
            r6[r7 + 2] = r9;
            r6[r7 + 3] = 0;
            r6[r7 + 4] = r10;
            this.currentSlotEnd = r10;
            int r62 = (z ? 1 : 0) + r8 + r5;
            if (r62 > 0) {
                insertSlots(r62, r3);
                Object[] objArr = this.slots;
                int r72 = this.currentSlot;
                if (z) {
                    objArr[r72] = obj2;
                    r72++;
                }
                if (r8 != 0) {
                    objArr[r72] = obj;
                    r72++;
                }
                if (r5 != 0) {
                    objArr[r72] = obj2;
                    r72++;
                }
                this.currentSlot = r72;
            }
            this.nodeCount = 0;
            access$groupSize = r3 + 1;
            this.parent = r3;
            this.currentGroup = access$groupSize;
        } else {
            this.startStack.push(this.parent);
            this.endStack.push(((this.groups.length / 5) - this.groupGapLen) - this.currentGroupEnd);
            int r1 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(r1);
            if (!Intrinsics.areEqual(obj2, composer$Companion$Empty$1)) {
                if (z) {
                    updateNodeOfGroup(this.currentGroup, obj2);
                } else {
                    updateAux(obj2);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress2);
            this.parent = r1;
            this.currentGroup = r1 + 1;
            access$groupSize = r1 + SlotTableKt.access$groupSize(this.groups, groupIndexToAddress2);
        }
        this.currentGroupEnd = access$groupSize;
    }
}
