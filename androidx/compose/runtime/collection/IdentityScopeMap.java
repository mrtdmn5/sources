package androidx.compose.runtime.collection;

import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityScopeMap.kt */
/* loaded from: classes.dex */
public final class IdentityScopeMap<T> {
    public IdentityArraySet<T>[] scopeSets;
    public int size;
    public int[] valueOrder;
    public Object[] values;

    public IdentityScopeMap() {
        int[] r1 = new int[50];
        for (int r2 = 0; r2 < 50; r2++) {
            r1[r2] = r2;
        }
        this.valueOrder = r1;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void add(Object value, Object scope) {
        int r4;
        IdentityArraySet<T> identityArraySet;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        int r0 = this.size;
        int[] r1 = this.valueOrder;
        Object[] objArr = this.values;
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        if (r0 > 0) {
            r4 = find(value);
            if (r4 >= 0) {
                identityArraySet = scopeSetAt(r4);
                identityArraySet.add(scope);
            }
        } else {
            r4 = -1;
        }
        int r42 = -(r4 + 1);
        if (r0 < r1.length) {
            int r5 = r1[r0];
            objArr[r5] = value;
            identityArraySet = identityArraySetArr[r5];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet<>();
                identityArraySetArr[r5] = identityArraySet;
            }
            if (r42 < r0) {
                ArraysKt___ArraysJvmKt.copyInto(r42 + 1, r42, r1, r1, r0);
            }
            r1[r42] = r5;
            this.size++;
        } else {
            int length = r1.length * 2;
            Object[] copyOf = Arrays.copyOf(identityArraySetArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            IdentityArraySet<T>[] identityArraySetArr2 = (IdentityArraySet[]) copyOf;
            IdentityArraySet<T> identityArraySet2 = new IdentityArraySet<>();
            identityArraySetArr2[r0] = identityArraySet2;
            Object[] copyOf2 = Arrays.copyOf(objArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            copyOf2[r0] = value;
            int[] r9 = new int[length];
            for (int r6 = r0 + 1; r6 < length; r6++) {
                r9[r6] = r6;
            }
            if (r42 < r0) {
                ArraysKt___ArraysJvmKt.copyInto(r42 + 1, r42, r1, r9, r0);
            }
            r9[r42] = r0;
            if (r42 > 0) {
                ArraysKt___ArraysJvmKt.copyInto$default(r1, r9, 0, r42, 6);
            }
            this.scopeSets = identityArraySetArr2;
            this.values = copyOf2;
            this.valueOrder = r9;
            this.size++;
            identityArraySet = identityArraySet2;
        }
        identityArraySet.add(scope);
    }

    public final void clear() {
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        int[] r1 = this.valueOrder;
        Object[] objArr = this.values;
        int length = identityArraySetArr.length;
        for (int r5 = 0; r5 < length; r5++) {
            IdentityArraySet<T> identityArraySet = identityArraySetArr[r5];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            r1[r5] = r5;
            objArr[r5] = null;
        }
        this.size = 0;
    }

    public final boolean contains(Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (find(element) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:            return -(r5 + 1);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int find(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = java.lang.System.identityHashCode(r9)
            int r1 = r8.size
            int r1 = r1 + (-1)
            java.lang.Object[] r2 = r8.values
            int[] r3 = r8.valueOrder
            r4 = 0
        Ld:
            if (r4 > r1) goto L60
            int r5 = r4 + r1
            int r5 = r5 >>> 1
            r6 = r3[r5]
            r6 = r2[r6]
            int r7 = java.lang.System.identityHashCode(r6)
            if (r7 >= r0) goto L20
            int r4 = r5 + 1
            goto Ld
        L20:
            if (r7 <= r0) goto L25
            int r1 = r5 + (-1)
            goto Ld
        L25:
            if (r9 != r6) goto L28
            return r5
        L28:
            java.lang.Object[] r1 = r8.values
            int[] r2 = r8.valueOrder
            int r3 = r5 + (-1)
        L2e:
            r4 = -1
            if (r4 >= r3) goto L42
            r4 = r2[r3]
            r4 = r1[r4]
            if (r4 != r9) goto L38
            goto L5f
        L38:
            int r4 = java.lang.System.identityHashCode(r4)
            if (r4 == r0) goto L3f
            goto L42
        L3f:
            int r3 = r3 + (-1)
            goto L2e
        L42:
            int r5 = r5 + 1
            int r3 = r8.size
        L46:
            if (r5 >= r3) goto L5a
            r4 = r2[r5]
            r4 = r1[r4]
            if (r4 != r9) goto L50
            r3 = r5
            goto L5f
        L50:
            int r4 = java.lang.System.identityHashCode(r4)
            if (r4 == r0) goto L57
            goto L5c
        L57:
            int r5 = r5 + 1
            goto L46
        L5a:
            int r5 = r8.size
        L5c:
            int r5 = r5 + 1
            int r3 = -r5
        L5f:
            return r3
        L60:
            int r4 = r4 + 1
            int r9 = -r4
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityScopeMap.find(java.lang.Object):int");
    }

    public final boolean remove(Object value, T t) {
        int r5;
        IdentityArraySet<T> identityArraySet;
        Intrinsics.checkNotNullParameter(value, "value");
        int find = find(value);
        int[] r0 = this.valueOrder;
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        Object[] objArr = this.values;
        int r3 = this.size;
        if (find < 0 || (identityArraySet = identityArraySetArr[(r5 = r0[find])]) == null) {
            return false;
        }
        boolean remove = identityArraySet.remove(t);
        if (identityArraySet.size == 0) {
            int r1 = find + 1;
            if (r1 < r3) {
                ArraysKt___ArraysJvmKt.copyInto(find, r1, r0, r0, r3);
            }
            int r32 = r3 - 1;
            r0[r32] = r5;
            objArr[r5] = null;
            this.size = r32;
        }
        return remove;
    }

    public final void removeScope(T scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        int[] r0 = this.valueOrder;
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        Object[] objArr = this.values;
        int r3 = this.size;
        int r5 = 0;
        for (int r4 = 0; r4 < r3; r4++) {
            int r6 = r0[r4];
            IdentityArraySet<T> identityArraySet = identityArraySetArr[r6];
            Intrinsics.checkNotNull(identityArraySet);
            identityArraySet.remove(scope);
            if (identityArraySet.size > 0) {
                if (r5 != r4) {
                    int r7 = r0[r5];
                    r0[r5] = r6;
                    r0[r4] = r7;
                }
                r5++;
            }
        }
        int r9 = this.size;
        for (int r1 = r5; r1 < r9; r1++) {
            objArr[r0[r1]] = null;
        }
        this.size = r5;
    }

    public final IdentityArraySet<T> scopeSetAt(int r3) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[r3]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }
}
