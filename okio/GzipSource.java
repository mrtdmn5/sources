package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GzipSource.kt */
/* loaded from: classes4.dex */
public final class GzipSource implements Source {
    public final CRC32 crc;
    public final Inflater inflater;
    public final InflaterSource inflaterSource;
    public byte section;
    public final RealBufferedSource source;

    public GzipSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource(realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    public static void checkEqual(int r1, int r2, String str) {
        if (r2 == r1) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(r2), Integer.valueOf(r1)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        throw new IOException(format);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) throws IOException {
        RealBufferedSource realBufferedSource;
        boolean z;
        boolean z2;
        boolean z3;
        Buffer buffer;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(sink, "sink");
        byte b = this.section;
        CRC32 crc32 = this.crc;
        RealBufferedSource realBufferedSource2 = this.source;
        if (b == 0) {
            realBufferedSource2.require(10L);
            Buffer buffer2 = realBufferedSource2.bufferField;
            byte b2 = buffer2.getByte(3L);
            boolean z4 = false;
            if (((b2 >> 1) & 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                updateCrc(realBufferedSource2.bufferField, 0L, 10L);
            }
            checkEqual(8075, realBufferedSource2.readShort(), "ID1ID2");
            realBufferedSource2.skip(8L);
            if (((b2 >> 2) & 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                realBufferedSource2.require(2L);
                if (z) {
                    updateCrc(realBufferedSource2.bufferField, 0L, 2L);
                }
                int readShort = buffer2.readShort() & 65535;
                long j4 = (short) (((readShort & 255) << 8) | ((readShort & 65280) >>> 8));
                realBufferedSource2.require(j4);
                if (z) {
                    updateCrc(realBufferedSource2.bufferField, 0L, j4);
                    j3 = j4;
                } else {
                    j3 = j4;
                }
                realBufferedSource2.skip(j3);
            }
            if (((b2 >> 3) & 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                buffer = buffer2;
                long indexOf = realBufferedSource2.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (indexOf != -1) {
                    if (z) {
                        realBufferedSource = realBufferedSource2;
                        j2 = 2;
                        updateCrc(realBufferedSource2.bufferField, 0L, indexOf + 1);
                    } else {
                        realBufferedSource = realBufferedSource2;
                        j2 = 2;
                    }
                    realBufferedSource.skip(indexOf + 1);
                } else {
                    throw new EOFException();
                }
            } else {
                realBufferedSource = realBufferedSource2;
                buffer = buffer2;
                j2 = 2;
            }
            if (((b2 >> 4) & 1) == 1) {
                z4 = true;
            }
            if (z4) {
                long indexOf2 = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (indexOf2 != -1) {
                    if (z) {
                        updateCrc(realBufferedSource.bufferField, 0L, indexOf2 + 1);
                    }
                    realBufferedSource.skip(indexOf2 + 1);
                } else {
                    throw new EOFException();
                }
            }
            if (z) {
                realBufferedSource.require(2L);
                int readShort2 = buffer.readShort() & 65535;
                checkEqual((short) (((readShort2 & 255) << 8) | ((readShort2 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            this.section = (byte) 1;
        } else {
            realBufferedSource = realBufferedSource2;
        }
        if (this.section == 1) {
            long j5 = sink.size;
            long read = this.inflaterSource.read(sink, 8192L);
            if (read != -1) {
                updateCrc(sink, j5, read);
                return read;
            }
            this.section = (byte) 2;
        }
        if (this.section == 2) {
            checkEqual(realBufferedSource.readIntLe(), (int) crc32.getValue(), "CRC");
            checkEqual(realBufferedSource.readIntLe(), (int) this.inflater.getBytesWritten(), "ISIZE");
            this.section = (byte) 3;
            if (!realBufferedSource.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
            return -1L;
        }
        return -1L;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final void updateCrc(Buffer buffer, long j, long j2) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        while (true) {
            int r0 = segment.limit;
            int r1 = segment.pos;
            if (j < r0 - r1) {
                break;
            }
            j -= r0 - r1;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.limit - r6, j2);
            this.crc.update(segment.data, (int) (segment.pos + j), min);
            j2 -= min;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j = 0;
        }
    }
}
