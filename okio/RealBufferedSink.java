package okio;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RealBufferedSink.kt */
/* loaded from: classes4.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Sink sink = this.sink;
        if (!this.closed) {
            try {
                Buffer buffer = this.bufferField;
                long j = buffer.size;
                if (j > 0) {
                    sink.write(buffer, j);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                sink.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @Override // okio.BufferedSink
    public final BufferedSink emit() {
        if (!this.closed) {
            Buffer buffer = this.bufferField;
            long j = buffer.size;
            if (j > 0) {
                this.sink.write(buffer, j);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            Buffer buffer = this.bufferField;
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(buffer, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if (!this.closed) {
            Buffer buffer = this.bufferField;
            long j = buffer.size;
            Sink sink = this.sink;
            if (j > 0) {
                sink.write(buffer, j);
            }
            sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.sink.timeout();
    }

    public final String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.closed) {
            int write = this.bufferField.write(source);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final long writeAll(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this.bufferField, 8192L);
            if (read != -1) {
                j += read;
                emitCompleteSegments();
            } else {
                return j;
            }
        }
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeByte(int r2) {
        if (!this.closed) {
            this.bufferField.m1734writeByte(r2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(j);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeInt(int r2) {
        if (!this.closed) {
            this.bufferField.m1735writeInt(r2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeShort(int r2) {
        if (!this.closed) {
            this.bufferField.m1736writeShort(r2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (!this.closed) {
            this.bufferField.m1738writeUtf8(string);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(int r2, int r3, String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (!this.closed) {
            this.bufferField.m1737writeUtf8(r2, r3, string);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.m1732write(byteString);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.closed) {
            Buffer buffer = this.bufferField;
            buffer.getClass();
            buffer.m1733write(source, 0, source.length);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] source, int r3, int r4) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.closed) {
            this.bufferField.m1733write(source, r3, r4);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}
