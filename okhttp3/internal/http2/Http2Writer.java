package okhttp3.internal.http2;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: Http2Writer.kt */
/* loaded from: classes4.dex */
public final class Http2Writer implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public final boolean client;
    public boolean closed;
    public final Buffer hpackBuffer;
    public final Hpack.Writer hpackWriter;
    public int maxFrameSize;
    public final BufferedSink sink;

    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.sink = bufferedSink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = DfuBaseService.ERROR_CONNECTION_MASK;
        this.hpackWriter = new Hpack.Writer(buffer);
    }

    public final synchronized void applyAndAckSettings(Settings peerSettings) throws IOException {
        int r0;
        int r6;
        Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
        if (!this.closed) {
            int r02 = this.maxFrameSize;
            int r1 = peerSettings.set;
            if ((r1 & 32) != 0) {
                r02 = peerSettings.values[5];
            }
            this.maxFrameSize = r02;
            if ((r1 & 2) != 0) {
                r0 = peerSettings.values[1];
            } else {
                r0 = -1;
            }
            if (r0 != -1) {
                Hpack.Writer writer = this.hpackWriter;
                if ((r1 & 2) != 0) {
                    r6 = peerSettings.values[1];
                } else {
                    r6 = -1;
                }
                writer.getClass();
                int min = Math.min(r6, DfuBaseService.ERROR_CONNECTION_MASK);
                int r12 = writer.maxDynamicTableByteCount;
                if (r12 != min) {
                    if (min < r12) {
                        writer.smallestHeaderTableSizeSetting = Math.min(writer.smallestHeaderTableSizeSetting, min);
                    }
                    writer.emitDynamicTableSizeUpdate = true;
                    writer.maxDynamicTableByteCount = min;
                    int r13 = writer.dynamicTableByteCount;
                    if (min < r13) {
                        if (min == 0) {
                            ArraysKt___ArraysJvmKt.fill$default(writer.dynamicTable, null);
                            writer.nextHeaderIndex = writer.dynamicTable.length - 1;
                            writer.headerCount = 0;
                            writer.dynamicTableByteCount = 0;
                        } else {
                            writer.evictToRecoverBytes(r13 - min);
                        }
                    }
                }
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void data(boolean z, int r3, Buffer buffer, int r5) throws IOException {
        if (!this.closed) {
            frameHeader(r3, r5, 0, z ? 1 : 0);
            if (r5 > 0) {
                Intrinsics.checkNotNull(buffer);
                this.sink.write(buffer, r5);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void frameHeader(int r4, int r5, int r6, int r7) throws IOException {
        boolean z;
        boolean z2 = false;
        if (r6 != 8) {
            Level level = Level.FINE;
            Logger logger2 = logger;
            if (logger2.isLoggable(level)) {
                Http2.INSTANCE.getClass();
                logger2.fine(Http2.frameLog(false, r4, r5, r6, r7));
            }
        }
        if (r5 <= this.maxFrameSize) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if ((Integer.MIN_VALUE & r4) == 0) {
                z2 = true;
            }
            if (z2) {
                byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                BufferedSink bufferedSink = this.sink;
                Intrinsics.checkNotNullParameter(bufferedSink, "<this>");
                bufferedSink.writeByte((r5 >>> 16) & 255);
                bufferedSink.writeByte((r5 >>> 8) & 255);
                bufferedSink.writeByte(r5 & 255);
                bufferedSink.writeByte(r6 & 255);
                bufferedSink.writeByte(r7 & 255);
                bufferedSink.writeInt(r4 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("reserved bit set: ", r4).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + r5).toString());
    }

    public final synchronized void goAway(int r5, ErrorCode errorCode, byte[] bArr) throws IOException {
        boolean z;
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!this.closed) {
            boolean z2 = false;
            if (errorCode.getHttpCode() != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                frameHeader(0, bArr.length + 8, 7, 0);
                this.sink.writeInt(r5);
                this.sink.writeInt(errorCode.getHttpCode());
                if (bArr.length == 0) {
                    z2 = true;
                }
                if (!z2) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void ping(int r4, int r5, boolean z) throws IOException {
        int r6;
        if (!this.closed) {
            if (z) {
                r6 = 1;
            } else {
                r6 = 0;
            }
            frameHeader(0, 8, 6, r6);
            this.sink.writeInt(r4);
            this.sink.writeInt(r5);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int r4, ErrorCode errorCode) throws IOException {
        boolean z;
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                frameHeader(r4, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void windowUpdate(int r6, long j) throws IOException {
        boolean z;
        if (!this.closed) {
            if (j != 0 && j <= 2147483647L) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    Http2.INSTANCE.getClass();
                    logger2.fine(Http2.frameLogWindowUpdate(false, r6, 4, j));
                }
                frameHeader(r6, 4, 8, 0);
                this.sink.writeInt((int) j);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void writeContinuationFrames(int r6, long j) throws IOException {
        int r0;
        while (j > 0) {
            long min = Math.min(this.maxFrameSize, j);
            j -= min;
            int r4 = (int) min;
            if (j == 0) {
                r0 = 4;
            } else {
                r0 = 0;
            }
            frameHeader(r6, r4, 9, r0);
            this.sink.write(this.hpackBuffer, min);
        }
    }
}
