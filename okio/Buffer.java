package okio;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.internal._BufferKt;
import okio.internal._ByteStringKt;

/* compiled from: Buffer.kt */
/* loaded from: classes4.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    public long size;

    public final void clear() {
        skip(this.size);
    }

    public final Object clone() {
        Buffer buffer = new Buffer();
        if (this.size != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                Intrinsics.checkNotNull(segment3);
                Intrinsics.checkNotNull(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.size = this.size;
        }
        return buffer;
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        if (segment2.limit < 8192 && segment2.owner) {
            j -= r3 - segment2.pos;
        }
        return j;
    }

    public final void copyTo(Buffer out, long j, long j2) {
        Intrinsics.checkNotNullParameter(out, "out");
        _UtilKt.checkOffsetAndCount(this.size, j, j2);
        if (j2 != 0) {
            out.size += j2;
            Segment segment = this.head;
            while (true) {
                Intrinsics.checkNotNull(segment);
                long j3 = segment.limit - segment.pos;
                if (j < j3) {
                    break;
                }
                j -= j3;
                segment = segment.next;
            }
            while (j2 > 0) {
                Intrinsics.checkNotNull(segment);
                Segment sharedCopy = segment.sharedCopy();
                int r4 = sharedCopy.pos + ((int) j);
                sharedCopy.pos = r4;
                sharedCopy.limit = Math.min(r4 + ((int) j2), sharedCopy.limit);
                Segment segment2 = out.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    out.head = sharedCopy;
                } else {
                    Segment segment3 = segment2.prev;
                    Intrinsics.checkNotNull(segment3);
                    segment3.push(sharedCopy);
                }
                j2 -= sharedCopy.limit - sharedCopy.pos;
                segment = segment.next;
                j = 0;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Buffer) {
                long j = this.size;
                Buffer buffer = (Buffer) obj;
                if (j == buffer.size) {
                    if (j != 0) {
                        Segment segment = this.head;
                        Intrinsics.checkNotNull(segment);
                        Segment segment2 = buffer.head;
                        Intrinsics.checkNotNull(segment2);
                        int r5 = segment.pos;
                        int r6 = segment2.pos;
                        long j2 = 0;
                        while (j2 < this.size) {
                            long min = Math.min(segment.limit - r5, segment2.limit - r6);
                            long j3 = 0;
                            while (j3 < min) {
                                int r15 = r5 + 1;
                                byte b = segment.data[r5];
                                int r52 = r6 + 1;
                                if (b == segment2.data[r6]) {
                                    j3++;
                                    r6 = r52;
                                    r5 = r15;
                                }
                            }
                            if (r5 == segment.limit) {
                                Segment segment3 = segment.next;
                                Intrinsics.checkNotNull(segment3);
                                r5 = segment3.pos;
                                segment = segment3;
                            }
                            if (r6 == segment2.limit) {
                                segment2 = segment2.next;
                                Intrinsics.checkNotNull(segment2);
                                r6 = segment2.pos;
                            }
                            j2 += min;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public final boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public final byte getByte(long j) {
        _UtilKt.checkOffsetAndCount(this.size, j, 1L);
        Segment segment = this.head;
        if (segment != null) {
            long j2 = this.size;
            if (j2 - j < j) {
                while (j2 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j2 -= segment.limit - segment.pos;
                }
                return segment.data[(int) ((segment.pos + j) - j2)];
            }
            long j3 = 0;
            while (true) {
                int r3 = segment.limit;
                int r4 = segment.pos;
                long j4 = (r3 - r4) + j3;
                if (j4 <= j) {
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j3 = j4;
                } else {
                    return segment.data[(int) ((r4 + j) - j3)];
                }
            }
        } else {
            Intrinsics.checkNotNull(null);
            throw null;
        }
    }

    public final int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int r1 = 1;
        do {
            int r3 = segment.limit;
            for (int r2 = segment.pos; r2 < r3; r2++) {
                r1 = (r1 * 31) + segment.data[r2];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != this.head);
        return r1;
    }

    public final long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        boolean z = false;
        if (0 <= j && j <= j2) {
            z = true;
        }
        if (z) {
            long j4 = this.size;
            if (j2 > j4) {
                j2 = j4;
            }
            if (j == j2 || (segment = this.head) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j4 -= segment.limit - segment.pos;
                }
                while (j4 < j2) {
                    int min = (int) Math.min(segment.limit, (segment.pos + j2) - j4);
                    for (int r11 = (int) ((segment.pos + j) - j4); r11 < min; r11++) {
                        if (segment.data[r11] == b) {
                            return (r11 - segment.pos) + j4;
                        }
                    }
                    j4 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j4;
                }
                return -1L;
            }
            while (true) {
                long j5 = (segment.limit - segment.pos) + j3;
                if (j5 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j5;
            }
            while (j3 < j2) {
                int min2 = (int) Math.min(segment.limit, (segment.pos + j2) - j3);
                for (int r112 = (int) ((segment.pos + j) - j3); r112 < min2; r112++) {
                    if (segment.data[r112] == b) {
                        return (r112 - segment.pos) + j3;
                    }
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("size=" + this.size + " fromIndex=" + j + " toIndex=" + j2).toString());
    }

    @Override // okio.BufferedSource
    public final long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(0L, targetBytes);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // okio.BufferedSource
    public final boolean rangeEquals(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] bArr = bytes.data;
        int length = bArr.length;
        if (length < 0 || this.size - 0 < length || bArr.length - 0 < length) {
            return false;
        }
        for (int r2 = 0; r2 < length; r2++) {
            if (getByte(r2 + 0) != bArr[0 + r2]) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            sink.write(this, j);
            return j;
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("byteCount < 0: ", j).toString());
    }

    @Override // okio.BufferedSource
    public final long readAll(Buffer buffer) throws IOException {
        long j = this.size;
        if (j > 0) {
            buffer.write(this, j);
        }
        return j;
    }

    @Override // okio.BufferedSource
    public final byte readByte() throws EOFException {
        if (this.size != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int r1 = segment.pos;
            int r2 = segment.limit;
            int r3 = r1 + 1;
            byte b = segment.data[r1];
            this.size--;
            if (r3 == r2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = r3;
            }
            return b;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final byte[] readByteArray() {
        return readByteArray(this.size);
    }

    public final ByteString readByteString() {
        return readByteString(this.size);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4 A[EDGE_INSN: B:41:0x00a4->B:38:0x00a4 BREAK  A[LOOP:0: B:4:0x000c->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009c  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lab
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            okio.Segment r7 = r14.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r8 = r7.pos
            int r9 = r7.limit
        L15:
            if (r8 >= r9) goto L90
            byte[] r10 = r7.data
            r10 = r10[r8]
            r11 = 48
            if (r10 < r11) goto L26
            r11 = 57
            if (r10 > r11) goto L26
            int r11 = r10 + (-48)
            goto L3d
        L26:
            r11 = 97
            if (r10 < r11) goto L31
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L31
            int r11 = r10 + (-97)
            goto L3b
        L31:
            r11 = 65
            if (r10 < r11) goto L68
            r11 = 70
            if (r10 > r11) goto L68
            int r11 = r10 + (-65)
        L3b:
            int r11 = r11 + 10
        L3d:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4d
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L15
        L4d:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            r0.writeHexadecimalUnsignedLong(r4)
            r0.m1734writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.readUtf8()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L68:
            r6 = 1
            if (r1 == 0) goto L6c
            goto L90
        L6c:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 2
            char[] r2 = new char[r2]
            char[] r3 = okio.internal._ByteStringKt.HEX_DIGIT_CHARS
            int r4 = r10 >> 4
            r4 = r4 & 15
            char r4 = r3[r4]
            r2[r0] = r4
            r0 = r10 & 15
            char r0 = r3[r0]
            r2[r6] = r0
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L90:
            if (r8 != r9) goto L9c
            okio.Segment r8 = r7.pop()
            r14.head = r8
            okio.SegmentPool.recycle(r7)
            goto L9e
        L9c:
            r7.pos = r8
        L9e:
            if (r6 != 0) goto La4
            okio.Segment r7 = r14.head
            if (r7 != 0) goto Lc
        La4:
            long r2 = r14.size
            long r0 = (long) r1
            long r2 = r2 - r0
            r14.size = r2
            return r4
        Lab:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public final int readInt() throws EOFException {
        if (this.size >= 4) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int r1 = segment.pos;
            int r4 = segment.limit;
            if (r4 - r1 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            int r5 = r1 + 1;
            byte[] bArr = segment.data;
            int r7 = r5 + 1;
            int r12 = ((bArr[r1] & 255) << 24) | ((bArr[r5] & 255) << 16);
            int r52 = r7 + 1;
            int r13 = r12 | ((bArr[r7] & 255) << 8);
            int r72 = r52 + 1;
            int r14 = r13 | (bArr[r52] & 255);
            this.size -= 4;
            if (r72 == r4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = r72;
            }
            return r14;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final short readShort() throws EOFException {
        if (this.size >= 2) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int r1 = segment.pos;
            int r4 = segment.limit;
            if (r4 - r1 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            int r5 = r1 + 1;
            byte[] bArr = segment.data;
            int r7 = r5 + 1;
            int r12 = ((bArr[r1] & 255) << 8) | (bArr[r5] & 255);
            this.size -= 2;
            if (r7 == r4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = r7;
            }
            return (short) r12;
        }
        throw new EOFException();
    }

    public final String readString(long j, Charset charset) throws EOFException {
        boolean z;
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j >= 0 && j <= 2147483647L) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.size >= j) {
                if (j == 0) {
                    return "";
                }
                Segment segment = this.head;
                Intrinsics.checkNotNull(segment);
                int r1 = segment.pos;
                if (r1 + j > segment.limit) {
                    return new String(readByteArray(j), charset);
                }
                int r3 = (int) j;
                String str = new String(segment.data, r1, r3, charset);
                int r9 = segment.pos + r3;
                segment.pos = r9;
                this.size -= j;
                if (r9 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("byteCount: ", j).toString());
    }

    public final String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final boolean request(long j) {
        if (this.size >= j) {
            return true;
        }
        return false;
    }

    @Override // okio.BufferedSource
    public final void require(long j) throws EOFException {
        if (this.size >= j) {
        } else {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final int select(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix = _BufferKt.selectPrefix(this, options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        skip(options.byteStrings[selectPrefix].getSize$okio());
        return selectPrefix;
    }

    @Override // okio.BufferedSource
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j, segment.limit - segment.pos);
                long j2 = min;
                this.size -= j2;
                j -= j2;
                int r2 = segment.pos + min;
                segment.pos = r2;
                if (r2 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot(int r9) {
        if (r9 == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(this.size, 0L, r9);
        Segment segment = this.head;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        while (r2 < r9) {
            Intrinsics.checkNotNull(segment);
            int r4 = segment.limit;
            int r5 = segment.pos;
            if (r4 != r5) {
                r2 += r4 - r5;
                r3++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[r3];
        int[] r22 = new int[r3 * 2];
        Segment segment2 = this.head;
        int r42 = 0;
        while (r1 < r9) {
            Intrinsics.checkNotNull(segment2);
            bArr[r42] = segment2.data;
            r1 += segment2.limit - segment2.pos;
            r22[r42] = Math.min(r1, r9);
            r22[r42 + r3] = segment2.pos;
            segment2.shared = true;
            r42++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, r22);
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final String toString() {
        boolean z;
        long j = this.size;
        if (j <= 2147483647L) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return snapshot((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.size).toString());
    }

    public final Segment writableSegment$okio(int r4) {
        boolean z = true;
        if (r4 < 1 || r4 > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            if (segment2.limit + r4 <= 8192 && segment2.owner) {
                return segment2;
            }
            Segment take2 = SegmentPool.take();
            segment2.push(take2);
            return take2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        m1733write(source, 0, source.length);
        return this;
    }

    @Override // okio.BufferedSink
    public final long writeAll(Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read != -1) {
                j += read;
            } else {
                return j;
            }
        }
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeByte(int r1) {
        m1734writeByte(r1);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long j) {
        writeHexadecimalUnsignedLong(j);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeInt(int r1) {
        m1735writeInt(r1);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeShort(int r1) {
        m1736writeShort(r1);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeUtf8(int r1, int r2, String str) {
        m1737writeUtf8(r1, r2, str);
        return this;
    }

    public final void writeUtf8CodePoint(int r12) {
        boolean z;
        String str;
        if (r12 < 128) {
            m1734writeByte(r12);
            return;
        }
        if (r12 < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            int r4 = writableSegment$okio.limit;
            byte[] bArr = writableSegment$okio.data;
            bArr[r4] = (byte) ((r12 >> 6) | 192);
            bArr[r4 + 1] = (byte) ((r12 & 63) | 128);
            writableSegment$okio.limit = r4 + 2;
            this.size += 2;
            return;
        }
        int r5 = 0;
        if (55296 <= r12 && r12 < 57344) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            m1734writeByte(63);
            return;
        }
        if (r12 < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            int r2 = writableSegment$okio2.limit;
            byte[] bArr2 = writableSegment$okio2.data;
            bArr2[r2] = (byte) ((r12 >> 12) | 224);
            bArr2[r2 + 1] = (byte) (((r12 >> 6) & 63) | 128);
            bArr2[r2 + 2] = (byte) ((r12 & 63) | 128);
            writableSegment$okio2.limit = r2 + 3;
            this.size += 3;
            return;
        }
        if (r12 <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            int r22 = writableSegment$okio3.limit;
            byte[] bArr3 = writableSegment$okio3.data;
            bArr3[r22] = (byte) ((r12 >> 18) | 240);
            bArr3[r22 + 1] = (byte) (((r12 >> 12) & 63) | 128);
            bArr3[r22 + 2] = (byte) (((r12 >> 6) & 63) | 128);
            bArr3[r22 + 3] = (byte) ((r12 & 63) | 128);
            writableSegment$okio3.limit = r22 + 4;
            this.size += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (r12 != 0) {
            char[] cArr = _ByteStringKt.HEX_DIGIT_CHARS;
            char[] cArr2 = {cArr[(r12 >> 28) & 15], cArr[(r12 >> 24) & 15], cArr[(r12 >> 20) & 15], cArr[(r12 >> 16) & 15], cArr[(r12 >> 12) & 15], cArr[(r12 >> 8) & 15], cArr[(r12 >> 4) & 15], cArr[r12 & 15]};
            while (r5 < 8 && cArr2[r5] == '0') {
                r5++;
            }
            str = StringsKt__StringsJVMKt.concatToString(cArr2, r5, 8);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public final long indexOfElement(long j, ByteString targetBytes) {
        int r10;
        int r11;
        int r102;
        int r112;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long j2 = 0;
        if (j >= 0) {
            Segment segment = this.head;
            if (segment != null) {
                long j3 = this.size;
                long j4 = j3 - j;
                byte[] bArr = targetBytes.data;
                if (j4 < j) {
                    while (j3 > j) {
                        segment = segment.prev;
                        Intrinsics.checkNotNull(segment);
                        j3 -= segment.limit - segment.pos;
                    }
                    if (bArr.length == 2) {
                        byte b = bArr[0];
                        byte b2 = bArr[1];
                        while (j3 < this.size) {
                            r102 = (int) ((segment.pos + j) - j3);
                            int r113 = segment.limit;
                            while (r102 < r113) {
                                byte b3 = segment.data[r102];
                                if (b3 == b || b3 == b2) {
                                    r112 = segment.pos;
                                    return (r102 - r112) + j3;
                                }
                                r102++;
                            }
                            j3 += segment.limit - segment.pos;
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j = j3;
                        }
                    } else {
                        while (j3 < this.size) {
                            r102 = (int) ((segment.pos + j) - j3);
                            int r114 = segment.limit;
                            while (r102 < r114) {
                                byte b4 = segment.data[r102];
                                for (byte b5 : bArr) {
                                    if (b4 == b5) {
                                        r112 = segment.pos;
                                        return (r102 - r112) + j3;
                                    }
                                }
                                r102++;
                            }
                            j3 += segment.limit - segment.pos;
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j = j3;
                        }
                    }
                } else {
                    while (true) {
                        long j5 = (segment.limit - segment.pos) + j2;
                        if (j5 > j) {
                            break;
                        }
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j2 = j5;
                    }
                    if (bArr.length == 2) {
                        byte b6 = bArr[0];
                        byte b7 = bArr[1];
                        while (j2 < this.size) {
                            r10 = (int) ((segment.pos + j) - j2);
                            int r115 = segment.limit;
                            while (r10 < r115) {
                                byte b8 = segment.data[r10];
                                if (b8 == b6 || b8 == b7) {
                                    r11 = segment.pos;
                                    return (r10 - r11) + j2;
                                }
                                r10++;
                            }
                            j2 += segment.limit - segment.pos;
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j = j2;
                        }
                    } else {
                        while (j2 < this.size) {
                            r10 = (int) ((segment.pos + j) - j2);
                            int r116 = segment.limit;
                            while (r10 < r116) {
                                byte b9 = segment.data[r10];
                                for (byte b10 : bArr) {
                                    if (b9 == b10) {
                                        r11 = segment.pos;
                                        return (r10 - r11) + j2;
                                    }
                                }
                                r10++;
                            }
                            j2 += segment.limit - segment.pos;
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j = j2;
                        }
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("fromIndex < 0: ", j).toString());
    }

    public final String readUtf8(long j) throws EOFException {
        return readString(j, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long indexOf = indexOf((byte) 10, 0L, j2);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(this, indexOf);
            }
            if (j2 < this.size && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return _BufferKt.readUtf8Line(this, j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0L, Math.min(32, this.size));
            throw new EOFException("\\n not found: limit=" + Math.min(this.size, j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("limit < 0: ", j).toString());
    }

    /* renamed from: writeByte */
    public final void m1734writeByte(int r5) {
        Segment writableSegment$okio = writableSegment$okio(1);
        int r1 = writableSegment$okio.limit;
        writableSegment$okio.limit = r1 + 1;
        writableSegment$okio.data[r1] = (byte) r5;
        this.size++;
    }

    @Override // okio.BufferedSink
    public final Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            m1734writeByte(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 | (j5 >>> 16);
            long j7 = j6 | (j6 >>> 32);
            long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
            long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
            long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
            long j11 = j10 + (j10 >>> 8);
            long j12 = j11 + (j11 >>> 16);
            int r1 = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
            Segment writableSegment$okio = writableSegment$okio(r1);
            int r3 = writableSegment$okio.limit;
            for (int r5 = (r3 + r1) - 1; r5 >= r3; r5--) {
                writableSegment$okio.data[r5] = _BufferKt.HEX_DIGIT_BYTES[(int) (15 & j)];
                j >>>= 4;
            }
            writableSegment$okio.limit += r1;
            this.size += r1;
        }
        return this;
    }

    /* renamed from: writeInt */
    public final void m1735writeInt(int r6) {
        Segment writableSegment$okio = writableSegment$okio(4);
        int r1 = writableSegment$okio.limit;
        int r2 = r1 + 1;
        byte[] bArr = writableSegment$okio.data;
        bArr[r1] = (byte) ((r6 >>> 24) & 255);
        int r12 = r2 + 1;
        bArr[r2] = (byte) ((r6 >>> 16) & 255);
        int r22 = r12 + 1;
        bArr[r12] = (byte) ((r6 >>> 8) & 255);
        bArr[r22] = (byte) (r6 & 255);
        writableSegment$okio.limit = r22 + 1;
        this.size += 4;
    }

    /* renamed from: writeShort */
    public final void m1736writeShort(int r6) {
        Segment writableSegment$okio = writableSegment$okio(2);
        int r1 = writableSegment$okio.limit;
        int r2 = r1 + 1;
        byte[] bArr = writableSegment$okio.data;
        bArr[r1] = (byte) ((r6 >>> 8) & 255);
        bArr[r2] = (byte) (r6 & 255);
        writableSegment$okio.limit = r2 + 1;
        this.size += 2;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeUtf8(String str) {
        m1738writeUtf8(str);
        return this;
    }

    public final byte[] readByteArray(long j) throws EOFException {
        int r1 = 0;
        if (!(j >= 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("byteCount: ", j).toString());
        }
        if (this.size >= j) {
            int r5 = (int) j;
            byte[] bArr = new byte[r5];
            while (r1 < r5) {
                int read = read(bArr, r1, r5 - r1);
                if (read == -1) {
                    throw new EOFException();
                }
                r1 += read;
            }
            return bArr;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString(long j) throws EOFException {
        if (!(j >= 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("byteCount: ", j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j >= 4096) {
            ByteString snapshot = snapshot((int) j);
            skip(j);
            return snapshot;
        }
        return new ByteString(readByteArray(j));
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink write(ByteString byteString) {
        m1732write(byteString);
        return this;
    }

    /* renamed from: writeUtf8 */
    public final void m1738writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        m1737writeUtf8(0, string.length(), string);
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr, int r2, int r3) {
        m1733write(bArr, r2, r3);
        return this;
    }

    /* renamed from: writeUtf8 */
    public final void m1737writeUtf8(int r12, int r13, String string) {
        char charAt;
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(r12 >= 0)) {
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("beginIndex < 0: ", r12).toString());
        }
        if (r13 >= r12) {
            if (!(r13 <= string.length())) {
                StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("endIndex > string.length: ", r13, " > ");
                m.append(string.length());
                throw new IllegalArgumentException(m.toString().toString());
            }
            while (r12 < r13) {
                char charAt2 = string.charAt(r12);
                if (charAt2 < 128) {
                    Segment writableSegment$okio = writableSegment$okio(1);
                    int r5 = writableSegment$okio.limit - r12;
                    int min = Math.min(r13, 8192 - r5);
                    int r7 = r12 + 1;
                    byte[] bArr = writableSegment$okio.data;
                    bArr[r12 + r5] = (byte) charAt2;
                    while (true) {
                        r12 = r7;
                        if (r12 >= min || (charAt = string.charAt(r12)) >= 128) {
                            break;
                        }
                        r7 = r12 + 1;
                        bArr[r12 + r5] = (byte) charAt;
                    }
                    int r2 = writableSegment$okio.limit;
                    int r52 = (r5 + r12) - r2;
                    writableSegment$okio.limit = r2 + r52;
                    this.size += r52;
                } else {
                    if (charAt2 < 2048) {
                        Segment writableSegment$okio2 = writableSegment$okio(2);
                        int r6 = writableSegment$okio2.limit;
                        byte[] bArr2 = writableSegment$okio2.data;
                        bArr2[r6] = (byte) ((charAt2 >> 6) | 192);
                        bArr2[r6 + 1] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio2.limit = r6 + 2;
                        this.size += 2;
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int r4 = r12 + 1;
                        char charAt3 = r4 < r13 ? string.charAt(r4) : (char) 0;
                        if (charAt2 <= 56319) {
                            if (56320 <= charAt3 && charAt3 < 57344) {
                                int r22 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                Segment writableSegment$okio3 = writableSegment$okio(4);
                                int r72 = writableSegment$okio3.limit;
                                byte[] bArr3 = writableSegment$okio3.data;
                                bArr3[r72] = (byte) ((r22 >> 18) | 240);
                                bArr3[r72 + 1] = (byte) (((r22 >> 12) & 63) | 128);
                                bArr3[r72 + 2] = (byte) (((r22 >> 6) & 63) | 128);
                                bArr3[r72 + 3] = (byte) ((r22 & 63) | 128);
                                writableSegment$okio3.limit = r72 + 4;
                                this.size += 4;
                                r12 += 2;
                            }
                        }
                        m1734writeByte(63);
                        r12 = r4;
                    } else {
                        Segment writableSegment$okio4 = writableSegment$okio(3);
                        int r73 = writableSegment$okio4.limit;
                        byte[] bArr4 = writableSegment$okio4.data;
                        bArr4[r73] = (byte) ((charAt2 >> '\f') | 224);
                        bArr4[r73 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        bArr4[r73 + 2] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio4.limit = r73 + 3;
                        this.size += 3;
                    }
                    r12++;
                }
            }
            return;
        }
        throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("endIndex < beginIndex: ", r13, " < ", r12).toString());
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        int r7;
        Segment take;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source != this) {
            _UtilKt.checkOffsetAndCount(source.size, 0L, j);
            while (j > 0) {
                Segment segment = source.head;
                Intrinsics.checkNotNull(segment);
                int r2 = segment.limit;
                Intrinsics.checkNotNull(source.head);
                if (j < r2 - r3.pos) {
                    Segment segment2 = this.head;
                    Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        if ((segment3.limit + j) - (segment3.shared ? 0 : segment3.pos) <= 8192) {
                            Segment segment4 = source.head;
                            Intrinsics.checkNotNull(segment4);
                            segment4.writeTo(segment3, (int) j);
                            source.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    Intrinsics.checkNotNull(segment5);
                    int r3 = (int) j;
                    if (r3 > 0 && r3 <= segment5.limit - segment5.pos) {
                        if (r3 >= 1024) {
                            take = segment5.sharedCopy();
                        } else {
                            take = SegmentPool.take();
                            int r5 = segment5.pos;
                            ArraysKt___ArraysJvmKt.copyInto(0, segment5.data, r5, take.data, r5 + r3);
                        }
                        take.limit = take.pos + r3;
                        segment5.pos += r3;
                        Segment segment6 = segment5.prev;
                        Intrinsics.checkNotNull(segment6);
                        segment6.push(take);
                        source.head = take;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                }
                Segment segment7 = source.head;
                Intrinsics.checkNotNull(segment7);
                long j2 = segment7.limit - segment7.pos;
                source.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7);
                    Segment segment10 = segment7.prev;
                    if (segment10 != segment7) {
                        Intrinsics.checkNotNull(segment10);
                        if (segment10.owner) {
                            int r52 = segment7.limit - segment7.pos;
                            Segment segment11 = segment7.prev;
                            Intrinsics.checkNotNull(segment11);
                            int r6 = 8192 - segment11.limit;
                            Segment segment12 = segment7.prev;
                            Intrinsics.checkNotNull(segment12);
                            if (segment12.shared) {
                                r7 = 0;
                            } else {
                                Segment segment13 = segment7.prev;
                                Intrinsics.checkNotNull(segment13);
                                r7 = segment13.pos;
                            }
                            if (r52 <= r6 + r7) {
                                Segment segment14 = segment7.prev;
                                Intrinsics.checkNotNull(segment14);
                                segment7.writeTo(segment14, r52);
                                segment7.pop();
                                SegmentPool.recycle(segment7);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                }
                source.size -= j2;
                this.size += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, min);
        int r7 = segment.pos + min;
        segment.pos = r7;
        this.size -= min;
        if (r7 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final int read(byte[] sink, int r9, int r10) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        _UtilKt.checkOffsetAndCount(sink.length, r9, r10);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(r10, segment.limit - segment.pos);
        int r1 = segment.pos;
        ArraysKt___ArraysJvmKt.copyInto(r9, segment.data, r1, sink, r1 + min);
        int r8 = segment.pos + min;
        segment.pos = r8;
        this.size -= min;
        if (r8 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final long indexOf(long j, ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] bArr = bytes.data;
        if (!(bArr.length > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j2 = 0;
        if (j >= 0) {
            Segment segment = this.head;
            if (segment != null) {
                long j3 = this.size;
                if (j3 - j < j) {
                    while (j3 > j) {
                        segment = segment.prev;
                        Intrinsics.checkNotNull(segment);
                        j3 -= segment.limit - segment.pos;
                    }
                    byte b = bArr[0];
                    int length = bArr.length;
                    long j4 = (this.size - length) + 1;
                    while (j3 < j4) {
                        int min = (int) Math.min(segment.limit, (segment.pos + j4) - j3);
                        for (int r13 = (int) ((segment.pos + j) - j3); r13 < min; r13++) {
                            if (segment.data[r13] == b && _BufferKt.rangeEquals(segment, r13 + 1, bArr, length)) {
                                return (r13 - segment.pos) + j3;
                            }
                        }
                        j3 += segment.limit - segment.pos;
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j3;
                    }
                } else {
                    while (true) {
                        long j5 = (segment.limit - segment.pos) + j2;
                        if (j5 > j) {
                            break;
                        }
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j2 = j5;
                    }
                    byte b2 = bArr[0];
                    int length2 = bArr.length;
                    long j6 = (this.size - length2) + 1;
                    while (j2 < j6) {
                        int min2 = (int) Math.min(segment.limit, (segment.pos + j6) - j2);
                        for (int r132 = (int) ((segment.pos + j) - j2); r132 < min2; r132++) {
                            if (segment.data[r132] == b2 && _BufferKt.rangeEquals(segment, r132 + 1, bArr, length2)) {
                                return (r132 - segment.pos) + j2;
                            }
                        }
                        j2 += segment.limit - segment.pos;
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("fromIndex < 0: ", j).toString());
    }

    /* renamed from: write */
    public final void m1732write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, byteString.getSize$okio());
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        int remaining = source.remaining();
        int r1 = remaining;
        while (r1 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(r1, 8192 - writableSegment$okio.limit);
            source.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            r1 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSource
    public final long indexOf(ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(0L, bytes);
    }

    /* renamed from: write */
    public final void m1733write(byte[] source, int r11, int r12) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = r12;
        _UtilKt.checkOffsetAndCount(source.length, r11, j);
        int r122 = r12 + r11;
        while (r11 < r122) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(r122 - r11, 8192 - writableSegment$okio.limit);
            int r3 = r11 + min;
            ArraysKt___ArraysJvmKt.copyInto(writableSegment$okio.limit, source, r11, writableSegment$okio.data, r3);
            writableSegment$okio.limit += min;
            r11 = r3;
        }
        this.size += j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
    }

    @Override // okio.BufferedSink
    public final BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer getBuffer() {
        return this;
    }
}
