package okhttp3.internal.http2;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: Http2Stream.kt */
/* loaded from: classes4.dex */
public final class Http2Stream {
    public final Http2Connection connection;
    public ErrorCode errorCode;
    public IOException errorException;
    public boolean hasResponseHeaders;
    public final ArrayDeque<Headers> headersQueue;
    public final int id;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final StreamTimeout readTimeout;
    public final FramingSink sink;
    public final FramingSource source;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final StreamTimeout writeTimeout;

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes4.dex */
    public final class FramingSink implements Sink {
        public boolean closed;
        public final boolean finished;
        public final Buffer sendBuffer = new Buffer();

        public FramingSink(boolean z) {
            this.finished = z;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            boolean z;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            Headers headers = _UtilJvmKt.EMPTY_HEADERS;
            synchronized (http2Stream) {
                if (this.closed) {
                    return;
                }
                synchronized (http2Stream) {
                    ErrorCode errorCode = http2Stream.errorCode;
                    z = false;
                    if (errorCode == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                Http2Stream http2Stream2 = Http2Stream.this;
                if (!http2Stream2.sink.finished) {
                    if (this.sendBuffer.size > 0) {
                        z = true;
                    }
                    if (z) {
                        while (this.sendBuffer.size > 0) {
                            emitFrame(true);
                        }
                    } else if (z2) {
                        http2Stream2.connection.writeData(http2Stream2.id, true, null, 0L);
                    }
                }
                Http2Stream http2Stream3 = Http2Stream.this;
                synchronized (http2Stream3) {
                    this.closed = true;
                    http2Stream3.notifyAll();
                    Unit unit2 = Unit.INSTANCE;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        public final void emitFrame(boolean z) throws IOException {
            long min;
            boolean z2;
            boolean z3;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.writeTimeout.enter();
                while (http2Stream.writeBytesTotal >= http2Stream.writeBytesMaximum && !this.finished && !this.closed) {
                    try {
                        synchronized (http2Stream) {
                            ErrorCode errorCode = http2Stream.errorCode;
                            if (errorCode != null) {
                                break;
                            } else {
                                http2Stream.waitForIo$okhttp();
                            }
                        }
                    } finally {
                        http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                    }
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                min = Math.min(http2Stream.writeBytesMaximum - http2Stream.writeBytesTotal, this.sendBuffer.size);
                http2Stream.writeBytesTotal += min;
                if (z && min == this.sendBuffer.size) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2;
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream http2Stream2 = Http2Stream.this;
                http2Stream2.connection.writeData(http2Stream2.id, z3, this.sendBuffer, min);
            } finally {
                http2Stream = Http2Stream.this;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            Headers headers = _UtilJvmKt.EMPTY_HEADERS;
            synchronized (http2Stream) {
                http2Stream.checkOutNotClosed$okhttp();
                Unit unit = Unit.INSTANCE;
            }
            while (this.sendBuffer.size > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            Headers headers = _UtilJvmKt.EMPTY_HEADERS;
            Buffer buffer = this.sendBuffer;
            buffer.write(source, j);
            while (buffer.size >= 16384) {
                emitFrame(false);
            }
        }
    }

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes4.dex */
    public final class FramingSource implements Source {
        public boolean closed;
        public boolean finished;
        public final long maxByteCount;
        public Headers trailers;
        public final Buffer receiveBuffer = new Buffer();
        public final Buffer readBuffer = new Buffer();

        public FramingSource(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            long j;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                Buffer buffer = this.readBuffer;
                j = buffer.size;
                buffer.clear();
                Intrinsics.checkNotNull(http2Stream, "null cannot be cast to non-null type java.lang.Object");
                http2Stream.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (j > 0) {
                updateConnectionFlowControl(j);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #3 {all -> 0x001d, blocks: (B:5:0x0008, B:7:0x0010, B:9:0x0016, B:14:0x0023, B:46:0x0098, B:47:0x009d, B:76:0x00bd, B:77:0x00c2, B:16:0x0028, B:19:0x002b, B:21:0x002e, B:23:0x0032, B:25:0x0036, B:26:0x0038, B:29:0x003b, B:30:0x003c, B:33:0x0044, B:34:0x0045, B:36:0x004a, B:38:0x004e, B:40:0x005a, B:42:0x006e, B:44:0x007d, B:59:0x0089, B:62:0x008f, B:66:0x00b0, B:67:0x00b7, B:71:0x00b9, B:72:0x00ba, B:28:0x0039, B:18:0x0029), top: B:4:0x0008, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final long read(okio.Buffer r12, long r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 197
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }

        public final void updateConnectionFlowControl(long j) {
            Headers headers = _UtilJvmKt.EMPTY_HEADERS;
            Http2Stream.this.connection.updateConnectionFlowControl$okhttp(j);
        }
    }

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes4.dex */
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (!exit()) {
            } else {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public final IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public final void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            final Http2Connection http2Connection = Http2Stream.this.connection;
            synchronized (http2Connection) {
                long j = http2Connection.degradedPongsReceived;
                long j2 = http2Connection.degradedPingsSent;
                if (j >= j2) {
                    http2Connection.degradedPingsSent = j2 + 1;
                    http2Connection.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
                    Unit unit = Unit.INSTANCE;
                    TaskQueue.execute$default(http2Connection.writerQueue, ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), http2Connection.connectionName, " ping"), new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            Http2Connection http2Connection2 = Http2Connection.this;
                            http2Connection2.getClass();
                            try {
                                http2Connection2.writer.ping(2, 0, false);
                            } catch (IOException e) {
                                http2Connection2.failConnection(e);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        }
    }

    public Http2Stream(int r4, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        this.id = r4;
        this.connection = http2Connection;
        this.writeBytesMaximum = http2Connection.peerSettings.getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers != null) {
            if (!isLocallyInitiated()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        }
        if (isLocallyInitiated()) {
        } else {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z;
        boolean isOpen;
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        synchronized (this) {
            FramingSource framingSource = this.source;
            if (!framingSource.finished && framingSource.closed) {
                FramingSink framingSink = this.sink;
                if (framingSink.finished || framingSink.closed) {
                    z = true;
                    isOpen = isOpen();
                    Unit unit = Unit.INSTANCE;
                }
            }
            z = false;
            isOpen = isOpen();
            Unit unit2 = Unit.INSTANCE;
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else if (!isOpen) {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        FramingSink framingSink = this.sink;
        if (!framingSink.closed) {
            if (!framingSink.finished) {
                if (this.errorCode != null) {
                    IOException iOException = this.errorException;
                    if (iOException == null) {
                        ErrorCode errorCode = this.errorCode;
                        Intrinsics.checkNotNull(errorCode);
                        throw new StreamResetException(errorCode);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final void close(ErrorCode rstStatusCode, IOException iOException) throws IOException {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (!closeInternal(rstStatusCode, iOException)) {
            return;
        }
        Http2Connection http2Connection = this.connection;
        http2Connection.getClass();
        http2Connection.writer.rstStream(this.id, rstStatusCode);
    }

    public final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            Unit unit = Unit.INSTANCE;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void closeLater(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!closeInternal(errorCode, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.http2.Http2Stream.FramingSink getSink() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto Le
            boolean r0 = r2.isLocallyInitiated()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            if (r0 == 0) goto L17
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L23
            monitor-exit(r2)
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink
            return r0
        L17:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L23
            throw r1     // Catch: java.lang.Throwable -> L23
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.getSink():okhttp3.internal.http2.Http2Stream$FramingSink");
    }

    public final boolean isLocallyInitiated() {
        boolean z;
        if ((this.id & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.connection.client == z) {
            return true;
        }
        return false;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        FramingSource framingSource = this.source;
        if (framingSource.finished || framingSource.closed) {
            FramingSink framingSink = this.sink;
            if (framingSink.finished || framingSink.closed) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x000d, B:8:0x0015, B:11:0x001e, B:13:0x002c, B:14:0x0030, B:22:0x0023), top: B:3:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void receiveHeaders(okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            okhttp3.Headers r0 = okhttp3.internal._UtilJvmKt.EMPTY_HEADERS
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L44
            r1 = 1
            if (r0 == 0) goto L23
            java.lang.String r0 = ":status"
            java.lang.String r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto L23
            java.lang.String r0 = ":method"
            java.lang.String r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L1e
            goto L23
        L1e:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch: java.lang.Throwable -> L44
            r0.trailers = r3     // Catch: java.lang.Throwable -> L44
            goto L2a
        L23:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L44
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L44
            r0.add(r3)     // Catch: java.lang.Throwable -> L44
        L2a:
            if (r4 == 0) goto L30
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.source     // Catch: java.lang.Throwable -> L44
            r3.finished = r1     // Catch: java.lang.Throwable -> L44
        L30:
            boolean r3 = r2.isOpen()     // Catch: java.lang.Throwable -> L44
            r2.notifyAll()     // Catch: java.lang.Throwable -> L44
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L44
            monitor-exit(r2)
            if (r3 != 0) goto L43
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream$okhttp(r4)
        L43:
            return
        L44:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
