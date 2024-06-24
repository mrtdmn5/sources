package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.net.DefaultHostResolver;
import aws.smithy.kotlin.runtime.net.HostResolver;
import aws.smithy.kotlin.runtime.tracing.EventLevel;
import aws.smithy.kotlin.runtime.tracing.NoOpTraceSpanKt;
import aws.smithy.kotlin.runtime.tracing.TraceSpan;
import aws.smithy.kotlin.runtime.tracing.TraceSpanLogger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.CookieJar$Companion$NoCookies;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;

/* compiled from: HttpEngineEventListener.kt */
/* loaded from: classes.dex */
public final class HttpEngineEventListener extends EventListener {
    public final HostResolver hr;
    public final TraceSpanLogger logger;
    public final ConnectionPool pool;
    public final TraceSpan traceSpan;

    public HttpEngineEventListener(ConnectionPool connectionPool, DefaultHostResolver hr, Call call) {
        TraceSpan traceSpan;
        Intrinsics.checkNotNullParameter(hr, "hr");
        Intrinsics.checkNotNullParameter(call, "call");
        this.pool = connectionPool;
        this.hr = hr;
        Request request = call.request();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SdkRequestTag.class);
        request.getClass();
        SdkRequestTag sdkRequestTag = (SdkRequestTag) JvmClassMappingKt.getJavaClass(orCreateKotlinClass).cast(request.tags.get(orCreateKotlinClass));
        TraceSpan traceSpan2 = (sdkRequestTag == null || (traceSpan = sdkRequestTag.traceSpan) == null || (traceSpan2 = traceSpan.child("HTTP")) == null) ? NoOpTraceSpanKt.NoOpTraceSpan : traceSpan2;
        this.traceSpan = traceSpan2;
        String qualifiedName = Reflection.getOrCreateKotlinClass(HttpEngineEventListener.class).getQualifiedName();
        if (qualifiedName != null) {
            Intrinsics.checkNotNullParameter(traceSpan2, "<this>");
            this.logger = new TraceSpanLogger(traceSpan2, qualifiedName);
            return;
        }
        throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
    }

    @Override // okhttp3.EventListener
    public final void cacheConditionalHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$cacheConditionalHit$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "cache conditional hit";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void cacheHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$cacheHit$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "cache hit";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$callEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "call complete";
            }
        });
        this.traceSpan.close();
    }

    @Override // okhttp3.EventListener
    public final void callFailed(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Function0<? extends Object> function0 = new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$callFailed$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "call failed";
            }
        };
        TraceSpanLogger traceSpanLogger = this.logger;
        traceSpanLogger.getClass();
        traceSpanLogger.log(EventLevel.Trace, iOException, function0);
        this.traceSpan.close();
    }

    @Override // okhttp3.EventListener
    public final void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$callStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "call started";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void canceled(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$canceled$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "call cancelled";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void connectEnd(RealCall call, final InetSocketAddress inetSocketAddress, final Proxy proxy, final Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectEnd$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "connection established: addr=" + inetSocketAddress + "; proxy=" + proxy + "; protocol=" + protocol;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void connectFailed(RealCall call, final InetSocketAddress inetSocketAddress, final Proxy proxy, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Function0<? extends Object> function0 = new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectFailed$$inlined$trace$1
            public final /* synthetic */ Protocol $protocol$inlined = null;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "connect failed: addr=" + inetSocketAddress + "; proxy=" + proxy + "; protocol=" + this.$protocol$inlined;
            }
        };
        TraceSpanLogger traceSpanLogger = this.logger;
        traceSpanLogger.getClass();
        traceSpanLogger.log(EventLevel.Trace, iOException, function0);
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "inetSocketAddress.address");
        this.hr.reportFailure(CookieJar$Companion$NoCookies.toHostAddress(address));
    }

    @Override // okhttp3.EventListener
    public final void connectStart(RealCall call, final InetSocketAddress inetSocketAddress, final Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectStart$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "starting connection: addr=" + inetSocketAddress + "; proxy=" + proxy;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void connectionAcquired(RealCall call, final RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(call, "call");
        final int identityHashCode = System.identityHashCode(realConnection);
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectionAcquired$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StringBuilder sb = new StringBuilder("connection acquired: conn(id=");
                sb.append(identityHashCode);
                sb.append(")=");
                sb.append(realConnection);
                sb.append("; connPool: total=");
                HttpEngineEventListener httpEngineEventListener = this;
                sb.append(httpEngineEventListener.pool.delegate.connections.size());
                sb.append(", idle=");
                sb.append(httpEngineEventListener.pool.idleConnectionCount());
                return sb.toString();
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void connectionReleased(Call call, final RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(call, "call");
        final int identityHashCode = System.identityHashCode(realConnection);
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectionReleased$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StringBuilder sb = new StringBuilder("connection released: conn(id=");
                sb.append(identityHashCode);
                sb.append(")=");
                sb.append(realConnection);
                sb.append("; connPool: total=");
                HttpEngineEventListener httpEngineEventListener = this;
                sb.append(httpEngineEventListener.pool.delegate.connections.size());
                sb.append(", idle=");
                sb.append(httpEngineEventListener.pool.idleConnectionCount());
                return sb.toString();
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void dnsEnd(Call call, final String str, final List<? extends InetAddress> list) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$dnsEnd$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "dns resolved: domain=" + str + "; records=" + list;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void dnsStart(Call call, final String str) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$dnsStart$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "dns query: domain=" + str;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void proxySelectEnd(Call call, final HttpUrl url, final List<? extends Proxy> list) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$proxySelectEnd$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "proxy select end: url=" + HttpUrl.this + "; proxies=" + list;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void proxySelectStart(Call call, final HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$proxySelectStart$$inlined$trace$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "proxy select start: url=" + HttpUrl.this;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void requestBodyEnd(RealCall call, final long j) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestBodyEnd$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "finished sending request body: bytesSent=" + j;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void requestBodyStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestBodyStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "sending request body";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void requestFailed(RealCall call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        Function0<? extends Object> function0 = new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestFailed$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "request failed";
            }
        };
        TraceSpanLogger traceSpanLogger = this.logger;
        traceSpanLogger.getClass();
        traceSpanLogger.log(EventLevel.Trace, ioe, function0);
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersEnd(RealCall call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestHeadersEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "finished sending request headers";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestHeadersStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "sending request headers";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void responseBodyEnd(RealCall call, final long j) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseBodyEnd$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "response body finished: bytesConsumed=" + j;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void responseBodyStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseBodyStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "response body available";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void responseFailed(RealCall call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        Function0<? extends Object> function0 = new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseFailed$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "response failed";
            }
        };
        TraceSpanLogger traceSpanLogger = this.logger;
        traceSpanLogger.getClass();
        traceSpanLogger.log(EventLevel.Trace, ioe, function0);
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersEnd(RealCall call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        final long contentLength = response.body.contentLength();
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseHeadersEnd$$inlined$trace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "response headers end: contentLengthHeader=" + contentLength;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseHeadersStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "response headers start";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void satisfactionFailure(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$satisfactionFailure$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "cache satisfaction failure";
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void secureConnectEnd(RealCall call, final Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$secureConnectEnd$$inlined$trace$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "TLS connect end: handshake=" + Handshake.this;
            }
        });
    }

    @Override // okhttp3.EventListener
    public final void secureConnectStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.logger.trace(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$secureConnectStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "initiating TLS connection";
            }
        });
    }
}
