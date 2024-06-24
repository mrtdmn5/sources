package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stack.kt */
/* loaded from: classes.dex */
public final class IntStack {
    public int[] slots = new int[10];
    public int tos;

    public final int pop() {
        int[] r0 = this.slots;
        int r1 = this.tos - 1;
        this.tos = r1;
        return r0[r1];
    }

    public final void push(int r4) {
        int r0 = this.tos;
        int[] r1 = this.slots;
        if (r0 >= r1.length) {
            int[] copyOf = Arrays.copyOf(r1, r1.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.slots = copyOf;
        }
        int[] r02 = this.slots;
        int r12 = this.tos;
        this.tos = r12 + 1;
        r02[r12] = r4;
    }
}
