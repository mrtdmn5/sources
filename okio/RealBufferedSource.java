package okio;

import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._BufferKt;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes4.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    @Override // okio.BufferedSource
    public final boolean exhausted() {
        if (!this.closed) {
            Buffer buffer = this.bufferField;
            if (buffer.exhausted() && this.source.read(buffer, 8192L) == -1) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer getBuffer() {
        return this.bufferField;
    }

    public final long indexOf(byte b, long j, long j2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long j3 = 0;
        if (!(0 <= j2)) {
            throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("fromIndex=0 toIndex=", j2).toString());
        }
        while (j3 < j2) {
            long indexOf = this.bufferField.indexOf(b, j3, j2);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.bufferField;
            long j4 = buffer.size;
            if (j4 >= j2 || this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j3 = Math.max(j3, j4);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public final long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (!this.closed) {
            long j = 0;
            while (true) {
                Buffer buffer = this.bufferField;
                long indexOfElement = buffer.indexOfElement(j, targetBytes);
                if (indexOfElement == -1) {
                    long j2 = buffer.size;
                    if (this.source.read(buffer, 8192L) == -1) {
                        return -1L;
                    }
                    j = Math.max(j, j2);
                } else {
                    return indexOfElement;
                }
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    public final RealBufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public final boolean rangeEquals(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] bArr = bytes.data;
        int length = bArr.length;
        if (!this.closed) {
            if (length >= 0 && bArr.length - 0 >= length) {
                for (int r3 = 0; r3 < length; r3++) {
                    long j = r3 + 0;
                    if (request(1 + j) && this.bufferField.getByte(j) == bArr[0 + r3]) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Buffer buffer = this.bufferField;
        if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
            return -1;
        }
        return buffer.read(sink);
    }

    @Override // okio.BufferedSource
    public final long readAll(Buffer buffer) {
        Buffer buffer2;
        long j = 0;
        while (true) {
            Source source = this.source;
            buffer2 = this.bufferField;
            if (source.read(buffer2, 8192L) == -1) {
                break;
            }
            long completeSegmentByteCount = buffer2.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                buffer.write(buffer2, completeSegmentByteCount);
            }
        }
        long j2 = buffer2.size;
        if (j2 > 0) {
            long j3 = j + j2;
            buffer.write(buffer2, j2);
            return j3;
        }
        return j;
    }

    @Override // okio.BufferedSource
    public final byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    public final byte[] readByteArray() {
        Source source = this.source;
        Buffer buffer = this.bufferField;
        buffer.writeAll(source);
        return buffer.readByteArray();
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString(long j) {
        require(j);
        return this.bufferField.readByteString(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:            if (r0 == 0) goto L52;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:            kotlin.text.CharsKt__CharKt.checkRadix(16);        kotlin.text.CharsKt__CharKt.checkRadix(16);        r1 = java.lang.Integer.toString(r2, 16);        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "toString(this, checkRadix(radix))");     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:            throw new java.lang.NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(r1));     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long readHexadecimalUnsignedLong() {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r6.request(r2)
            okio.Buffer r3 = r6.bufferField
            if (r2 == 0) goto L51
            long r4 = (long) r0
            byte r2 = r3.getByte(r4)
            r4 = 48
            if (r2 < r4) goto L1e
            r4 = 57
            if (r2 <= r4) goto L2f
        L1e:
            r4 = 97
            if (r2 < r4) goto L26
            r4 = 102(0x66, float:1.43E-43)
            if (r2 <= r4) goto L2f
        L26:
            r4 = 65
            if (r2 < r4) goto L31
            r4 = 70
            if (r2 <= r4) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L51
        L34:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            kotlin.text.CharsKt__CharKt.checkRadix(r1)
            kotlin.text.CharsKt__CharKt.checkRadix(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L51:
            long r0 = r3.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public final int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    public final int readIntLe() {
        require(4L);
        int readInt = this.bufferField.readInt();
        return ((readInt & 255) << 24) | (((-16777216) & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    @Override // okio.BufferedSource
    public final short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final boolean request(long j) {
        boolean z;
        Buffer buffer;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            do {
                buffer = this.bufferField;
                if (buffer.size >= j) {
                    return true;
                }
            } while (this.source.read(buffer, 8192L) != -1);
            return false;
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("byteCount < 0: ", j).toString());
    }

    @Override // okio.BufferedSource
    public final void require(long j) {
        if (request(j)) {
        } else {
            throw new EOFException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:            return -1;     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int select(okio.Options r8) {
        /*
            r7 = this;
            java.lang.String r0 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r7.closed
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L36
        Lb:
            okio.Buffer r0 = r7.bufferField
            int r2 = okio.internal._BufferKt.selectPrefix(r0, r8, r1)
            r3 = -2
            r4 = -1
            if (r2 == r3) goto L26
            if (r2 == r4) goto L24
            okio.ByteString[] r8 = r8.byteStrings
            r8 = r8[r2]
            int r8 = r8.getSize$okio()
            long r3 = (long) r8
            r0.skip(r3)
            goto L35
        L24:
            r2 = r4
            goto L35
        L26:
            okio.Source r2 = r7.source
            r5 = 8192(0x2000, double:4.0474E-320)
            long r2 = r2.read(r0, r5)
            r5 = -1
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 != 0) goto Lb
            goto L24
        L35:
            return r2
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "closed"
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.select(okio.Options):int");
    }

    @Override // okio.BufferedSource
    public final void skip(long j) {
        if (!this.closed) {
            while (j > 0) {
                Buffer buffer = this.bufferField;
                if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, buffer.size);
                buffer.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long indexOf = indexOf((byte) 10, 0L, j2);
            Buffer buffer = this.bufferField;
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(buffer, indexOf);
            }
            if (j2 < Long.MAX_VALUE && request(j2) && buffer.getByte(j2 - 1) == 13 && request(1 + j2) && buffer.getByte(j2) == 10) {
                return _BufferKt.readUtf8Line(buffer, j2);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size, j) + " content=" + buffer2.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("limit < 0: ", j).toString());
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j >= 0) {
            if (!this.closed) {
                Buffer buffer = this.bufferField;
                if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
                    return -1L;
                }
                return buffer.read(sink, Math.min(j, buffer.size));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("byteCount < 0: ", j).toString());
    }

    @Override // okio.BufferedSource
    public final long indexOf(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long j = 0;
        while (true) {
            Buffer buffer = this.bufferField;
            long indexOf = buffer.indexOf(j, bytes);
            if (indexOf != -1) {
                return indexOf;
            }
            long j2 = buffer.size;
            if (this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - bytes.data.length) + 1);
        }
    }
}
