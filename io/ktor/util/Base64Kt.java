package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.StringsKt;
import java.io.EOFException;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Base64.kt */
/* loaded from: classes3.dex */
public final class Base64Kt {
    public static final int[] BASE64_INVERSE_ALPHABET;

    static {
        int[] r1 = new int[256];
        for (int r3 = 0; r3 < 256; r3++) {
            r1[r3] = StringsKt__StringsKt.indexOf$default((CharSequence) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", (char) r3, 0, false, 6);
        }
        BASE64_INVERSE_ALPHABET = r1;
    }

    public static final byte[] decodeBase64Bytes(String str) {
        String str2;
        int readAvailable;
        boolean z;
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null);
        try {
            int lastIndex = StringsKt__StringsKt.getLastIndex(str);
            while (true) {
                if (-1 < lastIndex) {
                    if (str.charAt(lastIndex) == '=') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        str2 = str.substring(0, lastIndex + 1);
                        Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                        break;
                    }
                    lastIndex--;
                } else {
                    str2 = "";
                    break;
                }
            }
            StringsKt.writeText(bytePacketBuilder, str2, 0, str2.length(), Charsets.UTF_8);
            ByteReadPacket build = bytePacketBuilder.build();
            Intrinsics.checkNotNullParameter(build, "<this>");
            bytePacketBuilder = new BytePacketBuilder(null);
            try {
                byte[] bArr = new byte[4];
                while (build.getRemaining() > 0) {
                    int readAvailable2 = InputArraysKt.readAvailable(build, bArr, 0, 4);
                    int r6 = 0;
                    int r7 = 0;
                    int r8 = 0;
                    while (r6 < 4) {
                        r8 |= ((byte) (((byte) BASE64_INVERSE_ALPHABET[bArr[r6] & 255]) & 63)) << ((3 - r7) * 6);
                        r6++;
                        r7++;
                    }
                    int r5 = 4 - readAvailable2;
                    int r62 = 2;
                    if (r5 <= 2) {
                        while (true) {
                            bytePacketBuilder.writeByte((byte) ((r8 >> (r62 * 8)) & 255));
                            if (r62 != r5) {
                                r62--;
                            }
                        }
                    }
                }
                ByteReadPacket build2 = bytePacketBuilder.build();
                Intrinsics.checkNotNullParameter(build2, "<this>");
                long j = Integer.MAX_VALUE;
                long remaining = build2.getRemaining();
                if (j > remaining) {
                    j = remaining;
                }
                long j2 = 0;
                if (j < j2) {
                    j = j2;
                }
                byte[] bArr2 = new byte[(int) j];
                int r2 = 0;
                while (r2 < Integer.MAX_VALUE && (readAvailable = InputArraysKt.readAvailable(build2, bArr2, r2, Math.min(Integer.MAX_VALUE, bArr2.length) - r2)) > 0) {
                    r2 += readAvailable;
                    if (bArr2.length == r2) {
                        bArr2 = Arrays.copyOf(bArr2, r2 * 2);
                        Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(this, newSize)");
                    }
                }
                if (r2 >= 0) {
                    if (r2 != bArr2.length) {
                        byte[] copyOf = Arrays.copyOf(bArr2, r2);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        return copyOf;
                    }
                    return bArr2;
                }
                throw new EOFException("Not enough bytes available to read 0 bytes: " + (0 - r2) + " more required");
            } finally {
            }
        } finally {
        }
    }
}
