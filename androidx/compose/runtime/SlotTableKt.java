package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotTableKt {
    public static final boolean access$containsMark(int[] r1, int r2) {
        if ((r1[(r2 * 5) + 1] & 67108864) != 0) {
            return true;
        }
        return false;
    }

    public static final int access$dataAnchor(int[] r0, int r1) {
        return r0[(r1 * 5) + 4];
    }

    public static final int access$groupSize(int[] r0, int r1) {
        return r0[(r1 * 5) + 3];
    }

    public static final boolean access$hasAux(int[] r1, int r2) {
        if ((r1[(r2 * 5) + 1] & 268435456) != 0) {
            return true;
        }
        return false;
    }

    public static final boolean access$isNode(int[] r1, int r2) {
        if ((r1[(r2 * 5) + 1] & 1073741824) != 0) {
            return true;
        }
        return false;
    }

    public static final int access$locationOf(ArrayList arrayList, int r1, int r2) {
        int search = search(arrayList, r1, r2);
        if (search < 0) {
            return -(search + 1);
        }
        return search;
    }

    public static final int access$nodeCount(int[] r0, int r1) {
        return r0[(r1 * 5) + 1] & 67108863;
    }

    public static final int access$slotAnchor(int[] r1, int r2) {
        int r22 = r2 * 5;
        return countOneBits(r1[r22 + 1] >> 28) + r1[r22 + 4];
    }

    public static final void access$updateGroupSize(int[] r1, int r2, int r3) {
        boolean z;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        ComposerKt.runtimeCheck(z);
        r1[(r2 * 5) + 3] = r3;
    }

    public static final void access$updateNodeCount(int[] r2, int r3, int r4) {
        boolean z;
        if (r4 >= 0 && r4 < 67108863) {
            z = true;
        } else {
            z = false;
        }
        ComposerKt.runtimeCheck(z);
        int r32 = (r3 * 5) + 1;
        r2[r32] = r4 | (r2[r32] & (-67108864));
    }

    public static final int countOneBits(int r2) {
        switch (r2) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
                return 1;
            case 3:
            case 5:
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static final int search(ArrayList<Anchor> arrayList, int r5, int r6) {
        int size = arrayList.size() - 1;
        int r1 = 0;
        while (r1 <= size) {
            int r2 = (r1 + size) >>> 1;
            int r3 = arrayList.get(r2).location;
            if (r3 < 0) {
                r3 += r6;
            }
            int compare = Intrinsics.compare(r3, r5);
            if (compare < 0) {
                r1 = r2 + 1;
            } else if (compare > 0) {
                size = r2 - 1;
            } else {
                return r2;
            }
        }
        return -(r1 + 1);
    }
}
