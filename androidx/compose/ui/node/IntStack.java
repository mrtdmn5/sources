package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MyersDiff.kt */
/* loaded from: classes.dex */
public final class IntStack {
    public int lastIndex;
    public int[] stack;

    public IntStack(int r1) {
        this.stack = new int[r1];
    }

    public final void pushDiagonal(int r5, int r6, int r7) {
        int r0 = this.lastIndex;
        int r1 = r0 + 3;
        int[] r2 = this.stack;
        if (r1 >= r2.length) {
            int[] copyOf = Arrays.copyOf(r2, r2.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] r22 = this.stack;
        r22[r0 + 0] = r5 + r7;
        r22[r0 + 1] = r6 + r7;
        r22[r0 + 2] = r7;
        this.lastIndex = r1;
    }

    public final void pushRange(int r5, int r6, int r7, int r8) {
        int r0 = this.lastIndex;
        int r1 = r0 + 4;
        int[] r2 = this.stack;
        if (r1 >= r2.length) {
            int[] copyOf = Arrays.copyOf(r2, r2.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] r22 = this.stack;
        r22[r0 + 0] = r5;
        r22[r0 + 1] = r6;
        r22[r0 + 2] = r7;
        r22[r0 + 3] = r8;
        this.lastIndex = r1;
    }

    public final void quickSort(int r6, int r7) {
        boolean z;
        if (r6 < r7) {
            int r0 = r6 - 3;
            for (int r1 = r6; r1 < r7; r1 += 3) {
                int[] r2 = this.stack;
                int r3 = r2[r1];
                int r4 = r2[r7];
                if (r3 >= r4 && (r3 != r4 || r2[r1 + 1] > r2[r7 + 1])) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    r0 += 3;
                    swapDiagonal(r0, r1);
                }
            }
            int r02 = r0 + 3;
            swapDiagonal(r02, r7);
            quickSort(r6, r02 - 3);
            quickSort(r02 + 3, r7);
        }
    }

    public final void swapDiagonal(int r6, int r7) {
        int[] r0 = this.stack;
        int r1 = r0[r6];
        r0[r6] = r0[r7];
        r0[r7] = r1;
        int r12 = r6 + 1;
        int r2 = r7 + 1;
        int r3 = r0[r12];
        r0[r12] = r0[r2];
        r0[r2] = r3;
        int r62 = r6 + 2;
        int r72 = r7 + 2;
        int r13 = r0[r62];
        r0[r62] = r0[r72];
        r0[r72] = r13;
    }
}
