package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InflaterSource.kt */
/* loaded from: classes4.dex */
public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final BufferedSource source;

    public InflaterSource(RealBufferedSource realBufferedSource, Inflater inflater) {
        this.source = realBufferedSource;
        this.inflater = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) throws IOException {
        long j2;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (!this.closed) {
            Inflater inflater = this.inflater;
            try {
                Segment writableSegment$okio = sink.writableSegment$okio(1);
                int min = (int) Math.min(8192L, 8192 - writableSegment$okio.limit);
                boolean needsInput = inflater.needsInput();
                BufferedSource bufferedSource = this.source;
                if (needsInput && !bufferedSource.exhausted()) {
                    Segment segment = bufferedSource.getBuffer().head;
                    Intrinsics.checkNotNull(segment);
                    int r3 = segment.limit;
                    int r4 = segment.pos;
                    int r32 = r3 - r4;
                    this.bufferBytesHeldByInflater = r32;
                    inflater.setInput(segment.data, r4, r32);
                }
                int inflate = inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, min);
                int r1 = this.bufferBytesHeldByInflater;
                if (r1 != 0) {
                    int remaining = r1 - inflater.getRemaining();
                    this.bufferBytesHeldByInflater -= remaining;
                    bufferedSource.skip(remaining);
                }
                if (inflate > 0) {
                    writableSegment$okio.limit += inflate;
                    j2 = inflate;
                    sink.size += j2;
                } else {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        sink.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    j2 = 0;
                }
                if (j2 > 0) {
                    return j2;
                }
                if (!inflater.finished() && !inflater.needsDictionary()) {
                    if (bufferedSource.exhausted()) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } else {
                    return -1L;
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.timeout();
    }
}
