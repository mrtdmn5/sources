package okio;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: -Util.kt */
/* loaded from: classes4.dex */
public final class _UtilKt {
    public static final boolean arrayRangeEquals(int r4, byte[] a, int r6, byte[] b, int r8) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        for (int r1 = 0; r1 < r8; r1++) {
            if (a[r1 + r4] != b[r1 + r6]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) >= 0 && j2 <= j && j - j2 >= j3) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
    }
}
