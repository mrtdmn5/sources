package com.google.crypto.tink.shaded.protobuf;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class Utf8 {
    public static final Processor processor;

    /* loaded from: classes3.dex */
    public static class DecodeUtil {
        public static void access$1000(byte b, byte b2, byte b3, byte b4, char[] cArr, int r7) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b2)) {
                if ((((b2 + 112) + (b << 28)) >> 30) == 0 && !isNotTrailingByte(b3) && !isNotTrailingByte(b4)) {
                    int r2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                    cArr[r7] = (char) ((r2 >>> 10) + 55232);
                    cArr[r7 + 1] = (char) ((r2 & 1023) + 56320);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        public static void access$900(byte b, byte b2, byte b3, char[] cArr, int r6) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b2) && ((b != -32 || b2 >= -96) && ((b != -19 || b2 < -96) && !isNotTrailingByte(b3)))) {
                cArr[r6] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        public static boolean isNotTrailingByte(byte b) {
            if (b > -65) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Processor {
        public abstract String decodeUtf8(byte[] bArr, int r2, int r3) throws InvalidProtocolBufferException;

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int r3, int r4);

        public abstract int partialIsValidUtf8(int r1, int r2, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public static final class SafeProcessor extends Processor {
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public final String decodeUtf8(byte[] bArr, int r13, int r14) throws InvalidProtocolBufferException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if ((r13 | r14 | ((bArr.length - r13) - r14)) >= 0) {
                int r0 = r13 + r14;
                char[] cArr = new char[r14];
                int r1 = 0;
                while (r13 < r0) {
                    byte b = bArr[r13];
                    if (b >= 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        break;
                    }
                    r13++;
                    cArr[r1] = (char) b;
                    r1++;
                }
                int r6 = r1;
                while (r13 < r0) {
                    int r12 = r13 + 1;
                    byte b2 = bArr[r13];
                    if (b2 >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        int r2 = r6 + 1;
                        cArr[r6] = (char) b2;
                        r13 = r12;
                        while (true) {
                            r6 = r2;
                            if (r13 >= r0) {
                                break;
                            }
                            byte b3 = bArr[r13];
                            if (b3 >= 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                break;
                            }
                            r13++;
                            r2 = r6 + 1;
                            cArr[r6] = (char) b3;
                        }
                    } else {
                        if (b2 < -32) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            if (r12 < r0) {
                                int r22 = r12 + 1;
                                byte b4 = bArr[r12];
                                int r3 = r6 + 1;
                                if (b2 >= -62 && !DecodeUtil.isNotTrailingByte(b4)) {
                                    cArr[r6] = (char) (((b2 & 31) << 6) | (b4 & 63));
                                    r13 = r22;
                                    r6 = r3;
                                } else {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else {
                            if (b2 < -16) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                if (r12 < r0 - 1) {
                                    int r23 = r12 + 1;
                                    DecodeUtil.access$900(b2, bArr[r12], bArr[r23], cArr, r6);
                                    r13 = r23 + 1;
                                    r6++;
                                } else {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                            } else if (r12 < r0 - 2) {
                                int r24 = r12 + 1;
                                byte b5 = bArr[r12];
                                int r15 = r24 + 1;
                                DecodeUtil.access$1000(b2, b5, bArr[r24], bArr[r15], cArr, r6);
                                r6 = r6 + 1 + 1;
                                r13 = r15 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        }
                    }
                }
                return new String(cArr, 0, r6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(r13), Integer.valueOf(r14)));
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:            return r10 + r0;     */
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int encodeUtf8(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 250
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.SafeProcessor.encodeUtf8(java.lang.CharSequence, byte[], int, int):int");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public final int partialIsValidUtf8(int r6, int r7, byte[] bArr) {
            while (r6 < r7 && bArr[r6] >= 0) {
                r6++;
            }
            if (r6 < r7) {
                while (r6 < r7) {
                    int r0 = r6 + 1;
                    byte b = bArr[r6];
                    if (b < 0) {
                        if (b < -32) {
                            if (r0 < r7) {
                                if (b >= -62) {
                                    r6 = r0 + 1;
                                    if (bArr[r0] > -65) {
                                    }
                                }
                                return -1;
                            }
                            return b;
                        }
                        if (b < -16) {
                            if (r0 >= r7 - 1) {
                                return Utf8.access$1100(bArr, r0, r7);
                            }
                            int r3 = r0 + 1;
                            byte b2 = bArr[r0];
                            if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                                r6 = r3 + 1;
                                if (bArr[r3] > -65) {
                                }
                            }
                        } else {
                            if (r0 >= r7 - 2) {
                                return Utf8.access$1100(bArr, r0, r7);
                            }
                            int r1 = r0 + 1;
                            byte b3 = bArr[r0];
                            if (b3 <= -65) {
                                if ((((b3 + 112) + (b << 28)) >> 30) == 0) {
                                    int r62 = r1 + 1;
                                    if (bArr[r1] <= -65) {
                                        r0 = r62 + 1;
                                        if (bArr[r62] > -65) {
                                        }
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    r6 = r0;
                }
            }
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r3, int r4) {
            super(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Unpaired surrogate at index ", r3, " of ", r4));
        }
    }

    /* loaded from: classes3.dex */
    public static final class UnsafeProcessor extends Processor {
        public static int unsafeIncompleteStateFor(byte[] bArr, int r3, long j, int r6) {
            if (r6 != 0) {
                if (r6 != 1) {
                    if (r6 == 2) {
                        return Utf8.incompleteStateFor(r3, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
                    }
                    throw new AssertionError();
                }
                return Utf8.incompleteStateFor(r3, UnsafeUtil.getByte(bArr, j));
            }
            Processor processor = Utf8.processor;
            if (r3 > -12) {
                return -1;
            }
            return r3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public final String decodeUtf8(byte[] bArr, int r13, int r14) throws InvalidProtocolBufferException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if ((r13 | r14 | ((bArr.length - r13) - r14)) >= 0) {
                int r0 = r13 + r14;
                char[] cArr = new char[r14];
                int r1 = 0;
                while (r13 < r0) {
                    byte b = UnsafeUtil.getByte(bArr, r13);
                    if (b >= 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        break;
                    }
                    r13++;
                    cArr[r1] = (char) b;
                    r1++;
                }
                int r6 = r1;
                while (r13 < r0) {
                    int r12 = r13 + 1;
                    byte b2 = UnsafeUtil.getByte(bArr, r13);
                    if (b2 >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        int r2 = r6 + 1;
                        cArr[r6] = (char) b2;
                        r13 = r12;
                        while (true) {
                            r6 = r2;
                            if (r13 >= r0) {
                                break;
                            }
                            byte b3 = UnsafeUtil.getByte(bArr, r13);
                            if (b3 >= 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                break;
                            }
                            r13++;
                            r2 = r6 + 1;
                            cArr[r6] = (char) b3;
                        }
                    } else {
                        if (b2 < -32) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            if (r12 < r0) {
                                int r22 = r12 + 1;
                                byte b4 = UnsafeUtil.getByte(bArr, r12);
                                int r3 = r6 + 1;
                                if (b2 >= -62 && !DecodeUtil.isNotTrailingByte(b4)) {
                                    cArr[r6] = (char) (((b2 & 31) << 6) | (b4 & 63));
                                    r13 = r22;
                                    r6 = r3;
                                } else {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else {
                            if (b2 < -16) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                if (r12 < r0 - 1) {
                                    int r23 = r12 + 1;
                                    DecodeUtil.access$900(b2, UnsafeUtil.getByte(bArr, r12), UnsafeUtil.getByte(bArr, r23), cArr, r6);
                                    r13 = r23 + 1;
                                    r6++;
                                } else {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                            } else if (r12 < r0 - 2) {
                                int r24 = r12 + 1;
                                byte b5 = UnsafeUtil.getByte(bArr, r12);
                                int r15 = r24 + 1;
                                DecodeUtil.access$1000(b2, b5, UnsafeUtil.getByte(bArr, r24), UnsafeUtil.getByte(bArr, r15), cArr, r6);
                                r6 = r6 + 1 + 1;
                                r13 = r15 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        }
                    }
                }
                return new String(cArr, 0, r6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(r13), Integer.valueOf(r14)));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public final int encodeUtf8(CharSequence charSequence, byte[] bArr, int r24, int r25) {
            long j;
            char c;
            long j2;
            long j3;
            char c2;
            int r1;
            char charAt;
            long j4 = r24;
            long j5 = r25 + j4;
            int length = charSequence.length();
            if (length <= r25 && bArr.length - r25 >= r24) {
                int r2 = 0;
                while (true) {
                    j = 1;
                    c = 128;
                    if (r2 >= length || (charAt = charSequence.charAt(r2)) >= 128) {
                        break;
                    }
                    UnsafeUtil.putByte(bArr, j4, (byte) charAt);
                    r2++;
                    j4 = 1 + j4;
                }
                if (r2 == length) {
                    return (int) j4;
                }
                while (r2 < length) {
                    char charAt2 = charSequence.charAt(r2);
                    if (charAt2 < c && j4 < j5) {
                        long j6 = j4 + j;
                        UnsafeUtil.putByte(bArr, j4, (byte) charAt2);
                        j3 = j;
                        j2 = j6;
                        c2 = c;
                    } else if (charAt2 < 2048 && j4 <= j5 - 2) {
                        long j7 = j4 + j;
                        UnsafeUtil.putByte(bArr, j4, (byte) ((charAt2 >>> 6) | 960));
                        long j8 = j7 + j;
                        UnsafeUtil.putByte(bArr, j7, (byte) ((charAt2 & '?') | 128));
                        long j9 = j;
                        c2 = 128;
                        j2 = j8;
                        j3 = j9;
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && j4 <= j5 - 3) {
                        long j10 = j4 + j;
                        UnsafeUtil.putByte(bArr, j4, (byte) ((charAt2 >>> '\f') | 480));
                        long j11 = j10 + j;
                        UnsafeUtil.putByte(bArr, j10, (byte) (((charAt2 >>> 6) & 63) | 128));
                        UnsafeUtil.putByte(bArr, j11, (byte) ((charAt2 & '?') | 128));
                        j2 = j11 + 1;
                        j3 = 1;
                        c2 = 128;
                    } else {
                        if (j4 <= j5 - 4) {
                            int r3 = r2 + 1;
                            if (r3 != length) {
                                char charAt3 = charSequence.charAt(r3);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j12 = j4 + 1;
                                    UnsafeUtil.putByte(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j13 = j12 + 1;
                                    c2 = 128;
                                    UnsafeUtil.putByte(bArr, j12, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j14 = j13 + 1;
                                    UnsafeUtil.putByte(bArr, j13, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j3 = 1;
                                    j2 = j14 + 1;
                                    UnsafeUtil.putByte(bArr, j14, (byte) ((codePoint & 63) | 128));
                                    r2 = r3;
                                } else {
                                    r2 = r3;
                                }
                            }
                            throw new UnpairedSurrogateException(r2 - 1, length);
                        }
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((r1 = r2 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(r1)))) {
                            throw new UnpairedSurrogateException(r2, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j4);
                    }
                    r2++;
                    c = c2;
                    long j15 = j3;
                    j4 = j2;
                    j = j15;
                }
                return (int) j4;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (r24 + r25));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public final int partialIsValidUtf8(int r10, int r11, byte[] bArr) {
            int r2;
            long j;
            if ((r10 | r11 | (bArr.length - r11)) >= 0) {
                long j2 = r10;
                int r102 = (int) (r11 - j2);
                if (r102 < 16) {
                    r2 = 0;
                } else {
                    r2 = 0;
                    long j3 = j2;
                    while (true) {
                        if (r2 < r102) {
                            long j4 = j3 + 1;
                            if (UnsafeUtil.getByte(bArr, j3) < 0) {
                                break;
                            }
                            r2++;
                            j3 = j4;
                        } else {
                            r2 = r102;
                            break;
                        }
                    }
                }
                int r103 = r102 - r2;
                long j5 = j2 + r2;
                while (true) {
                    byte b = 0;
                    while (true) {
                        if (r103 <= 0) {
                            break;
                        }
                        long j6 = j5 + 1;
                        b = UnsafeUtil.getByte(bArr, j5);
                        if (b >= 0) {
                            r103--;
                            j5 = j6;
                        } else {
                            j5 = j6;
                            break;
                        }
                    }
                    if (r103 == 0) {
                        return 0;
                    }
                    int r104 = r103 - 1;
                    if (b < -32) {
                        if (r104 == 0) {
                            return b;
                        }
                        r103 = r104 - 1;
                        if (b < -62) {
                            break;
                        }
                        j = j5 + 1;
                        if (UnsafeUtil.getByte(bArr, j5) > -65) {
                            break;
                        }
                        j5 = j;
                    } else if (b < -16) {
                        if (r104 < 2) {
                            return unsafeIncompleteStateFor(bArr, b, j5, r104);
                        }
                        r103 = r104 - 2;
                        long j7 = j5 + 1;
                        byte b2 = UnsafeUtil.getByte(bArr, j5);
                        if (b2 > -65 || ((b == -32 && b2 < -96) || (b == -19 && b2 >= -96))) {
                            break;
                        }
                        j5 = j7 + 1;
                        if (UnsafeUtil.getByte(bArr, j7) > -65) {
                            break;
                        }
                    } else {
                        if (r104 < 3) {
                            return unsafeIncompleteStateFor(bArr, b, j5, r104);
                        }
                        r103 = r104 - 3;
                        long j8 = j5 + 1;
                        byte b3 = UnsafeUtil.getByte(bArr, j5);
                        if (b3 > -65) {
                            break;
                        }
                        if ((((b3 + 112) + (b << 28)) >> 30) != 0) {
                            break;
                        }
                        long j9 = j8 + 1;
                        if (UnsafeUtil.getByte(bArr, j8) > -65) {
                            break;
                        }
                        j = j9 + 1;
                        if (UnsafeUtil.getByte(bArr, j9) > -65) {
                            break;
                        }
                        j5 = j;
                    }
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(r10), Integer.valueOf(r11)));
        }
    }

    static {
        boolean z;
        Processor safeProcessor;
        if (UnsafeUtil.HAS_UNSAFE_ARRAY_OPERATIONS && UnsafeUtil.HAS_UNSAFE_BYTEBUFFER_OPERATIONS) {
            z = true;
        } else {
            z = false;
        }
        if (z && !Android.isOnAndroidDevice()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        processor = safeProcessor;
    }

    public static int access$1100(byte[] bArr, int r4, int r5) {
        byte b = bArr[r4 - 1];
        int r52 = r5 - r4;
        if (r52 != 0) {
            if (r52 != 1) {
                if (r52 == 2) {
                    return incompleteStateFor(b, bArr[r4], bArr[r4 + 1]);
                }
                throw new AssertionError();
            }
            return incompleteStateFor(b, bArr[r4]);
        }
        if (b > -12) {
            b = -1;
        }
        return b;
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int r1 = 0;
        int r2 = 0;
        while (r2 < length && charSequence.charAt(r2) < 128) {
            r2++;
        }
        int r3 = length;
        while (true) {
            if (r2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(r2);
            if (charAt < 2048) {
                r3 += (127 - charAt) >>> 31;
                r2++;
            } else {
                int length2 = charSequence.length();
                while (r2 < length2) {
                    char charAt2 = charSequence.charAt(r2);
                    if (charAt2 < 2048) {
                        r1 += (127 - charAt2) >>> 31;
                    } else {
                        r1 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, r2) >= 65536) {
                                r2++;
                            } else {
                                throw new UnpairedSurrogateException(r2, length2);
                            }
                        }
                    }
                    r2++;
                }
                r3 += r1;
            }
        }
        if (r3 >= length) {
            return r3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (r3 + 4294967296L));
    }

    public static int incompleteStateFor(int r1, int r2) {
        if (r1 > -12 || r2 > -65) {
            return -1;
        }
        return r1 ^ (r2 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int r2, int r3) {
        if (processor.partialIsValidUtf8(r2, r3, bArr) == 0) {
            return true;
        }
        return false;
    }

    public static int incompleteStateFor(int r1, int r2, int r3) {
        if (r1 > -12 || r2 > -65 || r3 > -65) {
            return -1;
        }
        return (r1 ^ (r2 << 8)) ^ (r3 << 16);
    }
}
