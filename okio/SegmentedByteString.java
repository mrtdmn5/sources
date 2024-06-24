package okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes4.dex */
public final class SegmentedByteString extends ByteString {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public SegmentedByteString(byte[][] bArr, int[] r3) {
        super(ByteString.EMPTY.data);
        this.segments = bArr;
        this.directory = r3;
    }

    @Override // okio.ByteString
    public final String base64() {
        return new ByteString(toByteArray()).base64();
    }

    @Override // okio.ByteString
    public final ByteString digest$okio(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.segments;
        int length = bArr.length;
        int r2 = 0;
        int r3 = 0;
        while (r2 < length) {
            int[] r5 = this.directory;
            int r4 = r5[length + r2];
            int r52 = r5[r2];
            messageDigest.update(bArr[r2], r4, r52 - r3);
            r2++;
            r3 = r52;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof ByteString) {
                ByteString byteString = (ByteString) obj;
                if (byteString.getSize$okio() != getSize$okio() || !rangeEquals(byteString, getSize$okio())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // okio.ByteString
    public final int getSize$okio() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int r0 = this.hashCode;
        if (r0 == 0) {
            byte[][] bArr = this.segments;
            int length = bArr.length;
            int r2 = 0;
            int r3 = 1;
            int r4 = 0;
            while (r2 < length) {
                int[] r6 = this.directory;
                int r5 = r6[length + r2];
                int r62 = r6[r2];
                byte[] bArr2 = bArr[r2];
                int r42 = (r62 - r4) + r5;
                while (r5 < r42) {
                    r3 = (r3 * 31) + bArr2[r5];
                    r5++;
                }
                r2++;
                r4 = r62;
            }
            this.hashCode = r3;
            return r3;
        }
        return r0;
    }

    @Override // okio.ByteString
    public final String hex() {
        return new ByteString(toByteArray()).hex();
    }

    @Override // okio.ByteString
    public final ByteString hmac$okio(ByteString byteString) {
        byte[][] bArr = this.segments;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(byteString.toByteArray(), "HmacSHA256"));
            int length = bArr.length;
            int r0 = 0;
            int r3 = 0;
            while (r0 < length) {
                int[] r4 = this.directory;
                int r5 = r4[length + r0];
                int r42 = r4[r0];
                mac.update(bArr[r0], r5, r42 - r3);
                r0++;
                r3 = r42;
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    public final byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public final byte internalGet$okio(int r10) {
        int r3;
        byte[][] bArr = this.segments;
        int length = bArr.length - 1;
        int[] r2 = this.directory;
        _UtilKt.checkOffsetAndCount(r2[length], r10, 1L);
        int segment = _SegmentedByteStringKt.segment(this, r10);
        if (segment == 0) {
            r3 = 0;
        } else {
            r3 = r2[segment - 1];
        }
        return bArr[segment][(r10 - r3) + r2[bArr.length + segment]];
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int r8, int r9, int r10, byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (r8 < 0 || r8 > getSize$okio() - r10 || r9 < 0 || r9 > other.length - r10) {
            return false;
        }
        int r102 = r10 + r8;
        int segment = _SegmentedByteStringKt.segment(this, r8);
        while (r8 < r102) {
            int[] r2 = this.directory;
            int r3 = segment == 0 ? 0 : r2[segment - 1];
            int r4 = r2[segment] - r3;
            byte[][] bArr = this.segments;
            int r22 = r2[bArr.length + segment];
            int min = Math.min(r102, r4 + r3) - r8;
            if (!_UtilKt.arrayRangeEquals((r8 - r3) + r22, bArr[segment], r9, other, min)) {
                return false;
            }
            r9 += min;
            r8 += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final ByteString toAsciiLowercase() {
        return new ByteString(toByteArray()).toAsciiLowercase();
    }

    @Override // okio.ByteString
    public final byte[] toByteArray() {
        byte[] bArr = new byte[getSize$okio()];
        byte[][] bArr2 = this.segments;
        int length = bArr2.length;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        while (r3 < length) {
            int[] r7 = this.directory;
            int r6 = r7[length + r3];
            int r72 = r7[r3];
            int r42 = r72 - r4;
            ArraysKt___ArraysJvmKt.copyInto(r5, bArr2[r3], r6, bArr, r6 + r42);
            r5 += r42;
            r3++;
            r4 = r72;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public final String toString() {
        return new ByteString(toByteArray()).toString();
    }

    @Override // okio.ByteString
    public final void write$okio(Buffer buffer, int r12) {
        int r5;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int r1 = 0 + r12;
        int segment = _SegmentedByteStringKt.segment(this, 0);
        int r3 = 0;
        while (r3 < r1) {
            int[] r4 = this.directory;
            if (segment == 0) {
                r5 = 0;
            } else {
                r5 = r4[segment - 1];
            }
            int r6 = r4[segment] - r5;
            byte[][] bArr = this.segments;
            int r42 = r4[bArr.length + segment];
            int min = Math.min(r1, r6 + r5) - r3;
            int r52 = (r3 - r5) + r42;
            Segment segment2 = new Segment(bArr[segment], r52, r52 + min, true);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            r3 += min;
            segment++;
        }
        buffer.size += r12;
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(ByteString other, int r11) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (getSize$okio() - r11 < 0) {
            return false;
        }
        int r112 = r11 + 0;
        int segment = _SegmentedByteStringKt.segment(this, 0);
        int r2 = 0;
        int r3 = 0;
        while (r2 < r112) {
            int[] r4 = this.directory;
            int r5 = segment == 0 ? 0 : r4[segment - 1];
            int r6 = r4[segment] - r5;
            byte[][] bArr = this.segments;
            int r42 = r4[bArr.length + segment];
            int min = Math.min(r112, r6 + r5) - r2;
            if (!other.rangeEquals(r3, (r2 - r5) + r42, min, bArr[segment])) {
                return false;
            }
            r3 += min;
            r2 += min;
            segment++;
        }
        return true;
    }
}
