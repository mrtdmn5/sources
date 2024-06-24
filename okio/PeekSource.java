package okio;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PeekSource.kt */
/* loaded from: classes4.dex */
public final class PeekSource implements Source {
    public final Buffer buffer;
    public boolean closed;
    public int expectedPos;
    public Segment expectedSegment;
    public long pos;
    public final BufferedSource upstream;

    public PeekSource(BufferedSource upstream) {
        int r2;
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
        Buffer buffer = upstream.getBuffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        if (segment != null) {
            r2 = segment.pos;
        } else {
            r2 = -1;
        }
        this.expectedPos = r2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:            if (r10 == r1.pos) goto L12;     */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long read(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r10 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            boolean r10 = r8.closed
            r11 = 1
            r10 = r10 ^ r11
            if (r10 == 0) goto L66
            okio.Segment r10 = r8.expectedSegment
            okio.Buffer r0 = r8.buffer
            if (r10 == 0) goto L20
            okio.Segment r1 = r0.head
            if (r10 != r1) goto L1f
            int r10 = r8.expectedPos
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.pos
            if (r10 != r1) goto L1f
            goto L20
        L1f:
            r11 = 0
        L20:
            if (r11 == 0) goto L5a
            long r10 = r8.pos
            r1 = 1
            long r10 = r10 + r1
            okio.BufferedSource r1 = r8.upstream
            boolean r10 = r1.request(r10)
            if (r10 != 0) goto L32
            r9 = -1
            return r9
        L32:
            okio.Segment r10 = r8.expectedSegment
            if (r10 != 0) goto L40
            okio.Segment r10 = r0.head
            if (r10 == 0) goto L40
            r8.expectedSegment = r10
            int r10 = r10.pos
            r8.expectedPos = r10
        L40:
            long r10 = r0.size
            long r0 = r8.pos
            long r10 = r10 - r0
            r0 = 8192(0x2000, double:4.0474E-320)
            long r10 = java.lang.Math.min(r0, r10)
            okio.Buffer r2 = r8.buffer
            long r4 = r8.pos
            r3 = r9
            r6 = r10
            r2.copyTo(r3, r4, r6)
            long r0 = r8.pos
            long r0 = r0 + r10
            r8.pos = r0
            return r10
        L5a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L66:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.upstream.timeout();
    }
}
