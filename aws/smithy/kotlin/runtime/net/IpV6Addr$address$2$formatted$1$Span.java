package aws.smithy.kotlin.runtime.net;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: IpV6Addr.kt */
/* loaded from: classes.dex */
public final class IpV6Addr$address$2$formatted$1$Span {
    public int start = 0;
    public int len = 0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IpV6Addr$address$2$formatted$1$Span)) {
            return false;
        }
        IpV6Addr$address$2$formatted$1$Span ipV6Addr$address$2$formatted$1$Span = (IpV6Addr$address$2$formatted$1$Span) obj;
        if (this.start == ipV6Addr$address$2$formatted$1$Span.start && this.len == ipV6Addr$address$2$formatted$1$Span.len) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.len) + (Integer.hashCode(this.start) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Span(start=");
        sb.append(this.start);
        sb.append(", len=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.len, ')');
    }
}
