package okhttp3.internal.platform;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* compiled from: AndroidPlatform.kt */
/* loaded from: classes4.dex */
public final class AndroidPlatform extends Platform {
    public static final boolean isSupported;
    public final ArrayList socketAdapters;

    /* compiled from: AndroidPlatform.kt */
    /* loaded from: classes4.dex */
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        public final Method findByIssuerAndSignatureMethod;
        public final X509TrustManager trustManager;

        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            if (Intrinsics.areEqual(this.trustManager, customTrustRootIndex.trustManager) && Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, customTrustRootIndex.findByIssuerAndSignatureMethod)) {
                return true;
            }
            return false;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public final X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                Object invoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) invoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public final int hashCode() {
            return this.findByIssuerAndSignatureMethod.hashCode() + (this.trustManager.hashCode() * 31);
        }

        public final String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }
    }

    static {
        boolean z;
        if (!Platform.Companion.isAndroid() || Build.VERSION.SDK_INT >= 30) {
            z = false;
        } else {
            z = true;
        }
        isSupported = z;
    }

    public AndroidPlatform() {
        StandardAndroidSocketAdapter standardAndroidSocketAdapter;
        SocketAdapter[] socketAdapterArr = new SocketAdapter[4];
        try {
            standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl")), Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl")), Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl")));
        } catch (Exception e) {
            Platform.platform.getClass();
            Platform.log(5, "unable to load android socket classes", e);
            standardAndroidSocketAdapter = null;
        }
        socketAdapterArr[0] = standardAndroidSocketAdapter;
        socketAdapterArr[1] = new DeferredSocketAdapter(AndroidSocketAdapter.playProviderFactory);
        socketAdapterArr[2] = new DeferredSocketAdapter(ConscryptSocketAdapter.factory);
        socketAdapterArr[3] = new DeferredSocketAdapter(BouncyCastleSocketAdapter.factory);
        ArrayList filterNotNull = ArraysKt___ArraysKt.filterNotNull(socketAdapterArr);
        ArrayList arrayList = new ArrayList();
        Iterator it = filterNotNull.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((SocketAdapter) next).isSupported()) {
                arrayList.add(next);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // okhttp3.internal.platform.Platform
    public final CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        AndroidCertificateChainCleaner androidCertificateChainCleaner = null;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions != null) {
            androidCertificateChainCleaner = new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions);
        }
        if (androidCertificateChainCleaner == null) {
            return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
        }
        return androidCertificateChainCleaner;
    }

    @Override // okhttp3.internal.platform.Platform
    public final TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> protocols) {
        Object obj;
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator it = this.socketAdapters.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SocketAdapter) obj).matchesSocket(sSLSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sSLSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void connectSocket(Socket socket, InetSocketAddress address, int r4) throws IOException {
        Intrinsics.checkNotNullParameter(address, "address");
        try {
            socket.connect(address, r4);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e);
            }
            throw e;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        Object obj;
        Iterator it = this.socketAdapters.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SocketAdapter) obj).matchesSocket(sSLSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter == null) {
            return null;
        }
        return socketAdapter.getSelectedProtocol(sSLSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    public final boolean isCleartextTrafficPermitted(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }
}
