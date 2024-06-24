package aws.smithy.kotlin.runtime.http.engine;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnvironmentProxySelector.kt */
/* loaded from: classes.dex */
public final class NoProxyHost {
    public final String hostMatch;
    public final Integer port;

    public NoProxyHost(String hostMatch, Integer num) {
        Intrinsics.checkNotNullParameter(hostMatch, "hostMatch");
        this.hostMatch = hostMatch;
        this.port = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoProxyHost)) {
            return false;
        }
        NoProxyHost noProxyHost = (NoProxyHost) obj;
        if (Intrinsics.areEqual(this.hostMatch, noProxyHost.hostMatch) && Intrinsics.areEqual(this.port, noProxyHost.port)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.hostMatch.hashCode() * 31;
        Integer num = this.port;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NoProxyHost(hostMatch=");
        sb.append(this.hostMatch);
        sb.append(", port=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.port, ')');
    }
}
