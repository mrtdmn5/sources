package okhttp3.internal.http2;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* compiled from: Http2Reader.kt */
/* loaded from: classes4.dex */
public final class Http2Reader implements Closeable {
    public static final Logger logger;
    public final boolean client;
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final BufferedSource source;

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static int lengthWithoutPadding(int r2, int r3, int r4) throws IOException {
            if ((r3 & 8) != 0) {
                r2--;
            }
            if (r4 <= r2) {
                return r2 - r4;
            }
            throw new IOException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("PROTOCOL_ERROR padding ", r4, " > remaining length ", r2));
        }
    }

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes4.dex */
    public interface Handler {
        void ackSettings();

        void data(int r1, int r2, BufferedSource bufferedSource, boolean z) throws IOException;

        void goAway(int r1, ErrorCode errorCode, ByteString byteString);

        void headers(int r1, List list, boolean z);

        void ping(int r1, int r2, boolean z);

        void priority();

        void pushPromise(List list, int r2) throws IOException;

        void rstStream(int r1, ErrorCode errorCode);

        void settings(Settings settings);

        void windowUpdate(int r1, long j);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.source.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d5, code lost:            throw new java.io.IOException(androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0.m("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", r6));     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean nextFrame(boolean r14, okhttp3.internal.http2.Http2Reader.Handler r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 780
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.nextFrame(boolean, okhttp3.internal.http2.Http2Reader$Handler):boolean");
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString readByteString = this.source.readByteString(byteString.data.length);
        Level level = Level.FINE;
        Logger logger2 = logger;
        if (logger2.isLoggable(level)) {
            logger2.fine(_UtilJvmKt.format("<< CONNECTION " + readByteString.hex(), new Object[0]));
        }
        if (Intrinsics.areEqual(byteString, readByteString)) {
        } else {
            throw new IOException("Expected a connection header but was ".concat(readByteString.utf8()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f4, code lost:            throw new java.io.IOException("Invalid dynamic table size update " + r3.maxDynamicTableByteCount);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<okhttp3.internal.http2.Header> readHeaderBlock(int r3, int r4, int r5, int r6) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.readHeaderBlock(int, int, int, int):java.util.List");
    }

    public final void readPriority(Handler handler, int r2) throws IOException {
        BufferedSource bufferedSource = this.source;
        bufferedSource.readInt();
        bufferedSource.readByte();
        byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
        handler.priority();
    }

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes4.dex */
    public static final class ContinuationSource implements Source {
        public int flags;
        public int left;
        public int length;
        public int padding;
        public final BufferedSource source;
        public int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            int r8;
            int readInt;
            Intrinsics.checkNotNullParameter(sink, "sink");
            do {
                int r82 = this.left;
                BufferedSource bufferedSource = this.source;
                if (r82 == 0) {
                    bufferedSource.skip(this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    r8 = this.streamId;
                    int readMedium = _UtilCommonKt.readMedium(bufferedSource);
                    this.left = readMedium;
                    this.length = readMedium;
                    int readByte = bufferedSource.readByte() & 255;
                    this.flags = bufferedSource.readByte() & 255;
                    Logger logger = Http2Reader.logger;
                    if (logger.isLoggable(Level.FINE)) {
                        Http2 http2 = Http2.INSTANCE;
                        int r3 = this.streamId;
                        int r4 = this.length;
                        int r5 = this.flags;
                        http2.getClass();
                        logger.fine(Http2.frameLog(true, r3, r4, readByte, r5));
                    }
                    readInt = bufferedSource.readInt() & Integer.MAX_VALUE;
                    this.streamId = readInt;
                    if (readByte != 9) {
                        throw new IOException(readByte + " != TYPE_CONTINUATION");
                    }
                } else {
                    long read = bufferedSource.read(sink, Math.min(8192L, r82));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
            } while (readInt == r8);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.source.timeout();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
        }
    }
}
