package okhttp3.internal.http1;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio.Timeout$Companion$NONE$1;

/* compiled from: Http1ExchangeCodec.kt */
/* loaded from: classes4.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    public final ExchangeCodec.Carrier carrier;
    public final OkHttpClient client;
    public final HeadersReader headersReader;
    public final BufferedSink sink;
    public final BufferedSource source;
    public int state;
    public Headers trailers;

    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes4.dex */
    public abstract class AbstractSource implements Source {
        public boolean closed;
        public final ForwardingTimeout timeout;

        public AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.source.timeout());
        }

        @Override // okio.Source
        public long read(Buffer sink, long j) {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return http1ExchangeCodec.source.read(sink, j);
            } catch (IOException e) {
                http1ExchangeCodec.carrier.noNewExchanges();
                responseBodyComplete();
                throw e;
            }
        }

        public final void responseBodyComplete() {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            int r1 = http1ExchangeCodec.state;
            if (r1 == 6) {
                return;
            }
            if (r1 == 5) {
                Http1ExchangeCodec.access$detachTimeout(http1ExchangeCodec, this.timeout);
                http1ExchangeCodec.state = 6;
            } else {
                throw new IllegalStateException("state: " + http1ExchangeCodec.state);
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.timeout;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes4.dex */
    public final class ChunkedSink implements Sink {
        public boolean closed;
        public final ForwardingTimeout timeout;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.sink.writeUtf8("0\r\n\r\n");
            Http1ExchangeCodec.access$detachTimeout(Http1ExchangeCodec.this, this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public final synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.closed) {
                if (j == 0) {
                    return;
                }
                Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
                http1ExchangeCodec.sink.writeHexadecimalUnsignedLong(j);
                http1ExchangeCodec.sink.writeUtf8("\r\n");
                http1ExchangeCodec.sink.write(source, j);
                http1ExchangeCodec.sink.writeUtf8("\r\n");
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes4.dex */
    public final class ChunkedSource extends AbstractSource {
        public long bytesRemainingInChunk;
        public boolean hasMoreChunks;
        public final /* synthetic */ Http1ExchangeCodec this$0;
        public final HttpUrl url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            super();
            Intrinsics.checkNotNullParameter(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.url = url;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !_UtilJvmKt.discard(this, TimeUnit.MILLISECONDS)) {
                this.this$0.carrier.noNewExchanges();
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public final long read(Buffer sink, long j) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            boolean z = true;
            if (!this.closed) {
                if (!this.hasMoreChunks) {
                    return -1L;
                }
                long j2 = this.bytesRemainingInChunk;
                Http1ExchangeCodec http1ExchangeCodec = this.this$0;
                if (j2 == 0 || j2 == -1) {
                    if (j2 != -1) {
                        http1ExchangeCodec.source.readUtf8LineStrict();
                    }
                    try {
                        this.bytesRemainingInChunk = http1ExchangeCodec.source.readHexadecimalUnsignedLong();
                        String obj = StringsKt__StringsKt.trim(http1ExchangeCodec.source.readUtf8LineStrict()).toString();
                        if (this.bytesRemainingInChunk >= 0) {
                            if (obj.length() <= 0) {
                                z = false;
                            }
                            if (!z || StringsKt__StringsJVMKt.startsWith(obj, ";", false)) {
                                if (this.bytesRemainingInChunk == 0) {
                                    this.hasMoreChunks = false;
                                    http1ExchangeCodec.trailers = http1ExchangeCodec.headersReader.readHeaders();
                                    OkHttpClient okHttpClient = http1ExchangeCodec.client;
                                    Intrinsics.checkNotNull(okHttpClient);
                                    Headers headers = http1ExchangeCodec.trailers;
                                    Intrinsics.checkNotNull(headers);
                                    HttpHeaders.receiveHeaders(okHttpClient.cookieJar, this.url, headers);
                                    responseBodyComplete();
                                }
                                if (!this.hasMoreChunks) {
                                    return -1L;
                                }
                            }
                        }
                        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + '\"');
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long read = super.read(sink, Math.min(8192L, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                http1ExchangeCodec.carrier.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes4.dex */
    public final class FixedLengthSource extends AbstractSource {
        public long bytesRemaining;

        public FixedLengthSource(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                responseBodyComplete();
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !_UtilJvmKt.discard(this, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.carrier.noNewExchanges();
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public final long read(Buffer sink, long j) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!this.closed) {
                long j2 = this.bytesRemaining;
                if (j2 == 0) {
                    return -1L;
                }
                long read = super.read(sink, Math.min(j2, 8192L));
                if (read != -1) {
                    long j3 = this.bytesRemaining - read;
                    this.bytesRemaining = j3;
                    if (j3 == 0) {
                        responseBodyComplete();
                    }
                    return read;
                }
                Http1ExchangeCodec.this.carrier.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes4.dex */
    public final class KnownLengthSink implements Sink {
        public boolean closed;
        public final ForwardingTimeout timeout;

        public KnownLengthSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ForwardingTimeout forwardingTimeout = this.timeout;
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            Http1ExchangeCodec.access$detachTimeout(http1ExchangeCodec, forwardingTimeout);
            http1ExchangeCodec.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.closed) {
                _UtilCommonKt.checkOffsetAndCount(source.size, 0L, j);
                Http1ExchangeCodec.this.sink.write(source, j);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes4.dex */
    public final class UnknownLengthSource extends AbstractSource {
        public boolean inputExhausted;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public final long read(Buffer sink, long j) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!this.closed) {
                if (this.inputExhausted) {
                    return -1L;
                }
                long read = super.read(sink, 8192L);
                if (read == -1) {
                    this.inputExhausted = true;
                    responseBodyComplete();
                    return -1L;
                }
                return read;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, ExchangeCodec.Carrier carrier, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter(carrier, "carrier");
        this.client = okHttpClient;
        this.carrier = carrier;
        this.source = bufferedSource;
        this.sink = bufferedSink;
        this.headersReader = new HeadersReader(bufferedSource);
    }

    public static final void access$detachTimeout(Http1ExchangeCodec http1ExchangeCodec, ForwardingTimeout forwardingTimeout) {
        http1ExchangeCodec.getClass();
        Timeout timeout = forwardingTimeout.delegate;
        Timeout$Companion$NONE$1 delegate = Timeout.NONE;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        forwardingTimeout.delegate = delegate;
        timeout.clearDeadline();
        timeout.clearTimeout();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.carrier.cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink createRequestBody(Request request, long j) {
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            requestBody.isDuplex();
        }
        boolean z = false;
        if (StringsKt__StringsJVMKt.equals("chunked", request.headers.get("Transfer-Encoding"))) {
            if (this.state == 1) {
                z = true;
            }
            if (z) {
                this.state = 2;
                return new ChunkedSink();
            }
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        if (j != -1) {
            if (this.state == 1) {
                z = true;
            }
            if (z) {
                this.state = 2;
                return new KnownLengthSink();
            }
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    public final FixedLengthSource newFixedLengthSource(long j) {
        boolean z;
        if (this.state == 4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source openResponseBodySource(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0L);
        }
        boolean z = true;
        if (StringsKt__StringsJVMKt.equals("chunked", Response.header$default(response, "Transfer-Encoding"))) {
            HttpUrl httpUrl = response.request.url;
            if (this.state != 4) {
                z = false;
            }
            if (z) {
                this.state = 5;
                return new ChunkedSource(this, httpUrl);
            }
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        long headersContentLength = _UtilJvmKt.headersContentLength(response);
        if (headersContentLength != -1) {
            return newFixedLengthSource(headersContentLength);
        }
        if (this.state != 4) {
            z = false;
        }
        if (z) {
            this.state = 5;
            this.carrier.noNewExchanges();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder readResponseHeaders(boolean z) {
        HeadersReader headersReader = this.headersReader;
        int r1 = this.state;
        boolean z2 = true;
        if (r1 != 1 && r1 != 2 && r1 != 3) {
            z2 = false;
        }
        if (z2) {
            try {
                String readUtf8LineStrict = headersReader.source.readUtf8LineStrict(headersReader.headerLimit);
                headersReader.headerLimit -= readUtf8LineStrict.length();
                StatusLine parse = StatusLine.Companion.parse(readUtf8LineStrict);
                int r3 = parse.code;
                Response.Builder builder = new Response.Builder();
                Protocol protocol = parse.protocol;
                Intrinsics.checkNotNullParameter(protocol, "protocol");
                builder.protocol = protocol;
                builder.code = r3;
                String message = parse.message;
                Intrinsics.checkNotNullParameter(message, "message");
                builder.message = message;
                builder.headers = headersReader.readHeaders().newBuilder();
                Http1ExchangeCodec$readResponseHeaders$responseBuilder$1 trailersFn = new Function0<Headers>() { // from class: okhttp3.internal.http1.Http1ExchangeCodec$readResponseHeaders$responseBuilder$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Headers invoke() {
                        throw new IllegalStateException("trailers not available".toString());
                    }
                };
                Intrinsics.checkNotNullParameter(trailersFn, "trailersFn");
                builder.trailersFn = trailersFn;
                if (z && r3 == 100) {
                    return null;
                }
                if (r3 == 100) {
                    this.state = 3;
                    return builder;
                }
                if (r3 == 103) {
                    this.state = 3;
                    return builder;
                }
                this.state = 4;
                return builder;
            } catch (EOFException e) {
                throw new IOException(ConstraintSet$$ExternalSyntheticOutline0.m("unexpected end of stream on ", this.carrier.getRoute().address.url.redact()), e);
            }
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (StringsKt__StringsJVMKt.equals("chunked", Response.header$default(response, "Transfer-Encoding"))) {
            return -1L;
        }
        return _UtilJvmKt.headersContentLength(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Headers trailers() {
        boolean z;
        if (this.state == 6) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Headers headers = this.trailers;
            if (headers == null) {
                return _UtilJvmKt.EMPTY_HEADERS;
            }
            return headers;
        }
        throw new IllegalStateException("too early; can't read the trailers yet".toString());
    }

    public final void writeRequest(Headers headers, String requestLine) {
        boolean z;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (this.state == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            BufferedSink bufferedSink = this.sink;
            bufferedSink.writeUtf8(requestLine).writeUtf8("\r\n");
            int length = headers.namesAndValues.length / 2;
            for (int r1 = 0; r1 < length; r1++) {
                bufferedSink.writeUtf8(headers.name(r1)).writeUtf8(": ").writeUtf8(headers.value(r1)).writeUtf8("\r\n");
            }
            bufferedSink.writeUtf8("\r\n");
            this.state = 1;
            return;
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void writeRequestHeaders(Request request) {
        boolean z;
        Proxy.Type type = this.carrier.getRoute().proxy.type();
        Intrinsics.checkNotNullExpressionValue(type, "carrier.route.proxy.type()");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        HttpUrl httpUrl = request.url;
        if (!httpUrl.isHttps && type == Proxy.Type.HTTP) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            sb.append(httpUrl);
        } else {
            String encodedPath = httpUrl.encodedPath();
            String encodedQuery = httpUrl.encodedQuery();
            if (encodedQuery != null) {
                encodedPath = encodedPath + '?' + encodedQuery;
            }
            sb.append(encodedPath);
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        writeRequest(request.headers, sb2);
    }
}
