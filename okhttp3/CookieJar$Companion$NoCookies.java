package okhttp3;

import aws.smithy.kotlin.runtime.net.HostAddress;
import aws.smithy.kotlin.runtime.net.IpAddr;
import aws.smithy.kotlin.runtime.net.IpV4Addr;
import aws.smithy.kotlin.runtime.net.IpV6Addr;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CookieJar.kt */
/* loaded from: classes4.dex */
public final class CookieJar$Companion$NoCookies implements CookieJar {
    public static final HostAddress toHostAddress(InetAddress inetAddress) {
        IpAddr ipV6Addr;
        if (inetAddress instanceof Inet4Address) {
            byte[] address = ((Inet4Address) inetAddress).getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "address");
            ipV6Addr = new IpV4Addr(address);
        } else if (inetAddress instanceof Inet6Address) {
            byte[] address2 = ((Inet6Address) inetAddress).getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "address");
            ipV6Addr = new IpV6Addr(address2, null);
        } else {
            throw new IllegalStateException(("unrecognized InetAddress " + inetAddress).toString());
        }
        String hostName = inetAddress.getHostName();
        Intrinsics.checkNotNullExpressionValue(hostName, "hostName");
        return new HostAddress(hostName, ipV6Addr);
    }

    @Override // okhttp3.CookieJar
    public void loadForRequest(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl url, List list) {
        Intrinsics.checkNotNullParameter(url, "url");
    }
}
