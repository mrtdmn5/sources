package kotlin.collections.builders;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListBuilder.kt */
/* loaded from: classes.dex */
public final class ListBuilderKt {
    public static final <E> E[] arrayOfUninitializedElements(int r1) {
        boolean z;
        if (r1 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return (E[]) new Object[r1];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final void resetRange(int r1, int r2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        while (r1 < r2) {
            objArr[r1] = null;
            r1++;
        }
    }
}
