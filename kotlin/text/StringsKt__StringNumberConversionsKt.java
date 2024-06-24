package kotlin.text;

import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringNumberConversions.kt */
/* loaded from: classes.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringBuilderKt {
    public static final void numberFormatError(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException(EndpointMode$Companion$$ExternalSyntheticOutline0.m("Invalid number format: '", input, '\''));
    }

    public static final Integer toIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(10, str);
    }

    public static final Long toLongOrNull(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharKt.checkRadix(10);
        int length = str.length();
        if (length != 0) {
            int r3 = 0;
            char charAt = str.charAt(0);
            long j = -9223372036854775807L;
            if (Intrinsics.compare(charAt, 48) < 0) {
                z = true;
                if (length != 1) {
                    if (charAt == '-') {
                        j = Long.MIN_VALUE;
                        r3 = 1;
                    } else if (charAt == '+') {
                        z = false;
                        r3 = 1;
                    }
                }
            } else {
                z = false;
            }
            long j2 = 0;
            long j3 = -256204778801521550L;
            while (r3 < length) {
                int digit = Character.digit((int) str.charAt(r3), 10);
                if (digit >= 0) {
                    if (j2 < j3) {
                        if (j3 == -256204778801521550L) {
                            j3 = j / 10;
                            if (j2 < j3) {
                            }
                        }
                    }
                    long j4 = j2 * 10;
                    long j5 = digit;
                    if (j4 >= j + j5) {
                        j2 = j4 - j5;
                        r3++;
                    }
                }
            }
            if (z) {
                return Long.valueOf(j2);
            }
            return Long.valueOf(-j2);
        }
        return null;
    }

    public static final Integer toIntOrNull(int r10, String str) {
        int r3;
        boolean z;
        int r2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharKt.checkRadix(r10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int r22 = 0;
        char charAt = str.charAt(0);
        int r5 = -2147483647;
        if (Intrinsics.compare(charAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                r5 = Integer.MIN_VALUE;
                r3 = 1;
            } else {
                if (charAt != '+') {
                    return null;
                }
                r3 = 1;
                z = false;
            }
        } else {
            r3 = 0;
            z = false;
        }
        int r7 = -59652323;
        while (r3 < length) {
            int digit = Character.digit((int) str.charAt(r3), r10);
            if (digit < 0) {
                return null;
            }
            if ((r22 < r7 && (r7 != -59652323 || r22 < (r7 = r5 / r10))) || (r2 = r22 * r10) < r5 + digit) {
                return null;
            }
            r22 = r2 - digit;
            r3++;
        }
        return z ? Integer.valueOf(r22) : Integer.valueOf(-r22);
    }
}
