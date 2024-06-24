package androidx.compose.runtime.snapshots;

import kotlin.collections.ArraysKt___ArraysJvmKt;

/* compiled from: SnapshotDoubleIndexHeap.kt */
/* loaded from: classes.dex */
public final class SnapshotDoubleIndexHeap {
    public int firstFreeHandle;
    public int[] handles;
    public int size;
    public int[] values = new int[16];
    public int[] index = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] r1 = new int[16];
        int r2 = 0;
        while (r2 < 16) {
            int r3 = r2 + 1;
            r1[r2] = r3;
            r2 = r3;
        }
        this.handles = r1;
    }

    public final int add(int r8) {
        int r0 = this.size + 1;
        int[] r1 = this.values;
        int length = r1.length;
        if (r0 > length) {
            int r2 = length * 2;
            int[] r02 = new int[r2];
            int[] r22 = new int[r2];
            ArraysKt___ArraysJvmKt.copyInto$default(r1, r02, 0, 0, 14);
            ArraysKt___ArraysJvmKt.copyInto$default(this.index, r22, 0, 0, 14);
            this.values = r02;
            this.index = r22;
        }
        int r03 = this.size;
        this.size = r03 + 1;
        int length2 = this.handles.length;
        if (this.firstFreeHandle >= length2) {
            int r12 = length2 * 2;
            int[] r23 = new int[r12];
            int r5 = 0;
            while (r5 < r12) {
                int r6 = r5 + 1;
                r23[r5] = r6;
                r5 = r6;
            }
            ArraysKt___ArraysJvmKt.copyInto$default(this.handles, r23, 0, 0, 14);
            this.handles = r23;
        }
        int r13 = this.firstFreeHandle;
        int[] r24 = this.handles;
        this.firstFreeHandle = r24[r13];
        int[] r3 = this.values;
        r3[r03] = r8;
        this.index[r03] = r13;
        r24[r13] = r03;
        int r82 = r3[r03];
        while (r03 > 0) {
            int r25 = ((r03 + 1) >> 1) - 1;
            if (r3[r25] <= r82) {
                break;
            }
            swap(r25, r03);
            r03 = r25;
        }
        return r13;
    }

    public final void swap(int r6, int r7) {
        int[] r0 = this.values;
        int[] r1 = this.index;
        int[] r2 = this.handles;
        int r3 = r0[r6];
        r0[r6] = r0[r7];
        r0[r7] = r3;
        int r02 = r1[r6];
        r1[r6] = r1[r7];
        r1[r7] = r02;
        r2[r1[r6]] = r6;
        r2[r1[r7]] = r7;
    }
}
