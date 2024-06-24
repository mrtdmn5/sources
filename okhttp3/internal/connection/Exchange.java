package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* compiled from: Exchange.kt */
/* loaded from: classes4.dex */
public final class Exchange {
    public final RealCall call;
    public final ExchangeCodec codec;
    public final EventListener eventListener;
    public final ExchangeFinder finder;
    public boolean hasFailure;
    public boolean isDuplex;

    /* compiled from: Exchange.kt */
    /* loaded from: classes4.dex */
    public final class RequestBodySink extends ForwardingSink {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, e);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.closed) {
                long j2 = this.contentLength;
                if (j2 != -1 && this.bytesReceived + j > j2) {
                    throw new ProtocolException("expected " + j2 + " bytes but received " + (this.bytesReceived + j));
                }
                try {
                    this.delegate.write(source, j);
                    this.bytesReceived += j;
                    return;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    /* compiled from: Exchange.kt */
    /* loaded from: classes4.dex */
    public final class ResponseBodySource extends ForwardingSource {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public boolean invokeStartEvent;
        public final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
            this.invokeStartEvent = true;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            if (e == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                Exchange exchange = this.this$0;
                exchange.eventListener.responseBodyStart(exchange.call);
            }
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, e);
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!this.closed) {
                try {
                    long read = this.delegate.read(sink, 8192L);
                    if (this.invokeStartEvent) {
                        this.invokeStartEvent = false;
                        Exchange exchange = this.this$0;
                        exchange.eventListener.responseBodyStart(exchange.call);
                    }
                    if (read == -1) {
                        complete(null);
                        return -1L;
                    }
                    long j2 = this.bytesReceived + read;
                    long j3 = this.contentLength;
                    if (j3 != -1 && j2 > j3) {
                        throw new ProtocolException("expected " + j3 + " bytes but received " + j2);
                    }
                    this.bytesReceived = j2;
                    if (j2 == j3) {
                        complete(null);
                    }
                    return read;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.call = realCall;
        this.eventListener = eventListener;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
    }

    public final <E extends IOException> E bodyComplete(long j, boolean z, boolean z2, E e) {
        if (e != null) {
            trackFailure(e);
        }
        EventListener eventListener = this.eventListener;
        RealCall realCall = this.call;
        if (z2) {
            if (e != null) {
                eventListener.requestFailed(realCall, e);
            } else {
                eventListener.requestBodyEnd(realCall, j);
            }
        }
        if (z) {
            if (e != null) {
                eventListener.responseFailed(realCall, e);
            } else {
                eventListener.responseBodyEnd(realCall, j);
            }
        }
        return (E) realCall.messageDone$okhttp(this, z2, z, e);
    }

    public final RequestBodySink createRequestBody(Request request, boolean z) throws IOException {
        this.isDuplex = z;
        RequestBody requestBody = request.body;
        Intrinsics.checkNotNull(requestBody);
        long contentLength = requestBody.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public final RealConnection getConnection$okhttp() {
        RealConnection realConnection;
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        if (carrier instanceof RealConnection) {
            realConnection = (RealConnection) carrier;
        } else {
            realConnection = null;
        }
        if (realConnection != null) {
            return realConnection;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels".toString());
    }

    public final RealResponseBody openResponseBody(Response response) throws IOException {
        ExchangeCodec exchangeCodec = this.codec;
        try {
            String header$default = Response.header$default(response, "Content-Type");
            long reportedContentLength = exchangeCodec.reportedContentLength(response);
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer(new ResponseBodySource(this, exchangeCodec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                readResponseHeaders.exchange = this;
                readResponseHeaders.trailersFn = new Function0<Headers>() { // from class: okhttp3.Response$Builder$initExchange$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Headers invoke() {
                        return Exchange.this.codec.trailers();
                    }
                };
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.codec.getCarrier().trackFailure(this.call, iOException);
    }
}
