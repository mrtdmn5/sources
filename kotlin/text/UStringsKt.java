package kotlin.text;

import androidx.compose.runtime.ActualAndroid_androidKt;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UStrings.kt */
/* loaded from: classes.dex */
public final class UStringsKt {
    public static void checkNonnegative(int r2, String str) {
        if (r2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + r2);
    }

    public static final ParcelableSnapshotMutableIntState mutableIntStateOf(int r1) {
        int r0 = ActualAndroid_androidKt.$r8$clinit;
        return new ParcelableSnapshotMutableIntState(r1);
    }

    /* renamed from: toString-V7xB4Y4 */
    public static final String m1669toStringV7xB4Y4(int r4) {
        CharsKt__CharKt.checkRadix(16);
        String l = Long.toString(r4 & 4294967295L, 16);
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return l;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte toUByte(java.lang.String r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 10
            kotlin.UInt r0 = toUIntOrNull(r0, r4)
            r1 = 0
            if (r0 == 0) goto L24
            int r0 = r0.data
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 ^ r0
            r3 = -2147483393(0xffffffff800000ff, float:-3.57E-43)
            int r2 = java.lang.Integer.compare(r2, r3)
            if (r2 <= 0) goto L1d
            goto L24
        L1d:
            byte r0 = (byte) r0
            kotlin.UByte r2 = new kotlin.UByte
            r2.<init>(r0)
            goto L25
        L24:
            r2 = r1
        L25:
            if (r2 == 0) goto L2a
            byte r4 = r2.data
            return r4
        L2a:
            kotlin.text.StringsKt__StringNumberConversionsKt.numberFormatError(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.UStringsKt.toUByte(java.lang.String):byte");
    }

    public static final int toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(10, str);
        if (uIntOrNull != null) {
            return uIntOrNull.data;
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    public static final UInt toUIntOrNull(int r16, String str) {
        int r6;
        int r15;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharKt.checkRadix(r16);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int r4 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare(charAt, 48) < 0) {
            r6 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            r6 = 0;
        }
        int r5 = 119304647;
        int r7 = 119304647;
        while (r6 < length) {
            int digit = Character.digit((int) str.charAt(r6), r16);
            if (digit < 0) {
                return null;
            }
            int r10 = r4 ^ Integer.MIN_VALUE;
            if (Integer.compare(r10, r7 ^ Integer.MIN_VALUE) > 0) {
                if (r7 == r5) {
                    r15 = r6;
                    r7 = (int) (((-1) & 4294967295L) / (r16 & 4294967295L));
                    if (Integer.compare(r10, r7 ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            r15 = r6;
            int r42 = r4 * r16;
            int r52 = r42 + digit;
            if (Integer.compare(r52 ^ Integer.MIN_VALUE, r42 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            r6 = r15 + 1;
            r4 = r52;
            r5 = 119304647;
        }
        return new UInt(r4);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.ULong toULongOrNull(java.lang.String r23) {
        /*
            r0 = r23
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = 10
            kotlin.text.CharsKt__CharKt.checkRadix(r1)
            int r2 = r23.length()
            if (r2 != 0) goto L14
            goto L9f
        L14:
            r3 = 0
            char r4 = r0.charAt(r3)
            r5 = 48
            int r5 = kotlin.jvm.internal.Intrinsics.compare(r4, r5)
            r6 = 1
            if (r5 >= 0) goto L2c
            if (r2 == r6) goto L9f
            r5 = 43
            if (r4 == r5) goto L2a
            goto L9f
        L2a:
            r4 = r6
            goto L2d
        L2c:
            r4 = r3
        L2d:
            long r7 = (long) r1
            r9 = 0
            r11 = 512409557603043100(0x71c71c71c71c71c, double:2.0539100454284282E-274)
            r13 = r9
            r15 = r11
        L37:
            if (r4 >= r2) goto Lac
            char r5 = r0.charAt(r4)
            int r5 = java.lang.Character.digit(r5, r1)
            if (r5 >= 0) goto L44
            goto L9f
        L44:
            r17 = -9223372036854775808
            r19 = r2
            long r1 = r13 ^ r17
            r20 = r4
            long r3 = r15 ^ r17
            int r3 = java.lang.Long.compare(r1, r3)
            if (r3 <= 0) goto L8c
            int r3 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r3 != 0) goto L9f
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 >= 0) goto L6c
            long r3 = r7 ^ r17
            int r3 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r3 >= 0) goto L69
            r15 = r9
            goto L83
        L69:
            r3 = 1
            goto L82
        L6c:
            long r15 = r15 / r7
            long r3 = r15 << r6
            long r15 = r3 * r7
            r21 = -1
            long r21 = r21 - r15
            long r15 = r21 ^ r17
            long r21 = r7 ^ r17
            int r15 = (r15 > r21 ? 1 : (r15 == r21 ? 0 : -1))
            if (r15 < 0) goto L7f
            r15 = r6
            goto L80
        L7f:
            r15 = 0
        L80:
            long r9 = (long) r15
            long r3 = r3 + r9
        L82:
            r15 = r3
        L83:
            long r3 = r15 ^ r17
            int r1 = java.lang.Long.compare(r1, r3)
            if (r1 <= 0) goto L8c
            goto L9f
        L8c:
            long r13 = r13 * r7
            long r1 = (long) r5
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r1 & r3
            long r1 = r1 + r13
            long r3 = r1 ^ r17
            long r9 = r13 ^ r17
            int r3 = java.lang.Long.compare(r3, r9)
            if (r3 >= 0) goto La1
        L9f:
            r0 = 0
            goto Lb1
        La1:
            int r4 = r20 + 1
            r13 = r1
            r2 = r19
            r1 = 10
            r3 = 0
            r9 = 0
            goto L37
        Lac:
            kotlin.ULong r0 = new kotlin.ULong
            r0.<init>(r13)
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.UStringsKt.toULongOrNull(java.lang.String):kotlin.ULong");
    }

    public static final UShort toUShortOrNull(int r2, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(r2, str);
        if (uIntOrNull == null) {
            return null;
        }
        int r22 = uIntOrNull.data;
        if (Integer.compare(Integer.MIN_VALUE ^ r22, -2147418113) > 0) {
            return null;
        }
        return new UShort((short) r22);
    }
}
