package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineBase;
import j$.time.Duration;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import org.sqlite.jdbc3.JDBC3Statement$$ExternalSyntheticLambda0;

/* compiled from: OkHttpEngine.kt */
/* loaded from: classes.dex */
public final class OkHttpEngine extends HttpClientEngineBase {
    public final OkHttpClient client;

    public OkHttpEngine(OkHttpEngineConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.followRedirects = false;
        builder.followSslRedirects = false;
        builder.retryOnConnectionFailure = true;
        Duration ofSeconds = Duration.ofSeconds(kotlin.time.Duration.m1679getInWholeSecondsimpl(config.connectTimeout), kotlin.time.Duration.m1681getNanosecondsComponentimpl(r3));
        Intrinsics.checkNotNullExpressionValue(ofSeconds, "toJavaDuration-LRDsOJo");
        long millis = ofSeconds.toMillis();
        TimeUnit unit = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(unit, "unit");
        builder.connectTimeout = _UtilJvmKt.checkDuration(millis, unit);
        Duration ofSeconds2 = Duration.ofSeconds(kotlin.time.Duration.m1679getInWholeSecondsimpl(config.socketReadTimeout), kotlin.time.Duration.m1681getNanosecondsComponentimpl(r3));
        Intrinsics.checkNotNullExpressionValue(ofSeconds2, "toJavaDuration-LRDsOJo");
        builder.readTimeout = _UtilJvmKt.checkDuration(ofSeconds2.toMillis(), unit);
        Duration ofSeconds3 = Duration.ofSeconds(kotlin.time.Duration.m1679getInWholeSecondsimpl(config.socketWriteTimeout), kotlin.time.Duration.m1681getNanosecondsComponentimpl(r3));
        Intrinsics.checkNotNullExpressionValue(ofSeconds3, "toJavaDuration-LRDsOJo");
        builder.writeTimeout = _UtilJvmKt.checkDuration(ofSeconds3.toMillis(), unit);
        ConnectionPool connectionPool = new ConnectionPool(kotlin.time.Duration.m1677getInWholeMillisecondsimpl(config.connectionIdleTimeout), unit);
        builder.connectionPool = connectionPool;
        Dispatcher dispatcher = new Dispatcher();
        int r5 = config.maxConnections;
        if (r5 >= 1) {
            synchronized (dispatcher) {
                dispatcher.maxRequests = r5;
                Unit unit2 = Unit.INSTANCE;
            }
            dispatcher.promoteAndExecute();
            int r52 = config.maxConnectionsPerHost;
            if (r52 >= 1) {
                synchronized (dispatcher) {
                    dispatcher.maxRequestsPerHost = r52;
                }
                dispatcher.promoteAndExecute();
                builder.dispatcher = dispatcher;
                builder.eventListenerFactory = new JDBC3Statement$$ExternalSyntheticLambda0(connectionPool, config);
                config.alpn.getClass();
                OkHttpProxySelector okHttpProxySelector = new OkHttpProxySelector(config.proxySelector);
                Intrinsics.areEqual(okHttpProxySelector, builder.proxySelector);
                builder.proxySelector = okHttpProxySelector;
                OkHttpProxyAuthenticator okHttpProxyAuthenticator = new OkHttpProxyAuthenticator(config.proxySelector);
                Intrinsics.areEqual(okHttpProxyAuthenticator, builder.proxyAuthenticator);
                builder.proxyAuthenticator = okHttpProxyAuthenticator;
                OkHttpDns okHttpDns = new OkHttpDns(config.hostResolver);
                Intrinsics.areEqual(okHttpDns, builder.dns);
                builder.dns = okHttpDns;
                this.client = new OkHttpClient(builder);
                return;
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("max < 1: ", r52).toString());
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("max < 1: ", r5).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object roundTrip(aws.smithy.kotlin.runtime.operation.ExecutionContext r24, aws.smithy.kotlin.runtime.http.request.HttpRequest r25, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.http.response.HttpCall> r26) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine.roundTrip(aws.smithy.kotlin.runtime.operation.ExecutionContext, aws.smithy.kotlin.runtime.http.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineBase
    public final void shutdown() {
        Socket socket;
        RealConnectionPool realConnectionPool = this.client.connectionPool.delegate;
        Iterator<RealConnection> it = realConnectionPool.connections.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection connection = it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (connection.calls.isEmpty()) {
                    it.remove();
                    connection.noNewExchanges = true;
                    socket = connection.socket;
                    Intrinsics.checkNotNull(socket);
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
            }
        }
        if (realConnectionPool.connections.isEmpty()) {
            realConnectionPool.cleanupQueue.cancelAll();
        }
        ((ThreadPoolExecutor) this.client.dispatcher.executorService()).shutdown();
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine() {
        this(OkHttpEngineConfig.Default);
        OkHttpEngineConfig okHttpEngineConfig = OkHttpEngineConfig.Default;
    }
}
