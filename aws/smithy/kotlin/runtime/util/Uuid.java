package aws.smithy.kotlin.runtime.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Uuid.kt */
/* loaded from: classes.dex */
public final class Uuid {
    public static final char[] nibbleChars;
    public static final Random.Default random;
    public static final long type2Mask;
    public static final long type2Set;
    public static final long v4Mask;
    public static final long v4Set;
    public final long high;
    public final long low;
    public final String stringRep;

    /* compiled from: Uuid.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static void writeDigits(long j, int r7, char[] cArr, int r9, int r10) {
            int r72 = 64 - (r7 * 8);
            int r102 = r10 * 2;
            int r0 = 0;
            while (r0 < r102) {
                r72 -= 4;
                cArr[r9] = Uuid.nibbleChars[(int) ((j >> r72) & 15)];
                r0++;
                r9++;
            }
        }
    }

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        nibbleChars = charArray;
        random = Random.Default;
        v4Mask = 61440 & 4294967295L;
        v4Set = DfuBaseService.ERROR_CONNECTION_MASK & 4294967295L;
        type2Mask = -4611686018427387904L;
        type2Set = Long.MIN_VALUE;
    }

    public Uuid(long j, long j2) {
        this.high = j;
        this.low = j2;
        char[] cArr = new char[36];
        Companion.writeDigits(j, 0, cArr, 0, 4);
        cArr[8] = '-';
        Companion.writeDigits(j, 4, cArr, 9, 2);
        cArr[13] = '-';
        Companion.writeDigits(j, 6, cArr, 14, 2);
        cArr[18] = '-';
        Companion.writeDigits(j2, 0, cArr, 19, 2);
        cArr[23] = '-';
        Companion.writeDigits(j2, 2, cArr, 24, 6);
        this.stringRep = new String(cArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        if (this.high == uuid.high && this.low == uuid.low) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.low) + (Long.hashCode(this.high) * 31);
    }

    public final String toString() {
        return this.stringRep;
    }
}
