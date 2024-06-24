package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okio.BufferedSink;
import okio.BufferedSource;

/* compiled from: ConnectInterceptor.kt */
/* loaded from: classes4.dex */
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        ExchangeCodec http1ExchangeCodec;
        RealCall realCall = realInterceptorChain.call;
        realCall.getClass();
        synchronized (realCall) {
            if (realCall.expectMoreExchanges) {
                if (!realCall.responseBodyOpen) {
                    if (!realCall.requestBodyOpen) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        ExchangeFinder exchangeFinder = realCall.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        RealConnection find = exchangeFinder.find();
        OkHttpClient client = realCall.client;
        find.getClass();
        Intrinsics.checkNotNullParameter(client, "client");
        Socket socket = find.socket;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = find.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = find.sink;
        Intrinsics.checkNotNull(bufferedSink);
        Http2Connection http2Connection = find.http2Connection;
        if (http2Connection != null) {
            http1ExchangeCodec = new Http2ExchangeCodec(client, find, realInterceptorChain, http2Connection);
        } else {
            int r8 = realInterceptorChain.readTimeoutMillis;
            socket.setSoTimeout(r8);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.timeout().timeout(r8, timeUnit);
            bufferedSink.timeout().timeout(realInterceptorChain.writeTimeoutMillis, timeUnit);
            http1ExchangeCodec = new Http1ExchangeCodec(client, find, bufferedSource, bufferedSink);
        }
        Exchange exchange = new Exchange(realCall, realCall.eventListener, exchangeFinder, http1ExchangeCodec);
        realCall.interceptorScopedExchange = exchange;
        realCall.exchange = exchange;
        synchronized (realCall) {
            realCall.requestBodyOpen = true;
            realCall.responseBodyOpen = true;
        }
        if (!realCall.canceled) {
            return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, exchange, null, 61).proceed(realInterceptorChain.request);
        }
        throw new IOException("Canceled");
    }
}
