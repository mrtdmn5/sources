package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.SegmentedByteString;

/* compiled from: -SegmentedByteString.kt */
/* loaded from: classes4.dex */
public final class _SegmentedByteStringKt {
    public static final int segment(SegmentedByteString segmentedByteString, int r5) {
        int r2;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int r52 = r5 + 1;
        int length = segmentedByteString.segments.length;
        int[] r4 = segmentedByteString.directory;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r1 = length - 1;
        int r0 = 0;
        while (true) {
            if (r0 <= r1) {
                r2 = (r0 + r1) >>> 1;
                int r3 = r4[r2];
                if (r3 < r52) {
                    r0 = r2 + 1;
                } else {
                    if (r3 <= r52) {
                        break;
                    }
                    r1 = r2 - 1;
                }
            } else {
                r2 = (-r0) - 1;
                break;
            }
        }
        if (r2 < 0) {
            return ~r2;
        }
        return r2;
    }
}
