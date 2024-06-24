package okhttp3.internal.connection;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.Headers;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.ByteString;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Timeout;

/* compiled from: ConnectPlan.kt */
/* loaded from: classes4.dex */
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {
    public final int attempt;
    public final RealCall call;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final int connectionSpecIndex;
    public final EventListener eventListener;
    public Handshake handshake;
    public final boolean isTlsFallback;
    public Protocol protocol;
    public Socket rawSocket;
    public final Route route;
    public final RealRoutePlanner routePlanner;
    public final List<Route> routes;
    public RealBufferedSink sink;
    public Socket socket;
    public RealBufferedSource source;
    public final Request tunnelRequest;

    /* compiled from: ConnectPlan.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            r0[Proxy.Type.DIRECT.ordinal()] = 1;
            r0[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ConnectPlan(OkHttpClient client, RealCall call, RealRoutePlanner routePlanner, Route route, List<Route> list, int r7, Request request, int r9, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(route, "route");
        this.client = client;
        this.call = call;
        this.routePlanner = routePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = r7;
        this.tunnelRequest = request;
        this.connectionSpecIndex = r9;
        this.isTlsFallback = z;
        this.eventListener = call.eventListener;
    }

    public static ConnectPlan copy$default(ConnectPlan connectPlan, int r11, Request request, int r13, boolean z, int r15) {
        if ((r15 & 1) != 0) {
            r11 = connectPlan.attempt;
        }
        int r6 = r11;
        if ((r15 & 2) != 0) {
            request = connectPlan.tunnelRequest;
        }
        Request request2 = request;
        if ((r15 & 4) != 0) {
            r13 = connectPlan.connectionSpecIndex;
        }
        int r8 = r13;
        if ((r15 & 8) != 0) {
            z = connectPlan.isTlsFallback;
        }
        return new ConnectPlan(connectPlan.client, connectPlan.call, connectPlan.routePlanner, connectPlan.route, connectPlan.routes, r6, request2, r8, z);
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    public final void cancel() {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    public final void connectSocket() throws IOException {
        int r0;
        Socket createSocket;
        Proxy.Type type = this.route.proxy.type();
        if (type == null) {
            r0 = -1;
        } else {
            r0 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (r0 != 1 && r0 != 2) {
            createSocket = new Socket(this.route.proxy);
        } else {
            createSocket = this.route.address.socketFactory.createSocket();
            Intrinsics.checkNotNull(createSocket);
        }
        this.rawSocket = createSocket;
        if (!this.canceled) {
            createSocket.setSoTimeout(this.client.readTimeoutMillis);
            try {
                Platform platform = Platform.platform;
                Platform.platform.connectSocket(createSocket, this.route.socketAddress, this.client.connectTimeoutMillis);
                try {
                    this.source = Okio.buffer(Okio.source(createSocket));
                    this.sink = Okio.buffer(Okio.sink(createSocket));
                    return;
                } catch (NullPointerException e) {
                    if (!Intrinsics.areEqual(e.getMessage(), "throw with null exception")) {
                        return;
                    } else {
                        throw new IOException(e);
                    }
                }
            } catch (ConnectException e2) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress);
                connectException.initCause(e2);
                throw connectException;
            }
        }
        throw new IOException("canceled");
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.ConnectResult connectTcp() {
        boolean z;
        IOException e;
        Socket socket;
        Socket socket2;
        EventListener eventListener = this.eventListener;
        Route route = this.route;
        boolean z2 = true;
        boolean z3 = false;
        if (this.rawSocket == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            RealCall realCall = this.call;
            CopyOnWriteArrayList<RoutePlanner.Plan> copyOnWriteArrayList = realCall.plansToCancel;
            CopyOnWriteArrayList<RoutePlanner.Plan> copyOnWriteArrayList2 = realCall.plansToCancel;
            copyOnWriteArrayList.add(this);
            try {
                eventListener.connectStart(realCall, route.socketAddress, route.proxy);
                connectSocket();
            } catch (IOException e2) {
                e = e2;
                z2 = false;
            } catch (Throwable th) {
                th = th;
                copyOnWriteArrayList2.remove(this);
                if (!z3) {
                    _UtilJvmKt.closeQuietly(socket);
                }
                throw th;
            }
            try {
                try {
                    RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, null, null, 6);
                    copyOnWriteArrayList2.remove(this);
                    return connectResult;
                } catch (Throwable th2) {
                    th = th2;
                    z3 = z2;
                    copyOnWriteArrayList2.remove(this);
                    if (!z3 && (socket = this.rawSocket) != null) {
                        _UtilJvmKt.closeQuietly(socket);
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                eventListener.connectFailed(realCall, route.socketAddress, route.proxy, e);
                RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, null, e, 2);
                copyOnWriteArrayList2.remove(this);
                if (!z2 && (socket2 = this.rawSocket) != null) {
                    _UtilJvmKt.closeQuietly(socket2);
                }
                return connectResult2;
            }
        }
        throw new IllegalStateException("TCP already connected".toString());
    }

    public final void connectTls(SSLSocket sSLSocket, ConnectionSpec connectionSpec) throws IOException {
        String str;
        Protocol protocol;
        String trimMargin;
        final Address address = this.route.address;
        try {
            if (connectionSpec.supportsTlsExtensions) {
                Platform platform = Platform.platform;
                Platform.platform.configureTlsExtensions(sSLSocket, address.url.host, address.protocols);
            }
            sSLSocket.startHandshake();
            SSLSession sslSocketSession = sSLSocket.getSession();
            Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
            final Handshake handshake = Handshake.Companion.get(sslSocketSession);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier;
            Intrinsics.checkNotNull(hostnameVerifier);
            if (!hostnameVerifier.verify(address.url.host, sslSocketSession)) {
                List<Certificate> peerCertificates = handshake.peerCertificates();
                if (!peerCertificates.isEmpty()) {
                    Certificate certificate = peerCertificates.get(0);
                    Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    StringBuilder sb = new StringBuilder("\n            |Hostname ");
                    sb.append(address.url.host);
                    sb.append(" not verified:\n            |    certificate: ");
                    CertificatePinner certificatePinner = CertificatePinner.DEFAULT;
                    StringBuilder sb2 = new StringBuilder("sha256/");
                    ByteString byteString = ByteString.EMPTY;
                    byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                    Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
                    sb2.append(ByteString.Companion.of$default(encoded).digest$okio("SHA-256").base64());
                    sb.append(sb2.toString());
                    sb.append("\n            |    DN: ");
                    sb.append(x509Certificate.getSubjectDN().getName());
                    sb.append("\n            |    subjectAltNames: ");
                    sb.append(CollectionsKt___CollectionsKt.plus((Iterable) OkHostnameVerifier.getSubjectAltNames(x509Certificate, 2), (Collection) OkHostnameVerifier.getSubjectAltNames(x509Certificate, 7)));
                    sb.append("\n            ");
                    trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
                    throw new SSLPeerUnverifiedException(trimMargin);
                }
                throw new SSLPeerUnverifiedException("Hostname " + address.url.host + " not verified (no certificates)");
            }
            final CertificatePinner certificatePinner2 = address.certificatePinner;
            Intrinsics.checkNotNull(certificatePinner2);
            final Handshake handshake2 = new Handshake(handshake.tlsVersion, handshake.cipherSuite, handshake.localCertificates, new Function0<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.ConnectPlan$connectTls$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Certificate> invoke() {
                    CertificateChainCleaner certificateChainCleaner = CertificatePinner.this.certificateChainCleaner;
                    Intrinsics.checkNotNull(certificateChainCleaner);
                    return certificateChainCleaner.clean(address.url.host, handshake.peerCertificates());
                }
            });
            this.handshake = handshake2;
            certificatePinner2.check$okhttp(address.url.host, new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.ConnectPlan$connectTls$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends X509Certificate> invoke() {
                    List<Certificate> peerCertificates2 = Handshake.this.peerCertificates();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(peerCertificates2, 10));
                    for (Certificate certificate2 : peerCertificates2) {
                        Intrinsics.checkNotNull(certificate2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                        arrayList.add((X509Certificate) certificate2);
                    }
                    return arrayList;
                }
            });
            if (connectionSpec.supportsTlsExtensions) {
                Platform platform2 = Platform.platform;
                str = Platform.platform.getSelectedProtocol(sSLSocket);
            } else {
                str = null;
            }
            this.socket = sSLSocket;
            this.source = Okio.buffer(Okio.source(sSLSocket));
            this.sink = Okio.buffer(Okio.sink(sSLSocket));
            if (str != null) {
                Protocol.Companion.getClass();
                protocol = Protocol.Companion.get(str);
            } else {
                protocol = Protocol.HTTP_1_1;
            }
            this.protocol = protocol;
            Platform platform3 = Platform.platform;
            Platform.platform.afterHandshake(sSLSocket);
        } catch (Throwable th) {
            Platform platform4 = Platform.platform;
            Platform.platform.afterHandshake(sSLSocket);
            _UtilJvmKt.closeQuietly(sSLSocket);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c A[Catch: all -> 0x0180, TryCatch #0 {all -> 0x0180, blocks: (B:63:0x0133, B:65:0x013c, B:72:0x0167, B:83:0x0141, B:86:0x0146, B:88:0x014a, B:91:0x0153, B:94:0x0158), top: B:62:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0171  */
    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.connection.RoutePlanner.ConnectResult connectTlsEtc() {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ConnectPlan.connectTlsEtc():okhttp3.internal.connection.RoutePlanner$ConnectResult");
    }

    public final RoutePlanner.ConnectResult connectTunnel$okhttp() throws IOException {
        Request request;
        Request request2 = this.tunnelRequest;
        Intrinsics.checkNotNull(request2);
        Route route = this.route;
        String str = "CONNECT " + _UtilJvmKt.toHostHeader(route.address.url, true) + " HTTP/1.1";
        while (true) {
            RealBufferedSource realBufferedSource = this.source;
            Intrinsics.checkNotNull(realBufferedSource);
            RealBufferedSink realBufferedSink = this.sink;
            Intrinsics.checkNotNull(realBufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, realBufferedSource, realBufferedSink);
            Timeout timeout = realBufferedSource.timeout();
            long j = this.client.readTimeoutMillis;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            timeout.timeout(j, timeUnit);
            realBufferedSink.timeout().timeout(r7.writeTimeoutMillis, timeUnit);
            http1ExchangeCodec.writeRequest(request2.headers, str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            readResponseHeaders.request = request2;
            Response build = readResponseHeaders.build();
            long headersContentLength = _UtilJvmKt.headersContentLength(build);
            if (headersContentLength != -1) {
                Http1ExchangeCodec.FixedLengthSource newFixedLengthSource = http1ExchangeCodec.newFixedLengthSource(headersContentLength);
                _UtilJvmKt.skipAll(newFixedLengthSource, Integer.MAX_VALUE, timeUnit);
                newFixedLengthSource.close();
            }
            int r4 = build.code;
            if (r4 != 200) {
                if (r4 == 407) {
                    Request authenticate = route.address.proxyAuthenticator.authenticate(route, build);
                    if (authenticate != null) {
                        if (StringsKt__StringsJVMKt.equals("close", Response.header$default(build, Headers.CONNECTION))) {
                            request = authenticate;
                            break;
                        }
                        request2 = authenticate;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    throw new IOException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unexpected response code for CONNECT: ", r4));
                }
            } else {
                request = null;
                break;
            }
        }
        if (request == null) {
            return new RoutePlanner.ConnectResult(this, null, null, 6);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        int r8 = this.attempt + 1;
        RealCall realCall = this.call;
        EventListener eventListener = this.eventListener;
        Proxy proxy = route.proxy;
        InetSocketAddress inetSocketAddress = route.socketAddress;
        if (r8 < 21) {
            eventListener.connectEnd(realCall, inetSocketAddress, proxy, null);
            return new RoutePlanner.ConnectResult(this, copy$default(this, r8, request, 0, false, 12), null, 4);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        eventListener.connectFailed(realCall, inetSocketAddress, proxy, protocolException);
        return new RoutePlanner.ConnectResult(this, null, protocolException, 2);
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final Route getRoute() {
        return this.route;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RealConnection handleSuccess() {
        RouteDatabase routeDatabase = this.call.client.routeDatabase;
        Route route = this.route;
        synchronized (routeDatabase) {
            Intrinsics.checkNotNullParameter(route, "route");
            routeDatabase._failedRoutes.remove(route);
        }
        ReusePlan planReusePooledConnection$okhttp = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp.connection;
        }
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        synchronized (realConnection) {
            RealConnectionPool realConnectionPool = this.client.connectionPool.delegate;
            realConnectionPool.getClass();
            okhttp3.Headers headers = _UtilJvmKt.EMPTY_HEADERS;
            realConnectionPool.connections.add(realConnection);
            realConnectionPool.cleanupQueue.schedule(realConnectionPool.cleanupTask, 0L);
            this.call.acquireConnectionNoEvents(realConnection);
            Unit unit = Unit.INSTANCE;
        }
        this.eventListener.connectionAcquired(this.call, realConnection);
        return realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final boolean isReady() {
        if (this.protocol != null) {
            return true;
        }
        return false;
    }

    public final ConnectPlan nextConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sSLSocket) {
        boolean z;
        boolean z2;
        String[] strArr;
        String[] strArr2;
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        int r0 = this.connectionSpecIndex;
        int size = connectionSpecs.size();
        for (int r6 = r0 + 1; r6 < size; r6++) {
            ConnectionSpec connectionSpec = connectionSpecs.get(r6);
            connectionSpec.getClass();
            if (!connectionSpec.isTls || (((strArr = connectionSpec.tlsVersionsAsString) != null && !_UtilCommonKt.hasIntersection(strArr, sSLSocket.getEnabledProtocols(), NaturalOrderComparator.INSTANCE)) || ((strArr2 = connectionSpec.cipherSuitesAsString) != null && !_UtilCommonKt.hasIntersection(strArr2, sSLSocket.getEnabledCipherSuites(), CipherSuite.ORDER_BY_NAME)))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (r0 != -1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                return copy$default(this, 0, null, r6, z2, 3);
            }
        }
        return null;
    }

    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sSLSocket) throws IOException {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan nextConnectionSpec$okhttp = nextConnectionSpec$okhttp(connectionSpecs, sSLSocket);
        if (nextConnectionSpec$okhttp != null) {
            return nextConnectionSpec$okhttp;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isTlsFallback);
        sb.append(", modes=");
        sb.append(connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.Plan retry() {
        return new ConnectPlan(this.client, this.call, this.routePlanner, this.route, this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final void trackFailure(RealCall call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final void noNewExchanges() {
    }
}
