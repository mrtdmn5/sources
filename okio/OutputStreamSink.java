package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmOkio.kt */
/* loaded from: classes4.dex */
public final class OutputStreamSink implements Sink {
    public final OutputStream out;
    public final Timeout timeout;

    public OutputStreamSink(OutputStream outputStream, SocketAsyncTimeout socketAsyncTimeout) {
        this.out = outputStream;
        this.timeout = socketAsyncTimeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        this.out.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.timeout;
    }

    public final String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        _UtilKt.checkOffsetAndCount(source.size, 0L, j);
        while (j > 0) {
            this.timeout.throwIfReached();
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j, segment.limit - segment.pos);
            this.out.write(segment.data, segment.pos, min);
            int r2 = segment.pos + min;
            segment.pos = r2;
            long j2 = min;
            j -= j2;
            source.size -= j2;
            if (r2 == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
