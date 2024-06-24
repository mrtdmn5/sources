package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner;

/* compiled from: Android10Platform.kt */
/* loaded from: classes4.dex */
public final class Android10Platform extends Platform {
    public static final boolean isSupported;
    public final ArrayList socketAdapters;

    static {
        boolean z;
        if (Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29) {
            z = true;
        } else {
            z = false;
        }
        isSupported = z;
    }

    public Android10Platform() {
        boolean z;
        Android10SocketAdapter android10SocketAdapter;
        SocketAdapter[] socketAdapterArr = new SocketAdapter[4];
        if (Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            android10SocketAdapter = new Android10SocketAdapter();
        } else {
            android10SocketAdapter = null;
        }
        socketAdapterArr[0] = android10SocketAdapter;
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
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> protocols) {
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
    public final Object getStackTraceForCloseable() {
        if (Build.VERSION.SDK_INT >= 30) {
            CloseGuard m = Android10Platform$$ExternalSyntheticApiModelOutline3.m();
            m.open("response.body().close()");
            return m;
        }
        return super.getStackTraceForCloseable();
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressLint({"NewApi"})
    public final boolean isCleartextTrafficPermitted(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // okhttp3.internal.platform.Platform
    public final void logCloseableLeak(Object obj, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Build.VERSION.SDK_INT >= 30) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.util.CloseGuard");
            Android10Platform$$ExternalSyntheticApiModelOutline1.m(obj).warnIfOpen();
        } else {
            super.logCloseableLeak(obj, message);
        }
    }
}
