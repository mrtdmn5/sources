package okhttp3;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._HostnamesJvmKt;

/* compiled from: Route.kt */
/* loaded from: classes4.dex */
public final class Route {
    public final Address address;
    public final Proxy proxy;
    public final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (Intrinsics.areEqual(route.address, this.address) && Intrinsics.areEqual(route.proxy, this.proxy) && Intrinsics.areEqual(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        String str;
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        Address address = this.address;
        String str2 = address.url.host;
        InetSocketAddress inetSocketAddress = this.socketAddress;
        InetAddress address2 = inetSocketAddress.getAddress();
        if (address2 != null && (hostAddress = address2.getHostAddress()) != null) {
            str = _HostnamesJvmKt.toCanonicalHost(hostAddress);
        } else {
            str = null;
        }
        if (StringsKt__StringsKt.contains$default(str2, ':')) {
            sb.append("[");
            sb.append(str2);
            sb.append("]");
        } else {
            sb.append(str2);
        }
        HttpUrl httpUrl = address.url;
        if (httpUrl.port != inetSocketAddress.getPort() || Intrinsics.areEqual(str2, str)) {
            sb.append(":");
            sb.append(httpUrl.port);
        }
        if (!Intrinsics.areEqual(str2, str)) {
            if (Intrinsics.areEqual(this.proxy, Proxy.NO_PROXY)) {
                sb.append(" at ");
            } else {
                sb.append(" via proxy ");
            }
            if (str == null) {
                sb.append("<unresolved>");
            } else if (StringsKt__StringsKt.contains$default(str, ':')) {
                sb.append("[");
                sb.append(str);
                sb.append("]");
            } else {
                sb.append(str);
            }
            sb.append(":");
            sb.append(inetSocketAddress.getPort());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
