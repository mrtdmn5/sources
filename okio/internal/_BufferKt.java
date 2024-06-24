package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.Options;
import okio.Segment;

/* compiled from: -Buffer.kt */
/* loaded from: classes4.dex */
public final class _BufferKt {
    public static final byte[] HEX_DIGIT_BYTES;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HEX_DIGIT_BYTES = bytes;
    }

    public static final boolean rangeEquals(Segment segment, int r7, byte[] bArr, int r9) {
        int r0 = segment.limit;
        byte[] bArr2 = segment.data;
        for (int r3 = 1; r3 < r9; r3++) {
            if (r7 == r0) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                r7 = segment.pos;
                r0 = segment.limit;
                bArr2 = segment.data;
            }
            if (bArr2[r7] != bArr[r3]) {
                return false;
            }
            r7++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == 13) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final int selectPrefix(Buffer buffer, Options options, boolean z) {
        int r4;
        int r2;
        boolean z2;
        byte[] bArr;
        int r7;
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = buffer.head;
        int r22 = -2;
        if (segment2 == null) {
            if (z) {
                return -2;
            }
            return -1;
        }
        int r42 = segment2.pos;
        int r5 = segment2.limit;
        byte[] bArr2 = segment2.data;
        Segment segment3 = segment2;
        int r10 = -1;
        int r8 = 0;
        loop0: while (true) {
            int r11 = r8 + 1;
            int[] r12 = options.trie;
            int r82 = r12[r8];
            int r13 = r11 + 1;
            int r112 = r12[r11];
            if (r112 != -1) {
                r10 = r112;
            }
            if (segment3 == null) {
                break;
            }
            if (r82 < 0) {
                int r14 = (r82 * (-1)) + r13;
                while (true) {
                    int r83 = r42 + 1;
                    int r15 = r13 + 1;
                    if ((bArr2[r42] & 255) != r12[r13]) {
                        return r10;
                    }
                    if (r15 == r14) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (r83 == r5) {
                        Intrinsics.checkNotNull(segment3);
                        Segment segment4 = segment3.next;
                        Intrinsics.checkNotNull(segment4);
                        r7 = segment4.pos;
                        int r84 = segment4.limit;
                        bArr = segment4.data;
                        if (segment4 == segment2) {
                            if (!z2) {
                                break loop0;
                            }
                            r5 = r84;
                            segment = null;
                        } else {
                            segment = segment4;
                            r5 = r84;
                        }
                    } else {
                        Segment segment5 = segment3;
                        bArr = bArr2;
                        r7 = r83;
                        segment = segment5;
                    }
                    if (z2) {
                        r4 = r12[r15];
                        r2 = r7;
                        bArr2 = bArr;
                        segment3 = segment;
                        break;
                    }
                    r42 = r7;
                    bArr2 = bArr;
                    r13 = r15;
                    segment3 = segment;
                }
            } else {
                int r142 = r42 + 1;
                int r43 = bArr2[r42] & 255;
                int r152 = r13 + r82;
                while (r13 != r152) {
                    if (r43 == r12[r13]) {
                        r4 = r12[r13 + r82];
                        if (r142 == r5) {
                            segment3 = segment3.next;
                            Intrinsics.checkNotNull(segment3);
                            r2 = segment3.pos;
                            r5 = segment3.limit;
                            bArr2 = segment3.data;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        } else {
                            r2 = r142;
                        }
                    } else {
                        r13++;
                    }
                }
                return r10;
            }
            if (r4 >= 0) {
                return r4;
            }
            r8 = -r4;
            r42 = r2;
            r22 = -2;
        }
        if (z) {
            return r22;
        }
        return r10;
    }
}
