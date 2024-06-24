package androidx.compose.runtime.snapshots;

import com.google.gson.internal.ObjectConstructor;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SnapshotIdSet.kt */
/* loaded from: classes.dex */
public final class SnapshotIdSetKt implements ObjectConstructor {
    public static final int access$lowestBitOf(long j) {
        int r0;
        if ((4294967295L & j) == 0) {
            r0 = 32;
            j >>= 32;
        } else {
            r0 = 0;
        }
        if ((65535 & j) == 0) {
            r0 += 16;
            j >>= 16;
        }
        if ((255 & j) == 0) {
            r0 += 8;
            j >>= 8;
        }
        if ((15 & j) == 0) {
            r0 += 4;
            j >>= 4;
        }
        if ((1 & j) == 0) {
            if ((2 & j) != 0) {
                return r0 + 1;
            }
            if ((4 & j) != 0) {
                return r0 + 2;
            }
            if ((j & 8) != 0) {
                return r0 + 3;
            }
            return -1;
        }
        return r0;
    }

    public static final int binarySearch(int[] r4, int r5) {
        int length = r4.length - 1;
        int r1 = 0;
        while (r1 <= length) {
            int r2 = (r1 + length) >>> 1;
            int r3 = r4[r2];
            if (r5 > r3) {
                r1 = r2 + 1;
            } else if (r5 < r3) {
                length = r2 - 1;
            } else {
                return r2;
            }
        }
        return -(r1 + 1);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        return new ConcurrentHashMap();
    }
}
