package aws.smithy.kotlin.runtime.net;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.net.Host;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: Url.kt */
/* loaded from: classes.dex */
public final class Url {
    public final boolean encodeParameters;
    public final boolean forceQuery;
    public final String fragment;
    public final Host host;
    public final QueryParameters parameters;
    public final String path;
    public final int port;
    public final Scheme scheme;
    public final UserInfo userInfo;

    public Url(Scheme scheme, Host host, int r6, String path, QueryParameters parameters, String str, UserInfo userInfo, boolean z, int r12) {
        boolean z2;
        r6 = (r12 & 4) != 0 ? scheme.defaultPort : r6;
        path = (r12 & 8) != 0 ? "" : path;
        if ((r12 & 16) != 0) {
            QueryParameters.Companion.getClass();
            parameters = EmptyQueryParameters.INSTANCE;
        }
        str = (r12 & 32) != 0 ? null : str;
        userInfo = (r12 & 64) != 0 ? null : userInfo;
        boolean z3 = false;
        z = (r12 & 128) != 0 ? false : z;
        if ((r12 & 256) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.scheme = scheme;
        this.host = host;
        this.port = r6;
        this.path = path;
        this.parameters = parameters;
        this.fragment = str;
        this.userInfo = userInfo;
        this.forceQuery = z;
        this.encodeParameters = z2;
        if (1 <= r6 && r6 < 65536) {
            z3 = true;
        }
        if (z3) {
        } else {
            throw new IllegalArgumentException("port must be in range [1, 65535]".toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Url)) {
            return false;
        }
        Url url = (Url) obj;
        if (Intrinsics.areEqual(this.scheme, url.scheme) && Intrinsics.areEqual(this.host, url.host) && this.port == url.port && Intrinsics.areEqual(this.path, url.path) && Intrinsics.areEqual(this.parameters, url.parameters) && Intrinsics.areEqual(this.fragment, url.fragment) && Intrinsics.areEqual(this.userInfo, url.userInfo) && this.forceQuery == url.forceQuery && this.encodeParameters == url.encodeParameters) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.parameters.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.path, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.port, (this.host.hashCode() + (this.scheme.hashCode() * 31)) * 31, 31), 31)) * 31;
        int r0 = 0;
        String str = this.fragment;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r1 = (hashCode2 + hashCode) * 31;
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            r0 = userInfo.hashCode();
        }
        int r12 = (r1 + r0) * 31;
        int r02 = 1;
        boolean z = this.forceQuery;
        int r2 = z;
        if (z != 0) {
            r2 = 1;
        }
        int r13 = (r12 + r2) * 31;
        boolean z2 = this.encodeParameters;
        if (!z2) {
            r02 = z2 ? 1 : 0;
        }
        return r13 + r02;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        Scheme scheme = this.scheme;
        sb.append(scheme.protocolName);
        sb.append("://");
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            String str2 = userInfo.username;
            if (!StringsKt__StringsJVMKt.isBlank(str2)) {
                sb.append(aws.smithy.kotlin.runtime.util.text.TextKt.urlEncodeComponent$default(str2));
                String str3 = userInfo.password;
                if (!StringsKt__StringsJVMKt.isBlank(str3)) {
                    sb.append(":".concat(aws.smithy.kotlin.runtime.util.text.TextKt.urlEncodeComponent$default(str3)));
                }
                sb.append("@");
            }
        }
        Host host = this.host;
        Intrinsics.checkNotNullParameter(host, "<this>");
        if (host instanceof Host.IpAddress) {
            IpAddr ipAddr = ((Host.IpAddress) host).address;
            if (ipAddr instanceof IpV6Addr) {
                IpV6Addr ipV6Addr = (IpV6Addr) ipAddr;
                if (ipV6Addr.zoneId == null) {
                    str = "[" + ipAddr + ']';
                } else {
                    byte[] octets = ipV6Addr.octets;
                    Intrinsics.checkNotNullParameter(octets, "octets");
                    str = "[" + new IpV6Addr(octets, null) + "%25" + aws.smithy.kotlin.runtime.util.text.TextKt.urlEncodeComponent$default(ipV6Addr.zoneId) + ']';
                }
            } else {
                str = ipAddr.toString();
            }
        } else if (host instanceof Host.Domain) {
            str = ((Host.Domain) host).name;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        sb.append(str);
        int r1 = scheme.defaultPort;
        int r3 = this.port;
        if (r3 != r1) {
            sb.append(":" + r3);
        }
        sb.append(UrlKt.encodePath(this.path, this.parameters.entries(), this.fragment, this.forceQuery, this.encodeParameters));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
