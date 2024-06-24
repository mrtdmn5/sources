package okhttp3;

import com.amazonaws.services.s3.internal.Constants;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/* compiled from: OkHttpClient.kt */
/* loaded from: classes4.dex */
public final class OkHttpClient implements Call.Factory {
    public final Authenticator authenticator;
    public final CertificateChainCleaner certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeoutMillis;
    public final ConnectionPool connectionPool;
    public final List<ConnectionSpec> connectionSpecs;
    public final CookieJar cookieJar;
    public final Dispatcher dispatcher;
    public final Dns dns;
    public final EventListener.Factory eventListenerFactory;
    public final boolean fastFallback;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List<Interceptor> interceptors;
    public final List<Interceptor> networkInterceptors;
    public final List<Protocol> protocols;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final RouteDatabase routeDatabase;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactoryOrNull;
    public final TaskRunner taskRunner;
    public final int writeTimeoutMillis;
    public final X509TrustManager x509TrustManager;
    public static final List<Protocol> DEFAULT_PROTOCOLS = _UtilJvmKt.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = _UtilJvmKt.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    /* compiled from: OkHttpClient.kt */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final Authenticator$Companion$AuthenticatorNone authenticator;
        public final CertificatePinner certificatePinner;
        public int connectTimeout;
        public final List<ConnectionSpec> connectionSpecs;
        public final CookieJar$Companion$NoCookies cookieJar;
        public Dns dns;
        public EventListener.Factory eventListenerFactory;
        public final boolean fastFallback;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public final OkHostnameVerifier hostnameVerifier;
        public List<? extends Protocol> protocols;
        public Authenticator proxyAuthenticator;
        public ProxySelector proxySelector;
        public int readTimeout;
        public boolean retryOnConnectionFailure;
        public final SocketFactory socketFactory;
        public int writeTimeout;
        public Dispatcher dispatcher = new Dispatcher();
        public ConnectionPool connectionPool = new ConnectionPool(5, TimeUnit.MINUTES);
        public final ArrayList interceptors = new ArrayList();
        public final ArrayList networkInterceptors = new ArrayList();

        public Builder() {
            EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = EventListener.NONE;
            Intrinsics.checkNotNullParameter(eventListener$Companion$NONE$1, "<this>");
            this.eventListenerFactory = new _UtilJvmKt$$ExternalSyntheticLambda1(eventListener$Companion$NONE$1);
            this.retryOnConnectionFailure = true;
            this.fastFallback = true;
            Authenticator$Companion$AuthenticatorNone authenticator$Companion$AuthenticatorNone = Authenticator.NONE;
            this.authenticator = authenticator$Companion$AuthenticatorNone;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator$Companion$AuthenticatorNone;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = Constants.MAXIMUM_UPLOAD_PARTS;
            this.readTimeout = Constants.MAXIMUM_UPLOAD_PARTS;
            this.writeTimeout = Constants.MAXIMUM_UPLOAD_PARTS;
        }
    }

    public OkHttpClient(Builder builder) {
        boolean z;
        boolean z2;
        this.dispatcher = builder.dispatcher;
        this.connectionPool = builder.connectionPool;
        this.interceptors = _UtilJvmKt.toImmutableList(builder.interceptors);
        this.networkInterceptors = _UtilJvmKt.toImmutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.fastFallback = builder.fastFallback;
        this.authenticator = builder.authenticator;
        this.followRedirects = builder.followRedirects;
        this.followSslRedirects = builder.followSslRedirects;
        this.cookieJar = builder.cookieJar;
        this.dns = builder.dns;
        ProxySelector proxySelector = builder.proxySelector;
        proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        this.proxySelector = proxySelector == null ? NullProxySelector.INSTANCE : proxySelector;
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.socketFactory = builder.socketFactory;
        List<ConnectionSpec> list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.protocols = builder.protocols;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.connectTimeoutMillis = builder.connectTimeout;
        this.readTimeoutMillis = builder.readTimeout;
        this.writeTimeoutMillis = builder.writeTimeout;
        this.routeDatabase = new RouteDatabase();
        this.taskRunner = TaskRunner.INSTANCE;
        List<ConnectionSpec> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).isTls) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else {
            Platform platform = Platform.platform;
            X509TrustManager platformTrustManager = Platform.platform.platformTrustManager();
            this.x509TrustManager = platformTrustManager;
            Platform platform2 = Platform.platform;
            Intrinsics.checkNotNull(platformTrustManager);
            this.sslSocketFactoryOrNull = platform2.newSslSocketFactory(platformTrustManager);
            CertificateChainCleaner buildCertificateChainCleaner = Platform.platform.buildCertificateChainCleaner(platformTrustManager);
            this.certificateChainCleaner = buildCertificateChainCleaner;
            CertificatePinner certificatePinner = builder.certificatePinner;
            Intrinsics.checkNotNull(buildCertificateChainCleaner);
            this.certificatePinner = Intrinsics.areEqual(certificatePinner.certificateChainCleaner, buildCertificateChainCleaner) ? certificatePinner : new CertificatePinner(certificatePinner.pins, buildCertificateChainCleaner);
        }
        List<Interceptor> list3 = this.interceptors;
        Intrinsics.checkNotNull(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (!list3.contains(null)) {
            List<Interceptor> list4 = this.networkInterceptors;
            Intrinsics.checkNotNull(list4, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
            if (!list4.contains(null)) {
                List<ConnectionSpec> list5 = this.connectionSpecs;
                if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                    Iterator<T> it2 = list5.iterator();
                    while (it2.hasNext()) {
                        if (((ConnectionSpec) it2.next()).isTls) {
                            z2 = false;
                            break;
                        }
                    }
                }
                z2 = true;
                X509TrustManager x509TrustManager = this.x509TrustManager;
                CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
                SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
                if (!z2) {
                    if (sSLSocketFactory == null) {
                        throw new IllegalStateException("sslSocketFactory == null".toString());
                    }
                    if (certificateChainCleaner == null) {
                        throw new IllegalStateException("certificateChainCleaner == null".toString());
                    }
                    if (x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null".toString());
                    }
                    return;
                }
                if (!(sSLSocketFactory == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!(certificateChainCleaner == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (x509TrustManager == null) {
                    if (!Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException(("Null network interceptor: " + list4).toString());
        }
        throw new IllegalStateException(("Null interceptor: " + list3).toString());
    }

    @Override // okhttp3.Call.Factory
    public final RealCall newCall(Request request) {
        return new RealCall(this, request, false);
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
