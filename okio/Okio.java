package okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes4.dex */
public final class Okio {
    public static final RealBufferedSink buffer(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        boolean z;
        Logger logger = Okio__JvmOkioKt.logger;
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        if (message != null) {
            z = StringsKt__StringsKt.contains(message, "getsockname failed", false);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okio.AsyncTimeout$sink$1] */
    public static final AsyncTimeout$sink$1 sink(Socket socket) throws IOException {
        Logger logger = Okio__JvmOkioKt.logger;
        final SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        final OutputStreamSink outputStreamSink = new OutputStreamSink(outputStream, socketAsyncTimeout);
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                Sink sink = outputStreamSink;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.enter();
                try {
                    sink.close();
                    Unit unit = Unit.INSTANCE;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public final void flush() {
                Sink sink = outputStreamSink;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.enter();
                try {
                    sink.flush();
                    Unit unit = Unit.INSTANCE;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink
            public final Timeout timeout() {
                return socketAsyncTimeout;
            }

            public final String toString() {
                return "AsyncTimeout.sink(" + outputStreamSink + ')';
            }

            @Override // okio.Sink
            public final void write(Buffer source, long j) {
                Intrinsics.checkNotNullParameter(source, "source");
                _UtilKt.checkOffsetAndCount(source.size, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        Segment segment = source.head;
                        Intrinsics.checkNotNull(segment);
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            j2 += segment.limit - segment.pos;
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            } else {
                                segment = segment.next;
                                Intrinsics.checkNotNull(segment);
                            }
                        }
                        Sink sink = outputStreamSink;
                        AsyncTimeout asyncTimeout = socketAsyncTimeout;
                        asyncTimeout.enter();
                        try {
                            sink.write(source, j2);
                            Unit unit = Unit.INSTANCE;
                            if (!asyncTimeout.exit()) {
                                j -= j2;
                            } else {
                                throw asyncTimeout.newTimeoutException(null);
                            }
                        } catch (IOException e) {
                            if (!asyncTimeout.exit()) {
                                throw e;
                            }
                            throw asyncTimeout.newTimeoutException(e);
                        } finally {
                            asyncTimeout.exit();
                        }
                    } else {
                        return;
                    }
                }
            }
        };
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okio.AsyncTimeout$source$1] */
    public static final AsyncTimeout$source$1 source(Socket socket) throws IOException {
        Logger logger = Okio__JvmOkioKt.logger;
        final SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        final InputStreamSource inputStreamSource = new InputStreamSource(inputStream, socketAsyncTimeout);
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                Source source = inputStreamSource;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.enter();
                try {
                    source.close();
                    Unit unit = Unit.INSTANCE;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public final long read(Buffer sink, long j) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                Source source = inputStreamSource;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.enter();
                try {
                    long read = source.read(sink, 8192L);
                    if (!asyncTimeout.exit()) {
                        return read;
                    }
                    throw asyncTimeout.newTimeoutException(null);
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public final Timeout timeout() {
                return socketAsyncTimeout;
            }

            public final String toString() {
                return "AsyncTimeout.source(" + inputStreamSource + ')';
            }
        };
    }

    public static final RealBufferedSource buffer(Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new RealBufferedSource(source);
    }

    public static final InputStreamSource source(InputStream inputStream) {
        Logger logger = Okio__JvmOkioKt.logger;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }
}
