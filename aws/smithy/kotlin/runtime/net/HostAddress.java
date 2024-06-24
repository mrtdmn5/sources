package aws.smithy.kotlin.runtime.net;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostResolver.kt */
/* loaded from: classes.dex */
public final class HostAddress {
    public final IpAddr address;
    public final String hostname;

    public HostAddress(String str, IpAddr ipAddr) {
        this.hostname = str;
        this.address = ipAddr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAddress)) {
            return false;
        }
        HostAddress hostAddress = (HostAddress) obj;
        if (Intrinsics.areEqual(this.hostname, hostAddress.hostname) && Intrinsics.areEqual(this.address, hostAddress.address)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.address.hashCode() + (this.hostname.hashCode() * 31);
    }

    public final String toString() {
        return "HostAddress(hostname=" + this.hostname + ", address=" + this.address + ')';
    }
}
