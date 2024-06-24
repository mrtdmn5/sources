package androidx.compose.runtime.collection;

/* compiled from: IdentityArrayIntMap.kt */
/* loaded from: classes.dex */
public final class IdentityArrayIntMap {
    public int size;
    public Object[] keys = new Object[4];
    public int[] values = new int[4];

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:            r7 = r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int add(int r11, java.lang.Object r12) {
        /*
            r10 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            int[] r0 = r10.values
            int r1 = r10.size
            r2 = 0
            r3 = -1
            if (r1 <= 0) goto L68
            int r1 = r1 + r3
            int r4 = java.lang.System.identityHashCode(r12)
            java.lang.Object[] r5 = r10.keys
            r6 = r2
        L15:
            if (r6 > r1) goto L5e
            int r7 = r6 + r1
            int r7 = r7 >>> 1
            r8 = r5[r7]
            int r9 = java.lang.System.identityHashCode(r8)
            if (r9 >= r4) goto L26
            int r6 = r7 + 1
            goto L15
        L26:
            if (r9 <= r4) goto L2b
            int r1 = r7 + (-1)
            goto L15
        L2b:
            if (r8 != r12) goto L2e
            goto L61
        L2e:
            java.lang.Object[] r1 = r10.keys
            int r5 = r10.size
            int r6 = r7 + (-1)
        L34:
            if (r3 >= r6) goto L46
            r8 = r1[r6]
            if (r8 != r12) goto L3c
            r7 = r6
            goto L61
        L3c:
            int r8 = java.lang.System.identityHashCode(r8)
            if (r8 == r4) goto L43
            goto L46
        L43:
            int r6 = r6 + (-1)
            goto L34
        L46:
            int r7 = r7 + 1
            if (r7 >= r5) goto L59
            r6 = r1[r7]
            if (r6 != r12) goto L4f
            goto L61
        L4f:
            int r6 = java.lang.System.identityHashCode(r6)
            if (r6 == r4) goto L46
            int r7 = r7 + 1
            int r1 = -r7
            goto L5c
        L59:
            int r5 = r5 + 1
            int r1 = -r5
        L5c:
            r7 = r1
            goto L61
        L5e:
            int r6 = r6 + 1
            int r7 = -r6
        L61:
            if (r7 < 0) goto L69
            r12 = r0[r7]
            r0[r7] = r11
            return r12
        L68:
            r7 = r3
        L69:
            int r7 = r7 + 1
            int r1 = -r7
            java.lang.Object[] r4 = r10.keys
            int r5 = r10.size
            int r6 = r4.length
            if (r5 != r6) goto L91
            int r6 = r4.length
            int r6 = r6 * 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            int r7 = r4.length
            int r7 = r7 * 2
            int[] r7 = new int[r7]
            int r8 = r1 + 1
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(r8, r1, r5, r4, r6)
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(r8, r1, r0, r7, r5)
            r5 = 6
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(r4, r6, r2, r1, r5)
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(r0, r7, r2, r1, r5)
            r10.keys = r6
            r10.values = r7
            goto L99
        L91:
            int r2 = r1 + 1
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(r2, r1, r5, r4, r4)
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(r2, r1, r0, r0, r5)
        L99:
            java.lang.Object[] r0 = r10.keys
            r0[r1] = r12
            int[] r12 = r10.values
            r12[r1] = r11
            int r11 = r10.size
            int r11 = r11 + 1
            r10.size = r11
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityArrayIntMap.add(int, java.lang.Object):int");
    }
}
