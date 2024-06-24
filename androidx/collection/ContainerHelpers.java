package androidx.collection;

/* loaded from: classes.dex */
public final class ContainerHelpers {
    public static final int[] EMPTY_INTS = new int[0];
    public static final long[] EMPTY_LONGS = new long[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static int binarySearch(int[] r3, int r4, int r5) {
        int r42 = r4 - 1;
        int r0 = 0;
        while (r0 <= r42) {
            int r1 = (r0 + r42) >>> 1;
            int r2 = r3[r1];
            if (r2 < r5) {
                r0 = r1 + 1;
            } else {
                if (r2 <= r5) {
                    return r1;
                }
                r42 = r1 - 1;
            }
        }
        return ~r0;
    }

    public static int binarySearch(long[] jArr, int r5, long j) {
        int r52 = r5 - 1;
        int r0 = 0;
        while (r0 <= r52) {
            int r1 = (r0 + r52) >>> 1;
            long j2 = jArr[r1];
            if (j2 < j) {
                r0 = r1 + 1;
            } else {
                if (j2 <= j) {
                    return r1;
                }
                r52 = r1 - 1;
            }
        }
        return ~r0;
    }
}
