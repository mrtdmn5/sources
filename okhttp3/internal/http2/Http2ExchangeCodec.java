package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.Http2Stream;
import okio.Sink;
import okio.Source;

/* compiled from: Http2ExchangeCodec.kt */
/* loaded from: classes4.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    public static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = _UtilJvmKt.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = _UtilJvmKt.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public volatile boolean canceled;
    public final ExchangeCodec.Carrier carrier;
    public final RealInterceptorChain chain;
    public final Http2Connection http2Connection;
    public final Protocol protocol;
    public volatile Http2Stream stream;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        this.carrier = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = okHttpClient.protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink createRequestBody(Request request, long j) {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void finishRequest() {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        http2Stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source openResponseBodySource(Response response) {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.source;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:            if (r1 == false) goto L21;     */
    @Override // okhttp3.internal.http.ExchangeCodec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response.Builder readResponseHeaders(boolean r11) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2ExchangeCodec.readResponseHeaders(boolean):okhttp3.Response$Builder");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        return _UtilJvmKt.headersContentLength(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Headers trailers() {
        Headers headers;
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        synchronized (http2Stream) {
            Http2Stream.FramingSource framingSource = http2Stream.source;
            if (framingSource.finished && framingSource.receiveBuffer.exhausted() && http2Stream.source.readBuffer.exhausted()) {
                headers = http2Stream.source.trailers;
                if (headers == null) {
                    headers = _UtilJvmKt.EMPTY_HEADERS;
                }
            } else {
                if (http2Stream.errorCode != null) {
                    IOException iOException = http2Stream.errorException;
                    if (iOException == null) {
                        ErrorCode errorCode = http2Stream.errorCode;
                        Intrinsics.checkNotNull(errorCode);
                        throw new StreamResetException(errorCode);
                    }
                    throw iOException;
                }
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
        }
        return headers;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010d A[Catch: all -> 0x01b7, TryCatch #0 {, blocks: (B:33:0x00cd, B:35:0x00d4, B:36:0x00d9, B:38:0x00dd, B:40:0x00f3, B:42:0x00fb, B:46:0x0107, B:48:0x010d, B:49:0x0116, B:91:0x01b1, B:92:0x01b6), top: B:32:0x00cd, outer: #2 }] */
    @Override // okhttp3.internal.http.ExchangeCodec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeRequestHeaders(okhttp3.Request r19) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2ExchangeCodec.writeRequestHeaders(okhttp3.Request):void");
    }
}
