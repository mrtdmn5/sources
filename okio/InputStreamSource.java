package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmOkio.kt */
/* loaded from: classes4.dex */
public final class InputStreamSource implements Source {
    public final InputStream input;
    public final Timeout timeout;

    public InputStreamSource(InputStream input, Timeout timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.timeout = timeout;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.input.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            this.timeout.throwIfReached();
            Segment writableSegment$okio = sink.writableSegment$okio(1);
            int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(8192L, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    sink.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return -1L;
                }
                return -1L;
            }
            writableSegment$okio.limit += read;
            long j2 = read;
            sink.size += j2;
            return j2;
        } catch (AssertionError e) {
            if (Okio.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.timeout;
    }

    public final String toString() {
        return "source(" + this.input + ')';
    }
}
