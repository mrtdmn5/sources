package okhttp3;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.HttpUrl;
import okhttp3.internal._HostnamesJvmKt;
import okhttp3.internal._UtilJvmKt;

/* compiled from: Address.kt */
/* loaded from: classes4.dex */
public final class Address {
    public final CertificatePinner certificatePinner;
    public final List<ConnectionSpec> connectionSpecs;
    public final Dns dns;
    public final HostnameVerifier hostnameVerifier;
    public final List<Protocol> protocols;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final HttpUrl url;

    public Address(String uriHost, int r3, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator proxyAuthenticator, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(uriHost, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = null;
        this.proxySelector = proxySelector;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String str = sSLSocketFactory != null ? "https" : "http";
        if (StringsKt__StringsJVMKt.equals(str, "http")) {
            builder.scheme = "http";
        } else {
            if (!StringsKt__StringsJVMKt.equals(str, "https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            builder.scheme = "https";
        }
        boolean z = false;
        String canonicalHost = _HostnamesJvmKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(uriHost, 0, 0, false, 7));
        if (canonicalHost != null) {
            builder.host = canonicalHost;
            if (1 <= r3 && r3 < 65536) {
                z = true;
            }
            if (z) {
                builder.port = r3;
                this.url = builder.build();
                this.protocols = _UtilJvmKt.toImmutableList(protocols);
                this.connectionSpecs = _UtilJvmKt.toImmutableList(connectionSpecs);
                return;
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("unexpected port: ", r3).toString());
        }
        throw new IllegalArgumentException("unexpected host: ".concat(uriHost));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (Intrinsics.areEqual(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address that) {
        Intrinsics.checkNotNullParameter(that, "that");
        if (Intrinsics.areEqual(this.dns, that.dns) && Intrinsics.areEqual(this.proxyAuthenticator, that.proxyAuthenticator) && Intrinsics.areEqual(this.protocols, that.protocols) && Intrinsics.areEqual(this.connectionSpecs, that.connectionSpecs) && Intrinsics.areEqual(this.proxySelector, that.proxySelector) && Intrinsics.areEqual(this.proxy, that.proxy) && Intrinsics.areEqual(this.sslSocketFactory, that.sslSocketFactory) && Intrinsics.areEqual(this.hostnameVerifier, that.hostnameVerifier) && Intrinsics.areEqual(this.certificatePinner, that.certificatePinner) && this.url.port == that.url.port) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((Objects.hashCode(this.proxy) + ((this.proxySelector.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.connectionSpecs, VectorGroup$$ExternalSyntheticOutline0.m(this.protocols, (this.proxyAuthenticator.hashCode() + ((this.dns.hashCode() + ((this.url.hashCode() + 527) * 31)) * 31)) * 31, 31), 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Address{");
        HttpUrl httpUrl = this.url;
        sb.append(httpUrl.host);
        sb.append(':');
        sb.append(httpUrl.port);
        sb.append(", ");
        Proxy proxy = this.proxy;
        if (proxy != null) {
            str = "proxy=" + proxy;
        } else {
            str = "proxySelector=" + this.proxySelector;
        }
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, str, '}');
    }
}
