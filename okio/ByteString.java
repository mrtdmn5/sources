package okio;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.internal._ByteStringKt;

/* compiled from: ByteString.kt */
/* loaded from: classes4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY;
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    /* compiled from: ByteString.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static ByteString decodeHex(String str) {
            boolean z;
            if (str.length() % 2 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int r1 = 0; r1 < length; r1++) {
                    int r4 = r1 * 2;
                    bArr[r1] = (byte) (_ByteStringKt.access$decodeHexDigit(str.charAt(r4 + 1)) + (_ByteStringKt.access$decodeHexDigit(str.charAt(r4)) << 4));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }

        public static ByteString encodeUtf8(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ByteString byteString = new ByteString(bytes);
            byteString.utf8 = str;
            return byteString;
        }

        public static ByteString of$default(byte[] bArr) {
            ByteString byteString = ByteString.EMPTY;
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            int length = bArr.length;
            _UtilKt.checkOffsetAndCount(bArr.length, 0, length);
            return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(bArr, 0, length + 0));
        }
    }

    static {
        new Companion();
        EMPTY = new ByteString(new byte[0]);
    }

    public ByteString(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public String base64() {
        byte[] map = _Base64Kt.BASE64;
        byte[] bArr = this.data;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int r5 = 0;
        int r6 = 0;
        while (r5 < length) {
            int r7 = r5 + 1;
            byte b = bArr[r5];
            int r8 = r7 + 1;
            byte b2 = bArr[r7];
            int r9 = r8 + 1;
            byte b3 = bArr[r8];
            int r10 = r6 + 1;
            bArr2[r6] = map[(b & 255) >> 2];
            int r62 = r10 + 1;
            bArr2[r10] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int r52 = r62 + 1;
            bArr2[r62] = map[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            r6 = r52 + 1;
            bArr2[r52] = map[b3 & 63];
            r5 = r9;
        }
        int length2 = bArr.length - length;
        if (length2 != 1) {
            if (length2 == 2) {
                int r4 = r5 + 1;
                byte b4 = bArr[r5];
                byte b5 = bArr[r4];
                int r42 = r6 + 1;
                bArr2[r6] = map[(b4 & 255) >> 2];
                int r63 = r42 + 1;
                bArr2[r42] = map[((b4 & 3) << 4) | ((b5 & 255) >> 4)];
                bArr2[r63] = map[(b5 & 15) << 2];
                bArr2[r63 + 1] = 61;
            }
        } else {
            byte b6 = bArr[r5];
            int r43 = r6 + 1;
            bArr2[r6] = map[(b6 & 255) >> 2];
            int r3 = r43 + 1;
            bArr2[r43] = map[(b6 & 3) << 4];
            bArr2[r3] = 61;
            bArr2[r3 + 1] = 61;
        }
        return new String(bArr2, Charsets.UTF_8);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compareTo(okio.ByteString r8) {
        /*
            r7 = this;
            okio.ByteString r8 = (okio.ByteString) r8
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            int r0 = r7.getSize$okio()
            int r1 = r8.getSize$okio()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L15:
            if (r4 >= r2) goto L2b
            byte r5 = r7.internalGet$okio(r4)
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r6 = r8.internalGet$okio(r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r5 != r6) goto L28
            int r4 = r4 + 1
            goto L15
        L28:
            if (r5 >= r6) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(java.lang.Object):int");
    }

    public ByteString digest$okio(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.data, 0, getSize$okio());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size$okio = byteString.getSize$okio();
            byte[] bArr = this.data;
            if (size$okio == bArr.length && byteString.rangeEquals(0, 0, bArr.length, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int getSize$okio() {
        return this.data.length;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 == 0) {
            int hashCode = Arrays.hashCode(this.data);
            this.hashCode = hashCode;
            return hashCode;
        }
        return r0;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int r4 = 0;
        for (byte b : bArr) {
            int r6 = r4 + 1;
            char[] cArr2 = _ByteStringKt.HEX_DIGIT_CHARS;
            cArr[r4] = cArr2[(b >> 4) & 15];
            r4 = r6 + 1;
            cArr[r6] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public ByteString hmac$okio(ByteString byteString) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(byteString.toByteArray(), "HmacSHA256"));
            byte[] doFinal = mac.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public byte[] internalArray$okio() {
        return this.data;
    }

    public byte internalGet$okio(int r2) {
        return this.data[r2];
    }

    public boolean rangeEquals(ByteString other, int r4) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(0, 0, r4, this.data);
    }

    public ByteString toAsciiLowercase() {
        int r0 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (r0 < bArr.length) {
                byte b = bArr[r0];
                if (b >= 65 && b <= 90) {
                    byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                    copyOf[r0] = (byte) (b + 32);
                    for (int r5 = r0 + 1; r5 < copyOf.length; r5++) {
                        byte b2 = copyOf[r5];
                        if (b2 >= 65 && b2 <= 90) {
                            copyOf[r5] = (byte) (b2 + 32);
                        }
                    }
                    return new ByteString(copyOf);
                }
                r0++;
            } else {
                return this;
            }
        }
    }

    public byte[] toByteArray() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01e0, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01d9, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01cc, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01b6, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a7, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0196, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0185, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0221, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x013b, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x012e, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x011c, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x010d, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x00fc, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x00b2, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x00a7, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0098, code lost:            if (r3 == 64) goto L248;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0224, code lost:            r4 = -1;     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0224 A[EDGE_INSN: B:156:0x0224->B:62:0x0224 BREAK  A[LOOP:0: B:8:0x0012->B:98:0x0012], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0224 A[EDGE_INSN: B:206:0x0224->B:62:0x0224 BREAK  A[LOOP:0: B:8:0x0012->B:98:0x0012], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0224 A[EDGE_INSN: B:242:0x0224->B:62:0x0224 BREAK  A[LOOP:0: B:8:0x0012->B:98:0x0012], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0224 A[EDGE_INSN: B:268:0x0224->B:62:0x0224 BREAK  A[LOOP:0: B:8:0x0012->B:98:0x0012, LOOP_LABEL: LOOP:0: B:8:0x0012->B:98:0x0012], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0224 A[EDGE_INSN: B:61:0x0224->B:62:0x0224 BREAK  A[LOOP:0: B:8:0x0012->B:98:0x0012], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.toString():java.lang.String");
    }

    public final String utf8() {
        String str = this.utf8;
        if (str == null) {
            byte[] internalArray$okio = internalArray$okio();
            Intrinsics.checkNotNullParameter(internalArray$okio, "<this>");
            String str2 = new String(internalArray$okio, Charsets.UTF_8);
            this.utf8 = str2;
            return str2;
        }
        return str;
    }

    public void write$okio(Buffer buffer, int r4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.m1733write(this.data, 0, r4);
    }

    public boolean rangeEquals(int r3, int r4, int r5, byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (r3 >= 0) {
            byte[] bArr = this.data;
            if (r3 <= bArr.length - r5 && r4 >= 0 && r4 <= other.length - r5 && _UtilKt.arrayRangeEquals(r3, bArr, r4, other, r5)) {
                return true;
            }
        }
        return false;
    }
}
